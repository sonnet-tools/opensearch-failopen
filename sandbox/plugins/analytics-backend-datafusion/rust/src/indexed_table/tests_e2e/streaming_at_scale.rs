        predicate_columns: vec![],
        evaluator_factory: factory,
    let want_status: Option<&'static str> = match tag {
        2 => Some("google"),
    assert_large_multipartition(
            LLeaf::LStatus(s) => BoolNode::Collector {
        5,
        ]),
/// matching each leaf's tag byte to a fixture-specific mock collector.
            out.push((
        .sql("SELECT brand, price, status, category, qty FROM t")
// AND where one branch is a NULL-prone predicate: amazon AND qty >= 50.
    categories: Vec<&'static str>,
// returns None) while still correctly emitting rows from RGs that do match.
                    Some(true) => {}
        "multipartition_pred_only",
    ])))
//   OR : acc is already all-true  for the batch (any further OR  stays true).
// ══════════════════════════════════════════════════════════════════════
}
        BoolNode::Predicate(_) => {}
    LQtyGe(i32),
                    Some(qty.value(i))
    large_deep_predicate_only,
);
        path,
            None
            LLeaf::LQtyGe(v) => pred_large_int("qty", Operator::GtEq, *v),
    let schema = Arc::new(Schema::new(vec![
    );
                    "active" => 4,
        LT::Not(inner) => BoolNode::Not(Box::new(to_engine_tree_large(inner))),
    let batch = RecordBatch::try_new(
        Arc::new(move |segment, _chunk, _stream_metrics, _stats_prune_tree| {
}
        object_path: object_store::path::Path::from(f.path.to_string_lossy().as_ref()),
        pushdown_predicate: None,
                status.value(i).to_string(),
        categories.push(categories_pool[(next() as usize) % categories_pool.len()]);
);
    }
        datafusion::physical_expr::expressions::BinaryExpr::new(left, op, right),
    let f = large_fixture();
            ),
    ])
    LT::And(vec![
        x ^= x << 13;
        LT::Leaf(LLeaf::LBrand("amazon")), // ~25% of rows
reference_test_large!(large_price_lt_negative, LT::Leaf(LLeaf::LPriceLt(-200)));
    LT::Not(Box::new(LT::Or(vec![
                    crate::indexed_table::eval::CollectorCallStrategy::TightenOuterBounds,
        Arc::new(move |segment, _chunk, _stream_metrics, _stats_prune_tree| {
 *
        })
    wire_large_rec(tree, &mut out);
        LLeaf::LPriceGe(v) => f.prices[row] >= v,
    assert_eq!(actual, expected_sorted, "[{}] row set mismatch", name);
            });
            None => panic!(
//! per RG, nullable qty column, negative/zero/positive prices. Validates
    let per_leaf: Vec<(i32, Arc<dyn RowGroupDocsCollector>)> = collectors
// ── Pure-predicate trees (no backend leaves) ──────────────────────────
    large_pure_predicate_triple_and,
    // Deterministic pseudo-randomness (no rand crate).
                && f.qtys[r] == *qty
reference_test_large!(
}
        max_doc: LARGE_N as i64,
    match tree {
// Wide OR containing a narrow predicate + wide collector — the narrow
//! and wide predicates (exercises RG-skip when a row group has no matches),
    let mut qtys: Vec<Option<i32>> = Vec::with_capacity(LARGE_N);
fn reference_evaluator_large_leaf(leaf: LLeaf, row: usize) -> Option<bool> {
        x ^= x << 17;
            first_row: offset,
//! multi-partition fanout, and shapes that highlight future Phase-2
struct LargeFixture {
    LT::Not(Box::new(LT::And(vec![
// Triple AND of pure predicates; page pruning must combine multiple
        ]),
// could skip sibling kernel evaluation once the accumulator is saturated.
        sort_fields: vec![],
    ctx.register_table("t", provider).unwrap();
}
        global_base: 0,
        .target_partitions(partitions)
    let mut out = Vec::new();
    let schema = meta.schema().clone();
        sort_max: None,
    LT::And(vec![
        let b = batch.unwrap();
        let schema = schema.clone();
            LT::Leaf(LLeaf::LStatus("archived")),
// so most pages get pruned in most RGs.
    LT::And(vec![
// universe (see `subtree_has_predicate` guard). Also varies how aggressively
// negative/zero/positive prices). One shared parquet + cached arrays.
    for i in 0..parquet_meta.num_row_groups() {
    LT::Not(Box::new(LT::Or(vec![
        let cat = b.column(3).as_any().downcast_ref::<StringArray>().unwrap();
        pushdown_predicate: None,
    let mut rgs = Vec::new();
);
        let per_leaf = per_leaf.clone();
            ));
    large_empty_via_contradiction,
            }
        parquet_size: size,
                annotation_id: match *b {
                    _ => panic!("unknown brand {}", b),
            LT::Leaf(LLeaf::LPriceLt(-200)),
//
        .collect();
                }
enum LLeaf {
    let f = large_fixture();
    ])
// NOT(pure-predicate). Must exercise the universe-fallback Phase 1 path
        Field::new("price", DataType::Int32, false),
            ));
reference_test_large!(
 * compatible open source license.
    ))
    LPriceLt(i32),
    large_or_wide_then_narrow_collector,
        parquet_size: size,
    assert_eq!(
// Probably matches ~0-2 rows across all 5 RGs — most RGs produce 0
//
// page pruning can trim — narrow predicates land in ~1 page/RG, wide ones
        LT::And(children) => {
            Arc::new(StringArray::from(categories.clone())),
    ])
        Field::new("status", DataType::Utf8, false),
    }
    ))
    // fine because rows are unique enough across columns.
    let f = large_fixture();
    ])))
            for c in children {
            let tag = Some(*annotation_id as u8).expect("empty tag bytes");
    out
const LARGE_N: usize = 10_000;
        },
    let f = large_fixture();
 */
// These tests lock in correctness for those shapes. A future optimization
// subsequent AND with a cheap collector should produce an empty result
    LT::Leaf(LLeaf::LPriceGe(900))
    LT::Not(Box::new(LT::And(vec![
    Arc::new(Schema::new(vec![
                tree: Arc::new(resolved),
    w.write(&batch).unwrap();
// ══════════════════════════════════════════════════════════════════════
        .into_iter()
    };
}
/// OR: any TRUE → TRUE, else any UNKNOWN → UNKNOWN, else FALSE.
// Collector-only shape that forces AND-empty short-circuit at scale.
        ]),
reference_test_large!(
    let parquet_meta = meta.metadata().clone();
        "multipartition_5",
                max_collector_parallelism: 1,
        Field::new("price", DataType::Int32, false),
    })
    let meta =
        .unwrap();
                price.value(i),
        .enumerate()
// brand=amazon AND brand=apple → empty per RG, triggering the fix I made
            }
        Field::new("qty", DataType::Int32, true),
    // Reference evaluator: rows where the tree evaluates to TRUE (UNKNOWN and FALSE excluded).
);
        LT::Leaf(LLeaf::LBrand("amazon")),
        BoolNode::Collector { annotation_id } => {
            ]),
//
            LLeaf::LPriceGe(v) => pred_large_int("price", Operator::GtEq, *v),
        LT::Leaf(LLeaf::LBrand("apple")),
    let mut categories = Vec::with_capacity(LARGE_N);
                brand.value(i).to_string(),
    while let Some(batch) = stream.next().await {
            LT::Leaf(LLeaf::LBrand("apple")),
// Exercises RG-skip when the whole expression is vacuous.
        sort_orders: vec![],
        LT::And(cs) => BoolNode::And(cs.iter().map(to_engine_tree_large).collect()),
                pruning_predicates: std::sync::Arc::new(std::collections::HashMap::new()),
        LT::Leaf(LLeaf::LCategory("books")),
    let mut actual: Vec<usize> = Vec::with_capacity(rows.len());
    statuses: Vec<&'static str>,
fn wire_large_rec(node: &BoolNode, out: &mut Vec<Arc<dyn RowGroupDocsCollector>>) {
        rows.len(),
                brand.value(i).to_string(),
fn wire_large(tree: &BoolNode) -> Vec<Arc<dyn RowGroupDocsCollector>> {
        LT::Leaf(LLeaf::LBrand("apple")),
reference_test_large!(
    LQtyEq(i32),
// Phase 2 today evaluates every child unconditionally even when:
}
//
        LT::Leaf(LLeaf::LPriceGe(900)),    // narrow, few rows
);
        statuses,
        datafusion::physical_expr::expressions::Literal::new(ScalarValue::Int32(Some(v))),
    }));
        LT::Or(cs) => BoolNode::Or(cs.iter().map(to_engine_tree_large).collect()),
reference_test_large!(large_price_ge_zero, LT::Leaf(LLeaf::LPriceGe(0)));
            LLeaf::LBrand(b) => BoolNode::Collector {
reference_test_large!(
        LT::Leaf(LLeaf::LBrand("apple")), // never matches alongside amazon → short-circuit
        datafusion::physical_expr::expressions::Column::new(col, col_idx),
            ));
// earlier for collecting sibling collector bitmaps. Add a 3rd collector
/// builds the matching mock collectors.
    LT::Or(vec![
        partitions,
//
        LLeaf::LQtyGe(v) => return f.qtys[row].map(|q| q >= v),
// must trigger the streaming loop's "skip RG" branch (when `prefetch_rg`
        emit_row_ids: false,
reference_test_large!(
    large_narrow_predicate_or_wide_collector,
                    Some(qty.value(i))
fn build_large_fixture() -> LargeFixture {
    Not(Box<LT>),
        });
        .force_strategy(Some(FilterStrategy::BooleanMask))
        BoolNode::Not(inner) => wire_large_rec(inner, out),
// Uniform distribution → each RG has roughly equal proportion but with
        LT::Leaf(LLeaf::LPriceGe(0)),
                schema.clone(),
reference_test_large!(
    let expected: Vec<usize> = (0..LARGE_N)
    large_price_lt_max_out_of_range,
        name,
                name, brand, price, status, cat, qty
/// DFS-walk the tree and build one collector per Collector leaf,
            },
                evaluator: Arc::new(BitmapTreeEvaluator),
            LT::Leaf(LLeaf::LPriceGe(500)),
}
        "multipartition_2",
// touch most pages.
                Some(false)
// NOT over collector-only AND. Uses the exact-inversion Phase-1 path.
                status.value(i).to_string(),
            LT::Not(Box::new(LT::Leaf(LLeaf::LCategory("books")))),
        LT::Leaf(LLeaf::LStatus("active")),
        let qty = b.column(4).as_any().downcast_ref::<Int32Array>().unwrap();
// ── RG-skip + narrow-match tests ─────────────────────────────────────
    ])
    let mut w = ArrowWriter::try_new(file, schema, Some(props)).unwrap();
);
        LT::Leaf(LLeaf::LQtyEq(0)),
        }
            ScalarValue::Utf8(Some(v.to_string())),
    let rows = run_large_partitioned(bt, collectors, partitions).await;
            }
