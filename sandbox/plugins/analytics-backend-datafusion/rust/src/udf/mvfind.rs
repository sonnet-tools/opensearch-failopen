    ColumnarValue, ScalarFunctionArgs, ScalarUDF, ScalarUDFImpl, Signature, Volatility,
                        match e {
        let result = run(arr, "^2");
        if arg_types.len() != 2 {
            .ok_or_else(|| {
            None
        let result = run(arr, "any");
//! * NULL array or NULL pattern → NULL result.
            | ColumnarValue::Scalar(ScalarValue::LargeUtf8(Some(p)))
    fn no_match_returns_null() {
//! # Pattern compilation strategy
        }
    }
    }
use datafusion::error::{DataFusionError, Result};
            None
                .downcast_ref::<datafusion::arrow::array::StringArray>()?;
                    return Some(i as i32);
    signature: Signature,
                    "mvfind: expected ListArray, got {:?}",
    }
        Ok(vec![arg_types[0].clone(), pattern_t])
                None => builder.append_null(),
        "mvfind"
                }
        DataType::Float64 => scan!(Float64Array, |v: f64| v.to_string()),
    #[test]
                    ColumnarValue::Scalar(ScalarValue::Utf8(Some(pattern.to_string()))),
            if list.is_null(i) {
            }
};
            | ColumnarValue::Scalar(ScalarValue::Utf8View(Some(p))) = &args.args[1]
}
        }
                        }
}
    fn null_element_skipped_index_still_zero_based() {
                None
        }};
        }
    use datafusion::arrow::array::{Int32Builder, ListBuilder, StringBuilder};
        DataType::Float32 => scan!(Float32Array, |v: f32| v.to_string()),
        DataType::UInt32 => scan!(UInt32Array, |v: u32| v.to_string()),
                DataFusionError::Internal(format!(
use datafusion::arrow::datatypes::DataType;
            .transpose()?;
    fn name(&self) -> &str {
//!
        assert_eq!(int_value(&result, 0), Some(1));
            }
//! * Result type is consistent with the YAML declaration in
    }
                .as_any()
    fn list_of_strings(rows: &[Option<&[Option<&str>]>]) -> ArrayRef {
            .as_any()
}
                None => {
        let arr = list_of_ints(&[Some(&[Some(10), Some(20), Some(30)])]);
//! * Returns Int32 — PPL's surface is `Integer`.
use regex::Regex;
        // Materialize a column-valued pattern up front; for scalar patterns we keep
        let arr = list_of_strings(&[Some(&[Some("apple"), Some("banana")])]);
                    return Some(i as i32);
                }
        // Fast path: pattern is a Utf8 scalar literal — compile once.
        for i in 0..n {
    }
};
            })?;
            Some(args.args[1].clone().into_array(n)?)
                    (Some(r), _) => Some(r.clone()),
        // Java's Matcher.find: "banana" matches /an/ (unanchored).
}
    #[test]
        DataType::Boolean => scan!(BooleanArray, |v: bool| v.to_string()),
