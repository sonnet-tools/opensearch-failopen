    println!("│ Pool limit:             {:<40} │", fmt_mb(r.pool_limit));
                }
        budgeted_spills: budgeted_spills.load(Ordering::Relaxed),
                let elapsed = start.elapsed().as_nanos();
    println!(
    budgeted_spills: usize,
use std::sync::{Arc, Barrier};
        .budgeted_effective_partitions
                        let operator_state_bytes = budget.batch_size * avg_row_bytes / 2;
    // With budget
    println!(
use std::thread;
                let budget_result =
            let budgeted_spills = budgeted_spills.clone();
        &analytics,
        .copied()
    // Compute theoretical untracked memory (without budget)
    unbudgeted_total_memory: usize,
        format!("{:.2} ms", ns / 1_000_000.0)
    println!("├─────────────────────────────────────────────────────────────────┤");
    configured_target_partitions: usize,
        &r,
        })
        budgeted_peak_reserved: peak_reserved.load(Ordering::Relaxed),
    print_result(
                let consumer = MemoryConsumer::new("simulated_hash_agg_nobudget");
    unbudgeted_untracked_memory: usize,
    }
    let b_latencies = budgeted_latencies.lock().unwrap().clone();
    for i in 0..40 {
    );
                barrier.wait();
    let avg_row_bytes = estimate_avg_row_bytes(schema);
        "│ Untracked memory:       {:<40} │",
        "│ With budget:    avg={}, p50={}, p99={:<12} │",
            let unbudgeted_latencies = unbudgeted_latencies.clone();
    println!(
        Field::new("metric_a", DataType::Float64, true),
    print_result(
    );
                let operator_state_bytes = batch_size * avg_row_bytes / 2;
    println!(
    let budgeted_spills = Arc::new(AtomicUsize::new(0));
            let unbudgeted_spills = unbudgeted_spills.clone();
    let unbudgeted_latencies: Arc<std::sync::Mutex<Vec<u128>>> =
    }
                let start = std::time::Instant::now();
        if overhead_ns < 0.0 { " (faster)" } else { "" }
                        peak_reserved.fetch_max(current, Ordering::Relaxed);
        "│ Within pool limit:      {:<40} │",
    );
    );
    );
        64 * 1024 * 1024, // 64MB pool
                    Err(_) => {
        fmt_ns(b_avg),
    } else if ns < 1_000_000.0 {
    }
}
    let avg_partitions: f64 = if r.budgeted_effective_partitions.is_empty() {
    let mut sorted = latencies.to_vec();
            let barrier = barrier.clone();
        fmt_mb(r.unbudgeted_untracked_memory)
        Field::new("region", DataType::Utf8, true),
        .map(|_| {
    } else {
    let total_phantom = Arc::new(AtomicUsize::new(0));
        .min()
                    }
    let effective_partitions: Arc<std::sync::Mutex<Vec<usize>>> =
        "│ Total phantom reserved: {:<40} │",
}
        budgeted_effective_partitions: eff_parts,
        format!("{:.1} µs", ns / 1_000.0)
            format!(
}
}
        "│ Effective partitions:   avg={:.1}, min={}, max={:<21} │",
