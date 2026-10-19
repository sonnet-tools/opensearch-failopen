            ColumnarValue::Array(arr),
//! * Returns NULL if no non-null elements were collected (PPL convention —
        let result: ArrayRef = match &element_type {
}
        let inner = list.value(row);
}
    row_list: &dyn Array,
    fn signature(&self) -> &Signature {
                    .with_precision_and_scale(*precision, *scale)
                                    any_value = true;
            DataType::Boolean => build!(BooleanBuilder, BooleanArray, ListArray),
            DataType::UInt16 => build!(UInt16Builder, UInt16Array, ListArray),
                                if !typed.is_null(i) {
                    }
        let result = run(args, 1);
}
        ];
    #[test]
        Self::new()
                            builder.values().append_value(typed.value(row));
    use datafusion::arrow::array::AsArray;
        // Materialize each operand as an ArrayRef whose Arrow type is either
            .collect()
                number_rows: n,
            other => {
            .map(|(i, cv)| {
/// Trait abstracting the difference between {@link StringBuilder} and
                            // Iterate elements of the list at this row.
            ColumnarValue::Scalar(_) => panic!("expected array"),
/// this glue lets {@link build_string_rows} drive either via the same code.
                                    ))
 * compatible open source license.
        let operand_arrays: Vec<ArrayRef> = args
    signature: Signature,
fn append_string_scalar<B: StrAppend>(
        out.append_str(typed.value(row));
    fn append_str(&mut self, s: &str) {
            DataType::Int8 => build!(Int8Builder, Int8Array, ListArray),
//!
                        } else if let Some(typed) = arr.as_any().downcast_ref::<Decimal128Array>() {
//! The Java adapter (`MvappendAdapter`) casts every scalar argument to the
        }
                    }
        Ok(ColumnarValue::Array(result))
        ))))
                return plan_err!("mvappend: unsupported element type {other:?}");
                            return plan_err!(
                    if any_value {
                            any_value = true;
            DataType::Int64 => build!(Int64Builder, Int64Array, ListArray),
    }
                config_options: Arc::new(datafusion::config::ConfigOptions::default()),
    }
        let args = vec![
        })?;
