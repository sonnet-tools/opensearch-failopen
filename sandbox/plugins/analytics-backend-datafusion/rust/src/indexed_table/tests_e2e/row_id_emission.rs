    }
/// and suffix) matching what `IndexedTableProvider.scan()` looks for.
    let props = datafusion::parquet::file::properties::WriterProperties::builder()
    let mut rgs = Vec::new();
        pushdown_predicate: None,
    .await;
    let mem_table =
        sort_fields: vec![],
        ids, expected,
async fn test_row_id_with_data_columns() {
    let schema = meta.schema().clone();
    // brand="amazon" rows: 0,1,2,3,12
}
        pred_int("price", Operator::Lt, 90),
// |  5  | apple  |    95 | archived  | electronics |
            rows.push((ids.value(i), brands.value(i).to_string(), prices.value(i)));
        row_groups: rgs,
        "filtered row IDs should be offset by global_base"
        })
    // we expect all IDs from 0 through 31 inclusive.
    }));
    let plan = df.create_physical_plan().await.unwrap();
        .set_max_row_group_size(8)
        ids, expected,
                schema.clone(),
        .enumerate()
            || (BRANDS[i] == "apple" && STATUSES[i] == "archived")
        pred_int("price", Operator::Lt, 100),
        let n = parquet_meta.row_group(i).num_rows();
        });
// ── Multi-segment row ID tests ──────────────────────────────────────────────
            num_rows: n,
                page_prune_metrics: Some(
    let expected = expected_rows(|i| STATUSES[i] == "archived");
    let path = tmp.path().to_path_buf();
                pruning_predicates: Arc::new(std::collections::HashMap::new()),
        Arc::new(move |segment, _chunk, _stream_metrics, _stats_prune_tree| {
    let expected = expected_rows(|i| BRANDS[i] == "amazon" || BRANDS[i] == "apple");
}
            ));
    let store: Arc<dyn object_store::ObjectStore> =
    let parquet_meta = meta.metadata().clone();
    let mut rgs = Vec::new();
    // Collector + Predicate: amazon AND price > 100 → rows 1,3
                page_pruner: pruner,
        writer_generation: 0,
        let n = parquet_meta.row_group(i).num_rows();
            Arc::new(Int64Array::from(row_ids)),
                page_pruner: pruner,
