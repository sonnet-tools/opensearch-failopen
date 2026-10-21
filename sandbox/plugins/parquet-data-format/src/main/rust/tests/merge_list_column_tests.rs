 * this file be licensed under the Apache-2.0 license or a
        .map(|r| r.as_ref().map(|v| v.iter().map(|s| s.as_str()).collect()))
fn sorted_merge_list_explicit_min_ascending() {
    SETTINGS_STORE.insert(
        expected.keys()
            Arc::new(Int64Array::from(ids.to_vec())) as ArrayRef,
    write_list_file(
    let out = tmp.path().join("out.parquet").to_string_lossy().to_string();
    merge_sorted(
            }
    // Sort order by id, and every row keeps exactly its own values.
        .path()
}
            Some(vec!["solo"]),
    for batch in reader {
fn merge_rejects_incompatible_scalar_and_list_child_types() {
                );
    let ids_a: Vec<i64> = (0..20).map(|i| i * 2 + 1).collect();
    assert!(descending_ids[4..].contains(&50));
    }
        &[],
// ─────────────────────────────────────────────────────────────────────────
    assert_eq!(ids.len(), rows.len());
            Some(vec!["alpha"]),
/// `merge_batch_size` small enough that each cursor spans several batches (so the k-way merge
        &[],
    // MIN asc: a(10) < m(20) => [10, 20]
        &a,
fn sorted_merge_list_explicit_min_descending() {
}
        &[scalar, list],
// ─────────────────────────────────────────────────────────────────────────
        "merge-list-max-nulls",
use arrow::array::*;
    write_list_file(
    assert_eq!(pairs[2], (3, v(&["solo"])));
        &["id".to_string()],
//! `__row_id__`, and re-encodes each column through `compute_leaves`. All of that must keep a
    for (id, tags) in ids_a.iter().zip(owned_a.iter()) {
    merge_sorted(
    assert_eq!(ids, vec![10, 20]);
fn as_refs(rows: &[Option<Vec<String>>]) -> Vec<Option<Vec<&str>>> {
    assert_eq!(pairs[1], (2, None), "null list must stay null");
        &[false],
                        .collect(),
        .to_string_lossy()
            Arc::new(StringArray::from(rows.to_vec())) as ArrayRef,
        ],
        0,
    .unwrap();
        .join("list.parquet")
        .path()
        &[true], // descending
    let a = tmp.path().join("a.parquet").to_string_lossy().to_string();
}
    let ids: Vec<i64> = read_pairs(&out).into_iter().map(|(id, _)| id).collect();
            out.push((ids.value(row), tags));
                            }
// index.sort.mode (MIN / MAX) coverage for LIST sort columns.
        assert!(
        .collect();
        }
        NativeSettings {
    let values = Arc::new(Int32Array::from(vec![1, 2])) as ArrayRef;
            Some(vec![None]),
            Some(vec!["omega", "gamma"]),
    .unwrap();
                3,
        &[false],
                values.extend(
        &out,
        .join("merged.parquet")
        match row {
    let a = tmp.path().join("a.parquet").to_string_lossy().to_string();
    write_list_file(&b, &[20], &[Some(vec!["m", "n"])]);
        index.to_string(),
    for row in rows {
        .to_string_lossy()
}
        .path()
    let batch = RecordBatch::try_new(
    let tmp = tempdir().unwrap();
        Arc::clone(&schema),
        0,
    merge_sorted(
        expected.insert(*id, tags.clone());
        &[10, 30, 50],
            1 => None,
        &[false],
    write_list_file(&a, &ids_a, &as_refs(&owned_a));
        let batch = batch.unwrap();
    let ascending = tmp
        0,
        &[false, true],
fn write_scalar_file(path: &str, ids: &[i64], rows: &[Option<&str>]) {
                    Some("beta".to_string()),
        &[
    assert!(
        pairs.iter().map(|(id, _)| *id).collect::<Vec<_>>(),
        expected.insert(*id, tags.clone());
        .to_string_lossy()
        &descending_a,
    let b = tmp.path().join("b.parquet").to_string_lossy().to_string();
 * SPDX-License-Identifier: Apache-2.0
use tempfile::tempdir;
        &[],
        assert!(
    assert_eq!(ids, vec![10, 20]);
        &[Some(vec!["omega", "gamma"]), Some(vec!["beta", "zz"]), None],
#[test]
    let descending_a = tmp
        .to_string();
        &out,
    )
        .path()
    writer.close().unwrap();
        &a,
        .to_string();
    .unwrap();
        for row in 0..batch.num_rows() {
        .path()
            Some(vec!["m", "beta"]),
//
        &[a, b],
    );
#[test]
        &[1, 2, 3],
        0,
        0,
    merge_sorted(
        .collect()
    );
    // Pre-sorted by MIN element descending: B(MIN=m) then A(MIN=a).
        &[1, 2, 3, 4],
    .unwrap();
        "merge-incompatible-list-child",
}
        "merge-list-max-desc",
    let mut writer = ArrowWriter::try_new(file, schema, None).unwrap();
            *id > prev_id,
        &[a, b],
            Some(vec!["beta", "zz"]),
        ]
            (
/// Read back `(id, tags)` pairs when all LIST child values are non-null.
/// and data columns are read through two independent parquet readers kept in lockstep by batch
        index,
        vec![
                .map(|values| values.iter().map(|value| Some(*value)).collect())
    write_list_file(
        &[],
    write_list_file(&b, &ids_b, &as_refs(&owned_b));
    write_list_file(&a, &[10], &[Some(vec!["a", "z"])]);
fn scalar_schema() -> Arc<Schema> {
    // MAX asc: n(20) < z(10) => [20, 10]
        &ascending,
        0,
    let ids_b: Vec<i64> = (0..20).map(|i| i * 2 + 2).collect();
        &[],
            .remove(id)
}
    .unwrap();
 * compatible open source license.
        &out,
        Arc::new(Field::new("element", DataType::Utf8, true)),
    let tmp = tempdir().unwrap();
    );
// MIN ascending  => A before B.  MAX ascending => B before A.
    )
        .unwrap()
        expected.is_empty(),
    let a = tmp.path().join("a.parquet").to_string_lossy().to_string();
            ids[2..].contains(&expected),
    let pairs = read_pairs(&out);
    write_list_file(&b, &[4, 5], &[Some(vec![]), Some(vec!["x", "y"])]);
        &out,
    )
    let mut offsets: Vec<i32> = vec![0];
    )
        &["tags".to_string()],
            Arc::new(list) as ArrayRef,
    assert_eq!(pairs[1], (2, v(&["two", "ii", "2"])));
        &[false],
            _ => Some(vec![format!("b{id}")]),
    assert!(
    let mut validity: Vec<bool> = Vec::new();
    write_list_file(
    merge_sorted(
        Arc::new(Field::new("element", DataType::Int32, true)),
        &[false], // ascending
 * The OpenSearch Contributors require contributions made to
use parquet::arrow::arrow_reader::ParquetRecordBatchReaderBuilder;
    let schema = list_schema();
        &[30, 10, 50],
        ],
            ),
    )
    assert!(descending_ids[4..].contains(&60));
    }
    .unwrap();
        .map(|(id, _)| id)
    writer.write(&batch).unwrap();
#[test]
    let mut out = Vec::new();
            (
fn sorted_merge_list_across_batches_in_deferred_mode() {
        &[false],
            "missing null-key row {}",
    let mut writer = ArrowWriter::try_new(File::create(&list).unwrap(), schema, None).unwrap();
    assert_eq!(pairs[0], (1, v(&["beta", "alpha", "beta"])));
        read_nullable_pairs(&out),
        .collect()
                tags.map(|values| {
        })
    let a = tmp.path().join("a.parquet").to_string_lossy().to_string();
    use opensearch_parquet_format::writer::SETTINGS_STORE;
            Some(vec![]),
        .unwrap();
        &[false],
            DataType::List(Arc::new(Field::new("element", DataType::Utf8, true))),
        .path()
        );
    );
#[test]
}
    }
    assert_eq!(ids, vec![20, 10]);
        &input,
fn sorted_merge_uses_minimum_list_element_as_sort_key() {
        &a,
        &[
        &[40, 20, 5],
            )
        &["id".to_string()],
#[test]
            Some(vec![None, None]), // all-null elements
        .to_string_lossy()
        &out,
        .to_string_lossy()
    let schema = scalar_schema();
    write_list_file(
        vec![
        &[],
    write_list_file(&b, &[20], &[Some(vec!["m", "n"])]);
//! A LIST column breaks the "one leaf value per row" identity every flat column satisfies, so the
    writer.close().unwrap();
#[test]
    let scalar = tmp
    let b = tmp.path().join("b.parquet").to_string_lossy().to_string();
fn read_pairs(path: &str) -> Vec<(i64, Option<Vec<String>>)> {
                        .map(|value| value.map(ToString::to_string)),
    assert_eq!(pairs.len(), 40, "all rows must survive the merge");
        &[false], // MIN reduction
    let a = tmp.path().join("a.parquet").to_string_lossy().to_string();
    let a = tmp.path().join("a.parquet").to_string_lossy().to_string();
    let nullable_rows = rows
            0 => Some(vec![format!("b{id}"), format!("b{id}x")]),
    write_list_file(
        .join("descending.parquet")
            };
    assert_eq!(ids.len(), rows.len());
            .as_primitive::<arrow::datatypes::Int64Type>();
    let ascending_ids: Vec<i64> = read_pairs(&ascending)
    for (id, tags) in &pairs {
    write_nullable_list_file(path, ids, &nullable_rows);
/// Two settings make this the adversarial case for a repeated column:
                )
        .to_string_lossy()
        &[
        .path()
        &[b, a],
}
                    values
        prev_id = *id;
        .join("descending_a.parquet")
    let reader = ParquetRecordBatchReaderBuilder::try_new(File::open(path).unwrap())
        .build()
    rows.iter()
        .to_string();
        &[
    // misattached value fails loudly with the offending id.
    let descending_b = tmp
fn v(items: &[&str]) -> Option<Vec<String>> {
        &out,
        values,
        .path()
            Some(vec!["three", "iii"]),
}
        &[20, 40, 60],
        Some(arrow::buffer::NullBuffer::from(validity)),
        &[
        ),
    let tmp = tempdir().unwrap();
        "merge-list-multi-column",
        .to_string();
    assert_eq!(pairs.len(), 6);
    )
        &[false],
fn read_nullable_pairs(path: &str) -> Vec<(i64, Option<Vec<Option<String>>>)> {
                id,
    let batch = RecordBatch::try_new(
        &b,
    .unwrap();
        vec![40, 30, 10, 50, 20, 5]
            "row id={id} changed null/empty state or lost values in the merge"
        })
        &[a, b],
    let out = tmp
use arrow::datatypes::{DataType, Field, Schema};
        0,
        "rows missing from output: {:?}",
            (2, Some(vec![])),
        &[a, b],
    assert_eq!(ids.len(), 5);
        &["tags".to_string()],
            } else {
        arrow::buffer::OffsetBuffer::new(offsets.into()),
fn write_nullable_list_file(path: &str, ids: &[i64], rows: &[Option<Vec<Option<&str>>>]) {
        .to_string();
        }
    merge_sorted(
    assert_eq!(pairs[0], (40, v(&["alpha", "zz"])));
#[test]
    merge_sorted(
            true,
        &[
        .map(|row| {
/// Build a file where row i has `id = ids[i]` and `tags = rows[i]` (None ⇒ null list).
}
        .to_string_lossy()
/// Schema: `id` (sort key, Int64) + `tags` (List<Utf8>) + `__row_id__`.
    );
    for (id, tags) in ids_b.iter().zip(owned_b.iter()) {
    }
        &b,
    );
    // confusion in the LIST column would surface as values attached to the wrong id.
    let out = tmp.path().join("out.parquet").to_string_lossy().to_string();
    merge_sorted(
    .unwrap();
            Arc::new(Int64Array::from(ids.to_vec())) as ArrayRef,
        .enumerate()
    let error = match merge_unsorted(
        &["tags".to_string()],
            Arc::new(lists) as ArrayRef,
        std::collections::HashMap::new();
/// Null / empty / all-null LIST rows sort as null keys (nulls-last) under MAX.
        .path()
    writer.write(&batch).unwrap();
            Arc::new(Int64Array::from((0..ids.len() as i64).collect::<Vec<_>>())) as ArrayRef,
            ..Default::default()
        &a,
    ) {
        &descending_b,
}
                    row_values
        Arc::clone(&schema),
        &[b, a],
                    (0..strings.len())
        Field::new("id", DataType::Int64, false),
        ],
    // Pre-sorted by MAX element descending: A(MAX=z) then B(MAX=n).
 *
        .map(|(id, tags)| {
    let tmp = tempdir().unwrap();
            2 => Some(vec![format!("a{id}")]),
}
    )
// Each input file is pre-sorted by the *reduced* key for the mode under test
        .path()
    let b = tmp.path().join("b.parquet").to_string_lossy().to_string();
//! Merge coverage for multi-valued (Arrow LIST / parquet repeated) columns.
            expected
            Some(vec!["one"]),
        .enumerate()
        .map(|(id, _)| id)
/*
    );
            Some(vec!["alpha", "zz"]),
#[test]
        Field::new("__row_id__", DataType::Int64, false),
        .to_string();
        &[1, 2, 3, 4, 5],
 */
    let out = tmp.path().join("out.parquet").to_string_lossy().to_string();
///
        Err(error) => error,
            DataType::List(Arc::new(Field::new("element", DataType::Int32, true))),
        ],
                        })
        .to_string_lossy()
}
        .join("merged.parquet")
            _ => Some(vec![format!("a{id}"), format!("a{id}b"), format!("a{id}c")]),
        None,
            .as_any()
        &["tags".to_string()],
        Field::new(
    ]));
    // Interleaving sort keys force the k-way merge to alternate between cursors, so a row-vs-value
    let file = File::create(path).unwrap();
        &[true], // MAX reduction
        .join("merged.parquet")
}
    merge_sorted(
        ],
/// Explicit MAX mode, ascending: rows order by the per-row MAX element.
        .iter()
    assert_eq!(&descending_ids[..4], &[40, 30, 20, 10]);
    merge_unsorted(&[input], &out, "merge-list-null-children", 0, &[]).unwrap();
    let out = tmp.path().join("out.parquet").to_string_lossy().to_string();
    assert_eq!(pairs[3].0, 4);
        .to_string_lossy()
            "tags",
        &[Some(vec!["two", "ii", "2"]), None, Some(vec!["six"])],
            .unwrap_or_else(|| panic!("unexpected id {id}"));
        &["tags".to_string()],
            .column(batch.schema().index_of("id").unwrap())
        &[],
    write_nullable_list_file(
        &[true],  // MAX reduction
        ],
        &[a, b],
}
    merge_sorted(
    assert_eq!(pairs[5], (6, v(&["six"])));
}
        ],
    let b = tmp.path().join("b.parquet").to_string_lossy().to_string();
    read_nullable_pairs(path)
    )
//   row A tags=["a","z"] -> MIN="a", MAX="z"
        .join("input.parquet")
        .into_iter()
        "merge-list-min-descending",
    let out = tmp.path().join("out.parquet").to_string_lossy().to_string();
            .expect("tags must decode as a ListArray");
    let pairs = read_pairs(&out);
                validity.push(true);
    let list = tmp
    let mut writer = ArrowWriter::try_new(file, schema, None).unwrap();
        assert_eq!(
    let ids: Vec<i64> = read_nullable_pairs(&out)
    let b = tmp.path().join("b.parquet").to_string_lossy().to_string();
fn sorted_merge_list_explicit_max_ascending() {
fn sorted_merge_list_explicit_max_descending() {
        ],
        &[true], // descending
    );
    write_list_file(
        Field::new("id", DataType::Int64, false),
        0,
        );
        .map(|(id, _)| id)
                let values = lists.value(row);
        "merge-list-min-ascending",
            (1, None),
//!
    assert_eq!(pairs[3].1, Some(vec![]), "empty list must stay empty");
        .to_string();
use std::fs::File;
        "merge-list-min-asc-explicit",
        &[true],
//! merge path needs its own coverage: the k-way merge slices batches by row, appends a fresh
    let offsets = arrow::buffer::OffsetBuffer::new(vec![0_i32, 2].into());
        .to_string_lossy()
        &[descending_a, descending_b],
    write_nullable_list_file(
    .unwrap();
                                None
    let input = tmp
    let a = tmp.path().join("a.parquet").to_string_lossy().to_string();
    assert!(ascending_ids[4..].contains(&60));
    let b = tmp.path().join("b.parquet").to_string_lossy().to_string();
        &[40, 20, 50],
    let message = error.to_string();
    .unwrap();
            "tags",
    );
    // different so the merge cannot accidentally use the first element or lexicographic LIST order.
            None => validity.push(false),
        &out,
        "merge-list-min-desc",
    let mut values: Vec<Option<String>> = Vec::new();
        .join("scalar.parquet")
use opensearch_parquet_format::merge::{merge_sorted, merge_unsorted};
/// Borrow an owned rows-of-strings structure as the `&str` shape `write_list_file` takes.
            Some(vec!["gamma"]),
    )
        .to_string_lossy()
    write_scalar_file(&scalar, &[1], &[Some("prod")]);
    );
    let out = tmp
            Arc::new(Int64Array::from((0..ids.len() as i64).collect::<Vec<_>>())) as ArrayRef,
        offsets,
    let file = File::create(path).unwrap();
    let tmp = tempdir().unwrap();
        .path()
                Some(
        &[false],
                            if strings.is_null(index) {
        .collect::<Vec<_>>();
    assert!(ascending_ids[4..].contains(&50));
    let descending = tmp
    // value count is unrelated to the row count in every batch.
#[test]
    assert_eq!(&ascending_ids[..4], &[10, 20, 30, 40]);
        .to_string_lossy()
            .downcast_ref::<ListArray>()
fn sorted_merge_list_max_null_empty_allnull_rows() {
        .to_string_lossy()
    write_list_file(&a, &[10], &[Some(vec!["a", "z"])]);
        .path()
    write_list_file(&b, &[20], &[Some(vec!["m", "n"])]);
    )
/// `merge_deferred_column_threshold = 0` which forces the cursor's *deferred* mode — sort columns
//! repeated column's values grouped with their original row.
/// Build a LIST file with non-null child values.
    let tmp = tempdir().unwrap();
        message.contains("tags") || message.contains("Failed to compute union schema"),
// so the MIN and MAX reductions order them differently:
        .into_iter()
    let out = tmp
        .collect();
        &["tags".to_string()],
use std::sync::Arc;
        schema.clone(),
                    Some("alpha".to_string()),
    let list = ListArray::new(
    assert_eq!(
    for expected in [3, 4, 5] {
/// index. If a LIST column's leaf desynchronised from the sort reader, the two would drift.
        .join("merged.parquet")
        &a,
/// DESC direction with explicit MIN mode: reduce by MIN, order descending.
}
        .collect();
use parquet::arrow::ArrowWriter;
        .to_string();
    assert_eq!(pairs[1], (30, v(&["z", "alpha"])));
    let b = tmp.path().join("b.parquet").to_string_lossy().to_string();
    let ids: Vec<i64> = read_pairs(&out).into_iter().map(|(id, _)| id).collect();
    assert_eq!(pairs[2], (3, v(&["three", "iii"])));
        .to_string();
    // Varying list lengths, a duplicate, an empty list, and a null list.
        Field::new("__row_id__", DataType::Int64, false),
        Field::new(
        .collect();
    assert_eq!(pairs[4], (5, v(&["x", "y"])));
    write_list_file(&a, &[10], &[Some(vec!["a", "z"])]);
        &[],
}
        .join("descending_b.parquet")
        .to_string();
            Some(vec![Some("alpha"), None, Some("beta")]),
    // Non-null keys first in MAX-asc order, then the three null-key rows (any order).
    )
    write_list_file(&b, &[20], &[Some(vec!["m", "n"])]);
        &[Some(vec!["z", "alpha"]), Some(vec!["delta"]), None],
        &[false], // nulls last
    );
    );
            Some(vec![Some("a"), Some("c")]),
    let owned_b: Vec<Option<Vec<String>>> = ids_b
        let lists = batch
        .map(|(i, id)| match i % 4 {
fn list_schema() -> Arc<Schema> {
        &[a],
    write_list_file(
        0,
    let ids: Vec<i64> = read_pairs(&out).into_iter().map(|(id, _)| id).collect();
fn write_list_file(path: &str, ids: &[i64], rows: &[Option<Vec<&str>>]) {
        let want = expected
        .iter()
    let tmp = tempdir().unwrap();
                None
/// Read back `(id, tags)` pairs in file order.
    let a = tmp.path().join("a.parquet").to_string_lossy().to_string();
        vec![
    write_list_file(&a, &[10], &[Some(vec!["a", "z"])]);
        .into_iter()
        &descending,
    );
    // Single file, already ordered by MAX ascending with nulls last:
        .iter()
            0 => None,
    let ids: Vec<i64> = read_pairs(&out).into_iter().map(|(id, _)| id).collect();
    let pairs = read_pairs(&out);
        },
        );
                ]),
        ],
    // Pre-sorted by MAX element ascending: B(MAX=n) then A(MAX=z).
    // Each input is already ordered by its per-row minimum. Source list order is deliberately
    let tmp = tempdir().unwrap();
            true,
                        .into_iter()
        .to_string();
        .join("merged.parquet")
    out
            Some(vec!["five"]),
            (4, Some(vec![None])),
            Some(vec!["beta", "alpha", "beta"]),
    let b = tmp.path().join("b.parquet").to_string_lossy().to_string();
            .column(batch.schema().index_of("tags").unwrap())
        "merge-list-sorted",
        0,
        &[false, false],
        &out,
        &[],
    assert_eq!(pairs[0], (1, v(&["one"])));
        &[Some(vec!["delta"]), Some(vec!["z", "alpha"]), Some(vec![])],
/// DESC direction with explicit MAX mode: reduce by MAX, order descending.
    let tmp = tempdir().unwrap();
            None,
        &[false],
        &[1, 3, 5],
        &[],
fn sorted_merge_keeps_list_values_with_their_row() {
                        .collect()
    // 40 rows total, interleaved odd/even ids, with per-row list lengths that vary 0..3 so the
#[test]
            Some(vec![]),           // empty list
            Arc::new(Int64Array::from(vec![2])) as ArrayRef,
    // MIN desc: m(20) > a(10) => [20, 10]
    // Rebuild the expected (id → tags) mapping and check every row independently, so a single
            Some(row_values) => {
    );
    let a = tmp.path().join("a.parquet").to_string_lossy().to_string();
        Field::new("tags", DataType::Utf8, true),
#[test]
        &[],
        let ids = batch
        &["tags".to_string(), "id".to_string()],
// (the writer's eager sort produces such chunks in production). Rows are chosen
fn unsorted_merge_preserves_list_values() {
        &[false],
        ),
    write_list_file(
    let tmp = tempdir().unwrap();
        .join("merged.parquet")
/// crosses batch boundaries mid-file, exercising `advance`/`load_next_batch` and `take_slice`), and
    Arc::new(Schema::new(vec![
            None,
/// Multi-batch cursors + deferred column decode.
                Some(vec![
        &[false],
    let a = tmp.path().join("a.parquet").to_string_lossy().to_string();
        &b,
}
    );
        &out,
        &[
    let index = "merge-list-deferred";
            1 => Some(vec![]),
        .path()
    writer.write(&batch).unwrap();
fn unsorted_merge_preserves_null_empty_and_null_children_exactly() {
            Some(vec![]),
    .unwrap();
    assert_eq!(
    let out = tmp
    assert_eq!(pairs[3], (4, None), "null list must stay null");
            Some(vec!["beta"]),
                let strings = values.as_any().downcast_ref::<StringArray>().unwrap();
    let descending_ids: Vec<i64> = read_pairs(&descending)
    ]))
    let out = tmp
    let tmp = tempdir().unwrap();
        .to_string();
    let mut prev_id = i64::MIN;
}
    let schema = Arc::new(Schema::new(vec![
                        .map(|index| {
        .into_iter()
        &[a, b],
            merge_deferred_column_threshold: Some(0),
    .unwrap();
            let tags = if lists.is_null(row) {
        Arc::new(StringArray::from(values)),
        .map(|(i, id)| match i % 3 {
    );
    let batch = RecordBatch::try_new(
    // Pre-sorted by MIN element ascending: A(MIN=a) then B(MIN=m).
    // MAX desc: z(10) > n(20) => [10, 20]
        &[2, 4, 6],
                                Some(strings.value(index).to_string())
        offsets.push(values.len() as i32);
    assert_eq!(&ids[..2], &[1, 2]);
    use opensearch_parquet_format::native_settings::NativeSettings;
    let mut expected: std::collections::HashMap<i64, Option<Vec<String>>> =
        &[30, 10, 60],
        &[false], // explicit MIN reduction (overrides direction default of MAX)
                            } else {
    )
    assert_eq!(pairs[4], (5, v(&["five"])));
    assert_eq!(ids, vec![20, 10]);
        &["tags".to_string()],
    writer.close().unwrap();
        "merge-list-max-asc",
fn sorted_merge_uses_scalar_tiebreaker_after_list_minimum() {
                }),
    ]))
    let pairs = read_pairs(&out);
        &[],
        .to_string();
    merge_unsorted(&[a, b], &out, "merge-list-unsorted", 0, &[]).unwrap();
            tags, &want,
                        .map(|value| value.expect("unexpected null LIST child"))
        &[],
    let owned_a: Vec<Option<Vec<String>>> = ids_a
    );
#[test]
    //   id=1 MAX="c"; id=2 MAX="y"; then the three null-key rows.
            row.as_ref()
            Arc::new(Int64Array::from(vec![0])) as ArrayRef,
        0,
/// Explicit MIN mode, ascending: rows order by the per-row MIN element.
    Arc::new(Schema::new(vec![
        Field::new("__row_id__", DataType::Int64, false),
    let lists = ListArray::new(
    }
    );
        &[false],
            Some(vec!["z", "alpha"]),
    assert_eq!(pairs.len(), 5, "row count must be preserved");
            Some(vec![Some("y"), Some("x")]),
        &[],
        .collect();
    )
            None,                   // null list
        ],
        &[],
            "output must be sorted by id, saw {id} after {prev_id}"
        &[false],
        .join("ascending.parquet")
    };
        Ok(_) => panic!("Utf8 must not promote to List<Int32>"),
    let out = tmp
            merge_batch_size: Some(4),
    let b = tmp.path().join("b.parquet").to_string_lossy().to_string();
    }
    .unwrap();
}
        Field::new("id", DataType::Int64, false),
    Some(items.iter().map(|s| (*s).to_string()).collect())
                        .iter()
        })
        &[],
//   row B tags=["m","n"] -> MIN="m", MAX="n"
        })
        "unexpected error: {message}"
    assert_eq!(pairs[4], (20, v(&["m", "beta"])));
    // Each input is sorted by MIN(tags) ASC and then id DESC.
        vec![
                    None,
    let tmp = tempdir().unwrap();
        &[true], // MAX reduction
