        "May",
        Weekday::Wed => 5,
            }
                ColumnarValue::Scalar(ScalarValue::Utf8(None)),
        );
// Directive engine — mirrors `StrftimeFormatterUtil`'s handler table. Unknown
        &self.signature
        let u = udf();
        assert_eq!(
        "February",
        }
        if bytes[i + 1] == b':' {
use datafusion::common::{exec_err, plan_err, Result, ScalarValue};
            "13:55:03"
            let format = scalar_utf8(fmt)?;
    fn coerce_types_folds_inputs() {
    }
}
        assert_eq!(call_f64(1521467703.0, "%:z").unwrap(), "+00:00");
            "{} {} {:02} {:02}:{:02}:{:02} UTC {:04}",
        Weekday::Sun => "Sunday",
    };
                (0..n)
        },
        "September",
        return None;
 * SPDX-License-Identifier: Apache-2.0
        Weekday::Fri => 3,
        // Non-numeric / non-temporal rejected.
            other => return plan_err!("strftime: arg 1 expected string, got {other:?}"),
        Weekday::Mon => "Monday",
        );
    }
    }
fn format_at(array: &ArrayRef, row: usize) -> Result<Option<String>> {
            dt.year(),
                ColumnarValue::Scalar(ScalarValue::Utf8(Some("%Y-%m-%d".into()))),
        }
    }
                    DataType::Timestamp(TimeUnit::Microsecond, None),
        return None;
    fn utf8_scalar(v: ColumnarValue) -> Option<String> {
        b'V' => out.push_str(&format!("{:02}", dt.iso_week().week())),
fn format_with_directives(dt: DateTime<Utc>, format: &str) -> String {
                DataType::Timestamp(TimeUnit::Microsecond, None)
        b'a' => out.push_str(weekday_short(dt.weekday())),
            out.push_str(&format!("{:0>width$}", truncated, width = precision));
        b'Q' => match precision {
        .timestamp_opt(seconds, micros_remainder * 1_000)
    };
/// (divided by 1000), matching the SQL plugin's behavior.
        assert_eq!(
            i += 1;
        }
use datafusion::execution::context::SessionContext;
        let out = u.invoke_with_args(args).unwrap();
        );
        }
        if append_simple_directive(&mut out, dt, directive) {
        b'j' => out.push_str(&format!("{:03}", dt.ordinal())),
            out.push(bytes[i] as char);
        b'A' => out.push_str(weekday_full(dt.weekday())),
    }
            month_short(dt.month()),
    }
                (0..n)
            ColumnarValue::Scalar(ScalarValue::Utf8(opt)) => opt,
            (&args.args[0], &args.args[1])
};
pub struct StrftimeUdf {
    fn invoke(args: Vec<ColumnarValue>, arg_types: &[DataType], n: usize) -> Result<ColumnarValue> {
            weekday_short(dt.weekday()),
        b'M' => out.push_str(&format!("{:02}", dt.minute())),
                    )
                    v.and_then(|v| render_from_micros(v, format.as_deref()))
        _ => {}
use chrono::{DateTime, Datelike, NaiveDate, TimeZone, Timelike, Utc, Weekday};
            call_f64(1521467703.0, "%a, %b %d, %Y %I:%M:%S %p %Z").unwrap(),
    #[test]
            out.push('%');
    #[test]
        u.invoke_with_args(ScalarFunctionArgs {
            let truncated = (scaled * 10f64.powi(precision as i32)) as u64;
        assert_eq!(call_f64(1521467703.123456, "%Q").unwrap(), "123");
        assert_eq!(call_f64(1521417600.0, "%I").unwrap(), "12"); // midnight
        (seconds - 1, (nanos + 1_000_000_000) as u32)
                        } else {
    }
            dt.day(),
            dt.month(),
                )
        assert_eq!(call_f64(1521467703.0, "%V").unwrap(), "12");
    }
                DataType::Float64,
