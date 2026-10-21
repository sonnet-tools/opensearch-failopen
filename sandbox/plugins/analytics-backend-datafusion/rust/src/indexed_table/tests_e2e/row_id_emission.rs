        query_config: Arc::new({
                Arc::clone(&segment.metadata),
}
        let per_leaf = per_leaf.clone();
        max_doc: 16,
        "Should detect __row_id__ column in projection"
    assert!(
        "active",
                    ),
                max_collector_parallelism: 1,
    let ids = run_tree_row_ids(tree).await;
        }
// directly, then compare against what emit_row_ids produces.
        assert_eq!(b.schema().field(2).name(), "price");
    let tree = BoolNode::And(vec![index_leaf(1), index_leaf(2)]);
    // Load metadata for segment 2
    let collectors = wire_collectors(&tree);
    .await;
#[tokio::test]
        object_path: object_path1,
                        _stream_metrics.ffm_collector_calls.clone(),
/// With global_base=1000, brand="amazon" (rows 0,1,2,3,12) should give 1000,1001,1002,1003,1012.
                tree: Arc::new(resolved),
    let size = std::fs::metadata(&path).unwrap().len();
    let expected = expected_rows(|i| BRANDS[i] == "amazon" || BRANDS[i] == "apple");
    let tree = BoolNode::And(vec![index_leaf(0)]);
// |  1  | amazon |   150 | archived  | electronics |
    let size1 = std::fs::metadata(&path1).unwrap().len();
    let tmp = write_fixture_parquet();
