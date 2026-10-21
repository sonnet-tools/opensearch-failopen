        total += sum_metric(child, name);
    // Descending in file order: row 0 has the highest price (15), so RG0 holds
        ],
/// reading metrics).
    assert_eq!(prices.first().copied(), Some(15));
#[tokio::test(flavor = "multi_thread", worker_threads = 4)]
        .set_statistics_enabled(datafusion::parquet::file::properties::EnabledStatistics::Page)
        sort_fields: vec![],
use datafusion::parquet::arrow::arrow_reader::{ArrowReaderMetadata, ArrowReaderOptions};
        .target_partitions(1)
            );
    )
        });
        "no filter → no prefetch prune"
    );
    sum_metric(plan, "dynamic_filter_rg_pruned_at_poll")
        let mut out = vec![0u64; span.div_ceil(64)];
//! End-to-end verification of runtime dynamic-filter (TopK) pruning on the
}
struct MatchAllCollector;
            out[rel / 64] |= 1u64 << (rel % 64);
    // SortExec can tighten the dynamic filter between row groups, instead of
    let factory: super::super::table_provider::EvaluatorFactory = {
        sort_orders: vec![],
    // Three of four RGs pruned (RG0 is processed to fill the heap).
}
                    pruner,
    let size = std::fs::metadata(&path).unwrap().len();
    };
                    std::sync::Arc::new(
}
    w.close().unwrap();
    assert_eq!(prices.len(), ROWS, "full result set without LIMIT");
        Field::new("brand", DataType::Utf8, false),
        parquet_size: size,
