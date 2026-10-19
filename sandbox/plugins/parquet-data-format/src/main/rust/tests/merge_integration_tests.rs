        &file_b,
        }
            .downcast_ref::<StringArray>()
    let batch_b = RecordBatch::try_new(
    assert_eq!(
    // File A: [null * half, 0, 2, 4, ..., (half-1)*2]
    let tmp = tempdir().unwrap();
    ]));
                .join(format!("{}.parquet", i))
        .join("merged.parquet")
    .unwrap();
    let file_b = tmp.path().join("b.parquet").to_string_lossy().to_string();
    let tmp = tempdir().unwrap();
    let tmp = tempdir().unwrap();
        &output,
    write_parquet(&file_a, &batch_a);
        &output,
        &[file_a, file_b],
    // nulls_first=true → merged: null*(half*2), 0, 1, 2, ..., (half-1)*2+1
        .chain(c_vals.iter())
    let file_1 = tmp.path().join("f1.parquet").to_string_lossy().to_string();
    let tmp = tempdir().unwrap();
    register_deferred_settings(index, 2, 0); // batch_size=2
}
    }
    // File B: [1, 4, 7, ...,  29_998]  ( 10_000 values, step 3 — exhausts first)
        let batch = batch.unwrap();
/// Single file with >1M rows: no merge needed, just copy through.
    )
        &[false],
    let batch_a = RecordBatch::try_new(
        Field::new("name", DataType::Utf8, true),
fn read_all_strings(path: &str, col: &str) -> Vec<String> {
        Field::new("payload", DataType::Utf8, false),
        0,
    let batch_b = RecordBatch::try_new(
    (sizes, firsts, lasts)
        .collect();
        ],
    };
        Field::new("col_a", DataType::Utf8, false),
    // File A: [1, 2, 5, 6] with batch_size=2 → cursor batches [1,2] and [5,6]
    write_parquet(
    .unwrap();
        &output,
fn count_rows_in_files(files: &[String]) -> i64 {
    .unwrap();
        &[],
/// Verifies data is loaded once for the full batch slice.
            Arc::new(Int64Array::from(vec![1, 3, 5, 7])),
        vec![
        &[],
        )
}
    merge_sorted(
        ],
        .join("merged_deferred.parquet")
            .as_any()
    let batch_b = RecordBatch::try_new(
        .path()
/// Register a small merge_batch_size for the given index so the cursor splits into multiple batches.
 * compatible open source license.
    let total_nonnulls = half * 2; // 700_000  (values 0..699_999)
fn test_deferred_tier2_descending() {
    let index = "test_deferred_wide_schema_correctness";
        .collect();
    let src_vals = read_all_strings(&output, "src");
            col_a_nulls.push(arr.is_null(i));
        &[false],
fn test_tier2_yield_descending() {
    assert_eq!(extra_vals, vec!["NULL", "x2", "x3", "NULL", "x5", "x6"]);
            Arc::new(StringArray::from(vec![Some("e2"), Some("e4"), Some("e6")])),
/// Helper: read all String values from a column.
        .unwrap()
        schema.clone(),
    let file_a = tmp.path().join("a.parquet").to_string_lossy().to_string();
}
fn test_tier2_yield_many_small_batches() {
/// TIER 3 deferred with many cursors — stress test for data reader sync
    assert!(rg_firsts.iter().all(|v| *v == Some(42)));
    let output = tmp.path().join("out.parquet").to_string_lossy().to_string();
        &[],
        &RecordBatch::try_new(schema.clone(), vec![Arc::new(Int64Array::from(a_vals))]).unwrap(),
        }
    merge_sorted(
            ])),
    // File A: [1, 2, 3, 10, 11, 12] with batch_size=3 → cursor batches [1,2,3] then [10,11,12]
    write_parquet(
    write_parquet(&file_a, &batch_a);
 *
            .downcast_ref::<StringArray>()
    for (i, v) in out_vals.iter().enumerate() {
    let (rg_sizes, rg_firsts, rg_lasts) = inspect_row_groups(&output, "v");
        eprintln!("Skipping: {} not found", input_dir);
    );
#[test]
        schema.clone(),
    register_deferred_settings(index, 2, 0); // batch_size=2, always deferred
                continue;
    assert!(!files.is_empty(), "No parquet files found in {}", input_dir);
            .to_string();
        &[file_a, file_b],
    let index = "test_tier2_yield_many_small_batches";
#[test]
        &[],
    assert_eq!(rg_lasts[0], Some(RG_MAX - 1), "RG0 last value");
        &[file_a, file_b],
    let files: Vec<String> = (0..3)
fn test_deferred_different_schemas() {
        &[],
}
        .to_string_lossy()
            assert!(!col.is_null(i), "__row_id__ should never be null");
/// Threshold set very high → forces eager mode even with many string columns.
        &[false],
        &[file_a, file_b],
    let tmp = tempdir().unwrap();
    let b_count: i64 = 149_999;
    // Merged: 0,1,2,3,4,5,...,29_998,29_999(missing from B),30_000,...
        .build()
    );
        &[false],
    write_parquet(
    let n1_e = read_all_int64(&output_eager, "n1");
        &[true],
        let batch = batch.unwrap();
    let output = tmp.path().join("out.parquet").to_string_lossy().to_string();
        &[false],
    let file_a = tmp.path().join("a.parquet").to_string_lossy().to_string();
        &[false],
    let file_b = tmp.path().join("b.parquet").to_string_lossy().to_string();
    expected.extend(odds);
use parquet::arrow::arrow_reader::ParquetRecordBatchReaderBuilder;
        rg_sizes[0],
        &["v".into()],
// ─── Large-file edge case tests ───────────────────────────────────────────────────
            .column(idx)
        &[],
        ],
    if !Path::new(&input_dir).exists() {
    )
            .as_any()
        .to_string_lossy()
    }
            schema.clone(),
    write_parquet(
    //
    let mut out_of_order: i64 = 0;
    let actual_rows = count_rows(&output_str);
    )
/// Merge three files with progressively wider schemas in deferred mode —
            rows_checked += 1;
}
    let reader = ParquetRecordBatchReaderBuilder::try_new(file)
        Field::new("col_c", DataType::Utf8, false),
            vec![Arc::new(Int64Array::from(a_vals.clone()))],
    let batch_b = RecordBatch::try_new(
    let file_a = tmp.path().join("a.parquet").to_string_lossy().to_string();
            let p = tmp
/// output_flush_rows=1_000_000. After 9 batches: 900_009 rows buffered.
            schema.clone(),
    // RG1 = rows 1_000_000..1_399_999 → values 1_000_000..1_399_999
    write_parquet(&file_b, &batch_b);
            schema.clone(),
            .path()
    // col_a only in file A — file B rows should be null
    )
                col_d_vals.push("NULL".to_string());
        },
    // File B: [null * half, 1, 3, 5, ..., (half-1)*2+1]
