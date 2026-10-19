    use datafusion::arrow::array::{Array, AsArray, BinaryArray};
        let args = ScalarFunctionArgs {
            number_rows: 3,
            arg_fields: vec![Arc::new(Field::new("v", DataType::Binary, true))],
        match u.invoke_with_args(args).unwrap() {
    }
        }
                let bin = arr.as_any().downcast_ref::<BinaryArray>().ok_or_else(|| {
            None,
//!   - IPv4-mapped IPv6 (10 zero bytes + `0xff 0xff` + 4 IPv4 bytes) → dotted-quad
 */
fn format_ip_bytes(bytes: &[u8]) -> Option<String> {
        let args = ScalarFunctionArgs {
        let bytes: Vec<u8> = vec![0x20, 0x01, 0x0d, 0xb8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1];
        }
impl ScalarUDFImpl for IpToStringUdf {
        }
        let v4 = ipv4_mapped_bytes(1, 2, 3, 4);
    }
    }
}
//! Buffers that aren't 16 bytes (defensive — should never happen for parquet-
    fn invoke_with_args(&self, args: ScalarFunctionArgs) -> Result<ColumnarValue> {
                vec![TypeSignature::Exact(vec![DataType::Binary])],
            }
        match v {
    }
            args: vec![ColumnarValue::Array(values)],
        assert_eq!(as_utf8(out).unwrap(), "1.2.3.4");
