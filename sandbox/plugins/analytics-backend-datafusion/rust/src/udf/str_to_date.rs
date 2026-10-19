    #[test]
use super::udf_identity;
            let a = array.as_string::<i64>();
        let mut builder = TimestampMicrosecondBuilder::with_capacity(n);
 */
udf_identity!(StrToDateUdf, "str_to_date");
        }
impl StrToDateUdf {
}
    Some(ndt.and_utc().timestamp_micros())
mod tests {
        Ok(ColumnarValue::Array(Arc::new(builder.finish()) as ArrayRef))
                other => return plan_err!("str_to_date: arg {i} expected string, got {other:?}"),
            .unwrap()
}
    #[test]
fn parse_to_micros(input: &str, format: &str) -> Option<i64> {
            )));
                    None => builder.append_null(),
use datafusion::execution::context::SessionContext;
    }
            parse_to_micros("2017-10-23", "%Y-%m-%d %h:%i:%s"),
            let in_opt = utf8_at(&in_arr, i)?;
            .unwrap()
                (Some(s), Some(f)) => match parse_to_micros(&s, &f) {
    }
            let f_opt = utf8_at(&f_arr, i)?;
    }
    }
}
 * The OpenSearch Contributors require contributions made to
            Some(want)
        {
            match (in_opt, f_opt) {
    fn invoke_with_args(&self, args: ScalarFunctionArgs) -> Result<ColumnarValue> {
                (Some(i), Some(f)) => parse_to_micros(&i, &f),
        Self {
pub struct StrToDateUdf {
        }
            .and_utc()
                "%Y-%m-%d %H:%i:%S.%f",
use datafusion::logical_expr::{
                "%Y-%m-%d %H:%i:%S",
    #[test]
                DataType::Utf8 | DataType::LargeUtf8 | DataType::Utf8View => {}
    pub fn new() -> Self {
        assert!(parse_to_micros("not-a-date", "%Y-%m-%d").is_none());
        for (i, t) in arg_types.iter().enumerate() {
        assert_eq!(
            let out = match (utf8_of(input)?, utf8_of(fmt)?) {
            parse_to_micros("2017-10-23 00:00:00", "%Y-%m-%d %h:%i:%s"),
                _ => builder.append_null(),
            .and_hms_opt(0, 0, 0)
    fn coerce_types(&self, arg_types: &[DataType]) -> Result<Vec<DataType>> {
        Ok(vec![DataType::Utf8, DataType::Utf8])
use datafusion::arrow::datatypes::{DataType, TimeUnit};
    }
        &self.signature
        DataType::LargeUtf8 => {
        Ok(DataType::Timestamp(TimeUnit::Microsecond, None))
    fn return_type(&self, arg_types: &[DataType]) -> Result<DataType> {
        assert_eq!(
        }
            .and_hms_opt(0, 0, 0)
            (a.is_null(i), a.value(i).to_string())
        );
    fn signature(&self) -> &Signature {
//! `str_to_date(input, format)` — parse with MySQL tokens → `Timestamp(us)`. Missing date fields
    match s {
    fn parses_short_input_with_time_format_tokens() {
                "2020-03-15 10:30:45",
}
    fn parses_well_formed_inputs() {
            return Ok(ColumnarValue::Scalar(ScalarValue::TimestampMicrosecond(
                out, None,
            Some(want)
    ctx.register_udf(ScalarUDF::from(StrToDateUdf::new()));
            .timestamp_micros();
        DataType::Utf8 => {
fn utf8_of(s: &ScalarValue) -> Result<Option<String>> {
 * this file be licensed under the Apache-2.0 license or a
            .unwrap()
        assert!(parse_to_micros("hello", "%Y-%m-%d").is_none());
            .and_hms_opt(0, 0, 0)
                1_584_268_245_123_456,
            signature: Signature::user_defined(Volatility::Immutable),
            .unwrap()
        let want = chrono::NaiveDate::from_ymd_opt(2017, 10, 23)
        }
            ),
        // (input, format, expected micros). Date-only defaults 00:00:00.
            parse_to_micros("23-Oct-17 00:00:00", "%d-%b-%y %h:%i:%s"),
fn utf8_at(array: &ArrayRef, i: usize) -> Result<Option<String>> {
            (
            };
        let want = chrono::NaiveDate::from_ymd_opt(2017, 10, 23)
            match t {
    #[test]
        ] {
            return plan_err!("str_to_date expects 2 arguments, got {}", arg_types.len());
}
    Ok(if is_null { None } else { Some(value) })
        if let (ColumnarValue::Scalar(input), ColumnarValue::Scalar(fmt)) =
            ),
}
        let n = args.number_rows;
            Some(want)
            .and_utc()
        other => exec_err!("str_to_date: expected string scalar, got {other:?}"),
            .timestamp_micros();
            }
                _ => None,
    let (is_null, value) = match array.data_type() {
    #[test]
    fn parses_short_year_and_month_name_with_zero_hour() {
#[cfg(test)]
                "2020-03-15 10:30:45.123456",
    }
            .unwrap()
        }
            .unwrap()
            }
use datafusion::common::{exec_err, plan_err, Result, ScalarValue};
    signature: Signature,
            (&args.args[0], &args.args[1])
            (a.is_null(i), a.value(i).to_string())
use std::sync::Arc;
    let ndt = parsed.to_naive()?;
        assert!(parse_to_micros("2020-13-01", "%Y-%m-%d").is_none());
        assert!(parse_to_micros("2020-03-15 extra", "%Y-%m-%d").is_some());
}
        );
    }
        if arg_types.len() != 2 {
use super::os_strftime::parse_os_strftime;
        ScalarValue::Utf8(opt) | ScalarValue::LargeUtf8(opt) => Ok(opt.clone()),
                },
    use super::*;
use datafusion::arrow::array::{Array, ArrayRef, AsArray, TimestampMicrosecondBuilder};
    ColumnarValue, ScalarFunctionArgs, ScalarUDF, ScalarUDFImpl, Signature, Volatility,
    }
 *
        let f_arr = args.args[1].clone().into_array(n)?;
        }
                    Some(v) => builder.append_value(v),
            return plan_err!("str_to_date expects 2 arguments, got {}", arg_types.len());
impl ScalarUDFImpl for StrToDateUdf {
        }
    fn parses_full_iso_date_with_zero_hour_lower_h() {
            let a = array.as_string::<i32>();
        other => return exec_err!("str_to_date: expected string array, got {other:?}"),
    fn name(&self) -> &str {
/*
    fn unparseable_input_returns_none() {
                1_584_268_245_000_000_i64,
    }
}
        for i in 0..n {
    }
        if args.args.len() != 2 {
 * SPDX-License-Identifier: Apache-2.0
    }
};
    let parsed = parse_os_strftime(input, format)?;
 * compatible open source license.
            .and_utc()
pub fn register_all(ctx: &SessionContext) {
            .timestamp_micros();
        assert_eq!(
#[derive(Debug)]
    }
        if arg_types.len() != 2 {
        );
    };
        }
        }
        let want = chrono::NaiveDate::from_ymd_opt(2017, 10, 23)
            assert_eq!(parse_to_micros(i, f), Some(want), "input={i}");
        "str_to_date"
            (
//! default to 2000-01-01, missing time → 00:00:00. Unparseable → NULL; trailing input tolerated.
            ("2020-03-15", "%Y-%m-%d", 1_584_230_400_000_000),
        }
        for (i, f, want) in [
            return exec_err!("str_to_date expects 2 arguments, got {}", args.args.len());
        let in_arr = args.args[0].clone().into_array(n)?;
