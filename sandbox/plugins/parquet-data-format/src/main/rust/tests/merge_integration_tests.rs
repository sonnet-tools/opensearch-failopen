            vec![
                "A1", "A2", "A3", "A10", "A11", "A12",
    let small: i64 = 200_000;
            vals.push(arr.value(i));
                Some(arr.value(i))
#[test]
    write_parquet(&file_b, &batch_b);
    .unwrap();
/// Read all Int64 values from a column.
            merge_batch_size: Some(batch_size),
    ]));
        .map(|i| {
}
    }
        .path()
            .as_any()
        .chain(b_vals.iter())
        vec![
/// correct RG splits with exact values.
    .unwrap();
    // "extra" in files 2 and 3
    let mut vals = Vec::new();
    // RG0 flushes after 10 batches = 1_000_010 rows (overshoots by 10)
            schema.clone(),
    );
/// Three files where the middle file exhausts first, forcing a TIER 1
        RG_MAX,
    //
        )
    );
        index_eager,
        vec![
#[test]
    let a_vals: Vec<i64> = (0..a_count).map(|i| i * 3).collect();
        schema.clone(),
    let file_a = tmp.path().join("a.parquet").to_string_lossy().to_string();
        &[false],
    register_deferred_settings(index, 3, 0); // threshold=0 → always deferred
    let batch_a = RecordBatch::try_new(
    // After TIER 2 drains A batch 0 [1,2], A loads batch 1 starting at 5.
    let batch_a = RecordBatch::try_new(
    assert!(rg_lasts.iter().all(|v| *v == Some(42)));
    )
    let index = "test_deferred_three_files_different_schemas";
    let file_a = tmp.path().join("a.parquet").to_string_lossy().to_string();
        &[],
        ],
    )
#[test]
    // RG1 = rows 1_000_000..1_399_999 → values 1_000_000..1_399_999
                )
            );
    .unwrap();
    let c_vals = read_all_strings(&output, "col_c");
        assert_eq!(*v, Some(i as i64), "wrong value at row {}", i);
        0,
    let file_a = tmp.path().join("a.parquet").to_string_lossy().to_string();
    let builder = ParquetRecordBatchReaderBuilder::try_new(file).unwrap();
            .column(idx)
    let file_a = tmp.path().join("a.parquet").to_string_lossy().to_string();
    let batch_b = RecordBatch::try_new(
        &[false],
use arrow::array::*;
    let output = tmp
        .path()
        .join("merged.parquet")
        &[],
            .column(idx)
/// Verifies TIER 1 drain handles multiple batch boundaries and produces
    .unwrap();
    merge_sorted(
            schema.clone(),
            .as_any()
        index,
    )
 *
    let files = list_parquet_files(&input_dir);
    )
    let output_deferred = tmp
        .to_string_lossy()
    assert_eq!(
        .to_string();
    let mut expected: Vec<i64> = a_vals.iter().chain(b_vals.iter()).copied().collect();
        &RecordBatch::try_new(schema.clone(), vec![Arc::new(Int64Array::from(vals))]).unwrap(),
/// Deferred mode with TIER 3 (partial batch emit) — verifies data reader
        &[],
    if !Path::new(&input_dir).exists() {
        &[],
            schema.clone(),
    let batch_b = RecordBatch::try_new(
        let batch = batch.unwrap();
        schema.clone(),
fn test_non_multiple_of_batch_size() {
        out_of_order
    merge_sorted(
        eprintln!("Skipping: PARQUET_TEST_INPUT_DIR not set");
    // File A: [1, 2, 20, 21] with batch_size=2 → cursor batches [1,2] and [20,21]
        &[],
    .into_iter()
    );
/// 150_001 + 149_999 = 300_000 rows. Verifies no off-by-one at batch boundaries.
    files.sort();
fn test_three_files_middle_exhausts_first() {
    // RG1 =   400_000 rows: remaining non-nulls (300_000..699_999)
                None
    assert_eq!(out_vals.len() as i64, total);
}
        &[false],
 * The OpenSearch Contributors require contributions made to
    let ts_vals = read_all_int64(&output, "ts");
        &[],
        let arr = batch
    for (i, (got, exp)) in out_vals.iter().zip(expected.iter()).enumerate() {
        .join("merged.parquet")
        &["ts".into()],
fn write_parquet(path: &str, batch: &RecordBatch) {
    let total_nulls = half * 2; // 700_000
    )
        &RecordBatch::try_new(schema.clone(), vec![Arc::new(Int64Array::from(a_vals))]).unwrap(),
        &[false],
    );
        ],
    .unwrap();
    assert!(!files.is_empty(), "No parquet files found in {}", input_dir);
    write_parquet(&file_2, &batch_2);
fn input_dir() -> Option<String> {
        .map(|_| None)
        &[false],
        Field::new("ts", DataType::Int64, false),
 */
                None
    let output = tmp.path().join("out.parquet").to_string_lossy().to_string();
    merge_sorted(
    );
        0,
    )
    write_parquet(
    register_deferred_settings(index, 2, 0); // batch_size=2
    }
        .join("merged.parquet")
        .collect();
        "Verified EventDate sort order across {} non-null rows",
        &[],
    write_parquet(&file_a, &batch_a);
            Some(i as i64),
    let mut firsts = Vec::new();
        RecordBatch::try_new(
    );
    let b_count: i64 = 149_999;
    merge_sorted(
        0,
        &output,
    let output = tmp
    let schema = Arc::new(Schema::new(vec![Field::new("v", DataType::Int64, false)]));
        &[],
// ─── Large-file edge case tests ───────────────────────────────────────────────────
    write_parquet(&file_a, &batch_a);
        Field::new("tag", DataType::Utf8, false),
        &[],
            Arc::new(Int64Array::from(vec![2, 4, 6])),
        ],
        )
    let schema = Arc::new(Schema::new(vec![Field::new("v", DataType::Int64, false)]));
    assert_eq!(rg_sizes[0], RG_MAX);
        &[],
            ])),
        &[file_a],
    let output = tmp.path().join("out.parquet").to_string_lossy().to_string();
    merge_sorted(
        .unwrap();
    assert_eq!(rg_lasts[1], Some(total_nonnulls - 1), "RG1 last value");
        &[],
    let b_vals: Vec<i64> = (0..small).map(|i| i * 2 + 1).collect();
    register_deferred_settings(index, 3, 0);
        }
        index,
        &[false],
    // File A: [1,2,5,6] → batches [1,2] and [5,6]
        })
        schema_3.clone(),
    write_parquet(&file_b, &batch_b);
        ],
        let arr = batch
/// Write a single RecordBatch to a Parquet file.
    let expected_rows = count_rows_in_files(&files);
        .to_string_lossy()
        &[false],
    let batch_a = RecordBatch::try_new(
        .join("merged.parquet")
        .to_string_lossy()
    let reverse = vec![false];
        index,
                &p,
        "RG0 size should be {} (overshoots RG_MAX={} by {}), got {}.",
    assert_eq!(b_vals, vec!["b1", "b2", "b3", "b4", "b5", "b6"]);
        vec![
            Arc::new(StringArray::from(vec![Some("NYC"), Some("LA")])),
        index,
        .join("merged.parquet")
    // Each RG should be exactly 10 * batch_size = 1_000_010 (overshoots RG_MAX by 10)
    );
        let batch = batch.unwrap();
use tempfile::tempdir;
        Field::new("msg", DataType::Utf8, false),
    let large: i64 = 1_200_000;
    // half = 350_000, so:
/// are correctly written despite being loaded lazily.
    );
    for batch in reader {
        &[false],
    })
                .unwrap(),
        .to_string_lossy()
}
    let index = "test_tier2_yield_multiple_cursors";
    write_parquet(&file_b, &batch_b);
    let batch_b = RecordBatch::try_new(
        .join("merged.parquet")
            assert!(!col.is_null(i), "__row_id__ should never be null");
        let batch = batch.unwrap();
        Field::new("src", DataType::Utf8, false),
    write_parquet(&file_a, &batch_a);
    // Batch [1,2,3] from A fits entirely before heap top (B=5) → TIER 2 emits all 3
    let file_b = tmp.path().join("b.parquet").to_string_lossy().to_string();
    let nulls_first = vec![false];
            Arc::new(StringArray::from(vec!["b2", "b3", "b4", "b5", "b6", "b7"])),
    // File C: [2, 5, 8, ..., 299_999]  (100_000 values, step 3)
/// current position, so A must yield to the heap.
}
            Arc::new(Int64Array::from(vec![2, 3, 4, 5, 6, 7])),
fn test_deferred_vs_eager_identical_output() {
        &file_b,
            Arc::new(StringArray::from(vec!["x", "x", "x", "x", "x"])),
        .unwrap(),
    // File A: [1, 2, 3, 10, 11, 12] with batch_size=3 → cursor batches [1,2,3] then [10,11,12]
    let file_a = tmp.path().join("a.parquet").to_string_lossy().to_string();
    // Remaining rows must be exactly 0, 1, 2, ..., total_nonnulls-1
        index_name.to_string(),
        Field::new("ts", DataType::Int64, false),
        .to_string();
    .unwrap();
        .to_string_lossy()
/// multiple internal batches — verifies data reader advances across batch
                && !p.file_name()?.to_str()?.starts_with("merged")
    verify_row_id_order(&output_str);
        expected_rg_size - RG_MAX,
    )
        schema.clone(),
    .unwrap();
    )
        schema.clone(),
