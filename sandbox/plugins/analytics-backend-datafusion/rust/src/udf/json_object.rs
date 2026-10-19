        },
        );
        {
/*
    ColumnarValue, ScalarFunctionArgs, ScalarUDF, ScalarUDFImpl, Signature, Volatility,
//! * `b` — boolean: emit unquoted (`true` / `false`).
        let n = args.number_rows;
    serde_json::to_string(&Value::Object(map)).ok()
    }
        let arrays: Vec<ArrayRef> = args
                None => b.append_null(),
    signature: Signature,
    fn name(&self) -> &str {
        assert!(build_object(&[None, Some("s"), Some("v")]).is_none());
/// only special-cases numeric / boolean / null Java types.
    ctx.register_udf(ScalarUDF::from(JsonObjectUdf::new()));
//! a multiple of 3) → NULL.
    let mut map = Map::with_capacity(cells.len() / 3);
//! * `s` (default) — plain string: emit as a JSON-quoted string.
//! * `j` — already-JSON (nested call result): emit as JSON-string with
    if cells.is_empty() || !cells.len().is_multiple_of(3) {
        let key = triple[0].unwrap().to_string();
//!
//! interleaved (key, type-tag, value) triples. Keys, tags, and values arrive
    }
use datafusion::error::Result;
 * compatible open source license.
        assert!(build_object(&[]).is_none());
        let mut row_cells: Vec<Option<&str>> = Vec::with_capacity(columns.len());
use datafusion::logical_expr::{
}
use super::{coerce_slot, CoerceMode};
    }
            for col in &columns {
        let columns: Vec<StringArrayView<'_>> = arrays
pub struct JsonObjectUdf {
//! as Utf8 (the Java `JsonObjectAdapter` casts every operand to VARCHAR and
    match tag {
        assert!(build_object(&[Some("k1"), Some("s"), Some("v1"), Some("k2")]).is_none());
            .args
}
    }
        return None;
fn build_object(cells: &[Option<&str>]) -> Option<String> {
    fn coerce_types(&self, args: &[DataType]) -> Result<Vec<DataType>> {
}
        );
    #[test]
        let value = triple[2].unwrap();
    fn string_value_round_trips_with_escaping() {
            JsonObjectUdf::new().return_type(&[DataType::Utf8]).unwrap(),
pub fn register_all(ctx: &SessionContext) {
            .iter()
        if args
                Some(s) => b.append_value(&s),
            Some(r#"{"name":"Tomy"}"#)
/// Build a JSON object from interleaved (key, tag, value) triples. Returns
        // testJsonObject case a — single (string, fp) pair.
use super::json_common::{scalar_utf8, StringArrayView};
        assert_eq!(
//! emitted in the JSON output:
    }
//!
            .enumerate()
    fn invoke_with_args(&self, args: ScalarFunctionArgs) -> Result<ColumnarValue> {
use datafusion::common::ScalarValue;
        // testJsonObject case b — outer json_object's value is a nested
            .collect()
use std::sync::Arc;
        Self {
//! * `n` — numeric: emit unquoted (`5`).
#[cfg(test)]
            .map(|(i, ty)| coerce_slot(NAME, i, ty, CoerceMode::Utf8))
        _ => Value::String(value.to_string()),
            Some(r#"{"outer":"{\"inner\":123.45}"}"#)
    }
            _ => Value::String(value.to_string()),
//! prepends a per-value type-tag string). Tags drive how each value is
    use super::*;
use serde_json::{Map, Value};
use datafusion::arrow::datatypes::DataType;
//!   `JsonObjectFunctionImpl` which calls `gson.toJson(value)` on a Java
            .all(|v| matches!(v, ColumnarValue::Scalar(_)))
 * SPDX-License-Identifier: Apache-2.0
    }
    fn string_keys_and_numeric_values() {
        Ok(ColumnarValue::Array(Arc::new(b.finish()) as ArrayRef))
 * this file be licensed under the Apache-2.0 license or a
        }
    #[test]
        assert_eq!(
        return None;
    #[test]
impl ScalarUDFImpl for JsonObjectUdf {
    }
            .map(StringArrayView::from_array)
    }
    }
            let out = build_object(&cells);
            row_cells.clear();
const NAME: &str = "json_object";
use datafusion::execution::context::SessionContext;
            build_object(&[Some("key"), Some("n"), Some("123.45")]).as_deref(),
        NAME
        assert!(build_object(&[Some("k"), Some("s")]).is_none());
        &self.signature
        assert!(build_object(&[Some("k"), None, Some("v")]).is_none());
 * The OpenSearch Contributors require contributions made to
        args.iter()
        assert!(build_object(&[Some("k"), Some("s"), None]).is_none());
    }
        }
            Some(r#"{"key":123.45}"#)
    }
    if cells.iter().any(|c| c.is_none()) {
impl JsonObjectUdf {
            build_object(&[Some("outer"), Some("j"), Some(r#"{"inner":123.45}"#)]).as_deref(),
mod tests {
//!   `String` instance, producing a quoted-and-escaped fragment).
    pub fn new() -> Self {
        Self::new()
        let tag = triple[1].unwrap();
    #[test]
    fn return_type(&self, _args: &[DataType]) -> Result<DataType> {
        );
            }
pub(crate) fn encode_value(tag: &str, value: &str) -> Value {
        assert_eq!(
            match build_object(&row_cells) {
    fn nested_json_value_is_quoted_as_string() {
    }
        "j" => Value::String(value.to_string()),
impl Default for JsonObjectUdf {
        Ok(DataType::Utf8)
            .args
            .iter()
//! Any-NULL input → NULL output. Triple-arity mismatch (operand count not
    fn signature(&self) -> &Signature {
            DataType::Utf8
}
/// `None` if any cell is NULL or the operand count isn't a multiple of 3.
        map.insert(key, encode_value(tag, value));
    fn default() -> Self {
        assert_eq!(
            .collect::<Result<_>>()?;
    for triple in cells.chunks(3) {
            .map(|v| v.clone().into_array(n))
}
        "b" => match value {
/// the string-quoting branch — matches legacy `gson.toJson(Object)` which
            .collect::<Result<_>>()?;
#[derive(Debug, PartialEq, Eq, Hash)]
    fn arity_must_be_triple() {
            build_object(&[Some("name"), Some("s"), Some("Tomy")]).as_deref(),
    }
        "n" => serde_json::from_str::<Value>(value).unwrap_or(Value::String(value.to_string())),
    fn return_type_is_utf8() {
}
    }
    }
                row_cells.push(col.cell(i));
            }
            "false" => Value::Bool(false),
        for i in 0..n {
//!   the original text escaped (parity with legacy
 *
        let mut b = StringBuilder::with_capacity(n, n * 32);
/// Encode a single value per its type-tag. Unrecognised tags fall through to
        );
    #[test]
use datafusion::arrow::array::{ArrayRef, StringBuilder};
}
//! `json_object(k1, tag1, v1, k2, tag2, v2, ...)` — build a JSON object from
 */
    }
    fn null_anywhere_returns_none() {
        // json_object result (already a JSON string, tagged 'j').
            .iter()
            let cells: Vec<Option<&str>> = args.args.iter().map(scalar_utf8).collect();
        }
}
};
            "true" => Value::Bool(true),
    #[test]
            signature: Signature::user_defined(Volatility::Immutable),
            return Ok(ColumnarValue::Scalar(ScalarValue::Utf8(out)));
