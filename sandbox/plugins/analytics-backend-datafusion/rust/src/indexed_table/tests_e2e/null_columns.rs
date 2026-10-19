            }
macro_rules! reference_test_null {
// ── The tests ───────────────────────────────────────────────────────
    let size = std::fs::metadata(&f.path).unwrap().len();
        NT::Leaf(NullLeaf::MostlyNullGe(100)),
);
            for c in cs {
    NT::Or(vec![
    let f = null_fixture();
            Field::new("all_null_col", DataType::Int32, true),
        sort_min: None,
}
//
}
                match reference_evaluator_null(c, row) {
 * this file be licensed under the Apache-2.0 license or a
    ])
        NT::Leaf(NullLeaf::AllNullGe(0)),
    static CELL: OnceLock<NullFixture> = OnceLock::new();
    null_or_collector_rg0_with_null_predicate_rg0,
//! in others. Mock collectors are scoped to specific RG ranges so we can
 * compatible open source license.
            Field::new("mostly_null_col", DataType::Int32, true),
    half_null: Vec<Option<i32>>,   // None in RG0,RG2; Some in RG1,RG3
    }
    null_predicate_on_all_null_column,
            Ok(eval)
        let n = parquet_meta.row_group(i).num_rows();
    let parquet_meta = meta.metadata().clone();
                    None => u = true,
            cs.iter()
    }
            pred_int_local("mostly_null_col", Operator::GtEq, *v)
    let qc = crate::datafusion_query_config::DatafusionQueryConfig::builder()
    NT::Or(vec![
// 11. OR between a collector in RG0 (where its column is all NULL in parquet)
    let mut half_null: Vec<Option<i32>> = Vec::with_capacity(NULL_N);
    let mut seq = 0u8;
            let mut u = false;
// Collector mocks can be scoped to specific RGs to test "collector matches
// expected 0 rows.
// and a predicate on that NULL column: collector dominates, predicate
            }
        ]))
                evaluator: Arc::new(BitmapTreeEvaluator),
) {
            Arc::new(Int32Array::from(mostly_null.clone())),
    }));
// 0..1024  (RG0): all_null_col NULL, mostly_null_col NULL, half_null_col NULL
            as Arc<dyn object_store::ObjectStore>,
        all_null.push(None);
