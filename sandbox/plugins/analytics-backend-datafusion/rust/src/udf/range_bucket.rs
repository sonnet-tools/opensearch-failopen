                ColumnarValue::Array(Arc::new(Float64Array::from(end_params)) as ArrayRef),
//! literal, null, null)` to avoid the window wrapper. Once empty-partition
        // Row 0: start=None, end=None     → range=100 (power-of-10) → w=10 → "50-60"
    })
        // that side" — the row still produces a non-null label (unlike a
                ColumnarValue::Array(Arc::new(Float64Array::from(data_mins)) as ArrayRef),
    }
                DataType::UInt32,
                Some("0-100".to_string()),
//!    - `effective_min = min(start_param, data_min)` when start_param not null
        ))
        // bin_start=0, bin_end=10.
        return None;
        let out = invoke_batch(
    let effective_range = effective_max - effective_min;
        format!("{}-{}", bin_start as i64, bin_end as i64)
        // Row 3: start=-10, end=200       → effective [-10,200], range=210 → w=100,
        let udf = RangeBucketUdf::new();
        end_params: Vec<Option<f64>>,
        let data_max = args.args[2].clone().into_array(n)?;
        assert_eq!(calculate(5.0, f64::NEG_INFINITY, 100.0, None, None), None);
    fn non_finite_bound_yields_null_via_range_guard() {
    }
                None => builder.append_null(),
    10f64.powf(adjusted)
    }
        // value=0.55 → adjusted=0.55, bin_index=floor(5.5)=5, bin_start=0.5,
            Some("0-10".to_string())
                DataType::Float64,
    Some(format_range(bin_start, bin_end, width))
            ]
    }
        // differ row-to-row; the invariant this test guards is purely
        //         first_bin_start=-100, value=50 → adjusted=150, bin_index=1,
    let is_exact_power_of_10 = (log10_range - floor_log).abs() < 1e-10;
    fn batch_null_in_value_or_bounds_propagates_null() {
}
        );
        assert_eq!(
        assert!(udf
//!    - else width = `10^floor(log10(range))`
    let first_bin_start = (effective_min / width).floor() * width;
        //   width = 10^floor(log10(89)) = 10^1 = 10.
            // observed data bound". Don't null-propagate from them.
                Some(end_param.value(i))
        Some(e) => e.max(data_max),
    }
    #[test]
        //         binStart=0, binEnd=100 → "0-100"
    ) -> Vec<Option<String>> {
    // ── Happy path with no user-supplied start/end ─────────────────────────
    if !effective_range.is_finite() || effective_range <= 0.0 {
    // Expansion-only: start_param can only lower effective_min; end_param
        let return_field = Arc::new(Field::new("out", DataType::Utf8, true));
            DataType::Utf8
use datafusion::logical_expr::{
    let log10_range = effective_range.log10();
            };
impl RangeBucketUdf {
        1
        let end_param = args.args[4].clone().into_array(n)?;
    //! `RangeBucketFunction.calculateRangeBucket`.
    signature: Signature,
        }
            .is_err());
        assert_eq!(calculate(5.0, 20.0, 10.0, None, None), None);
        let end_param = downcast_f64(&end_param, "end_param")?;
    use datafusion::arrow::datatypes::Field;
                DataType::Float64
                DataType::Float32,
//! <b>Window-dependency flag:</b> the PPL frontend's `bin start=... end=...`
        // range=1 → power of 10 → width=0.1.
    // ── Range guards ───────────────────────────────────────────────────────
    // ── Batch: null propagation differs per slot ───────────────────────────
        let arg_fields = vec![
    value: f64,
            calculate(5.0, -5.0, 10.0, Some(-10.0), Some(20.0)),
            match calculate(
    // ── Magnitude-based width ──────────────────────────────────────────────
        // bin_index=1, bin_start=0, bin_end=10.
}
            assert!(label.is_some(), "row {i} unexpectedly null-propagated");
        // of 10 → width=10.
        assert_eq!(
            Some("50-60".to_string())
            out,
            .coerce_types(&[
    data_max: f64,
        assert_eq!(
    fn coerce_types(&self, arg_types: &[DataType]) -> Result<Vec<DataType>> {
        // first_bin_start = floor(10/10)*10 = 10.
        assert_eq!(
        // dMin=0, dMax=1 → first_bin_start = floor(0/0.1)*0.1 = 0.
                CoerceMode::Float64,
            arg_fields,
/// Core range-bucket math. Direct port of Java
        let data_max = downcast_f64(&data_max, "data_max")?;
            Arc::new(Field::new("data_min", DataType::Float64, true)),
        3
    fn fractional_width_triggers_decimal_format() {
) -> Option<String> {
            .is_err());
        // start/end params. Each expansion changes the effective range and
        );
        //         first_bin_start=0, value=50 → binStart=0, binEnd=100 → "0-100"
        );
    fn non_positive_range_returns_null() {
        let start_param = downcast_f64(&start_param, "start_param")?;
            vec![Some(100.0), Some(100.0), Some(100.0), Some(100.0)],
    }
//!    + width`; label via the same integer/float formatter as span_bucket
fn is_integer_value(v: f64) -> bool {
//! `RangeBucketFunction`) which PPL emits via
        None => data_max,
                if s.is_null(i) {
    } else if span >= 0.1 {
// ─── tests ──────────────────────────────────────────────────────────────────
}
        floor_log
        Ok(ColumnarValue::Array(Arc::new(builder.finish()) as ArrayRef))
    }
                ColumnarValue::Array(Arc::new(Float64Array::from(start_params)) as ArrayRef),
        None => data_min,
//!    - if `effective_range` is exactly a power of 10 → width =
        //         adjusted=150, bin_index=1 → binStart=0, binEnd=100 → "0-100"
            out,
        // range=100 → log10(range)=2 (exact) → width = 10^(2-1) = 10.
    #[test]
use std::sync::Arc;
//! 1. Expansion-only effective bounds:
        );
        assert!((magnitude_based_width(1.0) - 0.1).abs() < 1e-12);
};
    }
        );
            ])
