                ColumnarValue::Array(n),
        let out = ConvUdf::new()
    })
    // i128 path so i64::MIN's absolute value doesn't overflow. Lowercase digits to
        // n is a string slot. CoerceMode::Utf8 passes the variant through unchanged, so the
        // 29234652 base 10 → base 36 = "hello" (matches testConvAndLower).
    Some(format_radix(parsed, to_base as u32))
        use datafusion::arrow::datatypes::Field;
                return exec_err!("radix {from_base} less than Character.MIN_RADIX");
                    builder.append_null();
        let arr = match out {
        assert_eq!(conv_one("29234652", 10, 36), Some("hello".to_string()));
            number_rows: 3,
    // match Java's `Long.toString(long, int radix)` — uppercase here would fail
//! `sql/core/.../ConvFunction.java`. NULL for invalid input / unsupported base.
mod tests {
        coerce_args(
        // 1732835878 base 10 → base 36 = "snoopy" (matches testConvNegateValue).
            // PPL's ConvFunction surfaces Java's Long.parseLong NumberFormatException for
    }
    #[test]
        let to_arr = args.args[2].clone().into_array(n)?;
        let to: ArrayRef = Arc::new(Int64Array::from(vec![2, 10, 2]));
            let n_val = match n_str.cell(i) {
}
            if from_base > 36 {
        assert_eq!(conv_one("FF", 16, 10), Some("255".to_string()));
        let d = (abs % base as u128) as u32;
                Arc::new(Field::new("to", DataType::Int64, true)),
        let s = arr
#[cfg(test)]
        Ok(ColumnarValue::Array(Arc::new(builder.finish()) as ArrayRef))
    arr.as_any().downcast_ref::<Int64Array>().ok_or_else(|| {
}
            &[CoerceMode::Utf8, CoerceMode::Int64, CoerceMode::Int64],
        }
    if negative {
use datafusion::arrow::datatypes::DataType;
    }
        )
        assert_eq!(s.value(1), "255"); // FF base16 → base10
    #[test]
            if to_base < 2 {
            ],
        let n: ArrayRef = Arc::new(StringViewArray::from(vec![Some("11"), Some("FF"), None]));
                return exec_err!("radix {to_base} greater than Character.MAX_RADIX");
                None => builder.append_null(),
}
fn format_radix(value: i64, base: u32) -> String {
    }
    out.extend(digits.chars().rev());
/// `conv(varchar, integer, integer)` → `varchar`.
    }
//! conv(n, fromBase, toBase) — base conversion. Mirrors PPL's `ConvFunction`:
use super::{coerce_args, udf_identity, CoerceMode};
        assert_eq!(s.value(0), "1011"); // 11 base10 → base2
        Self {
 *
            }
