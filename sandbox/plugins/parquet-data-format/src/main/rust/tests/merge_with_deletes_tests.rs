    let file = File::open(path).unwrap();
    // The output must be a valid parquet file (readable footer) with zero rows.
    merge_unsorted(&[f1, f2], &out, "test", 0, &[None, None]).unwrap();
}
}
        let idx = batch.schema().index_of(col).unwrap();
}
// ─── Helpers ────────────────────────────────────────────────────────────────
    let tmp = tempdir().unwrap();
        &[Some(f1_all_dead), None],
        .to_string_lossy()
        .to_string_lossy()
    let f2 = tmp.path().join("b.parquet").to_string_lossy().to_string();
//! surviving rows compared against expectations.
        .join("merged.parquet")
        0,
    )
        &out,
fn sorted_merge_with_no_deletes_returns_full_output() {
//! End-to-end tests for the live-docs path of merge_sorted and merge_unsorted.
        .path()
        .unwrap()
        "test",
use parquet::arrow::ArrowWriter;
        &[Some(f1_alive), Some(f2_alive)],
    assert_eq!(result.metadata.file_metadata().num_rows(), 0);
        &[Some(f1_alive), Some(f2_alive)],
    let out = tmp
    )
    .unwrap();
#[test]
        let batch = batch.unwrap();
 * The OpenSearch Contributors require contributions made to
    write_int64_file(&f2, vec![40, 50]);
 */
        .join("merged.parquet")
    write_int64_file(&f1, vec![1, 3, 5]);
    let f1_alive = pack_bits(3, &[0, 1, 2]);
        0,
    let f1 = tmp.path().join("a.parquet").to_string_lossy().to_string();
    let f2_alive = pack_bits(3, &[0, 2]);
    for &row in alive {
        0,
}
        &["val".into()],
        .unwrap();
    write_int64_file(&f1, vec![10, 20, 30]);
        .path()
        .join("merged.parquet")
    let f1 = tmp.path().join("a.parquet").to_string_lossy().to_string();
    assert_eq!(result.metadata.file_metadata().num_rows(), 0);
#[test]
    let f2_alive = pack_bits(2, &[1]);
    let out = tmp
        &[Some(pack_bits(3, &[])), Some(pack_bits(3, &[]))],
        .join("merged.parquet")
        .to_string_lossy()
    let f1 = tmp.path().join("a.parquet").to_string_lossy().to_string();
        .to_string();
        .join("merged.parquet")
#[test]
    let f1_alive = pack_bits(4, &[0, 2]);
    bits
    let f1 = tmp.path().join("a.parquet").to_string_lossy().to_string();
        .join("merged.parquet")
        .path()
        0,
        .join("merged.parquet")
        &[false],
    let f1_all_dead = pack_bits(3, &[]);
use parquet::arrow::arrow_reader::ParquetRecordBatchReaderBuilder;
    let f2 = tmp.path().join("b.parquet").to_string_lossy().to_string();
        .path()
        .to_string_lossy()
    assert_eq!(vals, vec![1, 2, 3, 4, 5, 6]);
    let f1 = tmp.path().join("a.parquet").to_string_lossy().to_string();
fn sorted_merge_drops_first_row_so_initial_heap_value_is_alive() {
fn write_int64_file(path: &str, vals: Vec<i64>) {
    let vals = read_int64_col(&out, "val");
}
    write_int64_file(&f1, vec![1, 3, 5]);
        &[false],
        .to_string_lossy()
        "test",
    write_int64_file(&f1, vec![1, 3, 5]);
        bits[row / 64] |= 1u64 << (row % 64);
    let f2 = tmp.path().join("b.parquet").to_string_lossy().to_string();
        &[Some(pack_bits(3, &[])), Some(pack_bits(2, &[]))],
    assert_eq!(result.mapping.len(), 5);
    write_int64_file(&f2, vec![2, 4, 6]);
        &[],
    let out = tmp
    let out = tmp
        0,
    let out = tmp
    let tmp = tempdir().unwrap();
}
        &out,
    write_parquet(path, &batch);
        &[],