//! `mvappend(arg1, arg2, …)` — flatten a mixed list of array and scalar args
    fn default() -> Self {
                None => builder.append_null(),
/// computed expressions as {@code Utf8} or {@code LargeUtf8}.
        let args = vec![
impl StrAppend for StringBuilder {
        if arg_types.is_empty() {
                };
            .map(|i| typed.value(i))
            DataType::UInt64 => build!(UInt64Builder, UInt64Array, ListArray),
                continue;
                                    DataFusionError::Internal(format!(
        // mvappend(1, 2, 3) → [1, 2, 3]
                    if any_value {
//! Mirrors PPL's [`MVAppendFunctionImpl`] / [`MVAppendCore`] semantics:
                append_string_scalar(arr.as_ref(), row, builder.values(), &mut any_value)?;
        let result = run(args, 1);
            ColumnarValue::Scalar(ScalarValue::Int32(Some(2))),
    }
        // mvappend([], 1) → [1]
//!
#[cfg(test)]
                Arc::new(builder.finish()) as ArrayRef
                                arr.data_type()
/// normalized everything to that single element type — either bare scalar or
                        }
                for row in 0..n {
                        }
/// Generic per-row writer for string-typed mvappend output. Dispatches list-child
    any_value: &mut bool,
                                .downcast_ref::<Decimal128Array>()
                    for arr in &operand_arrays {
/// {@link StringViewBuilder} when appending {@code &str} values. Both expose
                        if let Some(list_arr) = arr.as_any().downcast_ref::<GenericListArray<i32>>()
                    builder.append(true);
impl MvappendUdf {
}
            DataType::Float64 => build!(Float64Builder, Float64Array, ListArray),
        self.append_value(s);
        Ok(arg_types.to_vec())
                        builder.append(true);
    fn append_str(&mut self, s: &str) {
            }
        let mut builder = ListBuilder::new(Int32Builder::new());
    if let Some(typed) = arr.as_any().downcast_ref::<StringViewArray>() {
        assert!(list.is_null(0));
            if !typed.is_null(i) {
        for arr in operand_arrays {
                .iter()
                                        "mvappend: list element vector type mismatch ({:?})",
pub struct MvappendUdf {
}
                                "mvappend: unexpected operand vector type {:?}",
        "mvappend: list element vector type mismatch — expected string, got {:?}",
//!   * NULL argument → skipped entirely.
                    })?;
        ];
                                        row_list.data_type()
impl ScalarUDFImpl for MvappendUdf {
    n: usize,
    if let Some(large) = row_list.as_string_opt::<i64>() {
    out: &mut B,
        for i in 0..large.len() {
                            );
        let mut any_value = false;
    #[test]
                                        row_list.data_type()
fn element_type(arg_types: &[DataType]) -> Option<DataType> {
        assert_eq!(extract_row_ints(&result, 0), vec![1, 2]);
            }};
                                arr.data_type()
                    } else {
    fn all_null_args_yield_null_row() {
    }
            if !large.is_null(i) {
                        if let Some(list_arr) = arr.as_any().downcast_ref::<GenericListArray<i32>>()
                    for arr in &operand_arrays {
            )
                    for e in *elems {
                        if arr.is_null(row) {
            // {Utf8, LargeUtf8, Utf8View} depending on whether the operand is a string literal,
//!   * Scalar argument → appended as a single element.
            DataType::Utf8 | DataType::LargeUtf8 => {
                        }
                arg_fields,
            ColumnarValue::Array(arr),
                        }
}
            builder.append_null();
    fn three_scalar_ints() {
//! `ARRAY<ANY>` which substrait doesn't have an encoding for — those fail at
            if !typed.is_null(i) {
        for i in 0..typed.len() {
    plan_err!(
        let arr = list_of_ints(&[Some(&[])]);
            }
    }
            }
    if let Some(typed) = row_list.as_any().downcast_ref::<StringArray>() {
trait StrAppend {
            }
    ListArray, ListBuilder, StringArray, StringBuilder, StringViewArray, StringViewBuilder,
        // mvappend(NULL, NULL) → NULL
                let dt = match cv {
        let arr = list_of_ints(&[Some(&[Some(1), None, Some(2)])]);
use datafusion::logical_expr::{
    }
    fn run(args: Vec<ColumnarValue>, n: usize) -> ArrayRef {
        *any_value = true;
            builder.append(true);
        assert_eq!(extract_row_ints(&result, 0), vec![1, 2, 3]);
        let result = run(args, 1);
            // 52+), or a computed expression. The output type must match what {@code return_type}
    for row in 0..n {
                }
                .arg_fields
    }
                Arc::new(builder.finish()) as ArrayRef
                let mut builder = ListBuilder::new(StringBuilder::new());
//! `ARRAY<componentType>` before this UDF runs, so by the time we see operands
        *any_value = true;
        // exists only because Signature::user_defined demands an implementation; we
    use super::*;
    use datafusion::common::ScalarValue;
    ColumnarValue, ScalarFunctionArgs, ScalarUDF, ScalarUDFImpl, Signature, Volatility,
            // declared (which is whatever {@code element_type()} returned, driven by the first
                append_string_elements(row_list.as_ref(), builder.values(), &mut any_value)?;
    }
            DataFusionError::Internal("mvappend: lost element type at invoke".to_string())
        // pass each type through unchanged.
    fn invoke_with_args(&self, args: ScalarFunctionArgs) -> Result<ColumnarValue> {
            return plan_err!("mvappend expects at least 1 argument, got 0");
                                    builder.values().append_value(typed.value(i));
            // operand) — DataFusion validates the actual output schema against the declared
            return vec![];
use std::sync::Arc;
            .iter()
        ));
            .collect();
            // a field read (DataFusion's substrait consumer uses Utf8View for column reads in
            ColumnarValue::Scalar(ScalarValue::Int32(Some(1))),
            .map(|a| a.clone().into_array(n))
}
    if let Some(typed) = row_list.as_any().downcast_ref::<StringViewArray>() {
        let arg_fields: Vec<Arc<Field>> = args
//!
/// scalar literals come through as {@code Utf8}, field reads as {@code Utf8View},
//!
                        if arr.is_null(row) {
    }
//! vector type isn't covered surfaces as a planning error rather than a
/// Append all non-null string elements from a row's list to the output builder.
            }
        return Ok(());
        if any_value {
            }
            "out",
                            builder.values().append_value(typed.value(row));
                "mvappend: unable to determine element type from operand types".to_string(),
use datafusion::arrow::array::{
use datafusion::arrow::datatypes::{DataType, Field};
                        } else {
    )
        let typed = inner.as_primitive::<datafusion::arrow::datatypes::Int32Type>();
                            continue;
//! handles each supported scalar Arrow type explicitly; a list whose data
            .enumerate()
    }
    #[test]
        // mvappend([1, 2], 3) → [1, 2, 3]
        ];
    }
impl StrAppend for StringViewBuilder {
    }
//! substrait conversion, before reaching this UDF, and aren't addressed here.
                    .map_err(|e| {
        assert_eq!(extract_row_ints(&result, 0), vec![1, 2, 3]);
                Some(elems) => {
            } else {
    if let Some(large) = arr.as_string_opt::<i64>() {
            DataType::Int16 => build!(Int16Builder, Int16Array, ListArray),
                let inner = <$Builder>::new();
            signature: Signature::user_defined(Volatility::Immutable),
                    }
        *any_value = true;
                Arc::new(builder.finish()) as ArrayRef
    }
            }
    }
    #[test]
                build_string_rows::<StringViewBuilder>(&operand_arrays, n, &mut builder)?;
        }
            // String element types — handled specially because list children may be any of
        } else {
                            }
    fn return_type(&self, arg_types: &[DataType]) -> Result<DataType> {
            // produces DECIMAL(p, s) which substrait converts to Decimal128(p, s); the Java
        macro_rules! build {
//!   * Array argument → each non-null element is appended to the output.
    builder: &mut ListBuilder<B>,
                                    DataFusionError::Internal(format!(
            // adapter's CAST aligns every operand's element type to that.
                            for i in 0..typed.len() {
        let result = MvappendUdf::new()
/// downcasts across all three Utf8 flavors so the input doesn't need to match the
            DataType::UInt32 => build!(UInt32Builder, UInt32Array, ListArray),
            element_type,
    }
            DataType::List(Arc::new(Field::new("item", DataType::Int32, true))),
    if let Some(typed) = arr.as_any().downcast_ref::<StringArray>() {
/// output type.
        Ok(DataType::List(Arc::new(Field::new(
                                if !typed.is_null(i) {
//! into a single array, dropping null args AND null elements inside array args.
) -> Result<()> {
                        builder.append_null();
            .args
            // Decimal128 element type — needs a builder configured with the same precision
    arg_types.iter().find_map(|t| match t {
            ColumnarValue::Scalar(ScalarValue::Int32(Some(3))),
                *any_value = true;
            &args
    any_value: &mut bool,
            })
                }
/*
        }
            Some(field.data_type().clone())
    Float32Array, Float32Builder, Float64Array, Float64Builder, GenericListArray, Int16Array,
            .iter()
    plan_err!(
pub fn register_all(ctx: &SessionContext) {
        match result {
                        } else if let Some(typed) = arr.as_any().downcast_ref::<$Scalar>() {
                            Some(v) => builder.values().append_value(*v),
    Array, ArrayRef, AsArray, BooleanArray, BooleanBuilder, Decimal128Array, Decimal128Builder,
            ColumnarValue::Scalar(ScalarValue::Int32(Some(1))),
                            }
                                    any_value = true;
                        }
            DataType::Utf8View => {
) -> Result<()> {
        // Java adapter pre-coerces every operand to either ARRAY<E> or E for a
    }
    fn name(&self) -> &str {
    fn coerce_types(&self, arg_types: &[DataType]) -> Result<Vec<DataType>> {
                        {
    pub fn new() -> Self {
 * The OpenSearch Contributors require contributions made to
                let row_list = list_arr.value(row);
        return Ok(());
            }
    fn extract_row_ints(arr: &ArrayRef, row: usize) -> Vec<i32> {
 * SPDX-License-Identifier: Apache-2.0
            ColumnarValue::Array(arr),
    UInt8Builder,
    }
                                "mvappend: unexpected operand vector type {:?}",
fn build_string_rows<B: StrAppend + datafusion::arrow::array::ArrayBuilder>(
            ($Builder:ty, $Scalar:ty, $List:ty) => {{
}
    fn drops_null_arg() {
                            None => builder.values().append_null(),
    out: &mut B,
    }
        let args = vec![
                            let typed =
                                }
//! Mixed-type calls (`mvappend(1, 'text', 2.5)`) end up with Calcite type
        let element_type = element_type(arg_types).ok_or_else(|| {
                    ColumnarValue::Scalar(sv) => sv.data_type(),
            true,
            DataType::Decimal128(precision, scale) => {
            .unwrap();
        self.append_value(s);
//!
        "mvappend"
                args,
        if arg_types.is_empty() {
    UInt16Array, UInt16Builder, UInt32Array, UInt32Builder, UInt64Array, UInt64Builder, UInt8Array,
            "item",
            true,
        "mvappend: scalar operand vector type mismatch — expected string, got {:?}",
            DataType::Int32 => build!(Int32Builder, Int32Array, ListArray),
                        DataFusionError::Plan(format!("mvappend: decimal builder: {e}"))
        for row in rows {
    fn drops_null_elements_inside_array() {
        return Ok(());
                    }
            match row {
            }
        }
        assert_eq!(extract_row_ints(&result, 0), vec![1, 2, 3]);
        let result = run(args, 1);
                            continue;
fn append_string_elements<B: StrAppend>(
        ];
                    } else {
                .collect::<Vec<_>>(),
        };
}
                        match e {
    }
                        builder.append(true);
/// Handles operands typed as Utf8, LargeUtf8, or Utf8View.
//!   distinguishes `mvappend(null)` from `mvappend()` from `mvappend([])`).
                out.append_str(large.value(i));
    #[test]
            ColumnarValue::Scalar(ScalarValue::Int32(Some(3))),
    operand_arrays: &[ArrayRef],
    }
            if arr.is_null(row) {
            return plan_err!("mvappend expects at least 1 argument, got 0");
#[derive(Debug, PartialEq, Eq, Hash)]
            ColumnarValue::Array(a) => a,
use datafusion::error::{DataFusionError, Result};
                            return plan_err!(
    arr: &dyn Array,
                                    builder.values().append_value(typed.value(i));
                            any_value = true;
        ];
    }
                                })?;
        }
            .invoke_with_args(ScalarFunctionArgs {
                    }
        return Ok(());
                                    ))
                                })?;
        ];
    }
            // and scale as the input. Calcite's leastRestrictive widening for INT + DECIMAL
    fn list_of_ints(rows: &[Option<&[Option<i32>]>]) -> ArrayRef {
                            for i in 0..typed.len() {
                            let row_list = list_arr.value(row);
            DataFusionError::Plan(
            // schema and rejects mismatches with "column types must match schema types".
                        {
        let arr = list_of_ints(&[Some(&[Some(1), Some(2)])]);
        for i in 0..typed.len() {
use datafusion::execution::context::SessionContext;
                Arc::new(Field::new(format!("a{i}"), dt, true))
        )
                    let mut any_value = false;
        out.append_str(typed.value(row));
                                .as_any()
                build_string_rows::<StringBuilder>(&operand_arrays, n, &mut builder)?;
        let n = args.number_rows;
            DataType::UInt8 => build!(UInt8Builder, UInt8Array, ListArray),
        }
                Arc::new(builder.finish()) as ArrayRef
        }
            .collect::<Result<Vec<_>>>()?;
        // {element_type} or List<element_type>. Scalar operands replicate to n rows.
        }
        }
                out.append_str(typed.value(i));
        return Ok(());
        return Ok(());
        let element_type = element_type(
        }
                *any_value = true;
            })
            ColumnarValue::Scalar(ScalarValue::Int32(Some(2))),
                let mut builder = ListBuilder::new(StringViewBuilder::new());
                                        "mvappend: list element vector type mismatch ({:?})",
        }
            }
                            );
        &self.signature
        // single E. Use whichever element type we see first.
mod tests {
//! silent coercion.
        other => Some(other.clone()),
        }
                    ColumnarValue::Array(a) => a.data_type().clone(),
/// First operand type drives the element type. The Java adapter has already
            ColumnarValue::Scalar(ScalarValue::Int32(Some(3))),
        // Trust the Java adapter to have already coerced operands. coerce_types here
            ColumnarValue::Scalar(ScalarValue::Int32(Some(1))),
        }
        let args = vec![
        DataType::Null => None,
        .ok_or_else(|| {
 * this file be licensed under the Apache-2.0 license or a
        let return_field = Arc::new(Field::new(
//! call's array component type and every array argument to
        (0..typed.len())
            ColumnarValue::Scalar(ScalarValue::Int32(None)),
        let result = run(args, 1);
) -> Result<()> {
        Self {
    fn append_str(&mut self, s: &str);
    }
        if list.is_null(row) {
}
        assert_eq!(extract_row_ints(&result, 0), vec![1]);
        let result = run(args, 1);
//! * For each argument, in order:
                }
                                }
}
                        } else {
        let list = arr.as_any().downcast_ref::<ListArray>().unwrap();
};
    ctx.register_udf(ScalarUDF::from(MvappendUdf::new()));
 */
impl Default for MvappendUdf {
            DataType::Float32 => build!(Float32Builder, Float32Array, ListArray),
    row: usize,
                let mut builder = ListBuilder::new(inner);
        out.append_str(large.value(row));
    Ok(())
/// Append a single scalar string operand at the given row to the output builder.
//! they share a single element type. The element-conversion macro below
                            let typed = row_list
    }
                    let mut any_value = false;
                *any_value = true;
        arr.data_type()
    fn empty_array_in_args_contributes_nothing() {
/// `append_value(&str)`, but they're concrete types with no shared trait, so
/// `List<element>`. String element types are normalized to {@code Utf8} so the
use datafusion::common::plan_err;
                                row_list.as_any().downcast_ref::<$Scalar>().ok_or_else(|| {
    #[test]
    fn flattens_array_argument() {
                        builder.append_null();
}
                                .ok_or_else(|| {
}
                let inner = Decimal128Builder::new()
        // mvappend(NULL, 1, 2) → [1, 2]
    }
                let mut builder = ListBuilder::new(inner);
        let args = vec![
        })?;
            if let Some(list_arr) = arr.as_any().downcast_ref::<GenericListArray<i32>>() {
 *
    )
};
    })
                            let row_list = list_arr.value(row);
                return_field,
//! ## Type homogeneity
        let list = result.as_any().downcast_ref::<ListArray>().unwrap();
        Arc::new(builder.finish())
                for row in 0..n {
        DataType::List(field) | DataType::LargeList(field) | DataType::FixedSizeList(field, _) => {
        let args = vec![
        // mvappend([1, NULL, 2], 3) → [1, 2, 3]
            ColumnarValue::Scalar(ScalarValue::Int32(None)),
/// Handles list children typed as Utf8, LargeUtf8, or Utf8View.
/// match arm in {@link MvappendUdf::invoke_with_args} catches every flavor —
    Int16Builder, Int32Array, Int32Builder, Int64Array, Int64Builder, Int8Array, Int8Builder,
                out.append_str(typed.value(i));
        row_list.data_type()
            .filter(|i| !typed.is_null(*i))
                .map(|f| f.data_type().clone())
            ColumnarValue::Scalar(ScalarValue::Int32(None)),
