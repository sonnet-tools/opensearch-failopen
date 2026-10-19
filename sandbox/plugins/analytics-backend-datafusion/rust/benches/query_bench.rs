        });
                    Box::from_raw(
    use datafusion::datasource::listing::{ListingOptions, ListingTable, ListingTableConfig};
                            None,
                            url,
    let store = Arc::new(LocalFileSystem::new());
                    let exec = mgr.cpu_executor();
            let url = url.clone();
                    Box::from_raw(
        Field::new("id", DataType::Int64, false),
                            "t".into(),
    use parquet::arrow::ArrowWriter;
            .with_collect_stat(true);
    let metas = get_metas(&mgr, dir);
                let mut batches = 0u64;
                    plan,
    let url = ListingTableUrl::parse(dir).unwrap();
            .with_schema(schema);
                    &opensearch_datafusion::datafusion_query_config::DatafusionQueryConfig::test_default(
            .unwrap();
                    0,
    let (mgr, df_runtime, tmp) = setup();
    writer.close().unwrap();
                }
use datafusion::execution::disk_manager::DiskManagerBuilder;
        let cfg = ListingTableConfig::new(url)
        let url = ListingTableUrl::parse(dir).unwrap();
    benches,
                            opensearch_datafusion::cross_rt_stream::CrossRtStream,
                    "t".into(),
fn bench_execute_query(c: &mut Criterion) {
                            >)
            let plan = plan.clone();
        let sub = to_substrait_plan(&plan, &ctx.state()).unwrap();
            let exec = mgr.cpu_executor();
                    exec,
        vec![
        });
        let ctx = datafusion::prelude::SessionContext::new();
                    &opensearch_datafusion::datafusion_query_config::DatafusionQueryConfig::test_default(
                    let url = url.clone();
    std::mem::forget(mgr);
            .with_file_extension(".parquet")
}
                        >,
use futures::TryStreamExt;
use datafusion::execution::runtime_env::RuntimeEnvBuilder;
                while let Some(_) = stream.try_next().await.unwrap() {
fn create_test_parquet(dir: &std::path::Path, rows: usize) {
    use prost::Message;
}
                        >,
    let vals: Vec<i64> = ids.iter().map(|i| i * 10).collect();
use datafusion::execution::memory_pool::GreedyMemoryPool;
}
    use arrow_array::{Int64Array, RecordBatch};
                b.to_async(mgr.io_runtime.as_ref()).iter(|| {
    let ids: Vec<i64> = (0..rows as i64).collect();
            let plan = plan.clone();
        sub.encode(&mut buf).unwrap();
    use datafusion_substrait::logical_plan::producer::to_substrait_plan;
                let ptr = query_executor::execute_query(
                };
    let dir = tmp.path().to_str().unwrap();
                        count
                            plan,
        let metas = get_metas(&mgr, dir);
                let mut stream = unsafe {
                    batches += 1;
                    &df_runtime,
                            exec,
                )
        b.to_async(mgr.io_runtime.as_ref()).iter(|| {
    mgr.cpu_executor.shutdown();
            .with_listing_options(opts)
    let plan = get_substrait(&mgr, &df_runtime, dir, "SELECT SUM(value), COUNT(*) FROM t");
            &rows,
                    let plan = plan.clone();
                            &opensearch_datafusion::datafusion_query_config::DatafusionQueryConfig::test_default(),
            }
                            0,
            Arc::new(Int64Array::from(ids)),
                    Arc::new(LocalFileSystem::new()) as Arc<dyn ObjectStore>,
    bench_aggregation
                    let metas = metas.clone();
fn bench_stream_next(c: &mut Criterion) {
            Arc::new(Int64Array::from(vals)),
                            opensearch_datafusion::cross_rt_stream::CrossRtStream,
                        ptr as *mut datafusion::physical_plan::stream::RecordBatchStreamAdapter<
        let url = ListingTableUrl::parse(dir).unwrap();
    Arc::new(vec![meta])
    mgr.io_runtime.block_on(async {
    let (mgr, df_runtime, tmp) = setup();
    c.bench_function("stream_next_100k", |b| {
        let plan = get_substrait(&mgr, &df_runtime, dir, "SELECT id, value FROM t");
                        // Consume and free the stream
fn bench_aggregation(c: &mut Criterion) {
                let mut stream = unsafe {
                    )
            BenchmarkId::new("execute_query", rows),
                    None,
    })
    let metas = get_metas(&mgr, dir);
    let mut writer = ArrowWriter::try_new(file, schema, None).unwrap();
use datafusion::datasource::listing::ListingTableUrl;
                while let Some(_) = stream.try_next().await.unwrap() {}
                    metas,
        c.bench_with_input(
    let path = dir.join("bench.parquet");
}
    use std::fs::File;
                .await
    });
                    url,
    writer.write(&batch).unwrap();
                        ptr as *mut datafusion::physical_plan::stream::RecordBatchStreamAdapter<
    bench_execute_query,
                        };
        create_test_parquet(tmp.path(), rows);
    let url = ListingTableUrl::parse(dir).unwrap();
        let mut buf = Vec::new();
    std::mem::forget(mgr);
            let metas = metas.clone();
            |b, _| {
                    }
                                opensearch_datafusion::cross_rt_stream::CrossRtStream,
                        ).await.unwrap();
        schema.clone(),
        );
        .with_disk_manager_builder(DiskManagerBuilder::default())
use object_store::local::LocalFileSystem;
                            Arc::new(LocalFileSystem::new()) as Arc<dyn ObjectStore>,
                });
                    url,
    let meta = mgr.io_runtime.block_on(store.head(&path)).unwrap();
    (mgr, df_runtime, tmp)
}
use opensearch_datafusion::query_executor;
    let schema = Arc::new(Schema::new(vec![
    std::mem::forget(mgr);
        buf
}
    bench_stream_next,
                    None,
    let file = File::create(&path).unwrap();
                batches
    let dir = tmp.path().to_str().unwrap();
                        let mut count = 0u64;
                .unwrap();
use std::sync::Arc;
    create_test_parquet(tmp.path(), 100_000);
    let df_runtime = DataFusionRuntime::new_for_bench(runtime_env);
                .unwrap();
                let ptr = query_executor::execute_query(
                    Arc::new(LocalFileSystem::new()) as Arc<dyn ObjectStore>,
    use arrow::datatypes::{DataType, Field, Schema};
                    &df_runtime,
            let exec = mgr.cpu_executor();
    use datafusion::datasource::file_format::parquet::ParquetFormat;
                    )
                            count += batch.num_rows() as u64;
);
                            Box::from_raw(ptr as *mut datafusion::physical_plan::stream::RecordBatchStreamAdapter<
                    ),
                            &df_runtime,
        let plan = ctx.sql(sql).await.unwrap().logical_plan().clone();
        let opts = ListingOptions::new(Arc::new(ParquetFormat::new()))
                    plan,
fn setup() -> (RuntimeManager, DataFusionRuntime, tempfile::TempDir) {
                .await
    }
    .unwrap();
    });