async fn test_emit_row_ids_or_two_collectors() {
    let plan2 = df2.logical_plan();
            Ok(eval)
                    ),
            )),
    let mut rgs = Vec::new();
        query_config: Arc::new({
        let schema = schema.clone();
    let factory: super::super::table_provider::EvaluatorFactory = {
        Arc::new(object_store::local::LocalFileSystem::new());
    let ids = run_tree_row_ids(BoolNode::Not(Box::new(index_leaf(0)))).await;
    let expected =
        metadata: Arc::clone(&parquet_meta),
            qc
        "filtered row IDs should be offset by global_base"
    let ids = run_tree_row_ids(BoolNode::And(vec![pred_int("price", Operator::Lt, 50)])).await;
                Arc::clone(&segment.metadata),
        let schema = schema.clone();
                evaluator: Arc::new(BitmapTreeEvaluator),
    // Complex: (amazon AND price>80) OR (apple AND archived)
        pushdown_predicate: None,
    for i in 0..parquet_meta.num_row_groups() {
                cost_predicate: 1,
            let mut qc = crate::datafusion_query_config::DatafusionQueryConfig::test_default();
            Arc::new(datafusion::arrow::array::StringArray::from(
    assert_eq!(ids.len(), 32, "should have 32 row IDs (16 per segment)");
                    ),
    let ids = run_tree_row_ids(BoolNode::And(vec![
                    ),
    let store: Arc<dyn object_store::ObjectStore> =
        row_groups: rgs1,
        .into_iter()
            ));
                    crate::indexed_table::page_pruner::PagePruneMetrics::from_stream_metrics(
    let meta =
    let store_url = datafusion::execution::object_store::ObjectStoreUrl::local_filesystem();
        pred_int("price", Operator::Gt, 50),
    while let Some(batch) = stream.next().await {
        });
    // brand="amazon" rows: 0,1,2,3,12
    assert_eq!(ids, vec![4, 5, 6, 7, 13]);
        ],
            qc.target_partitions = 1;
        global_base,
    // Collector tag 0 = brand_eq("amazon")
    let file = std::fs::File::open(&path).unwrap();
    let mut row_ids: Vec<i64> = Vec::new();
/// and suffix) matching what `IndexedTableProvider.scan()` looks for.
    ctx.register_table("t", provider).unwrap();
        sort_min: None,
/*
    let object_path = object_store::path::Path::from(path.to_string_lossy().as_ref());
            qc
/// AND(brand="amazon", price > 100) matches rows where brand=amazon AND price>100.
    assert_eq!(
        Field::new("__row_id__", DataType::Int64, false),
                    ),
    w.close().unwrap();
        sort_fields: vec![],
    let segment1 = SegmentFileInfo {
        pushdown_predicate: None,
        segments: vec![segment1, segment2],
    let mut offset = 0i64;
        store_url,
        rgs2.push(RowGroupInfo {
    // Project __row_id__ — it will be computed from position, not read from parquet
    let plan = df.create_physical_plan().await.unwrap();
#[tokio::test]
    let expected = expected_rows(|i| PRICES[i] >= 150);
    ctx.register_table("t", provider).unwrap();
        ids, expected,
    let df2 = ctx.sql("SELECT brand FROM t").await.unwrap();
            Arc::new(StringArray::from(STATUSES.to_vec())),
    );
#[tokio::test]
    let df = ctx.sql("SELECT \"__row_id__\" FROM t").await.unwrap();
            let resolved = tree.resolve(&per_leaf)?;
            Arc::new(datafusion::arrow::array::Int64Array::from(row_ids)),
                    crate::indexed_table::eval::bitmap_tree::CollectorLeafBitmaps::new(
            first_row: offset,
        sort_min: None,
        let ids = b.column(0).as_any().downcast_ref::<Int64Array>().unwrap();
                    ),
            first_row: offset,
    let mut row_ids: Vec<i64> = Vec::new();
        });
        sort_orders: vec![],
    );
    let ids = run_tree_row_ids(BoolNode::And(vec![index_leaf(0)])).await;
        evaluator_factory: factory,
                        _stream_metrics,
            qc.force_strategy = Some(FilterStrategy::BooleanMask);
// | 10  | samsung|    70 | active    | electronics |
//
    let expected = expected_rows(|i| STATUSES[i] == "archived");
    };
                max_collector_parallelism: 1,
/// Verify global_base offset works: set global_base=1000 and check IDs are shifted.
        object_path: object_path2,
#[tokio::test]
    let collectors = wire_collectors(&tree);
//! instead of actual data columns.
            ));
// |  4  | apple  |    90 | active    | electronics |
    for i in 0..parquet_meta.num_row_groups() {
    .await;
    let parquet_meta1 = meta1.metadata().clone();
//! Verifies that the indexed query path can return global row IDs
    }));
        arrow_schema: schema.clone(),
                max_collector_parallelism: 1,
    let schema = meta.schema().clone();
            let pruner = Arc::new(PagePruner::new(
    let size2 = std::fs::metadata(&path2).unwrap().len();
        ArrowReaderMetadata::load(&file2, ArrowReaderOptions::new().with_page_index(true)).unwrap();
    let tree = BoolNode::And(vec![index_leaf(1)]);
        .set_statistics_enabled(datafusion::parquet::file::properties::EnabledStatistics::Page)
// ── Tests ────────────────────────────────────────────────────────────
                        _stream_metrics.ffm_collector_calls.clone(),
    let object_path1 = object_store::path::Path::from(path1.to_string_lossy().as_ref());
    let mut offset = 0i64;
    let plan = df.create_physical_plan().await.unwrap();
    let df = ctx.sql("SELECT \"__row_id__\" FROM t").await.unwrap();
    let ids = run_two_segments_row_ids(tree).await;
    let tree = Arc::new(tree);
                cost_collector: 10,
/// Verify that __row_id__ is computed alongside data columns — not replacing them.
    .await;
            let resolved = tree.resolve(&per_leaf)?;
        let b = batch.unwrap();
            let pruner = Arc::new(PagePruner::new(
    };
}
    )
    assert_eq!(ids, vec![0, 1, 2, 3, 12]);
    assert_eq!(
/// Segment 1 has rows 0..15 (global_base=0), segment 2 has rows 0..15 (global_base=16).
            index: i,
            qc.force_strategy = Some(FilterStrategy::BooleanMask);
        prune_tree_config: None,
    assert_eq!(
        .enumerate()
}
    let segment = SegmentFileInfo {
    let expected = expected_rows(|i| BRANDS[i] == "amazon");
    row_ids.sort();
    let df = ctx.sql("SELECT \"__row_id__\" FROM t").await.unwrap();
                    ),
            let mut qc = crate::datafusion_query_config::DatafusionQueryConfig::test_default();
    row_ids
    // Collector + string predicate: amazon AND category = "books" → rows 2
    let collectors = wire_collectors(&tree);
    // SingleCollector: brand="amazon" → rows 0,1,2,3,12
        pred_str("category", Operator::Eq, "books"),
    let segment2 = SegmentFileInfo {
        }),
    while let Some(batch) = stream.next().await {
        .into_iter()
        parquet_size: size,
    assert!(
    }
    let ids = run_tree_row_ids(BoolNode::And(vec![index_leaf(1), index_leaf(2)])).await;
// Optimizer + ComputeRowId --> @gbh --> optimizer --> for parquet only right
            b.num_columns(),
                rg_index_to_pos: HashMap::new(),
    let path = tmp.path().to_path_buf();
    let expected: Vec<i64> = (0..32).collect();
    // Tree OR + Predicate: (amazon OR apple) AND price > 100 → rows 1,3,6,9? no...
                collector_strategy:
    // amazon(0,1,2,3,12) OR apple(4,5,6,7,13) = 0-7,12,13. price>100: 1,3,6
    let task_ctx = ctx.task_ctx();
        let b = batch.unwrap();
    let parquet_meta = meta.metadata().clone();
        cancellation_token: None,
    ctx.register_table("t", provider).unwrap();
    let schema = meta.schema().clone();
    let df = ctx.sql("SELECT \"__row_id__\" FROM t").await.unwrap();
    let plan = df.create_physical_plan().await.unwrap();
                schema.clone(),
    tmp
        Field::new("status", DataType::Utf8, false),
        BoolNode::And(vec![index_leaf(0), pred_int("price", Operator::Gt, 80)]),
}
    assert_eq!(ids, expected, "SingleCollector(amazon) mismatch");
                stats_prune_tree: None,
        }
    let task_ctx = ctx.task_ctx();
        "status",
    let tree = tree.push_not_down();
        BoolNode::Or(vec![index_leaf(0), index_leaf(1)]),
        let n = parquet_meta.row_group(i).num_rows();
        .collect();
    let ctx = SessionContext::new();
        sort_max: None,
            let mut qc = crate::datafusion_query_config::DatafusionQueryConfig::test_default();
        sort_orders: vec![],
        arrow_schema: schema.clone(),
        .into_iter()
    let mut stream = datafusion::physical_plan::execute_stream(plan, task_ctx).unwrap();
        emit_row_ids: true,
    }));
                pruning_predicates: Arc::new(std::collections::HashMap::new()),
    };
    let expected = expected_rows(|i| PRICES[i] > 50 && PRICES[i] < 100);
                tree: Arc::new(resolved),
            rows.push((ids.value(i), brands.value(i).to_string(), prices.value(i)));
        row_groups: rgs,
    for i in 0..parquet_meta1.num_row_groups() {
#[tokio::test]
    let per_leaf: Vec<(i32, Arc<dyn RowGroupDocsCollector>)> = collectors
    assert_eq!(
        let per_leaf = per_leaf.clone();
    let path = tmp.path().to_path_buf();
                cost_predicate: 1,
/// Helper: run a query with `emit_row_ids=true` across two segments and return sorted row IDs.
        pushdown_predicate: None,
            num_rows: n,
    let per_leaf: Vec<(i32, Arc<dyn RowGroupDocsCollector>)> = collectors
    assert_eq!(rows[3], (3, "amazon".to_string(), 120));
    let file = std::fs::File::open(&path).unwrap();
        segments: vec![segment],
        sort_max: None,
    let meta2 =
    let ids = run_tree_row_ids(BoolNode::And(vec![
    // Multi-predicate: price > 50 AND price < 100 → rows 2,4,5,7,10,14,15
        "Should not detect __row_id__ in normal projection"
    let expected = expected_rows(|i| BRANDS[i] == "apple");
        ArrowReaderMetadata::load(&file, ArrowReaderOptions::new().with_page_index(true)).unwrap();
                schema.clone(),
    // Collector tag 0 = brand_eq("amazon") — matches rows 0,1,2,3,12
    row_ids.sort();
    let meta =
                &schema,
            index: i,
                &schema,
async fn run_two_segments_row_ids(tree: BoolNode) -> Vec<i64> {
    assert_eq!(ids, expected, "SingleCollector(archived) mismatch");
    let unique: std::collections::HashSet<i64> = ids.iter().copied().collect();
        "Collector+Predicate(apple,price<90) mismatch"
                schema.clone(),
// |  2  | amazon |    80 | active    | books       |
async fn test_emit_row_ids_with_global_base_offset() {
    let path = tmp.path().to_path_buf();
        let schema = schema.clone();
        sort_max: None,
    // Predicate only: price >= 150 → rows 1,6,9,11
            qc.indexed_pushdown_filters = false;
    assert_eq!(ids, vec![0, 1, 2, 3, 4, 5, 6, 7, 12, 13]);
    assert_eq!(rows[2], (2, "amazon".to_string(), 80));
            Ok(eval)
    let ids = run_tree_row_ids(tree).await;
/// Exhaustive test: all query types produce correct row IDs matching fixture positions.
                collector_strategy:
    let ids = run_tree_row_ids(BoolNode::And(vec![
                    crate::indexed_table::eval::bitmap_tree::CollectorLeafBitmaps::new(
            index: i,
        .collect();
                    crate::indexed_table::page_pruner::PagePruneMetrics::from_stream_metrics(
        sort_fields: vec![],
            ));
        let n = parquet_meta.row_group(i).num_rows();
        store_url,
        });
            3,
            });
        store,
}
                ),
use datafusion::arrow::array::Int64Array;
/// Build fixture schema with `__row_id__` column name (double underscore prefix
    let factory: super::super::table_provider::EvaluatorFactory = {
// ── Comprehensive correctness: verify emitted row IDs match actual positions ──
#[tokio::test]
                leaves: Arc::new(
                    crate::indexed_table::eval::CollectorCallStrategy::TightenOuterBounds,
        !plan_requests_row_ids(plan2),
        "Collector+Predicate(amazon,price>100) mismatch"
    let ids = run_tree_row_ids(BoolNode::Or(vec![index_leaf(0), index_leaf(1)])).await;
                cost_predicate: 1,
        let per_leaf = per_leaf.clone();
    let expected = expected_rows(|i| {
    let provider = Arc::new(IndexedTableProvider::new(IndexedTableConfig {
        offset += n;
        let tree = Arc::clone(&tree);
            qc.force_strategy = Some(FilterStrategy::BooleanMask);
    let mut stream = datafusion::physical_plan::execute_stream(plan, task_ctx).unwrap();
async fn test_emit_row_ids_collector_and_predicate() {
        Field::new("price", DataType::Int32, false),
 * compatible open source license.
        evaluator_factory: factory,
        predicate_columns: vec![0, 1, 2, 3],
            ));
        let n = parquet_meta2.row_group(i).num_rows();
        rgs.push(RowGroupInfo {
        pred_int("price", Operator::Lt, 100),
        })
    let tree = BoolNode::And(vec![
        Arc::new(object_store::local::LocalFileSystem::new());
        }),
                page_pruner: pruner,
    let tree = BoolNode::And(vec![pred_int("price", Operator::GtEq, 0)]);
    }
    let props = datafusion::parquet::file::properties::WriterProperties::builder()
        offset += n;
    let meta =
    rows.sort_by_key(|r| r.0);
    let object_path = object_store::path::Path::from(path.to_string_lossy().as_ref());
    };
    let mut stream = datafusion::physical_plan::execute_stream(plan, task_ctx).unwrap();
#[tokio::test]
        schema: schema.clone(),
    let ids = run_tree_row_ids(BoolNode::And(vec![index_leaf(2)])).await;
    // Plan without __row_id__ — should NOT be detected
        writer_generation: 0,
        let tree = Arc::clone(&tree);
    assert_eq!(rows[1], (1, "amazon".to_string(), 150));
                leaves: Arc::new(
        .enumerate()
        index_leaf(0), // amazon
        .map(|(i, c)| (i as i32, c))
    );
            Ok(eval)
        metadata: Arc::clone(&parquet_meta2),
        max_doc: 16,
        let brands = b.column(1).as_any().downcast_ref::<StringArray>().unwrap();
        assert_eq!(b.schema().field(0).name(), "__row_id__");
    // Predicate only: price < 50 → rows 8,12,13
            qc.indexed_pushdown_filters = false;
    let ids = run_tree_row_ids(tree).await;
        .enumerate()
    let ids = run_tree_row_ids(BoolNode::And(vec![
    };
        pred_int("price", Operator::Lt, 90),
    let plan = df.logical_plan();
    );
    let path2 = tmp2.path().to_path_buf();
            let eval: Arc<dyn RowGroupBitsetSource> = Arc::new(TreeBitsetSource {
                    crate::indexed_table::page_pruner::PagePruneMetrics::from_stream_metrics(
        assert_eq!(b.num_columns(), 1, "should have only __row_id__ column");
            Arc::new(StringArray::from(CATEGORIES.to_vec())),
        pushdown_predicate: None,
    let tmp = write_fixture_parquet();
    // Load metadata for segment 1
                evaluator: Arc::new(BitmapTreeEvaluator),
                    crate::indexed_table::eval::CollectorCallStrategy::TightenOuterBounds,
// |  3  | amazon |   120 | active    | electronics |
    let meta1 =
    let expected = expected_rows(|i| BRANDS[i] == "amazon" && PRICES[i] > 100);
    let ctx = SessionContext::new();
}
    ]))
            Arc::new(Int32Array::from(PRICES.to_vec())),
        schema.clone(),
    let mem_table =
                stats_prune_tree: None,
            first_row: offset,
        Field::new("category", DataType::Utf8, false),
        assert_eq!(b.schema().field(0).name(), "__row_id__");
    let expected = expected_rows(|i| BRANDS[i] != "amazon");
    let mut stream = datafusion::physical_plan::execute_stream(plan, task_ctx).unwrap();
    assert_eq!(ids, expected, "row IDs should cover 0..31 with no gaps");
// | row | brand  | price | status    | category    |
        segments: vec![segment],
// For each query type (SingleCollector, Collector+Predicate, Tree OR, Tree AND,
        max_doc: 16,
/// Test: two segments produce globally unique row IDs.
        Arc::new(move |segment, _chunk, _stream_metrics, _stats_prune_tree| {
fn expected_rows(filter: impl Fn(usize) -> bool) -> Vec<i64> {
        let per_leaf = per_leaf.clone();
                page_prune_metrics: Some(
    let ids = run_tree_row_ids(BoolNode::And(vec![pred_int("price", Operator::GtEq, 150)])).await;
    // Verify uniqueness explicitly
        store_url,
    .await;
    }
                tree: Arc::new(resolved),
}
        pred_int("price", Operator::Gt, 100),
    let tree = Arc::new(tree);
/// Combined unfiltered query should produce IDs 0..31 with no gaps.
        row_groups: rgs2,
        metadata: Arc::clone(&parquet_meta1),
    let collectors = wire_collectors(&tree);
        row_groups: rgs,
    assert_eq!(ids, expected, "Tree OR+Predicate mismatch");
    };
                        _stream_metrics,
    let tmp = write_fixture_parquet();
    let ids = run_tree_row_ids(tree).await;
        }
    let ids = run_tree_row_ids(BoolNode::And(vec![pred_str(
        predicate_columns: vec![0, 1, 2, 3],
    let parquet_meta = meta.metadata().clone();
// | 14  | samsung|    99 | active    | electronics |
//
/// OR(brand="amazon", brand="apple") matches rows 0-7, 12, 13.
                page_prune_metrics: Some(
                rg_index_to_pos: HashMap::new(),
    ]);
}
            index: i,
    assert_eq!(ids, vec![1000, 1001, 1002, 1003, 1012]);
        .unwrap();
fn build_row_id_fixture_schema() -> SchemaRef {
#[tokio::test]
    row_ids.sort();
    .await;
// | 15  | google |    55 | active    | electronics |
        .set_max_row_group_size(8)
        Operator::Eq,
}
        assert_eq!(b.schema().field(0).name(), "__row_id__");
        datafusion::datasource::MemTable::try_new(schema.clone(), vec![vec![batch]]).unwrap();
        .build();
    }));
    ]))
            )),
                cost_collector: 10,
                page_prune_metrics: Some(
        for i in 0..b.num_rows() {
    let tmp1 = write_row_id_fixture_parquet();
    assert_eq!(ids, vec![5, 13]);
        query_config: Arc::new({
            || (BRANDS[i] == "apple" && STATUSES[i] == "archived")
        metadata: Arc::clone(&parquet_meta),
        for i in 0..b.num_rows() {
        Arc::new(move |segment, _chunk, _stream_metrics, _stats_prune_tree| {
/// brand="amazon" matches rows 0,1,2,3,12 — verify we get those row IDs back.
    // Collector + Predicate: amazon AND price > 100 → rows 1,3
                page_prune_metrics: Some(
    ]))
                evaluator: Arc::new(BitmapTreeEvaluator),
            row_ids.push(col.value(i));
        Arc::new(object_store::local::LocalFileSystem::new());
/// brand="apple" matches rows 4,5,6,7,13.
    let mut rgs1 = Vec::new();
        plan_requests_row_ids(plan),
        assert_eq!(b.schema().field(1).name(), "brand");
            let eval: Arc<dyn RowGroupBitsetSource> = Arc::new(TreeBitsetSource {
        Field::new("brand", DataType::Utf8, false),
        Arc::new(move |segment, _chunk, _stream_metrics, _stats_prune_tree| {
                page_pruner: pruner,
        evaluator_factory: factory,
            let resolved = tree.resolve(&per_leaf)?;
/// Segment 1 (global_base=0) gives IDs: 0,1,2,3,12
            qc
        emit_row_ids: true,
    ]))
    );
        .map(|(i, c)| (i as i32, c))
    // Project __row_id__ alongside data columns
    let mut offset = 0i64;
#[tokio::test]
    ]))
    assert_eq!(unique.len(), 32, "all 32 row IDs should be unique");
    let per_leaf: Vec<(i32, Arc<dyn RowGroupDocsCollector>)> = collectors
        arrow_schema: schema.clone(),
        segments: vec![segment],
    }
        emit_row_ids: true,
            qc.target_partitions = 1;
    // Each segment has 16 rows. With global_base=0 and global_base=16,
// | 12  | amazon |    30 | archived  | electronics |
        "should have 10 row IDs (5 amazon rows per segment)"
        Arc::new(move |segment, _chunk, _stream_metrics, _stats_prune_tree| {
    let store: Arc<dyn object_store::ObjectStore> =
            "should have 3 columns: __row_id__, brand, price"
}
    let tree = Arc::new(tree);
    let ids = run_tree_row_ids(BoolNode::Or(vec![
    let task_ctx = ctx.task_ctx();
                stats_prune_tree: None,
        parquet_size: size,
    while let Some(batch) = stream.next().await {
                    crate::indexed_table::eval::bitmap_tree::CollectorLeafBitmaps::new(
            let pruner = Arc::new(PagePruner::new(
        assert_eq!(b.num_columns(), 1, "should have only __row_id__ column");
// Why it is complex -->
    row_ids
            qc
        let b = batch.unwrap();
            qc.target_partitions = 1;
        });
        ids, expected,
            Arc::new(datafusion::arrow::array::StringArray::from(
/// segment 2 has global_base=16, so combined IDs span 0..31.
    let store_url = datafusion::execution::object_store::ObjectStoreUrl::local_filesystem();
        prune_tree_config: None,
    }
    let file2 = std::fs::File::open(&path2).unwrap();
            index: i,
        .map(|(i, c)| (i as i32, c))
    let ctx = SessionContext::new();
    let task_ctx = ctx.task_ctx();
        })
        let prices = b.column(2).as_any().downcast_ref::<Int32Array>().unwrap();
        ArrowReaderMetadata::load(&file, ArrowReaderOptions::new().with_page_index(true)).unwrap();
                leaves: Arc::new(
        object_path,
    assert_eq!(ids, expected, "NOT(amazon) mismatch");
        }),
        }
                evaluator: Arc::new(BitmapTreeEvaluator),
    }));
/// Helper: run a tree with `emit_row_ids: true` and return the collected row IDs.
        (BRANDS[i] == "amazon" && PRICES[i] > 80)
        sort_fields: vec![],
// | 11  | samsung|   150 | active    | books       |
}
    let tree = BoolNode::And(vec![index_leaf(0)]).push_not_down();
    for i in 0..parquet_meta.num_row_groups() {
        prune_tree_config: None,
        emit_row_ids: true,
        max_doc: 16,
    let mut w = ArrowWriter::try_new(tmp.reopen().unwrap(), schema, Some(props)).unwrap();
                page_pruner: pruner,
    let expected: Vec<i64> = vec![0, 1, 2, 3, 12, 16, 17, 18, 19, 28];
            Arc::new(Int64Array::from(row_ids)),
            let resolved = tree.resolve(&per_leaf)?;
            qc.force_strategy = Some(FilterStrategy::BooleanMask);
    });
        ids, expected,
        global_base: 0,
                schema.clone(),
/// AND(brand="apple", status="archived") — apple rows: 4,5,6,7,13;
    let tree = tree.push_not_down();
        .collect();
            Arc::new(StringArray::from(BRANDS.to_vec())),
    Arc::new(Schema::new(vec![
    (0..16).filter(|&i| filter(i)).map(|i| i as i64).collect()
    let mut offset = 0i64;
    assert_eq!(ids, expected, "SingleCollector(apple) mismatch");
    let parquet_meta = meta.metadata().clone();
        for i in 0..b.num_rows() {
    // Tree AND: apple AND archived → rows 5,13
                        _stream_metrics,
    assert_eq!(ids, expected, "Collector+String(amazon,books) mismatch");
                        _stream_metrics.ffm_collector_calls.clone(),
    let row_ids: Vec<i64> = (0..16).collect();
        Arc::new(object_store::local::LocalFileSystem::new());
                tree: Arc::new(resolved),
                ),
                max_collector_parallelism: 1,
    let mut rgs = Vec::new();
async fn run_tree_row_ids(tree: BoolNode) -> Vec<i64> {
        sort_min: None,
 */
        assert_eq!(
    let expected = expected_rows(|i| BRANDS[i] == "apple" && PRICES[i] < 90);
        let b = batch.unwrap();
                &schema,
    // Segment 2: amazon rows at positions 0,1,2,3,12 + global_base 16 = 16,17,18,19,28
        let n = parquet_meta1.row_group(i).num_rows();
    ctx.register_table("t", Arc::new(mem_table)).unwrap();
        let col = b.column(0).as_any().downcast_ref::<Int64Array>().unwrap();
    let schema = meta1.schema().clone();
    use crate::indexed_table::substrait_to_tree::plan_requests_row_ids;
        offset += n;
    let tree = BoolNode::And(vec![index_leaf(0)]);
        .enumerate()
        rgs.push(RowGroupInfo {
}
        10,
                leaves: Arc::new(
        .map(|(i, c)| (i as i32, c))
                pruning_predicates: Arc::new(std::collections::HashMap::new()),
                stats_prune_tree: None,
                        _stream_metrics,
        }),
            let eval: Arc<dyn RowGroupBitsetSource> = Arc::new(TreeBitsetSource {
    let store: Arc<dyn object_store::ObjectStore> =
        pred_int("price", Operator::Gt, 100),
            num_rows: n,
                &schema,
    // Segment 1: amazon rows at positions 0,1,2,3,12 + global_base 0 = 0,1,2,3,12
/// Test: filtered query across two segments returns correct global IDs.
    assert_eq!(ids, expected, "Tree AND(apple,archived) mismatch");
    let batch = RecordBatch::try_new(
        store,
async fn test_emit_row_ids_two_segments_global_base() {
        let col = b.column(0).as_any().downcast_ref::<Int64Array>().unwrap();
    let mut offset = 0i64;
        offset += n;
        index_leaf(1),
    let store_url = datafusion::execution::object_store::ObjectStoreUrl::local_filesystem();
        sort_min: None,
    .await;
            });
    let segment = SegmentFileInfo {
    // we expect all IDs from 0 through 31 inclusive.
    let ids = run_two_segments_row_ids(tree).await;
                rg_index_to_pos: HashMap::new(),
        object_path,
        sort_orders: vec![],
    let tree = BoolNode::Or(vec![index_leaf(0), index_leaf(1)]);
    let row_ids: Vec<i64> = (0..16).collect();
            Arc::new(datafusion::arrow::array::StringArray::from(BRANDS.to_vec())),
                    crate::indexed_table::eval::CollectorCallStrategy::TightenOuterBounds,
        store,
                pruning_predicates: Arc::new(std::collections::HashMap::new()),
        .sql("SELECT \"__row_id__\", brand, price FROM t")
// Lot of query shapes --> for the query sent, how will that translate into at the data node side?
    w.write(&batch).unwrap();
            num_rows: n,
                ),
    let file1 = std::fs::File::open(&path1).unwrap();
        writer_generation: 0,
}
    let mut rgs = Vec::new();
// ── Multi-segment row ID tests ──────────────────────────────────────────────
        cancellation_token: None,
    )
    let store: Arc<dyn object_store::ObjectStore> =
    let file = std::fs::File::open(&path).unwrap();
    let expected = expected_rows(|i| PRICES[i] < 50);
        schema: schema.clone(),
    assert_eq!(ids, expected, "Tree OR(amazon,apple) mismatch");
        index_leaf(0),
        evaluator_factory: factory,
        offset += n;
    let factory: super::super::table_provider::EvaluatorFactory = {
            });
                ),
    assert_eq!(rows.len(), 5);
    // String predicate: status = "active" → rows 0,2,3,4,6,7,8,10,11,14,15
        global_base: 0,
    let mut rgs2 = Vec::new();
                ),
    let schema = build_row_id_fixture_schema();
        })
    let path1 = tmp1.path().to_path_buf();
            let eval: Arc<dyn RowGroupBitsetSource> = Arc::new(TreeBitsetSource {
        vec![
    assert_eq!(ids, expected, "Predicate-only(price<50) mismatch");
    let tmp2 = write_row_id_fixture_parquet();
    let provider = Arc::new(IndexedTableProvider::new(IndexedTableConfig {
        ArrowReaderMetadata::load(&file1, ArrowReaderOptions::new().with_page_index(true)).unwrap();
// |  8  | google |    40 | active    | electronics |
            qc.indexed_pushdown_filters = false;
    // SingleCollector: brand="apple" → rows 4,5,6,7,13
    let ids = run_tree_row_ids(tree).await;
            let pruner = Arc::new(PagePruner::new(
            Ok(eval)
    let factory: super::super::table_provider::EvaluatorFactory = {
        row_groups: rgs,
async fn test_emit_row_ids_two_collectors_and() {
#[tokio::test]
 * this file be licensed under the Apache-2.0 license or a
    let expected = expected_rows(|i| BRANDS[i] == "apple" && STATUSES[i] == "archived");
async fn test_all_query_types_match_fixture_positions() {
    // SingleCollector: status="archived" → rows 1,5,9,12,13
        store,
    let per_leaf: Vec<(i32, Arc<dyn RowGroupDocsCollector>)> = collectors
    let segment = SegmentFileInfo {
    let expected = expected_rows(|i| BRANDS[i] == "amazon" && CATEGORIES[i] == "books");
/// Segment 2 (global_base=16) gives IDs: 16,17,18,19,28
    let ids = run_tree_row_ids_with_global_base(tree, 1000).await;
/// Projects [__row_id__, brand, price] and verifies all three are present and correct.
        store_url,
    .unwrap();
    assert_eq!(rows[0], (0, "amazon".to_string(), 50));
        predicate_columns: vec![0, 1, 2, 3],
    assert_eq!(rows[4], (12, "amazon".to_string(), 30));
        arrow_schema: schema.clone(),
            qc.target_partitions = 1;
    let plan = df.create_physical_plan().await.unwrap();
    let ids = run_tree_row_ids(BoolNode::And(vec![
        index_leaf(0),
use super::*;
            first_row: offset,
        arrow_schema: schema.clone(),
        ids.len(),
        assert_eq!(b.schema().field(0).name(), "__row_id__");
    let object_path = object_store::path::Path::from(path.to_string_lossy().as_ref());
    ctx.register_table("t", provider).unwrap();
        ],
// Predicate-only), we compute the EXPECTED row IDs by scanning the fixture data
    // Collector + Predicate: apple AND price < 90 → rows 7,13
    assert_eq!(ids, expected, "Predicate-only(price>=150) mismatch");
    }
// | 13  | apple  |    45 | archived  | electronics |
                ),
/// brand="amazon" matches rows 0,1,2,3,12 within each segment.
        vec![
    ]))
        let schema = schema.clone();
    ]))
                pruning_predicates: Arc::new(std::collections::HashMap::new()),
                ),
#[tokio::test]
                cost_predicate: 1,
                STATUSES.to_vec(),
async fn run_tree_row_ids_with_global_base(tree: BoolNode, global_base: u64) -> Vec<i64> {
                collector_strategy:
    .await;
    let ctx = SessionContext::new();
    let parquet_meta2 = meta2.metadata().clone();
 * SPDX-License-Identifier: Apache-2.0
        parquet_size: size1,
}
    let object_path2 = object_store::path::Path::from(path2.to_string_lossy().as_ref());
                page_pruner: pruner,
    let expected = expected_rows(|i| STATUSES[i] == "active");
    let schema = build_fixture_schema();
                CATEGORIES.to_vec(),
        .await
    let ctx = SessionContext::new();
    let batch = datafusion::arrow::record_batch::RecordBatch::try_new(
        parquet_size: size,
async fn test_emit_row_ids_two_segments_with_filter() {
async fn test_row_id_column_detection() {
    // Filter: brand = "amazon" (rows 0,1,2,3,12)
        global_base: 0,
    }
async fn test_emit_row_ids_single_collector_apple() {
        metadata: Arc::clone(&parquet_meta),
            Arc::new(datafusion::arrow::array::Int32Array::from(PRICES.to_vec())),
        max_doc: 16,
    )]))
    .unwrap();
                cost_collector: 10,
        );
        prune_tree_config: None,
        let n = parquet_meta.row_group(i).num_rows();
    let df = ctx
        sort_fields: vec![],
        .into_iter()
/// Verify detection — `__row_id__` column in SELECT triggers emit_row_ids mode.
//! End-to-end tests for `emit_row_ids` mode.
        writer_generation: 0,
        let tree = Arc::clone(&tree);
/// amazon rows: 0(50), 1(150), 2(80), 3(120), 12(30) → price>100: rows 1, 3.
                    crate::indexed_table::eval::bitmap_tree::CollectorLeafBitmaps::new(
    let tmp = NamedTempFile::new().unwrap();
        BoolNode::And(vec![index_leaf(1), index_leaf(2)]),
            qc.indexed_pushdown_filters = false;
        schema: schema.clone(),
        predicate_columns: vec![0, 1, 2, 3],
    };
    assert_eq!(ids, vec![1, 3]);
    let tree = tree.push_not_down();
    while let Some(batch) = stream.next().await {
                    crate::indexed_table::page_pruner::PagePruneMetrics::from_stream_metrics(
    // Tree OR: amazon OR apple → rows 0-7,12,13
            row_ids.push(col.value(i));
        writer_generation: 1,
    // NOT(collector): NOT(amazon) → rows 4-11,13-15
    // Plan with __row_id__ in projection — should be detected
    let tree = Arc::new(tree);
    for i in 0..parquet_meta2.num_row_groups() {
                Arc::clone(&segment.metadata),
        .collect();
                    ),
        object_path,
                collector_strategy:
}
// |  5  | apple  |    95 | archived  | electronics |
    assert_eq!(ids, expected, "Multi-predicate(50<price<100) mismatch");
    assert_eq!(ids, expected, "Complex OR(AND,AND) mismatch");
    let provider = Arc::new(IndexedTableProvider::new(IndexedTableConfig {
        ArrowReaderMetadata::load(&file, ArrowReaderOptions::new().with_page_index(true)).unwrap();
/// archived rows: 1,5,9,12,13. Intersection: 5, 13.
async fn test_row_id_with_data_columns() {
/// Helper: compute expected row positions from fixture data given a filter.
    let mut rows: Vec<(i64, String, i32)> = Vec::new();
            let mut qc = crate::datafusion_query_config::DatafusionQueryConfig::test_default();
    let provider = Arc::new(IndexedTableProvider::new(IndexedTableConfig {
        expected_rows(|i| (BRANDS[i] == "amazon" || BRANDS[i] == "apple") && PRICES[i] > 100);
/// Write fixture parquet with `__row_id__` column name for emit_row_ids tests.
        sort_max: None,
                Arc::clone(&segment.metadata),
    }
        rgs1.push(RowGroupInfo {
    row_ids
    let mut row_ids: Vec<i64> = Vec::new();
        let col = b.column(0).as_any().downcast_ref::<Int64Array>().unwrap();
 * The OpenSearch Contributors require contributions made to
        query_config: Arc::new({
        schema.clone(),
    assert_eq!(ids, expected, "Predicate(status=active) mismatch");
fn write_row_id_fixture_parquet() -> NamedTempFile {
            num_rows: n,
    }
    };
    let tree = BoolNode::And(vec![index_leaf(0)]);
    // No filter — use a predicate that matches all rows (price >= 0)
// |  0  | amazon |    50 | active    | electronics |
    let schema = meta.schema().clone();
            num_rows: n,
// |  9  | google |   300 | archived  | electronics |
}
            first_row: offset,
            row_ids.push(col.value(i));
}
async fn test_emit_row_ids_single_collector_amazon() {
// The fixture (16 rows):
    let store_url = datafusion::execution::object_store::ObjectStoreUrl::local_filesystem();
        let tree = Arc::clone(&tree);
        for i in 0..b.num_rows() {
/// Each segment is a separate parquet file with 16 rows. Segment 1 has global_base=0,
        global_base: 16,
        sort_max: None,
        });
        schema: schema.clone(),
    );
    let size = std::fs::metadata(&path).unwrap().len();
                        _stream_metrics.ffm_collector_calls.clone(),
        cancellation_token: None,
    let ids = run_tree_row_ids(BoolNode::And(vec![index_leaf(1)])).await;
                rg_index_to_pos: HashMap::new(),
// |  7  | apple  |    60 | active    | electronics |
                    crate::indexed_table::eval::CollectorCallStrategy::TightenOuterBounds,
        pred_int("price", Operator::Gt, 100),
 *
        })
    };
    let size = std::fs::metadata(&path).unwrap().len();
        parquet_size: size2,
        sort_orders: vec![],
        rgs.push(RowGroupInfo {
                ),
                cost_collector: 10,
        cancellation_token: None,
        writer_generation: 0,
            });
// |  6  | apple  |   200 | active    | books       |
        sort_min: None,
