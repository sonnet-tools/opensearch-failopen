                        let mut stream = unsafe {
use std::sync::Arc;
                        ptr as *mut datafusion::physical_plan::stream::RecordBatchStreamAdapter<
        let url = ListingTableUrl::parse(dir).unwrap();
        let mut buf = Vec::new();
use object_store::{ObjectStore, ObjectStoreExt};
        create_test_parquet(tmp.path(), rows);
fn get_metas(mgr: &RuntimeManager, dir: &str) -> Arc<Vec<object_store::ObjectMeta>> {
                            0,
                let ptr = query_executor::execute_query(
    std::mem::forget(mgr);
                    metas,
    create_test_parquet(tmp.path(), 100_000);
    let dir = tmp.path().to_str().unwrap();
    mgr.io_runtime.block_on(async {
    std::mem::forget(mgr);
                        count
        buf
    writer.close().unwrap();
        Field::new("value", DataType::Int64, false),
                    &df_runtime,
                    &df_runtime,
                });
    });
            .with_schema(schema);
    let tmp = tempfile::tempdir().unwrap();
    mgr.cpu_executor.shutdown();
                batches
        schema.clone(),
            .with_collect_stat(true);
                    async {
        b.to_async(mgr.io_runtime.as_ref()).iter(|| {
            async {
    let batch = RecordBatch::try_new(
                    None,
                        let mut count = 0u64;
            let metas = metas.clone();
    let path = object_store::path::Path::from(format!("{}/bench.parquet", dir));
    )
    .unwrap();
use datafusion::execution::disk_manager::DiskManagerBuilder;
                        >,
        );
                    )
            .with_listing_options(opts)
                            url,
        b.to_async(mgr.io_runtime.as_ref()).iter(|| {
                let mut batches = 0u64;
            }
    let (mgr, df_runtime, tmp) = setup();
    let metas = get_metas(&mgr, dir);
                    &opensearch_datafusion::datafusion_query_config::DatafusionQueryConfig::test_default(
                            opensearch_datafusion::cross_rt_stream::CrossRtStream,
fn bench_stream_next(c: &mut Criterion) {
    let path = dir.join("bench.parquet");
        let schema = opts.infer_schema(&ctx.state(), &url).await.unwrap();
        c.bench_with_input(
    let dir = tmp.path().to_str().unwrap();
    writer.write(&batch).unwrap();
        });
    (mgr, df_runtime, tmp)
                    0,
                    url,
    use arrow_array::{Int64Array, RecordBatch};
    let runtime_env = RuntimeEnvBuilder::new()
use criterion::{criterion_group, criterion_main, BenchmarkId, Criterion};
                                opensearch_datafusion::cross_rt_stream::CrossRtStream,
                        }
            &rows,
                        ptr as *mut datafusion::physical_plan::stream::RecordBatchStreamAdapter<
);
}
fn get_substrait(mgr: &RuntimeManager, df: &DataFusionRuntime, dir: &str, sql: &str) -> Vec<u8> {
            let url = url.clone();
                    )
    create_test_parquet(tmp.path(), 100_000);
        let url = ListingTableUrl::parse(dir).unwrap();
    let plan = get_substrait(&mgr, &df_runtime, dir, "SELECT id, value FROM t");
                        };
    });
                            exec,
                .await
            let url = url.clone();
    use prost::Message;
use opensearch_datafusion::api::DataFusionRuntime;
                    let url = url.clone();
    use arrow::datatypes::{DataType, Field, Schema};
            Arc::new(Int64Array::from(vals)),
                    }
                let ptr = query_executor::execute_query(
        let dir = tmp.path().to_str().unwrap();
    let meta = mgr.io_runtime.block_on(store.head(&path)).unwrap();
}
            .unwrap();
        ctx.register_table("t", Arc::new(ListingTable::try_new(cfg).unwrap()))
                    exec,
    let (mgr, df_runtime, tmp) = setup();
    let metas = get_metas(&mgr, dir);
        Field::new("id", DataType::Int64, false),
                    ),
                            None,
                };
