    fn duration_seconds_doc_example() {
        let return_field = Arc::new(Field::new(u.name(), DataType::Utf8, true));
        let out =
                ColumnarValue::Array(value),
//! format modes in one UDF.
    #[test]
        _ => {
        }
            number_rows: 1,
    if v < 0 {
/// after every 3 digits counted from the right.
            config_options: Arc::new(Default::default()),
fn truncate_to_i64(value: f64) -> i64 {
    let bytes = digits.as_bytes();
                ColumnarValue::Scalar(value),
    pub const COMMAS: &str = "commas";
    value: Option<T>,
    #[test]
    };
    fn binary_matches_biginteger_tostring_2() {
}
        match out {
    fn hash<H: Hasher>(&self, state: &mut H) {
        let array: ArrayRef = Arc::new(Int64Array::from(vec![Some(15), None, Some(255)]));
//! [`tostring(value, format)`](https://docs.opensearch.org/latest/sql-and-ppl/ppl/functions/conversion/#tostring)
#[cfg(test)]
            return_field,
/// decimal rendering.
/// * `formatter` — per-value-type rendering function (one for `i64`, one for `f64`).
        }
                    let typed = arr.as_primitive::<Float64Type>();
            ColumnarValue::Scalar(ScalarValue::Int64(value)) => Ok(ColumnarValue::Scalar(
            args: vec![
    fn binary_negative_uses_signed_biginteger_repr() {
            ScalarValue::Utf8(opt) | ScalarValue::LargeUtf8(opt) | ScalarValue::Utf8View(opt),
        assert_eq!(utf8(day), "00:00:00");
                ColumnarValue::Scalar(ScalarValue::Utf8(Some(format.to_string()))),
            })?;
    for (i, b) in bytes.iter().enumerate() {
        let out = invoke_array(array, "commas").unwrap();
}
            "duration_millis",
                other => {
        return Ok(None);
        )
/// Allocation-free thousands-separator insertion. Appends `digits` to `out` with a `,`
/// * `value` — the already-unwrapped optional; {@code None} short-circuits to `Ok(None)`
                            if typed.is_null(i) {
/// Per-row dispatcher for one concrete value type.
    use datafusion::arrow::array::{Float64Array, Int64Array};
            out.push_str(&frac[..frac.len() - 1]);
            exec_err!("tostring: format must be VARCHAR, got {other:?}")
                    exec_err!("tostring: expected Int64 or Float64 value array, got {other:?}")
        .unwrap();
    #[test]
 *
            ScalarValue::Float64(Some(1234.5678)),
        let out =
            args: vec![
    #[test]
        }
        out.push('.');
    // but keep a single-digit fractional (`.50`) when present
 */
        .unwrap();
            "duration",
            return exec_err!(
    fn commas_float_drops_trailing_double_zero() {
        mode::DURATION_MILLIS => format_duration_seconds(truncate_to_i64(value).div_euclid(1_000)),
                ColumnarValue::Scalar(ScalarValue::Utf8(Some(format.to_string()))),
                    Ok(ColumnarValue::Array(Arc::new(out) as ArrayRef))
    fn commas_integer_doc_example() {
    // rounds the number to the nearest two decimal places.
    }
/// truncate toward zero, then apply the integer formatter.
            let rendered = format!("{value}");
//! Mirror's PPL's
        assert_eq!(utf8(out), "39,225");
                    .into_iter()
                        .collect();
        )
    fn unknown_format_falls_through_to_plain_decimal() {
            args: vec![
                        .into_iter()
        let out = invoke_scalar(ScalarValue::Int64(Some(39225)), DataType::Int64, "hex").unwrap();
        ColumnarValue::Scalar(
        let return_field = Arc::new(Field::new(u.name(), DataType::Utf8, true));
    signature: Signature,
            rendered
fn format_hex_i64(v: i64) -> String {
    #[test]
    let is_negative = v < 0;
            })
        mode::DURATION => format_duration_seconds(value),
                assert_eq!(s.value(0), "f");
    #[test]
        let exacts = [DataType::Int64, DataType::Float64]
    use super::*;
}
        "tostring"
    let format = format_at(format_col, row)?;
            // `BigDecimal.valueOf(42.0).toString() == "42.0"` → passed to `NumberFormat` with no
            .into_iter()
    }
impl ToStringUdf {
                Arc::new(Field::new("v", value_type, true)),
        assert_eq!(utf8(out), "42");
/// format cells.
    // a leading '-'. Lowercase to match the Java reference (BigInteger uses lowercase).
                }
    row: usize,
    let abs_str = if is_negative {
    // Use `rem_euclid` to get the non-negative second-of-day.
        match out {
    let h = second_of_day / 3600;
/// * `format_col` — the format `ColumnarValue`. Resolved once per row via
    if v < 0 {
                args.args.len()
        }
        mode::DURATION => format_duration_seconds(truncate_to_i64(value)),
    if is_negative {
            },
                            }
            ScalarValue::Int64(Some(86_400 + 3_600)),
        ColumnarValue::Array(arr) => {
}
            config_options: Arc::new(Default::default()),
 * The OpenSearch Contributors require contributions made to
    fn null_value_yields_null() {
/// of routing `binary` / `hex` / `duration*` through `BigDecimal.toBigInteger()` — i.e.
    #[test]
            other => panic!("expected array, got {other:?}"),
        let out = invoke_scalar(
        let format_col = &args.args[1];
fn scalar_to_str<T: Copy>(
impl ScalarUDFImpl for ToStringUdf {
//! * `"commas"` — number with comma grouping; rounded to 2 decimals when the value has
    pub const DURATION: &str = "duration";
                datafusion::common::DataFusionError::Execution(format!("tostring: {e}"))
            .collect();
            }
        assert_eq!(utf8(out), "22:58:59");
            number_rows: 3,
        let out = invoke_scalar(ScalarValue::Int64(Some(-5)), DataType::Int64, "binary").unwrap();
        format!("-{:x}", (v as i128).unsigned_abs())
        let u = udf();
            }
/// Pulls the format string for `row` out of `format_col`. Returns `Ok(None)` for null
            "duration",
                        .collect::<Result<Vec<_>>>()?
        .unwrap();
/*
            ColumnarValue::Scalar(ScalarValue::Utf8(None)) => {}
    out
        None => Ok(None),
fn format_at(format_col: &ColumnarValue, row: usize) -> Result<Option<String>> {
        };
        ) => Ok(opt.clone()),
//! * `"duration_millis"` — integer milliseconds → `HH:MM:SS` wall-clock rendering.
        mode::HEX => format_hex_i64(value),
    fn return_type(&self, _arg_types: &[DataType]) -> Result<DataType> {
    }
                                Ok(None)
            ],
    }
    fn duration_negative_wraps_to_pre_epoch_clock_time() {
            )),
        // Trim a trailing '0' when exactly one digit would be meaningful, e.g. `.50 → .5`.
 * compatible open source license.
        format!("{:x}", v as u64)
    fn name(&self) -> &str {
            invoke_scalar(ScalarValue::Int64(Some(6500)), DataType::Int64, "duration").unwrap();
    }
}
fn format_commas_i64(v: i64) -> String {
        out.push('-');
            "duration_millis",
// `ScalarUDFImpl` requires DynEq+DynHash. All `ToStringUdf` instances are functionally
    format_col: &ColumnarValue,
    if frac != "00" {
            );
                                scalar_to_str(Some(typed.value(i)), format_col, i, format_f64_as)
                        .collect::<Result<Vec<_>>>()?
        )
    } else {
                ColumnarValue::Scalar(ScalarValue::Utf8(None)),
        "tostring".hash(state);
                ColumnarValue::Scalar(ScalarValue::Int64(Some(42))),
                            if typed.is_null(i) {
    fn default() -> Self {
//! * `"binary"` — number → base-2 string of its integer part. Negative values use the
        u.invoke_with_args(args)
    #[test]
            config_options: Arc::new(Default::default()),
        true
        // Work in i128 so i64::MIN doesn't overflow on abs.
    // Drop `.00` so integral values render without a decimal tail (`39225 → "39,225"`),
    let len = bytes.len();
    }
                    let out: StringArray = (0..typed.len())
            invoke_scalar(ScalarValue::Int64(Some(39225)), DataType::Int64, "binary").unwrap();
    #[test]
    Volatility,
    }
}
        };
//!
                let s = arr.as_string::<i32>();
            return_field,
            arg_fields: vec![
        }
        )
        .unwrap();
        value: ScalarValue,
                            } else {
    }
        let day = invoke_scalar(
        _ => value.to_string(),
        assert_eq!(utf8(out), "22:58:59");
    // reference emits a leading '-' via BigInteger's signed radix representation. We match
    }
    #[test]
/// (`ToStringFunction.DURATION_FORMAT`, etc.).
                        })
        let u = udf();
        let value_type = value.data_type().clone();
            "commas",
    use datafusion::arrow::datatypes::Field;
            ],
        // The format arg accepts any string variant — the body dispatches via
                                Ok(None)
                assert!(s.is_null(1));
    }
            ColumnarValue::Scalar(ScalarValue::Float64(value)) => Ok(ColumnarValue::Scalar(
            signature: Signature::one_of(exacts, Volatility::Immutable),
        let return_field = Arc::new(Field::new(u.name(), DataType::Utf8, true));
//!   a fractional component, otherwise no decimals.
        // StringArrayView so the producer's Utf8View doesn't get cast to Utf8
            arg_fields: vec![
            ScalarValue::Int64(Some(-3_661_000)),
}
        value_type: DataType,
    match format {
            ],
            other => panic!("expected Utf8(None), got {other:?}"),
                ScalarValue::Utf8(scalar_to_str(*value, format_col, 0, format_f64_as)?),
    fn signature(&self) -> &Signature {
//! Supported format values:
            DataType::Int64,
//! * `"hex"` — number → lowercase hexadecimal of its integer part. Negative values use
                    let out: StringArray = (0..typed.len())
            ],
        let u = udf();
use datafusion::logical_expr::{
    }
        mode::DURATION_MILLIS => format_duration_seconds(value.div_euclid(1_000)),
use datafusion::common::{exec_err, Result, ScalarValue};
        } else {
}
            ],
    let is_negative = v.is_sign_negative();
fn format_duration_seconds(total_seconds: i64) -> String {
    #[test]
impl Eq for ToStringUdf {}
    }
            DataType::Int64,
                .map_or(rendered.clone(), |s| s.to_string())
            arg_fields: vec![
                }
        let out = invoke_scalar(
        let out = invoke_array(array, "hex").unwrap();
        match out {
            out.push(',');
    formatter: fn(T, &str) -> String,
        let args = ScalarFunctionArgs {
    value as i64
            ScalarValue::Int64(Some(86_400)),
        let day_plus_hour = invoke_scalar(
    match format {
            }
mod mode {
    }
impl PartialEq for ToStringUdf {
        format!("{:b}", v as u64)
    }
    }
            ScalarValue::Int64(Some(6_500_999)),
    }
                                scalar_to_str(Some(typed.value(i)), format_col, i, format_i64_as)
 * SPDX-License-Identifier: Apache-2.0
mod tests {
/// `tostring(bigint, varchar)` / `tostring(fp64, varchar)` → varchar.
}
                Arc::new(Field::new("f", DataType::Utf8, true)),
    #[test]
        match &args.args[0] {
        }
                Arc::new(Field::new("f", DataType::Utf8, true)),
    }
        return 0;
        mode::COMMAS => format_commas_i64(value),
/// Render an `f64` value per the requested format. Mirrors the Java reference's strategy
        v.to_string()
        u.invoke_with_args(args)
    }
//! * `"duration"` — integer seconds → `HH:MM:SS` **wall-clock** rendering.
            other => panic!("expected array, got {other:?}"),
#[derive(Debug)]
            // Drop a trailing `.0` so `tostring(42.0)` reads as `"42"`, matching
//!
        let out = u.invoke_with_args(args).unwrap();
    fn invoke_array(value: ArrayRef, format: &str) -> Result<ColumnarValue> {
            other => panic!("expected Utf8 scalar, got {other:?}"),
use datafusion::execution::context::SessionContext;
            DataType::Float64,
        &self.signature
    if is_negative {
        )
        .unwrap();
    #[test]
fn insert_thousands_separators(digits: &str, out: &mut String) {
    fn udf() -> ToStringUdf {
    }
    fn null_format_yields_null() {
    }
    fn array_int_hex_with_scalar_format() {
            ColumnarValue::Array(arr) => {
        assert_eq!(utf8(out), "-101");
        out.push(*b as char);
        Self {
        Some(f) => Ok(Some(formatter(v, f.as_str()))),
    fn invoke_with_args(&self, args: ScalarFunctionArgs) -> Result<ColumnarValue> {
///   (null propagation).
            Ok(view.cell(row).map(|s| s.to_string()))
//!   the signed-magnitude representation `-xx` (matches `BigInteger.toString(16)`).
    fn array_float_commas_with_scalar_format() {
//! [`ToStringFunction`](https://github.com/opensearch-project/sql/blob/main/core/src/main/java/org/opensearch/sql/expression/function/udf/ToStringFunction.java)
        .split_once('.')
        let array: ArrayRef = Arc::new(Float64Array::from(vec![Some(1234.5), None, Some(0.0)]));
fn format_commas_f64(v: f64) -> String {
        ColumnarValue::Scalar(other) => {
            // decimals would print `"42"`.
}
        match v {
    fn duration_bigdecimal_positive_example() {
    }
            DataType::Float64,
                [DataType::Utf8, DataType::LargeUtf8, DataType::Utf8View]
                DataType::Float64 => {
    }
                    .map(move |fmt_ty| TypeSignature::Exact(vec![value_ty.clone(), fmt_ty]))
    }
}
            number_rows: 1,
/// * `row` — only used when `format_col` is an array; ignored for the scalar path.
            ColumnarValue::Scalar(ScalarValue::Utf8(Some(s))) => s,
    }
            if !value.is_finite() {
    #[test]
    // Same rationale as `format_binary_i64` — BigInteger.toString(16) on negatives prints
///   [`format_at`]; the row index is only consulted when the caller passed an array.
                let s = arr.as_string::<i32>();
        if args.args.len() != 2 {
            let view = crate::udf::json_common::StringArrayView::from_array(arr).map_err(|e| {
    }
}
    }
    };
    }
        format!("-{:b}", (v as i128).unsigned_abs())
/// Render an `i64` value per the requested format. Unknown modes fall through to plain
                    Ok(ColumnarValue::Array(Arc::new(out) as ArrayRef))
            invoke_scalar(ScalarValue::Int64(Some(3661)), DataType::Int64, "duration").unwrap();
use datafusion::arrow::datatypes::{DataType, Float64Type, Int64Type};
}
            out.push_str(frac);
        assert_eq!(utf8(day_plus_hour), "01:00:00");
        let out = invoke_scalar(
            "duration",
        match out {
        };
    // Mirrors `BigInteger.toString(2)` for positive values; for negatives the Java
    let (whole, frac) = rounded
pub fn register_all(ctx: &SessionContext) {
    fn duration_wraps_modulo_24h() {
            ColumnarValue::Array(arr) => {
                "tostring expects exactly 2 arguments (value, format), got {}",
                            }
    }
        return v.to_string();
                exec_err!("tostring: expected BIGINT or DOUBLE value, got {other:?}")
    pub fn new() -> Self {
    // that by formatting the absolute value and re-prepending the sign.
    let s = second_of_day % 60;
                assert_eq!(s.value(0), "1,234.5");
    pub const BINARY: &str = "binary";
    ColumnarValue, ScalarFunctionArgs, ScalarUDF, ScalarUDFImpl, Signature, TypeSignature,
        }
        mode::BINARY => format_binary_i64(truncate_to_i64(value)),
}
}
        }
                assert!(s.is_null(1));
            DataType::Int64,
}
    fn duration_millis_truncates_subseconds() {
    } else {
///
            invoke_scalar(ScalarValue::Int64(Some(39225)), DataType::Int64, "commas").unwrap();
//!   signed-magnitude representation `-1xxxx` (matches `BigInteger.toString(2)`).
use std::hash::{Hash, Hasher};
                    let typed = arr.as_primitive::<Int64Type>();
        mode::BINARY => format_binary_i64(value),
    }
) -> Result<Option<String>> {
                Arc::new(Field::new("v", value_type, true)),
            ScalarValue::Float64(Some(-3661.4)),
    }
 * this file be licensed under the Apache-2.0 license or a
                ScalarValue::Utf8(scalar_to_str(*value, format_col, 0, format_i64_as)?),
                Arc::new(Field::new("v", DataType::Int64, true)),
            ColumnarValue::Array(arr) => match arr.data_type() {
        mode::COMMAS => format_commas_f64(value),
        )
            ColumnarValue::Scalar(other) => {
    }
        .unwrap();
                Arc::new(Field::new("f", DataType::Utf8, true)),
    let mut out = String::with_capacity(rounded.len() + whole.len() / 3 + 2);
    fn hex_matches_bigint_tohex() {
}
    #[test]
    }
        .expect("{:.2} always produces a decimal point");
    ctx.register_udf(ScalarUDF::from(ToStringUdf::new()));
            .flat_map(|value_ty| {
/// Format a signed number of seconds to  wall-clock `HH:MM:SS` format
            return_field,
        )
                }
        }
    }
    fn duration_millis_negative_wraps_via_floor_div() {
            "commas",
        assert_eq!(utf8(out), "01:01:01");
    let Some(v) = value else {
        if from_right > 1 && (from_right - 1) % 3 == 0 {
            ColumnarValue::Scalar(ScalarValue::Utf8(None)) => {}
}
    }
        let out =
fn format_f64_as(value: f64, format: &str) -> String {
    if !v.is_finite() {
        assert_eq!(utf8(out), "01:48:20");
impl Hash for ToStringUdf {
        }
        let out = invoke_scalar(
            }
pub struct ToStringUdf {
    out
        // at the planner level.
        let out =
use datafusion::arrow::array::{Array, ArrayRef, AsArray, StringArray};
        format!("{}", (v as i128).unsigned_abs())
        if frac.ends_with('0') {
    pub const HEX: &str = "hex";
    insert_thousands_separators(whole, &mut out);
        let from_right = len - i;
    if !value.is_finite() {
            other => panic!("expected Utf8(None), got {other:?}"),
        Self::new()
                            } else {
    match format_col {
                assert_eq!(s.value(2), "0");
                DataType::Int64 => {
    insert_thousands_separators(&abs_str, &mut out);
    #[test]
            )),
    }
    ) -> Result<ColumnarValue> {
        }
    }
        .unwrap();
    }
    let mut out = String::with_capacity(abs_str.len() + abs_str.len() / 3 + 1);
                        .collect();
        assert_eq!(utf8(out), "01:48:20");
    #[test]
        let out = invoke_scalar(ScalarValue::Int64(None), DataType::Int64, "hex").unwrap();
use std::sync::Arc;
    fn invoke_scalar(
    }
    format!("{:02}:{:02}:{:02}", h, m, s)
            ScalarValue::Float64(Some(39225.0)),
    fn eq(&self, _: &Self) -> bool {
                        .into_iter()
        let out = invoke_scalar(ScalarValue::Int64(Some(42)), DataType::Int64, "xyzzy").unwrap();
        assert_eq!(utf8(out), "39,225");
    } else {
                        .map(|i| {
    let second_of_day = total_seconds.rem_euclid(86_400);
        }
        mode::HEX => format_hex_i64(truncate_to_i64(value)),
    match format {
};
    // Non-finite fall through to native rendering (matches Double.toString for Infinity/NaN).
// identical — there's no meaningful "parameterization" — so they compare equal and hash
    fn utf8(v: ColumnarValue) -> String {
                return value.to_string();
fn format_binary_i64(v: i64) -> String {
                assert_eq!(s.value(2), "ff");
            DataType::Float64,
        let args = ScalarFunctionArgs {
    fn commas_float_rounds_to_two_decimals() {
        let out = invoke_scalar(
            ],
        ToStringUdf::new()
        Ok(DataType::Utf8)
impl Default for ToStringUdf {
        let args = ScalarFunctionArgs {
        assert_eq!(utf8(out), "1001100100111001");
                        .map(|i| {
    }
        }
            DataType::Int64,
                        })
        assert_eq!(utf8(out), "9939");
// identically.
    }
fn format_i64_as(value: i64, format: &str) -> String {
        format: &str,
}
}
                .strip_suffix(".0")
    let rounded = format!("{:.2}", v.abs());
    let m = (second_of_day / 60) % 60;
    pub const DURATION_MILLIS: &str = "duration_millis";
        assert_eq!(utf8(out), "1,234.57");
        out.push('-');
    }
/// Format modes, case-sensitive to match the SQL plugin's Java reference
