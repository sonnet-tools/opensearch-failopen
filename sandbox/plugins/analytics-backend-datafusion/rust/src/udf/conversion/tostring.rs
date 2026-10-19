        let return_field = Arc::new(Field::new(u.name(), DataType::Utf8, true));
            // decimals would print `"42"`.
            ColumnarValue::Scalar(ScalarValue::Utf8(None)) => {}
        }
                Arc::new(Field::new("f", DataType::Utf8, true)),
fn format_binary_i64(v: i64) -> String {
 * The OpenSearch Contributors require contributions made to
        u.invoke_with_args(args)
/// * `format_col` — the format `ColumnarValue`. Resolved once per row via
                        })
        mode::HEX => format_hex_i64(truncate_to_i64(value)),
    };
    #[test]
            }
}
        return v.to_string();
                assert_eq!(s.value(0), "1,234.5");
        }
}
    fn invoke_scalar(
        let out = invoke_scalar(ScalarValue::Int64(Some(-5)), DataType::Int64, "binary").unwrap();
    }
        mode::DURATION => format_duration_seconds(truncate_to_i64(value)),
        )
        let value_type = value.data_type().clone();
impl Default for ToStringUdf {
                            }
    }
            invoke_scalar(ScalarValue::Int64(Some(39225)), DataType::Int64, "commas").unwrap();
        Self {
    }
    if v < 0 {
        assert_eq!(utf8(out), "-101");
                        })
    #[test]
        let u = udf();
    }
    match format {
    match format_col {
                            }
    fn array_int_hex_with_scalar_format() {
    value: Option<T>,
    }
        format: &str,
        assert_eq!(utf8(out), "01:48:20");
        ) => Ok(opt.clone()),
                ColumnarValue::Scalar(ScalarValue::Utf8(None)),
/// truncate toward zero, then apply the integer formatter.
            return_field,
use datafusion::logical_expr::{
    fn commas_float_rounds_to_two_decimals() {
/// `tostring(bigint, varchar)` / `tostring(fp64, varchar)` → varchar.
            DataType::Float64,
                "tostring expects exactly 2 arguments (value, format), got {}",
    }
 * SPDX-License-Identifier: Apache-2.0
        mode::HEX => format_hex_i64(value),
        }
        match out {
                            if typed.is_null(i) {
        }
}
                .strip_suffix(".0")
    }
    #[test]
    // Use `rem_euclid` to get the non-negative second-of-day.
// identically.
            ScalarValue::Utf8(opt) | ScalarValue::LargeUtf8(opt) | ScalarValue::Utf8View(opt),
            arg_fields: vec![
    fn eq(&self, _: &Self) -> bool {
    }
        }
    // Drop `.00` so integral values render without a decimal tail (`39225 → "39,225"`),
            ColumnarValue::Array(arr) => {
}
            invoke_scalar(ScalarValue::Int64(Some(3661)), DataType::Int64, "duration").unwrap();
        let out =
    }
                    let out: StringArray = (0..typed.len())
                return value.to_string();
    if frac != "00" {
// identical — there's no meaningful "parameterization" — so they compare equal and hash
            DataType::Int64,
    }
        out.push('-');
/// Render an `f64` value per the requested format. Mirrors the Java reference's strategy
}
impl Hash for ToStringUdf {
//! [`tostring(value, format)`](https://docs.opensearch.org/latest/sql-and-ppl/ppl/functions/conversion/#tostring)
    // rounds the number to the nearest two decimal places.
    }
        "tostring".hash(state);
//! * `"commas"` — number with comma grouping; rounded to 2 decimals when the value has
            invoke_scalar(ScalarValue::Int64(Some(6500)), DataType::Int64, "duration").unwrap();
