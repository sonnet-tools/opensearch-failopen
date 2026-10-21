            first_row: offset,
        rgs.push(RowGroupInfo {
    // solo selection (the missing-column clause is unknown → it can
                cost_predicate: 1,
    let mut name = Vec::with_capacity(MISSING_N);
// contributes only "unknown" per grid cell, so it can neither add nor
    let combined: std::sync::Arc<dyn datafusion::physical_expr::PhysicalExpr> =
    let ctx = SessionContext::new();
    let drift_schema = schema_with_missing();
#[tokio::test(flavor = "multi_thread", worker_threads = 2)]
    assert_eq!(run_missing_col_tree(tree).await, 0);
//! segment's parquet file. Common when a mapping added the field after
        .indexed_pushdown_filters(false)
        Field::new("score", DataType::Int32, false),
    ))
        global_base: 0,
                    crate::indexed_table::eval::CollectorCallStrategy::TightenOuterBounds,
    w.write(batch).unwrap();
    let pp_solo = build_pruning_predicate(&score_lt, drift_schema.clone())
/// Run a tree whose predicates may reference `missing_col` (not in parquet
// 1. Predicate on missing column -> all UNKNOWN -> 0 rows.
        pred_missing_str("name", Operator::Eq, "foo"),
    let f = missing_col_fixture();
        datafusion::physical_expr::expressions::Literal::new(ScalarValue::Int32(Some(v))),
                Arc::clone(&segment.metadata),
        .target_partitions(1)
    let (file, path) = tmp.keep().unwrap();
    assert_eq!(count, 4);
}
            (Some(s), Some(c)) => {
        name.push(if i % 2 == 0 { "foo" } else { "bar" });
                Arc::clone(&segment.metadata),
fn missing_col_fixture() -> &'static MissingColFixture {
    let col_idx = schema.index_of(col).expect("column in local schema");
struct MissingColFixture {
async fn run_missing_col_tree(tree_bool: BoolNode) -> usize {
    let col_idx = schema.index_of(col).expect("column in local schema");
        ],
    let segment = SegmentFileInfo {
// remove page selections beyond what the existing column decides.
        .count();
                let solo_kept: usize = s.iter().filter(|r| !r.skip).map(|r| r.row_count).sum();
        datafusion::physical_expr::expressions::BinaryExpr::new(score_col, Operator::Lt, lit_100),
    let tmp = NamedTempFile::new().unwrap();
                leaves: Arc::new(CollectorLeafBitmaps::without_metrics()),
    let segment = SegmentFileInfo {
    let tmp = NamedTempFile::new().unwrap();
        sort_fields: vec![],
    // cycle → some pages will be prunable).
        store: Arc::new(object_store::local::LocalFileSystem::new())
        let tree = Arc::clone(&tree);
    // returned `Some`), that's the pre-fix regression we're guarding
fn not_pred(p: BoolNode) -> BoolNode {
// `None` whenever any referenced column was absent from the parquet
        BoolNode::And(vec![
                max_collector_parallelism: 1,
 * this file be licensed under the Apache-2.0 license or a
// column lookup on the RecordBatch returns None and our product code
// File has Utf8 columns; table schema declares Utf8View.
            .await;
}
    );
    let schema = Arc::new(Schema::new(vec![
        });
        .iter()
        ));
        pushdown_predicate: None,
    let file = std::fs::File::open(&f.path).unwrap();
        pred_missing_int("missing_col", Operator::Eq, 42),
            first_row: offset,
        Field::new("city", DataType::Utf8View, false),
    .unwrap();
    let parquet_meta = meta.metadata().clone();
}
    let missing_col: std::sync::Arc<dyn datafusion::physical_expr::PhysicalExpr> =
        rgs.push(RowGroupInfo {
        std::sync::Arc::new(datafusion::physical_expr::expressions::Column::new(
    )
        Field::new("name", DataType::Utf8, false),
    ]));
            pred_missing_int("score", Operator::Lt, 500),
    let lit_100: std::sync::Arc<dyn datafusion::physical_expr::PhysicalExpr> = std::sync::Arc::new(
#[tokio::test(flavor = "multi_thread", worker_threads = 2)]
    static CELL: OnceLock<MissingColFixture> = OnceLock::new();
// 3. AND(existing, missing): all rows UNKNOWN via missing branch -> 0.
    ]));
            ));
    };
}
        ));
    count
            });
    .unwrap();
        .filter(|n| **n == "foo")
    let schema = schema_with_missing();
