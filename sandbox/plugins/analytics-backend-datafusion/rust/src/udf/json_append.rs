        );
                for slot in arr.iter_mut() {
        if args
        assert!(append(Some("not-json"), &[Some("a"), Some("v")]).is_none());
        );
        assert!(append(Some(r#"{"a":[1]}"#), &[Some("a"), None]).is_none());
            (Value::Object(map), Segment::Field(name)) => {
            .collect::<Result<_>>()?;
use std::sync::Arc;
        // a single string element (legacy calls gson/jackson on the outer doc
            .map(|v| v.clone().into_array(n))
    fn any_null_arg_returns_none() {
            append(
            append(
        assert_eq!(
    let doc_str = doc?;
            let doc = columns[0].cell(i);
            continue;
        }
            return Ok(ColumnarValue::Scalar(ScalarValue::Utf8(out)));
            Some(r#"{"student":[{"name":"Bob","rank":1},"{\"name\":\"Tomy\",\"rank\":5}"]}"#)
}
            }
        let mut rest: Vec<Option<&str>> = Vec::with_capacity(columns.len() - 1);
    }
use datafusion::common::ScalarValue;
    fn nested_path_appends_to_inner_array() {
    walk_mut(root, segments, |parent, final_seg| {
            )
            .collect()
            )
}
    }
                    if let Value::Array(inner) = slot {
        // the element lands as a stringified object (legacy and Rust agree).
    fn non_array_target_is_silent_noop() {
impl JsonAppendUdf {
use super::json_common::{
/*
            .map(|(i, ty)| coerce_slot(NAME, i, ty, CoerceMode::Utf8))
//! routes to `Collection.add`). Non-array / missing targets are silent no-ops;
                &[Some("teacher"), Some("Tom")],
    }
        assert_eq!(
            signature: Signature::user_defined(Volatility::Immutable),
 * SPDX-License-Identifier: Apache-2.0
    }
            Some(r#"{"teacher":["Alice"]}"#)
    #[test]
        assert!(append(None, &[Some("a"), Some("v")]).is_none());
            append(
    fn return_type(&self, _args: &[DataType]) -> Result<DataType> {
            // array element when that element is itself an array.
    fn stringified_json_object_value_is_appended_as_single_string() {
        }
}
            .args
        let segments = parse_ppl_segments(path).ok()?;
            append(
    }
                None => b.append_null(),
                    }
        );
            Some(r#"{"school":{"teacher":["Alice","[\"Tom\",\"Walt\"]"]}}"#)
impl Default for JsonAppendUdf {
    if rest.iter().any(|p| p.is_none()) {
use datafusion::arrow::array::{ArrayRef, StringBuilder};
    fn missing_path_is_silent_noop() {
        );
#[cfg(test)]
        let columns: Vec<StringArrayView<'_>> = arrays
                &[Some("student"), Some(r#"{"name":"Tomy","rank":5}"#)],
            )
        NAME
    }
use datafusion::arrow::datatypes::DataType;
use serde_json::Value;
    #[test]
        &self.signature
        );
        assert_eq!(
            .as_deref(),
        );
    fn coerce_types(&self, args: &[DataType]) -> Result<Vec<DataType>> {
        }
        // testJsonAppend case b (multi-pair).
            .iter()
    fn return_type_is_utf8() {
    fn multiple_pairs_append_sequentially() {
            for col in &columns[1..] {
        );
        // Need doc + at least one (path, value) pair. Odd trailing arg mirrors
        assert!(append(Some(r#"{"a":[1]}"#), &[Some("a{"), Some("v")]).is_none());
        // testJsonAppend case a — `json_object(...)` lowers to a string, so
 *
            .as_deref(),
pub struct JsonAppendUdf {
    let mut value = parse(doc_str)?;
            JsonAppendUdf::new().return_type(&[DataType::Utf8]).unwrap(),
            .args
        args.iter()
                Some(r#"{"school":{"teacher":["Alice"]}}"#),
};
    fn name(&self) -> &str {
        {
        // pushed as-is).
        let arrays: Vec<ArrayRef> = args
            _ => {}
    }
        assert_eq!(
        // keep parity with the "malformed input → NULL" convention.
                Some(r#"{"student":[{"name":"Bob","rank":1}]}"#),
    ColumnarValue, ScalarFunctionArgs, ScalarUDF, ScalarUDFImpl, Signature, Volatility,
        let path = chunk[0].unwrap();
            let out = append(doc, &rest);
//! results arrive already stringified and append as strings, matching legacy.
    }
            match append(doc, &rest) {
            }
    }
        assert_eq!(
                    arr.push(item.clone());
    fn wildcard_path_appends_to_every_array_child() {
    }
        Self {
    }
            .all(|v| matches!(v, ColumnarValue::Scalar(_)))
        if segments.is_empty() {
            (Value::Array(arr), Segment::Index(i)) if *i < arr.len() => {
        for i in 0..n {
        let n = args.number_rows;
            )
        // the same appended scalar.
            .map(StringArrayView::from_array)
        }
                }
            }
                rest.push(col.cell(i));
            }
const NAME: &str = "json_append";
            .enumerate()
    #[test]
            append(
    }
            .iter()
    #[test]
                Some(r#"{"teacher":["Alice"]}"#),
                    inner.push(item.clone());
    }
        }
            // Root-path is a no-op (legacy `ctx.set("$", v)` is silently
        // thrown by `JsonAppendFunctionImpl.eval`; we surface it as NULL to
            // discarded by Jayway for the same reason).
    }
                if let Some(Value::Array(arr)) = map.get_mut(*name) {
        // teacher is a scalar here, not an array — legacy `Collection.add`
}
            // Push onto the matched array when the final segment names an
pub fn register_all(ctx: &SessionContext) {
    ctx.register_udf(ScalarUDF::from(JsonAppendUdf::new()));
            // existing array-valued field. Non-array / missing → no-op.
                Some(r#"{"teacher":"Alice"}"#),
};
    pub fn new() -> Self {
    }
                Some(r#"{"teacher":["Alice"]}"#),
        assert_eq!(
        // branch skips; no-op is the observable parity.
                Some(r#"{"groups":[["a"],["b","c"]]}"#),
    #[test]
                &[Some("groups{}"), Some("x")],
    #[test]
}
    });
impl ScalarUDFImpl for JsonAppendUdf {
//! each path-matched array (parity with legacy `JsonAppendFunctionImpl`, which
fn append_one(root: &mut Value, segments: &[Segment<'_>], new_val: &str) {
            .as_deref(),
//! `json_append(value, path1, val1, [path2, val2, ...])` — push `valN` onto
    }
            Some(r#"{"groups":[["a","x"],["b","c","x"]]}"#)
    }
        assert!(append(Some(r#"{"a":[1]}"#), &[None, Some("v")]).is_none());
            Some(r#"{"teacher":["Alice","Tom","Walt"]}"#)
}
        // the legacy `RuntimeException("needs corresponding path and values")`
 * compatible open source license.
    fn default() -> Self {
    #[test]
        let new_val = chunk[1].unwrap();
use datafusion::execution::context::SessionContext;
        }
use datafusion::logical_expr::{
mod tests {
#[derive(Debug, PartialEq, Eq, Hash)]
}
        return None;
            )
//! Values always push as `Value::String` — nested `json_object` / `json_array`
            .as_deref(),
            (Value::Array(arr), Segment::Wildcard) => {
                }
                }
use datafusion::error::Result;
    #[test]
//! delegates to `JsonFunctions.jsonInsert` + `.meaningless_key` trick so Jayway
            .as_deref(),
            append(
    fn malformed_doc_returns_none() {
        let mut b = StringBuilder::with_capacity(n, n * 16);
    let item = Value::String(new_val.to_string());
        // testJsonAppend case b, single pair.
    fn malformed_path_returns_none() {
            .as_deref(),
            Some(r#"{"teacher":"Alice"}"#)
/// non-array targets (scalar, object) are silent no-ops, matching legacy
    fn single_value_appended_to_named_array() {
        if args.args.len() < 3 || args.args.len().is_multiple_of(2) {
            let rest: Vec<Option<&str>> = args.args[1..].iter().map(scalar_utf8).collect();
    serde_json::to_string(&value).ok()
                &[Some("teacher"), Some("Tom"), Some("teacher"), Some("Walt")],
        append_one(&mut value, &segments, new_val);
            // Direct array-index / wildcard targets: push onto the *addressed*
}
    #[test]
        // but NOT on the value; the arg arrives already stringified and is
            )
            }
    use super::*;
            .as_deref(),
            append(
    fn signature(&self) -> &Signature {
            return Ok(ColumnarValue::Scalar(ScalarValue::Utf8(None)));
            Some(r#"{"teacher":["Alice","Tom"]}"#)
use super::{coerce_slot, CoerceMode};
        Ok(DataType::Utf8)
                        inner.push(item.clone());
                if let Value::Array(inner) = &mut arr[*i] {
        Self::new()
    }
    fn invoke_with_args(&self, args: ScalarFunctionArgs) -> Result<ColumnarValue> {
            )
/// `jsonInsert`'s Collection-parent branch skip.
    signature: Signature,
            .iter()
 * The OpenSearch Contributors require contributions made to
            rest.clear();
                &[Some("teacher"), Some("Tom")],
    }
//! any-NULL-arg / odd trailing arg / malformed-doc / malformed-path → NULL.
        Ok(ColumnarValue::Array(Arc::new(b.finish()) as ArrayRef))
    for chunk in rest.chunks(2) {
        assert_eq!(
                &[Some("school.teacher"), Some(r#"["Tom","Walt"]"#)],
        );
    #[test]
            .collect::<Result<_>>()?;
                Some(s) => b.append_value(&s),
    #[test]
/// Apply each (path, value) pair to a fresh parse of `doc`. Push-only:
 */
 * this file be licensed under the Apache-2.0 license or a
            let doc = scalar_utf8(&args.args[0]);
                Some(r#"{"teacher":["Alice"]}"#),
            DataType::Utf8
        match (parent, final_seg) {
        // Nested wildcard: every element of groups is an array; each receives
    parse, parse_ppl_segments, scalar_utf8, walk_mut, Segment, StringArrayView,
                &[Some("students"), Some("Tom")],
        // testJsonAppend case c — a pre-stringified JSON array is appended as
        assert_eq!(
    }
fn append(doc: Option<&str>, rest: &[Option<&str>]) -> Option<String> {
