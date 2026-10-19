        return None;
    fn signature(&self) -> &Signature {
use std::sync::Arc;
}
                    datafusion::common::DataFusionError::Execution(format!(
impl IpToStringUdf {
    let arr: [u8; 16] = bytes.try_into().expect("checked length above");
    }
        let mut v6 = vec![0u8; 16];
    if bytes[..10].iter().all(|&b| b == 0) && bytes[10] == 0xff && bytes[11] == 0xff {
                assert!(s.is_null(1));
 *
//! buffer-reinterpreted as Latin-1 by DataFusion's built-in `cast(binary,
    }
        u.invoke_with_args(args)
        let values: ArrayRef = Arc::new(BinaryArray::from_opt_vec(vec![
    fn wrong_length_yields_null() {
    fn eq(&self, _: &Self) -> bool {
        if args.args.len() != 1 {
    }
use datafusion::common::{exec_err, Result, ScalarValue};
//! formatted server-side by the analytics backend rather than getting
            )),
        let args = ScalarFunctionArgs {
                })?;
    fn null_input_yields_null() {
        assert!(as_utf8(out).is_none());
            ),
    }
            arg_fields: vec![Arc::new(Field::new("v", DataType::Binary, true))],
        }
// `ScalarUDFImpl` requires DynEq + DynHash. Stateless — all instances are equivalent.
    }
                        }
//!   - IPv4-mapped IPv6 (10 zero bytes + `0xff 0xff` + 4 IPv4 bytes) → dotted-quad
    fn array_input_preserves_null_mask() {
        bytes[12] = a;
        let out = invoke_scalar(ScalarValue::Binary(Some(ipv4_mapped_bytes(1, 2, 3, 4)))).unwrap();
                let bin = arr.as_any().downcast_ref::<BinaryArray>().ok_or_else(|| {
    // IPv4-mapped IPv6: 80 bits of zero, then 0xffff, then 4 bytes of IPv4.
            number_rows: 1,
        assert!(as_utf8(out).is_none());
            return_field,
};
            ColumnarValue::Array(arr) => {
                    })
                vec![TypeSignature::Exact(vec![DataType::Binary])],
//! Output format matches OpenSearch core's `InetAddresses.toAddrString`:
        let mut bytes = vec![0u8; 16];
        bytes[11] = 0xff;
        };
 * The OpenSearch Contributors require contributions made to
        &self.signature
    if bytes.len() != 16 {
        Self::new()
    }
//!
        bytes[10] = 0xff;
 * this file be licensed under the Apache-2.0 license or a
    signature: Signature,
}
            "{}.{}.{}.{}",
    #[test]
            }
    fn formats_ipv4_mapped_as_dotted_quad() {
                let out: StringArray = (0..bin.len())
    }
            bytes[12], bytes[13], bytes[14], bytes[15]
fn format_ip_bytes(bytes: &[u8]) -> Option<String> {
            number_rows: 3,
    }
        Self {
/// `InetAddresses.toAddrString` does. Returns `None` for buffers that aren't
        return Some(format!(
    }
        bytes[15] = 1;
                        } else {
 */
            }
                    ))
    }
                            None
                exec_err!("ip_to_string: expected Binary input, got {other:?}")
        }
