        assert_eq!(
        assert_eq!(format_ctime("", &Some("%H".to_string())), None);
        if args.args.len() != 2 {
    let (whole, frac) = split_epoch_seconds(epoch_seconds);
        assert_eq!(mktime_default("01/01/2000 00:00:00"), Some(946_684_800.0));
        }
    NaiveDateTime::parse_from_str(trimmed, format_str)
    if format_str.is_empty() {
impl TimeConversionUdf {
        &self.signature
    let format_str = format.as_deref()?.trim();
        );
            None
        TimeConversionFn::Ctime,
    fn ctime_default(value: &str) -> Option<String> {
    match value {
        assert_eq!(parse_mktime("11/14/2023", &Some(String::new())), None);
        return None;
    }
    fn signature(&self) -> &Signature {
    }
                &Some("%Y-%m-%d %H:%M:%S".to_string())
                    .as_string::<i64>()
impl Eq for TimeConversionUdf {}
        let out = format_ctime("1700000000", &Some("%Y-%m-%d".to_string()));
        ColumnarValue::Scalar(ScalarValue::Utf8(opt))
    signature: Signature,
use datafusion::arrow::datatypes::DataType;
        );
        ColumnarValue::Scalar(other) => exec_err!("mktime: expected Utf8 value, got {other:?}"),
            ScalarValue::Float64(opt.as_ref().and_then(|s| parse_mktime(s, &format_scalar))),
    }
    }
    Some(format!("{}", dt.format(&chrono_fmt)))
    let trimmed = value.trim();
        );
                args.args.len()
impl Hash for TimeConversionUdf {
    fn name(self) -> &'static str {
        let format = &args.args[1];
    if trimmed.is_empty() {
        return None;
    fn mktime_matches() {
 *
    )));
    }
use chrono::{DateTime, NaiveDateTime, TimeZone, Utc};
        assert_eq!(back, Some(1_700_000_000.0));
            TimeConversionFn::Ctime => "ctime",
    fn ctime_respects_custom_format() {
    #[test]
            Some(1_066_507_633.0)
                    .map(|opt| opt.and_then(|s| parse_mktime(s, &format_scalar)))
                &Some("%d/%m/%Y %H:%M:%S".to_string())
    #[test]
    }
            TimeConversionFn::Ctime => invoke_ctime(value, format),
    #[test]
        assert_eq!(out, Some(3600.0));
        assert_eq!(mktime_default(""), None);
        assert_eq!(
        );
