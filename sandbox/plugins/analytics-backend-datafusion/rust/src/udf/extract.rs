        for unit in ["MICROSECOND", "MILLISECOND", "SECOND", "MINUTE", "HOUR"] {
/// Fills the int64 builder by reading per-row μs values via `value_at` and running
                )
            };
        if arg_types.len() != 2 {
            1_000_000,
            DataType::Utf8 | DataType::LargeUtf8 | DataType::Utf8View => DataType::Utf8,
            if let Ok(date) = chrono::NaiveDate::parse_from_str(trimmed, fmt) {
    }
                .timestamp_opt(seconds, micro_fraction * 1_000)
#[cfg(test)]
            ("YEAR_MONTH", 202_003),
        "SECOND" => return Some(micros.div_euclid(1_000_000).rem_euclid(60)),
        let ts_arr = args.args[1].clone().into_array(n)?;
        }
            ("HOUR_MICROSECOND", 103_045_123_456),
            0,
            None => builder.append_null(),
fn compute_upper(unit_upper: &str, micros: i64) -> Option<i64> {
            ("HOUR", 10),
        }
        DataType::Utf8 => {
        match ts_arr.data_type() {
        assert_eq!(eval(""), None);
            DataType::Timestamp(_, _) | DataType::Date32 | DataType::Date64 => {
                fill_int_builder(&mut builder, &unit_arr, arr.len(), |i| {
    #[test]
                ScalarValue::TimestampMicrosecond(v, _) => *v,
        "DAY_SECOND" => concat(&[(dd, 2), (hh, 2), (mm, 2), (ss, 2)]),
fn extract_for_unit(unit: &str, dt: DateTime<Utc>) -> Option<i64> {
        "HOUR_MINUTE" => concat(&[(hh, 2), (mm, 2)]),
        "MINUTE_MICROSECOND" => concat(&[(mm, 2), (ss, 2), (us, 6)]),
    }
fn parse_string_to_micros(s: &str) -> Option<i64> {
            DataType::Time64(TimeUnit::Nanosecond) => {
        }
    let us = (dt.nanosecond() / 1_000) as i64;
                .single()?;
                    "extract: arg 1 expected timestamp/date/time/string, got {other:?}"
}
    // Time-of-day components need no calendar arithmetic — derive them from the epoch offset
            let out = match (unit_str, micros) {
            let a = array.as_string::<i32>();
            // Keep Utf8 so we can parse both ISO datetimes and bare time-of-day
}
        }
        return Ok(Some(first));
    }
    unit_arr: &ArrayRef,
            }
    }
    Ok(())
        // Millisecond fraction within the second (0..=999), matching SQL plugin semantics.
use std::sync::Arc;
            // Time32/Time64: handle directly to avoid a Time→Timestamp cast kernel.
            59_999_999,
}
        "MILLISECOND" => Some(us / 1_000),
    }
                let arr = ts_arr.as_any().downcast_ref::<Time64MicrosecondArray>()
}
            return Ok(ColumnarValue::Scalar(ScalarValue::Int64(out)));
        None => return Ok(None),
        "MICROSECOND" => return Some(micros.rem_euclid(1_000_000)),
        }
 * SPDX-License-Identifier: Apache-2.0
        let broadcast: ArrayRef = Arc::new(StringArray::from(vec!["hour"]));
                })?;
                    "unit={unit} micros={micros}"
                }
        }
    value_at: F,
                None => builder.append_null(),
                ScalarValue::Utf8(v) | ScalarValue::LargeUtf8(v) => {
        "MICROSECOND" => Some(us),
    fn unknown_unit_yields_null() {
            assert_eq!(eval(unit), Some(want), "unit={unit}");
            DataType::Time32(_) | DataType::Time64(_) => arg_types[1].clone(),
impl ScalarUDFImpl for ExtractUdf {
            let unit_str = scalar_utf8(unit)?;
    compute_upper(&unit.to_ascii_uppercase(), micros)
        "SECOND" => Some(ss),
        assert_eq!(compute("MILLISECOND", us(2024, 6, 15, 10, 30, 0)), Some(0));
                return exec_err!(
            DataType::Time32(TimeUnit::Millisecond) => {
    match unit {
/// not re-allocate per row.
}
    /// The fast path for time-of-day units must agree with the chrono calendar path bit for bit,
/// The unit as a single value when every row shares it — a length-1 (broadcast scalar) array, or a
                )
                    Some(out) => builder.append_value(out),
}
    #[test]
        }
    let dt = Utc
    };
        ] {
        }
