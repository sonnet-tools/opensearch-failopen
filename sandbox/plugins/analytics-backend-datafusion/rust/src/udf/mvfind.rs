        DataType::Utf8 => {
            if list.is_null(i) {
                    Ok(r) => Some(r),
                    }
    }
        Arc::new(builder.finish())
        }
            .transpose()?;
}
//! # Pattern compilation strategy
        // Materialize a column-valued pattern up front; for scalar patterns we keep
    fn name(&self) -> &str {
        let result = MvfindUdf::new()
            | ColumnarValue::Scalar(ScalarValue::Utf8View(Some(p))) = &args.args[1]
//! * Empty array → NULL result (no element to match).
                // Plan-time invalid pattern → planning error so users see it instantly.
    #[test]
                match (&scalar_regex, pattern_arr.as_ref().and_then(|a| a.cell(i))) {
    #[test]
        }
    #[test]
use super::json_common::StringArrayView;
}
            let regex_for_row: Option<Regex> =
                }
        &self.signature
        let arg_fields: Vec<Arc<Field>> = vec![
pub fn register_all(ctx: &SessionContext) {
                    builder.append_null();
                ))
            for i in 0..n {
            }
            let typed = arr
impl ScalarUDFImpl for MvfindUdf {
            }
        let arr = list_of_strings(&[Some(&[Some("apple"), Some("banana"), Some("apricot")])]);
                        match e {
            | ColumnarValue::Scalar(ScalarValue::LargeUtf8(Some(p)))
                    builder.append(true);
        }
        let list = arr_arr
            return plan_err!("mvfind expects 2 arguments, got {}", args.args.len());
use regex::Regex;
        assert_eq!(int_value(&result, 0), Some(1));
        assert_eq!(int_value(&result, 0), Some(1));
                Some(elems) => {
};
            .invoke_with_args(ScalarFunctionArgs {
        let result = run(arr, "an");
                }
            match row {
    }
        if arg_types.len() != 2 {
        assert_eq!(int_value(&result, 0), Some(1));
use datafusion::arrow::datatypes::DataType;
        assert_eq!(int_value(&result, 0), None);
        }
/// of the first non-null element whose stringified form matches `regex`.
                    return Some(i as i32);
                if regex.is_match(&$fmt(typed.value(i))) {
            let typed = arr.as_any().downcast_ref::<$A>()?;
    fn default() -> Self {
        let result = run(arr, "^2");
use datafusion::common::{plan_err, ScalarValue};
        let result = run(arr, "ban.*");
    }
fn find_first_match(arr: &dyn Array, regex: &Regex) -> Option<i32> {
        }
        if args.args.len() != 2 {
pub struct MvfindUdf {
        Self::new()
        ) {
        _ => None,
    }
        let arr = list_of_strings(&[None]);
    }
        let result = run(arr, "any");
                .as_any()
    }
            None
                            Some(s) => builder.values().append_value(s),
            .as_ref()
        let mut builder = Int32Builder::with_capacity(n);
        let n = args.number_rows;
        DataType::LargeUtf8 => {
 * The OpenSearch Contributors require contributions made to
                continue;
        assert_eq!(int_value(&result, 0), Some(1));
    ctx.register_udf(ScalarUDF::from(MvfindUdf::new()));
            DataType::Utf8 | DataType::LargeUtf8 | DataType::Utf8View => DataType::Utf8,
        DataType::Null => None,
        DataType::UInt8 => scan!(UInt8Array, |v: u8| v.to_string()),
        // Fast path: pattern is a Utf8 scalar literal — compile once.
                Some(r) => r,
}
        for i in 0..n {
        Ok(vec![arg_types[0].clone(), pattern_t])
//! * NULL array or NULL pattern → NULL result.
        }};
                    Err(e) => return plan_err!("mvfind: invalid regex pattern '{p}': {e}"),
    fn first_match_returns_zero_based_index() {
            } else {
//! `mvfind(arr, regex)` — find the 0-based index of the first array element
        DataType::Int32 => scan!(Int32Array, |v: i32| v.to_string()),
            for i in 0..n {
                    continue;
                    ColumnarValue::Array(arr),
    fn list_of_strings(rows: &[Option<&[Option<&str>]>]) -> ArrayRef {
                    ColumnarValue::Scalar(ScalarValue::Utf8(Some(pattern.to_string()))),
                        }
            None
            {
//! * Result type is consistent with the YAML declaration in
                }
                    builder.append(true);
                // Mirrors the SQL plugin's IllegalArgumentException for invalid literal regex.
            }
    fn signature(&self) -> &Signature {
        }
        for row in rows {
            };
        DataType::UInt64 => scan!(UInt64Array, |v: u64| v.to_string()),
                    for e in *elems {
        ];
        Ok(DataType::Int32)
    #[test]
        assert_eq!(int_value(&result, 0), None);
                .as_any()
        } else {
}
        }
                    (Some(r), _) => Some(r.clone()),
            // Per-row regex (compile if column-valued; reuse the scalar compile otherwise).
    }
        // the pre-compiled regex.
            ColumnarValue::Scalar(_) => panic!("expected array"),
            .as_any()
    #[test]
        match result {
            }
        let scalar_regex: Option<Regex> =
            return plan_err!("mvfind: arg 0 expected list type, got {:?}", arg_types[0]);
        let arr = list_of_strings(&[Some(&[None, Some("banana")])]);
        let result = run(arr, "kiwi");
            return plan_err!("mvfind expects 2 arguments, got {}", arg_types.len());
    ColumnarValue, ScalarFunctionArgs, ScalarUDF, ScalarUDFImpl, Signature, Volatility,
        };
        let return_field = Arc::new(Field::new("out", DataType::Int32, true));
            .downcast_ref::<GenericListArray<i32>>()
                arg_fields,
                number_rows: n,
            }
                builder.append_null();
                    arr_arr.data_type()
            match row {
    use datafusion::arrow::datatypes::Field;
        } else {
 *
    }
