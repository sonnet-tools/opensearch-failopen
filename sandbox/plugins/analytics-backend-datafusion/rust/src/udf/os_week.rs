        0
use datafusion::common::{plan_err, Result};
                    "os_yearweek: arg 0 not coerced to Date32".to_string(),
fn os_week_number(date: NaiveDate, mode: i32) -> u32 {
        if arg_types.is_empty() || arg_types.len() > 2 {
use datafusion::arrow::array::{Array, ArrayRef, AsArray, Int32Builder};
        Ok(out)
            assert_eq!(os_yearweek_number(d, mode), want, "mode={mode}");
}
/// `(firstDayOfWeek, minimalDaysInFirstWeek)` for MySQL modes 0..7.
    signature: Signature,
    ctx.register_udf(ScalarUDF::from(OsYearweekUdf::new()));
        Ok(DataType::Int32)
    let year = os_year_number(date, mode_resolved);
                datafusion::error::DataFusionError::Internal(
/// at least `min_days` days in `year`, else week 1 starts the next `start`-day.
    fn os_yearweek_jan1_1900_all_modes() {
            };
            | DataType::Utf8View => out.push(DataType::Date32),
            builder.append_value(os_yearweek_number(date, mode));
                    .as_primitive::<datafusion::arrow::datatypes::Int32Type>()
        4 | 6 => 4,
    year * 100 + week as i32
    }
}
    fn os_yearweek_matches_sql_plugin() {
                "os_yearweek expects 1 or 2 arguments, got {}",
            .ok_or_else(|| {
        let date_arg = args.args[0].clone().into_array(n)?;
            })?;
/// MySQL `YEARWEEK(date, mode)` — `year * 100 + week`. Bumps mode to 2 or 7 when the
        Ok(DataType::Int32)
    } else {
        jan1 - chrono::Duration::days(back as i64)
    } else {
            let mode = match &mode_arg {
        date.year()
        Weekday::Tue => 1,
    };
        assert_eq!(os_week_number(d, 0), 7);
        Ok(ColumnarValue::Array(Arc::new(builder.finish()) as ArrayRef))
    }
        let date_arg = args.args[0].clone().into_array(n)?;
        // 2008-02-20 (Wed) → MySQL mode 0 = 7 (ISO week is 8).
    }
                datafusion::error::DataFusionError::Execution(format!(
        match &arg_types[0] {
            match &arg_types[1] {
        let next_w1 = week1_start(year + 1, start, min_days);
use super::udf_identity;
                Some(arr) => arr
    fn return_type(&self, arg_types: &[DataType]) -> Result<DataType> {
        let d = NaiveDate::from_ymd_opt(2008, 2, 20).unwrap();
    let min_days = match mode {
pub struct OsYearweekUdf {
    };
        }
        // yearweek('2003-10-03', 3)=200340.
//! and `YEARWEEK`. DataFusion's `date_part('week', ts)` is ISO-only and disagrees with MySQL's
                | DataType::Int32
    } else {
        Self {
            (0, 189953),
    }
                )
            .downcast_ref::<datafusion::arrow::array::Date32Array>()
    fn os_week_default_mode_zero() {
        let expected: [(i32, i32); 8] = [
        } else {
                arg_types.len()
        }
        for i in 0..n {
    }
#[cfg(test)]
                    "os_yearweek: arg 0 expected date/timestamp/string, got {other:?}"
    }
            match &arg_types[1] {
    signature: Signature,
                    .value(i),
    }
            | DataType::Utf8
            signature: Signature::user_defined(Volatility::Immutable),
        }
}
mod tests {
        // From CalciteDateTimeFunctionIT.testWeek: each row = (date, mode, expected).
        Weekday::Wed => 2,
fn os_yearweek_number(date: NaiveDate, mode: i32) -> i32 {
}
        }
}
        let mode_arg = if args.args.len() == 2 {
/// see https://dev.mysql.com/doc/refman/8.0/en/date-and-time-functions.html#function_week.
    }
        }
            (6, 190001),
            (NaiveDate::from_ymd_opt(2008, 2, 20).unwrap(), 0, 7),
            DataType::Date32
    fn invoke_with_args(&self, args: ScalarFunctionArgs) -> Result<ColumnarValue> {
    fn os_yearweek_dec_1899_to_jan_1900_boundary() {
}
                other => {
                datafusion::error::DataFusionError::Internal(
            );
        mode
        if arg_types.is_empty() || arg_types.len() > 2 {
                "os_yearweek expects 1 or 2 arguments, got {}",
impl ScalarUDFImpl for OsWeekUdf {
        }
                Some(arr) if arr.is_null(i) => 0,
    }
                | DataType::UInt8
    fn coerce_types(&self, arg_types: &[DataType]) -> Result<Vec<DataType>> {
    #[test]
use datafusion::execution::context::SessionContext;
    pub fn new() -> Self {
        Weekday::Mon => 0,
    #[test]
        };
        assert_eq!(os_yearweek_number(d, 0), 200339);
                | DataType::Int32
                | DataType::UInt8
    (weekday_idx(from) + 7 - weekday_idx(start)) % 7
fn weekday_idx(w: Weekday) -> u32 {
            }
                | DataType::UInt64 => out.push(DataType::Int32),
    } else {
        } else {
                | DataType::Int16
}
    let back = back_offset(jan1.weekday(), start);
    if 7 - back >= min_days {
    };
/// First day of `year`'s week 1: the week containing Jan 1 owns week 1 iff it has
pub struct OsWeekUdf {
        assert_eq!(os_yearweek_number(dec30_1899, 0), 189952);
            (NaiveDate::from_ymd_opt(2008, 12, 31).unwrap(), 1, 53),
    }
    fn name(&self) -> &str {
            let days = dates.value(i);
        }
    }
        }
    fn signature(&self) -> &Signature {
fn back_offset(from: Weekday, start: Weekday) -> u32 {
        raw
        &self.signature
            }
}
}
                ))
        for i in 0..n {
    match w {
    let raw = java_calendar_week_of_year(date, week_params(m));
        assert_eq!(os_yearweek_number(d, 0), 199952);
                DataType::Int8
    let m = mode.rem_euclid(8) as u32;
        Self {
    }
        let n = args.number_rows;
//! default mode 0 (Sunday-first). Both UDFs share the per-mode week math (`os_week_number`):
udf_identity!(OsYearweekUdf, "os_yearweek");
udf_identity!(OsWeekUdf, "os_week");
/// Year that owns the week. Decrements for early-January dates that belong to the
impl OsWeekUdf {
/// per-mode week number is 0 so the date is re-counted in the prior year's frame.
    #[test]
    let mode_resolved = if os_week_number(date, mode) != 0 {
use chrono::{Datelike, NaiveDate, Weekday};
    fn return_type(&self, arg_types: &[DataType]) -> Result<DataType> {
            .as_any()
    let year = date.year();
            let date = NaiveDate::from_num_days_from_ce_opt(days + 719_163).ok_or_else(|| {
use datafusion::logical_expr::{
        let jan1_1900 = NaiveDate::from_ymd_opt(1900, 1, 1).unwrap();
            1
 * The OpenSearch Contributors require contributions made to
                None => 0,
                return plan_err!("os_week: arg 0 expected date/timestamp/string, got {other:?}")
    ColumnarValue, ScalarFunctionArgs, ScalarUDF, ScalarUDFImpl, Signature, Volatility,
                    return plan_err!("os_yearweek: arg 1 expected integer mode, got {other:?}")
        }
    pub fn new() -> Self {
impl OsYearweekUdf {
        Ok(out)
/// MySQL `WEEK()` modes 0..7. Modes 0/1/4/5 wrap early-January dates to week 0;
                continue;
 * compatible open source license.
                DataType::Int8
            | DataType::Timestamp(_, _)
        let n = args.number_rows;
        let mut out = Vec::with_capacity(arg_types.len());
//! - `os_week(date [, mode])` → the MySQL week number.
 *
}
            );
}
    } else {
        7
        }
    }
            other => {
            (days / 7) as u32 + 1
fn week1_start(year: i32, start: Weekday, min_days: u32) -> NaiveDate {
        Weekday::Fri => 4,
    if raw > 51 && date.day() < 7 && matches!(m, 0 | 1 | 4 | 5) {
        let d = NaiveDate::from_ymd_opt(1900, 1, 1).unwrap();
            }
            assert_eq!(os_week_number(*d, *mode), *want, "date={d}, mode={mode}");
        assert_eq!(os_yearweek_number(jan1_1900, 4), 190001);
//! MySQL `WEEK()` / `YEARWEEK()` semantics (modes 0..7), used by PPL's `WEEK` / `WEEK_OF_YEAR`
            (4, 190001),
        &self.signature
    let first = if mode % 2 == 0 {
            other => {
        let cases: &[(NaiveDate, i32, u32)] = &[
        let d = NaiveDate::from_ymd_opt(2003, 10, 3).unwrap();
        Ok(ColumnarValue::Array(Arc::new(builder.finish()) as ArrayRef))
        assert_eq!(os_yearweek_number(dec30_1899, 4), 189952);
        Weekday::Sun
            let mode = match &mode_arg {
            signature: Signature::user_defined(Volatility::Immutable),
        let d = NaiveDate::from_ymd_opt(2000, 1, 1).unwrap();
            (1, 190001),
            Some(args.args[1].clone().into_array(n)?)
        (days / 7) as u32 + 1
};
            }
            }
        2
        let dates = date_arg
    let raw = java_calendar_week_of_year(date, week_params(m));
        }
                )
            None
    }
        Weekday::Sat => 5,
            | DataType::LargeUtf8
    fn os_week_table_from_test_source() {
//!
        ];
#[derive(Debug)]
fn week_params(mode: u32) -> (Weekday, u32) {
            .downcast_ref::<datafusion::arrow::array::Date32Array>()
            if dates.is_null(i) {
            (5, 190001),
            .as_any()
    ctx.register_udf(ScalarUDF::from(OsWeekUdf::new()));
    let m = mode.rem_euclid(8) as u32;
        let dec30_1899 = NaiveDate::from_ymd_opt(1899, 12, 30).unwrap();
                Some(arr) if arr.is_null(i) => 0,
                datafusion::error::DataFusionError::Execution(format!(
                builder.append_null();
    (first, min_days)
        _ => 7,
#[derive(Debug)]
        "os_week"
impl ScalarUDFImpl for OsYearweekUdf {
        Weekday::Sun => 6,
            let days = (date - this_w1).num_days();
                    .value(i),
            return plan_err!(
/// prior year's last week.
                | DataType::UInt32
            (2, 189953),
    if date < this_w1 {
                continue;
            None
            })?;
        match &arg_types[0] {
    let week = os_week_number(date, mode_resolved);
//! - `os_yearweek(date [, mode])` → `year * 100 + week`, with MySQL's year-boundary roll.
pub fn register_all(ctx: &SessionContext) {
    } else if mode.rem_euclid(8) <= 4 {
        ];
    }
 */
                ))
                }
        } else {
        if date >= next_w1 {
use std::sync::Arc;
            (7, 190001),
    fn os_yearweek_rolls_year_at_boundary() {
                | DataType::Int16
                builder.append_null();
/*
            let date = NaiveDate::from_num_days_from_ce_opt(days + 719_163).ok_or_else(|| {
            | DataType::Timestamp(_, _)
                None => 0,
            (NaiveDate::from_ymd_opt(2008, 2, 20).unwrap(), 1, 8),
        Weekday::Thu => 3,
            })?;
        if arg_types.is_empty() || arg_types.len() > 2 {
            | DataType::LargeUtf8
        assert_eq!(os_yearweek_number(jan1_1900, 0), 189953);
            (3, 190001),
                | DataType::UInt64 => out.push(DataType::Int32),
        };
    fn name(&self) -> &str {
                    "os_week: invalid Date32 day count {days}"
                return plan_err!(
            return plan_err!("os_week expects 1 or 2 arguments, got {}", arg_types.len());
        Weekday::Mon
        if arg_types.is_empty() || arg_types.len() > 2 {
            return plan_err!(
    #[test]
fn os_year_number(date: NaiveDate, mode: i32) -> i32 {
    }
    }
    }
    fn invoke_with_args(&self, args: ScalarFunctionArgs) -> Result<ColumnarValue> {
        assert_eq!(os_yearweek_number(d, 3), 200340);
            if dates.is_null(i) {
            DataType::Date32
        "os_yearweek"
        let days = (date - prev_w1).num_days();
                Some(arr) => arr
}
}
        let mode_arg = if args.args.len() == 2 {
/// Days from `from` back to the most recent `start` weekday.
                )
    use super::*;
        jan1 + chrono::Duration::days((7 - back) as i64)
    #[test]
                | DataType::UInt32
        for (d, mode, want) in cases {
        let mut builder = Int32Builder::with_capacity(n);
 * this file be licensed under the Apache-2.0 license or a
    fn coerce_types(&self, arg_types: &[DataType]) -> Result<Vec<DataType>> {
/// Java `Calendar.WEEK_OF_YEAR` under `(firstDayOfWeek, minimalDaysInFirstWeek)`.
            Some(args.args[1].clone().into_array(n)?)
            return plan_err!("os_week expects 1 or 2 arguments, got {}", arg_types.len());
    let jan1 = NaiveDate::from_ymd_opt(year, 1, 1).unwrap();
}
    }
        let mut builder = Int32Builder::with_capacity(n);
        // From CalciteDateTimeFunctionIT.testYearWeek: yearweek('2003-10-03')=200339,
                    .as_primitive::<datafusion::arrow::datatypes::Int32Type>()
                | DataType::UInt16
        let dates = date_arg
use datafusion::arrow::datatypes::DataType;
    if raw > 51 && date.day() < 7 {
        let mut out = Vec::with_capacity(arg_types.len());
                | DataType::UInt16
        let prev_w1 = week1_start(year - 1, start, min_days);
                | DataType::Int64
    }
        // 2000-01-01 (Sat), mode 0 → week 0 → bumps to mode 2 → prior year's last week (1999-52).
            let days = dates.value(i);
            | DataType::Date64
        date.year() - 1
            }
                    "os_week: arg 0 not coerced to Date32".to_string(),
            })?;
            | DataType::Utf8
    }
    } else {
            | DataType::Utf8View => out.push(DataType::Date32),
                other => return plan_err!("os_week: arg 1 expected integer mode, got {other:?}"),
            | DataType::Date64
        for (mode, want) in expected {
        1 | 3 => 5,
                | DataType::Int64
                arg_types.len()
        }
        if arg_types.len() == 2 {
    }
            };
        if arg_types.len() == 2 {
    let this_w1 = week1_start(year, start, min_days);
    #[test]
                    "os_yearweek: invalid Date32 day count {days}"
    }
    fn signature(&self) -> &Signature {
 * SPDX-License-Identifier: Apache-2.0
            (NaiveDate::from_ymd_opt(2000, 1, 1).unwrap(), 0, 0),
            .ok_or_else(|| {
}
fn java_calendar_week_of_year(date: NaiveDate, (start, min_days): (Weekday, u32)) -> u32 {
        }
}
        }
            builder.append_value(os_week_number(date, mode) as i32);
        }
            (NaiveDate::from_ymd_opt(2000, 1, 1).unwrap(), 2, 52),
