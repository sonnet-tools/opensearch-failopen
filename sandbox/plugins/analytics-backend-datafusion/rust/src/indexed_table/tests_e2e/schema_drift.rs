    let df = ctx.sql("SELECT name, score FROM t").await.unwrap();
        parquet_size: size,
    let expected = missing_col_fixture()
// branch never matches; result = (name='foo' AND score<500) rows.
    }
// added the field: parquet literally has no such column, so Phase 2's
        store_url: datafusion::execution::object_store::ObjectStoreUrl::local_filesystem(),
    BoolNode::Predicate(Arc::new(
                rg_index_to_pos: HashMap::new(),
            Arc::new(Int32Array::from(score.clone())),
/// schema). Returns the row count the engine emits.
        Field::new("name", DataType::Utf8, false),
            });
    };
    let size = std::fs::metadata(&f.path).unwrap().len();
    let pp_solo = build_pruning_predicate(&score_lt, drift_schema.clone())
    let f = missing_col_fixture();
}
    ]));
// treats that as all-UNKNOWN (SQL semantics).
    let batch = RecordBatch::try_new(
    ))
                page_pruner: pruner,
    };
        std::sync::Arc::new(datafusion::physical_expr::expressions::Column::new(
                    crate::indexed_table::eval::CollectorCallStrategy::TightenOuterBounds,
    let rfile = std::fs::File::open(&path).unwrap();
    );
                tree: Arc::new(resolved),
    CELL.get_or_init(build_missing_col_fixture)
    ]));
// per grid cell and the existing-column clause still prunes.
        pushdown_predicate: None,
    let drift_schema = schema_with_missing();
/// PhysicalExprs that reference a column absent from the parquet file.
    let parquet_meta = meta.metadata().clone();
                let solo_kept: usize = s.iter().filter(|r| !r.skip).map(|r| r.row_count).sum();
    for rg_idx in 0..meta.metadata().num_row_groups() {
        })
        .indexed_pushdown_filters(false)
                    solo_kept
/// Build a tautology predicate: `col >= 0` (always true for non-negative int columns).
// ══════════════════════════════════════════════════════════════════════
        sort_max: None,
