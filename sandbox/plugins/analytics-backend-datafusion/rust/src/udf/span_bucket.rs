        // → binStart=0.01, binEnd=0.015.
 *
    }
    use super::*;
            .collect()
            ],
            }
        let ColumnarValue::Array(a) = out else {
//! as a VARCHAR label like `"10-20"` or `"3.0-4.5"`.
        let udf = SpanBucketUdf::new();
    #[test]
//! * `binEnd   = binStart + span`
        // The bin is half-open [start, end), so boundary value maps to upper bin.
    }
        assert_eq!(calculate(0.0, 10.0), Some("0-10".to_string()));
//! Semantics:
        }
        let out = invoke_batch(
        assert_eq!(calculate(0.17, 0.05), Some("0.150-0.200".to_string()));
    pub fn new() -> Self {
        let out = invoke_batch(vec![Some(15.0), Some(25.0)], vec![None, Some(10.0)]);
        1
impl Default for SpanBucketUdf {
//! This is NOT the standard-SQL `width_bucket` / Calcite `SPAN_BUCKET`; it's a
    fn invoke_batch(values: Vec<Option<f64>>, spans: Vec<Option<f64>>) -> Vec<Option<String>> {
        (0..n)
use datafusion::execution::context::SessionContext;
impl ScalarUDFImpl for SpanBucketUdf {
 */
        assert_eq!(calculate(-5.0, 10.0), Some("-10-0".to_string()));
    fn name(&self) -> &str {
            })?;
    if span >= 1.0 {
        assert_eq!(
    Some(format_range(bin_start, bin_end, span))
        assert_eq!(calculate(0.013, 0.005), Some("0.0100-0.0150".to_string()));
    }
            config_options: Arc::new(Default::default()),
/// otherwise flow through `floor` / `is_integer_span` and produce garbage
use datafusion::error::{DataFusionError, Result};
#[derive(Debug, PartialEq, Eq, Hash)]
    fn signature(&self) -> &Signature {
        assert_eq!(values.len(), spans.len());
        let span = args.args[1].clone().into_array(n)?;
}
        let out = udf
    // ── Batch invocation via DataFusion scalar harness ─────────────────────
        // floor(-5/10) = -1 → binStart = -10, binEnd = 0.
        let s = a.as_string::<i32>();
        assert_eq!(out, vec![None, Some("20-30".to_string())]);
}
        let span = span
}
                continue;
    span.is_finite() && span == span.floor()
    fn coerce_types(&self, arg_types: &[DataType]) -> Result<Vec<DataType>> {
                Some("-10-0".to_string())
        // matches Java's `span <= 0` behaviour and subtraitupdates's impl
        4
use datafusion::arrow::datatypes::DataType;
            vec![Some(42.0), Some(42.0), Some(42.0)],
    #[test]
                    span.data_type()
    }
        let mut builder = StringBuilder::with_capacity(n, n * 16);
            }
            .downcast_ref::<Float64Array>()
            match calculate(value.value(i), span.value(i)) {
        assert_eq!(out, vec![None, None, Some("40-45".to_string())]);
            "span_bucket",
    use std::sync::Arc;
            vec![Some(15.0), Some(0.0), Some(-5.0)],
    fn negative_value_rounds_down_toward_negative_infinity() {
use datafusion::common::plan_err;
    fn nan_span_returns_null() {
        }
        let udf = SpanBucketUdf::new();
        let span_arr = Arc::new(Float64Array::from(spans)) as ArrayRef;
            .downcast_ref::<Float64Array>()
    // not by `calculate`. Covered indirectly in batch tests below.
    }
    #[test]
    let bin_end = bin_start + span;
        let decimals = decimal_places_for(span);
    fn batch_happy_path_renders_each_row_independently() {
        }
    fn coerce_types_rejects_string_input() {
}
            panic!("expected array")
            .coerce_types(&[DataType::Utf8, DataType::Float64])
        coerce_args(
        assert_eq!(calculate(3.7, 1.5), Some("3.0-4.5".to_string()));
        assert_eq!(calculate(42.0, -1.0), None);
//!
            .is_err());
                ColumnarValue::Array(span_arr),
//! PPL-specific binning helper that returns the bucket *label* (not a bucket
    use datafusion::logical_expr::ScalarFunctionArgs;
    fn invoke_with_args(&self, args: ScalarFunctionArgs) -> Result<ColumnarValue> {
    fn batch_nonpositive_span_produces_null_not_error() {
        // Covers NaN (is_finite false), ±Inf (is_finite false), zero, and negatives.
    }
        // Negative on boundary: floor(-10/10) = -1 → binStart = -10.
                    None
        if args.args.len() != 2 {
            out,
                ))
                } else {
/// `SpanBucketFunction.calculateSpanBucket`.
    // Handled by the caller (`invoke_with_args`) via arrow null-bitmap checks,
            udf.return_type(&[DataType::Float64, DataType::Float64])
    // Matches Java `span == Math.floor(span) && !Double.isInfinite(span)`.
    }
}
    if is_integer_span(span) && is_integer_value(bin_start) && is_integer_value(bin_end) {
            arg_types,
    fn integer_value_and_span_render_as_long_range() {
                Some("0-10".to_string()),
        // span=0.005 → 4dp. floor(0.013/0.005) = floor(2.6) = 2
    }
    #[test]
}
fn is_integer_value(v: f64) -> bool {
    }
                    Some(s.value(i).to_string())
        assert_eq!(calculate(20.0, 10.0), Some("20-30".to_string()));
 * The OpenSearch Contributors require contributions made to
/// Core span-bucket math. Direct port of Java
        );
}
        };
                    "span_bucket: span expected Float64, got {:?}",
        // `span > 0.0` is true for +Inf but `is_integer_span` would say "no"
}
    #[test]