// |  1  | amazon |   150 | archived  | electronics |
    let object_path1 = object_store::path::Path::from(path1.to_string_lossy().as_ref());
    let store_url = datafusion::execution::object_store::ObjectStoreUrl::local_filesystem();
            Ok(eval)
    ]))
        ],
            qc.target_partitions = 1;
                    crate::indexed_table::eval::CollectorCallStrategy::TightenOuterBounds,
    .unwrap();
    // Predicate only: price < 50 → rows 8,12,13
            let mut qc = crate::datafusion_query_config::DatafusionQueryConfig::test_default();
            "should have 3 columns: __row_id__, brand, price"
        object_path,
    assert!(
        "status",
    // Each segment has 16 rows. With global_base=0 and global_base=16,
    let path = tmp.path().to_path_buf();
        .map(|(i, c)| (i as i32, c))
    let ids = run_tree_row_ids(BoolNode::Or(vec![index_leaf(0), index_leaf(1)])).await;
#[tokio::test]
        let b = batch.unwrap();
            num_rows: n,
            Arc::new(datafusion::arrow::array::Int64Array::from(row_ids)),
        arrow_schema: schema.clone(),
        });
    let ids = run_tree_row_ids(BoolNode::And(vec![
                cost_predicate: 1,
    };
                stats_prune_tree: None,
    let mut offset = 0i64;
        cancellation_token: None,
        metadata: Arc::clone(&parquet_meta),
    let ids = run_tree_row_ids(BoolNode::And(vec![index_leaf(1), index_leaf(2)])).await;
        .build();
                    ),
    let tree = Arc::new(tree);
    let ctx = SessionContext::new();
    let ids = run_tree_row_ids(BoolNode::And(vec![pred_str(
        predicate_columns: vec![0, 1, 2, 3],
                ),
/// Segment 2 (global_base=16) gives IDs: 16,17,18,19,28
    use crate::indexed_table::substrait_to_tree::plan_requests_row_ids;
    assert_eq!(ids, expected, "Predicate(status=active) mismatch");
    let row_ids: Vec<i64> = (0..16).collect();
/// With global_base=1000, brand="amazon" (rows 0,1,2,3,12) should give 1000,1001,1002,1003,1012.
        sort_min: None,
        let prices = b.column(2).as_any().downcast_ref::<Int32Array>().unwrap();
        Arc::new(object_store::local::LocalFileSystem::new());
    assert_eq!(rows[4], (12, "amazon".to_string(), 30));
        sort_orders: vec![],
                    crate::indexed_table::eval::bitmap_tree::CollectorLeafBitmaps::new(
    let ids = run_tree_row_ids(BoolNode::And(vec![
        predicate_columns: vec![0, 1, 2, 3],
            qc
    let tree = BoolNode::And(vec![pred_int("price", Operator::GtEq, 0)]);
                collector_strategy:
        max_doc: 16,
// | 10  | samsung|    70 | active    | electronics |
        store,
    let tmp2 = write_row_id_fixture_parquet();
    let task_ctx = ctx.task_ctx();
    let ids = run_tree_row_ids(BoolNode::And(vec![pred_int("price", Operator::Lt, 50)])).await;
                cost_predicate: 1,
    assert_eq!(ids, expected, "NOT(amazon) mismatch");
/// Verify detection — `__row_id__` column in SELECT triggers emit_row_ids mode.
    tmp
    let schema = build_row_id_fixture_schema();
    row_ids
        pushdown_predicate: None,
        Field::new("__row_id__", DataType::Int64, false),
async fn test_emit_row_ids_or_two_collectors() {
    row_ids.sort();
    let tree = BoolNode::And(vec![
    let meta =
            });
            first_row: offset,
    .await;
        let tree = Arc::clone(&tree);
    let ctx = SessionContext::new();
    assert_eq!(ids.len(), 32, "should have 32 row IDs (16 per segment)");
 * compatible open source license.
        assert_eq!(b.schema().field(0).name(), "__row_id__");
        sort_max: None,
    let factory: super::super::table_provider::EvaluatorFactory = {
            let resolved = tree.resolve(&per_leaf)?;
//! Verifies that the indexed query path can return global row IDs
    };
        offset += n;
        }
        let b = batch.unwrap();
                        _stream_metrics.ffm_collector_calls.clone(),
                &schema,
        pred_int("price", Operator::Gt, 100),
        .collect();
    for i in 0..parquet_meta.num_row_groups() {
        let schema = schema.clone();
                ),
/// Projects [__row_id__, brand, price] and verifies all three are present and correct.
/// Segment 1 (global_base=0) gives IDs: 0,1,2,3,12
        row_groups: rgs1,
                    crate::indexed_table::eval::bitmap_tree::CollectorLeafBitmaps::new(
    while let Some(batch) = stream.next().await {
    let df = ctx.sql("SELECT \"__row_id__\" FROM t").await.unwrap();
        rgs2.push(RowGroupInfo {
    let object_path = object_store::path::Path::from(path.to_string_lossy().as_ref());
            qc.target_partitions = 1;
            index: i,
            index: i,
    // Load metadata for segment 2
        segments: vec![segment],
    let path = tmp.path().to_path_buf();
                    ),
    // amazon(0,1,2,3,12) OR apple(4,5,6,7,13) = 0-7,12,13. price>100: 1,3,6
        }),
    assert_eq!(
                schema.clone(),
    let tmp1 = write_row_id_fixture_parquet();
        cancellation_token: None,
        pushdown_predicate: None,
    }
        assert_eq!(
        for i in 0..b.num_rows() {
                    crate::indexed_table::eval::CollectorCallStrategy::TightenOuterBounds,
    let store: Arc<dyn object_store::ObjectStore> =
    let factory: super::super::table_provider::EvaluatorFactory = {
    assert_eq!(ids, expected, "Tree AND(apple,archived) mismatch");
        offset += n;
fn expected_rows(filter: impl Fn(usize) -> bool) -> Vec<i64> {
    let plan = df.create_physical_plan().await.unwrap();
                    crate::indexed_table::eval::bitmap_tree::CollectorLeafBitmaps::new(
fn write_row_id_fixture_parquet() -> NamedTempFile {
    let ids = run_tree_row_ids(BoolNode::And(vec![index_leaf(2)])).await;
                page_prune_metrics: Some(
    ]))
    let file = std::fs::File::open(&path).unwrap();
    }));
        writer_generation: 0,
            Arc::new(datafusion::arrow::array::Int32Array::from(PRICES.to_vec())),
}
        pred_str("category", Operator::Eq, "books"),
        offset += n;
    assert_eq!(ids, vec![0, 1, 2, 3, 12]);
        sort_orders: vec![],
    }
            let resolved = tree.resolve(&per_leaf)?;
        emit_row_ids: true,
        assert_eq!(b.num_columns(), 1, "should have only __row_id__ column");
    assert_eq!(ids, vec![1000, 1001, 1002, 1003, 1012]);
                ),
        store_url,
            Ok(eval)
        let b = batch.unwrap();
                        _stream_metrics.ffm_collector_calls.clone(),
    // Project __row_id__ — it will be computed from position, not read from parquet
                schema.clone(),
    let size1 = std::fs::metadata(&path1).unwrap().len();
    assert_eq!(ids, expected, "SingleCollector(apple) mismatch");
    let factory: super::super::table_provider::EvaluatorFactory = {
    assert_eq!(ids, expected, "row IDs should cover 0..31 with no gaps");
    // Tree AND: apple AND archived → rows 5,13
        .collect();
    let meta =
        let tree = Arc::clone(&tree);
    let per_leaf: Vec<(i32, Arc<dyn RowGroupDocsCollector>)> = collectors
            qc
    w.close().unwrap();
            Arc::new(StringArray::from(BRANDS.to_vec())),
        BoolNode::And(vec![index_leaf(1), index_leaf(2)]),
        let col = b.column(0).as_any().downcast_ref::<Int64Array>().unwrap();
    let parquet_meta = meta.metadata().clone();
        global_base: 0,
                tree: Arc::new(resolved),
#[tokio::test]
/// Helper: run a tree with `emit_row_ids: true` and return the collected row IDs.
                ),
    while let Some(batch) = stream.next().await {
                ),
// ── Tests ────────────────────────────────────────────────────────────
    );
#[tokio::test]
        }),
                        _stream_metrics.ffm_collector_calls.clone(),
                tree: Arc::new(resolved),
        }
    assert_eq!(ids, vec![4, 5, 6, 7, 13]);
            num_rows: n,
/// segment 2 has global_base=16, so combined IDs span 0..31.
    }
            });
    let file2 = std::fs::File::open(&path2).unwrap();
        sort_min: None,
    assert_eq!(ids, expected, "Collector+String(amazon,books) mismatch");
