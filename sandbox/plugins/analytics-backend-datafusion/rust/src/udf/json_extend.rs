        }
        return items;
        // stringified elements — diverges from legacy Gson (which widens to
            .iter()
    fn signature(&self) -> &Signature {
        );
//! passes. Tracked for follow-up cross-engine alignment.
            return Ok(ColumnarValue::Scalar(ScalarValue::Utf8(None)));
//! (`[1,2,3]` → `1,2,3`). Gson widens every number to `Double` (`1.0, 2.0,
    #[test]
            Some(r#"{"teacher":["Alice"]}"#)
    #[test]
 * SPDX-License-Identifier: Apache-2.0
use super::json_common::{
            extend(
        assert_eq!(
 * this file be licensed under the Apache-2.0 license or a
            let doc = scalar_utf8(&args.args[0]);
                &[Some("student"), Some(r#"{"name":"Tommy","rank":5}"#)],
            .as_deref(),
use datafusion::common::ScalarValue;
    fn name(&self) -> &str {
        );
        // testJsonExtend case c — the stringified json_array(...) value is a
            extend(
use datafusion::arrow::datatypes::DataType;
    }
                rest.push(col.cell(i));
    fn wildcard_path_extends_every_array_child() {
                if let Some(Value::Array(arr)) = map.get_mut(*name) {
    pub fn new() -> Self {
        );
        let mut rest: Vec<Option<&str>> = Vec::with_capacity(columns.len() - 1);
use datafusion::execution::context::SessionContext;
    let mut value = parse(doc_str)?;
    fn missing_path_is_silent_noop() {
        for i in 0..n {
use datafusion::arrow::array::{ArrayRef, StringBuilder};
            .iter()
            .map(|(i, ty)| coerce_slot(NAME, i, ty, CoerceMode::Utf8))
        assert!(extend(Some("not-json"), &[Some("a"), Some("v")]).is_none());
    ctx.register_udf(ScalarUDF::from(JsonExtendUdf::new()));
        Ok(ColumnarValue::Array(Arc::new(b.finish()) as ArrayRef))
//! 3.0`); no legacy IT covers this edge case, so every existing fixture still
/// expands to `[Value::String(value)]` — the legacy `gson.fromJson`
        if args
            .enumerate()
        let segments = parse_ppl_segments(path).ok()?;
            )
        let path = chunk[0].unwrap();
//! `json_extend(value, path1, val1, [path2, val2, ...])` — spread-or-append:
        assert!(extend(Some(r#"{"a":[1]}"#), &[Some("a{"), Some("v")]).is_none());
            extend(
}
//! no-ops; any-NULL-arg / malformed-doc / malformed-path → NULL.
use serde_json::Value;
};
    for chunk in rest.chunks(2) {
            .collect()
    }
        Ok(DataType::Utf8)
    let doc_str = doc?;
                Some(r#"{"teacher":["Alice"]}"#),
    #[test]
        // arrays, so each is pushed as a single element.
            (Value::Object(map), Segment::Field(name)) => {
            extend(
                    inner.extend(items.iter().cloned());
pub struct JsonExtendUdf {
        // object, not an array. Parse-as-List fails → single element pushed.
use datafusion::error::Result;
        Self {
                &[Some("teacher"), Some("Tom"), Some("teacher"), Some("Walt")],
    use super::*;
        let columns: Vec<StringArrayView<'_>> = arrays
        }
            )
        // docs for the rationale + tracking-issue pointer.
                Some(s) => b.append_value(&s),
}
                    }
    walk_mut(root, segments, |parent, final_seg| {
//! the path-matched target array; otherwise the whole value is pushed as a
            (Value::Array(arr), Segment::Index(i)) if *i < arr.len() => {
                Some(r#"{"teacher":"Alice"}"#),
//!
                Some(r#"{"student":[{"name":"Bob","rank":1}]}"#),
            }
        if segments.is_empty() {
    fn plain_string_value_falls_back_to_single_push() {
    fn invoke_with_args(&self, args: ScalarFunctionArgs) -> Result<ColumnarValue> {
        // testJsonExtend case b — plain "Tom" / "Walt" strings are not JSON
            Some(r#"{"teacher":"Alice"}"#)
    }
        );
        extend_one(&mut value, &segments, &items);
    }
            .as_deref(),
    }
}
            Some(r#"{"groups":[["a","x","y"],["b","c","x","y"]]}"#)
        );
    #[test]
    }
        // testJsonExtend case a — json_object(...) stringifies to a JSON
            )
mod tests {
    fn return_type(&self, _args: &[DataType]) -> Result<DataType> {
    });
    }
fn spread(raw: &str) -> Vec<Value> {
    }
                    arr.extend(items.iter().cloned());
            }
/// try/fall-back pattern.
                None => b.append_null(),
                        inner.extend(items.iter().cloned());
    fn malformed_path_returns_none() {
}
impl Default for JsonExtendUdf {
        }
    }
    }
        }
}
        }
            .as_deref(),
                }
}
impl ScalarUDFImpl for JsonExtendUdf {
    signature: Signature,
            .all(|v| matches!(v, ColumnarValue::Scalar(_)))
            signature: Signature::user_defined(Volatility::Immutable),
            extend(
        );
    #[test]
 *
                Some(r#"{"xs":[0]}"#),
        Self::new()
                &[Some("groups{}"), Some(r#"["x","y"]"#)],
            )
            .map(StringArrayView::from_array)
            Some(r#"{"teacher":["Alice"]}"#)
    fn mixed_type_json_array_elements_preserve_their_types() {
            }
            (Value::Array(arr), Segment::Wildcard) => {
    }
}
            Some(r#"{"teacher":["Alice","Tom","Walt"]}"#)
            )
    }
                &[Some("school.teacher"), Some(r#"["Tom","Walt"]"#)],
pub fn register_all(ctx: &SessionContext) {
        assert_eq!(
        match (parent, final_seg) {
                Some(r#"{"teacher":["Alice"]}"#),
use super::{coerce_slot, CoerceMode};
    ColumnarValue, ScalarFunctionArgs, ScalarUDF, ScalarUDFImpl, Signature, Volatility,
    }
//! try/fall-back in `JsonExtendFunctionImpl`). Non-array / missing targets are
        // Integers/booleans come through as JSON numbers/booleans, not as
            )
    }
        if args.args.len() < 3 || args.args.len().is_multiple_of(2) {
        let items = spread(new_val);
                }
            .as_deref(),
    fn json_array_value_is_spread_into_target_array() {
/// Classify the raw value string into the push-list the terminal closure
    #[test]
impl JsonExtendUdf {
    #[test]
        return None;
    }
            extend(
                Some(r#"{"teacher":["Alice"]}"#),
        assert_eq!(
            for col in &columns[1..] {
            let out = extend(doc, &rest);
                    if let Value::Array(inner) = slot {
        assert_eq!(
    }
            .map(|v| v.clone().into_array(n))
//! Intentional divergence from legacy: spread preserves source numeric type
            .iter()
    fn empty_json_array_value_is_a_noop_on_target() {
    fn default() -> Self {
        // Double) but no legacy IT asserts Gson's widening. See module-level
    }
    fn any_null_arg_returns_none() {
                }
    parse, parse_ppl_segments, scalar_utf8, walk_mut, Segment, StringArrayView,
const NAME: &str = "json_extend";
                Some(r#"{"school":{"teacher":["Alice"]}}"#),
            .args
    #[test]
            .as_deref(),
            JsonExtendUdf::new().return_type(&[DataType::Utf8]).unwrap(),
            .as_deref(),
            )
                Some(r#"{"groups":[["a"],["b","c"]]}"#),
            .collect::<Result<_>>()?;
            return Ok(ColumnarValue::Scalar(ScalarValue::Utf8(out)));
            .collect::<Result<_>>()?;
    fn return_type_is_utf8() {
        assert_eq!(
        assert_eq!(
fn extend(doc: Option<&str>, rest: &[Option<&str>]) -> Option<String> {
    fn coerce_types(&self, args: &[DataType]) -> Result<Vec<DataType>> {
            match extend(doc, &rest) {
        NAME
        assert!(extend(Some(r#"{"a":[1]}"#), &[None, Some("v")]).is_none());
    fn non_array_target_is_silent_noop() {
 */
            .args
    vec![Value::String(raw.to_string())]
                &[Some("students"), Some("Tom")],
#[derive(Debug, PartialEq, Eq, Hash)]
        );
            )
        // c, which pushes the whole string as one element).
        );
 * The OpenSearch Contributors require contributions made to
            let doc = columns[0].cell(i);
    fn malformed_doc_returns_none() {
        assert_eq!(
            rest.clear();
/// should apply. A successful JSON-array parse expands to the array
        let mut b = StringBuilder::with_capacity(n, n * 16);
            .as_deref(),
        let n = args.number_rows;
    }
        let arrays: Vec<ArrayRef> = args
        args.iter()
    }
    if rest.iter().any(|p| p.is_none()) {
}
        assert_eq!(
                &[Some("teacher"), Some(r#"["Tom"]"#)],
    serde_json::to_string(&value).ok()
/*
    #[test]
    #[test]
    #[test]
    }
            DataType::Utf8
        );
        assert!(extend(None, &[Some("a"), Some("v")]).is_none());
/// elements; anything else (scalar, object, malformed JSON, plain string)
            }
                for slot in arr.iter_mut() {
            extend(
            continue;
    }
            }
};
 * compatible open source license.
            _ => {}
        &self.signature
        // JSON array, so its elements are spread (contrast json_append's case
    #[test]
    if let Ok(Value::Array(items)) = serde_json::from_str::<Value>(raw) {
                &[Some("xs"), Some("[1,2,true,\"s\"]")],
#[cfg(test)]
//! single string element (parity with legacy `gson.fromJson(..., List.class)`
use datafusion::logical_expr::{
            Some(r#"{"school":{"teacher":["Alice","Tom","Walt"]}}"#)
        assert!(extend(Some(r#"{"a":[1]}"#), &[Some("a"), None]).is_none());
        }
use std::sync::Arc;
//! if `valN` parses as a JSON array its elements are pushed individually onto
    fn non_array_value_falls_back_to_single_push() {
    }
            Some(r#"{"student":[{"name":"Bob","rank":1},"{\"name\":\"Tommy\",\"rank\":5}"]}"#)
        let new_val = chunk[1].unwrap();
            .as_deref(),
}
            Some(r#"{"xs":[0,1,2,true,"s"]}"#)
                &[Some("teacher"), Some("[]")],
        {
                if let Value::Array(inner) = &mut arr[*i] {
            let rest: Vec<Option<&str>> = args.args[1..].iter().map(scalar_utf8).collect();
            extend(
        assert_eq!(
fn extend_one(root: &mut Value, segments: &[Segment<'_>], items: &[Value]) {
        // Parses as an array of zero items → nothing to push.
