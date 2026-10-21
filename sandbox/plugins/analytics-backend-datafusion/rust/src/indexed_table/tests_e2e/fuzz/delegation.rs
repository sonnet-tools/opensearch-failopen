use std::collections::HashMap;
        Operator::LtEq => ord != Ordering::Greater,
        }
use super::corpus::{CellValue, Corpus};
                .position(|(a, b)| a != b)
    let factory = Arc::new(MockDelegatedBackendCollectorFactory { match_sets })
                CollectorCallStrategy::FullRange,
        }
    use std::cmp::Ordering;
            let v = match strategy {
                Arc::clone(&provider_locks),
    #[allow(dead_code)]
/// Compute the expected result by intersecting:
        .expect("delegation fuzz: original_expr must be BinaryExpr");
        None => return false,
        ($x:expr) => {
    Passthrough,
                })
        Operator::Gt,
            Some((*bail_unknown!(c) as i32).cmp(&(*bail_unknown!(l) as i32)))
use datafusion::physical_expr::PhysicalExpr;
pub(in crate::indexed_table::tests_e2e) fn generate_delegation_tree(
                }
use super::harness::LoadedSegment;
    match op {
    num_delegation: usize,
                70..=84 => rng.gen_range(i32::MIN..0),
            if c.is_nan() || l.is_nan() {
        }
use rand::SeedableRng;
pub(in crate::indexed_table::tests_e2e) struct DelegationTree {
///    `ProviderHandle::new_for_test(annotation_id)` — `provider_key == annotation_id`.
        store_url,
        predicate_columns: pred_cols,
//!
            };
/// Mock delegated-backend factory: looks up a per-`provider_key` match-set built
        _context_id: i64,
        Operator::LtEq,
    match dt {
        Operator::Lt => ord == Ordering::Less,
        Ok(out.into())
};
        (CellValue::TimestampNanos(c), ScalarValue::TimestampNanosecond(l, _)) => {
            let eval: Arc<dyn RowGroupBitsetSource> = Arc::new(SingleCollectorEvaluator::new(
            };
        provider_locks.insert(*annotation_id, lock);
    for (_, e) in iter {
/// matching `oracle::compare_cell_lit`'s top-level "row matches iff Tri::True" rule).
        Operator::Eq,
    use datafusion::arrow::datatypes::DataType;
    doc_ids.sort_unstable();
    }
    let bin = expr
        }
                    match c {
    let ctx = SessionContext::new();
    let task_ctx = ctx.task_ctx();
            Some(bail_unknown!(c).cmp(bail_unknown!(l)))
    macro_rules! bail_unknown {
    while let Some(batch) = stream.next().await {
    let store_url = datafusion::execution::object_store::ObjectStoreUrl::local_filesystem();
    original_exprs: &[(i32, Arc<dyn PhysicalExpr>)],
use futures::StreamExt;
    //
/// `provider_key == annotation_id` in this test (we control both ends).
        _writer_generation: i64,
                        _ => (b'A' + (c as u8 - 36)) as char,
    let ord: Option<Ordering> = match (cell, lit) {
) -> DelegationTree {
        (CellValue::Date32(c), ScalarValue::Date32(l)) => {
}
fn and_all(original_exprs: &[(i32, Arc<dyn PhysicalExpr>)]) -> Arc<dyn PhysicalExpr> {
            ScalarValue::Int64(Some(v))
    out
        Arc::new(object_store::local::LocalFileSystem::new());
 */
        (CellValue::Boolean(c), ScalarValue::Boolean(l)) => {
    }));
                70..=84 => rng.gen_range(0..1_704_067_200_000_000_000_i64),
    }
use crate::indexed_table::eval::RowGroupBitsetSource;
                HashMap::new(),
        store,
 *
                    let c: u32 = rng.gen_range(0..62);
        let mut out = vec![0u64; span.div_ceil(64)];
    let expected = expected_doc_ids(corpus, dt);
                &schema,
            )
    // arithmetic were wrong we'd silently corrupt results on any segment after the first.
        }
    let provider = Arc::new(IndexedTableProvider::new(IndexedTableConfig {
struct MockDelegatedBackendCollectorFactory {
            match behavior {
impl DelegatedBackendCollectorFactory for MockDelegatedBackendCollectorFactory {
        sort_orders: vec![],
        original_exprs,
    for i in 0..num_delegation {
/// produce the canonical (correctness ∩ predicates) result.
    acc.into_iter().collect()
            Some(bail_unknown!(c).cmp(bail_unknown!(l)))
            }
        .expect("delegation fuzz: BinaryExpr lhs must be Column");
    let qc = crate::datafusion_query_config::DatafusionQueryConfig::builder()
    ) -> Result<Arc<dyn RowGroupDocsCollector>, String> {
        let residual_physical = Arc::clone(&residual_physical);
    let plan = df.create_physical_plan().await.unwrap();
        })?;
    let mut doc_ids: Vec<i32> = Vec::new();
    // Build N DelegationPossible leaves wrapping random binary predicates.
                None => return false,
            match $x {
    let ops = [
            }
//!   correctness; result must match the oracle.
    let actual = execute_delegation_tree(corpus, loaded, dt, behavior).await;
            format!(
        }
            };
        lock.set(ProviderHandle::new_for_test(*annotation_id))
use rand::rngs::StdRng;
    CollectorCallStrategy, DelegatedBackendCollectorFactory, SingleCollectorEvaluator,
        .downcast_ref::<Literal>()
    /// `[(annotation_id, original_expr)]` for every DelegationPossible leaf in DFS order.
        Operator::Gt => ord == Ordering::Greater,
/// Build per-(annotation_id) match-sets for the mock delegated backend.
                .collect();
        Arc::new(move |segment, _chunk, stream_metrics, _stats_prune_tree| {
    }
            ));
            actual.len(),
        as Arc<dyn DelegatedBackendCollectorFactory>;
#[derive(Debug)]
    loaded: &LoadedSegment,
    let mut matches: Vec<i32> = (0..corpus.num_rows() as i32).collect();
    behavior: DelegatedBackendBehavior,
}
                70..=84 => rng.gen_range(0..18_262),
    /// `original_exprs` and `collector_match_set` directly.
            ScalarValue::Float64(Some(v))
        let provider_locks = Arc::clone(&provider_locks);
        }
    }
use rand::Rng;
//! - **Sloppy delegated backend**: the mock returns a *superset* — TRUE rows plus
//!
}
            ScalarValue::Date32(Some(v))
///   correctness collector match-set ∩ {rows where every original_expr is TRUE}
                0..=69 => {
            }
    };
        });
            };
                    }
        }
    let residual_physical: Arc<dyn PhysicalExpr> = and_all(&dt.original_exprs);