// | 15  | google |    55 | active    | electronics |
// Lot of query shapes --> for the query sent, how will that translate into at the data node side?
        let per_leaf = per_leaf.clone();
        .unwrap();
        let per_leaf = per_leaf.clone();
        let per_leaf = per_leaf.clone();
    let tree = BoolNode::Or(vec![index_leaf(0), index_leaf(1)]);
// | 12  | amazon |    30 | archived  | electronics |
        row_groups: rgs,
                Arc::clone(&segment.metadata),
// The fixture (16 rows):
    let segment2 = SegmentFileInfo {
    let mut stream = datafusion::physical_plan::execute_stream(plan, task_ctx).unwrap();
    }));
    let per_leaf: Vec<(i32, Arc<dyn RowGroupDocsCollector>)> = collectors
    let mut row_ids: Vec<i64> = Vec::new();
            let eval: Arc<dyn RowGroupBitsetSource> = Arc::new(TreeBitsetSource {
        store,
        let tree = Arc::clone(&tree);
    .await;
    for i in 0..parquet_meta1.num_row_groups() {
// For each query type (SingleCollector, Collector+Predicate, Tree OR, Tree AND,
        parquet_size: size1,
        "active",
            ));
    let size = std::fs::metadata(&path).unwrap().len();
        .sql("SELECT \"__row_id__\", brand, price FROM t")
        .enumerate()
            let pruner = Arc::new(PagePruner::new(
            qc.force_strategy = Some(FilterStrategy::BooleanMask);
            index: i,
    row_ids
        metadata: Arc::clone(&parquet_meta2),
#[tokio::test]
        rgs.push(RowGroupInfo {
// ── Comprehensive correctness: verify emitted row IDs match actual positions ──
    assert_eq!(
    assert_eq!(unique.len(), 32, "all 32 row IDs should be unique");
        .await
        query_config: Arc::new({
            Arc::new(datafusion::arrow::array::StringArray::from(
            qc.target_partitions = 1;
async fn test_emit_row_ids_single_collector_amazon() {
                ),
    // Multi-predicate: price > 50 AND price < 100 → rows 2,4,5,7,10,14,15
    let tmp = write_fixture_parquet();
        Arc::new(move |segment, _chunk, _stream_metrics, _stats_prune_tree| {
    // Plan with __row_id__ in projection — should be detected
        let schema = schema.clone();
    let store_url = datafusion::execution::object_store::ObjectStoreUrl::local_filesystem();
    let tree = BoolNode::And(vec![index_leaf(1)]);
    let tree = BoolNode::And(vec![index_leaf(1), index_leaf(2)]);
    let expected = expected_rows(|i| PRICES[i] >= 150);
                cost_collector: 10,
        expected_rows(|i| (BRANDS[i] == "amazon" || BRANDS[i] == "apple") && PRICES[i] > 100);
        datafusion::datasource::MemTable::try_new(schema.clone(), vec![vec![batch]]).unwrap();
async fn test_emit_row_ids_two_segments_global_base() {
        ids, expected,
    assert_eq!(ids, expected, "Predicate-only(price>=150) mismatch");
/// AND(brand="amazon", price > 100) matches rows where brand=amazon AND price>100.
fn build_row_id_fixture_schema() -> SchemaRef {
        }
    let segment = SegmentFileInfo {
        prune_tree_config: None,
    let tree = BoolNode::And(vec![index_leaf(0)]);
        query_config: Arc::new({
            first_row: offset,
        let brands = b.column(1).as_any().downcast_ref::<StringArray>().unwrap();
/// AND(brand="apple", status="archived") — apple rows: 4,5,6,7,13;
    }
                page_pruner: pruner,
                pruning_predicates: Arc::new(std::collections::HashMap::new()),
            let pruner = Arc::new(PagePruner::new(
//
                &schema,
            qc
    .unwrap();
    let collectors = wire_collectors(&tree);
            let mut qc = crate::datafusion_query_config::DatafusionQueryConfig::test_default();
        .into_iter()
            ));
//! instead of actual data columns.
                    crate::indexed_table::page_pruner::PagePruneMetrics::from_stream_metrics(
        });
        evaluator_factory: factory,
        Arc::new(move |segment, _chunk, _stream_metrics, _stats_prune_tree| {
async fn test_emit_row_ids_with_global_base_offset() {
            let pruner = Arc::new(PagePruner::new(
        })
}
// Optimizer + ComputeRowId --> @gbh --> optimizer --> for parquet only right
}
            b.num_columns(),
            Arc::new(StringArray::from(STATUSES.to_vec())),
    let tree = Arc::new(tree);
                cost_collector: 10,
    assert_eq!(rows[3], (3, "amazon".to_string(), 120));
    // Predicate only: price >= 150 → rows 1,6,9,11
    let mut offset = 0i64;
        .enumerate()
}
    let mut row_ids: Vec<i64> = Vec::new();
                    ),
    let tree = BoolNode::And(vec![index_leaf(0)]);
    let expected = expected_rows(|i| PRICES[i] > 50 && PRICES[i] < 100);
                leaves: Arc::new(
    let tree = tree.push_not_down();
/// brand="amazon" matches rows 0,1,2,3,12 — verify we get those row IDs back.
    // Load metadata for segment 1
    let expected =
    for i in 0..parquet_meta2.num_row_groups() {
    assert!(
                cost_collector: 10,
                ),
    }
            Arc::new(datafusion::arrow::array::StringArray::from(
    let plan = df.create_physical_plan().await.unwrap();
    .await;
        schema: schema.clone(),
            });
        let schema = schema.clone();
    let schema = meta.schema().clone();
    assert_eq!(
        store,
async fn test_emit_row_ids_collector_and_predicate() {
    let ids = run_tree_row_ids(tree).await;
    let tree = tree.push_not_down();
    let batch = RecordBatch::try_new(
        assert_eq!(b.num_columns(), 1, "should have only __row_id__ column");
//! End-to-end tests for `emit_row_ids` mode.
    ]);
    let schema = build_fixture_schema();
    w.write(&batch).unwrap();
    let schema = meta.schema().clone();
    );
                    ),
        assert_eq!(b.schema().field(0).name(), "__row_id__");
    let ids = run_tree_row_ids(BoolNode::And(vec![
    }
    let object_path = object_store::path::Path::from(path.to_string_lossy().as_ref());
        store_url,
        evaluator_factory: factory,
                cost_collector: 10,
    assert_eq!(rows[2], (2, "amazon".to_string(), 80));
    let segment1 = SegmentFileInfo {
                schema.clone(),
            });
                max_collector_parallelism: 1,
        pred_int("price", Operator::Gt, 50),
    let tree = BoolNode::And(vec![index_leaf(0)]);
                        _stream_metrics,
        Field::new("category", DataType::Utf8, false),
        "Collector+Predicate(amazon,price>100) mismatch"
                    ),
        .into_iter()
    let expected = expected_rows(|i| BRANDS[i] == "amazon");
    let meta =
// |  8  | google |    40 | active    | electronics |
            row_ids.push(col.value(i));
                collector_strategy:
    )
            )),
    };
    )]))
    let ctx = SessionContext::new();
                stats_prune_tree: None,
    .await;
    ctx.register_table("t", provider).unwrap();
    assert_eq!(ids, expected, "Predicate-only(price<50) mismatch");
        sort_orders: vec![],
// | 11  | samsung|   150 | active    | books       |
        }),
    let parquet_meta2 = meta2.metadata().clone();
    row_ids
    let object_path2 = object_store::path::Path::from(path2.to_string_lossy().as_ref());
#[tokio::test]
    let tmp = NamedTempFile::new().unwrap();
    let task_ctx = ctx.task_ctx();
    };
            Arc::new(Int32Array::from(PRICES.to_vec())),
}
            first_row: offset,
    let df = ctx.sql("SELECT \"__row_id__\" FROM t").await.unwrap();
    let tmp = write_fixture_parquet();
            num_rows: n,
    let ids = run_tree_row_ids(tree).await;
    rows.sort_by_key(|r| r.0);
use super::*;
    // Collector tag 0 = brand_eq("amazon")
}
    let mut rgs2 = Vec::new();
    assert_eq!(rows.len(), 5);
                    crate::indexed_table::page_pruner::PagePruneMetrics::from_stream_metrics(
        store_url,
    let ctx = SessionContext::new();
        metadata: Arc::clone(&parquet_meta1),
        arrow_schema: schema.clone(),
    });
        let col = b.column(0).as_any().downcast_ref::<Int64Array>().unwrap();
    // Collector tag 0 = brand_eq("amazon") — matches rows 0,1,2,3,12
                    crate::indexed_table::eval::CollectorCallStrategy::TightenOuterBounds,
