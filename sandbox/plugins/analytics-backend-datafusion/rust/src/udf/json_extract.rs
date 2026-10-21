        .map(|p| extract_one(&parsed, p.unwrap()).unwrap_or(Value::Null))
/// Legacy `doJsonize` single-path output: strings emerge unquoted; every other
use datafusion::logical_expr::{
        // No-op parse path so the call shape matches the legacy IT input.
//! (parity with legacy `JsonExtractFunctionImpl` → Calcite `jsonQuery` / `jsonValue`).
    let jsonpath = convert_ppl_path(path).ok()?;
    } else {
    fn malformed_path_returns_none() {
/// legacy `isScalarObject` branch (`.toString()` on Java scalars → same bytes
            vec![DataType::LargeUtf8, DataType::Utf8View]
        let doc = parsed(r#"{"a":null}"#);
}
            let doc = scalar_utf8(&args.args[0]);
            udf.coerce_types(&[DataType::LargeUtf8, DataType::Utf8View])
/// Evaluate a single PPL path against a parsed document. Returns `None` for
            .map(StringArrayView::from_array)
    }
use super::{coerce_slot, CoerceMode};
    #[test]
 *
        // verify the single-path path works end-to-end here.
            .coerce_types(&[DataType::Utf8, DataType::Int32])
 * SPDX-License-Identifier: Apache-2.0
        // Multi-path: wrap in JSON array. NULL misses land as literal `null`
    }
    }
        return None;
            _ => None,
        }
    }
    }
        // Scalar matches unwrap to their string form via `jsonize_single`.
    fn signature(&self) -> &Signature {
    fn name(&self) -> &str {
    }
            // mismatches surface as data NULL rather than query failure
        let mut b = StringBuilder::with_capacity(n, n * 16);
use serde_json::Value;
/*
    }
#[derive(Debug, PartialEq, Eq, Hash)]
            let out = extract(doc, &paths);
            v => Some(v),
        // Unmatched `{` bubbles out as None (legacy would also emit NULL via
        .filter_map(|v| match v {
 */
        // the PLAN-error swallow in the stateful function).
            JsonPathValue::Slice(r, _) => Some(r.clone()),
        let doc = parsed(r#"{"a":[{"t":"A"},{"t":"B"},{"t":"C"}]}"#);
}
pub fn register_all(ctx: &SessionContext) {
        }
        assert_eq!(
    }
        // Homogeneous string variadic.
/// legacy Calcite pair resolves to SQL NULL). Single-match returns the raw
    fn single_path_scalar_match_returns_tostring_form() {
            Value::Null => None,
    }
}
        // core `extract` helper is only called with ≥1 path, so we just
