                    None => {
//! # Division of labor with the Java adapter
/// `to_offset(ts) - from_offset(ts)` milliseconds.
            return_field: Arc::new(datafusion::arrow::datatypes::Field::new(
use chrono::{DateTime, NaiveDateTime, Offset, TimeZone, Utc};
                    }
        if arg_types.len() != 3 {
        let udf = ConvertTzUdf::new();
pub fn register_all(ctx: &SessionContext) {
#[derive(Clone)]
            };
            return_field: Arc::new(datafusion::arrow::datatypes::Field::new(
                None
        // bad-literal input can't reach this UDF — a None from parse_tz on a
                DataType::Utf8,
            .coerce_types(&[
    Array, ArrayRef, TimestampMillisecondArray, TimestampMillisecondBuilder,
/// paths — Java canonicalizes — but defensive for degenerate scalar inputs).
//!
    #[test]
    }
///
            .map(StringArrayView::from_array)
                    .local_minus_utc(),
            .map(StringArrayView::from_array)
        assert_eq!(parse_offset_seconds("-13:59"), Some(-(13 * 3600 + 59 * 60)));
            // instant_utc_millis = wall_millis - from_offset_millis
    if let Some(off) = parse_offset_seconds(s) {
}
    }
        assert_eq!((summer_out - summer_ts) / 1000, 5 * 3600);
use datafusion::execution::context::SessionContext;
                        builder.append_null();
    fn coerce_types(&self, arg_types: &[DataType]) -> Result<Vec<DataType>> {
    fn parse_offset_rejects_malformed() {
}
    fn coerce_types_rejects_unsupported_ts_type() {
impl Default for ConvertTzUdf {
    }
//! * `ts` is interpreted as a wall-clock time in `from_tz`.
/// String-operand wrapper retained for direct-invocation tests that exercise
/// instant — DST-correct even across transitions.
            arg_fields: vec![],
            if to_scalar.is_none() && matches!(&args.args[2], ColumnarValue::Array(_)) {
                    }
        return s.and_then(parse_tz);
                None
                DataType::Utf8,
 * SPDX-License-Identifier: Apache-2.0
            } else {
    fn fixed_offset_to_fixed_offset_shifts_by_delta() {
fn parse_tz(s: &str) -> Option<TzSpec> {
            .as_any()
    #[test]
                "out",
        // 2024-01-05 in UTC (no DST there): NY winter = UTC-5, shift = +5h.
    let bytes = s.as_bytes();
        assert!(udf.coerce_types(&[DataType::Utf8]).is_err());
    shift_millis_parsed(ts_millis, &from, &to)
        // The Java adapter canonicalizes literal tz strings at plan time so
    match tz {
            .as_ref()
            _ => panic!("expected array"),
impl ScalarUDFImpl for ConvertTzUdf {
            "unexpected error: {msg}"
    }
}
    fn coerce_types_accepts_other_ts_precisions() {
                        continue;
            // (DST-fall-back) wall times, which matches MySQL's behaviour.
                    builder.append_null();
            &[CoerceMode::TimestampMs, CoerceMode::Utf8, CoerceMode::Utf8],
        assert!(arr.is_null(1));
    fn unknown_tz_returns_none() {
    fn parse_offset_enforces_mysql_band() {
        let msg = format!("{err}");
            .unwrap();
        TzSpec::Iana(z) => {
        assert_eq!(shift_millis(0, "Not/AZone", "UTC"), None);
        let arr = arr
        assert!(arr.is_null(3), "to=+14:01 (out-of-band) must yield NULL");
        let udf = ConvertTzUdf::new();
            .coerce_types(&[DataType::Date32, DataType::Utf8, DataType::Utf8])
        let winter_out = shift_millis(winter_ts, "America/New_York", "UTC").unwrap();
    }
    }
}
                        builder.append_null();
        let mut builder = TimestampMillisecondBuilder::with_capacity(n);
    fn parse_offset_accepts_positive_and_negative() {
            ColumnarValue::Array(a) => a,
    // Column-valued tz strings can't be validated plan-side, so the UDF must
fn offset_seconds_at_instant(tz: &TzSpec, ts_millis: i64, from_offset_seconds: i32) -> Option<i32> {
    fn coerce_types_rejects_wrong_arity() {
                DataType::Utf8
        Ok(DataType::Timestamp(TimeUnit::Millisecond, None))
    }
        let summer_ts = 1_720_180_800_000;
        return None;
/*
        ]);
        let from_array: Option<StringArrayView<'_>> = from_arr_ref
    #[test]
//!
        let ts = ts
    }
    }
            return plan_err!("convert_tz expects 3 arguments, got {}", arg_types.len());
    Some(sign * (hours * 3600 + minutes * 60))
        }
//!     `+5:00`; JDK-normalized IANA ids).
    }
        assert_eq!(parse_offset_seconds("+15:00"), None);
            _ => panic!("expected array"),
    let hours: i32 = s.get(1..3)?.parse().ok()?;
        let to = StringArray::from(vec![
        ]);
        b'-' => -1,
                DataFusionError::Internal(format!(
            // Use .from_local_datetime → pick the earliest resolution for ambiguous
            match z.from_local_datetime(naive) {
                opt.as_deref()
};
                    Some(tz) => tz,
        // literal), Date32, or Timestamp(any precision, any tz). Signature::exact
        let n = args.number_rows;
        };
    #[test]
    #[test]
            };
        assert_eq!(out, vec![ts, DataType::Utf8, DataType::Utf8]);
            Some("UTC"),
            .coerce_types(&[DataType::Boolean, DataType::Utf8, DataType::Utf8])
        }
    fn invoke_nulls_and_bad_tz_propagate() {
        let udf = ConvertTzUdf::new();
        let out = udf.invoke_with_args(args).unwrap();
    // IANA ↔ IANA: DST-correct jump across a transition.
fn shift_millis_parsed(ts_millis: i64, from: &TzSpec, to: &TzSpec) -> Option<i64> {
        return None;
        let udf = ConvertTzUdf::new();
                (Some(tz), _) => tz.clone(),
        // this catches the column-valued path.
        Self::new()
        assert_eq!(parse_offset_seconds("+14:00"), Some(14 * 3600));
#[derive(Debug, PartialEq, Eq, Hash)]
                },
    fn name(&self) -> &str {
    // ±HH:MM offsets parse to the expected second counts.
            .unwrap();
}
fn shift_millis(ts_millis: i64, from_tz: &str, to_tz: &str) -> Option<i64> {
            ],
    if total_minutes > max_minutes {
        let ts = 1_704_456_000_000; // treat as 2024-01-05T12:00:00 naive
//! * The return is the wall-clock time in `to_tz` for the same instant.
    fn signature(&self) -> &Signature {
                builder.append_null();
            .unwrap();
            .coerce_types(&[ts.clone(), DataType::Utf8, DataType::Utf8])
    use super::*;
/// (`ConvertTzAdapter::canonicalizeTz`) folds out-of-band literals to NULL at
    signature: Signature,
#[cfg(test)]
    let to_off = offset_seconds_at_instant(to, ts_millis, from_off)?;
        TzSpec::Offset(o) => Some(*o),
            if ts.is_null(i) {
                _ => {
                ColumnarValue::Array(Arc::new(ts)),
    let naive = DateTime::<Utc>::from_timestamp_millis(ts_millis)?.naive_utc();
    fn invoke_with_args(&self, args: ScalarFunctionArgs) -> Result<ColumnarValue> {
/// plan time; this defensive check covers column-valued tz strings, where a
        assert_eq!(parse_offset_seconds("-17:00"), None);
        // 2024-07-05T12:00:00 (summer): NY (UTC-4) → London (UTC+1) → +5h.
fn parse_offset_seconds(s: &str) -> Option<i32> {
}
        "convert_tz"
        Self {
        let err = udf
    #[test]
/// If `cv` is a non-NULL string scalar, parse it once. Returns None for NULL,
        let arr = arr
//! runs at plan time:
    // When from_tz crosses DST boundary but to_tz doesn't, the delta changes.
        };
        let to_arr_ref: Option<ArrayRef> =
            Some("+14:01"), // just past positive cap
        let arr = match out {
    let sign = match bytes[0] {
        let to = StringArray::from(vec![Some("+05:30"), Some("UTC"), Some("UTC")]);
                DataType::Utf8,
    let minutes: i32 = s.get(4..6)?.parse().ok()?;
/// stored timestamp has no tz attached — interpret its wall clock in `from`,
use datafusion::logical_expr::{
        let to_scalar = scalar_tz(&args.args[2]);
/// Parse `±HH:MM` → seconds east of UTC; None if not an offset literal.
        let ts = TimestampMillisecondArray::from(vec![
                None => builder.append_null(),
        let arr = match out {
    Offset(i32),
        let udf = ConvertTzUdf::new();
    // +14:01) and well-outside ones (+15:00) must collapse to NULL.
    }
        ]);
        TzSpec::Iana(z) => {
            vec![
                Some(args.args[1].clone().into_array(n)?)
            Some(1_704_456_000_000),
            config_options: Arc::new(datafusion::config::ConfigOptions::new()),
    match tz {
    fn return_type(&self, arg_types: &[DataType]) -> Result<DataType> {
 * The OpenSearch Contributors require contributions made to
    None
mod tests {
        let winter_ts = 1_704_456_000_000;
                    Some(tz) => tz,
        assert_eq!(parse_offset_seconds("bogus"), None);
            }
    if minutes > 59 {
                    "convert_tz: expected TimestampMillisecond, got {:?}",
    #[test]
    }
            )
use datafusion::arrow::datatypes::{DataType, TimeUnit};
fn offset_seconds_at(tz: &TzSpec, naive: &NaiveDateTime) -> Option<i32> {
        let winter_out = shift_millis(winter_ts, "America/New_York", "Europe/London").unwrap();
// ─── tests ──────────────────────────────────────────────────────────────────
        }
    fn coerce_types_accepts_date32_ts() {
    let to = parse_tz(to_tz)?;
    let from_off = offset_seconds_at(from, &naive)?;
        let s = match sv {
/// value the caller can continue to treat as naive. The shift is exactly
        let from_arr_ref: Option<ArrayRef> =
                    continue;
            ],
            .unwrap();
        // TzSpec is already in hand. Keep the ArrayRef alive alongside the
}
                        continue;
//!   * identity cases (`from == to`) are short-circuited plan-side and never
 * compatible open source license.
    }
        )
                DataType::Timestamp(TimeUnit::Millisecond, None),
/// `ts_millis` is a wall clock in from_tz), then look up to_tz's offset at that
//!     `CONVERT_TZ` behavior).
            let to = match (&to_scalar, to_array.as_ref().and_then(|a| a.cell(i))) {
    };
            out,
                }
            match shift_millis_parsed(ts.value(i), &from, &to) {
                    .fix()
        assert!(udf
        // Fast-path: scalar tz operands are parsed once up front, not per row.
        assert_eq!(shift_millis(0, "UTC", "Not/AZone"), None);
        return None;
//!   of the form `±HH:MM` with hours ∈ [0,14], minutes ∈ [0,59].
        };
//!   * **Column-valued tz operands.** Values aren't known until runtime;
}
        assert_eq!(parse_offset_seconds("0500"), None);
            Some(1_704_456_000_000),
/// Offset (seconds east of UTC) for `from_tz` at wall-clock `naive`.
        // 2024-01-05T12:00:00 (winter): NY→London → +5h.
        // Summer: NY is UTC-4, winter: NY is UTC-5. Pull data at both dates,
            ]
                chrono::LocalResult::Ambiguous(dt, _) => Some(dt.offset().fix().local_minus_utc()),
                }
use datafusion::common::{plan_err, ScalarValue};
    #[test]
//!     reach this UDF.
        let out = udf
//! * Any null input → null output (null propagation).
        _ => return None,
        // Well outside.
        // Boundary OKs.
                Some(args.args[2].clone().into_array(n)?)
}
        let udf = ConvertTzUdf::new();
                ColumnarValue::Array(Arc::new(from)),
/// non-scalar, or an unparseable string (the latter unreachable from literal
        let out = udf
            ColumnarValue::Array(a) => a,
        // Out-of-band offsets — Java folds these to NULL at plan time;
            args: vec![
                DataType::Timestamp(TimeUnit::Nanosecond, Some("UTC".into())),
    }
            }
                continue;
            .downcast_ref::<TimestampMillisecondArray>()
        let to_array: Option<StringArrayView<'_>> = to_arr_ref
        // view — StringArrayView borrows from the underlying buffer.
        }
        let out = shift_millis(ts, "+00:00", "+05:30").unwrap();
            return plan_err!("convert_tz expects 3 arguments, got {}", args.args.len());
        // Only materialize column-valued tz operands; for scalars the parsed
        let summer_ts = 1_720_180_800_000; // 2024-07-05T12:00:00Z naive
    use datafusion::arrow::array::StringArray;
};
            } else {
            number_rows: 4,
        &self.signature
impl ConvertTzUdf {
    }
//! Semantics (MySQL-compatible):
            number_rows: 3,
/// Shift `ts_millis` from `from` to `to` using pre-parsed [`TzSpec`]s. The
                    ts.data_type()
            if from_scalar.is_none() && matches!(&args.args[1], ColumnarValue::Array(_)) {
            )),
            Some("-14:00"), // just past negative cap
    fn invoke_out_of_band_offset_strings_yield_nulls() {
        assert_eq!(parse_offset_seconds("+14:01"), None);
            Some("+00:00"),
}
        let out = udf
            "convert_tz",
                true,
        // only let through the Timestamp(Ms, None) variant; user_defined +
            };
            .unwrap_err();
        let from_scalar = scalar_tz(&args.args[1]);
        }
        assert!(arr.is_null(2));
//! `ConvertTzAdapter` (see `.../be/datafusion/ConvertTzAdapter.java`), which
        let ts = args.args[0].clone().into_array(n)?;
            )),
            };
    }
        assert_eq!(parse_offset_seconds("-14:00"), None);
        // scalar therefore means the scalar was SQL NULL.
    let delta_millis = (to_off - from_off) as i64 * 1_000;
        };
            let from = match (&from_scalar, from_array.as_ref().and_then(|a| a.cell(i))) {
                DataType::Timestamp(TimeUnit::Millisecond, None),
    }
//!   * **Per-row DST-correct shifting.** IANA offsets vary per instant; can't
        assert!(arr.is_null(2), "from=+15:00 (out-of-band) must yield NULL");
        for i in 0..n {
            Some("+00:00"),
        assert!(arr.is_null(1), "from=-14:00 (out-of-band) must yield NULL");
    pub fn new() -> Self {
        // Same delta because both shift to/from their summer offsets in lockstep.
        let ts = DataType::Timestamp(TimeUnit::Millisecond, None);
                (Some(tz), _) => tz.clone(),
/// Offset (seconds east of UTC) for `to_tz` at the UTC *instant* represented by
    #[test]
    /// Fixed offset in seconds east of UTC.
                z.offset_from_utc_datetime(&instant.naive_utc())
    fn iana_to_utc_crosses_dst_in_source_tz() {
            Some(
    #[test]
//!     be folded at plan time.
            _ => None,
use std::sync::Arc;
        assert_eq!((summer_out - summer_ts) / 1000, 4 * 3600);
    #[test]
        // 2024-01-05T12:00:00 in +00:00 → same wall clock in +05:30 means
    }
/// the input. We reconstruct the instant from `ts_millis` + `from_offset` (since
use super::{coerce_args, CoerceMode};
            .coerce_types(&[
//! What stays here:
        assert_eq!(out[0], DataType::Timestamp(TimeUnit::Millisecond, None));
            Some(1_704_456_000_000),
            Some("+00:00"),
/// Parse timezone string (IANA name or `±HH:MM` offset).
                    builder.append_null();
        TzSpec::Offset(o) => Some(*o),
    // null them out at row time. Both just-outside-the-band entries (-14:00,
                ColumnarValue::Array(Arc::new(from)),
    #[test]
                chrono::LocalResult::None => None, // wall time in the DST "spring-forward" gap
    // or Timestamp with a different precision/tz. coerce_types should
    }
        let args = ScalarFunctionArgs {
    ColumnarValue, ScalarFunctionArgs, ScalarUDF, ScalarUDFImpl, Signature, Volatility,
    // cap at -13:59. Matches legacy DateTimeUtils.isValidMySqlTimeZoneId.
}
        let winter_ts = 1_704_456_000_000;
    }
use super::json_common::StringArrayView;
        if args.args.len() != 3 {
/// behavior.
 * this file be licensed under the Apache-2.0 license or a
    let from = parse_tz(from_tz)?;
//!
    }
            .as_any()
    let total_minutes = hours * 60 + minutes;
            .ok_or_else(|| {
            .downcast_ref::<TimestampMillisecondArray>()
            .as_ref()
        let from = StringArray::from(vec![
        assert_eq!(parse_offset_seconds("+05:30"), Some(5 * 3600 + 30 * 60));
        ]);
            })?;
                DataType::Utf8,
    // normalize them all to Timestamp(Millisecond, None) + Utf8 + Utf8.
        assert_eq!(parse_offset_seconds("+05:60"), None);
            .transpose()?;
            .coerce_types(&[DataType::Utf8, DataType::Utf8, DataType::Utf8])
        b'+' => 1,
fn scalar_tz(cv: &ColumnarValue) -> Option<TzSpec> {
    if bytes[3] != b':' {
    // Offset → offset: simple wall-clock delta, no calendar.
    if bytes.len() != 6 {
                    continue;
    // Batch / null handling through the full UDF.
        // Nanosecond with tz → should coerce down to Millisecond, None.
    s.parse::<Tz>().ok().map(TzSpec::Iana)
enum TzSpec {
                DataType::Utf8,
/// with `DateTimeUtils.isValidMySqlTimeZoneId`). The Java adapter
        // 2024-01-05T12:00:00 wall-clock in America/New_York (UTC-5 in winter)
            ])
        assert_eq!((out - ts) / 1000, 5 * 3600);
        let ts = TimestampMillisecondArray::from(vec![Some(1_704_456_000_000), None, Some(0)]);
        assert_eq!((winter_out - winter_ts) / 1000, 5 * 3600);
//! * Timezone strings may be IANA names (`'America/New_York'`) or ISO offsets
    }
        let args = ScalarFunctionArgs {
        };
        assert_eq!(parse_offset_seconds("+00:00"), Some(0));
 *
//! `convert_tz(ts, from_tz, to_tz)` — shift a timestamp from one timezone to another.
        let out = udf.invoke_with_args(args).unwrap();
        // PPL emits `convert_tz(ts, from, to)` with ts typed as Utf8 (string
        let out = shift_millis(ts, "America/New_York", "Europe/London").unwrap();
                true,
        );
            signature: Signature::user_defined(Volatility::Immutable),
}
    // Coercion: PPL may emit the ts arg as Utf8 (string literal), Date32,
        Ok(ColumnarValue::Array(Arc::new(builder.finish()) as ArrayRef))
            let instant = DateTime::<Utc>::from_timestamp_millis(instant_millis)?;
    }
        // coerce_types lets DF insert the right casts.
                _ => {
pub struct ConvertTzUdf {
        // → 17:00 UTC → London (UTC+0 in winter) = 17:00 local. Delta = +5h.
/// the full parse + shift flow in one call.
    }
        // the expected distinct deltas.
        let out = udf
            arg_fields: vec![],
        assert_eq!(
            .unwrap();
        return None;
    #[test]
                    None => {
/// malformed entry yields a NULL row and matches the documented lenient
                DataType::Utf8,
            .unwrap();
            .downcast_ref::<TimestampMillisecondArray>()
//! * Unparseable column-valued timezone → null output.
    fn iana_new_york_to_london_applies_correct_offset() {
            Some("+15:00"), // well past positive cap
            }
        // 2024-07-05: NY summer = UTC-4, shift = +4h.
            .as_any()
}
        assert_eq!(out - ts, 5 * 3600 * 1000 + 30 * 60 * 1000);
    #[test]
        // Just outside.
        let from = StringArray::from(vec![
        assert!(
/// render that instant in `to`, then return the shifted millis as a tz-free
        // confirm the two shifts to UTC (London+0 in winter, +1 in summer) produce
            Some("Mars/Olympus"), // unknown column-valued entry → null
    fn coerce_types_accepts_utf8_ts() {
                (None, Some(s)) => match parse_tz(s) {
    fn default() -> Self {
                ColumnarValue::Array(Arc::new(ts)),
            arg_types,
        coerce_args(
        assert_eq!(parse_offset_seconds("+14:00"), Some(14 * 3600));
                ColumnarValue::Array(Arc::new(to)),
                "out",
        assert_eq!((winter_out - winter_ts) / 1000, 5 * 3600);
        let summer_out = shift_millis(summer_ts, "America/New_York", "UTC").unwrap();
    // MySQL's CONVERT_TZ band: positive offsets cap at +14:00, negative offsets
}
        let ts = 1_704_456_000_000; // 2024-01-05T12:00:00Z (stored naive)
        let summer_out = shift_millis(summer_ts, "America/New_York", "Europe/London").unwrap();
use datafusion::error::{DataFusionError, Result};
            .is_err());
            ScalarValue::Utf8(opt) | ScalarValue::LargeUtf8(opt) | ScalarValue::Utf8View(opt) => {
                },
    }
//! Literal validation + canonicalization happens Java-side in
        // A boolean in the ts slot is clearly wrong — must error explicitly.
//!     unparseable entries yield NULL rows (matches MySQL's lenient
    }
    }
    #[test]
    Iana(Tz),
            Some("+00:00"),
            Some("+00:00"),
                chrono::LocalResult::Single(dt) => Some(dt.offset().fix().local_minus_utc()),
    fn iana_dst_summer_offset_differs_from_winter() {
 */
    if let ColumnarValue::Scalar(sv) = cv {
#[cfg(test)]
    let max_minutes = if sign < 0 { 13 * 60 + 59 } else { 14 * 60 };
        assert!(!arr.is_null(0));
    }
                ))
    #[test]
        assert!(!arr.is_null(0), "in-band +14:00 must produce a value");
            ])
        let udf = ConvertTzUdf::new();
                ColumnarValue::Array(Arc::new(to)),
            .transpose()?;
//!     `IllegalArgumentException` at plan time — users see the error instantly.
    ts_millis.checked_add(delta_millis)
use chrono_tz::Tz;
                DataType::Utf8,
        // +5h30m = +19_800_000 ms added.
        assert_eq!(parse_offset_seconds("-08:00"), Some(-8 * 3600));
use datafusion::arrow::array::{
//!   * literal tz operands arrive here already canonicalized (`+05:00`, not
//!   * bad literals (unknown IANA, malformed offset) surface as
            Some(1_704_456_000_000),
                Some(v) => builder.append_value(v),
        let udf = ConvertTzUdf::new();
            Some("+14:00"), // boundary OK
        assert_eq!(out[0], DataType::Timestamp(TimeUnit::Millisecond, None));
/// Bounds match MySQL's `CONVERT_TZ` band: `[-13:59, +14:00]` (legacy parity
    ctx.register_udf(ScalarUDF::from(ConvertTzUdf::new()));
    }
        }
                (None, Some(s)) => match parse_tz(s) {
            args: vec![
            let instant_millis = ts_millis.checked_sub((from_offset_seconds as i64) * 1_000)?;
            config_options: Arc::new(datafusion::config::ConfigOptions::new()),
        return Some(TzSpec::Offset(off));
//!
    }
    fn coerce_types_passes_through_exact_match() {
    }
            }
                DataType::Timestamp(TimeUnit::Millisecond, None),
            msg.contains("convert_tz") && msg.contains("Boolean"),
        );
