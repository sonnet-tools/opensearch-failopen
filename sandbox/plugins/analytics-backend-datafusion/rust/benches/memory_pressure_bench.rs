        fields.push(Field::new(format!("str_col_{i}"), DataType::Utf8, true));
        "│ Memory saved:           {:<40} │",
fn make_pool(limit: usize) -> Arc<dyn MemoryPool> {
    batch_size: usize,
        Field::new("request_id", DataType::Utf8, true),
        256 * 1024 * 1024,
    println!("│ Operator spills:        {:<40} │", r.budgeted_spills);
        "│ Total phantom reserved: {:<40} │",
    // Scenario 5: Wide schema under extreme pressure
                        total_phantom.fetch_add(budget.phantom_bytes, Ordering::Relaxed);
    GreedyMemoryPool, MemoryConsumer, MemoryPool, TrackConsumersPool,
        32, // 32 concurrent queries
        fmt_mb(r.budgeted_phantom_total)
    println!("═══════════════════════════════════════════════════════════════════");
        4,
            let schema = schema.clone();
    );
    for h in handles2 {
}
    // ─── WITHOUT BUDGET pass (baseline) ───
        "│ Configured partitions:  {:<40} │",
        &r,
}
        8192,
}
        Arc::new(std::sync::Mutex::new(Vec::new()));
        batch_size,
                fmt_mb(r.unbudgeted_total_memory - r.pool_limit)
                let budget_result =
        format!("{} ({:.1}%)", fmt_mb(memory_saved), pct_saved)
    for i in 0..40 {
    let handles2: Vec<_> = (0..num_queries)
        * (3 * batch_size * avg_row_bytes + 64 * 1024 + schema.fields().len() * 4 * 1024)
    let unbudgeted_latencies: Arc<std::sync::Mutex<Vec<u128>>> =
    }
    println!("├────────────────── WITHOUT BUDGET (theoretical) ─────────────────┤");
    } else {
    Arc::new(Schema::new(fields))
    let eff_parts = effective_partitions.lock().unwrap().clone();
    }
    );
        "│ Without budget: avg={}, p50={}, p99={:<12} │",
        NonZeroUsize::new(5).unwrap(),
        Field::new("metric_a", DataType::Float64, true),
            format!(
//!
use std::sync::{Arc, Barrier};
                    }
    }
    print_result(
/// Wide schema (100 columns, mixed types).
    for h in handles {
        "Scenario 2: Moderate concurrency (8 queries, 128MB pool, 10-col)",
        if overhead_ns < 0.0 { " (faster)" } else { "" }
                            .lock()
//!   cargo bench --bench memory_pressure_bench
    let barrier2 = Arc::new(Barrier::new(num_queries));
                let consumer = MemoryConsumer::new("simulated_hash_agg_nobudget");
    let memory_saved = r
            let total_phantom = total_phantom.clone();
    // if ONLY tracked memory were controlled (untracked is invisible to pool).
        Field::new("metric_b", DataType::Float64, true),
    println!();
    print_result(
        0.0
    );
//! This is NOT a criterion latency benchmark — it's a measurement harness that
            })
    println!(
    };
        .unwrap_or(0);
//! - Effective target_partitions chosen per query
        fields.push(Field::new(format!("int_col_{i}"), DataType::Int64, true));
    let min_partitions = r
    );
    // against a pool of the same size. Spills here represent what would happen
    );
    // Scenario 2: Moderate concurrency, moderate pool
fn wide_analytics_schema() -> Arc<Schema> {
        4,                 // target_partitions=4
//! Measures memory reduction from budget enforcement under load.
            let effective_partitions = effective_partitions.clone();
    println!();
        128 * 1024 * 1024, // 128MB pool
        avg_partitions, min_partitions, max_partitions
    let unbudgeted_untracked = num_queries * untracked_per_query;
    let min = sorted[0] as f64;
        "Scenario 1: Low concurrency (4 queries, 256MB pool, 10-col schema)",
}
        "│ Budget overhead: {} ({:.2}% of total query time){:<12} │",
    let analytics = analytics_schema();
}
    println!("│ {:<63} │", label);
                let start = std::time::Instant::now();
        4,                 // target_partitions=4
        budgeted_peak_reserved: peak_reserved.load(Ordering::Relaxed),
                "YES by {}",
    println!("│ Batch size:             {:<40} │", r.batch_size);
    let total_phantom = Arc::new(AtomicUsize::new(0));
    let r = simulate_concurrent_queries(
        &wide,
        configured_target_partitions,
    );
    budgeted_latencies_ns: Vec<u128>,
    num_queries: usize,
    println!();
    println!("├────────────────── LATENCY (per query, includes 10ms sleep) ──────┤");
    let budgeted_latencies: Arc<std::sync::Mutex<Vec<u128>>> =
        format!("{:.0} ns", ns)
            let budgeted_latencies = budgeted_latencies.clone();
        fmt_mb(r.budgeted_peak_reserved)
        "│ Operator spills:        {:<40} │",