// 4. OR(existing, missing): existing branch dominates. Expected = name='foo'
) -> usize {
        std::sync::Arc::new(datafusion::physical_expr::expressions::BinaryExpr::new(
// Pre-fix, this assertion failed because `prune_rg` bailed out to
    let ctx = SessionContext::new();
                    rg_idx,
fn pred_missing_str(col: &str, op: Operator, v: &str) -> BoolNode {
    let props = datafusion::parquet::file::properties::WriterProperties::builder()
/// UNKNOWN) per its normal semantics.
        writer_generation: 0,
        let n = parquet_meta.row_group(i).num_rows();
    let df = ctx.sql("SELECT name, score FROM t").await.unwrap();
    }
/// PhysicalExprs that reference a column absent from the parquet file.
            (Some(_), None) => {
    file_schema: SchemaRef,
        let tree = Arc::clone(&tree);
    MissingColFixture { path, name, score }
        .build();
    let df = ctx.sql("SELECT * FROM t").await.unwrap();
// 5. Nested: (name='foo' AND score<500) OR (missing_col=42). The missing_col
        segments: vec![segment],
    }
    let (file, path) = tmp.keep().unwrap();
        Arc::new(datafusion::physical_expr::expressions::Literal::new(
                pruning_predicates: std::sync::Arc::new(std::collections::HashMap::new()),
            "missing_col",
        parquet_size: size,
            missing_col,
async fn missing_col_and_with_existing_returns_zero() {
        store_url: datafusion::execution::object_store::ObjectStoreUrl::local_filesystem(),
                    "rg {}: combined selection kept {} rows, solo kept {} — \
        .count();
    );
    // caused the pruner to bail out (returning `None` where solo
}
    let meta =
    let right: Arc<dyn datafusion::physical_expr::PhysicalExpr> = Arc::new(
        Field::new("score", DataType::Int32, false),
        query_config: std::sync::Arc::new(qc),
            let pruner = Arc::new(PagePruner::new(
}
    for i in 0..parquet_meta.num_row_groups() {
    batch: &RecordBatch,
        query_with_mismatched_schema(file_schema, table_schema, &batch, tautology_int("score", 2))
        schema: table_schema,
async fn utf8view_schema_with_utf8_file_does_not_panic() {
        .filter(|&i| f.name[i] == "foo" && f.score[i] < 500)
            num_rows: n,
    // only downgrade, never add rows). If the combined predicate
            Operator::Gt,
        Field::new("brand", DataType::Utf8, false),
fn build_missing_col_fixture() -> MissingColFixture {
    assert_eq!(run_missing_col_tree(tree).await, expected);
    let mut w = ArrowWriter::try_new(file, schema, Some(props)).unwrap();
                let combined_kept: usize = c.iter().filter(|r| !r.skip).map(|r| r.row_count).sum();
                evaluator: Arc::new(BitmapTreeEvaluator),
 */
        arrow_schema: meta.schema().clone(),
    BoolNode::Predicate(Arc::new(
// existing-column predicate alone — the missing-column clause
        max_doc: batch.num_rows() as i64,
        store: Arc::new(object_store::local::LocalFileSystem::new())
    }
}
                rg_index_to_pos: HashMap::new(),
        Field::new("brand", DataType::Utf8, false),
        ));
        file_schema.clone(),
    let left: Arc<dyn datafusion::physical_expr::PhysicalExpr> = Arc::new(
        object_path: object_store::path::Path::from(path.to_string_lossy().as_ref()),
        file_schema.clone(),
/*
                     missing-column clause must not add rows",
    let file = std::fs::File::open(&f.path).unwrap();
    let rfile = std::fs::File::open(&path).unwrap();
    score: Vec<i32>,
        .set_max_row_group_size(256)
/// Build a tautology predicate: `col >= 0` (always true for non-negative int columns).
/// The evaluator's refinement stage handles the missing column (emits
    let size = std::fs::metadata(&f.path).unwrap().len();
                cost_collector: 10,
    let mut w = ArrowWriter::try_new(file, file_schema, Some(props)).unwrap();
    let provider = Arc::new(IndexedTableProvider::new(IndexedTableConfig {
        Field::new("pop", DataType::Int32, false),
    let tree = BoolNode::Or(vec![
        .force_strategy(Some(FilterStrategy::BooleanMask))
                cost_collector: 10,
                );
/// table schema, run `SELECT * FROM t`, return row count.
        pred_missing_int("missing_col", Operator::GtEq, 0),
    BoolNode::Predicate(Arc::new(
        datafusion::physical_expr::expressions::Literal::new(ScalarValue::Int32(Some(0))),
        datafusion::physical_expr::expressions::Literal::new(ScalarValue::Int32(Some(100))),
    table_schema: SchemaRef,
            .await;
    p
// Without force_view_types(false), panics with "byte view array".
/// `col_idx` is the column's position in the table schema.
        prune_tree_config: None,
    let missing_gt: std::sync::Arc<dyn datafusion::physical_expr::PhysicalExpr> =
                    "rg {}: pruner bailed out on combined predicate despite \
fn schema_with_missing() -> SchemaRef {
                page_prune_metrics: None,
    let schema = schema_with_missing();
        schema: schema.clone(),
    let tree = not_pred(pred_missing_int("missing_col", Operator::GtEq, 0));
                tree: Arc::new(resolved),
    // so ~10% of rows match, concentrated at the start of every 1000-row
/// schema). Returns the row count the engine emits.
async fn missing_col_not_predicate_returns_zero_rows() {
        .build();
    let table_schema = Arc::new(Schema::new(vec![
const MISSING_N: usize = 2048;
    name: Vec<&'static str>,
        datafusion::physical_expr::expressions::BinaryExpr::new(left, Operator::GtEq, right),
        ]),
    let left: Arc<dyn datafusion::physical_expr::PhysicalExpr> = Arc::new(
/// Generic helper: write a parquet file, register with a (possibly different)
    let file_schema = Arc::new(Schema::new(vec![
    // grid cell → AND combines as "score<100 AND unknown".
    let mut rgs = Vec::new();
        predicate_columns: vec![],
            Operator::And,
        let combined = pruner.prune_rg(&pp_combined, rg_idx, None);
        Field::new("name", DataType::Utf8, false),
        predicate_columns: vec![],
    // Existing-column predicate: score < 100 (fixture has score = i % 1000
    count
//! Schema drift — predicates referencing columns that are absent from a
            });
            let resolved = tree.resolve(&[])?;
        vec![
}
        query_config: std::sync::Arc::new(qc),
    let f = missing_col_fixture();
    let expected = missing_col_fixture()
fn only_pred(p: BoolNode) -> BoolNode {
    let batch = RecordBatch::try_new(
    let mut count = 0;
        sort_min: None,
    let tree = only_pred(pred_missing_int("missing_col", Operator::GtEq, 0));
                page_prune_metrics: None,
    let batch = RecordBatch::try_new(
    );
        score.push((i as i32) % 1000);
        let schema = schema.clone();
            Ok(eval)
    let mut score = Vec::with_capacity(MISSING_N);
#[tokio::test(flavor = "multi_thread", worker_threads = 2)]
    for rg_idx in 0..meta.metadata().num_row_groups() {
    let schema = meta.schema().clone();
                evaluator: Arc::new(BitmapTreeEvaluator),
    assert_eq!(run_missing_col_tree(tree).await, 0);
        pred_missing_str("name", Operator::Eq, "foo"),
    assert_eq!(run_missing_col_tree(tree).await, expected);
                collector_strategy:
// Missing-column fixture — parquet written without a column that the
    ))
 *
// 2. NOT(missing-col predicate) -> UNKNOWN -> 0 rows.
    let mut offset = 0i64;
        ArrowReaderMetadata::load(&file, ArrowReaderOptions::new().with_page_index(true)).unwrap();
            Arc::new(Int32Array::from(score.clone())),
    // column has all-null stats → clause evaluates to unknown per
    w.close().unwrap();
fn tautology_int(col: &str, col_idx: usize) -> BoolNode {
// File has (name, score, brand); table schema is (brand, name, score).
    let meta =
        emit_row_ids: false,
fn pred_missing_int(col: &str, op: Operator, v: i32) -> BoolNode {
    use crate::indexed_table::page_pruner::{build_pruning_predicate, PagePruner};
//
    // against.
#[tokio::test(flavor = "multi_thread", worker_threads = 2)]
                panic!(
        emit_row_ids: false,
    );
                stats_prune_tree: None,
        .expect("combined predicate not always_true");
            _ => {}
    ctx.register_table("t", provider).unwrap();
#[tokio::test(flavor = "multi_thread", worker_threads = 2)]
            Arc::new(StringArray::from(vec!["acme", "globex", "acme", "globex"])),
        ArrowReaderMetadata::load(&rfile, ArrowReaderOptions::new().with_page_index(true)).unwrap();
    // RG, the combined selection must keep at most as many rows as the
// row count (half of MISSING_N).
        Arc::new(move |segment, _chunk, _stream_metrics, _stats_prune_tree| {
use super::*;
    let right: Arc<dyn datafusion::physical_expr::PhysicalExpr> = Arc::new(
        std::sync::Arc::new(datafusion::physical_expr::expressions::Column::new(
        std::sync::Arc::new(datafusion::physical_expr::expressions::BinaryExpr::new(
        ));
async fn query_with_mismatched_schema(
    let qc = crate::datafusion_query_config::DatafusionQueryConfig::builder()
    ))
}
        schema.clone(),
    CELL.get_or_init(build_missing_col_fixture)
                schema.clone(),
// 6. Page pruner direct invariant: a predicate that ANDs an existing
                cost_predicate: 1,
}
#[tokio::test(flavor = "multi_thread", worker_threads = 2)]
    let table_schema = Arc::new(Schema::new(vec![
        ));
    assert_eq!(count, 4);
                     present column — missing-column fix regression",
    let factory: super::super::table_provider::EvaluatorFactory = {
#[tokio::test(flavor = "multi_thread", worker_threads = 2)]
    ]));
        let schema = table_schema.clone();
    let mut count = 0;
// added the field: parquet literally has no such column, so Phase 2's
    BoolNode::Not(Box::new(p))
                tree: Arc::new(resolved),
    assert_eq!(run_missing_col_tree(tree).await, 0);
    }
        Field::new("score", DataType::Int32, false),
    let score_col: std::sync::Arc<dyn datafusion::physical_expr::PhysicalExpr> =
    };
}
        metadata: Arc::clone(&parquet_meta),
    let mut rgs = Vec::new();
                    crate::indexed_table::eval::CollectorCallStrategy::TightenOuterBounds,
    let count =
    // Parquet schema intentionally excludes `missing_col`.
        pred_missing_int("missing_col", Operator::GtEq, 0),
}
    }
    };
    let qc = crate::datafusion_query_config::DatafusionQueryConfig::builder()
        writer_generation: 0,
    // Column caches — only for columns actually in the parquet.
        .build();
            }
            ScalarValue::Utf8(Some(v.to_string())),
                );
            Arc::new(Int32Array::from(vec![10, 20, 30, 40])),
            as Arc<dyn object_store::ObjectStore>,
        offset += n;
}
    for i in 0..MISSING_N {
        ],
            lit_0,
        .set_statistics_enabled(datafusion::parquet::file::properties::EnabledStatistics::Page)
        parquet_size: size,
    );
// ══════════════════════════════════════════════════════════════════════
    let tree = Arc::new(tree_bool);
        .set_max_row_group_size(512)
    let props = datafusion::parquet::file::properties::WriterProperties::builder()
    let factory: super::super::table_provider::EvaluatorFactory = {
        Arc::new(move |segment, _chunk, _stream_metrics, _stats_prune_tree| {
    ]));
        sort_max: None,
    ]);
        prune_tree_config: None,
        .set_data_page_row_count_limit(128)
    let left: Arc<dyn datafusion::physical_expr::PhysicalExpr> = Arc::new(
// column with a missing column must prune identically to the
    while let Some(b) = stream.next().await {
                schema.clone(),
            Ok(eval)
    let batch = RecordBatch::try_new(
    ctx.register_table("t", provider).unwrap();
        offset += n;
        Field::new("name", DataType::Utf8, false),
            }
    let right: Arc<dyn datafusion::physical_expr::PhysicalExpr> =
    let tree = BoolNode::Or(vec![
        sort_orders: vec![],
            let resolved = tree.resolve(&[])?;
        .target_partitions(1)
            let pruner = Arc::new(PagePruner::new(
    let mut stream = df.execute_stream().await.unwrap();
    );
                stats_prune_tree: None,
async fn reorder_columns_aligned_and_filtered() {
    let pruner = PagePruner::new(&drift_schema, meta.metadata().clone(), drift_schema.clone());
        evaluator_factory: factory,
        .expect("score<100 is not always_true on this fixture");
//! segment evaluates to UNKNOWN for that predicate and gets filtered out.
async fn missing_col_predicate_returns_zero_rows() {
            let eval: Arc<dyn RowGroupBitsetSource> = Arc::new(TreeBitsetSource {
        metadata: Arc::clone(&parquet_meta),
        store_url: datafusion::execution::object_store::ObjectStoreUrl::local_filesystem(),
                pruning_predicates: std::sync::Arc::new(std::collections::HashMap::new()),
    );
}
    for i in 0..parquet_meta.num_row_groups() {
            score_lt.clone(),
                    solo_kept
            num_rows: n,
    ]);
                collector_strategy:
        Field::new("city", DataType::Utf8, false),
        datafusion::physical_expr::expressions::Literal::new(ScalarValue::Int32(Some(0))),
    let score_idx = drift_schema.index_of("score").unwrap();
        arrow_schema: schema.clone(),
    };
}
        Field::new("name", DataType::Utf8, false),
        .name
    path: std::path::PathBuf,
async fn missing_col_or_with_existing_keeps_existing() {
#[test]
        ],
 * SPDX-License-Identifier: Apache-2.0
    let score_lt: std::sync::Arc<dyn datafusion::physical_expr::PhysicalExpr> = std::sync::Arc::new(
}
        ArrowReaderMetadata::load(&file, ArrowReaderOptions::new().with_page_index(true)).unwrap();
        .build();
// Without the stream.rs reprojection fix, columns would be swapped.
        let b = b.unwrap();
 * compatible open source license.
    ]))
    .unwrap();
        })
        count += b.unwrap().num_rows();
    let tree = BoolNode::And(vec![
        datafusion::physical_expr::expressions::BinaryExpr::new(left, op, right),
        sort_fields: vec![],
        evaluator_factory: factory,
    let meta =
        Field::new("pop", DataType::Int32, false),
    let parquet_meta = meta.metadata().clone();
    let count =
        }
// branch never matches; result = (name='foo' AND score<500) rows.
    // Walk every RG in the fixture and check the invariant. For each
    BoolNode::Predicate(Arc::new(
    Arc::new(Schema::new(vec![
        })
        object_path: object_store::path::Path::from(f.path.to_string_lossy().as_ref()),
        sort_orders: vec![],
    // SELECT only columns that exist in parquet.
    // Schema handed to the pruner includes the missing column.
    );
async fn missing_col_nested_or_kept_existing_only() {
        datafusion::physical_expr::expressions::Column::new(col, col_idx),
    }));
        max_doc: MISSING_N as i64,
        });
    let tree = Arc::new(tree_bool);
            as Arc<dyn object_store::ObjectStore>,
        pushdown_predicate: None,
            index: i,
}
    w.write(&batch).unwrap();
//! the segment was written. Expected product behaviour: every row in that
                "seattle", "portland", "denver", "austin",
// treats that as all-UNKNOWN (SQL semantics).
        datafusion::physical_expr::expressions::Column::new(col, col_idx),
// per grid cell and the existing-column clause still prunes.
        datafusion::physical_expr::expressions::BinaryExpr::new(left, op, right),
// ══════════════════════════════════════════════════════════════════════
        query_with_mismatched_schema(file_schema, table_schema, &batch, tautology_int("pop", 1))
                max_collector_parallelism: 1,
            ));
    let lit_0: std::sync::Arc<dyn datafusion::physical_expr::PhysicalExpr> = std::sync::Arc::new(
// tree still references. Simulates a segment written before a mapping
        .indexed_pushdown_filters(false)
        Field::new("missing_col", DataType::Int32, true),
/// Local schema that *includes* missing_col — used for building
                assert!(
        sort_min: None,
                    combined_kept,
            let eval: Arc<dyn RowGroupBitsetSource> = Arc::new(TreeBitsetSource {
            Arc::new(StringArray::from(vec!["alice", "bob", "alice", "bob"])),
                &schema,
    while let Some(b) = stream.next().await {
                &schema,
 * The OpenSearch Contributors require contributions made to
fn page_pruner_prunes_existing_column_despite_missing_column() {
        row_groups: rgs,
    let missing_idx = drift_schema.index_of("missing_col").unwrap();
}
        count += b.num_rows();
    ]);
        row_groups: rgs,
            Arc::new(Int32Array::from(vec![750_000, 650_000, 700_000, 980_000])),
    let mut offset = 0i64;
            pred_missing_str("name", Operator::Eq, "foo"),
        cancellation_token: None,
            index: i,
    use datafusion::parquet::arrow::arrow_reader::{ArrowReaderMetadata, ArrowReaderOptions};
        .force_strategy(Some(FilterStrategy::BooleanMask))
        global_base: 0,
            Arc::new(StringArray::from(name.clone())),
    let f = missing_col_fixture();
        vec![
}
        vec![
                    combined_kept <= solo_kept,
            missing_idx,
    )
// file. Post-fix, the missing column contributes typed all-null stats
        datafusion::physical_expr::expressions::Column::new(col, col_idx),
    ]));
    let expected = (0..MISSING_N)
// ══════════════════════════════════════════════════════════════════════
        segments: vec![segment],
        let solo = pruner.prune_rg(&pp_solo, rg_idx, None);
    // Combined predicate: score < 100 AND missing_col > 0. Missing
            Arc::new(StringArray::from(vec![
            "score", score_idx,
    }
    let pp_combined = build_pruning_predicate(&combined, drift_schema)
    tree_bool: BoolNode,
    }));
    let mut stream = df.execute_stream().await.unwrap();
            ])),
        cancellation_token: None,
        let n = parquet_meta.row_group(i).num_rows();
    let provider = Arc::new(IndexedTableProvider::new(IndexedTableConfig {
    let file_schema = Arc::new(Schema::new(vec![
        Field::new("score", DataType::Int32, false),
                    rg_idx
        sort_max: None,
                page_pruner: pruner,
            missing_gt,
                leaves: Arc::new(CollectorLeafBitmaps::without_metrics()),
    )
        match (solo.as_ref(), combined.as_ref()) {
    w.close().unwrap();
                rg_index_to_pos: HashMap::new(),
    let size = std::fs::metadata(&path).unwrap().len();
                page_pruner: pruner,
