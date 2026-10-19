    let vals = read_primitive_col::<arrow::datatypes::Int64Type>(&output, "val");
    let output = tmp
        &output,
            s
        .build()
        .to_string_lossy()
    let tmp = tempdir().unwrap();
    ];
            schema.clone(),
        .to_string();
// ─── Int64 ──────────────────────────────────────────────────────────────────
#[test]
        0,
        .map(|(i, b)| {
    let vals = read_primitive_col::<arrow::datatypes::Int64Type>(&output, "val");
    let batches = vec![
        &output,
        .path()
            }
    .unwrap();
    let output = tmp
        0,
    let batches = vec![
        .to_string_lossy()
    col_name: &str,
        &[true],
        &files,
        &[],
#[test]
    let schema = Arc::new(Schema::new(vec![Field::new("val", DataType::Int64, true)]));
 * The OpenSearch Contributors require contributions made to
// ─── Float64 ────────────────────────────────────────────────────────────────
        .unwrap(),
            write_parquet(&s, b);
        .join("merged.parquet")
            schema.clone(),
        .enumerate()
        &output,
        .unwrap(),
        .iter()
use parquet::arrow::arrow_reader::ParquetRecordBatchReaderBuilder;
        &[false],
    let schema = Arc::new(Schema::new(vec![Field::new("val", DataType::Int64, true)]));
        &["val".into()],
            s
// ─── Float32 ────────────────────────────────────────────────────────────────
        )
        false,
                vals.push(Some(col.value(i).to_string()));
    );
            vec![Arc::new(Int64Array::from(vec![0, 7, 8]))],
    // Sorted by (category ASC, priority ASC)
    );
    let batches = vec![
        RecordBatch::try_new(
        .to_string_lossy()
            s
        RecordBatch::try_new(
        &["val".into()],
    assert_eq!(vals, vec![9, 8, 7, 6, 5, 4, 3, 2, 1]);
        .path()
        "test",
        )
    let files: Vec<String> = batches
            vec![Arc::new(Int32Array::from(vec![20, 40]))],
        &output,
    let batches = vec![
    // File A: [1, 3, 5]  File B: [2, 4, 6]  File C: [0, 7, 8]
        .to_string_lossy()
        &[true],
    .unwrap();
            let s = p.to_string_lossy().to_string();
    ];
        .map(|(i, b)| {
        true,
    let files: Vec<String> = batches
        .collect();
        })
    );
    let tmp = tempdir().unwrap();
        vals,
        let col = batch.column(idx).as_string::<i32>();
        "test",
fn test_merge_sort_by_string_with_nulls() {
        &[],
    assert_eq!(count_rows(&output), 9);
        RecordBatch::try_new(
    merge_sorted(
fn test_merge_sort_by_float32() {
        })
            s
    merge_sorted(
        )
        .path()
            let p = tmp.path().join(format!("input_{}.parquet", i));
        &[],
    let file = File::open(path).unwrap();
        RecordBatch::try_new(
    merge_sorted(
            let s = p.to_string_lossy().to_string();
// ─── Int64 with nulls ───────────────────────────────────────────────────────
    ];
    merge_sorted(
}
}
        .unwrap(),
    merge_sorted(
    let output = tmp
    assert_eq!(
            write_parquet(&s, b);
        .enumerate()
    let vals = read_primitive_col::<arrow::datatypes::Int64Type>(&output, "val");
        .to_string();
        .unwrap(),
                vals.push(None);
        &[false],
            s
            let s = p.to_string_lossy().to_string();
        )
        &[false],
        &files,
#[test]
                None,
}
        .join("merged.parquet")
        .collect();
    let batches = vec![
            let p = tmp.path().join(format!("input_{}.parquet", i));
        &[],
        .unwrap(),
    let batches = vec![
    let tmp = tempdir().unwrap();
                Some(2.5),
    let mut vals = Vec::new();
            schema.clone(),
            schema.clone(),
        })
        RecordBatch::try_new(
        .join("merged.parquet")
        })
        })
        RecordBatch::try_new(
    let schema = Arc::new(Schema::new(vec![Field::new("val", DataType::Int64, false)]));
        &output,
}
            vec![Arc::new(Float32Array::from(vec![2.0f32, 4.0]))],
        )
        .join("merged.parquet")
        RecordBatch::try_new(
            vec![
 *
fn test_merge_sort_by_string() {
            schema.clone(),
    let vals = read_primitive_col::<arrow::datatypes::Float64Type>(&output, "val");
        .collect();
        .collect();
            schema.clone(),
    let mut vals = Vec::new();
    writer.close().unwrap();
    let schema = Arc::new(Schema::new(vec![
            schema.clone(),
        .join("merged.parquet")
        0,
    let output = tmp
        .build()
    assert_eq!(vals, vec![10, 20, 30, 40]);
    let pris: Vec<i64> = pris.into_iter().map(|v| v.unwrap()).collect();
            write_parquet(&s, b);
        &output,
            let p = tmp.path().join(format!("input_{}.parquet", i));
        0,
use tempfile::tempdir;
        0,
/*
        &[],
        .to_string_lossy()
        .path()
        let batch = batch.unwrap();
        &[false],
    ];
            schema.clone(),
        )
        .join("merged.parquet")
#[test]
            schema.clone(),
        RecordBatch::try_new(
    let files: Vec<String> = batches
        .path()
            vec![Arc::new(Float32Array::from(vec![
        &[],
        )
    let output = tmp
                Some(3.0),
        &[true],
    let output = tmp
            Some("cherry".into()),
    let tmp = tempdir().unwrap();
        "test",
            schema.clone(),
            let p = tmp.path().join(format!("input_{}.parquet", i));
    for batch in reader {
                Some(1.0f32),
        .iter()
    for batch in reader {
            vec![Arc::new(Int64Array::from(vec![7, 4, 1]))],
#[test]
        RecordBatch::try_new(
        &[false],
        .enumerate()
            schema.clone(),
        })
    let vals: Vec<i32> = vals.into_iter().map(|v| v.unwrap()).collect();
    let schema = Arc::new(Schema::new(vec![Field::new(
            schema.clone(),
    }
        &[],
        &files,
        .to_string();
        .to_string();
    let vals: Vec<f32> = vals.into_iter().map(|v| v.unwrap()).collect();
        .map(|(i, b)| {
            schema.clone(),
            None,
            None,
            let s = p.to_string_lossy().to_string();
 * compatible open source license.
        &[false],
        .unwrap(),
    let vals = read_primitive_col::<arrow::datatypes::Float64Type>(&output, "val");
    reader.map(|b| b.unwrap().num_rows()).sum()
    // File B: (alpha,2), (beta,2), (beta,3)
            write_parquet(&s, b);
    .unwrap();
    );
        .unwrap(),
            write_parquet(&s, b);
    // File A: (alpha,1), (alpha,3), (beta,1)
        .join("merged.parquet")
// ─── Descending sort ────────────────────────────────────────────────────────
        })
        "test",
        .to_string();
        .path()
}
        .path()
    let files: Vec<String> = batches
    let tmp = tempdir().unwrap();
fn test_merge_sort_by_float64() {
        .to_string();
fn test_merge_sort_multi_column_string_and_int() {
        &[],
    let schema = Arc::new(Schema::new(vec![Field::new("val", DataType::Int64, true)]));
        )
        &files,
            vec![Arc::new(Float64Array::from(vec![
            Some("banana".into()),
        .enumerate()
        .path()
    let vals = read_primitive_col::<arrow::datatypes::Int64Type>(&output, "val");
                Arc::new(Int64Array::from(vec![2, 2, 3])),
    let tmp = tempdir().unwrap();
        vec![Some(1.0), Some(2.0), Some(3.0), None, None, None]
        &[],
        .iter()
#[test]
            let s = p.to_string_lossy().to_string();
        .enumerate()
        &[],
        DataType::Float64,
        .unwrap(),
}
// ─── Nulls ──────────────────────────────────────────────────────────────────
        )
        .unwrap();
            s
    )
}
        .unwrap(),
/// Count rows in a Parquet file.
                vals.push(Some(col.value(i)));
        let col = batch.column(idx).as_primitive::<T>();
    )]));
        false,
}
    let tmp = tempdir().unwrap();
        .iter()
            let p = tmp.path().join(format!("input_{}.parquet", i));
//! Tests for merge_sorted across all supported sort column types:
        &files,
            } else {
            vec![Arc::new(Int64Array::from(vec![8, 5, 2]))],
            ]))],
    .unwrap();
        .join("merged.parquet")
    .unwrap();
    // File A: [null, 2, 5]  File B: [null, 1, 4]
        &[],
        &[],
    let files: Vec<String> = batches
        &[false],
    )]));
                None,
        RecordBatch::try_new(
                None,
    let output = tmp
        "test",
        &[],
        .iter()
        &output,
        )
            ]))],
    )]));
    let tmp = tempdir().unwrap();
            s
        RecordBatch::try_new(
        )
        .map(|(i, b)| {
        .unwrap(),
    let batches = vec![
        .unwrap();
            vec![Arc::new(StringArray::from(vec!["apple", "cherry", "fig"]))],
        RecordBatch::try_new(
            vec![Arc::new(Float32Array::from(vec![1.0f32, 3.0]))],
    // nulls_first=true → nulls come first, then ascending
    )
    let files: Vec<String> = batches
        &[],
            vec![Arc::new(Int64Array::from(vec![Some(1), Some(3), None]))],
        .path()
        .to_string_lossy()
    let pris = read_primitive_col::<arrow::datatypes::Int64Type>(&output, "priority");
        })
    let schema = Arc::new(Schema::new(vec![Field::new(
        Field::new("priority", DataType::Int64, false),
            let s = p.to_string_lossy().to_string();
        Field::new("category", DataType::Utf8, false),
        .unwrap();
    let batches = vec![
            schema.clone(),
    assert_eq!(
        .iter()
            let p = tmp.path().join(format!("input_{}.parquet", i));
        )
    let reader = ParquetRecordBatchReaderBuilder::try_new(file)
        .unwrap(),
        )
        RecordBatch::try_new(
fn test_merge_sort_by_int32() {
        .to_string_lossy()
        &["val".into()],
                None,
            vec![Arc::new(Int64Array::from(vec![Some(2), None, None]))],
    assert_eq!(
    ]));
    merge_sorted(
    let file = File::create(path).unwrap();
        &[],
        "val",
use opensearch_parquet_format::merge::merge_sorted;
            if col.is_null(i) {
        vals,
    vals
        .to_string();
            ]))],
        "val",
    writer.write(batch).unwrap();
        .iter()
 * this file be licensed under the Apache-2.0 license or a
        &[false],
                Some(4.0),
            schema.clone(),
        "val",
    merge_sorted(
    .unwrap();
    assert_eq!(
        .collect();
        .join("merged.parquet")
#[test]
    ];
    let files: Vec<String> = batches
    let schema = Arc::new(Schema::new(vec![Field::new(
        &output,
}
        .unwrap(),
        &[false],
                Some("cherry"),
    let files: Vec<String> = batches
            let s = p.to_string_lossy().to_string();
        &[false],
        &[false],
        for i in 0..col.len() {
    )
            vec![Arc::new(Int64Array::from(vec![Some(1), Some(5), None]))],
    // Each file sorted descending
}
    assert_eq!(vals, vec![Some(1), Some(2), Some(4), Some(5), None, None]);
fn write_parquet(path: &str, batch: &RecordBatch) {
        RecordBatch::try_new(
        &output,
use std::fs::File;
        .to_string();
        ]
    )]));
        &[false],
        "test",
    let output = tmp
            let p = tmp.path().join(format!("input_{}.parquet", i));
    let schema = Arc::new(Schema::new(vec![Field::new(
        .unwrap(),
fn test_merge_sort_descending() {
            write_parquet(&s, b);
fn test_merge_sort_with_nulls_last() {
        &[],
        &files,
        .map(|(i, b)| {
        .map(|(i, b)| {
        RecordBatch::try_new(
    ];
    assert_eq!(vals, vec![0, 1, 2, 3, 4, 5, 6, 7, 8]);
            vec![Arc::new(Int32Array::from(vec![10, 30]))],
        &output,
    ];
                Some("banana"),
            if col.is_null(i) {
        .to_string_lossy()
        .collect();
        .unwrap(),
        0,
        .unwrap(),
            let p = tmp.path().join(format!("input_{}.parquet", i));
            schema.clone(),
// ─── Float32 with nulls ─────────────────────────────────────────────────────
    // Each file pre-sorted with nulls first, then ascending
        RecordBatch::try_new(
        .unwrap(),
            let s = p.to_string_lossy().to_string();
            vec![Arc::new(Int64Array::from(vec![2, 4, 6]))],
            ],
        vals,
        "test",
    assert_eq!(vals, vec![1.1, 2.2, 3.3, 4.4, 5.5, 6.6]);
        .unwrap(),
    assert_eq!(
    let output = tmp
}
fn count_rows(path: &str) -> usize {
        RecordBatch::try_new(
//! Int64, Int32, Float64, Float32, Utf8, and multi-column combinations.
fn test_merge_sort_by_int64_with_nulls() {
// ─── Multi-column: String + Int64 ──────────────────────────────────────────
}
            vec![Arc::new(Float64Array::from(vec![1.1, 3.3, 5.5]))],
        .map(|(i, b)| {
            vec![Arc::new(Int64Array::from(vec![9, 6, 3]))],
                Arc::new(StringArray::from(vec!["alpha", "alpha", "beta"])),
        .collect();
        DataType::Float32,
#[test]
        )
        true,
    )
            let s = p.to_string_lossy().to_string();
    let tmp = tempdir().unwrap();
            s
    )
        &output,
            let s = p.to_string_lossy().to_string();
            s
            s
        "test",
    let cats = read_string_col(&output, "category");
#[test]
        .enumerate()
        vec!["alpha", "alpha", "alpha", "beta", "beta", "beta"]
        vals,
fn test_merge_sort_with_nulls_first() {
        .map(|(i, b)| {
        .collect();
}
    let files: Vec<String> = batches
        &[],
            write_parquet(&s, b);
            schema.clone(),
            vec![Arc::new(StringArray::from(vec![
        &["category".into(), "priority".into()],
    )
            vec![Arc::new(Int64Array::from(vec![Some(2), Some(4), None]))],
        &[],
use arrow::datatypes::{DataType, Field, Schema};
    let output = tmp
        &[],
        &[false, false],
        .collect();
            schema.clone(),
        "test",
    let files: Vec<String> = batches
    )
) -> Vec<Option<T::Native>> {
        .build()
    .unwrap();
    let files: Vec<String> = batches
        )
        .map(|(i, b)| {
        .iter()
// ─── Int32 ──────────────────────────────────────────────────────────────────
        .path()
fn test_merge_sort_by_int64() {
                Some(1.5),
/// Write a single RecordBatch to a new Parquet file.
            vec![
        })
        &files,
    ];
    vals
                Some("apple"),
            schema.clone(),
        )
        &files,
            write_parquet(&s, b);
    .unwrap();
        .unwrap()
        &[false],
            let s = p.to_string_lossy().to_string();
    .unwrap();
use std::sync::Arc;
        .to_string();
fn read_primitive_col<T: arrow::datatypes::ArrowPrimitiveType>(
            schema.clone(),
        .unwrap(),
            vec![Arc::new(Int64Array::from(vec![None, Some(1), Some(4)]))],
    merge_sorted(
        &[false],
            schema.clone(),
        &files,
    ];
        &[],
    let schema = Arc::new(Schema::new(vec![Field::new("val", DataType::Utf8, true)]));
    )
        .map(|(i, b)| {
        .map(|(i, b)| {
        .to_string_lossy()
        &[],
    let vals = read_primitive_col::<arrow::datatypes::Float32Type>(&output, "val");
        .iter()
    .unwrap();
        .to_string();
        .to_string_lossy()
            } else {
    let tmp = tempdir().unwrap();
        .to_string_lossy()
    let files: Vec<String> = batches
    let vals: Vec<i64> = vals.into_iter().map(|v| v.unwrap()).collect();
// ─── Float64 with nulls ─────────────────────────────────────────────────────
        .collect();
                Some(3.0),
    let vals = read_string_col(&output, "val");
        .join("merged.parquet")
        )
        })
        .iter()
    let file = File::open(path).unwrap();
        )
use parquet::arrow::ArrowWriter;
    path: &str,
    // nulls_first=false → values ascending, then nulls
        "test",
            let s = p.to_string_lossy().to_string();
        .iter()
        .join("merged.parquet")
}
            let p = tmp.path().join(format!("input_{}.parquet", i));
    let vals: Vec<i64> = vals.into_iter().map(|v| v.unwrap()).collect();
    merge_sorted(
    merge_sorted(
        )
    merge_sorted(
        &[],
// ─── Utf8 (String / keyword) ───────────────────────────────────────────────
    assert_eq!(vals, vec![Some(1), Some(2), Some(3), None, None, None]);
        0,
        &[],
            let p = tmp.path().join(format!("input_{}.parquet", i));
        .to_string_lossy()
        &["val".into()],
    let batches = vec![
        &["val".into()],
        .unwrap()
        &files,
        &["val".into()],
        .unwrap(),
fn test_merge_sort_by_float32_with_nulls() {
            write_parquet(&s, b);
        &output,
        &files,
    let vals = read_primitive_col::<arrow::datatypes::Float32Type>(&output, "val");
        0,
    let vals: Vec<String> = vals.into_iter().map(|v| v.unwrap()).collect();
    let schema = Arc::new(Schema::new(vec![Field::new("val", DataType::Utf8, false)]));
            vec![Arc::new(Float64Array::from(vec![2.2, 4.4, 6.6]))],
            schema.clone(),
    assert_eq!(vals, vec![1.0, 2.0, 3.0, 4.0]);
        &["val".into()],
        let idx = batch.schema().index_of(col_name).unwrap();
        DataType::Float32,
        )
    let vals = read_string_col(&output, "val");
        .iter()
        &["val".into()],
            let p = tmp.path().join(format!("input_{}.parquet", i));
        &[false],
        &[false, false],
        cats,
                None,
        .map(|(i, b)| {
        &[false],
        .enumerate()
    let file = File::open(path).unwrap();
        }
            vec![Arc::new(Int64Array::from(vec![1, 3, 5]))],
        RecordBatch::try_new(
        vec![None, None, Some(1.5), Some(2.5), Some(3.0), Some(4.0)]
        .to_string_lossy()
            vec![Arc::new(Float32Array::from(vec![Some(2.0f32), None, None]))],
        .path()
fn read_string_col(path: &str, col_name: &str) -> Vec<Option<String>> {
        vec![
        RecordBatch::try_new(
                Some("fig"),
    let files: Vec<String> = batches
    .unwrap();
    ];
        &["val".into()],
        )
    let vals = read_primitive_col::<arrow::datatypes::Int64Type>(&output, "val");
        0,
                vals.push(None);
            vec![Arc::new(StringArray::from(vec!["banana", "date", "grape"]))],
#[test]
        0,
        .unwrap(),
        RecordBatch::try_new(
        RecordBatch::try_new(
            schema.clone(),
        .enumerate()
    let batches = vec![
            let s = p.to_string_lossy().to_string();
        0,
        })
        &output,
        &[],
            vec![Arc::new(Float64Array::from(vec![
}
        RecordBatch::try_new(
        .to_string();
    .unwrap();
// ─── Utf8 with nulls ────────────────────────────────────────────────────────
        &["val".into()],
        let idx = batch.schema().index_of(col_name).unwrap();
        RecordBatch::try_new(
        for i in 0..col.len() {
        .join("merged.parquet")
        &[],
        )
            write_parquet(&s, b);
    let tmp = tempdir().unwrap();
        DataType::Float64,
        &[false],
    let batches = vec![
    let batches = vec![
            vec![Arc::new(Int64Array::from(vec![None, Some(2), Some(5)]))],
        .enumerate()
    let reader = ParquetRecordBatchReaderBuilder::try_new(file)
    merge_sorted(
        )
            s
 * SPDX-License-Identifier: Apache-2.0
        .unwrap(),
            }
    let vals = read_primitive_col::<arrow::datatypes::Int32Type>(&output, "val");
            s
        "test",
}
#[test]
    let mut writer = ArrowWriter::try_new(file, batch.schema(), None).unwrap();
use arrow::array::*;
        RecordBatch::try_new(
    let output = tmp
/// Read all values of a typed primitive column from a Parquet file.
            s
        })
        &["val".into()],
        .collect();
    let output = tmp
    )
        .to_string();
                Arc::new(StringArray::from(vec!["alpha", "beta", "beta"])),
        .unwrap(),
    merge_sorted(
    )
        &["val".into()],
        .enumerate()
    ];
        0,
#[test]
    let reader = ParquetRecordBatchReaderBuilder::try_new(file)
    let output = tmp
        RecordBatch::try_new(
            write_parquet(&s, b);
        &[false],
        .unwrap(),
    .unwrap();
            write_parquet(&s, b);
            schema.clone(),
        .unwrap()
            schema.clone(),
        )
            let p = tmp.path().join(format!("input_{}.parquet", i));
    let tmp = tempdir().unwrap();
        RecordBatch::try_new(
    let batches = vec![
            Some("fig".into())
        0,
            let p = tmp.path().join(format!("input_{}.parquet", i));
    )
        .unwrap(),
    assert_eq!(vals, vec![None, None, Some(1), Some(2), Some(4), Some(5)]);
    let schema = Arc::new(Schema::new(vec![Field::new("val", DataType::Int64, false)]));
    let schema = Arc::new(Schema::new(vec![Field::new("val", DataType::Int32, false)]));
        &[],
        .map(|(i, b)| {
        .iter()
fn test_merge_sort_by_float64_with_nulls() {
        .path()
    ];
        &[false],
        .path()
            schema.clone(),
        )
    let cats: Vec<String> = cats.into_iter().map(|v| v.unwrap()).collect();
            vec![Arc::new(StringArray::from(vec![
            write_parquet(&s, b);
                Arc::new(Int64Array::from(vec![1, 3, 1])),
        &[false],
        )
    assert_eq!(pris, vec![1, 2, 3, 1, 2, 3]);
        .collect();
            Some("apple".into()),
}
        &files,
        .unwrap(),
        .enumerate()
        vec!["apple", "banana", "cherry", "date", "fig", "grape"]
 */
        .unwrap(),
        }
        .enumerate()
        })
    ];
            schema.clone(),
        "test",
        .join("merged.parquet")
    // Each file pre-sorted: nulls last, then ascending
/// Read all string values from a Utf8 column.
    let tmp = tempdir().unwrap();
        .unwrap(),
        .to_string();
    )
        .unwrap(),
        .enumerate()
    let vals: Vec<f64> = vals.into_iter().map(|v| v.unwrap()).collect();
            ]))],
    )
        &files,
            ],
            schema.clone(),
            ]))],
#[test]
        )
        &[true],
        "test",
        let batch = batch.unwrap();
        )
        .collect();
    }
        RecordBatch::try_new(
    );
        "val",
        RecordBatch::try_new(
