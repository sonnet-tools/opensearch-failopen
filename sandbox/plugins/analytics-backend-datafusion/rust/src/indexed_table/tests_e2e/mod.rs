use super::eval::bitmap_tree::{BitmapTreeEvaluator, CollectorLeafBitmaps};
    BoolNode::Predicate(Arc::new(
            ));
            Arc::new(StringArray::from(STATUSES.to_vec())),
    let mut out = Vec::new();
}
            Ok(eval)
mod streaming_at_scale;
                other => panic!("unknown test collector tag {:?}", other),
            out.push(c);
/// read metrics off it after execution.
//! collectors directly in Rust; that keeps the test hermetic while still
        let tree = Arc::clone(&tree);
fn pred_str(col: &str, op: Operator, v: &str) -> BoolNode {
use datafusion::arrow::record_batch::RecordBatch;
        arrow_schema: schema.clone(),
        ArrowReaderMetadata::load(&file, ArrowReaderOptions::new().with_page_index(true)).unwrap();
//
                collector_strategy:
                evaluator: Arc::new(BitmapTreeEvaluator),
const PRICES: [i32; 16] = [
        .iter()
    // equals the row-index-within-RG. Phase 2 bitmap_to_batch_mask
    // relies on this alignment. RowSelection would still work for Path B
    ctx.register_table("t", provider).unwrap();
        .map(|(i, _)| i as i32)
                Arc::clone(&segment.metadata),
}
mod row_id_emission;
// |  5  | apple  |    95 | archived  | electronics |
        datafusion::physical_expr::expressions::BinaryExpr::new(left, op, right),
        })
        let per_leaf = per_leaf.clone();
mod constant_predicate;
        let b = batch.unwrap();
//
/// Build a collector that returns docs matching `status == value`.
        Field::new("__row_id__", DataType::Int64, false),
    let path = tmp.path().to_path_buf();
        .into_iter()