// ── Large-fixture reference evaluator (3VL for NULL) ──────────────────────────────
        segments: vec![segment],
        LT::Leaf(LLeaf::LBrand("samsung")),
        .build();
        LT::Leaf(LLeaf::LBrand("amazon")),
                },
        LT::Leaf(LLeaf::LQtyGe(100)),
    large_price_ge_max_out_of_range,
                rg_index_to_pos: HashMap::new(),
    let mut out: Vec<Arc<dyn RowGroupDocsCollector>> = Vec::new();
///   * NULLs in qty propagate via 3VL; UNKNOWN rows must NOT appear in the
        let qty = b.column(4).as_any().downcast_ref::<Int32Array>().unwrap();
    // Caches: straightforward vectors for the reference evaluator.
        LT::Leaf(LLeaf::LPriceEq(99_999)), // empty
}
            index: i,
// Deep alternation: 5 levels, all ops, crosses nullable + non-nullable columns.
        LLeaf::LQtyEq(v) => return f.qtys[row].map(|q| q == v),
macro_rules! reference_test_large {
    LT::Or(vec![
    Some(match leaf {
        .sql("SELECT brand, price, status, category, qty FROM t")
            let eval: Arc<dyn RowGroupBitsetSource> = Arc::new(TreeBitsetSource {
                    None
        LT::Not(Box::new(LT::Leaf(LLeaf::LQtyGe(100)))),
        .map(|(i, c)| (i as i32, c))
// ── Multi-partition runs ─────────────────────────────────────────────
    LPriceEq(i32),
    let mut expected_sorted = expected.clone();
    ])
        ]),
        LT::Leaf(LLeaf::LStatus("archived")),
        LT::Leaf(LLeaf::LPriceGe(500)),
    large_and_narrow_then_wide_collector,
reference_test_large!(
fn reference_evaluator_large(tree: &LT, row: usize) -> Option<bool> {
        metadata: Arc::clone(&parquet_meta),
    };
        }
);
    LT::And(vec![
        "[{}] partitions={} count mismatch: engine={} reference evaluator={}",
// NULL row shouldn't match `qty = N` for any N.
}
/// Lower `LT` to `BoolNode`. Collector leaves encode the brand/status tag
    ])
        predicate_columns: vec![],
        let price = b.column(1).as_any().downcast_ref::<Int32Array>().unwrap();
// predicate's empty pages shouldn't suppress the collector's rows.
            if any_unknown {
);
        Arc::new(datafusion::physical_expr::expressions::Literal::new(
        arrow_schema: schema.clone(),
    large_not_qty_lt_100,
    ]));
