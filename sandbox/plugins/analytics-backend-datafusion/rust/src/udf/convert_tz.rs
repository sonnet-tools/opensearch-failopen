    fn iana_new_york_to_london_applies_correct_offset() {
        assert!(arr.is_null(2));
            return plan_err!("convert_tz expects 3 arguments, got {}", args.args.len());
                        builder.append_null();
        let winter_ts = 1_704_456_000_000;
        let ts = TimestampMillisecondArray::from(vec![Some(1_704_456_000_000), None, Some(0)]);
        assert!(arr.is_null(3), "to=+14:01 (out-of-band) must yield NULL");
        b'-' => -1,
//!
    }
        let winter_out = shift_millis(winter_ts, "America/New_York", "Europe/London").unwrap();
        let arr = match out {
        // 2024-01-05 in UTC (no DST there): NY winter = UTC-5, shift = +5h.
    let sign = match bytes[0] {
        assert_eq!(parse_offset_seconds("-08:00"), Some(-8 * 3600));
        // Nanosecond with tz → should coerce down to Millisecond, None.
#[derive(Clone)]
            .unwrap();
impl ConvertTzUdf {
    signature: Signature,
        let out = udf
/*
                opt.as_deref()
        TzSpec::Iana(z) => {
    #[test]
        b'+' => 1,
        // The Java adapter canonicalizes literal tz strings at plan time so
        // PPL emits `convert_tz(ts, from, to)` with ts typed as Utf8 (string
//!     `+5:00`; JDK-normalized IANA ids).
        };
}
                        continue;
            return plan_err!("convert_tz expects 3 arguments, got {}", arg_types.len());
            vec![
            )),
        assert_eq!(parse_offset_seconds("+14:00"), Some(14 * 3600));
        // Only materialize column-valued tz operands; for scalars the parsed
        let udf = ConvertTzUdf::new();
            ColumnarValue::Array(a) => a,
        let winter_out = shift_millis(winter_ts, "America/New_York", "UTC").unwrap();
        _ => return None,
            .unwrap_err();
        assert!(udf
        let to_scalar = scalar_tz(&args.args[2]);
//!     be folded at plan time.
            .as_any()
        let ts = DataType::Timestamp(TimeUnit::Millisecond, None);
                    Some(tz) => tz,
        assert!(arr.is_null(2), "from=+15:00 (out-of-band) must yield NULL");
    Iana(Tz),
        // Well outside.
        };
        let udf = ConvertTzUdf::new();
        if args.args.len() != 3 {
        ]);
                Some(args.args[1].clone().into_array(n)?)
                true,
        // view — StringArrayView borrows from the underlying buffer.
                }
                DataType::Utf8,
    }
//!     reach this UDF.
        ]);
///
                DataType::Utf8,
        assert_eq!(parse_offset_seconds("+05:30"), Some(5 * 3600 + 30 * 60));
fn parse_tz(s: &str) -> Option<TzSpec> {
        return None;
    };
        let from_array: Option<StringArrayView<'_>> = from_arr_ref
/// render that instant in `to`, then return the shifted millis as a tz-free
                DataType::Timestamp(TimeUnit::Nanosecond, Some("UTC".into())),
        let arr = match out {
            Some("+00:00"),
        let out = udf.invoke_with_args(args).unwrap();
        let ts = TimestampMillisecondArray::from(vec![
                    builder.append_null();
    }
}
        let msg = format!("{err}");
    if bytes[3] != b':' {
    let hours: i32 = s.get(1..3)?.parse().ok()?;
            msg.contains("convert_tz") && msg.contains("Boolean"),
            number_rows: 4,
            )),
    fn coerce_types_passes_through_exact_match() {
/// Shift `ts_millis` from `from` to `to` using pre-parsed [`TzSpec`]s. The
    if total_minutes > max_minutes {
 * The OpenSearch Contributors require contributions made to
    let max_minutes = if sign < 0 { 13 * 60 + 59 } else { 14 * 60 };
        assert_eq!((summer_out - summer_ts) / 1000, 4 * 3600);
}
                DataType::Utf8,
        let summer_out = shift_millis(summer_ts, "America/New_York", "Europe/London").unwrap();
            Some(
}
                }
//! runs at plan time:
            _ => panic!("expected array"),
    ColumnarValue, ScalarFunctionArgs, ScalarUDF, ScalarUDFImpl, Signature, Volatility,
fn offset_seconds_at(tz: &TzSpec, naive: &NaiveDateTime) -> Option<i32> {
    let to = parse_tz(to_tz)?;
        };
/// Parse `±HH:MM` → seconds east of UTC; None if not an offset literal.
/// `to_offset(ts) - from_offset(ts)` milliseconds.
            // Use .from_local_datetime → pick the earliest resolution for ambiguous
    fn coerce_types_accepts_date32_ts() {
            Some(1_704_456_000_000),
            )
            .unwrap();
            .coerce_types(&[ts.clone(), DataType::Utf8, DataType::Utf8])
            return_field: Arc::new(datafusion::arrow::datatypes::Field::new(
        // 2024-07-05T12:00:00 (summer): NY (UTC-4) → London (UTC+1) → +5h.
            Some("+15:00"), // well past positive cap
        let mut builder = TimestampMillisecondBuilder::with_capacity(n);
            .unwrap();
    }
fn shift_millis(ts_millis: i64, from_tz: &str, to_tz: &str) -> Option<i64> {
        };
//!   * identity cases (`from == to`) are short-circuited plan-side and never
        let from_arr_ref: Option<ArrayRef> =
        Self {
    fn name(&self) -> &str {
        let err = udf
    let from = parse_tz(from_tz)?;
            }
        let udf = ConvertTzUdf::new();
            match z.from_local_datetime(naive) {
    }
            }
                    .fix()
    pub fn new() -> Self {
        }
            "convert_tz",
                ColumnarValue::Array(Arc::new(ts)),
    /// Fixed offset in seconds east of UTC.
            .unwrap();
#[cfg(test)]
    // Coercion: PPL may emit the ts arg as Utf8 (string literal), Date32,
                (Some(tz), _) => tz.clone(),
            ColumnarValue::Array(a) => a,
    // or Timestamp with a different precision/tz. coerce_types should
use chrono::{DateTime, NaiveDateTime, Offset, TimeZone, Utc};
#[cfg(test)]
                DataType::Timestamp(TimeUnit::Millisecond, None),
        assert!(!arr.is_null(0));
    let from_off = offset_seconds_at(from, &naive)?;
        }
                Some(v) => builder.append_value(v),
        assert_eq!(shift_millis(0, "Not/AZone", "UTC"), None);
            Some("UTC"),
            signature: Signature::user_defined(Volatility::Immutable),
        // Out-of-band offsets — Java folds these to NULL at plan time;
            ])
};
            args: vec![
use datafusion::arrow::array::{
    }
                None
        assert_eq!((out - ts) / 1000, 5 * 3600);
//!
//! * Any null input → null output (null propagation).
            Some("-14:00"), // just past negative cap
}
            .downcast_ref::<TimestampMillisecondArray>()
                    }
    #[test]
                (Some(tz), _) => tz.clone(),
                _ => {
        let udf = ConvertTzUdf::new();
                z.offset_from_utc_datetime(&instant.naive_utc())
    fn coerce_types_accepts_utf8_ts() {
use datafusion::execution::context::SessionContext;
            .downcast_ref::<TimestampMillisecondArray>()
            Some("+00:00"),
    }
}
                },
        let out = shift_millis(ts, "+00:00", "+05:30").unwrap();
    fn invoke_out_of_band_offset_strings_yield_nulls() {
        &self.signature
//! * The return is the wall-clock time in `to_tz` for the same instant.
    #[test]
        assert_eq!((summer_out - summer_ts) / 1000, 5 * 3600);
                continue;
        // A boolean in the ts slot is clearly wrong — must error explicitly.
            .transpose()?;
        // → 17:00 UTC → London (UTC+0 in winter) = 17:00 local. Delta = +5h.
            // (DST-fall-back) wall times, which matches MySQL's behaviour.
        assert_eq!(shift_millis(0, "UTC", "Not/AZone"), None);
        assert_eq!((winter_out - winter_ts) / 1000, 5 * 3600);
        let udf = ConvertTzUdf::new();
            config_options: Arc::new(datafusion::config::ConfigOptions::new()),
    fn iana_to_utc_crosses_dst_in_source_tz() {
fn offset_seconds_at_instant(tz: &TzSpec, ts_millis: i64, from_offset_seconds: i32) -> Option<i32> {
fn shift_millis_parsed(ts_millis: i64, from: &TzSpec, to: &TzSpec) -> Option<i64> {
            let instant = DateTime::<Utc>::from_timestamp_millis(instant_millis)?;
                DataType::Utf8,
        ]);
                        continue;
        let args = ScalarFunctionArgs {
}
        let ts = ts
    }
    #[test]
            let instant_millis = ts_millis.checked_sub((from_offset_seconds as i64) * 1_000)?;
            .is_err());
            }
    if bytes.len() != 6 {
    }
    ctx.register_udf(ScalarUDF::from(ConvertTzUdf::new()));
        TzSpec::Iana(z) => {
        let s = match sv {
                ColumnarValue::Array(Arc::new(ts)),
/// Offset (seconds east of UTC) for `from_tz` at wall-clock `naive`.
use super::json_common::StringArrayView;
        assert_eq!(parse_offset_seconds("+15:00"), None);
        assert_eq!(
            .coerce_types(&[DataType::Boolean, DataType::Utf8, DataType::Utf8])
                None => builder.append_null(),
            .transpose()?;
        let n = args.number_rows;
    #[test]
            .as_any()
        Self::new()
                    None => {
            .as_ref()
            Some(1_704_456_000_000),
                DataType::Timestamp(TimeUnit::Millisecond, None),
        return s.and_then(parse_tz);
    // Batch / null handling through the full UDF.
        }
        }
            if to_scalar.is_none() && matches!(&args.args[2], ColumnarValue::Array(_)) {
//! Semantics (MySQL-compatible):
    #[test]
            ScalarValue::Utf8(opt) | ScalarValue::LargeUtf8(opt) | ScalarValue::Utf8View(opt) => {
                    Some(tz) => tz,
    match tz {
            ])
    let bytes = s.as_bytes();
        // coerce_types lets DF insert the right casts.
/// behavior.
    }
                    continue;
        "convert_tz"
        assert_eq!(out[0], DataType::Timestamp(TimeUnit::Millisecond, None));
            Some("+00:00"),
//! * Timezone strings may be IANA names (`'America/New_York'`) or ISO offsets
//!   * **Per-row DST-correct shifting.** IANA offsets vary per instant; can't
//!     unparseable entries yield NULL rows (matches MySQL's lenient
            // instant_utc_millis = wall_millis - from_offset_millis
        );
            .downcast_ref::<TimestampMillisecondArray>()
        let out = udf
            } else {
        // Boundary OKs.
                chrono::LocalResult::Single(dt) => Some(dt.offset().fix().local_minus_utc()),
    fn invoke_nulls_and_bad_tz_propagate() {
fn parse_offset_seconds(s: &str) -> Option<i32> {
//!
            ]
    ts_millis.checked_add(delta_millis)
    }
use datafusion::common::{plan_err, ScalarValue};
        return None;
//!
            } else {
}
//! * Unparseable column-valued timezone → null output.
        TzSpec::Offset(o) => Some(*o),
 * compatible open source license.
use datafusion::arrow::datatypes::{DataType, TimeUnit};
                ColumnarValue::Array(Arc::new(to)),
//!     `CONVERT_TZ` behavior).
//! * `ts` is interpreted as a wall-clock time in `from_tz`.
};
    }
            .map(StringArrayView::from_array)
    s.parse::<Tz>().ok().map(TzSpec::Iana)
    if let ColumnarValue::Scalar(sv) = cv {
    fn iana_dst_summer_offset_differs_from_winter() {
//!   * bad literals (unknown IANA, malformed offset) surface as
    let naive = DateTime::<Utc>::from_timestamp_millis(ts_millis)?.naive_utc();
            .map(StringArrayView::from_array)
    #[test]
    }
        Ok(ColumnarValue::Array(Arc::new(builder.finish()) as ArrayRef))
        assert_eq!(parse_offset_seconds("+00:00"), Some(0));
        };
            ],
            Some("+14:00"), // boundary OK
        let from = StringArray::from(vec![
            })?;
        // literal), Date32, or Timestamp(any precision, any tz). Signature::exact
 */
    if minutes > 59 {
    }
                ColumnarValue::Array(Arc::new(to)),
                DataType::Utf8,
/// Offset (seconds east of UTC) for `to_tz` at the UTC *instant* represented by
    fn invoke_with_args(&self, args: ScalarFunctionArgs) -> Result<ColumnarValue> {
                DataFusionError::Internal(format!(
        // 2024-01-05T12:00:00 (winter): NY→London → +5h.
// ─── tests ──────────────────────────────────────────────────────────────────
//! What stays here:
}
        let ts = 1_704_456_000_000; // 2024-01-05T12:00:00Z (stored naive)
                ColumnarValue::Array(Arc::new(from)),
        let to_arr_ref: Option<ArrayRef> =
use super::{coerce_args, CoerceMode};
    match tz {
        let summer_out = shift_millis(summer_ts, "America/New_York", "UTC").unwrap();
 * this file be licensed under the Apache-2.0 license or a
                _ => {
            }
        // 2024-01-05T12:00:00 in +00:00 → same wall clock in +05:30 means
        );
//!   * **Column-valued tz operands.** Values aren't known until runtime;
    // cap at -13:59. Matches legacy DateTimeUtils.isValidMySqlTimeZoneId.
                    builder.append_null();
    None
    Array, ArrayRef, TimestampMillisecondArray, TimestampMillisecondBuilder,
            args: vec![
        ]);
    #[test]
use datafusion::logical_expr::{
        assert!(
use std::sync::Arc;
use datafusion::error::{DataFusionError, Result};
            Some(1_704_456_000_000),
                builder.append_null();
    #[test]
        let arr = arr
                DataType::Utf8
    // ±HH:MM offsets parse to the expected second counts.
            Some(1_704_456_000_000),
//! Literal validation + canonicalization happens Java-side in
            Some("+00:00"),
        // TzSpec is already in hand. Keep the ArrayRef alive alongside the
            .as_ref()
        let to = StringArray::from(vec![Some("+05:30"), Some("UTC"), Some("UTC")]);
    }
/// value the caller can continue to treat as naive. The shift is exactly
                DataType::Timestamp(TimeUnit::Millisecond, None),
        let out = udf
            arg_fields: vec![],
/// instant — DST-correct even across transitions.
            let to = match (&to_scalar, to_array.as_ref().and_then(|a| a.cell(i))) {
pub struct ConvertTzUdf {
                (None, Some(s)) => match parse_tz(s) {
    fn coerce_types(&self, arg_types: &[DataType]) -> Result<Vec<DataType>> {
        let out = udf
            &[CoerceMode::TimestampMs, CoerceMode::Utf8, CoerceMode::Utf8],
    }
    }
    fn coerce_types_rejects_wrong_arity() {
    // normalize them all to Timestamp(Millisecond, None) + Utf8 + Utf8.
                ColumnarValue::Array(Arc::new(from)),
            Some("+00:00"),
#[derive(Debug, PartialEq, Eq, Hash)]
    let to_off = offset_seconds_at_instant(to, ts_millis, from_off)?;
    #[test]
        }
/// String-operand wrapper retained for direct-invocation tests that exercise
                        builder.append_null();
/// stored timestamp has no tz attached — interpret its wall clock in `from`,
use chrono_tz::Tz;
        TzSpec::Offset(o) => Some(*o),
    #[test]
        assert_eq!((winter_out - winter_ts) / 1000, 5 * 3600);
        assert!(!arr.is_null(0), "in-band +14:00 must produce a value");
        // Same delta because both shift to/from their summer offsets in lockstep.
    Some(sign * (hours * 3600 + minutes * 60))
    #[test]
        )
                chrono::LocalResult::Ambiguous(dt, _) => Some(dt.offset().fix().local_minus_utc()),
        let ts = args.args[0].clone().into_array(n)?;
}
        assert!(arr.is_null(1), "from=-14:00 (out-of-band) must yield NULL");
    }
        coerce_args(
        // 2024-07-05: NY summer = UTC-4, shift = +4h.
        assert_eq!(parse_offset_seconds("-17:00"), None);
    fn coerce_types_rejects_unsupported_ts_type() {
        // this catches the column-valued path.
                    ts.data_type()
/// malformed entry yields a NULL row and matches the documented lenient
            .as_any()
    fn signature(&self) -> &Signature {
        Ok(DataType::Timestamp(TimeUnit::Millisecond, None))
        let udf = ConvertTzUdf::new();
    fn parse_offset_enforces_mysql_band() {
                (None, Some(s)) => match parse_tz(s) {
 *
        return None;
            .unwrap();
    fn parse_offset_accepts_positive_and_negative() {
            number_rows: 3,
    // When from_tz crosses DST boundary but to_tz doesn't, the delta changes.
            .coerce_types(&[DataType::Utf8, DataType::Utf8, DataType::Utf8])
    #[test]
        // confirm the two shifts to UTC (London+0 in winter, +1 in summer) produce
    #[test]
    // IANA ↔ IANA: DST-correct jump across a transition.
                ))
                "out",
            };
    use datafusion::arrow::array::StringArray;
                chrono::LocalResult::None => None, // wall time in the DST "spring-forward" gap
    }
/// paths — Java canonicalizes — but defensive for degenerate scalar inputs).
    #[test]
        assert!(arr.is_null(1));
                "out",
/// (`ConvertTzAdapter::canonicalizeTz`) folds out-of-band literals to NULL at
        let from = StringArray::from(vec![
/// the full parse + shift flow in one call.
        // scalar therefore means the scalar was SQL NULL.
    shift_millis_parsed(ts_millis, &from, &to)
    }
        assert!(udf.coerce_types(&[DataType::Utf8]).is_err());
pub fn register_all(ctx: &SessionContext) {
                    }
    }
        // Summer: NY is UTC-4, winter: NY is UTC-5. Pull data at both dates,
//! # Division of labor with the Java adapter
        // only let through the Timestamp(Ms, None) variant; user_defined +
    if let Some(off) = parse_offset_seconds(s) {
    fn coerce_types_accepts_other_ts_precisions() {
}
mod tests {
//! `ConvertTzAdapter` (see `.../be/datafusion/ConvertTzAdapter.java`), which
        assert_eq!(out, vec![ts, DataType::Utf8, DataType::Utf8]);
        assert_eq!(parse_offset_seconds("0500"), None);
        let to = StringArray::from(vec![
            };
        assert_eq!(parse_offset_seconds("bogus"), None);
}
enum TzSpec {
        let udf = ConvertTzUdf::new();
    }
    let delta_millis = (to_off - from_off) as i64 * 1_000;
        let arr = arr
            .unwrap();
                true,
            _ => None,
            .coerce_types(&[DataType::Date32, DataType::Utf8, DataType::Utf8])
        return None;
    // null them out at row time. Both just-outside-the-band entries (-14:00,
            "unexpected error: {msg}"
            arg_fields: vec![],
        let from_scalar = scalar_tz(&args.args[1]);
        // Just outside.
fn scalar_tz(cv: &ColumnarValue) -> Option<TzSpec> {
    let minutes: i32 = s.get(4..6)?.parse().ok()?;
    }
        // 2024-01-05T12:00:00 wall-clock in America/New_York (UTC-5 in winter)
        // the expected distinct deltas.
    // Offset → offset: simple wall-clock delta, no calendar.
        assert_eq!(out - ts, 5 * 3600 * 1000 + 30 * 60 * 1000);
/// `ts_millis` is a wall clock in from_tz), then look up to_tz's offset at that
            };
    Offset(i32),
    fn unknown_tz_returns_none() {
        let to_array: Option<StringArrayView<'_>> = to_arr_ref
                DataType::Utf8,
                    continue;
    }
            out,
            config_options: Arc::new(datafusion::config::ConfigOptions::new()),
            _ => panic!("expected array"),
/// with `DateTimeUtils.isValidMySqlTimeZoneId`). The Java adapter
    }
        let udf = ConvertTzUdf::new();
                    .local_minus_utc(),
        // bad-literal input can't reach this UDF — a None from parse_tz on a
//!   of the form `±HH:MM` with hours ∈ [0,14], minutes ∈ [0,59].
            .coerce_types(&[
            return_field: Arc::new(datafusion::arrow::datatypes::Field::new(
                    None => {
    }
    }
    #[test]
    // Column-valued tz strings can't be validated plan-side, so the UDF must
                None
        let winter_ts = 1_704_456_000_000;
        if arg_types.len() != 3 {
            .ok_or_else(|| {
    fn default() -> Self {
        for i in 0..n {
        let ts = 1_704_456_000_000; // treat as 2024-01-05T12:00:00 naive
            ],
        assert_eq!(parse_offset_seconds("-13:59"), Some(-(13 * 3600 + 59 * 60)));
/// non-scalar, or an unparseable string (the latter unreachable from literal
/// plan time; this defensive check covers column-valued tz strings, where a
            if ts.is_null(i) {
    use super::*;
            Some("+14:01"), // just past positive cap
        // Fast-path: scalar tz operands are parsed once up front, not per row.
    // +14:01) and well-outside ones (+15:00) must collapse to NULL.
            match shift_millis_parsed(ts.value(i), &from, &to) {
//! `convert_tz(ts, from_tz, to_tz)` — shift a timestamp from one timezone to another.
            .coerce_types(&[
    // MySQL's CONVERT_TZ band: positive offsets cap at +14:00, negative offsets
        assert_eq!(out[0], DataType::Timestamp(TimeUnit::Millisecond, None));
    fn fixed_offset_to_fixed_offset_shifts_by_delta() {
}
                Some(args.args[2].clone().into_array(n)?)
    fn return_type(&self, arg_types: &[DataType]) -> Result<DataType> {
/// If `cv` is a non-NULL string scalar, parse it once. Returns None for NULL,
        let summer_ts = 1_720_180_800_000;
            };
        }
                DataType::Utf8,
                },
        let out = udf.invoke_with_args(args).unwrap();
        assert_eq!(parse_offset_seconds("+14:00"), Some(14 * 3600));
        assert_eq!(parse_offset_seconds("+14:01"), None);
        let summer_ts = 1_720_180_800_000; // 2024-07-05T12:00:00Z naive
        // +5h30m = +19_800_000 ms added.
    }
            if from_scalar.is_none() && matches!(&args.args[1], ColumnarValue::Array(_)) {
    }
                    "convert_tz: expected TimestampMillisecond, got {:?}",
impl Default for ConvertTzUdf {
/// Bounds match MySQL's `CONVERT_TZ` band: `[-13:59, +14:00]` (legacy parity
            arg_types,
    }
        assert_eq!(parse_offset_seconds("+05:60"), None);
    }
        return Some(TzSpec::Offset(off));
        let args = ScalarFunctionArgs {
        assert_eq!(parse_offset_seconds("-14:00"), None);
//!     `IllegalArgumentException` at plan time — users see the error instantly.
    fn parse_offset_rejects_malformed() {
}
//!   * literal tz operands arrive here already canonicalized (`+05:00`, not
impl ScalarUDFImpl for ConvertTzUdf {
/// Parse timezone string (IANA name or `±HH:MM` offset).
            Some("Mars/Olympus"), // unknown column-valued entry → null
/// the input. We reconstruct the instant from `ts_millis` + `from_offset` (since
            let from = match (&from_scalar, from_array.as_ref().and_then(|a| a.cell(i))) {
 * SPDX-License-Identifier: Apache-2.0
        let out = shift_millis(ts, "America/New_York", "Europe/London").unwrap();
    let total_minutes = hours * 60 + minutes;
