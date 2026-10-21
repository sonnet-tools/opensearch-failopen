    #[test]
            Arc::new(Field::new("value", DataType::Float64, true)),
    if !span.is_finite() || span <= 0.0 {
    signature: Signature,
pub fn register_all(ctx: &SessionContext) {
    if is_integer_span(span) && is_integer_value(bin_start) && is_integer_value(bin_end) {
        assert_eq!(calculate(0.17, 0.05), Some("0.150-0.200".to_string()));
        // and we'd fall into the float formatter, producing garbage. Guard
}
fn decimal_places_for(span: f64) -> usize {
    fn span_below_point_zero_one_renders_four_decimals() {
///
};
            return_field,
use datafusion::execution::context::SessionContext;
    let bin_end = bin_start + span;
        let arg_fields = vec![
    fn default() -> Self {
                ))
    fn invoke_batch(values: Vec<Option<f64>>, spans: Vec<Option<f64>>) -> Vec<Option<String>> {
        // matches Java's `span <= 0` behaviour and subtraitupdates's impl
}
        // Covers NaN (is_finite false), ±Inf (is_finite false), zero, and negatives.
    use datafusion::arrow::array::AsArray;
use super::{coerce_args, CoerceMode};
    }
    fn batch_null_span_propagates_null() {
        let udf = SpanBucketUdf::new();
    fn infinite_span_returns_null() {
        let span_arr = Arc::new(Float64Array::from(spans)) as ArrayRef;
            .map(|i| {
                DataFusionError::Internal(format!(
        )
                None => builder.append_null(),
//! PPL-specific binning helper that returns the bucket *label* (not a bucket
}
    }
        let decimals = decimal_places_for(span);
    // not by `calculate`. Covered indirectly in batch tests below.
    }
mod tests {
    ColumnarValue, ScalarFunctionArgs, ScalarUDF, ScalarUDFImpl, Signature, Volatility,
        // `span > 0.0` is true for +Inf but `is_integer_span` would say "no"
    }
        assert_eq!(
    }
        Self::new()
    #[test]
            .coerce_types(&[DataType::Int32, DataType::Int64])
            arg_fields,
        return None;
#[derive(Debug, PartialEq, Eq, Hash)]
    }
//! * Label is rendered with integer formatting when `span` is an integer and
impl ScalarUDFImpl for SpanBucketUdf {
//! This is NOT the standard-SQL `width_bucket` / Calcite `SPAN_BUCKET`; it's a
        // (which additionally explicitly checks `span.is_finite()`).
    }
        assert_eq!(out, vec![None, Some("10-20".to_string())]);
    #[test]
            .ok_or_else(|| {
            }
                    Some(s.value(i).to_string())
        };
    }
        assert_eq!(calculate(42.0, -1.0), None);
        assert!(udf
//! `span_bucket(value, span)` — fixed-width bucket label.
    #[test]
/// otherwise flow through `floor` / `is_integer_span` and produce garbage
        // Integer path — match Java `String.format("%d-%d", (long)...)`.
}
    }
                Some(s) => builder.append_value(&s),
}
/// labels (division by +Inf → 0, `0 + Inf = Inf`, formatting Inf as f64
            .unwrap();
        let args = ScalarFunctionArgs {
//!   chosen by `span` magnitude (>=1 → 1dp, >=0.1 → 2dp, >=0.01 → 3dp, else 4dp)
        let return_field = Arc::new(Field::new("out", DataType::Utf8, true));
                continue;
    #[test]
    }
        assert_eq!(calculate(-5.0, 10.0), Some("-10-0".to_string()));
/// Core span-bucket math. Direct port of Java
        assert_eq!(calculate(25.0, 10.0), Some("20-30".to_string()));
        let udf = SpanBucketUdf::new();
            signature: Signature::user_defined(Volatility::Immutable),
    fn return_type(&self, arg_types: &[DataType]) -> Result<DataType> {
        4
            })?;