// Same format helpers as span_bucket / width_bucket / minspan_bucket;
    }
    fn start_param_greater_than_data_min_is_ignored() {
    }
            };
fn format_range(bin_start: f64, bin_end: f64, span: f64) -> String {
            calculate(50.0, 10.0, 99.0, None, None),
        assert!((magnitude_based_width(500.0) - 100.0).abs() < 1e-12);
 * The OpenSearch Contributors require contributions made to
                DataType::Float64,
        // data_max=100, end=50 → effective_max = max(50, 100) = 100.
        // Row 1: start=-10, end=None      → effective [-10,100], range=110 → w=100,
            ) {
}
//! Algorithm:
    fn start_param_expands_effective_min_downward() {
            .coerce_types(&[
            Arc::new(Field::new("end_param", DataType::Float64, true)),
    if !width.is_finite() || width <= 0.0 {
        assert_eq!(calculate(5.0, 10.0, 10.0, None, None), None);
 *
    start_param: Option<f64>,
        floor_log - 1.0
    // ── Expansion-only semantics ───────────────────────────────────────────
            vec![None, None, Some(200.0), Some(200.0)],
    use super::*;
    }
        if arg_types.len() != 5 {
//!
            Some("70-80".to_string())
            Some("0-10".to_string())
            panic!("expected array")
            Arc::new(Field::new("value", DataType::Float64, true)),
//! range-based bucket label (PPL).
use super::{coerce_args, CoerceMode};
        // Matches Java's "only expand, never shrink" comment.
            signature: Signature::user_defined(Volatility::Immutable),
    }
    }
        let s = a.as_string::<i32>();
    fn non_power_of_ten_range_uses_floor_magnitude() {
//! This UDF is independent of that capability — it's a pure scalar — but
    #[test]
/// Mirrors `RangeBucketFunction.calculateMagnitudeBasedWidth`. Exact powers
        // first_bin_start = floor(-10/10)*10 = -10. value=5 → adjusted=15,
                end,
            if value.is_null(i) || data_min.is_null(i) || data_max.is_null(i) {
        }
            vec![None, Some(50.0), Some(50.0), Some(50.0)],
//! 3. Magnitude-based width:
    let bin_end = bin_start + width;
pub struct RangeBucketUdf {
                DataType::Float64,
        let n = args.number_rows;
        let start_param = args.args[3].clone().into_array(n)?;
}
}
    fn batch_null_start_or_end_params_do_not_null_propagate() {
/// `RangeBucketFunction.calculateRangeBucket`.
            .coerce_types(&[
#[derive(Debug, PartialEq, Eq, Hash)]
                DataType::Float64,
//!
    // ── Fractional width formatter branch ──────────────────────────────────
            args: vec![
                DataType::Float64,
            return plan_err!("range_bucket expects 5 arguments, got {}", args.args.len());
    fn invoke_batch(
use datafusion::arrow::datatypes::DataType;
    fn end_param_expands_effective_max_upward() {
        assert!((magnitude_based_width(100.0) - 10.0).abs() < 1e-12);
            vec![Some(100.0), Some(100.0), None, Some(100.0)],
}
                DataType::Float64,
    let effective_max = match end_param {
            // start_param / end_param are nullable sentinels for "use the
    let bin_start = bin_index * width + first_bin_start;
        Some(s) => s.min(data_min),
//! `data_max` being null propagates null, but `start_param` / `end_param`
    fn end_param_less_than_data_max_is_ignored() {
        assert!((magnitude_based_width(50.0) - 10.0).abs() < 1e-12);
    arr.as_any().downcast_ref::<Float64Array>().ok_or_else(|| {
    }
    fn exact_power_of_ten_range_drops_width_one_magnitude() {
                DataType::Float64,
        }
        // start=-10 → effective_min = min(-10, -5) = -10. range=30 → not power
        // therefore the width and bin alignment, so outputs legitimately
        let value = downcast_f64(&value, "value")?;
            ],
    #[test]
        let n = values.len();
            }
}
                CoerceMode::Float64,
            ])
        );
 * SPDX-License-Identifier: Apache-2.0
pub fn register_all(ctx: &SessionContext) {
        );
        )
            }
//! 2. `effective_range = effective_max - effective_min`; `<= 0 → null`
    #[test]
    }
            arg_types,
    #[test]
//! the backend to support windowed aggregates over empty partitions.
    // ── coerce_types ───────────────────────────────────────────────────────
        // value=50 → adjusted=40, bin_index=4, bin_start=50, bin_end=60.
                DataType::Int32,
        // All four rows are non-null — the key invariant for this test.
    fn coerce_types_rejects_non_numeric() {
//! bucket`, this one has asymmetric null-handling: `value` / `data_min` /
//! `range_bucket(value, data_min, data_max, start_param, end_param)` —
    data_min: f64,
        2
    #[test]
        // data_min=10, start=0 → effective_min = min(0, 10) = 0.
                    Some(s.value(i).to_string())
    #[test]
//! window pushdown lands, the `bin` command exercises this UDF too.
            ],
            } else {
    }
