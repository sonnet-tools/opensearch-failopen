            return plan_err!("width_bucket expects 4 arguments, got {}", arg_types.len());
//! `sql/core/.../binning/WidthBucketFunction.java`). Given a numeric value,
mod tests {
            Arc::new(Field::new("value", DataType::Float64, true)),
        assert_eq!(optimal_width(50.0, 50.0, 5), 100.0);
            arr.data_type()
            number_rows: n,
            return plan_err!("width_bucket expects 4 arguments, got {}", args.args.len());
        Ok(DataType::Utf8)
        assert_eq!(
    }
        let num_bins = args.args[1].clone().into_array(n)?;
        let max_value = args.args[3].clone().into_array(n)?;
use datafusion::logical_expr::{
        format!("{}-{}", bin_start as i64, bin_end as i64)
                num_bins.value(i),
        let bins_arr = Arc::new(Int64Array::from(num_bins)) as ArrayRef;
        let out = udf.invoke_with_args(args).unwrap();
/// fallback so this function's contract matches Java's exactly and anyone
        let udf = WidthBucketUdf::new();
//!
        let out = udf
                DataType::Utf8,
        let mut builder = StringBuilder::with_capacity(n, n * 16);
            "width_bucket: slot '{slot}' expected Int64 post-coerce, got {:?}",
        4
        // MAX_BINS = 50_000.
        let out = invoke_batch(
            calculate(39225.0, 10, 33539.0, 33539.0),
            .map(|i| {
        ))
    use datafusion::arrow::array::AsArray;
        assert!((w - 0.1).abs() < 1e-12, "expected ~0.1, got {w}");
const MIN_BINS: i64 = 2;
// distinct format policy without untangling a shared dependency.
            "width_bucket",
//! `width_bucket(value, num_bins, data_range, max_value)` — histogram bucket label.
    }
    } else if span >= 0.1 {
                continue;
fn optimal_width(data_range: f64, max_value: f64, requested_bins: i64) -> f64 {
        1
    fn coerce_types_rejects_wrong_arity() {
    // ── Batch invocation via DataFusion scalar harness ─────────────────────
        // Each row has exactly one null slot; all rows should produce null labels.
                if s.is_null(i) {
    ColumnarValue, ScalarFunctionArgs, ScalarUDF, ScalarUDFImpl, Signature, Volatility,
        );
        };
        assert_eq!(calculate(5.0, 1, 100.0, 100.0), None);
        assert!(udf
            &[
            .coerce_types(&[
fn downcast_f64<'a>(arr: &'a ArrayRef, slot: &str) -> Result<&'a Float64Array> {
        let range = downcast_f64(&range, "data_range")?;
    } else {
//!   higher if `ceil(range/width) + (maxValue % width == 0 ? 1 : 0)` would
    let bin_start = (value / width).floor() * width;
    }
//!
        };
                DataType::Int64,
            ])
    let mut actual_bins = (data_range / width).ceil();
}
    fn coerce_types_canonicalises_mixed_numeric_inputs() {
                }
        assert!(calculate(5.0, MAX_BINS, 100.0, 100.0).is_some());
    }
    fn zero_range_returns_null() {
            arg_types,
        // ceil(99/10)=10. 99 % 10 = 9 ≠ 0, no bump. 10 > 10 false → width=10.
    pub fn new() -> Self {
            config_options: Arc::new(Default::default()),
    }
    }
        return 1.0;
        values: Vec<Option<f64>>,
    #[test]
    let bin_end = bin_start + width;
        // ceil(1/0.1)=10. 1 % 0.1 is fp-ugly (~0.1) ≠ 0, no bump. 10 > 10 false → width=0.1.
    (v - v.round()).abs() < 1e-10
                Some(s) => builder.append_value(&s),
        // ceil(50/10)=5. 50 % 10 == 0 → actualBins=6. 6 > 5 → rescale to 10^2=100.
    fn num_bins_above_maximum_returns_null() {
    if span >= 1.0 {
        actual_bins += 1.0;
            ) {
            vec![Some(10), None, Some(10), Some(10)],
            .collect()
    #[test]
}
    // ── Optimal-width rescale branch ───────────────────────────────────────
    }
        ranges: Vec<Option<f64>>,
 * The OpenSearch Contributors require contributions made to
    #[test]
