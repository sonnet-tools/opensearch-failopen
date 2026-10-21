    assert_eq!(rows[4], (1012, "amazon".to_string(), 30));
    }
use roaring::RoaringBitmap;
    assert_eq!(rows[0], (0, "amazon".to_string(), 50));
    }
            qc
            let selection = build_row_selection_with_min_skip_run(
    fetch_columns: Vec<&str>,
/// Use price >= 0 as a match-all predicate (since emit_row_ids requires
        for i in 0..b.num_rows() {
        for i in 0..b.num_rows() {
    let object_meta = object_store::ObjectMeta {
async fn test_qtf_fetch_single_row() {
            index: i,
    assert_eq!(rows[3], (1003, "amazon".to_string(), 120));
use datafusion::arrow::record_batch::RecordBatch;
    // Build access plan for rows 0, 1, 2, 3, 12 in the file (amazon brand)
    .unwrap();
        size: std::fs::metadata(path).unwrap().len(),
/// Write two separate parquet files, query both -> verify row IDs from both segments.
    }));
                (0..values.len())
    singleton_writer.write(&singleton_batch).unwrap();
    assert_eq!(rows[0], (12, "amazon".to_string(), 30));
        predicate_columns: vec![0, 1, 2, 3],
            }
    let tree = BoolNode::And(vec![pred_int("price", Operator::GtEq, 0)]);
    )
            Ok(eval)
    ctx.register_object_store(store_url.as_ref(), store);
    assert!(batches.is_empty()); // fetch_phase returns empty vec for empty row_ids
        std::fs::File::create(&singleton_path).unwrap(),
    }
    }
            num_rows: n,
    let store_url = datafusion::execution::object_store::ObjectStoreUrl::local_filesystem();
    let mut stream = datafusion::physical_plan::execute_stream(plan, task_ctx).unwrap();
#[tokio::test]
                pruning_predicates: Arc::new(std::collections::HashMap::new()),
    for batch in batches {
    ctx.register_table("t", provider).unwrap();
    // Build row group info
    let tmp = write_fixture_parquet();
#[tokio::test]
        object_path,
            ));
            access_plan: None,
    if let Some(b) = batches.first() {
                .iter()
    }
    .unwrap();
    let batches = fetch_phase(&row_ids, &fetch_columns).await;
    // For the fetch phase, we verify we can fetch from a file with non-zero row_base.
        let rg_start = rg_first_row[rg_idx];
    let total_rows: u64 = rg_row_counts.iter().sum();
        if !rg_bitmap.is_empty() {
    }
        let prices = b.column(2).as_any().downcast_ref::<Int32Array>().unwrap();
/// Returns (sorted_row_ids, fetched_batches).
        ))],
use crate::shard_table_provider::{ShardFileInfo, ShardTableConfig, ShardTableProvider};
    assert_eq!(rows.len(), 16);
                1,
        &[],
        std::fs::File::create(&multiple_path).unwrap(),
        row_base: 0,
        Arc::new(object_store::local::LocalFileSystem::new());
    assert!(row_ids.is_empty());
        Arc::clone(&list_schema),
    use datafusion::arrow::array::{ListArray, StringViewArray};
        ArrowReaderMetadata::load(&file, ArrowReaderOptions::new().with_page_index(true)).unwrap();
        writer_generation: 0,
    let factory: super::super::table_provider::EvaluatorFactory = {
                schema.clone(),
    assert_eq!(row_ids, vec![1, 3, 6, 9, 11]);
    batches
    let mut cumulative = 0u64;
                .map(|rg| rg.num_rows as u64)
    use datafusion::arrow::buffer::OffsetBuffer;
    assert_eq!(rows.len(), 5);
    let meta =
    let (row_ids, batches) = query_then_fetch(tree, vec!["brand", "price"]).await;
    let object_meta = |path: &std::path::Path| object_store::ObjectMeta {
            let pos = gid as u64;
        let lists = batch
    // For two segments, we write two separate parquet files and combine them
            vec!["error".to_string(), "prod".to_string()],
        })
        version: None,
                tree: Arc::new(resolved),
