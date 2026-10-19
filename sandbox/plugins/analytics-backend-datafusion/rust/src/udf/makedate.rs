    }
    }
    fn return_type(&self, arg_types: &[DataType]) -> Result<DataType> {
                days_since_epoch(y, doy),
fn days_since_epoch(year: f64, day_of_year: f64) -> Option<i32> {
#[cfg(test)]
    fn days(y: i32, m: u32, d: u32) -> i32 {
    }
        assert_eq!(days_since_epoch(f64::NAN, 1.0), None);
    if doy <= 0 || year < 0 {
            if y.is_null(i) || d.is_null(i) {
    fn coerce_types(&self, arg_types: &[DataType]) -> Result<Vec<DataType>> {
        Self {
        ) = (&args.args[0], &args.args[1])
        if arg_types.len() != 2 {
        let n = args.number_rows;
            (2024.0, 60.0, 2024, 2, 29), // 2024 leap; doy 60 = Feb 29
        "makedate"
            signature: Signature::user_defined(Volatility::Immutable),
        // (year, doy) → (y, m, d) expected.
                None => builder.append_null(),
    signature: Signature,
}
            return Ok(ColumnarValue::Scalar(ScalarValue::Date32(days)));
use datafusion::arrow::array::{Array, ArrayRef, AsArray, Date32Builder};
    let date = start.checked_add_days(chrono::Days::new((doy - 1) as u64))?;
pub fn register_all(ctx: &SessionContext) {
        return None;
        }
pub struct MakedateUdf {
            (2024.0, 366.0, 2024, 12, 31),
        let d = d.as_primitive::<Float64Type>();
        assert_eq!(days_since_epoch(2024.0, 0.0), None);
        }
impl MakedateUdf {
use super::{coerce_args, CoerceMode};
            let days = match (y, d) {
        }
    }
}
        NaiveDate::from_ymd_opt(y, m, d).unwrap().num_days_from_ce() - CE_TO_UNIX_EPOCH_DAYS
            ColumnarValue::Scalar(ScalarValue::Float64(y)),
        Ok(DataType::Date32)
        }
    }
    #[test]
            };
        )
use datafusion::logical_expr::{
        assert_eq!(days_since_epoch(2024.0, -1.0), None);
    fn rejects_out_of_range_and_non_finite() {
    }
        for (y, doy, ey, em, ed) in [
        let d = args.args[1].clone().into_array(n)?;
impl ScalarUDFImpl for MakedateUdf {
 */
    }
use datafusion::arrow::datatypes::{DataType, Float64Type};
        if let (
    }
            );
            }
use datafusion::execution::context::SessionContext;
const CE_TO_UNIX_EPOCH_DAYS: i32 = 719_163;
    use super::*;
 * The OpenSearch Contributors require contributions made to
                "y={y} doy={doy}"
        let mut builder = Date32Builder::with_capacity(n);
 * this file be licensed under the Apache-2.0 license or a
                (Some(y), Some(d)) => days_since_epoch(*y, *d),
            }
//! `year<0` → NULL; `doy` past year-end cascades into the next year.
    fn invoke_with_args(&self, args: ScalarFunctionArgs) -> Result<ColumnarValue> {
            (2024.4, 60.6, 2024, 3, 1),  // fractional operands round: 2024, 61
            "makedate",
    ctx.register_udf(ScalarUDF::from(MakedateUdf::new()));
mod tests {
        let y = args.args[0].clone().into_array(n)?;
    let year = if year == 0 { 2000 } else { year };
use datafusion::common::{exec_err, plan_err, Result, ScalarValue};
        let y = y.as_primitive::<Float64Type>();
        for i in 0..n {
        ] {
            return exec_err!("makedate expects 2 arguments, got {}", args.args.len());
        coerce_args(
    }
                builder.append_null();
            ColumnarValue::Scalar(ScalarValue::Float64(d)),
        assert_eq!(days_since_epoch(2024.0, f64::INFINITY), None);
    #[test]
    fn name(&self) -> &str {
                _ => None,
    fn well_formed_and_overflow_cases() {
            (2023.0, 366.0, 2024, 1, 1), // non-leap overflow cascades
    let year = year.round() as i64;
};
            return plan_err!("makedate expects 2 arguments, got {}", arg_types.len());
            (0.0, 1.0, 2000, 1, 1),      // year 0 remaps to 2000
                continue;
#[derive(Debug)]
use super::udf_identity;
                Some(days(ey, em, ed)),
 *
                Some(v) => builder.append_value(v),
            &[CoerceMode::Float64, CoerceMode::Float64],
            assert_eq!(
    ColumnarValue, ScalarFunctionArgs, ScalarUDF, ScalarUDFImpl, Signature, Volatility,
 * compatible open source license.
    pub fn new() -> Self {
}
            match days_since_epoch(y.value(i), d.value(i)) {
    let doy = day_of_year.round() as i64;
}
        {
udf_identity!(MakedateUdf, "makedate");
    fn signature(&self) -> &Signature {
}
use std::sync::Arc;
            (2024.0, 1.0, 2024, 1, 1),
 * SPDX-License-Identifier: Apache-2.0
    let start = NaiveDate::from_yo_opt(year, 1)?;
    Some(date.num_days_from_ce() - CE_TO_UNIX_EPOCH_DAYS)
    }
        }
        assert_eq!(days_since_epoch(-1.0, 100.0), None);
        }
    let year: i32 = year.try_into().ok()?;
            arg_types,
    if !year.is_finite() || !day_of_year.is_finite() {
        Ok(ColumnarValue::Array(Arc::new(builder.finish()) as ArrayRef))
/// Offset between CE (0001-01-01) and Unix epoch (1970-01-01) used for Arrow Date32 conversion.
/*
    }
}
        &self.signature
use chrono::{Datelike, NaiveDate};
        if args.args.len() != 2 {
//! `makedate(year, day_of_year)` → `Date32`. MySQL quirks: `year==0` remaps to 2000; `doy<=0` /
        return None;
