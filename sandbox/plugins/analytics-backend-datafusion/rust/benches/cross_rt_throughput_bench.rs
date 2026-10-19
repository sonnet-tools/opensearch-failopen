use arrow::datatypes::{DataType, Field, Schema};
}
                            schema.clone(),
                        .enable_all()
use datafusion::physical_plan::stream::RecordBatchStreamAdapter;
        );
        Field::new("c", DataType::Int64, false),
                        total_rows
}
                        let mut total_rows = 0u64;
        vec![
    group.finish();
//!
                    }
/// This measures the channel overhead per batch — the difference between
                let exec = make_executor();
    ]))
                        let wrapped = RecordBatchStreamAdapter::new(cross.schema(), cross);
//!
use std::sync::Arc;
        let batch_size = 8192;
                            stream::iter(batches),
fn test_batch(rows: usize) -> RecordBatch {
                        .unwrap(),
        ],
    DedicatedExecutor::new("bench-cpu", builder)
                        .worker_threads(2)
            BenchmarkId::new("batches", num_batches),
        schema,
                    let schema = schema.clone();
            &num_batches,
        Field::new("b", DataType::Int64, false),
use opensearch_datafusion::cross_rt_stream::CrossRtStream;
        group.bench_with_input(
}
    RecordBatch::try_new(
                        while let Some(batch) = wrapped.next().await {
//! Throughput benchmark for CrossRtStream.
//! Measures how fast batches flow from the CPU executor through the mpsc channel
        group.throughput(Throughput::Elements(rows_total as u64));
            Arc::new(Int64Array::from(col.clone())),
            Arc::new(Int64Array::from(col.clone())),
                )
    builder.worker_threads(4).enable_all();
                });
                    async move {
fn make_executor() -> DedicatedExecutor {
                b.to_async(
            |b, &n| {
use futures::{stream, StreamExt};
use opensearch_datafusion::executor::DedicatedExecutor;
                        let inner = Box::pin(RecordBatchStreamAdapter::new(
    )
            Arc::new(Int64Array::from(col)),
    for num_batches in [100, 1000, 5000] {
                            total_rows += batch.unwrap().num_rows() as u64;
                    let batch = batch.clone();
/// channel(1) and channel(2) shows up as reduced stall time.
                        tokio::pin!(wrapped);
criterion_group!(benches, bench_cross_rt_throughput);
                        .build()
use arrow_array::{Int64Array, RecordBatch};
                            (0..n).map(|_| Ok(batch.clone())).collect();
use datafusion::error::DataFusionError;
//! to the consumer. This directly measures the impact of channel capacity on
}
    .unwrap()
    let col: Vec<i64> = (0..rows as i64).collect();
fn bench_cross_rt_throughput(c: &mut Criterion) {
    let mut group = c.benchmark_group("cross_rt_throughput");
//! Run: cargo bench --bench cross_rt_throughput_bench
    let mut builder = tokio::runtime::Builder::new_multi_thread();
            Arc::new(Int64Array::from(col.clone())),
use criterion::{criterion_group, criterion_main, BenchmarkId, Criterion, Throughput};
fn test_schema() -> Arc<Schema> {
                        ));
        Field::new("a", DataType::Int64, false),
        let rows_total = num_batches * batch_size;
/// Benchmark: push N batches through CrossRtStream and consume them.
                .iter(|| {
                let batch = test_batch(batch_size);
                        }
    }
                        let cross = CrossRtStream::new_with_df_error_stream(inner, exec.clone());
    Arc::new(Schema::new(vec![
                let schema = test_schema();
                    let exec = exec.clone();
                    tokio::runtime::Builder::new_multi_thread()
                exec.join_blocking();
        Field::new("d", DataType::Int64, false),
criterion_main!(benches);
    let schema = test_schema();
//! pipeline throughput.
            },
                        let batches: Vec<Result<RecordBatch, DataFusionError>> =