use opensearch_parquet_format::native_settings::NativeSettings;
        &["ts".into()],
        &["v".into()],
        &[],
            Arc::new(StringArray::from(vec![Some("NYC"), Some("LA")])),
    );
        0,
            .column(col_idx)
        vec![Arc::new(Int64Array::from(vec![10, 11, 12]))],
        Field::new("col_b", DataType::Utf8, true),
        .map(|i| {
        .join("merged.parquet")
    );
        .to_string_lossy()
fn test_default_settings_ascending_nulls_first() {
    .unwrap();
    assert_eq!(vals, vec![1, 2, 3, 4, 10, 11, 12, 20, 21, 30, 31]);
    let batch_b = RecordBatch::try_new(
        &RecordBatch::try_new(schema.clone(), vec![Arc::new(Int64Array::from(b_vals))]).unwrap(),
    )
    for i in 0..total_nulls as usize {
    let tmp = tempdir().unwrap();
        vec![
    let batch_b = RecordBatch::try_new(
        index,
    register_small_batch_size(index, 2);
/// boundaries during the drain loop.
        ],
    let output = tmp
        let idx = batch.schema().index_of(col).unwrap();
    let files: Vec<String> = vec![
    assert!(out_vals.iter().all(|v| *v == Some(42)));
            Arc::new(Int64Array::from(vec![5, 6, 7])),
        &[],
        &output,
    }
        schema.clone(),
        "test-index",
    .unwrap();
/// Helper: register settings with a specific deferred threshold.
                Some(p.to_string_lossy().to_string())
    // File A: evens, File B: odds — interleaved merge = 0,1,2,...
        0,
    let output = tmp.path().join("merged_sorted.parquet");
    assert_eq!(actual_rows, expected_rows, "Row count mismatch");
        vec![
    .unwrap();
        .join("merged_eager.parquet")
        let col = batch
        &files,
                        eprintln!(
        &[file_a, file_b],
    let schema = Arc::new(Schema::new(vec![Field::new("v", DataType::Int64, false)]));
/// Read all Int64 values from a column.
    let a_vals = read_all_strings(&output, "col_a");
            expected += 1;
    assert_eq!(
        &[false],
    );
            Arc::new(StringArray::from(vec![Some("x2"), Some("x5")])),
        vec![
    )
            .as_any()
    let index = "test_deferred_three_files_different_schemas";
    let batch_a = RecordBatch::try_new(
    )
}
        vec!["a", "b", "c", "d", "a", "b", "c", "d", "a", "b", "c", "d"]
        return;
    // heap_top from B is 5. Since 10 > 5, A must yield to heap.
    // One file with 2_000_002 rows (20 full batches of 100_001)
        schema.clone(),
    assert_eq!(rg_sizes.len(), 2);
    let b_vals: Vec<i64> = (0..b_count).map(|i| i * 2 + 1).collect();
        vec![
            prev = Some(val);
    assert_eq!(s1_d, s1_e, "s1 column differs between deferred and eager");
use parquet::arrow::ArrowWriter;
        schema.clone(),
        ("c", vec![3, 7, 11]),
    std::env::var("PARQUET_TEST_INPUT_DIR").ok()
    let batch_1 = RecordBatch::try_new(
        vec![
    // Build expected: interleaved evens/odds up to 399_999, then remaining evens
        &[false],
        0,
        vec![Arc::new(Int64Array::from(vec![3, 4, 30, 31]))],
    let file = File::open(&output_str).unwrap();
    let vals: Vec<i64> = vec![42i64; n as usize];
    let index = "test_deferred_tier3_many_cursors";
        .path()
 * The OpenSearch Contributors require contributions made to
    // Merged descending: 1_399_999, 1_399_998, ..., 1, 0
    let a_count: i64 = 150_001;
        ],
    assert_eq!(rg_sizes.len(), 2);
    let out_vals = read_col_i64(&output, "v");
        let labels: Vec<&str> = vals.iter().map(|_| label).collect();
        0,
    let tmp = tempdir().unwrap();
    let batch_b = RecordBatch::try_new(
    assert_eq!(rg_firsts[0], Some(0));
        .unwrap();
    let mut name_vals = Vec::new();
    let ts_vals = read_all_int64(&output, "ts");
    let b_vals: Vec<i64> = (0..ROWS_PER_FILE).map(|i| i * 2 + 1).collect();
    let total = a_count + b_count + c_count;
        schema.clone(),
        .join("merged.parquet")
    // RG0 is exactly RG_MAX rows. If batch_size didn't divide evenly, RG0 could
        "test_non_multiple_batch",
        ],
    let file_b = tmp.path().join("b.parquet").to_string_lossy().to_string();
    let file_a = tmp.path().join("a.parquet").to_string_lossy().to_string();
        schema.clone(),
fn read_col_i64(path: &str, col: &str) -> Vec<Option<i64>> {
        0,
        ("b", vec![2, 6, 10]),
    let tmp = tempdir().unwrap();
        &[false],
        .unwrap(),
    // After B exhausts, A and C continue interleaving.
        .to_string_lossy()
        .unwrap();
    let file = File::open(&output).unwrap();
    let file_a = tmp.path().join("a.parquet").to_string_lossy().to_string();
    write_parquet(&file_3, &batch_3);
        &[false],
    // col_d only in file B — file A rows should be null
    )
        &[],
}
        Field::new("data", DataType::Utf8, false),
    .unwrap();
    assert_eq!(rg_firsts[1], Some(expected_rg_size));
    let file_a = tmp.path().join("a.parquet").to_string_lossy().to_string();
    assert_eq!(rg_lasts[0], Some(expected_rg_size - 1));
use tempfile::tempdir;
    let sort_cols = vec!["EventDate".to_string()];
        &[],
        Field::new("n1", DataType::Int64, false),
        vec![
        Field::new("country", DataType::Utf8, true),
    .map(|(name, vals)| {
    assert_eq!(actual_rows, expected_rows, "Row count mismatch");
    assert_eq!(rg_sizes.len(), 2, "expected exactly 2 row groups");
    }
        &[],
        RG_MAX,
    assert_eq!(ts_vals, vec![12, 11, 10, 7, 6, 5, 3, 2, 1]);
    let tmp = tempdir().unwrap();
    let mut expected: Vec<i64> = a_vals
use std::sync::Arc;
        0,
    let file_2 = tmp.path().join("f2.parquet").to_string_lossy().to_string();
                .to_string_lossy()
    )
    let batch_a = RecordBatch::try_new(
    let out_vals = read_col_i64(&output, "v");
        .to_string();
        index,
        vec![
        let arr = batch
    let index = "test_deferred_tier2_descending";
        &["ts".into()],
    // File B: [2, 4, 6, 8] — single batch
        vec![
    write_parquet(&file_b, &batch_b);
        .iter()
    println!("Verified __row_id__ is sequential 0..{}", expected);
    assert_eq!(rg_lasts[1], Some(n - 1));
    )
        let batch = batch.unwrap();
        &[],
    for (i, (got, exp)) in out_vals.iter().zip(expected.iter()).enumerate() {
    let file = File::open(path).unwrap();
    let file_c = tmp.path().join("c.parquet").to_string_lossy().to_string();
    write_parquet(&file_b, &batch_b);
            Arc::new(Int64Array::from(vec![1, 2])),
    assert_eq!(rg_lasts[0], Some(RG_MAX - 1));
        "RG0 size should be {} (overshoots RG_MAX={} by {}), got {}.",
            Arc::new(Int64Array::from(vec![2, 4, 6])),
}
            p
    .unwrap();
    )
use std::fs::File;
    let mut rows_checked: i64 = 0;
    let reader = ParquetRecordBatchReaderBuilder::try_new(file)
        .join("merged.parquet")
    assert_eq!(rg_firsts[0], Some(0));
    assert_eq!(ts_vals, vec![1, 2, 3, 4, 5, 6]);
        &[file_a, file_b],
        0, // reverse=true (descending)
        &["ts".into()],
        vec!["A1", "A2", "A3", "B5", "B6", "B7", "A10", "A11", "A12"]
    ]));
// ─── TIER 2 yield-to-heap tests ─────────────────────────────────────────────
fn test_deferred_vs_eager_identical_output() {
    .unwrap();
        return;
    let ts_vals = read_all_int64(&output, "ts");
            vals.push(arr.value(i).to_string());
// ═══════════════════════════════════════════════════════════════════════════════
    let index = "test_rg_overshoot";
        vec![Arc::new(Int64Array::from(b_vals.clone()))],
    assert_eq!(ts_vals, vec![1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12]);
    write_parquet(
        &[file_a, file_b],
    let builder = ParquetRecordBatchReaderBuilder::try_new(file).unwrap();
            } else {
            .column(idx)
    )
            }
            Arc::new(Int64Array::from(vec![3, 6])),
    let index = "test_tier2_yield_after_batch_boundary";
            vec![Arc::new(Int64Array::from(a_vals.clone()))],
    let index = "test_deferred_tier3_interleaved";
    )
    let file_b = tmp.path().join("b.parquet").to_string_lossy().to_string();
    );
#[test]
        &[],
        src_vals,
    let files = list_parquet_files(&input_dir);
#[test]
        Field::new("s1", DataType::Utf8, false),
        .to_string_lossy()
    // File A: [1,2, 11,12, 21,22, 31,32, 41,42] with batch_size=2
        &RecordBatch::try_new(
    vals
        vec![Arc::new(Int64Array::from(vec![5, 7, 8]))],
/// Two files where file A has two batches (small row group size forces batch boundary).
        .to_string();
    // 3 files × 500_000 rows, all with value=42
    );
        let idx = batch.schema().index_of(col).unwrap();
        let batch = batch.unwrap();
    );
        &output,
    let builder = ParquetRecordBatchReaderBuilder::try_new(file).unwrap();
    }
        Field::new("ts", DataType::Int64, false),
    // File B: odds  1, 3, 5, ...,   399_999  (200_000 values, exhausts early)
        &[],
        .to_string();
    let ts_vals = read_all_int64(&output, "ts");
        .to_string_lossy()
    assert_eq!(rg_sizes[1], expected_rg_size, "RG1 size");
        index,
            vec![
    assert_eq!(
        &[true],
        .path()
        &[],
        .join("merged.parquet")
            .column(idx)
        for i in 0..arr.len() {
    let output_eager = tmp
#[test]
        ],
    println!("Output rows: {}", actual_rows);
        }
    // After TIER 2 drains A batch 0 [1,2], A loads batch 1 starting at 5.
    ]));
    let file_a = tmp.path().join("a.parquet").to_string_lossy().to_string();
    .unwrap();
        Field::new("msg", DataType::Utf8, false),
            Arc::new(StringArray::from(vec!["c2", "c4", "c6"])),
            });
        &output,
    let output = tmp
        .path()
            Arc::new(StringArray::from(vec!["z", "z", "z", "z", "z"])),
    let reader = ParquetRecordBatchReaderBuilder::try_new(file)
        &[file_a, file_b],
    )
        "test_skewed_large_small",
    register_small_batch_size(index, 3);
        &[false],
// ─── Default batch size / row-group size tests ───────────────────────────────
        &["v".into()],
        0,
use parquet::file::reader::{FileReader, SerializedFileReader};
        index,
                None
}
        &[false],
    // "name" in files 1 and 2 only
    .unwrap();
            schema.clone(),
        &[false],
        0,
