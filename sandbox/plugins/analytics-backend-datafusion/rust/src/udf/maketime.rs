fn micros_of_day(hour: f64, minute: f64, second: f64) -> Option<i64> {
            &[
                // micros_of_day is bounded by 24h*60m*60s*1e6 = 8.64e10 µs, so
        assert_eq!(micros_of_day(0.0, 59.5, 0.0), None);
        coerce_args(
    // Java's Math.round(d) = (long)floor(d+0.5); Rust's f64::round is half-away-from-zero which
    fn signature(&self) -> &Signature {
            };
    }
    }
    fn well_formed_and_rounding_semantics() {
    fn rejects_invalid_operands() {
        assert_eq!(micros_of_day(23.5, 0.0, 0.0), None);
    fn coerce_types(&self, arg_types: &[DataType]) -> Result<Vec<DataType>> {
    signature: Signature,
    #[test]
                // Lossless µs → ns scale (×1_000); see invoke_with_args scalar branch.
        if let (
    }
    let second_micros = (second * 1_000_000.0).trunc() as i64;
use datafusion::common::{exec_err, plan_err, Result, ScalarValue};
use std::sync::Arc;
    }
 */
    if !(0..=23).contains(&hour) || !(0..=59).contains(&minute) || second >= 60.0 {
                continue;
        // Non-finite.
//! `maketime(hour, minute, second)` → `Time64(ns)`. Hour/minute rounded; second passes with fraction.
use super::udf_identity;
    }
        if arg_types.len() != 3 {
                // *1_000 to ns yields ≤ 8.64e13 — safely within i64::MAX (≈9.2e18).
        }
        }
            let nanos = match (h, m, s) {
        // Negative components.
impl ScalarUDFImpl for MaketimeUdf {
 * this file be licensed under the Apache-2.0 license or a
            return plan_err!("maketime expects 3 arguments, got {}", arg_types.len());
        ) = (&args.args[0], &args.args[1], &args.args[2])
    // matches for non-negative inputs. PPL throws on out-of-range; we return None → NULL.
    fn invoke_with_args(&self, args: ScalarFunctionArgs) -> Result<ColumnarValue> {
                Some(us) => builder.append_value(us * 1_000),
            return Ok(ColumnarValue::Scalar(ScalarValue::Time64Nanosecond(nanos)));
 * SPDX-License-Identifier: Apache-2.0
            Some(2 * 3_600_000_000 + 2 * 60_000_000 + 3_999_999)
//!
            Some(3_600_000_000 + 2 * 60_000_000 + 3_500_000)
//! emission to widen losslessly to nanoseconds (max value 8.64e13 ≪ i64::MAX).
use datafusion::logical_expr::{
            signature: Signature::user_defined(Volatility::Immutable),
            match micros_of_day(h.value(i), m.value(i), s.value(i)) {
        let mut builder = Time64NanosecondBuilder::with_capacity(n);
                CoerceMode::Float64,
            ],
//! which all emit `Time64(Nanosecond)`. The internal `micros_of_day` helper
        for args in [(-0.1, 0.0, 0.0), (0.0, -0.1, 0.0), (0.0, 0.0, -0.1)] {
 *
    if !hour.is_finite() || !minute.is_finite() || !second.is_finite() {
    }
            arg_types,
}
            return exec_err!("maketime expects 3 arguments, got {}", args.args.len());
        // Out of range after rounding: 23.5→24h, 59.5→60m, 60s (no rounding).
        assert_eq!(micros_of_day(0.0, 0.0, 60.0), None);
            ColumnarValue::Scalar(ScalarValue::Float64(s)),
    }
        return None;
        );
        "maketime"
    pub fn new() -> Self {
use datafusion::execution::context::SessionContext;
}
mod tests {
    ctx.register_udf(ScalarUDF::from(MaketimeUdf::new()));
udf_identity!(MaketimeUdf, "maketime");
        }
impl MaketimeUdf {
            }
        let m = args.args[1].clone().into_array(n)?;
        for i in 0..n {
        let s = s.as_primitive::<Float64Type>();
};
                builder.append_null();
        let s = args.args[2].clone().into_array(n)?;
            micros_of_day(1.0, 2.0, 3.5),
                CoerceMode::Float64,
 * compatible open source license.
            "maketime",
//! still computes a microsecond count; the call sites multiply by 1_000 at
        let h = args.args[0].clone().into_array(n)?;
        assert_eq!(micros_of_day(f64::INFINITY, 0.0, 0.0), None);
//! Arrow output type harmonises with `current_time` / `to_time` / `curtime`,
        // 1.6→2h, 2.4→2m (half-away-from-zero), 3.999999s truncated.
#[cfg(test)]
        assert_eq!(micros_of_day(f64::NAN, 0.0, 0.0), None);
    ColumnarValue, ScalarFunctionArgs, ScalarUDF, ScalarUDFImpl, Signature, Volatility,
pub struct MaketimeUdf {
    let hour = hour.round() as i64;
        return None;
use datafusion::arrow::datatypes::{DataType, Float64Type, TimeUnit};
    #[test]
    use super::*;
pub fn register_all(ctx: &SessionContext) {
    }
//! Negative / non-finite / out-of-range (after rounding) / null → NULL.
    Some(hour * 3_600_000_000 + minute * 60_000_000 + second_micros)
use super::{coerce_args, CoerceMode};
            assert_eq!(micros_of_day(args.0, args.1, args.2), None, "{args:?}");
            if h.is_null(i) || m.is_null(i) || s.is_null(i) {
/*
            ColumnarValue::Scalar(ScalarValue::Float64(h)),
        Ok(ColumnarValue::Array(Arc::new(builder.finish()) as ArrayRef))
        }
                _ => None,
        Self {
        assert_eq!(
use datafusion::arrow::array::{Array, ArrayRef, AsArray, Time64NanosecondBuilder};
            micros_of_day(1.6, 2.4, 3.999_999),
            }
}
        }
        {
        assert_eq!(
        );
            ColumnarValue::Scalar(ScalarValue::Float64(m)),
    fn name(&self) -> &str {
    let minute = minute.round() as i64;
 * The OpenSearch Contributors require contributions made to
                (Some(h), Some(m), Some(s)) => micros_of_day(*h, *m, *s).map(|us| us * 1_000),
}
        let m = m.as_primitive::<Float64Type>();
//! Output is `Time64(Nanosecond)` (not `Time64(Microsecond)`) so that maketime's
    }
                CoerceMode::Float64,
                None => builder.append_null(),
    if hour < 0.0 || minute < 0.0 || second < 0.0 {
}
        let h = h.as_primitive::<Float64Type>();
    }
        let n = args.number_rows;
        )
#[derive(Debug)]
        return None;
}
        &self.signature
        // (1, 2, 3.5) → 1h2m3.5s.
        Ok(DataType::Time64(TimeUnit::Nanosecond))
    fn return_type(&self, arg_types: &[DataType]) -> Result<DataType> {
        }
    }
        if args.args.len() != 3 {
