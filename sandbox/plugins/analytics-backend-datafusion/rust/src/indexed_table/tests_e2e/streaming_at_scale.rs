    large_price_lt_max_out_of_range,
            LT::Leaf(LLeaf::LQtyEq(0)),
        LT::Or(vec![
    ]));
    let schema = Arc::new(Schema::new(vec![
        _ => None,
                && !actual.contains(&r)
    statuses: Vec<&'static str>,
// ══════════════════════════════════════════════════════════════════════
/// into `query_bytes`; `wire_large` walks the tree in DFS order and
 * compatible open source license.
    let expected: Vec<usize> = (0..LARGE_N)
    LT::Or(vec![
        ]),
/*
///   * fixture spans multiple RGs (5) and multiple pages per RG,
// returns None) while still correctly emitting rows from RGs that do match.
    let schema = large_schema();
        let b = batch.unwrap();
            LT::Leaf(LLeaf::LStatus("archived")),
            LT::Leaf(LLeaf::LPriceGe(500)),
    match tree {
                rg_index_to_pos: HashMap::new(),
    let collectors = wire_large(&bt);
            Arc::new(StringArray::from(brands.clone())),
        qtys,
// second Collector branch is redundant to compute.
    large_and_short_circuit_with_sibling,
async fn large_multipartition_5() {
    Not(Box<LT>),
        LT::Leaf(LLeaf::LBrand("apple")),
        sort_fields: vec![],
}
        let qty = b.column(4).as_any().downcast_ref::<Int32Array>().unwrap();
);
        emit_row_ids: false,
    let f = large_fixture();
    let factory: super::super::table_provider::EvaluatorFactory = {
        LT::Or(cs) => BoolNode::Or(cs.iter().map(to_engine_tree_large).collect()),
    large_and_narrow_then_wide_collector,
        row_groups: rgs,
    ctx.register_table("t", provider).unwrap();
reference_test_large!(
    for i in 0..LARGE_N {
reference_test_large!(large_price_ge_zero, LT::Leaf(LLeaf::LPriceGe(0)));
        LT::Leaf(LLeaf::LBrand("amazon")),
            let resolved = tree.resolve(&per_leaf)?;
use super::*;
    .await;
        LT::Leaf(LLeaf::LPriceLt(0)),
            LT::Leaf(LLeaf::LCategory("electronics")),
);
); // matches none
        .into_iter()
            LT::Leaf(LLeaf::LPriceLt(-200)),
    assert_eq!(
    Some(match leaf {
        LT::Leaf(LLeaf::LStatus("active")),
    LT::And(vec![
    LT::Or(vec![
        .force_strategy(Some(FilterStrategy::BooleanMask))
);
    large_triple_and_collectors,
// Same idea via NOT(Collector OR Collector): collectors-only, should
        .await
    large_complex_mixed,
reference_test_large!(large_price_lt_negative, LT::Leaf(LLeaf::LPriceLt(-200)));
    assert_large_multipartition(
reference_test_large!(
        LT::Leaf(l) => match l {
    let parquet_meta = meta.metadata().clone();
    let mut rgs = Vec::new();
        3 => Some("samsung"),
    };
#[derive(Debug, Clone)]
    LT::Leaf(LLeaf::LPriceGe(1000))
    }
    BoolNode::Predicate(Arc::new(
    let schema = large_schema();
    ])
        LT::Leaf(LLeaf::LPriceGe(0)),
        prices.push(p);
            let tag = Some(*annotation_id as u8).expect("empty tag bytes");
reference_test_large!(
        .force_strategy(Some(FilterStrategy::BooleanMask))
                &schema,
            Arc::new(Int32Array::from(prices.clone())),
            Some(i) => actual.push(i),
}
);
            LLeaf::LBrand(b) => BoolNode::Collector {
    ])
    collectors: Vec<Arc<dyn RowGroupDocsCollector>>,
    )
            out.push((
// Deep alternation: 5 levels, all ops, crosses nullable + non-nullable columns.
        LLeaf::LCategory(c) => f.categories[row] == c,
        rows.len(),
        .collect();
        .enumerate()
        let b = batch.unwrap();
    )
}
    qtys: Vec<Option<i32>>,
    let mut x: u64 = 0x9E3779B97F4A7C15;
        datafusion::physical_expr::expressions::BinaryExpr::new(left, op, right),
        .enumerate()
//! multi-RG streaming, page pruning, SQL 3VL on nullable columns, narrow
}
        "[{}] partitions={} count mismatch: engine={} reference evaluator={}",
                    Some(qty.value(i))
        LT::Leaf(LLeaf::LBrand("google")),
    assert_large_multipartition(
            LT::Leaf(LLeaf::LStatus("active")),
                price.value(i),
        Arc::new(move |segment, _chunk, _stream_metrics, _stats_prune_tree| {
    let want_status: Option<&'static str> = match tag {
    And(Vec<LT>),
        LT::Leaf(LLeaf::LBrand("samsung")),
// and then Phase 2 exact refinement.
                cat.value(i).to_string(),
    let mut stream = df.execute_stream().await.unwrap();
#[tokio::test(flavor = "multi_thread", worker_threads = 4)]
// Phase 2 today evaluates every child unconditionally even when:
    LT::Or(vec![
                    Some(false) => {}
// but with a richer dataset to exercise:
        .collect();
        .map(|i| i as i32)
// Predicate that matches only the top ~5% of values (price >= 900).
    }));
                if qty.is_null(i) {
//
// fallback). AND short-circuit on an empty collector must still register
                    None => any_unknown = true,
        x
        .build();
        .filter(|&r| reference_evaluator_large(&tree, r) == Some(true))
        LT::Leaf(LLeaf::LCategory("books")),
    ])
    let col_idx = schema.index_of(col).expect("large column");
// 4 collector leaves via nested AND/OR.
            ),
    large_almost_empty_result,
            ));
    large_deep_alternation,
    ctx.register_table("t", provider).unwrap();
                price.value(i),
// Nested predicate-only: 4 levels, no collectors.
fn to_engine_tree_large(tree: &LT) -> BoolNode {
    ($name:ident, $tree:expr) => {
            f.brands[r] == brand.as_str()
//   * multiple pages per RG (page size ≤ 512 rows),
    LT::Not(Box::new(LT::And(vec![
    };
                evaluator: Arc::new(BitmapTreeEvaluator),
        LT::Leaf(LLeaf::LStatus("archived")),
// A collector or predicate that matches zero (or a few) docs in some RGs
    )
reference_test_large!(
    ])))
        evaluator_factory: factory,
        async fn $name() {
    };
    LBrand(&'static str),  // 0..=3 depending on brand
        writer_generation: 0,
async fn assert_engine_matches_reference_large(name: &str, tree: LT) {
        LT::Leaf(LLeaf::LBrand("amazon")),
// two kernel evaluations per batch.
        LT::Leaf(LLeaf::LPriceLt(100))
reference_test_large!(
                    crate::indexed_table::eval::CollectorCallStrategy::TightenOuterBounds,
                    _ => panic!("unknown status {}", s),
                evaluator: Arc::new(BitmapTreeEvaluator),
}
        let _ = i;
        BoolNode::DelegationPossible { .. } => {}
#[tokio::test(flavor = "multi_thread", worker_threads = 4)]
        .unwrap();
    large_not_over_compound,
        .into_iter()
    large_pure_predicate_triple_and,
reference_test_large!(
        LT::Leaf(LLeaf::LPriceGe(-500)), // always true → saturated
        4 => Some("active"),
    let left: Arc<dyn datafusion::physical_expr::PhysicalExpr> = Arc::new(
            }
    let segment = SegmentFileInfo {
#[derive(Debug, Clone, Copy)]
        Arc::new(datafusion::physical_expr::expressions::Literal::new(
        let qty = b.column(4).as_any().downcast_ref::<Int32Array>().unwrap();
// ── RG-skip + narrow-match tests ─────────────────────────────────────
// Collector-only shape that forces AND-empty short-circuit at scale.
        },
                None
    let mut statuses = Vec::with_capacity(LARGE_N);
 * this file be licensed under the Apache-2.0 license or a
            index: i,
        LT::And(vec![
                    "google" => 2,
        }
    LT::Or(vec![
        predicate_columns: vec![],
    let per_leaf: Vec<(i32, Arc<dyn RowGroupDocsCollector>)> = collectors
    large_deep_predicate_only,
        expected_sorted.len(),
/// DFS-walk the tree and build one collector per Collector leaf,
);
        let p = (next() as i32).rem_euclid(1500) - 500;
                max_collector_parallelism: 1,
            let resolved = tree.resolve(&per_leaf)?;
// AND where the narrow predicate drops every row in most batches; the
    let mut offset = 0i64;
                    None => any_unknown = true,
                LT::Not(Box::new(LT::Leaf(LLeaf::LCategory("books")))),
        prune_tree_config: None,
                stats_prune_tree: None,
                },
    // Collectors (provider_id = u16, mapped in wire_large).
    large_pure_predicate_wide,
}
        LT::Not(Box::new(LT::Leaf(LLeaf::LQtyGe(100)))),
    let df = ctx
    BoolNode::Predicate(Arc::new(
    .await;
fn large_fixture() -> &'static LargeFixture {
// Wide OR containing a narrow predicate + wide collector — the narrow
// could skip sibling kernel evaluation once the accumulator is saturated.
        LT::Leaf(LLeaf::LCategory("electronics"))
reference_test_large!(
        qtys.push(if (next() % 10) == 0 {
        LT::Leaf(LLeaf::LStatus("archived")),
                "[{}] engine row not in fixture: ({}, {}, {}, {}, {:?})",
reference_test_large!(
        0 => Some("amazon"),
                stats_prune_tree: None,
        sort_orders: vec![],
        ]),
    large_or_three_narrow_after_wide,
    large_pure_predicate_narrow,
        let cat = b.column(3).as_any().downcast_ref::<StringArray>().unwrap();
    LPriceEq(i32),
    LStatus(&'static str), // 4 = active, 5 = archived
// Phase 1 result comes from page statistics, and NOT must fall back to the
);
        max_doc: LARGE_N as i64,
// Narrow: price in top ~10%. Each RG's pages have different price ranges,
reference_test_large!(
                match reference_evaluator_large(c, row) {
    let statuses_pool = ["active", "archived"];
    // Caches: straightforward vectors for the reference evaluator.
    let f = large_fixture();
    let batch = RecordBatch::try_new(
reference_test_large!(
    large_or_two_collectors,
 * SPDX-License-Identifier: Apache-2.0
            num_rows: n,
                    crate::indexed_table::eval::CollectorCallStrategy::TightenOuterBounds,
        object_path: object_store::path::Path::from(f.path.to_string_lossy().as_ref()),
// ── Large-fixture reference evaluator (3VL for NULL) ──────────────────────────────
// Large-scale fixture (10_000 rows, multi-RG, multi-page, nullable qty,
            Arc::new(StringArray::from(statuses.clone())),
            LT::Leaf(LLeaf::LCategory("books")),
    };
    Or(Vec<LT>),
    let brands_pool = ["amazon", "apple", "google", "samsung"];
fn large_schema() -> SchemaRef {
                leaves: Arc::new(CollectorLeafBitmaps::without_metrics()),
// ══════════════════════════════════════════════════════════════════════
    Arc::new(Schema::new(vec![
}
    };
    );
    let mut qtys: Vec<Option<i32>> = Vec::with_capacity(LARGE_N);
async fn run_large(
        LT::Or(vec![
                && want_status.map_or(true, |s| f.statuses[i] == s)
            LT::Leaf(LLeaf::LStatus("active")),
    let categories_pool = ["electronics", "books"];
        x ^= x << 17;
    let tmp = NamedTempFile::new().unwrap();
        LT::Not(Box::new(LT::Leaf(LLeaf::LStatus("archived")))),
        LT::And(vec![
    large_collector_and_narrow_predicate,
    }
    LQtyGe(i32),
);
            let eval: Arc<dyn RowGroupBitsetSource> = Arc::new(TreeBitsetSource {
        Field::new("category", DataType::Utf8, false),
            first_row: offset,
    );
}
// AND where one branch is a NULL-prone predicate: amazon AND qty >= 50.
    let mut stream = df.execute_stream().await.unwrap();
        name,
        LT::Leaf(LLeaf::LBrand("amazon")),
            LT::And(vec![
        LT::Leaf(LLeaf::LPriceGe(0)),
        // qty: ~10% NULL, otherwise [0, 200].
enum LLeaf {
        LT::Leaf(LLeaf::LQtyGe(100)),
    ))
                && f.qtys[r] == *qty
    large_narrow_predicate_or_wide_collector,
        LT::Leaf(LLeaf::LBrand("google")),
        row_groups: rgs,
 *
async fn run_large_partitioned(
 */
                pruning_predicates: std::sync::Arc::new(std::collections::HashMap::new()),
            LT::Leaf(LLeaf::LBrand("amazon")),
        sort_fields: vec![],
                status.value(i).to_string(),
// These exercise the Path C walker when it sees only Predicate leaves: every
// ══════════════════════════════════════════════════════════════════════
    LPriceGe(i32),
                cost_collector: 10,
        .build();
reference_test_large!(
            for c in children {
// Singleton match-ish: brand=amazon AND status=archived AND price=0.
        .target_partitions(partitions)
// universe (see `subtree_has_predicate` guard). Also varies how aggressively
// per-column range intersections.
    let want_brand: Option<&'static str> = match tag {
        ]),
        BoolNode::Collector { annotation_id } => {
        BoolNode::And(cs) | BoolNode::Or(cs) => cs.iter().for_each(|c| wire_large_rec(c, out)),
            None
            LT::Leaf(LLeaf::LBrand("apple")),
        .await
    ])
    large_narrow_predicate_top_5pct,
    };
// narrow predicate's page bitmap is interpreted wrong when AND'd with
fn reference_evaluator_large(tree: &LT, row: usize) -> Option<bool> {
reference_test_large!(
// Sanity: single-leaf collector on the large fixture.
        LT::Leaf(LLeaf::LBrand("amazon")),
    ])))
