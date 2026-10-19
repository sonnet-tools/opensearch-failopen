        if arg_types.len() != 2 {
    let bytes = format.as_bytes();
                                Ok(Some(f)) => render_from_seconds(values.value(i), Some(&f)),
    }
        ] {
            12
        Weekday::Tue => 6,
        Weekday::Thu => "Thursday",
        let args = ScalarFunctionArgs {
            return Ok(ColumnarValue::Scalar(ScalarValue::Utf8(rendered)));
    let mut out = String::with_capacity(format.len() + 16);
            return plan_err!("strftime expects 2 arguments, got {}", arg_types.len());
        assert_eq!(
        Weekday::Thu => 4,
            dt.minute(),
            h
        );
    fn integer_seconds_ymd_hms() {
        {
    fn out_of_range_and_non_finite_yield_null() {
            let mut colons = 1;
        b'I' => out.push_str(&format!("{:02}", h12)),
/// first Sunday of the year (matches `WeekFields.SUNDAY_START.weekOfYear() - 1`).
    let mut i = 0;
        assert!(call_f64(5e10, "%Y-%m-%d").is_none());
    }
            dt.hour(),
            Some(1521467703.0),
                "{t:?}"
            ],
        Weekday::Wed => 3,
        for t in [
            append_subsecond(&mut out, dt, bytes[i + 2], precision);
    match kind {
        assert_eq!(call_f64(-946_771_200.0, "%Y-%m-%d").unwrap(), "1940-01-01");
    #[test]
    };
    }
        if append_simple_directive(&mut out, dt, directive) {
            month_short(dt.month()),
        Weekday::Fri => 5,
            config_options: Arc::new(Default::default()),
udf_identity!(StrftimeUdf, "strftime");
            };
        return None;
                    .map(|i| {
    #[test]
            call_f64(-1.0, "%Y-%m-%d %H:%M:%S").unwrap(),
            6 => out.push_str(&format!("{:06}", nanos / 1_000)),
        }
            "1969-12-31 23:59:59"
    };
                colons += 1;
        Weekday::Tue => "Tue",
            ],
                ColumnarValue::Scalar(ScalarValue::Float64(Some(0.0))),
use datafusion::common::{exec_err, plan_err, Result, ScalarValue};
            return_field: Arc::new(Field::new(u.name(), DataType::Utf8, true)),
        assert_eq!(call_f64(-31_536_000.0, "%Y-%m-%d").unwrap(), "1969-01-01");
        let value_array = args.args[0].clone().into_array(n)?;
        // Non-numeric / non-temporal rejected.
    #[test]
        Weekday::Fri => 3,
        b'Y' => out.push_str(&format!("{:04}", dt.year())),
    ]
    }
    // `Instant.ofEpochSecond(s, n)` normalizes negative n; chrono requires
    }
}
        assert_eq!(s.value(2), "1969-12-31");
            i += 2;
    [
//! `strftime(value, format)` — POSIX-style datetime formatter mirroring PPL `StrftimeFunction`.
            dt.hour(),
 * The OpenSearch Contributors require contributions made to
            i += 2;
        b'g' => out.push_str(&format!("{:02}", dt.iso_week().year() % 100)),
            ],
}
    signature: Signature,
        // 5e10 is above MAX_UNIX_SECONDS (3.25e10) but below the 1e11 ms threshold.
    fn tz_directives_render_utc() {
    let dt = Utc.timestamp_opt(adj_seconds, adj_nanos).single()?;
        Weekday::Wed => 5,
            other => return plan_err!("strftime: arg 1 expected string, got {other:?}"),
        assert_eq!(call_f64(1521467703.0, "%:z").unwrap(), "+00:00");
            (&args.args[0], &args.args[1])
        if bytes[i + 1] == b'N' || bytes[i + 1] == b'Q' {
        )),
        b'U' => out.push_str(&format!("{:02}", week_of_year_sunday_start(dt))),
        let format_array = args.args[1].clone().into_array(n)?;
        utf8_scalar(invoke(args, &[DataType::Float64, DataType::Utf8], 1).unwrap())
fn month_short(m: u32) -> &'static str {
    let nanos = dt.nanosecond();
    let dt = Utc