pub fn register_all(ctx: &SessionContext) {
//!
        let u = udf();
        let bytes: Vec<u8> = vec![0x20, 0x01, 0x0d, 0xb8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1];
            ColumnarValue::Scalar(ScalarValue::Utf8(opt)) => opt,
//! utf8)` kernel.
//!   - Pure IPv6 → `Ipv6Addr::to_string()`'s RFC 5952 compressed form
        let out = invoke_scalar(ScalarValue::Binary(Some(vec![1, 2, 3, 4]))).unwrap();
        let out = invoke_scalar(ScalarValue::Binary(Some(bytes))).unwrap();
    #[test]
    }
        IpToStringUdf::new()
    }
                        arr.data_type()
    pub fn new() -> Self {
                ScalarValue::Utf8(opt.as_ref().and_then(|b| format_ip_bytes(b))),
        match u.invoke_with_args(args).unwrap() {
    fn hash<H: Hasher>(&self, state: &mut H) {
    fn name(&self) -> &str {
impl Default for IpToStringUdf {
use std::hash::{Hash, Hasher};
//! Buffers that aren't 16 bytes (defensive — should never happen for parquet-
 * compatible open source license.
                    .map(|i| {
impl PartialEq for IpToStringUdf {
        match v {
            other => panic!("expected Array, got {other:?}"),
            );
}
use datafusion::execution::context::SessionContext;
    }
//! ip_to_string(bytes) — render a 16-byte ipv6-mapped buffer as a canonical IP string.
#[cfg(test)]
        ]));
        bytes[14] = c;
use datafusion::arrow::datatypes::DataType;
    }
impl ScalarUDFImpl for IpToStringUdf {
use std::net::Ipv6Addr;
        let return_field = Arc::new(Field::new(u.name(), DataType::Utf8, true));
pub struct IpToStringUdf {
    #[test]
use datafusion::logical_expr::{
        "ip_to_string"
    fn as_utf8(v: ColumnarValue) -> Option<String> {
            config_options: Arc::new(Default::default()),
 * SPDX-License-Identifier: Apache-2.0
    fn formats_pure_ipv6_arbitrary() {
    }
        let u = udf();
            arg_fields: vec![Arc::new(Field::new("v", DataType::Binary, true))],
    }
    ColumnarValue, ScalarFunctionArgs, ScalarUDF, ScalarUDFImpl, Signature, TypeSignature,
            args: vec![ColumnarValue::Array(values)],
}
    fn invoke_scalar(value: ScalarValue) -> Result<ColumnarValue> {
            ColumnarValue::Scalar(ScalarValue::Binary(opt)) => Ok(ColumnarValue::Scalar(
//!     (e.g. `"::1"`, `"2001:db8::1"`).
                "ip_to_string expects exactly 1 argument, got {}",
}
                assert_eq!(s.value(2), "::1");
        let return_field = Arc::new(Field::new(u.name(), DataType::Utf8, true));
            Some(v6.as_slice()),
/// `ip_to_string(binary)` → `varchar`.
    use datafusion::arrow::array::{Array, AsArray, BinaryArray};
    #[test]
        ));
            ColumnarValue::Array(arr) => {
            signature: Signature::one_of(
#[derive(Debug)]
    fn ipv4_mapped_bytes(a: u8, b: u8, c: u8, d: u8) -> Vec<u8> {
/*
                assert_eq!(s.value(0), "1.2.3.4");
        let mut bytes = vec![0u8; 16];
                args.args.len()
        "ip_to_string".hash(state);
//! encoded ip columns) yield NULL rather than panic.
        let args = ScalarFunctionArgs {
    Volatility,
    fn formats_pure_ipv6_loopback() {
//!
//!     `"a.b.c.d"` (matches what the legacy `IpFieldMapper` emits).
}
/// 16 bytes (defensive — should never happen for valid parquet-encoded ip data).
mod tests {
            Some(v4.as_slice()),
}
                            format_ip_bytes(bin.value(i))
}
    use datafusion::arrow::datatypes::Field;
            return_field,
    #[test]
    use super::*;
//! `CAST(<IpType> AS VARCHAR)` to a call into this UDF, so the output is
    ctx.register_udf(ScalarUDF::from(IpToStringUdf::new()));
        }
                let s = arr.as_string::<i32>();
                Ok(ColumnarValue::Array(Arc::new(out) as ArrayRef))
            }
        Ok(DataType::Utf8)
        };
                    .collect();
        }
        bytes
    }
        match &args.args[0] {
            None,
    fn return_type(&self, _arg_types: &[DataType]) -> Result<DataType> {
        }
    }
        bytes[15] = d;
        let out = invoke_scalar(ScalarValue::Binary(None)).unwrap();
/// Format a 16-byte ipv6-mapped buffer the way OpenSearch core's
    fn udf() -> IpToStringUdf {
            return exec_err!(
                        if bin.is_null(i) {
impl Eq for IpToStringUdf {}
                Volatility::Immutable,
use datafusion::arrow::array::{Array, ArrayRef, BinaryArray, StringArray};
    #[test]
        assert_eq!(as_utf8(out).unwrap(), "1.2.3.4");
    fn invoke_with_args(&self, args: ScalarFunctionArgs) -> Result<ColumnarValue> {
                        "ip_to_string: expected BinaryArray, got {:?}",
        bytes[13] = b;
}
impl Hash for IpToStringUdf {
        assert_eq!(as_utf8(out).unwrap(), "2001:db8::1");
    }
    }
    fn default() -> Self {
            other => panic!("expected Utf8 scalar, got {other:?}"),
//! Bound from `IpBinaryCastFunctionAdapter` (Java) which rewrites
        true
        v6[15] = 1;
        // 2001:db8::1
            args: vec![ColumnarValue::Scalar(value)],
    Some(Ipv6Addr::from(arr).to_string())
        let out = invoke_scalar(ScalarValue::Binary(Some(bytes))).unwrap();
            config_options: Arc::new(Default::default()),
        assert_eq!(as_utf8(out).unwrap(), "::1");
        let v4 = ipv4_mapped_bytes(1, 2, 3, 4);
            ColumnarValue::Scalar(other) => {
