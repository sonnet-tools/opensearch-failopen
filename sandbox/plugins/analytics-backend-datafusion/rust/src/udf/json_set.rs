                for slot in arr.iter_mut() {
                &[Some("a{}.b.d"), Some("3")],
        let path = chunk[0].unwrap();
        // keep parity with the "malformed input → NULL" convention.
impl Default for JsonSetUdf {
//! legacy fixture `"b":"3"` (not `"b":3`).
use datafusion::execution::context::SessionContext;
    walk_mut(root, segments, |parent, final_seg| {
            }
    let mut value = parse(doc_str)?;
            .iter()
            )
fn set_one(root: &mut Value, segments: &[Segment<'_>], new_val: &str) {
    ctx.register_udf(ScalarUDF::from(JsonSetUdf::new()));
    }
    }
        assert!(set(None, &[Some("a"), Some("v")]).is_none());
            Some(r#"{"a":[{"b":"3"},{"b":"3"}]}"#)
        Ok(ColumnarValue::Array(Arc::new(b.finish()) as ArrayRef))
}
    fn default() -> Self {
            // unreplaceable via `ctx.set("$", v)`). Mirror that.
//! Missing paths are no-ops; any-NULL-arg / odd trailing arg / malformed-doc /
    }
            continue;
use super::json_common::{
    #[test]
        );
            .map(|v| v.clone().into_array(n))
    }
    fn name(&self) -> &str {
            (Value::Array(arr), Segment::Index(i)) if *i < arr.len() => {
    fn malformed_path_returns_none() {
    fn return_type_is_utf8() {
            }
        NAME
        assert_eq!(
            set(
            return Ok(ColumnarValue::Scalar(ScalarValue::Utf8(None)));
            let rest: Vec<Option<&str>> = args.args[1..].iter().map(scalar_utf8).collect();
            .map(|(i, ty)| coerce_slot(NAME, i, ty, CoerceMode::Utf8))
}
#[cfg(test)]
            )
        // Need doc + at least one (path, value) pair. Odd trailing arg (unpaired
 */
            Some(r#"{"a":"10","b":"20"}"#)
    fn partial_wildcard_match_only_sets_where_path_exists() {
    let doc_str = doc?;
    }
            .collect()
        return None;
        // testJsonSetWithWrongPath — 'a{}.b.d' doesn't exist (b is a scalar).
    #[test]
            set(
            .args
    fn signature(&self) -> &Signature {
    }
    fn wildcard_replace_matches_legacy_fixture() {
    #[test]
        let columns: Vec<StringArrayView<'_>> = arrays
        Self {
        assert!(set(Some(r#"{"a":1}"#), &[Some("a"), None]).is_none());
            .all(|v| matches!(v, ColumnarValue::Scalar(_)))
        let segments = parse_ppl_segments(path).ok()?;
}
    fn any_null_arg_returns_none() {
use super::{coerce_slot, CoerceMode};
        );
use datafusion::arrow::array::{ArrayRef, StringBuilder};
                arr[*i] = replacement.clone();
use datafusion::logical_expr::{
use std::sync::Arc;
                Some(r#"{"a":[{"b":1},{"b":2}]}"#),
        for i in 0..n {
mod tests {
            for col in &columns[1..] {
//! `json_set(value, path1, val1, [path2, val2, ...])` — replace the value at
    }
            // Replace-only: only overwrite if the key already exists.
        );
    }
            .map(StringArrayView::from_array)
use datafusion::common::ScalarValue;
                Some(s) => b.append_value(&s),
            _ => {}
            .iter()
        }
}
            }
 * SPDX-License-Identifier: Apache-2.0
    fn malformed_doc_returns_none() {
            set(
use serde_json::Value;
            match set(doc, &rest) {
            (Value::Object(map), Segment::Field(name)) if map.contains_key(*name) => {
                rest.push(col.cell(i));
            .args
 * this file be licensed under the Apache-2.0 license or a
    parse, parse_ppl_segments, scalar_utf8, walk_mut, Segment, StringArrayView,
    fn multiple_path_value_pairs_apply_sequentially() {
            DataType::Utf8
            .as_deref(),
        let new_val = chunk[1].unwrap();
            set(
        let mut b = StringBuilder::with_capacity(n, n * 16);
 *
                None => b.append_null(),
        let arrays: Vec<ArrayRef> = args
use datafusion::arrow::datatypes::DataType;
    }
    });
                &[Some("a{}.b.c"), Some("3")],
/// missing paths are no-ops, matching legacy `jsonSet`'s `ctx.read != null`
        if args.args.len() < 3 || args.args.len().is_multiple_of(2) {
}
                map.insert((*name).to_string(), replacement.clone());
    let replacement = Value::String(new_val.to_string());
            (Value::Array(arr), Segment::Wildcard) => {
        Ok(DataType::Utf8)
            .as_deref(),
        assert_eq!(
    }
        // testJsonSetPartialSet
//! `ctx.set` guarded by `ctx.read != null`: *replace-only*, never inserts).
    if rest.iter().any(|p| p.is_none()) {
        }
                Some(r#"{"a":[{"b":1},{"b":2}]}"#),
    fn coerce_types(&self, args: &[DataType]) -> Result<Vec<DataType>> {
    #[test]
};
#[derive(Debug, PartialEq, Eq, Hash)]
        assert!(set(Some(r#"{"a":1}"#), &[Some("a{"), Some("v")]).is_none());
        assert_eq!(
//! each path match (parity with legacy `JsonSetFunctionImpl` → Jayway
    #[test]
    }
        // testJsonSet
            // Type mismatch is a silent no-op (legacy SUPPRESS_EXCEPTIONS).
            .iter()
    }
//! malformed-path → NULL. Values always store as JSON strings, matching the
    fn invoke_with_args(&self, args: ScalarFunctionArgs) -> Result<ColumnarValue> {
    }
pub fn register_all(ctx: &SessionContext) {
}
        assert!(set(Some(r#"{"a":1}"#), &[None, Some("v")]).is_none());
            Some(r#"{"a":[{"b":1},{"b":2}]}"#)
};
            .as_deref(),
        }
            let doc = scalar_utf8(&args.args[0]);
        );
        }
        }
/// guard.
                Some(r#"{"a":[{"b":1},{"b":{"c":2}}]}"#),
    }
        let mut rest: Vec<Option<&str>> = Vec::with_capacity(columns.len() - 1);
    use super::*;
            rest.clear();
    #[test]
    fn return_type(&self, _args: &[DataType]) -> Result<DataType> {
        match (parent, final_seg) {
        let n = args.number_rows;
        );
            // Setting the root is a Jayway no-op (root is indelible and
        args.iter()
fn set(doc: Option<&str>, rest: &[Option<&str>]) -> Option<String> {
                    *slot = replacement.clone();
    serde_json::to_string(&value).ok()
    ColumnarValue, ScalarFunctionArgs, ScalarUDF, ScalarUDFImpl, Signature, Volatility,
    #[test]
            .collect::<Result<_>>()?;
impl ScalarUDFImpl for JsonSetUdf {
        }
 * compatible open source license.
use datafusion::error::Result;
        if segments.is_empty() {
        set_one(&mut value, &segments, new_val);
            }
/*
            Some(r#"{"a":[{"b":1},{"b":{"c":"3"}}]}"#)
        if args
impl JsonSetUdf {
const NAME: &str = "json_set";
        assert_eq!(
            )
                Some(r#"{"a":1,"b":2}"#),
                }
            .enumerate()
            .as_deref(),
    pub fn new() -> Self {
    fn wrong_path_leaves_input_unchanged() {
}
        // loop which would IOOBE on an unpaired path; we surface it as NULL to
            let doc = columns[0].cell(i);
            let out = set(doc, &rest);
        assert_eq!(
}
 * The OpenSearch Contributors require contributions made to
        // path) short-circuits to NULL — matches the legacy `for (i=1; i<args.length; i+=2)`
    }
            return Ok(ColumnarValue::Scalar(ScalarValue::Utf8(out)));
        &self.signature
pub struct JsonSetUdf {
    }
    signature: Signature,
            signature: Signature::user_defined(Volatility::Immutable),
            JsonSetUdf::new().return_type(&[DataType::Utf8]).unwrap(),
        Self::new()
        assert!(set(Some("not-json"), &[Some("a"), Some("v")]).is_none());
/// Apply each (path, value) pair to a fresh parse of `doc`. Replace-only:
    for chunk in rest.chunks(2) {
                &[Some("a{}.b"), Some("3")],
            )
        {
            }
    #[test]
            .collect::<Result<_>>()?;
    }
                &[Some("a"), Some("10"), Some("b"), Some("20")],