fn read_int64_col(path: &str, col: &str) -> Vec<i64> {
#[test]
    let file = File::open(path).unwrap();
    let row_ids = read_int64_col(&out, "__row_id__");
        &[Some(alive)],
        &[false],
    }
        &[],
    // Every source row maps to the dead sentinel; per-file spans are still recorded.
        &[],
    let mut vals = Vec::new();
    }
 *
        &[f1, f2],
    // Drop two rows; the merger writes sequential __row_id__ across surviving rows.
    write_int64_file(&f1, vec![10, 20, 30]);
        &[f1, f2],
    let f2 = tmp.path().join("b.parquet").to_string_lossy().to_string();
        .path()
}
    let reader = ParquetRecordBatchReaderBuilder::try_new(file)
    .unwrap();
        &["val".into()],
        &[false],
            vals.push(arr.value(i));
        }
        &[false],
    reader.map(|b| b.unwrap().num_rows()).sum()
        &out,
    write_int64_file(&f1, vec![1, 3, 5]);
        &["val".into()],
    )
        &[None, None],
    assert_eq!(vals, vec![3, 5]);
    let f1_alive = pack_bits(3, &[0, 2]);
    let vals = read_int64_col(&out, "val");
#[test]
    assert!(result.mapping.iter().all(|&m| m == -1));
    let f2 = tmp.path().join("b.parquet").to_string_lossy().to_string();
    let tmp = tempdir().unwrap();
}
    assert_eq!(count_rows(&out), 4);
    let f1 = tmp.path().join("a.parquet").to_string_lossy().to_string();