// Cross-RG amazon ∪ apple on 10k rows.
        Field::new("brand", DataType::Utf8, false),
        sort_orders: vec![],
    ])
        LLeaf::LBrand(b) => f.brands[row] == b,
reference_test_large!(
    }
        .indexed_pushdown_filters(false)
    let expected: Vec<usize> = (0..LARGE_N)
        .build();
                },
            ]),
        LT::Leaf(LLeaf::LStatus("archived")),
        sort_min: None,
//   * value-range variety (price in [-500, 1000], qty in [0, 200]).
                status.value(i).to_string(),
        let status = b.column(2).as_any().downcast_ref::<StringArray>().unwrap();
// negative/zero/positive prices). One shared parquet + cached arrays.
        LT::Leaf(LLeaf::LBrand("amazon")),
        .filter(|&r| reference_evaluator_large(&tree, r) == Some(true))
        .collect();
// NULL handling: qty is nullable. `qty >= 0` should exclude NULL rows (3VL).
    let f = large_fixture();
        global_base: 0,
        BoolNode::Predicate(_) => {}
        path,
        LT::Leaf(LLeaf::LBrand("amazon")),
    }));
// must still equal the single-partition reference evaluator answer.
                } else {
// Wide: price <0 OR price >=500 — matches ~70% of rows across every page.
        .indexed_pushdown_filters(false)
        datafusion::physical_expr::expressions::Literal::new(ScalarValue::Int32(Some(v))),
        LT::Leaf(LLeaf::LPriceEq(12345)),  // matches zero rows
    CELL.get_or_init(build_large_fixture)
            Arc::new(Int32Array::from(qtys.clone())),
        });
        LT::And(cs) => BoolNode::And(cs.iter().map(to_engine_tree_large).collect()),
    }
                    Some(true) => return Some(true),
        ArrowReaderMetadata::load(&file, ArrowReaderOptions::new().with_page_index(true)).unwrap();
                collector_strategy:
                &schema,
