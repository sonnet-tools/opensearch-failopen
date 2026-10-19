    // Measure memory after (peak would require sampling during merge)
                NUM_FILES, ROWS_PER_FILE, total_rows
                "│ Deferred mode: {}",
    let total_rows = ROWS_PER_FILE * NUM_FILES;
    println!("═══════════════════════════════════════════════════════════════");
            .parse()
            println!(
        Err(e) => {
        for col_idx in 0..num_string_cols {
use arrow::datatypes::{DataType, Field, Schema as ArrowSchema};
            columns.push(Arc::new(StringArray::from(values)));
const NARROW_STRING_COLUMNS: usize = 2;
        let batch_len = batch_rows.min(num_rows - rows_written);
                .collect();
                    )
                } else {
    {
//! Measures memory and throughput for sorted merge with:
            .split_whitespace()
    // Generate input files
}
            .sum();
    // Run merge
    let file = fs::File::create(path).unwrap();
const ROWS_PER_FILE: usize = 100_000;
use arrow::array::{Int64Array, RecordBatch, StringArray};
    // Wide schema: should trigger deferred mode (≥3 string non-sort columns)
use std::sync::Arc;
        (input_size as f64 / 1024.0 / 1024.0) / elapsed.as_secs_f64()
    }
            let values: Vec<String> = (0..batch_len)
            println!(
                if num_string_cols >= 3 {
        rows_written += batch_len;
use std::time::Instant;
const BATCH_SIZE: usize = 8192;
            .unwrap_or(0);
            );
            .collect();
    #[cfg(not(target_os = "linux"))]
            println!("│ {} FAILED: {:?}", label, e);
    let output_path = tmp_path.join("merged_output.parquet");
        Ok(output) => {
        }
        .build();
use parquet::file::properties::WriterProperties;
}
    let mb_per_sec = {
                    "NO (eager)"
const NUM_FILES: usize = 5;
    println!("═══════════════════════════════════════════════════════════════");
    match result {
//!
                })
    let start = Instant::now();
    let reverse_sorts = vec![false];
        let mut columns: Vec<Arc<dyn arrow::array::Array>> = vec![Arc::new(ts_array)];
    let props = WriterProperties::builder()
    let output_str = output_path.to_str().unwrap();
                output.metadata.file_metadata().num_rows()
        // macOS: use mach APIs or approximate with allocated bytes
    println!(" Compares deferred (wide schema) vs eager (narrow schema)");
//! Benchmark for merge cursor projection optimization.
        }
const STRING_VALUE_LEN: usize = 100;
                "│ Columns:       1 sort (Int64) + {} string ({}B each)",
            );
//! Requires the crate to compile (including metrics.rs fix in CI).
    run_merge_bench(
                    format!(
    );
}
    }
        &[],
    let rows_per_sec = total_rows as f64 / elapsed.as_secs_f64();
            println!("│ Output RGs:    {}", output.metadata.num_row_groups());
            .map(|p| fs::metadata(p).map(|m| m.len()).unwrap_or(0))
//!
        // Timestamps: sorted, unique per file with offset to ensure interleaving
        fields.push(Field::new(format!("field_{}", i), DataType::Utf8, true));
    // Measure memory before
        let pages: usize = statm
            .nth(1)
            println!();
        writer.write(&batch).unwrap();
        generate_parquet_file(&path_str, ROWS_PER_FILE, num_string_cols, i);
fn measure_resident_bytes() -> usize {
    }
                }
//!   cargo bench --bench merge_projection_bench
    let mut rows_written = 0;
        1, // output_writer_generation
    let sort_columns = vec!["@timestamp".to_string()];
            println!("├─────────────────────────────────────────────────────────────");
    let nulls_first = vec![false];
        let batch = RecordBatch::try_new(schema.clone(), columns).unwrap();
                rows_per_sec, mb_per_sec
