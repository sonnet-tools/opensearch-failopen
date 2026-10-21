                annotation_id: tag as i32,
        store_url: datafusion::execution::object_store::ObjectStoreUrl::local_filesystem(),
//
);
}
            Field::new("mostly_null_col", DataType::Int32, true),
        });
    let batch = RecordBatch::try_new(
        let rg = i / 1024;
 * this file be licensed under the Apache-2.0 license or a
    let size = std::fs::metadata(&f.path).unwrap().len();
        sort_max: None,
// ══════════════════════════════════════════════════════════════════════
        let per_leaf = per_leaf.clone();
}
}
    null_not_predicate_on_all_null_column,
    node: &BoolNode,
//! NULL in only some row groups, or present in some row groups and NULL
                &schema,
}
        emit_row_ids: false,
    }
    NT::Leaf(NullLeaf::Collector(vec![]))
    }
    mostly_null: Vec<Option<i32>>, // None in RG0,RG1; Some in RG2,RG3
    let tree = Arc::new(bt);
    Or(Vec<NT>),
        });
// Result == tag='even' rows (SQL 3VL: TRUE OR UNKNOWN = TRUE; UNKNOWN OR
        all_null.push(None);
    }
    ])
        object_path: object_store::path::Path::from(f.path.to_string_lossy().as_ref()),
    let mut count = 0;
    }
