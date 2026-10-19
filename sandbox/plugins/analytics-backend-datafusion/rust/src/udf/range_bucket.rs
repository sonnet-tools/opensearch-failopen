        // Row 0: start=None, end=None     → range=100 (power-of-10) → w=10 → "50-60"
    #[test]
                Some(end_param.value(i))
            calculate(0.55, 0.0, 1.0, None, None),
            udf.return_type(&[
            panic!("expected array")
    }
            out,
        assert_eq!(
    data_max: f64,
        ))
        //         first_bin_start=floor(-10/100)*100=-100, value=50 →
            return plan_err!("range_bucket expects 5 arguments, got {}", args.args.len());
        let start_param = args.args[3].clone().into_array(n)?;
                Some("50-60".to_string()),
    #[test]
    start_param: Option<f64>,
        // data_min=10, data_max=99 → range=89 (not power of 10) →
                continue;
}
        };
        let start_param = downcast_f64(&start_param, "start_param")?;
                    Some(s.value(i).to_string())
    Some(format_range(bin_start, bin_end, width))
            .coerce_types(&[
        // first_bin_start = floor(10/10)*10 = 10.
    data_min: f64,
            calculate(5.0, -5.0, 10.0, Some(-10.0), Some(20.0)),
                }
    fn non_finite_bound_yields_null_via_range_guard() {
                DataType::Float64,
        assert_eq!(
        Self {
                None
    let log10_range = effective_range.log10();
            .unwrap();
 * The OpenSearch Contributors require contributions made to
    if is_integer_span(span) && is_integer_value(bin_start) && is_integer_value(bin_end) {
            ) {
    } else {
        assert_eq!(calculate(5.0, 0.0, f64::NAN, None, None), None);
        assert_eq!(
use datafusion::error::{DataFusionError, Result};
        // dMin=0, dMax=1 → first_bin_start = floor(0/0.1)*0.1 = 0.
        2
            vec![None, None, Some(200.0), Some(200.0)],
            Some("0-10".to_string())
//! are nullable sentinels meaning "use the observed data bound".
        );
    };
        assert_eq!(calculate(5.0, 10.0, 10.0, None, None), None);
            ]
use datafusion::common::plan_err;
    };
}
/// Mirrors `RangeBucketFunction.calculateMagnitudeBasedWidth`. Exact powers
    let effective_max = match end_param {
        assert!((magnitude_based_width(500.0) - 100.0).abs() < 1e-12);
        );
            // Null propagation on the three hard-required slots.
        // range=10 → log10=1 (exact) → width = 10^0 = 1.
        // range=500 → log10≈2.699 → floor=2 → width=100.
                Some(start_param.value(i))
            Some("0-10".to_string())
        // first_bin_start = floor(0/10)*10 = 0. value=5 → bin_index=0,
            ]
    } else {
    let adjusted = if is_exact_power_of_10 {
    // ── Happy path with no user-supplied start/end ─────────────────────────
        let data_min = downcast_f64(&data_min, "data_min")?;
        assert!((magnitude_based_width(10.0) - 1.0).abs() < 1e-12);
    fn start_param_expands_effective_min_downward() {
            vec![Some(0.0), Some(0.0), Some(0.0), Some(0.0)],
        // data_min=-5, data_max=10, end=20 → effective_max = max(20, 10) = 20.
        // first_bin_start = floor(0/10)*10 = 0.
        Self::new()
        // data_max=100, end=null → range=100−10=90 → not power of 10 → width=10.
        let out = invoke_batch(
//! 1. Expansion-only effective bounds:
            config_options: Arc::new(Default::default()),
}
            calculate(50.0, 10.0, 99.0, None, None),
        assert_eq!(calculate(5.0, f64::NEG_INFINITY, 100.0, None, None), None);
        }
        let udf = RangeBucketUdf::new();
//!    - `effective_max = max(end_param,   data_max)` when end_param   not null
// ─── tests ──────────────────────────────────────────────────────────────────
    10f64.powf(adjusted)
        // data_min=10, start=20 → effective_min = min(20, 10) = 10 (expand-only).
                ColumnarValue::Array(Arc::new(Float64Array::from(end_params)) as ArrayRef),
    ) -> Vec<Option<String>> {
        // value=50 → adjusted=50, bin_index=5, bin_start=50, bin_end=60.
/*
    }
// duplicated locally per the same rationale.
            signature: Signature::user_defined(Volatility::Immutable),
    fn coerce_types_canonicalises_five_numeric_slots() {
        let n = args.number_rows;
/// `RangeBucketFunction.calculateRangeBucket`.
    // can only raise effective_max. Missing params leave the observed
                DataType::Int64,
    #[test]
            args: vec![
        );
                ColumnarValue::Array(Arc::new(Float64Array::from(data_maxes)) as ArrayRef),
//! 2. `effective_range = effective_max - effective_min`; `<= 0 → null`
    if !width.is_finite() || width <= 0.0 {
//!    - else width = `10^floor(log10(range))`
    }
/// Core range-bucket math. Direct port of Java
        coerce_args(
            // observed data bound". Don't null-propagate from them.
        assert!(udf
}
            Some("50-60".to_string())
            calculate(50.0, 10.0, 100.0, Some(20.0), None),
        // first_bin_start = 10. value=50 → adjusted=40, bin_index=4, binStart=50.
}
    // ── Fractional width formatter branch ──────────────────────────────────
    value: f64,
        assert_eq!(
    // bounds unchanged.
    fn no_params_uses_data_bounds_as_effective_range() {
            };
                end,
        // start/end params. Each expansion changes the effective range and
    fn end_param_less_than_data_max_is_ignored() {
            return_field,
            Arc::new(Field::new("data_max", DataType::Float64, true)),
            Some("70-80".to_string())
            calculate(5.0, 10.0, 100.0, Some(0.0), None),
    }
    pub fn new() -> Self {
}
            assert!(label.is_some(), "row {i} unexpectedly null-propagated");
            ])
    fn non_positive_range_returns_null() {
    end_param: Option<f64>,
        values: Vec<Option<f64>>,
        assert!((magnitude_based_width(50.0) - 10.0).abs() < 1e-12);
    fn fractional_width_triggers_decimal_format() {
                ColumnarValue::Array(Arc::new(Float64Array::from(values)) as ArrayRef),
        //         adjusted=150, bin_index=1 → binStart=0, binEnd=100 → "0-100"
        );
    if !effective_range.is_finite() || effective_range <= 0.0 {
        assert!(udf.return_type(&[DataType::Float64]).is_err());
//! Algorithm:
    }
        // Matches Java's "only expand, never shrink" comment.
    #[test]
impl Default for RangeBucketUdf {
//! `MAX(field) OVER ()` empty-partition window aggregates. End-to-end
 * compatible open source license.
    use super::*;
//!    - if `effective_range` is exactly a power of 10 → width =
        None => data_min,
            calculate(50.0, 0.0, 100.0, None, None),
                DataType::Utf8,
        let decimals = decimal_places_for(span);
use datafusion::logical_expr::{
    }
fn format_range(bin_start: f64, bin_end: f64, span: f64) -> String {
        // of 10 → width=10.
        // bin_end=0.6. width=0.1 → 2dp → "0.50-0.60".
        let udf = RangeBucketUdf::new();
        // start=-10 → effective_min = min(-10, -5) = -10. range=30 → not power
    #[test]
            vec![None, None, None, None],
//! 4. `first_bin_start = floor(effective_min / width) * width`
        let data_max = downcast_f64(&data_max, "data_max")?;
            DataType::Utf8
    fn non_power_of_ten_range_uses_same_magnitude_width() {
    #[test]
        // Row 1: start=-10, end=None      → effective [-10,100], range=110 → w=100,
    (v - v.round()).abs() < 1e-10
//! 6. `bin_start = bin_index * width + first_bin_start`; `bin_end = bin_start
                DataType::Float64,
        "range_bucket"
 */
    let is_exact_power_of_10 = (log10_range - floor_log).abs() < 1e-10;
    let adjusted = value - first_bin_start;
//!
            Some("50-60".to_string())
            vec![Some(50.0), Some(50.0), Some(50.0), Some(50.0)],
    }
        // range=50 → log10≈1.699 → floor=1 → width=10.
            let start = if start_param.is_null(i) {
                DataType::Float64,
        None => data_max,
            .is_err());
                } else {
impl ScalarUDFImpl for RangeBucketUdf {
        floor_log - 1.0
fn magnitude_based_width(effective_range: f64) -> f64 {
        start_params: Vec<Option<f64>>,
        data_mins: Vec<Option<f64>>,
            out,
//!    + width`; label via the same integer/float formatter as span_bucket
        );
            vec![None, Some(-10.0), None, Some(-10.0)],
    }
        // null value / data_min / data_max which would propagate null).
            if value.is_null(i) || data_min.is_null(i) || data_max.is_null(i) {
        let udf = RangeBucketUdf::new();
    }
#[derive(Debug, PartialEq, Eq, Hash)]
    fn default() -> Self {
                CoerceMode::Float64,
    #[test]
    let bin_end = bin_start + width;
}
    if span >= 1.0 {
    fn batch_null_in_value_or_bounds_propagates_null() {
        );
        assert!((magnitude_based_width(100.0) - 10.0).abs() < 1e-12);
        ];
        assert_eq!(
        let udf = RangeBucketUdf::new();
use datafusion::arrow::array::{Array, ArrayRef, Float64Array, StringBuilder};
fn decimal_places_for(span: f64) -> usize {
        let data_max = args.args[2].clone().into_array(n)?;
    span.is_finite() && span == span.floor()
        assert_eq!(calculate(5.0, 20.0, 10.0, None, None), None);
                None => builder.append_null(),
/// of 10 get one magnitude finer width (so a range of exactly 100 yields
    fn exact_power_of_ten_range_drops_width_one_magnitude() {
                start,
        format!("{:.*}-{:.*}", decimals, bin_start, decimals, bin_end)
    }
            })
            Arc::new(Field::new("end_param", DataType::Float64, true)),
    ctx.register_udf(ScalarUDF::from(RangeBucketUdf::new()));
    #[test]
            calculate(75.0, 0.0, 100.0, None, Some(50.0)),
            let end = if end_param.is_null(i) {
//!
        }
    fn end_param_expands_effective_max_upward() {
            Arc::new(Field::new("data_min", DataType::Float64, true)),
    fn invoke_batch(
//! <b>Window-dependency flag:</b> the PPL frontend's `bin start=... end=...`
        //         first_bin_start=-100, value=50 → adjusted=150, bin_index=1,
    arr.as_any().downcast_ref::<Float64Array>().ok_or_else(|| {
        );
        );
//! Ports the OpenSearch-SQL bespoke `RANGE_BUCKET` UDF (see sql/core's
    }
//! This UDF is independent of that capability — it's a pure scalar — but
/// width 10, not width 100, producing 10 labelled bins instead of 1).
        return None;
        assert_eq!(calculate(5.0, 0.0, f64::INFINITY, None, None), None);
        // Same (value=50, data_min=0, data_max=100) across 4 rows, varying
                DataType::Float64,
        Some(e) => e.max(data_max),
        // Asymmetric: null start_param/end_param means "no expansion from
    fn batch_null_start_or_end_params_do_not_null_propagate() {
                DataType::Float64,
        //         first_bin_start=0, value=50 → binStart=0, binEnd=100 → "0-100"
    #[test]
//! the IT suite calls it directly via `eval range_bucket(value, literal,
pub struct RangeBucketUdf {
        let out = udf.invoke_with_args(args).unwrap();
            } else {
    // ── Range guards ───────────────────────────────────────────────────────
//! window pushdown lands, the `bin` command exercises this UDF too.
                DataType::Float64
    }
    let bin_start = bin_index * width + first_bin_start;
    #[test]
            match calculate(
    }
}
        // value=0.55 → adjusted=0.55, bin_index=floor(5.5)=5, bin_start=0.5,
    //! Expected values seeded from the Java reference
    }
                DataType::Float64,
use datafusion::execution::context::SessionContext;
            } else {
            ])
            "range_bucket: slot '{slot}' expected Float64 post-coerce, got {:?}",
        // value=50 → adjusted=40, bin_index=4, bin_start=50, bin_end=60.
};
        assert_eq!(
    #[test]
    #[test]
    fn coerce_types(&self, arg_types: &[DataType]) -> Result<Vec<DataType>> {
        // bin_start=0, bin_end=10.
    let bin_index = (adjusted / width).floor();
) -> Option<String> {
    }
                CoerceMode::Float64,
            // start_param / end_param are nullable sentinels for "use the
                if s.is_null(i) {
//! `PPLBuiltinOperators.RANGE_BUCKET`. Unlike `width_bucket` / `minspan_
        // data_min=0 → range=100 → power of 10 → width=10. value=75 → binStart=70.
        // data_max=100, end=50 → effective_max = max(50, 100) = 100.
//! literal, null, null)` to avoid the window wrapper. Once empty-partition
            ],
//! 5. `bin_index = floor((value - first_bin_start) / width)`
        // range=1 → power of 10 → width=0.1.
        assert_eq!(
    }
    ColumnarValue, ScalarFunctionArgs, ScalarUDF, ScalarUDFImpl, Signature, Volatility,
//! bucket`, this one has asymmetric null-handling: `value` / `data_min` /
        format!("{}-{}", bin_start as i64, bin_end as i64)
                None
}
    #[test]
        //   width = 10^(2-1) = 10.
        let ColumnarValue::Array(a) = out else {
        );
    signature: Signature,
 * this file be licensed under the Apache-2.0 license or a
        };
                DataType::Float64
    }
                CoerceMode::Float64,
        for (i, label) in out.iter().enumerate() {
            .map(|i| {
    // ── Expansion-only semantics ───────────────────────────────────────────
        // bin_index=1, bin_start=0, bin_end=10.
        &self.signature
        let data_min = args.args[1].clone().into_array(n)?;
        }
        4
    #[test]
            "range_bucket",
        let args = ScalarFunctionArgs {
}
        //   width = 10^floor(log10(89)) = 10^1 = 10.
        let out = invoke_batch(
        assert!(udf
        end_params: Vec<Option<f64>>,
}
        // that side" — the row still produces a non-null label (unlike a
        for i in 0..n {
        let return_field = Arc::new(Field::new("out", DataType::Utf8, true));
        let value = args.args[0].clone().into_array(n)?;
    fn return_type(&self, arg_types: &[DataType]) -> Result<DataType> {
                Some(s) => builder.append_value(&s),
    // ── Batch: null propagation differs per slot ───────────────────────────
    //! `RangeBucketFunction.calculateRangeBucket`.
        let n = values.len();
            vec![Some(100.0), Some(100.0), Some(100.0), Some(100.0)],
pub fn register_all(ctx: &SessionContext) {
use std::sync::Arc;
//!    and width_bucket.
        // differ row-to-row; the invariant this test guards is purely
                DataType::Float64,
    fn non_power_of_ten_range_uses_floor_magnitude() {
            &[
            ])
                DataType::Float64,
        Some(s) => s.min(data_min),
        DataFusionError::Internal(format!(
    // ── Magnitude-based width ──────────────────────────────────────────────
    } else if span >= 0.1 {
            .collect()
//! the backend to support windowed aggregates over empty partitions.
            Some("50-60".to_string())
//! 3. Magnitude-based width:
            vec![Some(0.0), None, Some(0.0), Some(0.0)],
                DataType::Float64,
        // data_min=10, start=0 → effective_min = min(0, 10) = 0.
        assert_eq!(
        }
            }
//! `RangeBucketFunction`) which PPL emits via
            vec![None, Some(50.0), Some(50.0), Some(50.0)],
        // Row 3: start=-10, end=200       → effective [-10,200], range=210 → w=100,
        // first_bin_start = floor(-10/10)*10 = -10. value=5 → adjusted=15,
    // Expansion-only: start_param can only lower effective_min; end_param
        // "no row is null".
            };
    }
    } else if span >= 0.01 {
        assert_eq!(out, vec![None, None, None, Some("50-60".to_string())]);
            vec![
        // data_min=0, data_max=100 → range=100 (exact power of 10) →
    }
    fn start_param_greater_than_data_min_is_ignored() {
            .is_err());
        );
    let effective_min = match start_param {
            }
        );
    }
    }
            Arc::new(Field::new("value", DataType::Float64, true)),
        // therefore the width and bin alignment, so outputs legitimately
                Some("0-100".to_string()),
            arg_fields,
    fn coerce_types_rejects_non_numeric() {
        //
//!      `10^(floor(log10(range)) - 1)` (one magnitude finer)
                DataType::Float64
use super::{coerce_args, CoerceMode};
        1
        let value = downcast_f64(&value, "value")?;
        assert_eq!(
                ColumnarValue::Array(Arc::new(Float64Array::from(start_params)) as ArrayRef),
    #[test]
        Ok(ColumnarValue::Array(Arc::new(builder.finish()) as ArrayRef))
//!    - `effective_min = min(start_param, data_min)` when start_param not null
        );
            ])
            arg_types,
        // data_max=100, end=null → effective_max = 100. range=100 → width=10.