use super::*;
reference_test_large!(
// first child saturates.
        .set_statistics_enabled(datafusion::parquet::file::properties::EnabledStatistics::Page)
    );
        let _ = i;
    LT::Leaf(LLeaf::LPriceLt(-10000))
        let tree = Arc::clone(&tree);
    ])
                rg_index_to_pos: HashMap::new(),
);
                    "samsung" => 3,
    let mut statuses = Vec::with_capacity(LARGE_N);
        LT::Leaf(LLeaf::LPriceLt(0)),
reference_test_large!(
                    None => any_unknown = true,
    let mut offset = 0i64;
    let schema = large_schema();
        let n = parquet_meta.row_group(i).num_rows();
        LT::Or(vec![
        let n = parquet_meta.row_group(i).num_rows();
        let per_leaf = per_leaf.clone();
            assert_engine_matches_reference_large(stringify!($name), $tree).await;
            if any_unknown {
    .await;
        global_base: 0,
    let bt = to_engine_tree_large(&tree).push_not_down();
    large_or_collector_with_nullable_predicate,
                    Some(true) => return Some(true),
    large_not_over_compound,
    LT::Or(vec![
                None
    ])
        sort_orders: vec![],
                Some(true)
}
    let ctx = SessionContext::new();
    LT::Or(vec![
            let resolved = tree.resolve(&per_leaf)?;
// No Predicate leaves → Phase 1 bitmaps are all exact. NOT over
        LT::Or(vec![
// exercise exact inversion and bitset unions at RG scale.
    // Collectors (provider_id = u16, mapped in wire_large).
    }
        });
    for (brand, price, status, cat, qty) in &rows {
        sort_max: None,
        ]),
    let left: Arc<dyn datafusion::physical_expr::PhysicalExpr> = Arc::new(
// Same idea via NOT(Collector OR Collector): collectors-only, should
    match node {
        LT::Leaf(LLeaf::LQtyGe(50)),
    }
        .build();
    while let Some(batch) = stream.next().await {
    out
    Leaf(LLeaf),
        LT::Leaf(LLeaf::LPriceLt(500)),
                collector_strategy:
            },
    let mut next = || {
                && f.prices[r] == *price
        LT::And(vec![
            Some(i) => actual.push(i),
);
        LT::Leaf(LLeaf::LBrand("amazon")),
reference_test_large!(
#[derive(Debug, Clone, Copy)]
    let mut out = Vec::new();
        5 => Some("archived"),
        });
    );
        x
    large_complex_mixed,
// per-column range intersections.
        LT::Leaf(LLeaf::LPriceGe(500))
async fn large_multipartition_2() {
    large_not_over_collectors_only_and,
        })
    LT::And(vec![
    };
                && f.statuses[r] == status.as_str()
    let col_idx = schema.index_of(col).expect("large column");
        LLeaf::LPriceLt(v) => f.prices[row] < v,
    LT::And(vec![
            f.brands[r] == brand.as_str()
                    None
                annotation_id: match *s {
                },
    large_four_collectors_nested,
    LT::And(vec![
            Some((next() as i32).rem_euclid(201))
        LLeaf::LStatus(s) => f.statuses[row] == s,
/// into `query_bytes`; `wire_large` walks the tree in DFS order and
                Arc::clone(&segment.metadata),
reference_test_large!(
        x ^= x >> 7;
enum LT {
    let df = ctx
#[tokio::test(flavor = "multi_thread", worker_threads = 4)]
                    _ => panic!("unknown status {}", s),
            let mut any_unknown = false;
// NULL handling: qty is nullable. `qty >= 0` should exclude NULL rows (3VL).
        query_config: std::sync::Arc::new(qc),
                max_collector_parallelism: 1,
        0 => Some("amazon"),
    ])
    tree: BoolNode,
    let mut stream = df.execute_stream().await.unwrap();
        LT::Leaf(LLeaf::LBrand("amazon")), // large bitmap, wasted work today
                && want_status.map_or(true, |s| f.statuses[i] == s)
    let expected: Vec<usize> = (0..LARGE_N)
            Ok(eval)
// All other tests use num_partitions=1. These variants set N partitions
    actual.sort();
}
// Amazon ∩ active — must match across RGs.
            LT::Leaf(LLeaf::LBrand("apple")),
    ])))
//! short-circuit opportunities.
            LT::Leaf(LLeaf::LBrand("amazon")),
// and then Phase 2 exact refinement.
        rows.len(),
    };
//   * value-range variety (price in [-500, 1000], qty in [0, 200]).
    let want_brand: Option<&'static str> = match tag {
}
    ])