//!   cargo bench --bench memory_pressure_bench
    let r = simulate_concurrent_queries(
    println!("  Compares memory usage WITH vs WITHOUT budget enforcement");
    if latencies.is_empty() {
    // if ONLY tracked memory were controlled (untracked is invisible to pool).
use datafusion::execution::memory_pool::{
    avg_row_bytes: usize,
                    Ok(budget) => {
        fields.push(Field::new(format!("dbl_col_{i}"), DataType::Float64, true));
fn fmt_ns(ns: f64) -> String {
                        rejections.fetch_add(1, Ordering::Relaxed);
    pool_limit: usize,
                budgeted_latencies.lock().unwrap().push(elapsed);
    let handles2: Vec<_> = (0..num_queries)
        "Scenario 1: Low concurrency (4 queries, 256MB pool, 10-col schema)",
    SimulationResult {
    for h in handles2 {
            let effective_partitions = effective_partitions.clone();
        .saturating_sub(r.budgeted_peak_reserved);
    // Scenario 1: Low concurrency, plenty of memory
                            .push(budget.target_partitions);
            let rejections = rejections.clone();
        Field::new("event_type", DataType::Utf8, true),
    println!("═══════════════════════════════════════════════════════════════════");
    } else {
        fmt_ns(u_p99)
                        let mut reservation = consumer.register(&pool);
        GreedyMemoryPool::new(limit),
    sorted.sort();
fn analytics_schema() -> Arc<Schema> {
    );
    let overhead_ns = b_avg - u_avg;
    // Scenario 4: Wide schema under moderate pressure
    );
        } else {
//! - Peak pool reservation (tracked memory)
    ))
        4,                 // 4 concurrent queries
    let barrier2 = Arc::new(Barrier::new(num_queries));
        fmt_mb(r.budgeted_phantom_total)
        8192,
    println!(
        Arc::new(std::sync::Mutex::new(Vec::new()));
    );
        avg_row_bytes,
        "Scenario 2: Moderate concurrency (8 queries, 128MB pool, 10-col)",
        format!("{:.0} ns", ns)
    (avg, min, p50, p99)
    budgeted_peak_reserved: usize,
    );
        .collect();
fn make_pool(limit: usize) -> Arc<dyn MemoryPool> {
        "│ Peak pool reserved:     {:<40} │",
                unbudgeted_latencies.lock().unwrap().push(elapsed);
    );
                        let consumer = MemoryConsumer::new("simulated_hash_agg");
                let start = std::time::Instant::now();
use datafusion::arrow::datatypes::{DataType, Field, Schema};
        fields.push(Field::new(format!("int_col_{i}"), DataType::Int64, true));
        256 * 1024 * 1024,
    for i in 0..30 {
use opensearch_datafusion::query_budget::{acquire_budget, estimate_avg_row_bytes};
    let memory_saved = r
    );
    let r = simulate_concurrent_queries(
        &wide,
                "YES by {}",
    let r = simulate_concurrent_queries(
                }
            let budgeted_latencies = budgeted_latencies.clone();
//! - Whether budget enforcement prevents pool exhaustion
        Field::new("request_id", DataType::Utf8, true),
    );
    let budgeted_latencies: Arc<std::sync::Mutex<Vec<u128>>> =
            })
        fmt_mb(r.budgeted_peak_reserved)
            thread::spawn(move || {
        .map(|_| {
    println!(
        "│ Budget overhead: {} ({:.2}% of total query time){:<12} │",
        * (3 * batch_size * avg_row_bytes + 64 * 1024 + schema.fields().len() * 4 * 1024)
    println!("│ Operator spills:        {:<40} │", r.budgeted_spills);
        fmt_mb(r.unbudgeted_total_memory)
    }
    let mut fields = Vec::with_capacity(100);
        (overhead_ns / u_avg) * 100.0
    println!("├────────────────── WITHOUT BUDGET (theoretical) ─────────────────┤");
    if ns < 1_000.0 {
/// Wide schema (100 columns, mixed types).
    println!("├────────────────── WITH BUDGET ───────────────────────────────────┤");
                        }
        4,                 // target_partitions=4
        + batch_size * avg_row_bytes;
    let len = sorted.len();
        r.budgeted_effective_partitions.iter().sum::<usize>() as f64
        return (0.0, 0.0, 0.0, 0.0);
        h.join().unwrap();
    budgeted_rejections: usize,
    budgeted_effective_partitions: Vec<usize>,
    budgeted_phantom_total: usize,
    );
fn wide_analytics_schema() -> Arc<Schema> {
            let pool = pool_nobudget.clone();
        Arc::new(std::sync::Mutex::new(Vec::new()));
    let analytics = analytics_schema();
    println!("├────────────────── SAVINGS ───────────────────────────────────────┤");
                // No budget — allocate at full configured parallelism
                barrier.wait();
    let r = simulate_concurrent_queries(
    unbudgeted_latencies_ns: Vec<u128>,
    println!();
    pool_limit: usize,
    // against a pool of the same size. Spills here represent what would happen
        "│ Memory saved:           {:<40} │",
fn main() {
}
        16,               // 16 concurrent queries
        &r,
    let pct_saved = if r.unbudgeted_total_memory > 0 {
            let barrier = barrier2.clone();
    println!("│ Queries rejected:       {:<40} │", r.budgeted_rejections);
        Field::new("user_id", DataType::Int64, false),
        Field::new("session_id", DataType::Utf8, true),
    ]))
    let operator_state_per_query = batch_size * avg_row_bytes / 2;
}
    GreedyMemoryPool, MemoryConsumer, MemoryPool, TrackConsumersPool,
    let unbudgeted_untracked = num_queries * untracked_per_query;
    );
    let (u_avg, u_min, u_p50, u_p99) = latency_stats(&r.unbudgeted_latencies_ns);
) -> SimulationResult {
    );
    println!();
        "Scenario 3: High concurrency (16 queries, 64MB pool, 10-col)",
//! Output format is human-readable table comparing "with budget" vs "without budget".
//! This is NOT a criterion latency benchmark — it's a measurement harness that
    let unbudgeted_total = unbudgeted_untracked + num_queries * operator_state_per_query;
        unbudgeted_total_memory: unbudgeted_total,
    // Same workload but skip acquire_budget — allocate operator state directly
    println!("│ Batch size:             {:<40} │", r.batch_size);
    // Scenario 5: Wide schema under extreme pressure
        .iter()
/// Simulate N concurrent queries acquiring budgets and holding operator state.
    let u_latencies = unbudgeted_latencies.lock().unwrap().clone();
                        if reservation.try_grow(operator_state_bytes).is_err() {
    println!();
                            .unwrap()
    );
                thread::sleep(Duration::from_millis(10));
                        let current = pool.reserved();
        0.0
    );
    budgeted_latencies_ns: Vec<u128>,
    let overhead_pct = if u_avg > 0.0 {
    for i in 0..30 {
        &wide,
    configured_target_partitions: usize,
                    acquire_budget(&pool, &schema, configured_target_partitions, batch_size);
    );
    );
    unbudgeted_spills: usize,
        }
            let peak_reserved = peak_reserved.clone();
        8,
        format!("{} (pool only sees tracked ops)", r.unbudgeted_spills)
            )
    let untracked_per_query = configured_target_partitions
            let total_phantom = total_phantom.clone();
}
//! prints memory statistics directly. Run with:
        128 * 1024 * 1024, // 128MB pool
        fmt_ns(b_p99)
        8,                 // 8 concurrent queries
    let min = sorted[0] as f64;
                fmt_mb(r.unbudgeted_total_memory - r.pool_limit)
    println!(
    }
                        thread::sleep(Duration::from_millis(10));
        "│ Configured partitions:  {:<40} │",
        4,
            let pool = pool.clone();
        Field::new("payload", DataType::Utf8, true),
    print_result(
        8192,
        pool_limit,
        avg_partitions, min_partitions, max_partitions
    // Without budget
}
    );
    format!("{:.1} MB", bytes as f64 / (1024.0 * 1024.0))
                drop(reservation);
        .unwrap_or(0);
    }
        r.configured_target_partitions
    );
    };
    // ─── WITHOUT BUDGET pass (baseline) ───
    let min_partitions = r
    print_result(
}
    println!(
            "NO".to_string()
        fields.push(Field::new(format!("str_col_{i}"), DataType::Utf8, true));
/// (hash table growth proportional to batch_size) to represent a real workload.
        "│ Without budget: avg={}, p50={}, p99={:<12} │",
    } else {
                    unbudgeted_spills.fetch_add(1, Ordering::Relaxed);
    let pool_nobudget = make_pool(pool_limit);
    let r = simulate_concurrent_queries(
    let pool = make_pool(pool_limit);
        &r,
    println!("  MEMORY PRESSURE REDUCTION BENCHMARK");
    // Scenario 6: Very high concurrency burst
//! Measures memory reduction from budget enforcement under load.
struct SimulationResult {
        "│ Total (untracked+ops):  {:<40} │",
/// Schema representing a realistic analytics table.
        8192,
//!
fn simulate_concurrent_queries(
fn latency_stats(latencies: &[u128]) -> (f64, f64, f64, f64) {
                    }
        })
    println!("│ Avg row bytes:          {:<40} │", r.avg_row_bytes);
        unbudgeted_latencies_ns: u_latencies,
        .unbudgeted_total_memory
                        drop(reservation);
        "│ Would exceed pool:      {:<40} │",
    );
            thread::spawn(move || {
        8,
                match budget_result {
    println!(
        "Scenario 5: Wide schema extreme (16 queries, 128MB pool, 100-col, tp=8)",
        Field::new("metric_b", DataType::Float64, true),
    let eff_parts = effective_partitions.lock().unwrap().clone();
    }
use std::sync::atomic::{AtomicUsize, Ordering};
    let barrier = Arc::new(Barrier::new(num_queries));
        budgeted_rejections: rejections.load(Ordering::Relaxed),
    Arc::new(TrackConsumersPool::new(
    let avg = sorted.iter().sum::<u128>() as f64 / len as f64;
        16,
        .budgeted_effective_partitions
                            budgeted_spills.fetch_add(1, Ordering::Relaxed);
    Arc::new(Schema::new(vec![
    let handles: Vec<_> = (0..num_queries)
            })
        if r.unbudgeted_total_memory > r.pool_limit {
        256 * 1024 * 1024, // 256MB pool
        (memory_saved as f64 / r.unbudgeted_total_memory as f64) * 100.0
        Arc::new(std::sync::Mutex::new(Vec::new()));
                            .lock()
    println!("│ {:<63} │", label);
        if within_pool { "YES ✓" } else { "NO ✗" }
};
    schema: &Arc<Schema>,
    println!(
    print_result(
    // ─── WITH BUDGET pass ───
fn print_result(label: &str, r: &SimulationResult) {
    let max_partitions = r
                if reservation.try_grow(operator_state_bytes).is_err() {
    } else {
        32, // 32 concurrent queries
    let wide = wide_analytics_schema();
    println!(
    };
                        effective_partitions
    num_queries: usize,
    // Scenario 3: High concurrency, tight pool
        &analytics,
        128 * 1024 * 1024, // 128MB pool
        &r,
/// Each "query" acquires a budget, then simulates operator state allocation
        .collect();
        Field::new("timestamp", DataType::Int64, false),
//!
    println!("═══════════════════════════════════════════════════════════════════");
        .max()
    batch_size: usize,
    let peak_reserved = Arc::new(AtomicUsize::new(0));
        &analytics,
        NonZeroUsize::new(5).unwrap(),
        4,                 // target_partitions=4
    );
    let p99 = sorted[(len * 99 / 100).min(len - 1)] as f64;
    let r = simulate_concurrent_queries(
        configured_target_partitions,
    }
        budgeted_latencies_ns: b_latencies,
                let mut reservation = consumer.register(&pool);
    println!("┌─────────────────────────────────────────────────────────────────┐");
    println!(
        &r,
    batch_size: usize,
    println!("├────────────────── LATENCY (per query, includes 10ms sleep) ──────┤");
    println!(
        8192,
    let within_pool = r.budgeted_peak_reserved <= r.pool_limit;
            / r.budgeted_effective_partitions.len() as f64
    let (b_avg, b_min, b_p50, b_p99) = latency_stats(&r.budgeted_latencies_ns);
}
use std::time::Duration;
        256 * 1024 * 1024, // 256MB pool
                        drop(budget);
                        total_phantom.fetch_add(budget.phantom_bytes, Ordering::Relaxed);
//! - Effective target_partitions chosen per query
        4,
        fmt_ns(overhead_ns.abs()),
    let rejections = Arc::new(AtomicUsize::new(0));
        &analytics,
        .unwrap_or(0);
        &r,
//! Simulates concurrent queries against a shared pool and reports:
        fmt_ns(u_avg),
    for h in handles {
    let unbudgeted_spills = Arc::new(AtomicUsize::new(0));
        8192,              // batch_size=8192
        fmt_ns(b_p50),
    print_result(
///
    num_queries: usize,
        overhead_pct.abs(),
        .copied()
        unbudgeted_spills: unbudgeted_spills.load(Ordering::Relaxed),
        0.0
        .iter()
        fmt_ns(u_p50),
        budgeted_phantom_total: total_phantom.load(Ordering::Relaxed),
        8192,
        8, // higher parallelism
        h.join().unwrap();
    Arc::new(Schema::new(fields))
fn fmt_mb(bytes: usize) -> String {
        unbudgeted_untracked_memory: unbudgeted_untracked,
    println!("└─────────────────────────────────────────────────────────────────┘");
                let elapsed = start.elapsed().as_nanos();
        "Scenario 4: Wide schema (8 queries, 256MB pool, 100-col, tp=8)",
    );
/// Also runs a "without budget" baseline to measure latency difference.
    // Scenario 2: Moderate concurrency, moderate pool
        batch_size,
//!
        "│ Operator spills:        {:<40} │",
            let schema = schema.clone();
use std::num::NonZeroUsize;
        num_queries,
    println!("│ Concurrent queries:     {:<40} │", r.num_queries);
        Field::new("metric_c", DataType::Float64, true),
        format!("{} ({:.1}%)", fmt_mb(memory_saved), pct_saved)
    };
    let p50 = sorted[len / 2] as f64;
    );
        0.0
        "Scenario 6: Burst (32 queries, 256MB pool, 10-col, tp=4)",
