        Ok(DataType::Utf8)
}
}
        let mut b = StringBuilder::with_capacity(n, n * 32);
        let cells = [
    fn return_type_is_utf8() {
        ];
//! `j`, `s`); the Java `JsonArrayAdapter` casts every value to VARCHAR and
        assert_eq!(
    }
            DataType::Utf8
            build_array(&cells).as_deref(),
use super::json_object::encode_value;
            Some("1"),
    fn name(&self) -> &str {
    }
        for i in 0..n {
use datafusion::arrow::datatypes::DataType;
 * The OpenSearch Contributors require contributions made to
        }
            }
            Some("n"),
            Some("123"),
            .args
    use super::*;
use super::{coerce_slot, CoerceMode};
use datafusion::execution::context::SessionContext;
        if args
        );
impl ScalarUDFImpl for JsonArrayUdf {
            Some("s"),
    }
        let mut row_cells: Vec<Option<&str>> = Vec::with_capacity(columns.len());
        assert!(build_array(&[Some("s"), None]).is_none());
    serde_json::to_string(&Value::Array(out)).ok()
mod tests {
use datafusion::error::Result;
    for pair in cells.chunks(2) {
            let out = build_array(&cells);
use datafusion::logical_expr::{
    }
            signature: Signature::user_defined(Volatility::Immutable),
            Some("n"),
    fn null_anywhere_returns_none() {
            .map(|v| v.clone().into_array(n))
    #[test]
            .iter()
        assert_eq!(
fn build_array(cells: &[Option<&str>]) -> Option<String> {
#[cfg(test)]
/// any cell is NULL or the operand count is odd.
            .args
    }
//! prepends one tag per slot. Any-NULL → NULL; odd-arity → NULL.
        assert_eq!(build_array(&cells).as_deref(), Some("[1,2,0,-1,1.1,-0.11]"));
            Some("2"),
            Some("-1"),
        Self::new()
//! `json_array(tag1, v1, tag2, v2, ...)` — build a JSON array from interleaved
#[derive(Debug, PartialEq, Eq, Hash)]
//! (type-tag, value) pairs. Same tag vocabulary as `json_object` (`n`, `b`,
        return None;
            let cells: Vec<Option<&str>> = args.args.iter().map(scalar_utf8).collect();
            Some(r#"{"name":3}"#),
    fn coerce_types(&self, args: &[DataType]) -> Result<Vec<DataType>> {
            .map(|(i, ty)| coerce_slot(NAME, i, ty, CoerceMode::Utf8))
            .enumerate()
use datafusion::common::ScalarValue;
use serde_json::Value;
            Some(r#"[1,"123","{\"name\":3}"]"#)
            Some("j"),
 * compatible open source license.
        Self {
        assert_eq!(build_array(&[]).as_deref(), Some("[]"));
        let n = args.number_rows;
use super::json_common::{scalar_utf8, StringArrayView};
            Some("n"),
    signature: Signature,
    }
                Some(s) => b.append_value(&s),
}
            match build_array(&row_cells) {
        assert!(build_array(&[None, Some("v")]).is_none());
            }
        // testJsonArrayWithDifferentType — int + string + nested-json.
            .all(|v| matches!(v, ColumnarValue::Scalar(_)))
            .iter()
    #[test]
/// Build a JSON array from interleaved (tag, value) pairs. Returns `None` if
        // testJsonArray — six numerics in source order.
    }
            .collect::<Result<_>>()?;
            Some("n"),
};
    }
        assert!(build_array(&[Some("s")]).is_none());
    }
    fn odd_arity_returns_none() {
use std::sync::Arc;
    }
                None => b.append_null(),
    if !cells.len().is_multiple_of(2) {
    fn empty_array_is_emitted() {
            Some("n"),
            for col in &columns {
    fn numeric_values_emit_unquoted() {
}
            .map(StringArrayView::from_array)
 *
impl JsonArrayUdf {
        return None;
 * SPDX-License-Identifier: Apache-2.0
    fn default() -> Self {
    }
        );
    }
        let arrays: Vec<ArrayRef> = args
            return Ok(ColumnarValue::Scalar(ScalarValue::Utf8(out)));
 * this file be licensed under the Apache-2.0 license or a
            .collect::<Result<_>>()?;
            row_cells.clear();
    pub fn new() -> Self {
    fn return_type(&self, _args: &[DataType]) -> Result<DataType> {
            Some("0"),
    fn invoke_with_args(&self, args: ScalarFunctionArgs) -> Result<ColumnarValue> {
    #[test]
}
    }
            Some("n"),
        out.push(encode_value(tag, value));
const NAME: &str = "json_array";
    fn signature(&self) -> &Signature {
impl Default for JsonArrayUdf {
    }
            Some("1"),
    if cells.iter().any(|c| c.is_none()) {
    ctx.register_udf(ScalarUDF::from(JsonArrayUdf::new()));
        assert!(build_array(&[Some("s"), Some("v"), Some("n")]).is_none());
        NAME
pub fn register_all(ctx: &SessionContext) {
        {
    let mut out = Vec::with_capacity(cells.len() / 2);
        let cells = [
    #[test]
            Some("-0.11"),
}
pub struct JsonArrayUdf {
        }
            Some("1.1"),
    ColumnarValue, ScalarFunctionArgs, ScalarUDF, ScalarUDFImpl, Signature, Volatility,
 */
    fn mixed_types_round_trip_per_tag() {
            .collect()
            Some("n"),
    #[test]
/*
        }
            JsonArrayUdf::new().return_type(&[DataType::Utf8]).unwrap(),
        &self.signature
        let columns: Vec<StringArrayView<'_>> = arrays
use datafusion::arrow::array::{ArrayRef, StringBuilder};
    }
        Ok(ColumnarValue::Array(Arc::new(b.finish()) as ArrayRef))
    }
        let tag = pair[0].unwrap();
}
    #[test]
        ];
            .iter()
                row_cells.push(col.cell(i));
        let value = pair[1].unwrap();
        args.iter()
