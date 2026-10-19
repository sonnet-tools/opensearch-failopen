/// Scan the 16-row fixture via the predicate-only (`FilterClass::None`) factory
    rows
        sort_min: None,
    for i in 0..parquet_meta.num_row_groups() {
    };
async fn run_constant_residual(residual: Arc<dyn PhysicalExpr>) -> usize {
                    None,
    let object_path = object_store::path::Path::from(path.to_string_lossy().as_ref());
    // 1 > 0 → true for every row → full 16-row fixture passes.
            first_row: offset,
        let b = batch.unwrap();
                    schema.clone(),
fn const_predicate(lhs: i32, op: Operator, rhs: i32) -> Arc<dyn PhysicalExpr> {
    assert_eq!(16, rows, "constant-true residual should keep every row");
        parquet_size: size,
                ));
    let rows = run_constant_residual(const_predicate(1, Operator::Lt, 0)).await;
use std::collections::HashMap;
    ctx.register_table("t", provider).unwrap();
    let size = std::fs::metadata(&path).unwrap().len();
 * SPDX-License-Identifier: Apache-2.0
use datafusion::arrow::array::{Array, Int32Array, StringArray};
    };
    let provider = Arc::new(IndexedTableProvider::new(IndexedTableConfig {
    let path = tmp.path().to_path_buf();
    EvaluatorFactory, IndexedTableConfig, IndexedTableProvider, SegmentFileInfo,
    let rows = run_constant_residual(const_predicate(1, Operator::Gt, 0)).await;
        evaluator_factory: factory,
    let mut stream = datafusion::physical_plan::execute_stream(plan, ctx.task_ctx()).unwrap();
        Arc::new(object_store::local::LocalFileSystem::new());
/// the emitted row count.
}
        cancellation_token: None,
        let residual = Arc::clone(&residual);
 *
    let right: Arc<dyn PhysicalExpr> = Arc::new(Literal::new(ScalarValue::Int32(Some(rhs))));
 * this file be licensed under the Apache-2.0 license or a
    let ctx = SessionContext::new();
 */
//! false` — e.g. an unfoldable `mktime('...') > N`, which once errored with
            index: i,
        store_url,
        .indexed_pushdown_filters(false)
        let schema = schema.clone();
/*
        .build();
use super::write_fixture_parquet;
use datafusion::physical_expr::PhysicalExpr;
            num_rows: n,
 * The OpenSearch Contributors require contributions made to
use super::super::stream::{FilterStrategy, RowGroupInfo};
 * compatible open source license.
use datafusion::logical_expr::Operator;
        pushdown_predicate: None,
                    Some(Arc::clone(&residual)),
        prune_tree_config: None,
    let file = std::fs::File::open(&path).unwrap();
        // Sanity: projected columns decode.
        global_base: 0,
        sort_orders: vec![],
        store,
        arrow_schema: schema.clone(),
/// with `emit_row_ids = false`, as `execute_indexed_with_context` does. Returns
    assert_eq!(0, rows, "constant-false residual should drop every row");
                    None,
//! Constant (column-less) predicate on the indexed path with `emit_row_ids =
use datafusion::physical_expr::expressions::{BinaryExpr, Literal};
                let pruner = Arc::new(PagePruner::new(
use super::super::eval::RowGroupBitsetSource;
    }));
        });
    let parquet_meta = meta.metadata().clone();
                    &schema,
use datafusion::execution::context::SessionContext;
                let eval: Arc<dyn RowGroupBitsetSource> = Arc::new(PredicateOnlyEvaluator::new(
use futures::StreamExt;
        row_groups: rgs,
}
    let mut rows = 0usize;
        sort_max: None,
/// Column-less `<lhs> <op> <rhs>` over two Int32 literals — a constant boolean.
use super::super::eval::predicate_evaluator::PredicateOnlyEvaluator;
    let mut offset = 0i64;
//! constant-false drops every row (the residual is evaluated, not ignored).
}
    // as residual in on_batch_mask.
    let store_url = ObjectStoreUrl::local_filesystem();
//! `no index_filter(...) in plan`. Asserts constant-true keeps every row and
        sort_fields: vec![],
    let qc = crate::datafusion_query_config::DatafusionQueryConfig::builder()
        Arc::new(
        )
        .target_partitions(1)
        writer_generation: 0,
use datafusion::common::ScalarValue;
    }
        object_path,
    let mut rgs = Vec::new();
                    pruner,
        offset += n;
async fn constant_true_predicate_keeps_all_rows() {
                    Some(PagePruneMetrics::from_stream_metrics(stream_metrics)),
use std::sync::Arc;
use datafusion::parquet::arrow::arrow_reader::{ArrowReaderMetadata, ArrowReaderOptions};
    let plan = df.create_physical_plan().await.unwrap();
            },
#[tokio::test]
        .force_strategy(Some(FilterStrategy::BooleanMask))
    let df = ctx.sql("SELECT brand, price FROM t").await.unwrap();
};
        let _ = b.column(1).as_any().downcast_ref::<Int32Array>().unwrap();
                ));
    // 1 < 0 → false for every row → zero rows emitted.
    // FilterClass::None: no pruning predicate (column-less), constant applied
        rgs.push(RowGroupInfo {
        predicate_columns: vec![],
        rows += b.num_rows();
use super::super::table_provider::{
    let left: Arc<dyn PhysicalExpr> = Arc::new(Literal::new(ScalarValue::Int32(Some(lhs))));
                Ok(eval)
        metadata: Arc::clone(&parquet_meta),
async fn constant_false_predicate_drops_all_rows() {
use datafusion::execution::object_store::ObjectStoreUrl;
    let meta =
    Arc::new(BinaryExpr::new(left, op, right))
    let schema = meta.schema().clone();
        max_doc: 16,
        segments: vec![segment],
    let tmp = write_fixture_parquet();
        query_config: std::sync::Arc::new(qc),
    let segment = SegmentFileInfo {
use super::super::page_pruner::{PagePruneMetrics, PagePruner};
        let _ = b.column(0).as_any().downcast_ref::<StringArray>().unwrap();
            move |segment: &SegmentFileInfo, _chunk, stream_metrics, _stats_prune_tree| {
    let store: Arc<dyn object_store::ObjectStore> =
    }
    let factory: EvaluatorFactory = {
}
        schema: schema.clone(),
        let n = parquet_meta.row_group(i).num_rows();
#[tokio::test]
                    Arc::clone(&segment.metadata),
                    HashMap::new(),
    while let Some(batch) = stream.next().await {
        ArrowReaderMetadata::load(&file, ArrowReaderOptions::new().with_page_index(true)).unwrap();
        emit_row_ids: false,
