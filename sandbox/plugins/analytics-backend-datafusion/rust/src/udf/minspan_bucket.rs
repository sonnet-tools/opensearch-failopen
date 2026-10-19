        );
            Some("0.10-0.20".to_string())
//! Semantics:
            })
        format!("{:.*}-{:.*}", decimals, bin_start, decimals, bin_end)
    }
    }
            "minspan_bucket: slot '{slot}' expected Float64 post-coerce, got {:?}",
mod tests {
    }
            ])
                min_span.value(i),
        assert_eq!(calculate(5.0, f64::INFINITY, 100.0, 100.0), None);
        }
    } else {
                ColumnarValue::Array(Arc::new(Float64Array::from(values)) as ArrayRef),
    #[test]
    fn negative_range_returns_null() {
//! Ports the OpenSearch-SQL bespoke `MINSPAN_BUCKET` UDF (see
use datafusion::arrow::array::{Array, ArrayRef, Float64Array, StringBuilder};
            Arc::new(Field::new("value", DataType::Float64, true)),
/// Core minspan-bucket math. Direct port of Java
        let arg_fields = vec![
            );
        assert_eq!(calculate(0.7, 0.05, 1.0, 1.0), Some("0-1".to_string()));
                    None
    // of-magnitude width is already at least minSpan, so use it; otherwise
        // minSpan=0.05 → minspanWidth=0.1
                DataType::Float64,
        }
        1
fn downcast_f64<'a>(arr: &'a ArrayRef, slot: &str) -> Result<&'a Float64Array> {
    }
                DataType::Float64,
        &self.signature