fn calculate(
            Some("50-60".to_string())
                ColumnarValue::Array(Arc::new(Float64Array::from(values)) as ArrayRef),
        //
        let udf = RangeBucketUdf::new();
            return plan_err!("range_bucket expects 5 arguments, got {}", arg_types.len());
        start_params: Vec<Option<f64>>,
            vec![None, None, None, None],
        ];
        assert!(udf.return_type(&[DataType::Float64]).is_err());
//! command wraps `data_min` and `data_max` in `MIN(field) OVER ()` and
    ctx.register_udf(ScalarUDF::from(RangeBucketUdf::new()));
            number_rows: n,
//!    and width_bucket.
        Ok(DataType::Utf8)
    let adjusted = value - first_bin_start;
        assert_eq!(
    span.is_finite() && span == span.floor()
                data_min.value(i),
        data_mins: Vec<Option<f64>>,
        // null value / data_min / data_max which would propagate null).
}
    #[test]
fn is_integer_span(span: f64) -> bool {
            })
        // data_min=10, data_max=99 → range=89 (not power of 10) →
        // Same (value=50, data_min=0, data_max=100) across 4 rows, varying
    }
    }
            ]
 * this file be licensed under the Apache-2.0 license or a
                DataType::Float64,
    let floor_log = log10_range.floor();
    if span >= 1.0 {
    fn name(&self) -> &str {
        // Asymmetric: null start_param/end_param means "no expansion from
        let udf = RangeBucketUdf::new();
        // first_bin_start = floor(0/10)*10 = 0.
    }
    use datafusion::arrow::array::AsArray;
    };
    let bin_index = (adjusted / width).floor();
        let udf = RangeBucketUdf::new();