fn append_subsecond(out: &mut String, dt: DateTime<Utc>, kind: u8, precision: usize) {
                    "strftime: unsupported value array type after coercion: {other:?}"
        }
    let seconds = seconds_value.trunc() as i64;
    pub fn new() -> Self {
    match w {
        let arr: ArrayRef = Arc::new(Float64Array::from(vec![
                }
            dt.day()
    ]
    .copied()
fn week_of_year_sunday_start(dt: DateTime<Utc>) -> u32 {
                ColumnarValue::Scalar(ScalarValue::Utf8(Some("%Y".into()))),
    match w {
    // `Instant.ofEpochSecond(s, n)` normalizes negative n; chrono requires
        b'Y' => out.push_str(&format!("{:04}", dt.year())),
    .unwrap_or("")
        let value_array = args.args[0].clone().into_array(n)?;
        Weekday::Tue => "Tuesday",
            number_rows: 3,
                            }
use std::sync::Arc;
}
            t if t.is_numeric() => DataType::Float64,
        b'e' => out.push_str(&format!("{:2}", dt.day())),
            Some(-86400.0),
            }
        let s = a.as_string::<i32>();
        utf8_scalar(
            continue;
        utf8_scalar(invoke(args, &[DataType::Float64, DataType::Utf8], 1).unwrap())
        }
            dt.year()
    fn subsecond_default_precision() {
    fn array_f64_with_scalar_format() {
    fn invoke_with_args(&self, args: ScalarFunctionArgs) -> Result<ColumnarValue> {
            ],
            dt.hour(),
 * compatible open source license.
    fn ms_autodetect_above_1e11() {
        b'F' => out.push_str(&format!(
        Weekday::Sun => "Sun",
                        if values.is_null(i) {
    true
pub fn register_all(ctx: &SessionContext) {
            DataType::Timestamp(_, _) | DataType::Date32 | DataType::Date64 => {
    while i < bytes.len() {
    fn week_ordinal_and_literal() {
                            None
        "December",
                u.coerce_types(&[t.clone(), DataType::Utf8]).unwrap()[0],
    use datafusion::arrow::datatypes::Field;
            .collect();
        _ => out.push_str("+00:00"),
        // Lookahead: at least one char after `%`.
    let seconds_value = if value.abs() >= MILLIS_HEURISTIC_THRESHOLD {
        let h = dt.hour() % 12;
            Some(1521467703.0),
            vec![
    fn out_of_range_and_non_finite_yield_null() {
    }
fn render_from_micros(value: i64, format: Option<&str>) -> Option<String> {
}
    [
        assert_eq!(call_f64(1521467703.0, "%w").unwrap(), "1");
                Arc::new(Field::new("f", DataType::Utf8, true)),
            DataType::Float32,
        Weekday::Thu => "Thu",
    }
            DataType::UInt8,
        )),
const MILLIS_HEURISTIC_THRESHOLD: f64 = 1e11;
    match s {
            ColumnarValue::Scalar(ScalarValue::TimestampMicrosecond(Some(us), None)),
        Weekday::Fri => 5,
    Some(format_with_directives(dt, format))
        assert_eq!(
        let format = match &arg_types[1] {
        b'z' => out.push_str("+0000"),
        b's' => out.push_str(&dt.timestamp().to_string()),
    ]
    #[test]
        if args.args.len() != 2 {
        let ColumnarValue::Array(a) = out else {
    }
        let format_array = args.args[1].clone().into_array(n)?;
                    value_array.as_primitive::<datafusion::arrow::datatypes::Float64Type>();
        assert!(err.to_string().contains("expected numeric/timestamp"));
}
            other => {
                }
        } else {
        ];
    } else {
        );
        )
        "November",
        };
    fn tz_directives_render_utc() {
            "2018-03-19 13:55:03.123"
                ColumnarValue::Array(arr),
    #[test]
        for t in [
            let kind = bytes[i + 1];
            t @ (DataType::Utf8 | DataType::LargeUtf8 | DataType::Utf8View) => t.clone(),
        "October",
        if h == 0 {
            let precision = if kind == b'N' { 9 } else { 3 };
                }
    }
    .copied()
                        "strftime: unsupported scalar value type after coercion: {other:?}"
    match w {
            return plan_err!("strftime expects 2 arguments, got {}", arg_types.len());
            let scaled = nanos as f64 / 1_000_000_000.0;
        Weekday::Thu => "Thursday",
// directives fall through as literal text (matches the SQL plugin).
        "July",
    out.push_str("+0");
                    .map(|i| {
        }
        assert_eq!(
                ScalarValue::TimestampMicrosecond(v, _) => {
    }
    let format = format?;
    #[test]
            config_options: Arc::new(Default::default()),
        b'w' => out.push_str(&weekday_numeric_sunday_zero(dt.weekday()).to_string()),
                append_tz_colon(&mut out, colons);
        .single()?;
        Ok(vec![value, format])
}
            "{:02}/{:02}/{:04}",
            dt.second(),
        }
            i += 3;
        Weekday::Wed => 3,
            other => {
        assert_eq!(call_f64(-31_536_000.0, "%Y-%m-%d").unwrap(), "1969-01-01");
            .enumerate()
        assert_eq!(call_f64(-86400.0, "%Y-%m-%d").unwrap(), "1969-12-31");
    fn fractional_seconds_with_3q_milliseconds() {
        }
            number_rows: n,
        ] {
            .map(|(i, t)| Arc::new(Field::new(format!("a{i}"), t.clone(), true)))
            let precision = (bytes[i + 1] - b'0') as usize;
    fn udf() -> StrftimeUdf {
    if !value.is_finite() {
        b'I' => out.push_str(&format!("{:02}", h12)),
        if let (ColumnarValue::Scalar(val), ColumnarValue::Scalar(fmt)) =
    }
        }
        .expect("valid jan 1")
            continue;
mod tests {
    }
            }
        ScalarValue::Utf8(opt) | ScalarValue::LargeUtf8(opt) | ScalarValue::Utf8View(opt) => {
        }
    #[test]
    }
        // Unknown directive passes through verbatim (matches SQL plugin).
                ],
}
        assert_eq!(call_f64(1521467703.0, "%z").unwrap(), "+0000");
fn weekday_short(w: Weekday) -> &'static str {
                u.coerce_types(&[t.clone(), DataType::Utf8]).unwrap()[0],
            dt.day(),
}
        );
            )
                                _ => None,
}
fn append_tz_offset_minutes(out: &mut String, _dt: DateTime<Utc>) {
        assert_eq!(
                    .collect()
            };
            dt.second()
    // Numeric inputs with `abs(v) >= 1e11` are auto-detected as milliseconds,
        b'H' => out.push_str(&format!("{:02}", dt.hour())),
    }
 *
    };
fn month_short(m: u32) -> &'static str {
        // 5e10 is above MAX_UNIX_SECONDS (3.25e10) but below the 1e11 ms threshold.
        let args = vec![
}
            assert!(utf8_scalar(out).is_none());
    // non-negative nanos paired with an adjusted seconds value.
        Weekday::Thu => 4,
    }
        }
            ColumnarValue::Scalar(ScalarValue::Utf8(Some(f.to_string()))),
        (seconds, nanos as u32)
        Weekday::Sat => 6,
            dt.second(),
        Weekday::Tue => "Tue",
    #[test]
            panic!("expected array");
            9 => out.push_str(&format!("{:09}", nanos)),
    if !(-MAX_UNIX_SECONDS..=MAX_UNIX_SECONDS).contains(&seconds) {
        b'g' => out.push_str(&format!("{:02}", dt.iso_week().year() % 100)),
fn append_simple_directive(out: &mut String, dt: DateTime<Utc>, directive: u8) -> bool {
            vec![
            "2018-03-19 13:55:03"
        assert_eq!(s.value(0), "2018-03-19");
        0
}
            "Mon, Mar 19, 2018 01:55:03 PM UTC"
                    .map(|i| {
            && i + 2 < bytes.len()
use datafusion::arrow::datatypes::{DataType, TimeUnit};
    #[test]
        }
            dt.hour(),
        if bytes[i + 1] == b'E' && i + 2 < bytes.len() && bytes[i + 2] == b'z' {
            out.push('%');
                Arc::new(Field::new("v", DataType::Float64, true)),
}
        if bytes[i] != b'%' {
            DataType::Timestamp(TimeUnit::Microsecond, _) => {
        })
    out
        Weekday::Mon => 7,
                let values =
        assert_eq!(s.value(2), "1969-12-31");
        // %Ez (extended tz offset in minutes)
                            None
                &[
            args,
        )),
        )),
impl ScalarUDFImpl for StrftimeUdf {
    }
            );
 * this file be licensed under the Apache-2.0 license or a
        let canonical = DataType::Timestamp(TimeUnit::Microsecond, None);
            _ => out.push_str(&format!("{:03}", nanos / 1_000_000)),
    }
    Some(format_with_directives(dt, format))