//! * Pick `defaultWidth` when `defaultWidth >= minSpan` (range already
    }
        };
            .coerce_types(&[
            return plan_err!(
    // ── max_value is ignored (per Java's // currently unused comment) ──────
    } else if span >= 0.1 {
    // ── Batch layer: null propagation ──────────────────────────────────────
                DataType::Int64,
    // minspanWidth = 10^ceil(log10(minSpan)) — round minSpan up to next power of 10.
        assert_eq!(
            ])
        // minSpan=0.5 → minspanWidth=10^0=1
    if is_integer_span(span) && is_integer_value(bin_start) && is_integer_value(bin_end) {
    }
        4
//! * `range <= 0` or non-finite → null
//! * `minSpan <= 0` → null (Java: `minSpan <= 0` check)
                arg_types.len()
        Self::new()
    })
    //! matters (use_default vs. use_minspan), the test names describe the
        assert_eq!(calculate(5.0, -1.0, 100.0, 100.0), None);
            vec![Some(3.0), None, Some(3.0), Some(3.0), Some(3.0)],
            );
    fn default() -> Self {
    let width = if default_width >= min_span {
///
//! histogram bucket label.
        assert_eq!(calculate(5.0, 3.0, -1.0, 100.0), None);
            arg_fields,
            signature: Signature::user_defined(Volatility::Immutable),
        ];
 *
    fn max_value_is_ignored_in_current_algorithm() {
        let n = values.len();
    #[test]
        let udf = MinspanBucketUdf::new();
    fn return_type(&self, arg_types: &[DataType]) -> Result<DataType> {
    ColumnarValue, ScalarFunctionArgs, ScalarUDF, ScalarUDFImpl, Signature, Volatility,
            .is_err());
    // ── `defaultWidth < minSpan` branch (user floor wins) ──────────────────
        // slots are not applicable here (Java algorithm uses minSpan as a
        coerce_args(
    #[test]
            &[
        assert_eq!(out, vec![None, None, None, None, Some("0-100".to_string())]);
use datafusion::execution::context::SessionContext;
        (0..n)
        ranges: Vec<Option<f64>>,
                DataType::Float64
        ))
pub fn register_all(ctx: &SessionContext) {
        let max_value = args.args[3].clone().into_array(n)?;
                DataType::Float64,
impl MinspanBucketUdf {
        assert_eq!(calculate(5.0, 3.0, 0.0, 100.0), None);
            vec![
        // All 4 slots Float64 post-coerce — matches `span_bucket` /
 * this file be licensed under the Apache-2.0 license or a
    if !min_span.is_finite() || min_span <= 0.0 {
                DataType::Float64,
    //! invariant being exercised.
    }
        Ok(ColumnarValue::Array(Arc::new(builder.finish()) as ArrayRef))
        "minspan_bucket"
use datafusion::logical_expr::{
            .coerce_types(&[
        values: Vec<Option<f64>>,
fn calculate(value: f64, min_span: f64, range: f64, _max_value: f64) -> Option<String> {
        return None;
        // 0.1 >= 0.05 → width=0.1
    }
                CoerceMode::Float64,
        assert_eq!(calculate(5.0, 3.0, f64::INFINITY, 100.0), None);
        }
impl Default for MinspanBucketUdf {
        // range=5 → defaultWidth=10^0=1
        assert_eq!(a, Some("0-100".to_string()));
        format!("{}-{}", bin_start as i64, bin_end as i64)
    use datafusion::arrow::datatypes::Field;
fn is_integer_value(v: f64) -> bool {
            arg_types,
 * compatible open source license.
                continue;
            }
        // minSpan=3 → minspanWidth=10^1=10
        let udf = MinspanBucketUdf::new();
    }
/// 4-arg API (which has the same no-op parameter). See module doc.
            DataType::Utf8
        assert_eq!(a, c);
        // value=0.7 → binStart=0, binEnd=1 → "0-1"
            ])
}
        let udf = MinspanBucketUdf::new();
    #[test]
            calculate(15.0, 3.0, 100.0, 100.0),
//! magnitude width and the user-requested minimum span, then returns the
            panic!("expected array")
        3
                DataType::Float64,
    //! Expected values seeded from Java reference
        minspan_width
//! `sql/core/.../binning/MinspanBucketFunction.java`). Given a numeric value
    #[test]
 * The OpenSearch Contributors require contributions made to
    }
    }
//! * `defaultWidth  = 10^floor(log10(range))` — round range DOWN to next
    // ── `defaultWidth >= minSpan` branch (data's order-of-magnitude wins) ──
        // Tests that the UDF doesn't gate on value being inside [0, range].
            vec![Some(100.0), Some(100.0), Some(100.0), None, Some(100.0)],
                DataType::Float64
    }
                }
            ],
                CoerceMode::Float64,
        let ColumnarValue::Array(a) = out else {
    } else {
    fn non_finite_min_span_returns_null() {
//! avoids.
}
            match calculate(
impl ScalarUDFImpl for MinspanBucketUdf {
    arr.as_any().downcast_ref::<Float64Array>().ok_or_else(|| {
    span.is_finite() && span == span.floor()
    if span >= 1.0 {
            ]
        let range = args.args[2].clone().into_array(n)?;
    }
    }
        let max_value = downcast_f64(&max_value, "max_value")?;
        assert_eq!(calculate(5.0, 0.0, 100.0, 100.0), None);
                DataType::Utf8,
    #[test]
        // `width_bucket`'s downcast-once contract. num_bins-like integer
            ],
        }
    }
        // range=1.0 → defaultWidth=10^floor(0)=10^0=1
        let args = ScalarFunctionArgs {
                DataType::Float32,
    fn return_type_enforces_four_arg_arity() {
    // Java: `useDefault = defaultWidth >= minSpan`, i.e. data's natural order-
        assert_eq!(calculate(42.0, 0.5, 0.3, 0.3), Some("42-43".to_string()));
    #[test]
        // 100 >= 3 → width=100
    if !range.is_finite() || range <= 0.0 {
            .unwrap();
                DataType::Float64,
        let out = invoke_batch(
            return plan_err!(
    #[test]
#[cfg(test)]
        let mut builder = StringBuilder::with_capacity(n, n * 16);
        assert_eq!(
        min_spans: Vec<Option<f64>>,
fn decimal_places_for(span: f64) -> usize {
    fn coerce_types(&self, arg_types: &[DataType]) -> Result<Vec<DataType>> {
                DataType::Float64,
#[derive(Debug, PartialEq, Eq, Hash)]
    fn minspan_width_wins_when_range_narrow_relative_to_min_span() {
        // value=15 → binStart=10, binEnd=20 → "10-20"
                DataType::Float64,
        let n = args.number_rows;
        2
//!
    }
                "minspan_bucket expects 4 arguments, got {}",
                DataType::Float64,
        // value=42 → binStart=42, binEnd=43 → "42-43"
        DataFusionError::Internal(format!(
        let return_field = Arc::new(Field::new("out", DataType::Utf8, true));
        let out = udf
        };
        // this test reminds them to audit Java semantics first.
            .coerce_types(&[DataType::Float64, DataType::Float64, DataType::Float64])
    }
    }
                DataType::Int32,
    fn signature(&self) -> &Signature {
        let udf = MinspanBucketUdf::new();
// ─── tests ──────────────────────────────────────────────────────────────────
            Arc::new(Field::new("min_span", DataType::Float64, true)),
        // 1 >= 3 false → width=10
    fn default_width_wins_when_range_is_order_of_magnitude_above_min_span() {
        return None;
    Some(format_range(bin_start, bin_end, width))
                    Some(s.value(i).to_string())
    #[test]
    fn zero_min_span_returns_null() {
        Ok(DataType::Utf8)
        // width 0.1: non-integer → 2dp → "0.10-0.20"
    // ── coerce_types ───────────────────────────────────────────────────────
                ColumnarValue::Array(Arc::new(Float64Array::from(min_spans)) as ArrayRef),
        // range=100 → defaultWidth=10^2=100
    #[test]
/// `MinspanBucketFunction.calculateMinspanBucket`.
//! half-open bucket `[binStart, binEnd)` containing `value` as a VARCHAR label.
    } else if span >= 0.01 {
    #[test]
    fn non_finite_range_returns_null() {
        default_width
    }
};
        let value = downcast_f64(&value, "value")?;
//! and a minimum-span floor, picks the larger of the data's natural order-of-
            .map(|i| {
            number_rows: n,
        // 0.1 >= 0.5 false → width=1
    #[test]
    #[test]
//!   dominates)
        // range=0.3 → defaultWidth=10^-1=0.1 (log10(0.3) ≈ -0.523, floor=-1)
    fn coerce_types_rejects_wrong_arity() {
    #[test]
}
    }
        // results must be identical. This is a regression guard: if someone
    // ── Formatter coverage — non-integer widths ────────────────────────────
    use super::*;
            args: vec![
            Some("0-100".to_string())
        let min_span = downcast_f64(&min_span, "min_span")?;
use datafusion::common::plan_err;
        // value=0.17 → binStart = floor(0.17/0.1)*0.1 = floor(1.7)*0.1 = 0.1, binEnd=0.2
        );
    }
            config_options: Arc::new(Default::default()),
 */
    fn invoke_batch(
        let out = udf.invoke_with_args(args).unwrap();
    }
        Self {
    pub fn new() -> Self {
    signature: Signature,
    let bin_end = bin_start + width;
//!   produces coarse-enough bins); otherwise `minspanWidth` (user constraint
            Arc::new(Field::new("data_range", DataType::Float64, true)),
            if value.is_null(i) || min_span.is_null(i) || range.is_null(i) || max_value.is_null(i) {
        for i in 0..n {
use datafusion::error::{DataFusionError, Result};
    }
        assert_eq!(
// Same formatter as span_bucket / width_bucket; duplicated locally per the
        let a = calculate(15.0, 3.0, 100.0, 100.0);
        return None;
        assert_eq!(calculate(5.0, f64::NEG_INFINITY, 100.0, 100.0), None);
                } else {
    fn minspan_width_applied_even_when_value_outside_range() {
use std::sync::Arc;
use datafusion::arrow::datatypes::DataType;
        let decimals = decimal_places_for(span);
    }
        // later adds max_value into the algorithm (as width_bucket does),
//! `minspan_bucket(value, min_span, data_range, max_value)` — minimum-span
//! would require diverging from PPL's emit pattern, which this port explicitly
            return_field,
            vec![Some(100.0), Some(100.0), None, Some(100.0), Some(100.0)],
        let b = calculate(15.0, 3.0, 100.0, 99999.0);
//! * `minspanWidth = 10^ceil(log10(minSpan))` — round minSpan UP to next
    fn coerce_types_rejects_non_numeric() {
                value.value(i),
    let default_width = 10f64.powf(range.log10().floor());
                Some(s) => builder.append_value(&s),
    fn float_width_uses_decimal_format() {
    let minspan_width = 10f64.powf(min_span.log10().ceil());
                CoerceMode::Float64,
        );
    }
fn is_integer_span(span: f64) -> bool {
    }
        let s = a.as_string::<i32>();
}
        let c = calculate(15.0, 3.0, 100.0, -1.0);
    }
        );
//!   power of 10
    fn negative_min_span_returns_null() {
fn format_range(bin_start: f64, bin_end: f64, span: f64) -> String {
pub struct MinspanBucketUdf {
    #[test]
                max_value.value(i),
            arr.data_type()
    ctx.register_udf(ScalarUDF::from(MinspanBucketUdf::new()));
        let min_span = args.args[1].clone().into_array(n)?;
        assert_eq!(n, min_spans.len());
}
            .collect()
                range.value(i),
        assert_eq!(a, b);
        assert_eq!(n, maxes.len());
                builder.append_null();
    fn name(&self) -> &str {
            .unwrap(),
    fn batch_null_in_any_slot_propagates_null() {
            ) {
                ColumnarValue::Array(Arc::new(Float64Array::from(maxes)) as ArrayRef),
        if arg_types.len() != 4 {
                args.args.len()
    // use minspan_width so every bin is at least minSpan wide.
    fn invoke_with_args(&self, args: ScalarFunctionArgs) -> Result<ColumnarValue> {
//! parity but is unused by the algorithm (matches Java's `// currently unused
                ColumnarValue::Array(Arc::new(Float64Array::from(ranges)) as ArrayRef),
        );
//!
//! * Same integer/float label formatting as `span_bucket` / `width_bucket`
                None => builder.append_null(),
 * SPDX-License-Identifier: Apache-2.0
            }
            calculate(0.17, 0.05, 0.3, 0.3),
//! but kept for compatibility` comment). Removing it from the Rust signature
        // 1 >= 0.05 → width=1 (integer)
}
        assert!(udf
                DataType::Float64,
    };
    // ── range guards ───────────────────────────────────────────────────────
        let range = downcast_f64(&range, "data_range")?;
    use datafusion::logical_expr::ScalarFunctionArgs;
    #[test]
            vec![None, Some(5.0), Some(5.0), Some(5.0), Some(5.0)],
}
        assert!(udf.return_type(&[DataType::Float64]).is_err());
            out,
//! The `max_value` argument is carried through the signature for PPL call-shape
            udf.return_type(&[
            Arc::new(Field::new("max_value", DataType::Float64, true)),
    fn coerce_types_canonicalises_mixed_numeric_inputs() {
use super::{coerce_args, CoerceMode};
        assert_eq!(calculate(15.0, 3.0, 5.0, 5.0), Some("10-20".to_string()));
/*
        assert_eq!(
//!   power of 10
        if args.args.len() != 4 {
        assert!(udf
                if s.is_null(i) {
    }
    }
    } else {
    ) -> Vec<Option<String>> {
        let udf = MinspanBucketUdf::new();
/// `_max_value` is unused but preserved in the signature to match Java's
        // range=0.3 → defaultWidth=10^-1=0.1
}
    // ── min_span guards ────────────────────────────────────────────────────
}
}
    (v - v.round()).abs() < 1e-10
//!
// same rationale documented on width_bucket's format_range.
        // minSpan=0.05 → minspanWidth=10^ceil(-1.301)=10^-1=0.1
    fn default_width_wins_produces_label_covering_full_range() {
        // numeric floor, not an integer count).
}
    fn zero_range_returns_null() {
    use datafusion::arrow::array::AsArray;
                "minspan_bucket expects 4 arguments, got {}",
    }
        // value=15 → binStart=0, binEnd=100 → "0-100"
        assert_eq!(calculate(5.0, 3.0, f64::NAN, 100.0), None);
    if !width.is_finite() || width <= 0.0 {
        )
    let bin_start = (value / width).floor() * width;
            "minspan_bucket",
            .is_err());
        // Same (value, min_span, range) with different max_value values —
    //! `MinspanBucketFunction.calculateMinspanBucket`. Where the branching
}
    #[test]
        maxes: Vec<Option<f64>>,
                CoerceMode::Float64,
        assert_eq!(calculate(5.0, f64::NAN, 100.0, 100.0), None);
        // minSpan=3 → minspanWidth=10
        let value = args.args[0].clone().into_array(n)?;
        assert_eq!(n, ranges.len());
    // defaultWidth = 10^floor(log10(range)) — round range down to next power of 10.