fn test_single_large_file_passthrough() {
    let index_eager = "test_deferred_vs_eager_eager";
        .join("merged.parquet")
    // File B: [3,4,7,8] → batches [3,4] and [7,8]
    let batch_b = RecordBatch::try_new(
    write_parquet(&file_b, &batch_b);
    .unwrap();
}
        .unwrap();
    let output = tmp
        for i in 0..arr.len() {
    write_parquet(&file_b, &batch_b);
        &file_b,
        &["ts".into()],
            .path()
            .as_any()
    let ts_vals = read_all_int64(&output, "ts");
        .to_string_lossy()
        Field::new("ts", DataType::Int64, false),
    let file = File::open(&output).unwrap();
    // After TIER 2 drains A batch 0 [12,11,10], A loads batch 1 starting at 3.
        index,
        rg_sizes[0]
    let reader = builder.build().unwrap();
    let schema = Arc::new(Schema::new(vec![Field::new("v", DataType::Int64, false)]));
    let s1_d = read_all_strings(&output_deferred, "s1");
 * this file be licensed under the Apache-2.0 license or a
/// Threshold set very high → forces eager mode even with many string columns.
    let file_a = tmp.path().join("a.parquet").to_string_lossy().to_string();
    println!("Found {} input files", files.len());
    assert_eq!(rg_sizes[1], total - RG_MAX);
// ═══════════════════════════════════════════════════════════════════════════════
        &["v".into()],
        index_name.to_string(),
        )
        "test_non_multiple_batch",
    let schema = Arc::new(Schema::new(vec![Field::new("v", DataType::Int64, false)]));
        &[false],
    assert_eq!(rg_firsts[0], None, "RG0 should start with null");
    .unwrap();
        &RecordBatch::try_new(schema.clone(), vec![Arc::new(Int64Array::from(a_vals))]).unwrap(),
    let batch_b = RecordBatch::try_new(
        &RecordBatch::try_new(schema.clone(), vec![Arc::new(Int64Array::from(b_vals))]).unwrap(),
        &[file_a, file_b],
    let a_vals: Vec<i64> = (0..ROWS_PER_FILE).rev().map(|i| i * 2).collect();
    expected.sort();
    )
    // File B: [2, 4, 6, 8] — single batch
        schema_a.clone(),
/// Heavily skewed file sizes: file A has 1.2M rows, file B has 200K rows.
        &[false],
    let schema = Arc::new(Schema::new(vec![Field::new("v", DataType::Int64, false)]));
}
    let file_a = tmp.path().join("a.parquet").to_string_lossy().to_string();
    SETTINGS_STORE.insert(
    // Descending: RG0 starts at max, ends at total-RG_MAX; RG1 starts one below that
        &["v".into()],
            vec![Arc::new(Int64Array::from(b_vals.clone()))],
    // Expected: 1,2,3,4,10,11,12,20,21,30,31
        .to_string();
#[test]
        index,
}
        let idx = batch.schema().index_of("col_d").unwrap();
    let tmp = tempdir().unwrap();
    let output = tmp
    }
    write_parquet(&file_a, &batch_a);
    )
    let file_b = tmp.path().join("b.parquet").to_string_lossy().to_string();
            .column(idx)
        &files,
    // Use a batch_size that doesn't divide evenly into RG_MAX
    let ts_vals = read_all_int64(&output, "ts");
        &["ts".into()],
/// Returns (row_group_sizes, per_rg_first_value, per_rg_last_value) for a nullable Int64 column.
/// Verify behavior is identical to deferred (output correctness).
        &[false],
        &RecordBatch::try_new(schema.clone(), vec![Arc::new(Int64Array::from(b_vals))]).unwrap(),
        &["v".into()],
        0,
    let file_b = tmp.path().join("b.parquet").to_string_lossy().to_string();
        &file_a,
                    vec![Arc::new(Int64Array::from(vals.clone()))],
    // RG0 = rows 0..999_999  → values 0..999_999
        tag_vals,
    )
}
        &output,
}
#[test]
        vec![
    );
    let mut col_a_nulls = Vec::new();
    )
}
    let reader = ParquetRecordBatchReaderBuilder::try_new(file)
        .unwrap()
        src_vals,
            Arc::new(StringArray::from(vec![Some("bob"), Some("eve")])),
        &[file_a, file_b],
        .build()
        &[file_a, file_b],
    )
        schema.clone(),
    let mut vals = Vec::new();
    let file = File::open(&output).unwrap();
    };
            Arc::new(Int64Array::from(vec![3, 4, 7, 8])),
    assert_eq!(vals.len() as i64, total);
/// TIER 3 deferred with many cursors — stress test for data reader sync
        .build()
        .to_string();
        &[false],
            .as_any()
    let a_vals: Vec<i64> = (0..ROWS_PER_FILE).map(|i| i * 2).collect();
    let output = tmp.path().join("out.parquet").to_string_lossy().to_string();
    .unwrap();
    let file_b = tmp.path().join("b.parquet").to_string_lossy().to_string();
                    }
        &[file_a, file_b],
/// RG0 will be 1_000_010, not exactly 1_000_000.
    let b_vals: Vec<i64> = (0..b_count).map(|i| i * 3 + 1).collect();
    write_parquet(&file_b, &batch_b);
    let file_b = tmp.path().join("b.parquet").to_string_lossy().to_string();
    // First total_nulls rows must all be None
            Arc::new(StringArray::from(vec!["b", "b", "b", "b", "b"])),
    let b_vals: Vec<i64> = (0..ROWS_PER_FILE).rev().map(|i| i * 2 + 1).collect();
        &output,
        .to_string();
        schema.clone(),
        0,
    };
    let tmp = tempdir().unwrap();
    write_parquet(&file_c, &batch_c);
        &[],
    let c_vals: Vec<i64> = (0..c_count).map(|i| i * 3 + 2).collect();
    assert_eq!(rg_sizes[0], RG_MAX);
    let vals = read_col_i64(&output, "v");
        &["ts".into()],
    let file_c = tmp.path().join("c.parquet").to_string_lossy().to_string();
        ],
    assert_eq!(vals, vec![1, 2, 3, 4, 10, 11, 12, 20, 21, 30, 31]);
    // heap_top from B is 7. In descending, 3 < 7 means A should yield.
        Field::new("payload", DataType::Utf8, false),
        expected_rg_size,
        0,
        .chain((0..half).map(|i| Some(i * 2 + 1)))
    )
    // Merged descending: 1_399_999, 1_399_998, ..., 1, 0
    assert!(output.exists(), "Output file was not created");
        eprintln!("Skipping: {} not found", input_dir);
        }
            Arc::new(Int64Array::from(vec![2, 5])),
    let output = tmp
    let mut out_of_order: i64 = 0;
        .path()
    let index = "test_tier2_yield_descending";
    let val_vals = read_all_strings(&output, "val");
        Field::new("col_a", DataType::Utf8, false),
        0,
    let batch_b = RecordBatch::try_new(
        .unwrap();
    let output = tmp
    let output = tmp
    }
        &[],
    );
        Field::new("info", DataType::Utf8, false),
            Arc::new(StringArray::from(vec!["t3", "t4", "t5", "t6", "t7", "t8"])),
    let sort_cols = vec!["EventDate".to_string()];
    write_parquet(&file_b, &batch_b);
    for batch in reader {
        vec![
    .unwrap();
    let mut expected: Vec<i64> = a_vals
    ]));
    let schema = Arc::new(Schema::new(vec![Field::new("v", DataType::Int64, false)]));
}
        for i in 0..arr.len() {
    let file = File::open(&output_str).unwrap();
    }
        &[],
    // ── Row group structure ──────────────────────────────────────────────
        &[file_a, file_b],
    )
    // File A: [0, 3, 6, ..., 299_997]  (100_000 values, step 3)
    let index = "test_tier2_yield_after_batch_boundary";
        &output_str,
            .as_primitive::<arrow::datatypes::Int64Type>();
        let batch = batch.unwrap();
    // File A: [1, 3, 5, 7] — single batch
        .sum()
fn test_sorted_merge_real_files() {
    assert_eq!(col_d_vals, vec!["NULL", "d2", "NULL", "d4", "NULL", "d6"]);
        ],
    let mut expected: Vec<i64> = a_vals.iter().chain(b_vals.iter()).copied().collect();
        ],
    let file_b = tmp.path().join("b.parquet").to_string_lossy().to_string();
        .unwrap()
    // "name" in files 1 and 2 only
    let reader = SerializedFileReader::new(File::open(path).unwrap()).unwrap();
    // File A: [1,2, 11,12, 21,22, 31,32, 41,42] with batch_size=2
}
        Field::new("ts", DataType::Int64, false),
        &[],
/// Helper: read all String values from a column.
    ]));
            Arc::new(StringArray::from(vec!["b2", "b4", "b6"])),
        NativeSettings {
 * compatible open source license.
            }
    merge_sorted(
    // File B: odds  descending  [(ROWS_PER_FILE-1)*2+1, ..., 3, 1]
    )
    let output = tmp
    let builder = ParquetRecordBatchReaderBuilder::try_new(file).unwrap();
