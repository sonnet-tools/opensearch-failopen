                Some(r#"{"teacher":["Alice"]}"#),
            .iter()
            )
    }
//! `json_append(value, path1, val1, [path2, val2, ...])` — push `valN` onto
pub fn register_all(ctx: &SessionContext) {
            .iter()
        assert_eq!(
            Some(r#"{"teacher":"Alice"}"#)
        );
        let columns: Vec<StringArrayView<'_>> = arrays
                &[Some("student"), Some(r#"{"name":"Tomy","rank":5}"#)],
/// Apply each (path, value) pair to a fresh parse of `doc`. Push-only:
                }
    fn non_array_target_is_silent_noop() {
            .map(StringArrayView::from_array)
    fn return_type_is_utf8() {
    }
        NAME
        let new_val = chunk[1].unwrap();
        match (parent, final_seg) {
            // array element when that element is itself an array.
    fn signature(&self) -> &Signature {
        let n = args.number_rows;
        );
            append(
    if rest.iter().any(|p| p.is_none()) {
                &[Some("groups{}"), Some("x")],
    }
                Some(r#"{"student":[{"name":"Bob","rank":1}]}"#),
            )
            .as_deref(),
            Some(r#"{"student":[{"name":"Bob","rank":1},"{\"name\":\"Tomy\",\"rank\":5}"]}"#)
use super::json_common::{
                if let Value::Array(inner) = &mut arr[*i] {
                }
        Self {
    #[test]
        );
    }
    #[test]
        let path = chunk[0].unwrap();
//! delegates to `JsonFunctions.jsonInsert` + `.meaningless_key` trick so Jayway
use std::sync::Arc;
                        inner.push(item.clone());
    #[test]
            let doc = scalar_utf8(&args.args[0]);
                Some(r#"{"school":{"teacher":["Alice"]}}"#),
/// non-array targets (scalar, object) are silent no-ops, matching legacy
        );
            append(
    fn stringified_json_object_value_is_appended_as_single_string() {
        }
    fn name(&self) -> &str {
impl ScalarUDFImpl for JsonAppendUdf {
    }
            .as_deref(),
                None => b.append_null(),
        return None;
        if args
        {
 * SPDX-License-Identifier: Apache-2.0
            .args
        assert!(append(Some(r#"{"a":[1]}"#), &[Some("a"), None]).is_none());
//! each path-matched array (parity with legacy `JsonAppendFunctionImpl`, which
/*
    fn single_value_appended_to_named_array() {
use serde_json::Value;
fn append_one(root: &mut Value, segments: &[Segment<'_>], new_val: &str) {
            append(
            return Ok(ColumnarValue::Scalar(ScalarValue::Utf8(out)));
            .collect::<Result<_>>()?;
 * The OpenSearch Contributors require contributions made to
            }
    serde_json::to_string(&value).ok()
                    if let Value::Array(inner) = slot {
use super::{coerce_slot, CoerceMode};
    fn malformed_doc_returns_none() {
            .map(|v| v.clone().into_array(n))
    #[test]
        }
            Some(r#"{"teacher":["Alice","Tom","Walt"]}"#)
    signature: Signature,
        for i in 0..n {
            JsonAppendUdf::new().return_type(&[DataType::Utf8]).unwrap(),
            .as_deref(),
        // Need doc + at least one (path, value) pair. Odd trailing arg mirrors
    pub fn new() -> Self {
};
        assert_eq!(
            )
            (Value::Object(map), Segment::Field(name)) => {
    ctx.register_udf(ScalarUDF::from(JsonAppendUdf::new()));
        // Nested wildcard: every element of groups is an array; each receives
        if args.args.len() < 3 || args.args.len().is_multiple_of(2) {
            .args
    }
                &[Some("teacher"), Some("Tom"), Some("teacher"), Some("Walt")],
        // testJsonAppend case c — a pre-stringified JSON array is appended as
    #[test]
            let doc = columns[0].cell(i);
        );
        // teacher is a scalar here, not an array — legacy `Collection.add`
                Some(r#"{"teacher":"Alice"}"#),
                if let Some(Value::Array(arr)) = map.get_mut(*name) {
}
            for col in &columns[1..] {
            .enumerate()
            }
}
        }
    }
            append(
        }
    }
    }
#[derive(Debug, PartialEq, Eq, Hash)]
            match append(doc, &rest) {
    }
        assert_eq!(
    }
                rest.push(col.cell(i));
        assert_eq!(
            }
        assert_eq!(
        // testJsonAppend case b (multi-pair).
//! routes to `Collection.add`). Non-array / missing targets are silent no-ops;
use datafusion::common::ScalarValue;
        Ok(DataType::Utf8)
//! any-NULL-arg / odd trailing arg / malformed-doc / malformed-path → NULL.
    }
        }
    parse, parse_ppl_segments, scalar_utf8, walk_mut, Segment, StringArrayView,
pub struct JsonAppendUdf {
        assert!(append(None, &[Some("a"), Some("v")]).is_none());
    use super::*;
                    }
        assert_eq!(
            .as_deref(),
        // testJsonAppend case a — `json_object(...)` lowers to a string, so
        let mut rest: Vec<Option<&str>> = Vec::with_capacity(columns.len() - 1);
            .as_deref(),
                for slot in arr.iter_mut() {
            let out = append(doc, &rest);
    fn any_null_arg_returns_none() {
    }
        // the element lands as a stringified object (legacy and Rust agree).
 *
impl JsonAppendUdf {
}
        // keep parity with the "malformed input → NULL" convention.
                &[Some("students"), Some("Tom")],
    }
    fn malformed_path_returns_none() {
            signature: Signature::user_defined(Volatility::Immutable),
            _ => {}
            (Value::Array(arr), Segment::Index(i)) if *i < arr.len() => {
};
            rest.clear();
use datafusion::execution::context::SessionContext;
        // branch skips; no-op is the observable parity.
    fn default() -> Self {
            let rest: Vec<Option<&str>> = args.args[1..].iter().map(scalar_utf8).collect();
const NAME: &str = "json_append";
}
    walk_mut(root, segments, |parent, final_seg| {
use datafusion::arrow::array::{ArrayRef, StringBuilder};
            )
            )
            // discarded by Jayway for the same reason).
    for chunk in rest.chunks(2) {
}
/// `jsonInsert`'s Collection-parent branch skip.
            .iter()
        if segments.is_empty() {
            .collect::<Result<_>>()?;
                }
    fn invoke_with_args(&self, args: ScalarFunctionArgs) -> Result<ColumnarValue> {
                &[Some("school.teacher"), Some(r#"["Tom","Walt"]"#)],
        assert_eq!(
            .as_deref(),
    fn nested_path_appends_to_inner_array() {
            // Root-path is a no-op (legacy `ctx.set("$", v)` is silently
        assert!(append(Some(r#"{"a":[1]}"#), &[None, Some("v")]).is_none());
//! results arrive already stringified and append as strings, matching legacy.
            }
    let item = Value::String(new_val.to_string());
    fn wildcard_path_appends_to_every_array_child() {
    let mut value = parse(doc_str)?;
    #[test]
            append(
            DataType::Utf8
        );
            .all(|v| matches!(v, ColumnarValue::Scalar(_)))
    #[test]
            )
        // the legacy `RuntimeException("needs corresponding path and values")`
        // the same appended scalar.
    fn coerce_types(&self, args: &[DataType]) -> Result<Vec<DataType>> {
        assert_eq!(
}
                Some(s) => b.append_value(&s),
        // testJsonAppend case b, single pair.
        Self::new()
use datafusion::error::Result;
    #[test]
            )
}
            continue;
            // existing array-valued field. Non-array / missing → no-op.
            Some(r#"{"teacher":["Alice","Tom"]}"#)
            append(
#[cfg(test)]
        );
        append_one(&mut value, &segments, new_val);
            (Value::Array(arr), Segment::Wildcard) => {
    }
        // but NOT on the value; the arg arrives already stringified and is
        let mut b = StringBuilder::with_capacity(n, n * 16);
    }
    }
    #[test]
impl Default for JsonAppendUdf {
    fn return_type(&self, _args: &[DataType]) -> Result<DataType> {
        }
        Ok(ColumnarValue::Array(Arc::new(b.finish()) as ArrayRef))
    }
                &[Some("teacher"), Some("Tom")],
        let arrays: Vec<ArrayRef> = args
            append(
        args.iter()
 */
            .as_deref(),
    let doc_str = doc?;
 * this file be licensed under the Apache-2.0 license or a
            // Direct array-index / wildcard targets: push onto the *addressed*
                Some(r#"{"teacher":["Alice"]}"#),
        assert!(append(Some("not-json"), &[Some("a"), Some("v")]).is_none());
        &self.signature
                Some(r#"{"groups":[["a"],["b","c"]]}"#),
                &[Some("teacher"), Some("Tom")],
    fn missing_path_is_silent_noop() {
            }
    #[test]
        // pushed as-is).
            Some(r#"{"teacher":["Alice"]}"#)
 * compatible open source license.
            .map(|(i, ty)| coerce_slot(NAME, i, ty, CoerceMode::Utf8))
    ColumnarValue, ScalarFunctionArgs, ScalarUDF, ScalarUDFImpl, Signature, Volatility,
                    inner.push(item.clone());
}
use datafusion::logical_expr::{
            // Push onto the matched array when the final segment names an
    #[test]
        // thrown by `JsonAppendFunctionImpl.eval`; we surface it as NULL to
        );
use datafusion::arrow::datatypes::DataType;
    }
            Some(r#"{"groups":[["a","x"],["b","c","x"]]}"#)
    });
    fn multiple_pairs_append_sequentially() {
    }
                Some(r#"{"teacher":["Alice"]}"#),
fn append(doc: Option<&str>, rest: &[Option<&str>]) -> Option<String> {
//! Values always push as `Value::String` — nested `json_object` / `json_array`
        // a single string element (legacy calls gson/jackson on the outer doc
            Some(r#"{"school":{"teacher":["Alice","[\"Tom\",\"Walt\"]"]}}"#)
                    arr.push(item.clone());
            .collect()
        assert!(append(Some(r#"{"a":[1]}"#), &[Some("a{"), Some("v")]).is_none());
        let segments = parse_ppl_segments(path).ok()?;
mod tests {
            return Ok(ColumnarValue::Scalar(ScalarValue::Utf8(None)));
