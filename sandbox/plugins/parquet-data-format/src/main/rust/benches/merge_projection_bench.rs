            println!(
            .collect();
    let start = Instant::now();
                .collect();
                output.metadata.file_metadata().num_rows()
        }
            .unwrap_or("0")
            println!("│ {} ", label);
        input_paths.push(path_str);
        for col_idx in 0..num_string_cols {
            .parse()
    while rows_written < num_rows {
//! Measures memory and throughput for sorted merge with:
    println!("═══════════════════════════════════════════════════════════════");
    println!("═══════════════════════════════════════════════════════════════");
            println!("│ Elapsed:       {:.2?}", elapsed);
                })
                "│ Columns:       1 sort (Int64) + {} string ({}B each)",
use std::sync::Arc;
//!
        let mut columns: Vec<Arc<dyn arrow::array::Array>> = vec![Arc::new(ts_array)];
const ROWS_PER_FILE: usize = 100_000;
    for i in 0..NUM_FILES {
            );
    );
use std::fs;
            columns.push(Arc::new(StringArray::from(values)));
const STRING_VALUE_LEN: usize = 100;
        let ts_array = Int64Array::from(timestamps);
//!
            println!(
    // Approximate: read from /proc/self/statm on Linux, or use jemalloc stats
            println!("┌─────────────────────────────────────────────────────────────");
    let rows_per_sec = total_rows as f64 / elapsed.as_secs_f64();
use arrow::datatypes::{DataType, Field, Schema as ArrowSchema};
    }
        }
    println!(" Compares deferred (wide schema) vs eager (narrow schema)");
        generate_parquet_file(&path_str, ROWS_PER_FILE, num_string_cols, i);
                        width = STRING_VALUE_LEN
    }
        WIDE_STRING_COLUMNS,
            .unwrap_or(0);
    let mem_before = measure_resident_bytes();
                    "NO (eager)"
const NUM_FILES: usize = 5;
        (input_size as f64 / 1024.0 / 1024.0) / elapsed.as_secs_f64()
    let output_path = tmp_path.join("merged_output.parquet");
                "│ Deferred mode: {}",
//! Benchmark for merge cursor projection optimization.
    }
    let mem_delta_mb = (mem_after.saturating_sub(mem_before)) as f64 / 1024.0 / 1024.0;
//!
            println!(
const BATCH_SIZE: usize = 8192;
        0
    println!(" Expected results:");
    let file = fs::File::create(path).unwrap();
    }
            );
        &sort_columns,
    let props = WriterProperties::builder()
fn generate_parquet_file(path: &str, num_rows: usize, num_string_cols: usize, file_id: usize) {
            .iter()
    );
            println!("│ Batch size:    {}", BATCH_SIZE);
            println!("└─────────────────────────────────────────────────────────────");
