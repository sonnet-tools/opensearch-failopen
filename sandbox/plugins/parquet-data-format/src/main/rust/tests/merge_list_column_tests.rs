    let pairs = read_pairs(&out);
        &[a, b],
    merge_sorted(
    let ids: Vec<i64> = read_nullable_pairs(&out)
    let schema = Arc::new(Schema::new(vec![
    )
    let ids_a: Vec<i64> = (0..20).map(|i| i * 2 + 1).collect();
    );
        .to_string();
//
    let reader = ParquetRecordBatchReaderBuilder::try_new(File::open(path).unwrap())
        &[false, false],
            Arc::new(lists) as ArrayRef,
        .collect();
            };
        0,
    write_list_file(
        &[],
        assert!(
        let ids = batch
    assert_eq!(pairs[3].1, Some(vec![]), "empty list must stay empty");
            "tags",
        &[],
        0,
            1 => None,
            None,
    let ascending_ids: Vec<i64> = read_pairs(&ascending)
    let a = tmp.path().join("a.parquet").to_string_lossy().to_string();
        .join("scalar.parquet")
        Field::new("__row_id__", DataType::Int64, false),
        &[1, 2, 3, 4],
    ]));
    let tmp = tempdir().unwrap();
        Field::new("__row_id__", DataType::Int64, false),
    );
    write_list_file(&b, &[20], &[Some(vec!["m", "n"])]);
        "unexpected error: {message}"
        },
            merge_batch_size: Some(4),
#[test]
fn sorted_merge_list_explicit_max_descending() {
        ],
            expected
        &[],
}
    assert_eq!(pairs[5], (6, v(&["six"])));
            row.as_ref()