/// 1. Pre-seed `performance_provider_locks` with `OnceLock`s that hold a
    pub original_exprs: Vec<(i32, Arc<dyn PhysicalExpr>)>,
    schema: &datafusion::arrow::datatypes::SchemaRef,
/// Generate a SingleCollector-shape tree with `num_delegation` delegation leaves.
        .col_idx
};
            let v = match strategy {
                stream_metrics.ffm_collector_calls.clone(),
            let extras = corpus.num_rows() / 3; // ~33%
        let arr = b
            let s: String = (0..rng.gen_range(1..=6))
                None,
                return false;
        DataType::Int32 => {
        provider_key: i32,
                0..=69 => rng.gen_range(0..1000),
                70..=84 => rng.gen_range(i64::MIN..0),
    }
/// corpus. Reuses the same 3VL semantics as the oracle for parity. Only handles
        acc = acc.intersection(&m).copied().collect();
 * compatible open source license.
use crate::indexed_table::bool_tree::BoolNode;
    Arc::new(BinaryExpr::new(col_expr, op, lit_expr))
                pruner,
    let df = ctx.sql("SELECT * FROM t").await.unwrap();
    let ord = match ord {
    corpus: &Corpus,
    let density = corpus.config.collector_density.clamp(0.0, 1.0);
        Some(o) => o,
/// match-sets per annotation_id without re-walking the tree.
            c.partial_cmp(l)
//!   narrowing hint.
    // and exercises the multi-segment offset math:
                _ => rng.gen_range(1_735_689_600_000_000_000_i64..i64::MAX),
}
/// `tree` is the full BoolNode; `original_exprs` lets the harness compute peer
/// 2. Build `MockDelegatedBackendCollectorFactory` from `match_sets`.
use crate::indexed_table::table_provider::{
use crate::indexed_table::ffm_callbacks::ProviderHandle;
        segments: loaded.segments.clone(),
                None,
        let cell = &corpus.cells[col_idx][row];
    // Honor the corpus's target_partitions so multi-segment fixtures fan out across
        .target_partitions(corpus.config.target_partitions.max(1))
        let idx = schema.index_of("__doc_id").expect("__doc_id in batch");
}
    for (annotation_id, _) in &dt.original_exprs {
#[derive(Clone, Copy)]
/// One iteration. `behavior` decides whether the delegated backend lies (sloppy)
                out[rel / 64] |= 1u64 << (rel % 64);
    if expected != actual {
        let schema = b.schema();
                70..=84 => rng.gen_range(-1e9..0.0),
            Some(bail_unknown!(c).cmp(bail_unknown!(l)))
                "MockDelegatedBackend: no match-set for provider_key={}",
            ));
use datafusion::common::ScalarValue;
            .as_any()
            for _ in 0..extras {
    use std::collections::BTreeSet;
                    rng.gen_range(1_704_067_200_000_000_000_i64..1_735_689_600_000_000_000_i64)
/// from `original_expr` evaluation (passthrough) or from TRUE-rows + extras (sloppy).
            },
                segment.writer_generation,
    };
        DataType::Date32 => {
) -> Result<(), String> {
    dt: &DelegationTree,
        };
    let mut rng = StdRng::seed_from_u64(corpus.config.seed.wrapping_add(0xD3EE));
        })
    // Segment 0 has rg.first_row==0; segments 1..N have first_row != 0. If the offset
        .batch_size(1024)
                .zip(actual.iter())
        other => panic!("delegation fuzz: unsupported operator {:?}", other),
        acc = Arc::new(BinaryExpr::new(acc, Operator::And, Arc::clone(e))) as Arc<dyn PhysicalExpr>;
            if let Some(col) = node.downcast_ref::<datafusion::physical_expr::expressions::Column>()
        DataType::Boolean => ScalarValue::Boolean(Some(rng.gen())),
        DataType::Utf8 => {
    dt: &DelegationTree,
                schema.clone(),
        let _ = residual_physical.apply(|node| {
        }
    fn create(
        collector_match_set: matches,
        }
    ];
        }
            expected
        pushdown_predicate: Some(Arc::clone(&residual_physical)),
                None,
    let mut acc: BTreeSet<i32> = dt.collector_match_set.iter().copied().collect();