pub fn register_all(ctx: &SessionContext) {
        ColumnarValue::Array(arr) => {
        parse_mktime(value, &Some(DEFAULT_FORMAT.to_string()))
    }
    ctx.register_udf(ScalarUDF::from(TimeConversionUdf::new(
pub struct TimeConversionUdf {
        assert_eq!(
            TimeConversionFn::Ctime => DataType::Utf8,
#[derive(Debug)]
};
    #[test]
    }
    fn mktime_accepts_pre_parsed_number() {
//! * `mktime(value, format)` — formatted time string → UNIX epoch seconds as double. If the
    // Seconds + nanos
        Self {
    fn name(&self) -> &str {
impl ScalarUDFImpl for TimeConversionUdf {
fn invoke_ctime(value: &ColumnarValue, format: &ColumnarValue) -> Result<ColumnarValue> {
 * SPDX-License-Identifier: Apache-2.0
fn format_ctime(value: &str, format: &Option<String>) -> Option<String> {
        assert_eq!(ctime_default(""), None);
    }
    let chrono_fmt = format_str.to_string();
                "18/10/2003 20:07:13",
        assert_eq!(mktime_default("invalid"), None);
use datafusion::arrow::array::{Array, ArrayRef, AsArray, Float64Array, StringArray};
        assert_eq!(format_ctime("abc", &Some("%H".to_string())), None);
        let back = parse_mktime(&rendered, &Some("%Y-%m-%d %H:%M:%S".to_string()));
        assert_eq!(
            parse_mktime("2003-10-18 20:07:13", &Some("invalid format".to_string())),
use datafusion::common::{exec_err, Result, ScalarValue};
        assert_eq!(parse_mktime("11/14/2023", &None), None);
    }
use std::sync::Arc;
fn parse_mktime(value: &str, format: &Option<String>) -> Option<f64> {
                    return exec_err!("ctime: expected Utf8 array, got {other:?}");
    }
            TimeConversionFn::Mktime => DataType::Float64,
#[derive(Debug, Clone, Copy, PartialEq, Eq, Hash)]
    #[test]
    let whole = epoch.floor() as i64;
    }
    Signature::one_of(
    kind: TimeConversionFn,
    #[test]
        Volatility::Immutable,
            format_ctime("0", &Some("%Y".to_string())),
                    .iter()
                other => {
        ColumnarValue::Array(arr) => {
    fn ctime_rejects_empty_and_unparseable() {
    }
        );
    fn mktime_roundtrips_through_ctime() {
            Some("10/18/2003 20:07:13".to_string())
// ── ctime ──────────────────────────────────────────────────────────────────────────────────
                DataType::LargeUtf8 => arr
    match column {
    fn mktime_rejects_empty_format() {
        )),
}
enum TimeConversionFn {
            TypeSignature::Exact(vec![DataType::LargeUtf8, DataType::LargeUtf8]),
            format_ctime("1066507633", &Some("%d/%m/%Y".to_string())),
    }
    }
        match self {
        | ColumnarValue::Scalar(ScalarValue::LargeUtf8(opt)) => Ok(opt.clone()),
 * this file be licensed under the Apache-2.0 license or a
/// Signature shared across both functions: `(Utf8, Utf8)` or `(LargeUtf8, LargeUtf8)`
    fn eq(&self, other: &Self) -> bool {
//!   preserved as `nanos` adjustment
/// Split a fractional epoch value into `(whole seconds, fractional seconds)`
                "2003-10-18 20:07:13",
    fn ctime_rejects_unparseable_and_empty() {
}
    fn return_type(&self, _arg_types: &[DataType]) -> Result<DataType> {
        format_ctime(value, &Some(DEFAULT_FORMAT.to_string()))
}
    }
        ColumnarValue::Scalar(ScalarValue::Utf8(opt))
    fn ctime_rejects_empty_format() {
        assert_eq!(
    fn new(kind: TimeConversionFn) -> Self {
fn invoke_mktime(value: &ColumnarValue, format: &ColumnarValue) -> Result<ColumnarValue> {
//!   input already parses as a number it is forwarded unchanged
    use super::*;
    }
    let trimmed = value.trim();
 * The OpenSearch Contributors require contributions made to
        assert_eq!(
    }
    fn mktime_default_format_matches() {
        assert_eq!(format_ctime("0", &None), None);
            None
    fn mktime_default(value: &str) -> Option<f64> {
                other => {
                    .collect(),
    }
        );
/*
}
    (whole, frac)
        .map(|parsed| parsed.and_utc().timestamp() as f64)
}
                    .collect(),
    fn ctime_formats_epoch_with_default_format() {
    }
}
                DataType::LargeUtf8 => arr
        );
    }
    fn hash<H: Hasher>(&self, state: &mut H) {
    Volatility,
            parse_mktime("2023-11-14", &Some("%Y-%m-%d".to_string())),
    }
    fn invoke_with_args(&self, args: ScalarFunctionArgs) -> Result<ColumnarValue> {
    let format_str = format.as_deref()?.trim();
impl TimeConversionFn {
            parse_mktime("10/18/2003 20:07:13", &Some(String::new())),
    fn ctime_default_format_matches() {
    if trimmed.is_empty() {
                    .iter()
            parse_mktime(
//! * `ctime(value, format)` — UNIX epoch seconds → formatted time string. Fractional seconds are
        | ColumnarValue::Scalar(ScalarValue::LargeUtf8(opt)) => Ok(ColumnarValue::Scalar(
            );
            Some(946_684_800.0)
        );
        assert_eq!(
        ColumnarValue::Scalar(ScalarValue::Utf8(opt))
    const DEFAULT_FORMAT: &str = "%m/%d/%Y %H:%M:%S";
            let out: Float64Array = match arr.data_type() {
#[cfg(test)]
    match value {
                    return exec_err!("mktime: expected Utf8 array, got {other:?}");
        assert_eq!(format_ctime("0", &Some(String::new())), None);
        );
        }
                "01/01/2000 00:00:00",
            TimeConversionFn::Mktime => "mktime",
    )));
    #[test]
        assert_eq!(
    #[test]
        return None;
                DataType::Utf8 => arr
            return exec_err!(
    let epoch_seconds: f64 = trimmed.parse().ok()?;
                &Some("%d/%m/%Y %H:%M:%S".to_string())
                }
        assert_eq!(ctime_default("invalid"), None);
    }
            signature: signature(),
    }
    }
            TimeConversionFn::Mktime => invoke_mktime(value, format),
            Some("18/10/2003".to_string())
mod tests {
    }
}
        assert_eq!(ctime_default("0"), Some("01/01/1970 00:00:00".to_string()));
        assert_eq!(mktime_default("1066473433"), Some(1_066_473_433.0));
    let frac = epoch - (whole as f64);
    }
        vec![
use std::hash::{Hash, Hasher};
    let nanos = (frac * 1_000_000_000.0) as u32;
            None
}
        }
        // Non-numeric input with empty format → no way to parse → None.
        assert_eq!(out, Some("2023-11-14".to_string()));
            None
            ctime_default("1066507633"),
    if let Ok(n) = trimmed.parse::<f64>() {
fn extract_scalar_string(column: &ColumnarValue, ctx: &str) -> Result<Option<String>> {
        | ColumnarValue::Scalar(ScalarValue::LargeUtf8(opt)) => Ok(ColumnarValue::Scalar(
        let out = parse_mktime(
        );
    Ctime,
        ColumnarValue::Scalar(other) => exec_err!("{ctx}: expected Utf8 scalar, got {other:?}"),
                    .iter()
}
    fn ctime_custom_format_matches() {
    let dt: DateTime<Utc> = Utc.timestamp_opt(whole, nanos).single()?;
    #[test]
        assert_eq!(format_ctime("1066507633", &Some(String::new())), None);
    #[test]
        }
            ScalarValue::Utf8(opt.as_ref().and_then(|s| format_ctime(s, &format_scalar))),
    if format_str.is_empty() {
    fn mktime_parses_formatted_string() {
        return None;
            Ok(ColumnarValue::Array(Arc::new(out) as ArrayRef))
            parse_mktime("not a date", &Some("%Y-%m-%d".to_string())),
 */
}
            ),
                self.kind.name(),
fn signature() -> Signature {
    let format_scalar = extract_scalar_string(format, "mktime: format")?;
    }
        self.kind.hash(state);
            let out: StringArray = match arr.data_type() {
 * compatible open source license.
        );
            parse_mktime(
    #[test]
                    .collect(),
                    .map(|opt| opt.and_then(|s| parse_mktime(s, &format_scalar)))
        ],
        }
        }
        let out = format_ctime("1700000000", &Some("%m/%d/%Y %H:%M:%S".to_string()));
        assert_eq!(out, Some(1_700_000_000.0));
        assert_eq!(
        assert_eq!(
        .ok()
        }
            exec_err!("{ctx}: format must be a scalar literal, got an array")
            Some("2003-10-18 20:07:13".to_string())
            ),
            TypeSignature::Exact(vec![DataType::Utf8, DataType::Utf8]),
    }
    fn mktime_rejects_date_only_format() {
            &Some("%m/%d/%Y %H:%M:%S".to_string()),
        let value = &args.args[0];
        assert_eq!(mktime_default("not-a-date"), None);
    Mktime,
    fn mktime_rejects_unparseable() {
    ctx.register_udf(ScalarUDF::from(TimeConversionUdf::new(
                    .iter()
            Some("1970".to_string())
        }
use datafusion::logical_expr::{
        Ok(self.kind.return_type())
        )),
                "{} expects exactly 2 arguments, got {}",
        assert_eq!(mktime_default("10/18/2003 20:07:13"), Some(1_066_507_633.0));
}
                    .collect(),
        let rendered = format_ctime("1700000000", &Some("%Y-%m-%d %H:%M:%S".to_string())).unwrap();
                    .as_string::<i32>()
            Ok(ColumnarValue::Array(Arc::new(out) as ArrayRef))
}
    fn return_type(self) -> DataType {
    }
// ── helpers ────────────────────────────────────────────────────────────────────────────────
            parse_mktime(
            ),
}
        match self {
}
            format_ctime("1066507633", &Some("%Y-%m-%d %H:%M:%S".to_string())),
        self.kind == other.kind
use datafusion::execution::context::SessionContext;
        assert_eq!(out, Some("11/14/2023 22:13:20".to_string()));
            kind,
    #[test]
                    .map(|opt| opt.and_then(|s| format_ctime(s, &format_scalar)))
            Some(1_066_507_633.0)
    #[test]
        self.kind.name()
                DataType::Utf8 => arr
                    .as_string::<i64>()
    #[test]
        // 1_700_000_000 = 2023-11-14 22:13:20 UTC.
impl PartialEq for TimeConversionUdf {
    }
        ColumnarValue::Array(_) => {
    )
                }
        TimeConversionFn::Mktime,
        );
    ColumnarValue, ScalarFunctionArgs, ScalarUDF, ScalarUDFImpl, Signature, TypeSignature,
}
}
    #[test]
        return Some(n);
                    .as_string::<i32>()
    let format_scalar = extract_scalar_string(format, "ctime: format")?;
fn split_epoch_seconds(epoch: f64) -> (i64, f64) {
    }
        assert_eq!(
                    .map(|opt| opt.and_then(|s| format_ctime(s, &format_scalar)))
            "11/14/2023 22:13:20",
        assert_eq!(ctime_default("abc123"), None);
            };
    }
        ColumnarValue::Scalar(other) => exec_err!("ctime: expected Utf8 value, got {other:?}"),
// ── mktime ─────────────────────────────────────────────────────────────────────────────────
        let out = parse_mktime("3600", &Some("%H:%M:%S".to_string()));
        match self.kind {
    }
            };