fn only_pred(p: BoolNode) -> BoolNode {
        Field::new("pop", DataType::Int32, false),
    w.write(batch).unwrap();
    let lit_0: std::sync::Arc<dyn datafusion::physical_expr::PhysicalExpr> = std::sync::Arc::new(
        .force_strategy(Some(FilterStrategy::BooleanMask))
    );
                collector_strategy:
        .build();
) -> usize {
            Operator::Gt,
    Arc::new(Schema::new(vec![
    let count =
    let missing_gt: std::sync::Arc<dyn datafusion::physical_expr::PhysicalExpr> =
        prune_tree_config: None,
    .unwrap();
async fn run_missing_col_tree(tree_bool: BoolNode) -> usize {
            Arc::new(StringArray::from(name.clone())),
// row count (half of MISSING_N).
    // grid cell → AND combines as "score<100 AND unknown".
    .unwrap();
    );
    ]);
        .build();
// tree still references. Simulates a segment written before a mapping
        std::sync::Arc::new(datafusion::physical_expr::expressions::BinaryExpr::new(
        pred_missing_int("missing_col", Operator::GtEq, 0),
        object_path: object_store::path::Path::from(path.to_string_lossy().as_ref()),
        arrow_schema: meta.schema().clone(),
        .filter(|&i| f.name[i] == "foo" && f.score[i] < 500)
        .count();
        cancellation_token: None,
            as Arc<dyn object_store::ObjectStore>,
        ArrowReaderMetadata::load(&file, ArrowReaderOptions::new().with_page_index(true)).unwrap();
                );
        });
fn schema_with_missing() -> SchemaRef {
    path: std::path::PathBuf,
            score_lt.clone(),
    let provider = Arc::new(IndexedTableProvider::new(IndexedTableConfig {
        let schema = table_schema.clone();
        datafusion::physical_expr::expressions::BinaryExpr::new(score_col, Operator::Lt, lit_100),
    let file_schema = Arc::new(Schema::new(vec![
/// Run a tree whose predicates may reference `missing_col` (not in parquet
}
        Arc::new(move |segment, _chunk, _stream_metrics, _stats_prune_tree| {
                Arc::clone(&segment.metadata),
        emit_row_ids: false,
    let batch = RecordBatch::try_new(
/// Local schema that *includes* missing_col — used for building
    let meta =
        file_schema.clone(),
            pred_missing_str("name", Operator::Eq, "foo"),
        pred_missing_str("name", Operator::Eq, "foo"),
        sort_max: None,
// ══════════════════════════════════════════════════════════════════════
        store: Arc::new(object_store::local::LocalFileSystem::new())
    let mut count = 0;
}
    let mut offset = 0i64;
        }
    ]);
    name: Vec<&'static str>,
            .await;
 * compatible open source license.
                max_collector_parallelism: 1,
    );
    // Walk every RG in the fixture and check the invariant. For each
    let left: Arc<dyn datafusion::physical_expr::PhysicalExpr> = Arc::new(
/// `col_idx` is the column's position in the table schema.
            missing_idx,
                leaves: Arc::new(CollectorLeafBitmaps::without_metrics()),
        offset += n;
        datafusion::physical_expr::expressions::Column::new(col, col_idx),
use super::*;
            Arc::new(StringArray::from(vec![
    let tree = only_pred(pred_missing_int("missing_col", Operator::GtEq, 0));
        Field::new("brand", DataType::Utf8, false),
            lit_0,
        ],
    // only downgrade, never add rows). If the combined predicate
    for i in 0..parquet_meta.num_row_groups() {
    let mut rgs = Vec::new();
async fn missing_col_and_with_existing_returns_zero() {
        arrow_schema: schema.clone(),
    }
    let tmp = NamedTempFile::new().unwrap();
    let tree = BoolNode::And(vec![
            let resolved = tree.resolve(&[])?;
        ));
    .unwrap();
            ));
        datafusion::physical_expr::expressions::Literal::new(ScalarValue::Int32(Some(0))),
}
        sort_min: None,
            Ok(eval)
            Arc::new(StringArray::from(vec!["alice", "bob", "alice", "bob"])),
        file_schema.clone(),
        ));
    let file = std::fs::File::open(&f.path).unwrap();
    let props = datafusion::parquet::file::properties::WriterProperties::builder()
    ]));
    let tree = BoolNode::Or(vec![
        count += b.unwrap().num_rows();
            Arc::new(Int32Array::from(vec![10, 20, 30, 40])),
                evaluator: Arc::new(BitmapTreeEvaluator),
// 5. Nested: (name='foo' AND score<500) OR (missing_col=42). The missing_col
            });
// Without the stream.rs reprojection fix, columns would be swapped.
        Field::new("brand", DataType::Utf8, false),
        rgs.push(RowGroupInfo {
        ));
        .build();
    let mut stream = df.execute_stream().await.unwrap();
// File has Utf8 columns; table schema declares Utf8View.
    let lit_100: std::sync::Arc<dyn datafusion::physical_expr::PhysicalExpr> = std::sync::Arc::new(
        store: Arc::new(object_store::local::LocalFileSystem::new())
    ))
                    "rg {}: pruner bailed out on combined predicate despite \
            ScalarValue::Utf8(Some(v.to_string())),
}
            let eval: Arc<dyn RowGroupBitsetSource> = Arc::new(TreeBitsetSource {
            num_rows: n,
    let right: Arc<dyn datafusion::physical_expr::PhysicalExpr> = Arc::new(
    let tree = BoolNode::Or(vec![
    let score_idx = drift_schema.index_of("score").unwrap();
        });
        .force_strategy(Some(FilterStrategy::BooleanMask))
        Field::new("pop", DataType::Int32, false),
        std::sync::Arc::new(datafusion::physical_expr::expressions::Column::new(
        datafusion::physical_expr::expressions::BinaryExpr::new(left, op, right),
#[test]
        .target_partitions(1)
    assert_eq!(run_missing_col_tree(tree).await, expected);
struct MissingColFixture {
    }));
        metadata: Arc::clone(&parquet_meta),
    while let Some(b) = stream.next().await {
}
                     present column — missing-column fix regression",
            "score", score_idx,
        let tree = Arc::clone(&tree);
                max_collector_parallelism: 1,
        query_config: std::sync::Arc::new(qc),
        .expect("combined predicate not always_true");
    for i in 0..parquet_meta.num_row_groups() {
        BoolNode::And(vec![
//! segment's parquet file. Common when a mapping added the field after
    let score_col: std::sync::Arc<dyn datafusion::physical_expr::PhysicalExpr> =
fn missing_col_fixture() -> &'static MissingColFixture {
    // column has all-null stats → clause evaluates to unknown per
        parquet_size: size,
}
        sort_fields: vec![],
                    combined_kept,
    static CELL: OnceLock<MissingColFixture> = OnceLock::new();
                    rg_idx,
}
#[tokio::test(flavor = "multi_thread", worker_threads = 2)]
    // solo selection (the missing-column clause is unknown → it can
// ══════════════════════════════════════════════════════════════════════
}
        let tree = Arc::clone(&tree);
    p
/// UNKNOWN) per its normal semantics.
                cost_predicate: 1,
            }
        pred_missing_int("missing_col", Operator::GtEq, 0),
        segments: vec![segment],
            _ => {}
}
// contributes only "unknown" per grid cell, so it can neither add nor
// file. Post-fix, the missing column contributes typed all-null stats
    );
    tree_bool: BoolNode,
    w.close().unwrap();
                pruning_predicates: std::sync::Arc::new(std::collections::HashMap::new()),
        sort_min: None,
 * SPDX-License-Identifier: Apache-2.0
