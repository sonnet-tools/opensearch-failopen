             Pass path to a ClickBench hits parquet file.\n\n\
                                    ),
                        let df = ctx.sql(sql).await.unwrap();
                    }
//! Queries (from ClickBench q25–q27):
    })
//!   - q25: WHERE SearchPhrase != '' ORDER BY EventTime LIMIT 10
    group.finish();
                            evaluator_factory: factory,
                    async move {
        let ctx = datafusion::prelude::SessionContext::new();
        name: &'static str,
                            })
    for q in &queries {
                                let resolved = tree.resolve(&[])?;
    use opensearch_datafusion::indexed_table::table_provider::{
                        let mut stream = df.execute_stream().await.unwrap();
                            })
}
    let parquet_meta = meta.metadata().clone();
        .unwrap();
                        let ctx = datafusion::prelude::SessionContext::new();
    group.measurement_time(std::time::Duration::from_secs(10));
        // === Mode 2: row_id_emit (indexed path, projects ___row_id + sort keys) ===
    let store = Arc::new(LocalFileSystem::new());
            name: "q27-sort-multi",
            let id_no_emit = BenchmarkId::new(format!("{}/indexed_no_emit", q.name), "");
                                let pruner = Arc::new(PagePruner::new(&schema, Arc::clone(&seg.metadata)));
                let url = url.clone();
                        let provider = Arc::new(IndexedTableProvider::new(IndexedTableConfig {
    let fh = std::fs::File::open(path).unwrap();
    std::mem::forget(mgr);
use datafusion::arrow::datatypes::{DataType, Field, Schema};
                        let df = ctx.sql("SELECT * FROM t").await.unwrap();
                                lit_expr,
                    let schema = schema.clone();
                            datafusion::physical_expr::expressions::Column::new(
                            ),
                        ctx.register_table("t", provider).unwrap();
            num_rows: n,
            let segment = segment.clone();
        IndexedTableConfig, IndexedTableProvider, SegmentFileInfo,
                });
    use opensearch_datafusion::indexed_table::eval::{RowGroupBitsetSource, TreeBitsetSource};
    let url = ListingTableUrl::parse(&file).unwrap();
                                search_phrase_idx,
    let path = object_store::path::Path::from(file);
                                    page_pruner: pruner,
//!
    use prost::Message;
        custom_cache_manager: None,
        let schema = opts.infer_schema(&ctx.state(), &url).await.unwrap();
                            emit_row_ids: false,
                        let store: Arc<dyn object_store::ObjectStore> = Arc::new(LocalFileSystem::new());
                            store,
        panic!(
        writer_generation: 0,
                        0,
                    let mut config = DatafusionQueryConfig::test_default();
        sql_rowid: &'static str,
                        }));
                            ),
    let schema_with_rid = schema_with_row_id(&parquet_schema);
    let mgr = RuntimeManager::new(4);
        {
                        let ctx = datafusion::prelude::SessionContext::new();
            .unwrap();
                                let eval: Arc<dyn RowGroupBitsetSource> = Arc::new(TreeBitsetSource {
                    }
                        );
                                    max_collector_parallelism: 1,
                        );
