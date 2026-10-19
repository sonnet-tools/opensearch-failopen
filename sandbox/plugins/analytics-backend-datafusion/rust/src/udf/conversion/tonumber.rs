fn parse_with_base(s: Option<&str>, base: Option<i32>) -> Option<f64> {
/// Convert `base` to the radix expected by [`i64::from_str_radix`], or `None`
            );
        assert!(invoke_scalar(Some("12"), Some(2)).is_none());
}
                ColumnarValue::Array(values),
            args: vec![
    }
        let arr = match u.invoke_with_args(args).unwrap() {
        };
// identical (no parameterization), so equality is trivial.
    if (2..=36).contains(&base) {
        let BaseMode::Valid(radix) = resolve_base(base_col)? else {
        assert_eq!(invoke_scalar(Some("-10"), Some(2)), Some(-2.0));
    }
/// when the base is outside `[2, 36]` range.
                ColumnarValue::Scalar(ScalarValue::Int32(Some(16))),
//! [`tonumber(string, base)`](https://docs.opensearch.org/latest/sql-and-ppl/ppl/functions/conversion/#tonumber)
impl Default for ToNumberUdf {
    #[test]
            None => BaseMode::AllNull,
enum BaseMode {
            ],
use datafusion::arrow::datatypes::DataType;
            ColumnarValue::Array(_) => Some(value_col.clone().into_array(n)?),
    #[test]
        ) = (value_col, base_col)
                ),
    let s = s?;
        ]));
}
    fn signed_inputs_parse() {
            other => panic!("expected array, got {other:?}"),
        assert!(invoke_scalar(Some("10"), Some(1)).is_none());
        let u = ToNumberUdf::new();
        let values: ArrayRef = Arc::new(StringArray::from(vec![
            (
            ) => ValueSource::Scalar(opt.as_deref()),
                Arc::new(Field::new("b", DataType::Int32, true)),
            other => panic!("expected array, got {other:?}"),
        };
    #[test]
    fn invoke_scalar(value: Option<&str>, base: Option<i32>) -> Option<f64> {
                    | ScalarValue::Utf8View(opt),
    } else {
    #[test]
    fn eq(&self, _: &Self) -> bool {
use std::sync::Arc;
    fn out_of_range_base_returns_null() {
        assert!(invoke_scalar(None, None).is_none());
    Scalar(Option<&'a str>),
                parse_with_base(s.as_deref(), *b),
    #[test]
    }
    use datafusion::arrow::array::{Array, AsArray, Int32Array, StringArray};
}
        assert_eq!(invoke_scalar(Some("Z"), Some(36)), Some(35.0));
        "tonumber".hash(state);
        }),
        let u = ToNumberUdf::new();
        // Full-scalar fast path — a plain literal `tonumber('FA34', 16)` plan.
        assert!(f.is_null(1), "unparseable → NULL");
    AllNull,
}
#[cfg(test)]
            Some("10"),
            (None, other) => {
    use datafusion::arrow::datatypes::Field;
    }
            ],
        assert_eq!(f.value(3), 255.0);
        assert_eq!(invoke_scalar(Some("010101"), Some(2)), Some(21.0));
        let arr = match u.invoke_with_args(args).unwrap() {
            signature: Signature::one_of(
        }
    /// scalar dispatch and the range check.
//! # Semantics
            Some("FA34"),
    }
        };
        let base_col = &args.args[1];
    }
        let args = ScalarFunctionArgs {
                None => builder.append_null(),
            ],
    fn default() -> Self {
        };
 * SPDX-License-Identifier: Apache-2.0
};
    fn unparseable_string_returns_null() {
            ],
        }
        assert_eq!(invoke_scalar(Some("1"), Some(2)), Some(1.0));
    fn at(&self, i: usize) -> Option<&str> {
        }
    }
                Arc::new(Field::new("v", DataType::Utf8, true)),
        assert!(invoke_scalar(Some("10"), Some(-5)).is_none());
    fn scalar_out_of_range_base_produces_all_null_output() {
            None,
    fn return_type(&self, _arg_types: &[DataType]) -> Result<DataType> {
        };
        }
