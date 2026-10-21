            }
    UInt8Builder,
            DataType::UInt16 => build!(UInt16Builder, UInt16Array, ListArray),
                            Some(v) => builder.values().append_value(*v),
        let arr = list_of_ints(&[Some(&[Some(1), Some(2)])]);
        out.append_str(large.value(row));
        ));
                                        row_list.data_type()
/// scalar literals come through as {@code Utf8}, field reads as {@code Utf8View},
/// {@link StringViewBuilder} when appending {@code &str} values. Both expose
        assert_eq!(extract_row_ints(&result, 0), vec![1, 2, 3]);
                    ColumnarValue::Array(a) => a.data_type().clone(),
                let mut builder = ListBuilder::new(inner);
        // mvappend(NULL, NULL) → NULL
            "out",
    UInt16Array, UInt16Builder, UInt32Array, UInt32Builder, UInt64Array, UInt64Builder, UInt8Array,
        DataType::Null => None,
) -> Result<()> {
        Self::new()
            }};
    row: usize,
/// Append all non-null string elements from a row's list to the output builder.
                    for arr in &operand_arrays {
    }
                        builder.append(true);
            // String element types — handled specially because list children may be any of
        return Ok(());
}
use datafusion::execution::context::SessionContext;
                number_rows: n,
                    .map_err(|e| {
/// `List<element>`. String element types are normalized to {@code Utf8} so the
            ColumnarValue::Scalar(ScalarValue::Int32(Some(3))),
            &args
    }
    use datafusion::common::ScalarValue;
    }
 * SPDX-License-Identifier: Apache-2.0
        // mvappend([1, 2], 3) → [1, 2, 3]
        if list.is_null(row) {
            .collect();
//!
                Arc::new(builder.finish()) as ArrayRef
        let result = run(args, 1);
                let inner = <$Builder>::new();
        let list = result.as_any().downcast_ref::<ListArray>().unwrap();
                            any_value = true;
            }
//! The Java adapter (`MvappendAdapter`) casts every scalar argument to the
        // pass each type through unchanged.
use datafusion::common::plan_err;
        out.append_str(typed.value(row));