#[cfg(test)]
            calculate(50.0, 0.0, 100.0, None, None),
        // data_max=100, end=null → effective_max = 100. range=100 → width=10.
                DataType::Utf8,
                DataType::Float64
            arr.data_type()
    fn default() -> Self {
    fn coerce_types_canonicalises_five_numeric_slots() {
            "range_bucket: slot '{slot}' expected Float64 post-coerce, got {:?}",
        for i in 0..n {
        //         first_bin_start=floor(-10/100)*100=-100, value=50 →
                } else {
    } else if span >= 0.01 {
use datafusion::common::plan_err;
        // range=500 → log10≈2.699 → floor=2 → width=100.
        );
        assert!(udf
    #[test]
    #[test]
    let effective_min = match start_param {
            Arc::new(Field::new("start_param", DataType::Float64, true)),
//!    - `effective_max = max(end_param,   data_max)` when end_param   not null
        coerce_args(
            let end = if end_param.is_null(i) {
            return_field,
        let ColumnarValue::Array(a) = out else {
        if args.args.len() != 5 {
            // Null propagation on the three hard-required slots.
    }
use datafusion::error::{DataFusionError, Result};
        Self {
        // first_bin_start = 10. value=50 → adjusted=40, bin_index=4, binStart=50.
    }
//! the IT suite calls it directly via `eval range_bucket(value, literal,
        );
            vec![
use datafusion::execution::context::SessionContext;
fn downcast_f64<'a>(arr: &'a ArrayRef, slot: &str) -> Result<&'a Float64Array> {
        "range_bucket"
    pub fn new() -> Self {
    fn invoke_with_args(&self, args: ScalarFunctionArgs) -> Result<ColumnarValue> {
//! `MAX(field) OVER ()` empty-partition window aggregates. End-to-end
    #[test]
            Some("50-60".to_string())
//! pushdown through the backend via the `bin` command therefore requires
        // first_bin_start = floor(0/10)*10 = 0. value=5 → bin_index=0,
                CoerceMode::Float64,
                CoerceMode::Float64,
                Some("0-100".to_string())
mod tests {
                Some("50-60".to_string()),
                DataType::Float64,
        assert_eq!(
    }
use datafusion::arrow::array::{Array, ArrayRef, Float64Array, StringBuilder};
            .unwrap(),
        assert_eq!(
        assert!((magnitude_based_width(10.0) - 1.0).abs() < 1e-12);
        // data_min=10, start=20 → effective_min = min(20, 10) = 10 (expand-only).
        //   width = 10^(2-1) = 10.
        let data_min = downcast_f64(&data_min, "data_min")?;
        let out = udf.invoke_with_args(args).unwrap();
        for (i, label) in out.iter().enumerate() {
            calculate(5.0, 10.0, 100.0, Some(0.0), None),
        // data_min=-5, data_max=10, end=20 → effective_max = max(20, 10) = 20.
        data_maxes: Vec<Option<f64>>,
                DataType::Float64,
        format!("{:.*}-{:.*}", decimals, bin_start, decimals, bin_end)
                data_max.value(i),
                value.value(i),
            .map(|i| {
        );
        assert_eq!(calculate(5.0, 0.0, f64::NAN, None, None), None);
        assert_eq!(out, vec![None, None, None, Some("50-60".to_string())]);
        };
    let width = magnitude_based_width(effective_range);
            vec![None, Some(-10.0), None, Some(-10.0)],
        return None;
    #[test]
            vec![Some(0.0), None, Some(0.0), Some(0.0)],
            vec![
        // range=1 → log10=0 (exact) → width = 10^(0-1) = 0.1.
    // can only raise effective_max. Missing params leave the observed
    }
    if is_integer_span(span) && is_integer_value(bin_start) && is_integer_value(bin_end) {
                DataType::Float64,
            vec![Some(50.0), Some(50.0), Some(50.0), Some(50.0)],
        let args = ScalarFunctionArgs {
            let start = if start_param.is_null(i) {
            "range_bucket",
        let out = invoke_batch(
//! `PPLBuiltinOperators.RANGE_BUCKET`. Unlike `width_bucket` / `minspan_
                DataType::Float64
        // value=50 → adjusted=50, bin_index=5, bin_start=50, bin_end=60.
            udf.return_type(&[
    //! Expected values seeded from the Java reference
    }
            vec![None, None, None, None],
    } else {
        // bin_end=0.6. width=0.1 → 2dp → "0.50-0.60".
        );
                DataType::Int64,
/// width 10, not width 100, producing 10 labelled bins instead of 1).
    }
    let adjusted = if is_exact_power_of_10 {
        let out = udf
        }
fn decimal_places_for(span: f64) -> usize {
            config_options: Arc::new(Default::default()),
    ColumnarValue, ScalarFunctionArgs, ScalarUDF, ScalarUDFImpl, Signature, Volatility,
//! 5. `bin_index = floor((value - first_bin_start) / width)`
    #[test]
                None
    end_param: Option<f64>,
 */
                continue;
                Some(start_param.value(i))
                DataType::Float64,
 * compatible open source license.
        // data_max=100, end=null → range=100−10=90 → not power of 10 → width=10.
                DataType::Float64,
}
//!
//! Ports the OpenSearch-SQL bespoke `RANGE_BUCKET` UDF (see sql/core's
        }
    };
    }
        );
    } else {
        assert_eq!(
        DataFusionError::Internal(format!(
            Arc::new(Field::new("data_max", DataType::Float64, true)),
    fn coerce_types_rejects_wrong_arity() {
    #[test]
    fn return_type(&self, arg_types: &[DataType]) -> Result<DataType> {
impl Default for RangeBucketUdf {
            ])
        };
            calculate(75.0, 0.0, 100.0, None, Some(50.0)),
        // range=50 → log10≈1.699 → floor=1 → width=10.
            calculate(50.0, 10.0, 100.0, Some(20.0), None),
        // range=10 → log10=1 (exact) → width = 10^0 = 1.
/*
                CoerceMode::Float64,
        // data_min=0 → range=100 → power of 10 → width=10. value=75 → binStart=70.
        // "no row is null".
fn magnitude_based_width(effective_range: f64) -> f64 {
    };
    }
        // Row 2: start=None, end=200      → effective [0,200],   range=200 → w=100,
}
        values: Vec<Option<f64>>,
                ColumnarValue::Array(Arc::new(Float64Array::from(data_maxes)) as ArrayRef),
    }
        4
    fn non_power_of_ten_range_uses_same_magnitude_width() {
    fn no_params_uses_data_bounds_as_effective_range() {
        let udf = RangeBucketUdf::new();
        // data_min=0, data_max=100 → range=100 (exact power of 10) →
}
//! 4. `first_bin_start = floor(effective_min / width) * width`
    fn return_type_enforces_five_arg_arity() {
                DataType::Float64,
            ])
impl ScalarUDFImpl for RangeBucketUdf {
    }
                Some(s) => builder.append_value(&s),
                start,
}
            } else {
            .collect()
        (0..n)
        assert_eq!(
//! 6. `bin_start = bin_index * width + first_bin_start`; `bin_end = bin_start
                    None
                DataType::Float64,
            &[
        Self::new()
        let value = args.args[0].clone().into_array(n)?;
            .unwrap();
                DataType::Float64,
        let mut builder = StringBuilder::with_capacity(n, n * 16);
        let data_min = args.args[1].clone().into_array(n)?;
        let decimals = decimal_places_for(span);
        &self.signature
//!      `10^(floor(log10(range)) - 1)` (one magnitude finer)
        assert_eq!(
                }
    // bounds unchanged.
            calculate(0.55, 0.0, 1.0, None, None),
            Some("0.50-0.60".to_string())
    } else {
    (v - v.round()).abs() < 1e-10
//! are nullable sentinels meaning "use the observed data bound".
// duplicated locally per the same rationale.
                Some("0-100".to_string()),
/// of 10 get one magnitude finer width (so a range of exactly 100 yields
    #[test]
                None
    #[test]
        //
        assert_eq!(calculate(5.0, 0.0, f64::INFINITY, None, None), None);
                builder.append_null();
    fn signature(&self) -> &Signature {
            vec![Some(0.0), Some(0.0), Some(0.0), Some(0.0)],
