    fn str_list(rows: &[Option<Vec<Option<&str>>>]) -> ArrayRef {
use std::sync::Arc;
}
                        let start = row * *size as usize;
    dtype: &ArrowDataType,
                        .map(|i| i as u64))
            Some(current) => {
                    b.append(true);
}
#[cfg(test)]
            "v",
    }
    // ── winning_index directly ───────────────────────────────────────────
use super::error::{MergeError, MergeResult};
            get_reduced_value(
            SortKey::Bytes(col.as_string::<i32>().value(row).as_bytes().to_vec())
            col.as_list::<i64>(),
            return if reverse && !is_null_cmp {
 *
            Ok(take(values.as_ref(), &UInt64Array::from(indices), None)?)
    }
                    Some(arr.value(i).to_string())
}
        let batch =
        // Swap other/self so max-heap behaves as min-heap.
    }
        }
/// Materializes one temporary scalar reduced key per row for Arrow's
/// Scans `values[start..end]` and returns the index of the winning non-null
    }
            Some(vec![Some(3), Some(1), Some(2)]),
    fn test_winning_index_min_max_and_empty() {
            } else {
#[inline]
        )]));
        }),
            (SortKey::Bytes(a), SortKey::Bytes(b)) => a.cmp(b),
                    offsets[row + 1].as_usize(),
        let mut b = ListBuilder::new(Int64Builder::new());
                col.as_primitive::<TimestampSecondType>().value(row)
            })
    // scalar columns the value at `row` is the sort key regardless of mode.
    #[test]
/// MAX element, otherwise MIN). Scalar fields ignore the reduction mode and are
    Array, ArrayRef, AsArray, GenericListArray, OffsetSizeTrait, RecordBatch, UInt64Array,
    fn test_reduce_int_list_max() {
    max: bool,
                .collect::<MergeResult<Vec<_>>>()?;
    }