//! - **Passthrough**: the mock delegated-backend collector returns *exactly* the
                Arc::clone(&segment.metadata),
    for row in 0..corpus.num_rows() {
    // partitions — `EvaluatorFactory` closure then runs once per (partition × segment)
                _ => rng.gen_range(100.0..1e9),
        original_exprs.push((annotation_id, original_expr));
    fn collect_packed_u64_bitset(
            Some(bail_unknown!(c).cmp(bail_unknown!(l)))
/// Mock collector whose match set is fixed at construction. Same shape as
            Ok(eval)
    behavior: DelegatedBackendBehavior,
/// emits — all `original_expr`s in delegation trees pass through that fn.
            Ok(datafusion::common::tree_node::TreeNodeRecursion::Continue)
    });
        out.insert(*annotation_id, rows);
    let mut out = Vec::new();
pub(in crate::indexed_table::tests_e2e) async fn run_delegation_iteration(
/// `harness::MockCollector` but private to this module so we don't widen visibility.
                rows.push(r);
                DelegatedBackendBehavior::Sloppy => "sloppy",
use datafusion::logical_expr::Operator;
/// Compute the doc-ids where `original_expr` evaluates TRUE, row-by-row over the
///   `AND(Collector{tag=0}, DelegationPossible{id=1, expr1}, ..., DelegationPossible{id=N, exprN})`.
        }
                let rel = (doc - min_doc) as usize;
        _doc_min: i32,
    out
                _ => rng.gen_range(1000..i32::MAX),
        (CellValue::Float64(c), ScalarValue::Float64(l)) => {
}
    }
    corpus: &Corpus,
