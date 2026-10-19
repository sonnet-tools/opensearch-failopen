    let micros_rem = micros.rem_euclid(1_000_000) as u32;
        if arg_types.len() != 2 {
        Self {
        let out = render_at(1_584_268_245_123_456, "%Y-%m-%d %H:%i:%S", FormatMode::Date).unwrap();
            Some(s) => builder.append_value(&s),
            ScalarValue::TimestampMicrosecond(v, _) => *v,
            _ => None,
            other => return exec_err!("{udf}: unsupported format scalar: {other:?}"),
use datafusion::arrow::datatypes::{DataType, TimeUnit};
            signature: Signature::user_defined(Volatility::Immutable),
use super::os_strftime::{format_datetime, FormatMode};
                if a.is_null(i) {
        assert_eq!(out, "2020-03-15 10:30:45");
                let a = f_arr.as_string::<i64>();
                DataType::Timestamp(TimeUnit::Microsecond, None)
        if ts.is_null(i) {
    fn null_format_returns_none() {
            (Some(m), Some(f)) => render_at(m, &f, mode),
        };
use chrono::{TimeZone, Utc};
    Array, ArrayRef, AsArray, StringBuilder, TimestampMicrosecondArray,
                v_arr.data_type()
            return plan_err!("date_format expects 2 arguments, got {}", arg_types.len());
        let fmt_opt = match f_arr.data_type() {
) -> Result<ColumnarValue> {
    let f_arr = args.args[1].clone().into_array(n)?;
}
            }
    let dt = Utc.timestamp_opt(seconds, micros_rem * 1_000).single()?;
    if args.args.len() != 2 {
                    None
        Ok(DataType::Utf8)
                    None
    signature: Signature,
            other => {
    let seconds = micros.div_euclid(1_000_000);
    udf: &str,
impl ScalarUDFImpl for DateFormatUdf {
    fn render_scalar_matches_os_strftime() {
            other => return plan_err!("date_format: arg 1 expected string, got {other:?}"),
#[derive(Debug)]
        .ok_or_else(|| {
        };
        };
//! ([`os_strftime`](super::os_strftime)). Returns Utf8; null input → null.
 *
        }
                    Some(a.value(i).to_string())
        &self.signature
    format_datetime(dt, format, mode)
    Ok(ColumnarValue::Array(Arc::new(builder.finish()) as ArrayRef))
    let v_arr = args.args[0].clone().into_array(n)?;
        .as_any()
                }
            builder.append_null();
    }
            DataType::Timestamp(_, _) | DataType::Date32 | DataType::Date64 => {
            DataType::Utf8 | DataType::LargeUtf8 | DataType::Utf8View => DataType::Utf8,
};
        }
                return plan_err!(
            }
            DataType::LargeUtf8 => {
 * compatible open source license.
        match fmt_opt.and_then(|f| render_at(ts.value(i), &f, mode)) {
mod tests {
        "date_format"
    fn invoke_with_args(&self, args: ScalarFunctionArgs) -> Result<ColumnarValue> {
}
/*
    mode: FormatMode,
        let fmt = match &arg_types[1] {
                let a = f_arr.as_string::<i32>();
            other => return exec_err!("{udf}: format array has unexpected type {other:?}"),
    }
        }
use datafusion::arrow::array::{
    }
                )
    if let (ColumnarValue::Scalar(v), ColumnarValue::Scalar(fmt)) = (&args.args[0], &args.args[1]) {
            }
        let micros = match v {
};
    args: ScalarFunctionArgs,
 * this file be licensed under the Apache-2.0 license or a
    #[test]
use datafusion::execution::context::SessionContext;
#[cfg(test)]
        let out = match (micros, fmt_str) {
                    "date_format: arg 0 expected timestamp/date/string, got {other:?}"
    let n = args.number_rows;
    }
            ScalarValue::Utf8(opt) | ScalarValue::LargeUtf8(opt) => opt.clone(),
            None => builder.append_null(),
    ctx.register_udf(ScalarUDF::from(DateFormatUdf::new()));
        })?;
impl DateFormatUdf {
}
}
        return exec_err!("{udf} expects 2 arguments, got {}", args.args.len());
        .downcast_ref::<TimestampMicrosecondArray>()
                }
pub(crate) fn format_dispatch(
udf_identity!(DateFormatUdf, "date_format");
 * The OpenSearch Contributors require contributions made to
fn render_at(micros: i64, format: &str, mode: FormatMode) -> Option<String> {
    for i in 0..n {
        }
    }
                    Some(a.value(i).to_string())
//! `date_format(datetime, format)` — render a timestamp via MySQL-style tokens
    #[test]
            ))
        }
}
                } else {
    fn name(&self) -> &str {
        };
    }
        let ts = match &arg_types[0] {
            return plan_err!("date_format expects 2 arguments, got {}", arg_types.len());
            }
use std::sync::Arc;
        format_dispatch("date_format", FormatMode::Date, args)
    }
            continue;
                if a.is_null(i) {
    fn coerce_types(&self, arg_types: &[DataType]) -> Result<Vec<DataType>> {
use datafusion::logical_expr::{
    ColumnarValue, ScalarFunctionArgs, ScalarUDF, ScalarUDFImpl, Signature, Volatility,
    }
use super::udf_identity;
                DataType::Timestamp(TimeUnit::Microsecond, None)
    }
    }
                "{udf}: expected Timestamp(Microsecond, None) after coercion, got {:?}",
            DataType::Utf8 | DataType::LargeUtf8 | DataType::Utf8View => {
pub fn register_all(ctx: &SessionContext) {
        };
    pub fn new() -> Self {
    let ts = v_arr
            datafusion::common::DataFusionError::Execution(format!(
        };
pub struct DateFormatUdf {
            DataType::Utf8 => {
 */
}
                } else {
    let mut builder = StringBuilder::with_capacity(n, 0);
    use super::*;
    }
use datafusion::common::{exec_err, plan_err, Result, ScalarValue};
 * SPDX-License-Identifier: Apache-2.0
        let fmt_str = match fmt {
    fn return_type(&self, arg_types: &[DataType]) -> Result<DataType> {
    fn signature(&self) -> &Signature {
}
            other => return exec_err!("{udf}: unsupported ts scalar: {other:?}"),
        if arg_types.len() != 2 {
        return Ok(ColumnarValue::Scalar(ScalarValue::Utf8(out)));
            }
        Ok(vec![ts, fmt])
        assert!(render_at(0, "", FormatMode::Date).is_some());