fn get_list_reduced<O: OffsetSizeTrait>(
    dtype: &ArrowDataType,
            true,
    dtypes: &[ArrowDataType],
    row: usize,
    Ok(take(values.as_ref(), &UInt64Array::from(indices), None)?)
    fn eq(&self, other: &Self) -> bool {
    dtype: &ArrowDataType,
    Float64Type, Int16Type, Int32Type, Int64Type, Int8Type, TimestampMicrosecondType,
        ArrowDataType::UInt8 => SortKey::UInt(col.as_primitive::<UInt8Type>().value(row) as u64),
        }
        assert_eq!(
    b: usize,
            vec![Some("apple".to_string()), Some("m".to_string())]
            max,
        Arc::new(b.finish())
    }
    }
            match row {
        assert_eq!(
    fn test_reduce_int_list_min() {
fn get_reduced_value(
// =============================================================================
/// which preserves their established ordering without heap allocation.
                } else {
        .collect::<MergeResult<Vec<_>>>()?;
        assert_eq!(reduced_ints(&list, false), vec![None, None, None, Some(4)]);
}
                            start + *size as usize,
                )?
            SortKey::Bytes(col.as_string::<i64>().value(row).as_bytes().to_vec())
        cmp_sort_values(&other.sort_values, &self.sort_values, &self.reverse_sorts)
}
                if arr.is_null(i) {
            .map(|i| {
        }
        assert_eq!(scalar_key_i64(&min[0]), 42);
}
                .map(|row| {
        assert_eq!(
                if replace {
        let list_type = list.data_type().clone();
            null_first,
/// [`SortKey`] using the given reduction `mode` (MIN when `max == false`, MAX
    }
                    ord == Ordering::Greater
            }
    for index in start..end {
            left.cmp(&right)
    let ordering = match dtype {
        }
pub fn get_sort_values(
                            None => b.values().append_null(),
    // ── Null / empty / all-null semantics ────────────────────────────────
    #[test]
fn reduce_list_array<O: OffsetSizeTrait>(
        // materializing a single scalar, so pass `false`.
    fn reduced_ints(array: &ArrayRef, max: bool) -> Vec<Option<i64>> {
        if ord != Ordering::Equal {
/*
                    if list.is_null(row) {
/// Returns the scalar type used as the physical sort key. LIST columns reduce
                col.as_primitive::<TimestampMicrosecondType>().value(row)
    list: &GenericListArray<O>,
        // MAX reduction picks the largest element of each row.
pub(crate) fn reduced_sort_array(array: &ArrayRef, max: bool) -> MergeResult<ArrayRef> {
        _ => Ok(array.clone()),
        let nf = nulls_first.get(i).copied().unwrap_or(false);
            true,
            .value(a)
    }
        match winner {
    fn eq(&self, other: &Self) -> bool {
            arrow::datatypes::TimeUnit::Millisecond => {
                col.as_primitive::<TimestampNanosecondType>().value(row)
            .cmp(values.as_binary::<i64>().value(b)),
/// element — after the allocation-free [`winning_index`] scan. An all-null or
                    max,
        );
    null_first: bool,
}
    };
fn winning_index(
                ord
    let indices = (0..list.len())
        Some(index) => get_array_sort_value(values, index, dtype, false, false),
        ArrowDataType::Boolean => SortKey::Bool(col.as_boolean().value(row)),
            .value(a)
    TimestampMillisecondType, TimestampNanosecondType, TimestampSecondType, UInt16Type, UInt32Type,
        ArrowDataType::LargeList(field) => get_list_reduced(
// SortKey — typed sort value with null ordering baked in
        assert_eq!(scalar_key_i64(&max[0]), 8); // MAX element
    Bool(bool),
    pub sort_values: Vec<SortKey>,
            true,
use arrow::compute::take;
    }
            (SortKey::NullLast, _) => Ordering::Greater,
                // For MIN keep the smaller element, for MAX keep the larger.
        _ => {
 * SPDX-License-Identifier: Apache-2.0
            let start = row * *size as usize;
        assert_eq!(
        ArrowDataType::UInt16 => SortKey::UInt(col.as_primitive::<UInt16Type>().value(row) as u64),
pub enum SortKey {
            Some(vec![Some(3), Some(1), Some(2)]),
        ArrowDataType::List(field) => {
        assert!(matches!(nl[0], SortKey::NullLast));
            SortKey::Float(col.as_primitive::<Float32Type>().value(row) as f64)
        ArrowDataType::List(field)
            }
    match dtype {
) -> MergeResult<SortKey> {
    #[test]
///
        ArrowDataType::Utf8 => {
        ArrowDataType::Duration(unit) => SortKey::Int(match unit {
        })
            arrow::datatypes::TimeUnit::Second => {
                        Ok(winning_index(
            }
        }
            };
            })
    fn partial_cmp(&self, other: &Self) -> Option<Ordering> {
}
pub(crate) fn reduced_sort_type(dtype: &ArrowDataType) -> ArrowDataType {
// =============================================================================
// Sort value extraction
}
        let schema = Arc::new(Schema::new(vec![Field::new(
    #[test]
            arrow::datatypes::TimeUnit::Nanosecond => {
        offsets[row].as_usize(),
                }
/// (and therefore no `Vec<u8>` for string/binary) is materialized during the
        assert_eq!(reduced_strs(&list, false), vec![Some("alpha".to_string())]);
            "tags",
        // null_first => NullFirst sentinel; null_last => NullLast sentinel.
            RecordBatch::try_new(schema, vec![Arc::new(Int64Array::from(vec![42i64]))]).unwrap();
                    values.as_ref(),
    use super::*;
    UInt64Type, UInt8Type,
            }
        .map(|row| {
    child_type: &ArrowDataType,
    child_type: &ArrowDataType,
    #[test]
    fn scalar_key_i64(sk: &SortKey) -> i64 {
    row: usize,
// HeapItem for k-way merge
        if values.is_null(index) {
    match winning_index(values, start, end, dtype, max)? {
/// never written to Parquet.
                ord.reverse()
    let offsets = list.value_offsets();
        child_type,
                start,
/// RowConverter, using the resolved reduction mode (`max == true` selects the
        assert_eq!(scalar_key_i64(&min[0]), 1); // MIN element
    /// Builds a `List<Int64>` from rows. `None` row => null list; empty inner
    if null_first {
        ArrowDataType::Float64 => SortKey::Float(col.as_primitive::<Float64Type>().value(row)),
        ArrowDataType::Date64 => SortKey::Int(col.as_primitive::<Date64Type>().value(row)),
    list: &GenericListArray<O>,
        ArrowDataType::UInt32 => SortKey::UInt(col.as_primitive::<UInt32Type>().value(row) as u64),
// =============================================================================
    fn cmp(&self, other: &Self) -> Ordering {
        assert_eq!(
    use arrow::datatypes::{Field, Schema};
        | ArrowDataType::FixedSizeList(field, _) => field.data_type().clone(),
                    None
    // ── LIST reduction: MIN vs MAX for numeric values ────────────────────
                    None
    }
    fn cmp(&self, other: &Self) -> Ordering {
            .as_binary::<i32>()
    }
        ArrowDataType::Int8 => SortKey::Int(col.as_primitive::<Int8Type>().value(row) as i64),
    fn test_reduce_null_empty_and_all_null_rows() {
// =============================================================================
/// Compares two non-null elements without allocating byte buffers for string or
                            Some(v) => b.values().append_value(*v),
    fn int_list(rows: &[Option<Vec<Option<i64>>>]) -> ArrayRef {
    }
        }
    }
            list_type.clone(),
                col.as_primitive::<DurationMicrosecondType>().value(row)
            (SortKey::Float(a), SortKey::Float(b)) => a.total_cmp(b),
    null_first: bool,
    fn test_get_sort_values_list_null_row_uses_null_sentinel() {
        ArrowDataType::Binary => SortKey::Bytes(col.as_binary::<i32>().value(row).to_vec()),
        SortKey::NullLast
                        )?
            return Err(MergeError::Logic(format!(
        let values = Int64Array::from(vec![5i64, 1, 9, 3]);
            reduced_strs(&list, false),
        }
        ArrowDataType::Int64 => SortKey::Int(col.as_primitive::<Int64Type>().value(row)),
// =============================================================================
}
        let list = str_list(&[Some(vec![Some("delta"), Some("alpha"), Some("charlie")])]);
    fn test_get_sort_values_scalar_ignores_mode() {
    // ── get_sort_values: scalar ignores mode; list honors mode ───────────
}
            }
use arrow::array::{
    values: &dyn Array,
            Some(vec![Some("x"), Some("m")]),
impl Ord for SortKey {
    values: &dyn Array,
        ]);
            SortKey::Float(col.as_primitive::<Float16Type>().value(row).to_f32() as f64)
fn null_sort_key(null_first: bool) -> SortKey {
    Int(i64),
impl PartialEq for HeapItem {
                        match e {
        ArrowDataType::LargeUtf8 => values
            Some(vec![None, Some(7), Some(4)]), // mixed => ignores null element
        max,
        ArrowDataType::Binary => values
            Some(vec![Some(10), Some(-5)]),
            col.as_list::<i32>(),
        let max = get_sort_values(&batch, 0, &[0], &[list_type], &[false], &[true]).unwrap();
                other
        ArrowDataType::Float32 => {
        ArrowDataType::LargeBinary => SortKey::Bytes(col.as_binary::<i64>().value(row).to_vec()),
    Ordering::Equal
            arrow::datatypes::TimeUnit::Nanosecond => {
        ]);
            None => winner = Some(index),
            get_sort_values(&batch, 0, &[0], &[ArrowDataType::Int64], &[false], &[true]).unwrap();
                    offsets[row].as_usize(),
            .map(|i| {
                        }
        }
};
            .cmp(values.as_binary::<i32>().value(b)),
        values.push(get_sort_value(batch, row, *col_idx, dtype, nf, max)?);
            "tags",
        }
impl PartialOrd for HeapItem {
/// scan. This is the shared winner-selection helper used by both the k-way
        assert_eq!(reduced_ints(&list, true), vec![Some(3), Some(10)]);
            .as_binary::<i64>()
            } else {
    row: usize,
            max,
) -> MergeResult<Vec<SortKey>> {
    }
        Some(self.cmp(other))
    }
                            max,
    values: &dyn Array,
// =============================================================================
        SortKey::NullFirst
            let indices = (0..list.len())
            match row {
    /// vec => empty (non-null) list; inner `None` => null element.
}
        }
            (SortKey::NullFirst, _) => Ordering::Less,
                } else {
        self.cmp(other) == Ordering::Equal
        let arr = reduced.as_string::<i32>();
            vec![Some("cherry".to_string()), Some("x".to_string())]
    }
        let mut b = ListBuilder::new(StringBuilder::new());
}
        );
        let batch = RecordBatch::try_new(schema, vec![list]).unwrap();
impl Eq for HeapItem {}
        ArrowDataType::UInt64 => SortKey::UInt(col.as_primitive::<UInt64Type>().value(row)),
    Ok(key)
/// Lexicographic comparison of two sort-key tuples, respecting per-column
    start: usize,
            continue;
}
        (0..arr.len())
#[inline(always)]
 * this file be licensed under the Apache-2.0 license or a
            .collect()
/// returned unchanged. The returned array is used only while sorting and is
        }
            ArrowDataType::Int64,
    end: usize,
        let batch = RecordBatch::try_new(schema, vec![list]).unwrap();
                None => b.append(false),
            Some(vec![]),                       // empty list => null key
}
    start: usize,
                };
        self.sort_values == other.sort_values
    } else {
    DurationMillisecondType, DurationNanosecondType, DurationSecondType, Float16Type, Float32Type,
                let replace = if max {
            row,
/// sort direction. Returns `Ordering::Equal` when all values match.
 */
        let ord = av.cmp(bv);
    pub reverse_sorts: Arc<Vec<bool>>,
                }
            get_sort_values(&batch, 0, &[0], &[ArrowDataType::Int64], &[false], &[false]).unwrap();
                        Ok(None)
    col: &dyn Array,
#[derive(Debug, Clone)]
    NullLast,
/// empty range yields the null sentinel.
        ArrowDataType::LargeBinary => values
            (SortKey::Bool(a), SortKey::Bool(b)) => a.cmp(b),
#[derive(Debug)]
        let arr = reduced.as_primitive::<Int64Type>();
        match sk {
        offsets[row + 1].as_usize(),
            reduce_list_array(array.as_list::<i64>(), field.data_type(), max)
        null_first,
                }
        for row in rows {
    for (i, (av, bv)) in a.iter().zip(b.iter()).enumerate() {
fn get_array_sort_value(
    max: bool,
        other => {
            .as_bytes()
        let schema = Arc::new(Schema::new(vec![Field::new(
                Some(elems) => {
                    child_type,
/// scalar columns keep their own type.
    get_reduced_value(
            winning_index(arr, 0, 4, &ArrowDataType::Int64, false).unwrap(),
            )?
            .cmp(values.as_string::<i64>().value(b).as_bytes()),
                || matches!(bv, SortKey::NullFirst | SortKey::NullLast);
                })
        ArrowDataType::Timestamp(unit, _) => SortKey::Int(match unit {
        let min =
        let reduced = reduced_sort_array(array, max).unwrap();
        let list = int_list(&[
) -> MergeResult<SortKey> {
    let offsets = list.value_offsets();
    UInt(u64),
        let max = max_sort_modes.get(i).copied().unwrap_or(false);
    match array.data_type() {
    dtype: &ArrowDataType,
        ArrowDataType::List(field) => get_list_reduced(
    }
                    Some(arr.value(i))
            Some(2)
            .cmp(values.as_string::<i32>().value(b).as_bytes()),
        Some(self.cmp(other))
impl PartialOrd for SortKey {
                }
        ArrowDataType::LargeUtf8 => {
        ]);
                            None => b.values().append_null(),
    get_array_sort_value(batch.column(col_idx).as_ref(), row, dtype, null_first, max)
impl Eq for SortKey {}
            list_type.clone(),
    end: usize,
        let list_type = list.data_type().clone();
        );
/// Reduces the non-null elements of `values[start..end]` to a single
) -> MergeResult<Option<usize>> {
        }),
    fn test_get_sort_values_list_honors_mode() {
        )]));
    max: bool,
        for row in rows {
        }
    /// Builds a `List<Utf8>` from rows (same null conventions as `int_list`).
            (SortKey::NullLast, SortKey::NullLast) => Ordering::Equal,
}
                max,
        let min =
/// binary values. Other scalar types reuse the existing `SortKey` conversion,
                col.as_primitive::<TimestampMillisecondType>().value(row)
    }
                    winner = Some(index);
    let values = list.values();
                start + *size as usize,
    // `max` only affects LIST/FixedSizeList reduction (MIN vs MAX element). For
                        }
            None,                               // null list => null key
            winning_index(arr, 2, 2, &ArrowDataType::Int64, false).unwrap(),
) -> MergeResult<SortKey> {
        ArrowDataType::Int32 => SortKey::Int(col.as_primitive::<Int32Type>().value(row) as i64),
        // Guards against accidental regression to per-element Vec<u8> allocation:
    fn partial_cmp(&self, other: &Self) -> Option<Ordering> {
                col.as_primitive::<DurationMillisecondType>().value(row)
use std::cmp::Ordering;
        Arc::new(b.finish())
            .as_string::<i32>()
 * compatible open source license.
        | ArrowDataType::LargeList(field)
        assert_eq!(reduced_strs(&list, true), vec![Some("delta".to_string())]);
            other => panic!("expected Int key, got {:?}", other),
/// element for the requested reduction mode: the minimum element when
    if col.is_null(row) {
            arrow::datatypes::TimeUnit::Microsecond => {
    let mut winner: Option<usize> = None;
            _ => Ordering::Equal,
            (SortKey::Int(a), SortKey::Int(b)) => a.cmp(b),
    Ok(winner)
            )));
    fn reduced_strs(array: &ArrayRef, max: bool) -> Vec<Option<String>> {
        )?,
    )
            winning_index(arr, 0, 4, &ArrowDataType::Int64, true).unwrap(),
                    }
        _ => dtype.clone(),
            let left = get_array_sort_value(values, a, dtype, false, false)?;
    col_idx: usize,
                            Some(v) => b.values().append_value(*v),
        // Scalar field: MIN vs MAX must produce the same key.
        // the reducer must still select the correct winner for strings.
            let list = array.as_fixed_size_list();
        let list = int_list(&[
    // ── Helpers ──────────────────────────────────────────────────────────
/// `max == false`, the maximum element when `max == true`. Returns `None` when
    for (i, (col_idx, dtype)) in col_indices.iter().zip(dtypes.iter()).enumerate() {
    }
) -> MergeResult<ArrayRef> {
                Some(elems) => {
                    b.append(true);
// Sort-direction helpers
    max_sort_modes: &[bool],
                    }
                }
        )?,
        let nl = get_sort_values(&batch, 0, &[0], &[list_type], &[false], &[false]).unwrap();
#[inline]
mod tests {
fn compare_elements(
        ]);
        None => Ok(null_sort_key(null_first)),
        ArrowDataType::FixedSizeList(field, size) => {
        // Both MIN and MAX yield null for null/empty/all-null rows.
    Ok(ordering)
}
    #[test]
        ArrowDataType::Utf8 => values
        assert!(matches!(nf[0], SortKey::NullFirst));
                let ord = compare_elements(values, index, current, dtype)?;
    #[test]
        let list = int_list(&[
            (SortKey::NullFirst, SortKey::NullFirst) => Ordering::Equal,
                col.as_primitive::<DurationSecondType>().value(row)
            Some(vec![Some("banana"), Some("apple"), Some("cherry")]),
            arrow::datatypes::TimeUnit::Microsecond => {
            }
            get_sort_values(&batch, 0, &[0], &[list_type.clone()], &[false], &[false]).unwrap();
/// every element in the range is null (or the range is empty).
    null_first: bool,
            // Same column always produces the same variant; cross-variant is unreachable.
    pub file_id: usize,
pub fn get_sort_value(
            .value(a)
                if arr.is_null(i) {
    col_indices: &[usize],
            }
// =============================================================================
                    } else {
            if list.is_null(row) {
    fn test_reduce_utf8_list_min_and_max() {
    }
#[inline]
        );
        match (self, other) {
    batch: &RecordBatch,
    nulls_first: &[bool],
            None
        let max =
    }
    Bytes(Vec<u8>),
            }
}
        // MIN reduction picks the smallest element of each row.
    // ── LIST reduction: MIN vs MAX for Utf8 values ───────────────────────
            let values = list.values();
    Ok(values)
            SortKey::Int(v) => *v,
        let list = str_list(&[
            }
        (0..arr.len())
                field.data_type(),
                "Unsupported sort column type: {:?}",
            field.data_type(),
            reduced_strs(&list, true),
                    ord == Ordering::Less
/// Comparison happens fully in place via [`compare_elements`] — no `SortKey`
            Some(vec![Some(10), Some(-5)]),
    let mut values = Vec::with_capacity(col_indices.len());
        let list = int_list(&[None]);
    };
            (_, SortKey::NullLast) => Ordering::Less,
                Ok(winning_index(
                        match e {
        // Empty range yields None regardless of mode.
    max: bool,
    use arrow::array::{Int64Array, Int64Builder, ListBuilder, RecordBatch, StringBuilder};
}
            .as_string::<i64>()
        )]));
/// when `max == true`). Exactly one `SortKey` is materialized — for the winning
    batch: &RecordBatch,
    #[test]
                            values.as_ref(),
                col.as_fixed_size_list().values().as_ref(),
        ArrowDataType::Date32 => SortKey::Int(col.as_primitive::<Date32Type>().value(row) as i64),
                            start,
        // Scalar fields ignore the reduction mode.
            .value(a)
            (SortKey::UInt(a), SortKey::UInt(b)) => a.cmp(b),
            (_, SortKey::NullFirst) => Ordering::Greater,
) -> MergeResult<SortKey> {
        let list = int_list(&[Some(vec![Some(3), Some(1), Some(8)])]);
 * The OpenSearch Contributors require contributions made to
        ArrowDataType::Int16 => SortKey::Int(col.as_primitive::<Int16Type>().value(row) as i64),
                None => b.append(false),
                Ok(None)
#[inline]
/// merge sort-value extraction and the per-row list reduction.
}
) -> MergeResult<Ordering> {
            let reverse = reverse_sorts.get(i).copied().unwrap_or(false);
            }
}
        list.values().as_ref(),
        ArrowDataType::Float16 => {
        }
            field.data_type(),
use arrow::datatypes::{
    #[test]
    DataType as ArrowDataType, Date32Type, Date64Type, DurationMicrosecondType,
    }
                } else {
            }
};
            row,
    }
                            field.data_type(),
// =============================================================================
            let right = get_array_sort_value(values, b, dtype, false, false)?;
pub struct HeapItem {
                null_first,
impl Ord for HeapItem {
    max: bool,
    Float(f64),
        assert_eq!(reduced_ints(&list, true), vec![None, None, None, Some(7)]);
        }
            arrow::datatypes::TimeUnit::Millisecond => {
                    for e in elems {
        let arr: &dyn Array = &values;
    null_first: bool,
        return Ok(null_sort_key(null_first));
        assert_eq!(reduced_ints(&list, false), vec![Some(1), Some(-5)]);
    a: usize,
            .as_bytes()
            Some(1)
            .collect()
    }
                    }
pub fn cmp_sort_values(a: &[SortKey], b: &[SortKey], reverse_sorts: &[bool]) -> Ordering {
        assert_eq!(scalar_key_i64(&max[0]), 42);
#[inline]
        // The winner is a scalar leaf element; `max` is irrelevant when
    row: usize,
                    for e in elems {
        }
            }
            Some(vec![None, None]),             // all-null elements => null key
        );
        ArrowDataType::LargeList(field) => {
        let nf = get_sort_values(&batch, 0, &[0], &[list_type.clone()], &[true], &[false]).unwrap();
    let key = match dtype {
    }
            null_first,
            reduce_list_array(array.as_list::<i32>(), field.data_type(), max)
                col.as_primitive::<DurationNanosecondType>().value(row)
        let reduced = reduced_sort_array(array, max).unwrap();
        }
impl PartialEq for SortKey {
    dtype: &ArrowDataType,
/// to the winning (MIN or MAX, per the resolved sort mode) non-null element;
    }
            arrow::datatypes::TimeUnit::Second => {
        }
        ArrowDataType::FixedSizeList(field, size) => {
    max: bool,
        let schema = Arc::new(Schema::new(vec![Field::new(
                .map(|i| i as u64))
    }
    NullFirst,
    fn test_reduce_str_list_min_used_by_string_array() {
            let is_null_cmp = matches!(av, SortKey::NullFirst | SortKey::NullLast)