fn bench_execute_query(c: &mut Criterion) {
                    Box::from_raw(
                b.to_async(mgr.io_runtime.as_ref()).iter(|| {
}
                            metas,
                            >)
fn setup() -> (RuntimeManager, DataFusionRuntime, tempfile::TempDir) {
                    "t".into(),
                    metas,
                    None,
    }
        .with_memory_pool(Arc::new(GreedyMemoryPool::new(256 * 1024 * 1024)))
}
                    plan,
                    Arc::new(LocalFileSystem::new()) as Arc<dyn ObjectStore>,
    use datafusion::datasource::file_format::parquet::ParquetFormat;
        let sub = to_substrait_plan(&plan, &ctx.state()).unwrap();
    let url = ListingTableUrl::parse(dir).unwrap();
                    let plan = plan.clone();
                        while let Some(batch) = stream.try_next().await.unwrap() {
                    let metas = metas.clone();
                    0,
                .unwrap();
            async {
                    ),
use datafusion::datasource::listing::ListingTableUrl;
            BenchmarkId::new("execute_query", rows),
use datafusion::execution::memory_pool::GreedyMemoryPool;
                while let Some(_) = stream.try_next().await.unwrap() {
                    "t".into(),
}
                while let Some(_) = stream.try_next().await.unwrap() {}
                .unwrap();
                            Arc::new(LocalFileSystem::new()) as Arc<dyn ObjectStore>,
        let plan = ctx.sql(sql).await.unwrap().logical_plan().clone();
    let file = File::create(&path).unwrap();
            let plan = plan.clone();
        sub.encode(&mut buf).unwrap();
            },
    std::mem::forget(mgr);
    mgr.cpu_executor.shutdown();
    ]));
        let cfg = ListingTableConfig::new(url)
    benches,
            let exec = mgr.cpu_executor();
fn create_test_parquet(dir: &std::path::Path, rows: usize) {
        let metas = get_metas(&mgr, dir);
            |b, _| {
                    let exec = mgr.cpu_executor();
                        // Consume and free the stream
            .with_file_extension(".parquet")
                };
    bench_aggregation
                    batches += 1;
            }
use datafusion::execution::runtime_env::RuntimeEnvBuilder;
                            &df_runtime,
            Arc::new(Int64Array::from(ids)),
                            "t".into(),
        .unwrap();
}
                            &opensearch_datafusion::datafusion_query_config::DatafusionQueryConfig::test_default(),
        });
    c.bench_function("aggregation_100k", |b| {
                }
    let store = Arc::new(LocalFileSystem::new());
fn bench_aggregation(c: &mut Criterion) {
                    url,
    let plan = get_substrait(&mgr, &df_runtime, dir, "SELECT SUM(value), COUNT(*) FROM t");
use opensearch_datafusion::query_executor;
            let exec = mgr.cpu_executor();
    let df_runtime = DataFusionRuntime::new_for_bench(runtime_env);
                            Box::from_raw(ptr as *mut datafusion::physical_plan::stream::RecordBatchStreamAdapter<
                            plan,
use futures::TryStreamExt;
                    Arc::new(LocalFileSystem::new()) as Arc<dyn ObjectStore>,
                    &opensearch_datafusion::datafusion_query_config::DatafusionQueryConfig::test_default(
                .await
use object_store::local::LocalFileSystem;
    use datafusion_substrait::logical_plan::producer::to_substrait_plan;
    use std::fs::File;
    bench_stream_next,
        .with_disk_manager_builder(DiskManagerBuilder::default())
    let mut writer = ArrowWriter::try_new(file, schema, None).unwrap();
                let mut stream = unsafe {
                        ).await.unwrap();
    let (mgr, df_runtime, tmp) = setup();
                )
                    exec,
    use parquet::arrow::ArrowWriter;
                            opensearch_datafusion::cross_rt_stream::CrossRtStream,
                    plan,
    bench_execute_query,
        let ctx = datafusion::prelude::SessionContext::new();
    let schema = Arc::new(Schema::new(vec![
            let metas = metas.clone();
        .build()
                )
        vec![
        let opts = ListingOptions::new(Arc::new(ParquetFormat::new()))
    let vals: Vec<i64> = ids.iter().map(|i| i * 10).collect();
                            count += batch.num_rows() as u64;
            let plan = plan.clone();
}
criterion_group!(
    Arc::new(vec![meta])
        ],
        let plan = get_substrait(&mgr, &df_runtime, dir, "SELECT id, value FROM t");
    use datafusion::datasource::listing::{ListingOptions, ListingTable, ListingTableConfig};
    for rows in [100, 10_000, 100_000] {
                let mut stream = unsafe {
    mgr.cpu_executor.shutdown();
                    Box::from_raw(
use opensearch_datafusion::runtime_manager::RuntimeManager;
    let mgr = RuntimeManager::new(4, 1.5, 1.5);
    let url = ListingTableUrl::parse(dir).unwrap();
criterion_main!(benches);
                        let ptr = query_executor::execute_query(
    let ids: Vec<i64> = (0..rows as i64).collect();
                        >,
    })
    c.bench_function("stream_next_100k", |b| {
