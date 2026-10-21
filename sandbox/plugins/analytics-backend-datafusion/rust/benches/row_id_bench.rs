                            segments: vec![segment],
    let parquet_meta = meta.metadata().clone();
    mgr.cpu_executor.shutdown();
                                as *mut datafusion::physical_plan::stream::RecordBatchStreamAdapter<
                    async move {
                                let resolved = tree.resolve(&[])?;
                        }
    for q in &queries {
        // === Mode 2: row_id_emit (indexed path, projects ___row_id + sort keys) ===
                                    }),
                            let schema = schema.clone();
            .unwrap();
    Arc::new(Schema::new(fields))
                        url,
                        df_rt,
                                    cost_collector: 10,
        let id_data = BenchmarkId::new(format!("{}/data_fetch", q.name), "");
fn get_metas(mgr: &RuntimeManager, file: &str) -> Arc<Vec<object_store::ObjectMeta>> {
                                    cost_collector: 10,
//! Benchmark: ClickBench queries — QTF row_id+sort_keys vs full data fetch.
                b.to_async(mgr.io_runtime.as_ref()).iter(|| {
        let sub = to_substrait_plan(&plan, &ctx.state()).unwrap();
fn bench_file() -> String {
    let queries = vec![
            b.to_async(mgr.io_runtime.as_ref()).iter(|| {
        group.bench_with_input(id_data, &plan_data, |b, plan| {
                                Ok(eval)
use datafusion::datasource::listing::ListingTableUrl;
                    let schema = schema.clone();
        },
                                let mut qc = DatafusionQueryConfig::test_default();
                        let mut stream = df.execute_stream().await.unwrap();
        });
                    async move {
            sql_data: "SELECT \"SearchPhrase\" FROM t WHERE \"SearchPhrase\" != '' ORDER BY \"EventTime\" LIMIT 10",
    let url = ListingTableUrl::parse(&file).unwrap();
    use opensearch_datafusion::indexed_table::eval::{RowGroupBitsetSource, TreeBitsetSource};
                                    ),
        rgs.push(RowGroupInfo {
                            query_config: Arc::new({
                        Box::from_raw(
criterion_group!(benches, bench_clickbench);
                        }));
        ArrowReaderMetadata::load(&fh, ArrowReaderOptions::new().with_page_index(true)).unwrap();
        path
                            store_url,
                            Arc::new(move |seg, _chunk, _sm| {
                            datafusion::physical_expr::expressions::Literal::new(
        {
        });
                            })
use opensearch_datafusion::api::DataFusionRuntime;
                        let store: Arc<dyn object_store::ObjectStore> = Arc::new(LocalFileSystem::new());
//!   ROW_ID_BENCH_FILE=/path/to/hits_1.parquet cargo bench --bench row_id_bench
    let meta =
        sub.encode(&mut buf).unwrap();
                                        opensearch_datafusion::indexed_table::page_pruner::PagePruneMetrics::from_stream_metrics(_sm),
    // Load parquet metadata once
        let cfg = ListingTableConfig::new(url)
/// Augment a parquet schema with a virtual `___row_id` column at the end.
                let segment = segment.clone();
    let mgr = RuntimeManager::new(4);
    let path = object_store::path::Path::from(file);
                                lit_expr,
                        metas,
    let object_path = object_store::path::Path::from(path.to_string_lossy().as_ref());
    group.sample_size(10);
                        let factory: opensearch_datafusion::indexed_table::table_provider::EvaluatorFactory = {
    group.finish();
        BitmapTreeEvaluator, CollectorLeafBitmaps,
        }
                });
}
                    let mut stream = unsafe {
        writer_generation: 0,
                        let store_url = datafusion::execution::object_store::ObjectStoreUrl::local_filesystem();
            index: i,
//! Usage:
                                        ffm_collector_calls: _sm.ffm_collector_calls.clone(),
                                search_phrase_idx,
        let schema = opts.infer_schema(&ctx.state(), &url).await.unwrap();
            let df_rt = &df_runtime;
                    let segment = segment.clone();
            .with_file_extension(".parquet")
             Example:\n  \
            let schema = parquet_schema.clone();
        // === Mode 1: data_fetch (full query via ListingTable) ===
            });
                                ScalarValue::Binary(Some(vec![])),
                let schema = schema.clone();
                    )
                            evaluator_factory: factory,
                        plan,
                        let factory: opensearch_datafusion::indexed_table::table_provider::EvaluatorFactory = {
        },
                            })
                            segments: vec![segment],
                                    page_pruner: pruner,
                                    max_collector_parallelism: 1,
use object_store::local::LocalFileSystem;
                                "SearchPhrase",
            sql_data: "SELECT \"SearchPhrase\" FROM t WHERE \"SearchPhrase\" != '' ORDER BY \"EventTime\", \"SearchPhrase\" LIMIT 10",
use datafusion::execution::runtime_env::RuntimeEnvBuilder;
                        rows
                        let lit_expr: Arc<dyn datafusion::physical_expr::PhysicalExpr> = Arc::new(
        "Benchmark file not found: {}",
    let parquet_schema = meta.schema().clone();
    assert!(
use datafusion::arrow::datatypes::{DataType, Field, Schema};
                        );
        row_groups: rgs,
    let size = std::fs::metadata(path).unwrap().len();
use std::sync::Arc;
            sql_rowid: "SELECT \"___row_id\", \"EventTime\", \"SearchPhrase\" FROM t WHERE \"SearchPhrase\" != ''",
                                        ffm_collector_calls: _sm.ffm_collector_calls.clone(),
                                    pruning_predicates: Arc::new(std::collections::HashMap::new()),
    for i in 0..parquet_meta.num_row_groups() {
//!
            sql_rowid: "SELECT \"___row_id\", \"SearchPhrase\" FROM t WHERE \"SearchPhrase\" != ''",
//!   - q27: WHERE SearchPhrase != '' ORDER BY EventTime, SearchPhrase LIMIT 10
        metadata: Arc::clone(&parquet_meta),
    fields.push(Field::new("___row_id", DataType::Int64, false));
                        let pred = BoolNode::Predicate(Arc::new(
                                search_phrase_idx,
                            emit_row_ids: false,
                        ));
                        let col_expr: Arc<dyn datafusion::physical_expr::PhysicalExpr> = Arc::new(
        },
                        let col_expr: Arc<dyn datafusion::physical_expr::PhysicalExpr> = Arc::new(
                    }
    path
fn get_substrait(mgr: &RuntimeManager, file_path: &str, sql: &str) -> Vec<u8> {
            let id_no_emit = BenchmarkId::new(format!("{}/indexed_no_emit", q.name), "");
    let mut offset = 0i64;
    let file = bench_file();
                            let tree = Arc::clone(&tree);
                                    page_pruner: pruner,
        QueryDef {
        object_path,
                        };
                                lit_expr,
                        let df = ctx.sql(sql).await.unwrap();
}
                        let ctx = datafusion::prelude::SessionContext::new();
                            predicate_columns: vec![search_phrase_idx],
            group.bench_function(id_rowid, |b| {
                        )
use criterion::{criterion_group, criterion_main, BenchmarkId, Criterion};
        let plan = ctx.sql(sql).await.unwrap().logical_plan().clone();
        max_doc: total_rows,
                                    evaluator: Arc::new(BitmapTreeEvaluator),
                let exec = mgr.cpu_executor();
                    let mut rows = 0u64;
            name: "q27-sort-multi",
                                qc.target_partitions = 4;
                                    }),
                                Ok(eval)
                            query_config: Arc::new({
                            ),
    });
                                    collector_strategy: opensearch_datafusion::indexed_table::eval::CollectorCallStrategy::TightenOuterBounds,
    let runtime_env = RuntimeEnvBuilder::new()
//!   - q25: WHERE SearchPhrase != '' ORDER BY EventTime LIMIT 10
    group.measurement_time(std::time::Duration::from_secs(10));
                                    page_prune_metrics: Some(
                                let pruner = Arc::new(PagePruner::new(&schema, Arc::clone(&seg.metadata)));
                            schema: Arc::new(schema.as_ref().clone()),
                    while let Some(batch) = stream.try_next().await.unwrap() {
                        let ctx = datafusion::prelude::SessionContext::new();
}
        custom_cache_manager: None,
                                    cost_predicate: 1,
                                let resolved = tree.resolve(&[])?;
    ];
            group.bench_function(id_no_emit, |b| {
             Pass path to a ClickBench hits parquet file.\n\n\
    group.warm_up_time(std::time::Duration::from_secs(3));
use opensearch_datafusion::datafusion_query_config::DatafusionQueryConfig;
                            pushdown_predicate: None,
        }
    use opensearch_datafusion::indexed_table::table_provider::{
}
        sql_data: &'static str,
                async move {
    Arc::new(vec![meta])
    }
    use opensearch_datafusion::indexed_table::eval::bitmap_tree::{
                            ),
        runtime_env,
    let metas = get_metas(&mgr, &file);
                    }
            let id_rowid = BenchmarkId::new(format!("{}/row_id_emit", q.name), "");
    let path = std::path::Path::new(&file);
                                col_expr,
                            datafusion::physical_expr::expressions::BinaryExpr::new(
use opensearch_datafusion::runtime_manager::RuntimeManager;
                                let pruner = Arc::new(PagePruner::new(&schema, Arc::clone(&seg.metadata)));
                            Arc::new(move |seg, _chunk, _sm| {
use opensearch_datafusion::memory::DynamicLimitPool;
            let schema = schema_with_rid.clone();
            sql_data: "SELECT \"SearchPhrase\" FROM t WHERE \"SearchPhrase\" != '' ORDER BY \"SearchPhrase\" LIMIT 10",
    use datafusion::datasource::file_format::parquet::ParquetFormat;
        QueryDef {
                            emit_row_ids: true,
fn schema_with_row_id(base: &Schema) -> Arc<Schema> {
    let schema_with_rid = schema_with_row_id(&parquet_schema);
        // === Mode 3: indexed_no_emit (same filter, no row ID, returns all data) ===
                            pushdown_predicate: None,
                        let pred = BoolNode::Predicate(Arc::new(
                                datafusion::logical_expr::Operator::NotEq,
                                >,
    let search_phrase_idx = parquet_schema.index_of("SearchPhrase").unwrap();
//!
    struct QueryDef {
    };
                        ));
        .with_memory_pool(Arc::new(GreedyMemoryPool::new(2 * 1024 * 1024 * 1024)))
            let sql = q.sql_rowid;
                let metas = metas.clone();
    use datafusion::common::ScalarValue;
            .with_collect_stat(true);
    let path = std::env::var("ROW_ID_BENCH_FILE").unwrap_or_else(|_| {
                                        opensearch_datafusion::indexed_table::page_pruner::PagePruneMetrics::from_stream_metrics(_sm),
fn bench_clickbench(c: &mut Criterion) {
            let segment = segment.clone();
                            store,
                        }));
        dynamic_limit_handle: handle,
                                    cost_predicate: 1,
            let segment = segment.clone();
                            predicate_columns: vec![search_phrase_idx],
                        0,
        panic!(
        QueryDef {
    use prost::Message;
                    config.target_partitions = 4;
    let fh = std::fs::File::open(path).unwrap();
            .with_listing_options(opts)
    let (_, handle) = DynamicLimitPool::new(2 * 1024 * 1024 * 1024);
                                let eval: Arc<dyn RowGroupBitsetSource> = Arc::new(TreeBitsetSource {
        offset += n;
    std::mem::forget(mgr);
            });
                let url = url.clone();
        let opts = ListingOptions::new(Arc::new(ParquetFormat::new()))
                                    pruning_predicates: Arc::new(std::collections::HashMap::new()),
                            }),
    let mut rgs = Vec::new();
                        let lit_expr: Arc<dyn datafusion::physical_expr::PhysicalExpr> = Arc::new(
                                    tree: Arc::new(resolved),
                            let tree = Arc::clone(&tree);
                        let mut stream = df.execute_stream().await.unwrap();
        );
                    .await
                        rows += batch.num_rows() as u64;
        let mut buf = Vec::new();
                                datafusion::logical_expr::Operator::NotEq,
                let plan = plan.clone();
            num_rows: n,
                        let provider = Arc::new(IndexedTableProvider::new(IndexedTableConfig {
                        );
        .build()
//!   - indexed_no_emit: indexed path without row ID emission (just filter + return data)
use opensearch_datafusion::query_executor;
                    let schema = schema.clone();
                                });
                        );
                    };
                            ptr
                }
                                    max_collector_parallelism: 1,
    let mut fields: Vec<Field> = base.fields().iter().map(|f| f.as_ref().clone()).collect();
                        let store: Arc<dyn object_store::ObjectStore> = Arc::new(LocalFileSystem::new());
                    rows
                            }),
                                qc
                        let tree = Arc::new(BoolNode::And(vec![pred]).push_not_down());
                        let tree = Arc::new(BoolNode::And(vec![pred]).push_not_down());
                    let ptr = query_executor::execute_query(
criterion_main!(benches);
                        ctx.register_table("t", provider).unwrap();
    let store = Arc::new(LocalFileSystem::new());
                            ),
    (mgr, df_runtime)
        global_base: 0,
        let url = ListingTableUrl::parse(file_path).unwrap();
        let plan_data = get_substrait(&mgr, &file, q.sql_data);
                                qc
                            evaluator_factory: factory,
    mgr.io_runtime.block_on(async {
                    let mut config = DatafusionQueryConfig::test_default();
                                let eval: Arc<dyn RowGroupBitsetSource> = Arc::new(TreeBitsetSource {
use datafusion::execution::memory_pool::GreedyMemoryPool;
                });
                        };
                        None,
                            ),
//!
                let segment = segment.clone();
    use datafusion::parquet::arrow::arrow_reader::{ArrowReaderMetadata, ArrowReaderOptions};
                                qc.target_partitions = 4;
                            store_url,
                            ),
                        while let Some(batch) = stream.try_next().await.unwrap() {
    }
