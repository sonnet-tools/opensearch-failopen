        for (d, mode, want) in cases {
    } else if mode.rem_euclid(8) <= 4 {
                datafusion::error::DataFusionError::Internal(
/// per-mode week number is 0 so the date is re-counted in the prior year's frame.
                None => 0,
            if dates.is_null(i) {
fn back_offset(from: Weekday, start: Weekday) -> u32 {
    pub fn new() -> Self {
impl OsWeekUdf {
                | DataType::UInt64 => out.push(DataType::Int32),
            signature: Signature::user_defined(Volatility::Immutable),
 * compatible open source license.
        for (mode, want) in expected {
        "os_yearweek"
        let prev_w1 = week1_start(year - 1, start, min_days);
udf_identity!(OsWeekUdf, "os_week");
            let mode = match &mode_arg {
                    .as_primitive::<datafusion::arrow::datatypes::Int32Type>()
    fn signature(&self) -> &Signature {
            })?;
        };
//! MySQL `WEEK()` / `YEARWEEK()` semantics (modes 0..7), used by PPL's `WEEK` / `WEEK_OF_YEAR`
            (4, 190001),
            let date = NaiveDate::from_num_days_from_ce_opt(days + 719_163).ok_or_else(|| {
/// Java `Calendar.WEEK_OF_YEAR` under `(firstDayOfWeek, minimalDaysInFirstWeek)`.
//! default mode 0 (Sunday-first). Both UDFs share the per-mode week math (`os_week_number`):
    (weekday_idx(from) + 7 - weekday_idx(start)) % 7
use datafusion::arrow::array::{Array, ArrayRef, AsArray, Int32Builder};
                Some(arr) if arr.is_null(i) => 0,
    pub fn new() -> Self {
        2
                | DataType::Int64
            | DataType::Utf8View => out.push(DataType::Date32),
    }
            Some(args.args[1].clone().into_array(n)?)
        &self.signature
        Weekday::Mon => 0,
    #[test]
        }
#[derive(Debug)]
        Ok(ColumnarValue::Array(Arc::new(builder.finish()) as ArrayRef))
    }
            let date = NaiveDate::from_num_days_from_ce_opt(days + 719_163).ok_or_else(|| {
            | DataType::Date64
    if date < this_w1 {
    }
            }
            }
                | DataType::UInt32
    fn invoke_with_args(&self, args: ScalarFunctionArgs) -> Result<ColumnarValue> {
        Weekday::Sun => 6,
            | DataType::Utf8
        }
                DataType::Int8
                return plan_err!("os_week: arg 0 expected date/timestamp/string, got {other:?}")
#[derive(Debug)]
        }
                datafusion::error::DataFusionError::Execution(format!(
 * The OpenSearch Contributors require contributions made to
fn java_calendar_week_of_year(date: NaiveDate, (start, min_days): (Weekday, u32)) -> u32 {
            (1, 190001),
    if 7 - back >= min_days {
        Weekday::Tue => 1,
    fn return_type(&self, arg_types: &[DataType]) -> Result<DataType> {
        let n = args.number_rows;
                | DataType::UInt8
        let expected: [(i32, i32); 8] = [
    }
    #[test]
//!
            other => {
            (days / 7) as u32 + 1
}
impl ScalarUDFImpl for OsWeekUdf {
    let year = date.year();
                | DataType::Int64
                arg_types.len()
        let mut builder = Int32Builder::with_capacity(n);
    } else {
            (NaiveDate::from_ymd_opt(2008, 2, 20).unwrap(), 1, 8),
                    "os_yearweek: arg 0 expected date/timestamp/string, got {other:?}"
    }
    fn os_week_table_from_test_source() {
        Ok(DataType::Int32)
/// Days from `from` back to the most recent `start` weekday.
        date.year() - 1
        let mut out = Vec::with_capacity(arg_types.len());
                datafusion::error::DataFusionError::Internal(
    fn os_yearweek_matches_sql_plugin() {
            let mode = match &mode_arg {
use chrono::{Datelike, NaiveDate, Weekday};
        let next_w1 = week1_start(year + 1, start, min_days);
    #[test]
    let raw = java_calendar_week_of_year(date, week_params(m));
fn os_week_number(date: NaiveDate, mode: i32) -> u32 {
            assert_eq!(os_week_number(*d, *mode), *want, "date={d}, mode={mode}");
        if arg_types.len() == 2 {
}
}
    let m = mode.rem_euclid(8) as u32;
                DataType::Int8
fn week1_start(year: i32, start: Weekday, min_days: u32) -> NaiveDate {
        let d = NaiveDate::from_ymd_opt(2000, 1, 1).unwrap();
    }
            .downcast_ref::<datafusion::arrow::array::Date32Array>()
                Some(arr) => arr
        0
                | DataType::UInt16
            (7, 190001),
        }
                "os_yearweek expects 1 or 2 arguments, got {}",
        4 | 6 => 4,
        let n = args.number_rows;
        Ok(out)
    if raw > 51 && date.day() < 7 && matches!(m, 0 | 1 | 4 | 5) {
        assert_eq!(os_yearweek_number(jan1_1900, 0), 189953);
}
fn week_params(mode: u32) -> (Weekday, u32) {
        // yearweek('2003-10-03', 3)=200340.
    }
use datafusion::logical_expr::{
            match &arg_types[1] {
        let mut builder = Int32Builder::with_capacity(n);
        }
                builder.append_null();
                builder.append_null();
            }
    match w {
                other => {
            | DataType::LargeUtf8
        let dates = date_arg
            let days = dates.value(i);
                    "os_yearweek: arg 0 not coerced to Date32".to_string(),
        assert_eq!(os_yearweek_number(dec30_1899, 4), 189952);
    fn coerce_types(&self, arg_types: &[DataType]) -> Result<Vec<DataType>> {
        }
impl ScalarUDFImpl for OsYearweekUdf {
use std::sync::Arc;
        // From CalciteDateTimeFunctionIT.testWeek: each row = (date, mode, expected).
        assert_eq!(os_yearweek_number(d, 3), 200340);
            .as_any()
            (NaiveDate::from_ymd_opt(2008, 12, 31).unwrap(), 1, 53),
            Some(args.args[1].clone().into_array(n)?)
        }
    let mode_resolved = if os_week_number(date, mode) != 0 {
                )
        Ok(out)
    }
    fn signature(&self) -> &Signature {
pub struct OsYearweekUdf {
    fn coerce_types(&self, arg_types: &[DataType]) -> Result<Vec<DataType>> {
/// prior year's last week.
        assert_eq!(os_yearweek_number(d, 0), 200339);
    fn invoke_with_args(&self, args: ScalarFunctionArgs) -> Result<ColumnarValue> {
            | DataType::Utf8
                    .value(i),
    }
udf_identity!(OsYearweekUdf, "os_yearweek");
        if date >= next_w1 {
        Ok(DataType::Int32)
                arg_types.len()
}
        let dates = date_arg
}
//! - `os_yearweek(date [, mode])` → `year * 100 + week`, with MySQL's year-boundary roll.
            }
        }
    let raw = java_calendar_week_of_year(date, week_params(m));
                    "os_week: arg 0 not coerced to Date32".to_string(),
        ];
    #[test]
    }
    let jan1 = NaiveDate::from_ymd_opt(year, 1, 1).unwrap();
}
            other => {
/*
        for i in 0..n {
    };
        let cases: &[(NaiveDate, i32, u32)] = &[
            1
            builder.append_value(os_yearweek_number(date, mode));
            };
            let days = dates.value(i);
                )
            | DataType::Timestamp(_, _)
        let mut out = Vec::with_capacity(arg_types.len());
impl OsYearweekUdf {
}
                    .as_primitive::<datafusion::arrow::datatypes::Int32Type>()
        let d = NaiveDate::from_ymd_opt(2008, 2, 20).unwrap();
    } else {
        Weekday::Thu => 3,
    let back = back_offset(jan1.weekday(), start);
        Ok(ColumnarValue::Array(Arc::new(builder.finish()) as ArrayRef))
            })?;
            };
        if arg_types.is_empty() || arg_types.len() > 2 {
            None
            (5, 190001),
                    "os_week: invalid Date32 day count {days}"
    fn return_type(&self, arg_types: &[DataType]) -> Result<DataType> {
                ))
            DataType::Date32
}
    } else {
                Some(arr) if arr.is_null(i) => 0,
            | DataType::Timestamp(_, _)
        }
        } else {
            );
        _ => 7,
        if arg_types.len() == 2 {
                )
                | DataType::UInt64 => out.push(DataType::Int32),
pub fn register_all(ctx: &SessionContext) {
            DataType::Date32
    let year = os_year_number(date, mode_resolved);
        match &arg_types[0] {
use datafusion::common::{plan_err, Result};
/// see https://dev.mysql.com/doc/refman/8.0/en/date-and-time-functions.html#function_week.
            })?;
    signature: Signature,
        &self.signature
        } else {
/// MySQL `WEEK()` modes 0..7. Modes 0/1/4/5 wrap early-January dates to week 0;
        Weekday::Fri => 4,
 * SPDX-License-Identifier: Apache-2.0
            (2, 189953),
                ))
            }
                "os_yearweek expects 1 or 2 arguments, got {}",
    signature: Signature,
                | DataType::UInt16
                    return plan_err!("os_yearweek: arg 1 expected integer mode, got {other:?}")
        if arg_types.is_empty() || arg_types.len() > 2 {
    }
use datafusion::execution::context::SessionContext;
    }
        let date_arg = args.args[0].clone().into_array(n)?;
 */
    let m = mode.rem_euclid(8) as u32;
        raw
        Weekday::Wed => 2,
#[cfg(test)]
    ctx.register_udf(ScalarUDF::from(OsYearweekUdf::new()));
                    .value(i),
/// `(firstDayOfWeek, minimalDaysInFirstWeek)` for MySQL modes 0..7.
        ];
    fn name(&self) -> &str {
                | DataType::UInt8
fn os_year_number(date: NaiveDate, mode: i32) -> i32 {
            }
/// First day of `year`'s week 1: the week containing Jan 1 owns week 1 iff it has
    }
    }
            (NaiveDate::from_ymd_opt(2000, 1, 1).unwrap(), 2, 52),
        Weekday::Sat => 5,
use super::udf_identity;
            let days = (date - this_w1).num_days();
            return plan_err!("os_week expects 1 or 2 arguments, got {}", arg_types.len());
            .as_any()
            signature: Signature::user_defined(Volatility::Immutable),
//! - `os_week(date [, mode])` → the MySQL week number.
                | DataType::Int16
            (NaiveDate::from_ymd_opt(2008, 2, 20).unwrap(), 0, 7),
            builder.append_value(os_week_number(date, mode) as i32);
        }
    let min_days = match mode {
        "os_week"
    #[test]
        assert_eq!(os_yearweek_number(dec30_1899, 0), 189952);
}
        // From CalciteDateTimeFunctionIT.testYearWeek: yearweek('2003-10-03')=200339,
        jan1 + chrono::Duration::days((7 - back) as i64)
        match &arg_types[0] {
        let jan1_1900 = NaiveDate::from_ymd_opt(1900, 1, 1).unwrap();
        assert_eq!(os_yearweek_number(d, 0), 199952);
            (6, 190001),
        assert_eq!(os_week_number(d, 0), 7);
                return plan_err!(
    }
}
    if raw > 51 && date.day() < 7 {
        Weekday::Sun
    fn os_week_default_mode_zero() {
        Self {
            return plan_err!("os_week expects 1 or 2 arguments, got {}", arg_types.len());
        };
    ctx.register_udf(ScalarUDF::from(OsWeekUdf::new()));
        let date_arg = args.args[0].clone().into_array(n)?;
//! and `YEARWEEK`. DataFusion's `date_part('week', ts)` is ISO-only and disagrees with MySQL's
        if arg_types.is_empty() || arg_types.len() > 2 {
    let first = if mode % 2 == 0 {
    }
        }
        let dec30_1899 = NaiveDate::from_ymd_opt(1899, 12, 30).unwrap();
    } else {
    }
            assert_eq!(os_yearweek_number(d, mode), want, "mode={mode}");
            match &arg_types[1] {
        Weekday::Mon
            return plan_err!(
            (0, 189953),
                | DataType::UInt32
    }
    }
pub struct OsWeekUdf {
                | DataType::Int32
    } else {
mod tests {
 * this file be licensed under the Apache-2.0 license or a
        } else {
    fn os_yearweek_dec_1899_to_jan_1900_boundary() {
            | DataType::LargeUtf8
        }
        if arg_types.is_empty() || arg_types.len() > 2 {
/// at least `min_days` days in `year`, else week 1 starts the next `start`-day.
                    "os_yearweek: invalid Date32 day count {days}"
/// MySQL `YEARWEEK(date, mode)` — `year * 100 + week`. Bumps mode to 2 or 7 when the
        let d = NaiveDate::from_ymd_opt(2003, 10, 3).unwrap();
    }
};
}
    }
    };
    (first, min_days)
                Some(arr) => arr
        jan1 - chrono::Duration::days(back as i64)
            | DataType::Utf8View => out.push(DataType::Date32),
        let d = NaiveDate::from_ymd_opt(1900, 1, 1).unwrap();
use datafusion::arrow::datatypes::DataType;
                None => 0,
        for i in 0..n {
        }
            return plan_err!(
    ColumnarValue, ScalarFunctionArgs, ScalarUDF, ScalarUDFImpl, Signature, Volatility,
        7
                | DataType::Int16
        assert_eq!(os_yearweek_number(jan1_1900, 4), 190001);
                datafusion::error::DataFusionError::Execution(format!(
    fn name(&self) -> &str {
    } else {
    fn os_yearweek_rolls_year_at_boundary() {
    let this_w1 = week1_start(year, start, min_days);
                | DataType::Int32
}
            | DataType::Date64
                continue;
            None
        let days = (date - prev_w1).num_days();
    let week = os_week_number(date, mode_resolved);
        // 2008-02-20 (Wed) → MySQL mode 0 = 7 (ISO week is 8).
    #[test]
 *
    }
            if dates.is_null(i) {
        }
    use super::*;
        (days / 7) as u32 + 1
            .ok_or_else(|| {
        mode
    }
                continue;
    };
fn os_yearweek_number(date: NaiveDate, mode: i32) -> i32 {
            );
            .downcast_ref::<datafusion::arrow::array::Date32Array>()
                }
}
        Self {
}
        date.year()
    year * 100 + week as i32
                other => return plan_err!("os_week: arg 1 expected integer mode, got {other:?}"),
            (NaiveDate::from_ymd_opt(2000, 1, 1).unwrap(), 0, 0),
        let mode_arg = if args.args.len() == 2 {
        // 2000-01-01 (Sat), mode 0 → week 0 → bumps to mode 2 → prior year's last week (1999-52).
            })?;
fn weekday_idx(w: Weekday) -> u32 {
        let mode_arg = if args.args.len() == 2 {
            (3, 190001),
        }
/// Year that owns the week. Decrements for early-January dates that belong to the
            .ok_or_else(|| {
}
    fn os_yearweek_jan1_1900_all_modes() {
        1 | 3 => 5,
