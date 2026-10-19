        assert_eq!(conv_one("-100", 10, 16), Some("-64".to_string()));
    #[test]
 * SPDX-License-Identifier: Apache-2.0
        let to: ArrayRef = Arc::new(Int64Array::from(vec![2, 10, 2]));
            }
                ColumnarValue::Array(to),
//! conv(n, fromBase, toBase) — base conversion. Mirrors PPL's `ConvFunction`:
    #[test]
    }
impl ScalarUDFImpl for ConvUdf {
            args: vec![
    fn coerce_types(&self, arg_types: &[DataType]) -> Result<Vec<DataType>> {
/*
            let from_base = from_int.value(i);
            _ => panic!("expected array output"),
            // out-of-range radix. testConvWithInvalidRadix asserts the message text matches
    use super::*;
/// Caller is responsible for validating the base range (so invalid radix surfaces as a
    }
}
    }
 * compatible open source license.
        let from_arr = args.args[1].clone().into_array(n)?;
udf_identity!(ConvUdf, "conv");
        }
            };
            .invoke_with_args(args)
    Some(format_radix(parsed, to_base as u32))
        // array may arrive as Utf8, LargeUtf8, or (on the data-node → coordinator wire)
            if from_base < 2 {
            .downcast_ref::<StringArray>()
            number_rows: 3,
    fn invoke_accepts_utf8view_input() {
    #[test]
        let mut builder = StringBuilder::with_capacity(n, n * 16);
    }
    signature: Signature,
        out.push('-');
                return exec_err!("radix {to_base} greater than Character.MAX_RADIX");
fn conv_one(s: &str, from_base: i64, to_base: i64) -> Option<String> {
use std::sync::Arc;
            ],
                return exec_err!("radix {to_base} less than Character.MIN_RADIX");
//! `Long.toString(Long.parseLong(n, fromBase), toBase)`. See
            signature: Signature::user_defined(Volatility::Immutable),
        use datafusion::arrow::array::{Int64Array, StringArray, StringViewArray};
                Some(s) => builder.append_value(&s),
        assert_eq!(conv_one("11", 10, 2), Some("1011".to_string()));
            config_options: Arc::new(datafusion::config::ConfigOptions::new()),
            arg_fields: vec![
        return "0".to_string();
        let args = ScalarFunctionArgs {
    }
/// Parse `s` as an integer in `from_base`, format in `to_base`. NULL on unparseable input.
 */
        // Utf8View. Read it through the variant-agnostic view rather than downcasting to a
                    builder.append_null();
            }
#[derive(Debug)]
    if negative {
    out.extend(digits.chars().rev());
        let n = args.number_rows;
    }
                ColumnarValue::Array(from),
    fn name(&self) -> &str {
                return exec_err!("radix {from_base} less than Character.MIN_RADIX");
            .expect("Utf8 output");
    let parsed = i64::from_str_radix(s.trim(), from_base as u32).ok()?;
            // verbatim — keep the Java phrasing so the rest layer's 5xx message contains it.
    fn decimal_to_binary() {
    #[test]
        for i in 0..n {
        }
use datafusion::execution::context::SessionContext;
            }
        digits.push(char::from_digit(d, base).unwrap());
            ],
/// `conv(varchar, integer, integer)` → `varchar`.
            arr.data_type()
    fn unparseable_yields_none() {
        &self.signature
        assert_eq!(conv_one("xyz", 10, 2), None);
                None => builder.append_null(),
        Ok(DataType::Utf8)
            &[CoerceMode::Utf8, CoerceMode::Int64, CoerceMode::Int64],
            ColumnarValue::Array(a) => a,
        )
fn format_radix(value: i64, base: u32) -> String {
    #[test]
        let from_int = downcast_i64(&from_arr, "fromBase")?;
}
}
    fn signature(&self) -> &Signature {
        let to_int = downcast_i64(&to_arr, "toBase")?;
        // 1732835878 base 10 → base 36 = "snoopy" (matches testConvNegateValue).
        // Strings cross the data-node → coordinator wire as Utf8View; CoerceMode::Utf8
    fn output_is_lowercase_to_match_java_long_tostring() {
        let from: ArrayRef = Arc::new(Int64Array::from(vec![10, 16, 10]));
    #[test]
    }
                return exec_err!("radix {from_base} greater than Character.MAX_RADIX");
impl ConvUdf {
}
                ColumnarValue::Array(n),
    fn zero_round_trip() {
    pub fn new() -> Self {
        let s = arr
        }
            .as_any()
        let out = ConvUdf::new()
            "conv",
    if value == 0 {
        let arr = match out {
    let mut out = String::with_capacity(digits.len() + 1);
}
        assert_eq!(conv_one("FF", 16, 10), Some("255".to_string()));
    // i128 path so i64::MIN's absolute value doesn't overflow. Lowercase digits to
mod tests {
            }
                    continue;
    fn invoke_with_args(&self, args: ScalarFunctionArgs) -> Result<ColumnarValue> {
            .expect("conv must accept Utf8View");
        // i64::from_str_radix accepts both cases for input digits.
        DataFusionError::Internal(format!(
    fn hex_to_decimal_uppercase_input() {
use datafusion::arrow::datatypes::DataType;
            }
        assert_eq!(conv_one("29234652", 10, 36), Some("hello".to_string()));
    ColumnarValue, ScalarFunctionArgs, ScalarUDF, ScalarUDFImpl, Signature, Volatility,
        assert_eq!(s.value(1), "255"); // FF base16 → base10
//! `sql/core/.../ConvFunction.java`. NULL for invalid input / unsupported base.
 * The OpenSearch Contributors require contributions made to
    fn negative_round_trip() {
    let negative = value < 0;
                }
        // rather than downcasting to StringArray (Utf8).
    })
    let mut digits = String::new();
        let n_arr = args.args[0].clone().into_array(n)?;
            if from_base > 36 {
    ctx.register_udf(ScalarUDF::from(ConvUdf::new()));
        let to_arr = args.args[2].clone().into_array(n)?;
fn downcast_i64<'a>(arr: &'a ArrayRef, slot: &str) -> Result<&'a Int64Array> {
        abs /= base as u128;
            // PPL's ConvFunction surfaces Java's Long.parseLong NumberFormatException for
            return exec_err!("conv expects exactly 3 arguments, got {}", args.args.len());
        };
        let d = (abs % base as u128) as u32;
                Arc::new(Field::new("from", DataType::Int64, true)),
            return_field: Arc::new(Field::new("out", DataType::Utf8, true)),
#[cfg(test)]
        let n_str = StringArrayView::from_array(&n_arr)?;
    }
    }
    }
    }
    }
 *
        "conv"
            arg_types,
            if to_base > 36 {
    out
    while abs > 0 {
use datafusion::arrow::array::{Array, ArrayRef, Int64Array, StringBuilder};
        ))
    }
    fn return_type(&self, _arg_types: &[DataType]) -> Result<DataType> {
}
};
        assert_eq!(conv_one("0", 10, 36), Some("0".to_string()));
        // single concrete array type.
    }
                Arc::new(Field::new("n", DataType::Utf8View, true)),
    }
        assert!(s.is_null(2)); // null input → null
 * this file be licensed under the Apache-2.0 license or a
                Some(v) if !from_int.is_null(i) && !to_int.is_null(i) => v,
                _ => {
use super::{coerce_args, udf_identity, CoerceMode};
    }
    let mut abs = (value as i128).unsigned_abs();