// collector bitmap.
        .indexed_pushdown_filters(false)
                    "amazon" => 0,
                match reference_evaluator_large(c, row) {
        LT::Leaf(LLeaf::LCategory("electronics")),
                price.value(i),
        LT::Leaf(l) => reference_evaluator_large_leaf(*l, row),
                evaluator: Arc::new(BitmapTreeEvaluator),
);
    prices: Vec<i32>,
    .await;
reference_test_large!(
        .map(|i| i as i32)
}
        .await
        match found {
        LT::Leaf(LLeaf::LBrand("google")),
// AND of three: narrow first, then wide and wide. Short-circuit would save
    ])
// 4 collector leaves via nested AND/OR.
        _ => None,
            });
            } else {
// OR where the first predicate is wide enough to cover most batches. The
// fallback). AND short-circuit on an empty collector must still register
        LT::Leaf(LLeaf::LPriceGe(800)),
    let file = std::fs::File::open(&f.path).unwrap();
) -> Vec<(String, i32, String, String, Option<i32>)> {
            }
        rgs.push(RowGroupInfo {
    large_and_collector_with_nullable_predicate,
    ])
    ])
        let b = batch.unwrap();
        segments: vec![segment],
            LT::Leaf(LLeaf::LBrand("amazon")),
    ($name:ident, $tree:expr) => {
    );
        LT::Leaf(LLeaf::LStatus("archived")),
    let meta =
        sort_fields: vec![],
                "[{}] engine row not in fixture: ({}, {}, {}, {}, {:?})",
        prune_tree_config: None,
    let rows = run_large(bt, collectors).await;
}
    large_triple_and_collectors,
                }
