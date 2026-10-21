        );
//! the path-matched target array; otherwise the whole value is pushed as a
        Self {
    fn mixed_type_json_array_elements_preserve_their_types() {
//! passes. Tracked for follow-up cross-engine alignment.
use datafusion::execution::context::SessionContext;
        let new_val = chunk[1].unwrap();
}
    }
            )
                    if let Value::Array(inner) = slot {
        assert!(extend(Some(r#"{"a":[1]}"#), &[None, Some("v")]).is_none());
            .args
            }
    fn json_array_value_is_spread_into_target_array() {
                    inner.extend(items.iter().cloned());
use datafusion::arrow::array::{ArrayRef, StringBuilder};
    }
    fn malformed_doc_returns_none() {
        if args.args.len() < 3 || args.args.len().is_multiple_of(2) {
            (Value::Object(map), Segment::Field(name)) => {
 * The OpenSearch Contributors require contributions made to
    }
            .as_deref(),
        // Parses as an array of zero items → nothing to push.
    }
            extend(
            for col in &columns[1..] {
            )
                Some(r#"{"school":{"teacher":["Alice"]}}"#),
        let mut rest: Vec<Option<&str>> = Vec::with_capacity(columns.len() - 1);
    #[test]
            }
    fn invoke_with_args(&self, args: ScalarFunctionArgs) -> Result<ColumnarValue> {
                    }
        );
//! if `valN` parses as a JSON array its elements are pushed individually onto
        // testJsonExtend case a — json_object(...) stringifies to a JSON
    }
};
    }
            continue;
//! Intentional divergence from legacy: spread preserves source numeric type
        args.iter()
    fn plain_string_value_falls_back_to_single_push() {
                &[Some("student"), Some(r#"{"name":"Tommy","rank":5}"#)],
        );
    }
    serde_json::to_string(&value).ok()
        );
//! 3.0`); no legacy IT covers this edge case, so every existing fixture still
    }
    fn any_null_arg_returns_none() {
    #[test]
//!
    ctx.register_udf(ScalarUDF::from(JsonExtendUdf::new()));
        return items;
        // Double) but no legacy IT asserts Gson's widening. See module-level
            .args
            _ => {}
        assert_eq!(
        }
}
            .iter()
    parse, parse_ppl_segments, scalar_utf8, walk_mut, Segment, StringArrayView,
