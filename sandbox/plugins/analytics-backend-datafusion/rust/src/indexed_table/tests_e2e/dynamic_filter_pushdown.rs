            Ok(eval)
        evaluator_factory: factory,
        rgs.len() >= 4,
                    0,
    }));
fn rg_pruned_at_prefetch(plan: &Arc<dyn datafusion::physical_plan::ExecutionPlan>) -> usize {
//! insert `SortExec { fetch }` + push its `DynamicFilterPhysicalExpr` into
                    pruner,
         at_prefetch={at_prefetch} at_poll={at_poll}"
/// reading metrics).
use super::super::table_provider::{IndexedTableConfig, IndexedTableProvider, SegmentFileInfo};
    let plan = df.create_physical_plan().await.unwrap();
    // ([0..3], [4..7], [8..11]) become prunable.
use datafusion::parquet::arrow::arrow_reader::{ArrowReaderMetadata, ArrowReaderOptions};
    assert_eq!(at_prefetch + at_poll, 3, "expected 3 of 4 RGs pruned");
        arrow_schema: schema.clone(),
        "fixture should have >=4 row groups, got {}",
        offset += n;
        let b = batch.unwrap();
            prices.push(price.value(i));
    ]));
/// the only thing that can prune a row group is the dynamic filter.
        store,
    };
    // Descending in file order: row 0 has the highest price (15), so RG0 holds
        Ok(out.into())
                        crate::indexed_table::eval::single_collector::FfmDelegatedBackendCollectorFactory,
    }
            num_rows: n,
    // eval (prefetch phase); the final RG is caught at the poll phase after the
 * The OpenSearch Contributors require contributions made to
