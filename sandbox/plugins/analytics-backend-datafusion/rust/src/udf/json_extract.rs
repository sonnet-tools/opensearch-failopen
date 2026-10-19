/// Evaluate a single PPL path against a parsed document. Returns `None` for
    }
            let out = extract(doc, &paths);
            Value::Null => None,
            extract_one(&doc, "a").map(jsonize_single).unwrap(),
        serde_json::to_string(&Value::Array(per_path)).ok()
            v => Some(v),
use datafusion::arrow::datatypes::DataType;
        assert!(extract(Some("not-json"), &[Some("a")]).is_none());
        &self.signature
        _ => Some(Value::Array(matches)),
        // Single path: NULL-element collapses to a SQL NULL (legacy's
use jsonpath_rust::{JsonPath, JsonPathValue};
                path_buf.push(col.cell(i));
use datafusion::logical_expr::{
            v => Some(jsonize_single(v)),
/*
    #[test]
/// legacy Calcite pair resolves to SQL NULL). Single-match returns the raw
        // the PLAN-error swallow in the stateful function).
        match per_path.into_iter().next()? {
    }
        let udf = JsonExtractUdf::new();
        let err = udf
            r#"{"x":1,"y":2}"#
}
        Self::new()
    let compiled = JsonPath::try_from(jsonpath.as_str()).ok()?;
    }
            path_buf.clear();
        assert!(doc.is_object());
        }
    #[test]
        assert_eq!(extract_one(&doc, "c").map(jsonize_single).unwrap(), "true");
        .collect();
/// (any-null arg, malformed doc, malformed path, no match, explicit-null match)
use datafusion::execution::context::SessionContext;
        assert_eq!(
            udf.coerce_types(&[DataType::LargeUtf8, DataType::Utf8View])
    #[test]
            .args
    }
//! `< 2` args / any-NULL-arg / malformed doc / malformed path → NULL.
        // verify the single-path path works end-to-end here.
                .return_type(&[DataType::Utf8])
        serde_json::from_str(s).unwrap()
            .iter()
        assert!(extract(Some(r#"{"a":1}"#), &[None]).is_none());
    match matches.len() {
    fn return_type_is_utf8() {
//! JSON-serialized, wildcard multi-match → JSON-array, miss/explicit-null → NULL.
        // Exercised via the UDF entry point in the integration tests; the
            .map(|(i, ty)| coerce_slot(NAME, i, ty, CoerceMode::Utf8))
    }
        // Homogeneous string variadic.
        let n = args.number_rows;
}
        if args
        );
        let arrays: Vec<ArrayRef> = args
    fn signature(&self) -> &Signature {
        for i in 0..n {
/// `Value`; multi-match returns `Value::Array(...)`.
//! (parity with legacy `JsonExtractFunctionImpl` → Calcite `jsonQuery` / `jsonValue`).
            .to_string();
impl ScalarUDFImpl for JsonExtractUdf {
    }
        }
        assert_eq!(out.as_deref(), Some("1"));
        },
    }
            Value::Null => None,
use super::{coerce_slot, CoerceMode};
    fn single_path_container_match_is_jsonized() {
 * The OpenSearch Contributors require contributions made to
impl Default for JsonExtractUdf {
    fn default() -> Self {
        let doc = parsed(r#"{"a":801.0,"b":"hi","c":true,"d":42}"#);
        // core `extract` helper is only called with ≥1 path, so we just
fn jsonize_single(v: Value) -> String {
    }
        .iter()
            .collect()
    }
const NAME: &str = "json_extract";
    }
            JsonPathValue::Slice(r, _) => Some(r.clone()),
                .unwrap(),
        args.iter()
//! Multi-path: per-path results (NULL → `null` element) wrapped in a JSON array.
    fn coerce_types(&self, args: &[DataType]) -> Result<Vec<DataType>> {
        .map(|p| extract_one(&parsed, p.unwrap()).unwrap_or(Value::Null))
            .unwrap_err()
        assert_eq!(extract_one(&doc, "d").map(jsonize_single).unwrap(), "42");
            .iter()
    match v {
    fn malformed_path_returns_none() {
            for col in &columns[1..] {
    let parsed = parse(doc_str)?;
            // Legacy short-circuit: < 2 args → NULL. Avoid plan_err so adapter
    ColumnarValue, ScalarFunctionArgs, ScalarUDF, ScalarUDFImpl, Signature, Volatility,
mod tests {
pub struct JsonExtractUdf {
        assert_eq!(out.as_deref(), Some(r#"["John",null]"#));
        // Scalar matches unwrap to their string form via `jsonize_single`.
    #[test]
};
 * this file be licensed under the Apache-2.0 license or a
use super::json_common::{convert_ppl_path, parse, scalar_utf8, StringArrayView};
        {
    fn any_null_arg_returns_none() {
            match extract(doc, &path_buf) {
use std::sync::Arc;
    }
            .args
        // Multi-path: wrap in JSON array. NULL misses land as literal `null`
    }
        let doc = parsed(r#"{"name":"John"}"#);
        Ok(ColumnarValue::Array(Arc::new(b.finish()) as ArrayRef))
/// malformed-path, no-match, and explicit-null matches (the three cases the
    let per_path: Vec<Value> = paths
        );
        let doc = parsed(r#"{"a":null}"#);
            let doc = columns[0].cell(i);
    fn single_path_scalar_match_returns_tostring_form() {
            .all(|v| matches!(v, ColumnarValue::Scalar(_)))
        assert!(extract(None, &[Some("a")]).is_none());
    signature: Signature,
}
            vec![DataType::LargeUtf8, DataType::Utf8View]
        // Scalar fast-path: every operand is Scalar → evaluate once.
    }
        let columns: Vec<StringArrayView<'_>> = arrays
 * SPDX-License-Identifier: Apache-2.0
    }
            JsonExtractUdf::new()
        // elements (testJsonExtractMultiPathWithMissingPath).
        let mut path_buf: Vec<Option<&str>> = Vec::with_capacity(columns.len() - 1);
/// as `serde_json::to_string` for numbers and booleans).
        NAME
        }
    #[test]
        1 => match matches.into_iter().next().unwrap() {
        assert_eq!(
        Value::String(s) => s,
/// legacy `isScalarObject` branch (`.toString()` on Java scalars → same bytes
        let mut b = StringBuilder::with_capacity(n, n * 16);
        0 => None,
                None => b.append_null(),
            .coerce_types(&[DataType::Utf8, DataType::Int32])
    }
        // `queryResult != null ? queryResult : valueResult` returns null).
            .map(StringArrayView::from_array)
    if paths.iter().any(|p| p.is_none()) {
            return Ok(ColumnarValue::Scalar(ScalarValue::Utf8(None)));
            return Ok(ColumnarValue::Scalar(ScalarValue::Utf8(out)));
        assert!(extract(Some(r#"{"a":1}"#), &[Some("a{0")]).is_none());
            // (matches JsonExtractFunctionImpl.eval's `if (args.length < 2)`).
    }
        return None;
    }
    let matches: Vec<Value> = slice
        .collect();
            signature: Signature::user_defined(Volatility::Immutable),
                Some(s) => b.append_value(&s),
        assert_eq!(
    ctx.register_udf(ScalarUDF::from(JsonExtractUdf::new()));
        other => other.to_string(),
        let doc = parsed(r#"{"a":[{"t":"A"},{"t":"B"},{"t":"C"}]}"#);
        }
        let doc = parsed(r#"{"a":{"x":1,"y":2}}"#);
 */
fn extract_one(doc: &Value, path: &str) -> Option<Value> {
        .filter_map(|v| match v {
            DataType::Utf8
    let jsonpath = convert_ppl_path(path).ok()?;
    pub fn new() -> Self {
    let slice = compiled.find_slice(doc);
        let out = extract(Some(r#"{"a":1}"#), &[Some("a")]);
        // Columnar path: walk row-by-row. Branch production traffic takes.
/// Legacy `doJsonize` single-path output: strings emerge unquoted; every other
            // mismatches surface as data NULL rather than query failure
        }
//! `json_extract(value, path1, [path2, ...])` — extract JSON value(s) by PPL-path
    #[test]
    #[test]
}
        let out = extract(Some(r#"{"name":"John"}"#), &[Some("name"), Some("age")]);
            .map(|v| v.clone().into_array(n))
//! Single-path: scalar → `.to_string()`, string → unquoted, object/array →
pub fn register_all(ctx: &SessionContext) {
    fn multi_path_wraps_with_null_slots_for_misses() {
    } else {
use datafusion::common::ScalarValue;
        assert_eq!(serde_json::to_string(&v).unwrap(), r#"["A","B","C"]"#);
    #[test]
            .collect::<Result<_>>()?;
        Self {
            .iter()
        let v = extract_one(&doc, "a{}.t").unwrap();
    fn coerce_types_threads_each_slot_independently() {
}
    fn parsed(s: &str) -> Value {
        );
use datafusion::error::Result;
            _ => None,
    fn wildcard_multi_match_wraps_in_array() {
        assert_eq!(extract_one(&doc, "a").map(jsonize_single).unwrap(), "801.0");
}
        assert!(extract_one(&doc, "missing").is_none());
/// and a `Some(String)` for every matched case.
        assert!(extract_one(&doc, "a").is_none());
/// JSON value (numbers, bools, arrays, objects) is serialized. Matches the
            }
}
#[cfg(test)]
    }
    #[test]
 *
    #[test]
        // No-op parse path so the call shape matches the legacy IT input.
#[derive(Debug, PartialEq, Eq, Hash)]
    }
            }
    }
                .unwrap(),
use serde_json::Value;
fn extract(doc: Option<&str>, paths: &[Option<&str>]) -> Option<String> {
    use super::*;
    }
use datafusion::arrow::array::{ArrayRef, StringBuilder};
            .enumerate()
    fn return_type(&self, _args: &[DataType]) -> Result<DataType> {
    let doc_str = doc?;
        if args.args.len() < 2 {
}
        assert!(err.contains("expected string"));
    #[test]
        assert_eq!(extract_one(&doc, "b").map(jsonize_single).unwrap(), "hi");
/// Core extraction. Returns `None` for the legacy NULL-producing cases
    }
        .into_iter()
        Ok(DataType::Utf8)
        // Unmatched `{` bubbles out as None (legacy would also emit NULL via
            let doc = scalar_utf8(&args.args[0]);
    fn less_than_two_args_returns_none_via_fast_path() {
    fn missing_and_explicit_null_both_yield_none() {
            let paths: Vec<Option<&str>> = args.args[1..].iter().map(scalar_utf8).collect();
}
impl JsonExtractUdf {
        })
    if paths.len() == 1 {
    fn name(&self) -> &str {
            .collect::<Result<_>>()?;
 * compatible open source license.
    fn malformed_document_returns_none() {
    }
    fn invoke_with_args(&self, args: ScalarFunctionArgs) -> Result<ColumnarValue> {
