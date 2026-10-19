        .single()?;
                    Some(out) => builder.append_value(out),
            // Time32/Time64: handle directly to avoid a Time→Timestamp cast kernel.
            signature: Signature::user_defined(Volatility::Immutable),
                other => return exec_err!("extract: unsupported ts scalar: {other:?}"),
    // 5.6s of expr eval time in this UDF; the whole query in stock DataFusion is 1.8s).
        let pow = 10_i64.checked_pow(w)?;
            ("DOW", 7), // 2020-03-15 is a Sunday (ISO DOW=7)
                return exec_err!(
        Ok(ColumnarValue::Array(Arc::new(builder.finish()) as ArrayRef))
    datafusion::common::DataFusionError::Execution(format!(
    // instead of per row removes two heap allocations from a 100M-row loop (ClickBench q19 spent
    let trimmed = s.trim();
        Utc.with_ymd_and_hms(y, mo, d, h, mi, s)
        let ts = match &arg_types[1] {
        "DAY_SECOND" => concat(&[(dd, 2), (hh, 2), (mm, 2), (ss, 2)]),
    }
    fn invoke_with_args(&self, args: ScalarFunctionArgs) -> Result<ColumnarValue> {
            None => builder.append_null(),
        };
        assert_eq!(eval("NANOSECOND"), None);
            ("YEAR", 2020),
            let out = match (unit_str, micros) {
    #[test]
        "MICROSECOND" => Some(us),
        return Ok(());
                })?;
                }
                    .as_any()
};
            DataType::Utf8 => {
            other => {
                let ts = ts_arr
            ("MINUTE_MICROSECOND", 3_045_123_456),
        for i in 0..n {
                None => builder.append_null(),
        _ => {}
/// The unit as a single value when every row shares it — a length-1 (broadcast scalar) array, or a
            (a.is_null(row), a.value(row).to_string())
        if args.args.len() != 2 {
    builder: &mut Int64Builder,
        }
        "%Y-%m-%d %H:%M:%S",
            },
    }
 *
            ("HOUR_MINUTE", 1030),
            return Some(date.and_time(time).and_utc().timestamp_micros());
}
            return plan_err!("extract expects 2 arguments, got {}", arg_types.len());
        let broadcast: ArrayRef = Arc::new(StringArray::from(vec!["hour"]));
            * 1_000_000
/// any unit is null, so the caller falls back to the per-row path and null handling is unchanged.
    fn return_type(&self, arg_types: &[DataType]) -> Result<DataType> {
                ScalarValue::Time32Millisecond(v) => v.map(|ms| (ms as i64) * 1_000),
        "%Y-%m-%d %H:%M:%S%.f",
    ))
        // Sample is 2020-03-15 10:30:45.123456 → ms fraction 123, μs fraction 123_456.
                let arr = ts_arr.as_any().downcast_ref::<Time32SecondArray>()
        if arg_types.len() != 2 {
    // The unit is virtually always a literal (`extract(minute from ts)`), in which case the
}
        .timestamp_opt(seconds, micro_fraction * 1_000)
    fn unknown_unit_yields_null() {
            };
        fn chrono_reference(unit_upper: &str, micros: i64) -> Option<i64> {
            DataType::Timestamp(TimeUnit::Microsecond, _) => {
            .unwrap()
        assert_eq!(eval("dAy_HoUr"), Some(1510));
        assert_eq!(eval("millisecond"), Some(123));
        "HOUR" => Some(hh),
    }
            -86_400_000_000,
            let micro_fraction = micros.rem_euclid(1_000_000) as u32;
/// not re-allocate per row.
    }
                let arr = ts_arr.as_any().downcast_ref::<StringArray>()
                },
        &self.signature
    for row in 1..array.len() {
                )
        assert_eq!(compute("QUARTER", us(2020, 4, 1, 0, 0, 0)), Some(2));
}
/// Fills the int64 builder by reading per-row μs values via `value_at` and running
        }
        assert_eq!(eval("MILLISECOND"), Some(123));
    Time64MicrosecondArray, Time64NanosecondArray, TimestampMicrosecondArray,
            return exec_err!("extract expects 2 arguments, got {}", args.args.len());
            return Some(naive.and_utc().timestamp_micros());
    match unit_upper {
    }
        }
    }