// page-pruning, many pages per RG get skipped before reaching Phase 2.
    let file = std::fs::File::open(&f.path).unwrap();
    let mut actual: Vec<usize> = Vec::with_capacity(rows.len());
        .filter(|&i| {
        pushdown_predicate: None,
        } else {
    LT::And(vec![
    match node {
    out
                tree: Arc::new(resolved),
    large_four_collectors_nested,
//! multi-partition fanout, and shapes that highlight future Phase-2
    let mut brands = Vec::with_capacity(LARGE_N);
    large_empty_via_contradiction,
        .collect();
// collector-only subtrees should use exact inversion (not the universe
    large_not_qty_lt_100,
        // Price in [-500, 1000) including 0.
    ])
);
    ])
        LT::Leaf(LLeaf::LQtyGe(50)),
        rgs.push(RowGroupInfo {
// NOT over collector-only AND. Uses the exact-inversion Phase-1 path.
        "multipartition_pred_only",
        Arc::new(move |segment, _chunk, _stream_metrics, _stats_prune_tree| {
        LT::Leaf(LLeaf::LBrand("apple")), // never matches alongside amazon → short-circuit
    let rows = run_large_partitioned(bt, collectors, partitions).await;
    LT::And(vec![
                Some(true)
        arrow_schema: schema.clone(),
    let qc = crate::datafusion_query_config::DatafusionQueryConfig::builder()
        }
    let right: Arc<dyn datafusion::physical_expr::PhysicalExpr> = Arc::new(
// collector bitmap.
    while let Some(batch) = stream.next().await {
        LLeaf::LPriceEq(v) => f.prices[row] == v,
            LLeaf::LQtyGe(v) => pred_large_int("qty", Operator::GtEq, *v),
        cancellation_token: None,
        ]),
    ])))
                schema.clone(),
    LCategory(&'static str),
        datafusion::physical_expr::expressions::Column::new(col, col_idx),
enum LT {
}
            LLeaf::LCategory(c) => pred_large_str("category", Operator::Eq, c),
        LT::Leaf(LLeaf::LCategory("books")),
// subsequent AND with a cheap collector should produce an empty result
reference_test_large!(
        sort_max: None,
        let brand = b.column(0).as_any().downcast_ref::<StringArray>().unwrap();
            } else {
        ],
        2 => Some("google"),
        .sql("SELECT brand, price, status, category, qty FROM t")
        Field::new("category", DataType::Utf8, false),
}
    LT::And(vec![
    ])
/// builds the matching mock collectors.
/// 3VL: None = UNKNOWN.
            assert_engine_matches_reference_large(stringify!($name), $tree).await;
        actual.len(),
        LT::Leaf(LLeaf::LPriceGe(500)),
        LT::Or(vec![
    .unwrap();
    LPriceLt(i32),
//
    ])
    LT::Not(Box::new(LT::Or(vec![
);
            LLeaf::LQtyEq(v) => pred_large_int("qty", Operator::Eq, *v),
// Collector intersect narrow predicate: catches any page-pruning bug where
        brands.push(brands_pool[(next() as usize) % brands_pool.len()]);
    let schema = meta.schema().clone();
        store_url: datafusion::execution::object_store::ObjectStoreUrl::local_filesystem(),
    ])
        #[tokio::test(flavor = "multi_thread", worker_threads = 2)]
// Complex mixed: (google OR samsung) AND price>=0 AND NOT(archived) AND qty<100
    ])
                tree: Arc::new(resolved),
