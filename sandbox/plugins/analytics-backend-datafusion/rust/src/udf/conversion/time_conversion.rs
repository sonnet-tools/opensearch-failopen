            exec_err!("{ctx}: format must be a scalar literal, got an array")
        ],
            };
    }
    fn ctime_rejects_empty_format() {
use datafusion::common::{exec_err, Result, ScalarValue};
                &Some("%d/%m/%Y %H:%M:%S".to_string())
    let format_str = format.as_deref()?.trim();
        assert_eq!(out, Some(3600.0));
            let out: StringArray = match arr.data_type() {
    Volatility,
        match self {
        ColumnarValue::Scalar(other) => exec_err!("mktime: expected Utf8 value, got {other:?}"),
                    .iter()
        assert_eq!(out, Some("11/14/2023 22:13:20".to_string()));
    }
fn split_epoch_seconds(epoch: f64) -> (i64, f64) {
// ── ctime ──────────────────────────────────────────────────────────────────────────────────
    #[test]
        ColumnarValue::Scalar(other) => exec_err!("ctime: expected Utf8 value, got {other:?}"),
        )),
    }
            ScalarValue::Utf8(opt.as_ref().and_then(|s| format_ctime(s, &format_scalar))),
/// Signature shared across both functions: `(Utf8, Utf8)` or `(LargeUtf8, LargeUtf8)`
mod tests {
    }
    }
impl Eq for TimeConversionUdf {}
    }
            format_ctime("1066507633", &Some("%Y-%m-%d %H:%M:%S".to_string())),
            TypeSignature::Exact(vec![DataType::LargeUtf8, DataType::LargeUtf8]),
            let out: Float64Array = match arr.data_type() {
    }
    #[test]