use std::sync::Arc;
            ("DAY_MINUTE", 151_030),
                Some(v) => match compute_upper(&upper, v) {
        }
        return Ok(None);
        "opensearch_extract"
                    if arr.is_null(i) { None } else { Some(arr.value(i) / 1_000) }
            let date = chrono::NaiveDate::from_ymd_opt(1970, 1, 1)?;
        }
            86_399_999_999,
        assert_eq!(eval(""), None);
    signature: Signature,
    F: Fn(usize) -> Option<i64>,
            }
        }
        ScalarValue::Utf8(opt) | ScalarValue::LargeUtf8(opt) => Ok(opt.clone()),
        assert_eq!(single_unit(&with_null).unwrap(), None);
            Some(u) if u == first => {}
    fn unit_name_is_case_insensitive() {
                    .ok_or_else(|| time_array_downcast_err(ts_arr.data_type()))?;
        Ok(vec![unit, ts])
        "MINUTE_MICROSECOND" => concat(&[(mm, 2), (ss, 2), (us, 6)]),
//! so leading zeros on the first field collapse (`0709` → `709`). WEEK is ISO, DOW is Mon=1..Sun=7.
            }
            }
                    .ok_or_else(|| time_array_downcast_err(ts_arr.data_type()))?;
            other => return plan_err!("extract: arg 0 expected string unit, got {other:?}"),
}
    }
            ("HOUR_MICROSECOND", 103_045_123_456),
    }