fn append_simple_directive(out: &mut String, dt: DateTime<Utc>, directive: u8) -> bool {
            "{:02}/{:02}/{:04}",
            assert_eq!(
        assert_eq!(call_f64(1521467703.123456, "%Q").unwrap(), "123");
        Ok(ColumnarValue::Array(Arc::new(out) as ArrayRef))
            weekday_short(dt.weekday()),
    // non-negative nanos paired with an adjusted seconds value.
    Some(format_with_directives(dt, format))
    }
        }
            call_f64(1521467703.123456, "%Y-%m-%d %H:%M:%S.%3Q").unwrap(),
    while i < bytes.len() {
            DataType::Timestamp(TimeUnit::Microsecond, _) => {
        if i + 1 >= bytes.len() {
    } else {
                    value_array.as_primitive::<datafusion::arrow::datatypes::Float64Type>();
        .expect("valid jan 1")
        );
        // Lookahead: at least one char after `%`.
/// (divided by 1000), matching the SQL plugin's behavior.
            "13:55:03"
        b'N' => {
            }
        assert_eq!(call_f64(1521467703.0, "%w").unwrap(), "1");
    // Numeric inputs with `abs(v) >= 1e11` are auto-detected as milliseconds,
        );
        )),
        _ => out.push_str("+00:00"),
        "September",
    .get(m as usize)
