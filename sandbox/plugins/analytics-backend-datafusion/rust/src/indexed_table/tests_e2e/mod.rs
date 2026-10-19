        }
        schema.clone(),
fn build_fixture_schema() -> SchemaRef {
        sort_max: None,
    let matching: Vec<i32> = BRANDS
    }));
    // Load parquet metadata for the SegmentFileInfo.
// | 12  | amazon |    30 | archived  | electronics |
// |  6  | apple  |   200 | active    | books       |
const PRICES: [i32; 16] = [
                leaves: Arc::new(
            }
}
mod fuzz;
// | 13  | apple  |    45 | archived  | electronics |
const BRANDS: [&str; 16] = [
use std::sync::Arc;
/// Like [`run_tree`] but also returns the physical plan so tests can
    let tree = tree.push_not_down();
use datafusion::common::ScalarValue;
                other => panic!("unknown test collector tag {:?}", other),
    "electronics",
    );
    let task_ctx = ctx.task_ctx();
mod null_columns;
    let provider = Arc::new(IndexedTableProvider::new(IndexedTableConfig {
fn pred_str(col: &str, op: Operator, v: &str) -> BoolNode {
/// read metrics off it after execution.
    let schema = build_fixture_schema();
    "electronics",
                &schema,
    let meta =
fn brand_eq(value: &str) -> Arc<dyn RowGroupDocsCollector> {
    Arc::new(Schema::new(vec![
        .set_max_row_group_size(8)
    let ctx = SessionContext::new();
    }
                    crate::indexed_table::page_pruner::PagePruneMetrics::from_stream_metrics(
 * The OpenSearch Contributors require contributions made to
    };
        .set_statistics_enabled(datafusion::parquet::file::properties::EnabledStatistics::Page)
use std::collections::HashMap;
}
                pruning_predicates: std::sync::Arc::new(std::collections::HashMap::new()),
mod metrics;
        parquet_size: size,
}
    wire(tree, &mut out);
    let col_idx = schema.index_of(col).expect("column in fixture schema");
mod sort_reverse_row_id;
mod page_pruning;
// `BoolNode::Collector.query_bytes`. `wire_collectors_from_bytes` walks the
    let schema = meta.schema().clone();
async fn run_tree(tree: BoolNode) -> Vec<(String, i32, String, String)> {
}
        .build();
        sort_min: None,
        let b = batch.unwrap();
 */
    let mut stream =
mod multi_segment;
use datafusion::arrow::datatypes::{DataType, Field, Schema, SchemaRef};
    (rows, plan)
        &self,
/// Build a collector that returns docs matching `status == value`.
// tree in DFS order and returns one `Arc<dyn RowGroupDocsCollector>` per
        .map(|(i, _)| i as i32)
    let df = ctx
const STATUSES: [&str; 16] = [
            };
        .collect();
/// Build a `BoolNode::Predicate(expr)` for `col op <string value>`.
//! exercising the full streaming pipeline end-to-end.
        rgs.push(RowGroupInfo {
        segments: vec![segment],
/// Build a collector that returns docs matching `brand == value`.
        emit_row_ids: false,
        datafusion::physical_expr::expressions::BinaryExpr::new(left, op, right),
    .unwrap();
            Arc::new(Int64Array::from(row_ids)),
    "books",
                    crate::indexed_table::eval::bitmap_tree::CollectorLeafBitmaps::new(
//! collectors directly in Rust; that keeps the test hermetic while still
}
    fn collect_packed_u64_bitset(
        datafusion::physical_expr::expressions::BinaryExpr::new(left, op, right),
}
    "electronics",
    let parquet_meta = meta.metadata().clone();
use std::sync::OnceLock;
        store,
            first_row: offset,
        let schema = schema.clone();
    "electronics",
// ── Test runner: build provider + execute + collect rows ───────────
    while let Some(batch) = stream.next().await {
        .await
    ))
                        _stream_metrics,
    // (no Phase-2 mask), but Path C tree eval requires BooleanMask today.
    "electronics",
        datafusion::physical_plan::execute_stream(std::sync::Arc::clone(&plan), task_ctx).unwrap();
    let store_url = datafusion::execution::object_store::ObjectStoreUrl::local_filesystem();
//! `IndexedStream` → `BitmapTreeEvaluator` with a complex boolean tree.
) -> (
    }
    "archived", "active", "active", "archived", "archived", "active", "active",
        Arc::new(datafusion::physical_expr::expressions::Literal::new(
    let col_idx = schema.index_of(col).expect("column in fixture schema");
];
    let mut offset = 0i64;
}
        Arc::new(object_store::local::LocalFileSystem::new());
    // distinct i32 per leaf works.
        ],
    let matching: Vec<i32> = STATUSES
        object_path,
fn pred_int(col: &str, op: Operator, v: i32) -> BoolNode {
    ctx.register_table("t", provider).unwrap();
        max_doc: 16,
        ));
        for &doc in &self.matching {
    let left: Arc<dyn datafusion::physical_expr::PhysicalExpr> = Arc::new(
// |-----|--------|-------|-----------|-------------|
    let right: Arc<dyn datafusion::physical_expr::PhysicalExpr> = Arc::new(
    tree: BoolNode,
    let size = std::fs::metadata(&path).unwrap().len();
    // Test provider_key assignment: index in DFS order. Real provider keys
fn write_fixture_parquet() -> NamedTempFile {
        Field::new("__row_id__", DataType::Int64, false),
        .iter()
    ))
    let segment = SegmentFileInfo {
        .build();
    "electronics",
    "electronics",
impl RowGroupDocsCollector for MockCollector {
}
    match node {
    let batch = RecordBatch::try_new(
        global_base: 0,
/// Build a `BoolNode::Predicate(expr)` for `col op <int value>`.
                cost_predicate: 1,
// | 15  | google |    55 | active    | electronics |
    );
        cancellation_token: None,
                out[rel / 64] |= 1u64 << (rel % 64);
// |  9  | google |   300 | archived  | electronics |
                rg_index_to_pos: HashMap::new(),
    let left: Arc<dyn datafusion::physical_expr::PhysicalExpr> = Arc::new(
const CATEGORIES: [&str; 16] = [
        let per_leaf = per_leaf.clone();
// |  0  | amazon |    50 | active    | electronics |
// ── Mock index-backend-like collector ─────────────────────────────────────
// |  3  | amazon |   120 | active    | electronics |
        vec![
        let status = b.column(2).as_any().downcast_ref::<StringArray>().unwrap();
                max_collector_parallelism: 1,
    "electronics",
use super::page_pruner::PagePruner;
            Arc::new(Int32Array::from(PRICES.to_vec())),
        .map(|(i, _)| i as i32)
    // relies on this alignment. RowSelection would still work for Path B
        BoolNode::Predicate(_) => {}
    Arc::new(MockCollector { matching })
    );
        predicate_columns: vec![],
                    crate::indexed_table::eval::CollectorCallStrategy::TightenOuterBounds,
                cat.value(i).to_string(),
    };
                        _stream_metrics.ffm_collector_calls.clone(),
        BoolNode::Collector { annotation_id } => {
        .sql("SELECT brand, price, status, category FROM t")
        pushdown_predicate: None,
    out
// | 10  | samsung|    70 | active    | electronics |
                stats_prune_tree: None,
                    ),
    ) -> Result<CollectDocsResult, String> {
        .iter()
];
            let pruner = Arc::new(PagePruner::new(
    BoolNode::Collector {
//
    let schema = build_fixture_schema();
    for i in 0..parquet_meta.num_row_groups() {
    let props = datafusion::parquet::file::properties::WriterProperties::builder()
    "samsung", "samsung", "amazon", "apple", "samsung", "google",
use super::table_provider::{IndexedTableConfig, IndexedTableProvider, SegmentFileInfo};
}
            if doc >= min_doc && doc < max_doc {
// |  5  | apple  |    95 | archived  | electronics |
    BoolNode::Predicate(Arc::new(
    )
// Takes a pre-computed set of matching doc ids (absolute). Returns bits for
    // Normalize NOT push-down; build one collector per Collector leaf in DFS order.
/// built from the leaf's `query_bytes` tag (0=amazon, 1=apple, 2=archived).
mod qtf_fetch_phase;
// Collector leaf, matching the tag to a fixture-specific mock.
 * this file be licensed under the Apache-2.0 license or a
    "books",
            let eval: Arc<dyn RowGroupBitsetSource> = Arc::new(TreeBitsetSource {
        .target_partitions(1)
        datafusion::physical_expr::expressions::Literal::new(ScalarValue::Int32(Some(v))),
                price.value(i),
    50, 150, 80, 120, 90, 95, 200, 60, 40, 300, 70, 150, 30, 45, 99, 55,
        let price = b.column(1).as_any().downcast_ref::<Int32Array>().unwrap();
    let mut w = ArrowWriter::try_new(tmp.reopen().unwrap(), schema, Some(props)).unwrap();
    let tmp = NamedTempFile::new().unwrap();
//! Bypass the Java/FFM + substrait layers by constructing the tree and
// |  7  | apple  |    60 | active    | electronics |
                collector_strategy:
/// Walk `tree` in DFS order and return one collector per Collector leaf,
    let plan = df.create_physical_plan().await.unwrap();
        .indexed_pushdown_filters(false)
mod boolean_algebra;
use crate::indexed_table::index::CollectDocsResult;
        sort_fields: vec![],
                ),
use super::eval::{RowGroupBitsetSource, TreeBitsetSource};
            let resolved = tree.resolve(&per_leaf)?;
        Field::new("price", DataType::Int32, false),
use super::index::RowGroupDocsCollector;
                Some(0) => brand_eq("amazon"),
        let mut out = vec![0u64; span.div_ceil(64)];
}
use datafusion::arrow::array::{Array, Int32Array, Int64Array, StringArray};
    let store: Arc<dyn object_store::ObjectStore> =
        .enumerate()
    // come from `createProvider` upcalls; tests don't cross FFM so any
                cost_collector: 10,
use futures::StreamExt;
            out.push(c);
// ── Test fixture: parquet table with 16 rows ────────────────────────
    let object_path = object_store::path::Path::from(path.to_string_lossy().as_ref());
        .enumerate()
        datafusion::physical_expr::expressions::Column::new(col, col_idx),
        prune_tree_config: None,
                evaluator: Arc::new(BitmapTreeEvaluator),
        query_config: std::sync::Arc::new(qc),
            });
        Ok(out.into())
fn status_eq(value: &str) -> Arc<dyn RowGroupDocsCollector> {
            Arc::new(StringArray::from(STATUSES.to_vec())),
mod schema_drift;
        evaluator_factory: factory,
        let span = (max_doc - min_doc) as usize;
//
    let factory: super::table_provider::EvaluatorFactory = {
async fn run_tree_and_plan(
            rows.push((
fn wire(node: &BoolNode, out: &mut Vec<Arc<dyn RowGroupDocsCollector>>) {
        .collect();
/*
fn wire_collectors(tree: &BoolNode) -> Vec<Arc<dyn RowGroupDocsCollector>> {
                page_pruner: pruner,
// | row | brand  | price | status    | category    |
    let per_leaf: Vec<(i32, Arc<dyn RowGroupDocsCollector>)> = collectors
                schema.clone(),
            index: i,
    }
    "electronics",
];
        let tree = Arc::clone(&tree);
    // Use smallish row groups so there's > 1 and the streaming loop cycles.
        .collect();
        for i in 0..b.num_rows() {
                page_prune_metrics: Some(
        sort_orders: vec![],
            Ok(eval)
];
                status.value(i).to_string(),
        .enumerate()
    // Enable page index so PagePruner can prune predicates.
use datafusion::logical_expr::Operator;
        store_url,
    let right: Arc<dyn datafusion::physical_expr::PhysicalExpr> =
 * compatible open source license.
            Arc::new(StringArray::from(CATEGORIES.to_vec())),
        }
    "electronics",
        annotation_id: tag as i32,
                tree: Arc::new(resolved),
    "books",
        .filter(|(_, b)| **b == value)
        offset += n;
    // equals the row-index-within-RG. Phase 2 bitmap_to_batch_mask
            num_rows: n,
// ── Tree-building helpers ──────────────────────────────────────────
//!
        .force_strategy(Some(FilterStrategy::BooleanMask))
//! End-to-end tests covering `IndexedTableProvider` → `IndexedExec` →
mod constant_predicate;
    std::sync::Arc<dyn datafusion::physical_plan::ExecutionPlan>,
#[derive(Debug)]
    "active", "archived", "active", "active", "active", "archived", "active", "active", "active",
//
fn index_leaf(tag: u8) -> BoolNode {
mod streaming_at_scale;
    w.write(&batch).unwrap();
        .map(|(i, c)| (i as i32, c))
    }
}
    let mut rgs = Vec::new();
use super::stream::{FilterStrategy, RowGroupInfo};
        }
    let qc = crate::datafusion_query_config::DatafusionQueryConfig::builder()
// |  1  | amazon |   150 | archived  | electronics |
        min_doc: i32,
            ));
        .filter(|(_, s)| **s == value)
        BoolNode::DelegationPossible { .. } => {}
    w.close().unwrap();
    "electronics",
    let schema = build_fixture_schema();
        .into_iter()
use datafusion::parquet::arrow::arrow_reader::{ArrowReaderMetadata, ArrowReaderOptions};
    run_tree_and_plan(tree).await.0
#![cfg(test)]
use datafusion::execution::context::SessionContext;
        writer_generation: 0,
use super::eval::bitmap_tree::{BitmapTreeEvaluator, CollectorLeafBitmaps};
        metadata: Arc::clone(&parquet_meta),
        schema: schema.clone(),
        datafusion::physical_expr::expressions::Column::new(col, col_idx),
// |  8  | google |    40 | active    | electronics |
    let tree = Arc::new(tree);
        });
            Arc::new(StringArray::from(BRANDS.to_vec())),
        max_doc: i32,
// | 14  | samsung|    99 | active    | electronics |
mod dynamic_filter_pushdown;
    let tmp = write_fixture_parquet();
    }
    Arc::new(MockCollector { matching })
// |  2  | amazon |    80 | active    | books       |
 *
// |  4  | apple  |    90 | active    | electronics |
        Field::new("brand", DataType::Utf8, false),
                Some(1) => brand_eq("apple"),
        BoolNode::Not(inner) => wire(inner, out),
/// Result order matches `tree.collector_leaves()`.
            let c: Arc<dyn RowGroupDocsCollector> = match Some(*annotation_id as u8) {
    // Force BooleanMask so batches contain the entire RG and batch_offset
    tmp
        Arc::new(move |segment, _chunk, _stream_metrics, _stats_prune_tree| {
        let cat = b.column(3).as_any().downcast_ref::<StringArray>().unwrap();
    let collectors = wire_collectors(&tree);
    let mut rows: Vec<(String, i32, String, String)> = Vec::new();
    BoolNode::Predicate(Arc::new(
    let path = tmp.path().to_path_buf();
use super::bool_tree::BoolNode;
mod row_id_emission;
    "amazon", "amazon", "amazon", "amazon", "apple", "apple", "apple", "apple", "google", "google",
// Test-only leaf encoding: `index_leaf(tag)` puts a single-byte tag into
                    ),
        Field::new("status", DataType::Utf8, false),
use tempfile::NamedTempFile;
            ScalarValue::Utf8(Some(v.to_string())),
        row_groups: rgs,
    matching: Vec<i32>,
                let rel = (doc - min_doc) as usize;
mod row_id_strategies;
        let n = parquet_meta.row_group(i).num_rows();
) {
    "electronics",
        ArrowReaderMetadata::load(&file, ArrowReaderOptions::new().with_page_index(true)).unwrap();
        BoolNode::And(c) | BoolNode::Or(c) => c.iter().for_each(|x| wire(x, out)),
        Field::new("category", DataType::Utf8, false),
        arrow_schema: schema.clone(),
        })
// doc ids in `[min_doc, max_doc)` as a packed u64[] bitset.
                Arc::clone(&segment.metadata),
        .unwrap();
}
    ]))
use datafusion::arrow::record_batch::RecordBatch;
}
    Vec<(String, i32, String, String)>,
// | 11  | samsung|   150 | active    | books       |
        let brand = b.column(0).as_any().downcast_ref::<StringArray>().unwrap();
use datafusion::parquet::arrow::ArrowWriter;
                brand.value(i).to_string(),
                ),
 * SPDX-License-Identifier: Apache-2.0
                Some(2) => status_eq("archived"),
struct MockCollector {
    "electronics",
    let mut out = Vec::new();
            ));
    let file = std::fs::File::open(&path).unwrap();
    let row_ids: Vec<i64> = (0..16).collect();