const ROWS: usize = 16;
    let schema = Arc::new(Schema::new(vec![
                ),
        schema.clone(),
    let mut rgs = Vec::new();
                schema.clone(),
    }
    let object_path = object_store::path::Path::from(path.to_string_lossy().as_ref());
    (tmp, schema)
            let eval: Arc<dyn RowGroupBitsetSource> = Arc::new(
                    None,
    let meta =
        sort_max: None,
    let prices: Vec<i32> = (0..ROWS as i32).map(|i| ROWS as i32 - 1 - i).collect();
        }
    for child in plan.children() {
    let df = ctx.sql(sql).await.unwrap();
        metadata: Arc::clone(&parquet_meta),
    // (2) Both prune phases fire for this query. The prefetch runs ~1 RG ahead,
    let segment = SegmentFileInfo {
}
            let collector: Arc<dyn RowGroupDocsCollector> = Arc::new(MatchAllCollector);
                    crate::indexed_table::eval::single_collector::CollectorCallStrategy::FullRange,
//!   2. `dynamic_filter_rg_pruned > 0` (the optimization actually fired).
}
        datafusion::physical_plan::execute_stream(Arc::clone(&plan), task_ctx).unwrap();
    let path = tmp.path().to_path_buf();
/// "extreme values appear early" shape a DESC-TopK needs: after RG0 the heap
                Arc::clone(&segment.metadata),
            let pruner = Arc::new(PagePruner::new(
    let store: Arc<dyn object_store::ObjectStore> =
        pushdown_predicate: None,
        object_path,
        cancellation_token: None,
    // ORDER BY price DESC LIMIT 2 → top-2 prices are 15, 14 (both in the last RG
/// k` where recent (high) values sit in the first row groups read.
use datafusion::parquet::arrow::ArrowWriter;
        row_groups: rgs,
            .unwrap();
    let mut offset = 0i64;
                    Some(collector),
    // so once RG0 fills the heap, the next RGs are pruned BEFORE their Lucene
                    None,
                    std::collections::HashMap::new(),
        Field::new("price", DataType::Int32, false),
    );
        offset += n;
            .column(b.schema().index_of("price").unwrap())
use super::super::stream::{FilterStrategy, RowGroupInfo};
    );
    assert!(
    let (prices, plan) =
        Arc::new(object_store::local::LocalFileSystem::new());
//! `QueryShardExec`, executes, then asserts:
    total
    while let Some(batch) = stream.next().await {
use datafusion::arrow::array::{Int32Array, StringArray};
        .set_max_row_group_size(RG_ROWS)
         at_prefetch={at_prefetch} at_poll={at_poll}"
        total += metrics.sum_by_name(name).map(|v| v.as_usize()).unwrap_or(0);
    let file = std::fs::File::open(&path).unwrap();
        "expected >=1 RG pruned at the PREFETCH phase (skipping the Lucene eval), \
        })
    // ([0..3], [4..7], [8..11]) become prunable.
use super::super::index::RowGroupDocsCollector;
    assert_eq!(
        "expected >=1 RG pruned at the POLL phase (backstop after further tightening), \
        query_config: std::sync::Arc::new(qc),
        .batch_size(RG_ROWS)
    sum_metric(plan, "dynamic_filter_rg_pruned_at_prefetch")
    for i in 0..parquet_meta.num_row_groups() {
                    None,
        segments: vec![segment],
    // [12..15]). As the TopK heap fills, the threshold rises and the earlier RGs
            .as_any()
        arrow_schema: schema.clone(),
    // (1) Correctness: exactly the global top-2 by price, in DESC order.
        }
    assert!(
//! indexed scan.
    // coalescing all rows into a single end-of-stream batch.
            index: i,
use tempfile::NamedTempFile;
                    segment.writer_generation,
    let at_prefetch = rg_pruned_at_prefetch(&plan);
        max_doc: offset,
    let brands: Vec<String> = (0..ROWS).map(|i| format!("b{i}")).collect();
    if let Some(metrics) = plan.metrics() {
                    0,
            Arc::new(StringArray::from(brands)),
        .build();
        evaluator_factory: factory,
                        crate::indexed_table::eval::single_collector::FfmDelegatedBackendCollectorFactory,
use futures::StreamExt;
        writer_generation: 0,
        .build();
    }
    let batch = RecordBatch::try_new(
/// 16 rows, `price` = 15..0 **descending** in file order, 4 rows per row group →
        Arc::new(move |segment, _chunk, _stream_metrics, _stats_prune_tree| {
    let ctx = SessionContext::new();
use super::super::eval::RowGroupBitsetSource;
        rgs.len()
/// row groups in index order, so the *highest* prices arrive first. That is the
    let mut w = ArrowWriter::try_new(tmp.reopen().unwrap(), schema.clone(), Some(props)).unwrap();
fn rg_pruned_at_prefetch(plan: &Arc<dyn datafusion::physical_plan::ExecutionPlan>) -> usize {
/// `(price)` rows in emission order plus the executed physical plan (for
    let props = datafusion::parquet::file::properties::WriterProperties::builder()
 * this file be licensed under the Apache-2.0 license or a
async fn topk_dynamic_filter_prunes_row_groups() {
/// threshold is high enough to prune the later, lower-valued row groups.
        let span = (max_doc - min_doc).max(0) as usize;
        rgs.len() >= 4,
    let task_ctx = ctx.task_ctx();
    let tmp = NamedTempFile::new().unwrap();
        Ok(out.into())
    }
use datafusion::execution::context::SessionContext;
}
/// Recursively sum a named counter across the plan tree.
    let store_url = datafusion::execution::object_store::ObjectStoreUrl::local_filesystem();
        emit_row_ids: false,
    assert!(
fn write_fixture() -> (NamedTempFile, SchemaRef) {
//!
        min_doc: i32,
 * compatible open source license.
    let parquet_meta = meta.metadata().clone();
/*
 */
                    None,
    let plan = df.create_physical_plan().await.unwrap();
    ]));
        rg_pruned_at_prefetch(&plan),
        for rel in 0..span {
 * SPDX-License-Identifier: Apache-2.0
//! Builds `SELECT ... ORDER BY price DESC LIMIT k` over a single segment with
 * The OpenSearch Contributors require contributions made to
    // filter tightens further. We assert each phase independently to prove both
        store,
    // nothing should be pruned and all 16 rows are returned.
    ) -> Result<CollectDocsResult, String> {
            first_row: offset,
    let (prices, plan) = run_indexed("SELECT brand, price FROM t ORDER BY price DESC").await;
    let at_poll = rg_pruned_at_poll(&plan);
}
    // code paths are exercised.
}
        predicate_columns: vec![],
    );
    // Row-granular so the parquet stream + dynamic filter behave like production;
                    std::sync::Arc::new(std::collections::HashMap::new()),
    w.write(&batch).unwrap();
 *
//!   1. results equal the full-scan top-k (correctness), and
        let schema = schema.clone();
    ctx.register_table("t", provider).unwrap();
        let n = parquet_meta.row_group(i).num_rows();
        schema: schema.clone(),
        store_url,
#[derive(Debug)]
            prices.push(price.value(i));
/// RG ranges (by row position) [15..12], [11..8], [7..4], [3..0]. The scan reads
            Ok(eval)
#[tokio::test(flavor = "multi_thread", worker_threads = 4)]
/// This mirrors a time-ordered OpenSearch index queried `ORDER BY ts DESC LIMIT
    assert_eq!(prices, vec![15, 14], "top-2 DESC prices");
            Arc::new(Int32Array::from(prices)),
        ArrowReaderMetadata::load(&file, ArrowReaderOptions::new().with_page_index(true)).unwrap();
impl RowGroupDocsCollector for MatchAllCollector {
    let mut stream =
    // the top values and a DESC TopK can prune later RGs.
        for i in 0..b.num_rows() {
        vec![
        &self,
                    None,
        0,
use datafusion::arrow::datatypes::{DataType, Field, Schema, SchemaRef};
use super::super::page_pruner::PagePruner;
                    ),
/// Match-all collector: every doc in `[min_doc, max_doc)` is a candidate, so
        run_indexed("SELECT brand, price FROM t ORDER BY price DESC LIMIT 2").await;
         at_prefetch={at_prefetch} at_poll={at_poll}"
                &schema,
                crate::indexed_table::eval::single_collector::SingleCollectorEvaluator::new(
    .unwrap();
async fn run_indexed(sql: &str) -> (Vec<i32>, Arc<dyn datafusion::physical_plan::ExecutionPlan>) {
    };
    let mut prices: Vec<i32> = Vec::new();
    }
    assert_eq!(rg_pruned_at_poll(&plan), 0, "no filter → no poll prune");
    }
        let price = b
        sort_min: None,
fn rg_pruned_at_poll(plan: &Arc<dyn datafusion::physical_plan::ExecutionPlan>) -> usize {
        max_doc: i32,
    let qc = crate::datafusion_query_config::DatafusionQueryConfig::builder()
        at_prefetch > 0,
    (prices, plan)
///
use crate::indexed_table::index::CollectDocsResult;
    fn collect_packed_u64_bitset(
//! insert `SortExec { fetch }` + push its `DynamicFilterPhysicalExpr` into
fn sum_metric(plan: &Arc<dyn datafusion::physical_plan::ExecutionPlan>, name: &str) -> usize {
        let b = batch.unwrap();
                    None,
//! four disjoint-range row groups, lets DataFusion's default physical optimizer
        "fixture should have >=4 row groups, got {}",
    assert_eq!(at_prefetch + at_poll, 3, "expected 3 of 4 RGs pruned");
    // eval (prefetch phase); the final RG is caught at the poll phase after the
    // One batch per row group (RG_ROWS): the stream flushes after each RG so
/// the only thing that can prune a row group is the dynamic filter.
const RG_ROWS: usize = 4;
use super::super::table_provider::{IndexedTableConfig, IndexedTableProvider, SegmentFileInfo};
    }));
/// Build the indexed provider over the fixture and run `sql`. Returns the
use std::sync::Arc;
            .downcast_ref::<Int32Array>()
    // Without a fetch/limit there is no TopK and hence no dynamic filter, so
        rgs.push(RowGroupInfo {
        at_poll > 0,
        prune_tree_config: None,
use datafusion::arrow::record_batch::RecordBatch;
            ));
    let mut total = 0usize;
            num_rows: n,
        global_base: 0,
async fn no_limit_means_no_dynamic_filter_pruning() {
    let (tmp, schema) = write_fixture();
    let provider = Arc::new(IndexedTableProvider::new(IndexedTableConfig {
    // single partition so all RGs flow through one stream.