const STATUSES: [&str; 16] = [
    let df = ctx
        .filter(|(_, b)| **b == value)
    let left: Arc<dyn datafusion::physical_expr::PhysicalExpr> = Arc::new(
        sort_orders: vec![],
    let factory: super::table_provider::EvaluatorFactory = {
                price.value(i),
    let schema = meta.schema().clone();
// |  2  | amazon |    80 | active    | books       |
    w.close().unwrap();
    let tree = tree.push_not_down();
    // Use smallish row groups so there's > 1 and the streaming loop cycles.
                    crate::indexed_table::eval::bitmap_tree::CollectorLeafBitmaps::new(
        query_config: std::sync::Arc::new(qc),
mod multi_segment;
    let provider = Arc::new(IndexedTableProvider::new(IndexedTableConfig {
        .collect();
// | 12  | amazon |    30 | archived  | electronics |
    );
        .map(|(i, _)| i as i32)
                Some(0) => brand_eq("amazon"),
    let matching: Vec<i32> = STATUSES
    "electronics",
                    crate::indexed_table::page_pruner::PagePruneMetrics::from_stream_metrics(
        BoolNode::Not(inner) => wire(inner, out),
        Arc::new(object_store::local::LocalFileSystem::new());
    let file = std::fs::File::open(&path).unwrap();
    fn collect_packed_u64_bitset(
    "electronics",
        datafusion::physical_expr::expressions::BinaryExpr::new(left, op, right),
const BRANDS: [&str; 16] = [
// | 10  | samsung|    70 | active    | electronics |
        Arc::new(datafusion::physical_expr::expressions::Literal::new(
    Arc::new(MockCollector { matching })
    "electronics",
    "electronics",
use datafusion::parquet::arrow::arrow_reader::{ArrowReaderMetadata, ArrowReaderOptions};
 */
                    ),
        .sql("SELECT brand, price, status, category FROM t")
    Arc::new(Schema::new(vec![
        .set_max_row_group_size(8)
        cancellation_token: None,
    "amazon", "amazon", "amazon", "amazon", "apple", "apple", "apple", "apple", "google", "google",
            let resolved = tree.resolve(&per_leaf)?;
/*
}
        ],
fn brand_eq(value: &str) -> Arc<dyn RowGroupDocsCollector> {
                tree: Arc::new(resolved),
    };
    let col_idx = schema.index_of(col).expect("column in fixture schema");
        vec![
        &self,
    ]))
    }
    "books",
 *
// Test-only leaf encoding: `index_leaf(tag)` puts a single-byte tag into
            Arc::new(Int64Array::from(row_ids)),
        .unwrap();
 * compatible open source license.
            first_row: offset,
}
// `BoolNode::Collector.query_bytes`. `wire_collectors_from_bytes` walks the
    ))
mod page_pruning;
async fn run_tree_and_plan(
    "books",
// | 14  | samsung|    99 | active    | electronics |
    "electronics",
mod fuzz;
mod metrics;
        min_doc: i32,
        datafusion::physical_expr::expressions::Column::new(col, col_idx),
    let tree = Arc::new(tree);
// Takes a pre-computed set of matching doc ids (absolute). Returns bits for
use super::stream::{FilterStrategy, RowGroupInfo};
    let collectors = wire_collectors(&tree);
        global_base: 0,
}
        annotation_id: tag as i32,
        metadata: Arc::clone(&parquet_meta),
    "archived", "active", "active", "archived", "archived", "active", "active",
    tmp
}
        writer_generation: 0,
// ── Test fixture: parquet table with 16 rows ────────────────────────
    }));
// ── Tree-building helpers ──────────────────────────────────────────
// tree in DFS order and returns one `Arc<dyn RowGroupDocsCollector>` per
    "electronics",
mod null_columns;
// |  8  | google |    40 | active    | electronics |
/// Build a `BoolNode::Predicate(expr)` for `col op <string value>`.
            let eval: Arc<dyn RowGroupBitsetSource> = Arc::new(TreeBitsetSource {
            if doc >= min_doc && doc < max_doc {
        rgs.push(RowGroupInfo {
    let batch = RecordBatch::try_new(
    }
];
                ),
                page_prune_metrics: Some(
            ScalarValue::Utf8(Some(v.to_string())),
                Some(1) => brand_eq("apple"),
// |  4  | apple  |    90 | active    | electronics |
//! exercising the full streaming pipeline end-to-end.
mod row_id_strategies;
            let c: Arc<dyn RowGroupDocsCollector> = match Some(*annotation_id as u8) {
                leaves: Arc::new(
            };
    let schema = build_fixture_schema();
    out
}
        Field::new("brand", DataType::Utf8, false),
        .map(|(i, c)| (i as i32, c))
        let status = b.column(2).as_any().downcast_ref::<StringArray>().unwrap();
        .filter(|(_, s)| **s == value)
        .enumerate()
// | row | brand  | price | status    | category    |
        .collect();
    run_tree_and_plan(tree).await.0
        let span = (max_doc - min_doc) as usize;
) {
    let store_url = datafusion::execution::object_store::ObjectStoreUrl::local_filesystem();
                    crate::indexed_table::eval::CollectorCallStrategy::TightenOuterBounds,
        .target_partitions(1)
    Arc::new(MockCollector { matching })
    let mut rows: Vec<(String, i32, String, String)> = Vec::new();
async fn run_tree(tree: BoolNode) -> Vec<(String, i32, String, String)> {
    tree: BoolNode,
    "electronics",
                let rel = (doc - min_doc) as usize;
                stats_prune_tree: None,
                rg_index_to_pos: HashMap::new(),
    );
        sort_fields: vec![],
use datafusion::parquet::arrow::ArrowWriter;
                cost_predicate: 1,
use super::bool_tree::BoolNode;
// |  7  | apple  |    60 | active    | electronics |
    50, 150, 80, 120, 90, 95, 200, 60, 40, 300, 70, 150, 30, 45, 99, 55,
    "samsung", "samsung", "amazon", "apple", "samsung", "google",
    while let Some(batch) = stream.next().await {
use datafusion::logical_expr::Operator;
    // Enable page index so PagePruner can prune predicates.
    match node {
    let mut rgs = Vec::new();
//!
    "electronics",
// ── Test runner: build provider + execute + collect rows ───────────
// |  0  | amazon |    50 | active    | electronics |
fn wire_collectors(tree: &BoolNode) -> Vec<Arc<dyn RowGroupDocsCollector>> {
            let pruner = Arc::new(PagePruner::new(
        .set_statistics_enabled(datafusion::parquet::file::properties::EnabledStatistics::Page)
        max_doc: i32,
    // Test provider_key assignment: index in DFS order. Real provider keys
        .collect();
            rows.push((
use super::index::RowGroupDocsCollector;
    let size = std::fs::metadata(&path).unwrap().len();
        }
}
        Field::new("status", DataType::Utf8, false),
/// built from the leaf's `query_bytes` tag (0=amazon, 1=apple, 2=archived).
    }
    // Force BooleanMask so batches contain the entire RG and batch_offset
use futures::StreamExt;
// | 11  | samsung|   150 | active    | books       |
    let plan = df.create_physical_plan().await.unwrap();
    // Normalize NOT push-down; build one collector per Collector leaf in DFS order.
                max_collector_parallelism: 1,
use super::table_provider::{IndexedTableConfig, IndexedTableProvider, SegmentFileInfo};
            });
    )
    ) -> Result<CollectDocsResult, String> {
/// Build a collector that returns docs matching `brand == value`.
fn wire(node: &BoolNode, out: &mut Vec<Arc<dyn RowGroupDocsCollector>>) {
        segments: vec![segment],
        datafusion::physical_expr::expressions::Column::new(col, col_idx),
        sort_min: None,
mod schema_drift;
    let store: Arc<dyn object_store::ObjectStore> =
        }
        .enumerate()
mod dynamic_filter_pushdown;
    let tmp = NamedTempFile::new().unwrap();
// ── Mock index-backend-like collector ─────────────────────────────────────
        let n = parquet_meta.row_group(i).num_rows();
    "active", "archived", "active", "active", "active", "archived", "active", "active", "active",
use std::sync::Arc;
        BoolNode::And(c) | BoolNode::Or(c) => c.iter().for_each(|x| wire(x, out)),
    let schema = build_fixture_schema();
}
        sort_max: None,
//
        datafusion::physical_plan::execute_stream(std::sync::Arc::clone(&plan), task_ctx).unwrap();
    let left: Arc<dyn datafusion::physical_expr::PhysicalExpr> = Arc::new(
        Arc::new(move |segment, _chunk, _stream_metrics, _stats_prune_tree| {
                page_pruner: pruner,
use datafusion::arrow::datatypes::{DataType, Field, Schema, SchemaRef};
        let mut out = vec![0u64; span.div_ceil(64)];
        store,
                cost_collector: 10,
    Vec<(String, i32, String, String)>,
// |-----|--------|-------|-----------|-------------|
    let right: Arc<dyn datafusion::physical_expr::PhysicalExpr> = Arc::new(
const CATEGORIES: [&str; 16] = [
}
        .force_strategy(Some(FilterStrategy::BooleanMask))
//! `IndexedStream` → `BitmapTreeEvaluator` with a complex boolean tree.
        datafusion::physical_expr::expressions::Literal::new(ScalarValue::Int32(Some(v))),
mod qtf_fetch_phase;
    }
fn index_leaf(tag: u8) -> BoolNode {
#![cfg(test)]
    let object_path = object_store::path::Path::from(path.to_string_lossy().as_ref());
}
/// Walk `tree` in DFS order and return one collector per Collector leaf,
 * SPDX-License-Identifier: Apache-2.0
use datafusion::execution::context::SessionContext;
    "electronics",
// |  6  | apple  |   200 | active    | books       |
fn pred_int(col: &str, op: Operator, v: i32) -> BoolNode {
];
    // (no Phase-2 mask), but Path C tree eval requires BooleanMask today.
        object_path,
mod boolean_algebra;
        BoolNode::DelegationPossible { .. } => {}
fn write_fixture_parquet() -> NamedTempFile {
// |  3  | amazon |   120 | active    | electronics |
// doc ids in `[min_doc, max_doc)` as a packed u64[] bitset.
// | 15  | google |    55 | active    | electronics |
    let mut offset = 0i64;
        .await
use std::sync::OnceLock;
        max_doc: 16,
use super::eval::{RowGroupBitsetSource, TreeBitsetSource};
// |  1  | amazon |   150 | archived  | electronics |
                cat.value(i).to_string(),
#[derive(Debug)]
    let tmp = write_fixture_parquet();
    // distinct i32 per leaf works.
    let per_leaf: Vec<(i32, Arc<dyn RowGroupDocsCollector>)> = collectors
    for i in 0..parquet_meta.num_row_groups() {
        row_groups: rgs,
    );
use datafusion::arrow::array::{Array, Int32Array, Int64Array, StringArray};
        .enumerate()
 * The OpenSearch Contributors require contributions made to
        parquet_size: size,
        schema.clone(),
            Arc::new(Int32Array::from(PRICES.to_vec())),
        for &doc in &self.matching {
        let price = b.column(1).as_any().downcast_ref::<Int32Array>().unwrap();
    "electronics",
    };
    let right: Arc<dyn datafusion::physical_expr::PhysicalExpr> =
            index: i,
        Field::new("category", DataType::Utf8, false),
    matching: Vec<i32>,
        offset += n;
    "electronics",
        emit_row_ids: false,
                status.value(i).to_string(),
            ));
use datafusion::common::ScalarValue;
// |  9  | google |   300 | archived  | electronics |
                out[rel / 64] |= 1u64 << (rel % 64);
        .build();
        Ok(out.into())
    let mut stream =
    }
        evaluator_factory: factory,
                schema.clone(),
    let parquet_meta = meta.metadata().clone();
        pushdown_predicate: None,
        .build();
impl RowGroupDocsCollector for MockCollector {
                pruning_predicates: std::sync::Arc::new(std::collections::HashMap::new()),
struct MockCollector {
}
}
];
    BoolNode::Collector {
        BoolNode::Predicate(_) => {}
    ))
        });
    let matching: Vec<i32> = BRANDS
    // Load parquet metadata for the SegmentFileInfo.
    let meta =
    BoolNode::Predicate(Arc::new(
                    ),
        .indexed_pushdown_filters(false)
        for i in 0..b.num_rows() {
        ));
        }
    std::sync::Arc<dyn datafusion::physical_plan::ExecutionPlan>,
            }
        BoolNode::Collector { annotation_id } => {
    "electronics",
    wire(tree, &mut out);
    let row_ids: Vec<i64> = (0..16).collect();
    let col_idx = schema.index_of(col).expect("column in fixture schema");
    let props = datafusion::parquet::file::properties::WriterProperties::builder()
    "books",
        store_url,
    .unwrap();
                &schema,
        Field::new("price", DataType::Int32, false),
use super::page_pruner::PagePruner;
/// Build a `BoolNode::Predicate(expr)` for `col op <int value>`.
];
                        _stream_metrics,
                        _stream_metrics.ffm_collector_calls.clone(),
            num_rows: n,
// Collector leaf, matching the tag to a fixture-specific mock.
mod sort_reverse_row_id;
    let task_ctx = ctx.task_ctx();
        let brand = b.column(0).as_any().downcast_ref::<StringArray>().unwrap();
        let cat = b.column(3).as_any().downcast_ref::<StringArray>().unwrap();
    (rows, plan)
    let segment = SegmentFileInfo {
//! End-to-end tests covering `IndexedTableProvider` → `IndexedExec` →
    let ctx = SessionContext::new();
        prune_tree_config: None,
 * this file be licensed under the Apache-2.0 license or a
        schema: schema.clone(),
    let mut w = ArrowWriter::try_new(tmp.reopen().unwrap(), schema, Some(props)).unwrap();
    w.write(&batch).unwrap();
// | 13  | apple  |    45 | archived  | electronics |
    let schema = build_fixture_schema();
use std::collections::HashMap;
fn build_fixture_schema() -> SchemaRef {
            Arc::new(StringArray::from(CATEGORIES.to_vec())),
use crate::indexed_table::index::CollectDocsResult;
                ),
        predicate_columns: vec![],
fn status_eq(value: &str) -> Arc<dyn RowGroupDocsCollector> {
        let schema = schema.clone();
    "electronics",
            Arc::new(StringArray::from(BRANDS.to_vec())),
) -> (
//! Bypass the Java/FFM + substrait layers by constructing the tree and
        .iter()
use tempfile::NamedTempFile;
                Some(2) => status_eq("archived"),
    // come from `createProvider` upcalls; tests don't cross FFM so any
                brand.value(i).to_string(),
/// Result order matches `tree.collector_leaves()`.
/// Like [`run_tree`] but also returns the physical plan so tests can
    let qc = crate::datafusion_query_config::DatafusionQueryConfig::builder()