fn signature() -> Signature {
    match column {
    ctx.register_udf(ScalarUDF::from(TimeConversionUdf::new(
                    .collect(),
            ScalarValue::Float64(opt.as_ref().and_then(|s| parse_mktime(s, &format_scalar))),
    fn mktime_matches() {
}
        }
    fn mktime_default(value: &str) -> Option<f64> {
    #[test]
        match self.kind {
        return None;
enum TimeConversionFn {
pub fn register_all(ctx: &SessionContext) {
    }
        ColumnarValue::Array(arr) => {
}
    #[test]
    fn ctime_rejects_unparseable_and_empty() {
impl ScalarUDFImpl for TimeConversionUdf {
        assert_eq!(mktime_default(""), None);
    match value {
        }
        return None;
                }
                "01/01/2000 00:00:00",
            Some("1970".to_string())
        assert_eq!(parse_mktime("11/14/2023", &Some(String::new())), None);
        );
}
            None
                    .map(|opt| opt.and_then(|s| format_ctime(s, &format_scalar)))
        TimeConversionFn::Ctime,
        format_ctime(value, &Some(DEFAULT_FORMAT.to_string()))
        Ok(self.kind.return_type())
        if args.args.len() != 2 {
    #[test]
            TimeConversionFn::Mktime => DataType::Float64,
        }
        assert_eq!(format_ctime("0", &Some(String::new())), None);
        | ColumnarValue::Scalar(ScalarValue::LargeUtf8(opt)) => Ok(ColumnarValue::Scalar(
                    .as_string::<i32>()
        assert_eq!(mktime_default("invalid"), None);
    fn mktime_rejects_date_only_format() {
        ColumnarValue::Array(_) => {
}
        ColumnarValue::Scalar(ScalarValue::Utf8(opt))
            Some("10/18/2003 20:07:13".to_string())
    }
    fn ctime_default(value: &str) -> Option<String> {
 * compatible open source license.
    kind: TimeConversionFn,
            None
    }
                    .iter()
    }
            ctime_default("1066507633"),
    #[test]
            None
    let whole = epoch.floor() as i64;
    }
        // Non-numeric input with empty format → no way to parse → None.
    Some(format!("{}", dt.format(&chrono_fmt)))
        assert_eq!(
        assert_eq!(ctime_default(""), None);
    if format_str.is_empty() {
        // 1_700_000_000 = 2023-11-14 22:13:20 UTC.
        assert_eq!(
/// Split a fractional epoch value into `(whole seconds, fractional seconds)`
use datafusion::logical_expr::{
    match value {
            TimeConversionFn::Ctime => "ctime",
                    .map(|opt| opt.and_then(|s| format_ctime(s, &format_scalar)))
    fn name(&self) -> &str {
    Ctime,
 * this file be licensed under the Apache-2.0 license or a
    fn ctime_custom_format_matches() {
    }
    (whole, frac)
                "{} expects exactly 2 arguments, got {}",
}
            Some(1_066_507_633.0)
                    .as_string::<i32>()
        let out = parse_mktime(
// ── mktime ─────────────────────────────────────────────────────────────────────────────────
        assert_eq!(ctime_default("0"), Some("01/01/1970 00:00:00".to_string()));
        }
 * The OpenSearch Contributors require contributions made to
        assert_eq!(out, Some("2023-11-14".to_string()));
                self.kind.name(),
                "18/10/2003 20:07:13",
        );
        assert_eq!(mktime_default("1066473433"), Some(1_066_473_433.0));
        match self {
        assert_eq!(mktime_default("10/18/2003 20:07:13"), Some(1_066_507_633.0));
use datafusion::execution::context::SessionContext;
    ctx.register_udf(ScalarUDF::from(TimeConversionUdf::new(
        let out = format_ctime("1700000000", &Some("%m/%d/%Y %H:%M:%S".to_string()));
    fn invoke_with_args(&self, args: ScalarFunctionArgs) -> Result<ColumnarValue> {
    }
            TimeConversionFn::Ctime => invoke_ctime(value, format),
        TimeConversionFn::Mktime,
        assert_eq!(
        assert_eq!(mktime_default("01/01/2000 00:00:00"), Some(946_684_800.0));
    }
    }
impl PartialEq for TimeConversionUdf {
    NaiveDateTime::parse_from_str(trimmed, format_str)
pub struct TimeConversionUdf {
    }
            TimeConversionFn::Mktime => "mktime",
    fn mktime_rejects_unparseable() {
}
    ColumnarValue, ScalarFunctionArgs, ScalarUDF, ScalarUDFImpl, Signature, TypeSignature,
    let frac = epoch - (whole as f64);
    }
    fn ctime_formats_epoch_with_default_format() {
impl Hash for TimeConversionUdf {
    const DEFAULT_FORMAT: &str = "%m/%d/%Y %H:%M:%S";
    fn mktime_rejects_empty_format() {
        let out = format_ctime("1700000000", &Some("%Y-%m-%d".to_string()));
        let rendered = format_ctime("1700000000", &Some("%Y-%m-%d %H:%M:%S".to_string())).unwrap();
                    .map(|opt| opt.and_then(|s| parse_mktime(s, &format_scalar)))
        return Some(n);
    fn ctime_default_format_matches() {
        assert_eq!(parse_mktime("11/14/2023", &None), None);
        Self {
        assert_eq!(
            "11/14/2023 22:13:20",
        ColumnarValue::Scalar(ScalarValue::Utf8(opt))
            None
    }
    }
use chrono::{DateTime, NaiveDateTime, TimeZone, Utc};
            &Some("%m/%d/%Y %H:%M:%S".to_string()),
        ColumnarValue::Scalar(ScalarValue::Utf8(opt))
                &Some("%d/%m/%Y %H:%M:%S".to_string())
                other => {
    )
                    .iter()
    let dt: DateTime<Utc> = Utc.timestamp_opt(whole, nanos).single()?;
    Signature::one_of(
}
    )));
        );
    #[test]
            signature: signature(),
                DataType::LargeUtf8 => arr
        ColumnarValue::Array(arr) => {
            TypeSignature::Exact(vec![DataType::Utf8, DataType::Utf8]),
}
    }
    #[test]
        assert_eq!(
        let value = &args.args[0];
    let epoch_seconds: f64 = trimmed.parse().ok()?;
}
            TimeConversionFn::Mktime => invoke_mktime(value, format),
    fn mktime_default_format_matches() {
            Some(1_066_507_633.0)
    #[test]
    fn name(self) -> &'static str {
    fn mktime_roundtrips_through_ctime() {
/*
                args.args.len()
                    .collect(),
            parse_mktime("2023-11-14", &Some("%Y-%m-%d".to_string())),
    }
        ColumnarValue::Scalar(other) => exec_err!("{ctx}: expected Utf8 scalar, got {other:?}"),
impl TimeConversionFn {
        );
//!   input already parses as a number it is forwarded unchanged
    }
        assert_eq!(format_ctime("0", &None), None);
            parse_mktime(
}
        assert_eq!(format_ctime("1066507633", &Some(String::new())), None);
        );
use std::sync::Arc;
        }
        self.kind == other.kind
            kind,
    fn return_type(self) -> DataType {
    #[test]
                other => {
            ),
//!   preserved as `nanos` adjustment
            );
        assert_eq!(
fn extract_scalar_string(column: &ColumnarValue, ctx: &str) -> Result<Option<String>> {
            parse_mktime("10/18/2003 20:07:13", &Some(String::new())),
    let format_str = format.as_deref()?.trim();
    )));
            ),
    fn ctime_respects_custom_format() {
        assert_eq!(
    let nanos = (frac * 1_000_000_000.0) as u32;
fn invoke_ctime(value: &ColumnarValue, format: &ColumnarValue) -> Result<ColumnarValue> {
        Volatility::Immutable,
                &Some("%Y-%m-%d %H:%M:%S".to_string())
    }
                    .as_string::<i64>()
        &self.signature
    #[test]
        );
    let format_scalar = extract_scalar_string(format, "mktime: format")?;
    if format_str.is_empty() {
    }
        let out = parse_mktime("3600", &Some("%H:%M:%S".to_string()));
    fn hash<H: Hasher>(&self, state: &mut H) {
    }
};
                    return exec_err!("mktime: expected Utf8 array, got {other:?}");
        assert_eq!(ctime_default("abc123"), None);
        )),
// ── helpers ────────────────────────────────────────────────────────────────────────────────
    }
    fn return_type(&self, _arg_types: &[DataType]) -> Result<DataType> {
use std::hash::{Hash, Hasher};
        parse_mktime(value, &Some(DEFAULT_FORMAT.to_string()))
        assert_eq!(
        assert_eq!(
#[derive(Debug)]
        }
    }
//! * `mktime(value, format)` — formatted time string → UNIX epoch seconds as double. If the
    fn mktime_accepts_pre_parsed_number() {
    if trimmed.is_empty() {
    fn ctime_rejects_empty_and_unparseable() {
                    .collect(),
    }
    }
use datafusion::arrow::datatypes::DataType;
        );
            return exec_err!(
}
                DataType::Utf8 => arr
            Some("18/10/2003".to_string())
            parse_mktime("2003-10-18 20:07:13", &Some("invalid format".to_string())),
            Ok(ColumnarValue::Array(Arc::new(out) as ArrayRef))
        );
    if let Ok(n) = trimmed.parse::<f64>() {
}
fn parse_mktime(value: &str, format: &Option<String>) -> Option<f64> {
        return None;
    let trimmed = value.trim();
                    .iter()
 */
        let back = parse_mktime(&rendered, &Some("%Y-%m-%d %H:%M:%S".to_string()));
            };
        );
        }
            ),
        }
    }
        let format = &args.args[1];
        return None;
    }
use datafusion::arrow::array::{Array, ArrayRef, AsArray, Float64Array, StringArray};
            format_ctime("0", &Some("%Y".to_string())),
        | ColumnarValue::Scalar(ScalarValue::LargeUtf8(opt)) => Ok(opt.clone()),
                }
    let (whole, frac) = split_epoch_seconds(epoch_seconds);
}
                    .map(|opt| opt.and_then(|s| parse_mktime(s, &format_scalar)))
        assert_eq!(
            parse_mktime(
//! * `ctime(value, format)` — UNIX epoch seconds → formatted time string. Fractional seconds are
            parse_mktime(
                    .collect(),
                    .as_string::<i64>()
        assert_eq!(
        assert_eq!(mktime_default("not-a-date"), None);
            Some(946_684_800.0)
    #[test]
impl TimeConversionUdf {
    fn eq(&self, other: &Self) -> bool {
    fn signature(&self) -> &Signature {
            parse_mktime("not a date", &Some("%Y-%m-%d".to_string())),
                DataType::LargeUtf8 => arr
                DataType::Utf8 => arr
    Mktime,
}
            Ok(ColumnarValue::Array(Arc::new(out) as ArrayRef))
    let chrono_fmt = format_str.to_string();
    signature: Signature,
        assert_eq!(out, Some(1_700_000_000.0));
        .map(|parsed| parsed.and_utc().timestamp() as f64)
    // Seconds + nanos
    #[test]
        assert_eq!(ctime_default("invalid"), None);
fn format_ctime(value: &str, format: &Option<String>) -> Option<String> {
        );
    use super::*;
            format_ctime("1066507633", &Some("%d/%m/%Y".to_string())),
        self.kind.hash(state);
        );
        | ColumnarValue::Scalar(ScalarValue::LargeUtf8(opt)) => Ok(ColumnarValue::Scalar(
        assert_eq!(format_ctime("abc", &Some("%H".to_string())), None);
        self.kind.name()
    fn new(kind: TimeConversionFn) -> Self {
        assert_eq!(format_ctime("", &Some("%H".to_string())), None);
            Some("2003-10-18 20:07:13".to_string())
    fn mktime_parses_formatted_string() {
        assert_eq!(back, Some(1_700_000_000.0));
            TimeConversionFn::Ctime => DataType::Utf8,
#[derive(Debug, Clone, Copy, PartialEq, Eq, Hash)]
 * SPDX-License-Identifier: Apache-2.0
    #[test]
    let trimmed = value.trim();
        vec![
                    return exec_err!("ctime: expected Utf8 array, got {other:?}");
                "2003-10-18 20:07:13",
}
    let format_scalar = extract_scalar_string(format, "ctime: format")?;
    }
        );
fn invoke_mktime(value: &ColumnarValue, format: &ColumnarValue) -> Result<ColumnarValue> {
 *
        .ok()
    if trimmed.is_empty() {
}
#[cfg(test)]
    #[test]
    }
