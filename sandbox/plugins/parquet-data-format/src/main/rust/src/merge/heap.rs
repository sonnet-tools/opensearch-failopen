    } else {
    Ok(winner)
}
            .value(a)
        let values = Int64Array::from(vec![5i64, 1, 9, 3]);
        }
                let ord = compare_elements(values, index, current, dtype)?;
) -> MergeResult<SortKey> {
            max,
    DurationMillisecondType, DurationNanosecondType, DurationSecondType, Float16Type, Float32Type,
        }
        assert_eq!(reduced_strs(&list, false), vec![Some("alpha".to_string())]);
// HeapItem for k-way merge
}
            } else {
    Array, ArrayRef, AsArray, GenericListArray, OffsetSizeTrait, RecordBatch, UInt64Array,
                            Some(v) => b.values().append_value(*v),
                        Ok(None)
    #[test]
    }
    match dtype {
        values.push(get_sort_value(batch, row, *col_idx, dtype, nf, max)?);
// Sort-direction helpers
    fn test_reduce_utf8_list_min_and_max() {
    #[test]
    Ok(key)
        ArrowDataType::Binary => SortKey::Bytes(col.as_binary::<i32>().value(row).to_vec()),
            max,
    child_type: &ArrowDataType,
    batch: &RecordBatch,
impl PartialOrd for HeapItem {
            vec![Some("cherry".to_string()), Some("x".to_string())]
/// merge sort-value extraction and the per-row list reduction.
        (0..arr.len())
#[cfg(test)]
        }
                None => b.append(false),
        assert_eq!(scalar_key_i64(&min[0]), 42);
    // scalar columns the value at `row` is the sort key regardless of mode.
fn null_sort_key(null_first: bool) -> SortKey {
                    if list.is_null(row) {
            RecordBatch::try_new(schema, vec![Arc::new(Int64Array::from(vec![42i64]))]).unwrap();
    col_indices: &[usize],
    }
            col.as_list::<i64>(),
                };
        let schema = Arc::new(Schema::new(vec![Field::new(
}
            }
// =============================================================================
            None => winner = Some(index),
                        }
}
        offsets[row].as_usize(),
            winning_index(arr, 0, 4, &ArrowDataType::Int64, false).unwrap(),
 * compatible open source license.
                col.as_primitive::<DurationSecondType>().value(row)
        let nf = nulls_first.get(i).copied().unwrap_or(false);
        _ => Ok(array.clone()),
        let arr: &dyn Array = &values;
    values: &dyn Array,
    Ok(ordering)
            reduce_list_array(array.as_list::<i32>(), field.data_type(), max)
        let reduced = reduced_sort_array(array, max).unwrap();
        assert_eq!(scalar_key_i64(&min[0]), 1); // MIN element
                    ord == Ordering::Less
            list_type.clone(),
        let batch = RecordBatch::try_new(schema, vec![list]).unwrap();
    match array.data_type() {
        );
            winning_index(arr, 0, 4, &ArrowDataType::Int64, true).unwrap(),
mod tests {
}
            Some(vec![Some(10), Some(-5)]),
            SortKey::Bytes(col.as_string::<i32>().value(row).as_bytes().to_vec())
                }
        ArrowDataType::Int64 => SortKey::Int(col.as_primitive::<Int64Type>().value(row)),
        ArrowDataType::Timestamp(unit, _) => SortKey::Int(match unit {
                    for e in elems {
        let list = int_list(&[
}
// =============================================================================
        // null_first => NullFirst sentinel; null_last => NullLast sentinel.
            list_type.clone(),
        assert!(matches!(nf[0], SortKey::NullFirst));
            .as_string::<i32>()
            winning_index(arr, 2, 2, &ArrowDataType::Int64, false).unwrap(),
            }
/// Returns the scalar type used as the physical sort key. LIST columns reduce
}
            arrow::datatypes::TimeUnit::Millisecond => {
impl Ord for HeapItem {
use arrow::array::{
            row,
                col.as_primitive::<TimestampMillisecondType>().value(row)
                col.as_primitive::<DurationMicrosecondType>().value(row)
        ArrowDataType::LargeUtf8 => values
impl Eq for SortKey {}
    null_first: bool,
            } else {
        list.values().as_ref(),
/// which preserves their established ordering without heap allocation.
    Ordering::Equal
            arrow::datatypes::TimeUnit::Microsecond => {
                None => b.append(false),
        let mut b = ListBuilder::new(StringBuilder::new());
        }
        Arc::new(b.finish())
            left.cmp(&right)
        ArrowDataType::UInt32 => SortKey::UInt(col.as_primitive::<UInt32Type>().value(row) as u64),
    fn partial_cmp(&self, other: &Self) -> Option<Ordering> {
fn reduce_list_array<O: OffsetSizeTrait>(
        self.cmp(other) == Ordering::Equal
    UInt64Type, UInt8Type,
    max: bool,
                } else {
/// `max == false`, the maximum element when `max == true`. Returns `None` when
    }
                        .map(|i| i as u64))
                    None
    }
    fn test_reduce_null_empty_and_all_null_rows() {
        let arr = reduced.as_primitive::<Int64Type>();
        Some(index) => get_array_sort_value(values, index, dtype, false, false),
}
        ArrowDataType::Int8 => SortKey::Int(col.as_primitive::<Int8Type>().value(row) as i64),
                }
/// Lexicographic comparison of two sort-key tuples, respecting per-column
    // ── get_sort_values: scalar ignores mode; list honors mode ───────────
    if col.is_null(row) {
        None => Ok(null_sort_key(null_first)),
            }
            let indices = (0..list.len())
        let ord = av.cmp(bv);
        if values.is_null(index) {
                ord.reverse()
                }
    let offsets = list.value_offsets();
                }
                    }
/// returned unchanged. The returned array is used only while sorting and is
/// scan. This is the shared winner-selection helper used by both the k-way
        let list = str_list(&[
            }
    // `max` only affects LIST/FixedSizeList reduction (MIN vs MAX element). For
    }
    fn test_reduce_int_list_max() {
            .map(|i| {
    fn reduced_ints(array: &ArrayRef, max: bool) -> Vec<Option<i64>> {
) -> MergeResult<Vec<SortKey>> {
                other
    fn test_reduce_str_list_min_used_by_string_array() {
        );
        }
    // ── winning_index directly ───────────────────────────────────────────
#[inline]
            .collect()
/// to the winning (MIN or MAX, per the resolved sort mode) non-null element;
    }
        ]);
            let reverse = reverse_sorts.get(i).copied().unwrap_or(false);
use arrow::datatypes::{
 */
                    None
                col.as_primitive::<DurationMillisecondType>().value(row)
    row: usize,
    child_type: &ArrowDataType,
    max: bool,
) -> MergeResult<SortKey> {
#[inline(always)]
    #[test]
            (_, SortKey::NullFirst) => Ordering::Greater,
        }
                let replace = if max {
        let list = str_list(&[Some(vec![Some("delta"), Some("alpha"), Some("charlie")])]);
/// when `max == true`). Exactly one `SortKey` is materialized — for the winning
        let list = int_list(&[Some(vec![Some(3), Some(1), Some(8)])]);
    fn cmp(&self, other: &Self) -> Ordering {
    // ── LIST reduction: MIN vs MAX for numeric values ────────────────────
        assert_eq!(
    get_array_sort_value(batch.column(col_idx).as_ref(), row, dtype, null_first, max)
}
        ArrowDataType::FixedSizeList(field, size) => {
                    max,
            Some(vec![None, None]),             // all-null elements => null key
                            start + *size as usize,
    fn test_winning_index_min_max_and_empty() {
    NullLast,
        // Guards against accidental regression to per-element Vec<u8> allocation:
    fn reduced_strs(array: &ArrayRef, max: bool) -> Vec<Option<String>> {
    }
            get_sort_values(&batch, 0, &[0], &[list_type.clone()], &[false], &[false]).unwrap();
    end: usize,
            (SortKey::Float(a), SortKey::Float(b)) => a.total_cmp(b),
        let max = get_sort_values(&batch, 0, &[0], &[list_type], &[false], &[true]).unwrap();
                            Some(v) => b.values().append_value(*v),
    dtype: &ArrowDataType,
        ArrowDataType::Float64 => SortKey::Float(col.as_primitive::<Float64Type>().value(row)),
                    } else {
}
            (SortKey::UInt(a), SortKey::UInt(b)) => a.cmp(b),
    Bool(bool),
            .as_bytes()
#[inline]
                    }
        )]));
    batch: &RecordBatch,
            .value(a)
        }
            })
            (SortKey::NullFirst, SortKey::NullFirst) => Ordering::Equal,
            .cmp(values.as_binary::<i64>().value(b)),
    fn test_get_sort_values_scalar_ignores_mode() {
            let is_null_cmp = matches!(av, SortKey::NullFirst | SortKey::NullLast)
        ArrowDataType::Boolean => SortKey::Bool(col.as_boolean().value(row)),
            .as_binary::<i64>()
                ord
            "tags",
/// Reduces the non-null elements of `values[start..end]` to a single
            )));
