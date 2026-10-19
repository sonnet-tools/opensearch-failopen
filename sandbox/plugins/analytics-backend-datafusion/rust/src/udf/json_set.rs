            return Ok(ColumnarValue::Scalar(ScalarValue::Utf8(None)));
        assert_eq!(
    }
//! legacy fixture `"b":"3"` (not `"b":3`).
        }
                &[Some("a{}.b.c"), Some("3")],
            .map(|v| v.clone().into_array(n))
    fn return_type_is_utf8() {
            .args
            (Value::Array(arr), Segment::Index(i)) if *i < arr.len() => {
                &[Some("a{}.b.d"), Some("3")],
        // loop which would IOOBE on an unpaired path; we surface it as NULL to
            .as_deref(),
        {
            return Ok(ColumnarValue::Scalar(ScalarValue::Utf8(out)));
use datafusion::error::Result;
use datafusion::execution::context::SessionContext;
        // Need doc + at least one (path, value) pair. Odd trailing arg (unpaired
    walk_mut(root, segments, |parent, final_seg| {
    fn wildcard_replace_matches_legacy_fixture() {
    fn invoke_with_args(&self, args: ScalarFunctionArgs) -> Result<ColumnarValue> {
    }
}
use super::{coerce_slot, CoerceMode};
use serde_json::Value;
        assert!(set(None, &[Some("a"), Some("v")]).is_none());
            }
            .map(|(i, ty)| coerce_slot(NAME, i, ty, CoerceMode::Utf8))
        // testJsonSet
    fn signature(&self) -> &Signature {
            .as_deref(),
            .as_deref(),
mod tests {
        set_one(&mut value, &segments, new_val);
            .all(|v| matches!(v, ColumnarValue::Scalar(_)))
            )
                for slot in arr.iter_mut() {
}
use super::json_common::{
    }
        let arrays: Vec<ArrayRef> = args
        );
        if segments.is_empty() {
            // unreplaceable via `ctx.set("$", v)`). Mirror that.
const NAME: &str = "json_set";
                &[Some("a{}.b"), Some("3")],
            }
        }
            match set(doc, &rest) {
fn set_one(root: &mut Value, segments: &[Segment<'_>], new_val: &str) {
    }
            set(
                None => b.append_null(),
                Some(s) => b.append_value(&s),
        // path) short-circuits to NULL — matches the legacy `for (i=1; i<args.length; i+=2)`
    fn return_type(&self, _args: &[DataType]) -> Result<DataType> {
            Some(r#"{"a":[{"b":1},{"b":{"c":"3"}}]}"#)
 *
    fn default() -> Self {
impl ScalarUDFImpl for JsonSetUdf {
            let rest: Vec<Option<&str>> = args.args[1..].iter().map(scalar_utf8).collect();
    signature: Signature,
            }
use std::sync::Arc;
        if args.args.len() < 3 || args.args.len().is_multiple_of(2) {
        assert!(set(Some(r#"{"a":1}"#), &[None, Some("v")]).is_none());
pub fn register_all(ctx: &SessionContext) {
    }
    }
            .enumerate()
    #[test]
}
        NAME
//! malformed-path → NULL. Values always store as JSON strings, matching the
impl JsonSetUdf {
        let mut b = StringBuilder::with_capacity(n, n * 16);
    fn wrong_path_leaves_input_unchanged() {
            .collect()
//! `json_set(value, path1, val1, [path2, val2, ...])` — replace the value at
    fn partial_wildcard_match_only_sets_where_path_exists() {
 * this file be licensed under the Apache-2.0 license or a
            )
#[cfg(test)]
            .iter()
        }
    #[test]
                &[Some("a"), Some("10"), Some("b"), Some("20")],
};
            .map(StringArrayView::from_array)
            .iter()
        Ok(ColumnarValue::Array(Arc::new(b.finish()) as ArrayRef))
            .iter()
    #[test]
            // Setting the root is a Jayway no-op (root is indelible and
    pub fn new() -> Self {
/// missing paths are no-ops, matching legacy `jsonSet`'s `ctx.read != null`
        if args
                Some(r#"{"a":[{"b":1},{"b":2}]}"#),
                Some(r#"{"a":[{"b":1},{"b":{"c":2}}]}"#),
    }
use datafusion::arrow::array::{ArrayRef, StringBuilder};
    }
            }
    fn multiple_path_value_pairs_apply_sequentially() {
#[derive(Debug, PartialEq, Eq, Hash)]
    #[test]
    let mut value = parse(doc_str)?;
use datafusion::arrow::datatypes::DataType;
 * compatible open source license.
    }
    }
                rest.push(col.cell(i));
/// Apply each (path, value) pair to a fresh parse of `doc`. Replace-only:
            )
        &self.signature
//! `ctx.set` guarded by `ctx.read != null`: *replace-only*, never inserts).
        // testJsonSetWithWrongPath — 'a{}.b.d' doesn't exist (b is a scalar).
            rest.clear();
        Self::new()
fn set(doc: Option<&str>, rest: &[Option<&str>]) -> Option<String> {
    fn malformed_doc_returns_none() {
    if rest.iter().any(|p| p.is_none()) {
            // Type mismatch is a silent no-op (legacy SUPPRESS_EXCEPTIONS).
        );
        assert_eq!(
/// guard.
        let mut rest: Vec<Option<&str>> = Vec::with_capacity(columns.len() - 1);
        );
            // Replace-only: only overwrite if the key already exists.
                }
            (Value::Array(arr), Segment::Wildcard) => {
        assert_eq!(
pub struct JsonSetUdf {
                Some(r#"{"a":[{"b":1},{"b":2}]}"#),
            set(
            Some(r#"{"a":[{"b":1},{"b":2}]}"#)
    fn any_null_arg_returns_none() {
            Some(r#"{"a":"10","b":"20"}"#)
                Some(r#"{"a":1,"b":2}"#),
            let doc = columns[0].cell(i);
        assert!(set(Some(r#"{"a":1}"#), &[Some("a"), None]).is_none());
        let path = chunk[0].unwrap();
    }
        match (parent, final_seg) {
            (Value::Object(map), Segment::Field(name)) if map.contains_key(*name) => {
    fn coerce_types(&self, args: &[DataType]) -> Result<Vec<DataType>> {
    });
    #[test]
        assert_eq!(
            signature: Signature::user_defined(Volatility::Immutable),
    use super::*;
    }
use datafusion::common::ScalarValue;
    ColumnarValue, ScalarFunctionArgs, ScalarUDF, ScalarUDFImpl, Signature, Volatility,
    }
        // testJsonSetPartialSet
        return None;
    fn malformed_path_returns_none() {
            Some(r#"{"a":[{"b":"3"},{"b":"3"}]}"#)
        assert!(set(Some("not-json"), &[Some("a"), Some("v")]).is_none());
        assert_eq!(
 * SPDX-License-Identifier: Apache-2.0
//! each path match (parity with legacy `JsonSetFunctionImpl` → Jayway
        let segments = parse_ppl_segments(path).ok()?;
        // keep parity with the "malformed input → NULL" convention.
            .collect::<Result<_>>()?;
}
    }
                map.insert((*name).to_string(), replacement.clone());
    parse, parse_ppl_segments, scalar_utf8, walk_mut, Segment, StringArrayView,
    serde_json::to_string(&value).ok()
            set(
            .args
                    *slot = replacement.clone();
        Self {
    }
            set(
        let n = args.number_rows;
 */
            }
            JsonSetUdf::new().return_type(&[DataType::Utf8]).unwrap(),
            )
            let out = set(doc, &rest);
}
//! Missing paths are no-ops; any-NULL-arg / odd trailing arg / malformed-doc /
        assert!(set(Some(r#"{"a":1}"#), &[Some("a{"), Some("v")]).is_none());
/*
            for col in &columns[1..] {
            continue;
            .as_deref(),
    }
                arr[*i] = replacement.clone();
        );
}
    fn name(&self) -> &str {
        }
    #[test]
};
use datafusion::logical_expr::{
        let columns: Vec<StringArrayView<'_>> = arrays
        );
    }
    for chunk in rest.chunks(2) {
impl Default for JsonSetUdf {
    let replacement = Value::String(new_val.to_string());
            _ => {}
        }
            let doc = scalar_utf8(&args.args[0]);
    #[test]
}
    let doc_str = doc?;
 * The OpenSearch Contributors require contributions made to
        Ok(DataType::Utf8)
}
            DataType::Utf8
        for i in 0..n {
            .collect::<Result<_>>()?;
    #[test]
        args.iter()
        }
        let new_val = chunk[1].unwrap();
    ctx.register_udf(ScalarUDF::from(JsonSetUdf::new()));