use datafusion::logical_expr::{
//! * NULL element → skipped (continues to next element).
            }
        DataType::LargeUtf8 => {
        Ok(DataType::Int32)
            .unwrap();
                // Plan-time invalid pattern → planning error so users see it instantly.
impl ScalarUDFImpl for MvfindUdf {
            for i in 0..n {
                            None => builder.values().append_null(),
                config_options: Arc::new(datafusion::config::ConfigOptions::default()),
        ) {
                            Some(v) => builder.values().append_value(*v),
        let pattern_t = match &arg_types[1] {
        let typed = arr.as_any().downcast_ref::<Int32Array>().unwrap();
                arg_fields,
        if !matches!(
    #[test]
}
            DataType::List(_) | DataType::LargeList(_) | DataType::FixedSizeList(_, _)
                args: vec![
    }
        }
            &arg_types[0],
                // Mirrors the SQL plugin's IllegalArgumentException for invalid literal regex.
                if !typed.is_null(i) && regex.is_match(typed.value(i)) {
    #[test]
                .downcast_ref::<datafusion::arrow::array::LargeStringArray>()?;
        if arg_types.len() != 2 {
            ColumnarValue::Scalar(_) => panic!("expected array"),
        let arr = list_of_strings(&[None]);
                match Regex::new(p) {
        let arr = list_of_strings(&[Some(&[None, Some("banana")])]);
                    arr_arr.data_type()
                    for e in *elems {
                if typed.is_null(i) {
    }
 *
            other => return plan_err!("mvfind: arg 1 expected string, got {other:?}"),
            ColumnarValue::Array(a) => a,
            match row {
 * The OpenSearch Contributors require contributions made to
                if regex.is_match(&$fmt(typed.value(i))) {
        assert_eq!(int_value(&result, 0), None);
        };
            let typed = arr
fn find_first_match(arr: &dyn Array, regex: &Regex) -> Option<i32> {
        let arr_arr = args.args[0].clone().into_array(n)?;
            None
        assert_eq!(int_value(&result, 0), Some(1));
        let return_field = Arc::new(Field::new("out", DataType::Int32, true));
                number_rows: n,
                    builder.append(true);
    let n = arr.len();
            let typed = arr
            None
//!   `Regex::is_match` matches the same way (unanchored).
        }
    fn empty_array_returns_null() {
            None
    }
            };
//! errors are non-fatal — bad rows just produce NULL).
                            Some(s) => builder.values().append_value(s),
                }
//! * Per-element regex match (Java's `Matcher.find` semantics — substring
            for i in 0..n {
        assert_eq!(int_value(&result, 0), None);
                .as_any()
    UInt8Array,
use super::json_common::StringArrayView;
        DataType::UInt16 => scan!(UInt16Array, |v: u16| v.to_string()),
            .as_ref()
                    for e in *elems {
    use super::*;
/// Walk an Arrow array of any supported scalar type, return the 0-based index
                    builder.append(true);
        }
            None
            return plan_err!("mvfind expects 2 arguments, got {}", arg_types.len());
            return plan_err!("mvfind expects 2 arguments, got {}", args.args.len());
        let result = run(arr, "any");
    fn int_value(arr: &ArrayRef, row: usize) -> Option<i32> {
            } else {
                if !typed.is_null(i) && regex.is_match(typed.value(i)) {
                .downcast_ref::<datafusion::arrow::array::StringViewArray>()?;
    #[test]
                    ColumnarValue::Array(arr),
        }
        // the pre-compiled regex.
    }
                match (&scalar_regex, pattern_arr.as_ref().and_then(|a| a.cell(i))) {
        }
use datafusion::common::{plan_err, ScalarValue};
                builder.append_null();
        }
            .invoke_with_args(ScalarFunctionArgs {
                ],
    }
        let result = run(arr, "kiwi");
    }
                Some(r) => r,
 * SPDX-License-Identifier: Apache-2.0
        }
        DataType::Null => None,
//!
        if typed.is_null(row) {
#[cfg(test)]
            for i in 0..n {
                };
use datafusion::execution::context::SessionContext;
        let scalar_regex: Option<Regex> =
                    (None, Some(s)) => Regex::new(s).ok(),
        }
            }
use std::sync::Arc;
    #[test]
            }
                return_field,
    fn first_match_returns_zero_based_index() {
        let mut builder = Int32Builder::with_capacity(n);
                    _ => None,
//! * Empty array → NULL result (no element to match).
        }
                ))
        DataType::UInt8 => scan!(UInt8Array, |v: u8| v.to_string()),
        assert_eq!(int_value(&result, 0), Some(1));
    fn default() -> Self {
            };
            let row = list.value(i);
            for i in 0..n {
        Ok(ColumnarValue::Array(Arc::new(builder.finish()) as ArrayRef))
 * compatible open source license.
//!
        DataType::Utf8 => {
        if args.args.len() != 2 {
        Self {
                    Err(e) => return plan_err!("mvfind: invalid regex pattern '{p}': {e}"),
            }
                None => builder.append_null(),
    Array, ArrayRef, BooleanArray, Float32Array, Float64Array, GenericListArray, Int16Array,
    }
            Some(typed.value(row))
                    builder.append_null();
        for row in rows {
                }
pub struct MvfindUdf {
    }
                    continue;
        let result = MvfindUdf::new()
    pub fn new() -> Self {
        };
            return plan_err!("mvfind expects 2 arguments, got {}", arg_types.len());
            let regex_for_row: Option<Regex> =
        let result = run(arr, "ban.*");
        let result = run(arr, "ban.*");
        let arr = list_of_strings(&[Some(&[])]);
        Arc::new(builder.finish())
    fn invoke_with_args(&self, args: ScalarFunctionArgs) -> Result<ColumnarValue> {
                            None => builder.values().append_null(),
/// of the first non-null element whose stringified form matches `regex`.
                        }
                .as_any()
impl MvfindUdf {
//! invalid patterns yield NULL for that row (per PPL spec, dynamic-pattern
            }
                continue;
    }
//!   match, not full-string anchored). The Rust `regex` crate's
                    Ok(r) => Some(r),
        let result = run(arr, "an");
        DataType::UInt64 => scan!(UInt64Array, |v: u64| v.to_string()),
 */
            })
    fn return_type(&self, arg_types: &[DataType]) -> Result<DataType> {
//! Mirrors PPL's [`MVFindFunctionImpl`] semantics:
        _ => None,
        let arr = list_of_strings(&[Some(&[Some("apple"), Some("banana")])]);
        } else {
            match find_first_match(row.as_ref(), &regex) {
            {
        assert_eq!(int_value(&result, 0), None);
impl Default for MvfindUdf {
//! regex once up front (mirrors the SQL plugin's `tryCompileLiteralPattern`
                    continue;
/// Returns None if no element matches.
            let regex = match regex_for_row {
        Self::new()
//! When the pattern operand is a non-NULL Utf8 scalar literal we compile the
            // Per-row regex (compile if column-valued; reuse the scalar compile otherwise).
        let list = arr_arr
    #[test]
    macro_rules! scan {
    fn run(arr: ArrayRef, pattern: &str) -> ArrayRef {
    fn integer_array_stringified_for_regex() {
    }
                Some(elems) => {
                }
                Some(idx) => builder.append_value(idx),
        let n = arr.len();
    }
//! `mvfind(arr, regex)` — find the 0-based index of the first array element
        DataType::Int8 => scan!(Int8Array, |v: i8| v.to_string()),
        let n = args.number_rows;
                }
    }
        let mut builder = ListBuilder::new(StringBuilder::new());
                    }
        DataType::Int16 => scan!(Int16Array, |v: i16| v.to_string()),
    }
    Int32Array, Int32Builder, Int64Array, Int8Array, UInt16Array, UInt32Array, UInt64Array,
}
mod tests {
    fn list_of_ints(rows: &[Option<&[Option<i32>]>]) -> ArrayRef {
            .map(StringArrayView::from_array)
            if let ColumnarValue::Scalar(ScalarValue::Utf8(Some(p)))
        let pattern_arr_ref: Option<ArrayRef> = if scalar_regex.is_none() {
        for row in rows {
            DataType::Utf8 | DataType::LargeUtf8 | DataType::Utf8View => DataType::Utf8,
        DataType::Utf8View => {
        ];
                None => builder.append_null(),
        Arc::new(builder.finish())
//!   `opensearch_array_functions.yaml`.
                }
            Arc::new(Field::new("p", DataType::Utf8, true)),
                }
            }
            signature: Signature::user_defined(Volatility::Immutable),
            let typed = arr.as_any().downcast_ref::<$A>()?;
    ctx.register_udf(ScalarUDF::from(MvfindUdf::new()));
        assert_eq!(int_value(&result, 0), Some(1));
    fn substring_match_semantics_are_unanchored() {
    fn null_array_returns_null() {
            let typed = arr
                        match e {
        match result {
                Some(elems) => {
//! plan-time optimization). Column-valued patterns are compiled per row;
        DataType::Int64 => scan!(Int64Array, |v: i64| v.to_string()),
        DataType::Int32 => scan!(Int32Array, |v: i32| v.to_string()),
                    }
    match arr.data_type() {
pub fn register_all(ctx: &SessionContext) {
        let arr = list_of_strings(&[Some(&[Some("apple"), Some("banana"), Some("apricot")])]);
}
            return plan_err!("mvfind: arg 0 expected list type, got {:?}", arg_types[0]);
        &self.signature
    fn signature(&self) -> &Signature {
        }
    }
//!
    fn coerce_types(&self, arg_types: &[DataType]) -> Result<Vec<DataType>> {
            Arc::new(Field::new("a", arr.data_type().clone(), true)),
            match row {
        let arg_fields: Vec<Arc<Field>> = vec![
            .downcast_ref::<GenericListArray<i32>>()
        let pattern_arr: Option<StringArrayView<'_>> = pattern_arr_ref
use datafusion::arrow::array::{
    }
        let mut builder = ListBuilder::new(Int32Builder::new());
                if !typed.is_null(i) && regex.is_match(typed.value(i)) {
        } else {
                }
 * this file be licensed under the Apache-2.0 license or a
//! matching a regex, or NULL if no match.
/*
    use datafusion::arrow::datatypes::Field;
        ($A:ty, $fmt:expr) => {{
                    return Some(i as i32);
#[derive(Debug, PartialEq, Eq, Hash)]
                    return Some(i as i32);