//! End-to-end verification of runtime dynamic-filter (TopK) pruning on the
async fn run_indexed(sql: &str) -> (Vec<i32>, Arc<dyn datafusion::physical_plan::ExecutionPlan>) {
    ) -> Result<CollectDocsResult, String> {
use datafusion::execution::context::SessionContext;
/// This mirrors a time-ordered OpenSearch index queried `ORDER BY ts DESC LIMIT
                    None,
    // (1) Correctness: exactly the global top-2 by price, in DESC order.
    // Three of four RGs pruned (RG0 is processed to fill the heap).
use datafusion::arrow::record_batch::RecordBatch;
    let meta =
        ],
    fn collect_packed_u64_bitset(
        for rel in 0..span {
use super::super::stream::{FilterStrategy, RowGroupInfo};
                    None,
    let (tmp, schema) = write_fixture();
        schema: schema.clone(),
                    None,
    assert_eq!(prices.len(), ROWS, "full result set without LIMIT");
    // [12..15]). As the TopK heap fills, the threshold rises and the earlier RGs
                    None,
                &schema,
    let path = tmp.path().to_path_buf();
         at_prefetch={at_prefetch} at_poll={at_poll}"
    assert_eq!(rg_pruned_at_poll(&plan), 0, "no filter → no poll prune");
    let df = ctx.sql(sql).await.unwrap();
    assert_eq!(prices, vec![15, 14], "top-2 DESC prices");
    let provider = Arc::new(IndexedTableProvider::new(IndexedTableConfig {
        at_prefetch > 0,
        emit_row_ids: false,
                    crate::indexed_table::eval::single_collector::CollectorCallStrategy::FullRange,
        parquet_size: size,
    let (prices, plan) = run_indexed("SELECT brand, price FROM t ORDER BY price DESC").await;
    let segment = SegmentFileInfo {
        .build();
async fn topk_dynamic_filter_prunes_row_groups() {
struct MatchAllCollector;
            .as_any()
    }
    let file = std::fs::File::open(&path).unwrap();
use datafusion::arrow::array::{Int32Array, StringArray};
    let mut offset = 0i64;
    // Row-granular so the parquet stream + dynamic filter behave like production;
async fn no_limit_means_no_dynamic_filter_pruning() {
    sum_metric(plan, "dynamic_filter_rg_pruned_at_poll")
    assert_eq!(
        max_doc: offset,
    // Without a fetch/limit there is no TopK and hence no dynamic filter, so
        .batch_size(RG_ROWS)
            .column(b.schema().index_of("price").unwrap())
}
    // coalescing all rows into a single end-of-stream batch.
    let qc = crate::datafusion_query_config::DatafusionQueryConfig::builder()
impl RowGroupDocsCollector for MatchAllCollector {
    let mut stream =
    // nothing should be pruned and all 16 rows are returned.
                crate::indexed_table::eval::single_collector::SingleCollectorEvaluator::new(
    (tmp, schema)
        });
        0,
    let brands: Vec<String> = (0..ROWS).map(|i| format!("b{i}")).collect();
fn write_fixture() -> (NamedTempFile, SchemaRef) {
    let props = datafusion::parquet::file::properties::WriterProperties::builder()
    assert!(
        for i in 0..b.num_rows() {
    let schema = Arc::new(Schema::new(vec![
    (prices, plan)
/// 16 rows, `price` = 15..0 **descending** in file order, 4 rows per row group →
            .downcast_ref::<Int32Array>()
#[tokio::test(flavor = "multi_thread", worker_threads = 4)]
 * SPDX-License-Identifier: Apache-2.0
    // code paths are exercised.
            index: i,
fn sum_metric(plan: &Arc<dyn datafusion::physical_plan::ExecutionPlan>, name: &str) -> usize {
        "no filter → no prefetch prune"
    let store: Arc<dyn object_store::ObjectStore> =
                schema.clone(),
}
use std::sync::Arc;
    ctx.register_table("t", provider).unwrap();
    // single partition so all RGs flow through one stream.
        writer_generation: 0,
//! indexed scan.
    };
            Arc::new(StringArray::from(brands)),
 */
    w.write(&batch).unwrap();
use futures::StreamExt;
            .unwrap();
        })
#[tokio::test(flavor = "multi_thread", worker_threads = 4)]
}
                    std::sync::Arc::new(
    assert!(
    let object_path = object_store::path::Path::from(path.to_string_lossy().as_ref());
            out[rel / 64] |= 1u64 << (rel % 64);
    let tmp = NamedTempFile::new().unwrap();
    for i in 0..parquet_meta.num_row_groups() {
}
    let task_ctx = ctx.task_ctx();
        sort_min: None,
use crate::indexed_table::index::CollectDocsResult;
        &self,
//!   2. `dynamic_filter_rg_pruned > 0` (the optimization actually fired).
use tempfile::NamedTempFile;
fn rg_pruned_at_poll(plan: &Arc<dyn datafusion::physical_plan::ExecutionPlan>) -> usize {
        }
    sum_metric(plan, "dynamic_filter_rg_pruned_at_prefetch")
        predicate_columns: vec![],
                    ),
        "expected >=1 RG pruned at the POLL phase (backstop after further tightening), \
        Field::new("brand", DataType::Utf8, false),
        Arc::new(object_store::local::LocalFileSystem::new());
    // the top values and a DESC TopK can prune later RGs.
/// k` where recent (high) values sit in the first row groups read.
        query_config: std::sync::Arc::new(qc),
const RG_ROWS: usize = 4;
    let at_poll = rg_pruned_at_poll(&plan);
            let collector: Arc<dyn RowGroupDocsCollector> = Arc::new(MatchAllCollector);
                    Some(collector),
}
use super::super::index::RowGroupDocsCollector;
    assert_eq!(prices.first().copied(), Some(15));
        .set_statistics_enabled(datafusion::parquet::file::properties::EnabledStatistics::Page)
    let mut rgs = Vec::new();
            );
        schema.clone(),
    // so once RG0 fills the heap, the next RGs are pruned BEFORE their Lucene
        rgs.len()
        metadata: Arc::clone(&parquet_meta),
        let n = parquet_meta.row_group(i).num_rows();
/// Build the indexed provider over the fixture and run `sql`. Returns the
                    None,
        .build();
        row_groups: rgs,
}
        .target_partitions(1)
//! `QueryShardExec`, executes, then asserts:
    let ctx = SessionContext::new();
        ArrowReaderMetadata::load(&file, ArrowReaderOptions::new().with_page_index(true)).unwrap();
        rgs.push(RowGroupInfo {
        sort_max: None,
/// `(price)` rows in emission order plus the executed physical plan (for
        "expected >=1 RG pruned at the PREFETCH phase (skipping the Lucene eval), \
}
/// row groups in index order, so the *highest* prices arrive first. That is the
//!   1. results equal the full-scan top-k (correctness), and
    // ORDER BY price DESC LIMIT 2 → top-2 prices are 15, 14 (both in the last RG
//!
                Arc::clone(&segment.metadata),
    }
        store_url,
    let mut total = 0usize;
    let store_url = datafusion::execution::object_store::ObjectStoreUrl::local_filesystem();
        segments: vec![segment],
    let (prices, plan) =
/// "extreme values appear early" shape a DESC-TopK needs: after RG0 the heap
                    segment.writer_generation,
        global_base: 0,
    for child in plan.children() {
        prune_tree_config: None,
    // (2) Both prune phases fire for this query. The prefetch runs ~1 RG ahead,
        let mut out = vec![0u64; span.div_ceil(64)];
    total
    let size = std::fs::metadata(&path).unwrap().len();
    let batch = RecordBatch::try_new(
        sort_fields: vec![],
use super::super::eval::RowGroupBitsetSource;
                    std::sync::Arc::new(std::collections::HashMap::new()),
        total += metrics.sum_by_name(name).map(|v| v.as_usize()).unwrap_or(0);
                    std::collections::HashMap::new(),
    let mut w = ArrowWriter::try_new(tmp.reopen().unwrap(), schema.clone(), Some(props)).unwrap();
                    None,
    // SortExec can tighten the dynamic filter between row groups, instead of
            ));
//! four disjoint-range row groups, lets DataFusion's default physical optimizer
    );
///
    let mut prices: Vec<i32> = Vec::new();
        }
    while let Some(batch) = stream.next().await {
    let at_prefetch = rg_pruned_at_prefetch(&plan);
    let factory: super::super::table_provider::EvaluatorFactory = {
    assert!(
                ),
        Arc::new(move |segment, _chunk, _stream_metrics, _stats_prune_tree| {
        pushdown_predicate: None,
use datafusion::arrow::datatypes::{DataType, Field, Schema, SchemaRef};
            let eval: Arc<dyn RowGroupBitsetSource> = Arc::new(
/*
        Field::new("price", DataType::Int32, false),
const ROWS: usize = 16;
 *
    if let Some(metrics) = plan.metrics() {
            let pruner = Arc::new(PagePruner::new(
    .unwrap();
        max_doc: i32,
    )
//! Builds `SELECT ... ORDER BY price DESC LIMIT k` over a single segment with
 * this file be licensed under the Apache-2.0 license or a
        let span = (max_doc - min_doc).max(0) as usize;
            first_row: offset,
    }
    );
    );
use super::super::page_pruner::PagePruner;
        run_indexed("SELECT brand, price FROM t ORDER BY price DESC LIMIT 2").await;
        .set_max_row_group_size(RG_ROWS)
/// Match-all collector: every doc in `[min_doc, max_doc)` is a candidate, so
}
    // filter tightens further. We assert each phase independently to prove both
        rg_pruned_at_prefetch(&plan),
use datafusion::parquet::arrow::ArrowWriter;
        vec![
#[derive(Debug)]
    w.close().unwrap();
        let price = b
/// Recursively sum a named counter across the plan tree.
        sort_orders: vec![],
 * compatible open source license.
    // One batch per row group (RG_ROWS): the stream flushes after each RG so
/// RG ranges (by row position) [15..12], [11..8], [7..4], [3..0]. The scan reads
            Arc::new(Int32Array::from(prices)),
        min_doc: i32,
        at_poll > 0,
    );
        total += sum_metric(child, name);
        datafusion::physical_plan::execute_stream(Arc::clone(&plan), task_ctx).unwrap();
        cancellation_token: None,
        let schema = schema.clone();
    let prices: Vec<i32> = (0..ROWS as i32).map(|i| ROWS as i32 - 1 - i).collect();
        object_path,
/// threshold is high enough to prune the later, lower-valued row groups.
    let parquet_meta = meta.metadata().clone();
    }