async fn large_multipartition_predicate_only() {
#[derive(Debug, Clone)]
    )
                } else {
        cancellation_token: None,
    large_not_pure_predicate,
        arrow_schema: schema.clone(),
// Large-scale fixture (10_000 rows, multi-RG, multi-page, nullable qty,
                None
        brands.push(brands_pool[(next() as usize) % brands_pool.len()]);
    expected_sorted.sort();
        prices.push(p);
        LT::Leaf(LLeaf::LBrand("google")),
        let p = (next() as i32).rem_euclid(1500) - 500;
// that checks acc.true_count()/null_count() per step must preserve results.
fn pred_large_str(col: &str, op: Operator, v: &str) -> BoolNode {
        let schema = schema.clone();
// narrow predicate's page bitmap is interpreted wrong when AND'd with
/// 3VL evaluator. AND: any FALSE → FALSE, else any UNKNOWN → UNKNOWN, else TRUE.
            num_rows: n,
                page_prune_metrics: None,
    let size = std::fs::metadata(&f.path).unwrap().len();
// sibling to verify it still gets registered for Phase 2.
        LT::Leaf(LLeaf::LPriceEq(12345)),  // matches zero rows
    w.close().unwrap();
// page-pruning, many pages per RG get skipped before reaching Phase 2.
reference_test_large!(
    for i in 0..LARGE_N {
        rgs.push(RowGroupInfo {
    )
                page_pruner: pruner,
        LT::Not(LT::Leaf(LLeaf::LPriceLt(-100)).into()),
                    Some(false) => {}
    };
);
    let tree = Arc::new(tree);
        .filter(|&r| reference_evaluator_large(&tree, r) == Some(true))
            LT::Leaf(LLeaf::LBrand("amazon")),
 * The OpenSearch Contributors require contributions made to
/// Build the provider + stream against the cached 10k fixture.
            as Arc<dyn object_store::ObjectStore>,
reference_test_large!(
        let status = b.column(2).as_any().downcast_ref::<StringArray>().unwrap();
                    crate::indexed_table::eval::CollectorCallStrategy::TightenOuterBounds,
        let brand = b.column(0).as_any().downcast_ref::<StringArray>().unwrap();
                if qty.is_null(i) {
    large_deep_alternation,
            LT::Leaf(LLeaf::LStatus("archived")),
        LT::Leaf(LLeaf::LStatus("active")),
        for i in 0..b.num_rows() {
    let mut prices = Vec::with_capacity(LARGE_N);
    LT::And(vec![
    let qc = crate::datafusion_query_config::DatafusionQueryConfig::builder()
    ])
    let mut brands = Vec::with_capacity(LARGE_N);
        LT::Leaf(LLeaf::LBrand("samsung")),
        LT::Not(inner) => reference_evaluator_large(inner, row).map(|b| !b),
        ]),
    assert_large_multipartition(
                stats_prune_tree: None,
// Phase-2 short-circuit candidates — shapes where a future optimization
        "[{}] count mismatch: engine={} reference evaluator={}",
//   * multiple pages per RG (page size ≤ 512 rows),
    // Predicates.
    ])
        _ => None,
    LT::Leaf(LLeaf::LPriceGe(1000))
    }));
    ])
}
        statuses.push(statuses_pool[(next() as usize) % statuses_pool.len()]);
    LT::And(vec![
    }
        LT::Leaf(LLeaf::LBrand("apple")),
    ])
        LT::Leaf(LLeaf::LPriceGe(-1000)), // always true (page min is well above)
        LT::Leaf(LLeaf::LPriceLt(100))
        datafusion::physical_expr::expressions::Column::new(col, col_idx),
            as Arc<dyn object_store::ObjectStore>,
    BoolNode::Predicate(Arc::new(
    let f = large_fixture();
    let right: Arc<dyn datafusion::physical_expr::PhysicalExpr> = Arc::new(
                schema.clone(),
        LT::Leaf(LLeaf::LPriceGe(-500)), // always true → saturated
// AND where the narrow predicate drops every row in most batches; the
                cat.value(i).to_string(),
        LT::Leaf(LLeaf::LBrand("amazon")),
    assert_eq!(
        store: Arc::new(object_store::local::LocalFileSystem::new())
            LT::Leaf(LLeaf::LPriceGe(500)),
    ctx.register_table("t", provider).unwrap();
            LLeaf::LPriceEq(v) => pred_large_int("price", Operator::Eq, *v),
    };
            LT::And(vec![
        ]),
        ]),
// candidates and get skipped.
                    None => any_unknown = true,
    ])
        .enumerate()
    out
    }
    let props = datafusion::parquet::file::properties::WriterProperties::builder()
        LT::Or(vec![
                &schema,
//! Streaming-at-scale tests: 10 000 rows, 5 row groups with multiple pages
    let factory: super::super::table_provider::EvaluatorFactory = {
    LPriceGe(i32),
        writer_generation: 0,
    ])
    }
    And(Vec<LT>),
            let pruner = Arc::new(PagePruner::new(
        LT::Leaf(l) => match l {
    LCategory(&'static str),
    LT::Or(vec![
                leaves: Arc::new(CollectorLeafBitmaps::without_metrics()),
                page_pruner: pruner,
// Nested predicate-only: 4 levels, no collectors.
    LT::Not(Box::new(LT::Leaf(LLeaf::LQtyGe(100))))
#[tokio::test(flavor = "multi_thread", worker_threads = 4)]
        qtys.push(if (next() % 10) == 0 {
//   AND: acc is already all-false for the batch (any further AND stays false);
        BoolNode::And(cs) | BoolNode::Or(cs) => cs.iter().for_each(|c| wire_large_rec(c, out)),
    // Map engine rows back to fixture indices by a tuple key. Duplicates are
        expected.len()
        LT::Or(vec![
    match tree {
        store_url: datafusion::execution::object_store::ObjectStoreUrl::local_filesystem(),
    let schema = meta.schema().clone();
    partitions: usize,
reference_test_large!(
                cost_collector: 10,
    LBrand(&'static str),  // 0..=3 depending on brand
            Arc::new(Int32Array::from(prices.clone())),
    };
        prices,
    Arc::new(MockCollector { matching })
    .await;
        3 => Some("samsung"),
        1 => Some("apple"),
    let segment = SegmentFileInfo {
// Separate helpers from the 16-row fixture — reuses the same engine pipeline
);
    let mut x: u64 = 0x9E3779B97F4A7C15;
        LT::Leaf(LLeaf::LPriceGe(0)),
        Field::new("brand", DataType::Utf8, false),
        offset += n;
// must still equal the single-partition reference evaluator answer.
        LT::Leaf(LLeaf::LPriceEq(0)),
                cost_predicate: 1,
        ArrowReaderMetadata::load(&file, ArrowReaderOptions::new().with_page_index(true)).unwrap();
            LLeaf::LPriceLt(v) => pred_large_int("price", Operator::Lt, *v),
//! multi-RG streaming, page pruning, SQL 3VL on nullable columns, narrow
        LT::Leaf(LLeaf::LStatus("archived")), // must still be registered in per_leaf
// ── Collector-only compound trees ────────────────────────────────────
    let schema = large_schema();
);
fn large_collector_for(tag: u8) -> Arc<dyn RowGroupDocsCollector> {
        datafusion::physical_expr::expressions::BinaryExpr::new(left, op, right),
                collector_strategy:
                && !actual.contains(&r)
    static CELL: OnceLock<LargeFixture> = OnceLock::new();
// ══════════════════════════════════════════════════════════════════════
            out.push(large_collector_for(tag));
            Arc::new(StringArray::from(brands.clone())),
}
reference_test_large!(large_price_lt_zero, LT::Leaf(LLeaf::LPriceLt(0)));
    // Lower + run
        schema: schema.clone(),
            LLeaf::LCategory(c) => pred_large_str("category", Operator::Eq, c),
                page_prune_metrics: None,
 * this file be licensed under the Apache-2.0 license or a
        LT::Leaf(LLeaf::LBrand("apple")),
// regardless of evaluation order.
                },
        .collect();
    let provider = Arc::new(IndexedTableProvider::new(IndexedTableConfig {
}
        Field::new("category", DataType::Utf8, false),
            let eval: Arc<dyn RowGroupBitsetSource> = Arc::new(TreeBitsetSource {
        }
        .collect();
                stats_prune_tree: None,
            LT::Leaf(LLeaf::LCategory("electronics")),
);
        evaluator_factory: factory,
    qtys: Vec<Option<i32>>,
);
fn pred_large_int(col: &str, op: Operator, v: i32) -> BoolNode {
// ══════════════════════════════════════════════════════════════════════
                Arc::clone(&segment.metadata),
                LT::Not(Box::new(LT::Leaf(LLeaf::LCategory("books")))),
        LT::Leaf(LLeaf::LCategory("electronics"))
/// Two extra invariants tested vs the 16-row harness:
    let mut offset = 0i64;
                } else {
        LT::Leaf(LLeaf::LBrand("amazon")),
        vec![
// Amazon rows with NULL qty must be dropped (3VL AND).
    .unwrap();
        LT::Or(children) => {
                LT::Leaf(LLeaf::LBrand("apple")),
// two kernel evaluations per batch.
    };
    ])))
        sort_min: None,
    let left: Arc<dyn datafusion::physical_expr::PhysicalExpr> = Arc::new(
reference_test_large!(
            LT::Leaf(LLeaf::LBrand("amazon")),
    let provider = Arc::new(IndexedTableProvider::new(IndexedTableConfig {
    large_collector_and_narrow_predicate,
// Wide: price <0 OR price >=500 — matches ~70% of rows across every page.
    ])
async fn large_multipartition_5() {
        ],
    collectors: Vec<Arc<dyn RowGroupDocsCollector>>,
    collectors: Vec<Arc<dyn RowGroupDocsCollector>>,
async fn run_large_partitioned(
}
    let file = std::fs::File::open(&f.path).unwrap();
);
fn large_fixture() -> &'static LargeFixture {
            index: i,
        let brand = b.column(0).as_any().downcast_ref::<StringArray>().unwrap();
//
            LT::Leaf(LLeaf::LQtyEq(0)),
    let tmp = NamedTempFile::new().unwrap();
        LT::Or(vec![
);
            LT::Leaf(LLeaf::LCategory("books")),
    BoolNode::Predicate(Arc::new(
        store: Arc::new(object_store::local::LocalFileSystem::new())
    )
    brands: Vec<&'static str>,
#[tokio::test(flavor = "multi_thread", worker_threads = 4)]
    large_not_or_three_collectors,
        max_doc: LARGE_N as i64,
        Field::new("brand", DataType::Utf8, false),
    LargeFixture {
        async fn $name() {
reference_test_large!(
        2,
// second Collector branch is redundant to compute.
    ])
        LT::Leaf(LLeaf::LStatus("archived")),
        }
        for i in 0..b.num_rows() {
    large_narrow_predicate_top_5pct,
        }
    LT::Not(Box::new(LT::Or(vec![
    let tree = Arc::new(tree);
            ));
        actual.len(),
            for c in children {
                &schema,
            let mut any_unknown = false;
    path: std::path::PathBuf,
    large_not_over_collectors_only_or,
        LT::Leaf(LLeaf::LBrand("amazon")),
        .collect();
    let parquet_meta = meta.metadata().clone();
    Or(Vec<LT>),
reference_test_large!(
        ArrowReaderMetadata::load(&file, ArrowReaderOptions::new().with_page_index(true)).unwrap();
        .collect();
/// add qty-nullable and negative-price cases.
/// Leaves specific to the large fixture. We reuse the engine machinery but
        ]),
//   * multiple row groups (2048 rows/RG → 5 RGs),
    large_or_two_collectors,
        ));
        writer_generation: 0,
// OR of three: wide first, then narrow and narrow. Short-circuit after
    large_and_short_circuit_with_sibling,
        query_config: std::sync::Arc::new(qc),
// ── Large-fixture tests ──────────────────────────────────────────────
        .set_data_page_row_count_limit(512)
// These exercise the Path C walker when it sees only Predicate leaves: every
/// NOT(UNKNOWN) = UNKNOWN.
    LT::And(vec![
        sort_min: None,
        LT::Leaf(LLeaf::LCategory("books")),
        LLeaf::LCategory(c) => f.categories[row] == c,
    let collectors = wire_large(&bt);
        .await
reference_test_large!(
    let mut rgs = Vec::new();
    LT::Or(vec![
        .unwrap();
}
    );
            num_rows: n,
        let found = (0..LARGE_N).find(|&r| {
    let categories_pool = ["electronics", "books"];
        Field::new("status", DataType::Utf8, false),
/// 3VL: None = UNKNOWN.
        schema: schema.clone(),
    }
async fn assert_large_multipartition(name: &str, tree: LT, partitions: usize) {
    ]))
// NOT(qty < 100): UNKNOWN propagates → row dropped. Reference evaluator catches it.
    }
        .indexed_pushdown_filters(false)
reference_test_large!(large_qty_ge_zero, LT::Leaf(LLeaf::LQtyGe(0)));
        row_groups: rgs,
                    "apple" => 1,
    let segment = SegmentFileInfo {
        .into_iter()
    let matching: Vec<i32> = (0..LARGE_N)
    let ctx = SessionContext::new();
);
                && f.categories[r] == cat.as_str()
        categories,
// siblings' bitmaps for Phase 2 lookup.
// Cross-RG amazon ∪ apple on 10k rows.
                leaves: Arc::new(CollectorLeafBitmaps::without_metrics()),
fn large_schema() -> SchemaRef {
        ]),
    let (file, path) = tmp.keep().unwrap();
        .target_partitions(1)
                pruning_predicates: std::sync::Arc::new(std::collections::HashMap::new()),
        expected.len(),
    for i in 0..parquet_meta.num_row_groups() {
        LT::Or(vec![
// Complex mixed: (google OR samsung) AND price>=0 AND NOT(archived) AND qty<100
        qtys,
);
        #[tokio::test(flavor = "multi_thread", worker_threads = 2)]
            LT::Not(Box::new(LT::Leaf(LLeaf::LPriceLt(0)))),
            Arc::new(StringArray::from(statuses.clone())),
                cost_collector: 10,
); // matches none
        Field::new("qty", DataType::Int32, true),
            first_row: offset,
//   * negative, zero, and positive prices,
// Empty in Rust: price between two disjoint ranges in nested ANDs.
                    "archived" => 5,
        let tree = Arc::clone(&tree);
        schema.clone(),
    large_almost_empty_result,
        LLeaf::LPriceEq(v) => f.prices[row] == v,
// Singleton match-ish: brand=amazon AND status=archived AND price=0.
        offset += n;
);
        });
    )
            LT::Leaf(LLeaf::LBrand("samsung")),
);
        LT::And(vec![
        }
        expected_sorted.len(),
                cost_predicate: 1,
            LLeaf::LQtyEq(v) => pred_large_int("qty", Operator::Eq, *v),
            let pruner = Arc::new(PagePruner::new(
            LT::Leaf(LLeaf::LStatus("active")),
    let size = std::fs::metadata(&f.path).unwrap().len();
reference_test_large!(large_qty_eq_42, LT::Leaf(LLeaf::LQtyEq(42)));
///     result set.
    large_or_three_narrow_after_wide,
// Narrow: price in top ~10%. Each RG's pages have different price ranges,
async fn assert_engine_matches_reference_large(name: &str, tree: LT) {
    let per_leaf: Vec<(i32, Arc<dyn RowGroupDocsCollector>)> = collectors
reference_test_large!(large_leaf_brand_amazon, LT::Leaf(LLeaf::LBrand("amazon")));
        brands,
reference_test_large!(
 * SPDX-License-Identifier: Apache-2.0
);
// NOT over compound: NOT((amazon AND archived) OR (price < 0)).
            LT::Leaf(LLeaf::LStatus("active")),
            want_brand.map_or(true, |b| f.brands[i] == b)
    large_pure_predicate_wide,
        LT::Leaf(LLeaf::LPriceLt(0)),
///   * fixture spans multiple RGs (5) and multiple pages per RG,
    LT::And(vec![
        name,
        prune_tree_config: None,
/*
        LT::Leaf(LLeaf::LPriceGe(0)),
        Field::new("category", DataType::Utf8, false),
            Arc::new(Int32Array::from(qtys.clone())),
        actual.len(),
    ])))
        .force_strategy(Some(FilterStrategy::BooleanMask))
// NULL qty rows that aren't amazon should NOT appear in result.
/// Run a tree against the large fixture and compare to the 3VL reference evaluator.
}
); // matches none
    CELL.get_or_init(build_large_fixture)
// OR with nullable branch: amazon OR qty > 100.
    LT::Or(vec![
// collector-only subtrees should use exact inversion (not the universe
);
        let price = b.column(1).as_any().downcast_ref::<Int32Array>().unwrap();
reference_test_large!(
// Negative, zero, positive boundaries on `price` (range -500..1000).
// Predicate that matches only the top ~5% of values (price >= 900).
reference_test_large!(
    let brands_pool = ["amazon", "apple", "google", "samsung"];
    LT::And(vec![
                    Some(false) => return Some(false),
    LT::And(vec![
reference_test_large!(
// A collector or predicate that matches zero (or a few) docs in some RGs
            LT::Leaf(LLeaf::LBrand("google")),
        LT::Or(vec![
        LT::And(vec![
//   * nullable `qty` column (about 10% NULL),
    let col_idx = schema.index_of(col).expect("large column");
        cancellation_token: None,
        })
            LT::Leaf(LLeaf::LStatus("active")),
    let right: Arc<dyn datafusion::physical_expr::PhysicalExpr> =
// and force the `QueryShardExec` fanout + UnionExec chain. Result set
                match reference_evaluator_large(c, row) {
                tree: Arc::new(resolved),
);
reference_test_large!(
            let resolved = tree.resolve(&per_leaf)?;
    let bt = to_engine_tree_large(&tree).push_not_down();
        let status = b.column(2).as_any().downcast_ref::<StringArray>().unwrap();
        LT::Leaf(LLeaf::LPriceGe(900)),
        row_groups: rgs,
    let mut stream = df.execute_stream().await.unwrap();
// Three-collector AND (should intersect to roughly N/(4*2*2) ≈ 625 rows).
        metadata: Arc::clone(&parquet_meta),
        // qty: ~10% NULL, otherwise [0, 200].
                },
            } else {
) -> Vec<(String, i32, String, String, Option<i32>)> {
fn to_engine_tree_large(tree: &LT) -> BoolNode {
        LT::Leaf(LLeaf::LStatus("archived")),
        }
                    "google" => 2,
        expected_sorted.len()
    let qc = crate::datafusion_query_config::DatafusionQueryConfig::builder()
        LT::And(vec![
    large_and_three_wide_after_narrow,
// Collector intersect narrow predicate: catches any page-pruning bug where
// Sanity: single-leaf collector on the large fixture.
reference_test_large!(
    }
reference_test_large!(
}
        } else {
        .filter(|&i| {
            Ok(eval)
        let cat = b.column(3).as_any().downcast_ref::<StringArray>().unwrap();
        ]),
        4 => Some("active"),
reference_test_large!(
// but with a richer dataset to exercise:
// NOT over collector-only OR — De Morgan equivalent to AND of NOTs.
        store_url: datafusion::execution::object_store::ObjectStoreUrl::local_filesystem(),
                if qty.is_null(i) {
async fn run_large(
        .set_max_row_group_size(2048)
    let factory: super::super::table_provider::EvaluatorFactory = {
}
        .build();
    let df = ctx
                cat.value(i).to_string(),
        emit_row_ids: false,
    let statuses_pool = ["active", "archived"];
);
        3,
    large_pure_predicate_narrow,
    let collectors = wire_large(&bt);
        LT::Leaf(LLeaf::LBrand("amazon")),
        .filter(|&r| reference_evaluator_large(&tree, r) == Some(true))
    large_and_two_collectors,
        BoolNode::DelegationPossible { .. } => {}
// Phase 1 result comes from page statistics, and NOT must fall back to the
        LT::Leaf(LLeaf::LBrand("amazon")),
        // Price in [-500, 1000) including 0.
        LT::Leaf(LLeaf::LPriceLt(500)),
        object_path: object_store::path::Path::from(f.path.to_string_lossy().as_ref()),
            out.push((
        LLeaf::LBrand(b) => f.brands[row] == b,
    assert_large_multipartition(
    LT::And(vec![
reference_test_large!(
        LT::Not(Box::new(LT::Leaf(LLeaf::LStatus("archived")))),
    LStatus(&'static str), // 4 = active, 5 = archived
);
    tree: BoolNode,
reference_test_large!(
reference_test_large!(large_price_eq_zero, LT::Leaf(LLeaf::LPriceEq(0)));
        .map(|(i, c)| (i as i32, c))
);