//! Requires the crate to compile (including metrics.rs fix in CI).
                } else {
        Err(e) => {
            println!(
            println!(
        let pages: usize = statm
    writer.close().unwrap();
fn measure_resident_bytes() -> usize {
        let batch_len = batch_rows.min(num_rows - rows_written);
    let mb_per_sec = {
fn main() {
    // Generate input files
            println!("│ Output RGs:    {}", output.metadata.num_row_groups());
        let path = tmp_path.join(format!("input_{}.parquet", i));
    let mut input_paths = Vec::new();
            println!();
    let reverse_sorts = vec![false];
    let sort_columns = vec!["@timestamp".to_string()];
    println!(" Merge Projection Benchmark");
}
        let timestamps: Vec<i64> = (0..batch_len)
use arrow::array::{Int64Array, RecordBatch, StringArray};
//! - Wide schema (many string columns) → deferred mode should activate
        Ok(output) => {
    let schema = Arc::new(ArrowSchema::new(fields));
    // Run merge
        // String columns: random-ish values of fixed length
    // Narrow schema: should stay in eager mode (< 3 string non-sort columns)
        &reverse_sorts,
        NARROW_STRING_COLUMNS,
}
    println!();
    let output_str = output_path.to_str().unwrap();
        .build();
    }
        1, // output_writer_generation
    let nulls_first = vec![false];
    let mut fields = vec![Field::new("@timestamp", DataType::Int64, false)];
    let tmp_dir = tempfile::tempdir().unwrap();
                num_string_cols, STRING_VALUE_LEN
                    )
        &input_paths,
    match result {
    let elapsed = start.elapsed();
        let input_size: u64 = input_paths
const WIDE_STRING_COLUMNS: usize = 20;
    let mem_after = measure_resident_bytes();
    };
fn run_merge_bench(label: &str, num_string_cols: usize) {
        output_str,
        // Timestamps: sorted, unique per file with offset to ensure interleaving
                "│ Output rows:   {}",
    println!("═══════════════════════════════════════════════════════════════");
        // macOS: use mach APIs or approximate with allocated bytes
            .map(|i| ((rows_written + i) * NUM_FILES + file_id) as i64)
}
        }
    let total_rows = ROWS_PER_FILE * NUM_FILES;
            );
    let mut rows_written = 0;
        rows_written += batch_len;
            );
    let tmp_path = tmp_dir.path();
                }
//!   cargo bench --bench merge_projection_bench
    println!();
        fields.push(Field::new(format!("field_{}", i), DataType::Utf8, true));
    // Wide schema: should trigger deferred mode (≥3 string non-sort columns)
    let result = opensearch_parquet_format::merge::merge_sorted(
    );
                .map(|row| {
        .set_max_row_group_row_count(Some(num_rows))
            .map(|p| fs::metadata(p).map(|m| m.len()).unwrap_or(0))
    }
            let values: Vec<String> = (0..batch_len)
        &[],
    println!("═══════════════════════════════════════════════════════════════");
        &nulls_first,
                    format!(
        "WIDE SCHEMA (deferred mode — 20 string columns)",
        "bench_index",
            );
            println!("├─────────────────────────────────────────────────────────────");
        let batch = RecordBatch::try_new(schema.clone(), columns).unwrap();
//! Run:
    println!("   Wide:   Lower RSS, slightly lower throughput vs old code");
    for i in 0..num_string_cols {
                "│ Throughput:    {:.0} rows/sec, {:.1} MB/sec (input)",
    {
use std::time::Instant;
                rows_per_sec, mb_per_sec
        pages * 4096 // RSS in bytes (page size = 4KB)
                NUM_FILES, ROWS_PER_FILE, total_rows
            .nth(1)
    #[cfg(not(target_os = "linux"))]
//! - Narrow schema (few columns) → eager mode, no regression
            println!("│ {} FAILED: {:?}", label, e);
                    "YES (expected)"
    // Measure memory before
        writer.write(&batch).unwrap();
            .split_whitespace()
    let batch_rows = BATCH_SIZE.min(num_rows);
    run_merge_bench(
use parquet::file::properties::WriterProperties;
                "│ Files:         {} × {} rows = {} total rows",
    {
    #[cfg(target_os = "linux")]
        "NARROW SCHEMA (eager mode — 2 string columns)",
                        (rows_written + row) * 31 + col_idx * 7,
const NARROW_STRING_COLUMNS: usize = 2;
                        "{:0>width$}",
            println!("│ RSS delta:     {:.1} MB", mem_delta_mb);
        let path_str = path.to_str().unwrap().to_string();
    // Measure memory after (peak would require sampling during merge)
    println!("   Narrow: Same RSS & throughput as old code (no regression)");
        &[],
}
                if num_string_cols >= 3 {
use parquet::arrow::ArrowWriter;
    run_merge_bench(
            .sum();
    let mut writer = ArrowWriter::try_new(file, schema.clone(), Some(props)).unwrap();
        let statm = fs::read_to_string("/proc/self/statm").unwrap_or_default();