#[test]
    ]));
    .unwrap();
    .collect();
    let schema_a = Arc::new(Schema::new(vec![
    .unwrap();
    );
        vec![
        .map(|_| None)
            Arc::new(StringArray::from(vec!["a2", "a4", "a6"])),
        &[false],
    let schema_b = Arc::new(Schema::new(vec![
    assert_eq!(ts_vals, vec![1, 2, 3, 4, 5, 6, 7, 8]);
        &output,
    let make_batch = |vals: Vec<i64>, label: &str| {
    // Use a batch_size that doesn't divide evenly into RG_MAX
        &[],
                None
    let file_b = tmp.path().join("b.parquet").to_string_lossy().to_string();
        vec![
        .unwrap();
        Field::new("s3", DataType::Utf8, false),
    expected.extend((small..large).map(|i| i * 2));
}
    );
        "RG0 size: exact because batch_size=100_000 divides RG_MAX"
    write_parquet(&file_2, &batch_2);
#[test]
#[test]
    let mut expected: i64 = 0;
    let mut files: Vec<String> = std::fs::read_dir(dir)
            .unwrap();
        &[],
    .into_iter()
        &[false],
        0,
    register_deferred_settings(index, 3, 0); // threshold=0 → always deferred
    );
/// Merge files with different schemas in deferred mode — verifies that columns
        assert_eq!(
    // Descending merge expected: 12,11,10,7,6,5,3,2,1
            let val = col.value(i);
        }
    for (i, (got, exp)) in out_vals.iter().zip(expected.iter()).enumerate() {
    // ── Row group structure ──────────────────────────────────────────────
/// with row_idx > 0 (mid-batch position from a prior TIER 3 operation).
            Arc::new(StringArray::from(vec![
        .build()
            } else {
}
    assert!(output.exists(), "Output file was not created");
        Field::new("col_b", DataType::Utf8, false),
        ],
            Arc::new(StringArray::from(vec!["a"])),
        schema.clone(),
        .to_string_lossy()
    }
/*
        vec![
                Some(arr.value(i))
    let out_vals = read_col_i64(&output, "v");
        }
    register_deferred_settings(index, 3, 0);
    let file_a = tmp.path().join("a.parquet").to_string_lossy().to_string();
        let arr = batch
            "wrong non-null value at row {}",
            .unwrap();
    let actual_rows = count_rows(&output_str);
}
/// Heavily skewed file sizes: file A has 1.2M rows, file B has 200K rows.
        .unwrap();
        index,
        &files,
    assert_eq!(vals, vec![1, 2, 3, 5, 6, 7, 10, 11, 12]);
    let tmp = tempdir().unwrap();
    let file_a = tmp.path().join("a.parquet").to_string_lossy().to_string();
    };
// loads a new one, the new batch's first value is greater than the heap top,
        &["v".into()],
        &[false],
        &["ts".into()],
    assert_eq!(rg_firsts[1], Some(rg0_last_nonnull + 1), "RG1 first value");
        for i in 0..arr.len() {
            Arc::new(StringArray::from(vec!["b1", "b3", "b5"])),
        vec![Arc::new(Int64Array::from(vec![1, 2, 3, 10, 11, 12]))],
    )
    )
    )
            reader.metadata().file_metadata().num_rows()
            .join(format!("{}.parquet", name))
    )
        &[],
    assert_eq!(
        &[false],
    merge_sorted(
    )
    )
            .column(idx)
        &[],
        index,
    assert_eq!(n1_d, n1_e, "n1 column differs between deferred and eager");
        &output,
    let output = tmp.path().join("out.parquet").to_string_lossy().to_string();
    let batch_a = RecordBatch::try_new(
        index_deferred,
    let a_vals = read_all_strings(&output, "col_a");
    }
        Field::new("col_c", DataType::Utf8, false),
        schema.clone(),
    assert_eq!(vals.len() as i64, total);
        return;
        NativeSettings {
        .to_string();
    let mut firsts = Vec::new();
        0,
        &[false],
        )
    merge_sorted(
        &[false],
    );
    let output = tmp.path().join("out.parquet").to_string_lossy().to_string();
    assert!(output.exists(), "Output file was not created");
        &[false],
        &RecordBatch::try_new(schema.clone(), vec![Arc::new(Int64Array::from(vals))]).unwrap(),
        &["ts".into()],
        .to_string();
    let (rg_sizes, rg_firsts, rg_lasts) = inspect_row_groups(&output, "v");
        schema.clone(),
        Field::new("col_e", DataType::Utf8, true),
    register_deferred_settings(index_deferred, 3, 0);
    let c_count: i64 = 100_000;
    let n_rg = meta.num_row_groups();
    let expected_rg_size = (batch_size * 10) as i64; // 1_000_010
        &[],
        ],
        &[],
    }
        0,
            Arc::new(StringArray::from(vec![Some("alice"), Some("dave")])),
            Arc::new(StringArray::from(vec!["a1", "a3", "a5"])),
    .unwrap();
    // Compare outputs — must be identical
    let out_vals = read_col_i64(&output, "v");
    write_parquet(
    let col_idx = out_schema.index_of("EventDate").unwrap();
    assert_eq!(out_vals.len() as i64, total);
            Arc::new(Int64Array::from(vec![2, 3, 4, 5, 6, 7])),
    write_parquet(
    let mut expected: Vec<i64> = (0..small).map(|i| i * 2).collect(); // evens 0..399_998
 * SPDX-License-Identifier: Apache-2.0
        .path()
    let batch_a = RecordBatch::try_new(
/// Returns (row_group_sizes, per_rg_first_value, per_rg_last_value) for a nullable Int64 column.
        &[],
    let d_vals = read_all_strings(&output, "data");
    // File B: [3, 4, 5, 6, 7, 8] — becomes the sole cursor after A exhausts
    let b_vals: Vec<Option<i64>> = (0..half)
    // Total: 1_500_000 rows → 2 RGs
        let col = batch
    )
        &[],
    let file_a = tmp.path().join("a.parquet").to_string_lossy().to_string();
    );
    let file_a = tmp.path().join("a.parquet").to_string_lossy().to_string();
    let batch_b = RecordBatch::try_new(
    assert_eq!(vals, expected);
            write_parquet(
            Arc::new(StringArray::from(vec!["a2", "a4", "a6"])),
    )
#[test]
        .path()
            Arc::new(StringArray::from(vec!["p3", "p4", "p7", "p8"])),
    let schema = Arc::new(Schema::new(vec![Field::new("v", DataType::Int64, false)]));
            Arc::new(StringArray::from(vec!["p1", "p2", "p5", "p6"])),
            if arr.is_null(i) {
            Arc::new(StringArray::from(vec![Some("b1"), Some("b3"), Some("b5")])),
    assert_eq!(b_vals, vec!["b1", "b2", "b3", "b4", "b5", "b6"]);
    let schema = Arc::new(Schema::new(vec![
    let odds: Vec<i64> = (0..small).map(|i| i * 2 + 1).collect(); // odds  1..399_999
    assert_eq!(col_a_nulls, vec![false, true, false, true, false, true]);
        expected_rg_size - RG_MAX,
        vec![
            ..Default::default()
#[test]
    )
        &[],
        vec![Arc::new(Int64Array::from(vec![7, 6, 5]))],
/// 10th batch pushes 100_001 more → 1_000_010 rows → flush with 1_000_010.
        let batch = batch.unwrap();
fn test_default_settings_ascending_nulls_last() {
        let end = offset + sz as usize;
    let schema = Arc::new(Schema::new(vec![Field::new("v", DataType::Int64, false)]));
            }
        &file_b,
 */
        .to_string();
/// Stress test: many small batches forcing repeated yield-to-heap transitions.
    let file_a = tmp.path().join("a.parquet").to_string_lossy().to_string();
}
#[test]
    merge_unsorted(&files, &output_str, "test-index", 0, &[]).unwrap();
            .unwrap();
/// correct RG splits with exact values.
        assert_eq!(*v, Some(i as i64), "wrong value at row {}", i);
    }
        &RecordBatch::try_new(schema.clone(), vec![Arc::new(Int64Array::from(vals))]).unwrap(),
    )
    let batch_b = RecordBatch::try_new(
    )
        .sum()
    let batch_b = RecordBatch::try_new(
fn write_parquet(path: &str, batch: &RecordBatch) {
                Arc::new(Int64Array::from(vals)),
        &[false],
        vec![
/// File sizes that are not multiples of batch_size (100_000):
    .unwrap();
        0,
    let file_3 = tmp.path().join("f3.parquet").to_string_lossy().to_string();
            Arc::new(Int64Array::from(vec![2, 4, 6])),
            ])),
    let a_vals: Vec<i64> = (0..ROWS_PER_FILE).rev().map(|i| i * 2).collect();
//   - Exact row group sizes (first=1_000_000, second=400_000)
        &[false],
    let file_b = tmp.path().join("b.parquet").to_string_lossy().to_string();
    let meta = reader.metadata();
    let file_a = tmp.path().join("a.parquet").to_string_lossy().to_string();
    .unwrap();
    // With default batch_size=100_000 which divides evenly into RG_MAX=1_000_000,
    // Run with eager (threshold=9999)
        .copied()
    //
    let index = "test_deferred_tier1_single_cursor_drain";
    let batch_2 = RecordBatch::try_new(
        vec![Arc::new(Int64Array::from(vec![5, 6, 7]))],
    let output = tmp
    )
fn test_deferred_tier1_single_cursor_drain() {
        for i in 0..arr.len() {
    )
/// TIER 2 deferred with descending sort — verifies deferred works with reverse order.
        vec!["first", "second", "t3", "t4", "t5", "t6", "t7", "t8"]
    register_deferred_settings(index_eager, 3, 9999);
        &[false],
        schema_3.clone(),
            } else {
    let mut vals = Vec::new();
        let arr = batch
        Field::new("name", DataType::Utf8, true),
            .column(idx)
        &[],
/// Deferred mode with TIER 3 (partial batch emit) — verifies data reader
            .unwrap();
        msg_vals,
    for batch in reader {
            Some(i as i64),
    println!("Found {} input files", files.len());
    );
        &[],
    .unwrap();
    register_small_batch_size(index, 2);
    )
        &[false],
    //   total nulls  = 700_000
            vals.push(if arr.is_null(i) {
    let file_b = tmp.path().join("b.parquet").to_string_lossy().to_string();
        let idx = batch.schema().index_of("col_a").unwrap();
    vals
            );
            }
    let schema = Arc::new(Schema::new(vec![Field::new("v", DataType::Int64, false)]));
}
    let output = tmp
    write_parquet(&file_b, &batch_b);
        0,
        Field::new("ts", DataType::Int64, false),
    expected.sort();
    // File A: evens  [0, 2, 4, ..., (ROWS_PER_FILE-1)*2]   — 700_000 values
    let ts_vals = read_all_int64(&output, "ts");
            Arc::new(StringArray::from(vec!["b2", "b3", "b4", "b5", "b6", "b7"])),
        .unwrap(),
/// transition mid-merge with two remaining cursors still active.
    write_parquet(
        index,
/// Three files where the middle file exhausts first, forcing a TIER 1
/// handles mismatched schemas correctly.
    let batch_size: usize = 100_001;
    let schema_2 = Arc::new(Schema::new(vec![
/// Verifies total row count is preserved and no rows are dropped or duplicated.
    let file = File::open(&output).unwrap();
/// TIER 2 deferred: entire batch fits before heap top — emits full batch at once.
        ],
    assert_eq!(ts_vals, vec![1, 2, 3, 4, 5, 6]);
#[test]
        .join("merged.parquet")
/// missing in some files are padded with nulls and the deferred data reader
        .map(|f| {
    // heap_top from B is also 5. Since 5 == 5 (not Greater), A should NOT yield.
    write_parquet(&file_a, &batch_a);
        &[file_a],
    files.sort();
        path
/// Verifies that RG size can exceed RG_MAX when a pushed slice straddles the
                .unwrap(),
        &output,
        &reverse,
    let mut prev: Option<i64> = None;
    let mut expected: Vec<i64> = a_vals.iter().chain(b_vals.iter()).copied().collect();
        .path()
        let idx = batch.schema().index_of("country").unwrap();
    // File B: [5, 6, 7]
        &sort_cols,
    let output = tmp
        &["v".into()],
fn test_single_large_file_passthrough() {
        vec!["a12", "a11", "a10", "b7", "b6", "b5", "a3", "a2", "a1"]
        &RecordBatch::try_new(schema.clone(), vec![Arc::new(Int64Array::from(b_vals))]).unwrap(),
    // File A: evens descending  [(ROWS_PER_FILE-1)*2, ..., 2, 0]
        &[file_a.clone(), file_b.clone()],
    let c_vals = read_all_strings(&output, "col_c");
        ],
        .to_string_lossy()
    merge_sorted(
}
    for batch in reader {
    let file_a = tmp.path().join("a.parquet").to_string_lossy().to_string();
}
        &[false],
    let schema = Arc::new(Schema::new(vec![Field::new("v", DataType::Int64, false)]));
    let tmp = tempdir().unwrap();
        &[],
    )
        &[],
        &[file_1, file_2, file_3],
    )
    //
    let ts_vals = read_all_int64(&output, "ts");
    .unwrap();
        .chain((0..half).map(|i| Some(i * 2 + 1)))
        "Found {} out-of-order rows in EventDate",
        }
fn test_deferred_tier3_interleaved() {
    for (i, v) in out_vals.iter().enumerate() {
    )
        let arr = batch
            vals.push(arr.value(i));
        Field::new("val", DataType::Utf8, false),
                &RecordBatch::try_new(
        Field::new("ts", DataType::Int64, false),
    assert_eq!(vals, vec![12, 11, 10, 7, 6, 5, 3, 2, 1]);
    let tmp = tempdir().unwrap();
        }
        assert_eq!(vals[i], None, "expected null at row {}", i);
    let vals: Vec<i64> = (0..n).collect();
    let expected_rows = count_rows_in_files(&files);
    let batch_b = RecordBatch::try_new(
        vec!["alice", "bob", "NULL", "dave", "eve", "NULL"]
    write_parquet(&file_c, &batch_c);
/// Descending sort with yield-to-heap after batch boundary.
        let batch = batch.unwrap();
        .path()
    // 1_500_000 rows in one file → RG0=1_000_000, RG1=500_000
    files
        .build()
        Field::new("col_a", DataType::Utf8, true),
        &file_a,
    let file_b = tmp.path().join("b.parquet").to_string_lossy().to_string();
        &[],
        &["v".into()],
        let arr = batch
        &file_b,
    register_deferred_settings(index, 2, 0); // small batches force frequent batch transitions
    SETTINGS_STORE.insert(
    for (i, (got, exp)) in out_vals.iter().zip(expected.iter()).enumerate() {
            schema.clone(),
    // File B: [5, 7, 8]
        .join("merged.parquet")
    // Run with deferred (threshold=0)
///
    assert!(rg_lasts.iter().all(|v| *v == Some(42)));
    // After TIER 2 drains A batch 0 [12,11,10], A loads batch 1 starting at 3.
    register_small_batch_size(index, 3);
        &[file_a, file_b],
            Arc::new(StringArray::from(vec![Some("b2"), Some("b4"), Some("b6")])),
    let mut writer = ArrowWriter::try_new(file, batch.schema(), None).unwrap();
        lasts.push(all[end - 1]);
    // Sorted order: ts=[1,2,3,4,5,6], rows from file A at positions 0,2,4; file B at 1,3,5
    let file = File::open(&output).unwrap();
        .unwrap()
//   - Every single output value matches the expected sorted sequence
            if arr.is_null(i) {
    let batch_a = RecordBatch::try_new(
/// stays synchronized across batch boundaries.
        index,
        &RecordBatch::try_new(schema.clone(), vec![Arc::new(Int64Array::from(a_vals))]).unwrap(),
    // File B: [7, 6, 5] descending
            .column(col_idx)
        &[false],
use arrow::array::types::TimestampMillisecondType;
    let tmp = tempdir().unwrap();
}
    let a_vals: Vec<i64> = (0..a_count).map(|i| i * 2).collect();
    let tmp = tempdir().unwrap();
    let output = tmp
    merge_sorted(
/// RG0 will be 1_000_010, not exactly 1_000_000.
    // ── Exact value check ────────────────────────────────────────────────
fn test_tier2_yield_after_batch_boundary() {
    //   total non-nulls = 700_000  (values 0..699_999)
    }
    for batch in reader {
            ],
    assert_eq!(rg_lasts[0], Some(total - RG_MAX), "RG0 last value");
    let batch_b = RecordBatch::try_new(
        &["v".into()],
    let file = File::open(&output).unwrap();
        Field::new("src", DataType::Utf8, false),
    assert_eq!(rg_sizes[1], total - RG_MAX);
        &[],
    )
    register_deferred_settings(index, 3, 0);
    let mut col_a_nulls = Vec::new();
use arrow::datatypes::{DataType, Field, Schema};
                country_vals.push("NULL".to_string());
/// All-duplicate values: every row in every file has the same sort key.
    assert_eq!(rg_sizes[0], RG_MAX);
                        );
    //
// Writes 1.4M rows across 2 files to force exactly 2 row groups.
        .to_string_lossy()
    let (rg_sizes, rg_firsts, rg_lasts) = inspect_row_groups(&output, "v");
            merge_batch_size: Some(batch_size),
            Arc::new(Int64Array::from(vec![20, 40, 60, 80, 100])),
            Arc::new(StringArray::from(vec![
fn test_tier2_no_yield_when_equal_to_heap_top() {
    merge_sorted(
    let schema = Arc::new(Schema::new(vec![
    let schema = Arc::new(Schema::new(vec![
    // Fully interleaved → TIER 3 binary search on every pop
    .unwrap();
    assert_eq!(p_vals, vec!["p1", "p2", "p3", "p4", "p5", "p6", "p7", "p8"]);
    .unwrap();
    .unwrap();
    // Verify __row_id__ is sequential 0..N
        schema.clone(),
    .unwrap();
/// current position, so A must yield to the heap.
    let vals: Vec<i64> = (0..n).collect();
    assert_eq!(ts_vals, vec![1, 2, 3, 4, 5, 6, 7, 8]);
    assert_eq!(rg_sizes[1], n - RG_MAX);
    assert_eq!(vals.len() as i64, ROWS_PER_FILE * 2);
            .as_any()
        "test_default_asc_nulls_last",
    .unwrap();
        ],
        &["ts".into()],
    write_parquet(&file_a, &batch_a);
    println!("Total input rows: {}", expected_rows);
    // But counts differ so the last few values come only from one file.
    let out_vals = read_col_i64(&output, "v");
    for batch in reader {
    let schema = Arc::new(Schema::new(vec![
    let schema = Arc::new(Schema::new(vec![Field::new("v", DataType::Int64, true)]));
    )
/// multiple internal batches — verifies data reader advances across batch
        &output,
        "test_default_asc_nulls_first",
        schema.clone(),
    let schema = Arc::new(Schema::new(vec![
            .column(idx)
        &["v".into()],
    let reader = ParquetRecordBatchReaderBuilder::try_new(file)
    // File A: [1, 2, 20, 21] with batch_size=2 → cursor batches [1,2] and [20,21]
        schema.clone(),
    merge_sorted(
    let Some(input_dir) = input_dir() else {
    let file_b = tmp.path().join("b.parquet").to_string_lossy().to_string();
    .unwrap();
    )
    let file_a = tmp.path().join("a.parquet").to_string_lossy().to_string();
    let b_vals: Vec<i64> = (0..ROWS_PER_FILE).rev().map(|i| i * 2 + 1).collect();
            Arc::new(StringArray::from(vec!["b7", "b6", "b5"])),
    for (i, v) in vals.iter().enumerate() {
            .column(idx)
    )
    let tmp = tempdir().unwrap();
//   - Exact null count and null positions for nulls_first/nulls_last
        .collect();
        let idx = batch.schema().index_of("extra").unwrap();
    let reader = builder.build().unwrap();
        &[],
    let tmp = tempdir().unwrap();
    // overshoot (see test_rg_size_overshoots_when_batch_straddles_threshold).
            vec![Arc::new(Int64Array::from(b_vals.clone()))],
fn test_deferred_tier1_multi_batch_drain() {
        schema.clone(),
        &[],
    let half = ROWS_PER_FILE / 2; // 350_000
        let idx = batch.schema().index_of("name").unwrap();
        &[false],
            ..Default::default()
        eprintln!("Skipping: PARQUET_TEST_INPUT_DIR not set");
    // File A: evens 0, 2, 4, ..., 2_399_998  (1_200_000 values)
fn test_deferred_tier2_full_batch_emit() {
    .unwrap();
/// overshoot).
        &[false],
    write_parquet(&file_a, &batch_a);
    let sizes: Vec<i64> = (0..n_rg).map(|i| meta.row_group(i).num_rows()).collect();
    )
}
}
    write_parquet(&file_b, &batch_b);
/// TIER 1 deferred: single cursor remaining — drains all remaining rows.
    let file_b = tmp.path().join("b.parquet").to_string_lossy().to_string();
        .path()
    // File A: [1,2,5,6] → batches [1,2] and [5,6]
    let tmp = tempdir().unwrap();
    write_parquet(
    let batch_b = RecordBatch::try_new(
    .unwrap();
    assert_eq!(d_vals, vec!["A1", "B2", "A3", "B4", "A5", "B6", "A7", "B8"]);
        eprintln!("Skipping: PARQUET_TEST_INPUT_DIR not set");
        &file_a,
    let batch_b = RecordBatch::try_new(
    assert_eq!(out_vals.len() as i64, n);
    write_parquet(
            {
    })
#[test]
    assert_eq!(
        expected_rg_size,
            .downcast_ref::<arrow::array::Int64Array>()
    // File A: [1, 2, 3, 10, 11, 12] → batches [1,2,3] and [10,11,12]
        &file_c,
        RecordBatch::try_new(
        .to_string();
}
    assert_eq!(val_vals, vec!["a", "b2", "b3", "b4", "b5", "b6", "b7"]);
    assert_eq!(
    let vals = read_col_i64(&output, "v");
    let output_deferred = tmp
        &["v".into()],
        ],
    }
    )
        let arr = batch
        0,
    merge_sorted(
    // "extra" in files 2 and 3
    let mut all: Vec<Option<i64>> = Vec::new();
                country_vals.push(arr.value(i).to_string());
    let reverse = vec![false];
            if arr.is_null(i) {
    let mut extra_vals = Vec::new();
            if col.is_null(i) {
        .to_string_lossy()
    )
use opensearch_parquet_format::writer::SETTINGS_STORE;
//   - RG boundary: last value of RG0 < first value of RG1 (ascending)
        NativeSettings {
            Arc::new(Int64Array::from(vec![1, 2, 3, 10, 11, 12])),
        .index_of("__row_id__")
        .to_string_lossy()
        &[],
        .unwrap()
}
    assert_eq!(rg_lasts[1], Some(n - 1));
#[test]
    let tmp = tempdir().unwrap();
    // File B: odds  descending  [(ROWS_PER_FILE-1)*2+1, ..., 3, 1]
        .unwrap()
        vec![Arc::new(Int64Array::from(vec![1, 2, 20, 21]))],
    let b_count: i64 = 10_000;
        &[],
        0,
        &[],
        "test_all_dupes_large",
    assert_eq!(a_vals, vec!["a1", "a2", "a3", "a4", "a5", "a6"]);
        &file_b,
        .build()
    let a_vals: Vec<Option<i64>> = (0..half)
    let output = tmp
    let output = tmp
            }
    merge_sorted(
fn test_deferred_tier3_many_cursors() {
fn test_three_files_middle_exhausts_first() {
            .downcast_ref::<StringArray>()
fn test_deferred_three_files_different_schemas() {
    register_deferred_settings(index, 4, 0);
    .unwrap();
        vec![Arc::new(Int64Array::from(a_vals.clone()))],
        let arr = batch
fn count_rows(path: &str) -> i64 {
        .join("merged.parquet")
        .to_string_lossy()
        Field::new("ts", DataType::Int64, false),
        })
        &output,
    .unwrap();
    merge_sorted(
            Arc::new(StringArray::from(vec![Some("a1"), Some("a3"), Some("a5")])),
    // RG1 gets the remaining 1_000_010 - wait, 20 * 100_001 = 2_000_020 rows
    .unwrap();
    // Expected merge: 1,2,3,5,6,7,10,11,12
        schema.clone(),
        &[file_a, file_b],
    assert_eq!(out_vals.len() as i64, total);
            .to_string_lossy()
    // Exact boundary values
// ═══════════════════════════════════════════════════════════════════════════════
    let a_vals: Vec<i64> = (0..ROWS_PER_FILE).map(|i| i * 2).collect();
        &output_deferred,
    for (i, v) in vals.iter().enumerate() {
    .unwrap();
        assert_eq!(*got, Some(*exp), "wrong value at row {}", i);
        "test_three_files_middle_exhausts",
    register_small_batch_size(index, 2);
    .unwrap();
        ],
        schema.clone(),
    let mut lasts = Vec::new();
    merge_sorted(
            Arc::new(StringArray::from(vec!["a", "a", "a", "a", "a"])),
        &[false],
        )
    );
    // Descending: RG0 starts at max, ends at total-RG_MAX; RG1 starts one below that
        schema.clone(),
        }
            Arc::new(StringArray::from(vec![Some("x3"), Some("x6")])),
        &["v".into()],
#[test]
    write_parquet(&file_a, &batch_a);
}
        ],
    // Each RG should be exactly 10 * batch_size = 1_000_010 (overshoots RG_MAX by 10)
/// batch is buffered, so the RG contains all buffered rows including the
        &["ts".into()],
        schema_1.clone(),
    let mut country_vals = Vec::new();
fn test_deferred_multi_batch_sync() {
        country_vals,
                && !p.file_name()?.to_str()?.starts_with("merged")
            merge_batch_size: Some(batch_size),
    );
    for batch in reader {
        &[false],
    // File B: [2, 3, 4, 5, 6, 7] — 3 batches of 2 rows each, all drained by TIER 1
            if p.extension().and_then(|s| s.to_str()) == Some("parquet")
    // ── Row group structure ──────────────────────────────────────────────
    }
    }
        Field::new("tag", DataType::Utf8, false),
    let output = tmp
    println!("Output rows: {}", actual_rows);
    );
#[test]
    expected.sort();
    assert_eq!(rg_lasts[1], Some(0), "RG1 last value");
    assert_eq!(
        Field::new("ts", DataType::Int64, false),
    register_deferred_settings(index, 3, 0);
                Some(arr.value(i))
    // Exact value check
    let rdr = ParquetRecordBatchReaderBuilder::try_new(file)
    .unwrap();
    let file_b = tmp.path().join("b.parquet").to_string_lossy().to_string();
    let small: i64 = 200_000;
                )
/// Edge case: new batch starts exactly equal to heap top (should NOT yield).
        offset = end;
        0,
        0,
        ],
}
    if !Path::new(&input_dir).exists() {
    //
    let batch_a = RecordBatch::try_new(
    for batch in reader {
                if val < p {
    let tmp = tempdir().unwrap();
    ]));
    assert_eq!(rg_sizes.len(), 2);
        Field::new("ts", DataType::Int64, false),
            Arc::new(StringArray::from(vec!["c1", "c3", "c5"])),
    vals
// Deferred data loading tests
    assert_eq!(out_vals.len() as i64, total);
/// Deferred mode with multiple batches per cursor — verifies data reader
    let index = "test_tier2_no_yield_when_equal_to_heap_top";
    ]));
        &[false],
        &[false],
            Arc::new(Int64Array::from(vec![100, 300, 500, 700, 900])),
    let index_deferred = "test_deferred_vs_eager_deferred";
    let expected_rows = count_rows_in_files(&files);
    );
        for i in 0..col.len() {
}
    }
    let c_vals: Vec<i64> = (0..c_count).map(|i| i * 3 + 2).collect();
        expected_rg_size,
// ═══════════════════════════════════════════════════════════════════════════════
            .as_primitive::<arrow::datatypes::Int64Type>();
    reader.metadata().file_metadata().num_rows()
    ]));
    assert_eq!(
        .join("merged.parquet")
/// Wide schema with threshold=0 forces deferred mode. Verify all data columns
    // Batch [1,2,3] from A fits entirely before heap top (B=5) → TIER 2 emits all 3
            .downcast_ref::<PrimitiveArray<TimestampMillisecondType>>()
                    }
        &[false],
        &[file_a, file_b],
    merge_sorted(
        &[false],
    assert_eq!(rg_sizes.iter().sum::<i64>(), n);
        for i in 0..col.len() {
fn test_deferred_wide_schema_correctness() {
            schema.clone(),
fn test_eager_forced_by_high_threshold() {
        index,
        name_vals,
        vec![
    };
const RG_MAX: i64 = 1_000_000;
        .unwrap();
    merge_sorted(
/// TIER 1 deferred with multiple batches: the sole remaining cursor spans
// Deferred mode — TIER 1, 2, 3 correctness tests
fn read_all_int64(path: &str, col: &str) -> Vec<i64> {
            Arc::new(StringArray::from(vec!["b2", "b4", "b6"])),
        .join("merged.parquet")
fn test_skewed_file_sizes_large_small() {
    // 4 fully interleaved files:
#[test]
        &[true],
}
    assert_eq!(rg_firsts[0], Some(total - 1), "RG0 first value");
    let rdr = builder.build().unwrap();
        .unwrap()
    );
    assert_eq!(ts_vals, vec![1, 2, 3, 4, 5, 6]);
    assert!(!files.is_empty(), "No parquet files found in {}", input_dir);
        Field::new("extra", DataType::Utf8, true),
    .unwrap();
    // RG0 flushes after 10 batches = 1_000_010 rows (overshoots by 10)
    let mut offset = 0usize;
    );
        &[],
    let output = tmp
        &[],
    // current position and vice versa.
        Field::new("extra", DataType::Utf8, true),
#[test]
        &RecordBatch::try_new(
    )
    assert_eq!(ts_vals, vec![1, 2, 3, 4, 5, 6, 7, 8]);
    let b_vals: Vec<i64> = (0..5).flat_map(|i| vec![i * 10 + 5, i * 10 + 6]).collect();
    let schema = Arc::new(Schema::new(vec![Field::new("v", DataType::Int64, false)]));
        index,
        Field::new("col_b", DataType::Utf8, true),
    let file_a = tmp.path().join("a.parquet").to_string_lossy().to_string();
    ]));
    }
const ROWS_PER_FILE: i64 = 700_000; // 2 files → 1_400_000 total → RG0=1_000_000, RG1=400_000
    let ts_e = read_all_int64(&output_eager, "ts");
    write_parquet(&file_a, &batch_a);
        .join("merged.parquet")
        &[],
            .unwrap();
    write_parquet(&file_b, &batch_b);
    write_parquet(
    for i in 0..total_nonnulls as usize {
        .path()
    let b_vals = read_all_strings(&output, "col_b");
        &[],
/// across multiple interleaved cursors with small batch sizes.
        .path()
    let output = tmp.path().join("out.parquet").to_string_lossy().to_string();
        .path()
            .expect("__row_id__ should be Int64");
    ]));
    .unwrap();
    let file = File::open(path).unwrap();
#[test]
        vec![Arc::new(Int64Array::from(vec![1, 2, 5, 6]))],
        index.to_string(),
        ],
    let builder = ParquetRecordBatchReaderBuilder::try_new(file).unwrap();
    register_deferred_settings(index, 3, 9999); // threshold=9999 → always eager
    assert_eq!(rg_sizes[0], RG_MAX);
    let tmp = tempdir().unwrap();
        &output,
    let schema = Arc::new(Schema::new(vec![Field::new("v", DataType::Int64, false)]));
            }
    let n: i64 = 500_000;
    .unwrap();
    .unwrap();
        index_name.to_string(),
    )
        schema.clone(),
        assert_eq!(*got, Some(*exp), "wrong value at row {}", i);
}
    write_parquet(&file_a, &batch_a);
    // After TIER 2 drains A batch 0 [1,2,3], A loads batch 1 starting at 10.
    assert_eq!(a_vals, vec!["a1", "a2", "a3", "a4", "a5", "a6"]);
    .unwrap();
        "test_default_desc_nulls_last",
    let schema = Arc::new(Schema::new(vec![Field::new("v", DataType::Int64, false)]));
    let ts_vals = read_all_int64(&output, "ts");
        .collect();
        Field::new("ts", DataType::Int64, false),
    let rg0_last_nonnull = RG_MAX - total_nulls - 1; // = 1_000_000 - 700_000 - 1 = 299_999
        &[file_a, file_b],
        0,
        vec![
    assert_eq!(out_vals.len() as i64, n);
    let file_b = tmp.path().join("b.parquet").to_string_lossy().to_string();
    let mut expected: Vec<i64> = a_vals.iter().chain(b_vals.iter()).copied().collect();
    .unwrap();
}
        let batch = batch.unwrap();
    );
        0,
    let schema = Arc::new(Schema::new(vec![
            Arc::new(Int64Array::from(vec![200, 400, 600, 800, 1000])),
        &output,
    // RG boundary: last of RG0 must be strictly less than first of RG1
        Field::new("ts", DataType::Int64, false),
        &file_b,
        &RecordBatch::try_new(schema.clone(), vec![Arc::new(Int64Array::from(a_vals))]).unwrap(),
#[test]
    let vals = read_col_i64(&output, "v");
    merge_sorted(
    for &sz in &sizes {
        &RecordBatch::try_new(
/// flush threshold (output_row_count >= output_flush_rows fires AFTER the
    );
    assert_eq!(ts_vals, vec![1, 2, 3, 5, 6, 7, 10, 11, 12]);
        .to_string();
        })
    .unwrap();
/// Read every value of a nullable Int64 column.
    let vals = read_all_int64(&output, "v");
            Arc::new(StringArray::from(vec!["c", "c", "c", "c", "c"])),
        &[],
    )
        &file_a,
        .join("merged.parquet")
    .unwrap();
    // File B: [7, 6, 5]
    let file_b = tmp.path().join("b.parquet").to_string_lossy().to_string();
            .as_any()
    )
        })
            Arc::new(StringArray::from(vec!["c2", "c4", "c6"])),
/// Verify behavior is identical to deferred (output correctness).
        .unwrap()
        )
        &["ts".into()],
        &[false],
    assert_eq!(rg_sizes[0], RG_MAX);
    .unwrap();
            Arc::new(StringArray::from(vec![Some("c1"), Some("c3"), Some("c5")])),
        schema.clone(),
    // Verify EventDate is non-decreasing in the merged output
            }
    ]));
    }
        &["ts".into()],
    ]
// ═══════════════════════════════════════════════════════════════════════════════
    let col_idx = schema
        &output,
    let schema = Arc::new(Schema::new(vec![Field::new("v", DataType::Int64, false)]));
    SETTINGS_STORE.insert(
}
    assert_eq!(rg_firsts[1], Some(RG_MAX), "RG1 first value");
        .unwrap()
    let out_schema = builder.schema().clone();
        &output,
    // File B: [3, 4, 30, 31] with batch_size=2 → cursor batches [3,4] and [30,31]
        &files,
    .unwrap();
        &output,
    // Read all values in order, then slice per RG
}
        &output_str,
        &output,
    // File C: [2, 5, 8, ..., 299_999]  (100_000 values, step 3)
        let batch = batch.unwrap();
    write_parquet(
        &[true],
        &[false],
        vec!["NULL", "NULL", "US", "NULL", "NULL", "UK"]
    write_parquet(&file_a, &batch_a);
    for batch in rdr {
    let total = a_count + b_count;
    // RG0 first value = 1_399_999
    )
}
        &[file_a, file_b],
    let index = "test_deferred_multi_batch_sync";
            let p = e.ok()?.path();
}
            .unwrap();
    write_parquet(&file_a, &batch_a);
        Field::new("city", DataType::Utf8, true),
    write_parquet(&file_b, &batch_b);
    let output = tmp
        .unwrap(),
    }
    let a_vals: Vec<i64> = (0..a_count).map(|i| i * 3).collect();
    let output = tmp.path().join("out.parquet").to_string_lossy().to_string();
        &output,
        Field::new("s2", DataType::Utf8, false),