reference_test_large!(large_price_lt_zero, LT::Leaf(LLeaf::LPriceLt(0)));
        datafusion::physical_expr::expressions::Column::new(col, col_idx),
        _ => None,
        LLeaf::LQtyGe(v) => return f.qtys[row].map(|q| q >= v),
// Negative, zero, positive boundaries on `price` (range -500..1000).
            let pruner = Arc::new(PagePruner::new(
    LT::Leaf(LLeaf::LPriceGe(900))
/// Lower `LT` to `BoolNode`. Collector leaves encode the brand/status tag
    let tree = Arc::new(tree);
        LT::Leaf(LLeaf::LStatus("active")),
        ]),
    let parquet_meta = meta.metadata().clone();
        .set_data_page_row_count_limit(512)
    LT::And(vec![
// ── Collector-only compound trees ────────────────────────────────────
    LT::Not(Box::new(LT::Or(vec![
        LLeaf::LPriceLt(v) => f.prices[row] < v,
        .target_partitions(1)
    );
// NULL row shouldn't match `qty = N` for any N.
    large_not_over_collectors_only_and,
    large_not_over_collectors_only_or,
);
/// add qty-nullable and negative-price cases.
                if qty.is_null(i) {
        global_base: 0,
        LT::Leaf(l) => reference_evaluator_large_leaf(*l, row),
        }
fn pred_large_int(col: &str, op: Operator, v: i32) -> BoolNode {
            index: i,
reference_test_large!(
fn large_collector_for(tag: u8) -> Arc<dyn RowGroupDocsCollector> {
        store: Arc::new(object_store::local::LocalFileSystem::new())
);
// Phase-2 short-circuit candidates — shapes where a future optimization
        datafusion::physical_expr::expressions::BinaryExpr::new(left, op, right),
            let eval: Arc<dyn RowGroupBitsetSource> = Arc::new(TreeBitsetSource {
// exercise exact inversion and bitset unions at RG scale.
                }
        let cat = b.column(3).as_any().downcast_ref::<StringArray>().unwrap();
// must trigger the streaming loop's "skip RG" branch (when `prefetch_rg`
    let col_idx = schema.index_of(col).expect("large column");
    large_or_collector_with_nullable_predicate,
        LT::Leaf(LLeaf::LStatus("archived")), // must still be registered in per_leaf
        actual.len(),
        .map(|(i, c)| (i as i32, c))
                annotation_id: match *s {
    let mut rgs = Vec::new();
/// OR: any TRUE → TRUE, else any UNKNOWN → UNKNOWN, else FALSE.
    // Map engine rows back to fixture indices by a tuple key. Duplicates are
    LT::Or(vec![
    large_and_three_wide_after_narrow,
        let per_leaf = per_leaf.clone();
//   * negative, zero, and positive prices,
        .set_max_row_group_size(2048)
// OR of three: wide first, then narrow and narrow. Short-circuit after
}
        name,
                && f.categories[r] == cat.as_str()
            LT::Leaf(LLeaf::LStatus("active")),
                    "apple" => 1,
        segments: vec![segment],
macro_rules! reference_test_large {
//! short-circuit opportunities.
            }
        store: Arc::new(object_store::local::LocalFileSystem::new())
            want_brand.map_or(true, |b| f.brands[i] == b)
        5 => Some("archived"),
    let matching: Vec<i32> = (0..LARGE_N)
        LLeaf::LStatus(s) => f.statuses[row] == s,
        LT::Leaf(LLeaf::LBrand("apple")),
        LT::And(vec![
        ]),
    LT::And(vec![
);
        .map(|(i, c)| (i as i32, c))
);
        })
            });
    ])
        3,
            } else {
// Three-collector AND (should intersect to roughly N/(4*2*2) ≈ 625 rows).
    let segment = SegmentFileInfo {
// Probably matches ~0-2 rows across all 5 RGs — most RGs produce 0
        offset += n;
        LT::And(vec![
//
    }
            LT::Leaf(LLeaf::LBrand("amazon")),
            LLeaf::LStatus(s) => BoolNode::Collector {
                page_pruner: pruner,
        x ^= x << 13;
        match found {
        .collect();
    let ctx = SessionContext::new();
//
            ));
/// 3VL evaluator. AND: any FALSE → FALSE, else any UNKNOWN → UNKNOWN, else TRUE.
        Field::new("price", DataType::Int32, false),
    let schema = meta.schema().clone();
    }
                brand.value(i).to_string(),
// ── Multi-partition runs ─────────────────────────────────────────────
);
    brands: Vec<&'static str>,
        LT::Leaf(LLeaf::LPriceGe(-1000)), // always true (page min is well above)
        LT::Leaf(LLeaf::LPriceGe(900)),
//
                cat.value(i).to_string(),
async fn large_multipartition_predicate_only() {
    let mut categories = Vec::with_capacity(LARGE_N);
/// Leaves specific to the large fixture. We reuse the engine machinery but
    let collectors = wire_large(&bt);
    let props = datafusion::parquet::file::properties::WriterProperties::builder()
    ])
}
    path: std::path::PathBuf,
    actual.sort();
                rg_index_to_pos: HashMap::new(),
            if any_unknown {
                cost_predicate: 1,
    let f = large_fixture();
    let (file, path) = tmp.keep().unwrap();
        parquet_size: size,
        LT::Leaf(LLeaf::LCategory("electronics")),
);
    ])
    .await;
            LT::Not(Box::new(LT::Leaf(LLeaf::LPriceLt(0)))),
);
) -> Vec<(String, i32, String, String, Option<i32>)> {
        5,
    ])))
        Field::new("status", DataType::Utf8, false),
    LT::And(vec![
}
/// Run a tree against the large fixture and compare to the 3VL reference evaluator.
        categories,
reference_test_large!(large_qty_eq_42, LT::Leaf(LLeaf::LQtyEq(42)));
);
        LT::Not(inner) => BoolNode::Not(Box::new(to_engine_tree_large(inner))),
