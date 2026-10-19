    fn integer_arrays_are_stringified() {
        let left = list_of_strings(&[None]);
            // handles the dispatch for us.
//!   `Objects.toString(elem, "")`), so `mvzip([1, NULL], ["a", "b"])` yields
use datafusion::execution::context::SessionContext;
    }
use datafusion::arrow::datatypes::{DataType, Field};
//! `mvzip(left, right [, separator])` — element-wise zip of two arrays into an
        DataType::Boolean => collect!(BooleanArray, |v: bool| v.to_string()),
    }
        Arc::new(builder.finish())
        let n = left.len();
                    DataFusionError::Internal(format!(
            // emit None for each. Reachable when the input list is empty and its
        let left = downcast_list(&left_arr, "left")?;
        let right_arr = args.args[1].clone().into_array(n)?;
    Array, ArrayRef, AsArray, BooleanArray, Float32Array, Float64Array, GenericListArray,
        }
                    out.push(Some($fmt(typed.value(i))));
 * this file be licensed under the Apache-2.0 license or a
    fn coerce_types(&self, arg_types: &[DataType]) -> Result<Vec<DataType>> {
//! Mirrors PPL's [`MVZipFunctionImpl`] semantics:
    macro_rules! collect {
        DataType::UInt32 => collect!(UInt32Array, |v: u32| v.to_string()),
 */
                        "mvzip: string element downcast failed for {:?}",
        }};
            let right_row = right.value(i);
}
            _ => None,
//! * Element NULLs are rendered as empty strings (matches the SQL plugin's
                args,
    }
            true,
            return plan_err!("mvzip expects 2 or 3 arguments, got {}", arg_types.len());
            } else {
            }
            ))
