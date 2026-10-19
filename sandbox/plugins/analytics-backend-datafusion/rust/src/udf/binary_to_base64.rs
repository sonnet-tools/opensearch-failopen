    }
            ColumnarValue::Scalar(other) => {
 * The OpenSearch Contributors require contributions made to
}
                    datafusion::common::DataFusionError::Execution(format!(
// `ScalarUDFImpl` requires DynEq + DynHash. Stateless — all instances are equivalent.
        let return_field = Arc::new(Field::new(u.name(), DataType::Utf8, true));
            config_options: Arc::new(Default::default()),
#[cfg(test)]
    Volatility,
    fn signature(&self) -> &Signature {
        true
    pub fn new() -> Self {
//! `binary` field wire contract.
impl PartialEq for BinaryToBase64Udf {
        Ok(DataType::Utf8)
        let out = invoke_scalar(ScalarValue::Binary(None)).unwrap();
    }
 * this file be licensed under the Apache-2.0 license or a
        "binary_to_base64"
                        "binary_to_base64: expected BinaryArray, got {:?}",
}
    }
 */
 * compatible open source license.
            None,
    }
pub struct BinaryToBase64Udf {
        }
    fn array_input_preserves_null_mask() {
impl Default for BinaryToBase64Udf {
    }
        // | fields binary_value already returns "U29tZSBiaW5hcnkgYmxvYg==" today.
                            Some(STANDARD.encode(bin.value(i)))
    fn as_utf8(v: ColumnarValue) -> Option<String> {
            return exec_err!(
            ),
use datafusion::arrow::datatypes::DataType;
    }
                "binary_to_base64 expects exactly 1 argument, got {}",
mod tests {
        u.invoke_with_args(args)
            }
                        arr.data_type()
//! `CAST(<BinaryType> AS VARCHAR)` to a call into this UDF, so the output
            ColumnarValue::Scalar(ScalarValue::Binary(opt)) => Ok(ColumnarValue::Scalar(
    fn round_trips_known_payload() {
        let u = udf();
            return_field,
                        } else {
            ColumnarValue::Array(arr) => {
    }
use datafusion::logical_expr::{
}
impl Hash for BinaryToBase64Udf {
    use datafusion::arrow::array::{Array, AsArray, BinaryArray};
                    .map(|i| {
    }
        let values: ArrayRef = Arc::new(BinaryArray::from_opt_vec(vec![
use base64::{engine::general_purpose::STANDARD, Engine as _};
            return_field,
pub fn register_all(ctx: &SessionContext) {
        match u.invoke_with_args(args).unwrap() {
                    })
                exec_err!("binary_to_base64: expected Binary input, got {other:?}")
                Ok(ColumnarValue::Array(Arc::new(out) as ArrayRef))
                ScalarValue::Utf8(opt.as_ref().map(|b| STANDARD.encode(b))),
        Self {
use std::hash::{Hash, Hasher};
/// `binary_to_base64(binary)` → `varchar`.
        match &args.args[0] {
//! binary_to_base64(bytes) — base64-encode a binary buffer per the OpenSearch
/*
                            None
    fn empty_input_yields_empty_string() {
    }
        // "Some binary blob" is what the test fixture stores in binary_value;
            }
        let args = ScalarFunctionArgs {
    fn eq(&self, _: &Self) -> bool {
        };
            ColumnarValue::Scalar(ScalarValue::Utf8(opt)) => opt,
        let args = ScalarFunctionArgs {
            Some(b"".as_ref()),
            number_rows: 1,
    #[test]
        }
            number_rows: 3,
            config_options: Arc::new(Default::default()),
use datafusion::execution::context::SessionContext;
impl Eq for BinaryToBase64Udf {}
                let out: StringArray = (0..bin.len())
    fn name(&self) -> &str {
    fn default() -> Self {
    }
        let out = invoke_scalar(ScalarValue::Binary(Some(b"Some binary blob".to_vec()))).unwrap();
//! buffer-reinterpreted as Latin-1 by DataFusion's built-in `cast(binary,
    fn udf() -> BinaryToBase64Udf {
        &self.signature
}
        assert_eq!(as_utf8(out).unwrap(), "U29tZSBiaW5hcnkgYmxvYg==");
            other => panic!("expected Array, got {other:?}"),
            )),
impl BinaryToBase64Udf {
use std::sync::Arc;
}
                        if bin.is_null(i) {
use datafusion::common::{exec_err, Result, ScalarValue};
        };
                    ))
        if args.args.len() != 1 {
                args.args.len()
    }
    #[test]
};
//! utf8)` kernel.
    fn invoke_scalar(value: ScalarValue) -> Result<ColumnarValue> {
                vec![TypeSignature::Exact(vec![DataType::Binary])],
//! matches what `| fields binary_value` already returns instead of getting
    ctx.register_udf(ScalarUDF::from(BinaryToBase64Udf::new()));
        "binary_to_base64".hash(state);
                    .collect();
#[derive(Debug)]
    #[test]
        }
            Some(b"Some binary blob".as_ref()),
        let u = udf();
        ]));
    fn invoke_with_args(&self, args: ScalarFunctionArgs) -> Result<ColumnarValue> {
            other => panic!("expected Utf8 scalar, got {other:?}"),
    fn null_input_yields_null() {
    #[test]
            signature: Signature::one_of(
    ColumnarValue, ScalarFunctionArgs, ScalarUDF, ScalarUDFImpl, Signature, TypeSignature,
}
            );
        let out = invoke_scalar(ScalarValue::Binary(Some(Vec::new()))).unwrap();
    signature: Signature,
                let bin = arr.as_any().downcast_ref::<BinaryArray>().ok_or_else(|| {
}
        BinaryToBase64Udf::new()
            arg_fields: vec![Arc::new(Field::new("v", DataType::Binary, true))],
}
    fn return_type(&self, _arg_types: &[DataType]) -> Result<DataType> {
                let s = arr.as_string::<i32>();
            ColumnarValue::Array(arr) => {
    use datafusion::arrow::datatypes::Field;
    }
    fn hash<H: Hasher>(&self, state: &mut H) {
    }
impl ScalarUDFImpl for BinaryToBase64Udf {
    use super::*;
            arg_fields: vec![Arc::new(Field::new("v", DataType::Binary, true))],
            args: vec![ColumnarValue::Array(values)],
 * SPDX-License-Identifier: Apache-2.0
        assert_eq!(as_utf8(out).unwrap(), "");
        }
        let return_field = Arc::new(Field::new(u.name(), DataType::Utf8, true));
        Self::new()
        }
    }
        assert!(as_utf8(out).is_none());
                })?;
                        }
            args: vec![ColumnarValue::Scalar(value)],
                assert_eq!(s.value(0), "U29tZSBiaW5hcnkgYmxvYg==");
use datafusion::arrow::array::{Array, ArrayRef, BinaryArray, StringArray};
//!
    }
            }
 *
//! Bound from `IpBinaryCastFunctionAdapter` (Java) which rewrites
        match v {
                Volatility::Immutable,
                assert_eq!(s.value(2), "");
                assert!(s.is_null(1));
