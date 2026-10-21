            schema.clone(),
        .to_string();
        "test",
        )
        &[false],
    writer.close().unwrap();
        &[],
    let output = tmp
    // nulls_first=true → nulls come first, then ascending
                Arc::new(Int64Array::from(vec![1, 3, 1])),
    let files: Vec<String> = batches
            schema.clone(),
        &[],
    let batches = vec![
        .unwrap(),
        .unwrap(),
    let files: Vec<String> = batches
        0,
            schema.clone(),
    let files: Vec<String> = batches
        let batch = batch.unwrap();
            schema.clone(),
            vec![Arc::new(Float64Array::from(vec![
    let vals = read_string_col(&output, "val");
            schema.clone(),
use opensearch_parquet_format::merge::merge_sorted;
        .unwrap(),
        "test",
        &files,
    let vals: Vec<i64> = vals.into_iter().map(|v| v.unwrap()).collect();
    let tmp = tempdir().unwrap();
            s
}
    // File B: (alpha,2), (beta,2), (beta,3)
        .to_string();
        })
        &[false],
    let schema = Arc::new(Schema::new(vec![Field::new("val", DataType::Int32, false)]));
        )
        vals,
                Some(2.5),
    merge_sorted(
        .map(|(i, b)| {
        RecordBatch::try_new(
        )
        )
    let schema = Arc::new(Schema::new(vec![Field::new("val", DataType::Utf8, false)]));
        .path()
        0,
    let tmp = tempdir().unwrap();
use std::sync::Arc;
        0,
                Arc::new(Int64Array::from(vec![2, 2, 3])),
        .iter()
        .path()
        &[false],
        let idx = batch.schema().index_of(col_name).unwrap();
        .path()
            schema.clone(),
            ]))],
        &[false],
    let output = tmp
#[test]
        &[false],
        &[],
            let p = tmp.path().join(format!("input_{}.parquet", i));
            write_parquet(&s, b);
            Some("apple".into()),
        0,
    )
    let tmp = tempdir().unwrap();
        "val",
    merge_sorted(
        .to_string();
    .unwrap();
    let vals = read_primitive_col::<arrow::datatypes::Int64Type>(&output, "val");
    ];
fn test_merge_sort_by_int64_with_nulls() {
    )]));
    ];
#[test]
        .unwrap(),
fn test_merge_sort_by_float32() {
        "val",
    );
        .to_string_lossy()
    ];
            s
        .unwrap(),
            schema.clone(),
        .unwrap(),
        RecordBatch::try_new(
fn read_primitive_col<T: arrow::datatypes::ArrowPrimitiveType>(
            vec![Arc::new(Int64Array::from(vec![Some(1), Some(3), None]))],
        &files,
    .unwrap();
        RecordBatch::try_new(
    merge_sorted(
    let schema = Arc::new(Schema::new(vec![Field::new("val", DataType::Int64, true)]));
    );
        .to_string();
            vec![Arc::new(StringArray::from(vec![
        .collect();
    let file = File::open(path).unwrap();
            schema.clone(),
                Arc::new(StringArray::from(vec!["alpha", "beta", "beta"])),
            schema.clone(),
        .map(|(i, b)| {
        .iter()
            ]))],
        vec![
        )
            write_parquet(&s, b);
}
}
        &files,
            vec![Arc::new(Int64Array::from(vec![None, Some(1), Some(4)]))],
            ]))],
    ];
    let tmp = tempdir().unwrap();
        })
    assert_eq!(vals, vec![Some(1), Some(2), Some(3), None, None, None]);
        .to_string();
        &["val".into()],
            vec![Arc::new(Int64Array::from(vec![8, 5, 2]))],
        )
#[test]
    path: &str,
        0,
use parquet::arrow::ArrowWriter;
        vec!["alpha", "alpha", "alpha", "beta", "beta", "beta"]
    .unwrap();
        &[false],
        .to_string_lossy()
    let batches = vec![
            vec![Arc::new(Float32Array::from(vec![1.0f32, 3.0]))],
        )
        .to_string_lossy()
    .unwrap();