///
    // Without budget
    for i in 0..30 {
                        let operator_state_bytes = budget.batch_size * avg_row_bytes / 2;
        &r,
    }
                }
    println!("═══════════════════════════════════════════════════════════════════");
    let mut fields = Vec::with_capacity(100);
        "│ Total (untracked+ops):  {:<40} │",
    println!(
        0.0
    println!("┌─────────────────────────────────────────────────────────────────┐");
        "│ Untracked memory:       {:<40} │",
        r.budgeted_effective_partitions.iter().sum::<usize>() as f64
        8192,
    print_result(
        Field::new("timestamp", DataType::Int64, false),
    budgeted_phantom_total: usize,
        Field::new("user_id", DataType::Int64, false),
    println!("│ Concurrent queries:     {:<40} │", r.num_queries);
    print_result(
        .max()
    let budgeted_spills = Arc::new(AtomicUsize::new(0));
    println!(
    println!("├────────────────── SAVINGS ───────────────────────────────────────┤");
                    }
                let elapsed = start.elapsed().as_nanos();
    // Scenario 3: High concurrency, tight pool
    let untracked_per_query = configured_target_partitions
            let unbudgeted_spills = unbudgeted_spills.clone();
    configured_target_partitions: usize,
    let r = simulate_concurrent_queries(
        &r,
        &r,
struct SimulationResult {
    let avg_partitions: f64 = if r.budgeted_effective_partitions.is_empty() {
    println!("  Compares memory usage WITH vs WITHOUT budget enforcement");
        256 * 1024 * 1024, // 256MB pool
        .unwrap_or(0);
    let avg_row_bytes = estimate_avg_row_bytes(schema);
    let max_partitions = r
        8192,
        format!("{:.1} µs", ns / 1_000.0)
}
        budgeted_phantom_total: total_phantom.load(Ordering::Relaxed),
    let u_latencies = unbudgeted_latencies.lock().unwrap().clone();
                    Ok(budget) => {
fn fmt_ns(ns: f64) -> String {
        fmt_ns(b_p99)
    println!("│ Avg row bytes:          {:<40} │", r.avg_row_bytes);
        r.configured_target_partitions
        "│ Would exceed pool:      {:<40} │",
    println!(
        0.0
        .min()
    if ns < 1_000.0 {
    unbudgeted_untracked_memory: usize,
            thread::spawn(move || {
        &analytics,
    );
    ]))
        &wide,
    let unbudgeted_spills = Arc::new(AtomicUsize::new(0));
        Field::new("session_id", DataType::Utf8, true),
    let overhead_ns = b_avg - u_avg;
            let peak_reserved = peak_reserved.clone();
) -> SimulationResult {
    num_queries: usize,
        return (0.0, 0.0, 0.0, 0.0);
                match budget_result {
    let overhead_pct = if u_avg > 0.0 {
use std::num::NonZeroUsize;
        .saturating_sub(r.budgeted_peak_reserved);
    let handles: Vec<_> = (0..num_queries)
        Arc::new(std::sync::Mutex::new(Vec::new()));
        8192,              // batch_size=8192
            thread::spawn(move || {
                            .push(budget.target_partitions);
                        let consumer = MemoryConsumer::new("simulated_hash_agg");
use opensearch_datafusion::query_budget::{acquire_budget, estimate_avg_row_bytes};
    let p99 = sorted[(len * 99 / 100).min(len - 1)] as f64;
    let avg = sorted.iter().sum::<u128>() as f64 / len as f64;
    // Scenario 4: Wide schema under moderate pressure
                        rejections.fetch_add(1, Ordering::Relaxed);
    let r = simulate_concurrent_queries(
        fmt_ns(u_avg),
        4,
    let r = simulate_concurrent_queries(
use datafusion::arrow::datatypes::{DataType, Field, Schema};
    );
    println!(
            let unbudgeted_latencies = unbudgeted_latencies.clone();
        if within_pool { "YES ✓" } else { "NO ✗" }
        "Scenario 6: Burst (32 queries, 256MB pool, 10-col, tp=4)",
        + batch_size * avg_row_bytes;
        .iter()
            let pool = pool.clone();
    );
        Field::new("region", DataType::Utf8, true),
    (avg, min, p50, p99)
                        peak_reserved.fetch_max(current, Ordering::Relaxed);
    // With budget
        format!("{} (pool only sees tracked ops)", r.unbudgeted_spills)
            let budgeted_spills = budgeted_spills.clone();
        8192,
        8,
        8, // higher parallelism
    );
        (memory_saved as f64 / r.unbudgeted_total_memory as f64) * 100.0
        unbudgeted_untracked_memory: unbudgeted_untracked,
//! - Whether budget enforcement prevents pool exhaustion
            / r.budgeted_effective_partitions.len() as f64
            let barrier = barrier.clone();
    let pool_nobudget = make_pool(pool_limit);
    unbudgeted_spills: usize,
    println!("├─────────────────────────────────────────────────────────────────┤");
        fmt_ns(u_p50),
                        if reservation.try_grow(operator_state_bytes).is_err() {
    } else {
    let rejections = Arc::new(AtomicUsize::new(0));
    budgeted_peak_reserved: usize,
            let barrier = barrier2.clone();
        })
fn latency_stats(latencies: &[u128]) -> (f64, f64, f64, f64) {
    print_result(
    budgeted_effective_partitions: Vec<usize>,
        avg_row_bytes,
                // No budget — allocate at full configured parallelism
        64 * 1024 * 1024, // 64MB pool
        fmt_mb(r.unbudgeted_untracked_memory)
        unbudgeted_latencies_ns: u_latencies,
    for i in 0..30 {
}
}
        .map(|_| {
use std::thread;
        16,
            let rejections = rejections.clone();
                let start = std::time::Instant::now();
                        drop(budget);
                thread::sleep(Duration::from_millis(10));
        .unbudgeted_total_memory
        })
                        thread::sleep(Duration::from_millis(10));
                            budgeted_spills.fetch_add(1, Ordering::Relaxed);
        fmt_ns(overhead_ns.abs()),
    unbudgeted_total_memory: usize,
//! Simulates concurrent queries against a shared pool and reports:
        "Scenario 5: Wide schema extreme (16 queries, 128MB pool, 100-col, tp=8)",
        h.join().unwrap();
    if latencies.is_empty() {
    batch_size: usize,
    // Scenario 6: Very high concurrency burst
    let r = simulate_concurrent_queries(
        unbudgeted_spills: unbudgeted_spills.load(Ordering::Relaxed),
        .budgeted_effective_partitions
    let (b_avg, b_min, b_p50, b_p99) = latency_stats(&r.budgeted_latencies_ns);
    Arc::new(Schema::new(vec![
use std::time::Duration;
        .iter()
fn main() {
    println!(
        Arc::new(std::sync::Mutex::new(Vec::new()));
        .copied()
    let p50 = sorted[len / 2] as f64;
    let operator_state_per_query = batch_size * avg_row_bytes / 2;
    );
}
                let mut reservation = consumer.register(&pool);
    let effective_partitions: Arc<std::sync::Mutex<Vec<usize>>> =
    // ─── WITH BUDGET pass ───
        &analytics,
    } else {
        format!("{:.2} ms", ns / 1_000_000.0)
fn fmt_mb(bytes: usize) -> String {
    Arc::new(TrackConsumersPool::new(
        8,                 // 8 concurrent queries
//!
        8,
/// Also runs a "without budget" baseline to measure latency difference.
fn analytics_schema() -> Arc<Schema> {
    println!(
    configured_target_partitions: usize,
    schema: &Arc<Schema>,
    let unbudgeted_total = unbudgeted_untracked + num_queries * operator_state_per_query;
        "│ Within pool limit:      {:<40} │",
    // Compute theoretical untracked memory (without budget)
        .budgeted_effective_partitions
    unbudgeted_latencies_ns: Vec<u128>,
        fmt_mb(r.unbudgeted_total_memory)
    );
    }
        4,                 // 4 concurrent queries
        "│ Effective partitions:   avg={:.1}, min={}, max={:<21} │",
        fmt_ns(b_p50),
        h.join().unwrap();
    };
        fields.push(Field::new(format!("dbl_col_{i}"), DataType::Float64, true));
    println!(
        (overhead_ns / u_avg) * 100.0
    let r = simulate_concurrent_queries(
    );
    println!(
            "NO".to_string()
        if r.unbudgeted_total_memory > r.pool_limit {
                        }
    );
                        let current = pool.reserved();
//! prints memory statistics directly. Run with:
                barrier.wait();
        .copied()
        num_queries,
                        effective_partitions
    println!("  MEMORY PRESSURE REDUCTION BENCHMARK");
            })
                let operator_state_bytes = batch_size * avg_row_bytes / 2;
        &analytics,
    println!(
    ))
    );
            let pool = pool_nobudget.clone();
    } else if ns < 1_000_000.0 {
        "│ With budget:    avg={}, p50={}, p99={:<12} │",
/// Simulate N concurrent queries acquiring budgets and holding operator state.
    avg_row_bytes: usize,
/// (hash table growth proportional to batch_size) to represent a real workload.
        pool_limit,
    );
    println!("└─────────────────────────────────────────────────────────────────┘");
    );
//! - Peak pool reservation (tracked memory)
};
    // Scenario 1: Low concurrency, plenty of memory
    let pool = make_pool(pool_limit);
    println!(
            )
    let peak_reserved = Arc::new(AtomicUsize::new(0));
        16,               // 16 concurrent queries
        &analytics,
        128 * 1024 * 1024, // 128MB pool
                            .unwrap()
        }
        budgeted_rejections: rejections.load(Ordering::Relaxed),
        overhead_pct.abs(),
/// Each "query" acquires a budget, then simulates operator state allocation
//!
    println!("│ Queries rejected:       {:<40} │", r.budgeted_rejections);
    budgeted_spills: usize,
    } else {
    print_result(
    let (u_avg, u_min, u_p50, u_p99) = latency_stats(&r.unbudgeted_latencies_ns);
use datafusion::execution::memory_pool::{
        budgeted_effective_partitions: eff_parts,
        budgeted_spills: budgeted_spills.load(Ordering::Relaxed),
        256 * 1024 * 1024, // 256MB pool
    let mut sorted = latencies.to_vec();
        Field::new("metric_c", DataType::Float64, true),
    println!(
        .collect();
    }
                drop(reservation);
    println!("├────────────────── WITH BUDGET ───────────────────────────────────┤");
        fmt_ns(u_p99)
                unbudgeted_latencies.lock().unwrap().push(elapsed);
    sorted.sort();
    let b_latencies = budgeted_latencies.lock().unwrap().clone();
    }
                        drop(reservation);
                }
        GreedyMemoryPool::new(limit),
        "│ Peak pool reserved:     {:<40} │",
        8192,
    // Same workload but skip acquire_budget — allocate operator state directly
    println!(
}
use std::sync::atomic::{AtomicUsize, Ordering};
//! Output format is human-readable table comparing "with budget" vs "without budget".
        .collect();
                        let mut reservation = consumer.register(&pool);
fn print_result(label: &str, r: &SimulationResult) {
        .map(|_| {
                budgeted_latencies.lock().unwrap().push(elapsed);
    println!("│ Pool limit:             {:<40} │", fmt_mb(r.pool_limit));
    let pct_saved = if r.unbudgeted_total_memory > 0 {
    );
        "Scenario 3: High concurrency (16 queries, 64MB pool, 10-col)",
    );
        &r,
    let barrier = Arc::new(Barrier::new(num_queries));
        Field::new("payload", DataType::Utf8, true),
    let len = sorted.len();
    SimulationResult {
        Field::new("event_type", DataType::Utf8, true),
fn simulate_concurrent_queries(
    let within_pool = r.budgeted_peak_reserved <= r.pool_limit;
    );
    );
    pool_limit: usize,
                    Err(_) => {
        "Scenario 4: Wide schema (8 queries, 256MB pool, 100-col, tp=8)",
    format!("{:.1} MB", bytes as f64 / (1024.0 * 1024.0))
    );
                if reservation.try_grow(operator_state_bytes).is_err() {
        } else {
                    acquire_budget(&pool, &schema, configured_target_partitions, batch_size);
    };
                let elapsed = start.elapsed().as_nanos();
        fmt_ns(b_avg),
    pool_limit: usize,
    }
/// Schema representing a realistic analytics table.
    let wide = wide_analytics_schema();
        unbudgeted_total_memory: unbudgeted_total,
    budgeted_rejections: usize,
    );
    );
        &r,
                    unbudgeted_spills.fetch_add(1, Ordering::Relaxed);
        budgeted_latencies_ns: b_latencies,
    );
                barrier.wait();