fn setup() -> (RuntimeManager, DataFusionRuntime) {
                        "t".into(),
                        ctx.register_table("t", provider).unwrap();
    let meta = mgr.io_runtime.block_on(store.head(&path)).unwrap();
                            rows += batch.num_rows() as u64;
//!   - q26: WHERE SearchPhrase != '' ORDER BY SearchPhrase LIMIT 10
                                    page_prune_metrics: Some(
                                });
            "ROW_ID_BENCH_FILE not set.\n\
            });
        let n = parquet_meta.row_group(i).num_rows();
                    let segment = segment.clone();
//! Each query is run in three modes:
                        Arc::new(LocalFileSystem::new()) as Arc<dyn ObjectStore>,
}
    let df_runtime = DataFusionRuntime {
                                    ),
             ROW_ID_BENCH_FILE=/path/to/hits_1.parquet cargo bench --bench row_id_bench"
                                    leaves: Arc::new(CollectorLeafBitmaps {
                                let mut qc = DatafusionQueryConfig::test_default();
    use datafusion::datasource::listing::{ListingOptions, ListingTable, ListingTableConfig};
                            datafusion::physical_expr::expressions::Column::new(
                        let mut rows = 0u64;
                            store,
    };
            .with_schema(schema);
                            datafusion::physical_expr::expressions::Literal::new(
        let ctx = datafusion::prelude::SessionContext::new();
//!   - row_id_emit: indexed path with emit_row_ids=true, projects ___row_id + sort keys
            name: "q25-sort-eventtime",
        ctx.register_table("t", Arc::new(ListingTable::try_new(cfg).unwrap()))
        sql_rowid: &'static str,
        name: &'static str,
    };
                        let provider = Arc::new(IndexedTableProvider::new(IndexedTableConfig {
    use opensearch_datafusion::indexed_table::stream::RowGroupInfo;
    use opensearch_datafusion::indexed_table::bool_tree::BoolNode;
                                "SearchPhrase",
                    }
            first_row: offset,
                        let store_url = datafusion::execution::object_store::ObjectStoreUrl::local_filesystem();
                            let schema = schema.clone();
                        let mut rows = 0u64;
                        while let Some(batch) = stream.try_next().await.unwrap() {
                let schema = schema.clone();
    use datafusion_substrait::logical_plan::producer::to_substrait_plan;
    let mut group = c.benchmark_group("clickbench_qtf");
                                col_expr,
                    .unwrap();
    let segment = SegmentFileInfo {
                        );
    use opensearch_datafusion::indexed_table::page_pruner::PagePruner;
        std::path::Path::new(&path).exists(),
    // Schema with ___row_id appended (virtual column)
                                    tree: Arc::new(resolved),
                                    leaves: Arc::new(CollectorLeafBitmaps {
                        rows
                                    collector_strategy: opensearch_datafusion::indexed_table::eval::CollectorCallStrategy::TightenOuterBounds,
                b.to_async(mgr.io_runtime.as_ref()).iter(|| {
                        }
    );
                            ),
        {
    }
        IndexedTableConfig, IndexedTableProvider, SegmentFileInfo,
                        &config,
    })
                            schema,
    let total_rows = offset;
                                    opensearch_datafusion::cross_rt_stream::CrossRtStream,
//! Queries (from ClickBench q25–q27):
                            rows += batch.num_rows() as u64;
}
//!   - data_fetch: full query via ListingTable (filter + sort + limit + all data)
use object_store::{ObjectStore, ObjectStoreExt};
                        let df = ctx.sql("SELECT * FROM t").await.unwrap();
        parquet_size: size,
                        exec,
                            datafusion::physical_expr::expressions::Column::new(
                            datafusion::physical_expr::expressions::BinaryExpr::new(
    let (mgr, df_runtime) = setup();
            sql_rowid: "SELECT \"___row_id\", \"EventTime\", \"SearchPhrase\" FROM t WHERE \"SearchPhrase\" != ''",
                                ScalarValue::Binary(Some(vec![])),
        buf
    };
            name: "q26-sort-searchphrase",
                                    evaluator: Arc::new(BitmapTreeEvaluator),
use futures::TryStreamExt;
        .unwrap();