//! `data_max` being null propagates null, but `start_param` / `end_param`
            ],
            vec![None, None, None, None],
//! pushdown through the backend via the `bin` command therefore requires
            number_rows: n,
        floor_log
    use datafusion::arrow::datatypes::Field;
        //         binStart=0, binEnd=100 → "0-100"
        let mut builder = StringBuilder::with_capacity(n, n * 16);
                DataType::UInt32,
    let width = magnitude_based_width(effective_range);
    }
        Ok(DataType::Utf8)
    }
            vec![
    fn invoke_with_args(&self, args: ScalarFunctionArgs) -> Result<ColumnarValue> {
        let s = a.as_string::<i32>();
        let arg_fields = vec![
            .coerce_types(&[
            .coerce_types(&[
                DataType::Float64,
        assert!((magnitude_based_width(1.0) - 0.1).abs() < 1e-12);
mod tests {
                DataType::Float64,
    };
}
                data_min.value(i),
    }
        )
                builder.append_null();
//! `range_bucket(value, data_min, data_max, start_param, end_param)` —
//! command wraps `data_min` and `data_max` in `MIN(field) OVER ()` and
        // All four rows are non-null — the key invariant for this test.
        // range=1 → log10=0 (exact) → width = 10^(0-1) = 0.1.
        return None;
    }
        assert_eq!(
impl RangeBucketUdf {
                DataType::Float64,
fn calculate(
        (0..n)
    }
                Some("0-100".to_string()),
    let first_bin_start = (effective_min / width).floor() * width;
                DataType::Float64,
            Some("0.50-0.60".to_string())
            Arc::new(Field::new("start_param", DataType::Float64, true)),
fn downcast_f64<'a>(arr: &'a ArrayRef, slot: &str) -> Result<&'a Float64Array> {
                DataType::Float64,
        if args.args.len() != 5 {
    })
            vec![Some(100.0), Some(100.0), None, Some(100.0)],
    fn coerce_types_rejects_wrong_arity() {
 * SPDX-License-Identifier: Apache-2.0
    } else {
            return plan_err!("range_bucket expects 5 arguments, got {}", arg_types.len());
//!
fn is_integer_value(v: f64) -> bool {
    #[test]
        data_maxes: Vec<Option<f64>>,
        let end_param = args.args[4].clone().into_array(n)?;
        let end_param = downcast_f64(&end_param, "end_param")?;
        let out = udf
                data_max.value(i),
//! range-based bucket label (PPL).
#[cfg(test)]
    }
                DataType::Int32,
    }
        if arg_types.len() != 5 {
    use datafusion::arrow::array::AsArray;
        // range=100 → log10(range)=2 (exact) → width = 10^(2-1) = 10.
    // ── coerce_types ───────────────────────────────────────────────────────
                Some("0-100".to_string())
    fn name(&self) -> &str {
                    None
    fn signature(&self) -> &Signature {
                CoerceMode::Float64,
    #[test]
    let effective_range = effective_max - effective_min;
            arr.data_type()
        //
                DataType::Float64,
// Same format helpers as span_bucket / width_bucket / minspan_bucket;
        }
}
            .unwrap(),
        3
    let floor_log = log10_range.floor();
use datafusion::arrow::datatypes::DataType;
 *
                CoerceMode::Float64,
fn is_integer_span(span: f64) -> bool {
    }
                ColumnarValue::Array(Arc::new(Float64Array::from(data_mins)) as ArrayRef),
        let udf = RangeBucketUdf::new();
                DataType::Float64,
                value.value(i),
    fn return_type_enforces_five_arg_arity() {
        // Row 2: start=None, end=200      → effective [0,200],   range=200 → w=100,
                DataType::Float32,