#[derive(Debug)]
        Weekday::Wed => "Wednesday",
        ] {
                    "strftime: arg 0 expected numeric/timestamp/date/string, got {other:?}"
        b'B' => out.push_str(month_full(dt.month())),
    #[test]
    let mut i = 0;
            append_subsecond(&mut out, dt, kind, precision);
        value / 1000.0
    }
fn month_full(m: u32) -> &'static str {
                    return exec_err!(
                colons += 1;
            continue;
}
        // %<digit>N / %<digit>Q with optional precision
    #[test]
            }
        // Numeric + string fold onto Float64.
    let dt = Utc.timestamp_opt(adj_seconds, adj_nanos).single()?;
    let (adj_seconds, adj_nanos) = if nanos < 0 {
    match colons {
            ColumnarValue::Scalar(ScalarValue::Utf8(Some(f.to_string()))),
                            }
                    .expect("coerce_types canonicalizes to TimestampMicrosecond");
        {
            DataType::Float64 => {
            );
            DataType::Int32,
            dt.hour(),
                i += 2 + colons;
        b'm' => out.push_str(&format!("{:02}", dt.month())),
        assert_eq!(call_f64(1521467703.0, "%j").unwrap(), "078");
        "March",
/*
    let mut out = String::with_capacity(format.len() + 16);
        StrftimeUdf::new()
 * The OpenSearch Contributors require contributions made to
        Weekday::Sat => 2,
        }
            "2018-03-19"
            ],
    }
        let err = u
        b'k' => out.push_str(&format!("{:2}", dt.hour())),
 */
                ColumnarValue::Scalar(ScalarValue::Float64(Some(0.0))),
        Weekday::Tue => 2,
                "{t:?}"
        b'b' => out.push_str(month_short(dt.month())),
/// first Sunday of the year (matches `WeekFields.SUNDAY_START.weekOfYear() - 1`).
        assert_eq!(call_f64(1_521_467_703.0, "%Y-%m-%d").unwrap(), "2018-03-19");
impl StrftimeUdf {
                ScalarValue::Float64(v) => {
use datafusion::arrow::array::{Array, ArrayRef, AsArray, StringArray, TimestampMicrosecondArray};
                "{t:?}"
        3 => out.push_str("+0"),
        };
            DataType::Utf8,
    let fraction = seconds_value - seconds as f64;
        Ok(DataType::Utf8)
    fn name(&self) -> &str {
    fn twelve_hour_clock_and_ampm() {
            DataType::Utf8 | DataType::LargeUtf8 | DataType::Utf8View => DataType::Float64,
/// SQL plugin's `StrftimeFunction.MAX_UNIX_TIMESTAMP` — values beyond this yield null.
            DataType::Timestamp(TimeUnit::Nanosecond, Some("UTC".into())),
            && (bytes[i + 2] == b'N' || bytes[i + 2] == b'Q')
            out.push(directive as char);
                        }
            // Default precision per StrftimeFormatterUtil: %N=9 nanos, %Q=3 millis.
    }
            }
        Weekday::Fri => "Fri",
            12
    signature: Signature,
    let view = super::json_common::StringArrayView::from_array(array)
                continue;
                let values = value_array
    let h12 = {
        }
        } else {
            .unwrap(),
            "{:02}:{:02}:{:02}",
        if arg_types.len() != 2 {
        };
    let nanos = dt.nanosecond();
                return plan_err!(
        Weekday::Thu => 4,
        b'y' => out.push_str(&format!("{:02}", dt.year() % 100)),
            DataType::Date64,
        assert_eq!(call_f64(1521467703.0, "%a").unwrap(), "Mon");
    }
    let nanos = (fraction * 1_000_000_000.0) as i32;
        b'N' => {
    match kind {
        b'p' => out.push_str(if dt.hour() < 12 { "AM" } else { "PM" }),
    fn return_type(&self, arg_types: &[DataType]) -> Result<DataType> {
            call_f64(1_521_467_703_000.0, "%Y-%m-%d %H:%M:%S").unwrap(),
fn weekday_numeric_sunday_zero(w: Weekday) -> u32 {
            i += 3;
        )),
        );
    }
                other => {
                    })
            None,
    ctx.register_udf(ScalarUDF::from(StrftimeUdf::new()));
        "",
        Weekday::Sat => "Sat",
    }
        b'd' => out.push_str(&format!("{:02}", dt.day())),
        assert_eq!(call_f64(1521467703.0, "%p").unwrap(), "PM");
    let bytes = format.as_bytes();
            "2018-03-19 13:55:03"
                canonical,
}
}
        _ => return false,
                    .as_any()
        b'+' => out.push_str(&format!(
        b'G' => out.push_str(&format!("{:04}", dt.iso_week().year())),
    #[test]
#[cfg(test)]
            config_options: Arc::new(Default::default()),
}
            DataType::Int64,
}
        (doy - days_to_first_sunday) / 7 + 1
    #[test]
            while i + 1 + colons < bytes.len() && bytes[i + 1 + colons] == b':' {
            .coerce_types(&[DataType::Boolean, DataType::Utf8])
        // `abs(v) >= 1e11` auto-treats input as ms; below stays in seconds.
fn render_from_seconds(value: f64, format: Option<&str>) -> Option<String> {
    use super::*;
    fn complex_format_matches_it() {
        for args in [
                1,
        assert_eq!(
    fn timestamp_micros_renders_date_and_time() {
    }
                                Ok(Some(f)) => render_from_seconds(values.value(i), Some(&f)),
                return exec_err!(
            i += 2;
            assert_eq!(
            month_short(dt.month()),
            "{} {} {:02} {:02}:{:02}:{:02} {:04}",
            dt.year()
    Ok(view.cell(row).map(|s| s.to_string()))
        2 => out.push_str("+00:00:00"),
        let u = udf();
    }
    }
        Weekday::Sat => "Saturday",
            }
        if bytes[i + 1] == b'N' || bytes[i + 1] == b'Q' {
}
            return plan_err!("strftime expects 2 arguments, got {}", arg_types.len());
            call_f64(1521467703.123456, "%Y-%m-%d %H:%M:%S.%3Q").unwrap(),
    fn null_operand_yields_null() {
    if doy < days_to_first_sunday {
            arg_fields: vec![
        }
        };
            let rendered = match val {
                    })
    };
    #[test]
    } else {
    // matching the SQL plugin's `StrftimeFormatterUtil` threshold.
    fn signature(&self) -> &Signature {
            DataType::Timestamp(TimeUnit::Millisecond, None),
    .unwrap_or("")
        // Temporal types fold onto Timestamp(us).
        b'C' => out.push_str(&format!("{:02}", dt.year() / 100)),
        let directive = bytes[i + 1];
            weekday_short(dt.weekday()),
}
            dt.year()
    let doy = dt.ordinal();
                                Ok(Some(f)) => render_from_micros(values.value(i), Some(&f)),
    #[test]
    let dt = Utc
        assert!(call_f64(5e10, "%Y-%m-%d").is_none());
    fn coerce_types(&self, arg_types: &[DataType]) -> Result<Vec<DataType>> {
    }
            let out = invoke(args, &[DataType::Float64, DataType::Utf8], 1).unwrap();
            dt.day(),
        };
    fn weekday_directives() {
    }
}
        "August",
    [
            continue;
        if bytes[i + 1].is_ascii_digit()
            append_tz_offset_minutes(&mut out, dt);
        Weekday::Mon => 1,
        "April",
            h
        let args = ScalarFunctionArgs {
        assert_eq!(call_f64(1521467703.0, "%Y-%q").unwrap(), "2018-%q");
    .get(m as usize)
        .map_err(|e| datafusion::common::DataFusionError::Execution(format!("strftime: {e}")))?;
    fn call_ts_us(us: i64, f: &str) -> Option<String> {
                            match format_at(&format_array, i) {
    fn call_f64(v: f64, f: &str) -> Option<String> {
        Weekday::Sun => 1,
        for t in [
fn scalar_utf8(s: &ScalarValue) -> Result<Option<String>> {
        );
                    .downcast_ref::<TimestampMicrosecondArray>()
        "strftime"
        let arg_fields = arg_types
        Self {
fn weekday_full(w: Weekday) -> &'static str {
            }
            dt.minute(),
        }
            signature: Signature::user_defined(Volatility::Immutable),
            i += 2;
        b'%' => out.push('%'),
            Ok(opt.clone())
    fn negative_epoch_rendering() {
        assert_eq!(call_f64(-946_771_200.0, "%Y-%m-%d").unwrap(), "1940-01-01");
            return_field: Arc::new(Field::new(u.name(), DataType::Utf8, true)),
            other => panic!("expected Utf8 scalar, got {other:?}"),
            "{:04}-{:02}-{:02}",
        assert_eq!(call_f64(1521467703.123456, "%N").unwrap(), "123456001");
    .get(m as usize)
            break;
        b'f' => out.push_str(&format!("{:06}", dt.nanosecond() / 1000)),
use super::udf_identity;
            dt.minute(),
        "June",
                args,
            out.push('%');
        match v {
                        if values.is_null(i) {
        b'T' | b'X' => out.push_str(&format!(
        let n = args.number_rows;
            if i + 1 + colons < bytes.len() && bytes[i + 1 + colons] == b'z' {
        let args = vec![
                ColumnarValue::Scalar(ScalarValue::Float64(None)),
    let micros_remainder = value.rem_euclid(1_000_000) as u32;
/// Numeric inputs with `abs(v) >= 1e11` are auto-detected as milliseconds
use datafusion::logical_expr::{
            DataType::Date32,
        b'S' => out.push_str(&format!("{:02}", dt.second())),
            continue;
    }
            "1969-12-31 23:59:59"
//! `strftime(value, format)` — POSIX-style datetime formatter mirroring PPL `StrftimeFunction`.
    fn integer_seconds_ymd_hms() {
    } else {
            .iter()
                    .collect()
    use datafusion::arrow::array::{Float64Array, Int64Array};
}
            invoke(
        Weekday::Fri => "Friday",
    if !(-MAX_UNIX_SECONDS..=MAX_UNIX_SECONDS).contains(&seconds) {
        assert_eq!(call_f64(1521467703.0, "%A").unwrap(), "Monday");
        assert!(s.is_null(1));
            call_f64(1521467703.0, "%Y-%m-%d %H:%M:%S").unwrap(),
        ]));
    }
        // 1521467703.123456 isn't exactly f64-representable (≈ ...01), so %N shows trailing 001.
            let mut colons = 1;
            dt.month(),
            dt.minute(),
    }
        b'U' => out.push_str(&format!("{:02}", week_of_year_sunday_start(dt))),
            ],
            6 => out.push_str(&format!("{:06}", nanos / 1_000)),
    }
            ColumnarValue::Scalar(ScalarValue::Float64(Some(v))),
        Ok(ColumnarValue::Array(Arc::new(out) as ArrayRef))
            args: vec![
            i += 2;
        Weekday::Sun => 0,
                )
        )),
    let days_to_first_sunday = match jan1 {
            .unwrap_err();
                            match format_at(&format_array, i) {
        ] {
        "", "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec",
        let out: StringArray = match value_array.data_type() {
            return exec_err!("strftime expects 2 arguments, got {}", args.args.len());
    match directive {
udf_identity!(StrftimeUdf, "strftime");
    let jan1 = NaiveDate::from_ymd_opt(dt.year(), 1, 1)
    }
        Weekday::Wed => "Wed",
        return None;
                        }
        b'Z' => out.push_str("UTC"),
        assert!(call_f64(f64::NAN, "%Y-%m-%d").is_none());
                        } else {
    ColumnarValue, ScalarFunctionArgs, ScalarUDF, ScalarUDFImpl, Signature, Volatility,
        "January",
        assert_eq!(
const MAX_UNIX_SECONDS: i64 = 32_536_771_199;
        .weekday();
        }
        value
            call_f64(-1.0, "%Y-%m-%d %H:%M:%S").unwrap(),
        other => exec_err!("strftime: format must be VARCHAR, got {other:?}"),
        assert_eq!(call_f64(1521467703.0, "%I").unwrap(), "01");
        b'c' => out.push_str(&format!(
        if arg_types.len() != 2 {
        let value = match &arg_types[0] {
        {
        Weekday::Mon => "Mon",
            arg_fields,
            append_subsecond(&mut out, dt, bytes[i + 2], precision);
        // 2018-03-19 = Monday
fn append_tz_colon(out: &mut String, colons: usize) {
        if i + 1 >= bytes.len() {
    #[test]
    let format = format?;
    }
        let _arr: ArrayRef = Arc::new(Int64Array::from(vec![Some(1521467703i64)]));
            assert_eq!(
            i += 1;
        Weekday::Tue => 6,
            call_ts_us(1_521_467_703_000_000, "%H:%M:%S").unwrap(),
                    v.and_then(|v| render_from_seconds(v, format.as_deref()))
        b'x' => out.push_str(&format!(
        1 => out.push_str("+00:00"),
        ];
        let u = udf();
                                _ => None,
        assert_eq!(call_f64(1521467703.0, "%Ez").unwrap(), "+0");
/// `%U` — week of year, Sunday-start; week 0 is the partial week before the
            return Ok(ColumnarValue::Scalar(ScalarValue::Utf8(rendered)));
            ],
        }
            call_ts_us(1_521_467_703_000_000, "%F").unwrap(),
    }
    let seconds = value.div_euclid(1_000_000);
        assert_eq!(call_f64(1521467703.0, "100%%").unwrap(), "100%");
                    DataType::Utf8,
            return_field: Arc::new(Field::new(u.name(), DataType::Utf8, true)),
        // %:z / %::z / %:::z
        // Int64 shape sanity — exercised by the array test above.
