        ranges: Vec<Option<f64>>,
                num_bins.value(i),
    fn invoke_batch(
        assert_eq!(calculate(5.0, -1, 100.0, 100.0), None);
    }
    }
        let udf = WidthBucketUdf::new();
/// Core width-bucket math. Direct port of Java
    use super::*;
                CoerceMode::Float64,
                DataType::Float64,
            return plan_err!("width_bucket expects 4 arguments, got {}", arg_types.len());
        Ok(DataType::Utf8)
        DataFusionError::Internal(format!(
            .unwrap();
pub struct WidthBucketUdf {
    let width = optimal_width(range, max_value, num_bins);
    if !width.is_finite() || width <= 0.0 {
        };
            arg_fields,
    } else if span >= 0.1 {
            Some("30000-40000".to_string())
        Ok(ColumnarValue::Array(Arc::new(builder.finish()) as ArrayRef))
        for i in 0..n {
        let udf = WidthBucketUdf::new();
                Some(s) => builder.append_value(&s),
        let value = downcast_f64(&value, "value")?;
/// Mirror `org.opensearch.sql.calcite.utils.binning.BinConstants.MIN_BINS`.
        let max_arr = Arc::new(Float64Array::from(maxes)) as ArrayRef;
    } else {
    fn coerce_types_rejects_string_in_value_slot() {
            .coerce_types(&[
    }
                value.value(i),
//!
    // Java: `if (maxValue % optimalWidth == 0) actualBins++;`
        if arg_types.len() != 4 {
use datafusion::arrow::array::{Array, ArrayRef, Float64Array, Int64Array, StringBuilder};
    // ── Happy path: exact bank-fixture case from subtraitupdates's tests ───
        // range=1, bins=10 → targetWidth=0.1 → exponent=ceil(log10(0.1))=-1 → width=0.1.
            .coerce_types(&[
//! Semantics:
    if !(MIN_BINS..=MAX_BINS).contains(&num_bins) {
        );
    #[test]
/// `WidthBucketFunction.calculateWidthBucket`.
// ─── tests ──────────────────────────────────────────────────────────────────
    }
            match calculate(
        }
            .collect()
        values: Vec<Option<f64>>,
    }
            out,
    // `calculate` takes primitives and can't observe a null; null propagation
    #[test]
    }
        //   → width=10000. actualBins=ceil(33539/10000)=4. 33539 % 10000 = 3539 ≠ 0,
        3
    fn non_finite_range_returns_null() {
            .map(|i| {
            ],
    fn signature(&self) -> &Signature {
    #[test]
//!   exceed `numBins`. Label uses the same integer/float decimal-place rules
    }
        let return_field = Arc::new(Field::new("out", DataType::Utf8, true));
}
    // ── Batch invocation via DataFusion scalar harness ─────────────────────
        ))
                None => builder.append_null(),
                ColumnarValue::Array(max_arr),
//!   as `span_bucket`.
        assert_eq!(
        let arg_fields = vec![
                DataType::Int32,
            Arc::new(Field::new("data_range", DataType::Float64, true)),
    #[test]
// (range_bucket and minspan_bucket both reuse this exact helper), but keeping
        // Each row has exactly one null slot; all rows should produce null labels.
    #[test]
                ColumnarValue::Array(bins_arr),
            udf.return_type(&[
use datafusion::error::{DataFusionError, Result};
//! requested bin count, total data range, and dataset max, returns the
    }
//! * `range <= 0` or non-finite → null
        assert!(udf.return_type(&[DataType::Float64]).is_err());
    // ── coerce_types ───────────────────────────────────────────────────────
                DataType::Utf8,
        }
        assert_eq!(calculate(5.0, 1, 100.0, 100.0), None);
//!   higher if `ceil(range/width) + (maxValue % width == 0 ? 1 : 0)` would
        4
    ) -> Vec<Option<String>> {
    signature: Signature,
        Self {
        assert!(calculate(5.0, MIN_BINS, 100.0, 100.0).is_some());
    fn batch_null_in_any_slot_propagates_null() {
        // ceil(50/10)=5. 50 % 10 == 0 → actualBins=6. 6 > 5 → rescale to 10^2=100.
fn calculate(value: f64, num_bins: i64, range: f64, max_value: f64) -> Option<String> {
        assert!(udf
        format!("{}-{}", bin_start as i64, bin_end as i64)
        width = 10f64.powf(exponent + 1.0);
            "width_bucket",
                }
        assert_eq!(calculate(5.0, i64::MAX, 100.0, 100.0), None);
            vec![Some(33539.0)],
        num_bins: Vec<Option<i64>>,
        let out = invoke_batch(
                ColumnarValue::Array(range_arr),
    fn return_type_enforces_four_arg_arity() {
        assert_eq!(calculate(5.0, 10, 0.0, 100.0), None);
        }
            return plan_err!("width_bucket expects 4 arguments, got {}", args.args.len());
        let value = args.args[0].clone().into_array(n)?;
                builder.append_null();
 * SPDX-License-Identifier: Apache-2.0
// distinct format policy without untangling a shared dependency.
/// Mirrors `WidthBucketFunction.calculateOptimalWidth` — the Java reference
        assert_eq!(optimal_width(99.0, 99.0, 10), 10.0);
            vec![Some(100.0), Some(100.0), None, Some(100.0)],
        let out = udf
        //   no bump. 4 > 10 false → width stays 10000.
    fn name(&self) -> &str {
            .is_err());
        assert_eq!(calculate(5.0, 0, 100.0, 100.0), None);
    //! directly so the test names describe the invariant being exercised.
            .unwrap(),
                DataType::Float64,
        maxes: Vec<Option<f64>>,
    }
        "width_bucket"
//! variant returns a VARCHAR bucket label via a nice-number magnitude-based
            "width_bucket: slot '{slot}' expected Int64 post-coerce, got {:?}",
        )
                DataType::Float64,
    })
    }
    }
                DataType::Int64,
/// admits an explicit fallback of `1.0` when `range <= 0` or `bins <= 0`;
#[cfg(test)]
impl WidthBucketUdf {
    fn optimal_width_no_rescale_when_max_offboundary() {
        // MIN_BINS = 2.
    fn default() -> Self {
                ColumnarValue::Array(value_arr),
    }
            })
    #[test]
        let max_value = args.args[3].clone().into_array(n)?;
    }
    arr.as_any().downcast_ref::<Float64Array>().ok_or_else(|| {
    fn invoke_with_args(&self, args: ScalarFunctionArgs) -> Result<ColumnarValue> {
            vec![Some(39225.0)],
        // (numeric value, range, max) to Float64 — same pattern as
            arr.data_type()
 *
    fn negative_range_returns_null() {
}
        // ceil(99/10)=10. 99 % 10 = 9 ≠ 0, no bump. 10 > 10 false → width=10.
pub fn register_all(ctx: &SessionContext) {
        let s = a.as_string::<i32>();
    #[test]
    fn batch_happy_path_non_null_rows() {
fn format_range(bin_start: f64, bin_end: f64, span: f64) -> String {
        let n = values.len();
        // MAX_BINS = 50_000.
        let decimals = decimal_places_for(span);
    }
//!
//! * Optimal width = `10^ceil(log10(range/numBins))`; bumped one magnitude
    fn return_type(&self, arg_types: &[DataType]) -> Result<DataType> {
            number_rows: n,
    let exponent = target_width.log10().ceil();
const MIN_BINS: i64 = 2;
            panic!("expected array")
    fn num_bins_below_minimum_returns_null() {
    Some(format_range(bin_start, bin_end, width))
    }
    if data_range <= 0.0 || requested_bins <= 0 {
            vec![
            &[
        // SpanBucketUdf. invoke_with_args downcasts once per slot.
    (v - v.round()).abs() < 1e-10
            signature: Signature::user_defined(Volatility::Immutable),
        DataFusionError::Internal(format!(
    // ── Range guards ───────────────────────────────────────────────────────
//! `width_bucket(value, num_bins, data_range, max_value)` — histogram bucket label.
    span.is_finite() && span == span.floor()
    #[test]
fn decimal_places_for(span: f64) -> usize {
}
            ])
        );
            Arc::new(Field::new("value", DataType::Float64, true)),
//! `sql/core/.../binning/WidthBucketFunction.java`). Given a numeric value,
        );
    #[test]
        assert_eq!(calculate(5.0, 10, f64::NAN, 100.0), None);
        let num_bins = args.args[1].clone().into_array(n)?;
        assert_eq!(out, vec![None, None, None, None]);
impl ScalarUDFImpl for WidthBucketUdf {
 * compatible open source license.
//! label (e.g. `"30000-40000"`).
    #[test]
    fn coerce_types_canonicalises_mixed_numeric_inputs() {
 */
use datafusion::common::plan_err;
    ctx.register_udf(ScalarUDF::from(WidthBucketUdf::new()));
            vec![None, Some(5.0), Some(5.0), Some(5.0)],
        Self::new()
    // ── Boundary of numBins ────────────────────────────────────────────────
                range.value(i),
}
        assert_eq!(calculate(5.0, 10, f64::NEG_INFINITY, 100.0), None);
    use datafusion::arrow::datatypes::Field;
        // coerce_types normalizes slot 1 (num_bins) to Int64 and slots 0/2/3
        // ceil(1/0.1)=10. 1 % 0.1 is fp-ugly (~0.1) ≠ 0, no bump. 10 > 10 false → width=0.1.
                    None
            .is_err());
    //! `WidthBucketFunction.calculateWidthBucket`. Any drift from Java is a
        let out = invoke_batch(
    }
    fn num_bins_above_maximum_returns_null() {
        let range_arr = Arc::new(Float64Array::from(ranges)) as ArrayRef;
    //! steps matter (optimal-width rescale branch), we pin `optimal_width`
            args: vec![
        assert_eq!(
            vec![Some(10), None, Some(10), Some(10)],
    fn coerce_types(&self, arg_types: &[DataType]) -> Result<Vec<DataType>> {
    let bin_start = (value / width).floor() * width;
    fn zero_range_returns_null() {
    width
    //! bug in this port, not the test. Where the algorithm's intermediate
        assert_eq!(calculate(5.0, 10, f64::INFINITY, 100.0), None);
    }
                DataType::Int64,
            arr.data_type()
    } else {
}
#[derive(Debug, PartialEq, Eq, Hash)]
mod tests {
//! * Any null input → null (null propagation).
    fn optimal_width_rescales_when_max_on_boundary_exceeds_bins() {
        }
/// we can't hit those from `calculate` (already guarded), but we keep the
    }
    #[test]
            ],
}
fn optimal_width(data_range: f64, max_value: f64, requested_bins: i64) -> f64 {
/// fallback so this function's contract matches Java's exactly and anyone
            ])
        (0..n)
    })
use datafusion::arrow::datatypes::DataType;
        return None;
    }
    pub fn new() -> Self {
}
    if is_integer_span(span) && is_integer_value(bin_start) && is_integer_value(bin_end) {
                    Some(s.value(i).to_string())
        // value=39225 → binStart=floor(39225/10000)*10000=30000, binEnd=40000.
        };
        let range = downcast_f64(&range, "data_range")?;
/// Mirror `BinConstants.MAX_BINS`.
/// reusing it directly gets identical behavior.
        assert_eq!(
            ])
                DataType::Float64,
                DataType::Int64,
    let bin_end = bin_start + width;
    }
                DataType::Float32,
use datafusion::execution::context::SessionContext;
    // happens in `invoke_with_args`. Batch test below covers it.
    use datafusion::logical_expr::ScalarFunctionArgs;
        let args = ScalarFunctionArgs {
        let mut builder = StringBuilder::with_capacity(n, n * 16);
fn is_integer_value(v: f64) -> bool {
}
        return None;
    // ── Optimal-width rescale branch ───────────────────────────────────────
    if span >= 1.0 {
 * The OpenSearch Contributors require contributions made to
        let n = args.number_rows;
        // range=33539, bins=10 → targetWidth=3353.9 → exponent=ceil(log10(...))=4
        assert!(calculate(5.0, MAX_BINS, 100.0, 100.0).is_some());
    let mut actual_bins = (data_range / width).ceil();
                continue;
        let ColumnarValue::Array(a) = out else {
    }
        actual_bins += 1.0;
        );
        assert_eq!(optimal_width(50.0, 50.0, 5), 100.0);
}
    }
            Arc::new(Field::new("num_bins", DataType::Int64, true)),
    ColumnarValue, ScalarFunctionArgs, ScalarUDF, ScalarUDFImpl, Signature, Volatility,
        let udf = WidthBucketUdf::new();
        let range = args.args[2].clone().into_array(n)?;
        let w = optimal_width(1.0, 1.0, 10);
//! width_bucket (DataFusion has it natively) needs a distinct enum entry.
            vec![Some(33539.0)],
        assert!((w - 0.1).abs() < 1e-12, "expected ~0.1, got {w}");
    }
        );
            .coerce_types(&[DataType::Int64, DataType::Int64, DataType::Int64])
            ]
    fn optimal_width_target_under_one_yields_unit_width() {
    }
                } else {
            if value.is_null(i) || num_bins.is_null(i) || range.is_null(i) || max_value.is_null(i) {
 * this file be licensed under the Apache-2.0 license or a
fn downcast_i64<'a>(arr: &'a ArrayRef, slot: &str) -> Result<&'a Int64Array> {
    }
                DataType::Float64
    }