//!
    use datafusion::arrow::array::AsArray;
                }
        // (which additionally explicitly checks `span.is_finite()`).
            })?;
    //! Expected values seeded from the Java reference
            })
        // span=0.1. floor(0.25/0.1) = floor(2.5) = 2 → binStart=0.2, binEnd=0.3.
    }
    #[test]
    fn span_below_point_zero_one_renders_four_decimals() {
    }
        // floor(-0.1/10) = -1 → binStart = -10, binEnd = 0.
                    "span_bucket: value expected Float64, got {:?}",
    #[test]
    fn return_type(&self, arg_types: &[DataType]) -> Result<DataType> {
//! `sql/core/.../binning/SpanBucketFunction.java`). Given a numeric value and a
                if s.is_null(i) {
    fn span_between_point_zero_one_and_point_one_renders_three_decimals() {
                Some(s) => builder.append_value(&s),
            vec![Some(10.0), Some(10.0), Some(10.0)],
    // ── Integer path ───────────────────────────────────────────────────────
    #[test]
        assert_eq!(calculate(42.0, f64::NAN), None);
    fn value_on_bin_boundary_belongs_to_upper_bin() {
        // Java reference which boxes to `Number` and calls `doubleValue()`.
    }
        // Java: floor(10.0 / 10.0) = 1.0 → binStart = 10, binEnd = 20.
        // Both args canonicalised to Float64 via `coerce_types` — matches the
        Self {
        let arg_fields = vec![
            ]
pub struct SpanBucketUdf {
            .unwrap();
        // span=0.05 (< 0.1, >= 0.01) → 3dp. floor(0.17/0.05) = floor(3.4) = 3
    // ── Null-producing inputs ──────────────────────────────────────────────
        );
    }
        let n = values.len();
/// Returns `None` when `span` is non-finite (NaN or ±Inf) or non-positive.
    #[test]
    // ── Floating-point path — decimal places from span magnitude ───────────
//!
        assert_eq!(calculate(25.0, 10.0), Some("20-30".to_string()));
mod tests {
                DataFusionError::Internal(format!(
/// labels (division by +Inf → 0, `0 + Inf = Inf`, formatting Inf as f64
/// yields `"inf-inf"`). Match the subtraitupdates port which adds the
        return None;
            arg_fields,
    }
//!   chosen by `span` magnitude (>=1 → 1dp, >=0.1 → 2dp, >=0.01 → 3dp, else 4dp)
    }
};
    } else if span >= 0.01 {
use super::{coerce_args, CoerceMode};
    #[test]
    ColumnarValue, ScalarFunctionArgs, ScalarUDF, ScalarUDFImpl, Signature, Volatility,
        2
                .unwrap(),
// ─── tests ──────────────────────────────────────────────────────────────────
            return_field,
//! positive numeric `span`, returns the half-open bucket `[binStart, binEnd)`
impl SpanBucketUdf {
            DataType::Utf8
        format!("{}-{}", bin_start as i64, bin_end as i64)
        "span_bucket"
//! * `span <= 0` → null (Java returns null, matches).
 * SPDX-License-Identifier: Apache-2.0
//! * `binStart = floor(value / span) * span`
        // → binStart=0.15, binEnd=0.2.
fn is_integer_span(span: f64) -> bool {
    #[test]
        assert!(udf.return_type(&[DataType::Float64]).is_err());
    }
/*
            .ok_or_else(|| {
        assert_eq!(calculate(0.25, 0.1), Some("0.20-0.30".to_string()));
fn format_range(bin_start: f64, bin_end: f64, span: f64) -> String {
    if !span.is_finite() || span <= 0.0 {
        assert_eq!(calculate(-10.0, 10.0), Some("-10-0".to_string()));
    }
        let udf = SpanBucketUdf::new();
    }
        for i in 0..n {
            vec![Some(0.0), Some(-1.0), Some(5.0)],
    #[test]
        )
        Self::new()
//! `span_bucket(value, span)` — fixed-width bucket label.
///
        let n = args.number_rows;
    fn infinite_span_returns_null() {
}
        let args = ScalarFunctionArgs {
            .map(|i| {
    fn non_integer_span_gte_one_renders_one_decimal() {
            .coerce_types(&[DataType::Int32, DataType::Int64])
 * this file be licensed under the Apache-2.0 license or a
    }
    fn negative_span_returns_null() {
    signature: Signature,
            .return_type(&[DataType::Float64, DataType::Float64, DataType::Float64])
        let value_arr = Arc::new(Float64Array::from(values)) as ArrayRef;
        assert_eq!(out, vec![DataType::Float64, DataType::Float64]);
fn decimal_places_for(span: f64) -> usize {
            number_rows: n,
    }
/// `is_finite()` guard explicitly.
    }
            return plan_err!("span_bucket expects 2 arguments, got {}", args.args.len());
        let return_field = Arc::new(Field::new("out", DataType::Utf8, true));
        assert_eq!(calculate(42.0, f64::NEG_INFINITY), None);
//! * Any null input → null (null propagation, matches Java's `NullPolicy.ANY`).
    }
        assert_eq!(calculate(15.0, 10.0), Some("10-20".to_string()));
    // ── Edge: value is null / span is null ─────────────────────────────────
use datafusion::arrow::array::{Array, ArrayRef, Float64Array, StringBuilder};
//! index). Any PPL `bin span=<n>` command routes through here.
    //! Java implementation is a bug in the port, not the test.
        let udf = SpanBucketUdf::new();
    // Matches Java `Math.abs(v - Math.round(v)) < 1e-10`.
        &self.signature
    use datafusion::arrow::datatypes::Field;
        if arg_types.len() != 2 {
        let out = invoke_batch(vec![None, Some(15.0)], vec![Some(10.0), Some(10.0)]);
 * compatible open source license.
//! * Label is rendered with integer formatting when `span` is an integer and
        // and we'd fall into the float formatter, producing garbage. Guard
        3
use std::sync::Arc;
    #[test]
    }
    fn coerce_types_canonicalises_mixed_numeric_inputs() {
    fn zero_span_returns_null() {
        assert_eq!(calculate(10.0, 10.0), Some("10-20".to_string()));
        format!("{:.*}-{:.*}", decimals, bin_start, decimals, bin_end)
            .as_any()
        // span=1.5 → 1dp. floor(3.7/1.5)=2 → binStart=3.0, binEnd=4.5.
    }
    // ── coerce_types accepts every integer/float source ────────────────────
    } else {
                ColumnarValue::Array(value_arr),
    let bin_start = (value / span).floor() * span;
/// The Java reference only checks `span <= 0`, but an infinite span would
                Some("10-20".to_string()),
                None => builder.append_null(),
pub fn register_all(ctx: &SessionContext) {
            .ok_or_else(|| {
fn calculate(value: f64, span: f64) -> Option<String> {
        Ok(ColumnarValue::Array(Arc::new(builder.finish()) as ArrayRef))
use datafusion::logical_expr::{
            .is_err());
        assert!(udf
    }
    }
        assert_eq!(
}
//!   to match the Java reference.
        let out = udf.invoke_with_args(args).unwrap();
            signature: Signature::user_defined(Volatility::Immutable),
//! Ports the OpenSearch-SQL bespoke `SPAN_BUCKET` UDF (see
    fn batch_null_value_propagates_null() {
    #[test]
    }
            vec![
    #[test]
        }
    fn return_type_enforces_two_arg_arity() {
    }
    } else {
        let out = invoke_batch(
        assert_eq!(calculate(42.0, 0.0), None);
    fn span_between_point_one_and_one_renders_two_decimals() {
            return plan_err!("span_bucket expects 2 arguments, got {}", arg_types.len());
        assert_eq!(out, vec![None, Some("10-20".to_string())]);
#[cfg(test)]
        Ok(DataType::Utf8)
        assert!(udf
}
            if value.is_null(i) || span.is_null(i) {
    fn default() -> Self {
            Arc::new(Field::new("span", DataType::Float64, true)),
    #[test]
    } else if span >= 0.1 {
    }
        assert_eq!(calculate(42.0, f64::INFINITY), None);
        assert_eq!(calculate(-0.1, 10.0), Some("-10-0".to_string()));
        );
            Arc::new(Field::new("value", DataType::Float64, true)),
            args: vec![
                builder.append_null();
    (v - v.round()).abs() < 1e-10
//!   both bounds are integer-valued; otherwise floating with decimal places
    //! `SpanBucketFunction.calculateSpanBucket` — any behavioural drift from the
                    value.data_type()
        ];
        };
            &[CoerceMode::Float64, CoerceMode::Float64],
    #[test]
    #[test]
            .as_any()
        let value = args.args[0].clone().into_array(n)?;
    fn batch_null_span_propagates_null() {
        // Integer path — match Java `String.format("%d-%d", (long)...)`.
                ))
    ctx.register_udf(ScalarUDF::from(SpanBucketUdf::new()));
        let value = value
                DataFusionError::Internal(format!(
        );
