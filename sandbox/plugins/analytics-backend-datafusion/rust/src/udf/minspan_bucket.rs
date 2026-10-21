        assert_eq!(n, maxes.len());
        // minSpan=0.5 → minspanWidth=10^0=1
/*
                DataType::Float64,
            arg_fields,
        }
        }
    #[test]
    let minspan_width = 10f64.powf(min_span.log10().ceil());
//! * `defaultWidth  = 10^floor(log10(range))` — round range DOWN to next
                DataType::Float64,
        )
fn format_range(bin_start: f64, bin_end: f64, span: f64) -> String {
//! Semantics:
        let udf = MinspanBucketUdf::new();
            arg_types,
    }
        let s = a.as_string::<i32>();
        assert_eq!(a, b);
        // 0.1 >= 0.5 false → width=1
    // use minspan_width so every bin is at least minSpan wide.
    #[test]
    fn batch_null_in_any_slot_propagates_null() {
 */
        assert_eq!(
 * The OpenSearch Contributors require contributions made to
        // width 0.1: non-integer → 2dp → "0.10-0.20"
        // slots are not applicable here (Java algorithm uses minSpan as a
        };
/// `MinspanBucketFunction.calculateMinspanBucket`.
            .unwrap(),
        }
        default_width
        let args = ScalarFunctionArgs {
                DataType::Int32,
//! histogram bucket label.
    }
    #[test]
    let bin_start = (value / width).floor() * width;
    }
    }
    #[test]
                min_span.value(i),
    }
                continue;
    fn non_finite_min_span_returns_null() {
    } else {
}
                DataType::Float64
//!   power of 10
                "minspan_bucket expects 4 arguments, got {}",
        );
    fn name(&self) -> &str {
    #[test]
    let bin_end = bin_start + width;
            Some("0.10-0.20".to_string())
    ctx.register_udf(ScalarUDF::from(MinspanBucketUdf::new()));
    }
use super::{coerce_args, CoerceMode};
                None => builder.append_null(),
pub struct MinspanBucketUdf {
    signature: Signature,
            "minspan_bucket",
//! avoids.
                DataType::Float64,
        let min_span = downcast_f64(&min_span, "min_span")?;
            return plan_err!(
}
                CoerceMode::Float64,
    fn non_finite_range_returns_null() {
        let range = args.args[2].clone().into_array(n)?;
    fn max_value_is_ignored_in_current_algorithm() {
//!
        let max_value = downcast_f64(&max_value, "max_value")?;
}
    }
        );
            panic!("expected array")
            signature: Signature::user_defined(Volatility::Immutable),
        "minspan_bucket"
        let udf = MinspanBucketUdf::new();
}
        // 1 >= 0.05 → width=1 (integer)
            vec![Some(100.0), Some(100.0), None, Some(100.0), Some(100.0)],
        return None;
        let max_value = args.args[3].clone().into_array(n)?;
    #[test]
use datafusion::execution::context::SessionContext;
        // later adds max_value into the algorithm (as width_bucket does),
//! but kept for compatibility` comment). Removing it from the Rust signature
        // this test reminds them to audit Java semantics first.
use datafusion::arrow::datatypes::DataType;
                } else {
/// `_max_value` is unused but preserved in the signature to match Java's
    }
    ColumnarValue, ScalarFunctionArgs, ScalarUDF, ScalarUDFImpl, Signature, Volatility,
                }
        let mut builder = StringBuilder::with_capacity(n, n * 16);
//! half-open bucket `[binStart, binEnd)` containing `value` as a VARCHAR label.
}
    }
            Some("0-100".to_string())
use datafusion::arrow::array::{Array, ArrayRef, Float64Array, StringBuilder};
//!
                arg_types.len()
        minspan_width
    fn coerce_types_rejects_non_numeric() {
    }
fn is_integer_value(v: f64) -> bool {
            Arc::new(Field::new("max_value", DataType::Float64, true)),
        4
    }
        );
    }
        assert_eq!(calculate(0.7, 0.05, 1.0, 1.0), Some("0-1".to_string()));
                    None
        let ColumnarValue::Array(a) = out else {
            Arc::new(Field::new("value", DataType::Float64, true)),
    }
    if is_integer_span(span) && is_integer_value(bin_start) && is_integer_value(bin_end) {
    fn signature(&self) -> &Signature {
                DataType::Float64,
    }
    }