// 8. Collector matching only rows in RG2 (2048..3072). RGs 0,1,3 must skip.
        writer_generation: 0,
        Field::new("mostly_null_col", DataType::Int32, true),
    let (file, path) = tmp.keep().unwrap();
        ]))
    )
        tag,
        .unwrap();
        );
        NT::Leaf(l) => reference_evaluator_null_leaf(l, row),
        ))
        expected.len()
        Field::new("half_null_col", DataType::Int32, true),
            for c in cs {
    let provider = Arc::new(IndexedTableProvider::new(IndexedTableConfig {
            } else {
reference_test_null!(
            datafusion::physical_expr::expressions::Column::new(col, col_idx),
        NT::Leaf(NullLeaf::TagEq("even")),
            first_row: offset,
            }
        .into_iter()
// 2. NOT of a predicate on an all-NULL column. 3VL: NOT(UNKNOWN) = UNKNOWN →
macro_rules! reference_test_null {
// 7. Collector matching zero rows in the whole segment. Every RG's
        NT::Leaf(NullLeaf::HalfNullGe(0)),
    let bt = to_engine_tree_null(&tree, &mut seq).push_not_down();
            Arc::new(Int32Array::from(all_null.clone())),
            BoolNode::Collector {
    null_collector_empty_in_whole_segment,
    let mut matching_sets = Vec::new();
    let collectors = wire_null(&bt, &matching_sets);
#[derive(Debug)]
reference_test_null!(
}
        NT::Leaf(NullLeaf::AllNullGe(0)),
enum NT {
// different granularities.
            }
        }
        }
            let set = &matching_sets[tag];
 * SPDX-License-Identifier: Apache-2.0
        }
    let f = null_fixture();
        NullLeaf::HalfNullGe(v) => f.half_null[row].map(|x| x >= *v),
        .target_partitions(1)
    And(Vec<NT>),
            for c in cs {
            *coll_seq += 1;
        NT::And(cs) => {
    }
    match tree {
        NT::Leaf(NullLeaf::MostlyNullEq(v)) => pred_int_local("mostly_null_col", Operator::Eq, *v),
/// Lower `NT` to `BoolNode`. Collector leaves embed their DFS index as a
);
        path,
    NT::And(vec![
            datafusion::physical_expr::expressions::Literal::new(ScalarValue::Int32(Some(v))),
        NT::Not(inner) => BoolNode::Not(Box::new(to_engine_tree_null(inner, coll_seq))),
fn to_engine_tree_null(tree: &NT, coll_seq: &mut u8) -> BoolNode {
//! in others. Mock collectors are scoped to specific RG ranges so we can
    }
        })
    fn collect_packed_u64_bitset(
    let ctx = SessionContext::new();
        for &doc in &self.matching_rows {
                .collect(),
                page_prune_metrics: None,
fn wire_null(bt: &BoolNode, matching_sets: &[Vec<i32>]) -> Vec<Arc<dyn RowGroupDocsCollector>> {
                schema.clone(),
        NT::Leaf(NullLeaf::AllNullGe(0)),
    null_and_rg_scoped_collector_with_null_in_that_rg,
fn collect_matching_sets(tree: &NT, out: &mut Vec<Vec<i32>>) {
    NT::Or(vec![
        NullLeaf::AllNullGe(v) => f.all_null[row].map(|x| x >= *v),
// 1. Predicate against a column that is entirely NULL across all segments.
            }
    let per_leaf: Vec<(i32, Arc<dyn RowGroupDocsCollector>)> = collectors
                let rel = (doc - min_doc) as usize;
        BoolNode::Collector { annotation_id } => {
// prefetch_rg returns None → full segment skip, emits zero rows.
    half_null: Vec<Option<i32>>,   // None in RG0,RG2; Some in RG1,RG3
        Arc::new(Schema::new(vec![
                page_pruner: pruner,
    matching_sets: &[Vec<i32>],
            datafusion::physical_expr::expressions::BinaryExpr::new(left, op, right),
    let mut tag: Vec<&'static str> = Vec::with_capacity(NULL_N);
        Field::new("all_null_col", DataType::Int32, true),
reference_test_null!(
        NullLeaf::Collector(matching) => Some(matching.contains(&(row as i32))),
        ArrowReaderMetadata::load(&file, ArrowReaderOptions::new().with_page_index(true)).unwrap();
            let mut u = false;
                tree: Arc::new(resolved),
    ($name:ident, $tree:expr) => {
    static CELL: OnceLock<NullFixture> = OnceLock::new();
        half_null.push(if rg % 2 == 0 {
        name,
#[derive(Debug, Clone)]
        "[{}] count mismatch: engine={} reference evaluator={}",
        );
    ) -> Result<CollectDocsResult, String> {
            as Arc<dyn object_store::ObjectStore>,
            }
            Field::new("tag", DataType::Utf8, false),
        NT::Leaf(NullLeaf::TagEq(s)) => pred_str_local("tag", Operator::Eq, s),
    };
    NullFixture {
        NT::Leaf(_) => {}
        NT::Leaf(NullLeaf::Collector(set)) => out.push(set.clone()),
 */
//! test "collector empty in some RGs" alongside "predicate NULL in some
        metadata: Arc::clone(&parquet_meta),
        Arc::new(move |segment, _chunk, _stream_metrics, _stats_prune_tree| {
// rows in RG2 whose mostly_null_col >= 100.
    // Predicates against NULL-laden columns.
    }
        row_groups: rgs,
        tag.push(if i % 2 == 0 { "even" } else { "odd" });
    let segment = SegmentFileInfo {
        .filter(|&r| reference_evaluator_null(&tree, r) == Some(true))
    let mut stream = df.execute_stream().await.unwrap();
            }
}
        }
        half_null,
            num_rows: n,
// (RG2,RG3). RGs with no non-null pages should prune; RGs with data should
        .map(|(i, c)| (i as i32, c))
    while let Some(batch) = stream.next().await {
    wire_null_rec(bt, matching_sets, &mut out);
    fn null_schema() -> SchemaRef {
    let schema = meta.schema().clone();
    path: std::path::PathBuf,
// ── The tests ───────────────────────────────────────────────────────
// 10. Same shape but predicate hits a NULL-in-this-RG column: collector in
use super::*;
                cost_predicate: 1,
    null_predicate_on_mostly_null_column,
        NT::And(cs) => BoolNode::And(
        expected.len(),
        count,
    null_predicate_on_all_null_column,
// nothing in a whole RG" / "matches only in one RG" scenarios.
        NT::Leaf(NullLeaf::Collector((2048..3072).collect())),
                }
    };
        BoolNode::DelegationPossible { .. } => {}
        count,
        let col_idx = schema.index_of(col).expect("null column");
        parquet_size: size,
    let file = std::fs::File::open(&f.path).unwrap();
    let expected: Vec<usize> = (0..NULL_N)
            let pruner = Arc::new(PagePruner::new(
        .set_max_row_group_size(1024)
                    None => u = true,
            let tag = *coll_seq;
    w.write(&batch).unwrap();
    MostlyNullEq(i32),
// ══════════════════════════════════════════════════════════════════════
    match leaf {
            None
    );
);
            Some((i as i32) % 500)
// evaluate. Expected count: all rows in RG2,RG3 where mostly_null_col >= 0.
    let mut offset = 0i64;
/// single byte in `query_bytes`; `wire_null` uses that byte to look up
    fn pred_int_local(col: &str, op: Operator, v: i32) -> BoolNode {
    NT::Leaf(NullLeaf::Collector((2048..3072).collect()))
            datafusion::physical_expr::expressions::Column::new(col, col_idx),
        ))
reference_test_null!(
            ));
        .set_statistics_enabled(datafusion::parquet::file::properties::EnabledStatistics::Page)
        NT::Not(inner) => reference_evaluator_null(inner, row).map(|b| !b),
            }));
fn build_null_fixture() -> NullFixture {
/// the matching-set for the leaf.
                stats_prune_tree: None,
        let tree = Arc::clone(&tree);
            if doc >= min_doc && doc < max_doc {
) {
    let df = ctx
        let left: Arc<dyn datafusion::physical_expr::PhysicalExpr> = Arc::new(
            let eval: Arc<dyn RowGroupBitsetSource> = Arc::new(TreeBitsetSource {
// contributes nothing. Result: exactly the collector's matching rows.
    for i in 0..NULL_N {
            Arc::new(datafusion::physical_expr::expressions::Literal::new(
            if u {
            Arc::new(Int32Array::from(mostly_null.clone())),
            pred_int_local("mostly_null_col", Operator::GtEq, *v)
                match reference_evaluator_null(c, row) {
}
        let schema = schema.clone();
        ),
        mostly_null.push(if rg < 2 { None } else { Some((i as i32) % 200) });
            let mut u = false;
    let props = datafusion::parquet::file::properties::WriterProperties::builder()
        NullLeaf::MostlyNullGe(v) => f.mostly_null[row].map(|x| x >= *v),
    let factory: super::super::table_provider::EvaluatorFactory = {
    NT::Leaf(NullLeaf::AllNullGe(0))
        all_null,
                    None => u = true,
// 3. AND with an all-NULL predicate: tag='even' AND all_null >= 0 → 0 rows.
fn reference_evaluator_null_leaf(leaf: &NullLeaf, row: usize) -> Option<bool> {
// Rows | Layout
    };
}
    null_and_rg_scoped_collector_with_nullable_predicate,
);
    MostlyNullGe(i32),
        .await
        prune_tree_config: None,
    // Collectors: explicitly scoped to specific RGs via an absolute row set.
        sort_fields: vec![],
    NT::Not(Box::new(NT::Leaf(NullLeaf::AllNullGe(0))))
        evaluator_factory: factory,
    assert_eq!(
    HalfNullGe(i32),
    fn pred_str_local(col: &str, op: Operator, v: &str) -> BoolNode {
        .build();
    match tree {
        }
            Arc::new(Int32Array::from(half_null.clone())),
// Null-density fixture — 4096 rows, 4 RGs, columns deliberately NULL at
        }
        ),
    let mut out: Vec<Arc<dyn RowGroupDocsCollector>> = Vec::new();
reference_test_null!(
                max_collector_parallelism: 1,
    let meta =
        cancellation_token: None,
        NT::Leaf(NullLeaf::Collector((0..1024).step_by(7).collect())),
        NT::Leaf(NullLeaf::TagEq("even")),
// UNKNOWN = UNKNOWN, so non-even rows are UNKNOWN and get filtered out).
        .set_data_page_row_count_limit(256)
    Not(Box<NT>),
        segments: vec![segment],
                matching_rows: set.clone(),
// RG2, predicate on half_null_col (NULL in RG0+RG2, present in RG1+RG3).
    let mut seq = 0u8;
        NT::And(cs) | NT::Or(cs) => cs.iter().for_each(|c| collect_matching_sets(c, out)),
    ])
    let parquet_meta = meta.metadata().clone();
    NT::And(vec![
                    Some(true) => {}
    matching_rows: Vec<i32>, // absolute doc IDs to match
//! NULL-column edge cases: columns that are entirely NULL in a segment,
                leaves: Arc::new(CollectorLeafBitmaps::without_metrics()),
reference_test_null!(
    let mut mostly_null: Vec<Option<i32>> = Vec::with_capacity(NULL_N);
    let qc = crate::datafusion_query_config::DatafusionQueryConfig::builder()
    let tmp = NamedTempFile::new().unwrap();
        count += batch.unwrap().num_rows();
            cs.iter().for_each(|c| wire_null_rec(c, matching_sets, out))
    // Column caches for the reference evaluator.
        rgs.push(RowGroupInfo {
    }
fn reference_evaluator_null(tree: &NT, row: usize) -> Option<bool> {
            if u {
reference_test_null!(
            out.push(Arc::new(RgScopedCollector {
/// Leaf types for null-fixture tests.
        query_config: std::sync::Arc::new(qc),
        max_doc: i32,
fn wire_null_rec(
 *
                    Some(false) => return Some(false),
reference_test_null!(
        mostly_null,
                pruning_predicates: std::sync::Arc::new(std::collections::HashMap::new()),
        let schema = null_schema();
                    Some(true) => return Some(true),
            Ok(eval)
    NT::Leaf(NullLeaf::MostlyNullGe(0))
                .map(|c| to_engine_tree_null(c, coll_seq))
        #[tokio::test(flavor = "multi_thread", worker_threads = 2)]
        let span = (max_doc - min_doc) as usize;
    }
        NT::Or(cs) => {
            assert_engine_matches_reference_null(stringify!($name), $tree).await;
}
    null_mostly_null_no_match,
struct RgScopedCollector {
        NT::Leaf(NullLeaf::Collector((2048..3072).collect())),
}
        BoolNode::Predicate(Arc::new(
/// Collector that matches only rows in a specific RG range.
    match node {
        min_doc: i32,
            let resolved = tree.resolve(&per_leaf)?;
    all_null: Vec<Option<i32>>,    // always None
                Some(true)
        pushdown_predicate: None,
        BoolNode::Predicate(Arc::new(
fn null_fixture() -> &'static NullFixture {
    let mut rgs = Vec::new();
);
        let n = parquet_meta.row_group(i).num_rows();
        arrow_schema: schema.clone(),
                .collect(),
);
        async fn $name() {
        predicate_columns: vec![],
        let right: Arc<dyn datafusion::physical_expr::PhysicalExpr> =
            cs.iter()
        let schema = null_schema();
/// Walk `tree` in DFS order and build one `RgScopedCollector` per Collector
    let mut all_null: Vec<Option<i32>> = Vec::with_capacity(NULL_N);
    let f = null_fixture();
                Arc::clone(&segment.metadata),
    w.close().unwrap();
// Collector mocks can be scoped to specific RGs to test "collector matches
#[derive(Debug, Clone)]
    .unwrap();
        );
reference_test_null!(
                None
);
    ctx.register_table("t", provider).unwrap();
    CELL.get_or_init(build_null_fixture)
    collect_matching_sets(&tree, &mut matching_sets);
            Arc::new(StringArray::from(tag.clone())),
        NT::Or(cs) => BoolNode::Or(
        NT::Leaf(NullLeaf::HalfNullGe(v)) => pred_int_local("half_null_col", Operator::GtEq, *v),
        NullLeaf::MostlyNullEq(v) => f.mostly_null[row].map(|x| x == *v),
    ]));
        let col_idx = schema.index_of(col).expect("null column");
        vec![
                None
    out
        BoolNode::Predicate(_) => {}
        let left: Arc<dyn datafusion::physical_expr::PhysicalExpr> = Arc::new(
        .enumerate()
                .map(|c| to_engine_tree_null(c, coll_seq))
        BoolNode::And(cs) | BoolNode::Or(cs) => {
        global_base: 0,
                cost_collector: 10,
        sort_min: None,
    ])
        NullLeaf::TagEq(s) => Some(f.tag[row] == *s),
        .force_strategy(Some(FilterStrategy::BooleanMask))
        store: Arc::new(object_store::local::LocalFileSystem::new())
// mostly_null_col is present in RG2, so predicate applies normally. Result:
        let right: Arc<dyn datafusion::physical_expr::PhysicalExpr> = Arc::new(
}
/*
        NT::Leaf(NullLeaf::MostlyNullGe(100)),
        }
            datafusion::physical_expr::expressions::BinaryExpr::new(left, op, right),
    }
 * The OpenSearch Contributors require contributions made to
    let mut w = ArrowWriter::try_new(file, schema, Some(props)).unwrap();
    }));
            Field::new("all_null_col", DataType::Int32, true),
        NT::Leaf(NullLeaf::HalfNullGe(0)),
    AllNullGe(i32),
                collector_strategy:
struct NullFixture {
impl RowGroupDocsCollector for RgScopedCollector {
    out: &mut Vec<Arc<dyn RowGroupDocsCollector>>,
    match tree {
//! RGs" combinations that the random-distribution 10k fixture rarely hits.
    NT::And(vec![
        BoolNode::Not(inner) => wire_null_rec(inner, matching_sets, out),
    Collector(Vec<i32>),
                    Some(false) => {}
    null_and_with_all_null_predicate,
        max_doc: NULL_N as i64,
async fn assert_engine_matches_reference_null(name: &str, tree: NT) {
                    crate::indexed_table::eval::CollectorCallStrategy::TightenOuterBounds,
    tag: Vec<&'static str>,        // non-null always
        NT::Leaf(NullLeaf::Collector(_)) => {
// 3072..4096 (RG3): all_null_col NULL, mostly_null_col present, half_null_col present
    }
// RG2 has collector matches but predicate is all UNKNOWN → 0 rows.
    }
    ])
        }
 * compatible open source license.
// 9. AND between a collector in RG2 and a predicate that's NULL in RG2.
    ])
            });
//
/// leaf, looked up by the tag byte the leaf carries.
        NT::Leaf(NullLeaf::MostlyNullGe(v)) => {
);
        .collect();
    TagEq(&'static str),
            Field::new("half_null_col", DataType::Int32, true),
);
        let mut out = vec![0u64; span.div_ceil(64)];
    for i in 0..parquet_meta.num_row_groups() {
        .collect();
}
        NT::Leaf(NullLeaf::AllNullGe(v)) => pred_int_local("all_null_col", Operator::GtEq, *v),
}
                match reference_evaluator_null(c, row) {
// 0..1024  (RG0): all_null_col NULL, mostly_null_col NULL, half_null_col NULL
        schema.clone(),
    null_or_collector_rg0_with_null_predicate_rg0,
}
        offset += n;
// 4. OR with all-NULL predicate. tag='even' OR all_null >= 0.
        NT::Not(inner) => collect_matching_sets(inner, out),
                Some(false)
const NULL_N: usize = 4096;
        .build();
        &self,
        Ok(out.into())
        Field::new("tag", DataType::Utf8, false),
            cs.iter()
            ));
// 6. Predicate narrow against mostly-null column (no match in any page).
);
    null_or_with_all_null_predicate,
// expected 0 rows.
// 2048..3072 (RG2): all_null_col NULL, mostly_null_col present, half_null_col NULL
// 3VL: every row → UNKNOWN → expected 0 rows.
    }
);
                out[rel / 64] |= 1u64 << (rel % 64);
    NT::Or(vec![
    let schema = Arc::new(Schema::new(vec![
    NT::Leaf(NullLeaf::MostlyNullEq(10_000))
}
enum NullLeaf {
    Leaf(NullLeaf),
    null_collector_only_in_one_rg,
// 11. OR between a collector in RG0 (where its column is all NULL in parquet)
            } else {
            let tag = *annotation_id as usize;
    let mut half_null: Vec<Option<i32>> = Vec::with_capacity(NULL_N);
                evaluator: Arc::new(BitmapTreeEvaluator),
        } else {
                rg_index_to_pos: HashMap::new(),
                ScalarValue::Utf8(Some(v.to_string())),
            index: i,
        schema: schema.clone(),
// 5. Predicate on a column NULL in some RGs (RG0,RG1) + present in others
reference_test_null!(
        sort_orders: vec![],
// and a predicate on that NULL column: collector dominates, predicate
        .indexed_pushdown_filters(false)
                }
// 1024..2048 (RG1): all_null_col NULL, mostly_null_col NULL, half_null_col present
reference_test_null!(
            }
        .sql("SELECT tag, all_null_col, mostly_null_col, half_null_col FROM t")
        ],