//!   - q26: WHERE SearchPhrase != '' ORDER BY SearchPhrase LIMIT 10
fn get_substrait(mgr: &RuntimeManager, file_path: &str, sql: &str) -> Vec<u8> {
                                    tree: Arc::new(resolved),
                                        opensearch_datafusion::indexed_table::page_pruner::PagePruneMetrics::from_stream_metrics(_sm),
//!   - data_fetch: full query via ListingTable (filter + sort + limit + all data)
                        Box::from_raw(
        sql_data: &'static str,
            name: "q26-sort-searchphrase",
                                let resolved = tree.resolve(&[])?;
                let schema = schema.clone();
                                    cost_predicate: 1,
                    async move {
                                        ffm_collector_calls: _sm.ffm_collector_calls.clone(),
                        );
//!   - q27: WHERE SearchPhrase != '' ORDER BY EventTime, SearchPhrase LIMIT 10
                                qc.target_partitions = 4;
            sql_data: "SELECT \"SearchPhrase\" FROM t WHERE \"SearchPhrase\" != '' ORDER BY \"EventTime\" LIMIT 10",
                                    page_prune_metrics: Some(
                                Ok(eval)
                            let tree = Arc::clone(&tree);
                            datafusion::physical_expr::expressions::Literal::new(
use opensearch_datafusion::api::DataFusionRuntime;
}
                            datafusion::physical_expr::expressions::Literal::new(
                            }),
    let mut offset = 0i64;
    group.warm_up_time(std::time::Duration::from_secs(3));
                                    evaluator: Arc::new(BitmapTreeEvaluator),
                                let mut qc = DatafusionQueryConfig::test_default();
use datafusion::datasource::listing::ListingTableUrl;
    use opensearch_datafusion::indexed_table::eval::bitmap_tree::{
        let url = ListingTableUrl::parse(file_path).unwrap();
        let sub = to_substrait_plan(&plan, &ctx.state()).unwrap();
//!   - indexed_no_emit: indexed path without row ID emission (just filter + return data)
                    )
        // === Mode 3: indexed_no_emit (same filter, no row ID, returns all data) ===
    let runtime_env = RuntimeEnvBuilder::new()
    let path = std::env::var("ROW_ID_BENCH_FILE").unwrap_or_else(|_| {
                        let store_url = datafusion::execution::object_store::ObjectStoreUrl::local_filesystem();
            sql_data: "SELECT \"SearchPhrase\" FROM t WHERE \"SearchPhrase\" != '' ORDER BY \"EventTime\", \"SearchPhrase\" LIMIT 10",
        group.bench_with_input(id_data, &plan_data, |b, plan| {
                    let segment = segment.clone();
                            let schema = schema.clone();
fn bench_clickbench(c: &mut Criterion) {
                                let eval: Arc<dyn RowGroupBitsetSource> = Arc::new(TreeBitsetSource {
        });
                                >,
            let segment = segment.clone();
        let mut buf = Vec::new();
                        let tree = Arc::new(BoolNode::And(vec![pred]).push_not_down());
                            segments: vec![segment],
                            predicate_columns: vec![search_phrase_idx],
                                as *mut datafusion::physical_plan::stream::RecordBatchStreamAdapter<
//!   ROW_ID_BENCH_FILE=/path/to/hits_1.parquet cargo bench --bench row_id_bench
use object_store::{ObjectStore, ObjectStoreExt};
    let (_, handle) = DynamicLimitPool::new(2 * 1024 * 1024 * 1024);
                    let schema = schema.clone();
    for i in 0..parquet_meta.num_row_groups() {
                        metas,
                    }
        parquet_size: size,
                        )
    let parquet_schema = meta.schema().clone();
            });
                            ),
        }
/// Augment a parquet schema with a virtual `___row_id` column at the end.
            let df_rt = &df_runtime;
                                col_expr,
                                qc
        QueryDef {
                            pushdown_predicate: None,
    mgr.io_runtime.block_on(async {
                        let store: Arc<dyn object_store::ObjectStore> = Arc::new(LocalFileSystem::new());
                    config.target_partitions = 4;
//! Benchmark: ClickBench queries — QTF row_id+sort_keys vs full data fetch.
    use opensearch_datafusion::indexed_table::bool_tree::BoolNode;
                        let col_expr: Arc<dyn datafusion::physical_expr::PhysicalExpr> = Arc::new(
                                    collector_strategy: opensearch_datafusion::indexed_table::eval::CollectorCallStrategy::TightenOuterBounds,
                        "t".into(),
                        let mut rows = 0u64;
            name: "q25-sort-eventtime",
                                datafusion::logical_expr::Operator::NotEq,
                                    leaves: Arc::new(CollectorLeafBitmaps {
                            datafusion::physical_expr::expressions::BinaryExpr::new(
        );
                                    pruning_predicates: Arc::new(std::collections::HashMap::new()),
    };
    Arc::new(vec![meta])
                                    max_collector_parallelism: 1,
                            ptr
        QueryDef {
                        };
                        let pred = BoolNode::Predicate(Arc::new(
                                    cost_predicate: 1,
            let id_rowid = BenchmarkId::new(format!("{}/row_id_emit", q.name), "");
                        plan,
                            datafusion::physical_expr::expressions::BinaryExpr::new(
//!
                                qc.target_partitions = 4;
    // Schema with ___row_id appended (virtual column)
fn get_metas(mgr: &RuntimeManager, file: &str) -> Arc<Vec<object_store::ObjectMeta>> {
                            rows += batch.num_rows() as u64;
                            Arc::new(move |seg, _chunk, _sm| {
                                    leaves: Arc::new(CollectorLeafBitmaps {
    use datafusion::datasource::listing::{ListingOptions, ListingTable, ListingTableConfig};
                                "SearchPhrase",
        {
    path
                }
                                    cost_collector: 10,
                    while let Some(batch) = stream.try_next().await.unwrap() {
                        }
                        let factory: opensearch_datafusion::indexed_table::table_provider::EvaluatorFactory = {
                    .await
            .with_listing_options(opts)
                let segment = segment.clone();
                            pushdown_predicate: None,
        row_groups: rgs,
        "Benchmark file not found: {}",
                async move {
        let n = parquet_meta.row_group(i).num_rows();
        let opts = ListingOptions::new(Arc::new(ParquetFormat::new()))
use opensearch_datafusion::query_executor;
    let segment = SegmentFileInfo {
            .with_file_extension(".parquet")
    let file = bench_file();
                        let col_expr: Arc<dyn datafusion::physical_expr::PhysicalExpr> = Arc::new(
}
fn bench_file() -> String {
    };
                    let mut rows = 0u64;
    use datafusion::common::ScalarValue;
    use datafusion::parquet::arrow::arrow_reader::{ArrowReaderMetadata, ArrowReaderOptions};
            sql_rowid: "SELECT \"___row_id\", \"EventTime\", \"SearchPhrase\" FROM t WHERE \"SearchPhrase\" != ''",
        rgs.push(RowGroupInfo {
    group.sample_size(10);
            .with_schema(schema);
            group.bench_function(id_rowid, |b| {
                                    pruning_predicates: Arc::new(std::collections::HashMap::new()),
            let schema = parquet_schema.clone();
                    let segment = segment.clone();
                                search_phrase_idx,
use opensearch_datafusion::runtime_manager::RuntimeManager;
    }
use datafusion::execution::runtime_env::RuntimeEnvBuilder;
                                lit_expr,
    let meta =
            sql_data: "SELECT \"SearchPhrase\" FROM t WHERE \"SearchPhrase\" != '' ORDER BY \"SearchPhrase\" LIMIT 10",
        },
use criterion::{criterion_group, criterion_main, BenchmarkId, Criterion};
    use opensearch_datafusion::indexed_table::stream::RowGroupInfo;
    let object_path = object_store::path::Path::from(path.to_string_lossy().as_ref());
                                    cost_collector: 10,
    let search_phrase_idx = parquet_schema.index_of("SearchPhrase").unwrap();
    fields.push(Field::new("___row_id", DataType::Int64, false));
                            emit_row_ids: true,
    let (mgr, df_runtime) = setup();
                                    opensearch_datafusion::cross_rt_stream::CrossRtStream,
criterion_group!(benches, bench_clickbench);
                        while let Some(batch) = stream.try_next().await.unwrap() {
        offset += n;
}
                        df_rt,
use std::sync::Arc;
                        exec,
                        while let Some(batch) = stream.try_next().await.unwrap() {
                        Arc::new(LocalFileSystem::new()) as Arc<dyn ObjectStore>,
                            schema,
    use datafusion::datasource::file_format::parquet::ParquetFormat;
            first_row: offset,
                    .unwrap();
    let path = std::path::Path::new(&file);
//!   - row_id_emit: indexed path with emit_row_ids=true, projects ___row_id + sort keys
                            rows += batch.num_rows() as u64;
                            ),
    Arc::new(Schema::new(fields))
        let plan = ctx.sql(sql).await.unwrap().logical_plan().clone();
    let meta = mgr.io_runtime.block_on(store.head(&path)).unwrap();
                        );
        buf
                            schema: Arc::new(schema.as_ref().clone()),
    }
                                datafusion::logical_expr::Operator::NotEq,
}
    // Load parquet metadata once
                                });
                    let ptr = query_executor::execute_query(
            });
                let exec = mgr.cpu_executor();
                            query_config: Arc::new({
fn setup() -> (RuntimeManager, DataFusionRuntime) {
            sql_rowid: "SELECT \"___row_id\", \"EventTime\", \"SearchPhrase\" FROM t WHERE \"SearchPhrase\" != ''",
    };
                        rows
        dynamic_limit_handle: handle,
fn schema_with_row_id(base: &Schema) -> Arc<Schema> {
    };
        metadata: Arc::clone(&parquet_meta),
                                ScalarValue::Binary(Some(vec![])),
        let cfg = ListingTableConfig::new(url)
        .with_memory_pool(Arc::new(GreedyMemoryPool::new(2 * 1024 * 1024 * 1024)))
        path
                    };
                                let pruner = Arc::new(PagePruner::new(&schema, Arc::clone(&seg.metadata)));
    let total_rows = offset;
                            evaluator_factory: factory,
                        let pred = BoolNode::Predicate(Arc::new(
                        let lit_expr: Arc<dyn datafusion::physical_expr::PhysicalExpr> = Arc::new(
    ];
                                col_expr,
    let mut rgs = Vec::new();
            sql_rowid: "SELECT \"___row_id\", \"SearchPhrase\" FROM t WHERE \"SearchPhrase\" != ''",
                            Arc::new(move |seg, _chunk, _sm| {
                                    tree: Arc::new(resolved),
use datafusion::execution::memory_pool::GreedyMemoryPool;
             Example:\n  \
        ArrowReaderMetadata::load(&fh, ArrowReaderOptions::new().with_page_index(true)).unwrap();
                                        ffm_collector_calls: _sm.ffm_collector_calls.clone(),
                        url,
                            store_url,
                        rows += batch.num_rows() as u64;
                        }));
                    rows
//!
                                    collector_strategy: opensearch_datafusion::indexed_table::eval::CollectorCallStrategy::TightenOuterBounds,
        std::path::Path::new(&path).exists(),
    });
                                    page_prune_metrics: Some(
}
                let segment = segment.clone();
    let size = std::fs::metadata(path).unwrap().len();
    use datafusion_substrait::logical_plan::producer::to_substrait_plan;
                        let tree = Arc::new(BoolNode::And(vec![pred]).push_not_down());
    let df_runtime = DataFusionRuntime {
        });
    assert!(
        global_base: 0,
             ROW_ID_BENCH_FILE=/path/to/hits_1.parquet cargo bench --bench row_id_bench"
criterion_main!(benches);
            "ROW_ID_BENCH_FILE not set.\n\
    let mut group = c.benchmark_group("clickbench_qtf");
                        None,
        runtime_env,
        .build()
                            predicate_columns: vec![search_phrase_idx],
                            ),
//! Each query is run in three modes:
                            let tree = Arc::clone(&tree);
                            query_config: Arc::new({
                                Ok(eval)
            group.bench_function(id_no_emit, |b| {
        ctx.register_table("t", Arc::new(ListingTable::try_new(cfg).unwrap()))
                        ));
                                let mut qc = DatafusionQueryConfig::test_default();
                            }),
        }
        max_doc: total_rows,
                            datafusion::physical_expr::expressions::Column::new(
                            let schema = schema.clone();
                                    }),
        },
    use opensearch_datafusion::indexed_table::page_pruner::PagePruner;
            b.to_async(mgr.io_runtime.as_ref()).iter(|| {
        object_path,
    }
                            store_url,
                let schema = schema.clone();
                b.to_async(mgr.io_runtime.as_ref()).iter(|| {
use opensearch_datafusion::memory::DynamicLimitPool;
    );
                    let mut stream = unsafe {
                            ),
use object_store::local::LocalFileSystem;
                        ));
    let metas = get_metas(&mgr, &file);
                                    ),
                });
                                        opensearch_datafusion::indexed_table::page_pruner::PagePruneMetrics::from_stream_metrics(_sm),
                        let lit_expr: Arc<dyn datafusion::physical_expr::PhysicalExpr> = Arc::new(
    let queries = vec![
use futures::TryStreamExt;
                        }
                            segments: vec![segment],
        let plan_data = get_substrait(&mgr, &file, q.sql_data);
        QueryDef {
            let schema = schema_with_rid.clone();
                            store,
use opensearch_datafusion::datafusion_query_config::DatafusionQueryConfig;
                        ctx.register_table("t", provider).unwrap();
                        rows
                        let mut rows = 0u64;
                        };
                                "SearchPhrase",
        // === Mode 1: data_fetch (full query via ListingTable) ===
                b.to_async(mgr.io_runtime.as_ref()).iter(|| {
    mgr.cpu_executor.shutdown();
        },
            index: i,
            });
    struct QueryDef {
            let sql = q.sql_rowid;
                        &config,
                        let mut stream = df.execute_stream().await.unwrap();
                        let store_url = datafusion::execution::object_store::ObjectStoreUrl::local_filesystem();
                                    page_pruner: pruner,
                                ScalarValue::Binary(Some(vec![])),
    (mgr, df_runtime)
                        let factory: opensearch_datafusion::indexed_table::table_provider::EvaluatorFactory = {
    let mut fields: Vec<Field> = base.fields().iter().map(|f| f.as_ref().clone()).collect();
                        let provider = Arc::new(IndexedTableProvider::new(IndexedTableConfig {
        sub.encode(&mut buf).unwrap();
        BitmapTreeEvaluator, CollectorLeafBitmaps,
                                    evaluator: Arc::new(BitmapTreeEvaluator),
//! Usage:
                                    }),
                                });
                let metas = metas.clone();
        let id_data = BenchmarkId::new(format!("{}/data_fetch", q.name), "");
                let plan = plan.clone();
                                qc
            .with_collect_stat(true);
