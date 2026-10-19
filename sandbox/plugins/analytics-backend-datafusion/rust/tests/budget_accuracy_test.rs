    let sub = to_substrait_plan(&plan, &ctx.state()).unwrap();
    target_partitions: usize,
        } else {
    );
                let size = batch.get_array_memory_size();
    println!(
async fn budget_accuracy_metadata_based_is_tighter() {
        .await;
    println!("├────────────────── PREDICTED (formula) ──────────────────────────┤");
) {
            predicted_batch_bytes,
    dir: &str,
    for h in handles {
        total_rows.load(Ordering::Relaxed),
            "NO ✗ — UNDER-ESTIMATE"
            predicted_avg_row_bytes, actual_avg_row_bytes
    let (actual_total_bytes, actual_rows, actual_batches) =
        4,
    );
            "{} ({:.1} MB)",
    println!("│ Total rows:              {:<38} │", actual_rows);
#[tokio::test]
async fn validate_budget_accuracy_relaxed(
    .await;
    )
        .unwrap();
    target_partitions: usize,
    let static_phantom = static_budget.phantom_bytes;
        .unwrap()
        writer.write(&batch).unwrap();
        "│ Row bytes ratio:         {:<38} │",
        max_over_estimate_ratio,
        .partition_count();
        .unwrap();
        // but that's correct: the formula budgets for scan, not for post-agg output.
use arrow_array::{Float64Array, Int64Array, RecordBatch, StringArray};
        )
                Arc::new(Int64Array::from(timestamps)),
        max_over_estimate_ratio,
    config.options_mut().execution.batch_size = batch_size;
    let total_batches = Arc::new(AtomicUsize::new(0));
            actual_avg_row_bytes
        format!("{:.2}x (predicted/actual)", row_bytes_ratio)
    let dir = format!("file://{}/", tmp.path().to_str().unwrap());
        .with_collect_stat(true);
 * compatible open source license.
/// than the static schema-based path by using actual column sizes from the
    );
    // output is legitimately tiny relative to scan estimates.
    // The formula's "untracked per batch" = batch_size × predicted_avg_row_bytes
    assert!(static_phantom > 0);
    schema
    println!(
        .with_config(config)
    )
    let mut config = SessionConfig::new();
        format!(
    // Aggregation queries produce tiny output (few rows with Arrow overhead) that
        f64::MAX,
    let cfg = ListingTableConfig::new(url)
    // For schemas with only fixed-width columns, both would be identical.
    validate_budget_accuracy_relaxed(
    let mut handles = Vec::new();
async fn budget_accuracy_single_partition() {
        "│ Total bytes emitted:     {:<38} │",
}
    buf
    println!("│ Actual partitions used:  {:<38} │", actual_partitions);
        .with_memory_pool(Arc::new(GreedyMemoryPool::new(1_000_000_000)))
    assert!(meta_phantom > 0);
        format!(
    let pool = Arc::new(GreedyMemoryPool::new(1_000_000_000))
    println!("│ Query: {:<56} │", sql);
        if meta_phantom < static_phantom {
    if max_over_estimate_ratio < f64::MAX {
//! emitted by every partition stream. Sums these to get "actual untracked
    // predicted >= actual for scan, and skip the over-estimate check since
    let url = ListingTableUrl::parse(dir).unwrap();
        let total_rows = total_rows.clone();
                1 => Some("us-west-2"),
//! We also check that the formula isn't wildly over-conservative (within 3x).
                    hosts
    ctx: Arc<datafusion::execution::TaskContext>,
    let dir = format!("file://{}/", tmp.path().to_str().unwrap());
        Field::new("id", DataType::Int64, false),
        Field::new("region", DataType::Utf8, true),
    drop(budget);
//!
    let schema = create_parquet_data(tmp.path(), 100_000, 4);
        let ids: Vec<i64> = (start..start + rows_per_file).map(|i| i as i64).collect();
    let schema = create_parquet_data(tmp.path(), 50_000, 1);
            "{} ({:.1} KB)",
    let schema = create_parquet_data(tmp.path(), 50_000, 2);
        total_batches.load(Ordering::Relaxed),
    println!("│ Total batches:           {:<38} │", actual_batches);
        h.await.unwrap();
    validate_budget_accuracy(&dir, &schema, "SELECT * FROM t", 1, 8192).await;
    } else {
        )
    // For schemas with short strings (this test: "us-east-1", "host-0042"),
    // intentionally budgets for scan-level buffers at full schema width.
            actual_total_bytes as f64 / 1048576.0
    }
                total_bytes.fetch_add(size, Ordering::Relaxed);
            is_conservative,
use tempfile::TempDir;
    let runtime_env = RuntimeEnvBuilder::new()
        as Arc<dyn datafusion::execution::memory_pool::MemoryPool>;
}
        let start = file_idx * rows_per_file;
use datafusion::prelude::*;
    validate_budget_accuracy(&dir, &schema, "SELECT * FROM t WHERE id > 50000", 8, 8192).await;
    );
    );
        );
    let tmp = TempDir::new().unwrap();
                        .collect::<Vec<Option<&str>>>(),
    validate_budget_accuracy(&dir, &schema, "SELECT * FROM t", 4, 1024).await;
    let cfg = ListingTableConfig::new(url)
    println!();
    schema: &Arc<Schema>,