//!
///    DataFusion's FilterExec re-applies it on decoded batches.
            let pruner = Arc::new(PagePruner::new(
        .get(col.name())
//! evaluator consults a delegated-backend (Lucene) collector and AND-intersects its
    }
    let match_sets = build_match_sets(corpus, &mut rng, &dt.original_exprs, behavior);
                        10..=35 => (b'a' + (c as u8 - 10)) as char,
/// - Passthrough: TRUE-rows of `original_expr`.
        }
//!   random extras. The extras are filtered out by `FilterExec`'s residual on
    DelegationTree {
        matching: dt.collector_match_set.clone(),
    let pred_cols: Vec<usize> = {
        let lock = Arc::new(OnceLock::new());
#[derive(Debug)]
        .downcast_ref::<BinaryExpr>()
    let target = ((corpus.num_rows() as f64) * density) as usize;
    matching: Vec<i32>,
}
        &self,
/// One generated delegation-shape tree:
    let col_expr: Arc<dyn PhysicalExpr> = Arc::new(Column::new(field.name(), col_idx));
                indices.insert(col.index());
use datafusion::arrow::array::Array;
    }
) -> Vec<i32> {
/*
        if compare_cell_lit_true(cell, *bin.op(), lit.value()) {
/// - Sloppy: TRUE-rows + ~30% additional random doc-ids (still in [0, num_rows)).
            };
fn compare_cell_lit_true(cell: &CellValue, op: Operator, lit: &ScalarValue) -> bool {
    let field = schema.field(col_idx);
    let op = *ops.choose(rng).unwrap();
struct StaticBitsetCollector {
        let b = batch.unwrap();
/// Returns true iff `cell op lit` is TRUE under SQL 3VL (UNKNOWN / NULL → false,
        if matches!(behavior, DelegatedBackendBehavior::Sloppy) {
    let mut out = HashMap::with_capacity(original_exprs.len());
    Ok(())
                .map(|i| i.to_string())
            rows.dedup();
//! Two test scenarios:
    }
            let l = bail_unknown!(l);
                0,
}
    use datafusion::arrow::datatypes::{DataType, TimeUnit};
    let lit_expr: Arc<dyn PhysicalExpr> = Arc::new(Literal::new(literal));
//!   delegated-backend bitset isn't trusted for correctness; it's a candidate
    for (annotation_id, expr) in original_exprs {
                let r = rng.gen_range(0..corpus.num_rows() as i32);
    assert!(!original_exprs.is_empty(), "and_all: empty exprs");
pub(in crate::indexed_table::tests_e2e) async fn execute_delegation_tree(
        max_doc: i32,
fn gen_binary_predicate_expr(
    }
///
        cancellation_token: None,
                0..=69 => rng.gen_range(0..10_000),
        datafusion::physical_plan::execute_stream(Arc::clone(&plan), task_ctx).unwrap();
    let col_idx = *corpus
        }
use std::sync::{Arc, OnceLock};
    let mut stream =
    let provider_locks = Arc::new(provider_locks);
            let c = bail_unknown!(c);
        ));
fn expected_doc_ids(corpus: &Corpus, dt: &DelegationTree) -> Vec<i32> {
            }
    EvaluatorFactory, IndexedTableConfig, IndexedTableProvider,
    //   peer_bm offset = (min_doc as i64 - rg.first_row) as u32
/// uses (private there, inlined here so we don't need to widen its visibility).
    // ── Residual: AND of all original_exprs. DataFusion's FilterExec re-applies
        query_config: Arc::new(qc),
        children.push(BoolNode::DelegationPossible {
    };
    matches.sort_unstable();
            ScalarValue::Utf8(Some(s))
        DataType::Int64 => {
    let mut acc = Arc::clone(&iter.next().unwrap().1);
        Operator::Lt,
    rng: &mut StdRng,
//!   rows where `original_expr` is TRUE. AND-intersection is a no-op for
        for &doc in &self.matching {
    /// FilterExec must filter those out.
use crate::indexed_table::page_pruner::PagePruner;
    corpus: &Corpus,
//! the residual `original_expr` is re-applied by DataFusion's `FilterExec` — so the
        tree: BoolNode::And(children),
            rows.sort_unstable();
                .unwrap_or_else(|| "len".to_string()),
    let eval_factory: EvaluatorFactory = {
    rng: &mut StdRng,
/// End-to-end execution of a delegation tree.
        Operator::NotEq => ord != Ordering::Equal,
use crate::indexed_table::eval::single_collector::{
    let mut provider_locks: HashMap<i32, Arc<OnceLock<ProviderHandle>>> = HashMap::new();
    // ── Mock delegated-backend factory + provider locks ──
        Ok(Arc::new(StaticBitsetCollector { matching }) as Arc<dyn RowGroupDocsCollector>)
) -> Arc<dyn PhysicalExpr> {
        let schema = loaded.schema.clone();
fn pick_literal_for(rng: &mut StdRng, dt: &datafusion::arrow::datatypes::DataType) -> ScalarValue {
        &self,
    children.push(BoolNode::Collector { annotation_id: 0 });
            ScalarValue::TimestampNanosecond(Some(v), None)
}
    }
            ScalarValue::Int32(Some(v))
    }
    // Pre-compute the always-call correctness collector's match-set.
            if doc >= min_doc && doc < max_doc {
        });
 * SPDX-License-Identifier: Apache-2.0
//! Fuzz coverage for performance-delegated leaves (`BoolNode::DelegationPossible`).
    for (_, expr) in &dt.original_exprs {
        let span = (max_doc - min_doc) as usize;
                Some(Arc::clone(&residual_physical)),
}
        .build();
        emit_row_ids: false,
            .downcast_ref::<datafusion::arrow::array::Int32Array>()
        .unwrap_or_else(|| panic!("column {:?} not in corpus", col.name()));
    corpus: &Corpus,
pub(in crate::indexed_table::tests_e2e) enum DelegatedBackendBehavior {
            expected.len(),
        evaluator_factory: eval_factory,
    behavior: DelegatedBackendBehavior,
        prune_tree_config: None,
/// or replays exactly (passthrough). Either way, the residual FilterExec must
impl RowGroupDocsCollector for StaticBitsetCollector {
/// The Collector tag is always 0; delegation annotation ids are 1..=num_delegation.
    //
    let lit = bin
        DataType::Timestamp(TimeUnit::Nanosecond, None) => {
    //    it on decoded rows — that's what enforces correctness regardless of how
            doc_ids.push(arr.value(i));
}
    /// Doc-id set the always-call correctness collector returns.
            annotation_id,
                .map(|_| {
            .expect("OnceLock set");
    doc_ids
    /// Kept for diagnostics / panic messages even though execution drives off
            }
        let mut indices = std::collections::BTreeSet::new();
 * this file be licensed under the Apache-2.0 license or a
                .iter()
/// 4. Stash the residual (AND of all `original_expr`s) as `pushdown_predicate` so
    let literal = pick_literal_for(rng, field.data_type());
        (CellValue::Utf8(c), ScalarValue::Utf8(l)) => {
use crate::indexed_table::index::RowGroupDocsCollector;
    /// `provider_key` → set of doc-ids the collector pretends to match.
            Some(bail_unknown!(c).as_str().cmp(bail_unknown!(l).as_str()))
) -> HashMap<i32, Vec<i32>> {
        }
    match_sets: HashMap<i32, Vec<i32>>,
        }
            assert!(arr.is_valid(i), "__doc_id is non-null");
    //    pushdown_predicate carries the residual, FilterExec is built by the planner.
        _doc_max: i32,
use datafusion::execution::context::SessionContext;
    }
}
        let matching = self.match_sets.get(&provider_key).cloned().ok_or_else(|| {
    };
        let original_expr = gen_binary_predicate_expr(rng, &corpus.schema);
        .right()
    acc
}
        schema: loaded.schema.clone(),
    pub collector_match_set: Vec<i32>,
    /// Collector returns exactly the rows where `original_expr` is TRUE.
        let correctness = Arc::clone(&correctness);
        (CellValue::Int32(c), ScalarValue::Int32(l)) => {
    rng: &mut StdRng,
                Some(v) => v,
        other => panic!("delegation fuzz: unsupported schema type {:?}", other),
            {
//!   `original_expr`. Final result still matches the oracle. This proves the
        Operator::Eq => ord == Ordering::Equal,
        Operator::NotEq,
    let mut iter = original_exprs.iter();
    loaded: &LoadedSegment,
        Operator::GtEq => ord != Ordering::Less,
        (CellValue::Int64(c), ScalarValue::Int64(l)) => {
        // provider_key == annotation_id by construction.
//! `DelegationPossible` leaves and DF page-pruning isn't selective enough, the
            let v = match strategy {
        let m: BTreeSet<i32> = rows_matching_predicate(corpus, expr).into_iter().collect();
        Operator::GtEq,
    let col = bin
    let correctness: Arc<dyn RowGroupDocsCollector> = Arc::new(StaticBitsetCollector {
}
                _ => rng.gen_range(10_000..i64::MAX),
    matches.truncate(target);
        use datafusion::common::tree_node::TreeNode;
    // ── Execute. Same shape as `run_single_collector_query`: SELECT * FROM t,
        .indexed_pushdown_filters(true)
            .column(idx)
/// Decides the bitset shape returned by the mock delegated-backend collector.
        let mut rows = rows_matching_predicate(corpus, expr);
        .downcast_ref::<Column>()
    ) -> Result<CollectDocsResult, String> {
/// Build a `Column op Literal` PhysicalExpr — same shape `tree_gen::gen_binary_predicate`
//! final result must equal `Predicate(original_expr)` evaluated row-by-row.
            .expect("__doc_id is Int32");
use rand::seq::SliceRandom;
            original_expr: Arc::clone(&original_expr),
        .left()
            out.push(row as i32);
                0..=69 => rng.gen_range(0.0..100.0),
        _ => panic!("delegation fuzz: cell/lit type mismatch"),
 * The OpenSearch Contributors require contributions made to
/// `BinaryExpr(Column op Literal)`, which is the only shape `gen_binary_predicate_expr`
    let mut original_exprs: Vec<(i32, Arc<dyn PhysicalExpr>)> = Vec::with_capacity(num_delegation);
                Some(Arc::clone(&correctness)),
                Arc::clone(&factory),
fn build_match_sets(
    let store: Arc<dyn object_store::ObjectStore> =
use datafusion::physical_expr::expressions::{BinaryExpr, Column, Literal};
    let mut children: Vec<BoolNode> = Vec::with_capacity(num_delegation + 1);
        DataType::Float64 => {
    // ── Always-call correctness collector ──
        min_doc: i32,
        }
                None,
        for i in 0..arr.len() {
                DelegatedBackendBehavior::Passthrough => "passthrough",
        sort_fields: vec![],
                0..=69 => rng.gen_range(18_262..20_454),
    matches.shuffle(rng);
}
        return Err(format!(
    ctx.register_table("t", provider).unwrap();
/// 3. Wire those into `SingleCollectorEvaluator` via the new factory parameter.
    let col_idx = rng.gen_range(1..schema.fields().len());
}
    pub tree: BoolNode,
    //    the delegated backend responded.
    let strategy = rng.gen_range(0..100u32);
        .expect("delegation fuzz: BinaryExpr rhs must be Literal");
            "delegation mismatch (behavior={:?}):\n  expected.len={} actual.len={}\n  first_mismatch_at_idx={}\n",
//! Production behavior under test: when a SingleCollector tree has
            let v = match strategy {
//! bitset into the candidate set. Regardless of how the delegated backend responds,
        let annotation_id = (i + 1) as i32;
        indices.into_iter().collect()
                provider_key
fn rows_matching_predicate(corpus: &Corpus, expr: &Arc<dyn PhysicalExpr>) -> Vec<i32> {
    }
            let v: i64 = match strategy {
use crate::indexed_table::index::CollectDocsResult;
                        0..=9 => (b'0' + c as u8) as char,
    /// Collector returns the TRUE rows plus a random ~30% extra rows. Residual
                _ => rng.gen_range(20_454..i32::MAX),
    Sloppy,
/// Build `expr0 AND expr1 AND ... AND exprN` as a single PhysicalExpr.
        let factory = Arc::clone(&factory);