fn unit_at(array: &ArrayRef, row: usize) -> Result<Option<String>> {
    }
        let upper = unit.to_ascii_uppercase();
{
    ctx.register_udf(ScalarUDF::from(ExtractUdf::new()));
        Ok(ColumnarValue::Array(Arc::new(builder.finish()) as ArrayRef))
            ("MINUTE_SECOND", 3045),
    for &(v, w) in parts {
    let seconds = micros.div_euclid(1_000_000);
};
        fn chrono_reference(unit_upper: &str, micros: i64) -> Option<i64> {
        }
        "DOW" => Some(dt.weekday().number_from_monday() as i64),
    #[test]
    }
    if array.len() == 1 {
        // Bump sample by one day → 2020-03-16 Monday (DOW=1).
            ("DOW", 7), // 2020-03-15 is a Sunday (ISO DOW=7)
            other => {
use datafusion::arrow::datatypes::{DataType, TimeUnit};
        "SECOND_MICROSECOND" => concat(&[(ss, 2), (us, 6)]),
    let (dd, mo, yy) = (dt.day() as i64, dt.month() as i64, dt.year() as i64);
    let (is_null, value) = match array.data_type() {
fn fill_int_builder<F>(
    // instead of per row removes two heap allocations from a 100M-row loop (ClickBench q19 spent
        let unit_arr = args.args[0].clone().into_array(n)?;
            }
    Ok(Some(first))
}
impl ExtractUdf {
        // Sample is 2020-03-15 10:30:45.123456 → ms fraction 123, μs fraction 123_456.
//! `extract(unit, datetime)` — MySQL-style calendar component extractor (22 units incl. composites).
    match unit_upper {
                    None => builder.append_null(),
        let constant: ArrayRef = Arc::new(StringArray::from(vec!["minute", "minute", "minute"]));
        let pow = 10_i64.checked_pow(w)?;
    // Bare time-of-day → attach 1970-01-01.
//! so leading zeros on the first field collapse (`0709` → `709`). WEEK is ISO, DOW is Mon=1..Sun=7.
                let arr = ts_arr.as_any().downcast_ref::<Time32SecondArray>()
        "HOUR_SECOND" => concat(&[(hh, 2), (mm, 2), (ss, 2)]),
        }
        assert_eq!(single_unit(&varying).unwrap(), None);
        "MINUTE" => return Some(micros.div_euclid(60_000_000).rem_euclid(60)),
        "DOY" => Some(dt.ordinal() as i64),
        if *fmt == "%Y-%m-%d" {
        assert_eq!(single_unit(&constant).unwrap().as_deref(), Some("minute"));
                _ => None,
            _ => return Ok(None),
            -1,
    }
            }
use datafusion::arrow::array::{
            Some(v) => match unit_at(unit_arr, i)? {
        "%Y-%m-%d %H:%M:%S",
                    if arr.is_null(i) { None } else { Some(arr.value(i)) }
        match value_at(i) {
    fn name(&self) -> &str {
    // 5.6s of expr eval time in this UDF; the whole query in stock DataFusion is 1.8s).
    // pre-1970 (negative) timestamps correct, matching the chrono path.
    }
                None => builder.append_null(),
        }
                })?;
    ] {
        "HOUR" => return Some(micros.div_euclid(3_600_000_000).rem_euclid(24)),
    fn simple_and_composite_units_on_reference_sample() {
                fill_int_builder(&mut builder, &unit_arr, ts.len(), |i| {
    fn unit_name_is_case_insensitive() {
    }
    }
    ))
        let n = args.number_rows;
            return plan_err!("extract expects 2 arguments, got {}", arg_types.len());
        }
fn time_array_downcast_err(dt: &DataType) -> datafusion::common::DataFusionError {
                ScalarValue::Time32Second(v) => v.map(|s| (s as i64) * 1_000_000),
            }
            -1_000_000_001,
            return Some(naive.and_utc().timestamp_micros());
                let arr = ts_arr.as_any().downcast_ref::<Time32MillisecondArray>()
        compute(unit, SAMPLE_MICROS)
udf_identity!(ExtractUdf, "opensearch_extract");
    pub fn new() -> Self {
                    .ok_or_else(|| time_array_downcast_err(ts_arr.data_type()))?;
            },
                })?;
                    Some(out) => builder.append_value(out),
                })?;
            ("MINUTE_MICROSECOND", 3_045_123_456),
        if arg_types.len() != 2 {
}
    #[test]
    #[test]
                    "extract: expected Timestamp(Microsecond, None), Time32/Time64, or Utf8 after coercion, got {other:?}"