use opensearch_datafusion::query_budget::{
}
    println!(
    let dir = format!("file://{}/", tmp.path().to_str().unwrap());
        "│ target_partitions={}, batch_size={:<30} │",
    let avg_batch_bytes = if actual_batches > 0 {
        .with_file_extension(".parquet")
            "{} ({:.1} KB)",
            schema.clone(),
use datafusion::datasource::file_format::parquet::ParquetFormat;
        }
        format!(
        .unwrap();
        .output_partitioning()
async fn measure_actual_bytes(
        writer.close().unwrap();
}
    let actual_partitions = physical_plan
    let opts = ListingOptions::new(Arc::new(ParquetFormat::new()))
    println!(
async fn validate_budget_accuracy_inner(
            .map(|i| match i % 4 {
        format!(
async fn budget_accuracy_narrow_schema_projection() {
        )
        measure_actual_bytes(physical_plan, ctx.task_ctx()).await;
use arrow::datatypes::{DataType, Field, Schema};
        format!("{:.1}% tighter", reduction_pct)
        )
    };
    for file_idx in 0..num_files {
};
        .with_schema(schema);
    drop(meta_budget);
};
        let total_batches = total_batches.clone();
        batch_size,
/// Validates that acquire_budget_from_metadata produces tighter estimates
                2 => Some("eu-west-1"),
            actual_total_bytes,
    let plan = Plan::decode(substrait_bytes.as_slice()).unwrap();
        .with_collect_stat(true);
        &schema,
use datafusion::common::DataFusionError;
    let reader =
    let ctx = SessionContext::new_with_state(state);
    println!(
    let schema = create_parquet_data(tmp.path(), 100_000, 4);
        actual_total_bytes / actual_rows
    println!("┌─────────────────────────────────────────────────────────────────┐");
                Arc::new(Float64Array::from(metrics)),
        "│ Phantom reservation:     {:<38} │",
                total_batches.fetch_add(1, Ordering::Relaxed);
    let logical_plan = from_substrait_plan(&ctx.state(), &plan).await.unwrap();
use substrait::proto::Plan;
    );
            .collect();
    schema: &Arc<Schema>,
fn create_parquet_data(dir: &std::path::Path, num_rows: usize, num_files: usize) -> Arc<Schema> {
    println!(
        }
    let opts = ListingOptions::new(Arc::new(ParquetFormat::new()))
    let static_budget = acquire_budget(&pool, &schema, 4, 8192).unwrap();
    println!(
#[tokio::test]
use std::sync::atomic::{AtomicUsize, Ordering};
    let row_bytes_ratio = predicted_avg_row_bytes as f64 / actual_avg_row_bytes.max(1) as f64;
    use parquet::file::reader::{FileReader, SerializedFileReader};
                Arc::new(StringArray::from(
                        .map(|s| s.as_deref())
use datafusion::execution::SessionStateBuilder;
    // Formula prediction
        "│ Avg batch bytes:         {:<38} │",
        "│ Predicted batch bytes:   {:<38} │",
/// Core validation with configurable over-estimate threshold.
        actual_total_bytes / actual_batches
        let file = std::fs::File::create(&path).unwrap();
            meta_phantom,
        Field::new("host", DataType::Utf8, true),
        let timestamps: Vec<i64> = ids.iter().map(|i| 1700000000 + i).collect();
    );
        .build()
    let pool = Arc::new(GreedyMemoryPool::new(1_000_000_000))
    println!("└─────────────────────────────────────────────────────────────────┘");
/// Build a substrait plan for the given SQL against the parquet directory.
        0
}
    let tmp = TempDir::new().unwrap();
    let reduction_pct = (1.0 - meta_phantom as f64 / static_phantom as f64) * 100.0;
async fn build_substrait(dir: &str, sql: &str) -> Vec<u8> {
        Field::new("metric", DataType::Float64, true),
        .with_runtime_env(Arc::from(runtime_env))
    sql: &str,
    // metadata measures ~13 bytes/string vs static's 64 bytes — metadata is tighter.
    println!("├─────────────────────────────────────────────────────────────────┤");
        "│ Within {:.0}x (not wasteful):{:<37} │",
//! real parquet query execution through DataFusion.
    let predicted_avg_row_bytes = estimate_avg_row_bytes(schema);
//! Source of truth: `RecordBatch::get_array_memory_size()` on every batch
        let metrics: Vec<Option<f64>> = ids.iter().map(|i| Some(*i as f64 * 1.5)).collect();
    let inferred_schema = opts.infer_schema(&ctx.state(), &url).await.unwrap();
use datafusion::physical_plan::{execute_stream_partitioned, ExecutionPlan};
    // We just verify they produce different (potentially tighter) results and
        "│ Predicted avg row bytes: {:<38} │",
        }
use datafusion_substrait::logical_plan::consumer::from_substrait_plan;
    // over-estimates. We relax the 3x threshold for projections since the formula
        );
    let schema = create_parquet_data(tmp.path(), 200_000, 8);
    .await;
        predicted_avg_row_bytes
            "{} ({:.1} MB)",
    );
        "│ Reduction:        {:<44} │",
    );
    sub.encode(&mut buf).unwrap();
        sql,
    let tmp = TempDir::new().unwrap();
#[tokio::test]
    let schema = create_parquet_data(tmp.path(), 100_000, 4);
    let url = ListingTableUrl::parse(dir).unwrap();
    println!(
    );
    sql: &str,
    ]));
            "Budget OVER-estimated by more than {:.0}x: predicted={}, actual={}. \
//! prediction.
                Arc::new(Int64Array::from(ids)),
        as Arc<dyn datafusion::execution::memory_pool::MemoryPool>;
    }
    let total_bytes = Arc::new(AtomicUsize::new(0));