// AND of three: narrow first, then wide and wide. Short-circuit would save
);
    LT::And(vec![
        let n = parquet_meta.row_group(i).num_rows();
// All other tests use num_partitions=1. These variants set N partitions
);
            let pruner = Arc::new(PagePruner::new(
            Ok(eval)
    let bt = to_engine_tree_large(&tree).push_not_down();
                collector_strategy:
    collectors: Vec<Arc<dyn RowGroupDocsCollector>>,
    )
        Field::new("status", DataType::Utf8, false),
        let per_leaf = per_leaf.clone();
        ArrowReaderMetadata::load(&file, ArrowReaderOptions::new().with_page_index(true)).unwrap();
        ]),
    partitions: usize,
            ));
            }
        LT::And(children) => {
                    _ => panic!("unknown brand {}", b),
//! per RG, nullable qty column, negative/zero/positive prices. Validates
    let ctx = SessionContext::new();
        pushdown_predicate: None,
        LT::Leaf(LLeaf::LPriceGe(0)),
        })
 * The OpenSearch Contributors require contributions made to
    }
                max_collector_parallelism: 1,
            for c in children {
        metadata: Arc::clone(&parquet_meta),
    let size = std::fs::metadata(&f.path).unwrap().len();
        statuses,
                Arc::clone(&segment.metadata),
        schema: schema.clone(),
    let provider = Arc::new(IndexedTableProvider::new(IndexedTableConfig {
    LT::And(vec![
                    Some(qty.value(i))
//   AND: acc is already all-false for the batch (any further AND stays false);
// Amazon ∩ active — must match across RGs.
    out
        LLeaf::LQtyEq(v) => return f.qtys[row].map(|q| q == v),
    LT::Not(Box::new(LT::Or(vec![
// ── Pure-predicate trees (no backend leaves) ──────────────────────────
    // Lower + run
    let qc = crate::datafusion_query_config::DatafusionQueryConfig::builder()
reference_test_large!(large_leaf_brand_amazon, LT::Leaf(LLeaf::LBrand("amazon")));
        arrow_schema: schema.clone(),
    large_not_pure_predicate,
// These tests lock in correctness for those shapes. A future optimization
    let right: Arc<dyn datafusion::physical_expr::PhysicalExpr> =
);
    while let Some(batch) = stream.next().await {
        ]),
// NOT over compound: NOT((amazon AND archived) OR (price < 0)).
            LT::Not(Box::new(LT::Leaf(LLeaf::LCategory("books")))),
        LT::Leaf(LLeaf::LBrand("amazon")),
    large_or_wide_then_narrow_collector,
        offset += n;
        max_doc: LARGE_N as i64,
        emit_row_ids: false,
                    "active" => 4,
    })
            LLeaf::LPriceEq(v) => pred_large_int("price", Operator::Eq, *v),
    let mut w = ArrowWriter::try_new(file, schema, Some(props)).unwrap();
        brands,
    let mut offset = 0i64;
        "multipartition_5",
    let meta =
                None
            let mut any_unknown = false;
                page_pruner: pruner,
                },
// Separate helpers from the 16-row fixture — reuses the same engine pipeline
fn pred_large_str(col: &str, op: Operator, v: &str) -> BoolNode {
        LT::Leaf(LLeaf::LPriceGe(800)),
reference_test_large!(
// Exercises RG-skip when the whole expression is vacuous.
                    None
                pruning_predicates: std::sync::Arc::new(std::collections::HashMap::new()),
// OR with nullable branch: amazon OR qty > 100.
//   OR : acc is already all-true  for the batch (any further OR  stays true).
        LT::Leaf(LLeaf::LBrand("amazon")), // large bitmap, wasted work today
    }
reference_test_large!(
            },
            LT::Leaf(LLeaf::LBrand("amazon")),
    let left: Arc<dyn datafusion::physical_expr::PhysicalExpr> = Arc::new(
    LargeFixture {
reference_test_large!(
//   * multiple row groups (2048 rows/RG → 5 RGs),
// No Predicate leaves → Phase 1 bitmaps are all exact. NOT over
            first_row: offset,
// NOT(pure-predicate). Must exercise the universe-fallback Phase 1 path
        LT::Or(vec![
    let factory: super::super::table_provider::EvaluatorFactory = {
    expected_sorted.sort();
        Field::new("brand", DataType::Utf8, false),
// ── Large-fixture tests ──────────────────────────────────────────────
    let mut prices = Vec::with_capacity(LARGE_N);
        x ^= x >> 7;
            Arc::new(StringArray::from(categories.clone())),
// siblings' bitmaps for Phase 2 lookup.
                    None
            as Arc<dyn object_store::ObjectStore>,
        ]),
                    Some(true) => {}
    large_not_or_three_collectors,
    ])))
        LT::Leaf(LLeaf::LQtyEq(0)),
// NULL qty rows that aren't amazon should NOT appear in result.
        let tree = Arc::clone(&tree);
                annotation_id: match *b {
);
///   * NULLs in qty propagate via 3VL; UNKNOWN rows must NOT appear in the
            });
                }
        .set_statistics_enabled(datafusion::parquet::file::properties::EnabledStatistics::Page)
                Arc::clone(&segment.metadata),
        query_config: std::sync::Arc::new(qc),
#[tokio::test(flavor = "multi_thread", worker_threads = 4)]
reference_test_large!(
}
fn wire_large(tree: &BoolNode) -> Vec<Arc<dyn RowGroupDocsCollector>> {
reference_test_large!(
        }
        LT::Leaf(LLeaf::LStatus("archived")),
    // Reference evaluator: rows where the tree evaluates to TRUE (UNKNOWN and FALSE excluded).
        ]),
    LT::And(vec![
        for i in 0..b.num_rows() {
        })
        LT::Not(inner) => reference_evaluator_large(inner, row).map(|b| !b),
//   * nullable `qty` column (about 10% NULL),
            LT::Leaf(LLeaf::LBrand("apple")),
                    "archived" => 5,
/// NOT(UNKNOWN) = UNKNOWN.
    w.write(&batch).unwrap();
        prices,
    // fine because rows are unique enough across columns.
// candidates and get skipped.
        prune_tree_config: None,
        let schema = schema.clone();
///     result set.
    assert_eq!(
reference_test_large!(
        LT::Leaf(LLeaf::LBrand("samsung")),
reference_test_large!(
    );
        }
}
    let mut out: Vec<Arc<dyn RowGroupDocsCollector>> = Vec::new();
    );
// touch most pages.
reference_test_large!(
fn wire_large_rec(node: &BoolNode, out: &mut Vec<Arc<dyn RowGroupDocsCollector>>) {
    // Predicates.
fn reference_evaluator_large_leaf(leaf: LLeaf, row: usize) -> Option<bool> {
            if any_unknown {
        parquet_size: size,
// so most pages get pruned in most RGs.
    };
        LT::Or(vec![
    let mut out = Vec::new();
            ScalarValue::Utf8(Some(v.to_string())),
    ])
        LT::Leaf(LLeaf::LBrand("amazon")), // ~25% of rows
        LT::Not(LT::Leaf(LLeaf::LPriceLt(-100)).into()),
    let tree = Arc::new(tree);
    let mut expected_sorted = expected.clone();
    ])
    LT::Not(Box::new(LT::Leaf(LLeaf::LQtyGe(100))))
        LT::Leaf(LLeaf::LBrand("apple")),
    LT::Leaf(LLeaf::LPriceLt(-10000))
// predicate's empty pages shouldn't suppress the collector's rows.
            let mut any_unknown = false;
                && f.prices[r] == *price
            None => panic!(
            LLeaf::LPriceLt(v) => pred_large_int("price", Operator::Lt, *v),
}
    w.close().unwrap();
    large_and_two_collectors,
        LT::Or(vec![
    ])
            out.push((
// page pruning can trim — narrow predicates land in ~1 page/RG, wide ones
        rows.len(),
    LT::Or(vec![
reference_test_large!(
    LT::And(vec![
                LT::Leaf(LLeaf::LBrand("apple")),
    ])
                cost_predicate: 1,
// sibling to verify it still gets registered for Phase 2.
                leaves: Arc::new(CollectorLeafBitmaps::without_metrics()),
reference_test_large!(large_qty_ge_zero, LT::Leaf(LLeaf::LQtyGe(0)));
        "multipartition_2",
// OR where the first predicate is wide enough to cover most batches. The
        statuses.push(statuses_pool[(next() as usize) % statuses_pool.len()]);
        });
        writer_generation: 0,
            LT::Leaf(LLeaf::LStatus("archived")),
);
// that checks acc.true_count()/null_count() per step must preserve results.
        let price = b.column(1).as_any().downcast_ref::<Int32Array>().unwrap();
            },
// and force the `QueryShardExec` fanout + UnionExec chain. Result set
        vec![
    for (brand, price, status, cat, qty) in &rows {
// earlier for collecting sibling collector bitmaps. Add a 3rd collector
            out.push(large_collector_for(tag));
        partitions,
                    "amazon" => 0,
reference_test_large!(
        LT::Or(vec![
        let found = (0..LARGE_N).find(|&r| {
        query_config: std::sync::Arc::new(qc),
        let schema = schema.clone();
        LLeaf::LPriceGe(v) => f.prices[row] >= v,
    let file = std::fs::File::open(&f.path).unwrap();
        "[{}] count mismatch: engine={} reference evaluator={}",
                cost_collector: 10,
        let tree = Arc::clone(&tree);
        evaluator_factory: factory,
        rgs.push(RowGroupInfo {
    out
        LT::Or(children) => {
        let n = parquet_meta.row_group(i).num_rows();
        2,
    }
        segments: vec![segment],
        sort_max: None,
);
            }
) -> Vec<(String, i32, String, String, Option<i32>)> {
    match tree {
        cancellation_token: None,
            Some((next() as i32).rem_euclid(201))
}
        LT::Leaf(LLeaf::LPriceEq(99_999)), // empty
    let df = ctx
// Uniform distribution → each RG has roughly equal proportion but with
        object_path: object_store::path::Path::from(f.path.to_string_lossy().as_ref()),
    assert_large_multipartition(
        });
                page_prune_metrics: None,
        expected.len()
}
            Ok(eval)
//
            num_rows: n,
    let mut out = Vec::new();
reference_test_large!(
    LT::And(vec![
    let mut next = || {
        sort_min: None,
        expected_sorted.len()
                    Some(false) => return Some(false),
    prices: Vec<i32>,
        LT::Leaf(LLeaf::LPriceGe(900)),    // narrow, few rows
reference_test_large!(
    categories: Vec<&'static str>,
}
        predicate_columns: vec![],
        Field::new("price", DataType::Int32, false),
        ));
        Field::new("qty", DataType::Int32, true),
// Triple AND of pure predicates; page pruning must combine multiple
            LT::Leaf(LLeaf::LBrand("google")),
// Amazon rows with NULL qty must be dropped (3VL AND).
    let size = std::fs::metadata(&f.path).unwrap().len();
    assert_eq!(actual, expected_sorted, "[{}] row set mismatch", name);
// ══════════════════════════════════════════════════════════════════════
    };
                name, brand, price, status, cat, qty
// NOT over collector-only OR — De Morgan equivalent to AND of NOTs.
        Field::new("qty", DataType::Int32, true),
                Some(false)
        LT::Leaf(LLeaf::LPriceGe(500))
//! Streaming-at-scale tests: 10 000 rows, 5 row groups with multiple pages
            as Arc<dyn object_store::ObjectStore>,
    ])
    tree: BoolNode,
    for i in 0..parquet_meta.num_row_groups() {
reference_test_large!(
    large_price_ge_max_out_of_range,
        LT::Leaf(LLeaf::LPriceLt(0)),
                page_prune_metrics: None,
        store_url: datafusion::execution::object_store::ObjectStoreUrl::local_filesystem(),
reference_test_large!(large_price_eq_zero, LT::Leaf(LLeaf::LPriceEq(0)));
                brand.value(i).to_string(),
        let status = b.column(2).as_any().downcast_ref::<StringArray>().unwrap();
        categories.push(categories_pool[(next() as usize) % categories_pool.len()]);
    ]))
        expected.len(),
        .unwrap();
        LT::Leaf(LLeaf::LPriceLt(500)),
                && f.statuses[r] == status.as_str()
        }
        BoolNode::Not(inner) => wire_large_rec(inner, out),
// regardless of evaluation order.
    ])
);
);
/// Two extra invariants tested vs the 16-row harness:
    LT::Or(vec![
            LT::Leaf(LLeaf::LBrand("amazon")),
            LT::Leaf(LLeaf::LPriceGe(500)),
    LT::And(vec![
);
                schema.clone(),
const LARGE_N: usize = 10_000;
    tree: BoolNode,
struct LargeFixture {
// brand=amazon AND brand=apple → empty per RG, triggering the fix I made
    }
        LT::Leaf(LLeaf::LPriceLt(500)),
                },
    let meta =
            LT::Leaf(LLeaf::LBrand("samsung")),
    LQtyEq(i32),
        1 => Some("apple"),
    // Deterministic pseudo-randomness (no rand crate).
        }
reference_test_large!(
}
        let brand = b.column(0).as_any().downcast_ref::<StringArray>().unwrap();
// first child saturates.
        schema: schema.clone(),
        LT::Leaf(LLeaf::LBrand("amazon")),
);
}
    let bt = to_engine_tree_large(&tree).push_not_down();
// Empty in Rust: price between two disjoint ranges in nested ANDs.
        LT::Leaf(LLeaf::LBrand("apple")),
    static CELL: OnceLock<LargeFixture> = OnceLock::new();
    let provider = Arc::new(IndexedTableProvider::new(IndexedTableConfig {
/// matching each leaf's tag byte to a fixture-specific mock collector.
async fn assert_large_multipartition(name: &str, tree: LT, partitions: usize) {
fn build_large_fixture() -> LargeFixture {
async fn large_multipartition_2() {
}
        });
// NOT(qty < 100): UNKNOWN propagates → row dropped. Reference evaluator catches it.
            ));
    ])
reference_test_large!(
        for i in 0..b.num_rows() {
    Arc::new(MockCollector { matching })
        ]),
);
    let per_leaf: Vec<(i32, Arc<dyn RowGroupDocsCollector>)> = collectors
    Leaf(LLeaf),
/// Build the provider + stream against the cached 10k fixture.
    ))
        let price = b.column(1).as_any().downcast_ref::<Int32Array>().unwrap();
); // matches none
            LLeaf::LPriceGe(v) => pred_large_int("price", Operator::GtEq, *v),
                    "samsung" => 3,
        .sql("SELECT brand, price, status, category, qty FROM t")
//! and wide predicates (exercises RG-skip when a row group has no matches),
        LT::Leaf(LLeaf::LPriceEq(0)),
                } else {
                match reference_evaluator_large(c, row) {
    let rows = run_large(bt, collectors).await;
        schema.clone(),
    wire_large_rec(tree, &mut out);
    LT::Not(Box::new(LT::And(vec![
    let f = large_fixture();
    LT::And(vec![
    for i in 0..parquet_meta.num_row_groups() {
    large_and_collector_with_nullable_predicate,
        metadata: Arc::clone(&parquet_meta),