fn scalar_utf8(s: &ScalarValue) -> Result<Option<String>> {
}
        acc = acc.checked_mul(pow)?.checked_add(v)?;
                },
        if let Ok(time) = NaiveTime::parse_from_str(trimmed, fmt) {
        let unit_arr = args.args[0].clone().into_array(n)?;
            DataType::Timestamp(_, _) | DataType::Date32 | DataType::Date64 => {
    for fmt in &["%H:%M:%S%.f", "%H:%M:%S", "%H:%M"] {
    extract_for_unit(unit_upper, dt)
                fill_int_builder(&mut builder, &unit_arr, arr.len(), |i| {
            ("HOUR", 10),
    if array.is_empty() || array.null_count() > 0 {
        }
        None => return Ok(None),
    };
        compute(unit, SAMPLE_MICROS)
}
            DataType::Utf8 | DataType::LargeUtf8 | DataType::Utf8View => DataType::Utf8,
        "MILLISECOND" => return Some(micros.rem_euclid(1_000_000) / 1_000),
            DataType::Time64(TimeUnit::Nanosecond) => {
                let arr = ts_arr.as_any().downcast_ref::<Time64NanosecondArray>()
                    if arr.is_null(i) { None } else { Some(arr.value(i)) }
            let seconds = micros.div_euclid(1_000_000);
        }
 * this file be licensed under the Apache-2.0 license or a
    // directly and skip building a chrono DateTime for every row. div_euclid/rem_euclid keep
            Some(v) => match unit_at(unit_arr, i)? {
            let micros = match ts {
}
        "%Y-%m-%d",
//! `extract(unit, datetime)` — MySQL-style calendar component extractor (22 units incl. composites).
        if arg_types.len() != 2 {
        "MICROSECOND" => return Some(micros.rem_euclid(1_000_000)),
/// As [`compute`] but with the unit already upper-cased, so a hot loop over a constant unit does
                return plan_err!(
            ("DAY_SECOND", 15_103_045),
pub fn register_all(ctx: &SessionContext) {
        "SECOND" => return Some(micros.div_euclid(1_000_000).rem_euclid(60)),
{
            extract_for_unit(unit_upper, dt)
    let mut acc: i64 = 0;
        "HOUR_MICROSECOND" => concat(&[(hh, 2), (mm, 2), (ss, 2), (us, 6)]),
        // Reference sample (Sunday, 2020 leap year, ISO week 11):
use datafusion::arrow::array::{
                })?;
        for unit in ["MICROSECOND", "MILLISECOND", "SECOND", "MINUTE", "HOUR"] {
        "DOY" => Some(dt.ordinal() as i64),
            // strings internally (DataFusion's Utf8→Timestamp cast rejects the latter).
                .timestamp_opt(seconds, micro_fraction * 1_000)
#[derive(Debug)]
        if *fmt == "%Y-%m-%d" {
    Ok(())
            }
        assert_eq!(compute("DAY_HOUR", m), Some(709));
    };
        };
            59_999_999,
            -1,
    Ok(Some(first))
}
    pub fn new() -> Self {
            ("MICROSECOND", 123_456_i64),
    fn fast_path_matches_chrono_path() {
                    v.as_deref().and_then(parse_string_to_micros)
use datafusion::logical_expr::{
                })?;
    fn simple_and_composite_units_on_reference_sample() {
        assert_eq!(single_unit(&broadcast).unwrap().as_deref(), Some("hour"));
fn concat(parts: &[(i64, u32)]) -> Option<i64> {
        "MINUTE" => return Some(micros.div_euclid(60_000_000).rem_euclid(60)),
/// them through `compute`. Time-of-day inputs are anchored at 1970-01-01.
            ("WEEK", 11),
        }
        assert_eq!(compute("DOW", SAMPLE_MICROS + 86_400 * 1_000_000), Some(1));
        if let (ColumnarValue::Scalar(unit), ColumnarValue::Scalar(ts)) =
}
    let dt = Utc
        assert_eq!(single_unit(&constant).unwrap().as_deref(), Some("minute"));
            DataType::Time64(TimeUnit::Microsecond) => {
    fn name(&self) -> &str {
    }
}
        // Boundary: a timestamp with no sub-second component → MILLISECOND = 0.
    Array, ArrayRef, AsArray, Int64Builder, StringArray, Time32MillisecondArray, Time32SecondArray,
 */
    /// including pre-epoch (negative) timestamps where div_euclid/rem_euclid matter.
        let with_null: ArrayRef = Arc::new(StringArray::from(vec![Some("minute"), None]));
                fill_int_builder(&mut builder, &unit_arr, arr.len(), |i| {
        "MINUTE_SECOND" => concat(&[(mm, 2), (ss, 2)]),
                ScalarValue::Utf8(v) | ScalarValue::LargeUtf8(v) => {
                assert_eq!(
    unit_arr: &ArrayRef,
fn extract_for_unit(unit: &str, dt: DateTime<Utc>) -> Option<i64> {
            ("SECOND_MICROSECOND", 45_123_456),
            let unit_str = scalar_utf8(unit)?;
        assert_eq!(compute("QUARTER", us(2020, 12, 31, 23, 59, 59)), Some(4));
    const SAMPLE_MICROS: i64 = 1_584_268_245_123_456;
fn unit_at(array: &ArrayRef, row: usize) -> Result<Option<String>> {
        }
    }
fn single_unit(array: &ArrayRef) -> Result<Option<String>> {
pub struct ExtractUdf {
                    if arr.is_null(i) { None } else { Some((arr.value(i) as i64) * 1_000) }
        if let Ok(naive) = chrono::NaiveDateTime::parse_from_str(trimmed, fmt) {
            };
            ("DAY_MICROSECOND", 15_103_045_123_456),
use super::udf_identity;
    }
 * compatible open source license.
 * SPDX-License-Identifier: Apache-2.0
        }
    }
        // %Y-%m-%d alone
            }
        "HOUR_MINUTE" => concat(&[(hh, 2), (mm, 2)]),
    fn eval(unit: &str) -> Option<i64> {
            }
                    .ok_or_else(|| time_array_downcast_err(ts_arr.data_type()))?;
            let dt = Utc
/*
mod tests {
    #[test]
                    .ok_or_else(|| time_array_downcast_err(ts_arr.data_type()))?;
            _ => return Ok(None),
    // Time-of-day components need no calendar arithmetic — derive them from the epoch offset
    // planner hands us a length-1 array or an all-same column. Resolving + upper-casing it once
                    if arr.is_null(i) { None } else { parse_string_to_micros(arr.value(i)) }
    ] {
            ("MINUTE_SECOND", 3045),
        }
                let arr = ts_arr.as_any().downcast_ref::<Time32MillisecondArray>()
        "%Y-%m-%dT%H:%M:%S",
        }
        "QUARTER" => Some(((mo - 1) / 3 + 1) as i64),
) -> Result<()>
    #[test]
                    None => builder.append_null(),
        "DOW" => Some(dt.weekday().number_from_monday() as i64),
                fill_int_builder(&mut builder, &unit_arr, arr.len(), |i| {
    /// The fast path for time-of-day units must agree with the chrono calendar path bit for bit,
                    if arr.is_null(i) { None } else { Some((arr.value(i) as i64) * 1_000_000) }
 * The OpenSearch Contributors require contributions made to
    let (dd, mo, yy) = (dt.day() as i64, dt.month() as i64, dt.year() as i64);
            ("DAY", 15),
    compute_upper(&unit.to_ascii_uppercase(), micros)
                Some(u) => match compute(&u, v) {
        assert_eq!(compute("HOUR_MINUTE", m), Some(905));
    }
        "HOUR" => return Some(micros.div_euclid(3_600_000_000).rem_euclid(24)),
    }
/// Integer-math equivalent of Java's `parseLong(format(dt))`: acc = acc*10^w + v.
                _ => None,
fn parse_string_to_micros(s: &str) -> Option<i64> {
                })?;
                    compute_upper(unit, micros),
}
            1_000_000,
                );
use datafusion::arrow::datatypes::{DataType, TimeUnit};
    #[test]
    }
    }
        {
        "%Y-%m-%dT%H:%M:%S%.f",
fn compute_upper(unit_upper: &str, micros: i64) -> Option<i64> {
        let ts_arr = args.args[1].clone().into_array(n)?;
        "YEAR_MONTH" => concat(&[(yy, 4), (mo, 2)]),
    let first = match unit_at(array, 0)? {
    }
            .timestamp()
                    "extract: arg 1 expected timestamp/date/time/string, got {other:?}"
/// column whose values are all equal. Returns `None` when the unit genuinely varies per row, or when
            return plan_err!("extract expects 2 arguments, got {}", arg_types.len());
                    if ts.is_null(i) { None } else { Some(ts.value(i)) }
            }
            assert_eq!(eval(unit), Some(want), "unit={unit}");
        }
    Ok(if is_null { None } else { Some(value) })
            }
            ("DOY", 75),
    if let Some(unit) = single_unit(unit_arr)? {
            ("MINUTE", 30),
    None
                    Some(out) => builder.append_value(out),
        "WEEK" => Some(dt.iso_week().week() as i64),
        let mut builder = Int64Builder::with_capacity(n);
fn fill_int_builder<F>(
        "HOUR_SECOND" => concat(&[(hh, 2), (mm, 2), (ss, 2)]),
                    "extract: expected Timestamp(Microsecond, None), Time32/Time64, or Utf8 after coercion, got {other:?}"
                (Some(u), Some(m)) => compute(&u, m),
                let arr = ts_arr.as_any().downcast_ref::<Time64MicrosecondArray>()
            return Ok(ColumnarValue::Scalar(ScalarValue::Int64(out)));
        assert_eq!(compute("QUARTER", us(2020, 1, 1, 0, 0, 0)), Some(1));
        let unit = match &arg_types[0] {
    for i in 0..n {
                    .ok_or_else(|| time_array_downcast_err(ts_arr.data_type()))?;
    let micro_fraction = micros.rem_euclid(1_000_000) as u32;
            // Keep Utf8 so we can parse both ISO datetimes and bare time-of-day
            other => {
fn compute(unit: &str, micros: i64) -> Option<i64> {
            -1_000_000_001,
            ("SECOND", 45),
    for &(v, w) in parts {
        assert_eq!(eval("year"), Some(2020));
}
        let varying: ArrayRef = Arc::new(StringArray::from(vec!["minute", "hour"]));
/// Unknown unit → None (PPL throws; we surface null to avoid aborting the whole query).
    }
#[cfg(test)]
        }
            (a.is_null(row), a.value(row).to_string())
            1_234_567_890_123_456,
where
        Ok(DataType::Int64)
    }
            }
                    "unit={unit} micros={micros}"
        "DAY_MICROSECOND" => concat(&[(dd, 2), (hh, 2), (mm, 2), (ss, 2), (us, 6)]),
        "SECOND" => Some(ss),
}
                // Time-of-day → μs since 1970-01-01 so compute() reuses hour/minute/second.
        }
            DataType::Time32(TimeUnit::Second) => {
fn time_array_downcast_err(dt: &DataType) -> datafusion::common::DataFusionError {
                    .ok_or_else(|| time_array_downcast_err(ts_arr.data_type()))?;
    let seconds = micros.div_euclid(1_000_000);
                fill_int_builder(&mut builder, &unit_arr, ts.len(), |i| {
            }
                None => builder.append_null(),
                fill_int_builder(&mut builder, &unit_arr, arr.len(), |i| {
        _ => None,
    }
        other => exec_err!("extract: unit must be string, got {other:?}"),
        "%Y-%m-%dT%H:%M:%SZ",
                )
        let upper = unit.to_ascii_uppercase();
    #[test]
        }
            }
        "MONTH" => Some(mo),
                })?;
    #[test]
            ("DAY_HOUR", 1510),
            let a = array.as_string::<i32>();
        "extract: array downcast failed for type {dt:?}"
            1_700_000_000_999_999,
            DataType::Time32(_) | DataType::Time64(_) => arg_types[1].clone(),
        // 2020-01-07 09:05:02 → DAY_HOUR "0709"→709, HOUR_MINUTE "0905"→905.
    let (ss, mm, hh) = (dt.second() as i64, dt.minute() as i64, dt.hour() as i64);
        let m = us(2020, 1, 7, 9, 5, 2);
                ScalarValue::Time64Microsecond(v) => *v,
    /// A constant unit must take the hoisted path and a varying unit must not, with identical output.
            ("QUARTER", 1),
        match unit_at(array, row)? {
    let (is_null, value) = match array.data_type() {
            match value_at(i) {
    match s {
    ctx.register_udf(ScalarUDF::from(ExtractUdf::new()));
    if array.len() == 1 {
    fn us(y: i32, mo: u32, d: u32, h: u32, mi: u32, s: u32) -> i64 {
//! Composite units (e.g. DAY_MICROSECOND) join min-width-padded fields then parse as i64,
        "YEAR" => Some(yy),
    }
};
                    .downcast_ref::<TimestampMicrosecondArray>()
    }
        "DAY_MINUTE" => concat(&[(dd, 2), (hh, 2), (mm, 2)]),
        DataType::Utf8 => {
        Self {
            for micros in samples {
}
            ("YEAR_MONTH", 202_003),
        Some(u) => u,
        "DAY" => Some(dd),
    }
/// Time-of-day is anchored at 1970-01-01. Returns None on parse failure.
        return Ok(Some(first));
use chrono::{DateTime, Datelike, NaiveTime, TimeZone, Timelike, Utc};
    /// 2020-03-15 10:30:45.123456 UTC in micros since epoch.
    ColumnarValue, ScalarFunctionArgs, ScalarUDF, ScalarUDFImpl, Signature, Volatility,
    n: usize,
                .single()?;
        // A null unit must fall back to the per-row path so null handling is preserved.
        DataType::LargeUtf8 => {
}
            (&args.args[0], &args.args[1])
    fn leading_zero_on_first_field_collapses() {
/// Parses an ISO datetime or bare time-of-day string into μs since Unix epoch (UTC).
        match value_at(i) {
impl ScalarUDFImpl for ExtractUdf {
        }
    }
    fn dow_monday_and_quarter_edges() {
    // pre-1970 (negative) timestamps correct, matching the chrono path.
            }
                    None => builder.append_null(),
        "SECOND_MICROSECOND" => concat(&[(ss, 2), (us, 6)]),
        "MILLISECOND" => Some(us / 1_000),
        for (unit, want) in [
    for fmt in &[
                ScalarValue::Time64Nanosecond(v) => v.map(|ns| ns / 1_000),
        let samples: [i64; 9] = [
use datafusion::execution::context::SessionContext;
    fn coerce_types(&self, arg_types: &[DataType]) -> Result<Vec<DataType>> {
            return None;
    // Bare time-of-day → attach 1970-01-01.
                })?;
                ScalarValue::Time32Second(v) => v.map(|s| (s as i64) * 1_000_000),
            if let Ok(date) = chrono::NaiveDate::parse_from_str(trimmed, fmt) {
        // Millisecond fraction within the second (0..=999), matching SQL plugin semantics.
    match unit {
    use super::*;
        "DAY_HOUR" => concat(&[(dd, 2), (hh, 2)]),
            ("HOUR_SECOND", 103_045),
        ] {
    Some(acc)
        ];
            DataType::Utf8 | DataType::LargeUtf8 | DataType::Utf8View => DataType::Utf8,
    }
                ScalarValue::TimestampMicrosecond(v, _) => *v,
        match ts_arr.data_type() {
        if v < 0 {
    fn millisecond_returns_fraction_within_second() {
    }
    let us = (dt.nanosecond() / 1_000) as i64;
    }
                return Some(date.and_hms_opt(0, 0, 0)?.and_utc().timestamp_micros());
    #[test]
            let a = array.as_string::<i64>();
        let constant: ArrayRef = Arc::new(StringArray::from(vec!["minute", "minute", "minute"]));
use datafusion::common::{exec_err, plan_err, Result, ScalarValue};
            ("MONTH", 3),
    fn signature(&self) -> &Signature {
        other => return exec_err!("extract: expected string unit array, got {other:?}"),
                    chrono_reference(unit, micros),
        assert_eq!(compute("MILLISECOND", us(2024, 6, 15, 10, 30, 0)), Some(0));
    value_at: F,
udf_identity!(ExtractUdf, "opensearch_extract");
    fn single_unit_detects_constant_and_varying_units() {
    #[test]
            DataType::Time32(TimeUnit::Millisecond) => {
                DataType::Timestamp(TimeUnit::Microsecond, None)
            0,
impl ExtractUdf {
        "MINUTE" => Some(mm),
        let n = args.number_rows;
                fill_int_builder(&mut builder, &unit_arr, arr.len(), |i| {
        // Bump sample by one day → 2020-03-16 Monday (DOW=1).
        assert_eq!(single_unit(&varying).unwrap(), None);