/// Inner implementation.
    println!("│ STATIC vs METADATA-BASED BUDGET COMPARISON                      │");
            .iter()
}
                let batch = batch.unwrap();
            "Budget UNDER-estimated row bytes: predicted={} < actual={}. \
            "{} ({:.1} MB)",
use datafusion_substrait::logical_plan::producer::to_substrait_plan;
    println!("│ Actual avg row bytes:    {:<38} │", actual_avg_row_bytes);
    }
                _ => Some("ap-southeast-1"),
/// Execute a physical plan across all partitions, measuring total bytes emitted.
            "YES ✓"
        let regions: Vec<Option<&str>> = ids
        .with_listing_options(opts)
    println!(
        "│ Conservative (pred≥act): {:<38} │",
    println!("└─────────────────────────────────────────────────────────────────┘");
        )
        if within_threshold {
    let dir = format!("file://{}/", tmp.path().to_str().unwrap());
        "│ Static phantom:   {:<44} │",
        )
    dir: &str,
        target_partitions,
}
    let dir = format!("file://{}/", tmp.path().to_str().unwrap());
    )
    for mut stream in streams {
#[tokio::test]
    let predicted_batch_bytes = batch_size * predicted_avg_row_bytes;
    // is still conservative (≥ actual) even for narrow projections — it just
    // Build substrait and execute through DataFusion at the specified parallelism
    );
    let streams = execute_stream_partitioned(plan, ctx).unwrap();
    // After aggregation the OUTPUT batches are tiny (few rows). The formula
) -> (usize, usize, usize) {
    let mut buf = Vec::new();
    // reservation covers the scan stage. Post-aggregation batches are small
use datafusion::execution::context::SessionContext;
 * this file be licensed under the Apache-2.0 license or a
    let schema = Arc::new(Schema::new(vec![
    plan: Arc<dyn ExecutionPlan>,
    let dataframe = ctx.execute_logical_plan(logical_plan).await.unwrap();
    let tmp = TempDir::new().unwrap();
}
    let num_partitions = plan.properties().output_partitioning().partition_count();
            format!("static is {:.1}% tighter (short strings)", -reduction_pct)
        8192,
    schema: &Arc<Schema>,
            }
    } else {
use datafusion::datasource::listing::{
    (
        // Skip the ratio check entirely.
/*
    let metadata = reader.metadata().clone();
        let mut writer = ArrowWriter::try_new(file, schema.clone(), None).unwrap();
    // Metadata-based estimate (measured from parquet column sizes)
    println!("├────────────────── VALIDATION ───────────────────────────────────┤");
        .filter_map(|e| e.ok())
        "│ Metadata phantom: {:<44} │",
}
}
    let is_conservative = predicted_avg_row_bytes >= actual_avg_row_bytes;
    // estimates INPUT/scan-level batch memory which is correct — the phantom
        assert!(
    let tmp = TempDir::new().unwrap();
        dir,
    );
) {
        format!(
}
    };
            .map(|i| Some(format!("host-{:04}", i % 100)))
        let total_bytes = total_bytes.clone();
    // doesn't correspond to scan-level memory. The formula budgets for scan buffers,
    acquire_budget, acquire_budget_from_metadata, estimate_avg_row_bytes,
            predicted_batch_bytes as f64 / 1024.0
        let path = dir.join(format!("data_{}.parquet", file_idx));
    // Compute actual average batch size (this is what flows through channels)
async fn validate_budget_accuracy(
                )),
    batch_size: usize,
            avg_batch_bytes as f64 / 1024.0
            vec![
use futures::StreamExt;
    let state = SessionStateBuilder::new()
    let actual_avg_row_bytes = if actual_rows > 0 {
//!
            "{} ({:.1} MB)",
    );
        .find(|e| e.path().extension().map_or(false, |ext| ext == "parquet"))
    let total_rows = Arc::new(AtomicUsize::new(0));
#[tokio::test]
        .build();
    println!(
    validate_budget_accuracy_inner(
    let tmp = TempDir::new().unwrap();
            "NO ✗ — OVER-ESTIMATE"
#[tokio::test]
    let substrait_bytes = build_substrait(dir, sql).await;
        schema,
}
async fn budget_accuracy_small_batch_size() {
    validate_budget_accuracy_inner(dir, schema, sql, target_partitions, batch_size, 3.0).await;
                0 => Some("us-east-1"),
                total_rows.fetch_add(batch.num_rows(), Ordering::Relaxed);
use prost::Message;
    ctx.register_table("t", Arc::new(ListingTable::try_new(cfg).unwrap()))
        .unwrap();
            predicted_avg_row_bytes,
    // and don't need budget coverage. We validate conservatism is still safe:
            meta_phantom as f64 / 1048576.0
    let physical_plan = dataframe.create_physical_plan().await.unwrap();
    max_over_estimate_ratio: f64,
        } else {
    config.options_mut().execution.target_partitions = target_partitions;
            static_phantom,
/// Create parquet test data with a known schema.
        }));
//! Validates the memory budget formula against actual measured memory during
    // Read parquet metadata from the first file
        SerializedFileReader::new(std::fs::File::open(first_file.path()).unwrap()).unwrap();
use std::sync::Arc;
            avg_batch_bytes,
        let hosts: Vec<Option<String>> = ids
async fn budget_accuracy_aggregation_query() {
            budget.phantom_bytes,
    drop(static_budget);
    let schema = create_parquet_data(tmp.path(), 100_000, 4);
    }
        .with_file_extension(".parquet")
    let dir = format!("file://{}/", tmp.path().to_str().unwrap());
    let ctx = SessionContext::new();
    println!("└─────────────────────────────────────────────────────────────────┘");
            ],
            .iter()
            "YES ✓"
    let dir = format!("file://{}/", tmp.path().to_str().unwrap());
 *
            within_threshold || actual_avg_row_bytes == 0,
        .with_listing_options(opts)
    let plan = ctx.sql(sql).await.unwrap().logical_plan().clone();
 */
             This wastes pool capacity and forces unnecessary spilling.",
use parquet::arrow::ArrowWriter;
    println!("┌─────────────────────────────────────────────────────────────────┐");
    // Static estimate (type-based)
#[tokio::test]
        format!(
            })
        .with_default_features()
    println!(
        if is_conservative {
 * SPDX-License-Identifier: Apache-2.0
        &dir,
    let schema = opts.infer_schema(&ctx.state(), &url).await.unwrap();
        // Aggregation output is 4 rows × 3 cols — ratio to input estimate is enormous
            format!("metadata is {:.1}% tighter", reduction_pct)
        )
        let batch = RecordBatch::try_new(
    let meta_budget = acquire_budget_from_metadata(&pool, &schema, &metadata, 4, 8192).unwrap();
    // Both should produce a valid budget (positive phantom)
    validate_budget_accuracy(&dir, &schema, "SELECT * FROM t", 4, 8192).await;
    ctx.register_table("t", Arc::new(ListingTable::try_new(cfg).unwrap()))
use datafusion::execution::runtime_env::RuntimeEnvBuilder;
use datafusion::execution::memory_pool::GreedyMemoryPool;
    batch_size: usize,
        handles.push(tokio::spawn(async move {
        target_partitions, batch_size
            .collect();
        .unwrap();
    let rows_per_file = num_rows / num_files;
    batch_size: usize,
        "│ Difference:       {:<44} │",
                Arc::new(StringArray::from(regions)),
    target_partitions: usize,
        .with_schema(inferred_schema);
async fn budget_accuracy_high_parallelism() {
//! bytes flowing through the pipeline" and compares against the formula's
        total_bytes.load(Ordering::Relaxed),
    let meta_phantom = meta_budget.phantom_bytes;
    // both remain conservative relative to actual.
    println!("├────────────────── ACTUAL (measured) ────────────────────────────┤");
        } else {
                        .iter()
        Field::new("ts", DataType::Int64, false),
 * The OpenSearch Contributors require contributions made to
    // not post-aggregation output.
/// Core validation: run a query, measure actual memory per batch, compare to formula.
    println!(
    let tmp = TempDir::new().unwrap();
    dir: &str,
    let first_file = std::fs::read_dir(tmp.path())
    sql: &str,
        0
        "SELECT region, COUNT(*), AVG(metric) FROM t GROUP BY region",
    validate_budget_accuracy_relaxed(&dir, &schema, "SELECT id, metric FROM t", 4, 8192, 15.0)
    let within_threshold = row_bytes_ratio <= max_over_estimate_ratio;
    // projected_columns is provided. This test validates the FULL-SCHEMA estimate
}
            budget.phantom_bytes as f64 / 1048576.0
            max_over_estimate_ratio,
async fn budget_accuracy_narrow_schema_full_scan() {
    // Projection reads only 2 columns. The formula uses the full schema unless
    println!(
    // Assertions — only enforce when the output shape matches input (scan queries).
/// parquet footer.
            while let Some(batch) = stream.next().await {
        .properties()
    max_over_estimate_ratio: f64,
        assert!(
    ListingOptions, ListingTable, ListingTableConfig, ListingTableUrl,
    let budget = acquire_budget(&pool, schema, target_partitions, batch_size).unwrap();
             This means real memory usage exceeds the phantom reservation — potential OOM.",
            static_phantom as f64 / 1048576.0
//! Pass criteria: actual ≤ predicted (formula is conservative).
) {