/// JSON value (numbers, bools, arrays, objects) is serialized. Matches the
    fn single_path_container_match_is_jsonized() {
        if args.args.len() < 2 {
/// as `serde_json::to_string` for numbers and booleans).
    #[test]
        Self {
    match matches.len() {
        assert_eq!(
    }
        let udf = JsonExtractUdf::new();
            path_buf.clear();
impl ScalarUDFImpl for JsonExtractUdf {
    match v {
        assert_eq!(extract_one(&doc, "b").map(jsonize_single).unwrap(), "hi");
        let arrays: Vec<ArrayRef> = args
    }
        Self::new()
 * compatible open source license.
        Ok(DataType::Utf8)
    let matches: Vec<Value> = slice
impl JsonExtractUdf {
//! Single-path: scalar → `.to_string()`, string → unquoted, object/array →
    #[test]
        assert_eq!(extract_one(&doc, "d").map(jsonize_single).unwrap(), "42");
        let v = extract_one(&doc, "a{}.t").unwrap();
        .collect();
    let parsed = parse(doc_str)?;
        }
        let n = args.number_rows;
use datafusion::error::Result;
        serde_json::to_string(&Value::Array(per_path)).ok()
            .enumerate()
/// (any-null arg, malformed doc, malformed path, no match, explicit-null match)
use datafusion::arrow::datatypes::DataType;
    let doc_str = doc?;
}
        assert!(err.contains("expected string"));
        NAME
                .unwrap(),
//! JSON-serialized, wildcard multi-match → JSON-array, miss/explicit-null → NULL.
    }
        let err = udf
        );
        // Scalar fast-path: every operand is Scalar → evaluate once.
        assert_eq!(out.as_deref(), Some("1"));
        );
        assert!(extract(Some("not-json"), &[Some("a")]).is_none());
/// `Value`; multi-match returns `Value::Array(...)`.
    #[test]
    }
};
            Value::Null => None,
    pub fn new() -> Self {
                .unwrap(),
    #[test]
        .iter()
fn extract(doc: Option<&str>, paths: &[Option<&str>]) -> Option<String> {
        1 => match matches.into_iter().next().unwrap() {
}
        other => other.to_string(),
pub struct JsonExtractUdf {
                path_buf.push(col.cell(i));
        .into_iter()
            .iter()
        }
    #[test]
        &self.signature
use datafusion::common::ScalarValue;
                None => b.append_null(),
//! Multi-path: per-path results (NULL → `null` element) wrapped in a JSON array.
        for i in 0..n {
}
        let doc = parsed(r#"{"name":"John"}"#);
    fn wildcard_multi_match_wraps_in_array() {
    }
    }
            .all(|v| matches!(v, ColumnarValue::Scalar(_)))
use jsonpath_rust::{JsonPath, JsonPathValue};
            .collect::<Result<_>>()?;
use std::sync::Arc;
        let out = extract(Some(r#"{"a":1}"#), &[Some("a")]);
            extract_one(&doc, "a").map(jsonize_single).unwrap(),
            return Ok(ColumnarValue::Scalar(ScalarValue::Utf8(None)));
    fn default() -> Self {
    ColumnarValue, ScalarFunctionArgs, ScalarUDF, ScalarUDFImpl, Signature, Volatility,
        match per_path.into_iter().next()? {
}
            .map(|v| v.clone().into_array(n))
    }
            .collect()
        // `queryResult != null ? queryResult : valueResult` returns null).
        Value::String(s) => s,
 * this file be licensed under the Apache-2.0 license or a
        assert_eq!(serde_json::to_string(&v).unwrap(), r#"["A","B","C"]"#);
fn jsonize_single(v: Value) -> String {
    signature: Signature,
            r#"{"x":1,"y":2}"#
        .collect();
        },
        assert!(extract(Some(r#"{"a":1}"#), &[None]).is_none());
#[cfg(test)]
//! `json_extract(value, path1, [path2, ...])` — extract JSON value(s) by PPL-path
        _ => Some(Value::Array(matches)),
        assert!(extract_one(&doc, "a").is_none());
            .iter()
impl Default for JsonExtractUdf {
/// and a `Some(String)` for every matched case.
                Some(s) => b.append_value(&s),
            .iter()
 * The OpenSearch Contributors require contributions made to
    }
            .args
            JsonExtractUdf::new()
const NAME: &str = "json_extract";
        })
        let mut path_buf: Vec<Option<&str>> = Vec::with_capacity(columns.len() - 1);
            }
    if paths.len() == 1 {
        assert_eq!(extract_one(&doc, "a").map(jsonize_single).unwrap(), "801.0");
        // Single path: NULL-element collapses to a SQL NULL (legacy's
    fn return_type(&self, _args: &[DataType]) -> Result<DataType> {
            .args
            let doc = columns[0].cell(i);
    #[test]
            let paths: Vec<Option<&str>> = args.args[1..].iter().map(scalar_utf8).collect();
    fn malformed_document_returns_none() {
        serde_json::from_str(s).unwrap()
        0 => None,
    let compiled = JsonPath::try_from(jsonpath.as_str()).ok()?;
            .map(|(i, ty)| coerce_slot(NAME, i, ty, CoerceMode::Utf8))
        let doc = parsed(r#"{"a":801.0,"b":"hi","c":true,"d":42}"#);
    #[test]
            DataType::Utf8
//! `< 2` args / any-NULL-arg / malformed doc / malformed path → NULL.
        }
        Ok(ColumnarValue::Array(Arc::new(b.finish()) as ArrayRef))
            .unwrap_err()
    use super::*;
    }
/// malformed-path, no-match, and explicit-null matches (the three cases the
    let slice = compiled.find_slice(doc);
    ctx.register_udf(ScalarUDF::from(JsonExtractUdf::new()));
        let columns: Vec<StringArrayView<'_>> = arrays
            v => Some(jsonize_single(v)),
    fn missing_and_explicit_null_both_yield_none() {
fn extract_one(doc: &Value, path: &str) -> Option<Value> {
            .to_string();
    fn parsed(s: &str) -> Value {
    fn less_than_two_args_returns_none_via_fast_path() {
    fn coerce_types(&self, args: &[DataType]) -> Result<Vec<DataType>> {
mod tests {
}
        let out = extract(Some(r#"{"name":"John"}"#), &[Some("name"), Some("age")]);
                .return_type(&[DataType::Utf8])
        // elements (testJsonExtractMultiPathWithMissingPath).
            match extract(doc, &path_buf) {
        // Exercised via the UDF entry point in the integration tests; the
    let per_path: Vec<Value> = paths
    fn any_null_arg_returns_none() {
    fn invoke_with_args(&self, args: ScalarFunctionArgs) -> Result<ColumnarValue> {
        // Columnar path: walk row-by-row. Branch production traffic takes.
            return Ok(ColumnarValue::Scalar(ScalarValue::Utf8(out)));
    #[test]
    }
use datafusion::execution::context::SessionContext;
        assert!(extract(Some(r#"{"a":1}"#), &[Some("a{0")]).is_none());
        {
    }
        args.iter()
use super::json_common::{convert_ppl_path, parse, scalar_utf8, StringArrayView};
        );
    #[test]
        assert!(extract_one(&doc, "missing").is_none());
            signature: Signature::user_defined(Volatility::Immutable),
        assert_eq!(extract_one(&doc, "c").map(jsonize_single).unwrap(), "true");
        assert_eq!(
        let doc = parsed(r#"{"a":{"x":1,"y":2}}"#);
            // (matches JsonExtractFunctionImpl.eval's `if (args.length < 2)`).
        assert_eq!(out.as_deref(), Some(r#"["John",null]"#));
}
            for col in &columns[1..] {
        assert!(doc.is_object());
            .collect::<Result<_>>()?;
    }
use datafusion::arrow::array::{ArrayRef, StringBuilder};
            // Legacy short-circuit: < 2 args → NULL. Avoid plan_err so adapter
        if args
        assert!(extract(None, &[Some("a")]).is_none());
    if paths.iter().any(|p| p.is_none()) {
/// Core extraction. Returns `None` for the legacy NULL-producing cases
    }
    }
    fn multi_path_wraps_with_null_slots_for_misses() {
            }
    fn coerce_types_threads_each_slot_independently() {
    fn return_type_is_utf8() {
    #[test]
