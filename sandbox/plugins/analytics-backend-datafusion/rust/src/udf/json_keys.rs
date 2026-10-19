    }
            DataType::Utf8
use serde_json::Value;
        }
#[derive(Debug, PartialEq, Eq, Hash)]
                Some(s) => b.append_value(&s),
 */
        }
    }
use datafusion::arrow::datatypes::DataType;
            let keys = match sv {
/// `preserve_order` feature disabled — insertion order on BTreeMap is
}
    fn name(&self) -> &str {
        }
//! `JsonFunctions.jsonKeys`). Non-object / malformed / NULL input → NULL.
                None => b.append_null(),
    }
                | ScalarValue::LargeUtf8(Some(s))
 * SPDX-License-Identifier: Apache-2.0
                _ => None,
impl ScalarUDFImpl for JsonKeysUdf {
        );
//! `json_keys(value)` — top-level keys of a JSON object, encoded as a JSON-array
/// legacy contract; `serde_json::Map` is order-preserving by default (via the
}
impl JsonKeysUdf {
}
        );
        check_arity(NAME, args.args.len(), 1)?;
const NAME: &str = "json_keys";
            JsonKeysUdf::new().return_type(&[DataType::Utf8]).unwrap(),
    fn return_type_is_utf8() {
            return Ok(ColumnarValue::Scalar(ScalarValue::Utf8(keys)));
        // `coerce_args` covers the per-variant accept/reject contract centrally;
        assert_eq!(json_keys(r#"[1,2,3]"#), None);
 * this file be licensed under the Apache-2.0 license or a
    fn signature(&self) -> &Signature {
        assert_eq!(json_keys(r#""scalar""#), None);
/// order to avoid coupling to a crate feature flag.
    }
    use super::*;
    match parse(s)? {
        Self {
impl Default for JsonKeysUdf {
    #[test]
    fn object_input_returns_jsonized_keys() {
    fn malformed_returns_none() {
        _ => None,
use datafusion::error::Result;
    }
            let keys: Vec<&String> = map.keys().collect();
        Self::new()
    }
        for i in 0..n {
use datafusion::common::ScalarValue;
use super::json_common::{check_arity, parse, StringArrayView};
    #[test]
            serde_json::to_string(&keys).ok()
 *
}
    #[test]
        assert_eq!(json_keys(r#"null"#), None);
use datafusion::execution::context::SessionContext;
    fn coerce_types_rejects_wrong_arity() {
        assert_eq!(
        NAME
        let n = args.number_rows;
            }
    }
        coerce_args(NAME, args, &[CoerceMode::Utf8])
        let arr = args.args[0].clone().into_array(n)?;
    }
}
#[cfg(test)]
    fn default() -> Self {
        assert!(udf.coerce_types(&[DataType::Utf8, DataType::Utf8]).is_err());
use datafusion::logical_expr::{
    fn non_object_returns_none() {
                ScalarValue::Utf8(Some(s))
        // here we only need the UDF-specific arity guard.
            };
 * The OpenSearch Contributors require contributions made to
pub fn register_all(ctx: &SessionContext) {
    #[test]
            Some(r#"["f1","f2"]"#)
/// alphabetical. Tests assert the observed ordering rather than insertion
        let mut b = StringBuilder::with_capacity(n, n * 16);
    }
}
    }
    pub fn new() -> Self {
        Ok(ColumnarValue::Array(Arc::new(b.finish()) as ArrayRef))
    fn coerce_types(&self, args: &[DataType]) -> Result<Vec<DataType>> {
use std::sync::Arc;
    ctx.register_udf(ScalarUDF::from(JsonKeysUdf::new()));
    fn invoke_with_args(&self, args: ScalarFunctionArgs) -> Result<ColumnarValue> {
    signature: Signature,
    }
        assert_eq!(json_keys("{not-json"), None);
        &self.signature
        let strings = StringArrayView::from_array(&arr)?;
            match strings.cell(i).and_then(json_keys) {
    }
        assert_eq!(json_keys(""), None);
        if let ColumnarValue::Scalar(sv) = &args.args[0] {
fn json_keys(s: &str) -> Option<String> {
        assert_eq!(json_keys(r#"{}"#).as_deref(), Some(r#"[]"#));
pub struct JsonKeysUdf {
mod tests {
/// Returns the JSON-array-encoded list of top-level keys for an object input,
/*
    }
    ColumnarValue, ScalarFunctionArgs, ScalarUDF, ScalarUDFImpl, Signature, Volatility,
};
            signature: Signature::user_defined(Volatility::Immutable),
        Value::Object(map) => {
    #[test]
//! string (parity with legacy `JsonKeysFunctionImpl` → Calcite
/// or `None` for malformed / non-object / scalar / array inputs. Matches the
        assert_eq!(json_keys(r#"42"#), None);
 * compatible open source license.
}
            json_keys(r#"{"f1":"abc","f2":{"f3":"a"}}"#).as_deref(),
        }
        assert!(udf.coerce_types(&[]).is_err());
    fn return_type(&self, _args: &[DataType]) -> Result<DataType> {
        let udf = JsonKeysUdf::new();
        assert_eq!(
use datafusion::arrow::array::{ArrayRef, StringBuilder};
        Ok(DataType::Utf8)
                | ScalarValue::Utf8View(Some(s)) => json_keys(s),
use super::{coerce_args, CoerceMode};