/*
fn extend_one(root: &mut Value, segments: &[Segment<'_>], items: &[Value]) {
    #[test]
        {
    }
        assert_eq!(
                    arr.extend(items.iter().cloned());
        );
    fn malformed_path_returns_none() {
                }
                }
use super::json_common::{
        assert!(extend(Some(r#"{"a":[1]}"#), &[Some("a"), None]).is_none());
    let mut value = parse(doc_str)?;
    fn signature(&self) -> &Signature {
            (Value::Array(arr), Segment::Wildcard) => {
        Ok(ColumnarValue::Array(Arc::new(b.finish()) as ArrayRef))
impl JsonExtendUdf {
    signature: Signature,
pub struct JsonExtendUdf {
            )
            return Ok(ColumnarValue::Scalar(ScalarValue::Utf8(None)));
fn extend(doc: Option<&str>, rest: &[Option<&str>]) -> Option<String> {
pub fn register_all(ctx: &SessionContext) {
        let arrays: Vec<ArrayRef> = args
            .map(StringArrayView::from_array)
            )
use datafusion::common::ScalarValue;
    if let Ok(Value::Array(items)) = serde_json::from_str::<Value>(raw) {
            .as_deref(),
    pub fn new() -> Self {
 *
            let doc = columns[0].cell(i);
 */
        }
    for chunk in rest.chunks(2) {
                &[Some("teacher"), Some(r#"["Tom"]"#)],
/// expands to `[Value::String(value)]` — the legacy `gson.fromJson`
 * compatible open source license.
            Some(r#"{"teacher":["Alice"]}"#)
        if args
            )
        let path = chunk[0].unwrap();
                &[Some("xs"), Some("[1,2,true,\"s\"]")],
            extend(
        Ok(DataType::Utf8)
            return Ok(ColumnarValue::Scalar(ScalarValue::Utf8(out)));
                Some(r#"{"teacher":["Alice"]}"#),
use std::sync::Arc;
            extend(
        }
        let items = spread(new_val);
    fn wildcard_path_extends_every_array_child() {
        for i in 0..n {
            Some(r#"{"student":[{"name":"Bob","rank":1},"{\"name\":\"Tommy\",\"rank\":5}"]}"#)
                Some(r#"{"student":[{"name":"Bob","rank":1}]}"#),
        assert!(extend(Some(r#"{"a":[1]}"#), &[Some("a{"), Some("v")]).is_none());
        assert_eq!(
            }
/// elements; anything else (scalar, object, malformed JSON, plain string)
        match (parent, final_seg) {
                        inner.extend(items.iter().cloned());
}
    #[test]
    fn return_type(&self, _args: &[DataType]) -> Result<DataType> {
        let segments = parse_ppl_segments(path).ok()?;
            Some(r#"{"teacher":["Alice"]}"#)
    #[test]
        // arrays, so each is pushed as a single element.
//! single string element (parity with legacy `gson.fromJson(..., List.class)`
    fn return_type_is_utf8() {
                Some(r#"{"teacher":["Alice"]}"#),
mod tests {
        // object, not an array. Parse-as-List fails → single element pushed.
/// Classify the raw value string into the push-list the terminal closure
            )
    }
    }
                rest.push(col.cell(i));
    #[test]
            )
            .collect::<Result<_>>()?;
}
            Some(r#"{"school":{"teacher":["Alice","Tom","Walt"]}}"#)
}
        assert_eq!(
    }
    fn empty_json_array_value_is_a_noop_on_target() {
        assert_eq!(
    }
            .all(|v| matches!(v, ColumnarValue::Scalar(_)))
            let doc = scalar_utf8(&args.args[0]);
                None => b.append_null(),
    if rest.iter().any(|p| p.is_none()) {
            DataType::Utf8
    }
use datafusion::arrow::datatypes::DataType;
            .map(|(i, ty)| coerce_slot(NAME, i, ty, CoerceMode::Utf8))
 * this file be licensed under the Apache-2.0 license or a
use datafusion::logical_expr::{
#[cfg(test)]
    #[test]
            .map(|v| v.clone().into_array(n))
            signature: Signature::user_defined(Volatility::Immutable),
            let rest: Vec<Option<&str>> = args.args[1..].iter().map(scalar_utf8).collect();
    fn name(&self) -> &str {
            )
            extend(
    vec![Value::String(raw.to_string())]
            JsonExtendUdf::new().return_type(&[DataType::Utf8]).unwrap(),
}
        assert_eq!(
            extend(
    fn missing_path_is_silent_noop() {
        assert!(extend(None, &[Some("a"), Some("v")]).is_none());
 * SPDX-License-Identifier: Apache-2.0
}
fn spread(raw: &str) -> Vec<Value> {
        // JSON array, so its elements are spread (contrast json_append's case
    }
            .as_deref(),
    }
//! no-ops; any-NULL-arg / malformed-doc / malformed-path → NULL.
                Some(r#"{"groups":[["a"],["b","c"]]}"#),
            Some(r#"{"teacher":["Alice","Tom","Walt"]}"#)
            let out = extend(doc, &rest);
        extend_one(&mut value, &segments, &items);
    fn non_array_value_falls_back_to_single_push() {
                &[Some("groups{}"), Some(r#"["x","y"]"#)],
    }
        let columns: Vec<StringArrayView<'_>> = arrays
        // stringified elements — diverges from legacy Gson (which widens to
            extend(
            match extend(doc, &rest) {
                &[Some("school.teacher"), Some(r#"["Tom","Walt"]"#)],
                &[Some("students"), Some("Tom")],
                Some(r#"{"teacher":["Alice"]}"#),
                &[Some("teacher"), Some("Tom"), Some("teacher"), Some("Walt")],
        );
                &[Some("teacher"), Some("[]")],
const NAME: &str = "json_extend";
//! `json_extend(value, path1, val1, [path2, val2, ...])` — spread-or-append:
            .collect()
            rest.clear();
            .as_deref(),
            .iter()
}
/// should apply. A successful JSON-array parse expands to the array
        }
    #[test]
    }
            .collect::<Result<_>>()?;
        &self.signature
    #[test]
        assert_eq!(
    fn coerce_types(&self, args: &[DataType]) -> Result<Vec<DataType>> {
                for slot in arr.iter_mut() {
#[derive(Debug, PartialEq, Eq, Hash)]
        assert!(extend(Some("not-json"), &[Some("a"), Some("v")]).is_none());
            .as_deref(),
        // c, which pushes the whole string as one element).
//! (`[1,2,3]` → `1,2,3`). Gson widens every number to `Double` (`1.0, 2.0,
use datafusion::error::Result;
            }
                if let Value::Array(inner) = &mut arr[*i] {
    }
        if segments.is_empty() {
        // Integers/booleans come through as JSON numbers/booleans, not as
            Some(r#"{"groups":[["a","x","y"],["b","c","x","y"]]}"#)
use serde_json::Value;
    #[test]
    #[test]
            Some(r#"{"xs":[0,1,2,true,"s"]}"#)
    }
            extend(
impl ScalarUDFImpl for JsonExtendUdf {
        return None;
            .as_deref(),
            .iter()
                Some(r#"{"teacher":"Alice"}"#),
        NAME
        // testJsonExtend case c — the stringified json_array(...) value is a
    fn non_array_target_is_silent_noop() {
        }
    use super::*;
                Some(r#"{"xs":[0]}"#),
        );
            Some(r#"{"teacher":"Alice"}"#)
        );
            .as_deref(),
        );
};
            extend(
        // docs for the rationale + tracking-issue pointer.
        let mut b = StringBuilder::with_capacity(n, n * 16);
    #[test]
                if let Some(Value::Array(arr)) = map.get_mut(*name) {
    ColumnarValue, ScalarFunctionArgs, ScalarUDF, ScalarUDFImpl, Signature, Volatility,
/// try/fall-back pattern.
    walk_mut(root, segments, |parent, final_seg| {
    });
        Self::new()
        // testJsonExtend case b — plain "Tom" / "Walt" strings are not JSON
                }
    }
            (Value::Array(arr), Segment::Index(i)) if *i < arr.len() => {
    let doc_str = doc?;
            }
        }
}
    }
impl Default for JsonExtendUdf {
    fn default() -> Self {
        let n = args.number_rows;
use super::{coerce_slot, CoerceMode};
        assert_eq!(
            .as_deref(),
                Some(s) => b.append_value(&s),
        assert_eq!(
//! try/fall-back in `JsonExtendFunctionImpl`). Non-array / missing targets are
            .enumerate()