// directly, then compare against what emit_row_ids produces.
        writer_generation: 1,
    let df2 = ctx.sql("SELECT brand FROM t").await.unwrap();
        ids.len(),
        })
    let ids = run_tree_row_ids(BoolNode::And(vec![index_leaf(0)])).await;
        .map(|(i, c)| (i as i32, c))
    assert_eq!(ids, expected, "Tree OR(amazon,apple) mismatch");
        schema.clone(),
        sort_max: None,
/// Test: filtered query across two segments returns correct global IDs.
/// OR(brand="amazon", brand="apple") matches rows 0-7, 12, 13.
        writer_generation: 0,
        parquet_size: size,
    let task_ctx = ctx.task_ctx();
        ArrowReaderMetadata::load(&file, ArrowReaderOptions::new().with_page_index(true)).unwrap();
/// Each segment is a separate parquet file with 16 rows. Segment 1 has global_base=0,
    let store_url = datafusion::execution::object_store::ObjectStoreUrl::local_filesystem();
    assert_eq!(ids, vec![5, 13]);
            qc.force_strategy = Some(FilterStrategy::BooleanMask);
/// Combined unfiltered query should produce IDs 0..31 with no gaps.
                Arc::clone(&segment.metadata),
    assert_eq!(rows[1], (1, "amazon".to_string(), 150));
            let eval: Arc<dyn RowGroupBitsetSource> = Arc::new(TreeBitsetSource {
use datafusion::arrow::array::Int64Array;
    ctx.register_table("t", provider).unwrap();
// |  0  | amazon |    50 | active    | electronics |
 * The OpenSearch Contributors require contributions made to
}
            3,
        assert_eq!(b.schema().field(1).name(), "brand");
                Arc::clone(&segment.metadata),
    ]))
    // Tree OR: amazon OR apple → rows 0-7,12,13
    let mut rgs = Vec::new();
        emit_row_ids: true,
        object_path,
    let size = std::fs::metadata(&path).unwrap().len();
    let provider = Arc::new(IndexedTableProvider::new(IndexedTableConfig {
    row_ids.sort();
        }
    let df = ctx
    // String predicate: status = "active" → rows 0,2,3,4,6,7,8,10,11,14,15
    let mut rgs1 = Vec::new();
    // Plan without __row_id__ — should NOT be detected
        predicate_columns: vec![0, 1, 2, 3],
    // Verify uniqueness explicitly
                evaluator: Arc::new(BitmapTreeEvaluator),
            row_ids.push(col.value(i));
    let file = std::fs::File::open(&path).unwrap();
            num_rows: n,
    let unique: std::collections::HashSet<i64> = ids.iter().copied().collect();
        object_path: object_path1,
}
                CATEGORIES.to_vec(),
        });
                    crate::indexed_table::eval::CollectorCallStrategy::TightenOuterBounds,
            Ok(eval)
        Field::new("price", DataType::Int32, false),
                    ),
    let plan = df.create_physical_plan().await.unwrap();
