    let task_ctx = ctx.task_ctx();
                .collect(),
        ]
    assert_eq!(row_ids, vec![0, 1, 2, 3, 12]);
    let file_size = std::fs::metadata(&path).unwrap().len();
            OffsetBuffer::new(vec![0_i32, 1].into()),
    let parquet_meta = meta.metadata().clone();
        row_group_row_counts: rg_row_counts,
    let mut cumulative = 0u64;
        .join(", ");
}
    let df = ctx.sql(sql).await.unwrap();
    // We simulate the second segment by doing a query with global_base=16,
        pushdown_predicate: None,
            rows.push(
            plan.set(rg_idx, RowGroupAccess::Selection(selection));
        let per_leaf = per_leaf.clone();
    assert_eq!(row_ids, (0..16).collect::<Vec<i64>>());
            });
            None,
        sort_min: None,
            plan.set(rg_idx, RowGroupAccess::Selection(selection));
/// Full QTF loop with predicate only: price > 100 -> get row IDs -> fetch brand+price -> verify.
async fn test_qtf_fetch_subset_columns() {
// ── Tests ────────────────────────────────────────────────────────────
}
        metadata_cache,
    assert_eq!(row_ids.len(), 16);
use datafusion::arrow::record_batch::RecordBatch;
#[tokio::test]
/// Returns (sorted_row_ids, fetched_batches).
    multiple_writer.write(&multiple_batch).unwrap();
        return vec![];
    // Query phase: brand="amazon" on segment 0 gives rows 0,1,2,3,12.
    let num_rgs = parquet_meta.num_row_groups();
                &schema,
    let mut rows: Vec<(i64, String, i32)> = Vec::new();
                rg_bitmap.insert((pos - rg_start) as u32);
}
        evaluator_factory: factory,
            rows.push((ids.value(i), brands.value(i).to_string(), prices.value(i)));
    // Use row_base=1000 to simulate a second segment with global_base offset
                    crate::indexed_table::page_pruner::PagePruneMetrics::from_stream_metrics(
        cumulative += count;
            rows.push((ids.value(i), brands.value(i).to_string(), prices.value(i)));
use super::*;
    assert_eq!(rows.len(), 5);
                rg_row_counts[rg_idx] as usize,
        e_tag: None,
    for b in batches {
            row_base: segment.global_base as i64,
async fn test_qtf_fetch_single_row() {
                page_pruner: pruner,
    assert_eq!(rows[0], (12, "amazon".to_string(), 30));
            None,
async fn test_qtf_full_loop_predicate_only() {
            qc
    // Execute SQL: __row_id__ + row_base gives global row ID
    let file = std::fs::File::open(&path).unwrap();
                        _stream_metrics.ffm_collector_calls.clone(),
        let mut rg_bitmap = RoaringBitmap::new();
        object_path,
    );
                .row_groups
        .unwrap()
        let ids = b.column(0).as_any().downcast_ref::<Int64Array>().unwrap();
/// brand="amazon" AND price=30 matches only row 12.
    let mut rgs = Vec::new();
    let mut stream = datafusion::physical_plan::execute_stream(plan, task_ctx).unwrap();
    }
    for i in 0..parquet_meta.num_row_groups() {
    let mut plan = ParquetAccessPlan::new_none(num_rgs);
    assert_eq!(rows[1], (1, "amazon".to_string(), 150));
                    .collect::<Vec<_>>(),
async fn query_then_fetch(
            row_group_row_counts: segment
    rows
            let selection = build_row_selection_with_min_skip_run(
        arrow_schema: schema.clone(),
    // Verify schema: should be __row_id__ + brand (2 columns)
    }
        &ctx.state(),
    );
    let file_schema = meta.schema().clone();
    singleton_writer.write(&singleton_batch).unwrap();
    .unwrap();
            let pos = gid as u64;
        .await
        vec![Arc::new(ListArray::new(
            );
/// Rows with price > 100: 1(150), 3(120), 5(95? no), 6(200), 9(300), 11(150).
/// Fetch only "brand" column -> verify only that column + __row_id__ are returned.
    // Build access plan for rows 0, 1, 2, 3, 12 in the file (amazon brand)
        });
    let tree = BoolNode::And(vec![pred_int("price", Operator::GtEq, 0)]);
    assert_eq!(rows[3], (7, "apple".to_string()));
        let b = batch.unwrap();
    for rg_idx in 0..num_rgs {
        writer_generation: 0,
use futures::StreamExt;
        Arc::new(move |segment, _chunk, _stream_metrics, _stats_prune_tree| {
        location: object_store::path::Path::from(path.to_string_lossy().as_ref()),
            qc.indexed_pushdown_filters = false;
        store,
    for b in batches {
        &metas,
    assert_eq!(rows[2], (6, "apple".to_string(), 200));
        object_meta,
        rg_row_counts.push(parquet_meta.row_group(i).num_rows() as u64);
//! query phase (emit row IDs) -> fetch phase (retrieve by those IDs) -> verify data correctness.
    // Build row group info
            list_child,
        .iter()
        let ids = b.column(0).as_any().downcast_ref::<Int64Array>().unwrap();
        sort_max: None,
                    .map(|index| values.value(index).to_string())
    let target_local_positions: Vec<u64> = vec![0, 1, 2, 3, 12];
                    ),
    assert_eq!(rows[0], (0, "amazon".to_string(), 50));
                .map(|rg| rg.num_rows as u64)
            num_rows: n,
    ctx.register_table("t", provider).unwrap();
        version: None,
#[tokio::test]
            Arc::clone(&list_child),
    let tree = BoolNode::And(vec![index_leaf(0)]); // brand="amazon"
    }
        None,
    assert_eq!(rows[2], (1002, "amazon".to_string(), 80));
        for &pos in &target_local_positions {
    let mut cumulative = 0u64;
        rg_row_counts.push(parquet_meta.row_group(i).num_rows() as u64);
        .enumerate()
 */
        schema: schema.clone(),
    assert_eq!(rows[0], (4, "apple".to_string()));
    let mut offset = 0i64;
async fn test_qtf_full_loop_no_filter() {
    tree: BoolNode,
        Arc::clone(&list_schema),
        size: std::fs::metadata(path).unwrap().len(),
                ),
    };
            vec!["error".to_string(), "prod".to_string()],
    let tree = BoolNode::And(vec![index_leaf(1)]); // brand="apple" -> rows 4,5,6,7,13
    )
    assert_eq!(rows[0], (1, "amazon".to_string(), 150));
    assert_eq!(rows[15], (15, "google".to_string(), 55));
                rg_bitmap.insert((pos - rg_start) as u32);
    assert_eq!(rows[3], (9, "google".to_string(), 300));
    assert_eq!(rows[4], (12, "amazon".to_string(), 30));
            );
    // For the fetch phase, we verify we can fetch from a file with non-zero row_base.
        assert_eq!(b.schema().field(1).name(), "brand");
    let metadata_cache = ctx
            store_url,
        files: vec![shard_file],
    let mut multiple_writer = ArrowWriter::try_new(
            index: i,
        Arc::clone(&store),
    assert_eq!(rows[0], (1000, "amazon".to_string(), 50));
 *
            vec!["prod".to_string()]
    let (row_ids, batches) = query_then_fetch(tree, vec!["brand", "price"]).await;
        "SELECT (\"__row_id__\" + \"row_base\") AS \"__row_id__\", \"brand\", \"price\" FROM t";
    assert_eq!(rows[4], (13, "apple".to_string()));
        .collect();
    rows.sort_by_key(|r| r.0);
    }));
    let (row_ids, batches) = query_then_fetch(tree, vec!["brand", "price"]).await;
use datafusion::datasource::physical_plan::parquet::{ParquetAccessPlan, RowGroupAccess};
    .await
/// Amazon rows: 0(50), 1(150), 2(80), 3(120), 12(30).
            Arc::new(StringArray::from(vec!["prod"])),
    )]));
        vec![
        }
    let total_rows: u64 = rg_row_counts.iter().sum();
