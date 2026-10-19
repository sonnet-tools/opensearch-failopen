            .enumerate()
            match delete(doc, &path_buf) {
    });
            .map(|(i, ty)| coerce_slot(NAME, i, ty, CoerceMode::Utf8))
        for i in 0..n {
            let doc = scalar_utf8(&args.args[0]);
        );
}
    let mut value = parse(doc_str)?;
    signature: Signature,
        assert_eq!(
            }
        }
            .as_deref(),
            )
    }
const NAME: &str = "json_delete";
                Some(
/*
use super::{coerce_slot, CoerceMode};
            .collect()
        Ok(ColumnarValue::Array(Arc::new(b.finish()) as ArrayRef))
impl Default for JsonDeleteUdf {
    }
use datafusion::arrow::datatypes::DataType;
//! `json_delete(value, path1, [path2, ...])` — remove path-matched entries
        match (parent, final_seg) {
                Some(r#"{"f1":"abc","f2":{"f3":"a","f4":"b"}}"#),
    }
    }
    fn wildcard_array_delete_matches_legacy_fixture() {
    }
        assert_eq!(
    }
            signature: Signature::user_defined(Volatility::Immutable),
            _ => {}
        // testJsonDeleteWithNested
        );
        {
            // (root is indelible). Mirror that by skipping.
            // Type mismatch between the container and the terminal segment is a
impl ScalarUDFImpl for JsonDeleteUdf {
            // unchanged. Matching that as SQL NULL (not an error) keeps us
                Some(s) => b.append_value(&s),
fn delete(doc: Option<&str>, paths: &[Option<&str>]) -> Option<String> {
    #[test]
    #[test]
        assert!(delete(Some(r#"{"a":1}"#), &[Some("a{")]).is_none());
            (Value::Object(map), Segment::Field(name)) => {
                map.shift_remove(*name);
/// document serialized back to a string.
            )
            )
                Some(r#"{"account_number":1,"balance":39225,"age":32,"gender":"M"}"#),
            Some(r#"{"f1":"abc","f2":{"f4":"b"}}"#)
    fn coerce_types(&self, args: &[DataType]) -> Result<Vec<DataType>> {
            (Value::Array(arr), Segment::Index(i)) if *i < arr.len() => {
//! from a JSON document (parity with legacy `JsonDeleteFunctionImpl` → Jayway
        }
//! Missing paths are no-ops; any-NULL-arg / malformed-doc / malformed-path →
                None => b.append_null(),
        Self {
            // silent no-op, matching Jayway's SUPPRESS_EXCEPTIONS.
#[derive(Debug, PartialEq, Eq, Hash)]
}
use datafusion::arrow::array::{ArrayRef, StringBuilder};
    }
        let n = args.number_rows;
        let arrays: Vec<ArrayRef> = args
    }
        assert_eq!(
        Ok(DataType::Utf8)
            JsonDeleteUdf::new().return_type(&[DataType::Utf8]).unwrap(),
use std::sync::Arc;
    fn default() -> Self {
    fn any_null_arg_returns_none() {
        // Exercised through invoke_with_args — the top-level guard returns
    fn return_type(&self, _args: &[DataType]) -> Result<DataType> {
            Some(r#"{}"#)
            DataType::Utf8
use datafusion::execution::context::SessionContext;
    }
    ColumnarValue, ScalarFunctionArgs, ScalarUDF, ScalarUDFImpl, Signature, Volatility,
    fn malformed_path_returns_none() {
 * compatible open source license.
}
        let mut b = StringBuilder::with_capacity(n, n * 16);
                &[Some("f2.f3")],
}
                arr.clear();
                &[Some("teacher"), Some("student{}.rank")],
    parse, parse_ppl_segments, scalar_utf8, walk_mut, Segment, StringArrayView,
        }
        return None;
        assert_eq!(
            .map(|v| v.clone().into_array(n))
            let paths: Vec<Option<&str>> = args.args[1..].iter().map(scalar_utf8).collect();
        }
            return Ok(ColumnarValue::Scalar(ScalarValue::Utf8(None)));
        }
    pub fn new() -> Self {
            // Legacy `jsonRemove(doc)` with no pathspecs would return `doc`
            .iter()
    fn malformed_doc_returns_none() {
 * SPDX-License-Identifier: Apache-2.0
            let doc = columns[0].cell(i);
            Some(r#"{"f1":"abc","f2":{"f3":"a","f4":"b"}}"#)
            delete(
        if segments.is_empty() {
        delete_one(&mut value, &segments);
    }
            Some(r#"{"account_number":1,"balance":39225}"#)
/// Apply every path's delete to a fresh parse of `doc`. Returns `None` for
fn delete_one(root: &mut Value, segments: &[Segment<'_>]) {
            .args
            .as_deref(),
                    r#"{"teacher":"Alice","student":[{"name":"Bob","rank":1},{"name":"Charlie","rank":2}]}"#
//! `JsonPath.delete` under `SUPPRESS_EXCEPTIONS`, applied per pathspec).
 */
            continue;
    fn missing_path_returns_document_unchanged() {
#[cfg(test)]
        }
            // consistent with the other json_* UDFs' any-NULL-arg convention.
 *
            .all(|v| matches!(v, ColumnarValue::Scalar(_)))
            .iter()
//! feature (see `rust/Cargo.toml`).
    #[test]
        assert!(delete(Some(r#"{"a":1}"#), &[None]).is_none());
    #[test]
            .collect::<Result<_>>()?;
        );
    walk_mut(root, segments, |parent, final_seg| {
            }
use serde_json::Value;
            .collect::<Result<_>>()?;
pub struct JsonDeleteUdf {
        // testJsonDelete
 * this file be licensed under the Apache-2.0 license or a
            delete(
            path_buf.clear();
}
    if paths.iter().any(|p| p.is_none()) {
            }
    fn signature(&self) -> &Signature {
use super::json_common::{
        Self::new()
        // testJsonDeleteWithNestedNothing
mod tests {
        let segments = parse_ppl_segments(path).ok()?;
        );
/// any-NULL arg / malformed doc / malformed path; otherwise the mutated
            let out = delete(doc, &paths);
        let mut path_buf: Vec<Option<&str>> = Vec::with_capacity(columns.len() - 1);
            }
        let columns: Vec<StringArrayView<'_>> = arrays
            delete(Some(r#"{"a":1}"#), &[Some("a")]).as_deref(),
        );
    for path in paths.iter().map(|p| p.unwrap()) {
        &self.signature
            // Legacy `jsonRemove` on an empty path attempts to `ctx.read("$")`
            // which returns the root; `ctx.delete("$")` is a Jayway no-op
                &[Some("age"), Some("gender")],
    fn flat_key_delete_matches_legacy_fixture() {
            .map(StringArrayView::from_array)
    #[test]
            .iter()
        assert!(delete(None, &[Some("a")]).is_none());
    #[test]
    fn invoke_with_args(&self, args: ScalarFunctionArgs) -> Result<ColumnarValue> {
    }
                &[Some("f2.f100")],
}
}
            (Value::Array(arr), Segment::Wildcard) => {
};
    ctx.register_udf(ScalarUDF::from(JsonDeleteUdf::new()));
use datafusion::common::ScalarValue;
            for col in &columns[1..] {
    fn name(&self) -> &str {
            .args
            delete(
    let doc_str = doc?;
    }
            )
    }
                Some(r#"{"f1":"abc","f2":{"f3":"a","f4":"b"}}"#),
        );
        // testJsonDeleteWithNestedAndArray
                arr.remove(*i);
        NAME
    fn return_type_is_utf8() {
        if args
            Some(r#"{"student":[{"name":"Bob"},{"name":"Charlie"}]}"#)
 * The OpenSearch Contributors require contributions made to
impl JsonDeleteUdf {
}
    use super::*;
    #[test]
        assert!(delete(Some("not-json"), &[Some("a")]).is_none());
                path_buf.push(col.cell(i));
        assert_eq!(
                ),
    }
    fn nested_key_delete_preserves_siblings() {
        if args.args.len() < 2 {
        assert_eq!(
    }
            }
    }
            .as_deref(),
    }
            .as_deref(),
use datafusion::logical_expr::{
//! NULL. Output key order is preserved via `serde_json`'s `preserve_order`
            return Ok(ColumnarValue::Scalar(ScalarValue::Utf8(out)));
    fn less_than_two_args_returns_none_via_fast_path() {
    #[test]
    }
    serde_json::to_string(&value).ok()
pub fn register_all(ctx: &SessionContext) {
use datafusion::error::Result;
        // Utf8(None) for <2 args, so helper-level coverage is enough.
};
    #[test]
        args.iter()
            delete(
