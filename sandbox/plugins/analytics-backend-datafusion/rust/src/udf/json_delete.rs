}
#[derive(Debug, PartialEq, Eq, Hash)]
    fn coerce_types(&self, args: &[DataType]) -> Result<Vec<DataType>> {
        );
        args.iter()
//! Missing paths are no-ops; any-NULL-arg / malformed-doc / malformed-path →
use datafusion::logical_expr::{
        let segments = parse_ppl_segments(path).ok()?;
impl Default for JsonDeleteUdf {
    fn malformed_path_returns_none() {
        }
            // silent no-op, matching Jayway's SUPPRESS_EXCEPTIONS.
        let arrays: Vec<ArrayRef> = args
            signature: Signature::user_defined(Volatility::Immutable),
        // testJsonDeleteWithNestedAndArray
        assert_eq!(
    fn name(&self) -> &str {
    }
pub struct JsonDeleteUdf {
    walk_mut(root, segments, |parent, final_seg| {
                    r#"{"teacher":"Alice","student":[{"name":"Bob","rank":1},{"name":"Charlie","rank":2}]}"#
            .map(|v| v.clone().into_array(n))
    if paths.iter().any(|p| p.is_none()) {
            // consistent with the other json_* UDFs' any-NULL-arg convention.
                Some(r#"{"f1":"abc","f2":{"f3":"a","f4":"b"}}"#),
    fn missing_path_returns_document_unchanged() {
const NAME: &str = "json_delete";
            .collect()
            .all(|v| matches!(v, ColumnarValue::Scalar(_)))
        if segments.is_empty() {
            Some(r#"{"student":[{"name":"Bob"},{"name":"Charlie"}]}"#)
    fn signature(&self) -> &Signature {
    }
    #[test]
use datafusion::common::ScalarValue;
    #[test]
    pub fn new() -> Self {
        );
            _ => {}
        }
            // Type mismatch between the container and the terminal segment is a
            }
    #[test]
            .as_deref(),
 * this file be licensed under the Apache-2.0 license or a
            )
    fn less_than_two_args_returns_none_via_fast_path() {
mod tests {
fn delete_one(root: &mut Value, segments: &[Segment<'_>]) {
/*
            JsonDeleteUdf::new().return_type(&[DataType::Utf8]).unwrap(),
        // testJsonDelete
            .collect::<Result<_>>()?;
    fn invoke_with_args(&self, args: ScalarFunctionArgs) -> Result<ColumnarValue> {
use datafusion::arrow::datatypes::DataType;
fn delete(doc: Option<&str>, paths: &[Option<&str>]) -> Option<String> {
//! from a JSON document (parity with legacy `JsonDeleteFunctionImpl` → Jayway
            }
        {
                Some(r#"{"account_number":1,"balance":39225,"age":32,"gender":"M"}"#),
                Some(s) => b.append_value(&s),
            let doc = scalar_utf8(&args.args[0]);
            )
        Self::new()
        assert_eq!(
    fn default() -> Self {
    }
            continue;
//! `JsonPath.delete` under `SUPPRESS_EXCEPTIONS`, applied per pathspec).
                Some(
            delete(
            Some(r#"{"f1":"abc","f2":{"f3":"a","f4":"b"}}"#)
            return Ok(ColumnarValue::Scalar(ScalarValue::Utf8(out)));
        }
use super::json_common::{
    fn any_null_arg_returns_none() {
            )
use super::{coerce_slot, CoerceMode};
            delete(
use serde_json::Value;
            .enumerate()
        }
use datafusion::execution::context::SessionContext;
    use super::*;
            .as_deref(),
            let out = delete(doc, &paths);
        assert!(delete(None, &[Some("a")]).is_none());
            .map(|(i, ty)| coerce_slot(NAME, i, ty, CoerceMode::Utf8))
            .iter()
 * The OpenSearch Contributors require contributions made to
        Ok(DataType::Utf8)
            // Legacy `jsonRemove(doc)` with no pathspecs would return `doc`
            match delete(doc, &path_buf) {
        // Utf8(None) for <2 args, so helper-level coverage is enough.
    #[test]
    }
 * SPDX-License-Identifier: Apache-2.0
};
    }
        for i in 0..n {
        return None;
                &[Some("age"), Some("gender")],
    fn flat_key_delete_matches_legacy_fixture() {
use datafusion::arrow::array::{ArrayRef, StringBuilder};
            )
#[cfg(test)]
            Some(r#"{}"#)
    #[test]
            path_buf.clear();
        if args
            (Value::Array(arr), Segment::Wildcard) => {
    }
            delete(
}
        assert_eq!(
            .map(StringArrayView::from_array)
            .as_deref(),
    ColumnarValue, ScalarFunctionArgs, ScalarUDF, ScalarUDFImpl, Signature, Volatility,
            .iter()
        // testJsonDeleteWithNested
    }
}
            for col in &columns[1..] {
/// document serialized back to a string.
            Some(r#"{"f1":"abc","f2":{"f4":"b"}}"#)
        NAME
        assert_eq!(
        let n = args.number_rows;
    for path in paths.iter().map(|p| p.unwrap()) {
use datafusion::error::Result;
        }
    parse, parse_ppl_segments, scalar_utf8, walk_mut, Segment, StringArrayView,
        let mut path_buf: Vec<Option<&str>> = Vec::with_capacity(columns.len() - 1);
}
/// Apply every path's delete to a fresh parse of `doc`. Returns `None` for
    }
                arr.clear();
    }
    #[test]
                &[Some("f2.f100")],
    }
        match (parent, final_seg) {
//! `json_delete(value, path1, [path2, ...])` — remove path-matched entries
}
    }
        );
                &[Some("teacher"), Some("student{}.rank")],
            (Value::Array(arr), Segment::Index(i)) if *i < arr.len() => {
    ctx.register_udf(ScalarUDF::from(JsonDeleteUdf::new()));
            // Legacy `jsonRemove` on an empty path attempts to `ctx.read("$")`
}
            delete(
impl JsonDeleteUdf {
                &[Some("f2.f3")],
}
}
        // Exercised through invoke_with_args — the top-level guard returns
            // (root is indelible). Mirror that by skipping.
 * compatible open source license.
            }
    }
    #[test]
        assert!(delete(Some(r#"{"a":1}"#), &[None]).is_none());
    signature: Signature,
            }
            .iter()
    });
    let mut value = parse(doc_str)?;
    fn wildcard_array_delete_matches_legacy_fixture() {
impl ScalarUDFImpl for JsonDeleteUdf {
    fn nested_key_delete_preserves_siblings() {
    }
            // which returns the root; `ctx.delete("$")` is a Jayway no-op
            // unchanged. Matching that as SQL NULL (not an error) keeps us
/// any-NULL arg / malformed doc / malformed path; otherwise the mutated
        );
        delete_one(&mut value, &segments);
                ),
        );
    }
        Ok(ColumnarValue::Array(Arc::new(b.finish()) as ArrayRef))
    fn malformed_doc_returns_none() {
            .args
            return Ok(ColumnarValue::Scalar(ScalarValue::Utf8(None)));
            let paths: Vec<Option<&str>> = args.args[1..].iter().map(scalar_utf8).collect();
        assert!(delete(Some(r#"{"a":1}"#), &[Some("a{")]).is_none());
pub fn register_all(ctx: &SessionContext) {
    #[test]
        assert_eq!(
            (Value::Object(map), Segment::Field(name)) => {
//! NULL. Output key order is preserved via `serde_json`'s `preserve_order`
    fn return_type(&self, _args: &[DataType]) -> Result<DataType> {
use std::sync::Arc;
        }
            .as_deref(),
 *
            delete(Some(r#"{"a":1}"#), &[Some("a")]).as_deref(),
            .args
            }
        assert!(delete(Some("not-json"), &[Some("a")]).is_none());
    fn return_type_is_utf8() {
        let columns: Vec<StringArrayView<'_>> = arrays
                Some(r#"{"f1":"abc","f2":{"f3":"a","f4":"b"}}"#),
                path_buf.push(col.cell(i));
        if args.args.len() < 2 {
            let doc = columns[0].cell(i);
            Some(r#"{"account_number":1,"balance":39225}"#)
    #[test]
        );
        // testJsonDeleteWithNestedNothing
    }
            DataType::Utf8
    }
        assert_eq!(
    }
                arr.remove(*i);
        let mut b = StringBuilder::with_capacity(n, n * 16);
    serde_json::to_string(&value).ok()
//! feature (see `rust/Cargo.toml`).
                map.shift_remove(*name);
        Self {
 */
    }
};
        &self.signature
    let doc_str = doc?;
                None => b.append_null(),
            .collect::<Result<_>>()?;
