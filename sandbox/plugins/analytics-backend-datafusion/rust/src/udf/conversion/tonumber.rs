    }
        ColumnarValue::Scalar(ScalarValue::Int32(Some(b))) => Ok(match validate_base(*b) {
        assert!(invoke_scalar(Some("10"), Some(1)).is_none());
            other => panic!("expected array, got {other:?}"),
        // Materialize the value column. For scalars we keep the raw &str to
impl Hash for ToNumberUdf {
            return_field: Arc::new(Field::new("out", DataType::Float64, true)),
                ColumnarValue::Scalar(ScalarValue::Int32(Some(42))),
    /// of the value column — we skip reading it.
    }
enum ValueSource<'a> {
    if (2..=36).contains(&base) {
    ColumnarValue, ScalarFunctionArgs, ScalarUDF, ScalarUDFImpl, Signature, TypeSignature,
        }
            arg_fields: vec![
impl ToNumberUdf {
        ColumnarValue::Array(arr) => {
            Some(r) => BaseMode::Valid(r),
                "tonumber: base must be a literal integer, got column of type {:?}",
//! * Output type is `Float64`
            ColumnarValue::Array(a) => a,
                "tonumber expects exactly 2 arguments (string, base), got {}",
                Arc::new(Field::new("b", DataType::Int32, true)),
        let values_arr_ref: Option<ArrayRef> = match value_col {
                ColumnarValue::Scalar(ScalarValue::Int32(Some(16))),
            ColumnarValue::Array(a) => a,
            ColumnarValue::Array(_) => Some(value_col.clone().into_array(n)?),
    }
        Some(base as u32)
    }
            ColumnarValue::Scalar(ScalarValue::Utf8(s)),
            ValueSource::Array(view) => view.cell(i),
    }
    /// Returns the string at row `i`, or `None`
 */
            ],
            other => panic!("expected array, got {other:?}"),
};
    let radix = validate_base(base?)?;
pub fn register_all(ctx: &SessionContext) {
 * The OpenSearch Contributors require contributions made to
impl Default for ToNumberUdf {
    }
        };
                Arc::new(Field::new("v", DataType::Utf8, true)),
            return Ok(ColumnarValue::Array(Arc::new(builder.finish()) as ArrayRef));
    Valid(u32),
    }
    fn scalar_null_base_produces_all_null_output() {
/// Resolve the `base` argument
        };
        }
                    ScalarValue::Utf8(opt)
        assert_eq!(invoke_scalar(Some("Z"), Some(36)), Some(35.0));
    #[test]
    }
    }
        let f = arr.as_primitive::<datafusion::arrow::datatypes::Float64Type>();
}
            arg_fields: vec![
        let arr = match u.invoke_with_args(args).unwrap() {
                args.args.len()
        if let (
impl<'a> ValueSource<'a> {
                return exec_err!("tonumber: value expected Utf8, got {other:?}");
    let s = s?;
use crate::udf::json_common::StringArrayView;
        let mut builder = Float64Builder::with_capacity(n);
                    | ScalarValue::LargeUtf8(opt)
            }
                ColumnarValue::Array(values),
    }
 * compatible open source license.
        }
        let out: Float64Array = builder.finish();
}
            {
    match base_col {
        ]));