/// Format a 16-byte ipv6-mapped buffer the way OpenSearch core's
        let u = udf();
        bytes
    fn signature(&self) -> &Signature {
            ColumnarValue::Array(arr) => {
                let out: StringArray = (0..bin.len())
            bytes[12], bytes[13], bytes[14], bytes[15]
 * The OpenSearch Contributors require contributions made to
    fn formats_pure_ipv6_arbitrary() {
                        }
}
//!
            ColumnarValue::Scalar(ScalarValue::Binary(opt)) => Ok(ColumnarValue::Scalar(
}
use datafusion::arrow::array::{Array, ArrayRef, BinaryArray, StringArray};
            signature: Signature::one_of(
 * this file be licensed under the Apache-2.0 license or a
        &self.signature
        bytes[10] = 0xff;
        let out = invoke_scalar(ScalarValue::Binary(None)).unwrap();
    fn eq(&self, _: &Self) -> bool {
                Ok(ColumnarValue::Array(Arc::new(out) as ArrayRef))
            number_rows: 1,
                ScalarValue::Utf8(opt.as_ref().and_then(|b| format_ip_bytes(b))),
            "{}.{}.{}.{}",
    }
            ColumnarValue::Scalar(ScalarValue::Utf8(opt)) => opt,
    pub fn new() -> Self {
pub struct IpToStringUdf {
        assert_eq!(as_utf8(out).unwrap(), "2001:db8::1");
mod tests {
            Some(v6.as_slice()),
                Volatility::Immutable,
        let return_field = Arc::new(Field::new(u.name(), DataType::Utf8, true));
    if bytes.len() != 16 {
}
            Some(v4.as_slice()),
            ColumnarValue::Array(arr) => {
}
//!     `"a.b.c.d"` (matches what the legacy `IpFieldMapper` emits).
use std::hash::{Hash, Hasher};
use std::net::Ipv6Addr;
        let values: ArrayRef = Arc::new(BinaryArray::from_opt_vec(vec![
        "ip_to_string".hash(state);
        let return_field = Arc::new(Field::new(u.name(), DataType::Utf8, true));
        let mut v6 = vec![0u8; 16];
            }
    use datafusion::arrow::datatypes::Field;
use datafusion::logical_expr::{
impl Hash for IpToStringUdf {
                    ))
    fn default() -> Self {
        return Some(format!(
                "ip_to_string expects exactly 1 argument, got {}",
        // 2001:db8::1
        let out = invoke_scalar(ScalarValue::Binary(Some(bytes))).unwrap();
        match &args.args[0] {
    ColumnarValue, ScalarFunctionArgs, ScalarUDF, ScalarUDFImpl, Signature, TypeSignature,
use std::sync::Arc;
        let mut bytes = vec![0u8; 16];
    }
                    datafusion::common::DataFusionError::Execution(format!(
    #[test]
                        if bin.is_null(i) {
                exec_err!("ip_to_string: expected Binary input, got {other:?}")
        return None;
    fn formats_ipv4_mapped_as_dotted_quad() {
use datafusion::execution::context::SessionContext;
impl Eq for IpToStringUdf {}
                        arr.data_type()
        bytes[11] = 0xff;
#[derive(Debug)]
        v6[15] = 1;
            ColumnarValue::Scalar(other) => {
    fn wrong_length_yields_null() {
                assert_eq!(s.value(2), "::1");
            }
//! Bound from `IpBinaryCastFunctionAdapter` (Java) which rewrites
impl Default for IpToStringUdf {
            other => panic!("expected Utf8 scalar, got {other:?}"),
impl PartialEq for IpToStringUdf {
    fn return_type(&self, _arg_types: &[DataType]) -> Result<DataType> {
    #[test]
        };
                            format_ip_bytes(bin.value(i))
 * SPDX-License-Identifier: Apache-2.0
    // IPv4-mapped IPv6: 80 bits of zero, then 0xffff, then 4 bytes of IPv4.
            )),
                args.args.len()
    }
        "ip_to_string"
//! utf8)` kernel.
        true
/*
            ),
        assert!(as_utf8(out).is_none());
    }
        Self::new()
    Some(Ipv6Addr::from(arr).to_string())
use datafusion::common::{exec_err, Result, ScalarValue};
                    .map(|i| {
        bytes[13] = b;
    let arr: [u8; 16] = bytes.try_into().expect("checked length above");
        }
    ctx.register_udf(ScalarUDF::from(IpToStringUdf::new()));
    }
    #[test]
    }
    }
        if args.args.len() != 1 {
}
            other => panic!("expected Array, got {other:?}"),
        let out = invoke_scalar(ScalarValue::Binary(Some(vec![1, 2, 3, 4]))).unwrap();
            args: vec![ColumnarValue::Scalar(value)],
#[cfg(test)]
        assert!(as_utf8(out).is_none());
//!
        u.invoke_with_args(args)
    Volatility,
                        "ip_to_string: expected BinaryArray, got {:?}",
        let mut bytes = vec![0u8; 16];
    }
use datafusion::arrow::datatypes::DataType;
                let s = arr.as_string::<i32>();
    }
    #[test]
    #[test]
        let out = invoke_scalar(ScalarValue::Binary(Some(bytes))).unwrap();
}
    #[test]
    signature: Signature,
    fn array_input_preserves_null_mask() {
        Self {
    fn ipv4_mapped_bytes(a: u8, b: u8, c: u8, d: u8) -> Vec<u8> {
        ]));
        }
        ));
impl IpToStringUdf {
//!     (e.g. `"::1"`, `"2001:db8::1"`).
        bytes[15] = 1;
    fn formats_pure_ipv6_loopback() {
        Ok(DataType::Utf8)
};
                    .collect();
//! encoded ip columns) yield NULL rather than panic.
        bytes[15] = d;
            config_options: Arc::new(Default::default()),
        };
        bytes[12] = a;
        let out = invoke_scalar(ScalarValue::Binary(Some(ipv4_mapped_bytes(1, 2, 3, 4)))).unwrap();
    fn udf() -> IpToStringUdf {
    if bytes[..10].iter().all(|&b| b == 0) && bytes[10] == 0xff && bytes[11] == 0xff {
                assert!(s.is_null(1));
 * compatible open source license.
            );
//! formatted server-side by the analytics backend rather than getting
            return_field,
//!   - Pure IPv6 → `Ipv6Addr::to_string()`'s RFC 5952 compressed form
                        } else {
    fn null_input_yields_null() {
//! Output format matches OpenSearch core's `InetAddresses.toAddrString`:
    }
    fn hash<H: Hasher>(&self, state: &mut H) {
pub fn register_all(ctx: &SessionContext) {
//! ip_to_string(bytes) — render a 16-byte ipv6-mapped buffer as a canonical IP string.
    fn invoke_scalar(value: ScalarValue) -> Result<ColumnarValue> {
    fn as_utf8(v: ColumnarValue) -> Option<String> {
/// `ip_to_string(binary)` → `varchar`.
    use super::*;
//! buffer-reinterpreted as Latin-1 by DataFusion's built-in `cast(binary,
    fn name(&self) -> &str {
                    })
            config_options: Arc::new(Default::default()),
            arg_fields: vec![Arc::new(Field::new("v", DataType::Binary, true))],
    }
    }
}
    }
    }
//! `CAST(<IpType> AS VARCHAR)` to a call into this UDF, so the output is
// `ScalarUDFImpl` requires DynEq + DynHash. Stateless — all instances are equivalent.
        bytes[14] = c;
 *
//!
        let u = udf();
/// `InetAddresses.toAddrString` does. Returns `None` for buffers that aren't
        assert_eq!(as_utf8(out).unwrap(), "::1");
    }
}
                assert_eq!(s.value(0), "1.2.3.4");
    }
                            None
/// 16 bytes (defensive — should never happen for valid parquet-encoded ip data).
        IpToStringUdf::new()
            return_field,
                })?;
            return exec_err!(