fn test_merge_sort_with_nulls_last() {
            schema.clone(),
            write_parquet(&s, b);
    )]));
    for batch in reader {
        .unwrap(),
    let files: Vec<String> = batches
            vec![Arc::new(Int64Array::from(vec![None, Some(2), Some(5)]))],
        &[],
        &output,
        &[],
        .unwrap(),
        )
        &[],
// ─── Multi-column: String + Int64 ──────────────────────────────────────────
/// Read all string values from a Utf8 column.
        .join("merged.parquet")
        .path()
#[test]
        &[true],
) -> Vec<Option<T::Native>> {
        .unwrap(),
            s
        .unwrap(),
        &files,
    let batches = vec![
}
            vec![
}
    let batches = vec![
fn test_merge_sort_by_int64() {
        RecordBatch::try_new(
use std::fs::File;
    let schema = Arc::new(Schema::new(vec![
 * this file be licensed under the Apache-2.0 license or a
}
        .unwrap(),
    )
        .unwrap(),
        )
    let output = tmp
#[test]
        })
        .path()
            let p = tmp.path().join(format!("input_{}.parquet", i));
            let p = tmp.path().join(format!("input_{}.parquet", i));
    let output = tmp
    let tmp = tempdir().unwrap();
        RecordBatch::try_new(
        RecordBatch::try_new(
            s
        .to_string_lossy()
                None,
#[test]
    let cats: Vec<String> = cats.into_iter().map(|v| v.unwrap()).collect();
        vals,
        .unwrap(),
            schema.clone(),
 *
    ];
        "test",
        &[],
    )
        RecordBatch::try_new(
        &["val".into()],
            let p = tmp.path().join(format!("input_{}.parquet", i));
    let output = tmp
    let vals = read_primitive_col::<arrow::datatypes::Int64Type>(&output, "val");
    let files: Vec<String> = batches
    let vals = read_primitive_col::<arrow::datatypes::Int64Type>(&output, "val");
    assert_eq!(
                Some(1.5),
        RecordBatch::try_new(
        &["val".into()],
            let s = p.to_string_lossy().to_string();
        .unwrap(),
    let vals = read_primitive_col::<arrow::datatypes::Int32Type>(&output, "val");
                Some(3.0),
//! Int64, Int32, Float64, Float32, Utf8, and multi-column combinations.
        0,
        .to_string();
    )
    merge_sorted(
fn test_merge_sort_with_nulls_first() {
                None,
        .unwrap()
        .enumerate()
    assert_eq!(vals, vec![Some(1), Some(2), Some(4), Some(5), None, None]);
        &output,
    ];
            schema.clone(),
    .unwrap();
        &[],
        .to_string();
}
        .enumerate()
    .unwrap();
        &output,
        .map(|(i, b)| {
        .unwrap(),
        &[],
        .map(|(i, b)| {
            let s = p.to_string_lossy().to_string();
        .unwrap(),
    let vals: Vec<i32> = vals.into_iter().map(|v| v.unwrap()).collect();
        }
            schema.clone(),
            ],
#[test]
            schema.clone(),
        .iter()
        .map(|(i, b)| {
            let p = tmp.path().join(format!("input_{}.parquet", i));
        "val",
        .join("merged.parquet")
        .join("merged.parquet")
        "test",
        &files,
        .to_string_lossy()
    let files: Vec<String> = batches
        &files,
            write_parquet(&s, b);
            vec![Arc::new(Int32Array::from(vec![20, 40]))],
        .unwrap(),
// ─── Int32 ──────────────────────────────────────────────────────────────────
        &[false, false],
        .to_string_lossy()
        let batch = batch.unwrap();
            s
    )
        &[],
    let files: Vec<String> = batches
        )
        .map(|(i, b)| {
        &[true],
        &output,
        &files,
        &[],
    let vals = read_primitive_col::<arrow::datatypes::Float32Type>(&output, "val");
        &[false],
        0,
    let tmp = tempdir().unwrap();
            vec![Arc::new(StringArray::from(vec!["apple", "cherry", "fig"]))],
            schema.clone(),
    )
        )
        &["val".into()],
        )
        &files,
    assert_eq!(
        .path()
    ];
        &["val".into()],
    let vals = read_primitive_col::<arrow::datatypes::Float32Type>(&output, "val");
}
        "test",
            schema.clone(),
        Field::new("priority", DataType::Int64, false),
    let vals = read_string_col(&output, "val");
        .join("merged.parquet")
    let schema = Arc::new(Schema::new(vec![Field::new("val", DataType::Int64, false)]));
        0,
        .map(|(i, b)| {
    .unwrap();
            schema.clone(),
    let schema = Arc::new(Schema::new(vec![Field::new(
    let schema = Arc::new(Schema::new(vec![Field::new(
        vec![None, None, Some(1.5), Some(2.5), Some(3.0), Some(4.0)]
        &[],
    for batch in reader {
        })
        .collect();
        "test",
        .join("merged.parquet")
                vals.push(None);
            schema.clone(),
    let batches = vec![
        ]
        .unwrap(),
    ];
#[test]
        true,
            schema.clone(),
#[test]
        .to_string();
        .iter()
    ];
            Some("fig".into())
        &[false],
        )
        RecordBatch::try_new(
        .path()
    .unwrap();
    let mut vals = Vec::new();
        )
        )
#[test]
#[test]
    ];
    );
        RecordBatch::try_new(
        .to_string_lossy()
        })
    let schema = Arc::new(Schema::new(vec![Field::new("val", DataType::Int64, true)]));
        .collect();
        .map(|(i, b)| {
        .unwrap();
        })
    // Each file pre-sorted with nulls first, then ascending
    let output = tmp
        RecordBatch::try_new(
        RecordBatch::try_new(
}
        RecordBatch::try_new(
        &["val".into()],
        RecordBatch::try_new(
fn write_parquet(path: &str, batch: &RecordBatch) {
    let pris = read_primitive_col::<arrow::datatypes::Int64Type>(&output, "priority");
        RecordBatch::try_new(
    // File A: [1, 3, 5]  File B: [2, 4, 6]  File C: [0, 7, 8]
    // File A: (alpha,1), (alpha,3), (beta,1)
            schema.clone(),
                Some("cherry"),
        .to_string();
    )
                None,
}
            vec![Arc::new(Int64Array::from(vec![Some(2), None, None]))],
                vals.push(Some(col.value(i)));
        &files,
        .collect();
            s
    assert_eq!(vals, vec![1.1, 2.2, 3.3, 4.4, 5.5, 6.6]);
    vals
        .unwrap(),
        )
        RecordBatch::try_new(
        })
        &[],
        &[false],
        &[],
            write_parquet(&s, b);
            let s = p.to_string_lossy().to_string();
        &["category".into(), "priority".into()],
        .unwrap(),
                Some(1.0f32),
    let vals: Vec<i64> = vals.into_iter().map(|v| v.unwrap()).collect();
fn test_merge_sort_descending() {
use tempfile::tempdir;
            write_parquet(&s, b);
        .iter()
        &[],
        )
        .enumerate()
    assert_eq!(
            vec![Arc::new(Float32Array::from(vec![2.0f32, 4.0]))],
        RecordBatch::try_new(
    let tmp = tempdir().unwrap();
            }
        .to_string();
            s
    let tmp = tempdir().unwrap();
        .to_string_lossy()
// ─── Float64 ────────────────────────────────────────────────────────────────
        &[],
        .unwrap(),
        &files,
    merge_sorted(
    let tmp = tempdir().unwrap();
        .path()
// ─── Int64 with nulls ───────────────────────────────────────────────────────
/// Read all values of a typed primitive column from a Parquet file.
        .enumerate()
                None,
        .unwrap(),
        &[true],
            vec![Arc::new(Int64Array::from(vec![1, 3, 5]))],
    let mut writer = ArrowWriter::try_new(file, batch.schema(), None).unwrap();
                Some("apple"),
            let p = tmp.path().join(format!("input_{}.parquet", i));
// ─── Int64 ──────────────────────────────────────────────────────────────────
            let p = tmp.path().join(format!("input_{}.parquet", i));
                Some(3.0),
            let s = p.to_string_lossy().to_string();
            vec![Arc::new(Float64Array::from(vec![1.1, 3.3, 5.5]))],
        .path()
        vals,
            s
            let p = tmp.path().join(format!("input_{}.parquet", i));
            let p = tmp.path().join(format!("input_{}.parquet", i));
    )
            write_parquet(&s, b);
        .build()
    let batches = vec![
        let col = batch.column(idx).as_string::<i32>();
        RecordBatch::try_new(
        &["val".into()],
    let vals: Vec<f32> = vals.into_iter().map(|v| v.unwrap()).collect();
        .enumerate()
            let s = p.to_string_lossy().to_string();
    writer.write(batch).unwrap();
fn read_string_col(path: &str, col_name: &str) -> Vec<Option<String>> {
        0,
        .collect();
        .enumerate()
        .join("merged.parquet")
}
        vec![Some(1.0), Some(2.0), Some(3.0), None, None, None]
        &["val".into()],
    let batches = vec![
}
        .collect();
        .unwrap()
    )
    let pris: Vec<i64> = pris.into_iter().map(|v| v.unwrap()).collect();
 * The OpenSearch Contributors require contributions made to
fn test_merge_sort_by_float64_with_nulls() {
    ];
        .to_string();
        .enumerate()
        &[],
        .build()
        "test",
    )
        &files,
    merge_sorted(
        .to_string();
    .unwrap();
    let schema = Arc::new(Schema::new(vec![Field::new(
    merge_sorted(
        .iter()
    let files: Vec<String> = batches
        .to_string_lossy()
        false,
    let batches = vec![
    )]));
            let s = p.to_string_lossy().to_string();
    let batches = vec![
        "test",
        .unwrap()
        .collect();
            let s = p.to_string_lossy().to_string();
        DataType::Float32,
        .join("merged.parquet")
                Some(4.0),
        .path()
            schema.clone(),
            write_parquet(&s, b);
fn test_merge_sort_multi_column_string_and_int() {
        &[false],
        "test",
    .unwrap();
            write_parquet(&s, b);
                None,
        .unwrap();
    )
        vec!["apple", "banana", "cherry", "date", "fig", "grape"]
    let vals: Vec<String> = vals.into_iter().map(|v| v.unwrap()).collect();
            let s = p.to_string_lossy().to_string();
            } else {
fn test_merge_sort_by_int32() {
            vec![Arc::new(Int64Array::from(vec![7, 4, 1]))],
        .unwrap();
            schema.clone(),
        )
        .to_string_lossy()
#[test]
            let s = p.to_string_lossy().to_string();
    merge_sorted(
            let p = tmp.path().join(format!("input_{}.parquet", i));
        &output,
        .join("merged.parquet")
        &output,
        })
        .collect();
            if col.is_null(i) {
    )]));
        for i in 0..col.len() {
        .enumerate()
        .iter()
use arrow::array::*;
use arrow::datatypes::{DataType, Field, Schema};
// ─── Float32 with nulls ─────────────────────────────────────────────────────
    assert_eq!(pris, vec![1, 2, 3, 1, 2, 3]);
        vals,
        )
            let p = tmp.path().join(format!("input_{}.parquet", i));
                Arc::new(StringArray::from(vec!["alpha", "alpha", "beta"])),
    let reader = ParquetRecordBatchReaderBuilder::try_new(file)
        "test",
            let s = p.to_string_lossy().to_string();
        &[false],
 */
    merge_sorted(
}
        .iter()
            schema.clone(),
    let files: Vec<String> = batches
fn test_merge_sort_by_string() {
fn test_merge_sort_by_float32_with_nulls() {
    )
        &["val".into()],
    let tmp = tempdir().unwrap();
    let output = tmp
            ]))],
        .iter()
        RecordBatch::try_new(
        .join("merged.parquet")
            let p = tmp.path().join(format!("input_{}.parquet", i));
            ],
    let reader = ParquetRecordBatchReaderBuilder::try_new(file)
        &["val".into()],
    assert_eq!(vals, vec![10, 20, 30, 40]);
    let output = tmp
        0,
        &[false],
        .enumerate()
        )
        })
        .unwrap(),
        .unwrap(),
        &[false],
    let batches = vec![
        .map(|(i, b)| {
            vec![Arc::new(Float64Array::from(vec![2.2, 4.4, 6.6]))],
// ─── Float64 with nulls ─────────────────────────────────────────────────────
        .map(|(i, b)| {
        &output,
// ─── Descending sort ────────────────────────────────────────────────────────
    reader.map(|b| b.unwrap().num_rows()).sum()
        DataType::Float32,
    let tmp = tempdir().unwrap();
        cats,
            s
        )
            vec![Arc::new(Float32Array::from(vec![Some(2.0f32), None, None]))],
        .to_string();
        &[],
            schema.clone(),
        )
            ]))],
            } else {
    let vals = read_primitive_col::<arrow::datatypes::Int64Type>(&output, "val");
            Some("cherry".into()),
            vec![Arc::new(Int64Array::from(vec![9, 6, 3]))],
            schema.clone(),
        let idx = batch.schema().index_of(col_name).unwrap();
    let vals = read_primitive_col::<arrow::datatypes::Float64Type>(&output, "val");
            vec![Arc::new(Int32Array::from(vec![10, 30]))],
        .enumerate()
            schema.clone(),
    let schema = Arc::new(Schema::new(vec![Field::new("val", DataType::Int64, true)]));
        .build()
        .path()
            schema.clone(),
        &[],
            vec![Arc::new(Float64Array::from(vec![
    let vals = read_primitive_col::<arrow::datatypes::Int64Type>(&output, "val");
        for i in 0..col.len() {
    assert_eq!(vals, vec![1.0, 2.0, 3.0, 4.0]);
        &output,
    merge_sorted(
/// Count rows in a Parquet file.
        RecordBatch::try_new(
        .iter()
}
        )
fn count_rows(path: &str) -> usize {
        false,
                vals.push(None);
    let vals = read_primitive_col::<arrow::datatypes::Float64Type>(&output, "val");
 * SPDX-License-Identifier: Apache-2.0
    merge_sorted(
        &[false],
// ─── Float32 ────────────────────────────────────────────────────────────────
        })
        &[],
            s
fn test_merge_sort_by_string_with_nulls() {
    let vals: Vec<f64> = vals.into_iter().map(|v| v.unwrap()).collect();
        .enumerate()
                vals.push(Some(col.value(i).to_string()));
        .join("merged.parquet")
            }
        &[],
        0,
            None,
        .map(|(i, b)| {
            vec![
        .to_string_lossy()
            s
    let file = File::open(path).unwrap();
    col_name: &str,
        )
    merge_sorted(
    let files: Vec<String> = batches
        .iter()
// ─── Nulls ──────────────────────────────────────────────────────────────────
        "test",
        })
        let col = batch.column(idx).as_primitive::<T>();
                Some("banana"),
fn test_merge_sort_by_float64() {
    );
    .unwrap();
        &[],
//! Tests for merge_sorted across all supported sort column types:
            Some("banana".into()),
    );
    ]));
        .collect();
        .unwrap(),
        RecordBatch::try_new(
        .unwrap(),
            write_parquet(&s, b);
        .to_string_lossy()
    let batches = vec![
        &[],
    }
/// Write a single RecordBatch to a new Parquet file.
        .collect();
        RecordBatch::try_new(
        "val",
    let files: Vec<String> = batches
    merge_sorted(
            let p = tmp.path().join(format!("input_{}.parquet", i));
    let schema = Arc::new(Schema::new(vec![Field::new("val", DataType::Utf8, true)]));
            vec![Arc::new(Int64Array::from(vec![0, 7, 8]))],
    // nulls_first=false → values ascending, then nulls
// ─── Utf8 with nulls ────────────────────────────────────────────────────────
        &[false],
            vec![Arc::new(StringArray::from(vec![
    // Each file pre-sorted: nulls last, then ascending
    let cats = read_string_col(&output, "category");
    let output = tmp
            s
        )
        &[true],
    assert_eq!(
        .collect();
        &output,
}
        &[false],
        Field::new("category", DataType::Utf8, false),
    let files: Vec<String> = batches
        .collect();
        &["val".into()],
    ];
    assert_eq!(
    let file = File::open(path).unwrap();
    let mut vals = Vec::new();
        }
        &[],
    let tmp = tempdir().unwrap();
            if col.is_null(i) {
        &[false],
                Some("fig"),
        .collect();
    // Each file sorted descending
            let s = p.to_string_lossy().to_string();
            write_parquet(&s, b);
}
        0,
    let output = tmp
    vals
        RecordBatch::try_new(
/*
        })
        .join("merged.parquet")
        &[],
        .map(|(i, b)| {
// ─── Utf8 (String / keyword) ───────────────────────────────────────────────
        .iter()
        &["val".into()],
        )
            vec![Arc::new(Int64Array::from(vec![Some(2), Some(4), None]))],
        .unwrap(),
    let tmp = tempdir().unwrap();
            let s = p.to_string_lossy().to_string();
    ];
        .enumerate()
        0,
        .unwrap(),
    let file = File::create(path).unwrap();
    assert_eq!(count_rows(&output), 9);
    let files: Vec<String> = batches
        &[false],
    let output = tmp
        &[false],
            None,
    assert_eq!(vals, vec![0, 1, 2, 3, 4, 5, 6, 7, 8]);
    // Sorted by (category ASC, priority ASC)
        &output,
    let schema = Arc::new(Schema::new(vec![Field::new("val", DataType::Int64, false)]));
#[test]
        RecordBatch::try_new(
        RecordBatch::try_new(
        RecordBatch::try_new(
    let schema = Arc::new(Schema::new(vec![Field::new(
            vec![Arc::new(Int64Array::from(vec![Some(1), Some(5), None]))],
    assert_eq!(vals, vec![9, 8, 7, 6, 5, 4, 3, 2, 1]);
            write_parquet(&s, b);
    .unwrap();
        &output,
        RecordBatch::try_new(
    let reader = ParquetRecordBatchReaderBuilder::try_new(file)
        &[false],
            let s = p.to_string_lossy().to_string();
        DataType::Float64,
            vec![Arc::new(Float32Array::from(vec![
        .path()
        .join("merged.parquet")
    }
        RecordBatch::try_new(
    let batches = vec![
    .unwrap();
            write_parquet(&s, b);
        &output,
    let output = tmp
        DataType::Float64,
        &files,
        .to_string_lossy()
        "test",
        )
        .iter()
        "test",
        })
            s
    assert_eq!(vals, vec![None, None, Some(1), Some(2), Some(4), Some(5)]);
    let output = tmp
        &output,
 * compatible open source license.
        .path()
        .map(|(i, b)| {
        &files,
        .join("merged.parquet")
        true,
            schema.clone(),
        &[false, false],
    let batches = vec![
use parquet::arrow::arrow_reader::ParquetRecordBatchReaderBuilder;
        .enumerate()
    // File A: [null, 2, 5]  File B: [null, 1, 4]
        )
    )
            vec![Arc::new(StringArray::from(vec!["banana", "date", "grape"]))],
}
        &[],
            vec![Arc::new(Int64Array::from(vec![2, 4, 6]))],