/// Write a single RecordBatch to a Parquet file.
    let batch_a = RecordBatch::try_new(
    )
        for i in 0..arr.len() {
        &[file_a, file_b],
        let path = tmp
 * this file be licensed under the Apache-2.0 license or a
        Field::new("ts", DataType::Int64, false),
    )
        index,
        rg_sizes[0], RG_MAX,
    let file = File::open(path).unwrap();
    )
    merge_sorted(
        for i in 0..arr.len() {
    // RG1: non-nulls (rg0_last_nonnull+1)..total_nonnulls-1
    let file_b = tmp.path().join("b.parquet").to_string_lossy().to_string();
    let tmp = tempdir().unwrap();
    // File A: [1] — exhausts immediately
    let output = tmp
        &output,
    write_parquet(&file_b, &batch_b);
        .to_string();
        index,
    let reader = SerializedFileReader::new(File::open(path).unwrap()).unwrap();
        .unwrap()
        .build()
    let (rg_sizes, rg_firsts, rg_lasts) = inspect_row_groups(&output, "v");
        .join("merged.parquet")
        Field::new("col_b", DataType::Utf8, false),
        vec![
    for batch in reader {
}
        .to_string_lossy()
fn test_rg_size_overshoots_when_batch_straddles_threshold() {
        vec![
        &[],
        &output,
    // First total_nulls rows must all be None
/// verifies union schema construction and null padding across multiple files.
    }
            if arr.is_null(i) {
                    schema.clone(),
        .join("merged.parquet")
    write_parquet(&file_a, &batch_a);
        schema.clone(),
                            rows_checked, p, val
    assert_eq!(ts_d, ts_e, "timestamps differ between deferred and eager");
/// handles partial slices correctly when merge interleaves within a batch.
fn test_sorted_merge_real_files() {
                Arc::new(StringArray::from(labels)),
    }
    )
    }
    )
    //
use opensearch_parquet_format::merge::{merge_sorted, merge_unsorted};
    // RG0 = rows 0..999_999  → values 0..999_999
        let idx = batch.schema().index_of(col).unwrap();
    assert_eq!(rg_lasts[1], Some(total_nonnulls - 1), "RG1 last value");
    }
        )
            Arc::new(StringArray::from(vec!["b1", "b3", "b5"])),
    )
        &[false],
        &["v".into()],
                }
        NativeSettings {
        &["ts".into()],
            Arc::new(Int64Array::from(vec![7, 6, 5])),
#[test]
    let n: i64 = (batch_size * 20) as i64; // 2_000_020
fn test_tier2_yield_multiple_cursors() {
                &p,
    //   total rows   = 1_400_000
    // RG0 = 1_000_000 rows: all 700_000 nulls + first 300_000 non-nulls (0..299_999)
        .path()
        .build()
    merge_sorted(
                "A1", "A2", "A3", "A10", "A11", "A12",
    .unwrap();
    // RG0 last  value = 1_399_999 - (RG_MAX-1) = 400_000
    // A: [1, 5, 9]  B: [2, 6, 10]  C: [3, 7, 11]  D: [4, 8, 12]
    let output = tmp.path().join("out.parquet").to_string_lossy().to_string();
        eprintln!("Skipping: {} not found", input_dir);
    let n1_d = read_all_int64(&output_deferred, "n1");
    let vals = read_all_int64(&output, "v");
            } else {
#[test]
        .to_string();
        schema.clone(),
        &[false],
        return;
        &[false],
        .to_string();
            Arc::new(Int64Array::from(vec![3, 4, 5, 6, 7, 8])),
        "test_single_large_file",
        &[],
            merge_deferred_column_threshold: Some(deferred_threshold),
    )
    let b_vals = read_all_strings(&output, "col_b");
        &output,
        ("a", vec![1i64, 5, 9]),
        vec![
            assert_eq!(col.value(i), expected, "__row_id__ gap at row {}", expected);
    // TIER 1 should drain B entirely without heap operations
        let idx = batch.schema().index_of(col).unwrap();
    let ts_vals = read_all_int64(&output, "ts");
    // Expected: 1,2,5,5,6,7,8
        schema.clone(),
    let file_a = tmp.path().join("a.parquet").to_string_lossy().to_string();
                name_vals.push(arr.value(i).to_string());
    let vals = read_all_int64(&output, "v");
    );
    // Expected: 1,2,3,4,10,11,12,20,21,30,31
    // Sort by EventDate ascending (each input file is pre-sorted by EventDate)
    let batch_a = RecordBatch::try_new(
        assert_eq!(*v, Some(i as i64), "wrong value at row {}", i);
    .unwrap();
    let out_vals = read_col_i64(&output, "v");
    .unwrap();
    let s1_e = read_all_strings(&output_eager, "s1");
fn test_non_multiple_of_batch_size() {
        &nulls_first,
        &[file_a, file_b],
    )
        vec![
    let schema = Arc::new(Schema::new(vec![Field::new("v", DataType::Int64, false)]));
    // File B: [3,4,7,8] → batches [3,4] and [7,8]
        &[file_a, file_b],
            }
/// Verifies TIER 1 drain handles multiple batch boundaries and produces
            .as_any()
fn register_deferred_settings(index_name: &str, batch_size: usize, deferred_threshold: usize) {
        .to_string();
    )
        Field::new("ts", DataType::Int64, false),
    let file_b = tmp.path().join("b.parquet").to_string_lossy().to_string();
    let ts_vals = read_all_int64(&output, "ts");
        .map(|_| None)
    let ts_vals = read_all_int64(&output, "ts");
}
        &[],
    files
        &["ts".into()],
            } else {
    let index = "test_tier2_yield_multiple_cursors";
    assert_eq!(ts_vals, vec![1, 2, 3, 4, 5, 6, 7]);
        &[false],
    )
                extra_vals.push("NULL".to_string());
        "Verified EventDate sort order across {} non-null rows",
#[test]
        let arr = batch
            Arc::new(Int64Array::from(vec![1, 3, 5])),
}
            Arc::new(Int64Array::from(vec![3, 4, 7, 8])),
            Arc::new(StringArray::from(vec![Some("d2"), Some("d4"), Some("d6")])),
    let schema = Arc::new(Schema::new(vec![
            .unwrap();
    .unwrap();
        .path()
// Uses default settings (merge_batch_size=100_000, row_group_max_rows=1_000_000).
        &file_a,
    writer.close().unwrap();
    let files = list_parquet_files(&input_dir);
        write_parquet(&path, &make_batch(vals, name));
    write_parquet(&file_a, &batch_a);
                    if out_of_order <= 5 {
    )
            Arc::new(StringArray::from(vec!["A1", "A3", "A5", "A7"])),
        index,
    ]));
