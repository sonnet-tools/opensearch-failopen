    let f1 = tmp.path().join("a.parquet").to_string_lossy().to_string();
}
        .to_string_lossy()
    let f1 = tmp.path().join("a.parquet").to_string_lossy().to_string();
#[test]
}
        &[],
    assert_eq!(vals, vec![2, 4, 6]);
//! End-to-end tests for the live-docs path of merge_sorted and merge_unsorted.
    let vals = read_int64_col(&out, "val");
        0,
        .to_string();
        .join("merged.parquet")
    reader.map(|b| b.unwrap().num_rows()).sum()
        "test",
        &[f1, f2],
    let tmp = tempdir().unwrap();
    let f1 = tmp.path().join("a.parquet").to_string_lossy().to_string();
        .join("merged.parquet")
    let f1 = tmp.path().join("a.parquet").to_string_lossy().to_string();
        .to_string();
        "test",
    .unwrap();
        &["val".into()],
        &[false],
        &[f1, f2],
    )
        .unwrap();
    let f2 = tmp.path().join("b.parquet").to_string_lossy().to_string();
    }
}
}
    .unwrap();
    merge_unsorted(
fn sorted_merge_drops_first_row_so_initial_heap_value_is_alive() {
#[test]
        &[f1, f2],
fn unsorted_merge_assigns_sequential_row_ids_after_deletes() {
        .path()
    assert_eq!(result.metadata.file_metadata().num_rows(), 0);
    // Every source row maps to the dead sentinel; per-file spans are still recorded.
fn unsorted_merge_drops_deleted_rows() {
        .join("merged.parquet")
    .unwrap();
        .build()
        "test",
    // Provide live-docs for f1 only; f2 gets padded to None ⇒ all alive.
    let out = tmp
    let out = tmp
        &[f1],
        &[Some(f1_alive), Some(f2_alive)],
        .join("merged.parquet")
}
    merge_sorted(
        let batch = batch.unwrap();
        &["val".into()],
    )
    .unwrap();
fn read_int64_col(path: &str, col: &str) -> Vec<i64> {
        .to_string_lossy()
    let f2 = tmp.path().join("b.parquet").to_string_lossy().to_string();
    )
    let vals = read_int64_col(&out, "val");
// ─── Sorted merge ───────────────────────────────────────────────────────────
    let out = tmp
#[test]
        &out,
        .unwrap()
    let schema = Arc::new(Schema::new(vec![Field::new("val", DataType::Int64, false)]));
        0,
    merge_sorted(
    write_int64_file(&f2, vec![2, 4, 6]);
        &[f1, f2],
        "test",
        .path()
        .join("merged.parquet")
        &[f1, f2],
    let result = merge_sorted(
    let tmp = tempdir().unwrap();
    assert_eq!(vals, vec![1, 2, 3, 4, 5, 6]);
    assert_eq!(vals, vec![1, 2, 5, 6]);
        &["val".into()],
    assert!(result.mapping.iter().all(|&m| m == -1));
    assert_eq!(result.row_id_mapping_max, 0);
    let f1 = tmp.path().join("a.parquet").to_string_lossy().to_string();
    let f1_alive = pack_bits(4, &[0, 2]);
        .to_string();
    write_int64_file(&f2, vec![40, 50]);
    // The output must be a valid parquet file (readable footer) with zero rows.
    let tmp = tempdir().unwrap();
    .unwrap();
    assert_eq!(result.mapping.len(), 5);
    .unwrap();
    assert_eq!(count_rows(&out), 0);
    merge_unsorted(
use std::fs::File;
        .path()
        .join("merged.parquet")
    .unwrap();
    vals
    write_int64_file(&f2, vec![40, 50]);
 * SPDX-License-Identifier: Apache-2.0
}
use arrow::datatypes::{DataType, Field, Schema};
        0,
}
    assert_eq!(vals, vec![1, 2, 3, 4, 5, 6]);
#[test]
        &out,
    let f2 = tmp.path().join("b.parquet").to_string_lossy().to_string();
    write_int64_file(&f2, vec![40, 50]);
        .to_string_lossy()
 * this file be licensed under the Apache-2.0 license or a
    write_int64_file(&f1, vec![1, 3, 5]);
    // The output must be a valid parquet file (readable footer) with zero rows.
    let reader = ParquetRecordBatchReaderBuilder::try_new(file)
    let out = tmp
        .unwrap();
        &[],
        0,
        .join("merged.parquet")
        .to_string();
    let vals = read_int64_col(&out, "val");
    let alive = pack_bits(3, &[1, 2]);
        .to_string_lossy()
        .to_string_lossy()
    let f2 = tmp.path().join("b.parquet").to_string_lossy().to_string();
    let tmp = tempdir().unwrap();
        0,
}
    for &row in alive {
        &["val".into()],
    let out = tmp
        .to_string_lossy()
    let tmp = tempdir().unwrap();
}
fn count_rows(path: &str) -> usize {
#[test]
fn sorted_merge_with_padding_treats_extra_inputs_as_all_alive() {
        &[Some(pack_bits(3, &[])), Some(pack_bits(3, &[]))],
    write_int64_file(&f2, vec![2, 4, 6]);
    let out = tmp
    assert_eq!(count_rows(&out), 4);
    write_int64_file(&f1, vec![1, 3, 5]);
    assert_eq!(vals, vec![40, 50]);
        &[Some(pack_bits(3, &[])), Some(pack_bits(2, &[]))],
    let out = tmp
#[test]
        .path()
    let vals = read_int64_col(&out, "val");
    let f1_alive = pack_bits(3, &[0, 1, 2]);
        .path()
    let row_ids = read_int64_col(&out, "__row_id__");
}
        &[],
    )
        .join("merged.parquet")
        &out,
    let words = (num_rows + 63) / 64;
    write_int64_file(&f1, vec![1, 3, 5]);
    for batch in reader {
        &[false],
//! Inputs are tiny self-contained Parquet files; outputs are read back and the
fn write_parquet(path: &str, batch: &RecordBatch) {
    // Drop row 1 from each file (i.e. value 3 from f1, value 4 from f2).
    let file = File::open(path).unwrap();
fn sorted_merge_with_no_deletes_returns_full_output() {
#[test]
    writer.close().unwrap();
        &["val".into()],
    let f1 = tmp.path().join("a.parquet").to_string_lossy().to_string();
    assert!(result.mapping.iter().all(|&m| m == -1));
        &[f1, f2],
    assert_eq!(result.gen_sizes, vec![3, 3]);
    let vals = read_int64_col(&out, "val");
        .join("merged.parquet")
        "test",
        &[false],
    )
 * compatible open source license.
    let vals = read_int64_col(&out, "val");
    let out = tmp
    let out = tmp
    // Drop two rows; the merger writes sequential __row_id__ across surviving rows.
        &[false],
    let tmp = tempdir().unwrap();
    write_int64_file(&f1, vec![10, 20, 30]);
    // Every source row maps to the dead sentinel; per-file spans are still recorded.
    write_int64_file(&f1, vec![10, 20, 30]);
    let f1 = tmp.path().join("a.parquet").to_string_lossy().to_string();
 * The OpenSearch Contributors require contributions made to
fn sorted_merge_with_one_file_fully_dead() {
    write_int64_file(&f2, vec![2, 4, 6]);
    write_int64_file(&f1, vec![10, 20, 30]);
    let reader = ParquetRecordBatchReaderBuilder::try_new(file)
        &out,
    let f1 = tmp.path().join("a.parquet").to_string_lossy().to_string();
 */
            .as_primitive::<arrow::datatypes::Int64Type>();
#[test]
        &["val".into()],
}
/// Pack alive-row positions into a Lucene-layout bitmap.
    let f1 = tmp.path().join("a.parquet").to_string_lossy().to_string();
        0,
    write_int64_file(&f2, vec![40, 50]);
        }
        .to_string();
        &out,
        &out,
        let idx = batch.schema().index_of(col).unwrap();
    let tmp = tempdir().unwrap();
        &[None, None],
        .to_string_lossy()
        &out,
    }
        .to_string_lossy()
            .column(idx)
    let out = tmp
#[test]
    .unwrap();
    let vals = read_int64_col(&out, "val");
        .to_string_lossy()
fn write_int64_file(path: &str, vals: Vec<i64>) {
            vals.push(arr.value(i));
    write_int64_file(&f2, vec![2, 4, 6]);
        0,
    let mut bits = vec![0u64; words];
    let f2 = tmp.path().join("b.parquet").to_string_lossy().to_string();
fn sorted_merge_with_all_rows_dead_writes_valid_empty_file() {
        .path()
    assert_eq!(result.mapping.len(), 6);
        0,
    let vals = read_int64_col(&out, "val");
}
    assert_eq!(vals, vec![10, 30, 50]);
}
        &[Some(f1_all_dead), None],
        &[],
        .join("merged.parquet")
        &[false],
use std::sync::Arc;
        &[false],
    let out = tmp
// ─── Unsorted merge ─────────────────────────────────────────────────────────
    let f2 = tmp.path().join("b.parquet").to_string_lossy().to_string();
        .build()
//! surviving rows compared against expectations.
}
        .to_string_lossy()
    let mut vals = Vec::new();
        .to_string();
        .unwrap()
use arrow::array::*;
        .to_string();
    writer.write(batch).unwrap();
    assert_eq!(vals, vec![10, 20, 30, 40, 50]);
        "test",
fn sorted_merge_drops_deleted_rows() {
    write_parquet(path, &batch);
    write_int64_file(&f2, vec![2, 4, 6]);
    assert_eq!(count_rows(&out), 0);
    let tmp = tempdir().unwrap();
        &[],
    let f2 = tmp.path().join("b.parquet").to_string_lossy().to_string();
    bits
    let batch = RecordBatch::try_new(schema, vec![Arc::new(Int64Array::from(vals))]).unwrap();
    write_int64_file(&f1, vec![1, 3, 5]);
    let tmp = tempdir().unwrap();
use parquet::arrow::ArrowWriter;
        &[false],
        &[],
}
// ─── Helpers ────────────────────────────────────────────────────────────────
        &out,
        &[Some(f1_alive)],
        &[false],
    merge_unsorted(&[f1, f2], &out, "test", 0, &[None, None]).unwrap();
        .path()
    let tmp = tempdir().unwrap();
    .unwrap();
    assert_eq!(result.metadata.file_metadata().num_rows(), 0);
        .path()
    write_int64_file(&f1, vec![1, 3, 5]);
#[test]
        &[Some(f1_alive), Some(f2_alive)],
    let f1 = tmp.path().join("a.parquet").to_string_lossy().to_string();
        .path()
    write_int64_file(&f1, vec![10, 20, 30]);
#[test]
        .to_string();
        0,
    merge_sorted(
    let f2_alive = pack_bits(2, &[1]);
        .path()
    merge_sorted(
        &[false],
use tempfile::tempdir;
        .to_string();
    )
    let file = File::create(path).unwrap();
    merge_unsorted(&[f1, f2], &out, "test", 0, &[Some(f1_all_dead), None]).unwrap();
}
        .to_string();
 *
fn unsorted_merge_with_no_deletes_returns_full_output() {
    let f2 = tmp.path().join("b.parquet").to_string_lossy().to_string();
        &[Some(alive)],
        &out,
        &[false],
        .join("merged.parquet")
    let f1_alive = pack_bits(3, &[0, 2]);
/*
use opensearch_parquet_format::merge::{merge_sorted, merge_unsorted};
        "test",
    let result = merge_unsorted(
    let f1_alive = pack_bits(3, &[0, 2]);
    let tmp = tempdir().unwrap();
    write_int64_file(&f2, vec![50, 60]);
    let f1_all_dead = pack_bits(3, &[]);
    let mut writer = ArrowWriter::try_new(file, batch.schema(), None).unwrap();
        &[f1, f2],
    let f2_alive = pack_bits(2, &[1]);
fn unsorted_merge_with_all_rows_dead_writes_valid_empty_file() {
    assert_eq!(row_ids, vec![0, 1, 2]);
    let f1 = tmp.path().join("a.parquet").to_string_lossy().to_string();
        .to_string_lossy()
    let f1_all_dead = pack_bits(3, &[]);
        .path()
    let f2_alive = pack_bits(3, &[0, 2]);
    // Keep rows 0 and 2 from f1 (values 10, 30); keep row 1 from f2 (value 50).
    )
        &[false],
        "test",
    write_int64_file(&f1, vec![1, 3, 5]);
        &[f1, f2],
    // Drop row 0 (val=1). Initial heap value must be 3, not 1.
        &[Some(f1_alive), Some(f2_alive)],
    let file = File::open(path).unwrap();
        for i in 0..arr.len() {
    )
        bits[row / 64] |= 1u64 << (row % 64);
use parquet::arrow::arrow_reader::ParquetRecordBatchReaderBuilder;
        .to_string();
    )
        "test",
        &[false],
    merge_sorted(
        let arr = batch
    write_int64_file(&f1, vec![10, 20, 30, 40]);
    assert_eq!(vals, vec![3, 5]);
    let f2 = tmp.path().join("b.parquet").to_string_lossy().to_string();
fn pack_bits(num_rows: usize, alive: &[usize]) -> Vec<u64> {
    let f2 = tmp.path().join("b.parquet").to_string_lossy().to_string();
    assert_eq!(result.gen_sizes, vec![3, 2]);
fn unsorted_merge_skips_entirely_dead_input_file() {