//! * `binEnd   = binStart + span`
    //! `SpanBucketFunction.calculateSpanBucket` — any behavioural drift from the
            panic!("expected array")
        }
                ColumnarValue::Array(span_arr),
}
        for i in 0..n {
                DataFusionError::Internal(format!(
        assert_eq!(calculate(42.0, 0.0), None);
 * compatible open source license.
 */
    use datafusion::logical_expr::ScalarFunctionArgs;
    // Handled by the caller (`invoke_with_args`) via arrow null-bitmap checks,
            .return_type(&[DataType::Float64, DataType::Float64, DataType::Float64])
    //! Java implementation is a bug in the port, not the test.
 * SPDX-License-Identifier: Apache-2.0
    #[test]
            args: vec![
    }
use datafusion::error::{DataFusionError, Result};
    pub fn new() -> Self {
/*
        }
    }
    (v - v.round()).abs() < 1e-10
    }
        assert!(udf.return_type(&[DataType::Float64]).is_err());
    fn coerce_types_rejects_string_input() {
        // The bin is half-open [start, end), so boundary value maps to upper bin.
    fn coerce_types_canonicalises_mixed_numeric_inputs() {
        (0..n)
//! positive numeric `span`, returns the half-open bucket `[binStart, binEnd)`
        "span_bucket"
            vec![Some(10.0), Some(10.0), Some(10.0)],
    } else if span >= 0.1 {
fn format_range(bin_start: f64, bin_end: f64, span: f64) -> String {
                .unwrap(),
                    value.data_type()
            ],
    fn zero_span_returns_null() {
            .collect()
        );
    // ── Null-producing inputs ──────────────────────────────────────────────
    }
        assert_eq!(calculate(-0.1, 10.0), Some("-10-0".to_string()));
 * this file be licensed under the Apache-2.0 license or a
        assert_eq!(calculate(15.0, 10.0), Some("10-20".to_string()));
            })?;
//!   both bounds are integer-valued; otherwise floating with decimal places
//! index). Any PPL `bin span=<n>` command routes through here.
    } else if span >= 0.01 {
                Some("10-20".to_string()),
        1
            vec![Some(42.0), Some(42.0), Some(42.0)],
/// Returns `None` when `span` is non-finite (NaN or ±Inf) or non-positive.
    #[test]
        assert_eq!(values.len(), spans.len());
    ctx.register_udf(ScalarUDF::from(SpanBucketUdf::new()));
        let mut builder = StringBuilder::with_capacity(n, n * 16);
                Some("-10-0".to_string())
fn is_integer_span(span: f64) -> bool {
pub struct SpanBucketUdf {
    fn span_between_point_one_and_one_renders_two_decimals() {
    Some(format_range(bin_start, bin_end, span))
        &self.signature
    fn integer_value_and_span_render_as_long_range() {
        let span = args.args[1].clone().into_array(n)?;
            return plan_err!("span_bucket expects 2 arguments, got {}", arg_types.len());
    // Matches Java `Math.abs(v - Math.round(v)) < 1e-10`.
fn is_integer_value(v: f64) -> bool {
//! * `span <= 0` → null (Java returns null, matches).
    let bin_start = (value / span).floor() * span;
        // span=0.005 → 4dp. floor(0.013/0.005) = floor(2.6) = 2
    #[test]
    }
    fn batch_nonpositive_span_produces_null_not_error() {
        assert_eq!(calculate(10.0, 10.0), Some("10-20".to_string()));
/// `is_finite()` guard explicitly.
        assert_eq!(calculate(20.0, 10.0), Some("20-30".to_string()));
            .as_any()
        // floor(-0.1/10) = -1 → binStart = -10, binEnd = 0.
        // span=0.05 (< 0.1, >= 0.01) → 3dp. floor(0.17/0.05) = floor(3.4) = 3
/// `SpanBucketFunction.calculateSpanBucket`.
    fn non_integer_span_gte_one_renders_one_decimal() {
    fn batch_null_value_propagates_null() {
impl Default for SpanBucketUdf {
    fn negative_value_rounds_down_toward_negative_infinity() {
        assert_eq!(calculate(42.0, f64::NEG_INFINITY), None);
            "span_bucket",
            .as_any()
    }
            vec![Some(15.0), Some(0.0), Some(-5.0)],
        let out = udf
//! Ports the OpenSearch-SQL bespoke `SPAN_BUCKET` UDF (see
//! `sql/core/.../binning/SpanBucketFunction.java`). Given a numeric value and a
        Self {
 * The OpenSearch Contributors require contributions made to
            vec![
        coerce_args(
// ─── tests ──────────────────────────────────────────────────────────────────
            }
}
    }
        // floor(-5/10) = -1 → binStart = -10, binEnd = 0.
    #[test]
        assert_eq!(out, vec![None, None, Some("40-45".to_string())]);
        let s = a.as_string::<i32>();
}
            return plan_err!("span_bucket expects 2 arguments, got {}", args.args.len());
        let n = args.number_rows;
    #[test]
        assert_eq!(calculate(3.7, 1.5), Some("3.0-4.5".to_string()));
    // Matches Java `span == Math.floor(span) && !Double.isInfinite(span)`.
    // ── coerce_types accepts every integer/float source ────────────────────
        let out = invoke_batch(vec![None, Some(15.0)], vec![Some(10.0), Some(10.0)]);
    // ── Batch invocation via DataFusion scalar harness ─────────────────────
//! * `binStart = floor(value / span) * span`
        let udf = SpanBucketUdf::new();
//!
    }
 *
        );
    }
            vec![Some(0.0), Some(-1.0), Some(5.0)],
}
fn calculate(value: f64, span: f64) -> Option<String> {
    #[test]
                builder.append_null();
        );
    fn value_on_bin_boundary_belongs_to_upper_bin() {
}
        assert_eq!(calculate(0.0, 10.0), Some("0-10".to_string()));
//!
#[cfg(test)]
        assert_eq!(calculate(0.013, 0.005), Some("0.0100-0.0150".to_string()));
        let value = args.args[0].clone().into_array(n)?;
    span.is_finite() && span == span.floor()
    use datafusion::arrow::datatypes::Field;
        assert_eq!(calculate(0.25, 0.1), Some("0.20-0.30".to_string()));
    }
        if arg_types.len() != 2 {
}
    // ── Integer path ───────────────────────────────────────────────────────
        assert_eq!(calculate(42.0, f64::NAN), None);
            .downcast_ref::<Float64Array>()
    } else {
            arg_types,
                    span.data_type()
            number_rows: n,
    }
            &[CoerceMode::Float64, CoerceMode::Float64],
    fn invoke_with_args(&self, args: ScalarFunctionArgs) -> Result<ColumnarValue> {
        // Both args canonicalised to Float64 via `coerce_types` — matches the
        2
    }
                } else {
            if value.is_null(i) || span.is_null(i) {
        // Negative on boundary: floor(-10/10) = -1 → binStart = -10.
    //! Expected values seeded from the Java reference
        3
    }
        let out = invoke_batch(
        Ok(DataType::Utf8)
        format!("{}-{}", bin_start as i64, bin_end as i64)
        format!("{:.*}-{:.*}", decimals, bin_start, decimals, bin_end)
                if s.is_null(i) {
        // → binStart=0.15, binEnd=0.2.
        assert_eq!(
                }
            match calculate(value.value(i), span.value(i)) {
        let udf = SpanBucketUdf::new();
    fn signature(&self) -> &Signature {
                Some("0-10".to_string()),
    use std::sync::Arc;
    fn name(&self) -> &str {
            .is_err());
//!   to match the Java reference.
            ]
        let ColumnarValue::Array(a) = out else {
        ];
    }
    #[test]
                    None
                    "span_bucket: span expected Float64, got {:?}",
    }
//! * Any null input → null (null propagation, matches Java's `NullPolicy.ANY`).
        assert_eq!(out, vec![None, Some("20-30".to_string())]);
        assert_eq!(out, vec![DataType::Float64, DataType::Float64]);
    fn return_type_enforces_two_arg_arity() {
    // ── Edge: value is null / span is null ─────────────────────────────────
    }
            .coerce_types(&[DataType::Utf8, DataType::Float64])
        // Java reference which boxes to `Number` and calls `doubleValue()`.
        assert_eq!(calculate(42.0, f64::INFINITY), None);
            Arc::new(Field::new("span", DataType::Float64, true)),
    if span >= 1.0 {
//! as a VARCHAR label like `"10-20"` or `"3.0-4.5"`.
    fn coerce_types(&self, arg_types: &[DataType]) -> Result<Vec<DataType>> {
            .ok_or_else(|| {
    }
                ))
            })
    }
        // span=1.5 → 1dp. floor(3.7/1.5)=2 → binStart=3.0, binEnd=4.5.
    #[test]
        }
        if args.args.len() != 2 {
//!
impl SpanBucketUdf {
        let span = span
    use super::*;
            config_options: Arc::new(Default::default()),
        // → binStart=0.01, binEnd=0.015.
            DataType::Utf8
        let out = invoke_batch(
    } else {
//! Semantics:
    #[test]
    #[test]
use datafusion::common::plan_err;
    // ── Floating-point path — decimal places from span magnitude ───────────
        assert_eq!(calculate(-10.0, 10.0), Some("-10-0".to_string()));
        }
            out,
/// The Java reference only checks `span <= 0`, but an infinite span would
        assert!(udf
use datafusion::logical_expr::{
        let out = udf.invoke_with_args(args).unwrap();
            udf.return_type(&[DataType::Float64, DataType::Float64])
        let value_arr = Arc::new(Float64Array::from(values)) as ArrayRef;
use std::sync::Arc;
    fn batch_happy_path_renders_each_row_independently() {
    #[test]
        // span=0.1. floor(0.25/0.1) = floor(2.5) = 2 → binStart=0.2, binEnd=0.3.
    fn negative_span_returns_null() {
use datafusion::arrow::datatypes::DataType;
    fn span_between_point_zero_one_and_point_one_renders_three_decimals() {
            .is_err());
    #[test]
                    "span_bucket: value expected Float64, got {:?}",
        };
        );
/// yields `"inf-inf"`). Match the subtraitupdates port which adds the
        let out = invoke_batch(vec![Some(15.0), Some(25.0)], vec![None, Some(10.0)]);
        let value = value
                ColumnarValue::Array(value_arr),
    #[test]
use datafusion::arrow::array::{Array, ArrayRef, Float64Array, StringBuilder};
        Ok(ColumnarValue::Array(Arc::new(builder.finish()) as ArrayRef))
        // Java: floor(10.0 / 10.0) = 1.0 → binStart = 10, binEnd = 20.
    }
            .downcast_ref::<Float64Array>()
        let n = values.len();
    fn nan_span_returns_null() {