impl Hash for ToNumberUdf {
            ValueSource::Array(view) => view.cell(i),
            exec_err!("tonumber: base expected Int32 literal, got {other:?}")
impl<'a> ValueSource<'a> {
//! * `base` must be in the inclusive range `[2, 36]`
            other => panic!("expected Float64 scalar, got {other:?}"),
            let mut builder = Float64Builder::with_capacity(n);
                ColumnarValue::Array(values),
    }
    fn overflow_returns_null() {
        let u = ToNumberUdf::new();
            ),
            arg_fields: vec![
            ColumnarValue::Array(a) => a,
            }
        let arr = match u.invoke_with_args(args).unwrap() {
        Self {
            (Some(arr), _) => ValueSource::Array(StringArrayView::from_array(arr)?),
        }
    #[test]
//! base-N integer parse.
            _ => None,
    }
            args: vec![
            assert!(f.is_null(i), "row {i} must be NULL");
            ColumnarValue::Array(a) => a,
mod tests {
    fn name(&self) -> &str {
                Arc::new(Field::new("b", DataType::Int32, true)),
        };
        {
            config_options: Arc::new(Default::default()),
// `ScalarUDFImpl` requires `DynEq` + `DynHash`. All instances are functionally
 * this file be licensed under the Apache-2.0 license or a
                arr.data_type()
}
        assert!(f.is_null(0));
    let radix = validate_base(base?)?;
        assert!(invoke_scalar(None, Some(10)).is_none());
    }
use datafusion::common::{exec_err, Result, ScalarValue};
                Some(v) => builder.append_value(v as f64),
        ColumnarValue::Scalar(ScalarValue::Int32(Some(b))) => Ok(match validate_base(*b) {
    fn hex_doc_example() {
        for i in 0..3 {
}
    match base_col {
 * compatible open source license.
                ColumnarValue::Scalar(
        let out: Float64Array = builder.finish();
/// How the resolved (constant) `base` argument behaves across the batch.
            Some(r) => BaseMode::Valid(r),
        assert!(f.is_null(2), "null input → NULL");
        "tonumber"
        None
    }
/*
            config_options: Arc::new(Default::default()),
        assert!(invoke_scalar(Some("FA34"), Some(10)).is_none());
        match u.invoke_with_args(args).unwrap() {
}
                Volatility::Immutable,
        &self.signature
        }
use datafusion::execution::context::SessionContext;
            return_field: Arc::new(Field::new("out", DataType::Float64, true)),
impl PartialEq for ToNumberUdf {
    ctx.register_udf(ScalarUDF::from(ToNumberUdf::new()));
    }
        let values: ArrayRef = Arc::new(StringArray::from(vec![Some("FA34"), Some("10")]));
        ColumnarValue::Scalar(other) => {
    fn null_inputs_return_null() {
    }
            return exec_err!(
        Ok(DataType::Float64)
        let args = ScalarFunctionArgs {
    fn invoke_with_args(&self, args: ScalarFunctionArgs) -> Result<ColumnarValue> {
// ─── tests ──────────────────────────────────────────────────────────────────
        match self {
            ],
    fn binary_doc_example() {
                    | ScalarValue::LargeUtf8(opt)
            number_rows: 2,
            other => panic!("expected array, got {other:?}"),
pub fn register_all(ctx: &SessionContext) {
        };
                None,
 *
            return_field: Arc::new(Field::new("out", DataType::Float64, true)),
        };
            }
            return Ok(ColumnarValue::Array(Arc::new(builder.finish()) as ArrayRef));
        assert!(invoke_scalar(Some("1 2"), Some(10)).is_none());
            arg_fields: vec![
        assert!(f.is_null(1));
impl ScalarUDFImpl for ToNumberUdf {
    /// of the value column — we skip reading it.
            args: vec![
        let f = arr.as_primitive::<datafusion::arrow::datatypes::Float64Type>();
            {
            ValueSource::Scalar(s) => *s,
    #[test]
    }
        assert_eq!(invoke_scalar(Some("4598"), Some(10)), Some(4598.0));
        let n = args.number_rows;
            )));
    fn scalar_null_base_produces_all_null_output() {
//! * Output type is `Float64`
        let values: ArrayRef = Arc::new(StringArray::from(vec![
            ],
        let f = arr.as_primitive::<datafusion::arrow::datatypes::Float64Type>();
                Arc::new(Field::new("v", DataType::Utf8, true)),
    Valid(u32),
            builder.append_nulls(n);
            return_field: Arc::new(Field::new("out", DataType::Float64, true)),
        ColumnarValue::Array(arr) => {
                "tonumber: base must be a literal integer, got column of type {:?}",
/// `tonumber(varchar, int)` → fp64. Base-N string-to-integer parse widened to double
        assert_eq!(invoke_scalar(Some("FA34"), Some(16)), Some(64052.0));
            arg_fields: vec![
            config_options: Arc::new(Default::default()),
    #[test]
        let mut builder = Float64Builder::with_capacity(n);
use std::hash::{Hash, Hasher};
enum ValueSource<'a> {
            Some("nope"),
    pub fn new() -> Self {
            ColumnarValue::Array(a) => a,
            return Ok(ColumnarValue::Scalar(ScalarValue::Float64(
                Arc::new(Field::new("v", DataType::Utf8, true)),
                Arc::new(Field::new("v", DataType::Utf8, true)),
use crate::udf::json_common::StringArrayView;
        assert!(invoke_scalar(Some("9223372036854775808"), Some(10)).is_none());
            ],
    }
    /// {@code i64::from_str_radix} wants), so the per-row code skips both the
        let values: ValueSource = match (&values_arr_ref, value_col) {
                Arc::new(Field::new("b", DataType::Int32, true)),
    fn base10_integer_doc_example() {
    }
        assert_eq!(f.value(0), 64052.0);
        // avoid a pointless n-wide StringArray allocation.
        ]));
/// Resolve the `base` argument
            Some("nope"),
            exec_err!(
        Ok(ColumnarValue::Array(Arc::new(out) as ArrayRef))
        for i in 0..n {
 */
                ColumnarValue::Scalar(ScalarValue::Int32(None)),
    }
                args.args.len()
//!
    }
    }
        };
 * The OpenSearch Contributors require contributions made to
    /// Base is valid. Carries the validated radix as `u32` (the type
}
}
    fn base_boundary_values() {
            number_rows: 4,
        }