#[tokio::test]
use roaring::RoaringBitmap;
        .sql("SELECT tags FROM t")
    // price > 100: rows 1(150), 3(120), 6(200), 9(300), 11(150)
    let provider = Arc::new(IndexedTableProvider::new(IndexedTableConfig {
    let store_url = datafusion::execution::object_store::ObjectStoreUrl::local_filesystem();
    let sql = format!(
    ctx.register_table("t", provider).unwrap();
//! The query phase uses `IndexedTableProvider` with `emit_row_ids: true` to get
}
    let multiple_batch = RecordBatch::try_new(
        .collect();
    let tree = BoolNode::And(vec![pred_int("price", Operator::Gt, 100)]);
    .unwrap();
    ctx.register_table("t", provider).unwrap();
    let meta =
            OffsetBuffer::new(vec![0_i32, 2].into()),
    }));
        .await
    // Verify first and last rows
    };
    let ctx = SessionContext::new();
// ── Fetch phase helper ──────────────────────────────────────────────
                        _stream_metrics,
        .runtime_env()
        row_groups: rgs,
    batches
    row_ids.sort();
    let sql =
#[tokio::test]
    for batch in batches {
            }
 * SPDX-License-Identifier: Apache-2.0
    let plan = df.create_physical_plan().await.unwrap();
    let rows = extract_id_brand_price(&batches);
        predicate_columns: vec![0, 1, 2, 3],
        row_base: 1000,
        last_modified: chrono::Utc::now(),
        ))],
        if !rg_bitmap.is_empty() {
    let mut rows = Vec::new();
    let (segments, resolved_schema) = crate::indexed_table::segment_info::build_segments(
        .map(|(i, c)| (i as i32, c))
        let lists = batch
/// Full QTF loop with two segments (global_base offset).
            let mut qc = crate::datafusion_query_config::DatafusionQueryConfig::test_default();
        for i in 0..b.num_rows() {
        }
    .unwrap();
    singleton_writer.close().unwrap();
    let factory: super::super::table_provider::EvaluatorFactory = {
                evaluator: Arc::new(BitmapTreeEvaluator),
        true,
    rows.sort();
    let total_rows: u64 = rg_row_counts.iter().sum();
    ctx.register_object_store(store_url.as_ref(), store);
    assert!(batches.is_empty()); // fetch_phase returns empty vec for empty row_ids
            first_row: offset,
            let values = values.as_any().downcast_ref::<StringViewArray>().unwrap();
        rgs.push(RowGroupInfo {
    // Register object store and table
/*
    let mut rows: Vec<(i64, String, i32)> = Vec::new();
    let df = ctx.sql(&sql).await.unwrap();
        last_modified: chrono::Utc::now(),
    }
}
            num_rows: segment.max_doc as u64,
fn extract_id_brand_price(batches: &[RecordBatch]) -> Vec<(i64, String, i32)> {
    let collectors = wire_collectors(&tree);
    )
        max_doc: 16,
/// Filter that matches exactly 1 row -> fetch -> verify.
    }
        query_config: Arc::new({
        "t",
    assert_eq!(rows[3], (1003, "amazon".to_string(), 120));
    };
    let meta =
        }
        ArrowReaderMetadata::load(&file, ArrowReaderOptions::new().with_page_index(true)).unwrap();
        }
        for row in 0..lists.len() {
        access_plan: Some(plan),
        Arc::new(object_store::local::LocalFileSystem::new());
    let mut stream = datafusion::physical_plan::execute_stream(plan, task_ctx).unwrap();
            qc.target_partitions = 1;
                cost_predicate: 1,
//! global row IDs. The fetch phase uses `ShardTableProvider` with `ParquetAccessPlan`
    let ctx = SessionContext::new();
    let tree = BoolNode::And(vec![index_leaf(0), pred_int("price", Operator::Gt, 500)]);
        ArrowReaderMetadata::load(&file, ArrowReaderOptions::new().with_page_index(true)).unwrap();
    let metas = vec![object_meta(&singleton_path), object_meta(&multiple_path)];
}
        let brands = b.column(1).as_any().downcast_ref::<StringArray>().unwrap();
        object_meta,
/// brand="amazon" AND price > 500 matches nothing.
    while let Some(batch) = stream.next().await {
/// Run the fetch phase: given row IDs, build a ShardTableProvider with
    assert_eq!(rows[1], (5, "apple".to_string()));
        parquet_size: size,
        for i in 0..b.num_rows() {
        store_url: store_url.clone(),
        for &gid in row_ids {
    // price >= 0 matches all rows
    if row_ids.is_empty() {
    // Distribute row IDs into per-RG bitmaps (local positions within each RG)
async fn test_qtf_fetch_empty_result() {
use crate::shard_table_provider::{ShardFileInfo, ShardTableConfig, ShardTableProvider};
        let prices = b.column(2).as_any().downcast_ref::<Int32Array>().unwrap();
        sort_orders: vec![],
    let store: Arc<dyn object_store::ObjectStore> =
        sort_fields: vec![],
async fn fetch_phase(row_ids: &[i64], fetch_columns: &[&str]) -> Vec<RecordBatch> {
    ctx.register_table(
/// Full QTF loop with SingleCollector: brand="amazon" -> get row IDs -> fetch brand+price -> verify.
    let batches = ctx
        files: vec![shard_file],
    }
        batches.push(batch.unwrap());
 * this file be licensed under the Apache-2.0 license or a
        vec![Arc::new(ListArray::new(
    let list_schema = Arc::new(Schema::new(vec![Field::new(
        Arc::new(object_store::local::LocalFileSystem::new());
#[tokio::test]
    let files = segments
        "SELECT (\"__row_id__\" + \"row_base\") AS \"__row_id__\", {} FROM t",
 * The OpenSearch Contributors require contributions made to
    let store_url = datafusion::execution::object_store::ObjectStoreUrl::local_filesystem();
use datafusion::logical_expr::Operator;
    let multiple_path = dir.path().join("list-multiple.parquet");
        })
    let store: Arc<dyn object_store::ObjectStore> =
        .map(|c| format!("\"{}\"", c))
    )
        .get_file_metadata_cache();
    assert_eq!(rows.len(), 5);
        &[],
    let object_meta = |path: &std::path::Path| object_store::ObjectMeta {
        store_url,
        }
        })
        let rg_end = rg_start + rg_row_counts[rg_idx];
    .unwrap();
        col_list
        file_schema: file_schema.clone(),
        .into_iter()
            if pos >= rg_start && pos < rg_end {
    // With row_base=1000, the row IDs should be 1000+file_row_id.
        DataType::List(Arc::clone(&list_child)),
        num_rows: total_rows,
        Arc::clone(&list_schema),
                    crate::indexed_table::eval::CollectorCallStrategy::TightenOuterBounds,
#[tokio::test]
    // has global_base=16 (since the first file has 16 rows).
            .downcast_ref::<ListArray>()
    while let Some(batch) = stream.next().await {
            let pruner = Arc::new(PagePruner::new(
        std::fs::File::create(&multiple_path).unwrap(),
        Arc::new(ShardTableProvider::new(ShardTableConfig {
                page_prune_metrics: Some(
        Arc::clone(&list_schema),
        e_tag: None,
        assert_eq!(b.schema().field(0).name(), "__row_id__");
    for &count in &rg_row_counts {
    let mut singleton_writer = ArrowWriter::try_new(
    .unwrap();
    let ctx = SessionContext::new();
    let plan = df.create_physical_plan().await.unwrap();
    let singleton_batch = RecordBatch::try_new(
async fn test_qtf_full_loop_two_segments() {
/// promotion or custom expression adapters.
        last_modified: chrono::Utc::now(),
    ctx.register_object_store(store_url.as_ref(), store);
    }));
                    crate::indexed_table::eval::bitmap_tree::CollectorLeafBitmaps::new(
    for i in 0..parquet_meta.num_row_groups() {
            let resolved = tree.resolve(&per_leaf)?;
    let task_ctx = ctx.task_ctx();
        metadata: Arc::clone(&parquet_meta),
        if !rg_bitmap.is_empty() {
/// Write two separate parquet files, query both -> verify row IDs from both segments.
        rg_first_row.push(cumulative);
    let list_child = Arc::new(Field::new("element", DataType::Utf8, true));
    let mut stream = datafusion::physical_plan::execute_stream(plan, task_ctx).unwrap();
/// QTF fetch reads predefined LIST columns from every parquet generation without compatibility
        })),
    assert_eq!(rows.len(), 1);
    let rows = extract_id_brand(&batches);
                rg_index_to_pos: HashMap::new(),
        e_tag: None,
        .iter()
use datafusion::execution::context::SessionContext;
    let tree = Arc::new(tree);
    assert_eq!(
        offset += n;
            if pos >= rg_start && pos < rg_end {
                pruning_predicates: Arc::new(std::collections::HashMap::new()),
    let mut rg_row_counts: Vec<u64> = Vec::new();
            files,
        let mut rg_bitmap = RoaringBitmap::new();
                Arc::clone(&segment.metadata),
    assert_eq!(rows[1], (3, "amazon".to_string(), 120));
    assert_eq!(row_ids, vec![12]);
    let store: Arc<dyn object_store::ObjectStore> =
    }
    let (row_ids, batches) = query_then_fetch(tree, vec!["brand"]).await;
    rows.sort_by_key(|r| r.0);
                .iter()
    }
        }
    let dir = tempfile::tempdir().unwrap();
        let rg_start = rg_first_row[rg_idx];
    let size = std::fs::metadata(&path).unwrap().len();
            }
        location: object_store::path::Path::from(path.to_string_lossy().as_ref()),
    assert_eq!(rows[4], (11, "samsung".to_string(), 150));
#[tokio::test]
    let store: Arc<dyn object_store::ObjectStore> =
    };
    // File has __row_id__ = [0..15], but we only read rows at positions 0,1,2,3,12.
        location: object_store::path::Path::from(path.to_string_lossy().as_ref()),
    assert!(row_ids.is_empty());
    fetch_columns: Vec<&str>,
        let rg_end = rg_start + rg_row_counts[rg_idx];
    use datafusion::parquet::arrow::ArrowWriter;
                cost_collector: 10,
    let (row_ids, batches) = query_then_fetch(tree, vec!["brand", "price"]).await;
    }
// ── Query phase helper (adapted from row_id_emission.rs) ────────────
    let df = ctx.sql("SELECT \"__row_id__\" FROM t").await.unwrap();
                (0..values.len())
    let mut batches: Vec<RecordBatch> = Vec::new();
            ));
        row_base: 0,
    let task_ctx = ctx.task_ctx();
    let num_rgs = parquet_meta.num_row_groups();
    let mut rg_first_row: Vec<u64> = Vec::with_capacity(num_rgs);
    let path = tmp.path().to_path_buf();
    let shard_file = ShardFileInfo {
    let (row_ids, batches) = query_then_fetch(tree, vec!["brand", "price"]).await;
    for rg_idx in 0..num_rgs {
    let rows = extract_id_brand_price(&batches);
    ctx.register_object_store(store_url.as_ref(), store);
    let parquet_meta = meta.metadata().clone();
        Arc::new(object_store::local::LocalFileSystem::new());
    assert_eq!(rows[3], (3, "amazon".to_string(), 120));
}
        store_url: store_url.clone(),
}
async fn query_phase(tree: BoolNode) -> Vec<i64> {
 * compatible open source license.
        let brands = b.column(1).as_any().downcast_ref::<StringArray>().unwrap();
        std::fs::File::create(&singleton_path).unwrap(),
        let prices = b.column(2).as_any().downcast_ref::<Int32Array>().unwrap();
    .unwrap();
    row_ids
        Arc::new(object_store::local::LocalFileSystem::new());
    }
) -> (Vec<i64>, Vec<RecordBatch>) {
//! to read only the targeted rows and compute `__row_id__ + row_base`.
    let mut rg_first_row: Vec<u64> = Vec::with_capacity(num_rgs);
    }
            .as_any()
        let ids = b.column(0).as_any().downcast_ref::<Int64Array>().unwrap();
    if let Some(b) = batches.first() {
                schema.clone(),
    let file_schema = meta.schema().clone();
                stats_prune_tree: None,
            let eval: Arc<dyn RowGroupBitsetSource> = Arc::new(TreeBitsetSource {
    };
        let n = parquet_meta.row_group(i).num_rows();
    let tmp = write_fixture_parquet();
        let rg_start = rg_first_row[rg_idx];
    for &count in &rg_row_counts {
    for i in 0..parquet_meta.num_row_groups() {
        }),
    while let Some(batch) = stream.next().await {
                &rg_bitmap,
        cumulative += count;
        file_schema: file_schema.clone(),
    let tmp = write_fixture_parquet();
            object_meta: metas[index].clone(),
/// Full QTF loop with no filter: all 16 rows -> fetch all -> verify count.
        .collect::<Vec<_>>()
    use datafusion::arrow::datatypes::{DataType, Field, Schema};
        .collect()
    }
    let path = tmp.path().to_path_buf();
    }
        let b = batch.unwrap();
    assert_eq!(rows.len(), 5);
    let store_url = datafusion::execution::object_store::ObjectStoreUrl::local_filesystem();
    assert_eq!(row_ids, vec![4, 5, 6, 7, 13]);
use datafusion::parquet::arrow::arrow_reader::{ArrowReaderMetadata, ArrowReaderOptions};
    multiple_writer.close().unwrap();
fn extract_id_brand(batches: &[RecordBatch]) -> Vec<(i64, String)> {
        size: file_size,
//!
    let provider = Arc::new(ShardTableProvider::new(ShardTableConfig {
    let meta =
        for i in 0..b.num_rows() {
    }
                ),
        .state()
/// going through the indexed path, we need at least a trivial predicate).
    )
                collector_strategy:
    let per_leaf: Vec<(i32, Arc<dyn RowGroupDocsCollector>)> = collectors
        row_group_row_counts: rg_row_counts,
    // The __row_id__ in parquet for those positions = 0,1,2,3,12
            Arc::new(StringArray::from(vec!["error", "prod"])),
        num_rows: total_rows,
            rows.push((ids.value(i), brands.value(i).to_string()));
    assert_eq!(rows[4], (1012, "amazon".to_string(), 30));
    // in a single fetch pass. The first segment has global_base=0, the second
/// Extract (row_id, brand) tuples from fetch result batches, sorted by row_id.
        let schema = schema.clone();
/// Filter that matches 0 rows -> empty result.
            qc.force_strategy = Some(FilterStrategy::BooleanMask);
    use datafusion::arrow::array::{ListArray, StringViewArray};
        .enumerate()
        for i in 0..b.num_rows() {
                1,
    assert_eq!(rows.len(), 16);
    let (row_ids, batches) = query_then_fetch(tree, vec!["brand", "price"]).await;
        &[0, 1],
        ArrowReaderMetadata::load(&file, ArrowReaderOptions::new().with_page_index(true)).unwrap();
use datafusion::arrow::array::{Array, Int32Array, Int64Array, StringArray};
    assert_eq!(rows[2], (6, "apple".to_string()));
/// Run the query phase with `emit_row_ids: true` and return sorted row IDs (as i64).
}
        }
    let segment = SegmentFileInfo {
    let path = tmp.path().to_path_buf();
            access_plan: None,
//! End-to-end tests for the full data-node QTF loop:
    let plan = df.create_physical_plan().await.unwrap();
            .unwrap();
    let mut plan = ParquetAccessPlan::new_none(num_rgs);
/// Use price >= 0 as a match-all predicate (since emit_row_ids requires
#[tokio::test]
    let file = std::fs::File::open(&path).unwrap();
    let tree = tree.push_not_down();
    let file_size = std::fs::metadata(&path).unwrap().len();
                max_collector_parallelism: 1,
        cancellation_token: None,
    let singleton_path = dir.path().join("list-singleton.parquet");
    // Global: 0+1000=1000, 1+1000=1001, 2+1000=1002, 3+1000=1003, 12+1000=1012
                    ),
}
        emit_row_ids: true,
    )
        size: file_size,
    let mut rows: Vec<(i64, String)> = Vec::new();
        segments: vec![segment],
    let schema = meta.schema().clone();
/// ParquetAccessPlan to read only those rows, then execute SQL to get data.
    let store_url = datafusion::execution::object_store::ObjectStoreUrl::local_filesystem();
async fn test_qtf_full_loop_single_collector() {
    let mut row_ids: Vec<i64> = Vec::new();
    let tmp = write_fixture_parquet();
        prune_tree_config: None,
    // Build the ParquetAccessPlan from row_ids
        access_plan: Some(plan),
    let shard_file = ShardFileInfo {
            Ok(eval)
                leaves: Arc::new(
    assert_eq!(rows[0], (0, "amazon".to_string(), 50));
    assert_eq!(rows[1], (1001, "amazon".to_string(), 150));
        .unwrap();
    };
        .map(|(index, segment)| ShardFileInfo {
    let rows = extract_id_brand_price(&batches);
    let object_meta = object_store::ObjectMeta {
}
/// Combined helper: run query phase -> get row IDs, then run fetch phase -> get data.
    rows
    rows.sort_by_key(|r| r.0);
    let object_meta = object_store::ObjectMeta {
    (row_ids, batches)
    let col_list = fetch_columns
            file_schema: resolved_schema,
/// Extract (row_id, brand, price) tuples from fetch result batches, sorted by row_id.
        let tree = Arc::clone(&tree);
    // For two segments, we write two separate parquet files and combine them
        assert_eq!(b.num_columns(), 2);
    )
        .cache_manager
    let row_ids = query_phase(tree).await;
        "tags",
        ))],
    let batches = fetch_phase(&row_ids, &fetch_columns).await;
    assert_eq!(row_ids, vec![1, 3, 6, 9, 11]);
        let col = b.column(0).as_any().downcast_ref::<Int64Array>().unwrap();
    assert_eq!(rows.len(), 5);
        None,
use crate::indexed_table::row_selection::build_row_selection_with_min_skip_run;
        }
    let object_path = object_store::path::Path::from(path.to_string_lossy().as_ref());
        rg_first_row.push(cumulative);
}
            let values = lists.value(row);
        let brands = b.column(1).as_any().downcast_ref::<StringArray>().unwrap();
            let selection = build_row_selection_with_min_skip_run(&rg_bitmap, rg_num_rows, 1);
    let mut rg_row_counts: Vec<u64> = Vec::new();
        rows,
        let rg_num_rows = rg_row_counts[rg_idx] as usize;
}
    assert_eq!(rows[2], (2, "amazon".to_string(), 80));
    let rows = extract_id_brand_price(&batches);
        version: None,
    };
    let ctx = SessionContext::new();
        global_base: 0,
            .column(0)
        }
    let file = std::fs::File::open(&path).unwrap();
/// Returns (row_id, column_values) tuples sorted by row_id.
        list_schema,
    // Build the object meta
    let provider = Arc::new(ShardTableProvider::new(ShardTableConfig {
async fn test_qtf_fetch_predefined_list_files() {
    // which would give 16,17,18,19,28.
                tree: Arc::new(resolved),
    let tree = BoolNode::And(vec![index_leaf(0), pred_int("price", Operator::Eq, 30)]);
            row_ids.push(col.value(i));
    }
    let parquet_meta = meta.metadata().clone();
    // Build ShardTableProvider
        version: None,
use std::sync::Arc;
    use datafusion::arrow::buffer::OffsetBuffer;