#[cfg(test)]
            Some(typed.value(row))
        }
    let n = arr.len();
        }
//! * Per-element regex match (Java's `Matcher.find` semantics — substring
            };
                    return Some(i as i32);
    }
        let result = run(arr, "any");
        Self {
impl Default for MvfindUdf {
    }
                        match e {
                ],
    match arr.data_type() {
};
            None
            ColumnarValue::Array(a) => a,
                    "mvfind: expected ListArray, got {:?}",
            .map(StringArrayView::from_array)
            match find_first_match(row.as_ref(), &regex) {
                None => builder.append_null(),
            None
//! Mirrors PPL's [`MVFindFunctionImpl`] semantics:
        if arg_types.len() != 2 {
            None
            })?;
    fn invoke_with_args(&self, args: ScalarFunctionArgs) -> Result<ColumnarValue> {
        DataType::Int64 => scan!(Int64Array, |v: i64| v.to_string()),
                args: vec![
                if !typed.is_null(i) && regex.is_match(typed.value(i)) {
                }
    }
        let n = arr.len();
}
            Arc::new(Field::new("a", arr.data_type().clone(), true)),
                Some(elems) => {
//!   `Regex::is_match` matches the same way (unanchored).
                };
    #[test]
        let pattern_t = match &arg_types[1] {
                None
                if !typed.is_null(i) && regex.is_match(typed.value(i)) {
                    (None, Some(s)) => Regex::new(s).ok(),
                config_options: Arc::new(datafusion::config::ConfigOptions::default()),
    }
    fn return_type(&self, arg_types: &[DataType]) -> Result<DataType> {
                            None => builder.values().append_null(),
        let typed = arr.as_any().downcast_ref::<Int32Array>().unwrap();
        }
//! invalid patterns yield NULL for that row (per PPL spec, dynamic-pattern
//! matching a regex, or NULL if no match.
    }
                None => {
    fn int_value(arr: &ArrayRef, row: usize) -> Option<i32> {
    #[test]
        assert_eq!(int_value(&result, 0), None);
//!   match, not full-string anchored). The Rust `regex` crate's
                None => builder.append_null(),
                if typed.is_null(i) {
//!
    fn coerce_types(&self, arg_types: &[DataType]) -> Result<Vec<DataType>> {
        let result = run(arr, "ban.*");
//! errors are non-fatal — bad rows just produce NULL).
use std::sync::Arc;
            &arg_types[0],
                    for e in *elems {
 * SPDX-License-Identifier: Apache-2.0
                            Some(v) => builder.values().append_value(*v),
    fn null_element_skipped_index_still_zero_based() {
        DataType::Float32 => scan!(Float32Array, |v: f32| v.to_string()),
            Some(args.args[1].clone().into_array(n)?)
            Arc::new(Field::new("p", DataType::Utf8, true)),
    fn no_match_returns_null() {
    }
        for row in rows {
//!
                match Regex::new(p) {
            let regex = match regex_for_row {
        let arr_arr = args.args[0].clone().into_array(n)?;
        DataType::Utf8View => {
                    return Some(i as i32);
#[derive(Debug, PartialEq, Eq, Hash)]
        }
            for i in 0..n {
    use datafusion::arrow::array::{Int32Builder, ListBuilder, StringBuilder};
    }
 */
//! regex once up front (mirrors the SQL plugin's `tryCompileLiteralPattern`
                    }
    fn integer_array_stringified_for_regex() {
            for i in 0..n {
}
    }
        if !matches!(
                if !typed.is_null(i) && regex.is_match(typed.value(i)) {
        let arr = list_of_strings(&[Some(&[Some("apple"), Some("banana")])]);
                DataFusionError::Internal(format!(
                .downcast_ref::<datafusion::arrow::array::StringArray>()?;
 * compatible open source license.
    macro_rules! scan {
    }
//! * Returns Int32 — PPL's surface is `Integer`.
                return_field,
            signature: Signature::user_defined(Volatility::Immutable),
            .ok_or_else(|| {
 * this file be licensed under the Apache-2.0 license or a
                    continue;
//! When the pattern operand is a non-NULL Utf8 scalar literal we compile the
            let row = list.value(i);
        let arr = list_of_strings(&[Some(&[])]);
        Ok(ColumnarValue::Array(Arc::new(builder.finish()) as ArrayRef))
        }
/// Returns None if no element matches.
            }
            .unwrap();
                        }
                None => builder.append_null(),
                }
    }
    Array, ArrayRef, BooleanArray, Float32Array, Float64Array, GenericListArray, Int16Array,
        let arr = list_of_strings(&[Some(&[Some("apple"), Some("banana")])]);
/*
                .downcast_ref::<datafusion::arrow::array::LargeStringArray>()?;
//!
        // Java's Matcher.find: "banana" matches /an/ (unanchored).
impl MvfindUdf {
    }
                }
use datafusion::arrow::array::{
                            None => builder.values().append_null(),
                .downcast_ref::<datafusion::arrow::array::StringViewArray>()?;
        let mut builder = ListBuilder::new(Int32Builder::new());
        }
                .as_any()
//! plan-time optimization). Column-valued patterns are compiled per row;
    use super::*;
        let arr = list_of_ints(&[Some(&[Some(10), Some(20), Some(30)])]);
    fn list_of_ints(rows: &[Option<&[Option<i32>]>]) -> ArrayRef {
            }
//!
        "mvfind"
            None
use datafusion::logical_expr::{
/// Walk an Arrow array of any supported scalar type, return the 0-based index
//!   `opensearch_array_functions.yaml`.
        DataType::UInt32 => scan!(UInt32Array, |v: u32| v.to_string()),
        let mut builder = ListBuilder::new(StringBuilder::new());
        DataType::UInt16 => scan!(UInt16Array, |v: u16| v.to_string()),
        };
use datafusion::execution::context::SessionContext;
                }
        ($A:ty, $fmt:expr) => {{
            return plan_err!("mvfind expects 2 arguments, got {}", arg_types.len());
        DataType::Boolean => scan!(BooleanArray, |v: bool| v.to_string()),
}
        DataType::Int8 => scan!(Int8Array, |v: i8| v.to_string()),
            })
    fn empty_array_returns_null() {
            }
    }
            let typed = arr
    Int32Array, Int32Builder, Int64Array, Int8Array, UInt16Array, UInt32Array, UInt64Array,
//! * NULL element → skipped (continues to next element).
    fn null_array_returns_null() {
    UInt8Array,
mod tests {
                }
use datafusion::error::{DataFusionError, Result};
            other => return plan_err!("mvfind: arg 1 expected string, got {other:?}"),
        DataType::Float64 => scan!(Float64Array, |v: f64| v.to_string()),
        let pattern_arr: Option<StringArrayView<'_>> = pattern_arr_ref
            let typed = arr
    pub fn new() -> Self {
    signature: Signature,
    fn substring_match_semantics_are_unanchored() {
                Some(idx) => builder.append_value(idx),
        if typed.is_null(row) {
                }
                    return Some(i as i32);
            DataType::List(_) | DataType::LargeList(_) | DataType::FixedSizeList(_, _)
            if let ColumnarValue::Scalar(ScalarValue::Utf8(Some(p)))
        let pattern_arr_ref: Option<ArrayRef> = if scalar_regex.is_none() {
                    _ => None,
        DataType::Int16 => scan!(Int16Array, |v: i16| v.to_string()),
    fn run(arr: ArrayRef, pattern: &str) -> ArrayRef {
        Arc::new(builder.finish())