pub fn get_sort_value(
        )?,
                        )?
    }
        // Swap other/self so max-heap behaves as min-heap.
    UInt(u64),
        );
    Ok(take(values.as_ref(), &UInt64Array::from(indices), None)?)
                .map(|i| i as u64))
                col.as_primitive::<TimestampNanosecondType>().value(row)
        ArrowDataType::List(field) => get_list_reduced(
    #[test]
                        Ok(winning_index(
            SortKey::Int(v) => *v,
            return Err(MergeError::Logic(format!(
                    ord == Ordering::Greater
        max,
        for row in rows {
    dtype: &ArrowDataType,
            .value(a)
            other => panic!("expected Int key, got {:?}", other),
            let list = array.as_fixed_size_list();
            .cmp(values.as_string::<i64>().value(b).as_bytes()),
            true,
                            field.data_type(),
            .map(|i| {
    let mut winner: Option<usize> = None;
                .map(|row| {
    pub reverse_sorts: Arc<Vec<bool>>,
            reduced_strs(&list, true),
            Some(2)
        let max = max_sort_modes.get(i).copied().unwrap_or(false);
        ArrowDataType::Date32 => SortKey::Int(col.as_primitive::<Date32Type>().value(row) as i64),
    Ok(values)
/// [`SortKey`] using the given reduction `mode` (MIN when `max == false`, MAX
        assert_eq!(
    get_reduced_value(
            .value(a)
                } else {
            _ => Ordering::Equal,
        ArrowDataType::FixedSizeList(field, size) => {
            None
            Some(vec![Some("banana"), Some("apple"), Some("cherry")]),
            let start = row * *size as usize;
// =============================================================================
fn get_list_reduced<O: OffsetSizeTrait>(
        assert_eq!(reduced_strs(&list, true), vec![Some("delta".to_string())]);
            vec![Some("apple".to_string()), Some("m".to_string())]
                // For MIN keep the smaller element, for MAX keep the larger.
        ArrowDataType::Duration(unit) => SortKey::Int(match unit {
    NullFirst,
        )]));
            .as_bytes()
        child_type,
            }
                if arr.is_null(i) {
                null_first,
}
/// Compares two non-null elements without allocating byte buffers for string or
    row: usize,
        match winner {
            null_first,
                    winner = Some(index);
    };
    #[test]
    null_first: bool,
/// never written to Parquet.
#[inline]
        assert_eq!(scalar_key_i64(&max[0]), 42);
        Some(self.cmp(other))
}
                    values.as_ref(),
        | ArrowDataType::FixedSizeList(field, _) => field.data_type().clone(),
    pub file_id: usize,
        ArrowDataType::Int32 => SortKey::Int(col.as_primitive::<Int32Type>().value(row) as i64),
) -> MergeResult<Option<usize>> {
}
                    child_type,
            (SortKey::NullLast, _) => Ordering::Greater,
            let left = get_array_sort_value(values, a, dtype, false, false)?;
                })
            arrow::datatypes::TimeUnit::Second => {
    a: usize,
        ArrowDataType::UInt16 => SortKey::UInt(col.as_primitive::<UInt16Type>().value(row) as u64),
        Arc::new(b.finish())
            field.data_type(),
                    }
            };
                            start,
    fn int_list(rows: &[Option<Vec<Option<i64>>>]) -> ArrayRef {
/// Materializes one temporary scalar reduced key per row for Arrow's
        assert_eq!(scalar_key_i64(&max[0]), 8); // MAX element
        assert_eq!(reduced_ints(&list, true), vec![None, None, None, Some(7)]);
            // Same column always produces the same variant; cross-variant is unreachable.
                col.as_primitive::<TimestampSecondType>().value(row)
            match row {
            get_reduced_value(
            arrow::datatypes::TimeUnit::Millisecond => {
/// MAX element, otherwise MIN). Scalar fields ignore the reduction mode and are
            (SortKey::Int(a), SortKey::Int(b)) => a.cmp(b),
    use arrow::array::{Int64Array, Int64Builder, ListBuilder, RecordBatch, StringBuilder};
    }
/// Comparison happens fully in place via [`compare_elements`] — no `SortKey`
    }
    }
        ArrowDataType::LargeList(field) => get_list_reduced(
        );
                "Unsupported sort column type: {:?}",
    max: bool,
        ArrowDataType::LargeList(field) => {
                            None => b.values().append_null(),
                start + *size as usize,
            .cmp(values.as_string::<i32>().value(b).as_bytes()),
impl Eq for HeapItem {}
    }
    )
            }
                    b.append(true);
    let ordering = match dtype {
                        match e {
            "tags",
) -> MergeResult<SortKey> {
    start: usize,
        let list = int_list(&[None]);
        let min =
                max,
#[derive(Debug)]
    max: bool,
#[inline]
        Some(self.cmp(other))
    fn partial_cmp(&self, other: &Self) -> Option<Ordering> {
            continue;
    /// Builds a `List<Int64>` from rows. `None` row => null list; empty inner
        offsets[row + 1].as_usize(),
// =============================================================================
                if arr.is_null(i) {
        .collect::<MergeResult<Vec<_>>>()?;
            SortKey::Bytes(col.as_string::<i64>().value(row).as_bytes().to_vec())
            "v",
        )]));
            true,
    nulls_first: &[bool],
                    for e in elems {
/// scalar columns keep their own type.
        assert_eq!(
 * The OpenSearch Contributors require contributions made to
                .collect::<MergeResult<Vec<_>>>()?;
        ArrowDataType::UInt8 => SortKey::UInt(col.as_primitive::<UInt8Type>().value(row) as u64),
        // MAX reduction picks the largest element of each row.
/*
                            values.as_ref(),
            }
        // Scalar fields ignore the reduction mode.
    fn eq(&self, other: &Self) -> bool {
            .as_binary::<i32>()
        );
    max: bool,
            }
        ]);
    use super::*;
fn get_array_sort_value(
        ArrowDataType::List(field) => {
/// element for the requested reduction mode: the minimum element when
}
    max_sort_modes: &[bool],
        ArrowDataType::Binary => values
    let offsets = list.value_offsets();
    dtype: &ArrowDataType,
    // ── Null / empty / all-null semantics ────────────────────────────────
    }
            (SortKey::Bool(a), SortKey::Bool(b)) => a.cmp(b),
    fn test_reduce_int_list_min() {
                    offsets[row + 1].as_usize(),
        }
}
#[derive(Debug, Clone)]
            )?
                        let start = row * *size as usize;
            let right = get_array_sort_value(values, b, dtype, false, false)?;
            .as_string::<i64>()
    let mut values = Vec::with_capacity(col_indices.len());
        let arr = reduced.as_string::<i32>();
    fn test_get_sort_values_list_honors_mode() {
use std::sync::Arc;
        ArrowDataType::LargeUtf8 => {
            arrow::datatypes::TimeUnit::Microsecond => {
}
        cmp_sort_values(&other.sort_values, &self.sort_values, &self.reverse_sorts)
}
    Int(i64),
}
                )?
    // ── Helpers ──────────────────────────────────────────────────────────
        ArrowDataType::List(field)
        ArrowDataType::LargeBinary => values
        }
pub(crate) fn reduced_sort_type(dtype: &ArrowDataType) -> ArrowDataType {
/// binary values. Other scalar types reuse the existing `SortKey` conversion,
        _ => {
    TimestampMillisecondType, TimestampNanosecondType, TimestampSecondType, UInt16Type, UInt32Type,
            })
            field.data_type(),
// Sort value extraction
                field.data_type(),
    col_idx: usize,
    if null_first {
impl PartialEq for SortKey {
    }
}
            Some(vec![Some(3), Some(1), Some(2)]),
        let batch = RecordBatch::try_new(schema, vec![list]).unwrap();
                start,
            true,
 * this file be licensed under the Apache-2.0 license or a
impl PartialEq for HeapItem {
                    Some(arr.value(i).to_string())
    fn test_get_sort_values_list_null_row_uses_null_sentinel() {
        match (self, other) {
    }
        return Ok(null_sort_key(null_first));
        SortKey::NullLast
            return if reverse && !is_null_cmp {
        // materializing a single scalar, so pass `false`.
            Some(vec![Some(10), Some(-5)]),
    }
    DataType as ArrowDataType, Date32Type, Date64Type, DurationMicrosecondType,
pub struct HeapItem {
        let list_type = list.data_type().clone();
// =============================================================================
            row,
use std::cmp::Ordering;
        ]);
// =============================================================================
    }
) -> MergeResult<SortKey> {
fn get_reduced_value(
    // ── LIST reduction: MIN vs MAX for Utf8 values ───────────────────────
        let nf = get_sort_values(&batch, 0, &[0], &[list_type.clone()], &[true], &[false]).unwrap();
    }
                        match e {
            SortKey::Float(col.as_primitive::<Float16Type>().value(row).to_f32() as f64)
    #[test]
            arrow::datatypes::TimeUnit::Nanosecond => {
        other => {
        ArrowDataType::Int16 => SortKey::Int(col.as_primitive::<Int16Type>().value(row) as i64),
                col.as_fixed_size_list().values().as_ref(),
/// element — after the allocation-free [`winning_index`] scan. An all-null or
                } else {
    for (i, (av, bv)) in a.iter().zip(b.iter()).enumerate() {
    list: &GenericListArray<O>,
}
    fn str_list(rows: &[Option<Vec<Option<&str>>>]) -> ArrayRef {
                || matches!(bv, SortKey::NullFirst | SortKey::NullLast);
    fn scalar_key_i64(sk: &SortKey) -> i64 {
        }
///
    b: usize,
    Bytes(Vec<u8>),
                        }
        if ord != Ordering::Equal {
    for index in start..end {
        // The winner is a scalar leaf element; `max` is irrelevant when
        ArrowDataType::Utf8 => {
    };
/// every element in the range is null (or the range is empty).
        let batch =
        ArrowDataType::Float16 => {
    }
        ArrowDataType::Utf8 => values
        ArrowDataType::Float32 => {
        assert_eq!(reduced_ints(&list, false), vec![None, None, None, Some(4)]);
    row: usize,
        }
        }
            SortKey::Float(col.as_primitive::<Float32Type>().value(row) as f64)
        // the reducer must still select the correct winner for strings.
            (SortKey::Bytes(a), SortKey::Bytes(b)) => a.cmp(b),
            Some(vec![Some("x"), Some("m")]),
            ArrowDataType::Int64,
            Some(1)
    fn cmp(&self, other: &Self) -> Ordering {
        let schema = Arc::new(Schema::new(vec![Field::new(
        let list = int_list(&[
        null_first,
    let key = match dtype {
                Some(elems) => {
// =============================================================================
    pub sort_values: Vec<SortKey>,
/// RowConverter, using the resolved reduction mode (`max == true` selects the
// =============================================================================
            arrow::datatypes::TimeUnit::Nanosecond => {
                    Some(arr.value(i))
        _ => dtype.clone(),
    }
) -> MergeResult<Ordering> {
/// Scans `values[start..end]` and returns the index of the winning non-null
        }
            null_first,
            (SortKey::NullLast, SortKey::NullLast) => Ordering::Equal,
        ]);
            Some(vec![]),                       // empty list => null key
impl Ord for SortKey {
pub fn get_sort_values(
            reduced_strs(&list, false),
    null_first: bool,
    }
    max: bool,
        }),
) -> MergeResult<ArrayRef> {
            (SortKey::NullFirst, _) => Ordering::Less,
            let values = list.values();
    match winning_index(values, start, end, dtype, max)? {
            reduce_list_array(array.as_list::<i64>(), field.data_type(), max)
pub enum SortKey {
};
/// empty range yields the null sentinel.
            }
        // Empty range yields None regardless of mode.
        let schema = Arc::new(Schema::new(vec![Field::new(
    #[test]
                Some(elems) => {
/// sort direction. Returns `Ordering::Equal` when all values match.
            col.as_list::<i32>(),
            (_, SortKey::NullLast) => Ordering::Less,
    values: &dyn Array,
            Some(current) => {
                col.as_primitive::<DurationNanosecondType>().value(row)
    /// vec => empty (non-null) list; inner `None` => null element.
        let list_type = list.data_type().clone();
use arrow::compute::take;
    dtype: &ArrowDataType,
        ArrowDataType::UInt64 => SortKey::UInt(col.as_primitive::<UInt64Type>().value(row)),
        let mut b = ListBuilder::new(Int64Builder::new());
    values: &dyn Array,
        assert_eq!(
        // MIN reduction picks the smallest element of each row.
        })
            get_sort_values(&batch, 0, &[0], &[ArrowDataType::Int64], &[false], &[true]).unwrap();
 * SPDX-License-Identifier: Apache-2.0
        match sk {
        SortKey::NullFirst
    /// Builds a `List<Utf8>` from rows (same null conventions as `int_list`).
        .map(|row| {
// SortKey — typed sort value with null ordering baked in
        self.sort_values == other.sort_values
        ArrowDataType::LargeBinary => SortKey::Bytes(col.as_binary::<i64>().value(row).to_vec()),
use super::error::{MergeError, MergeResult};
                }
        assert_eq!(reduced_ints(&list, false), vec![Some(1), Some(-5)]);
    col: &dyn Array,
    Float64Type, Int16Type, Int32Type, Int64Type, Int8Type, TimestampMicrosecondType,
        let max =
        // Both MIN and MAX yield null for null/empty/all-null rows.
fn compare_elements(
    }
    }
pub fn cmp_sort_values(a: &[SortKey], b: &[SortKey], reverse_sorts: &[bool]) -> Ordering {
    }
                            None => b.values().append_null(),
    row: usize,
            get_sort_values(&batch, 0, &[0], &[ArrowDataType::Int64], &[false], &[false]).unwrap();
        assert!(matches!(nl[0], SortKey::NullLast));
        assert_eq!(
    list: &GenericListArray<O>,
    }
pub(crate) fn reduced_sort_array(array: &ArrayRef, max: bool) -> MergeResult<ArrayRef> {
                    offsets[row].as_usize(),
        let list = int_list(&[
    start: usize,
                col.as_primitive::<TimestampMicrosecondType>().value(row)
        (0..arr.len())
    }
    dtype: &ArrowDataType,
            .cmp(values.as_binary::<i32>().value(b)),
        }
    for (i, (col_idx, dtype)) in col_indices.iter().zip(dtypes.iter()).enumerate() {
        }),
            Some(vec![None, Some(7), Some(4)]), // mixed => ignores null element
    dtypes: &[ArrowDataType],
    #[test]
    Float(f64),
fn winning_index(
                            max,
            .collect()
        }
    #[test]
            None,                               // null list => null key
            Ok(take(values.as_ref(), &UInt64Array::from(indices), None)?)
            Some(vec![Some(3), Some(1), Some(2)]),
        for row in rows {
        }
            match row {
    let values = list.values();
        )?,
                Ok(None)
    }
        }
    }
        | ArrowDataType::LargeList(field)
/// (and therefore no `Vec<u8>` for string/binary) is materialized during the
            if list.is_null(row) {
                    b.append(true);
        ArrowDataType::Date64 => SortKey::Int(col.as_primitive::<Date64Type>().value(row)),
            }
    use arrow::datatypes::{Field, Schema};
    end: usize,
                Ok(winning_index(
        let min =
    fn eq(&self, other: &Self) -> bool {
};
            arrow::datatypes::TimeUnit::Second => {
 *
#[inline]
        let nl = get_sort_values(&batch, 0, &[0], &[list_type], &[false], &[false]).unwrap();
    null_first: bool,
        let reduced = reduced_sort_array(array, max).unwrap();
        assert_eq!(reduced_ints(&list, true), vec![Some(3), Some(10)]);
            }
impl PartialOrd for SortKey {
}
        // Scalar field: MIN vs MAX must produce the same key.
    let indices = (0..list.len())
            }
                if replace {
