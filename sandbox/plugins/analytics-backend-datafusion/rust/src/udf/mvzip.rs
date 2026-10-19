            ColumnarValue::Array(left.clone()),
#[cfg(test)]
        "mvzip"
        let right = list_of_strings(&[Some(&[Some("1"), Some("2")])]);
        assert_eq!(extract_row_strings(&result, 0), Vec::<String>::new());
impl ScalarUDFImpl for MvzipUdf {
        let arg_fields: Vec<Arc<Field>> = args
        let right = list_of_strings(&[Some(&[Some("1"), Some("2")])]);
        for i in 0..n {
    }
        ($A:ty, $fmt:expr) => {{
                args,
                        out.push(None);
        }};
        let left = list_of_strings(&[Some(&[Some("a"), Some("b"), Some("c")])]);
    use super::*;
            }
            }
            _ => None,
                        match e {
                let large = arr.as_string_opt::<i64>().ok_or_else(|| {
//!
use datafusion::arrow::array::{
            match row {
    match arr.data_type() {
        let n = args.number_rows;
                let mut joined = String::with_capacity(l.len() + separator.len() + r.len());
                })?
    }
        let mut args = vec![
pub struct MvzipUdf {
        DataType::Null => {
        for row in rows {
            ))
        Ok(ColumnarValue::Array(Arc::new(builder.finish()) as ArrayRef))
                ))
                return plan_err!("mvzip: arg {i} expected list type, got {t:?}");
                joined.push_str(l);
                return_field,
            }
                other => {
    }
    use datafusion::arrow::array::StringBuilder as ArrowStringBuilder;
 * this file be licensed under the Apache-2.0 license or a
    fn signature(&self) -> &Signature {
                    "mvzip: failed to downcast element vector to {}",
            let typed = arr.as_any().downcast_ref::<$A>().ok_or_else(|| {
        let mut builder = ListBuilder::new(ArrowStringBuilder::new());
            for j in 0..take {
        }
    pub fn new() -> Self {
            )));
 * SPDX-License-Identifier: Apache-2.0
            scalar_string(&args.args[2])
            DataFusionError::Internal(format!(
        (0..strs.len()).map(|i| strs.value(i).to_string()).collect()
            // emit None for each. Reachable when the input list is empty and its
            }
        let result = run(left, right, None);
        ))))
                        }
        }
        }
        DataType::Int8 => collect!(Int8Array, |v: i8| v.to_string()),
            for i in 0..n {
    fn truncate_to_shorter_array() {
                    }
        assert_eq!(extract_row_strings(&result, 0), vec!["a,1", ",2"]);
            "out",
    fn empty_array_yields_empty_result() {
    }
        let list = arr.as_any().downcast_ref::<ListArray>().unwrap();
        let result = run(left, right, None);
    }
//! Result type is `List<Utf8>` regardless of the input element types — `mvzip`
            ColumnarValue::Array(right.clone()),
        }
        // Output: List<Utf8>, one row per input row.
            ScalarValue::Utf8(Some(s))
//! is fundamentally a string-formatting operation. The Java side relies on the
                "mvzip: {slot} expected ListArray, got {:?}",
        // ColumnarValue::into_array handles them by replicating to {row count}.
    let mut out: Vec<Option<String>> = Vec::with_capacity(n);
        ];
        let left = list_of_strings(&[Some(&[])]);
        let right = list_of_strings(&[Some(&[Some("1")])]);
                out.push(None);
    }
