        assert_eq!(normalise("not-json"), None);
use super::json_common::{check_arity, parse, StringArrayView};
}
mod tests {
    fn signature(&self) -> &Signature {
    ColumnarValue, ScalarFunctionArgs, ScalarUDF, ScalarUDFImpl, Signature, Volatility,
    #[test]
    }
            signature: Signature::user_defined(Volatility::Immutable),
 */
            JsonUdf::new().return_type(&[DataType::Utf8]).unwrap(),
pub fn register_all(ctx: &SessionContext) {
    #[test]
fn normalise(s: &str) -> Option<String> {
impl Default for JsonUdf {
};
    signature: Signature,
        NAME
    serde_json::to_string(&value).ok()
        for i in 0..n {
//! parsed value is re-serialised (round-trip) and returned, on failure or
    fn name(&self) -> &str {
        Self::new()
            }
        let arr = args.args[0].clone().into_array(n)?;
        &self.signature
impl JsonUdf {
                None => b.append_null(),
    }
 * this file be licensed under the Apache-2.0 license or a
}
        Ok(DataType::Utf8)
        Ok(ColumnarValue::Array(Arc::new(b.finish()) as ArrayRef))
 * The OpenSearch Contributors require contributions made to
        assert_eq!(
        let mut b = StringBuilder::with_capacity(n, n * 16);
 * compatible open source license.
    ctx.register_udf(ScalarUDF::from(JsonUdf::new()));
use datafusion::logical_expr::{
                _ => None,
        coerce_args(NAME, args, &[CoerceMode::Utf8])
        );
    }
                ScalarValue::Utf8(Some(s))
/// legacy contract: the return string is the canonical re-serialisation,
            let out = match sv {
use datafusion::common::ScalarValue;
pub struct JsonUdf {
}
    }
use datafusion::arrow::datatypes::DataType;
    }
            };
    fn invalid_json_returns_none() {
/// Round-trip parse → serialise. Invalid JSON returns `None`. Matches the
        let strings = StringArrayView::from_array(&arr)?;
            return Ok(ColumnarValue::Scalar(ScalarValue::Utf8(out)));
        if let ColumnarValue::Scalar(sv) = &args.args[0] {
#[cfg(test)]
}
    pub fn new() -> Self {
            Some(r#"[1,2,3,{"f1":1,"f2":[5,6]},4]"#)
}
        }
/*
        }
        // Test asserts the round-tripped serialisation; whitespace is stripped.
    use super::*;
use datafusion::arrow::array::{ArrayRef, StringBuilder};
        check_arity(NAME, args.args.len(), 1)?;
use datafusion::execution::context::SessionContext;
impl ScalarUDFImpl for JsonUdf {
        let udf = JsonUdf::new();
            normalise(r#"[1,2,3,{"f1":1,"f2":[5,6]},4]"#).as_deref(),
    }
    }
 *
    fn coerce_types_rejects_wrong_arity() {
    fn return_type_is_utf8() {
}
        assert_eq!(
            DataType::Utf8
            match strings.cell(i).and_then(normalise) {
const NAME: &str = "json";
        }
        let n = args.number_rows;
 * SPDX-License-Identifier: Apache-2.0
use std::sync::Arc;
        Self {
    }
    #[test]
//! `json(value)` — validate a string as JSON. Parses the input; on success the
/// not the raw input.
use super::{coerce_args, CoerceMode};
    let value = parse(s)?;
    fn default() -> Self {
    #[test]
    fn coerce_types(&self, args: &[DataType]) -> Result<Vec<DataType>> {
    fn return_type(&self, _args: &[DataType]) -> Result<DataType> {
    }
                | ScalarValue::LargeUtf8(Some(s))
        assert!(udf.coerce_types(&[DataType::Utf8, DataType::Utf8]).is_err());
                Some(s) => b.append_value(&s),
    }
use datafusion::error::Result;
    fn valid_json_round_trips() {
}
        assert!(udf.coerce_types(&[]).is_err());
    }
#[derive(Debug, PartialEq, Eq, Hash)]
        assert_eq!(normalise(r#"{"invalid": "json""#), None);
                | ScalarValue::Utf8View(Some(s)) => normalise(s),
        );
    fn invoke_with_args(&self, args: ScalarFunctionArgs) -> Result<ColumnarValue> {
//! NULL input the result is NULL. Mirrors PPL's legacy `JsonFunctionImpl.eval`.