//! * `numBins` outside `[MIN_BINS, MAX_BINS]` → null
        assert_eq!(calculate(5.0, 10, -1.0, 100.0), None);
            DataType::Utf8
}
use datafusion::logical_expr::{
//! Ports the OpenSearch-SQL bespoke `WIDTH_BUCKET` UDF (see
//! half-open bucket `[binStart, binEnd)` that contains `value` as a VARCHAR
                CoerceMode::Int64,
            arg_types,
// each UDF self-contained makes it trivial to later give one of them a
}
        let num_bins = downcast_i64(&num_bins, "num_bins")?;
    } else if span >= 0.01 {
        if args.args.len() != 4 {
        format!("{:.*}-{:.*}", decimals, bin_start, decimals, bin_end)
    if !range.is_finite() || range <= 0.0 {
                DataType::Float64,
    // ── Null inputs at the batch layer ─────────────────────────────────────
//! algorithm. The two collide in name only; any future wiring of real ISO SQL
            ) {
        assert!(udf
    #[test]
        let bins_arr = Arc::new(Int64Array::from(num_bins)) as ArrayRef;
        return 1.0;
    fn bank_fixture_width_10000() {
        let udf = WidthBucketUdf::new();
                DataType::Int32,
        2
    }
            calculate(39225.0, 10, 33539.0, 33539.0),
    use datafusion::arrow::array::AsArray;
        assert_eq!(n, maxes.len());
        let max_value = downcast_f64(&max_value, "max_value")?;
                if s.is_null(i) {
        1
            }
use super::{coerce_args, CoerceMode};
            vec![Some(10)],
        let value_arr = Arc::new(Float64Array::from(values)) as ArrayRef;
// shared module. The PPL binning family is expected to converge over time
}
                DataType::Float64,
        let udf = WidthBucketUdf::new();
}
            return_field,
// Formatting helpers — duplicated from span_bucket rather than moved to a
        assert_eq!(calculate(5.0, 50_001, 100.0, 100.0), None);
        coerce_args(
        // range=50, bins=5, max=50 → targetWidth=10 → exponent=1 → width=10.
                CoerceMode::Float64,
                max_value.value(i),
impl Default for WidthBucketUdf {
    }
    if max_value % width == 0.0 {
            Arc::new(Field::new("max_value", DataType::Float64, true)),
    let target_width = data_range / requested_bins as f64;
    //! Expected values seeded from the Java reference
    arr.as_any().downcast_ref::<Int64Array>().ok_or_else(|| {
    #[test]
/*
                CoerceMode::Float64,
    }
    if actual_bins > requested_bins as f64 {
        let out = udf.invoke_with_args(args).unwrap();
    fn coerce_types_rejects_wrong_arity() {
    }
        assert_eq!(n, ranges.len());
        ))
//! <b>Not</b> ISO-SQL `WIDTH_BUCKET(value, min, max, count) → INT`. The PPL
}
fn is_integer_span(span: f64) -> bool {
        &self.signature
            "width_bucket: slot '{slot}' expected Float64 post-coerce, got {:?}",
fn downcast_f64<'a>(arr: &'a ArrayRef, slot: &str) -> Result<&'a Float64Array> {
                DataType::Int64,
                DataType::Float64
        ];
        // range=99, bins=10, max=99 → targetWidth=9.9 → exponent=1 → width=10.
        assert_eq!(out, vec![Some("30000-40000".to_string())]);
//!
    }
    #[test]
            config_options: Arc::new(Default::default()),
use std::sync::Arc;
    }
    #[test]
        return None;
const MAX_BINS: i64 = 50_000;
        assert_eq!(n, num_bins.len());
    let mut width = 10f64.powf(exponent);
    #[test]
            }
};
    fn num_bins_at_boundary_accepted() {
            vec![Some(100.0), Some(100.0), Some(100.0), None],