/// Build fixture schema with `__row_id__` column name (double underscore prefix
        let n = parquet_meta.row_group(i).num_rows();
                evaluator: Arc::new(BitmapTreeEvaluator),
        cancellation_token: None,
        arrow_schema: schema.clone(),
            row_ids.push(col.value(i));
    assert_eq!(ids, expected, "SingleCollector(amazon) mismatch");
        parquet_size: size2,
    );
    let ids = run_tree_row_ids_with_global_base(tree, 1000).await;
                leaves: Arc::new(
async fn test_all_query_types_match_fixture_positions() {
    };
    let segment = SegmentFileInfo {
    let expected = expected_rows(|i| PRICES[i] < 50);
                tree: Arc::new(resolved),
                ),
        let per_leaf = per_leaf.clone();
 *
    // Collector + string predicate: amazon AND category = "books" → rows 2
                evaluator: Arc::new(BitmapTreeEvaluator),
    let mut w = ArrowWriter::try_new(tmp.reopen().unwrap(), schema, Some(props)).unwrap();
        let ids = b.column(0).as_any().downcast_ref::<Int64Array>().unwrap();
        global_base,
// | 13  | apple  |    45 | archived  | electronics |
            qc
            index: i,
        Field::new("status", DataType::Utf8, false),
    let meta2 =
/// archived rows: 1,5,9,12,13. Intersection: 5, 13.
    assert_eq!(ids, vec![1, 3]);
    let parquet_meta = meta.metadata().clone();
    let ids = run_tree_row_ids(BoolNode::Or(vec![
}
// Predicate-only), we compute the EXPECTED row IDs by scanning the fixture data
        for i in 0..b.num_rows() {
        max_doc: 16,
    let size = std::fs::metadata(&path).unwrap().len();
    row_ids.sort();
        schema.clone(),
#[tokio::test]
        vec![
        evaluator_factory: factory,
        for i in 0..b.num_rows() {
    let mut rows: Vec<(i64, String, i32)> = Vec::new();
        emit_row_ids: true,
        predicate_columns: vec![0, 1, 2, 3],
        object_path: object_path2,
/// amazon rows: 0(50), 1(150), 2(80), 3(120), 12(30) → price>100: rows 1, 3.
    let path1 = tmp1.path().to_path_buf();
        prune_tree_config: None,
    let segment = SegmentFileInfo {
                page_pruner: pruner,
                stats_prune_tree: None,
        index_leaf(0), // amazon
/// Helper: compute expected row positions from fixture data given a filter.
        "Should detect __row_id__ column in projection"
        query_config: Arc::new({
        });
//
#[tokio::test]
    // SingleCollector: brand="amazon" → rows 0,1,2,3,12
 * SPDX-License-Identifier: Apache-2.0
            let pruner = Arc::new(PagePruner::new(
        assert_eq!(b.schema().field(0).name(), "__row_id__");
            qc.indexed_pushdown_filters = false;
    let ids = run_two_segments_row_ids(tree).await;
        max_doc: 16,
        "Should not detect __row_id__ in normal projection"
        parquet_size: size,
    let mut offset = 0i64;
    let expected = expected_rows(|i| BRANDS[i] != "amazon");
        object_path,
            qc.indexed_pushdown_filters = false;
                max_collector_parallelism: 1,
    // SingleCollector: status="archived" → rows 1,5,9,12,13
/// brand="apple" matches rows 4,5,6,7,13.
        let tree = Arc::clone(&tree);
                tree: Arc::new(resolved),
        );
            let resolved = tree.resolve(&per_leaf)?;
#[tokio::test]
        global_base: 16,
    let per_leaf: Vec<(i32, Arc<dyn RowGroupDocsCollector>)> = collectors
        Field::new("brand", DataType::Utf8, false),
    let per_leaf: Vec<(i32, Arc<dyn RowGroupDocsCollector>)> = collectors
                leaves: Arc::new(
                    ),
        writer_generation: 0,
    let ids = run_tree_row_ids(BoolNode::And(vec![index_leaf(1)])).await;
    let ids = run_tree_row_ids(BoolNode::Not(Box::new(index_leaf(0)))).await;
async fn test_emit_row_ids_two_segments_with_filter() {
            index: i,
    let expected = expected_rows(|i| BRANDS[i] == "amazon" && PRICES[i] > 100);
    (0..16).filter(|&i| filter(i)).map(|i| i as i64).collect()
    while let Some(batch) = stream.next().await {
    assert_eq!(ids, expected, "SingleCollector(archived) mismatch");
    // No filter — use a predicate that matches all rows (price >= 0)
    while let Some(batch) = stream.next().await {
        "Collector+Predicate(apple,price<90) mismatch"
            Arc::new(StringArray::from(CATEGORIES.to_vec())),
                rg_index_to_pos: HashMap::new(),
                    crate::indexed_table::eval::bitmap_tree::CollectorLeafBitmaps::new(
    let path2 = tmp2.path().to_path_buf();
    let tree = tree.push_not_down();
        ArrowReaderMetadata::load(&file, ArrowReaderOptions::new().with_page_index(true)).unwrap();
        parquet_size: size,
    let df = ctx.sql("SELECT \"__row_id__\" FROM t").await.unwrap();
}
    }
        let n = parquet_meta2.row_group(i).num_rows();
        assert_eq!(b.schema().field(0).name(), "__row_id__");
    let mut stream = datafusion::physical_plan::execute_stream(plan, task_ctx).unwrap();
        prune_tree_config: None,
                        _stream_metrics,
        prune_tree_config: None,
        schema: schema.clone(),
        metadata: Arc::clone(&parquet_meta),
    let mut offset = 0i64;
        sort_orders: vec![],
                max_collector_parallelism: 1,
        schema: schema.clone(),
        .into_iter()
        arrow_schema: schema.clone(),
            Ok(eval)
        pred_int("price", Operator::Gt, 100),
                    ),
#[tokio::test]
                rg_index_to_pos: HashMap::new(),
/// Verify global_base offset works: set global_base=1000 and check IDs are shifted.
        arrow_schema: schema.clone(),
    ]))
        vec![
                stats_prune_tree: None,
    assert_eq!(
    }));
                &schema,
    );
    };
        offset += n;
        global_base: 0,
        store,
    let tree = Arc::new(tree);
            let mut qc = crate::datafusion_query_config::DatafusionQueryConfig::test_default();
    // Complex: (amazon AND price>80) OR (apple AND archived)
}
    let expected = expected_rows(|i| BRANDS[i] == "apple" && PRICES[i] < 90);
    // SingleCollector: brand="apple" → rows 4,5,6,7,13
    let schema = meta1.schema().clone();
    );
                &schema,
async fn run_tree_row_ids(tree: BoolNode) -> Vec<i64> {
        max_doc: 16,
        Operator::Eq,
            let eval: Arc<dyn RowGroupBitsetSource> = Arc::new(TreeBitsetSource {
    // Project __row_id__ alongside data columns
        row_groups: rgs,
        sort_fields: vec![],
        sort_fields: vec![],
#[tokio::test]
    let mut stream = datafusion::physical_plan::execute_stream(plan, task_ctx).unwrap();
                        _stream_metrics.ffm_collector_calls.clone(),
 */
    let store: Arc<dyn object_store::ObjectStore> =
        segments: vec![segment],
        .into_iter()
    };
    let expected: Vec<i64> = vec![0, 1, 2, 3, 12, 16, 17, 18, 19, 28];
    for i in 0..parquet_meta.num_row_groups() {
        store_url,
    // Tree OR + Predicate: (amazon OR apple) AND price > 100 → rows 1,3,6,9? no...
            qc.force_strategy = Some(FilterStrategy::BooleanMask);
            let eval: Arc<dyn RowGroupBitsetSource> = Arc::new(TreeBitsetSource {
        10,
        Arc::new(object_store::local::LocalFileSystem::new());
    let mut row_ids: Vec<i64> = Vec::new();
        .set_statistics_enabled(datafusion::parquet::file::properties::EnabledStatistics::Page)
    let df = ctx.sql("SELECT \"__row_id__\" FROM t").await.unwrap();
    // Segment 1: amazon rows at positions 0,1,2,3,12 + global_base 0 = 0,1,2,3,12
// |  4  | apple  |    90 | active    | electronics |
/// Verify that __row_id__ is computed alongside data columns — not replacing them.
            qc.indexed_pushdown_filters = false;
async fn run_tree_row_ids_with_global_base(tree: BoolNode, global_base: u64) -> Vec<i64> {
        let schema = schema.clone();
    let ids = run_tree_row_ids(BoolNode::And(vec![pred_int("price", Operator::GtEq, 150)])).await;
    let store_url = datafusion::execution::object_store::ObjectStoreUrl::local_filesystem();
    ctx.register_table("t", provider).unwrap();
 * this file be licensed under the Apache-2.0 license or a
        index_leaf(1),
    ]))
                cost_predicate: 1,
    let expected: Vec<i64> = (0..32).collect();
    let size2 = std::fs::metadata(&path2).unwrap().len();
    let tree = Arc::new(tree);
    // Segment 2: amazon rows at positions 0,1,2,3,12 + global_base 16 = 16,17,18,19,28
        rgs1.push(RowGroupInfo {
        .collect();
        row_groups: rgs2,
        index_leaf(0),
    let file1 = std::fs::File::open(&path1).unwrap();
                rg_index_to_pos: HashMap::new(),
    let ids = run_tree_row_ids(BoolNode::And(vec![
        ArrowReaderMetadata::load(&file1, ArrowReaderOptions::new().with_page_index(true)).unwrap();
        segments: vec![segment1, segment2],
    let collectors = wire_collectors(&tree);
// |  7  | apple  |    60 | active    | electronics |
}
/// Segment 1 has rows 0..15 (global_base=0), segment 2 has rows 0..15 (global_base=16).
            )),
        offset += n;
    ]))
        Arc::new(object_store::local::LocalFileSystem::new());
    .await;
                    crate::indexed_table::page_pruner::PagePruneMetrics::from_stream_metrics(
        rgs.push(RowGroupInfo {
        sort_min: None,
// |  2  | amazon |    80 | active    | books       |
        }),
        let b = batch.unwrap();
    );
        evaluator_factory: factory,
        sort_max: None,
        segments: vec![segment],
    assert_eq!(ids, vec![0, 1, 2, 3, 4, 5, 6, 7, 12, 13]);
    let parquet_meta1 = meta1.metadata().clone();
// |  6  | apple  |   200 | active    | books       |
        .map(|(i, c)| (i as i32, c))
/// Exhaustive test: all query types produce correct row IDs matching fixture positions.
    assert_eq!(ids, expected, "Tree OR+Predicate mismatch");
    let plan = df.logical_plan();
                leaves: Arc::new(
        .collect();
                pruning_predicates: Arc::new(std::collections::HashMap::new()),
            first_row: offset,
        max_doc: 16,
// |  9  | google |   300 | archived  | electronics |
async fn test_emit_row_ids_single_collector_apple() {
    let ctx = SessionContext::new();
        pred_int("price", Operator::Gt, 100),
                        _stream_metrics,
        (BRANDS[i] == "amazon" && PRICES[i] > 80)
        for i in 0..b.num_rows() {
        ArrowReaderMetadata::load(&file2, ArrowReaderOptions::new().with_page_index(true)).unwrap();
        schema: schema.clone(),
// | row | brand  | price | status    | category    |
        .enumerate()
        BoolNode::Or(vec![index_leaf(0), index_leaf(1)]),
                    crate::indexed_table::page_pruner::PagePruneMetrics::from_stream_metrics(
        plan_requests_row_ids(plan),
    let meta1 =
                collector_strategy:
        !plan_requests_row_ids(plan2),
    ctx.register_table("t", Arc::new(mem_table)).unwrap();
}
    let ids = run_tree_row_ids(tree).await;
            qc.force_strategy = Some(FilterStrategy::BooleanMask);
    let tmp = write_fixture_parquet();
                rg_index_to_pos: HashMap::new(),
    let ids = run_tree_row_ids(tree).await;
async fn test_row_id_column_detection() {
    let collectors = wire_collectors(&tree);
                        _stream_metrics,
    let file = std::fs::File::open(&path).unwrap();
                collector_strategy:
    let ids = run_tree_row_ids(tree).await;
                STATUSES.to_vec(),
            qc.indexed_pushdown_filters = false;
    let store: Arc<dyn object_store::ObjectStore> =
        let col = b.column(0).as_any().downcast_ref::<Int64Array>().unwrap();
        assert_eq!(b.schema().field(2).name(), "price");
    let object_path = object_store::path::Path::from(path.to_string_lossy().as_ref());
    let mut stream = datafusion::physical_plan::execute_stream(plan, task_ctx).unwrap();
    assert_eq!(rows[0], (0, "amazon".to_string(), 50));
    let expected = expected_rows(|i| BRANDS[i] == "amazon" && CATEGORIES[i] == "books");
    // NOT(collector): NOT(amazon) → rows 4-11,13-15
        "should have 10 row IDs (5 amazon rows per segment)"
        query_config: Arc::new({
// | 14  | samsung|    99 | active    | electronics |
                pruning_predicates: Arc::new(std::collections::HashMap::new()),
    )
            let resolved = tree.resolve(&per_leaf)?;
    let factory: super::super::table_provider::EvaluatorFactory = {
/// Write fixture parquet with `__row_id__` column name for emit_row_ids tests.
                Arc::clone(&segment.metadata),
        pushdown_predicate: None,
                page_prune_metrics: Some(
}
    let mut offset = 0i64;
    let provider = Arc::new(IndexedTableProvider::new(IndexedTableConfig {
        Arc::new(move |segment, _chunk, _stream_metrics, _stats_prune_tree| {
        let n = parquet_meta1.row_group(i).num_rows();
            let mut qc = crate::datafusion_query_config::DatafusionQueryConfig::test_default();
        Arc::new(object_store::local::LocalFileSystem::new());
        emit_row_ids: true,
async fn run_two_segments_row_ids(tree: BoolNode) -> Vec<i64> {
    ctx.register_table("t", provider).unwrap();
        sort_max: None,
    let collectors = wire_collectors(&tree);
    assert_eq!(ids, expected, "Complex OR(AND,AND) mismatch");
    let expected = expected_rows(|i| {
/// brand="amazon" matches rows 0,1,2,3,12 within each segment.
                max_collector_parallelism: 1,
    for i in 0..parquet_meta.num_row_groups() {
    // Collector + Predicate: apple AND price < 90 → rows 7,13
    let ids = run_two_segments_row_ids(tree).await;
    .await;
#[tokio::test]
        .map(|(i, c)| (i as i32, c))
    let provider = Arc::new(IndexedTableProvider::new(IndexedTableConfig {
    let provider = Arc::new(IndexedTableProvider::new(IndexedTableConfig {
/// Test: two segments produce globally unique row IDs.
    assert_eq!(ids, expected, "Multi-predicate(50<price<100) mismatch");
async fn test_emit_row_ids_two_collectors_and() {
        sort_min: None,
    Arc::new(Schema::new(vec![
        sort_fields: vec![],
            ));
            Arc::new(datafusion::arrow::array::StringArray::from(BRANDS.to_vec())),
    };
    // Filter: brand = "amazon" (rows 0,1,2,3,12)
// |  3  | amazon |   120 | active    | electronics |
        })
        BoolNode::And(vec![index_leaf(0), pred_int("price", Operator::Gt, 80)]),
                evaluator: Arc::new(BitmapTreeEvaluator),
    }
                cost_predicate: 1,
/// Helper: run a query with `emit_row_ids=true` across two segments and return sorted row IDs.
// Why it is complex -->
    ]))
    let ids = run_tree_row_ids(BoolNode::And(vec![
    let plan2 = df2.logical_plan();
        rgs.push(RowGroupInfo {
        global_base: 0,
        ],
        sort_max: None,
        index_leaf(0),
            first_row: offset,
            qc.target_partitions = 1;
    let task_ctx = ctx.task_ctx();
/*
    let tree = BoolNode::And(vec![index_leaf(0)]).push_not_down();
    let row_ids: Vec<i64> = (0..16).collect();
                page_prune_metrics: Some(
}
        sort_min: None,
    let batch = datafusion::arrow::record_batch::RecordBatch::try_new(
    let expected = expected_rows(|i| BRANDS[i] == "apple" && STATUSES[i] == "archived");
    let expected = expected_rows(|i| BRANDS[i] == "apple");
        ArrowReaderMetadata::load(&file, ArrowReaderOptions::new().with_page_index(true)).unwrap();
    let expected = expected_rows(|i| STATUSES[i] == "active");
        metadata: Arc::clone(&parquet_meta),
        cancellation_token: None,
    };