mod mode {
};
    fn null_format_yields_null() {
    }
    // but keep a single-digit fractional (`.50`) when present
    fn hash<H: Hasher>(&self, state: &mut H) {
                }
    #[test]
            ],
        match out {
    };
            other => panic!("expected Utf8 scalar, got {other:?}"),
        match out {
) -> Result<Option<String>> {
fn truncate_to_i64(value: f64) -> i64 {
    }
        v.to_string()
                .map_or(rendered.clone(), |s| s.to_string())
    ) -> Result<ColumnarValue> {
    fn signature(&self) -> &Signature {
    }
///   (null propagation).
    out
                            } else {
    pub const HEX: &str = "hex";
//!
    ctx.register_udf(ScalarUDF::from(ToStringUdf::new()));
            ScalarValue::Int64(Some(6_500_999)),
        ColumnarValue::Scalar(
/// * `value` — the already-unwrapped optional; {@code None} short-circuits to `Ok(None)`
            ColumnarValue::Scalar(ScalarValue::Utf8(Some(s))) => s,
                ColumnarValue::Scalar(value),
                                scalar_to_str(Some(typed.value(i)), format_col, i, format_i64_as)
            }
        .unwrap();
        // at the planner level.
                ColumnarValue::Scalar(ScalarValue::Utf8(Some(format.to_string()))),
        assert_eq!(utf8(out), "1001100100111001");
            number_rows: 3,
        .expect("{:.2} always produces a decimal point");
            args: vec![
            return_field,
        if frac.ends_with('0') {
        out.push('-');
        let out =
    let m = (second_of_day / 60) % 60;
    }
    if !v.is_finite() {
        if args.args.len() != 2 {
        true
                DataType::Float64 => {
    #[test]
            ],
        }
        } else {
        let out = invoke_array(array, "commas").unwrap();
                    .map(move |fmt_ty| TypeSignature::Exact(vec![value_ty.clone(), fmt_ty]))
    let bytes = digits.as_bytes();
//!   the signed-magnitude representation `-xx` (matches `BigInteger.toString(16)`).
        let return_field = Arc::new(Field::new(u.name(), DataType::Utf8, true));
        None => Ok(None),
    #[test]
}
    // a leading '-'. Lowercase to match the Java reference (BigInteger uses lowercase).
    pub fn new() -> Self {
impl ScalarUDFImpl for ToStringUdf {
            DataType::Int64,
        let day = invoke_scalar(
        mode::DURATION => format_duration_seconds(value),
/// * `row` — only used when `format_col` is an array; ignored for the scalar path.
    // that by formatting the absolute value and re-prepending the sign.
/// Allocation-free thousands-separator insertion. Appends `digits` to `out` with a `,`
    #[test]
    if v < 0 {
        // Work in i128 so i64::MIN doesn't overflow on abs.
        }
        assert_eq!(utf8(day), "00:00:00");
            ColumnarValue::Array(arr) => {
}
                let s = arr.as_string::<i32>();
pub fn register_all(ctx: &SessionContext) {
 * this file be licensed under the Apache-2.0 license or a
            rendered
        format!("{}", (v as i128).unsigned_abs())
// `ScalarUDFImpl` requires DynEq+DynHash. All `ToStringUdf` instances are functionally
/// after every 3 digits counted from the right.
        assert_eq!(utf8(out), "9939");
    use super::*;
        )
//!
/// decimal rendering.
            config_options: Arc::new(Default::default()),
/// Format modes, case-sensitive to match the SQL plugin's Java reference
            "duration",
    let is_negative = v < 0;
        match &args.args[0] {
pub struct ToStringUdf {
/// (`ToStringFunction.DURATION_FORMAT`, etc.).
fn scalar_to_str<T: Copy>(
            "commas",
                other => {
    signature: Signature,
        mode::COMMAS => format_commas_f64(value),
            ],
        // The format arg accepts any string variant — the body dispatches via
            ],
                exec_err!("tostring: expected BIGINT or DOUBLE value, got {other:?}")
    #[test]
            ColumnarValue::Scalar(ScalarValue::Utf8(None)) => {}
        )
        return 0;
                            if typed.is_null(i) {
        &self.signature
    row: usize,
                ColumnarValue::Array(value),
                Arc::new(Field::new("v", value_type, true)),
///
use datafusion::execution::context::SessionContext;
        ColumnarValue::Scalar(other) => {
    }
//! * `"hex"` — number → lowercase hexadecimal of its integer part. Negative values use
            DataType::Float64,
    fn utf8(v: ColumnarValue) -> String {
            arg_fields: vec![
    // Mirrors `BigInteger.toString(2)` for positive values; for negatives the Java
    }
fn format_commas_f64(v: f64) -> String {
 *
use std::sync::Arc;
    }
        }
                ScalarValue::Utf8(scalar_to_str(*value, format_col, 0, format_f64_as)?),
mod tests {
            exec_err!("tostring: format must be VARCHAR, got {other:?}")
    fn commas_integer_doc_example() {
            "duration_millis",
        let out = invoke_scalar(ScalarValue::Int64(Some(39225)), DataType::Int64, "hex").unwrap();
/// Pulls the format string for `row` out of `format_col`. Returns `Ok(None)` for null
    formatter: fn(T, &str) -> String,
    fn array_float_commas_with_scalar_format() {
fn format_at(format_col: &ColumnarValue, row: usize) -> Result<Option<String>> {
                    let typed = arr.as_primitive::<Float64Type>();
            ColumnarValue::Scalar(other) => {
            .flat_map(|value_ty| {
                Arc::new(Field::new("v", DataType::Int64, true)),
            "duration",
            .into_iter()
    fn name(&self) -> &str {
        )
    let rounded = format!("{:.2}", v.abs());
#[derive(Debug)]
    let mut out = String::with_capacity(abs_str.len() + abs_str.len() / 3 + 1);
                        .into_iter()
        assert_eq!(utf8(out), "39,225");
    }
    format_col: &ColumnarValue,
    if is_negative {
            other => panic!("expected array, got {other:?}"),
                        .collect::<Result<Vec<_>>>()?
    let is_negative = v.is_sign_negative();
use std::hash::{Hash, Hasher};
            if !value.is_finite() {
                Arc::new(Field::new("f", DataType::Utf8, true)),
    fn duration_millis_negative_wraps_via_floor_div() {
//! Mirror's PPL's
        let args = ScalarFunctionArgs {
}
    }
            other => panic!("expected Utf8(None), got {other:?}"),
    let format = format_at(format_col, row)?;
//!   a fractional component, otherwise no decimals.
    }
    use datafusion::arrow::datatypes::Field;
    }
        value: ScalarValue,
    }
        }
        match v {
            let rendered = format!("{value}");
            other => panic!("expected array, got {other:?}"),
                            } else {
}
        let u = udf();
    // Non-finite fall through to native rendering (matches Double.toString for Infinity/NaN).
        let array: ArrayRef = Arc::new(Float64Array::from(vec![Some(1234.5), None, Some(0.0)]));
        mode::BINARY => format_binary_i64(truncate_to_i64(value)),
        u.invoke_with_args(args)
        .unwrap();
    } else {
}
            "duration",
    }
    }
    match format {
    }
                        .into_iter()
        _ => value.to_string(),
            other => panic!("expected Utf8(None), got {other:?}"),
            return_field,
    pub const COMMAS: &str = "commas";
            ScalarValue::Int64(Some(86_400)),
    }
        return Ok(None);
//!   signed-magnitude representation `-1xxxx` (matches `BigInteger.toString(2)`).
                        .collect();
    #[test]
        .unwrap();
            .collect();
    if is_negative {
            ColumnarValue::Scalar(ScalarValue::Int64(value)) => Ok(ColumnarValue::Scalar(
//! * `"binary"` — number → base-2 string of its integer part. Negative values use the
        ToStringUdf::new()
    fn invoke_array(value: ArrayRef, format: &str) -> Result<ColumnarValue> {
                datafusion::common::DataFusionError::Execution(format!("tostring: {e}"))
                ScalarValue::Utf8(scalar_to_str(*value, format_col, 0, format_i64_as)?),
            DataType::Int64,
                }
            ],
//! [`ToStringFunction`](https://github.com/opensearch-project/sql/blob/main/core/src/main/java/org/opensearch/sql/expression/function/udf/ToStringFunction.java)
    insert_thousands_separators(&abs_str, &mut out);
                        .map(|i| {
        )
fn format_f64_as(value: f64, format: &str) -> String {
            args: vec![
                                Ok(None)
        let u = udf();
    ColumnarValue, ScalarFunctionArgs, ScalarUDF, ScalarUDFImpl, Signature, TypeSignature,
impl Eq for ToStringUdf {}
            },
                                Ok(None)
            ColumnarValue::Scalar(ScalarValue::Float64(value)) => Ok(ColumnarValue::Scalar(
    }
        let args = ScalarFunctionArgs {
        out.push(*b as char);
            args: vec![
        };
    #[test]
    fn default() -> Self {
        match out {
fn format_duration_seconds(total_seconds: i64) -> String {
        .unwrap();
        let out = invoke_scalar(ScalarValue::Int64(Some(42)), DataType::Int64, "xyzzy").unwrap();
                    let out: StringArray = (0..typed.len())
    fn duration_bigdecimal_positive_example() {
    }
    #[test]
    let len = bytes.len();
    if !value.is_finite() {
use datafusion::common::{exec_err, Result, ScalarValue};
#[cfg(test)]
///   [`format_at`]; the row index is only consulted when the caller passed an array.
    let (whole, frac) = rounded
                assert!(s.is_null(1));
        let out = u.invoke_with_args(args).unwrap();
        format!("-{:x}", (v as i128).unsigned_abs())
        assert_eq!(utf8(out), "01:48:20");
                [DataType::Utf8, DataType::LargeUtf8, DataType::Utf8View]
        Ok(DataType::Utf8)
/// * `formatter` — per-value-type rendering function (one for `i64`, one for `f64`).
            number_rows: 1,
}
        assert_eq!(utf8(out), "42");
                        .collect::<Result<Vec<_>>>()?
    }
        mode::DURATION_MILLIS => format_duration_seconds(truncate_to_i64(value).div_euclid(1_000)),
fn format_i64_as(value: i64, format: &str) -> String {
/// format cells.
}
            // `BigDecimal.valueOf(42.0).toString() == "42.0"` → passed to `NumberFormat` with no
            let view = crate::udf::json_common::StringArrayView::from_array(arr).map_err(|e| {
    fn invoke_with_args(&self, args: ScalarFunctionArgs) -> Result<ColumnarValue> {
//! * `"duration"` — integer seconds → `HH:MM:SS` **wall-clock** rendering.
    match format {
        Some(f) => Ok(Some(formatter(v, f.as_str()))),
            out.push(',');
        let out =
use datafusion::arrow::array::{Array, ArrayRef, AsArray, StringArray};
    }
        let out = invoke_array(array, "hex").unwrap();
                                scalar_to_str(Some(typed.value(i)), format_col, i, format_f64_as)
            config_options: Arc::new(Default::default()),
/// of routing `binary` / `hex` / `duration*` through `BigDecimal.toBigInteger()` — i.e.
fn format_hex_i64(v: i64) -> String {
}
            )),
        let array: ArrayRef = Arc::new(Int64Array::from(vec![Some(15), None, Some(255)]));
 */
    let Some(v) = value else {
        let out = invoke_scalar(
}
    insert_thousands_separators(whole, &mut out);
            }
        mode::BINARY => format_binary_i64(value),
        }
    #[test]
            DataType::Int64,
            )),
/*
        let out = invoke_scalar(
                assert_eq!(s.value(2), "0");
    Volatility,
        assert_eq!(utf8(out), "01:01:01");
        assert_eq!(utf8(day_plus_hour), "01:00:00");
            invoke_scalar(ScalarValue::Int64(Some(39225)), DataType::Int64, "binary").unwrap();
        mode::DURATION_MILLIS => format_duration_seconds(value.div_euclid(1_000)),
            ScalarValue::Float64(Some(1234.5678)),
        assert_eq!(utf8(out), "22:58:59");
    let abs_str = if is_negative {
        let out = invoke_scalar(ScalarValue::Int64(None), DataType::Int64, "hex").unwrap();
            ],
    use datafusion::arrow::array::{Float64Array, Int64Array};
        format!("{:b}", v as u64)
    value as i64
    fn binary_matches_biginteger_tostring_2() {
//! Supported format values:
    fn duration_millis_truncates_subseconds() {
        mode::COMMAS => format_commas_i64(value),
        Self::new()
    }
            DataType::Float64,
            })
                        .map(|i| {
        assert_eq!(utf8(out), "39,225");
            }
    for (i, b) in bytes.iter().enumerate() {
//! * `"duration_millis"` — integer milliseconds → `HH:MM:SS` wall-clock rendering.
}
    #[test]
        )
        assert_eq!(utf8(out), "1,234.57");
            arg_fields: vec![
impl ToStringUdf {
    fn duration_seconds_doc_example() {
        assert_eq!(utf8(out), "22:58:59");
    let h = second_of_day / 3600;
        let exacts = [DataType::Int64, DataType::Float64]
/// Format a signed number of seconds to  wall-clock `HH:MM:SS` format
        value_type: DataType,
                    .into_iter()
}
}
    fn null_value_yields_null() {
        let return_field = Arc::new(Field::new(u.name(), DataType::Utf8, true));
        }
/// Per-row dispatcher for one concrete value type.
                ColumnarValue::Scalar(ScalarValue::Utf8(Some(format.to_string()))),
                ColumnarValue::Scalar(ScalarValue::Int64(Some(42))),
            );
    } else {
        };
        format!("-{:b}", (v as i128).unsigned_abs())
    }
    format!("{:02}:{:02}:{:02}", h, m, s)
        _ => {
        let from_right = len - i;
        let out = invoke_scalar(
    fn commas_float_drops_trailing_double_zero() {
    #[test]
                assert_eq!(s.value(0), "f");
        .unwrap();
            config_options: Arc::new(Default::default()),
impl PartialEq for ToStringUdf {
            out.push_str(frac);
fn insert_thousands_separators(digits: &str, out: &mut String) {
    }
    }
                Arc::new(Field::new("v", value_type, true)),
                assert!(s.is_null(1));
            number_rows: 1,
    }
        let format_col = &args.args[1];
            return exec_err!(
                    let typed = arr.as_primitive::<Int64Type>();
            "commas",
                Arc::new(Field::new("f", DataType::Utf8, true)),
}
                DataType::Int64 => {
                        .collect();
        }
        // Trim a trailing '0' when exactly one digit would be meaningful, e.g. `.50 → .5`.
        let out =
        )
    }
/// Render an `i64` value per the requested format. Unknown modes fall through to plain
            signature: Signature::one_of(exacts, Volatility::Immutable),
        out.push('.');
            // Drop a trailing `.0` so `tostring(42.0)` reads as `"42"`, matching
    fn return_type(&self, _arg_types: &[DataType]) -> Result<DataType> {
            out.push_str(&frac[..frac.len() - 1]);
            Ok(view.cell(row).map(|s| s.to_string()))
        .unwrap();
            ScalarValue::Float64(Some(-3661.4)),
    fn unknown_format_falls_through_to_plain_decimal() {
                    Ok(ColumnarValue::Array(Arc::new(out) as ArrayRef))
            ScalarValue::Int64(Some(86_400 + 3_600)),
    let second_of_day = total_seconds.rem_euclid(86_400);
    #[test]
        let out = invoke_scalar(
            "duration_millis",
                    Ok(ColumnarValue::Array(Arc::new(out) as ArrayRef))
    pub const DURATION_MILLIS: &str = "duration_millis";
                let s = arr.as_string::<i32>();
        .unwrap();
    // Same rationale as `format_binary_i64` — BigInteger.toString(16) on negatives prints
    } else {
        }
        "tostring"
    fn udf() -> ToStringUdf {
    }
                    exec_err!("tostring: expected Int64 or Float64 value array, got {other:?}")
    let s = second_of_day % 60;
        .split_once('.')
        let args = ScalarFunctionArgs {
            ScalarValue::Int64(Some(-3_661_000)),
}
            ScalarValue::Float64(Some(39225.0)),
    #[test]
    }
    pub const DURATION: &str = "duration";
    // reference emits a leading '-' via BigInteger's signed radix representation. We match
}
fn format_commas_i64(v: i64) -> String {
            })?;
    fn duration_negative_wraps_to_pre_epoch_clock_time() {
//! format modes in one UDF.
        if from_right > 1 && (from_right - 1) % 3 == 0 {
    let mut out = String::with_capacity(rounded.len() + whole.len() / 3 + 2);
 * compatible open source license.
    #[test]
    fn binary_negative_uses_signed_biginteger_repr() {
                assert_eq!(s.value(2), "ff");
    }
            ColumnarValue::Array(arr) => match arr.data_type() {
        let out = invoke_scalar(
    pub const BINARY: &str = "binary";
    fn hex_matches_bigint_tohex() {
                args.args.len()
use datafusion::arrow::datatypes::{DataType, Float64Type, Int64Type};
        format!("{:x}", v as u64)
                }
    out
        let day_plus_hour = invoke_scalar(
    }
        };
    fn duration_wraps_modulo_24h() {
        ColumnarValue::Array(arr) => {
        // StringArrayView so the producer's Utf8View doesn't get cast to Utf8