// remove page selections beyond what the existing column decides.
fn not_pred(p: BoolNode) -> BoolNode {
        store_url: datafusion::execution::object_store::ObjectStoreUrl::local_filesystem(),
        vec![
// column lookup on the RecordBatch returns None and our product code
        prune_tree_config: None,
    let schema = meta.schema().clone();
    let qc = crate::datafusion_query_config::DatafusionQueryConfig::builder()
    count
// 3. AND(existing, missing): all rows UNKNOWN via missing branch -> 0.
    assert_eq!(count, 4);
fn tautology_int(col: &str, col_idx: usize) -> BoolNode {
            let pruner = Arc::new(PagePruner::new(
    // caused the pruner to bail out (returning `None` where solo
    assert_eq!(run_missing_col_tree(tree).await, expected);
    let size = std::fs::metadata(&path).unwrap().len();
fn page_pruner_prunes_existing_column_despite_missing_column() {
        Field::new("name", DataType::Utf8, false),
                stats_prune_tree: None,
    use crate::indexed_table::page_pruner::{build_pruning_predicate, PagePruner};
    let missing_col: std::sync::Arc<dyn datafusion::physical_expr::PhysicalExpr> =
    let qc = crate::datafusion_query_config::DatafusionQueryConfig::builder()
    // RG, the combined selection must keep at most as many rows as the
    }));
            first_row: offset,
        Field::new("missing_col", DataType::Int32, true),
    );
        Field::new("city", DataType::Utf8, false),
        predicate_columns: vec![],
#[tokio::test(flavor = "multi_thread", worker_threads = 2)]
            let pruner = Arc::new(PagePruner::new(
    let f = missing_col_fixture();
    ctx.register_table("t", provider).unwrap();
 * The OpenSearch Contributors require contributions made to
        .set_max_row_group_size(512)
    // cycle → some pages will be prunable).
        predicate_columns: vec![],
#[tokio::test(flavor = "multi_thread", worker_threads = 2)]
    let tree = Arc::new(tree_bool);
        .set_max_row_group_size(256)
    }
                pruning_predicates: std::sync::Arc::new(std::collections::HashMap::new()),
        ArrowReaderMetadata::load(&file, ArrowReaderOptions::new().with_page_index(true)).unwrap();
                Arc::clone(&segment.metadata),
                &schema,
        Field::new("name", DataType::Utf8, false),
    assert_eq!(run_missing_col_tree(tree).await, 0);
            index: i,
// 4. OR(existing, missing): existing branch dominates. Expected = name='foo'
const MISSING_N: usize = 2048;
// 1. Predicate on missing column -> all UNKNOWN -> 0 rows.
            as Arc<dyn object_store::ObjectStore>,
        sort_orders: vec![],
                let combined_kept: usize = c.iter().filter(|r| !r.skip).map(|r| r.row_count).sum();
    while let Some(b) = stream.next().await {
        ],
        datafusion::physical_expr::expressions::Literal::new(ScalarValue::Int32(Some(0))),
        max_doc: MISSING_N as i64,
 * this file be licensed under the Apache-2.0 license or a
    // against.
        vec![
            }
    let ctx = SessionContext::new();
}
    file_schema: SchemaRef,
    count
    let f = missing_col_fixture();
            .await;
        let n = parquet_meta.row_group(i).num_rows();
            Arc::new(StringArray::from(vec!["acme", "globex", "acme", "globex"])),
    let tmp = NamedTempFile::new().unwrap();
        object_path: object_store::path::Path::from(f.path.to_string_lossy().as_ref()),
                page_pruner: pruner,
    let score_lt: std::sync::Arc<dyn datafusion::physical_expr::PhysicalExpr> = std::sync::Arc::new(
                cost_collector: 10,
    let combined: std::sync::Arc<dyn datafusion::physical_expr::PhysicalExpr> =
    let batch = RecordBatch::try_new(
        })
                cost_collector: 10,
        Field::new("city", DataType::Utf8View, false),
    let expected = (0..MISSING_N)
    score: Vec<i32>,
// Missing-column fixture — parquet written without a column that the
    let factory: super::super::table_provider::EvaluatorFactory = {
    let factory: super::super::table_provider::EvaluatorFactory = {
fn pred_missing_str(col: &str, op: Operator, v: &str) -> BoolNode {
// Pre-fix, this assertion failed because `prune_rg` bailed out to
        .build();
        Field::new("name", DataType::Utf8, false),
                rg_index_to_pos: HashMap::new(),
        Field::new("score", DataType::Int32, false),
        ]),
    let left: Arc<dyn datafusion::physical_expr::PhysicalExpr> = Arc::new(
        .name
    // SELECT only columns that exist in parquet.
        row_groups: rgs,
        .target_partitions(1)
// 2. NOT(missing-col predicate) -> UNKNOWN -> 0 rows.
                &schema,
        .indexed_pushdown_filters(false)
        .iter()
            Arc::new(Int32Array::from(vec![750_000, 650_000, 700_000, 980_000])),
            "missing_col",
    let (file, path) = tmp.keep().unwrap();
        vec![
    for i in 0..MISSING_N {
    ]));
        ],
    let meta =
    ctx.register_table("t", provider).unwrap();
            num_rows: n,
                    crate::indexed_table::eval::CollectorCallStrategy::TightenOuterBounds,
        let schema = schema.clone();
/// Generic helper: write a parquet file, register with a (possibly different)
#[tokio::test(flavor = "multi_thread", worker_threads = 2)]
    );
        ));
            Ok(eval)
    let count =
        metadata: Arc::clone(&parquet_meta),
    let tree = Arc::new(tree_bool);
    let mut stream = df.execute_stream().await.unwrap();
        writer_generation: 0,