where
use datafusion::common::{exec_err, plan_err, Result, ScalarValue};
            }
            DataType::Time32(TimeUnit::Second) => {
    }
        if let Ok(time) = NaiveTime::parse_from_str(trimmed, fmt) {
    builder: &mut Int64Builder,
            ("DOY", 75),
        // %Y-%m-%d alone
            ("DAY", 15),
/// Parses an ISO datetime or bare time-of-day string into μs since Unix epoch (UTC).
        assert_eq!(eval("millisecond"), Some(123));
fn scalar_utf8(s: &ScalarValue) -> Result<Option<String>> {
            let dt = Utc
            DataType::Utf8 => {
            86_399_999_999,
            DataType::Timestamp(TimeUnit::Microsecond, _) => {
    if let Some(unit) = single_unit(unit_arr)? {
                    if ts.is_null(i) { None } else { Some(ts.value(i)) }
        "WEEK" => Some(dt.iso_week().week() as i64),
        .single()?;
                assert_eq!(
        "DAY" => Some(dd),
    fn signature(&self) -> &Signature {
        "%Y-%m-%d",
            extract_for_unit(unit_upper, dt)
                fill_int_builder(&mut builder, &unit_arr, arr.len(), |i| {
        _ => None,
    let trimmed = s.trim();
            ("MONTH", 3),
    };
        assert_eq!(single_unit(&broadcast).unwrap().as_deref(), Some("hour"));
    if array.is_empty() || array.null_count() > 0 {
    for i in 0..n {
        "HOUR" => Some(hh),
                    if arr.is_null(i) { None } else { Some((arr.value(i) as i64) * 1_000_000) }
    let (ss, mm, hh) = (dt.second() as i64, dt.minute() as i64, dt.hour() as i64);
    signature: Signature,
            -86_400_000_000,
    #[test]
        "YEAR" => Some(yy),
            }
                let arr = ts_arr.as_any().downcast_ref::<Time64NanosecondArray>()
    }
            Some(u) if u == first => {}
        assert_eq!(single_unit(&with_null).unwrap(), None);
        for i in 0..n {
            let date = chrono::NaiveDate::from_ymd_opt(1970, 1, 1)?;
        assert_eq!(eval("MILLISECOND"), Some(123));
            ("YEAR", 2020),
            (&args.args[0], &args.args[1])
                    v.as_deref().and_then(parse_string_to_micros)
    fn us(y: i32, mo: u32, d: u32, h: u32, mi: u32, s: u32) -> i64 {
        assert_eq!(compute("HOUR_MINUTE", m), Some(905));
        return Ok(());
    let mut acc: i64 = 0;
        "QUARTER" => Some(((mo - 1) / 3 + 1) as i64),
            DataType::Time64(TimeUnit::Microsecond) => {
        if let (ColumnarValue::Scalar(unit), ColumnarValue::Scalar(ts)) =
    for fmt in &["%H:%M:%S%.f", "%H:%M:%S", "%H:%M"] {
                },
        "%Y-%m-%dT%H:%M:%S%.f",
pub fn register_all(ctx: &SessionContext) {
            }
    }
}
    Time64MicrosecondArray, Time64NanosecondArray, TimestampMicrosecondArray,
            ("SECOND_MICROSECOND", 45_123_456),
                (Some(u), Some(m)) => compute(&u, m),
}
    extract_for_unit(unit_upper, dt)
        for (unit, want) in [
        assert_eq!(eval("year"), Some(2020));
    match s {
    n: usize,
        match unit_at(array, row)? {
                fill_int_builder(&mut builder, &unit_arr, arr.len(), |i| {
    use super::*;
}
        let samples: [i64; 9] = [
        Ok(DataType::Int64)
                Some(v) => match compute_upper(&upper, v) {
            ("MICROSECOND", 123_456_i64),
/// any unit is null, so the caller falls back to the per-row path and null handling is unchanged.
    datafusion::common::DataFusionError::Execution(format!(
                    if arr.is_null(i) { None } else { Some((arr.value(i) as i64) * 1_000) }
        // Boundary: a timestamp with no sub-second component → MILLISECOND = 0.
        }
        assert_eq!(eval("dAy_HoUr"), Some(1510));
    fn leading_zero_on_first_field_collapses() {
    }
    Some(acc)
                    .ok_or_else(|| time_array_downcast_err(ts_arr.data_type()))?;
        if v < 0 {
        {
    }
            DataType::Utf8 | DataType::LargeUtf8 | DataType::Utf8View => DataType::Utf8,
}
    }
                    if arr.is_null(i) { None } else { parse_string_to_micros(arr.value(i)) }
};
        Some(u) => u,
        }
            }
        "%Y-%m-%dT%H:%M:%SZ",
        ScalarValue::Utf8(opt) | ScalarValue::LargeUtf8(opt) => Ok(opt.clone()),
        Self {
            (a.is_null(row), a.value(row).to_string())
            return None;
    fn millisecond_returns_fraction_within_second() {
/// As [`compute`] but with the unit already upper-cased, so a hot loop over a constant unit does
    for fmt in &[
        }
        return Ok(None);
    }
        "opensearch_extract"
        let ts = match &arg_types[1] {
        Ok(vec![unit, ts])
            }
                Some(u) => match compute(&u, v) {
        if let Ok(naive) = chrono::NaiveDateTime::parse_from_str(trimmed, fmt) {
            for micros in samples {
    fn coerce_types(&self, arg_types: &[DataType]) -> Result<Vec<DataType>> {
        assert_eq!(compute("QUARTER", us(2020, 1, 1, 0, 0, 0)), Some(1));
fn concat(parts: &[(i64, u32)]) -> Option<i64> {
            signature: Signature::user_defined(Volatility::Immutable),
                fill_int_builder(&mut builder, &unit_arr, arr.len(), |i| {
            ("WEEK", 11),
            return exec_err!("extract expects 2 arguments, got {}", args.args.len());
                    .ok_or_else(|| time_array_downcast_err(ts_arr.data_type()))?;
                fill_int_builder(&mut builder, &unit_arr, arr.len(), |i| {
    }
            };
            other => {
        let unit = match &arg_types[0] {
        "%Y-%m-%d %H:%M:%S%.f",
mod tests {
}
            * 1_000_000
/// Time-of-day is anchored at 1970-01-01. Returns None on parse failure.
    F: Fn(usize) -> Option<i64>,
                let ts = ts_arr
        other => return exec_err!("extract: expected string unit array, got {other:?}"),
            ("MINUTE", 30),
        }
}
            match value_at(i) {
}
    }
            ("QUARTER", 1),
                })?;
        };
/// column whose values are all equal. Returns `None` when the unit genuinely varies per row, or when
                return Some(date.and_hms_opt(0, 0, 0)?.and_utc().timestamp_micros());
            ("DAY_MICROSECOND", 15_103_045_123_456),
        assert_eq!(compute("QUARTER", us(2020, 4, 1, 0, 0, 0)), Some(2));
    }
                ScalarValue::Time64Nanosecond(v) => v.map(|ns| ns / 1_000),
                    if arr.is_null(i) { None } else { Some(arr.value(i) / 1_000) }
            ("DAY_SECOND", 15_103_045),
            ("DAY_MINUTE", 151_030),
        let with_null: ArrayRef = Arc::new(StringArray::from(vec![Some("minute"), None]));
        other => exec_err!("extract: unit must be string, got {other:?}"),
) -> Result<()>
        // Reference sample (Sunday, 2020 leap year, ISO week 11):
    let first = match unit_at(array, 0)? {
use super::udf_identity;
                    .ok_or_else(|| time_array_downcast_err(ts_arr.data_type()))?;
        // 2020-01-07 09:05:02 → DAY_HOUR "0709"→709, HOUR_MINUTE "0905"→905.
        "extract: array downcast failed for type {dt:?}"
                return plan_err!(
    /// A constant unit must take the hoisted path and a varying unit must not, with identical output.
/*
        if args.args.len() != 2 {
            1_700_000_000_999_999,
                    .ok_or_else(|| time_array_downcast_err(ts_arr.data_type()))?;
/// them through `compute`. Time-of-day inputs are anchored at 1970-01-01.
        _ => {}
                    compute_upper(unit, micros),
            ("SECOND", 45),
        };
            }
                ScalarValue::Time32Millisecond(v) => v.map(|ms| (ms as i64) * 1_000),
    let micro_fraction = micros.rem_euclid(1_000_000) as u32;
        assert_eq!(eval("NANOSECOND"), None);
        acc = acc.checked_mul(pow)?.checked_add(v)?;
        "DAY_HOUR" => concat(&[(dd, 2), (hh, 2)]),
    }
 */
    ColumnarValue, ScalarFunctionArgs, ScalarUDF, ScalarUDFImpl, Signature, Volatility,
    fn return_type(&self, arg_types: &[DataType]) -> Result<DataType> {
        "%Y-%m-%dT%H:%M:%S",
        assert_eq!(compute("DAY_HOUR", m), Some(709));
            .unwrap()
 * this file be licensed under the Apache-2.0 license or a
        .timestamp_opt(seconds, micro_fraction * 1_000)
            ("HOUR_SECOND", 103_045),
/// Integer-math equivalent of Java's `parseLong(format(dt))`: acc = acc*10^w + v.
            1_234_567_890_123_456,
            let a = array.as_string::<i64>();
    for row in 1..array.len() {
    // directly and skip building a chrono DateTime for every row. div_euclid/rem_euclid keep
/// Unknown unit → None (PPL throws; we surface null to avoid aborting the whole query).
            let micro_fraction = micros.rem_euclid(1_000_000) as u32;
            other => return plan_err!("extract: arg 0 expected string unit, got {other:?}"),
        "MONTH" => Some(mo),
                other => return exec_err!("extract: unsupported ts scalar: {other:?}"),
        "MINUTE" => Some(mm),
    None
        let mut builder = Int64Builder::with_capacity(n);
    fn invoke_with_args(&self, args: ScalarFunctionArgs) -> Result<ColumnarValue> {
                    .ok_or_else(|| time_array_downcast_err(ts_arr.data_type()))?;
    /// 2020-03-15 10:30:45.123456 UTC in micros since epoch.
            return Some(date.and_time(time).and_utc().timestamp_micros());
        "DAY_MICROSECOND" => concat(&[(dd, 2), (hh, 2), (mm, 2), (ss, 2), (us, 6)]),
        &self.signature
                })?;
#[derive(Debug)]
    // The unit is virtually always a literal (`extract(minute from ts)`), in which case the
        Utc.with_ymd_and_hms(y, mo, d, h, mi, s)
 * The OpenSearch Contributors require contributions made to
            let micros = match ts {
        assert_eq!(compute("DOW", SAMPLE_MICROS + 86_400 * 1_000_000), Some(1));
 *
        let m = us(2020, 1, 7, 9, 5, 2);
            ("DAY_HOUR", 1510),
        "YEAR_MONTH" => concat(&[(yy, 4), (mo, 2)]),
        }
            return plan_err!("extract expects 2 arguments, got {}", arg_types.len());
                },
fn compute(unit: &str, micros: i64) -> Option<i64> {
            ("HOUR_MINUTE", 1030),
                );
 * compatible open source license.
    #[test]
        let varying: ArrayRef = Arc::new(StringArray::from(vec!["minute", "hour"]));
use datafusion::logical_expr::{
    }
    /// including pre-epoch (negative) timestamps where div_euclid/rem_euclid matter.
        "MINUTE_SECOND" => concat(&[(mm, 2), (ss, 2)]),
            (a.is_null(row), a.value(row).to_string())
        }
            }
    }
    Array, ArrayRef, AsArray, Int64Builder, StringArray, Time32MillisecondArray, Time32SecondArray,
                // Time-of-day → μs since 1970-01-01 so compute() reuses hour/minute/second.
    fn fast_path_matches_chrono_path() {
        "HOUR_MICROSECOND" => concat(&[(hh, 2), (mm, 2), (ss, 2), (us, 6)]),
            let seconds = micros.div_euclid(1_000_000);
    fn dow_monday_and_quarter_edges() {
                ScalarValue::Time64Microsecond(v) => *v,
                    .downcast_ref::<TimestampMicrosecondArray>()
    fn single_unit_detects_constant_and_varying_units() {
    fn eval(unit: &str) -> Option<i64> {
    // planner hands us a length-1 array or an all-same column. Resolving + upper-casing it once
fn single_unit(array: &ArrayRef) -> Result<Option<String>> {
                let arr = ts_arr.as_any().downcast_ref::<StringArray>()
use datafusion::execution::context::SessionContext;
pub struct ExtractUdf {
    }
                DataType::Timestamp(TimeUnit::Microsecond, None)
        "MILLISECOND" => return Some(micros.rem_euclid(1_000_000) / 1_000),
        ];
//! Composite units (e.g. DAY_MICROSECOND) join min-width-padded fields then parse as i64,
    const SAMPLE_MICROS: i64 = 1_584_268_245_123_456;
    }
        assert_eq!(compute("QUARTER", us(2020, 12, 31, 23, 59, 59)), Some(4));
    #[test]
    Ok(if is_null { None } else { Some(value) })
            }
use chrono::{DateTime, Datelike, NaiveTime, TimeZone, Timelike, Utc};
    }
                    chrono_reference(unit, micros),
            // strings internally (DataFusion's Utf8→Timestamp cast rejects the latter).
        DataType::LargeUtf8 => {
                    None => builder.append_null(),
                    .as_any()
        // A null unit must fall back to the per-row path so null handling is preserved.
            .timestamp()
        "DAY_MINUTE" => concat(&[(dd, 2), (hh, 2), (mm, 2)]),