//!   * Scalar argument → appended as a single element.
                            None => builder.values().append_null(),
        let args = vec![
            ColumnarValue::Array(arr),
/// Handles list children typed as Utf8, LargeUtf8, or Utf8View.
                    } else {
                                    any_value = true;
//!
//! `ARRAY<ANY>` which substrait doesn't have an encoding for — those fail at
                return_field,
) -> Result<()> {
            if let Some(list_arr) = arr.as_any().downcast_ref::<GenericListArray<i32>>() {
                        builder.append_null();
 * compatible open source license.
                            continue;
    }
    fn run(args: Vec<ColumnarValue>, n: usize) -> ArrayRef {
                            builder.values().append_value(typed.value(row));
    }
                                if !typed.is_null(i) {
        for i in 0..typed.len() {
    }
    }
};
        let element_type = element_type(arg_types).ok_or_else(|| {
            }
        let result = run(args, 1);
    Int16Builder, Int32Array, Int32Builder, Int64Array, Int64Builder, Int8Array, Int8Builder,
fn element_type(arg_types: &[DataType]) -> Option<DataType> {
    }
    }
            // operand) — DataFusion validates the actual output schema against the declared
                            );
                    if any_value {
        let result: ArrayRef = match &element_type {
use datafusion::logical_expr::{
//! silent coercion.
    fn drops_null_elements_inside_array() {
    any_value: &mut bool,
        .ok_or_else(|| {
    #[test]
                    let mut any_value = false;
        ];
    n: usize,
    out: &mut B,
        }
        }
            .unwrap();
//! vector type isn't covered surfaces as a planning error rather than a
            ColumnarValue::Array(a) => a,
    ColumnarValue, ScalarFunctionArgs, ScalarUDF, ScalarUDFImpl, Signature, Volatility,
/// Handles operands typed as Utf8, LargeUtf8, or Utf8View.
            .collect()
    fn extract_row_ints(arr: &ArrayRef, row: usize) -> Vec<i32> {
            if !large.is_null(i) {
impl StrAppend for StringBuilder {
use datafusion::arrow::datatypes::{DataType, Field};
    fn append_str(&mut self, s: &str) {
        // single E. Use whichever element type we see first.
                        {
        let arg_fields: Vec<Arc<Field>> = args
                args,
        })?;
    }
impl ScalarUDFImpl for MvappendUdf {
    #[test]
            return plan_err!("mvappend expects at least 1 argument, got 0");
                    }
        }
        if arg_types.is_empty() {
                                "mvappend: unexpected operand vector type {:?}",
 */
                            for i in 0..typed.len() {
        for arr in operand_arrays {
                        if arr.is_null(row) {
/// Trait abstracting the difference between {@link StringBuilder} and
        // Trust the Java adapter to have already coerced operands. coerce_types here
                            let typed =
        // Materialize each operand as an ArrayRef whose Arrow type is either
use datafusion::arrow::array::{
        }
                return plan_err!("mvappend: unsupported element type {other:?}");
    fn empty_array_in_args_contributes_nothing() {
                let mut builder = ListBuilder::new(inner);
        ];
    for row in 0..n {
                    })?;
    use datafusion::arrow::array::AsArray;
        let return_field = Arc::new(Field::new(
    fn all_null_args_yield_null_row() {
    builder: &mut ListBuilder<B>,
                build_string_rows::<StringBuilder>(&operand_arrays, n, &mut builder)?;
                                }
        let args = vec![
            .enumerate()
                            }
//!   * NULL argument → skipped entirely.
                build_string_rows::<StringViewBuilder>(&operand_arrays, n, &mut builder)?;
                    for e in *elems {
//! * For each argument, in order:
/// this glue lets {@link build_string_rows} drive either via the same code.
    }
                for row in 0..n {
    fn list_of_ints(rows: &[Option<&[Option<i32>]>]) -> ArrayRef {
                    let mut any_value = false;
    }
        }
}
        let mut builder = ListBuilder::new(Int32Builder::new());
        row_list.data_type()
        return Ok(());
}
                let dt = match cv {
            ColumnarValue::Scalar(ScalarValue::Int32(Some(3))),
    })
            DataType::List(Arc::new(Field::new("item", DataType::Int32, true))),
 *
        DataType::List(field) | DataType::LargeList(field) | DataType::FixedSizeList(field, _) => {
                        if let Some(list_arr) = arr.as_any().downcast_ref::<GenericListArray<i32>>()
                            builder.values().append_value(typed.value(row));
    }
                Arc::new(builder.finish()) as ArrayRef
        let operand_arrays: Vec<ArrayRef> = args
//! Mirrors PPL's [`MVAppendFunctionImpl`] / [`MVAppendCore`] semantics:
    arg_types.iter().find_map(|t| match t {
use datafusion::error::{DataFusionError, Result};
                arg_fields,
                                    builder.values().append_value(typed.value(i));
/// normalized everything to that single element type — either bare scalar or
}
impl Default for MvappendUdf {
impl MvappendUdf {
                        } else if let Some(typed) = arr.as_any().downcast_ref::<Decimal128Array>() {
        let inner = list.value(row);
    fn coerce_types(&self, arg_types: &[DataType]) -> Result<Vec<DataType>> {
                "mvappend: unable to determine element type from operand types".to_string(),
    Array, ArrayRef, AsArray, BooleanArray, BooleanBuilder, Decimal128Array, Decimal128Builder,
            .iter()
        match result {
                                    ))
        })?;
        if arg_types.is_empty() {
    row_list: &dyn Array,
                        }
                    builder.append(true);
        out.append_str(typed.value(row));
};
        return Ok(());
            DataType::UInt32 => build!(UInt32Builder, UInt32Array, ListArray),
/// Generic per-row writer for string-typed mvappend output. Dispatches list-child
                                arr.data_type()
        for i in 0..typed.len() {
            signature: Signature::user_defined(Volatility::Immutable),
    )
    if let Some(typed) = arr.as_any().downcast_ref::<StringArray>() {
        assert_eq!(extract_row_ints(&result, 0), vec![1, 2, 3]);
                    }
            // 52+), or a computed expression. The output type must match what {@code return_type}
        Self {
    ListArray, ListBuilder, StringArray, StringBuilder, StringViewArray, StringViewBuilder,
//!
}
    }
                config_options: Arc::new(datafusion::config::ConfigOptions::default()),
            DataType::Int64 => build!(Int64Builder, Int64Array, ListArray),
                }
#[cfg(test)]
        };
    signature: Signature,
//!
    fn three_scalar_ints() {
    use super::*;
                .arg_fields
                            any_value = true;
    #[test]
                                    any_value = true;
                *any_value = true;
            DataType::UInt8 => build!(UInt8Builder, UInt8Array, ListArray),
                                "mvappend: unexpected operand vector type {:?}",
            ColumnarValue::Scalar(ScalarValue::Int32(None)),
}
                        } else {
                        } else {
        // exists only because Signature::user_defined demands an implementation; we
            ColumnarValue::Array(arr),
            DataType::Int32 => build!(Int32Builder, Int32Array, ListArray),
    Ok(())
        *any_value = true;
                append_string_scalar(arr.as_ref(), row, builder.values(), &mut any_value)?;
//! handles each supported scalar Arrow type explicitly; a list whose data
                            // Iterate elements of the list at this row.
        assert_eq!(extract_row_ints(&result, 0), vec![1]);
}
            "item",
        }
                            continue;
            Some(field.data_type().clone())
            .map(|i| typed.value(i))
            if arr.is_null(row) {
}
//! into a single array, dropping null args AND null elements inside array args.
                                    DataFusionError::Internal(format!(
        let arr = list_of_ints(&[Some(&[Some(1), None, Some(2)])]);
                                }
        let result = MvappendUdf::new()
//! Mixed-type calls (`mvappend(1, 'text', 2.5)`) end up with Calcite type
            element_type,
pub fn register_all(ctx: &SessionContext) {
            builder.append_null();
            )
        let args = vec![
    }
                }
            }
                Arc::new(builder.finish()) as ArrayRef
                        DataFusionError::Plan(format!("mvappend: decimal builder: {e}"))
    out: &mut B,
                                        row_list.data_type()
            }
            ColumnarValue::Scalar(ScalarValue::Int32(None)),
    }
            if !typed.is_null(i) {
        assert!(list.is_null(0));
            // produces DECIMAL(p, s) which substrait converts to Decimal128(p, s); the Java
/// computed expressions as {@code Utf8} or {@code LargeUtf8}.
    fn append_str(&mut self, s: &str);
    plan_err!(
        ];
//!   distinguishes `mvappend(null)` from `mvappend()` from `mvappend([])`).
        *any_value = true;
            true,
        }
            // declared (which is whatever {@code element_type()} returned, driven by the first
                Arc::new(Field::new(format!("a{i}"), dt, true))
                            let row_list = list_arr.value(row);
            // {Utf8, LargeUtf8, Utf8View} depending on whether the operand is a string literal,
    fn signature(&self) -> &Signature {
    if let Some(typed) = row_list.as_any().downcast_ref::<StringArray>() {
        }
            })
                                        "mvappend: list element vector type mismatch ({:?})",
                            return plan_err!(
//! `mvappend(arg1, arg2, …)` — flatten a mixed list of array and scalar args
                        if let Some(list_arr) = arr.as_any().downcast_ref::<GenericListArray<i32>>()
                        builder.append_null();
        ];
        // Java adapter pre-coerces every operand to either ARRAY<E> or E for a
                                row_list.as_any().downcast_ref::<$Scalar>().ok_or_else(|| {
            true,
                            }
        self.append_value(s);
            DataType::Int8 => build!(Int8Builder, Int8Array, ListArray),
        let args = vec![
                let row_list = list_arr.value(row);
                    }
                }
                Some(elems) => {
            }
        other => Some(other.clone()),
            .collect::<Result<Vec<_>>>()?;
    #[test]
            }
        // mvappend(NULL, 1, 2) → [1, 2]
                *any_value = true;
        let result = run(args, 1);
            // and scale as the input. Calcite's leastRestrictive widening for INT + DECIMAL
    fn return_type(&self, arg_types: &[DataType]) -> Result<DataType> {
            .args
            ColumnarValue::Scalar(ScalarValue::Int32(Some(1))),
                    }
            DataType::Float64 => build!(Float64Builder, Float64Array, ListArray),
                        builder.append(true);
    arr: &dyn Array,
    }
        let result = run(args, 1);
        // mvappend(1, 2, 3) → [1, 2, 3]
    fn name(&self) -> &str {
            other => {
    }
//! substrait conversion, before reaching this UDF, and aren't addressed here.
            .invoke_with_args(ScalarFunctionArgs {
            DataFusionError::Plan(
 * The OpenSearch Contributors require contributions made to
        self.append_value(s);
        ];
        let n = args.number_rows;
                Arc::new(builder.finish()) as ArrayRef
        }
                let inner = Decimal128Builder::new()
            }
                        if arr.is_null(row) {
    plan_err!(
        return Ok(());
        for row in rows {
        let list = arr.as_any().downcast_ref::<ListArray>().unwrap();
                    if any_value {
            DataType::UInt64 => build!(UInt64Builder, UInt64Array, ListArray),
                out.append_str(large.value(i));
        return Ok(());
                                })?;
#[derive(Debug, PartialEq, Eq, Hash)]
    }
                        match e {
    }
        arr.data_type()
    #[test]
        let arr = list_of_ints(&[Some(&[])]);
                            let row_list = list_arr.value(row);
                out.append_str(typed.value(i));
/*
            ($Builder:ty, $Scalar:ty, $List:ty) => {{
        "mvappend: list element vector type mismatch — expected string, got {:?}",
                        }
                                    DataFusionError::Internal(format!(
            DataType::Utf8 | DataType::LargeUtf8 => {
    operand_arrays: &[ArrayRef],
        assert_eq!(extract_row_ints(&result, 0), vec![1, 2]);
                                .ok_or_else(|| {
        Arc::new(builder.finish())
    )
        let result = run(args, 1);
            ColumnarValue::Scalar(ScalarValue::Int32(Some(2))),
            // adapter's CAST aligns every operand's element type to that.
            // a field read (DataFusion's substrait consumer uses Utf8View for column reads in
        let typed = inner.as_primitive::<datafusion::arrow::datatypes::Int32Type>();
        }
/// First operand type drives the element type. The Java adapter has already
                        }
                            return plan_err!(
        // mvappend([1, NULL, 2], 3) → [1, 2, 3]
    }
        &self.signature
            ColumnarValue::Scalar(ScalarValue::Int32(Some(3))),
                    for arr in &operand_arrays {
    ctx.register_udf(ScalarUDF::from(MvappendUdf::new()));
            }
/// `append_value(&str)`, but they're concrete types with no shared trait, so
        macro_rules! build {
    }
    any_value: &mut bool,
            // Decimal128 element type — needs a builder configured with the same precision
            DataType::Int16 => build!(Int16Builder, Int16Array, ListArray),
    }
                                    builder.values().append_value(typed.value(i));
                append_string_elements(row_list.as_ref(), builder.values(), &mut any_value)?;
//! * Returns NULL if no non-null elements were collected (PPL convention —
                };
                            for i in 0..typed.len() {
                    ColumnarValue::Scalar(sv) => sv.data_type(),
//! `ARRAY<componentType>` before this UDF runs, so by the time we see operands
                out.append_str(typed.value(i));
        let mut any_value = false;
                .iter()
        Ok(arg_types.to_vec())
//! they share a single element type. The element-conversion macro below
            DataType::Utf8View => {
            } else {
        ))))
        ];
            DataType::Boolean => build!(BooleanBuilder, BooleanArray, ListArray),
            .map(|a| a.clone().into_array(n))
            .filter(|i| !typed.is_null(*i))
    }
    fn flattens_array_argument() {
                                arr.data_type()
                            let typed = row_list
}
            return vec![];
        if any_value {
    fn drops_null_arg() {
            ColumnarValue::Scalar(ScalarValue::Int32(None)),
                                .as_any()
                                        "mvappend: list element vector type mismatch ({:?})",
            if !typed.is_null(i) {
                        }
            DataFusionError::Internal("mvappend: lost element type at invoke".to_string())
                                if !typed.is_null(i) {
        "mvappend: scalar operand vector type mismatch — expected string, got {:?}",
            ColumnarValue::Scalar(ScalarValue::Int32(Some(2))),
    if let Some(typed) = row_list.as_any().downcast_ref::<StringViewArray>() {
            ColumnarValue::Scalar(ScalarValue::Int32(Some(1))),
        )
        let element_type = element_type(
        let args = vec![
}
                *any_value = true;
fn build_string_rows<B: StrAppend + datafusion::arrow::array::ArrayBuilder>(
        "mvappend"
    }
    fn invoke_with_args(&self, args: ScalarFunctionArgs) -> Result<ColumnarValue> {
        *any_value = true;
        let args = vec![
                                .downcast_ref::<Decimal128Array>()
}
                                    ))
            }
        return Ok(());
        } else {
    fn default() -> Self {
/// match arm in {@link MvappendUdf::invoke_with_args} catches every flavor —
                .map(|f| f.data_type().clone())
            match row {
            .map(|(i, cv)| {
        // mvappend([], 1) → [1]
) -> Result<()> {
                    .with_precision_and_scale(*precision, *scale)
impl StrAppend for StringViewBuilder {
                    }
                        } else if let Some(typed) = arr.as_any().downcast_ref::<$Scalar>() {
/// output type.
fn append_string_elements<B: StrAppend>(
fn append_string_scalar<B: StrAppend>(
    pub fn new() -> Self {
        }
}
        assert_eq!(extract_row_ints(&result, 0), vec![1, 2, 3]);
            DataType::Decimal128(precision, scale) => {
        Ok(DataType::List(Arc::new(Field::new(
}
            builder.append(true);
            ColumnarValue::Scalar(_) => panic!("expected array"),
    #[test]
/// Append a single scalar string operand at the given row to the output builder.
                for row in 0..n {
            // schema and rejects mismatches with "column types must match schema types".
    if let Some(typed) = arr.as_any().downcast_ref::<StringViewArray>() {
            .iter()
                continue;
                None => builder.append_null(),
    if let Some(large) = row_list.as_string_opt::<i64>() {
                let mut builder = ListBuilder::new(StringBuilder::new());
                .collect::<Vec<_>>(),
/// downcasts across all three Utf8 flavors so the input doesn't need to match the
    if let Some(large) = arr.as_string_opt::<i64>() {
        }
                            );
            ColumnarValue::Scalar(ScalarValue::Int32(Some(1))),
                    } else {
        (0..typed.len())
//!
        }
//! call's array component type and every array argument to
trait StrAppend {
//!   * Array argument → each non-null element is appended to the output.
    fn append_str(&mut self, s: &str) {
            DataType::Float32 => build!(Float32Builder, Float32Array, ListArray),
            ColumnarValue::Array(arr),
        Ok(ColumnarValue::Array(result))
        // {element_type} or List<element_type>. Scalar operands replicate to n rows.
            return plan_err!("mvappend expects at least 1 argument, got 0");
use std::sync::Arc;
        for i in 0..large.len() {
mod tests {
//! ## Type homogeneity
            })
                let mut builder = ListBuilder::new(StringViewBuilder::new());
    Float32Array, Float32Builder, Float64Array, Float64Builder, GenericListArray, Int16Array,
 * this file be licensed under the Apache-2.0 license or a
pub struct MvappendUdf {
                                })?;
        let result = run(args, 1);
                        }
                        {