fn run_merge_bench(label: &str, num_string_cols: usize) {
                    "YES (expected)"
                num_string_cols, STRING_VALUE_LEN
                "│ Throughput:    {:.0} rows/sec, {:.1} MB/sec (input)",
            println!("└─────────────────────────────────────────────────────────────");
    let mem_after = measure_resident_bytes();
    println!("═══════════════════════════════════════════════════════════════");
    );
    let tmp_path = tmp_dir.path();
        let timestamps: Vec<i64> = (0..batch_len)
            );
        let statm = fs::read_to_string("/proc/self/statm").unwrap_or_default();
//!
            println!("│ Batch size:    {}", BATCH_SIZE);
    let batch_rows = BATCH_SIZE.min(num_rows);
const WIDE_STRING_COLUMNS: usize = 20;
    };
    println!("═══════════════════════════════════════════════════════════════");
        0
    let tmp_dir = tempfile::tempdir().unwrap();
fn generate_parquet_file(path: &str, num_rows: usize, num_string_cols: usize, file_id: usize) {
    println!("   Narrow: Same RSS & throughput as old code (no regression)");
    // Narrow schema: should stay in eager mode (< 3 string non-sort columns)
            .map(|i| ((rows_written + i) * NUM_FILES + file_id) as i64)
                        "{:0>width$}",
        .set_max_row_group_row_count(Some(num_rows))
        WIDE_STRING_COLUMNS,
        let ts_array = Int64Array::from(timestamps);
use parquet::arrow::ArrowWriter;
    writer.close().unwrap();
        "NARROW SCHEMA (eager mode — 2 string columns)",
    }
            println!(
                        (rows_written + row) * 31 + col_idx * 7,
//! Run:
        NARROW_STRING_COLUMNS,
    );
            println!("┌─────────────────────────────────────────────────────────────");
        let path_str = path.to_str().unwrap().to_string();
                .map(|row| {
        &reverse_sorts,
//! - Narrow schema (few columns) → eager mode, no regression
    #[cfg(target_os = "linux")]
    let mem_before = measure_resident_bytes();
                "│ Files:         {} × {} rows = {} total rows",
        }
        &input_paths,
    let mut input_paths = Vec::new();
            println!("│ {} ", label);
    println!("   Wide:   Lower RSS, slightly lower throughput vs old code");
                        width = STRING_VALUE_LEN
    println!(" Merge Projection Benchmark");
        output_str,
            );
    let result = opensearch_parquet_format::merge::merge_sorted(
    // Approximate: read from /proc/self/statm on Linux, or use jemalloc stats
        "WIDE SCHEMA (deferred mode — 20 string columns)",
        &[],
        "bench_index",
            .unwrap_or("0")
    println!();
    let elapsed = start.elapsed();
            .iter()
//! - Wide schema (many string columns) → deferred mode should activate
    {
        pages * 4096 // RSS in bytes (page size = 4KB)
        &sort_columns,
            );
    let schema = Arc::new(ArrowSchema::new(fields));
    while rows_written < num_rows {
    println!(" Expected results:");
            println!("│ RSS delta:     {:.1} MB", mem_delta_mb);
    run_merge_bench(
        let path = tmp_path.join(format!("input_{}.parquet", i));
            println!("│ Elapsed:       {:.2?}", elapsed);
    let mem_delta_mb = (mem_after.saturating_sub(mem_before)) as f64 / 1024.0 / 1024.0;
            println!(
    let mut writer = ArrowWriter::try_new(file, schema.clone(), Some(props)).unwrap();
        &nulls_first,
        let input_size: u64 = input_paths
    }
        input_paths.push(path_str);
            println!(
    }
    let mut fields = vec![Field::new("@timestamp", DataType::Int64, false)];
        // String columns: random-ish values of fixed length
                "│ Output rows:   {}",
    println!();
    for i in 0..num_string_cols {
    for i in 0..NUM_FILES {
}
use std::fs;
fn main() {
