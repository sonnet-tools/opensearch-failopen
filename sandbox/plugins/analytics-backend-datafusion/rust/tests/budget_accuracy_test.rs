        predicted_avg_row_bytes
    println!(
 * SPDX-License-Identifier: Apache-2.0
        }
            .collect();
    let inferred_schema = opts.infer_schema(&ctx.state(), &url).await.unwrap();
    let tmp = TempDir::new().unwrap();
async fn budget_accuracy_single_partition() {
    println!("└─────────────────────────────────────────────────────────────────┘");
    let within_threshold = row_bytes_ratio <= max_over_estimate_ratio;
        format!(
}
async fn validate_budget_accuracy(
use datafusion::execution::SessionStateBuilder;
use datafusion::datasource::listing::{
//! Validates the memory budget formula against actual measured memory during
        writer.write(&batch).unwrap();
    config.options_mut().execution.batch_size = batch_size;
#[tokio::test]
    let schema = create_parquet_data(tmp.path(), 100_000, 4);
        let total_batches = total_batches.clone();
    (
            predicted_avg_row_bytes,
            "Budget UNDER-estimated row bytes: predicted={} < actual={}. \
//! emitted by every partition stream. Sums these to get "actual untracked
    ctx.register_table("t", Arc::new(ListingTable::try_new(cfg).unwrap()))
    let schema = create_parquet_data(tmp.path(), 100_000, 4);
    let opts = ListingOptions::new(Arc::new(ParquetFormat::new()))
    );
async fn budget_accuracy_high_parallelism() {
 * The OpenSearch Contributors require contributions made to
    let substrait_bytes = build_substrait(dir, sql).await;
        sql,
//! Pass criteria: actual ≤ predicted (formula is conservative).
    }
        format!(
        .with_schema(inferred_schema);
    drop(static_budget);
    let plan = Plan::decode(substrait_bytes.as_slice()).unwrap();
use parquet::arrow::ArrowWriter;
        Field::new("id", DataType::Int64, false),
    validate_budget_accuracy_relaxed(&dir, &schema, "SELECT id, metric FROM t", 4, 8192, 15.0)
        "│ Metadata phantom: {:<44} │",
    drop(budget);
        0
        "│ target_partitions={}, batch_size={:<30} │",
    println!(
        } else {
        );
            within_threshold || actual_avg_row_bytes == 0,
    println!(
        "SELECT region, COUNT(*), AVG(metric) FROM t GROUP BY region",
    // Build substrait and execute through DataFusion at the specified parallelism
             This wastes pool capacity and forces unnecessary spilling.",
    // Compute actual average batch size (this is what flows through channels)
        .unwrap();
    // and don't need budget coverage. We validate conservatism is still safe:
    // Static estimate (type-based)
/// Create parquet test data with a known schema.
};
            schema.clone(),
    batch_size: usize,
    println!(
        SerializedFileReader::new(std::fs::File::open(first_file.path()).unwrap()).unwrap();
    let tmp = TempDir::new().unwrap();
    batch_size: usize,
            budget.phantom_bytes as f64 / 1048576.0
async fn budget_accuracy_small_batch_size() {
             This means real memory usage exceeds the phantom reservation — potential OOM.",
    schema: &Arc<Schema>,
                        .map(|s| s.as_deref())
        "│ Reduction:        {:<44} │",
        let batch = RecordBatch::try_new(
    // over-estimates. We relax the 3x threshold for projections since the formula
        total_batches.load(Ordering::Relaxed),
    schema: &Arc<Schema>,
    // reservation covers the scan stage. Post-aggregation batches are small
        .with_listing_options(opts)
            "{} ({:.1} KB)",
        let regions: Vec<Option<&str>> = ids
            .iter()
    let avg_batch_bytes = if actual_batches > 0 {
    // projected_columns is provided. This test validates the FULL-SCHEMA estimate
    println!("└─────────────────────────────────────────────────────────────────┘");
        0
use datafusion::execution::runtime_env::RuntimeEnvBuilder;
    assert!(static_phantom > 0);
}
            meta_phantom,
    target_partitions: usize,
async fn budget_accuracy_narrow_schema_full_scan() {
    println!(
/// Execute a physical plan across all partitions, measuring total bytes emitted.
    let state = SessionStateBuilder::new()
use datafusion::physical_plan::{execute_stream_partitioned, ExecutionPlan};
        as Arc<dyn datafusion::execution::memory_pool::MemoryPool>;
use arrow::datatypes::{DataType, Field, Schema};
    config.options_mut().execution.target_partitions = target_partitions;
    batch_size: usize,
    .await;
    let total_rows = Arc::new(AtomicUsize::new(0));
    dir: &str,
            actual_avg_row_bytes
use datafusion::execution::memory_pool::GreedyMemoryPool;
async fn budget_accuracy_aggregation_query() {
        let metrics: Vec<Option<f64>> = ids.iter().map(|i| Some(*i as f64 * 1.5)).collect();
#[tokio::test]
        .unwrap()
        "│ Row bytes ratio:         {:<38} │",
    );
            vec![
    println!(
        let file = std::fs::File::create(&path).unwrap();
    // After aggregation the OUTPUT batches are tiny (few rows). The formula
/// Core validation: run a query, measure actual memory per batch, compare to formula.
    let schema = create_parquet_data(tmp.path(), 50_000, 1);
    // Metadata-based estimate (measured from parquet column sizes)
    max_over_estimate_ratio: f64,
    let streams = execute_stream_partitioned(plan, ctx).unwrap();
    println!("┌─────────────────────────────────────────────────────────────────┐");
                    hosts
            "{} ({:.1} MB)",
                        .iter()
        .with_runtime_env(Arc::from(runtime_env))
            "{} ({:.1} MB)",
}
        );
    sql: &str,
        Field::new("ts", DataType::Int64, false),
    println!(
                0 => Some("us-east-1"),
    // is still conservative (≥ actual) even for narrow projections — it just
            ],
        .unwrap();
    println!("│ Total batches:           {:<38} │", actual_batches);
            static_phantom,
        )
fn create_parquet_data(dir: &std::path::Path, num_rows: usize, num_files: usize) -> Arc<Schema> {
/// than the static schema-based path by using actual column sizes from the
use datafusion_substrait::logical_plan::producer::to_substrait_plan;
}
        // Aggregation output is 4 rows × 3 cols — ratio to input estimate is enormous
}
    schema: &Arc<Schema>,
    for mut stream in streams {
    println!("│ STATIC vs METADATA-BASED BUDGET COMPARISON                      │");
        4,
    } else {
 *
use substrait::proto::Plan;
/// Validates that acquire_budget_from_metadata produces tighter estimates
        } else {
            "YES ✓"
    // Read parquet metadata from the first file
    let rows_per_file = num_rows / num_files;
        h.await.unwrap();
                Arc::new(StringArray::from(
//! bytes flowing through the pipeline" and compares against the formula's
    let schema = create_parquet_data(tmp.path(), 200_000, 8);
        // but that's correct: the formula budgets for scan, not for post-agg output.
    println!();
    println!("├────────────────── ACTUAL (measured) ────────────────────────────┤");
#[tokio::test]
        &schema,
    // both remain conservative relative to actual.
            "NO ✗ — OVER-ESTIMATE"
    // For schemas with only fixed-width columns, both would be identical.
        Field::new("metric", DataType::Float64, true),
use opensearch_datafusion::query_budget::{
            is_conservative,
        .unwrap();
        )
    let dir = format!("file://{}/", tmp.path().to_str().unwrap());
            predicted_avg_row_bytes, actual_avg_row_bytes
    drop(meta_budget);
        measure_actual_bytes(physical_plan, ctx.task_ctx()).await;
        .unwrap();
async fn measure_actual_bytes(
}
    } else {
        dir,
}
    acquire_budget, acquire_budget_from_metadata, estimate_avg_row_bytes,
            .map(|i| match i % 4 {
    let actual_avg_row_bytes = if actual_rows > 0 {
        )
};
        "│ Predicted batch bytes:   {:<38} │",
        if within_threshold {
    let dir = format!("file://{}/", tmp.path().to_str().unwrap());
    .await;
    println!("│ Query: {:<56} │", sql);
        format!("{:.2}x (predicted/actual)", row_bytes_ratio)
        as Arc<dyn datafusion::execution::memory_pool::MemoryPool>;
}
            .collect();
    );
        .with_listing_options(opts)
    println!("├────────────────── PREDICTED (formula) ──────────────────────────┤");
        let path = dir.join(format!("data_{}.parquet", file_idx));
        total_bytes.load(Ordering::Relaxed),
    }
        format!("{:.1}% tighter", reduction_pct)
 */
    println!("├────────────────── VALIDATION ───────────────────────────────────┤");
        writer.close().unwrap();
    let dir = format!("file://{}/", tmp.path().to_str().unwrap());
    let row_bytes_ratio = predicted_avg_row_bytes as f64 / actual_avg_row_bytes.max(1) as f64;
    let tmp = TempDir::new().unwrap();
        .with_collect_stat(true);
        .with_schema(schema);
    validate_budget_accuracy_inner(
    println!("└─────────────────────────────────────────────────────────────────┘");
    let schema = opts.infer_schema(&ctx.state(), &url).await.unwrap();
        }));
    let plan = ctx.sql(sql).await.unwrap().logical_plan().clone();
    let opts = ListingOptions::new(Arc::new(ParquetFormat::new()))
        let mut writer = ArrowWriter::try_new(file, schema.clone(), None).unwrap();
                let size = batch.get_array_memory_size();
        let hosts: Vec<Option<String>> = ids
            "Budget OVER-estimated by more than {:.0}x: predicted={}, actual={}. \
            actual_total_bytes as f64 / 1048576.0
//!
#[tokio::test]
    );
            "YES ✓"
        let timestamps: Vec<i64> = ids.iter().map(|i| 1700000000 + i).collect();
    target_partitions: usize,
        "│ Within {:.0}x (not wasteful):{:<37} │",
        )
        if meta_phantom < static_phantom {
        // Skip the ratio check entirely.
use datafusion::datasource::file_format::parquet::ParquetFormat;
                2 => Some("eu-west-1"),
    // output is legitimately tiny relative to scan estimates.
) -> (usize, usize, usize) {
        .unwrap();
        let start = file_idx * rows_per_file;
    let predicted_avg_row_bytes = estimate_avg_row_bytes(schema);
    println!(
        total_rows.load(Ordering::Relaxed),
        .with_file_extension(".parquet")
                1 => Some("us-west-2"),
                Arc::new(Float64Array::from(metrics)),
            actual_total_bytes,
    ctx.register_table("t", Arc::new(ListingTable::try_new(cfg).unwrap()))
}
        max_over_estimate_ratio,
        f64::MAX,
    // predicted >= actual for scan, and skip the over-estimate check since
        .find(|e| e.path().extension().map_or(false, |ext| ext == "parquet"))
//! prediction.
        max_over_estimate_ratio,
    let dir = format!("file://{}/", tmp.path().to_str().unwrap());
    let mut handles = Vec::new();
    sql: &str,
#[tokio::test]
    println!(
    // Assertions — only enforce when the output shape matches input (scan queries).
            format!("static is {:.1}% tighter (short strings)", -reduction_pct)
    );
        Field::new("region", DataType::Utf8, true),
    );
    println!(
    let mut config = SessionConfig::new();
        assert!(
    let pool = Arc::new(GreedyMemoryPool::new(1_000_000_000))
        "│ Difference:       {:<44} │",
        "│ Conservative (pred≥act): {:<38} │",
            "NO ✗ — UNDER-ESTIMATE"
                        .collect::<Vec<Option<&str>>>(),
    // For schemas with short strings (this test: "us-east-1", "host-0042"),
        "│ Phantom reservation:     {:<38} │",
        let total_bytes = total_bytes.clone();
 * this file be licensed under the Apache-2.0 license or a
    // The formula's "untracked per batch" = batch_size × predicted_avg_row_bytes
        target_partitions, batch_size
        schema,
            meta_phantom as f64 / 1048576.0
    let total_bytes = Arc::new(AtomicUsize::new(0));
    let runtime_env = RuntimeEnvBuilder::new()
    validate_budget_accuracy(&dir, &schema, "SELECT * FROM t", 4, 1024).await;
        .with_memory_pool(Arc::new(GreedyMemoryPool::new(1_000_000_000)))
    let static_phantom = static_budget.phantom_bytes;
                Arc::new(StringArray::from(regions)),
    let mut buf = Vec::new();
use futures::StreamExt;
    let num_partitions = plan.properties().output_partitioning().partition_count();
/// Inner implementation.
            budget.phantom_bytes,
use arrow_array::{Float64Array, Int64Array, RecordBatch, StringArray};
/// Build a substrait plan for the given SQL against the parquet directory.
        .partition_count();
        .filter_map(|e| e.ok())
    }
        8192,
                Arc::new(Int64Array::from(ids)),
    let schema = create_parquet_data(tmp.path(), 100_000, 4);
                _ => Some("ap-southeast-1"),
    let logical_plan = from_substrait_plan(&ctx.state(), &plan).await.unwrap();
        "│ Predicted avg row bytes: {:<38} │",
    println!(
    // Formula prediction
    let schema = create_parquet_data(tmp.path(), 50_000, 2);
            predicted_batch_bytes as f64 / 1024.0
        .await;
        Field::new("host", DataType::Utf8, true),
            .iter()
/// Core validation with configurable over-estimate threshold.
        actual_total_bytes / actual_batches
use datafusion_substrait::logical_plan::consumer::from_substrait_plan;
    );
    let reduction_pct = (1.0 - meta_phantom as f64 / static_phantom as f64) * 100.0;
        )
    // doesn't correspond to scan-level memory. The formula budgets for scan buffers,
) {
    // estimates INPUT/scan-level batch memory which is correct — the phantom
    let ctx = SessionContext::new_with_state(state);
    let url = ListingTableUrl::parse(dir).unwrap();
        .with_config(config)
    plan: Arc<dyn ExecutionPlan>,
            })
//! Source of truth: `RecordBatch::get_array_memory_size()` on every batch
    let (actual_total_bytes, actual_rows, actual_batches) =
    for h in handles {
    // intentionally budgets for scan-level buffers at full schema width.
    let meta_budget = acquire_budget_from_metadata(&pool, &schema, &metadata, 4, 8192).unwrap();
    let schema = Arc::new(Schema::new(vec![
    ]));
            "{} ({:.1} MB)",
        actual_total_bytes / actual_rows
//!
    // Aggregation queries produce tiny output (few rows with Arrow overhead) that
}
        )
        .output_partitioning()
        .with_collect_stat(true);
    let tmp = TempDir::new().unwrap();
        .with_file_extension(".parquet")
    )
            avg_batch_bytes,
        .build()
    let reader =
    };
    buf
        format!(
//! real parquet query execution through DataFusion.
    );
    let dir = format!("file://{}/", tmp.path().to_str().unwrap());
 * compatible open source license.