// 1024..2048 (RG1): all_null_col NULL, mostly_null_col NULL, half_null_col present
        sort_max: None,
        let span = (max_doc - min_doc) as usize;
        count += batch.unwrap().num_rows();
    node: &BoolNode,
    }
        NT::Leaf(NullLeaf::MostlyNullGe(v)) => {
    let mut w = ArrowWriter::try_new(file, schema, Some(props)).unwrap();
reference_test_null!(
        .force_strategy(Some(FilterStrategy::BooleanMask))
        query_config: std::sync::Arc::new(qc),
        tag,
    let ctx = SessionContext::new();
//! NULL-column edge cases: columns that are entirely NULL in a segment,
        evaluator_factory: factory,
        for &doc in &self.matching_rows {
    let mut offset = 0i64;
    // Collectors: explicitly scoped to specific RGs via an absolute row set.
    fn collect_packed_u64_bitset(
// UNKNOWN = UNKNOWN, so non-even rows are UNKNOWN and get filtered out).
);
        expected.len(),
                match reference_evaluator_null(c, row) {
    NT::Leaf(NullLeaf::MostlyNullEq(10_000))
    null_not_predicate_on_all_null_column,
    );
            let mut u = false;
        NullLeaf::TagEq(s) => Some(f.tag[row] == *s),
        .await
    }
            datafusion::physical_expr::expressions::BinaryExpr::new(left, op, right),
    null_collector_only_in_one_rg,
        sort_fields: vec![],
        schema.clone(),
/*
        NT::Or(cs) => {
    for i in 0..NULL_N {
        NT::Leaf(l) => reference_evaluator_null_leaf(l, row),
    NT::Leaf(NullLeaf::AllNullGe(0))
        store: Arc::new(object_store::local::LocalFileSystem::new())
        BoolNode::Predicate(Arc::new(
fn reference_evaluator_null(tree: &NT, row: usize) -> Option<bool> {
    out: &mut Vec<Arc<dyn RowGroupDocsCollector>>,
                &schema,
);
//! RGs" combinations that the random-distribution 10k fixture rarely hits.
            ));
reference_test_null!(
            let tag = *annotation_id as usize;
        NullLeaf::HalfNullGe(v) => f.half_null[row].map(|x| x >= *v),
        .set_max_row_group_size(1024)
        NT::Leaf(NullLeaf::Collector((0..1024).step_by(7).collect())),
        NT::Leaf(NullLeaf::TagEq("even")),
reference_test_null!(
/// single byte in `query_bytes`; `wire_null` uses that byte to look up
reference_test_null!(
// 7. Collector matching zero rows in the whole segment. Every RG's
                ScalarValue::Utf8(Some(v.to_string())),
    let expected: Vec<usize> = (0..NULL_N)
        segments: vec![segment],
        pushdown_predicate: None,
        NT::Leaf(NullLeaf::TagEq("even")),
            for c in cs {
    null_and_rg_scoped_collector_with_null_in_that_rg,
// evaluate. Expected count: all rows in RG2,RG3 where mostly_null_col >= 0.
        name,
            datafusion::physical_expr::expressions::Literal::new(ScalarValue::Int32(Some(v))),
        NT::Leaf(_) => {}
    }
                .map(|c| to_engine_tree_null(c, coll_seq))
// RG2, predicate on half_null_col (NULL in RG0+RG2, present in RG1+RG3).
        count,
//! test "collector empty in some RGs" alongside "predicate NULL in some
            }));
        Field::new("half_null_col", DataType::Int32, true),
        NT::Leaf(NullLeaf::TagEq(s)) => pred_str_local("tag", Operator::Eq, s),
            if u {
    }
        rgs.push(RowGroupInfo {
        prune_tree_config: None,
        count,
        "[{}] count mismatch: engine={} reference evaluator={}",
        }
    MostlyNullEq(i32),
        sort_orders: vec![],
        NT::Leaf(NullLeaf::Collector((2048..3072).collect())),
    NT::Leaf(NullLeaf::Collector((2048..3072).collect()))
        writer_generation: 0,
// (RG2,RG3). RGs with no non-null pages should prune; RGs with data should
    null_or_with_all_null_predicate,
/// Leaf types for null-fixture tests.
        });
        NT::Leaf(NullLeaf::AllNullGe(v)) => pred_int_local("all_null_col", Operator::GtEq, *v),
        async fn $name() {
    null_collector_empty_in_whole_segment,
}
    let collectors = wire_null(&bt, &matching_sets);
// different granularities.
    null_mostly_null_no_match,
);
    CELL.get_or_init(build_null_fixture)
        arrow_schema: schema.clone(),
        BoolNode::And(cs) | BoolNode::Or(cs) => {
    w.write(&batch).unwrap();
// Null-density fixture — 4096 rows, 4 RGs, columns deliberately NULL at
            datafusion::physical_expr::expressions::BinaryExpr::new(left, op, right),
        metadata: Arc::clone(&parquet_meta),
        } else {
    matching_rows: Vec<i32>, // absolute doc IDs to match
        NT::And(cs) | NT::Or(cs) => cs.iter().for_each(|c| collect_matching_sets(c, out)),
        .indexed_pushdown_filters(false)
reference_test_null!(
        ],
// 10. Same shape but predicate hits a NULL-in-this-RG column: collector in
    AllNullGe(i32),
}
        Field::new("mostly_null_col", DataType::Int32, true),
        let mut out = vec![0u64; span.div_ceil(64)];
            Field::new("half_null_col", DataType::Int32, true),
        .filter(|&r| reference_evaluator_null(&tree, r) == Some(true))
// 2048..3072 (RG2): all_null_col NULL, mostly_null_col present, half_null_col NULL
            }
// Result == tag='even' rows (SQL 3VL: TRUE OR UNKNOWN = TRUE; UNKNOWN OR
        })
}
    };
        tag.push(if i % 2 == 0 { "even" } else { "odd" });
    NT::Leaf(NullLeaf::Collector(vec![]))
                .map(|c| to_engine_tree_null(c, coll_seq))
    let mut out: Vec<Arc<dyn RowGroupDocsCollector>> = Vec::new();
    ]));
);
    NT::Leaf(NullLeaf::MostlyNullGe(0))
reference_test_null!(
        let schema = null_schema();
        .collect();
            let resolved = tree.resolve(&per_leaf)?;
// prefetch_rg returns None → full segment skip, emits zero rows.
reference_test_null!(
// 8. Collector matching only rows in RG2 (2048..3072). RGs 0,1,3 must skip.
    )
#[derive(Debug, Clone)]
            ));
                leaves: Arc::new(CollectorLeafBitmaps::without_metrics()),
// 3VL: every row → UNKNOWN → expected 0 rows.
        Arc::new(Schema::new(vec![
fn to_engine_tree_null(tree: &NT, coll_seq: &mut u8) -> BoolNode {
                collector_strategy:
            Some((i as i32) % 500)
// 3. AND with an all-NULL predicate: tag='even' AND all_null >= 0 → 0 rows.
 * SPDX-License-Identifier: Apache-2.0
                cost_collector: 10,
            let eval: Arc<dyn RowGroupBitsetSource> = Arc::new(TreeBitsetSource {
}
        );
    mostly_null: Vec<Option<i32>>, // None in RG0,RG1; Some in RG2,RG3
    }
        NT::Leaf(NullLeaf::HalfNullGe(0)),
    NT::Not(Box::new(NT::Leaf(NullLeaf::AllNullGe(0))))
            Arc::new(Int32Array::from(all_null.clone())),
        Field::new("all_null_col", DataType::Int32, true),
                tree: Arc::new(resolved),
        });
    let tmp = NamedTempFile::new().unwrap();
    .unwrap();
reference_test_null!(
    let df = ctx
#[derive(Debug, Clone)]
    let file = std::fs::File::open(&f.path).unwrap();
        NT::Leaf(NullLeaf::Collector(_)) => {
            datafusion::physical_expr::expressions::Column::new(col, col_idx),
    match tree {
    NT::And(vec![
        mostly_null,
    ctx.register_table("t", provider).unwrap();
/// leaf, looked up by the tag byte the leaf carries.
    Or(Vec<NT>),
            BoolNode::Collector {
    null_and_with_all_null_predicate,
    let mut tag: Vec<&'static str> = Vec::with_capacity(NULL_N);
        .collect();
                matching_rows: set.clone(),
    let mut all_null: Vec<Option<i32>> = Vec::with_capacity(NULL_N);
                pruning_predicates: std::sync::Arc::new(std::collections::HashMap::new()),
fn wire_null(bt: &BoolNode, matching_sets: &[Vec<i32>]) -> Vec<Arc<dyn RowGroupDocsCollector>> {
        Field::new("tag", DataType::Utf8, false),
    path: std::path::PathBuf,
    };
    null_predicate_on_mostly_null_column,
            }
 */
            let pruner = Arc::new(PagePruner::new(
        }
        let right: Arc<dyn datafusion::physical_expr::PhysicalExpr> =
fn build_null_fixture() -> NullFixture {
        Ok(out.into())
impl RowGroupDocsCollector for RgScopedCollector {
reference_test_null!(
    while let Some(batch) = stream.next().await {
        NT::Leaf(NullLeaf::Collector((2048..3072).collect())),
        half_null.push(if rg % 2 == 0 {
// 6. Predicate narrow against mostly-null column (no match in any page).
fn wire_null_rec(
    w.close().unwrap();
 *
        let left: Arc<dyn datafusion::physical_expr::PhysicalExpr> = Arc::new(
                cost_predicate: 1,
    let batch = RecordBatch::try_new(
        }
    assert_eq!(
        NT::Not(inner) => collect_matching_sets(inner, out),
    out
    };
// ══════════════════════════════════════════════════════════════════════
    ])
// 4. OR with all-NULL predicate. tag='even' OR all_null >= 0.
        let col_idx = schema.index_of(col).expect("null column");
        .enumerate()
                page_pruner: pruner,
        store_url: datafusion::execution::object_store::ObjectStoreUrl::local_filesystem(),
);
    let props = datafusion::parquet::file::properties::WriterProperties::builder()
    let schema = Arc::new(Schema::new(vec![
            None
        let per_leaf = per_leaf.clone();
        let rg = i / 1024;
    let f = null_fixture();
        NT::And(cs) => BoolNode::And(
    fn pred_int_local(col: &str, op: Operator, v: i32) -> BoolNode {
    TagEq(&'static str),
        expected.len()
const NULL_N: usize = 4096;
            Arc::new(datafusion::physical_expr::expressions::Literal::new(
/// the matching-set for the leaf.
    for i in 0..parquet_meta.num_row_groups() {
// contributes nothing. Result: exactly the collector's matching rows.
        BoolNode::Collector { annotation_id } => {
            let set = &matching_sets[tag];
// rows in RG2 whose mostly_null_col >= 100.
        NT::Leaf(NullLeaf::HalfNullGe(v)) => pred_int_local("half_null_col", Operator::GtEq, *v),
        predicate_columns: vec![],
                annotation_id: tag as i32,
        let right: Arc<dyn datafusion::physical_expr::PhysicalExpr> = Arc::new(
async fn assert_engine_matches_reference_null(name: &str, tree: NT) {
fn null_fixture() -> &'static NullFixture {
        .map(|(i, c)| (i as i32, c))
        BoolNode::Not(inner) => wire_null_rec(inner, matching_sets, out),
// nothing in a whole RG" / "matches only in one RG" scenarios.
        schema: schema.clone(),
        NullLeaf::Collector(matching) => Some(matching.contains(&(row as i32))),
}
        NT::Leaf(NullLeaf::HalfNullGe(0)),
    let bt = to_engine_tree_null(&tree, &mut seq).push_not_down();
    Leaf(NullLeaf),
        ))
            Field::new("tag", DataType::Utf8, false),
        BoolNode::DelegationPossible { .. } => {}
        NT::Leaf(NullLeaf::AllNullGe(0)),
    ) -> Result<CollectDocsResult, String> {
    match leaf {
                None
            out.push(Arc::new(RgScopedCollector {
        .target_partitions(1)
            let tag = *coll_seq;
            num_rows: n,
                    Some(false) => {}
            cs.iter()
        Arc::new(move |segment, _chunk, _stream_metrics, _stats_prune_tree| {
/// Lower `NT` to `BoolNode`. Collector leaves embed their DFS index as a
    null_and_rg_scoped_collector_with_nullable_predicate,
        }
    Not(Box<NT>),
    let segment = SegmentFileInfo {
    let schema = meta.schema().clone();
    ])
        }
    tag: Vec<&'static str>,        // non-null always
        NT::Not(inner) => reference_evaluator_null(inner, row).map(|b| !b),
    let meta =
            Arc::new(Int32Array::from(half_null.clone())),
struct RgScopedCollector {
}
        ),
        }
    fn null_schema() -> SchemaRef {
    }
                    Some(true) => return Some(true),
    let (file, path) = tmp.keep().unwrap();
        path,
/// Collector that matches only rows in a specific RG range.
// mostly_null_col is present in RG2, so predicate applies normally. Result:
    // Column caches for the reference evaluator.
    match node {
                Arc::clone(&segment.metadata),
    fn pred_str_local(col: &str, op: Operator, v: &str) -> BoolNode {
);
    let mut mostly_null: Vec<Option<i32>> = Vec::with_capacity(NULL_N);
        mostly_null.push(if rg < 2 { None } else { Some((i as i32) % 200) });
        NT::Leaf(NullLeaf::Collector(set)) => out.push(set.clone()),
    }
                Some(false)
        let schema = null_schema();
            if u {
        let left: Arc<dyn datafusion::physical_expr::PhysicalExpr> = Arc::new(
        #[tokio::test(flavor = "multi_thread", worker_threads = 2)]
    }
// 3072..4096 (RG3): all_null_col NULL, mostly_null_col present, half_null_col present
}
        min_doc: i32,
            } else {
    match tree {
            }
                    Some(true) => {}
    }
fn collect_matching_sets(tree: &NT, out: &mut Vec<Vec<i32>>) {
    NT::And(vec![
    matching_sets: &[Vec<i32>],
        cancellation_token: None,
fn reference_evaluator_null_leaf(leaf: &NullLeaf, row: usize) -> Option<bool> {
        .unwrap();
enum NullLeaf {
        parquet_size: size,
        .into_iter()
    ])
        emit_row_ids: false,
                .collect(),
                out[rel / 64] |= 1u64 << (rel % 64);
        row_groups: rgs,
                page_prune_metrics: None,
            datafusion::physical_expr::expressions::Column::new(col, col_idx),
                }
reference_test_null!(
        NT::Leaf(NullLeaf::MostlyNullEq(v)) => pred_int_local("mostly_null_col", Operator::Eq, *v),
    let provider = Arc::new(IndexedTableProvider::new(IndexedTableConfig {
        ),
                .collect(),
}
        ArrowReaderMetadata::load(&file, ArrowReaderOptions::new().with_page_index(true)).unwrap();
        }
        NullLeaf::MostlyNullEq(v) => f.mostly_null[row].map(|x| x == *v),
        NT::Or(cs) => BoolNode::Or(
);
}
);
            Arc::new(StringArray::from(tag.clone())),
                let rel = (doc - min_doc) as usize;
    let mut matching_sets = Vec::new();
 * The OpenSearch Contributors require contributions made to
        .build();
        }
                stats_prune_tree: None,
reference_test_null!(
use super::*;
    }
                }
    wire_null_rec(bt, matching_sets, &mut out);
    // Predicates against NULL-laden columns.
// 2. NOT of a predicate on an all-NULL column. 3VL: NOT(UNKNOWN) = UNKNOWN →
// ══════════════════════════════════════════════════════════════════════
        BoolNode::Predicate(_) => {}
    And(Vec<NT>),
        global_base: 0,
            if doc >= min_doc && doc < max_doc {
    let mut stream = df.execute_stream().await.unwrap();
        .set_data_page_row_count_limit(256)
        );
        .build();
            assert_engine_matches_reference_null(stringify!($name), $tree).await;
    let factory: super::super::table_provider::EvaluatorFactory = {
#[derive(Debug)]
        max_doc: i32,
                rg_index_to_pos: HashMap::new(),
            cs.iter().for_each(|c| wire_null_rec(c, matching_sets, out))
    NT::And(vec![
// RG2 has collector matches but predicate is all UNKNOWN → 0 rows.
// 1. Predicate against a column that is entirely NULL across all segments.
                Some(true)
);
            *coll_seq += 1;
    HalfNullGe(i32),
        NullLeaf::MostlyNullGe(v) => f.mostly_null[row].map(|x| x >= *v),
    let per_leaf: Vec<(i32, Arc<dyn RowGroupDocsCollector>)> = collectors
                schema.clone(),
        &self,
        ))
}
// Rows | Layout
        BoolNode::Predicate(Arc::new(
enum NT {
//
                None
                max_collector_parallelism: 1,
        all_null,
        half_null,
            });
        let col_idx = schema.index_of(col).expect("null column");
        let tree = Arc::clone(&tree);
            } else {
    let mut count = 0;
}
        );
        .sql("SELECT tag, all_null_col, mostly_null_col, half_null_col FROM t")
        let schema = schema.clone();
        .set_statistics_enabled(datafusion::parquet::file::properties::EnabledStatistics::Page)
// 5. Predicate on a column NULL in some RGs (RG0,RG1) + present in others
}
            }
    ($name:ident, $tree:expr) => {
}
    Collector(Vec<i32>),
            index: i,
        NT::Not(inner) => BoolNode::Not(Box::new(to_engine_tree_null(inner, coll_seq))),
                    crate::indexed_table::eval::CollectorCallStrategy::TightenOuterBounds,
);
        object_path: object_store::path::Path::from(f.path.to_string_lossy().as_ref()),
    MostlyNullGe(i32),
                    None => u = true,
struct NullFixture {
    all_null: Vec<Option<i32>>,    // always None
    let mut rgs = Vec::new();
    NullFixture {
            first_row: offset,
//! NULL in only some row groups, or present in some row groups and NULL
        max_doc: NULL_N as i64,
    }
        offset += n;
        NullLeaf::AllNullGe(v) => f.all_null[row].map(|x| x >= *v),
        NT::And(cs) => {
        vec![
    collect_matching_sets(&tree, &mut matching_sets);
                    Some(false) => return Some(false),
    match tree {
/// Walk `tree` in DFS order and build one `RgScopedCollector` per Collector
    let tree = Arc::new(bt);
    ])
// 9. AND between a collector in RG2 and a predicate that's NULL in RG2.