fn resolve_base(base_col: &ColumnarValue) -> Result<BaseMode> {
    fn scalar_out_of_range_base_produces_all_null_output() {
            return Ok(ColumnarValue::Scalar(ScalarValue::Float64(
        let arr = match u.invoke_with_args(args).unwrap() {
            None,
enum BaseMode {
        assert!(invoke_scalar(Some("9223372036854775808"), Some(10)).is_none());
            )
}
        assert!(invoke_scalar(None, None).is_none());
impl Eq for ToNumberUdf {}
        assert!(invoke_scalar(Some(""), Some(10)).is_none());
        assert!(invoke_scalar(Some("10"), Some(0)).is_none());
        let args = ScalarFunctionArgs {
        let n = args.number_rows;
    fn array_values_with_scalar_base_takes_fast_path() {
        assert_eq!(invoke_scalar(Some("FA34"), Some(16)), Some(64052.0));
}
        Self {
        ColumnarValue::Scalar(ScalarValue::Int32(None)) => Ok(BaseMode::AllNull),
        assert_eq!(invoke_scalar(Some("+FA"), Some(16)), Some(250.0));
    }
/// `tonumber(varchar, int)` → fp64. Base-N string-to-integer parse widened to double
        assert_eq!(f.value(3), 255.0);
            None => BaseMode::AllNull,
#[cfg(test)]
            builder.append_nulls(n);
        ]));
    Scalar(Option<&'a str>),
                Arc::new(Field::new("v", DataType::Utf8, true)),
            (
    }
        }
        let u = ToNumberUdf::new();
                .and_then(|s| i64::from_str_radix(s, radix).ok())
//! # Semantics
        {
    i64::from_str_radix(s, radix).ok().map(|v| v as f64)
        assert!(invoke_scalar(Some("10"), Some(37)).is_none());
impl ScalarUDFImpl for ToNumberUdf {
 *
        &self.signature
    fn null_inputs_return_null() {
    fn default() -> Self {
                ColumnarValue::Array(values),
    fn hash<H: Hasher>(&self, state: &mut H) {
    #[test]
                ColumnarValue::Array(values),
            args: vec![
        let base_col = &args.args[1];
            ],
    use super::*;
        if args.args.len() != 2 {
    fn invoke_scalar(value: Option<&str>, base: Option<i32>) -> Option<f64> {
        assert_eq!(invoke_scalar(Some("4598"), Some(10)), Some(4598.0));
                Arc::new(Field::new("b", DataType::Int32, true)),
        Ok(ColumnarValue::Array(Arc::new(out) as ArrayRef))
/// How the resolved (constant) `base` argument behaves across the batch.
// ─── tests ──────────────────────────────────────────────────────────────────
/// Resolved once up front so the hot loop doesn't repeat the scalar dispatch
    fn eq(&self, _: &Self) -> bool {
    fn invoke_with_args(&self, args: ScalarFunctionArgs) -> Result<ColumnarValue> {
        let f = arr.as_primitive::<datafusion::arrow::datatypes::Float64Type>();
use std::hash::{Hash, Hasher};
    fn return_type(&self, _arg_types: &[DataType]) -> Result<DataType> {
    ctx.register_udf(ScalarUDF::from(ToNumberUdf::new()));
        let values: ArrayRef = Arc::new(StringArray::from(vec![
    /// {@code i64::from_str_radix} wants), so the per-row code skips both the
        assert_eq!(invoke_scalar(Some("fa34"), Some(16)), Some(64052.0));
    fn unparseable_string_returns_null() {
        let BaseMode::Valid(radix) = resolve_base(base_col)? else {
    signature: Signature,
        let args = ScalarFunctionArgs {
        let f = arr.as_primitive::<datafusion::arrow::datatypes::Float64Type>();
    #[test]
//! * `base` must be in the inclusive range `[2, 36]`
    fn out_of_range_base_returns_null() {
}
        }
    /// Base is valid. Carries the validated radix as `u32` (the type
                Arc::new(Field::new("v", DataType::Utf8, true)),
use datafusion::execution::context::SessionContext;
    pub fn new() -> Self {
            ],
    } else {
        "tonumber".hash(state);
                Arc::new(Field::new("v", DataType::Utf8, true)),
            arg_fields: vec![
        }),
}
            ColumnarValue::Scalar(ScalarValue::Int32(b)),
}
    }
    #[test]
        Ok(DataType::Float64)
        for i in 0..n {
fn validate_base(base: i32) -> Option<u32> {
/// when the base is outside `[2, 36]` range.
    }
        assert_eq!(invoke_scalar(Some("010101"), Some(2)), Some(21.0));
            Some("FA34"),
                ColumnarValue::Scalar(ScalarValue::Int32(None)),
pub struct ToNumberUdf {
}
                vec![TypeSignature::Exact(vec![DataType::Utf8, DataType::Int32])],
            )));
            number_rows: 2,
            number_rows: 1,
        }
            exec_err!("tonumber: base expected Int32 literal, got {other:?}")
    #[test]
        };
                None => builder.append_null(),
    }
    fn at(&self, i: usize) -> Option<&str> {
        let values: ArrayRef = Arc::new(StringArray::from(vec![Some("FA34"), Some("10")]));
}
    }
    #[test]
            return_field: Arc::new(Field::new("out", DataType::Float64, true)),
        let args = ScalarFunctionArgs {
        };
//! [`tonumber(string, base)`](https://docs.opensearch.org/latest/sql-and-ppl/ppl/functions/conversion/#tonumber)
        assert_eq!(f.len(), 3);
mod tests {
            Some("nope"),
        ColumnarValue::Scalar(other) => {
// `ScalarUDFImpl` requires `DynEq` + `DynHash`. All instances are functionally
}
    /// scalar dispatch and the range check.
//!
    }
    use datafusion::arrow::datatypes::Field;
        };
    #[test]
            signature: Signature::one_of(
/*
                .at(i)
    }
            return_field: Arc::new(Field::new("out", DataType::Float64, true)),
        assert_eq!(invoke_scalar(Some("-10"), Some(2)), Some(-2.0));
            number_rows: 3,
                Arc::new(Field::new("b", DataType::Int32, true)),
        assert!(invoke_scalar(Some("10"), None).is_none());
                ColumnarValue::Scalar(ScalarValue::Int32(base)),
            return_field: Arc::new(Field::new(u.name(), DataType::Float64, true)),
 * this file be licensed under the Apache-2.0 license or a
        let value_col = &args.args[0];
            ],
        assert!(invoke_scalar(Some("12"), Some(2)).is_none());
        assert_eq!(f.value(0), 64052.0);
impl PartialEq for ToNumberUdf {
            args: vec![
    }
    AllNull,
        assert_eq!(invoke_scalar(Some("-21"), Some(10)), Some(-21.0));
        };
        assert!(f.is_null(2), "null input → NULL");
        Self::new()
use std::sync::Arc;
            exec_err!(
            args: vec![
use datafusion::common::{exec_err, Result, ScalarValue};
            args: vec![
            Some("nope"),
    fn hex_doc_example() {
        let values: ArrayRef = Arc::new(StringArray::from(vec![
    fn binary_doc_example() {
/// How the `value` argument is supplied
            config_options: Arc::new(Default::default()),
#[derive(Debug)]
            ],
        };
use datafusion::arrow::datatypes::DataType;
            other => panic!("expected array, got {other:?}"),
            ],
    }
        };
            let mut builder = Float64Builder::with_capacity(n);
            number_rows: 4,
/// or the range check on every row.
//! base-N integer parse.
                ColumnarValue::Scalar(
        ) = (value_col, base_col)
        assert!(invoke_scalar(Some("3.14"), Some(10)).is_none());
            assert!(f.is_null(i), "row {i} must be NULL");
        assert!(invoke_scalar(Some("1 2"), Some(10)).is_none());
            ],
        let arr = match u.invoke_with_args(args).unwrap() {
        let u = ToNumberUdf::new();
            }
            arg_fields: vec![
    fn base10_integer_doc_example() {
                ColumnarValue::Scalar(ScalarValue::Utf8(value.map(|s| s.to_string()))),
        for i in 0..3 {
            config_options: Arc::new(Default::default()),
                parse_with_base(s.as_deref(), *b),
            ),
}
    fn signature(&self) -> &Signature {
            ) => ValueSource::Scalar(opt.as_deref()),
}
    Array(StringArrayView<'a>),
    }
                Some(v) => builder.append_value(v as f64),
    fn base_boundary_values() {
// identical (no parameterization), so equality is trivial.
}
                None,
        assert!(f.is_null(0));
        match u.invoke_with_args(args).unwrap() {
                Volatility::Immutable,
    }
        };
            other => panic!("expected Float64 scalar, got {other:?}"),
 * SPDX-License-Identifier: Apache-2.0
            Some("10"),
        }
        }
/// Convert `base` to the radix expected by [`i64::from_str_radix`], or `None`
    /// Base is `NULL` or outside `[2, 36]`. Every output row is NULL regardless
            Some("FA34"),
        let values: ValueSource = match (&values_arr_ref, value_col) {
            (None, other) => {
        // avoid a pointless n-wide StringArray allocation.
    #[test]
            (Some(arr), _) => ValueSource::Array(StringArrayView::from_array(arr)?),
            ColumnarValue::Array(a) => a,
}
use datafusion::arrow::array::{ArrayRef, Float64Array, Float64Builder};
use datafusion::logical_expr::{
    fn name(&self) -> &str {
        true
                Arc::new(Field::new("b", DataType::Int32, true)),
        assert!(invoke_scalar(Some("10"), Some(-5)).is_none());
    #[test]
    fn signed_inputs_parse() {
        assert!(f.is_null(1));
                    | ScalarValue::Utf8View(opt),
            );
    }
            config_options: Arc::new(Default::default()),
    }
        match self {
            _ => None,
        None
        assert!(f.is_null(1), "unparseable → NULL");
        assert!(invoke_scalar(None, Some(10)).is_none());
fn parse_with_base(s: Option<&str>, base: Option<i32>) -> Option<f64> {
        assert_eq!(invoke_scalar(Some("1"), Some(2)), Some(1.0));
        "tonumber"
            ColumnarValue::Scalar(ScalarValue::Float64(opt)) => opt,
            ValueSource::Scalar(s) => *s,
            ],
    #[test]
        };
        let u = ToNumberUdf::new();
            config_options: Arc::new(Default::default()),
        }
    #[test]
        let u = ToNumberUdf::new();
        let args = ScalarFunctionArgs {
                ),
    use datafusion::arrow::array::{Array, AsArray, Int32Array, StringArray};
    fn overflow_returns_null() {
                arr.data_type()
        assert!(invoke_scalar(Some("FA34"), Some(10)).is_none());
            return exec_err!(
            Some("ff"),
        // Full-scalar fast path — a plain literal `tonumber('FA34', 16)` plan.
    Volatility,
    #[test]
            match values
