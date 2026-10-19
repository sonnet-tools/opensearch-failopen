        if arg_types.len() != 1 {
        Ok(DataType::Timestamp(TimeUnit::Microsecond, None))
    }
            assert_eq!(to_micros(v), None, "v={v}");
        for i in 0..input.len() {
    use super::*;
    pub fn new() -> Self {
    #[test]
            if input.is_null(i) {
            }
//! `from_unixtime(seconds)` — UNIX seconds (fractional ok) → `Timestamp(us)`. Negative / ≥ MySQL
            signature: Signature::user_defined(Volatility::Immutable),
        // Sub-microsecond truncates (not rounds) to match PPL's int cast.
            return plan_err!("from_unixtime expects 1 argument, got {}", arg_types.len());
            MAX_UNIX_SECONDS_EXCLUSIVE,
use datafusion::arrow::datatypes::{DataType, TimeUnit};
 */
    signature: Signature,
/*
 * compatible open source license.
        }
    fn invoke_with_args(&self, args: ScalarFunctionArgs) -> Result<ColumnarValue> {
#[cfg(test)]
        "from_unixtime"
        }
    }
    }
    }
    fn converts_epoch_and_fractional_seconds() {
            return exec_err!("from_unixtime expects 1 argument, got {}", args.args.len());
    }
    // PPL truncates nanos via int cast after `(v%1)*1e9`; trunc ≡ floor for non-negative seconds.
use datafusion::execution::context::SessionContext;
        }
    ctx.register_udf(ScalarUDF::from(FromUnixtimeUdf::new()));
        return None;
    fn return_type(&self, arg_types: &[DataType]) -> Result<DataType> {
 * The OpenSearch Contributors require contributions made to
}
            match to_micros(input.value(i)) {
    }
fn to_micros(seconds: f64) -> Option<i64> {
use datafusion::arrow::array::{Array, ArrayRef, AsArray, TimestampMicrosecondBuilder};
    fn rejects_out_of_range_and_non_finite() {
            return Ok(ColumnarValue::Scalar(ScalarValue::TimestampMicrosecond(
 * this file be licensed under the Apache-2.0 license or a
    }
    Some((seconds * 1_000_000.0).trunc() as i64)
    }
        let input = input.as_primitive::<datafusion::arrow::datatypes::Float64Type>();
 *
pub fn register_all(ctx: &SessionContext) {
}
                builder.append_null();
        let n = args.number_rows;
    }
        if let ColumnarValue::Scalar(ScalarValue::Float64(v)) = &args.args[0] {
};
    fn coerce_types(&self, arg_types: &[DataType]) -> Result<Vec<DataType>> {
        if args.args.len() != 1 {
        assert_eq!(to_micros(1.5), Some(1_500_000));
use super::{coerce_args, CoerceMode};
use std::sync::Arc;
/// MySQL docs: values at/above 32536771199.999999 return 0; first failing second is 32_536_771_200.
    #[test]
}
impl FromUnixtimeUdf {
 * SPDX-License-Identifier: Apache-2.0
use super::udf_identity;
                continue;
        assert_eq!(to_micros(0.000_001_9), Some(1));
            f64::INFINITY,
}
    ColumnarValue, ScalarFunctionArgs, ScalarUDF, ScalarUDFImpl, Signature, Volatility,
}
            -0.1,
mod tests {
use datafusion::common::{exec_err, plan_err, Result, ScalarValue};
        assert_eq!(to_micros(0.0), Some(0));
        coerce_args("from_unixtime", arg_types, &[CoerceMode::Float64])
impl ScalarUDFImpl for FromUnixtimeUdf {
udf_identity!(FromUnixtimeUdf, "from_unixtime");
        Self {
    fn name(&self) -> &str {
        }
use datafusion::logical_expr::{
            MAX_UNIX_SECONDS_EXCLUSIVE + 1.0,
#[derive(Debug)]
            }
        let input = args.args[0].clone().into_array(n)?;
        for v in [
    fn signature(&self) -> &Signature {
                Some(us) => builder.append_value(us),
        }
                None => builder.append_null(),
        &self.signature
            f64::NAN,
            )));
        Ok(ColumnarValue::Array(Arc::new(builder.finish()) as ArrayRef))
        assert_eq!(to_micros(0.000_000_9), Some(0));
pub struct FromUnixtimeUdf {
const MAX_UNIX_SECONDS_EXCLUSIVE: f64 = 32_536_771_200.0;
//! upper bound / non-finite → NULL. 2-arg `(seconds, format)` overload deferred to date_format.
}
    if !seconds.is_finite() || !(0.0..MAX_UNIX_SECONDS_EXCLUSIVE).contains(&seconds) {
                micros, None,
            let micros = v.and_then(to_micros);
        let mut builder = TimestampMicrosecondBuilder::with_capacity(n);
        ] {
        }