use super::json_common::StringArrayView;
            "conv: slot '{slot}' expected Int64 post-coerce, got {:?}",
        if args.args.len() != 3 {
    // tests that assert against lowercased base-36 strings ("snoopy", "hello").
use datafusion::logical_expr::{
        assert_eq!(conv_one("1732835878", 10, 36), Some("snoopy".to_string()));
/// hard error, matching Java's `NumberFormatException`).
            let n_val = match n_str.cell(i) {
                Arc::new(Field::new("to", DataType::Int64, true)),
        coerce_args(
pub fn register_all(ctx: &SessionContext) {
            let to_base = to_int.value(i);
pub struct ConvUdf {
        // passes the variant through, so conv must read the StringViewArray directly
    #[test]
use datafusion::common::{exec_err, DataFusionError, Result};
        assert_eq!(s.value(0), "1011"); // 11 base10 → base2
            match conv_one(n_val, from_base, to_base) {
            if to_base < 2 {
        // n is a string slot. CoerceMode::Utf8 passes the variant through unchanged, so the
    arr.as_any().downcast_ref::<Int64Array>().ok_or_else(|| {
}
        Self {
        };
}
    // match Java's `Long.toString(long, int radix)` — uppercase here would fail
        let n: ArrayRef = Arc::new(StringViewArray::from(vec![Some("11"), Some("FF"), None]));
        Ok(ColumnarValue::Array(Arc::new(builder.finish()) as ArrayRef))
        // 29234652 base 10 → base 36 = "hello" (matches testConvAndLower).
        use datafusion::arrow::datatypes::Field;