use std::path::Path;
        .to_string();
        &[file_a, file_b, file_c],
    let tmp = tempdir().unwrap();
        schema_2.clone(),
        &[],
    let reader = ParquetRecordBatchReaderBuilder::try_new(file)
    // File A: [12, 11, 10, 3, 2, 1] with batch_size=3 → cursor batches [12,11,10] and [3,2,1]
            Arc::new(Int64Array::from(vec![2, 4, 6])),
/// are correctly written despite being loaded lazily.
    .unwrap();
        Field::new("ts", DataType::Int64, false),
    let file_b = tmp.path().join("b.parquet").to_string_lossy().to_string();
    writer.write(batch).unwrap();
        .unwrap();
    // col_b present in both files
        &RecordBatch::try_new(schema.clone(), vec![Arc::new(Int64Array::from(b_vals))]).unwrap(),
    // half = 350_000, so:
    let output = tmp
        .unwrap();
        schema.clone(),
            Arc::new(Int64Array::from(vec![1, 3, 5])),
    write_parquet(&file_1, &batch_1);
    let tmp = tempdir().unwrap();
        schema.clone(),
        Field::new("col_c", DataType::Utf8, true),
    ]));
            Arc::new(Int64Array::from(vec![2, 4, 6, 8])),
    let file_a = tmp.path().join("a.parquet").to_string_lossy().to_string();
            total_nulls as usize + i
    let reader = builder.build().unwrap();
        .iter()
    .unwrap();
            ..Default::default()
        ],
    let file_c = tmp.path().join("c.parquet").to_string_lossy().to_string();
        &output,
}
            Arc::new(Int64Array::from(vec![2, 5])),
        &[],
    }
        .collect();
        &file_a,
    .unwrap();
        for i in 0..arr.len() {
        &[false],
    )
        &[],
        index,
    let schema = Arc::new(Schema::new(vec![Field::new("v", DataType::Int64, false)]));
            } else {
        .expect("cannot read directory")
    );
        .unwrap(),