impl MinspanBucketUdf {
        // minSpan=3 → minspanWidth=10^1=10
            config_options: Arc::new(Default::default()),
                CoerceMode::Float64,
            if value.is_null(i) || min_span.is_null(i) || range.is_null(i) || max_value.is_null(i) {
    fn negative_min_span_returns_null() {
    fn invoke_batch(
        let return_field = Arc::new(Field::new("out", DataType::Utf8, true));
    #[test]
        maxes: Vec<Option<f64>>,
    // ── `defaultWidth < minSpan` branch (user floor wins) ──────────────────
                ColumnarValue::Array(Arc::new(Float64Array::from(min_spans)) as ArrayRef),
        let udf = MinspanBucketUdf::new();
fn is_integer_span(span: f64) -> bool {
//! The `max_value` argument is carried through the signature for PPL call-shape
    fn return_type_enforces_four_arg_arity() {
    }
    // ── min_span guards ────────────────────────────────────────────────────
            match calculate(
    }
    }
        ))
                DataType::Utf8,
    #[test]
        let out = udf
//! and a minimum-span floor, picks the larger of the data's natural order-of-
        let range = downcast_f64(&range, "data_range")?;
            ])
            .coerce_types(&[
                ColumnarValue::Array(Arc::new(Float64Array::from(ranges)) as ArrayRef),
    //! `MinspanBucketFunction.calculateMinspanBucket`. Where the branching
}
        // results must be identical. This is a regression guard: if someone
    }
