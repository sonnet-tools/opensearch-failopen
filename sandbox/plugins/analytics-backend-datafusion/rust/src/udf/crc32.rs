};
            | ColumnarValue::Scalar(ScalarValue::LargeUtf8(opt)) => Ok(ColumnarValue::Scalar(
        let return_field = Arc::new(Field::new(u.name(), DataType::Int64, true));
use datafusion::arrow::datatypes::DataType;
            ColumnarValue::Array(arr) => {
            number_rows: 1,
                };
            ),
        }
impl ScalarUDFImpl for Crc32Udf {
        let u = udf();
    use super::*;
            return exec_err!("crc32 expects exactly 1 argument, got {}", args.args.len());
        let args = ScalarFunctionArgs {
            other => panic!("expected Int64 scalar, got {other:?}"),
use datafusion::common::{exec_err, Result, ScalarValue};
            return_field,
                ScalarValue::Int64(opt.as_ref().map(|s| hash_u32_to_i64(s.as_bytes()))),
    fn hash<H: Hasher>(&self, state: &mut H) {
        // negative sign-extended i32.
            arg_fields: vec![Arc::new(Field::new("v", DataType::Utf8, true))],
        match v {
    ctx.register_udf(ScalarUDF::from(Crc32Udf::new()));
        };
        let out = invoke_scalar(ScalarValue::Utf8(Some("123456789".to_string()))).unwrap();
use datafusion::arrow::array::{Array, ArrayRef, AsArray, Int64Array};
    use datafusion::arrow::datatypes::Field;
    #[test]
        "crc32".hash(state);
    }
/*
        Crc32Udf::new()
                    }
#[derive(Debug)]
    }
 * The OpenSearch Contributors require contributions made to
                Volatility::Immutable,
fn hash_u32_to_i64(value: &[u8]) -> i64 {
    fn empty_input_is_zero() {
                assert_eq!(ints.value(0), 0xE8B7_BE43);
impl Eq for Crc32Udf {}
    #[test]
}
                let out: Int64Array = match arr.data_type() {
                        .collect(),
    // See https://rosettacode.org/wiki/CRC-32#Rust for the canonical vector.
                        .iter()
use datafusion::logical_expr::{
    }
    fn array_input_preserves_null_mask() {
        match &args.args[0] {
        "crc32"
                        .as_string::<i32>()
// `ScalarUDFImpl` requires DynEq + DynHash. All instances are functionally identical
                    DataType::LargeUtf8 => arr
    }
            }
                        return exec_err!("crc32: expected Utf8 array, got {other:?}");
        assert_eq!(got, 0xCBF4_3926);
            return_field,
        let out = invoke_scalar(ScalarValue::Utf8(None)).unwrap();
    #[test]
                let ints = arr.as_primitive::<datafusion::arrow::datatypes::Int64Type>();
                    TypeSignature::Exact(vec![DataType::LargeUtf8]),
        // 0xFFFFFFFF ≈ 4.29e9; must fit as a positive i64 (zero-extended), never a
            args: vec![ColumnarValue::Array(values)],
    fn signature(&self) -> &Signature {
    ColumnarValue, ScalarFunctionArgs, ScalarUDF, ScalarUDFImpl, Signature, TypeSignature,
        // Reference vector for "123456789" = 0xCBF43926.
    }
            args: vec![ColumnarValue::Scalar(value)],
                Ok(ColumnarValue::Array(Arc::new(out) as ArrayRef))
    fn result_is_always_non_negative() {
    }
        true
    // Standard reference: crc32("") == 0, crc32("a") == 0xE8B7BE43.
                    other => {
 *
    fn invoke_with_args(&self, args: ScalarFunctionArgs) -> Result<ColumnarValue> {
        let out = invoke_scalar(ScalarValue::Utf8(Some("a".to_string()))).unwrap();
    fn null_input_yields_null() {
use std::sync::Arc;
                        .collect(),
use datafusion::execution::context::SessionContext;
 * compatible open source license.
//! crc32(input): CRC-32 (IEEE 802.3 polynomial) of the UTF-8 byte stream of `input`.
 * this file be licensed under the Apache-2.0 license or a
        }
        }
impl Default for Crc32Udf {
            config_options: Arc::new(Default::default()),
                        .as_string::<i64>()
    fn invoke_scalar(value: ScalarValue) -> Result<ColumnarValue> {
}
    }
        };
    fn default() -> Self {
            }
    }
        let out = invoke_scalar(ScalarValue::Utf8(Some(String::new()))).unwrap();
    Volatility,
/// `crc32(varchar)` → `bigint`. Non-negative integer in the range [0, 2^32 - 1].
    }
        assert_eq!(as_i64(out), Some(0));
    }
impl PartialEq for Crc32Udf {
        let u = udf();
    #[test]
    #[test]
/// IEEE 802.3 CRC-32, zero-extended to i64 so the value stays non-negative.
                        .map(|opt| opt.map(|s| hash_u32_to_i64(s.as_bytes())))
        Self {
        let return_field = Arc::new(Field::new(u.name(), DataType::Int64, true));
impl Hash for Crc32Udf {
// (no parameterization), so equality is trivial.
impl Crc32Udf {
            ColumnarValue::Scalar(ScalarValue::Int64(opt)) => opt,
                assert!(ints.is_null(1));
}
pub struct Crc32Udf {
                    TypeSignature::Exact(vec![DataType::Utf8]),
pub fn register_all(ctx: &SessionContext) {
                vec![
        let values: ArrayRef = Arc::new(StringArray::from(vec![Some("a"), None, Some("")]));
        let args = ScalarFunctionArgs {
            ColumnarValue::Scalar(other) => exec_err!("crc32: expected Utf8 input, got {other:?}"),
        }
    fn as_i64(v: ColumnarValue) -> Option<i64> {
mod tests {
    signature: Signature,
        assert!(got >= 0, "crc32 must be non-negative, got {got}");
    fn return_type(&self, _arg_types: &[DataType]) -> Result<DataType> {
                        .iter()
    }
    }
            number_rows: 3,
    fn udf() -> Crc32Udf {
        match u.invoke_with_args(args).unwrap() {
                assert_eq!(ints.value(2), 0);
 * SPDX-License-Identifier: Apache-2.0
}
#[cfg(test)]
}
        &self.signature
}
}
    use datafusion::arrow::array::StringArray;
            ColumnarValue::Array(arr) => {
        }
            config_options: Arc::new(Default::default()),
}
 */
        if args.args.len() != 1 {
                ],
            other => panic!("expected Array, got {other:?}"),
        Self::new()
    }
    fn eq(&self, _: &Self) -> bool {
    }
                    DataType::Utf8 => arr
            arg_fields: vec![Arc::new(Field::new("v", DataType::Utf8, true))],
        Ok(DataType::Int64)
        assert_eq!(as_i64(out), Some(0xE8B7_BE43));
    fn name(&self) -> &str {
    fn single_char_matches_reference_vector() {
use std::hash::{Hash, Hasher};
}
                        .map(|opt| opt.map(|s| hash_u32_to_i64(s.as_bytes())))
            ColumnarValue::Scalar(ScalarValue::Utf8(opt))
    }
        u.invoke_with_args(args)
            )),
    pub fn new() -> Self {
        let got = as_i64(out).unwrap();
        assert!(as_i64(out).is_none());
            signature: Signature::one_of(
    crc32fast::hash(value) as i64
    }