fn elements_as_strings(arr: &dyn Array) -> Result<Vec<Option<String>>> {
                builder.values().append_value(joined);
                .to_string()
    }
    }
                    coerced.push(DataType::Utf8)
        assert_eq!(extract_row_strings(&result, 0), vec!["10,1", "20,2"]);
                    ))
 * compatible open source license.
        if arg_types.len() != 2 && arg_types.len() != 3 {
        let return_field = Arc::new(Field::new(
/// the SQL plugin side — NULL elements become None which the caller renders as
        let left = list_of_strings(&[Some(&[Some("x"), Some("y")])]);
        let result = run(left, right, None);
        DataType::Utf8 | DataType::LargeUtf8 | DataType::Utf8View => {
                "mvzip: unsupported list element type {other:?}"
                        "mvzip: separator must be a non-NULL string scalar literal".to_string(),
                        }
//! `opensearch_array_functions.yaml` declaration to type the call before
            if !matches!(
        DataType::UInt16 => collect!(UInt16Array, |v: u16| v.to_string()),
        Self {
        }
//!
                    DataFusionError::Plan(
                    builder.append(true);
                t,
    fn invoke_with_args(&self, args: ScalarFunctionArgs) -> Result<ColumnarValue> {
            let s = arr.as_string_opt::<i32>();
        }
/// (NULL scalar, column-valued, or non-string types).
        match sv {
                DataType::List(_) | DataType::LargeList(_) | DataType::FixedSizeList(_, _)
        assert_eq!(extract_row_strings(&result, 0), vec!["a,1"]);
            .invoke_with_args(ScalarFunctionArgs {
//!   constrain to scalars here and produce a planning error otherwise.
                }
        match result {
        DataType::Boolean => collect!(BooleanArray, |v: bool| v.to_string()),
}
                    )
        let separator: String = if args.args.len() == 3 {
    #[test]
            }
            }
    }
        }
mod tests {
    #[test]
                s.to_string(),
        Self::new()
        let n = left.len();
/*
//! * The separator is a Utf8 scalar. Calling it as a column would require
            return plan_err!("mvzip expects 2 or 3 arguments, got {}", arg_types.len());
                arg_fields,
        };
                }
            ) {
        if arg_types.len() == 3 {
}
        if let Some(s) = sep {
        let left_arr = args.args[0].clone().into_array(n)?;
};
            .unwrap();
fn scalar_string(cv: &ColumnarValue) -> Option<&str> {
//! `mvzip(left, right [, separator])` — element-wise zip of two arrays into an
    fn name(&self) -> &str {
            // String children may arrive as any of the three Utf8 flavors; AsArray
/// Convert each element of an Arrow array of any supported scalar type to its
use datafusion::error::{DataFusionError, Result};
    Ok(out)
        }
    fn custom_separator() {
                if typed.is_null(i) {
            ))));
            .enumerate()
        let right_arr = args.args[1].clone().into_array(n)?;
                    builder.append(true);
}
        DataType::Int16 => collect!(Int16Array, |v: i16| v.to_string()),
        }
        for row in rows {
            let left_row = left.value(i);
            return plan_err!("mvzip expects 2 or 3 arguments, got {}", args.args.len());
    fn null_array_yields_null_row() {
        DataType::Float32 => collect!(Float32Array, |v: f32| v.to_string()),
//! Mirrors PPL's [`MVZipFunctionImpl`] semantics:
    Int16Array, Int32Array, Int64Array, Int8Array, ListArray, ListBuilder, StringArray,
                        "mvzip: string element downcast failed for {:?}",
    if let ColumnarValue::Scalar(sv) = cv {
}
/// the empty string).
            | ScalarValue::Utf8View(Some(s)) => Some(s.as_str()),
use datafusion::logical_expr::{
            .iter()
            }
                    } else {
    }
    fn basic_two_string_arrays_with_default_separator() {
        let right = downcast_list(&right_arr, "right")?;
        let right = list_of_strings(&[Some(&[Some("1"), Some("2")])]);
                    if typed.is_null(i) {
            // before the SQL-plugin VARCHAR-default kicks in).
                    for e in *elems {
/// canonical string form (matching `Objects.toString(elem, "")` semantics on
        assert_eq!(extract_row_strings(&result, 0), vec!["a,1", "b,2"]);
//! * Result length is `min(len(left), len(right))` (Python-`zip` truncation).
        let result = MvzipUdf::new()
    arr.as_any()
        let left = list_of_strings(&[Some(&[Some("a"), None])]);
                }
        }
        }
        other => {
            if let Some(typed) = s {
                    }
                }
            let right_row = right.value(i);
        let mut builder = ListBuilder::new(Int32Builder::new());
    fn extract_row_strings(arr: &ArrayRef, row: usize) -> Vec<String> {
    }
        let mut coerced: Vec<DataType> = arg_types[..2].to_vec();
            // declared element type is Null/UNKNOWN (e.g. PPL `array()` no-arg
                } else {
//! * Either array NULL → NULL result.
                builder.append_null();
        Arc::new(builder.finish())
        let right = list_of_strings(&[Some(&[Some("1")])]);
 * The OpenSearch Contributors require contributions made to
            | ScalarValue::LargeUtf8(Some(s))
    }
        .downcast_ref::<GenericListArray<i32>>()
        let result = run(left, right, None);
//!   per-row materialization; PPL's surface only exposes a literal so we
            })
        let right = list_of_ints(&[Some(&[Some(1), Some(2)])]);
        Ok(coerced)
        let result = run(left, right, None);
    fn return_type(&self, arg_types: &[DataType]) -> Result<DataType> {
        DataType::Float64 => collect!(Float64Array, |v: f64| v.to_string()),
    #[test]
                    out.push(None);
            args.push(ColumnarValue::Scalar(ScalarValue::Utf8(Some(
        assert!(list.is_null(0));
            .map(|(i, _)| Arc::new(Field::new(format!("a{i}"), DataType::Utf8, true)))
                    stringify!($A)
            // Element vector with Null type — every cell is NULL by definition, so
    signature: Signature,
            let right_strs = elements_as_strings(right_row.as_ref())?;
    fn list_of_strings(rows: &[Option<&[Option<&str>]>]) -> ArrayRef {
    }
        for (i, t) in arg_types.iter().take(2).enumerate() {
                arr.data_type()
/// Extract a non-NULL Utf8 scalar literal, or return None for everything else
        let left = downcast_list(&left_arr, "left")?;
    }
        &self.signature
    macro_rules! collect {
            for _ in 0..n {
    }
            // handles the dispatch for us.
                        out.push(Some(large.value(i).to_string()));
        DataType::Int64 => collect!(Int64Array, |v: i64| v.to_string()),
                            Some(v) => builder.values().append_value(*v),
        }
            DataType::List(Arc::new(Field::new("item", DataType::Utf8, true))),
        .ok_or_else(|| {
            ColumnarValue::Array(a) => a,
                for i in 0..n {
        let mut builder = ListBuilder::new(StringBuilder::new());
//! substrait emission.
    fn run(left: ArrayRef, right: ArrayRef, sep: Option<&str>) -> ArrayRef {
    #[test]
    }
            match row {
            })?;
                    } else {
//!   `["1,a", ",b"]`.
                continue;
                        match e {
                })?;
#[derive(Debug, PartialEq, Eq, Hash)]
                }
        let left = list_of_ints(&[Some(&[Some(10), Some(20)])]);
    fn default() -> Self {
}
    let n = arr.len();
        } else {
use datafusion::arrow::datatypes::{DataType, Field};
                            None => builder.values().append_null(),
    }
            true,
        let inner = list.value(row);
                    for e in *elems {
            .collect();
                            None => builder.values().append_null(),
}
    }
};
    use datafusion::arrow::array::Int32Builder;
            ColumnarValue::Scalar(_) => panic!("expected array"),
        let right = list_of_strings(&[Some(&[Some("1")])]);
    #[test]
    #[test]
        }
    StringBuilder, UInt16Array, UInt32Array, UInt64Array, UInt8Array,
                None => builder.append_null(),
//! * Element NULLs are rendered as empty strings (matches the SQL plugin's
            true,
        Ok(DataType::List(Arc::new(Field::new(
                config_options: Arc::new(datafusion::config::ConfigOptions::default()),
    fn list_of_ints(rows: &[Option<&[Option<i32>]>]) -> ArrayRef {
            return Err(DataFusionError::NotImplemented(format!(
fn downcast_list<'a>(arr: &'a ArrayRef, slot: &str) -> Result<&'a ListArray> {
                let r = right_strs[j].as_deref().unwrap_or("");
impl Default for MvzipUdf {
        DataType::Int32 => collect!(Int32Array, |v: i32| v.to_string()),
                number_rows: n,
                Some(elems) => {
                }
use std::sync::Arc;
                joined.push_str(r);
    ctx.register_udf(ScalarUDF::from(MvzipUdf::new()));
//!   `Objects.toString(elem, "")`), so `mvzip([1, NULL], ["a", "b"])` yields
                for i in 0..n {
        let left = list_of_strings(&[Some(&[Some("a"), Some("b")])]);
        ));
            }
    ColumnarValue, ScalarFunctionArgs, ScalarUDF, ScalarUDFImpl, Signature, Volatility,
                    }
        Arc::new(builder.finish())
                    return plan_err!("mvzip: arg 2 (separator) expected string, got {other:?}")
            }
            } else {
        None
        // user_defined lets us accept ListArray with any element type and a
        let strs = inner.as_string::<i32>();
 *
use datafusion::execution::context::SessionContext;
        let left = list_of_strings(&[None]);
    #[test]
                        arr.data_type()
pub fn register_all(ctx: &SessionContext) {
        let list = result.as_any().downcast_ref::<ListArray>().unwrap();
    }
                            Some(s) => builder.values().append_value(s),
                let l = left_strs[j].as_deref().unwrap_or("");
            "item",
            signature: Signature::user_defined(Volatility::Immutable),
    fn null_element_renders_as_empty_string() {
                        out.push(None);
//!
        DataType::UInt32 => collect!(UInt32Array, |v: u32| v.to_string()),
    fn integer_arrays_are_stringified() {
                None => builder.append_null(),
    }
                joined.push_str(&separator);
        let result = run(left, right, None);
        })
        }
        assert_eq!(extract_row_strings(&result, 0), vec!["x-1", "y-2"]);
        DataType::UInt8 => collect!(UInt8Array, |v: u8| v.to_string()),
                Some(elems) => {
            match &arg_types[2] {
                        out.push(Some(typed.value(i).to_string()));
            builder.append(true);
        if arg_types.len() != 2 && arg_types.len() != 3 {
    }
impl MvzipUdf {
            return plan_err!("mvzip expects 2 or 3 arguments, got {}", arg_types.len());
                    out.push(Some($fmt(typed.value(i))));
            ",".to_string()
        if args.args.len() != 2 && args.args.len() != 3 {
        // string separator without enumerating every concrete combination.
}
                DataType::Utf8 | DataType::LargeUtf8 | DataType::Utf8View => {
use datafusion::common::{plan_err, ScalarValue};
            let left_strs = elements_as_strings(left_row.as_ref())?;
}
                }
}
        DataType::UInt64 => collect!(UInt64Array, |v: u64| v.to_string()),
 */
        // Materialize left/right as ListArrays. Scalar list operands are unusual but
    Array, ArrayRef, AsArray, BooleanArray, Float32Array, Float64Array, GenericListArray,
                    if large.is_null(i) {
            DataType::Utf8,
            if left.is_null(i) || right.is_null(i) {
            let take = left_row.len().min(right_row.len());
                .ok_or_else(|| {
                    DataFusionError::Internal(format!(
//! array of strings, joined per pair by a separator (default `,`).
    fn coerce_types(&self, arg_types: &[DataType]) -> Result<Vec<DataType>> {
        let result = run(left, right, Some("-"));
                DataFusionError::Internal(format!(
        }
                    }
    } else {