fn calculate(value: f64, min_span: f64, range: f64, _max_value: f64) -> Option<String> {
            ]
        let n = args.number_rows;
        // numeric floor, not an integer count).
        min_spans: Vec<Option<f64>>,
        2
                DataType::Float64,
        let n = values.len();
        // minSpan=3 → minspanWidth=10
    } else {
                ColumnarValue::Array(Arc::new(Float64Array::from(maxes)) as ArrayRef),
            vec![Some(3.0), None, Some(3.0), Some(3.0), Some(3.0)],
        assert_eq!(calculate(5.0, 0.0, 100.0, 100.0), None);
mod tests {
        let out = udf.invoke_with_args(args).unwrap();
        // value=15 → binStart=10, binEnd=20 → "10-20"
                    Some(s.value(i).to_string())
                DataType::Float32,
                value.value(i),
            "minspan_bucket: slot '{slot}' expected Float64 post-coerce, got {:?}",
        ranges: Vec<Option<f64>>,
        assert_eq!(calculate(5.0, 3.0, f64::NAN, 100.0), None);
    fn default() -> Self {
///
    use super::*;
use datafusion::logical_expr::{
                DataType::Float64,
/// Core minspan-bucket math. Direct port of Java
            .collect()
        coerce_args(
use datafusion::error::{DataFusionError, Result};
// same rationale documented on width_bucket's format_range.
        Self::new()
    #[test]
            out,
        // 0.1 >= 0.05 → width=0.1
            Arc::new(Field::new("data_range", DataType::Float64, true)),
//! `sql/core/.../binning/MinspanBucketFunction.java`). Given a numeric value
}
        );
        // All 4 slots Float64 post-coerce — matches `span_bucket` /
        let decimals = decimal_places_for(span);
    #[test]
    }
    pub fn new() -> Self {
    // ── Formatter coverage — non-integer widths ────────────────────────────
    }
    use datafusion::logical_expr::ScalarFunctionArgs;
    fn minspan_width_applied_even_when_value_outside_range() {
    } else if span >= 0.01 {
    // ── range guards ───────────────────────────────────────────────────────
        Ok(ColumnarValue::Array(Arc::new(builder.finish()) as ArrayRef))
        format!("{}-{}", bin_start as i64, bin_end as i64)
        // range=1.0 → defaultWidth=10^floor(0)=10^0=1
        assert_eq!(calculate(5.0, f64::INFINITY, 100.0, 100.0), None);
//!   dominates)
    fn default_width_wins_produces_label_covering_full_range() {
//!   power of 10
    }
        let arg_fields = vec![
            Arc::new(Field::new("min_span", DataType::Float64, true)),
            return plan_err!(
    }
                if s.is_null(i) {
            ])
                DataType::Float64,
    // ── Batch layer: null propagation ──────────────────────────────────────
        // `width_bucket`'s downcast-once contract. num_bins-like integer
                DataType::Float64,
}
/// 4-arg API (which has the same no-op parameter). See module doc.
use datafusion::common::plan_err;
 * this file be licensed under the Apache-2.0 license or a
pub fn register_all(ctx: &SessionContext) {
fn decimal_places_for(span: f64) -> usize {
                args.args.len()
                builder.append_null();
    let width = if default_width >= min_span {
    // ── `defaultWidth >= minSpan` branch (data's order-of-magnitude wins) ──
        1
    #[test]
        // value=0.17 → binStart = floor(0.17/0.1)*0.1 = floor(1.7)*0.1 = 0.1, binEnd=0.2
}
        // range=0.3 → defaultWidth=10^-1=0.1 (log10(0.3) ≈ -0.523, floor=-1)
    })
        assert_eq!(calculate(5.0, 3.0, f64::INFINITY, 100.0), None);
    span.is_finite() && span == span.floor()
                Some(s) => builder.append_value(&s),
        &self.signature
    // ── max_value is ignored (per Java's // currently unused comment) ──────
//! `minspan_bucket(value, min_span, data_range, max_value)` — minimum-span
    // Java: `useDefault = defaultWidth >= minSpan`, i.e. data's natural order-
        assert_eq!(calculate(5.0, 3.0, 0.0, 100.0), None);
            vec![Some(100.0), Some(100.0), Some(100.0), None, Some(100.0)],
    // ── coerce_types ───────────────────────────────────────────────────────
                CoerceMode::Float64,
    fn return_type(&self, arg_types: &[DataType]) -> Result<DataType> {
// Same formatter as span_bucket / width_bucket; duplicated locally per the
//! * Same integer/float label formatting as `span_bucket` / `width_bucket`
        let c = calculate(15.0, 3.0, 100.0, -1.0);
 *
    }
    //! Expected values seeded from Java reference
        assert_eq!(out, vec![None, None, None, None, Some("0-100".to_string())]);
    let default_width = 10f64.powf(range.log10().floor());
    fn negative_range_returns_null() {
            ],
        for i in 0..n {
        assert_eq!(a, Some("0-100".to_string()));
                range.value(i),
        // range=100 → defaultWidth=10^2=100
        format!("{:.*}-{:.*}", decimals, bin_start, decimals, bin_end)
    #[test]
            vec![None, Some(5.0), Some(5.0), Some(5.0), Some(5.0)],
        let out = invoke_batch(
    #[test]
        assert_eq!(
    };
        Self {
                DataType::Float64,
            &[
        assert_eq!(a, c);
            udf.return_type(&[
                DataType::Float64,
};
        assert_eq!(calculate(5.0, -1.0, 100.0, 100.0), None);
 * compatible open source license.
#[cfg(test)]
    #[test]
            vec![
//! parity but is unused by the algorithm (matches Java's `// currently unused
        // 100 >= 3 → width=100
        let udf = MinspanBucketUdf::new();
}
    use datafusion::arrow::array::AsArray;
    fn minspan_width_wins_when_range_narrow_relative_to_min_span() {
                CoerceMode::Float64,
        assert_eq!(calculate(15.0, 3.0, 5.0, 5.0), Some("10-20".to_string()));
            calculate(15.0, 3.0, 100.0, 100.0),
            }
        // Tests that the UDF doesn't gate on value being inside [0, range].
            ) {
        let a = calculate(15.0, 3.0, 100.0, 100.0);
    } else {
        // Same (value, min_span, range) with different max_value values —
        let value = args.args[0].clone().into_array(n)?;
        assert!(udf
        };
impl ScalarUDFImpl for MinspanBucketUdf {
    ) -> Vec<Option<String>> {
#[derive(Debug, PartialEq, Eq, Hash)]
    (v - v.round()).abs() < 1e-10
    }
        assert_eq!(calculate(5.0, f64::NAN, 100.0, 100.0), None);
    fn zero_min_span_returns_null() {
        assert!(udf.return_type(&[DataType::Float64]).is_err());
            .coerce_types(&[DataType::Float64, DataType::Float64, DataType::Float64])
        );
use std::sync::Arc;
    fn float_width_uses_decimal_format() {
            }
        assert!(udf
        assert_eq!(calculate(5.0, 3.0, -1.0, 100.0), None);
    //! invariant being exercised.
            number_rows: n,
        // minSpan=0.05 → minspanWidth=0.1
        3
        values: Vec<Option<f64>>,
            );
    if !width.is_finite() || width <= 0.0 {
            .unwrap();
    // defaultWidth = 10^floor(log10(range)) — round range down to next power of 10.
        let min_span = args.args[1].clone().into_array(n)?;
impl Default for MinspanBucketUdf {
        // range=0.3 → defaultWidth=10^-1=0.1
    if !range.is_finite() || range <= 0.0 {
    }
        // value=0.7 → binStart=0, binEnd=1 → "0-1"
    #[test]
            })
            DataType::Utf8
        assert_eq!(n, min_spans.len());
        Ok(DataType::Utf8)
    fn zero_range_returns_null() {
        let value = downcast_f64(&value, "value")?;
//! Ports the OpenSearch-SQL bespoke `MINSPAN_BUCKET` UDF (see
            .map(|i| {
        // range=5 → defaultWidth=10^0=1
    //! matters (use_default vs. use_minspan), the test names describe the
            arr.data_type()
    }
//! * `range <= 0` or non-finite → null
        // value=42 → binStart=42, binEnd=43 → "42-43"
    fn coerce_types_rejects_wrong_arity() {
    // of-magnitude width is already at least minSpan, so use it; otherwise
}
    }
    fn coerce_types(&self, arg_types: &[DataType]) -> Result<Vec<DataType>> {
//! magnitude width and the user-requested minimum span, then returns the
    } else if span >= 0.1 {
        if arg_types.len() != 4 {
            .is_err());
            ],
                DataType::Int64,
        assert_eq!(calculate(5.0, f64::NEG_INFINITY, 100.0, 100.0), None);
        if args.args.len() != 4 {
        // value=15 → binStart=0, binEnd=100 → "0-100"
        assert_eq!(n, ranges.len());
    }
    if span >= 1.0 {
            calculate(0.17, 0.05, 0.3, 0.3),
}
                DataType::Float64
//! * Pick `defaultWidth` when `defaultWidth >= minSpan` (range already
    fn coerce_types_canonicalises_mixed_numeric_inputs() {
        return None;
            return_field,
    if !min_span.is_finite() || min_span <= 0.0 {
    fn default_width_wins_when_range_is_order_of_magnitude_above_min_span() {
    use datafusion::arrow::datatypes::Field;
            .coerce_types(&[
        assert_eq!(calculate(42.0, 0.5, 0.3, 0.3), Some("42-43".to_string()));
 * SPDX-License-Identifier: Apache-2.0
        let udf = MinspanBucketUdf::new();
    #[test]
            .is_err());
//!
    fn invoke_with_args(&self, args: ScalarFunctionArgs) -> Result<ColumnarValue> {
    // minspanWidth = 10^ceil(log10(minSpan)) — round minSpan up to next power of 10.
                ColumnarValue::Array(Arc::new(Float64Array::from(values)) as ArrayRef),
            ])
        let b = calculate(15.0, 3.0, 100.0, 99999.0);
    #[test]
        }
//! would require diverging from PPL's emit pattern, which this port explicitly
    arr.as_any().downcast_ref::<Float64Array>().ok_or_else(|| {
        // 1 >= 3 false → width=10
                "minspan_bucket expects 4 arguments, got {}",
        assert_eq!(
            );
        ];
//! * `minspanWidth = 10^ceil(log10(minSpan))` — round minSpan UP to next
            args: vec![
fn downcast_f64<'a>(arr: &'a ArrayRef, slot: &str) -> Result<&'a Float64Array> {
//! * `minSpan <= 0` → null (Java: `minSpan <= 0` check)
    }
        DataFusionError::Internal(format!(
        return None;
// ─── tests ──────────────────────────────────────────────────────────────────
    Some(format_range(bin_start, bin_end, width))
                max_value.value(i),
        (0..n)
        assert_eq!(
//!   produces coarse-enough bins); otherwise `minspanWidth` (user constraint
        // minSpan=0.05 → minspanWidth=10^ceil(-1.301)=10^-1=0.1