fn pack_bits(num_rows: usize, alive: &[usize]) -> Vec<u64> {
    let f1_alive = pack_bits(3, &[0, 2]);
        .join("merged.parquet")
        0,
#[test]
    )
    assert_eq!(count_rows(&out), 0);
        .path()
    // Drop row 1 from each file (i.e. value 3 from f1, value 4 from f2).
        "test",
    )
        .join("merged.parquet")
    let tmp = tempdir().unwrap();
        .build()
    let f2 = tmp.path().join("b.parquet").to_string_lossy().to_string();
        .path()
        &[Some(f1_alive)],
        .to_string_lossy()
    .unwrap();
    let vals = read_int64_col(&out, "val");
    write_int64_file(&f1, vec![10, 20, 30, 40]);
    write_int64_file(&f2, vec![40, 50]);
    merge_sorted(
        .to_string();
    let mut writer = ArrowWriter::try_new(file, batch.schema(), None).unwrap();
fn count_rows(path: &str) -> usize {
        &[f1, f2],
    writer.close().unwrap();
    // The output must be a valid parquet file (readable footer) with zero rows.
        &[f1, f2],
            .as_primitive::<arrow::datatypes::Int64Type>();
/// Pack alive-row positions into a Lucene-layout bitmap.
    assert_eq!(count_rows(&out), 0);
        "test",
fn write_parquet(path: &str, batch: &RecordBatch) {
    let out = tmp
        &out,
        .to_string_lossy()
        &[],
        let arr = batch
fn unsorted_merge_skips_entirely_dead_input_file() {
        &[],
        .to_string();
    // Every source row maps to the dead sentinel; per-file spans are still recorded.
            .column(idx)
}
fn unsorted_merge_assigns_sequential_row_ids_after_deletes() {
    assert_eq!(vals, vec![1, 2, 3, 4, 5, 6]);
    )
#[test]
    let vals = read_int64_col(&out, "val");
        &out,
        &["val".into()],
    let tmp = tempdir().unwrap();
    for batch in reader {
    write_int64_file(&f2, vec![50, 60]);
        &[f1, f2],
    write_int64_file(&f2, vec![2, 4, 6]);
        .to_string();
    let f2 = tmp.path().join("b.parquet").to_string_lossy().to_string();
        &[false],
    .unwrap();
    let f1 = tmp.path().join("a.parquet").to_string_lossy().to_string();
    )
    let tmp = tempdir().unwrap();
 * compatible open source license.
    let result = merge_unsorted(
    let result = merge_sorted(
use std::sync::Arc;
    assert_eq!(result.gen_sizes, vec![3, 3]);
    merge_sorted(
 * SPDX-License-Identifier: Apache-2.0
}
    let tmp = tempdir().unwrap();
        &["val".into()],
        &[false],
        .to_string();
    assert_eq!(vals, vec![10, 30, 50]);
        .path()
    merge_sorted(
        "test",
}
    let tmp = tempdir().unwrap();
    merge_sorted(
    write_int64_file(&f1, vec![10, 20, 30]);
        &[Some(f1_alive), Some(f2_alive)],
    write_int64_file(&f1, vec![1, 3, 5]);
        &["val".into()],
    merge_unsorted(&[f1, f2], &out, "test", 0, &[Some(f1_all_dead), None]).unwrap();
    let alive = pack_bits(3, &[1, 2]);
        &[f1, f2],
        0,
        &[false],
        for i in 0..arr.len() {
    // Keep rows 0 and 2 from f1 (values 10, 30); keep row 1 from f2 (value 50).
    assert!(result.mapping.iter().all(|&m| m == -1));
/*
        &[f1],
fn sorted_merge_with_one_file_fully_dead() {
    let f1 = tmp.path().join("a.parquet").to_string_lossy().to_string();
    write_int64_file(&f2, vec![2, 4, 6]);
        &[false],
    // Drop row 0 (val=1). Initial heap value must be 3, not 1.
    assert_eq!(result.row_id_mapping_max, 0);
    let out = tmp
    assert_eq!(vals, vec![1, 2, 5, 6]);
 * this file be licensed under the Apache-2.0 license or a
fn sorted_merge_drops_deleted_rows() {
        "test",
    .unwrap();
        .to_string();
    assert_eq!(vals, vec![2, 4, 6]);
    let out = tmp
fn sorted_merge_with_padding_treats_extra_inputs_as_all_alive() {
    write_int64_file(&f2, vec![2, 4, 6]);
    let tmp = tempdir().unwrap();
        .join("merged.parquet")
    let out = tmp
use opensearch_parquet_format::merge::{merge_sorted, merge_unsorted};
}
    let mut bits = vec![0u64; words];
    assert_eq!(vals, vec![10, 20, 30, 40, 50]);
fn unsorted_merge_with_all_rows_dead_writes_valid_empty_file() {
    .unwrap();
        .to_string_lossy()
        &out,
        .to_string();
    let f1 = tmp.path().join("a.parquet").to_string_lossy().to_string();
        &out,
        &[f1, f2],
        &[false],
use arrow::datatypes::{DataType, Field, Schema};
// ─── Sorted merge ───────────────────────────────────────────────────────────
    let words = (num_rows + 63) / 64;
fn unsorted_merge_with_no_deletes_returns_full_output() {
}
    let vals = read_int64_col(&out, "val");
        .path()
        0,
        .join("merged.parquet")
    let out = tmp
        .to_string_lossy()
    let file = File::create(path).unwrap();
    let vals = read_int64_col(&out, "val");
    write_int64_file(&f1, vec![10, 20, 30]);
}
    let reader = ParquetRecordBatchReaderBuilder::try_new(file)
    write_int64_file(&f2, vec![40, 50]);
    let tmp = tempdir().unwrap();
        .path()
    write_int64_file(&f1, vec![1, 3, 5]);
        .path()
    let f2 = tmp.path().join("b.parquet").to_string_lossy().to_string();
        .to_string();
    assert_eq!(row_ids, vec![0, 1, 2]);
        &[false],
        .unwrap()
    let f1_all_dead = pack_bits(3, &[]);
        .unwrap();
// ─── Unsorted merge ─────────────────────────────────────────────────────────
        &[false],
        .to_string();
    let vals = read_int64_col(&out, "val");
        &out,
use std::fs::File;
    let f2 = tmp.path().join("b.parquet").to_string_lossy().to_string();
use tempfile::tempdir;
    write_int64_file(&f2, vec![40, 50]);
    // Provide live-docs for f1 only; f2 gets padded to None ⇒ all alive.
    .unwrap();
    let f2 = tmp.path().join("b.parquet").to_string_lossy().to_string();
#[test]
#[test]
        &[f1, f2],
    )
    let batch = RecordBatch::try_new(schema, vec![Arc::new(Int64Array::from(vals))]).unwrap();
    let tmp = tempdir().unwrap();
    write_int64_file(&f2, vec![2, 4, 6]);
fn unsorted_merge_drops_deleted_rows() {
        .to_string();
#[test]
        "test",
    assert_eq!(vals, vec![40, 50]);
        "test",
    let schema = Arc::new(Schema::new(vec![Field::new("val", DataType::Int64, false)]));
    writer.write(batch).unwrap();
    let f1 = tmp.path().join("a.parquet").to_string_lossy().to_string();
    .unwrap();
//! Inputs are tiny self-contained Parquet files; outputs are read back and the
        0,
    assert_eq!(result.mapping.len(), 6);
    )
    let f2_alive = pack_bits(2, &[1]);
        .to_string_lossy()
    .unwrap();
    let vals = read_int64_col(&out, "val");
        .to_string_lossy()
        &out,
}
    merge_unsorted(
        .to_string();
use arrow::array::*;
        "test",
}
    vals
    merge_sorted(
        .build()
    assert_eq!(result.gen_sizes, vec![3, 2]);
    merge_unsorted(
    let f1 = tmp.path().join("a.parquet").to_string_lossy().to_string();
#[test]
    let out = tmp
fn sorted_merge_with_all_rows_dead_writes_valid_empty_file() {
