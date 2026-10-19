use std::sync::Arc;
                    let schema = narrow_schema();
    Arc::new(TrackConsumersPool::new(
    });
    Arc::new(Schema::new(fields))
    bench_phantom_reservation_cycle,
/// Simulates a loaded node where the budget must still succeed at full parallelism.
        b.iter(|| {
            drop(reservation); // shrinks
    bench_estimate_row_bytes,
    group.bench_function("narrow_3cols", |b| {
            assert!(budget.target_partitions >= 1);
                                barrier.wait();
                        h.join().unwrap();
/// is low. This bench tests the reduction path specifically by using a pool small
//!
use opensearch_datafusion::query_budget::{acquire_budget, estimate_avg_row_bytes};
            &num_threads,
fn bench_acquire_budget_no_pressure(c: &mut Criterion) {
/// Should be <100ns — just arithmetic on DataType variants.
                    let barrier = Arc::new(Barrier::new(n));
            let budget = acquire_budget(&pool, &schema, 4, 8192).unwrap();
    c.bench_function("acquire_budget/no_pressure/narrow_schema", |b| {
            // Use with_projection which still delegates to inner; the jemalloc
fn make_pool(limit: usize) -> Arc<dyn MemoryPool> {
                        .map(|_| {
        NonZeroUsize::new(5).unwrap(),
/// Benchmark: acquire_budget latency with 80% pool utilization.
}
        Field::new("ts", DataType::Int64, false),
}
/// Benchmark: acquire_budget latency when it must iterate (reduce partitions).
        });
}
/// NOTE: In production, jemalloc override may prevent reduction when actual RSS
fn wide_schema() -> Arc<Schema> {
}
                });
//! 2. End-to-end query throughput with vs without budget enforcement
    let narrow = narrow_schema();
    });
    });
fn bench_acquire_budget_high_pressure_fallback(c: &mut Criterion) {
/// Benchmark: phantom reservation overhead (grow + shrink on pool).
    bench_acquire_budget_high_pressure_fallback,
criterion_group!(
        Field::new("value", DataType::Float64, false),
            },
    let pool = make_pool(1_000_000_000);
fn bench_acquire_budget_moderate_pressure(c: &mut Criterion) {
            reservation.try_grow(phantom_size).unwrap();
    let pool = make_pool(1_000_000_000); // 1GB — no pressure
    use std::sync::Barrier;
                b.iter(|| {
};
/// Benchmark: concurrent acquire_budget calls (simulates multi-query admission).
        Field::new("id", DataType::Int64, false),
                                    drop(budget);
    let consumer = MemoryConsumer::new("background_load");
                            let barrier = barrier.clone();
    use std::thread;
                    for h in handles {
}
            // override will fire in a bench process with GBs of RAM. So we just
            // Under pressure, partitions may be reduced
        b.iter(|| estimate_avg_row_bytes(&narrow));
    ))
//! 1. `acquire_budget` latency at different pool utilization levels
/// Simulates high pressure where the first attempt fails and fallback kicks in.
    group.finish();
    let pool = make_pool(100_000_000); // 100MB
            |b, &n| {
/// Measures the cost of the atomic CAS in GreedyMemoryPool::try_grow.
        b.iter(|| estimate_avg_row_bytes(&wide));
        b.iter(|| {
    c.bench_function("acquire_budget/high_pressure/wide_schema", |b| {
/// enough that even the jemalloc override threshold (70%) is exceeded relative to
    bench_acquire_budget_concurrent,
/// process allocation.
criterion_main!(benches);
fn narrow_schema() -> Arc<Schema> {
    bench_acquire_budget_no_pressure,
    bench_acquire_budget_moderate_pressure,
    let phantom_size = 5_000_000; // 5MB typical phantom
    }
    ]))
            // measure the "budget succeeds at full partitions via override" path.
    // Pre-fill pool to 80% with a long-lived reservation
            let budget = acquire_budget(&pool, &schema, 16, 8192).unwrap();
            let pool = make_pool(50_000_000);
use criterion::{criterion_group, criterion_main, BenchmarkId, Criterion, Throughput};
    c.bench_function("phantom_reservation/grow_shrink_cycle", |b| {
            drop(budget);
            assert!(budget.target_partitions >= 1);
        });
}
        .map(|i| Field::new(format!("col_{i}"), DataType::Utf8, true))
            let budget = acquire_budget(&pool, &schema, 4, 8192).unwrap();
            assert_eq!(budget.target_partitions, 4);
    });
                                }
    benches,
    drop(bg_reservation);
    bg_reservation.try_grow(80_000_000).unwrap();
    let mut bg_reservation = consumer.register(&pool);
use datafusion::arrow::datatypes::{DataType, Field, Schema};
}
        );
    let schema = narrow_schema();
    group.bench_function("wide_50cols", |b| {
    });
                            thread::spawn(move || {
    c.bench_function("acquire_budget/80pct_pressure/narrow_schema", |b| {
                    let handles: Vec<_> = (0..n)
    let mut group = c.benchmark_group("estimate_avg_row_bytes");
}
                        })
            drop(budget);
                            let schema = schema.clone();
/// Uses acquire_budget_with_projection(None) which goes through the inner path.
    group.finish();
//! 3. Behavior under simulated concurrent query pressure
    let fields: Vec<Field> = (0..50)
fn bench_phantom_reservation_cycle(c: &mut Criterion) {
//!
            assert_eq!(budget.batch_size, 8192);
/// Benchmark: acquire_budget latency with no pool pressure.
//! Benchmark for query_budget overhead at various concurrency levels.
use std::num::NonZeroUsize;
        GreedyMemoryPool::new(limit),
                            let pool = pool.clone();
    Arc::new(Schema::new(vec![
            // With jemalloc override active, may get full 16 (correct — no real pressure)
fn bench_acquire_budget_concurrent(c: &mut Criterion) {
                    let pool = make_pool(1_000_000_000);
    });
    let schema = wide_schema();
        b.iter(|| {
                        .collect();
                                for _ in 0..100 {
        group.bench_with_input(
}
        .collect();
        });
    GreedyMemoryPool, MemoryConsumer, MemoryPool, TrackConsumersPool,
use datafusion::execution::memory_pool::{
            BenchmarkId::new("threads", num_threads),
            let mut reservation = consumer.register(&pool);
/// Benchmark: estimate_avg_row_bytes for different schema shapes.
                            })
);
                    }
    let mut group = c.benchmark_group("acquire_budget_concurrent");
            drop(budget);
    let schema = narrow_schema();
    for num_threads in [1, 4, 8, 16] {
            let consumer = MemoryConsumer::new("phantom").with_can_spill(true);
fn bench_estimate_row_bytes(c: &mut Criterion) {
/// This is the hot-path cost when memory is plentiful.
/// Measures contention on the pool's atomic under parallel access.
//! Measures:
//! Run: cargo bench --bench memory_budget_bench
        b.iter(|| {
                                    let budget = acquire_budget(&pool, &schema, 4, 8192).unwrap();
    let wide = wide_schema();
        });
            // Drop the budget to release the phantom reservation for next iteration