/// missing in some files are padded with nulls and the deferred data reader
        .to_string_lossy()
        &[],
        &file_a,
        let arr = batch
    // ── Row group structure ──────────────────────────────────────────────
    ]));
    let batch_b = RecordBatch::try_new(
    .unwrap();
    let col_idx = schema
            Arc::new(StringArray::from(vec!["c1", "c3", "c5"])),
        &[false],
    let batch_b = RecordBatch::try_new(
            .unwrap();
    assert_eq!(rg_sizes[0], RG_MAX);
    let batch_c = RecordBatch::try_new(
        assert_eq!(*got, Some(*exp), "wrong value at row {}", i);
    let reader = ParquetRecordBatchReaderBuilder::try_new(file)
        &[true],
    let mut all: Vec<Option<i64>> = Vec::new();
        .to_string();
                col_d_vals.push("NULL".to_string());
    register_deferred_settings(index, 3, 0);
        for i in 0..arr.len() {
/// handles partial slices correctly when merge interleaves within a batch.
        &[file_a, file_b],
fn inspect_row_groups(path: &str, col: &str) -> (Vec<i64>, Vec<Option<i64>>, Vec<Option<i64>>) {
    assert_eq!(actual_rows, expected_rows, "Row count mismatch");
        ("c", vec![3, 7, 11]),
        return;
            Arc::new(Int64Array::from(vec![10, 30, 50, 70, 90])),
        &[true],
            Arc::new(StringArray::from(vec![Some("x2"), Some("x5")])),
    )
    // RG boundary: last of RG0 must be strictly less than first of RG1
    )
    assert_eq!(rg_sizes.len(), 2);
        let arr = batch
    let reader = ParquetRecordBatchReaderBuilder::try_new(file)
    let output = tmp.path().join("merged_unsorted.parquet");
    let tmp = tempdir().unwrap();
#[test]
    .unwrap();
    let index = "test_deferred_tier3_many_cursors";
    let tmp = tempdir().unwrap();
        Field::new("col_a", DataType::Utf8, true),
            Arc::new(Int64Array::from(vec![3, 4, 5, 6, 7, 8])),
/// Merge files with different schemas in deferred mode — verifies that columns
        .path()
    ]));
        )
            .downcast_ref::<PrimitiveArray<TimestampMillisecondType>>()
            Arc::new(StringArray::from(vec!["a2", "a4", "a6"])),
            if arr.is_null(i) {
    .unwrap();
                &RecordBatch::try_new(
    let file_b = tmp.path().join("b.parquet").to_string_lossy().to_string();
/*
    let Some(input_dir) = input_dir() else {
    // Expected: 1,2,5,5,6,7,8
            Arc::new(StringArray::from(vec![Some("US"), Some("UK")])),
fn test_rg_size_overshoots_when_batch_straddles_threshold() {
    assert_eq!(
        country_vals,
    assert_eq!(rg_firsts[1], Some(total - RG_MAX - 1), "RG1 first value");
    .unwrap();
    // nulls_first=true → merged: null*(half*2), 0, 1, 2, ..., (half-1)*2+1
        .iter()
    let batch_2 = RecordBatch::try_new(
    // Sort by EventDate ascending (each input file is pre-sorted by EventDate)
    let schema = Arc::new(Schema::new(vec![
            .downcast_ref::<StringArray>()
    // overshoot (see test_rg_size_overshoots_when_batch_straddles_threshold).
        &[],
        .collect();
        &output,
                Arc::new(StringArray::from(labels)),
use arrow::array::types::TimestampMillisecondType;
            "wrong non-null value at row {}",
    register_small_batch_size(index, 2);
    let batch_b = RecordBatch::try_new(
        "test_default_asc_nulls_first",
    assert_eq!(ts_vals, vec![1, 2, 3, 4, 5, 6, 7, 8]);
        &[false],
    }
            .column(idx)
    let b_vals: Vec<i64> = (0..b_count).map(|i| i * 2 + 1).collect();
            Arc::new(StringArray::from(vec!["b2", "b4", "b6"])),
    // RG1 gets the remaining 1_000_010 - wait, 20 * 100_001 = 2_000_020 rows
        let labels: Vec<&str> = vals.iter().map(|_| label).collect();
        index,
    )
    // Compare outputs — must be identical
        .path()
    write_parquet(&file_1, &batch_1);
        let arr = batch
                col_d_vals.push(arr.value(i).to_string());
        .path()
        &[false],
use std::path::Path;
fn list_parquet_files(dir: &str) -> Vec<String> {
    .unwrap();
    )
        let end = offset + sz as usize;
        &[],
        .path()
    assert_eq!(ts_vals, vec![12, 11, 10, 7, 6, 5, 3, 2, 1]);
        &[file_a, file_b, file_c],
        Field::new("col_c", DataType::Utf8, false),
/// Stress test: many small batches forcing repeated yield-to-heap transitions.
        ],
fn test_deferred_multi_batch_sync() {
            if arr.is_null(i) {
        &[false],
        .join("merged.parquet")
}
        }
    let tmp = tempdir().unwrap();
    let batch_b = RecordBatch::try_new(
    // Exact value check
                    out_of_order += 1;
    // With default batch_size=100_000 which divides evenly into RG_MAX=1_000_000,
    }
        Field::new("ts", DataType::Int64, false),
    let file_b = tmp.path().join("b.parquet").to_string_lossy().to_string();
        let idx = batch.schema().index_of(col).unwrap();
// ═══════════════════════════════════════════════════════════════════════════════
        index,
    let mut lasts = Vec::new();
    let output = tmp.path().join("out.parquet").to_string_lossy().to_string();
    write_parquet(&file_b, &batch_b);
    for batch in reader {
    )
    println!("Output rows: {}", actual_rows);
            schema.clone(),
        &[],
#[test]
    write_parquet(
        &file_b,
    )
    let schema = Arc::new(Schema::new(vec![
    let b_vals = read_all_strings(&output, "col_b");
// Deferred mode — TIER 1, 2, 3 correctness tests
        Field::new("ts", DataType::Int64, false),
        &[false],
            Arc::new(StringArray::from(vec!["p1", "p2", "p5", "p6"])),
                Some(arr.value(i))
    SETTINGS_STORE.insert(
    write_parquet(&file_a, &batch_a);
    let file_c = tmp.path().join("c.parquet").to_string_lossy().to_string();
    write_parquet(&file_a, &batch_a);
    let schema = Arc::new(Schema::new(vec![
    assert_eq!(ts_vals, vec![1, 2, 3, 4, 5, 6]);
    assert_eq!(rg_sizes.len(), 2);
    let output = tmp
fn test_deferred_tier2_full_batch_emit() {
    merge_sorted(
#[test]
        .path()
    let mut name_vals = Vec::new();
    );
    let mut extra_vals = Vec::new();
        index,
        Field::new("col_d", DataType::Utf8, true),
    .unwrap();
    let schema = Arc::new(Schema::new(vec![
    let ts_e = read_all_int64(&output_eager, "ts");
            .as_primitive::<arrow::datatypes::Int64Type>();
        }
    .unwrap();
    let batch_a = RecordBatch::try_new(
    .map(|(name, vals)| {
    assert_eq!(
        index,
#[test]
        .chain(c_vals.iter())
    .unwrap();
            .unwrap();
        .build()
        &[false],
    write_parquet(&file_3, &batch_3);
    )
        vec![
    //   total nulls  = 700_000
    println!("Total input rows: {}", expected_rows);
        &[false],
            .as_any()
        .expect("__row_id__ not in output");
        &[],
    );
    )
        .to_string_lossy()
        .to_string();
    register_deferred_settings(index, 3, 0);
        &["v".into()],
                country_vals.push(arr.value(i).to_string());
    let actual_rows = count_rows(&output_str);
        schema.clone(),
                Some(p.to_string_lossy().to_string())
    assert_eq!(ts_vals, vec![1, 2, 3, 4, 5, 6, 7, 8]);
        &[file_a, file_b],
        "test_all_dupes_large",
                name_vals.push("NULL".to_string());
        vec![
    let tmp = tempdir().unwrap();
#[test]
    for &sz in &sizes {
/// Setup: batch_size=100_001 so each cursor batch is 100_001 rows.
    .unwrap();
    // RG0 last  value = 1_399_999 - (RG_MAX-1) = 400_000
    let files: Vec<String> = (0..3)
/// Deferred mode produces identical output to eager mode for the same input.
    )
        0,
        &[file_a, file_b],
        &[false],
        vec![Arc::new(Int64Array::from(vec![3, 4, 30, 31]))],
        .join("merged.parquet")
    assert_eq!(d_vals, vec!["A1", "B2", "A3", "B4", "A5", "B6", "A7", "B8"]);
    merge_sorted(
    let batch_b = RecordBatch::try_new(
        &[],
/// Deferred mode with multiple batches per cursor — verifies data reader
        .build()
        &output,
                extra_vals.push(arr.value(i).to_string());
            ..Default::default()
            vec![Arc::new(Int64Array::from(c_vals.clone()))],
        .to_string_lossy()
    let tmp = tempdir().unwrap();
    SETTINGS_STORE.insert(
        schema.clone(),
/// TIER 2 deferred: entire batch fits before heap top — emits full batch at once.
        &[file_a, file_b],
    let batch_a = RecordBatch::try_new(
        &output,
    let n: i64 = 1_500_000;
    //
        .path()
#[test]
    merge_sorted(
            }
/// File sizes that are not multiples of batch_size (100_000):
    let vals: Vec<i64> = (0..n).collect();
        .unwrap(),
    let file = File::open(path).unwrap();
            Arc::new(Int64Array::from(vec![12, 11, 10, 3, 2, 1])),
}
    let file_b = tmp.path().join("b.parquet").to_string_lossy().to_string();
    let output = tmp
    // Descending merge expected: 12,11,10,7,6,5,3,2,1
            } else {
        &[false],
    // Empty sort columns → unsorted merge
                None
fn count_rows(path: &str) -> i64 {
fn test_tier2_yield_after_batch_boundary() {
        vec![Arc::new(Int64Array::from(vec![1, 2, 20, 21]))],
    let tmp = tempdir().unwrap();
    vals
        schema.clone(),
        &[],
    // File C: [10, 11, 12]
    assert_eq!(rg_lasts[0], Some(RG_MAX - 1));
            schema.clone(),
    )
            } else {
fn verify_row_id_order(path: &str) {
        &RecordBatch::try_new(
    let vals: Vec<i64> = vec![42i64; n as usize];
// loads a new one, the new batch's first value is greater than the heap top,
    //   total rows   = 1_400_000
    assert!(!files.is_empty(), "No parquet files found in {}", input_dir);
    }
        index_deferred,
    let ts_vals = read_all_int64(&output, "ts");
        vec![
    // File B: [null * half, 1, 3, 5, ..., (half-1)*2+1]
        assert_eq!(*v, Some(total - 1 - i as i64), "wrong value at row {}", i);
        &[],
    }
        &[false],
    assert_eq!(out_vals.len() as i64, total);
    };
        Field::new("s2", DataType::Utf8, false),
        assert_eq!(*v, Some(i as i64), "wrong value at row {}", i);
    let output = tmp
}
        );
    let index = "test_deferred_tier1_multi_batch_drain";
        )
    merge_unsorted(&files, &output_str, "test-index", 0, &[]).unwrap();
            col_a_nulls.push(arr.is_null(i));
    let tmp = tempdir().unwrap();
        let idx = batch.schema().index_of(col).unwrap();
        .path()
        &[],
    let mut country_vals = Vec::new();
            .join(format!("{}.parquet", name))
    let out_vals = read_col_i64(&output, "v");
            if arr.is_null(i) {
    let file_b = tmp.path().join("b.parquet").to_string_lossy().to_string();
}
use parquet::arrow::ArrowWriter;
fn test_tier2_yield_multiple_cursors() {
        for i in 0..col.len() {
        &RecordBatch::try_new(schema.clone(), vec![Arc::new(Int64Array::from(a_vals))]).unwrap(),
        Field::new("extra", DataType::Utf8, true),
    let b_vals = read_all_strings(&output, "col_b");
        offset = end;
        &[false],
        .build()
        ],
    .unwrap();
        &output,
        ],
/// Verifies data reader loads correctly when TIER 1 bulk-emits.
    .unwrap();
    let tmp = tempdir().unwrap();
    assert_eq!(rg_sizes[0], RG_MAX);
/// Verifies that RG size can exceed RG_MAX when a pushed slice straddles the
    assert_eq!(val_vals, vec!["a", "b2", "b3", "b4", "b5", "b6", "b7"]);
        let arr = batch
        &file_b,
    let file_a = tmp.path().join("a.parquet").to_string_lossy().to_string();
    assert_eq!(rg_sizes[1], total - RG_MAX);
    // Sorted order: ts=[1,2,3,4,5,6], rows from file A at positions 0,2,4; file B at 1,3,5
            Arc::new(Int64Array::from(vec![2, 4, 6])),
    }
        let idx = batch.schema().index_of("country").unwrap();
/// Helper: count rows in a single parquet file.
    let output_str = output.to_string_lossy().to_string();
        ("a", vec![1i64, 5, 9]),
        .unwrap();
    for (i, (got, exp)) in out_vals.iter().zip(expected.iter()).enumerate() {
    )
    println!("Total input rows: {}", expected_rows);
#[test]
        &["ts".into()],
fn test_deferred_different_schemas() {
        &[file_a, file_b],
    let tmp = tempdir().unwrap();
    )
fn test_tier2_no_yield_when_equal_to_heap_top() {
    let output = tmp.path().join("out.parquet").to_string_lossy().to_string();
fn test_default_settings_ascending_nulls_first() {
    let b_vals: Vec<i64> = (0..ROWS_PER_FILE).map(|i| i * 2 + 1).collect();
            Arc::new(Int64Array::from(vec![2, 4, 6, 8])),
    assert_eq!(out_vals.len() as i64, n);
}
    let file_a = tmp.path().join("a.parquet").to_string_lossy().to_string();
    let file_b = tmp.path().join("b.parquet").to_string_lossy().to_string();
        &[file_a, file_b],
    )
        "test_three_files_middle_exhausts",
        Field::new("n1", DataType::Int64, false),
    //
    let total = ROWS_PER_FILE * 2; // 1_400_000
        "test_single_large_file",
    let n1_d = read_all_int64(&output_deferred, "n1");
#[test]
    write_parquet(&file_a, &batch_a);
    for batch in rdr {
        &["ts".into()],
            Arc::new(Int64Array::from(vec![1, 2, 3, 10, 11, 12])),
    let reader = builder.build().unwrap();
        vec!["a", "b", "c", "d", "a", "b", "c", "d", "a", "b", "c", "d"]
    let a_vals: Vec<i64> = (0..a_count).map(|i| i * 2).collect();
    register_deferred_settings(index, 4, 0); // batch_size=4, always deferred
            }
    ]));
    // File A: evens 0, 2, 4, ..., 2_399_998  (1_200_000 values)
    .unwrap();
/// output_flush_rows=1_000_000. After 9 batches: 900_009 rows buffered.
        Field::new("s1", DataType::Utf8, false),
        NativeSettings {
            Arc::new(StringArray::from(vec!["c", "c", "c", "c", "c"])),
    let batch_a = RecordBatch::try_new(
    assert_eq!(b_vals, vec!["b1", "b2", "b3", "b4", "b5", "b6"]);
    assert_eq!(
    // But counts differ so the last few values come only from one file.
    register_small_batch_size(index, 3);
    );
                if val < p {
    assert_eq!(rg_firsts[1], Some(rg0_last_nonnull + 1), "RG1 first value");
    }
                "a12", "a11", "a10", "a3", "a2", "a1",
    // Verify __row_id__ is sequential 0..N
            let val = col.value(i);
/// Read every value of a nullable Int64 column.
            {
    )
    let file_b = tmp.path().join("b.parquet").to_string_lossy().to_string();
    let file_a = tmp.path().join("a.parquet").to_string_lossy().to_string();
        vec![
        &[],
        &[file_a, file_b],
}
        vec!["A1", "A2", "A3", "B5", "B6", "B7", "A10", "A11", "A12"]
    .unwrap();
        index,
    let schema_b = Arc::new(Schema::new(vec![
            .downcast_ref::<arrow::array::Int64Array>()
    assert_eq!(vals.len() as i64, ROWS_PER_FILE * 2);
    .unwrap();
    let out_vals = read_col_i64(&output, "v");
    // ── Exact value check ────────────────────────────────────────────────
    write_parquet(&file_b, &batch_b);
        &nulls_first,
    //
        &[],
    write_parquet(&file_a, &batch_a);
// so the cursor must yield back to the heap.
    assert_eq!(ts_vals, vec![1, 2, 3, 4, 5, 6]);
        &RecordBatch::try_new(
    let total = n * 3;
    let d_vals = read_all_strings(&output, "data");
        let batch = batch.unwrap();
        rg_sizes[0], RG_MAX,
    );
fn test_default_settings_descending_nulls_last() {
    assert_eq!(col_a_nulls, vec![false, true, false, true, false, true]);
        &[],
            Arc::new(StringArray::from(vec!["y", "y", "y", "y", "y"])),
    assert_eq!(a_vals, vec!["a1", "a2", "a3", "a4", "a5", "a6"]);
    // Total: 1_500_000 rows → 2 RGs
    expected.sort();
    let schema = builder.schema().clone();
    let tmp = tempdir().unwrap();
    .unwrap();
    ]));
    // Merged: 0,1,2,3,4,5,...,29_998,29_999(missing from B),30_000,...
        ],
    )
            let p = e.ok()?.path();
    assert!(rg_firsts.iter().all(|v| *v == Some(42)));
    // File A: [null * half, 0, 2, 4, ..., (half-1)*2]
    write_parquet(&file_b, &batch_b);
    let index = "test_deferred_tier2_descending";
        vec![Arc::new(Int64Array::from(vec![1, 2, 5, 6]))],
        .to_string();
    let tag_vals = read_all_strings(&output, "tag");
        })
/// After TIER 2 drains A's first batch, A's second batch starts higher than B's
    .unwrap();
            Arc::new(StringArray::from(vec!["a2", "a4", "a6"])),
        &[false],
    // After interleaved section: remaining evens from 400_000 to 2_399_998
    if !Path::new(&input_dir).exists() {
        &[file_a, file_b, file_c],
    // RG0: 1_000_010, RG1: 1_000_010
        .to_string();
            Arc::new(StringArray::from(vec!["z", "z", "z", "z", "z"])),
        vec!["alice", "bob", "NULL", "dave", "eve", "NULL"]
        &[false],
    let msg_vals = read_all_strings(&output, "msg");
    let index = "test_deferred_multi_batch_sync";
    let file = File::open(&output).unwrap();
        vec!["NULL", "NULL", "US", "NULL", "NULL", "UK"]
        Field::new("col_e", DataType::Utf8, true),
        }
        path
        "test_default_desc_nulls_last",
    );
    .unwrap();
            }
        "test_default_asc_nulls_last",
        ],
/// verifies union schema construction and null padding across multiple files.
        &[file_a],
        Field::new("data", DataType::Utf8, false),
    }
    let out_vals = read_col_i64(&output, "v");
            } else {
        .to_string();
    // File B: [7, 6, 5] descending
        vec![
            vals[total_nulls as usize + i],
        vec![
    )
    let reader = ParquetRecordBatchReaderBuilder::try_new(file)
        for i in 0..arr.len() {
            .as_any()
    assert_eq!(extra_vals, vec!["NULL", "x2", "x3", "NULL", "x5", "x6"]);
/// File B exhausts while file A is mid-batch, forcing TIER 1 drain of A
        let arr = batch
        .unwrap(),
/// Helper: count total rows across input files.
    let schema = Arc::new(Schema::new(vec![
        .to_string();
}
        &[false],
            Arc::new(StringArray::from(vec![Some("alice"), Some("dave")])),
    for (i, v) in vals.iter().enumerate() {
            Arc::new(StringArray::from(vec!["b7", "b6", "b5"])),
        .join("merged.parquet")
            .downcast_ref::<StringArray>()
        &file_a,
/// Descending sort with yield-to-heap after batch boundary.
fn test_deferred_tier2_descending() {
    .unwrap();
    merge_sorted(
    assert_eq!(p_vals, vec!["p1", "p2", "p3", "p4", "p5", "p6", "p7", "p8"]);
    let schema = Arc::new(Schema::new(vec![Field::new("v", DataType::Int64, true)]));
/// with row_idx > 0 (mid-batch position from a prior TIER 3 operation).
        ],
    expected.sort();
    let file = File::open(path).unwrap();
/// stays synchronized across batch boundaries.
    // File B: [5, 6, 7]
    );
    let file_b = tmp.path().join("b.parquet").to_string_lossy().to_string();
        &["ts".into()],
            Arc::new(StringArray::from(vec![Some("c1"), Some("c3"), Some("c5")])),
    let tmp = tempdir().unwrap();
        .map(|f| {
        }
fn read_all_int64(path: &str, col: &str) -> Vec<i64> {
        &file_a,
        ],
#[test]
    let file_a = tmp.path().join("a.parquet").to_string_lossy().to_string();
    assert_eq!(rg_firsts[1], Some(RG_MAX));
    .unwrap();
    merge_sorted(
    assert_eq!(
    register_deferred_settings(index_eager, 3, 9999);
            assert_eq!(col.value(i), expected, "__row_id__ gap at row {}", expected);
    let src_vals = read_all_strings(&output, "src");
    let b_count: i64 = 10_000;
#[test]
        Field::new("col_b", DataType::Utf8, false),
    .unwrap();
    let total_nonnulls = half * 2; // 700_000  (values 0..699_999)
    }
    assert_eq!(a_vals, vec!["a1", "a2", "a3", "a4", "a5", "a6"]);
            reader.metadata().file_metadata().num_rows()
    let batch_a = RecordBatch::try_new(
            .column(idx)
        &files,
    vals
    )
        let path = tmp
    let schema = Arc::new(Schema::new(vec![Field::new("v", DataType::Int64, false)]));
    )
        &sort_cols,
    // File B: [3, 4, 30, 31] with batch_size=2 → cursor batches [3,4] and [30,31]
            Arc::new(StringArray::from(vec!["b1", "b3", "b5"])),
    // current position and vice versa.
    write_parquet(&file_a, &batch_a);
        .to_string();
        &[file_a, file_b],
        &file_a,
/// TIER 1 deferred with multiple batches: the sole remaining cursor spans
    assert_eq!(rg_lasts[0], Some(rg0_last_nonnull), "RG0 last value");
    assert_eq!(ts_vals, vec![1, 2, 3, 5, 6, 7, 10, 11, 12]);
        ],
use opensearch_parquet_format::writer::SETTINGS_STORE;
/// 10th batch pushes 100_001 more → 1_000_010 rows → flush with 1_000_010.
    )
fn test_deferred_three_files_different_schemas() {
    // heap_top from B is 5. Since 10 > 5, A must yield to heap.
        &[],
    merge_sorted(
            Arc::new(Int64Array::from(vec![1, 3, 5])),
        Field::new("ts", DataType::Int64, false),
    let index = "test_rg_overshoot";
            .column(idx)
            .unwrap();
    write_parquet(
        write_parquet(&path, &make_batch(vals, name));
        schema.clone(),
            .expect("__row_id__ should be Int64");
            expected += 1;
    let a_vals: Vec<i64> = (0..large).map(|i| i * 2).collect();
            Arc::new(Int64Array::from(vec![5, 6, 7])),
    // Verify EventDate is non-decreasing in the merged output
        .join("merged.parquet")
    let file_a = tmp.path().join("a.parquet").to_string_lossy().to_string();
    let n: i64 = (batch_size * 20) as i64; // 2_000_020
    assert_eq!(ts_vals, vec![1, 2, 3, 4, 5, 6]);
    merge_sorted(
    let batch_a = RecordBatch::try_new(
        &output,
        .path()
            ],
}
        ],
    let ts_vals = read_all_int64(&output, "ts");
    let vals = read_all_int64(&output, "v");
    let mut files: Vec<String> = std::fs::read_dir(dir)
    ]));
            Arc::new(StringArray::from(vec![
                }
#[test]
    .unwrap();
    // After B exhausts, A and C continue interleaving.
        &file_b,
        let batch = batch.unwrap();
    for (i, v) in vals.iter().enumerate() {
    let file_a = tmp.path().join("a.parquet").to_string_lossy().to_string();
    let file_a = tmp.path().join("a.parquet").to_string_lossy().to_string();
    // Merged: 0,1,2,3,...,399_999, 400_000,400_002,...,2_399_998
    // File A: [1, 2] — exhausts quickly
        0,
        for i in 0..arr.len() {
// ─── Default batch size / row-group size tests ───────────────────────────────
        index,
        &output,
    .unwrap();
        for i in 0..arr.len() {
            });
fn test_default_settings_ascending_nulls_last() {
    // File B: [5, 7, 8]
    let mut writer = ArrowWriter::try_new(file, batch.schema(), None).unwrap();
    merge_sorted(
            if p.extension().and_then(|s| s.to_str()) == Some("parquet")
            } else {
        schema_2.clone(),
            Arc::new(StringArray::from(vec!["a1", "a3", "a5"])),
        0,
#[test]
    let tmp = tempdir().unwrap();
        .unwrap()
    // 3 files × 500_000 rows, all with value=42
        vec![
        schema.clone(),
        .to_string_lossy()
        for i in 0..arr.len() {
        .unwrap(),
        .join("merged.parquet")
    // 4 fully interleaved files:
        .to_string_lossy()
    // File A: [1, 2, 5, 6] with batch_size=2 → cursor batches [1,2] and [5,6]
            Arc::new(StringArray::from(vec![Some("e2"), Some("e4"), Some("e6")])),
    let make_batch = |vals: Vec<i64>, label: &str| {
    for (i, v) in out_vals.iter().enumerate() {
    );
    );
            merge_batch_size: Some(batch_size),
    .unwrap();
        &[false],
}
    for batch in rdr {
    )
            .to_string();
            Arc::new(StringArray::from(vec!["first", "second"])),
        .to_string();
    assert_eq!(rg_firsts[0], Some(0));
    expected.sort();
        rows_checked
/// Three files with interleaved batch boundaries to force multiple yield events.
            .as_primitive::<arrow::datatypes::Int64Type>();
            Arc::new(StringArray::from(vec!["a"])),
    assert_eq!(rg_firsts[1], Some(RG_MAX), "RG1 first value");
        rg_sizes[0],
    // One file with 2_000_002 rows (20 full batches of 100_001)
        msg_vals,
            if let Some(p) = prev {
    // File B: [1, 4, 7, ...,  29_998]  ( 10_000 values, step 3 — exhausts first)
        schema.clone(),
        &[false],
        &["v".into()],
}
}
}
fn read_all_strings(path: &str, col: &str) -> Vec<String> {
        let idx = batch.schema().index_of("extra").unwrap();
        }
    )
    let reader = SerializedFileReader::new(File::open(path).unwrap()).unwrap();
    // File B: [5,6, 15,16, 25,26, 35,36, 45,46] with batch_size=2
// These tests exercise the logic where after TIER 2 drains a full batch and
fn read_col_i64(path: &str, col: &str) -> Vec<Option<i64>> {
    let file_a = tmp.path().join("a.parquet").to_string_lossy().to_string();
        .path()
    assert_eq!(s1_d, s1_e, "s1 column differs between deferred and eager");
        0,
        0,
    let tmp = tempdir().unwrap();
        schema.clone(),
            merge_batch_size: Some(batch_size),
        &[],
    let file_a = tmp.path().join("a.parquet").to_string_lossy().to_string();
        ],
        0,
    ]));
    // Run with deferred (threshold=0)
    println!("Verified __row_id__ is sequential 0..{}", expected);
    let n: i64 = 500_000;
// ═══════════════════════════════════════════════════════════════════════════════
    for (i, (got, exp)) in out_vals.iter().zip(expected.iter()).enumerate() {
            .as_any()
    let batch_a = RecordBatch::try_new(
        let batch = batch.unwrap();
        0,
    let output = tmp
    //   total non-nulls = 700_000  (values 0..699_999)
            Arc::new(StringArray::from(vec![Some("a1"), Some("a3"), Some("a5")])),
    let tmp = tempdir().unwrap();
        ],
    let batch_1 = RecordBatch::try_new(
            } else {
        Field::new("name", DataType::Utf8, true),
    // File A: evens descending  [(ROWS_PER_FILE-1)*2, ..., 2, 0]
    // ── Exact value check ────────────────────────────────────────────────
    assert_eq!(rg_sizes.len(), 2);
    // Merged ascending: 0, 1, 2, 3, ..., 1_399_999
        assert_eq!(vals[i], None, "expected null at row {}", i);
    write_parquet(
    let batch_b = RecordBatch::try_new(
/// transition mid-merge with two remaining cursors still active.
        &[false],
    ]));
    for batch in reader {
    let tmp = tempdir().unwrap();
        &output,
    merge_sorted(
        &RecordBatch::try_new(schema.clone(), vec![Arc::new(Int64Array::from(b_vals))]).unwrap(),
        Field::new("ts", DataType::Int64, false),
        assert_eq!(*got, Some(*exp), "wrong value at row {}", i);
}
            Arc::new(StringArray::from(vec![Some("b2"), Some("b4"), Some("b6")])),
    // RG1: non-nulls (rg0_last_nonnull+1)..total_nonnulls-1
        schema.clone(),
        let idx = batch.schema().index_of(col).unwrap();
    // A: [1, 5, 9]  B: [2, 6, 10]  C: [3, 7, 11]  D: [4, 8, 12]
        &[file_a, file_b],
    let file_a = tmp.path().join("a.parquet").to_string_lossy().to_string();
    )
        vec![
    register_deferred_settings(index, 3, 0);
    let file_1 = tmp.path().join("f1.parquet").to_string_lossy().to_string();
    let files = list_parquet_files(&input_dir);
    assert_eq!(out_vals.len() as i64, n);
    // col_b present in both files
        expected_rg_size,
        &["ts".into()],
/// across multiple interleaved cursors with small batch sizes.
    let batch_b = RecordBatch::try_new(
        let batch = batch.unwrap();
        &[false],
                    schema.clone(),
    merge_sorted(
    for batch in reader {
    let schema_2 = Arc::new(Schema::new(vec![
    assert_eq!(rg_sizes[1], total - RG_MAX);
        &output,
        &[],
            prev = Some(val);
        &output,
    let mut prev: Option<i64> = None;
        "Found {} out-of-order rows in EventDate",
fn test_tier2_yield_many_small_batches() {
        Field::new("col_b", DataType::Utf8, false),
        index.to_string(),
    assert_eq!(out_vals.len() as i64, total);
        &[],
        .path()
/// Verifies data is loaded once for the full batch slice.
    // RG0 = 1_000_000 rows: all 700_000 nulls + first 300_000 non-nulls (0..299_999)
    let index = "test_deferred_tier2_full_batch_emit";
use parquet::file::reader::{FileReader, SerializedFileReader};
        index,
        &["v".into()],
        let col = batch
    }
            .unwrap();
            Arc::new(StringArray::from(vec!["c2", "c4", "c6"])),
        vec![
    assert_eq!(ts_vals, vec![1, 2, 3, 4, 5, 6]);
    )
        &[false],
    let index = "test_deferred_wide_schema_correctness";
    let vals = read_all_int64(&output, "v");
    .unwrap();
/// Verifies total row count is preserved and no rows are dropped or duplicated.
        Field::new("extra", DataType::Utf8, true),
    merge_sorted(
        &[],
        Field::new("col_c", DataType::Utf8, true),
    assert_eq!(out_vals.len() as i64, total);
fn test_deferred_wide_schema_correctness() {
    let file_2 = tmp.path().join("f2.parquet").to_string_lossy().to_string();
            if col.is_null(i) {
        &["v".into()],
        &[],
        .copied()
        schema.clone(),
            });
            Arc::new(Int64Array::from(vec![2, 4, 6])),
    assert_eq!(ts_vals, vec![1, 2, 3, 4, 5, 6, 7]);
    )
        schema.clone(),
            .unwrap();
        .to_string();
    let mut col_d_vals = Vec::new();
            Arc::new(Int64Array::from(vec![3, 6])),
        .expect("cannot read directory")
        .unwrap()
        .to_string_lossy()
        vec![
    )
    merge_sorted(
    let schema = Arc::new(Schema::new(vec![Field::new("v", DataType::Int64, false)]));
    .unwrap();
    let file_a = tmp.path().join("a.parquet").to_string_lossy().to_string();
    .unwrap();
            }
    let output = tmp
        .index_of("__row_id__")
    let a_vals = read_all_strings(&output, "col_a");
        .path()
/// Merge three files with progressively wider schemas in deferred mode —
        .path()
        &output,
    )
        &[],
            total_nulls as usize + i
        &[],
        schema.clone(),
    .unwrap();
        vec![Arc::new(Int64Array::from(vec![5, 7, 8]))],
            Arc::new(StringArray::from(vec![Some("x3"), Some("x6")])),
        &[false],
        schema.clone(),
                        );
    assert_eq!(rg_firsts[0], Some(total - 1), "RG0 first value");
            Arc::new(Int64Array::from(vec![100, 300, 500, 700, 900])),
        .to_string();
        &output,
    );
    // Fully interleaved → TIER 3 binary search on every pop
    .unwrap();
    vals
    )
        &["v".into()],
    .unwrap();
    let ts_vals = read_all_int64(&output, "ts");
    let files: Vec<String> = vec![
    let file = File::open(&output).unwrap();
        .path()
/// Wide schema with threshold=0 forces deferred mode. Verify all data columns
        eprintln!("Skipping: PARQUET_TEST_INPUT_DIR not set");
        &[false],
        let idx = batch.schema().index_of(col).unwrap();
/// Single file with >1M rows: no merge needed, just copy through.
        0,
    assert_eq!(actual_rows, expected_rows, "Row count mismatch");
        &[],
#[test]
    let batch_a = RecordBatch::try_new(
}
    let index = "test_tier2_yield_many_small_batches";
    write_parquet(&file_a, &batch_a);
            Arc::new(Int64Array::from(vec![1, 4])),
            .column(col_idx)
    assert_eq!(rg_firsts[0], Some(0));
    )
        vec!["a12", "a11", "a10", "b7", "b6", "b5", "a3", "a2", "a1"]
/// Register a small merge_batch_size for the given index so the cursor splits into multiple batches.
    let a_vals = read_all_strings(&output, "col_a");
    register_deferred_settings(index, 2, 0); // batch_size=2, always deferred
        &output,
// Verifies:
    write_parquet(&file_b, &batch_b);
        let batch = batch.unwrap();
            ])),
        &[false],
use std::fs::File;
        &[],
    let file_a = tmp.path().join("a.parquet").to_string_lossy().to_string();
        &["ts".into()],
/// TIER 1 deferred: single cursor remaining — drains all remaining rows.
    }
            Arc::new(StringArray::from(vec!["B2", "B4", "B6", "B8"])),
    let sizes: Vec<i64> = (0..n_rg).map(|i| meta.row_group(i).num_rows()).collect();
        &[false],
    .unwrap();
    let vals = read_col_i64(&output, "v");
    let file_b = tmp.path().join("b.parquet").to_string_lossy().to_string();
    let file_b = tmp.path().join("b.parquet").to_string_lossy().to_string();
    let total = ROWS_PER_FILE * 2;
            vec![Arc::new(Int64Array::from(a_vals.clone()))],
    assert_eq!(ts_d, ts_e, "timestamps differ between deferred and eager");
        }
            all.push(if arr.is_null(i) {
    let tmp = tempdir().unwrap();
        },
            .as_any()
    assert!(output.exists(), "Output file was not created");
        ("b", vec![2, 6, 10]),
        schema.clone(),
    let vals: Vec<i64> = (0..n).collect();
    // File B: [2, 3, 4, 5, 6, 7] — 3 batches of 2 rows each, all drained by TIER 1
                            "Out of order at row {}: prev={}, cur={}",
fn test_deferred_tier1_single_cursor_drain() {
    // File A: evens, File B: odds — interleaved merge = 0,1,2,...
        &[],
    let (rg_sizes, rg_firsts, rg_lasts) = inspect_row_groups(&output, "v");
    // After TIER 2 drains A batch 0 [1,2,3], A loads batch 1 starting at 10.
        .join("merged_deferred.parquet")
        Field::new("col_c", DataType::Utf8, false),
            Arc::new(Int64Array::from(vec![1, 3, 5])),
    // File A: [12, 11, 10, 3, 2, 1] descending → batches [12,11,10] and [3,2,1]
    .collect();
    assert_eq!(rg_lasts[1], Some(0), "RG1 last value");
fn test_tier2_yield_descending() {
        &output,
            .to_string_lossy()
        &[file_a, file_b],
//   - RG boundary: last value of RG0 < first value of RG1 (ascending)
    let mut offset = 0usize;
    for batch in reader {
                name_vals.push(arr.value(i).to_string());
        &output,
    writer.close().unwrap();
        &files,
            .column(idx)
    merge_sorted(
        assert_eq!(*got, Some(*exp), "wrong value at row {}", i);
    register_small_batch_size(index, 2);
        return;
    let tmp = tempdir().unwrap();
    //
    )
    let rdr = ParquetRecordBatchReaderBuilder::try_new(file)
///
    // ── Exact value check ────────────────────────────────────────────────
        &[false],
        },
        ],
        .collect();
    let (rg_sizes, rg_firsts, rg_lasts) = inspect_row_groups(&output, "v");
            Arc::new(StringArray::from(vec!["p3", "p4", "p7", "p8"])),
const RG_MAX: i64 = 1_000_000;
        &file_b,
            }
    register_small_batch_size(index, 3);
    let out_vals = read_col_i64(&output, "v");
    assert_eq!(
    ]));
    .unwrap();
    let file = File::create(path).unwrap();
        .to_string_lossy()
    write_parquet(
        schema.clone(),
    let index = "test_tier2_no_yield_when_equal_to_heap_top";
            schema.clone(),
        &[false],
/// TIER 2 deferred with descending sort — verifies deferred works with reverse order.
        ],
    }
            Arc::new(StringArray::from(vec!["c2", "c4", "c6"])),
    let output = tmp
        &[false],
    // File A: [1, 2, 3, 10, 11, 12] → batches [1,2,3] and [10,11,12]
        schema.clone(),
    }
    let file = File::open(path).unwrap();
    let mut rows_checked: i64 = 0;
            merge_deferred_column_threshold: Some(deferred_threshold),
    assert_eq!(rg_lasts[0], Some(expected_rg_size - 1));
    let mut expected: Vec<i64> = (0..small).map(|i| i * 2).collect(); // evens 0..399_998
            .downcast_ref::<StringArray>()
fn test_deferred_tier1_multi_batch_drain() {
    );
    // heap_top from B is also 5. Since 5 == 5 (not Greater), A should NOT yield.
    let reader = ParquetRecordBatchReaderBuilder::try_new(file)
    let batch_b = RecordBatch::try_new(
    )
    )
        &RecordBatch::try_new(schema.clone(), vec![Arc::new(Int64Array::from(b_vals))]).unwrap(),
fn test_deferred_tier3_interleaved() {
    .unwrap();
    write_parquet(
        schema.clone(),
    let out_schema = builder.schema().clone();
            .unwrap();
// ─── TIER 2 yield-to-heap tests ─────────────────────────────────────────────
    let file_b = tmp.path().join("b.parquet").to_string_lossy().to_string();
        &RecordBatch::try_new(
    )
        NativeSettings {
        &[],
        .collect();
    ]));
}
    // Read all values in order, then slice per RG
    // File B: odds   [1, 3, 5, ..., (ROWS_PER_FILE-1)*2+1] — 700_000 values
        .join("merged.parquet")
    let schema = Arc::new(Schema::new(vec![
        )
// ═══════════════════════════════════════════════════════════════════════════════
        for i in 0..arr.len() {
        .unwrap();
    .unwrap();
        &["ts".into()],
                .to_string();
        index,
        &[],
    // File A: [12, 11, 10, 3, 2, 1] with batch_size=3 → cursor batches [12,11,10] and [3,2,1]
                extra_vals.push("NULL".to_string());
    )
            Arc::new(StringArray::from(vec![Some("d2"), Some("d4"), Some("d6")])),
fn register_deferred_settings(index_name: &str, batch_size: usize, deferred_threshold: usize) {
    let output = tmp.path().join("out.parquet").to_string_lossy().to_string();
        0,
    let file_a = tmp.path().join("a.parquet").to_string_lossy().to_string();
}
    )
fn register_small_batch_size(index_name: &str, batch_size: usize) {
    .unwrap();
        0,
        &[false],
        0,
        vec![Arc::new(Int64Array::from(vec![5, 6, 7]))],
            if arr.is_null(i) {
                continue;
        .to_string_lossy()
    let batch_a = RecordBatch::try_new(
        &[],
    let schema = Arc::new(Schema::new(vec![
    let (rg_sizes, rg_firsts, rg_lasts) = inspect_row_groups(&output, "v");
        &["v".into()],
    reader.metadata().file_metadata().num_rows()
    let total = a_count + b_count + c_count;
    write_parquet(&file_a, &batch_a);
            .unwrap();
                country_vals.push("NULL".to_string());
    .unwrap();
    let n1_e = read_all_int64(&output_eager, "n1");
}
        .collect();
        .unwrap();
        &[],
    let reader = ParquetRecordBatchReaderBuilder::try_new(file)
    )
#[test]
        Field::new("ts", DataType::Int64, false),
        0,
        Field::new("country", DataType::Utf8, true),
#[test]
        &[true],
    files
    //
    expected.extend((small..large).map(|i| i * 2));
            write_parquet(
    let (rg_sizes, rg_firsts, rg_lasts) = inspect_row_groups(&output, "v");
        &[file_a, file_b],
    assert_eq!(vals.len() as i64, total);
    assert_eq!(c_vals, vec!["c1", "c2", "c3", "c4", "c5", "c6"]);
    assert_eq!(
        }
        .build()
    //
        &RecordBatch::try_new(
        &output,
        schema.clone(),
    // Exact boundary values
    let meta = reader.metadata();
    )
        vec![
        &[false],
    (sizes, firsts, lasts)
    println!(
use arrow::datatypes::{DataType, Field, Schema};
use parquet::arrow::arrow_reader::ParquetRecordBatchReaderBuilder;
    let file_b = tmp.path().join("b.parquet").to_string_lossy().to_string();
    let col_idx = out_schema.index_of("EventDate").unwrap();
    merge_sorted(
        &[false],
    assert_eq!(rg_lasts[0], Some(RG_MAX - 1), "RG0 last value");
        .unwrap()
    let schema = Arc::new(Schema::new(vec![Field::new("v", DataType::Int64, false)]));
        let idx = batch.schema().index_of("col_a").unwrap();
    assert_eq!(rg_sizes.len(), 2, "expected exactly 2 row groups");
    let half = ROWS_PER_FILE / 2; // 350_000
        .unwrap()
            ..Default::default()
            vec![Arc::new(Int64Array::from(b_vals.clone()))],
    let index = "test_deferred_tier3_interleaved";
    .unwrap();
        &file_a,
    write_parquet(&file_b, &batch_b);
        &["v".into()],
    merge_sorted(
    // File A: evens  [0, 2, 4, ..., (ROWS_PER_FILE-1)*2]   — 700_000 values
        index,
    let actual_rows = count_rows(&output_str);
        index,
    let file_b = tmp.path().join("b.parquet").to_string_lossy().to_string();
        schema_1.clone(),
    let schema = Arc::new(Schema::new(vec![
    );
        0,
        Field::new("ts", DataType::Int64, false),
        &["ts".into()],
#[test]
    .unwrap();
    let odds: Vec<i64> = (0..small).map(|i| i * 2 + 1).collect(); // odds  1..399_999
/// Verify that __row_id__ in the output is monotonically increasing (0, 1, 2, ...).
use opensearch_parquet_format::native_settings::NativeSettings;
    for batch in reader {
            .downcast_ref::<StringArray>()
#[test]
    register_deferred_settings(index, 3, 9999); // threshold=9999 → always eager
    write_parquet(
//   - Every single output value matches the expected sorted sequence
        .to_string();
        &RecordBatch::try_new(schema.clone(), vec![Arc::new(Int64Array::from(a_vals))]).unwrap(),
    );
 * SPDX-License-Identifier: Apache-2.0
            ..Default::default()
    let ts_vals = read_all_int64(&output, "ts");
    .unwrap();
    // col_a only in file A — file B rows should be null
        &output,
    // Expected merge: 1,2,3,5,6,7,10,11,12
    // "country" only in file 3
    let schema = Arc::new(Schema::new(vec![Field::new("v", DataType::Int64, false)]));
        &output,
        Field::new("name", DataType::Utf8, true),
    let b_vals: Vec<i64> = (0..5).flat_map(|i| vec![i * 10 + 5, i * 10 + 6]).collect();
    ]));
    let batch_a = RecordBatch::try_new(
    assert_eq!(vals, vec![1, 2, 5, 5, 6, 7, 8]);
    write_parquet(
            Arc::new(StringArray::from(vec![
    // File B: [7, 6, 5]
        0,
    let output_str = output.to_string_lossy().to_string();
            .column(idx)
    let output_eager = tmp
/// Helper: register settings with a specific deferred threshold.
    let builder = ParquetRecordBatchReaderBuilder::try_new(file).unwrap();
    merge_sorted(
/// flush threshold (output_row_count >= output_flush_rows fires AFTER the
            vals.push(arr.value(i).to_string());
        &output_deferred,
        assert_eq!(
    let batch_b = RecordBatch::try_new(
    for i in 0..total_nulls as usize {
        ("d", vec![4, 8, 12]),
    let ts_vals = read_all_int64(&output, "ts");
    let mut expected: i64 = 0;
                            rows_checked, p, val
// Uses default settings (merge_batch_size=100_000, row_group_max_rows=1_000_000).
/// Edge case: new batch starts exactly equal to heap top (should NOT yield).
/// Two files where file A has two batches (small row group size forces batch boundary).
    merge_sorted(
        &reverse,
        vec![Arc::new(Int64Array::from(vec![10, 11, 12]))],
    // RG0 first value = 1_399_999
    .unwrap();
    merge_sorted(
    let tmp = tempdir().unwrap();
        vec![
    assert_eq!(rg_sizes.iter().sum::<i64>(), n);
        vec!["first", "second", "t3", "t4", "t5", "t6", "t7", "t8"]
    assert_eq!(vals, vec![12, 11, 10, 7, 6, 5, 3, 2, 1]);
        vec![
    // RG0 is exactly RG_MAX rows. If batch_size didn't divide evenly, RG0 could
}
        0,
    let file_b = tmp.path().join("b.parquet").to_string_lossy().to_string();
        &["ts".into()],
// Deferred data loading tests
        .filter_map(|e| {
        Field::new("val", DataType::Utf8, false),
        0,
            Arc::new(StringArray::from(vec!["a", "a", "a", "a", "a"])),
    assert_eq!(rg_sizes[1], n - RG_MAX);
    register_deferred_settings(index, 2, 0); // small batches force frequent batch transitions
    write_parquet(&file_b, &batch_b);
    let Some(input_dir) = input_dir() else {
    for batch in reader {
        .path()
    assert_eq!(rg_lasts[1], Some(n - 1));
        .join("merged.parquet")
        &[file_a, file_b],
        vec![Arc::new(Int64Array::from(vec![1, 2, 3, 10, 11, 12]))],
        &output,
    )
    merge_sorted(
        .to_string();
/// Helper: collect all parquet files in a directory (sorted by name).
    assert_eq!(rg_lasts[1], Some(n - 1));
    write_parquet(
        &[false],
    let tmp = tempdir().unwrap();
    merge_sorted(
use std::sync::Arc;
        &[false],
fn test_all_duplicate_sort_keys_large() {
}
                .join(format!("{}.parquet", i))
    std::env::var("PARQUET_TEST_INPUT_DIR").ok()
        schema_b.clone(),
            Arc::new(Int64Array::from(vec![20, 40, 60, 80, 100])),
    assert_eq!(vals, expected);
        &output,
    .unwrap();
            Arc::new(Int64Array::from(vec![1, 3, 5])),
    println!("Output rows: {}", actual_rows);
        &[file_1, file_2, file_3],
        return;
/// boundaries during the drain loop.
        .unwrap()
    )
    // TIER 1 should drain B entirely without heap operations
    .unwrap();
        let idx = batch.schema().index_of("name").unwrap();
    // Build expected: interleaved evens/odds up to 399_999, then remaining evens
#[test]
        &[false],
    let vals = read_col_i64(&output, "v");
use opensearch_parquet_format::merge::{merge_sorted, merge_unsorted};
    let a_vals: Vec<i64> = (0..5).flat_map(|i| vec![i * 10 + 1, i * 10 + 2]).collect();
}
    files
        &RecordBatch::try_new(
    // 1_500_000 rows in one file → RG0=1_000_000, RG1=500_000
fn test_eager_forced_by_high_threshold() {
    let batch_a = RecordBatch::try_new(
    let a_count: i64 = 150_001;
    ]
const ROWS_PER_FILE: i64 = 700_000; // 2 files → 1_400_000 total → RG0=1_000_000, RG1=400_000
        &RecordBatch::try_new(schema.clone(), vec![Arc::new(Int64Array::from(vals))]).unwrap(),
#[test]
        let arr = batch
                    if out_of_order <= 5 {
    assert_eq!(n1_d, n1_e, "n1 column differs between deferred and eager");
        &[],
    write_parquet(
        .to_string_lossy()
    let output = tmp.path().join("out.parquet").to_string_lossy().to_string();
        &[],
    let schema = Arc::new(Schema::new(vec![Field::new("v", DataType::Int64, false)]));
        vec![
    merge_sorted(
        &[],
        &output_eager,
        &file_a,
    );
    let rdr = builder.build().unwrap();
        .chain((0..half).map(|i| Some(i * 2)))
        &[false],
            let reader = SerializedFileReader::new(File::open(f).unwrap()).unwrap();
//   - Exact null count and null positions for nulls_first/nulls_last
        &[false],
            Arc::new(StringArray::from(vec!["B5", "B6", "B7"])),
        &[false],
        schema.clone(),
    .unwrap();
    let index_deferred = "test_deferred_vs_eager_deferred";
}
    assert!(out_vals.iter().all(|v| *v == Some(42)));
#[test]
        "test_skewed_large_small",
    )
    )
        Field::new("ts", DataType::Int64, false),
        "RG0 size: exact because batch_size=100_000 divides RG_MAX"
        &output,
    let file_a = tmp.path().join("a.parquet").to_string_lossy().to_string();
            rows_checked += 1;
        .build()
        .path()
    merge_sorted(
    register_deferred_settings(index, 4, 0);
    let schema_3 = Arc::new(Schema::new(vec![
        let batch = batch.unwrap();
    assert_eq!(rg_sizes[1], expected_rg_size, "RG1 size");
        &["v".into()],
        schema.clone(),
}
    let vals = read_all_int64(&output, "v");
    .unwrap();
        &[],
    .unwrap();
    let output = tmp.path().join("merged_sorted.parquet");
        ],
    // This forces many yield events as each batch boundary in A jumps past B's
        .unwrap();
        &[],
    let out_vals = read_col_i64(&output, "v");
        firsts.push(all[offset]);
    // File A: [1] — exhausts immediately
    let output = tmp
    let b_vals: Vec<Option<i64>> = (0..half)
        Field::new("city", DataType::Utf8, true),
    let file_b = tmp.path().join("b.parquet").to_string_lossy().to_string();
    )
    write_parquet(&file_b, &batch_b);
    let schema_1 = Arc::new(Schema::new(vec![
        Field::new("s3", DataType::Utf8, false),
    );
        &[file_a.clone(), file_b.clone()],
        0,
    assert_eq!(rg_sizes.len(), 2);
    for (i, v) in out_vals.iter().enumerate() {
    )
    let total = a_count + b_count;
    // Expected: 1,2,3,4,5,6,7,8
fn test_deferred_tier3_many_cursors() {
        vec![
    // ── Row group structure ──────────────────────────────────────────────
    assert_eq!(
    for batch in reader {
    assert_eq!(rg_firsts[1], Some(expected_rg_size));
    let (rg_sizes, rg_firsts, rg_lasts) = inspect_row_groups(&output, "v");
        return;
        name_vals,
    register_deferred_settings(index_deferred, 3, 0);
fn test_unsorted_merge_real_files() {
        &[false],
        schema.clone(),
    let ts_vals = read_all_int64(&output, "ts");
        &["v".into()],
    )
        &[file_a, file_b],
    let schema_a = Arc::new(Schema::new(vec![
    assert_eq!(rg_lasts[0], Some(total - RG_MAX), "RG0 last value");
    );
                Arc::new(Int64Array::from(vals)),
            Arc::new(StringArray::from(vec!["c1", "c3", "c5"])),
        .to_string_lossy()
        vec![
    }
        vec![Arc::new(Int64Array::from(vec![7, 6, 5]))],
    register_small_batch_size(index, 2);
//   - Exact row group sizes (first=1_000_000, second=400_000)
    // File B: [5, 6, 7]
}
    .unwrap();
fn test_skewed_file_sizes_large_small() {
    let info_vals = read_all_strings(&output, "info");
    let batch_size: usize = 100_001;
            Arc::new(Int64Array::from(vec![200, 400, 600, 800, 1000])),
    // Run with eager (threshold=9999)
}
    let tmp = tempdir().unwrap();
            let p = tmp
    }
        lasts.push(all[end - 1]);
        index,
    let output = tmp.path().join("out.parquet").to_string_lossy().to_string();
            Arc::new(StringArray::from(vec![Some("b1"), Some("b3"), Some("b5")])),
    }
        .unwrap();
    assert_eq!(rg_sizes[1], ROWS_PER_FILE * 2 - RG_MAX, "RG1 size");
    let mut vals = Vec::new();
            .downcast_ref::<StringArray>()
    assert_eq!(rg_sizes.len(), 2);
            vals.push(if arr.is_null(i) {
        .to_string_lossy()
    assert_eq!(ts_vals, vec![1, 2, 3, 4, 5, 6, 7, 8]);
    assert_eq!(ts_vals, vec![1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12]);
    expected.extend(odds);
#[test]
        &[],
        Field::new("ts", DataType::Int64, false),
        .join("merged.parquet")
            Arc::new(StringArray::from(vec!["a1", "a3", "a5"])),
        schema.clone(),
        &[],
            Arc::new(Int64Array::from(vec![1])),
        ],
    let batch_a = RecordBatch::try_new(
            Arc::new(Int64Array::from(vec![1, 2])),
        out_of_order, 0,
        Field::new("col_b", DataType::Utf8, true),
        &output,
    let file_3 = tmp.path().join("f3.parquet").to_string_lossy().to_string();
}
        &[],
        &file_c,
    let a_count: i64 = 100_000;
    write_parquet(&file_a, &batch_a);
            .column(col_idx)
    let reader = ParquetRecordBatchReaderBuilder::try_new(file)
    let file = File::open(path).unwrap();
/// batch is buffered, so the RG contains all buffered rows including the
    let rg0_last_nonnull = RG_MAX - total_nulls - 1; // = 1_000_000 - 700_000 - 1 = 299_999
    let c_count: i64 = 100_000;
    let n_rg = meta.num_row_groups();
    ]));
    let tmp = tempdir().unwrap();
    let schema = Arc::new(Schema::new(vec![Field::new("v", DataType::Int64, false)]));
        .iter()
            Arc::new(Int64Array::from(vec![7, 6, 5])),
    let tmp = tempdir().unwrap();
            .column(idx)
    )
    );
            .downcast_ref::<StringArray>()
        &[],
    .unwrap();
    let schema = Arc::new(Schema::new(vec![
            p
    ]));
    let file_a = tmp.path().join("a.parquet").to_string_lossy().to_string();
        .to_string();
        vec![
/// All-duplicate values: every row in every file has the same sort key.
}
    )
        "test-index",
    );
        &[file_a, file_b],
        &["ts".into()],
        &[false],
    assert_eq!(vals, vec![1, 2, 3, 5, 6, 7, 10, 11, 12]);
}
        }
    let expected_rg_size = (batch_size * 10) as i64; // 1_000_010
/// handles mismatched schemas correctly.
/// overshoot).
    let ts_d = read_all_int64(&output_deferred, "ts");
    let output = tmp.path().join("out.parquet").to_string_lossy().to_string();
        },
    let tmp = tempdir().unwrap();
        &[],
    // File B: odds  1, 3, 5, ...,   399_999  (200_000 values, exhausts early)
    let tmp = tempdir().unwrap();
        })
    );
        eprintln!("Skipping: {} not found", input_dir);
        schema.clone(),
                .to_string_lossy()
        .to_string_lossy()
        .join("merged.parquet")
    let p_vals = read_all_strings(&output, "payload");
        info_vals,
    write_parquet(
    write_parquet(&file_a, &batch_a);
    .unwrap();
        vec![Arc::new(Int64Array::from(a_vals.clone()))],
            Arc::new(Int64Array::from(vec![1, 3, 5, 7])),
}
    let vals = read_all_int64(&output, "v");
        for i in 0..arr.len() {
    writer.write(batch).unwrap();
    write_parquet(
        let arr = batch
        assert_eq!(*v, Some(i as i64), "wrong value at row {}", i);
        vec![Arc::new(Int64Array::from(b_vals.clone()))],
    }
        .unwrap()
    let total = large + small;
#[test]
        &["v".into()],
        vec![Arc::new(Int64Array::from(vec![12, 11, 10, 3, 2, 1]))],
            Arc::new(StringArray::from(vec!["b1", "b3", "b5"])),
            } else {
    write_parquet(
        for i in 0..col.len() {
    let index = "test_eager_forced_by_high_threshold";
    let file_b = tmp.path().join("b.parquet").to_string_lossy().to_string();
            Arc::new(StringArray::from(vec!["A1", "A3", "A5", "A7"])),
    let s1_e = read_all_strings(&output_eager, "s1");
        &output,
        Field::new("ts", DataType::Int64, false),
    .unwrap();
        let batch = batch.unwrap();
    .unwrap();
    let batch_a = RecordBatch::try_new(
fn count_rows_in_files(files: &[String]) -> i64 {
        &[],
        ],
    let file = File::open(path).unwrap();
    // File B: [3, 4, 5, 6, 7, 8] — becomes the sole cursor after A exhausts
    // RG0: all nulls first, then non-nulls 0..(RG_MAX - total_nulls - 1)
    let schema = Arc::new(Schema::new(vec![
            } else {
    let expected_rows = count_rows_in_files(&files);
    let schema = Arc::new(Schema::new(vec![Field::new("v", DataType::Int64, false)]));
        &[],
        &[],
    let out_vals = read_col_i64(&output, "v");
    let ts_vals = read_all_int64(&output, "ts");
        &[],
    assert_eq!(
    let index = "test_deferred_different_schemas";
        &[true],
// Writes 1.4M rows across 2 files to force exactly 2 row groups.
            }
        vec![
        schema.clone(),
    let ts_vals = read_all_int64(&output, "ts");
            Arc::new(Int64Array::from(vec![1, 2, 5, 6])),
    let output = tmp
    }
    }
    // col_d only in file B — file A rows should be null
                        eprintln!(
        0,
        0,
    write_parquet(&file_a, &batch_a);
    let tmp = tempdir().unwrap();
        .map(|_| None)
    )
        Field::new("ts", DataType::Int64, false),
    write_parquet(&file_b, &batch_b);
    .unwrap();
    let file = File::open(&output).unwrap();
        0,
#[test]
        &[false],
    let file_a = tmp.path().join("a.parquet").to_string_lossy().to_string();
        &["v".into()],
        }
        .unwrap(),
    let index = "test_deferred_tier1_single_cursor_drain";
    let (rg_sizes, rg_firsts, rg_lasts) = inspect_row_groups(&output, "v");
        .unwrap()
    .unwrap();
        .join("merged_eager.parquet")
        Field::new("col_a", DataType::Utf8, false),
            vec![Arc::new(Int64Array::from(a_vals.clone()))],
        Field::new("col_b", DataType::Utf8, true),
    write_parquet(
                .path()
        .build()
    for i in 0..total_nonnulls as usize {
        0, // reverse=true (descending)
    let a_vals: Vec<Option<i64>> = (0..half)
    let vals = read_all_int64(&output, "v");
        Field::new("ts", DataType::Int64, false),
    let batch_3 = RecordBatch::try_new(
        &file_a,
    let tmp = tempdir().unwrap();
    write_parquet(
    write_parquet(&file_a, &batch_a);
        let col = batch