/*
fn downcast_list<'a>(arr: &'a ArrayRef, slot: &str) -> Result<&'a ListArray> {
 * SPDX-License-Identifier: Apache-2.0
        .ok_or_else(|| {
    fn truncate_to_shorter_array() {
fn elements_as_strings(arr: &dyn Array) -> Result<Vec<Option<String>>> {
 * compatible open source license.
        "mvzip"
    fn run(left: ArrayRef, right: ArrayRef, sep: Option<&str>) -> ArrayRef {
};
    let mut out: Vec<Option<String>> = Vec::with_capacity(n);
        assert_eq!(extract_row_strings(&result, 0), Vec::<String>::new());
        let left = list_of_strings(&[Some(&[])]);
                builder.values().append_value(joined);
}
                joined.push_str(r);
        let left_arr = args.args[0].clone().into_array(n)?;
                None => builder.append_null(),
                })?
//! * Result length is `min(len(left), len(right))` (Python-`zip` truncation).
        }
    }
            ColumnarValue::Array(right.clone()),
                    "mvzip: failed to downcast element vector to {}",
//!
            for _ in 0..n {
use std::sync::Arc;
//! substrait emission.
        let left = list_of_ints(&[Some(&[Some(10), Some(20)])]);
                let large = arr.as_string_opt::<i64>().ok_or_else(|| {
        for row in rows {
/// (NULL scalar, column-valued, or non-string types).
                return_field,
                arr.data_type()
//! * The separator is a Utf8 scalar. Calling it as a column would require
            ColumnarValue::Array(left.clone()),
                    for e in *elems {
        // ColumnarValue::into_array handles them by replicating to {row count}.
}
        };
                continue;
                    }
    }
    Ok(out)
            signature: Signature::user_defined(Volatility::Immutable),
#[derive(Debug, PartialEq, Eq, Hash)]
            match &arg_types[2] {
//!   `["1,a", ",b"]`.
        let left = list_of_strings(&[Some(&[Some("a"), Some("b"), Some("c")])]);
                joined.push_str(&separator);
            }
    arr.as_any()
                arg_fields,
        }
    pub fn new() -> Self {
    }
        DataType::Int8 => collect!(Int8Array, |v: i8| v.to_string()),
            let s = arr.as_string_opt::<i32>();
        let list = result.as_any().downcast_ref::<ListArray>().unwrap();
            for i in 0..n {
        ));
                let l = left_strs[j].as_deref().unwrap_or("");
        }
        let right = downcast_list(&right_arr, "right")?;
            let take = left_row.len().min(right_row.len());
    }
    fn extract_row_strings(arr: &ArrayRef, row: usize) -> Vec<String> {
            }
    #[test]
        }
                }
    fn basic_two_string_arrays_with_default_separator() {
        DataType::Int16 => collect!(Int16Array, |v: i16| v.to_string()),
        DataType::UInt16 => collect!(UInt16Array, |v: u16| v.to_string()),
        let result = run(left, right, Some("-"));
                    coerced.push(DataType::Utf8)
            DataType::List(Arc::new(Field::new("item", DataType::Utf8, true))),
        let result = MvzipUdf::new()
            })?;
            .collect();
    }
        DataType::Int32 => collect!(Int32Array, |v: i32| v.to_string()),
        ))))
                }
        assert_eq!(extract_row_strings(&result, 0), vec!["10,1", "20,2"]);
                } else {
        DataType::UInt64 => collect!(UInt64Array, |v: u64| v.to_string()),
        }
                Some(elems) => {
        }
                        arr.data_type()
//! array of strings, joined per pair by a separator (default `,`).
                    } else {
                .ok_or_else(|| {
    }
                            None => builder.values().append_null(),
#[cfg(test)]
//! * Either array NULL → NULL result.
            args.push(ColumnarValue::Scalar(ScalarValue::Utf8(Some(
        let result = run(left, right, None);
        let return_field = Arc::new(Field::new(
        if args.args.len() != 2 && args.args.len() != 3 {
                "mvzip: unsupported list element type {other:?}"
        let mut builder = ListBuilder::new(StringBuilder::new());
            return Err(DataFusionError::NotImplemented(format!(
/// the empty string).
        } else {
        assert_eq!(extract_row_strings(&result, 0), vec!["a,1"]);
}
    use super::*;
            match row {
            | ScalarValue::Utf8View(Some(s)) => Some(s.as_str()),
        let right = list_of_ints(&[Some(&[Some(1), Some(2)])]);
            }
    }
        if arg_types.len() == 3 {
    if let ColumnarValue::Scalar(sv) = cv {
}
use datafusion::common::{plan_err, ScalarValue};
                        out.push(None);
                        match e {
//! Result type is `List<Utf8>` regardless of the input element types — `mvzip`
            .enumerate()
    }
            }
        DataType::Int64 => collect!(Int64Array, |v: i64| v.to_string()),
    fn signature(&self) -> &Signature {
                        }
            "item",
        })
        let right = list_of_strings(&[Some(&[Some("1")])]);
    let n = arr.len();
/// canonical string form (matching `Objects.toString(elem, "")` semantics on
            match row {
                config_options: Arc::new(datafusion::config::ConfigOptions::default()),
                builder.append_null();
                }
        // Materialize left/right as ListArrays. Scalar list operands are unusual but
                .to_string()
                }
                for i in 0..n {
    use datafusion::arrow::array::Int32Builder;
            }
            ColumnarValue::Array(a) => a,
    ctx.register_udf(ScalarUDF::from(MvzipUdf::new()));
                        }
                t,
                    builder.append(true);
 *
                number_rows: n,
                })?;
            if left.is_null(i) || right.is_null(i) {
    fn default() -> Self {
            .invoke_with_args(ScalarFunctionArgs {
    }
                if typed.is_null(i) {
                }
        Self {
        // user_defined lets us accept ListArray with any element type and a
            // before the SQL-plugin VARCHAR-default kicks in).
                }
        None
        ];
        let result = run(left, right, None);
    #[test]
use datafusion::error::{DataFusionError, Result};
                out.push(None);
        DataType::UInt8 => collect!(UInt8Array, |v: u8| v.to_string()),
    fn null_element_renders_as_empty_string() {
        let right = list_of_strings(&[Some(&[Some("1"), Some("2")])]);
pub fn register_all(ctx: &SessionContext) {
        Ok(ColumnarValue::Array(Arc::new(builder.finish()) as ArrayRef))
    }
            // String children may arrive as any of the three Utf8 flavors; AsArray
impl MvzipUdf {
    }
//!
                    out.push(None);
        }
            scalar_string(&args.args[2])
        let mut builder = ListBuilder::new(ArrowStringBuilder::new());
        &self.signature
        for i in 0..n {
    StringBuilder, UInt16Array, UInt32Array, UInt64Array, UInt8Array,
            "out",
        let right = list_of_strings(&[Some(&[Some("1"), Some("2")])]);
            if !matches!(
//!   constrain to scalars here and produce a planning error otherwise.
//!   per-row materialization; PPL's surface only exposes a literal so we
                other => {
impl ScalarUDFImpl for MvzipUdf {
        ($A:ty, $fmt:expr) => {{
        let mut coerced: Vec<DataType> = arg_types[..2].to_vec();
                let mut joined = String::with_capacity(l.len() + separator.len() + r.len());
                for i in 0..n {
            let typed = arr.as_any().downcast_ref::<$A>().ok_or_else(|| {
        }
                DataType::Utf8 | DataType::LargeUtf8 | DataType::Utf8View => {
        }
        Self::new()
                "mvzip: {slot} expected ListArray, got {:?}",
        assert_eq!(extract_row_strings(&result, 0), vec!["a,1", ",2"]);
                        out.push(Some(large.value(i).to_string()));
use datafusion::logical_expr::{
            ScalarValue::Utf8(Some(s))
            DataFusionError::Internal(format!(
                return plan_err!("mvzip: arg {i} expected list type, got {t:?}");
            let left_row = left.value(i);
    use datafusion::arrow::array::StringBuilder as ArrowStringBuilder;
        assert_eq!(extract_row_strings(&result, 0), vec!["x-1", "y-2"]);
                let r = right_strs[j].as_deref().unwrap_or("");
};
            // Element vector with Null type — every cell is NULL by definition, so
        }
        let left = list_of_strings(&[Some(&[Some("a"), None])]);
    signature: Signature,
    }
                joined.push_str(l);
                    }
            .iter()
                ))
            DataType::Utf8,
        let right = list_of_strings(&[Some(&[Some("1"), Some("2")])]);
        let separator: String = if args.args.len() == 3 {
                    if typed.is_null(i) {
                    }
    }
                s.to_string(),
                DataFusionError::Internal(format!(
                            None => builder.values().append_null(),
        Ok(coerced)
            }
    } else {
        // Output: List<Utf8>, one row per input row.
            })
                    } else {
    }
                    ))
        let inner = list.value(row);
        // string separator without enumerating every concrete combination.
                    builder.append(true);
            let right_strs = elements_as_strings(right_row.as_ref())?;
    fn name(&self) -> &str {
        let result = run(left, right, None);
//! `opensearch_array_functions.yaml` declaration to type the call before
            // declared element type is Null/UNKNOWN (e.g. PPL `array()` no-arg
            if let Some(typed) = s {
            .map(|(i, _)| Arc::new(Field::new(format!("a{i}"), DataType::Utf8, true)))
/// the SQL plugin side — NULL elements become None which the caller renders as
                    return plan_err!("mvzip: arg 2 (separator) expected string, got {other:?}")
            for j in 0..take {
    fn empty_array_yields_empty_result() {
    }
    fn custom_separator() {
        let left = list_of_strings(&[Some(&[Some("a"), Some("b")])]);
}
        assert_eq!(extract_row_strings(&result, 0), vec!["a,1", "b,2"]);
        DataType::Null => {
    fn invoke_with_args(&self, args: ScalarFunctionArgs) -> Result<ColumnarValue> {
        DataType::Float32 => collect!(Float32Array, |v: f32| v.to_string()),
            ))));
        let left = list_of_strings(&[Some(&[Some("x"), Some("y")])]);
                }
}
            true,
        DataType::Float64 => collect!(Float64Array, |v: f64| v.to_string()),
            ColumnarValue::Scalar(_) => panic!("expected array"),
        if arg_types.len() != 2 && arg_types.len() != 3 {
fn scalar_string(cv: &ColumnarValue) -> Option<&str> {
    fn list_of_strings(rows: &[Option<&[Option<&str>]>]) -> ArrayRef {
            return plan_err!("mvzip expects 2 or 3 arguments, got {}", arg_types.len());
//!
        }
        assert!(list.is_null(0));
            ",".to_string()
                            Some(s) => builder.values().append_value(s),
    fn return_type(&self, arg_types: &[DataType]) -> Result<DataType> {
    fn list_of_ints(rows: &[Option<&[Option<i32>]>]) -> ArrayRef {
            }
        for row in rows {
                        "mvzip: separator must be a non-NULL string scalar literal".to_string(),
                        out.push(None);
        match result {
                DataType::List(_) | DataType::LargeList(_) | DataType::FixedSizeList(_, _)
        }
}
    #[test]
        .downcast_ref::<GenericListArray<i32>>()
        let result = run(left, right, None);
        let strs = inner.as_string::<i32>();
                    if large.is_null(i) {
        let list = arr.as_any().downcast_ref::<ListArray>().unwrap();
    }
                None => builder.append_null(),
mod tests {
            )));
                    stringify!($A)
        }
    #[test]
        let n = args.number_rows;
    Int16Array, Int32Array, Int64Array, Int8Array, ListArray, ListBuilder, StringArray,
pub struct MvzipUdf {
        let mut args = vec![
/// Extract a non-NULL Utf8 scalar literal, or return None for everything else
            builder.append(true);
}
        let result = run(left, right, None);
                    for e in *elems {
    #[test]
        match sv {
//! is fundamentally a string-formatting operation. The Java side relies on the
        (0..strs.len()).map(|i| strs.value(i).to_string()).collect()
    }
impl Default for MvzipUdf {
use datafusion::arrow::array::{
        let right = list_of_strings(&[Some(&[Some("1")])]);
            | ScalarValue::LargeUtf8(Some(s))
    ColumnarValue, ScalarFunctionArgs, ScalarUDF, ScalarUDFImpl, Signature, Volatility,
        for (i, t) in arg_types.iter().take(2).enumerate() {
                    }
    #[test]
/// Convert each element of an Arrow array of any supported scalar type to its
 * The OpenSearch Contributors require contributions made to
                            Some(v) => builder.values().append_value(*v),
        DataType::Utf8 | DataType::LargeUtf8 | DataType::Utf8View => {
        let result = run(left, right, None);
        if arg_types.len() != 2 && arg_types.len() != 3 {
                        out.push(Some(typed.value(i).to_string()));
        let mut builder = ListBuilder::new(Int32Builder::new());
        let arg_fields: Vec<Arc<Field>> = args
    fn null_array_yields_null_row() {
                Some(elems) => {
            }
                        match e {
        Ok(DataType::List(Arc::new(Field::new(
    }
        other => {
        }
    match arr.data_type() {
        Arc::new(builder.finish())
    #[test]
        if let Some(s) = sep {
                    )
            ) {
            return plan_err!("mvzip expects 2 or 3 arguments, got {}", args.args.len());
        let right = list_of_strings(&[Some(&[Some("1")])]);
                    DataFusionError::Plan(
            .unwrap();
            let left_strs = elements_as_strings(left_row.as_ref())?;