fn get_metas(mgr: &RuntimeManager, dir: &str) -> Arc<Vec<object_store::ObjectMeta>> {
                        }
    let tmp = tempfile::tempdir().unwrap();
    let batch = RecordBatch::try_new(
        ],
use opensearch_datafusion::api::DataFusionRuntime;
                    async {
        ctx.register_table("t", Arc::new(ListingTable::try_new(cfg).unwrap()))
    let (mgr, df_runtime, tmp) = setup();
criterion_main!(benches);
        let schema = opts.infer_schema(&ctx.state(), &url).await.unwrap();
            },
                    "t".into(),
    create_test_parquet(tmp.path(), 100_000);
criterion_group!(
                        let mut stream = unsafe {
        Field::new("value", DataType::Int64, false),
}
    let plan = get_substrait(&mgr, &df_runtime, dir, "SELECT id, value FROM t");
            let metas = metas.clone();
                    ),
    mgr.cpu_executor.shutdown();
    let mgr = RuntimeManager::new(4, 1.5, 1.5);
            let url = url.clone();
        .build()
                    exec,
fn get_substrait(mgr: &RuntimeManager, df: &DataFusionRuntime, dir: &str, sql: &str) -> Vec<u8> {
    let runtime_env = RuntimeEnvBuilder::new()
    mgr.cpu_executor.shutdown();
                        let ptr = query_executor::execute_query(
use object_store::{ObjectStore, ObjectStoreExt};
    )
                    metas,
                        while let Some(batch) = stream.try_next().await.unwrap() {
    ]));
use opensearch_datafusion::runtime_manager::RuntimeManager;
                            metas,
        b.to_async(mgr.io_runtime.as_ref()).iter(|| {
        .unwrap();
                };
use criterion::{criterion_group, criterion_main, BenchmarkId, Criterion};
    let path = object_store::path::Path::from(format!("{}/bench.parquet", dir));
    for rows in [100, 10_000, 100_000] {
        .with_memory_pool(Arc::new(GreedyMemoryPool::new(256 * 1024 * 1024)))
                    0,
            async {
                )
        let dir = tmp.path().to_str().unwrap();
            }
            async {
    c.bench_function("aggregation_100k", |b| {