use datafusion::parquet::arrow::arrow_reader::{ArrowReaderMetadata, ArrowReaderOptions};
            None,
    ctx.register_table("t", provider).unwrap();
                rg_row_counts[rg_idx] as usize,
    let total_rows: u64 = rg_row_counts.iter().sum();
    let rows = extract_id_brand(&batches);
    for i in 0..parquet_meta.num_row_groups() {
        e_tag: None,
        .collect::<Vec<_>>()
}
/// Full QTF loop with no filter: all 16 rows -> fetch all -> verify count.
}
    // Verify first and last rows
            rows.push((ids.value(i), brands.value(i).to_string(), prices.value(i)));
    for &count in &rg_row_counts {
async fn test_qtf_fetch_predefined_list_files() {
            None,
    let path = tmp.path().to_path_buf();
        let rg_num_rows = rg_row_counts[rg_idx] as usize;
        last_modified: chrono::Utc::now(),
    let plan = df.create_physical_plan().await.unwrap();
    let num_rgs = parquet_meta.num_row_groups();
                    ),
#[tokio::test]
    let target_local_positions: Vec<u64> = vec![0, 1, 2, 3, 12];
            row_ids.push(col.value(i));
use futures::StreamExt;
    singleton_writer.close().unwrap();
    }
    let df = ctx.sql("SELECT \"__row_id__\" FROM t").await.unwrap();
        list_schema,
/// Returns (row_id, column_values) tuples sorted by row_id.
            }
    ctx.register_table(
        DataType::List(Arc::clone(&list_child)),
        Arc::clone(&store),
    let mut rows: Vec<(i64, String, i32)> = Vec::new();
        Arc::new(object_store::local::LocalFileSystem::new());
        for &pos in &target_local_positions {
        object_meta,
    for b in batches {
        rg_first_row.push(cumulative);
        ArrowReaderMetadata::load(&file, ArrowReaderOptions::new().with_page_index(true)).unwrap();
            OffsetBuffer::new(vec![0_i32, 1].into()),
        }
    let shard_file = ShardFileInfo {
    }));
        "SELECT (\"__row_id__\" + \"row_base\") AS \"__row_id__\", \"brand\", \"price\" FROM t";
    let tree = BoolNode::And(vec![pred_int("price", Operator::Gt, 100)]);
            row_group_row_counts: segment
            let values = values.as_any().downcast_ref::<StringViewArray>().unwrap();
            num_rows: segment.max_doc as u64,
            let values = lists.value(row);
    for b in batches {
    ctx.register_table("t", provider).unwrap();
    )
    // in a single fetch pass. The first segment has global_base=0, the second
        version: None,
    assert_eq!(rows[1], (1, "amazon".to_string(), 150));
                rg_bitmap.insert((pos - rg_start) as u32);