#[tokio::test(flavor = "multi_thread", worker_threads = 2)]
        Field::new("score", DataType::Int32, false),
// `None` whenever any referenced column was absent from the parquet
    BoolNode::Not(Box::new(p))
    // Schema handed to the pruner includes the missing column.
        query_config: std::sync::Arc::new(qc),
    let (file, path) = tmp.keep().unwrap();
}
        let b = b.unwrap();
        let solo = pruner.prune_rg(&pp_solo, rg_idx, None);
                panic!(
    let file = std::fs::File::open(&f.path).unwrap();
            pred_missing_int("score", Operator::Lt, 500),
                schema.clone(),
        Arc::new(move |segment, _chunk, _stream_metrics, _stats_prune_tree| {
        .set_data_page_row_count_limit(128)
    let parquet_meta = meta.metadata().clone();
                page_prune_metrics: None,
}
    let right: Arc<dyn datafusion::physical_expr::PhysicalExpr> =
        pred_missing_int("missing_col", Operator::Eq, 42),
    let mut name = Vec::with_capacity(MISSING_N);
    let mut rgs = Vec::new();
    let mut score = Vec::with_capacity(MISSING_N);
        std::sync::Arc::new(datafusion::physical_expr::expressions::BinaryExpr::new(
    let props = datafusion::parquet::file::properties::WriterProperties::builder()
    let meta =
    w.close().unwrap();
    let left: Arc<dyn datafusion::physical_expr::PhysicalExpr> = Arc::new(
        query_with_mismatched_schema(file_schema, table_schema, &batch, tautology_int("score", 2))
    // so ~10% of rows match, concentrated at the start of every 1000-row
    batch: &RecordBatch,
        query_with_mismatched_schema(file_schema, table_schema, &batch, tautology_int("pop", 1))
        name.push(if i % 2 == 0 { "foo" } else { "bar" });
                stats_prune_tree: None,
            Operator::And,
async fn query_with_mismatched_schema(
//! segment evaluates to UNKNOWN for that predicate and gets filtered out.
            (Some(s), Some(c)) => {
                cost_predicate: 1,
    assert_eq!(count, 4);
}
            missing_col,
        sort_orders: vec![],
        ));
        offset += n;
    let col_idx = schema.index_of(col).expect("column in local schema");
    // Existing-column predicate: score < 100 (fixture has score = i % 1000
/// The evaluator's refinement stage handles the missing column (emits
                     missing-column clause must not add rows",
    // returned `Some`), that's the pre-fix regression we're guarding
            ])),
    w.write(&batch).unwrap();
    ]));
        emit_row_ids: false,
        schema: table_schema,
    let mut offset = 0i64;