impl ScalarUDFImpl for ConvUdf {
    use super::*;
        }
 */
            _ => panic!("expected array output"),
}
        let n_arr = args.args[0].clone().into_array(n)?;
    // tests that assert against lowercased base-36 strings ("snoopy", "hello").
}
        let from_arr = args.args[1].clone().into_array(n)?;
    }
        DataFusionError::Internal(format!(
    #[test]
        out.push('-');
            if to_base > 36 {
            };
            signature: Signature::user_defined(Volatility::Immutable),
        // rather than downcasting to StringArray (Utf8).
}
        assert!(s.is_null(2)); // null input → null
        assert_eq!(conv_one("-100", 10, 16), Some("-64".to_string()));
    fn invoke_with_args(&self, args: ScalarFunctionArgs) -> Result<ColumnarValue> {
use datafusion::common::{exec_err, DataFusionError, Result};
pub struct ConvUdf {
        if args.args.len() != 3 {
                return exec_err!("radix {from_base} greater than Character.MAX_RADIX");
udf_identity!(ConvUdf, "conv");
            ],
    fn name(&self) -> &str {
        return "0".to_string();
    fn negative_round_trip() {
        let n = args.number_rows;
    fn unparseable_yields_none() {
    pub fn new() -> Self {
        abs /= base as u128;
    let negative = value < 0;
    fn output_is_lowercase_to_match_java_long_tostring() {
            if from_base < 2 {
    }
    }
        let mut builder = StringBuilder::with_capacity(n, n * 16);
    }
    fn coerce_types(&self, arg_types: &[DataType]) -> Result<Vec<DataType>> {
    out
                Some(s) => builder.append_value(&s),
        for i in 0..n {
        // Strings cross the data-node → coordinator wire as Utf8View; CoerceMode::Utf8
    let mut abs = (value as i128).unsigned_abs();
            "conv: slot '{slot}' expected Int64 post-coerce, got {:?}",
    signature: Signature,
    fn zero_round_trip() {
                Some(v) if !from_int.is_null(i) && !to_int.is_null(i) => v,
            // verbatim — keep the Java phrasing so the rest layer's 5xx message contains it.
            return_field: Arc::new(Field::new("out", DataType::Utf8, true)),
        assert_eq!(conv_one("0", 10, 36), Some("0".to_string()));
        };
use datafusion::arrow::array::{Array, ArrayRef, Int64Array, StringBuilder};
        }
        let n_str = StringArrayView::from_array(&n_arr)?;
 * The OpenSearch Contributors require contributions made to
//! `Long.toString(Long.parseLong(n, fromBase), toBase)`. See
        };
                ColumnarValue::Array(from),
 * SPDX-License-Identifier: Apache-2.0
            arr.data_type()
use std::sync::Arc;
/// Parse `s` as an integer in `from_base`, format in `to_base`. NULL on unparseable input.
    ColumnarValue, ScalarFunctionArgs, ScalarUDF, ScalarUDFImpl, Signature, Volatility,
    while abs > 0 {
    fn hex_to_decimal_uppercase_input() {
            arg_types,
    fn signature(&self) -> &Signature {
        assert_eq!(conv_one("1732835878", 10, 36), Some("snoopy".to_string()));
    ctx.register_udf(ScalarUDF::from(ConvUdf::new()));
    }
}
        Ok(DataType::Utf8)
    fn return_type(&self, _arg_types: &[DataType]) -> Result<DataType> {
                Arc::new(Field::new("from", DataType::Int64, true)),
            // out-of-range radix. testConvWithInvalidRadix asserts the message text matches
                Arc::new(Field::new("n", DataType::Utf8View, true)),
        // single concrete array type.
        // Utf8View. Read it through the variant-agnostic view rather than downcasting to a
    #[test]
            "conv",
/// hard error, matching Java's `NumberFormatException`).
    }
fn downcast_i64<'a>(arr: &'a ArrayRef, slot: &str) -> Result<&'a Int64Array> {
    #[test]
    let mut digits = String::new();
        "conv"
            .as_any()
    }
    }
/*
        &self.signature
            .invoke_with_args(args)
        assert_eq!(conv_one("xyz", 10, 2), None);
                _ => {
            config_options: Arc::new(datafusion::config::ConfigOptions::new()),
            .downcast_ref::<StringArray>()
        ))
    }
    #[test]
    let mut out = String::with_capacity(digits.len() + 1);
            let to_base = to_int.value(i);
        let to_int = downcast_i64(&to_arr, "toBase")?;
            }
}
                }
    fn decimal_to_binary() {
use datafusion::logical_expr::{
 * this file be licensed under the Apache-2.0 license or a
            return exec_err!("conv expects exactly 3 arguments, got {}", args.args.len());
#[derive(Debug)]
        let from: ArrayRef = Arc::new(Int64Array::from(vec![10, 16, 10]));
            .expect("conv must accept Utf8View");
            match conv_one(n_val, from_base, to_base) {
impl ConvUdf {
            args: vec![
    }
    }
            }
            }
        digits.push(char::from_digit(d, base).unwrap());
        assert_eq!(conv_one("11", 10, 2), Some("1011".to_string()));
use datafusion::execution::context::SessionContext;
            ColumnarValue::Array(a) => a,
    if value == 0 {
    }
    fn invoke_accepts_utf8view_input() {
        let args = ScalarFunctionArgs {
            }
};
                ColumnarValue::Array(to),
/// Caller is responsible for validating the base range (so invalid radix surfaces as a
fn conv_one(s: &str, from_base: i64, to_base: i64) -> Option<String> {
pub fn register_all(ctx: &SessionContext) {
use super::json_common::StringArrayView;
                    continue;
                return exec_err!("radix {to_base} less than Character.MIN_RADIX");
            .expect("Utf8 output");
        let from_int = downcast_i64(&from_arr, "fromBase")?;
        // array may arrive as Utf8, LargeUtf8, or (on the data-node → coordinator wire)
    #[test]
 * compatible open source license.
        use datafusion::arrow::array::{Int64Array, StringArray, StringViewArray};
            let from_base = from_int.value(i);
    let parsed = i64::from_str_radix(s.trim(), from_base as u32).ok()?;
            arg_fields: vec![
        // passes the variant through, so conv must read the StringViewArray directly
        // i64::from_str_radix accepts both cases for input digits.