async fn query_then_fetch(
    // Build ShardTableProvider
async fn test_qtf_full_loop_two_segments() {
        version: None,
    let mut rows = Vec::new();
            .column(0)
    let ctx = SessionContext::new();
    };
/// Full QTF loop with SingleCollector: brand="amazon" -> get row IDs -> fetch brand+price -> verify.
        vec![Arc::new(ListArray::new(
        row_groups: rgs,
    let dir = tempfile::tempdir().unwrap();
    let singleton_batch = RecordBatch::try_new(
    let tree = BoolNode::And(vec![index_leaf(0)]); // brand="amazon"
        "SELECT (\"__row_id__\" + \"row_base\") AS \"__row_id__\", {} FROM t",
        assert_eq!(b.num_columns(), 2);
            });
    row_ids
    multiple_writer.write(&multiple_batch).unwrap();
        None,
    assert_eq!(rows[2], (1002, "amazon".to_string(), 80));
            if pos >= rg_start && pos < rg_end {
}
/// Extract (row_id, brand) tuples from fetch result batches, sorted by row_id.
        .runtime_env()
        let b = batch.unwrap();
            qc.target_partitions = 1;
    let parquet_meta = meta.metadata().clone();
            store_url,
        max_doc: 16,
                    ),
    };
    while let Some(batch) = stream.next().await {
        }
            plan.set(rg_idx, RowGroupAccess::Selection(selection));
    let ctx = SessionContext::new();
    for &count in &rg_row_counts {
                    crate::indexed_table::eval::bitmap_tree::CollectorLeafBitmaps::new(
    // Distribute row IDs into per-RG bitmaps (local positions within each RG)
) -> (Vec<i64>, Vec<RecordBatch>) {
        access_plan: Some(plan),
        cancellation_token: None,
    let col_list = fetch_columns
/// Combined helper: run query phase -> get row IDs, then run fetch phase -> get data.
        for &gid in row_ids {
        object_meta,
            row_base: segment.global_base as i64,
        metadata: Arc::clone(&parquet_meta),
    for i in 0..parquet_meta.num_row_groups() {
                leaves: Arc::new(
//!
    let sql = format!(
/// Run the query phase with `emit_row_ids: true` and return sorted row IDs (as i64).
    let tmp = write_fixture_parquet();
    )
/// Full QTF loop with two segments (global_base offset).
        }
        sort_max: None,
/// Amazon rows: 0(50), 1(150), 2(80), 3(120), 12(30).
        })
//! to read only the targeted rows and compute `__row_id__ + row_base`.
            rows.push((ids.value(i), brands.value(i).to_string(), prices.value(i)));
    let row_ids = query_phase(tree).await;
    rows
        .map(|(index, segment)| ShardFileInfo {
    assert_eq!(rows.len(), 5);
    let provider = Arc::new(ShardTableProvider::new(ShardTableConfig {
                    crate::indexed_table::eval::CollectorCallStrategy::TightenOuterBounds,
                ),
    assert_eq!(rows[0], (1000, "amazon".to_string(), 50));
    let tmp = write_fixture_parquet();
        let tree = Arc::clone(&tree);
    let file_schema = meta.schema().clone();
            qc.indexed_pushdown_filters = false;
        &[0, 1],
async fn test_qtf_fetch_subset_columns() {
    assert_eq!(row_ids, vec![0, 1, 2, 3, 12]);
        .await
    let meta =
            let resolved = tree.resolve(&per_leaf)?;
}
        schema: schema.clone(),
        let brands = b.column(1).as_any().downcast_ref::<StringArray>().unwrap();
        Arc::new(object_store::local::LocalFileSystem::new());
    ctx.register_object_store(store_url.as_ref(), store);
        location: object_store::path::Path::from(path.to_string_lossy().as_ref()),
            let selection = build_row_selection_with_min_skip_run(&rg_bitmap, rg_num_rows, 1);
            first_row: offset,
        emit_row_ids: true,
            Arc::new(StringArray::from(vec!["prod"])),
        .unwrap();
    let store: Arc<dyn object_store::ObjectStore> =
    let (row_ids, batches) = query_then_fetch(tree, vec!["brand", "price"]).await;
    assert_eq!(rows[3], (3, "amazon".to_string(), 120));
    assert_eq!(rows.len(), 1);
}
use std::sync::Arc;
    }
        if !rg_bitmap.is_empty() {
#[tokio::test]
                max_collector_parallelism: 1,
//! The query phase uses `IndexedTableProvider` with `emit_row_ids: true` to get
        rg_row_counts.push(parquet_meta.row_group(i).num_rows() as u64);
        pushdown_predicate: None,
        batches.push(batch.unwrap());
}
 * The OpenSearch Contributors require contributions made to
    let size = std::fs::metadata(&path).unwrap().len();
    )]));
        sort_min: None,
/// Filter that matches exactly 1 row -> fetch -> verify.
    // Build the object meta
//! query phase (emit row IDs) -> fetch phase (retrieve by those IDs) -> verify data correctness.
        store_url: store_url.clone(),
    // The __row_id__ in parquet for those positions = 0,1,2,3,12
            let mut qc = crate::datafusion_query_config::DatafusionQueryConfig::test_default();
    let list_schema = Arc::new(Schema::new(vec![Field::new(
 * this file be licensed under the Apache-2.0 license or a
        .await
    rows.sort();
        &metas,
    let per_leaf: Vec<(i32, Arc<dyn RowGroupDocsCollector>)> = collectors
        parquet_size: size,
 * SPDX-License-Identifier: Apache-2.0
                    .collect::<Vec<_>>(),
#[tokio::test]
                        _stream_metrics,
        .map(|c| format!("\"{}\"", c))
        .collect();
    let file = std::fs::File::open(&path).unwrap();
    let rows = extract_id_brand_price(&batches);
    }
            .unwrap();
                collector_strategy:
        for row in 0..lists.len() {
    let path = tmp.path().to_path_buf();
    let file_schema = meta.schema().clone();
            object_meta: metas[index].clone(),
        .state()
        offset += n;
    let (segments, resolved_schema) = crate::indexed_table::segment_info::build_segments(
        row_group_row_counts: rg_row_counts,
        rgs.push(RowGroupInfo {
                &rg_bitmap,
    assert_eq!(rows[1], (5, "apple".to_string()));
    }
#[tokio::test]
    use datafusion::arrow::datatypes::{DataType, Field, Schema};
        file_schema: file_schema.clone(),
        sort_orders: vec![],
        let rg_end = rg_start + rg_row_counts[rg_idx];
        last_modified: chrono::Utc::now(),
    let rows = extract_id_brand_price(&batches);
        return vec![];
    let df = ctx.sql(sql).await.unwrap();
    let mut rgs = Vec::new();
        num_rows: total_rows,
    };
// ── Tests ────────────────────────────────────────────────────────────
}
        metadata_cache,
        let mut rg_bitmap = RoaringBitmap::new();
    use datafusion::parquet::arrow::ArrowWriter;
    let (row_ids, batches) = query_then_fetch(tree, vec!["brand"]).await;
        for i in 0..b.num_rows() {
/// QTF fetch reads predefined LIST columns from every parquet generation without compatibility
        store,
        let schema = schema.clone();
        }
}
        .collect();
    let tree = BoolNode::And(vec![index_leaf(0), pred_int("price", Operator::Eq, 30)]);
        store_url: store_url.clone(),
    let (row_ids, batches) = query_then_fetch(tree, vec!["brand", "price"]).await;
    let metadata_cache = ctx
async fn test_qtf_full_loop_predicate_only() {
                Arc::clone(&segment.metadata),
    // price >= 0 matches all rows
    let mut stream = datafusion::physical_plan::execute_stream(plan, task_ctx).unwrap();
    let rows = extract_id_brand_price(&batches);
    let file = std::fs::File::open(&path).unwrap();
 */
        files: vec![shard_file],
        .enumerate()
    let rows = extract_id_brand_price(&batches);
            rows.push(
    let task_ctx = ctx.task_ctx();
    let mut offset = 0i64;
    let mut rows: Vec<(i64, String)> = Vec::new();
    // With row_base=1000, the row IDs should be 1000+file_row_id.
        .get_file_metadata_cache();
/// going through the indexed path, we need at least a trivial predicate).
            Arc::clone(&list_child),
        .join(", ");
        let ids = b.column(0).as_any().downcast_ref::<Int64Array>().unwrap();
        for i in 0..b.num_rows() {
    let mut rg_first_row: Vec<u64> = Vec::with_capacity(num_rgs);
    }
    )
            list_child,
use crate::indexed_table::row_selection::build_row_selection_with_min_skip_run;
    let tree = BoolNode::And(vec![index_leaf(0), pred_int("price", Operator::Gt, 500)]);
        arrow_schema: schema.clone(),
use datafusion::arrow::array::{Array, Int32Array, Int64Array, StringArray};
    }
//! global row IDs. The fetch phase uses `ShardTableProvider` with `ParquetAccessPlan`
/// brand="amazon" AND price=30 matches only row 12.
        ArrowReaderMetadata::load(&file, ArrowReaderOptions::new().with_page_index(true)).unwrap();
// ── Fetch phase helper ──────────────────────────────────────────────
        size: file_size,
    }
        vec![
}
    let file_size = std::fs::metadata(&path).unwrap().len();
                cost_collector: 10,
    };
    .unwrap();
        ]
    let store_url = datafusion::execution::object_store::ObjectStoreUrl::local_filesystem();
        None,
    assert_eq!(rows.len(), 5);
        segments: vec![segment],
    let (row_ids, batches) = query_then_fetch(tree, vec!["brand", "price"]).await;
/// promotion or custom expression adapters.
        store_url,
        "tags",
    // Global: 0+1000=1000, 1+1000=1001, 2+1000=1002, 3+1000=1003, 12+1000=1012
        query_config: Arc::new({
    let num_rgs = parquet_meta.num_row_groups();
        let brands = b.column(1).as_any().downcast_ref::<StringArray>().unwrap();
    let collectors = wire_collectors(&tree);
use datafusion::datasource::physical_plan::parquet::{ParquetAccessPlan, RowGroupAccess};
    row_ids.sort();
    assert_eq!(rows[4], (13, "apple".to_string()));
                evaluator: Arc::new(BitmapTreeEvaluator),
/// Fetch only "brand" column -> verify only that column + __row_id__ are returned.
    let store: Arc<dyn object_store::ObjectStore> =
    tree: BoolNode,
        let col = b.column(0).as_any().downcast_ref::<Int64Array>().unwrap();
    assert_eq!(rows[15], (15, "google".to_string(), 55));
    .unwrap();
    assert_eq!(row_ids, vec![12]);
        assert_eq!(b.schema().field(1).name(), "brand");
        assert_eq!(b.schema().field(0).name(), "__row_id__");
        let ids = b.column(0).as_any().downcast_ref::<Int64Array>().unwrap();
    for i in 0..parquet_meta.num_row_groups() {
    };
                    .map(|index| values.value(index).to_string())
    let mut rg_row_counts: Vec<u64> = Vec::new();
        global_base: 0,
    let store_url = datafusion::execution::object_store::ObjectStoreUrl::local_filesystem();
    let sql =
    // Execute SQL: __row_id__ + row_base gives global row ID
    .unwrap();
        let rg_start = rg_first_row[rg_idx];
    let batches = ctx
            files,
    // We simulate the second segment by doing a query with global_base=16,
                rg_index_to_pos: HashMap::new(),
    let ctx = SessionContext::new();
                &schema,
    let store: Arc<dyn object_store::ObjectStore> =
    let ctx = SessionContext::new();
    let store: Arc<dyn object_store::ObjectStore> =
        .sql("SELECT tags FROM t")
    let path = tmp.path().to_path_buf();
    assert_eq!(row_ids, (0..16).collect::<Vec<i64>>());
    let meta =
    // Verify schema: should be __row_id__ + brand (2 columns)
        let rg_end = rg_start + rg_row_counts[rg_idx];
/// Filter that matches 0 rows -> empty result.
        last_modified: chrono::Utc::now(),
 * compatible open source license.
        files: vec![shard_file],
/// Extract (row_id, brand, price) tuples from fetch result batches, sorted by row_id.
        let brands = b.column(1).as_any().downcast_ref::<StringArray>().unwrap();
/// Full QTF loop with predicate only: price > 100 -> get row IDs -> fetch brand+price -> verify.
    let plan = df.create_physical_plan().await.unwrap();
                    crate::indexed_table::page_pruner::PagePruneMetrics::from_stream_metrics(
        size: file_size,
                page_prune_metrics: Some(
        let ids = b.column(0).as_any().downcast_ref::<Int64Array>().unwrap();
#[tokio::test]
    let mut batches: Vec<RecordBatch> = Vec::new();
                ),
        evaluator_factory: factory,
    let object_meta = object_store::ObjectMeta {
    )
        Arc::new(ShardTableProvider::new(ShardTableConfig {
        Arc::new(object_store::local::LocalFileSystem::new());
/*
    let provider = Arc::new(ShardTableProvider::new(ShardTableConfig {
    let store_url = datafusion::execution::object_store::ObjectStoreUrl::local_filesystem();
    // price > 100: rows 1(150), 3(120), 6(200), 9(300), 11(150)
    let files = segments
    // which would give 16,17,18,19,28.
    rows.sort_by_key(|r| r.0);
        cumulative += count;
    ctx.register_object_store(store_url.as_ref(), store);
    let mut plan = ParquetAccessPlan::new_none(num_rgs);
        prune_tree_config: None,
        .unwrap()
async fn query_phase(tree: BoolNode) -> Vec<i64> {
    let parquet_meta = meta.metadata().clone();
            rows.push((ids.value(i), brands.value(i).to_string()));
    assert_eq!(rows[3], (9, "google".to_string(), 300));
    let segment = SegmentFileInfo {
    let plan = df.create_physical_plan().await.unwrap();
    }));
    let file = std::fs::File::open(&path).unwrap();
    while let Some(batch) = stream.next().await {
    assert_eq!(rows[3], (7, "apple".to_string()));
    assert_eq!(rows[1], (1001, "amazon".to_string(), 150));
    .unwrap();
    let list_child = Arc::new(Field::new("element", DataType::Utf8, true));
        .into_iter()
    let mut cumulative = 0u64;
    }
    rows.sort_by_key(|r| r.0);
#[tokio::test]
    // Build the ParquetAccessPlan from row_ids
        let mut rg_bitmap = RoaringBitmap::new();
            OffsetBuffer::new(vec![0_i32, 2].into()),
            qc.force_strategy = Some(FilterStrategy::BooleanMask);
}
    let parquet_meta = meta.metadata().clone();
// ── Query phase helper (adapted from row_id_emission.rs) ────────────
                        _stream_metrics.ffm_collector_calls.clone(),
    while let Some(batch) = stream.next().await {
        e_tag: None,
        }
}
            let pruner = Arc::new(PagePruner::new(
    assert_eq!(rows[4], (11, "samsung".to_string(), 150));
    assert_eq!(rows[0], (1, "amazon".to_string(), 150));
    let mut rows: Vec<(i64, String, i32)> = Vec::new();
}
        .iter()
        num_rows: total_rows,
 *
    let multiple_path = dir.path().join("list-multiple.parquet");
        sort_fields: vec![],
    );
async fn test_qtf_fetch_empty_result() {
    );
        location: object_store::path::Path::from(path.to_string_lossy().as_ref()),
    assert_eq!(rows[1], (3, "amazon".to_string(), 120));
            plan.set(rg_idx, RowGroupAccess::Selection(selection));
    let provider = Arc::new(IndexedTableProvider::new(IndexedTableConfig {
    let task_ctx = ctx.task_ctx();
                .row_groups
        .map(|(i, c)| (i as i32, c))
                rg_bitmap.insert((pos - rg_start) as u32);
        }
    let schema = meta.schema().clone();
async fn fetch_phase(row_ids: &[i64], fetch_columns: &[&str]) -> Vec<RecordBatch> {
    for rg_idx in 0..num_rgs {
    assert_eq!(row_ids.len(), 16);
    assert_eq!(rows.len(), 5);
        let prices = b.column(2).as_any().downcast_ref::<Int32Array>().unwrap();
    let shard_file = ShardFileInfo {
use super::*;
    let object_path = object_store::path::Path::from(path.to_string_lossy().as_ref());
        })),
    // File has __row_id__ = [0..15], but we only read rows at positions 0,1,2,3,12.
        "t",
        .collect()
    assert_eq!(rows[4], (12, "amazon".to_string(), 30));
    // Use row_base=1000 to simulate a second segment with global_base offset
    };
            .downcast_ref::<ListArray>()
        }
        cumulative += count;
    };
        rows,
            let eval: Arc<dyn RowGroupBitsetSource> = Arc::new(TreeBitsetSource {
        }
    rows
    let df = ctx.sql(&sql).await.unwrap();
    let mut rg_row_counts: Vec<u64> = Vec::new();
/// Run the fetch phase: given row IDs, build a ShardTableProvider with
                page_pruner: pruner,
    let mut row_ids: Vec<i64> = Vec::new();
use datafusion::execution::context::SessionContext;
    let mut rg_first_row: Vec<u64> = Vec::with_capacity(num_rgs);
/// Rows with price > 100: 1(150), 3(120), 5(95? no), 6(200), 9(300), 11(150).
    assert_eq!(rows[2], (6, "apple".to_string()));
    .await
        vec![Arc::new(ListArray::new(
        let n = parquet_meta.row_group(i).num_rows();
        access_plan: Some(plan),
    if row_ids.is_empty() {
        ))],
        }
fn extract_id_brand(batches: &[RecordBatch]) -> Vec<(i64, String)> {
        let b = batch.unwrap();
/// ParquetAccessPlan to read only those rows, then execute SQL to get data.
        col_list
        .cache_manager
        let per_leaf = per_leaf.clone();
    // has global_base=16 (since the first file has 16 rows).
    let mut singleton_writer = ArrowWriter::try_new(
        location: object_store::path::Path::from(path.to_string_lossy().as_ref()),
    let mut plan = ParquetAccessPlan::new_none(num_rgs);
fn extract_id_brand_price(batches: &[RecordBatch]) -> Vec<(i64, String, i32)> {
        row_base: 1000,
}
        Arc::clone(&list_schema),
    let metas = vec![object_meta(&singleton_path), object_meta(&multiple_path)];
        row_group_row_counts: rg_row_counts,
    let singleton_path = dir.path().join("list-singleton.parquet");
    }
/// brand="amazon" AND price > 500 matches nothing.
        });
use datafusion::logical_expr::Operator;
                stats_prune_tree: None,
        &ctx.state(),
        rg_row_counts.push(parquet_meta.row_group(i).num_rows() as u64);
    assert_eq!(rows[0], (0, "amazon".to_string(), 50));
            );
    assert_eq!(rows[2], (2, "amazon".to_string(), 80));
            if pos >= rg_start && pos < rg_end {
        .iter()
    multiple_writer.close().unwrap();
            Arc::new(StringArray::from(vec!["error", "prod"])),
        }),
//! End-to-end tests for the full data-node QTF loop:
    let file_size = std::fs::metadata(&path).unwrap().len();
    )
    assert_eq!(row_ids, vec![4, 5, 6, 7, 13]);
            vec!["prod".to_string()]
    let task_ctx = ctx.task_ctx();
    rows.sort_by_key(|r| r.0);
    let (row_ids, batches) = query_then_fetch(tree, vec!["brand", "price"]).await;
        file_schema: file_schema.clone(),
        Arc::new(move |segment, _chunk, _stream_metrics, _stats_prune_tree| {
            file_schema: resolved_schema,
    let tree = tree.push_not_down();
                cost_predicate: 1,
                .collect(),
async fn test_qtf_full_loop_single_collector() {
            );
        e_tag: None,
    (row_ids, batches)
    // Register object store and table
    // Query phase: brand="amazon" on segment 0 gives rows 0,1,2,3,12.
        Arc::clone(&list_schema),
    let tree = BoolNode::And(vec![index_leaf(1)]); // brand="apple" -> rows 4,5,6,7,13
    assert_eq!(rows[2], (6, "apple".to_string(), 200));
        rg_first_row.push(cumulative);
    let multiple_batch = RecordBatch::try_new(
    let mut multiple_writer = ArrowWriter::try_new(
        true,
    let tree = Arc::new(tree);
    assert_eq!(rows[0], (4, "apple".to_string()));
async fn test_qtf_full_loop_no_filter() {
    let mut stream = datafusion::physical_plan::execute_stream(plan, task_ctx).unwrap();
            .as_any()
    assert_eq!(
    for rg_idx in 0..num_rgs {
        .enumerate()