//! Schema drift — predicates referencing columns that are absent from a
        rgs.push(RowGroupInfo {
        global_base: 0,
    let table_schema = Arc::new(Schema::new(vec![
    // Parquet schema intentionally excludes `missing_col`.
        Field::new("score", DataType::Int32, false),
        datafusion::physical_expr::expressions::Literal::new(ScalarValue::Int32(Some(v))),
        schema.clone(),
}
async fn missing_col_nested_or_kept_existing_only() {
        datafusion::physical_expr::expressions::Literal::new(ScalarValue::Int32(Some(100))),
 *
        max_doc: batch.num_rows() as i64,
    ]);
        let n = parquet_meta.row_group(i).num_rows();
        count += b.num_rows();
                page_prune_metrics: None,
fn pred_missing_int(col: &str, op: Operator, v: i32) -> BoolNode {
// File has (name, score, brand); table schema is (brand, name, score).
    let col_idx = schema.index_of(col).expect("column in local schema");
            (Some(_), None) => {
        Arc::new(datafusion::physical_expr::expressions::Literal::new(
        .count();
    // Combined predicate: score < 100 AND missing_col > 0. Missing
async fn reorder_columns_aligned_and_filtered() {
                leaves: Arc::new(CollectorLeafBitmaps::without_metrics()),
        schema: schema.clone(),
//! the segment was written. Expected product behaviour: every row in that
    let ctx = SessionContext::new();
    BoolNode::Predicate(Arc::new(
// 6. Page pruner direct invariant: a predicate that ANDs an existing
    let schema = schema_with_missing();
        pushdown_predicate: None,
            ));
                    rg_idx
 */
    }
        datafusion::physical_expr::expressions::Column::new(col, col_idx),
        evaluator_factory: factory,
#[tokio::test(flavor = "multi_thread", worker_threads = 2)]
        datafusion::physical_expr::expressions::BinaryExpr::new(left, op, right),
        .filter(|n| **n == "foo")
async fn missing_col_not_predicate_returns_zero_rows() {
                schema.clone(),
    assert_eq!(run_missing_col_tree(tree).await, 0);
        pred_missing_str("name", Operator::Eq, "foo"),
    assert_eq!(run_missing_col_tree(tree).await, 0);
    let tree = not_pred(pred_missing_int("missing_col", Operator::GtEq, 0));
    let pruner = PagePruner::new(&drift_schema, meta.metadata().clone(), drift_schema.clone());
        Field::new("score", DataType::Int32, false),
    let schema = schema_with_missing();
    let segment = SegmentFileInfo {
            let resolved = tree.resolve(&[])?;
    }
/*
                collector_strategy:
    let right: Arc<dyn datafusion::physical_expr::PhysicalExpr> = Arc::new(
//
        segments: vec![segment],
    );
// column with a missing column must prune identically to the
    let table_schema = Arc::new(Schema::new(vec![
    BoolNode::Predicate(Arc::new(
    ))
        ArrowReaderMetadata::load(&rfile, ArrowReaderOptions::new().with_page_index(true)).unwrap();
                evaluator: Arc::new(BitmapTreeEvaluator),
async fn utf8view_schema_with_utf8_file_does_not_panic() {
        datafusion::physical_expr::expressions::Column::new(col, col_idx),
        datafusion::physical_expr::expressions::BinaryExpr::new(left, Operator::GtEq, right),
        sort_fields: vec![],
    let schema = Arc::new(Schema::new(vec![
#[tokio::test(flavor = "multi_thread", worker_threads = 2)]
            index: i,
        cancellation_token: None,
    let file_schema = Arc::new(Schema::new(vec![
        .expect("score<100 is not always_true on this fixture");
}
                );
        let combined = pruner.prune_rg(&pp_combined, rg_idx, None);
                    "rg {}: combined selection kept {} rows, solo kept {} — \
    let df = ctx.sql("SELECT * FROM t").await.unwrap();
                    combined_kept <= solo_kept,
    let mut count = 0;
    };
    // Column caches — only for columns actually in the parquet.
                "seattle", "portland", "denver", "austin",
/// table schema, run `SELECT * FROM t`, return row count.
}
        evaluator_factory: factory,
        score.push((i as i32) % 1000);
    )
        .set_statistics_enabled(datafusion::parquet::file::properties::EnabledStatistics::Page)
    use datafusion::parquet::arrow::arrow_reader::{ArrowReaderMetadata, ArrowReaderOptions};
        writer_generation: 0,
    ]))
                assert!(
        global_base: 0,
    let mut w = ArrowWriter::try_new(file, schema, Some(props)).unwrap();
async fn missing_col_or_with_existing_keeps_existing() {
        match (solo.as_ref(), combined.as_ref()) {
async fn missing_col_predicate_returns_zero_rows() {
    let mut w = ArrowWriter::try_new(file, file_schema, Some(props)).unwrap();
    }
            let eval: Arc<dyn RowGroupBitsetSource> = Arc::new(TreeBitsetSource {
// existing-column predicate alone — the missing-column clause
    let segment = SegmentFileInfo {
    let pp_combined = build_pruning_predicate(&combined, drift_schema)
    )
            missing_gt,
}
            first_row: offset,
    )
    let provider = Arc::new(IndexedTableProvider::new(IndexedTableConfig {
}
    MissingColFixture { path, name, score }
    table_schema: SchemaRef,
// Without force_view_types(false), panics with "byte view array".
    let missing_idx = drift_schema.index_of("missing_col").unwrap();
        row_groups: rgs,
                tree: Arc::new(resolved),
    };
fn build_missing_col_fixture() -> MissingColFixture {