fn format_range(bin_start: f64, bin_end: f64, span: f64) -> String {
            ]
        assert_eq!(optimal_width(99.0, 99.0, 10), 10.0);
    use datafusion::logical_expr::ScalarFunctionArgs;
            })
            .is_err());
            args: vec![
        let udf = WidthBucketUdf::new();
        let n = args.number_rows;
            Arc::new(Field::new("num_bins", DataType::Int64, true)),
    if actual_bins > requested_bins as f64 {
}
        assert_eq!(calculate(5.0, 50_001, 100.0, 100.0), None);
/*
    // ── Range guards ───────────────────────────────────────────────────────
        let decimals = decimal_places_for(span);
        //   no bump. 4 > 10 false → width stays 10000.
    }
            vec![Some(100.0), Some(100.0), None, Some(100.0)],
            ])
//! Semantics:
//! algorithm. The two collide in name only; any future wiring of real ISO SQL
                CoerceMode::Int64,
    let mut width = 10f64.powf(exponent);
        assert_eq!(calculate(5.0, 0, 100.0, 100.0), None);
/// Core width-bucket math. Direct port of Java
}
    ) -> Vec<Option<String>> {
//! * Any null input → null (null propagation).
        let max_arr = Arc::new(Float64Array::from(maxes)) as ArrayRef;
    signature: Signature,
}
    }
    fn coerce_types(&self, arg_types: &[DataType]) -> Result<Vec<DataType>> {
        if arg_types.len() != 4 {
        width = 10f64.powf(exponent + 1.0);
    use super::*;
                DataType::Float64
#[derive(Debug, PartialEq, Eq, Hash)]
    }
                DataType::Int32,
        let s = a.as_string::<i32>();
    width
                ColumnarValue::Array(bins_arr),
use datafusion::arrow::datatypes::DataType;
// (range_bucket and minspan_bucket both reuse this exact helper), but keeping
}
                DataType::Float64,
    // Java: `if (maxValue % optimalWidth == 0) actualBins++;`
    // happens in `invoke_with_args`. Batch test below covers it.
//!
                DataType::Float64,
    //! steps matter (optimal-width rescale branch), we pin `optimal_width`
                    Some(s.value(i).to_string())
    #[test]
        Self::new()
                DataType::Float64,
    if data_range <= 0.0 || requested_bins <= 0 {
    fn num_bins_below_minimum_returns_null() {
    }
    arr.as_any().downcast_ref::<Float64Array>().ok_or_else(|| {
        // coerce_types normalizes slot 1 (num_bins) to Int64 and slots 0/2/3
        coerce_args(
        // (numeric value, range, max) to Float64 — same pattern as
        assert_eq!(n, maxes.len());
            }
    }
use super::{coerce_args, CoerceMode};
        }
    fn bank_fixture_width_10000() {
        let max_value = downcast_f64(&max_value, "max_value")?;
// ─── tests ──────────────────────────────────────────────────────────────────
            vec![Some(33539.0)],
            vec![Some(10)],
    }
                ColumnarValue::Array(max_arr),
 *
    ctx.register_udf(ScalarUDF::from(WidthBucketUdf::new()));
    #[test]
        maxes: Vec<Option<f64>>,
        assert_eq!(calculate(5.0, i64::MAX, 100.0, 100.0), None);
                DataType::Float32,
/// Mirrors `WidthBucketFunction.calculateOptimalWidth` — the Java reference
        let arg_fields = vec![
        assert_eq!(
        // value=39225 → binStart=floor(39225/10000)*10000=30000, binEnd=40000.
fn is_integer_value(v: f64) -> bool {
            out,
impl WidthBucketUdf {
/// Mirror `BinConstants.MAX_BINS`.
    }
        assert!(calculate(5.0, MIN_BINS, 100.0, 100.0).is_some());
fn decimal_places_for(span: f64) -> usize {
//! variant returns a VARCHAR bucket label via a nice-number magnitude-based
        "width_bucket"
    #[test]
            vec![None, Some(5.0), Some(5.0), Some(5.0)],
use datafusion::common::plan_err;
        return None;
        let num_bins = downcast_i64(&num_bins, "num_bins")?;
}
        let args = ScalarFunctionArgs {
/// Mirror `org.opensearch.sql.calcite.utils.binning.BinConstants.MIN_BINS`.
    }
    fn non_finite_range_returns_null() {
            "width_bucket: slot '{slot}' expected Float64 post-coerce, got {:?}",
            vec![
                DataType::Int64,
        //   → width=10000. actualBins=ceil(33539/10000)=4. 33539 % 10000 = 3539 ≠ 0,
    }
            signature: Signature::user_defined(Volatility::Immutable),
        )
    if max_value % width == 0.0 {
 * this file be licensed under the Apache-2.0 license or a
        let ColumnarValue::Array(a) = out else {
        for i in 0..n {
        DataFusionError::Internal(format!(
    // ── coerce_types ───────────────────────────────────────────────────────
    fn optimal_width_no_rescale_when_max_offboundary() {
    if !(MIN_BINS..=MAX_BINS).contains(&num_bins) {
    } else {
            panic!("expected array")
fn calculate(value: f64, num_bins: i64, range: f64, max_value: f64) -> Option<String> {
    }
    span.is_finite() && span == span.floor()
    use datafusion::arrow::datatypes::Field;
                DataType::Float64,
                ColumnarValue::Array(value_arr),
        }
    }
        ];
    }
            Arc::new(Field::new("max_value", DataType::Float64, true)),
                } else {
            ],
    }
        ))
}
        // MIN_BINS = 2.
    fn invoke_batch(
//! <b>Not</b> ISO-SQL `WIDTH_BUCKET(value, min, max, count) → INT`. The PPL
    }
    } else if span >= 0.01 {
        return None;
//! * `numBins` outside `[MIN_BINS, MAX_BINS]` → null
        assert_eq!(
        let return_field = Arc::new(Field::new("out", DataType::Utf8, true));
        num_bins: Vec<Option<i64>>,
        assert_eq!(calculate(5.0, 10, f64::INFINITY, 100.0), None);
    fn batch_null_in_any_slot_propagates_null() {
        assert_eq!(calculate(5.0, 10, f64::NEG_INFINITY, 100.0), None);
    if !range.is_finite() || range <= 0.0 {
            Some("30000-40000".to_string())
const MAX_BINS: i64 = 50_000;
    //! `WidthBucketFunction.calculateWidthBucket`. Any drift from Java is a
                CoerceMode::Float64,
use datafusion::error::{DataFusionError, Result};
            .is_err());
                DataType::Float64
//! * Optimal width = `10^ceil(log10(range/numBins))`; bumped one magnitude
                DataType::Int32,
    })
        if args.args.len() != 4 {
    }
        assert_eq!(calculate(5.0, 10, f64::NAN, 100.0), None);
                None => builder.append_null(),
        assert_eq!(n, num_bins.len());
            vec![Some(100.0), Some(100.0), Some(100.0), None],
    fn optimal_width_rescales_when_max_on_boundary_exceeds_bins() {
            }
}
        &self.signature
    //! Expected values seeded from the Java reference
    #[test]
    fn batch_happy_path_non_null_rows() {
    //! directly so the test names describe the invariant being exercised.
    #[test]
        let value = args.args[0].clone().into_array(n)?;
            Arc::new(Field::new("data_range", DataType::Float64, true)),
    #[test]
    }
                range.value(i),
use std::sync::Arc;
        let value_arr = Arc::new(Float64Array::from(values)) as ArrayRef;
            match calculate(
    if !width.is_finite() || width <= 0.0 {
        );
    #[test]
            .unwrap(),
                builder.append_null();
    if is_integer_span(span) && is_integer_value(bin_start) && is_integer_value(bin_end) {
pub struct WidthBucketUdf {
            ])
        // range=1, bins=10 → targetWidth=0.1 → exponent=ceil(log10(0.1))=-1 → width=0.1.
    fn signature(&self) -> &Signature {
        let value = downcast_f64(&value, "value")?;
    let exponent = target_width.log10().ceil();
/// admits an explicit fallback of `1.0` when `range <= 0` or `bins <= 0`;
        assert!(udf.return_type(&[DataType::Float64]).is_err());
    }
    fn return_type(&self, arg_types: &[DataType]) -> Result<DataType> {
        return None;
                DataType::Int64,
//!   exceed `numBins`. Label uses the same integer/float decimal-place rules
            .coerce_types(&[DataType::Int64, DataType::Int64, DataType::Int64])
        let range_arr = Arc::new(Float64Array::from(ranges)) as ArrayRef;
        Self {
    fn name(&self) -> &str {
    let target_width = data_range / requested_bins as f64;
}
    fn default() -> Self {
    // `calculate` takes primitives and can't observe a null; null propagation
// shared module. The PPL binning family is expected to converge over time
    let width = optimal_width(range, max_value, num_bins);
    // ── Null inputs at the batch layer ─────────────────────────────────────
    }
                DataType::Float64,
                CoerceMode::Float64,
        (0..n)
impl Default for WidthBucketUdf {
    #[test]
    arr.as_any().downcast_ref::<Int64Array>().ok_or_else(|| {
            arg_fields,
//! label (e.g. `"30000-40000"`).
pub fn register_all(ctx: &SessionContext) {
                DataType::Float64,
            return_field,
        // SpanBucketUdf. invoke_with_args downcasts once per slot.
            udf.return_type(&[
        assert_eq!(n, ranges.len());
// each UDF self-contained makes it trivial to later give one of them a
            arr.data_type()
                ColumnarValue::Array(range_arr),
                    None
            ],
        assert_eq!(calculate(5.0, -1, 100.0, 100.0), None);
        let udf = WidthBucketUdf::new();
        let range = args.args[2].clone().into_array(n)?;
    fn return_type_enforces_four_arg_arity() {
    fn optimal_width_target_under_one_yields_unit_width() {
    }
    // ── Boundary of numBins ────────────────────────────────────────────────
                DataType::Int64,
        // range=50, bins=5, max=50 → targetWidth=10 → exponent=1 → width=10.
            DataType::Utf8
    Some(format_range(bin_start, bin_end, width))
    }
        );
        }
        Ok(ColumnarValue::Array(Arc::new(builder.finish()) as ArrayRef))
    #[test]
    fn coerce_types_rejects_string_in_value_slot() {
    #[test]
 * SPDX-License-Identifier: Apache-2.0
    //! bug in this port, not the test. Where the algorithm's intermediate
        let n = values.len();
//! * `range <= 0` or non-finite → null
use datafusion::arrow::array::{Array, ArrayRef, Float64Array, Int64Array, StringBuilder};
impl ScalarUDFImpl for WidthBucketUdf {
        let w = optimal_width(1.0, 1.0, 10);
/// reusing it directly gets identical behavior.
            .unwrap();
//! width_bucket (DataFusion has it natively) needs a distinct enum entry.
        assert_eq!(calculate(5.0, 10, -1.0, 100.0), None);
        }
    #[test]
}
 * compatible open source license.
fn is_integer_span(span: f64) -> bool {
                value.value(i),
}
        DataFusionError::Internal(format!(
    })
    fn num_bins_at_boundary_accepted() {
        assert_eq!(out, vec![None, None, None, None]);
    fn negative_range_returns_null() {
/// we can't hit those from `calculate` (already guarded), but we keep the
        );
        );
// Formatting helpers — duplicated from span_bucket rather than moved to a
        assert_eq!(calculate(5.0, 10, 0.0, 100.0), None);
        3
        format!("{:.*}-{:.*}", decimals, bin_start, decimals, bin_end)
fn downcast_i64<'a>(arr: &'a ArrayRef, slot: &str) -> Result<&'a Int64Array> {
    #[test]
//! half-open bucket `[binStart, binEnd)` that contains `value` as a VARCHAR
        // range=99, bins=10, max=99 → targetWidth=9.9 → exponent=1 → width=10.
    }
    fn invoke_with_args(&self, args: ScalarFunctionArgs) -> Result<ColumnarValue> {
//! Ports the OpenSearch-SQL bespoke `WIDTH_BUCKET` UDF (see
    }
        assert_eq!(out, vec![Some("30000-40000".to_string())]);
        let udf = WidthBucketUdf::new();
            vec![Some(39225.0)],
//! requested bin count, total data range, and dataset max, returns the
            if value.is_null(i) || num_bins.is_null(i) || range.is_null(i) || max_value.is_null(i) {
        // range=33539, bins=10 → targetWidth=3353.9 → exponent=ceil(log10(...))=4
        assert!(udf
    #[test]
use datafusion::execution::context::SessionContext;
}
                CoerceMode::Float64,
    }
};
}
    // ── Happy path: exact bank-fixture case from subtraitupdates's tests ───
//!   as `span_bucket`.
/// `WidthBucketFunction.calculateWidthBucket`.
        let udf = WidthBucketUdf::new();
    }
        2
 */
    }
            vec![Some(33539.0)],
        let out = invoke_batch(
#[cfg(test)]
                max_value.value(i),
            .coerce_types(&[