/// Resolved once up front so the hot loop doesn't repeat the scalar dispatch
        assert!(invoke_scalar(Some("10"), Some(0)).is_none());
                    ScalarValue::Utf8(opt)
impl Eq for ToNumberUdf {}
            args: vec![
        Some(base as u32)
    }
            Some("ff"),
        assert_eq!(f.len(), 3);
}
        Self::new()
    /// Base is `NULL` or outside `[2, 36]`. Every output row is NULL regardless
}
                .and_then(|s| i64::from_str_radix(s, radix).ok())
}
        ColumnarValue::Scalar(ScalarValue::Int32(None)) => Ok(BaseMode::AllNull),
}
use datafusion::logical_expr::{
        // Materialize the value column. For scalars we keep the raw &str to
        let args = ScalarFunctionArgs {
        if let (
            ColumnarValue::Scalar(ScalarValue::Int32(b)),
use datafusion::arrow::array::{ArrayRef, Float64Array, Float64Builder};
            config_options: Arc::new(Default::default()),
            number_rows: 3,
    ColumnarValue, ScalarFunctionArgs, ScalarUDF, ScalarUDFImpl, Signature, TypeSignature,
}
fn validate_base(base: i32) -> Option<u32> {
    use super::*;
    }
    fn hash<H: Hasher>(&self, state: &mut H) {
    signature: Signature,
        if args.args.len() != 2 {
                .at(i)
    #[test]
    #[test]
    /// Returns the string at row `i`, or `None`
        let u = ToNumberUdf::new();
    i64::from_str_radix(s, radix).ok().map(|v| v as f64)
        let f = arr.as_primitive::<datafusion::arrow::datatypes::Float64Type>();
            return_field: Arc::new(Field::new(u.name(), DataType::Float64, true)),
    }
            ColumnarValue::Scalar(ScalarValue::Utf8(s)),
        assert!(invoke_scalar(Some("3.14"), Some(10)).is_none());
    #[test]
    fn signature(&self) -> &Signature {
            number_rows: 1,
    fn array_values_with_scalar_base_takes_fast_path() {
            Some("FA34"),
    Volatility,
    }
        }
        let args = ScalarFunctionArgs {
                ColumnarValue::Scalar(ScalarValue::Int32(Some(42))),
                Arc::new(Field::new("b", DataType::Int32, true)),
        let value_col = &args.args[0];
            )
                ColumnarValue::Scalar(ScalarValue::Int32(base)),
        assert!(invoke_scalar(Some(""), Some(10)).is_none());
                ColumnarValue::Array(values),
    Array(StringArrayView<'a>),
            ColumnarValue::Scalar(ScalarValue::Float64(opt)) => opt,
/// How the `value` argument is supplied
            ],
        let values_arr_ref: Option<ArrayRef> = match value_col {
    #[test]
    }
            arg_fields: vec![
        true
        }
                "tonumber expects exactly 2 arguments (string, base), got {}",
                return exec_err!("tonumber: value expected Utf8, got {other:?}");
impl ToNumberUdf {
pub struct ToNumberUdf {
            match values
#[derive(Debug)]
fn resolve_base(base_col: &ColumnarValue) -> Result<BaseMode> {
        assert_eq!(invoke_scalar(Some("fa34"), Some(16)), Some(64052.0));
        assert!(invoke_scalar(Some("10"), None).is_none());
/// or the range check on every row.
        };
        assert!(invoke_scalar(Some("10"), Some(37)).is_none());
        assert_eq!(invoke_scalar(Some("+FA"), Some(16)), Some(250.0));
        assert_eq!(invoke_scalar(Some("-21"), Some(10)), Some(-21.0));
                vec![TypeSignature::Exact(vec![DataType::Utf8, DataType::Int32])],
                ColumnarValue::Scalar(ScalarValue::Utf8(value.map(|s| s.to_string()))),