// Directive engine — mirrors `StrftimeFormatterUtil`'s handler table. Unknown
        // Unknown directive passes through verbatim (matches SQL plugin).
                    .as_any()
        }
        Weekday::Sat => 6,
                }
        assert_eq!(call_f64(1521417600.0, "%I").unwrap(), "12"); // midnight
        assert_eq!(call_f64(1521467703.0, "%I").unwrap(), "01");
        b'B' => out.push_str(month_full(dt.month())),
            );
            && (bytes[i + 2] == b'N' || bytes[i + 2] == b'Q')
                u.coerce_types(&[t.clone(), DataType::Utf8]).unwrap()[0],
        let args = vec![
use datafusion::arrow::array::{Array, ArrayRef, AsArray, StringArray, TimestampMicrosecondArray};
            )
            let precision = if kind == b'N' { 9 } else { 3 };
            }
    if doy < days_to_first_sunday {
            arg_fields: vec![
        {
    }
                ],
    let (adj_seconds, adj_nanos) = if nanos < 0 {
            ],
            .coerce_types(&[DataType::Boolean, DataType::Utf8])
            continue;
}
    out.push_str("+0");
            let out = invoke(args, &[DataType::Float64, DataType::Utf8], 1).unwrap();
            t if t.is_numeric() => DataType::Float64,
    fn call_ts_us(us: i64, f: &str) -> Option<String> {
            append_subsecond(&mut out, dt, kind, precision);
                    )
        b'T' | b'X' => out.push_str(&format!(
            .iter()
        assert_eq!(call_f64(1521467703.0, "%A").unwrap(), "Monday");
    }
        Weekday::Tue => 2,
                let values =
    fn udf() -> StrftimeUdf {
        "",
        assert!(call_f64(f64::NAN, "%Y-%m-%d").is_none());
        assert_eq!(
            dt.year()
    match colons {
        .map_err(|e| datafusion::common::DataFusionError::Execution(format!("strftime: {e}")))?;
}
        b'k' => out.push_str(&format!("{:2}", dt.hour())),
fn weekday_numeric_sunday_zero(w: Weekday) -> u32 {
        ]));
    [
                canonical,
        b'z' => out.push_str("+0000"),
        assert_eq!(call_f64(1521467703.0, "%j").unwrap(), "078");
            dt.minute(),
            arg_fields,
    if !value.is_finite() {
        b'f' => out.push_str(&format!("{:06}", dt.nanosecond() / 1000)),
        utf8_scalar(
        for t in [
            "{} {} {:02} {:02}:{:02}:{:02} {:04}",
            }
                        } else {
                "{t:?}"
        b'+' => out.push_str(&format!(
            // Default precision per StrftimeFormatterUtil: %N=9 nanos, %Q=3 millis.
            dt.day()
            }
        if bytes[i] != b'%' {
use datafusion::logical_expr::{
    use datafusion::arrow::datatypes::Field;
        Weekday::Mon => 7,
                    .collect()
        assert!(err.to_string().contains("expected numeric/timestamp"));
    fn call_f64(v: f64, f: &str) -> Option<String> {
                args,
    true
fn render_from_micros(value: i64, format: Option<&str>) -> Option<String> {
    let format = format?;
                DataType::Float64,
        "", "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec",
            let truncated = (scaled * 10f64.powi(precision as i32)) as u64;
    }
            args: vec![
    fn utf8_scalar(v: ColumnarValue) -> Option<String> {
        assert_eq!(call_f64(1521467703.0, "%V").unwrap(), "12");
    }
        Weekday::Sun => "Sun",
        );
        Weekday::Fri => "Fri",
        if arg_types.len() != 2 {
            assert!(utf8_scalar(out).is_none());
    out
}
    }
            let format = scalar_utf8(fmt)?;
        let out: StringArray = match value_array.data_type() {
            ColumnarValue::Scalar(ScalarValue::Utf8(Some(f.to_string()))),
        (doy - days_to_first_sunday) / 7 + 1
    fn name(&self) -> &str {
    let micros_remainder = value.rem_euclid(1_000_000) as u32;
            config_options: Arc::new(Default::default()),
        _ => {}
impl ScalarUDFImpl for StrftimeUdf {
    match w {
        if let (ColumnarValue::Scalar(val), ColumnarValue::Scalar(fmt)) =
    } else {
        "October",
    }
    .copied()
        assert_eq!(call_f64(1521467703.0, "%Y-%q").unwrap(), "2018-%q");
                }
}
                        }
    ColumnarValue, ScalarFunctionArgs, ScalarUDF, ScalarUDFImpl, Signature, Volatility,
 * SPDX-License-Identifier: Apache-2.0
                return exec_err!(
        let err = u
        2 => out.push_str("+00:00:00"),
                Arc::new(Field::new("f", DataType::Utf8, true)),
            );
fn week_of_year_sunday_start(dt: DateTime<Utc>) -> u32 {
                )
                    DataType::Timestamp(TimeUnit::Microsecond, None),
    let nanos = (fraction * 1_000_000_000.0) as i32;
fn weekday_full(w: Weekday) -> &'static str {
        b'y' => out.push_str(&format!("{:02}", dt.year() % 100)),
            .unwrap(),
                (0..n)
            "{:02}:{:02}:{:02}",
        )
            ColumnarValue::Scalar(ScalarValue::Utf8(opt)) => opt,
                        } else {
                    .map(|i| {
            i += 3;
        Weekday::Mon => "Mon",
        b'V' => out.push_str(&format!("{:02}", dt.iso_week().week())),
        let directive = bytes[i + 1];
            DataType::Int32,
                            None
}
                        }
    Some(format_with_directives(dt, format))
/// SQL plugin's `StrftimeFunction.MAX_UNIX_TIMESTAMP` — values beyond this yield null.
    fn complex_format_matches_it() {
            }
        Weekday::Sat => 2,
        let format = match &arg_types[1] {
        Weekday::Sat => "Sat",
            "{:04}-{:02}-{:02}",
            None,
    fn return_type(&self, arg_types: &[DataType]) -> Result<DataType> {
    #[test]
        Weekday::Sun => 1,
        };
            dt.day(),
use datafusion::arrow::datatypes::{DataType, TimeUnit};
            }
                        if values.is_null(i) {
}
                append_tz_colon(&mut out, colons);
            ColumnarValue::Scalar(ScalarValue::TimestampMicrosecond(Some(us), None)),
        "February",
                            match format_at(&format_array, i) {
    let format = format?;
            DataType::Timestamp(TimeUnit::Millisecond, None),
    use datafusion::arrow::array::{Float64Array, Int64Array};
 *
    }
    match w {
    }
                    })
        )),
        let s = a.as_string::<i32>();
            out.push(directive as char);
        // Int64 shape sanity — exercised by the array test above.
        let arr: ArrayRef = Arc::new(Float64Array::from(vec![
#[cfg(test)]
        value
        let u = udf();
    let doy = dt.ordinal();
        b'G' => out.push_str(&format!("{:04}", dt.iso_week().year())),
        assert_eq!(call_f64(1521467703.123456, "%N").unwrap(), "123456001");
}
            continue;
        b'd' => out.push_str(&format!("{:02}", dt.day())),
fn scalar_utf8(s: &ScalarValue) -> Result<Option<String>> {
        };
        } else {
        );
        b's' => out.push_str(&dt.timestamp().to_string()),
        for args in [
    match w {
        if bytes[i + 1].is_ascii_digit()
            DataType::Timestamp(_, _) | DataType::Date32 | DataType::Date64 => {
const MILLIS_HEURISTIC_THRESHOLD: f64 = 1e11;
        assert_eq!(
            other => panic!("expected Utf8 scalar, got {other:?}"),
}
            append_tz_offset_minutes(&mut out, dt);
        }
                            None
        b'Q' => match precision {
        let ColumnarValue::Array(a) = out else {
pub struct StrftimeUdf {
fn append_tz_colon(out: &mut String, colons: usize) {
        }
            return plan_err!("strftime expects 2 arguments, got {}", arg_types.len());
}
        if bytes[i + 1] == b':' {
                ScalarValue::TimestampMicrosecond(v, _) => {
        assert_eq!(s.value(0), "2018-03-19");
}
        // %<digit>N / %<digit>Q with optional precision
        (seconds, nanos as u32)
            if i + 1 + colons < bytes.len() && bytes[i + 1 + colons] == b'z' {
            continue;
        assert!(s.is_null(1));
            out.push('%');
            DataType::Float32,
        assert_eq!(call_f64(1521467703.0, "%z").unwrap(), "+0000");
        // `abs(v) >= 1e11` auto-treats input as ms; below stays in seconds.
                            match format_at(&format_array, i) {
            let scaled = nanos as f64 / 1_000_000_000.0;
        }
            other => {
    }
        Weekday::Mon => 1,
    }
                Arc::new(Field::new("v", DataType::Float64, true)),
    #[test]
        // 1521467703.123456 isn't exactly f64-representable (≈ ...01), so %N shows trailing 001.
        b'p' => out.push_str(if dt.hour() < 12 { "AM" } else { "PM" }),
                            }
    if !(-MAX_UNIX_SECONDS..=MAX_UNIX_SECONDS).contains(&seconds) {
pub fn register_all(ctx: &SessionContext) {
                    "strftime: arg 0 expected numeric/timestamp/date/string, got {other:?}"
            call_ts_us(1_521_467_703_000_000, "%F").unwrap(),
            out.push(bytes[i] as char);
/// Numeric inputs with `abs(v) >= 1e11` are auto-detected as milliseconds
    let seconds = seconds_value.trunc() as i64;
        // Temporal types fold onto Timestamp(us).
        Weekday::Sun => "Sunday",
            9 => out.push_str(&format!("{:09}", nanos)),
            call_ts_us(1_521_467_703_000_000, "%H:%M:%S").unwrap(),
        other => exec_err!("strftime: format must be VARCHAR, got {other:?}"),
/*
                &[
        }
        b'x' => out.push_str(&format!(
    #[test]
            continue;
        Weekday::Wed => "Wednesday",
                        "strftime: unsupported scalar value type after coercion: {other:?}"
            dt.year(),
            .enumerate()
    };
            t @ (DataType::Utf8 | DataType::LargeUtf8 | DataType::Utf8View) => t.clone(),
        b'H' => out.push_str(&format!("{:02}", dt.hour())),
            break;
        let u = udf();
    #[test]
        let canonical = DataType::Timestamp(TimeUnit::Microsecond, None);
        ] {
            out.push('%');
            .unwrap_err();
        "July",
        0
                ColumnarValue::Scalar(ScalarValue::Utf8(Some("%Y-%m-%d".into()))),
    match s {
            dt.year()
    fn coerce_types_folds_inputs() {
        Weekday::Sun => 0,
    let view = super::json_common::StringArrayView::from_array(array)
        match v {
}
    }
use chrono::{DateTime, Datelike, NaiveDate, TimeZone, Timelike, Utc, Weekday};
            assert_eq!(
                DataType::Timestamp(TimeUnit::Microsecond, None)
            signature: Signature::user_defined(Volatility::Immutable),
        }
        "January",
        b'a' => out.push_str(weekday_short(dt.weekday())),
        )),
        );
            DataType::Float64 => {
            DataType::Timestamp(TimeUnit::Nanosecond, Some("UTC".into())),
        b'%' => out.push('%'),
            dt.day(),
        assert_eq!(call_f64(1521467703.0, "%a").unwrap(), "Mon");
            return exec_err!("strftime expects 2 arguments, got {}", args.args.len());
        value / 1000.0
        // %:z / %::z / %:::z
            let rendered = match val {
        (seconds - 1, (nanos + 1_000_000_000) as u32)
                            }
    use super::*;
        b'S' => out.push_str(&format!("{:02}", dt.second())),
                (0..n)
                ScalarValue::Float64(v) => {
                    "strftime: unsupported value array type after coercion: {other:?}"
        }
                    v.and_then(|v| render_from_seconds(v, format.as_deref()))
        }
            DataType::Int64,
    fn week_ordinal_and_literal() {
            vec![
            call_f64(1521467703.0, "%Y-%m-%d %H:%M:%S").unwrap(),
}
}
fn weekday_short(w: Weekday) -> &'static str {
    }
            dt.year()
    }
        } else {
            while i + 1 + colons < bytes.len() && bytes[i + 1 + colons] == b':' {
        b'A' => out.push_str(weekday_full(dt.weekday())),
    fn fractional_seconds_with_3q_milliseconds() {
        Self {
        3 => out.push_str("+0"),
}
        ] {
        ScalarValue::Utf8(opt) | ScalarValue::LargeUtf8(opt) | ScalarValue::Utf8View(opt) => {
            weekday_short(dt.weekday()),
        b'F' => out.push_str(&format!(
        assert_eq!(
            dt.second(),
        return None;
        }
                ColumnarValue::Array(arr),
    let fraction = seconds_value - seconds as f64;
        if bytes[i + 1] == b'E' && i + 2 < bytes.len() && bytes[i + 2] == b'z' {
            let kind = bytes[i + 1];
                ColumnarValue::Scalar(ScalarValue::Float64(None)),
    fn array_f64_with_scalar_format() {
 */
    .unwrap_or("")
        let arg_fields = arg_types
                continue;
            .collect();
            .map(|(i, t)| Arc::new(Field::new(format!("a{i}"), t.clone(), true)))
    }
    fn subsecond_default_precision() {
        // 2018-03-19 = Monday
            month_short(dt.month()),
use datafusion::execution::context::SessionContext;
        Weekday::Wed => "Wed",
        b'C' => out.push_str(&format!("{:02}", dt.year() / 100)),
        ];
        assert_eq!(call_f64(1_521_467_703.0, "%Y-%m-%d").unwrap(), "2018-03-19");
        assert_eq!(
        }
    fn weekday_directives() {
        let out = u.invoke_with_args(args).unwrap();
                    .downcast_ref::<TimestampMicrosecondArray>()
        let args = vec![
                i += 2 + colons;
fn format_at(array: &ArrayRef, row: usize) -> Result<Option<String>> {
    let days_to_first_sunday = match jan1 {
        Ok(vec![value, format])
            DataType::Date64,
                ColumnarValue::Scalar(ScalarValue::Utf8(Some("%Y".into()))),
            DataType::Utf8,
    }
fn append_subsecond(out: &mut String, dt: DateTime<Utc>, kind: u8, precision: usize) {
    }
        "December",
                                _ => None,
        assert_eq!(
}
    }
        }
            vec![
    } else {
 * compatible open source license.
    #[test]
fn format_with_directives(dt: DateTime<Utc>, format: &str) -> String {
fn render_from_seconds(value: f64, format: Option<&str>) -> Option<String> {
use std::sync::Arc;
    let h12 = {
        StrftimeUdf::new()
        assert_eq!(call_f64(1521467703.0, "%Ez").unwrap(), "+0");
    }
                u.coerce_types(&[t.clone(), DataType::Utf8]).unwrap()[0],
            "2018-03-19 13:55:03"
        let h = dt.hour() % 12;
        }
    }
        b'e' => out.push_str(&format!("{:2}", dt.day())),
    // matching the SQL plugin's `StrftimeFormatterUtil` threshold.
            call_f64(1521467703.0, "%a, %b %d, %Y %I:%M:%S %p %Z").unwrap(),
        }
            _ => out.push_str(&format!("{:03}", nanos / 1_000_000)),
    #[test]
        };
};
fn month_full(m: u32) -> &'static str {
                                _ => None,
        );
                let values = value_array
mod tests {
            dt.day(),
    #[test]
        "strftime"
            call_f64(1_521_467_703_000.0, "%Y-%m-%d %H:%M:%S").unwrap(),
            Some(-86400.0),
use super::udf_identity;
            dt.month(),
    #[test]
        }
        b'm' => out.push_str(&format!("{:02}", dt.month())),
        "June",
    }
        return None;
            panic!("expected array");
            out.push_str(&format!("{:0>width$}", truncated, width = precision));
            dt.minute(),
        assert_eq!(
            && i + 2 < bytes.len()
    #[test]
                    v.and_then(|v| render_from_micros(v, format.as_deref()))
            return_field: Arc::new(Field::new(u.name(), DataType::Utf8, true)),
            dt.second()
        Weekday::Mon => "Monday",
            other => {
        "April",
    .unwrap_or("")
}
            i += 1;
                    return exec_err!(
            out.push('%');
            DataType::Utf8 | DataType::LargeUtf8 | DataType::Utf8View => DataType::Float64,
    fn signature(&self) -> &Signature {
    }
            number_rows: n,
        .weekday();
    if !(-MAX_UNIX_SECONDS..=MAX_UNIX_SECONDS).contains(&seconds) {
    .copied()
    }
        }
    };
        }
        b'M' => out.push_str(&format!("{:02}", dt.minute())),
    }
        Ok(DataType::Utf8)
                        if values.is_null(i) {
            "Mon, Mar 19, 2018 01:55:03 PM UTC"
    pub fn new() -> Self {
    fn null_operand_yields_null() {
        Weekday::Fri => "Friday",
    fn invoke(args: Vec<ColumnarValue>, arg_types: &[DataType], n: usize) -> Result<ColumnarValue> {
        };
        &self.signature
        "November",
            ColumnarValue::Scalar(ScalarValue::Utf8(Some(f.to_string()))),
            i += 3;
    }
            number_rows: 3,
    #[test]
        1 => out.push_str("+00:00"),
        "August",
        }
        if h == 0 {
        b'j' => out.push_str(&format!("{:03}", dt.ordinal())),
        u.invoke_with_args(ScalarFunctionArgs {
                1,
}
        .timestamp_opt(seconds, micros_remainder * 1_000)
const MAX_UNIX_SECONDS: i64 = 32_536_771_199;
        assert_eq!(call_f64(1521467703.0, "100%%").unwrap(), "100%");
            "2018-03-19 13:55:03.123"
    }
        ];
        b'Z' => out.push_str("UTC"),
    fn coerce_types(&self, arg_types: &[DataType]) -> Result<Vec<DataType>> {
            "2018-03-19 13:55:03"
    let seconds = value.div_euclid(1_000_000);
            dt.hour(),
            "2018-03-19"
fn append_tz_offset_minutes(out: &mut String, _dt: DateTime<Utc>) {
            "{} {} {:02} {:02}:{:02}:{:02} UTC {:04}",
                    .expect("coerce_types canonicalizes to TimestampMicrosecond");
        })
            dt.second(),
                    DataType::Utf8,
                }
        // %Ez (extended tz offset in minutes)
        Weekday::Thu => 4,
    fn ms_autodetect_above_1e11() {
/// `%U` — week of year, Sunday-start; week 0 is the partial week before the
        let value = match &arg_types[0] {
        let _arr: ArrayRef = Arc::new(Int64Array::from(vec![Some(1521467703i64)]));
                    })
        assert_eq!(call_f64(-86400.0, "%Y-%m-%d").unwrap(), "1969-12-31");
        Weekday::Thu => "Thu",
    }
            invoke(
        _ => return false,
            DataType::Date32,
    }
            dt.month(),
        Weekday::Tue => "Tuesday",
            i += 2;
                )
            }
                return plan_err!(
        Weekday::Sat => "Saturday",
                ColumnarValue::Scalar(ScalarValue::Utf8(None)),
    ctx.register_udf(ScalarUDF::from(StrftimeUdf::new()));
            DataType::UInt8,
    let jan1 = NaiveDate::from_ymd_opt(dt.year(), 1, 1)
    fn twelve_hour_clock_and_ampm() {
    }
    #[test]
        if args.args.len() != 2 {
                    .collect()
        };
            ColumnarValue::Scalar(ScalarValue::Float64(Some(v))),
#[derive(Debug)]
        "March",
 * this file be licensed under the Apache-2.0 license or a
    .get(m as usize)
impl StrftimeUdf {
    fn negative_epoch_rendering() {
        .single()?;
    ]
            let precision = (bytes[i + 1] - b'0') as usize;
    let seconds_value = if value.abs() >= MILLIS_HEURISTIC_THRESHOLD {
    }
                                Ok(Some(f)) => render_from_micros(values.value(i), Some(&f)),
    #[test]
            Ok(opt.clone())
// directives fall through as literal text (matches the SQL plugin).
        "May",
        },
                other => {
        // Numeric + string fold onto Float64.
    fn invoke_with_args(&self, args: ScalarFunctionArgs) -> Result<ColumnarValue> {
            args,
        let n = args.number_rows;
        b'w' => out.push_str(&weekday_numeric_sunday_zero(dt.weekday()).to_string()),
    match directive {
    Ok(view.cell(row).map(|s| s.to_string()))
        b'c' => out.push_str(&format!(
        b'b' => out.push_str(month_short(dt.month())),
}
    fn timestamp_micros_renders_date_and_time() {
    }
        assert_eq!(call_f64(1521467703.0, "%p").unwrap(), "PM");
    }
    }
        let u = udf();
        )),
            continue;
            i += 1;