use arrow::array::*;
        .to_string_lossy()
    .unwrap();
    write_parquet(&file_b, &batch_b);
        .build()
        let batch = batch.unwrap();
    let schema_3 = Arc::new(Schema::new(vec![
            .as_any()
    // ── Row group structure ──────────────────────────────────────────────
        }
    let mut col_d_vals = Vec::new();
    let schema = Arc::new(Schema::new(vec![Field::new("v", DataType::Int64, false)]));
    let schema_1 = Arc::new(Schema::new(vec![
            all.push(if arr.is_null(i) {
        0,
    let file_b = tmp.path().join("b.parquet").to_string_lossy().to_string();
    assert_eq!(rg_sizes[1], ROWS_PER_FILE * 2 - RG_MAX, "RG1 size");
                name_vals.push("NULL".to_string());
        .chain((0..half).map(|i| Some(i * 2)))
    assert_eq!(rg_sizes[1], total - RG_MAX);
            Arc::new(StringArray::from(vec!["B5", "B6", "B7"])),
    .unwrap();
        );
        assert_eq!(*v, Some(total - 1 - i as i64), "wrong value at row {}", i);
        Field::new("ts", DataType::Int64, false),
        &[file_a, file_b],
        }
        &output,
        0,
        &["v".into()],
    );
        tag_vals,
/// 150_001 + 149_999 = 300_000 rows. Verifies no off-by-one at batch boundaries.
        .to_string_lossy()
fn register_small_batch_size(index_name: &str, batch_size: usize) {
    .unwrap();
        for i in 0..arr.len() {
    let vals = read_all_int64(&output, "v");
    )
    write_parquet(&file_b, &batch_b);
fn verify_row_id_order(path: &str) {
    assert_eq!(rg_sizes[1], total - RG_MAX);
        .chain(b_vals.iter())
    let batch_a = RecordBatch::try_new(
            Arc::new(Int64Array::from(vec![1, 2, 5, 6])),
    let ts_vals = read_all_int64(&output, "ts");
        info_vals,
#[test]
        &file_a,
        vec![
    let output = tmp
        out_of_order, 0,
}
            Arc::new(StringArray::from(vec!["a1", "a3", "a5"])),
    let schema = Arc::new(Schema::new(vec![Field::new("v", DataType::Int64, false)]));
    let tmp = tempdir().unwrap();
        &[false],
        schema_b.clone(),
        index,
    let nulls_first = vec![false];
        .build()
            merge_batch_size: Some(batch_size),
    write_parquet(&file_b, &batch_b);
        &[],
    // Expected: 1,2,3,4,5,6,7,8
    write_parquet(
    .unwrap();
    assert_eq!(vals, vec![1, 2, 5, 5, 6, 7, 8]);
        out_of_order
        let arr = batch
        .to_string_lossy()
fn list_parquet_files(dir: &str) -> Vec<String> {
    merge_sorted(
    write_parquet(&file_b, &batch_b);
        &[false],
        ("d", vec![4, 8, 12]),
    let output = tmp
    merge_sorted(
    let batch_a = RecordBatch::try_new(
// These tests exercise the logic where after TIER 2 drains a full batch and
        &file_b,
        }
    let file_b = tmp.path().join("b.parquet").to_string_lossy().to_string();
        )
        &[file_a, file_b, file_c],
        schema_a.clone(),
    )
    let index = "test_deferred_tier2_full_batch_emit";
/// Verifies data reader loads correctly when TIER 1 bulk-emits.
fn test_unsorted_merge_real_files() {
    .unwrap();
        Field::new("ts", DataType::Int64, false),
            Arc::new(Int64Array::from(vec![12, 11, 10, 3, 2, 1])),
    );
            Arc::new(Int64Array::from(vec![1, 3, 5])),
            Arc::new(StringArray::from(vec!["first", "second"])),
    let vals = read_all_int64(&output, "v");
#[test]
    let b_vals: Vec<i64> = (0..b_count).map(|i| i * 3 + 1).collect();
    // File A: [1, 2] — exhausts quickly
    let ts_vals = read_all_int64(&output, "ts");
        schema.clone(),
        },
                col_d_vals.push(arr.value(i).to_string());
    // Merged ascending: 0, 1, 2, 3, ..., 1_399_999
    // File B: odds   [1, 3, 5, ..., (ROWS_PER_FILE-1)*2+1] — 700_000 values
    let file = File::create(path).unwrap();
                .path()
    // File A: [12, 11, 10, 3, 2, 1] descending → batches [12,11,10] and [3,2,1]
    let index_eager = "test_deferred_vs_eager_eager";
    merge_sorted(
    merge_sorted(
/// Deferred mode produces identical output to eager mode for the same input.
        assert_eq!(*v, Some(i as i64), "wrong value at row {}", i);
    let index = "test_deferred_tier1_multi_batch_drain";
        .path()
    let a_vals: Vec<i64> = (0..5).flat_map(|i| vec![i * 10 + 1, i * 10 + 2]).collect();
    let total = ROWS_PER_FILE * 2;
        &[],
                extra_vals.push(arr.value(i).to_string());
        &[false],
fn test_all_duplicate_sort_keys_large() {
    SETTINGS_STORE.insert(
    let output = tmp.path().join("out.parquet").to_string_lossy().to_string();
    // Merged: 0,1,2,3,...,399_999, 400_000,400_002,...,2_399_998
        schema.clone(),
            });
    merge_sorted(
        .expect("__row_id__ not in output");
    // This forces many yield events as each batch boundary in A jumps past B's
    let output = tmp
        ],
    // heap_top from B is 7. In descending, 3 < 7 means A should yield.
    );
        &[],
        schema.clone(),
    assert_eq!(out_vals.len() as i64, total);
            Arc::new(StringArray::from(vec!["b2", "b4", "b6"])),
    let p_vals = read_all_strings(&output, "payload");
    let batch_c = RecordBatch::try_new(
    // ── Exact value check ────────────────────────────────────────────────
fn inspect_row_groups(path: &str, col: &str) -> (Vec<i64>, Vec<Option<i64>>, Vec<Option<i64>>) {
    let (rg_sizes, rg_firsts, rg_lasts) = inspect_row_groups(&output, "v");
        .filter_map(|e| {
    let batch_a = RecordBatch::try_new(
        vec![
    // File C: [10, 11, 12]
        .to_string();
        &[false],
    expected.sort();
    merge_sorted(
    let file_a = tmp.path().join("a.parquet").to_string_lossy().to_string();
        &output,
    assert_eq!(rg_firsts[0], None, "RG0 should start with null");
        Field::new("col_a", DataType::Utf8, false),
        .to_string();
        &[false],
            .downcast_ref::<StringArray>()
        &[false],
            .downcast_ref::<StringArray>()
    let total = ROWS_PER_FILE * 2; // 1_400_000
    let tag_vals = read_all_strings(&output, "tag");
        .unwrap(),
            Arc::new(StringArray::from(vec!["t3", "t4", "t5", "t6", "t7", "t8"])),
    write_parquet(&file_a, &batch_a);
    let msg_vals = read_all_strings(&output, "msg");
                            "Out of order at row {}: prev={}, cur={}",
        &RecordBatch::try_new(schema.clone(), vec![Arc::new(Int64Array::from(a_vals))]).unwrap(),
        &[],
    assert_eq!(b_vals, vec!["b1", "b2", "b3", "b4", "b5", "b6"]);
            if let Some(p) = prev {
    .unwrap();
            vec![Arc::new(Int64Array::from(c_vals.clone()))],
    let reader = ParquetRecordBatchReaderBuilder::try_new(file)
    merge_sorted(
    let file = File::open(path).unwrap();
/// Verify that __row_id__ in the output is monotonically increasing (0, 1, 2, ...).
    write_parquet(
    ]));
    let reader = SerializedFileReader::new(File::open(path).unwrap()).unwrap();
        .path()
    let info_vals = read_all_strings(&output, "info");
    assert_eq!(c_vals, vec!["c1", "c2", "c3", "c4", "c5", "c6"]);
    merge_sorted(
        &RecordBatch::try_new(
    let index = "test_deferred_different_schemas";
}
}
    merge_sorted(
    assert_eq!(rg_sizes.len(), 2);
        for i in 0..arr.len() {
    let a_vals: Vec<i64> = (0..large).map(|i| i * 2).collect();
            vec![Arc::new(Int64Array::from(b_vals.clone()))],
    }
    let file = File::open(path).unwrap();
    let file_b = tmp.path().join("b.parquet").to_string_lossy().to_string();
    let s1_d = read_all_strings(&output_deferred, "s1");
    let large: i64 = 1_200_000;
    assert_eq!(rg_sizes[0], RG_MAX);
        index_name.to_string(),
        firsts.push(all[offset]);
    // Empty sort columns → unsorted merge
        .unwrap()
    let output = tmp.path().join("out.parquet").to_string_lossy().to_string();
    let tmp = tempdir().unwrap();
    let val_vals = read_all_strings(&output, "val");
    println!(
fn input_dir() -> Option<String> {
#[test]
        &output,
                    vec![Arc::new(Int64Array::from(vals.clone()))],
    .unwrap();
            .as_any()
    let ts_d = read_all_int64(&output_deferred, "ts");
    .unwrap();
    let batch_3 = RecordBatch::try_new(
/// Helper: collect all parquet files in a directory (sorted by name).
        .to_string_lossy()
    let b_vals: Vec<i64> = (0..small).map(|i| i * 2 + 1).collect();
    let batch_a = RecordBatch::try_new(
    println!("Total input rows: {}", expected_rows);
        Field::new("ts", DataType::Int64, false),
        0,
    // File B: [5, 6, 7]
    // After interleaved section: remaining evens from 400_000 to 2_399_998
    let file = File::open(&output).unwrap();
}
    assert_eq!(rg_firsts[1], Some(total - RG_MAX - 1), "RG1 first value");
    ]));
    let schema = Arc::new(Schema::new(vec![
            .as_primitive::<arrow::datatypes::Int64Type>();
        ],
        rg_sizes[0]
        &[false],
        index,
            Arc::new(StringArray::from(vec!["x", "x", "x", "x", "x"])),
        &[],
            vals[total_nulls as usize + i],
        rows_checked
    write_parquet(&file_a, &batch_a);
    write_parquet(&file_b, &batch_b);
    );
    register_deferred_settings(index, 4, 0); // batch_size=4, always deferred
        assert_eq!(*got, Some(*exp), "wrong value at row {}", i);
        &[],
    )
        &RecordBatch::try_new(
    assert_eq!(vals.len() as i64, total);
    .unwrap();
    write_parquet(&file_a, &batch_a);
        .to_string();
    .unwrap();
/// File B exhausts while file A is mid-batch, forcing TIER 1 drain of A
    assert_eq!(
            Arc::new(StringArray::from(vec![Some("US"), Some("UK")])),
        &["ts".into()],
    let tmp = tempdir().unwrap();
        &[],
    // RG0: all nulls first, then non-nulls 0..(RG_MAX - total_nulls - 1)
        let idx = batch.schema().index_of("col_d").unwrap();
    let schema = Arc::new(Schema::new(vec![
    // Remaining rows must be exactly 0, 1, 2, ..., total_nonnulls-1
    expected.sort();
    let tmp = tempdir().unwrap();
            .as_primitive::<arrow::datatypes::Int64Type>();
/// Setup: batch_size=100_001 so each cursor batch is 100_001 rows.
    let a_count: i64 = 100_000;
    let batch_a = RecordBatch::try_new(
    let batch_b = RecordBatch::try_new(
        0,
    let file_a = tmp.path().join("a.parquet").to_string_lossy().to_string();
            .downcast_ref::<StringArray>()
        ],
                None
    let output = tmp.path().join("merged_unsorted.parquet");
    // RG1 =   400_000 rows: remaining non-nulls (300_000..699_999)
    let output_str = output.to_string_lossy().to_string();
    )
/// After TIER 2 drains A's first batch, A's second batch starts higher than B's
    assert_eq!(rg_firsts[1], Some(RG_MAX));
    let reader = ParquetRecordBatchReaderBuilder::try_new(file)
#[test]
        &["v".into()],
    let file_a = tmp.path().join("a.parquet").to_string_lossy().to_string();
    let (rg_sizes, rg_firsts, rg_lasts) = inspect_row_groups(&output, "v");
    let tmp = tempdir().unwrap();
        schema.clone(),
    let total = n * 3;
    merge_sorted(
    let file_a = tmp.path().join("a.parquet").to_string_lossy().to_string();
            Arc::new(StringArray::from(vec![Some("bob"), Some("eve")])),
            Arc::new(StringArray::from(vec!["c1", "c3", "c5"])),
        &[false],
        &output_eager,
        &[file_a, file_b],
        &file_a,
        &[file_a, file_b],
        .to_string();
        &RecordBatch::try_new(schema.clone(), vec![Arc::new(Int64Array::from(b_vals))]).unwrap(),
        vec![Arc::new(Int64Array::from(vec![12, 11, 10, 3, 2, 1]))],
        &file_a,
        &[],
        .path()
    let output_str = output.to_string_lossy().to_string();
    // RG0: 1_000_010, RG1: 1_000_010
    let file_b = tmp.path().join("b.parquet").to_string_lossy().to_string();
        .join("merged.parquet")
        &[false],
            Arc::new(Int64Array::from(vec![1])),
    ]));
    // File A: [1, 3, 5, 7] — single batch
    let schema = builder.schema().clone();
            Arc::new(StringArray::from(vec!["y", "y", "y", "y", "y"])),
// Verifies:
    let batch_a = RecordBatch::try_new(
    let total_nulls = half * 2; // 700_000
        Field::new("info", DataType::Utf8, false),
        index,
        .to_string_lossy()
    for batch in rdr {
    // File A: [0, 3, 6, ..., 299_997]  (100_000 values, step 3)
            Arc::new(Int64Array::from(vec![10, 30, 50, 70, 90])),
                    out_of_order += 1;
        &[],
/// Three files with interleaved batch boundaries to force multiple yield events.
                "a12", "a11", "a10", "a3", "a2", "a1",
    .unwrap();
    //
    assert_eq!(ts_vals, vec![1, 2, 3, 4, 5, 6]);
        schema.clone(),
/// Helper: count rows in a single parquet file.
        &["ts".into()],
    verify_row_id_order(&output_str);
    let total = large + small;
    let mut vals = Vec::new();
    let index = "test_tier2_yield_descending";
/// Helper: count total rows across input files.
    let index = "test_eager_forced_by_high_threshold";
    assert_eq!(col_d_vals, vec!["NULL", "d2", "NULL", "d4", "NULL", "d6"]);
    // "country" only in file 3
            .column(idx)
    write_parquet(&file_b, &batch_b);
#[test]
    let Some(input_dir) = input_dir() else {
    for batch in reader {
        for i in 0..arr.len() {
    assert_eq!(rg_lasts[0], Some(rg0_last_nonnull), "RG0 last value");
        .join("merged.parquet")
        },
            Arc::new(StringArray::from(vec!["B2", "B4", "B6", "B8"])),
            let reader = SerializedFileReader::new(File::open(f).unwrap()).unwrap();
    let schema = Arc::new(Schema::new(vec![
    .unwrap();
    let vals = read_col_i64(&output, "v");
    register_deferred_settings(index, 3, 0);
        0,
        ],
    .unwrap();
fn test_default_settings_descending_nulls_last() {
        vec![
        let batch = batch.unwrap();
        index_eager,
        ],
        let batch = batch.unwrap();
                .to_string();
        Field::new("ts", DataType::Int64, false),
        &[file_a],
        .unwrap();
        &[],
    let n: i64 = 1_500_000;
}
        Field::new("col_d", DataType::Utf8, true),
    for batch in reader {
    let file_b = tmp.path().join("b.parquet").to_string_lossy().to_string();
    let file_a = tmp.path().join("a.parquet").to_string_lossy().to_string();
        &["v".into()],
    )
        .path()
    let mut vals = Vec::new();
    )
    // File B: [5,6, 15,16, 25,26, 35,36, 45,46] with batch_size=2
        0,
    )
            .column(idx)
    write_parquet(
    assert_eq!(rg_sizes.len(), 2);
        0,
    write_parquet(&file_b, &batch_b);
    // ── Exact value check ────────────────────────────────────────────────
            Arc::new(Int64Array::from(vec![1, 4])),
        .to_string();
// so the cursor must yield back to the heap.
            Arc::new(StringArray::from(vec!["b", "b", "b", "b", "b"])),
            } else {
    merge_sorted(