async fn validate_budget_accuracy_inner(
    let tmp = TempDir::new().unwrap();
    schema
    }
    let cfg = ListingTableConfig::new(url)
use std::sync::atomic::{AtomicUsize, Ordering};
    ctx: Arc<datafusion::execution::TaskContext>,
    // Both should produce a valid budget (positive phantom)
use datafusion::execution::context::SessionContext;
            max_over_estimate_ratio,
    let total_batches = Arc::new(AtomicUsize::new(0));
    let url = ListingTableUrl::parse(dir).unwrap();
    // metadata measures ~13 bytes/string vs static's 64 bytes — metadata is tighter.
    println!("│ Total rows:              {:<38} │", actual_rows);
    let actual_partitions = physical_plan
    let cfg = ListingTableConfig::new(url)
/*
                )),
    let dir = format!("file://{}/", tmp.path().to_str().unwrap());
    dir: &str,
}
    let tmp = TempDir::new().unwrap();
            static_phantom as f64 / 1048576.0
        )
/// parquet footer.
    let sub = to_substrait_plan(&plan, &ctx.state()).unwrap();
    );
            format!("metadata is {:.1}% tighter", reduction_pct)
    );
    // Projection reads only 2 columns. The formula uses the full schema unless
                Arc::new(Int64Array::from(timestamps)),
        .with_default_features()
    let metadata = reader.metadata().clone();
        handles.push(tokio::spawn(async move {
    )
use datafusion::prelude::*;
    let is_conservative = predicted_avg_row_bytes >= actual_avg_row_bytes;
}
    for file_idx in 0..num_files {
            "{} ({:.1} MB)",
    };
        "│ Avg batch bytes:         {:<38} │",
    let predicted_batch_bytes = batch_size * predicted_avg_row_bytes;
        }
    sub.encode(&mut buf).unwrap();
        let total_rows = total_rows.clone();
    let tmp = TempDir::new().unwrap();
        .properties()
    )
async fn build_substrait(dir: &str, sql: &str) -> Vec<u8> {
//! We also check that the formula isn't wildly over-conservative (within 3x).
            avg_batch_bytes as f64 / 1024.0
use prost::Message;
    // We just verify they produce different (potentially tighter) results and
use std::sync::Arc;
        } else {
#[tokio::test]
        if is_conservative {
    let dataframe = ctx.execute_logical_plan(logical_plan).await.unwrap();
    if max_over_estimate_ratio < f64::MAX {
    validate_budget_accuracy_relaxed(
        assert!(
    let dir = format!("file://{}/", tmp.path().to_str().unwrap());
        "│ Total bytes emitted:     {:<38} │",
    println!("┌─────────────────────────────────────────────────────────────────┐");
#[tokio::test]
    println!("│ Actual partitions used:  {:<38} │", actual_partitions);
                total_bytes.fetch_add(size, Ordering::Relaxed);
            .map(|i| Some(format!("host-{:04}", i % 100)))
async fn validate_budget_accuracy_relaxed(
    println!(
            while let Some(batch) = stream.next().await {
        format!(
            }
    let physical_plan = dataframe.create_physical_plan().await.unwrap();
    validate_budget_accuracy(&dir, &schema, "SELECT * FROM t", 4, 8192).await;
async fn budget_accuracy_metadata_based_is_tighter() {
        }
    validate_budget_accuracy(&dir, &schema, "SELECT * FROM t", 1, 8192).await;
    dir: &str,
    let first_file = std::fs::read_dir(tmp.path())
    max_over_estimate_ratio: f64,
    let budget = acquire_budget(&pool, schema, target_partitions, batch_size).unwrap();
    let schema = create_parquet_data(tmp.path(), 100_000, 4);
                let batch = batch.unwrap();
    );
    println!("│ Actual avg row bytes:    {:<38} │", actual_avg_row_bytes);
        &dir,
}
use tempfile::TempDir;
        .build();
            predicted_batch_bytes,
    let ctx = SessionContext::new();
    println!(
    use parquet::file::reader::{FileReader, SerializedFileReader};
async fn budget_accuracy_narrow_schema_projection() {
    );
    ListingOptions, ListingTable, ListingTableConfig, ListingTableUrl,
        let ids: Vec<i64> = (start..start + rows_per_file).map(|i| i as i64).collect();
        format!(
    sql: &str,
    assert!(meta_phantom > 0);
        format!(
) {
        "│ Static phantom:   {:<44} │",
                total_rows.fetch_add(batch.num_rows(), Ordering::Relaxed);
        target_partitions,
    );
        batch_size,
    validate_budget_accuracy(&dir, &schema, "SELECT * FROM t WHERE id > 50000", 8, 8192).await;
    let pool = Arc::new(GreedyMemoryPool::new(1_000_000_000))
    // not post-aggregation output.
    validate_budget_accuracy_inner(dir, schema, sql, target_partitions, batch_size, 3.0).await;
            "{} ({:.1} KB)",
    target_partitions: usize,
use datafusion::common::DataFusionError;
                total_batches.fetch_add(1, Ordering::Relaxed);
) {
    let static_budget = acquire_budget(&pool, &schema, 4, 8192).unwrap();
    let meta_phantom = meta_budget.phantom_bytes;
    println!("├─────────────────────────────────────────────────────────────────┤");