fn sorted_merge_uses_scalar_tiebreaker_after_list_minimum() {
/*
    assert_eq!(pairs[0], (1, v(&["beta", "alpha", "beta"])));
    let schema = scalar_schema();
    let a = tmp.path().join("a.parquet").to_string_lossy().to_string();
//! merge path needs its own coverage: the k-way merge slices batches by row, appends a fresh
        &[false],
        Field::new(
        let batch = batch.unwrap();
        .path()
        &[b, a],
        &descending,
        index,
    let file = File::create(path).unwrap();
/// Two settings make this the adversarial case for a repeated column:
        &[false],
    assert!(ascending_ids[4..].contains(&60));
            Some(vec!["three", "iii"]),
        &descending_b,
    )
        &a,
#[test]
        .map(|(id, _)| id)
        &[true],
            }
        &["tags".to_string(), "id".to_string()],
        &[false],
    assert_eq!(pairs[4], (5, v(&["five"])));
    write_list_file(&a, &ids_a, &as_refs(&owned_a));
        "merge-list-min-asc-explicit",
    ]))
        .join("descending.parquet")
    let values = Arc::new(Int32Array::from(vec![1, 2])) as ArrayRef;
        &[false],
        Some(arrow::buffer::NullBuffer::from(validity)),
    writer.close().unwrap();
            Some(vec![Some("alpha"), None, Some("beta")]),
    assert_eq!(&ascending_ids[..4], &[10, 20, 30, 40]);
        0,
        &input,
        ],
// ─────────────────────────────────────────────────────────────────────────
        Field::new("id", DataType::Int64, false),
            Arc::new(Int64Array::from(vec![2])) as ArrayRef,
            out.push((ids.value(row), tags));
        &[10, 30, 50],
    let mut writer = ArrowWriter::try_new(file, schema, None).unwrap();
        &a,
    let pairs = read_pairs(&out);
fn sorted_merge_keeps_list_values_with_their_row() {
        &["tags".to_string()],
        .to_string_lossy()
        .collect::<Vec<_>>();
            let tags = if lists.is_null(row) {
    // Non-null keys first in MAX-asc order, then the three null-key rows (any order).
        .map(|(i, id)| match i % 4 {
            Arc::new(Int64Array::from(ids.to_vec())) as ArrayRef,
//! repeated column's values grouped with their original row.
    let nullable_rows = rows
        &[a, b],
                        .iter()
        .to_string();
//!
    );
        .iter()
#[test]
    // Pre-sorted by MIN element ascending: A(MIN=a) then B(MIN=m).
        &[Some(vec!["delta"]), Some(vec!["z", "alpha"]), Some(vec![])],
    )
use parquet::arrow::arrow_reader::ParquetRecordBatchReaderBuilder;
    let tmp = tempdir().unwrap();
        0,
    assert!(descending_ids[4..].contains(&50));
            0 => Some(vec![format!("b{id}"), format!("b{id}x")]),
        &out,
fn sorted_merge_list_explicit_min_ascending() {
 * SPDX-License-Identifier: Apache-2.0
                id,
    let schema = list_schema();
        .into_iter()
    let out = tmp.path().join("out.parquet").to_string_lossy().to_string();
        &[false],
    let a = tmp.path().join("a.parquet").to_string_lossy().to_string();
        &out,
        &out,
        &[],
        &["tags".to_string()],
        .to_string_lossy()
    let descending = tmp
        &["id".to_string()],
/// Multi-batch cursors + deferred column decode.
    assert_eq!(pairs[1], (30, v(&["z", "alpha"])));
            (
/// and data columns are read through two independent parquet readers kept in lockstep by batch
    let b = tmp.path().join("b.parquet").to_string_lossy().to_string();
        &[a, b],
    merge_unsorted(&[input], &out, "merge-list-null-children", 0, &[]).unwrap();
//! A LIST column breaks the "one leaf value per row" identity every flat column satisfies, so the
    writer.close().unwrap();
        .map(|(id, _)| id)
    );
    let index = "merge-list-deferred";
        index.to_string(),
        &a,
        &["tags".to_string()],
///
    // Single file, already ordered by MAX ascending with nulls last:
    let mut values: Vec<Option<String>> = Vec::new();
                None
                .map(|values| values.iter().map(|value| Some(*value)).collect())
fn read_pairs(path: &str) -> Vec<(i64, Option<Vec<String>>)> {
        &out,
        Arc::new(Field::new("element", DataType::Utf8, true)),
        &[],
        .path()
}
#[test]
        &[20, 40, 60],
    )
    out
    assert_eq!(pairs[1], (2, None), "null list must stay null");
    }
    write_scalar_file(&scalar, &[1], &[Some("prod")]);
            Some(vec!["alpha", "zz"]),
    );
    let mut expected: std::collections::HashMap<i64, Option<Vec<String>>> =
    assert_eq!(pairs[1], (2, v(&["two", "ii", "2"])));
    // Each input is already ordered by its per-row minimum. Source list order is deliberately
        &[false],
        &out,
    let out = tmp.path().join("out.parquet").to_string_lossy().to_string();
        })
    let tmp = tempdir().unwrap();
    merge_unsorted(&[a, b], &out, "merge-list-unsorted", 0, &[]).unwrap();
        .path()
}
}
            "row id={id} changed null/empty state or lost values in the merge"
            Some(vec!["beta", "zz"]),
    )
            1 => Some(vec![]),
    );
    assert_eq!(&descending_ids[..4], &[40, 30, 20, 10]);
fn write_list_file(path: &str, ids: &[i64], rows: &[Option<Vec<&str>>]) {
                        })
        expected.insert(*id, tags.clone());
        .into_iter()
                    row_values
                let values = lists.value(row);
        &["tags".to_string()],
            .remove(id)
        &ascending,
                        .into_iter()
#[test]
            merge_deferred_column_threshold: Some(0),
/// `merge_batch_size` small enough that each cursor spans several batches (so the k-way merge
        &[false], // explicit MIN reduction (overrides direction default of MAX)
    let tmp = tempdir().unwrap();
    let tmp = tempdir().unwrap();
    let owned_a: Vec<Option<Vec<String>>> = ids_a
        "merge-list-max-desc",
    assert_eq!(pairs[0], (1, v(&["one"])));
        "merge-list-min-descending",
        "merge-list-min-ascending",
        .join("list.parquet")
        .iter()
        &[a, b],
// (the writer's eager sort produces such chunks in production). Rows are chosen
}
}
    let mut writer = ArrowWriter::try_new(file, schema, None).unwrap();
            Some(vec!["m", "beta"]),
    let out = tmp
            None,
    write_nullable_list_file(
        .path()
            _ => Some(vec![format!("b{id}")]),
    merge_sorted(
    let out = tmp
        .path()
    let out = tmp.path().join("out.parquet").to_string_lossy().to_string();
        .to_string_lossy()
        &b,
        ),
/// Null / empty / all-null LIST rows sort as null keys (nulls-last) under MAX.
    let list = tmp
        ],
        &[false],
 * compatible open source license.
use tempfile::tempdir;
    );
        &[],
    let batch = RecordBatch::try_new(
    assert_eq!(pairs[3].0, 4);
        "merge-list-sorted",
            )
/// `merge_deferred_column_threshold = 0` which forces the cursor's *deferred* mode — sort columns
    )
        &[false], // ascending
    use opensearch_parquet_format::writer::SETTINGS_STORE;
        &[false], // nulls last
    assert_eq!(pairs[3], (4, None), "null list must stay null");
    // Rebuild the expected (id → tags) mapping and check every row independently, so a single
                )
            (2, Some(vec![])),
    }
    )
fn sorted_merge_list_explicit_max_ascending() {
            Arc::new(list) as ArrayRef,
    assert_eq!(pairs[2], (3, v(&["solo"])));
/// Schema: `id` (sort key, Int64) + `tags` (List<Utf8>) + `__row_id__`.
    );
        .map(|row| {
    );
    write_list_file(
    let b = tmp.path().join("b.parquet").to_string_lossy().to_string();
    merge_sorted(
            Some(vec!["five"]),
/// Read back `(id, tags)` pairs in file order.
/// Build a file where row i has `id = ids[i]` and `tags = rows[i]` (None ⇒ null list).
    );
        .join("merged.parquet")
            DataType::List(Arc::new(Field::new("element", DataType::Int32, true))),
}
    let file = File::create(path).unwrap();
            Some(vec![None, None]), // all-null elements
        .to_string();
    )
    use opensearch_parquet_format::native_settings::NativeSettings;
    for (id, tags) in ids_b.iter().zip(owned_b.iter()) {
        .path()
        ],
        &[
    assert_eq!(ids.len(), rows.len());
        "merge-list-max-asc",
    let descending_a = tmp
        .map(|(id, _)| id)
        for row in 0..batch.num_rows() {
    assert_eq!(&ids[..2], &[1, 2]);
fn read_nullable_pairs(path: &str) -> Vec<(i64, Option<Vec<Option<String>>>)> {
        &[false],
            Some(vec![]),
    let batch = RecordBatch::try_new(
            Arc::new(Int64Array::from((0..ids.len() as i64).collect::<Vec<_>>())) as ArrayRef,
        "merge-list-multi-column",
    merge_sorted(
fn sorted_merge_list_explicit_min_descending() {
        &[false], // MIN reduction
    let message = error.to_string();
    let b = tmp.path().join("b.parquet").to_string_lossy().to_string();
    .unwrap();
                    Some("alpha".to_string()),
        &[Some(vec!["z", "alpha"]), Some(vec!["delta"]), None],
    let ascending = tmp
        &[40, 20, 50],
/// index. If a LIST column's leaf desynchronised from the sort reader, the two would drift.
                    (0..strings.len())
        .to_string_lossy()
    write_list_file(
        &[
                Some(
    assert_eq!(pairs.len(), 5, "row count must be preserved");
fn sorted_merge_uses_minimum_list_element_as_sort_key() {
fn sorted_merge_list_across_batches_in_deferred_mode() {
    merge_sorted(
    let lists = ListArray::new(
 * this file be licensed under the Apache-2.0 license or a
    .unwrap();
    let out = tmp
//   row A tags=["a","z"] -> MIN="a", MAX="z"
        &[false],
//! Merge coverage for multi-valued (Arrow LIST / parquet repeated) columns.
            Some(vec![Some("y"), Some("x")]),
        .join("descending_b.parquet")
        0,
            true,
    let b = tmp.path().join("b.parquet").to_string_lossy().to_string();
        &[b, a],
        Field::new(
/// Explicit MAX mode, ascending: rows order by the per-row MAX element.
        ),
        "merge-list-max-nulls",
            None => validity.push(false),
        .join("merged.parquet")
#[test]
    .unwrap();
        .path()
        &[a, b],
    let b = tmp.path().join("b.parquet").to_string_lossy().to_string();
    let error = match merge_unsorted(
            ),
        &[Some(vec!["omega", "gamma"]), Some(vec!["beta", "zz"]), None],
        &[false],
        ]
    let a = tmp.path().join("a.parquet").to_string_lossy().to_string();
        .to_string();
/// Borrow an owned rows-of-strings structure as the `&str` shape `write_list_file` takes.
        std::collections::HashMap::new();
    //   id=1 MAX="c"; id=2 MAX="y"; then the three null-key rows.
fn write_scalar_file(path: &str, ids: &[i64], rows: &[Option<&str>]) {
#[test]
    .unwrap();
    // value count is unrelated to the row count in every batch.
    write_list_file(&a, &[10], &[Some(vec!["a", "z"])]);
use std::fs::File;
}
        &[],
        .to_string();
                        .map(|value| value.expect("unexpected null LIST child"))
                        .map(|value| value.map(ToString::to_string)),
        &[
    // misattached value fails loudly with the offending id.
        Field::new("id", DataType::Int64, false),
        &[],
            *id > prev_id,
    Some(items.iter().map(|s| (*s).to_string()).collect())
    // Varying list lengths, a duplicate, an empty list, and a null list.
fn write_nullable_list_file(path: &str, ids: &[i64], rows: &[Option<Vec<Option<&str>>>]) {
        })
        &[
        &[1, 2, 3],
        &[],
        .to_string();
                validity.push(true);
        .to_string();
        ],
        .to_string_lossy()
        Arc::clone(&schema),
    assert_eq!(
    let out = tmp
    let tmp = tempdir().unwrap();
                3,
    ) {
        .into_iter()
            Some(vec!["alpha"]),
        .map(|(id, tags)| {
        &[false, true],
            (
/// Build a LIST file with non-null child values.
    // Pre-sorted by MAX element ascending: B(MAX=n) then A(MAX=z).
fn scalar_schema() -> Arc<Schema> {
    // MAX asc: n(20) < z(10) => [20, 10]
    let ids: Vec<i64> = read_pairs(&out).into_iter().map(|(id, _)| id).collect();
    assert_eq!(ids, vec![20, 10]);
// index.sort.mode (MIN / MAX) coverage for LIST sort columns.
    let list = ListArray::new(
#[test]
    for row in rows {
            Some(vec!["beta"]),
        &[],
        &["tags".to_string()],
    // Each input is sorted by MIN(tags) ASC and then id DESC.
    let ids: Vec<i64> = read_pairs(&out).into_iter().map(|(id, _)| id).collect();
    let tmp = tempdir().unwrap();
            .as_primitive::<arrow::datatypes::Int64Type>();
        .to_string();
    let descending_b = tmp
    write_list_file(&a, &[10], &[Some(vec!["a", "z"])]);
        .collect();
        &out,
        &[2, 4, 6],
    );
    let tmp = tempdir().unwrap();
    let mut prev_id = i64::MIN;
            .unwrap_or_else(|| panic!("unexpected id {id}"));
        &[1, 2, 3, 4, 5],
    write_list_file(&b, &[20], &[Some(vec!["m", "n"])]);
    assert!(
            None,                   // null list
    let mut writer = ArrowWriter::try_new(File::create(&list).unwrap(), schema, None).unwrap();
    assert_eq!(ids, vec![10, 20]);
    // MAX desc: z(10) > n(20) => [10, 20]
        &[
    assert_eq!(ids, vec![10, 20]);
        .unwrap()
        assert!(
                    None,
        0,
    // Sort order by id, and every row keeps exactly its own values.
        vec![
        .map(|r| r.as_ref().map(|v| v.iter().map(|s| s.as_str()).collect()))
    Arc::new(Schema::new(vec![
    .unwrap();
        let want = expected
        Field::new("id", DataType::Int64, false),
                                None
    let b = tmp.path().join("b.parquet").to_string_lossy().to_string();
        &[],
        &["id".to_string()],
    let ids: Vec<i64> = read_pairs(&out).into_iter().map(|(id, _)| id).collect();
            .column(batch.schema().index_of("tags").unwrap())
}
            ..Default::default()
        .path()
            0 => None,
// ─────────────────────────────────────────────────────────────────────────
    write_list_file(&b, &[20], &[Some(vec!["m", "n"])]);
    )
    let out = tmp
        .to_string();
        .to_string();
    let a = tmp.path().join("a.parquet").to_string_lossy().to_string();
            .as_any()
        Arc::clone(&schema),
        .to_string_lossy()
    }
    // Pre-sorted by MIN element descending: B(MIN=m) then A(MIN=a).
        Ok(_) => panic!("Utf8 must not promote to List<Int32>"),
                            }
    };
    merge_sorted(
        .collect()
        &out,
use parquet::arrow::ArrowWriter;
        None,
 * The OpenSearch Contributors require contributions made to
        expected.is_empty(),
fn unsorted_merge_preserves_list_values() {
}
    .unwrap();
            Some(vec!["beta", "alpha", "beta"]),
        Field::new("tags", DataType::Utf8, true),
    );
use std::sync::Arc;
    write_list_file(
            Some(vec!["solo"]),
#[test]
        .enumerate()
    let ids_b: Vec<i64> = (0..20).map(|i| i * 2 + 2).collect();
    )
        &["tags".to_string()],
        .path()
        &[Some(vec!["two", "ii", "2"]), None, Some(vec!["six"])],
    let mut validity: Vec<bool> = Vec::new();
        .into_iter()
        &[],
        schema.clone(),
        vec![40, 30, 10, 50, 20, 5]
        .to_string();
    }
        offsets,
    assert_eq!(pairs.len(), 40, "all rows must survive the merge");
 *
            } else {
    assert!(ascending_ids[4..].contains(&50));
            Some(vec![]),           // empty list
        &[30, 10, 50],
        prev_id = *id;
/// DESC direction with explicit MIN mode: reduce by MIN, order descending.
    let scalar = tmp
    // MIN asc: a(10) < m(20) => [10, 20]
    );
        );
            2 => Some(vec![format!("a{id}")]),
    )
    for batch in reader {
    let tmp = tempdir().unwrap();
        Err(error) => error,
        .path()
                            } else {
    let tmp = tempdir().unwrap();
        ],
        .join("input.parquet")
    writer.write(&batch).unwrap();
        );
    read_nullable_pairs(path)
    let pairs = read_pairs(&out);
        &[scalar, list],
}
    let offsets = arrow::buffer::OffsetBuffer::new(vec![0_i32, 2].into());
        .path()
        &[false],
        .to_string_lossy()
    let a = tmp.path().join("a.parquet").to_string_lossy().to_string();
    let a = tmp.path().join("a.parquet").to_string_lossy().to_string();
#[test]
/// DESC direction with explicit MAX mode: reduce by MAX, order descending.
        0,
        "merge-incompatible-list-child",
    write_list_file(
    .unwrap();
            Some(vec![]),
    merge_sorted(
            Some(vec!["one"]),
    let tmp = tempdir().unwrap();
}
    }
            Some(row_values) => {
            DataType::List(Arc::new(Field::new("element", DataType::Utf8, true))),
            Arc::new(Int64Array::from((0..ids.len() as i64).collect::<Vec<_>>())) as ArrayRef,
            Some(vec!["gamma"]),
    write_list_file(&a, &[10], &[Some(vec!["a", "z"])]);
        pairs.iter().map(|(id, _)| *id).collect::<Vec<_>>(),
        .to_string_lossy()
/// crosses batch boundaries mid-file, exercising `advance`/`load_next_batch` and `take_slice`), and
                        .collect(),
    assert_eq!(ids, vec![20, 10]);
    .unwrap();
use opensearch_parquet_format::merge::{merge_sorted, merge_unsorted};
        read_nullable_pairs(&out),
    let a = tmp.path().join("a.parquet").to_string_lossy().to_string();
            "output must be sorted by id, saw {id} after {prev_id}"
                        .collect()
    for expected in [3, 4, 5] {
        vec![
    let mut offsets: Vec<i32> = vec![0];
        ],
        &[],
        &out,
    let out = tmp.path().join("out.parquet").to_string_lossy().to_string();
        &[true], // descending
        &[40, 20, 5],
            Arc::new(StringArray::from(rows.to_vec())) as ArrayRef,
                let strings = values.as_any().downcast_ref::<StringArray>().unwrap();
                                Some(strings.value(index).to_string())
    let descending_ids: Vec<i64> = read_pairs(&descending)
        &b,
    // Interleaving sort keys force the k-way merge to alternate between cursors, so a row-vs-value
        &out,
        .join("merged.parquet")
    write_nullable_list_file(path, ids, &nullable_rows);
fn as_refs(rows: &[Option<Vec<String>>]) -> Vec<Option<Vec<&str>>> {
        .path()
#[test]
        "rows missing from output: {:?}",
        .to_string();
        0,
        .map(|(i, id)| match i % 3 {
                Some(vec![
        }
        &[],
        .join("descending_a.parquet")
    Arc::new(Schema::new(vec![
        &a,
        })
    let out = tmp.path().join("out.parquet").to_string_lossy().to_string();
fn v(items: &[&str]) -> Option<Vec<String>> {
    )
        values,
}
        .collect();
        &[true], // descending
        .to_string();
        &[true], // MAX reduction
        .to_string_lossy()
        Arc::new(Field::new("element", DataType::Int32, true)),
        message.contains("tags") || message.contains("Failed to compute union schema"),
        &[],
        &[],
fn merge_rejects_incompatible_scalar_and_list_child_types() {
        &b,
        ],
//   row B tags=["m","n"] -> MIN="m", MAX="n"
    let mut out = Vec::new();
    assert_eq!(ids.len(), rows.len());
        .join("merged.parquet")
        .path()
            Arc::new(Int64Array::from(ids.to_vec())) as ArrayRef,
    write_list_file(
        0,
    .unwrap();
            .column(batch.schema().index_of("id").unwrap())
/// Explicit MIN mode, ascending: rows order by the per-row MIN element.
        arrow::buffer::OffsetBuffer::new(offsets.into()),
        Field::new("__row_id__", DataType::Int64, false),
            Arc::new(Int64Array::from(vec![0])) as ArrayRef,
        assert_eq!(
        .to_string_lossy()
 */
    let a = tmp.path().join("a.parquet").to_string_lossy().to_string();
}
            .downcast_ref::<ListArray>()
    );
        0,
    merge_sorted(
            Some(vec!["z", "alpha"]),
    let b = tmp.path().join("b.parquet").to_string_lossy().to_string();
    );
        Arc::new(StringArray::from(values)),
    .unwrap();
}
fn sorted_merge_list_max_null_empty_allnull_rows() {
        .iter()
    assert!(descending_ids[4..].contains(&60));
    write_list_file(
        ],
    .unwrap();
    // different so the merge cannot accidentally use the first element or lexicographic LIST order.
    .unwrap();
    assert_eq!(pairs[2], (3, v(&["three", "iii"])));
    let batch = RecordBatch::try_new(
    let owned_b: Vec<Option<Vec<String>>> = ids_b
    );
    // Pre-sorted by MAX element descending: A(MAX=z) then B(MAX=n).
    let out = tmp
fn list_schema() -> Arc<Schema> {
    write_list_file(&b, &ids_b, &as_refs(&owned_b));
    assert_eq!(pairs[4], (20, v(&["m", "beta"])));
    for (id, tags) in ids_a.iter().zip(owned_a.iter()) {
            (4, Some(vec![None])),
use arrow::array::*;
                values.extend(
        &[
    write_list_file(
                tags.map(|values| {
        "merge-list-min-desc",
// MIN ascending  => A before B.  MAX ascending => B before A.
    write_list_file(&b, &[20], &[Some(vec!["m", "n"])]);
}
}
        &[true], // MAX reduction
    )
    .unwrap();
    for (id, tags) in &pairs {
            tags, &want,
}
        &[a],
    let input = tmp
                            if strings.is_null(index) {
    assert_eq!(
            (1, None),
                    values
    let b = tmp.path().join("b.parquet").to_string_lossy().to_string();
}
        .build()
            ids[2..].contains(&expected),
            Some(vec!["omega", "gamma"]),
    // confusion in the LIST column would surface as values attached to the wrong id.
    merge_sorted(
        .enumerate()
// so the MIN and MAX reductions order them differently:
    );
            Some(vec![Some("a"), Some("c")]),
fn unsorted_merge_preserves_null_empty_and_null_children_exactly() {
        .collect()
    write_list_file(&b, &[4, 5], &[Some(vec![]), Some(vec!["x", "y"])]);
            true,
        &[false],
        .join("ascending.parquet")
    writer.close().unwrap();
            _ => Some(vec![format!("a{id}"), format!("a{id}b"), format!("a{id}c")]),
                );
    write_list_file(&a, &[10], &[Some(vec!["a", "z"])]);
        offsets.push(values.len() as i32);
        .collect();
        &["tags".to_string()],
        match row {
    let b = tmp.path().join("b.parquet").to_string_lossy().to_string();
            .expect("tags must decode as a ListArray");
    assert_eq!(pairs.len(), 6);
#[test]
/// Read back `(id, tags)` pairs when all LIST child values are non-null.
        .to_string_lossy()
}
        .join("merged.parquet")
        &[
    let pairs = read_pairs(&out);
        .join("merged.parquet")
    let a = tmp.path().join("a.parquet").to_string_lossy().to_string();
                        .map(|index| {
    assert_eq!(ids.len(), 5);
    write_list_file(
    let tmp = tempdir().unwrap();
            "tags",
    SETTINGS_STORE.insert(
    let ids: Vec<i64> = read_pairs(&out).into_iter().map(|(id, _)| id).collect();
        expected.keys()
    writer.write(&batch).unwrap();
        vec![
    );
        let lists = batch
            Some(vec![None]),
        &[descending_a, descending_b],
        .unwrap();
        &[30, 10, 60],
        })
    assert_eq!(pairs[0], (40, v(&["alpha", "zz"])));
        .to_string_lossy()
        &[1, 3, 5],
        .to_string_lossy()
    // 40 rows total, interleaved odd/even ids, with per-row list lengths that vary 0..3 so the
                }),
    assert!(
        &[a, b],
                ]),
    assert_eq!(pairs[4], (5, v(&["x", "y"])));
        &[true],  // MAX reduction
    ]))
        ],
use arrow::datatypes::{DataType, Field, Schema};
    merge_sorted(
    rows.iter()
        &a,
        );
    write_nullable_list_file(
        NativeSettings {
                    Some("beta".to_string()),
        0,
    }
        &descending_a,
    // MIN desc: m(20) > a(10) => [20, 10]
        }
            "missing null-key row {}",
        &[false],
        .collect();
        expected.insert(*id, tags.clone());
        vec![
//! `__row_id__`, and re-encodes each column through `compute_leaves`. All of that must keep a
}
    writer.write(&batch).unwrap();
// Each input file is pre-sorted by the *reduced* key for the mode under test
