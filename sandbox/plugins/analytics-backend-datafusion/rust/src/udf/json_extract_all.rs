            // by `walk`. Defensive: serialize as JSON so a future caller that
                match v.render() {
        let mut b = new_map_builder(n);
            rendered(r#"{"empty":[]}"#).unwrap(),
//! arrays append a `{}` segment (`tags{}`); duplicate logical keys merge into a
                        assert_eq!(fields[0].name(), "key");
        }
        &self.signature
    }
            }
    )
fn stringify_number(n: &serde_json::Number) -> String {
        );
                None => None,
        StringBuilder::new(),
        // `{"x": null}` → key `x` present, value rendered as the literal
    fn empty_object_returns_empty_map() {
    if let Some(i) = n.as_i64() {
/// One logical value at a path. Mirrors the legacy `Object` slot —
    #[test]
            vec![
    fn name(&self) -> &str {
    fn rendered(s: &str) -> Option<Vec<(String, String)>> {
//! whatever was parsed before the syntax error, matching the legacy
            }
        );
    }
            false,
type OrderedEntries = Vec<(String, Slot)>;
            other => panic!("expected Map, got {other:?}"),
    let parsed = match parse(s) {
//! {@code JsonExtractAllFunctionImpl#parseJson}).
use datafusion::arrow::datatypes::{DataType, Field, Fields};
            } else if s.ends_with(ARRAY_MARKER) {
            Slot::Single(None) => Some("null".to_string()),
    b: &mut MapBuilder<StringBuilder, StringBuilder>,
        assert_eq!(
        );
const ARRAY_MARKER: &str = "{}";
                ("system".to_string(), "linux".to_string()),
/// bool, null). Matches the legacy contract exactly.
                ("age".to_string(), "30".to_string()),
/// `path` is the current path stack (field names + array markers). Empty
        assert_eq!(
    #[test]
        Ok(ColumnarValue::Array(Arc::new(b.finish()) as ArrayRef))
/// substrait-friendly Arrow shape that decodes to the same logical type.
}
/// streaming-parser order in the legacy impl.
use serde_json::Value;
use datafusion::execution::context::SessionContext;
        _ => None,
        Arc::new(Field::new(
        let udf = JsonExtractAllUdf::new();
    s
    #[test]
 */
            let s = scalar_str(sv);
                ("name".to_string(), "John".to_string()),
fn extract_all(s: &str) -> Option<OrderedEntries> {
}
/// does. Returns `None` for JSON null (rendered as `"null"` at the outer
///  - Integers in i64 range → `123`, `9223372036854775807`
                path.pop();
    fn empty_array_yields_no_entry() {
    // form serde_json holds internally.
/// `IndexMap` so the wire-level JSON object key order matches Jackson's
        return u.to_string();
            DataType::Map(field, sorted) => {
            .to_string()
/// Public entry — returns `Some(map)` when the input parses (possibly to an
        extract_all(s).map(|entries| {
        // string `"null"` (legacy `String.valueOf((Object) null) == "null"`).
    fn top_level_array_of_objects_roots_at_curly_marker() {
    // Should be unreachable for finite JSON; fall back to the raw textual
            for _ in 0..n {
    match sv {
            for (k, v) in map.iter() {
            Some(v.to_string())
                path.push(key.clone());
    for segment in path {
/// boundary — see `Slot::render`).
            vec![("{}.a".to_string(), "[null, 1]".to_string())]
        leaf => {
}
//! literal string `"null"`. Null input / empty / whitespace / top-level scalar
        );
            let mut b = new_map_builder(n);
        let dt = JsonExtractAllUdf::new()
            rendered(r#"[{"a":null},{"a":1}]"#).unwrap(),
/// Stringify a JSON scalar exactly the way the legacy `String.valueOf` chain
        }
            }
 *
        let strings = StringArrayView::from_array(&arr)?;
    }
    n.to_string()
    }
enum Slot {
        // Scalar fast-path — every row in the batch evaluates to the same map.
        NAME
            // promoting to a real Scalar for Map; the cleanest fast-path here
    }
                Some(text) => extract_all(text),
    match v {
            path.pop();
    }
    }
    }
}
                append_row(&mut b, result.as_ref())?;
    if s.trim().is_empty() {
        Self::new()
        let arr = args.args[0].clone().into_array(n)?;
                // `VALUE_NAME` so the SQL-plugin response marshaller can use
        // state), but the IT-side `testSpathAutoExtractMalformedJson` only
        Value::Array(arr) => {
impl Default for JsonExtractAllUdf {
            Slot::Single(first) => {
    fn default() -> Self {
/// through unchanged; field-name separators are `.`. Adjacent `{}` segments
        }
    fn nested_object_flattens_to_dotted_path() {
 * The OpenSearch Contributors require contributions made to
        let n = args.number_rows;
        }
        // `{"a":{"b":1}, "a.b": 2}` — Jackson's parser emits the outer key
    } else {
                        assert!(!fields[0].is_nullable());
        Value::Object(map) => {
            append_row(&mut b, row_result.as_ref())?;
    if let Some((_, existing)) = out.iter_mut().find(|(k, _)| *k == key) {
    let mut s = String::with_capacity(path.iter().map(|p| p.len() + 1).sum::<usize>());
    /// as the literal string `"null"` to match Java's `String.valueOf(null)`.
        false,
    match v {
    }
            let row_result = match strings.cell(i) {
    /// `[v1, v2, ..., vn]` with `null` for null elements — Java's
    let mut out: OrderedEntries = Vec::new();
                ("user.name".to_string(), "John".to_string()),
            rendered(r#"[1,2,3]"#).unwrap(),
    };
                Some(s) => extract_all(s),
    fn array_of_objects_propagates_marker_into_children() {
            DataType::Struct(Fields::from(vec![
        // Malformed → legacy swallows the error and returns the partial map.
            // is still to drop into the columnar builder for n rows and emit
        assert_eq!(rendered(r#"{}"#).unwrap(), Vec::<(String, String)>::new());
            .unwrap_err()
            let key = build_path(path);
/// dotted key that collides with a nested-object path), so O(n) lookup on
        Some(v) => v,
            }
    entries: Option<&OrderedEntries>,
                v.push(first.take());
    ColumnarValue, ScalarFunctionArgs, ScalarUDF, ScalarUDFImpl, Signature, Volatility,
        match self {
pub fn register_all(ctx: &SessionContext) {
            s.push_str(ARRAY_MARKER);
/// Join `path` into a dotted/`{}`-terminated string. Array markers `{}` carry
            Slot::Single(Some(s)) => Some(s.clone()),
                }
    #[test]
        return None;
            .unwrap();
///  - Non-integers → Rust's default `{}` formatter, which is the shortest
pub struct JsonExtractAllUdf {
/// `Vec<(String, Slot)>` rather than pulling `indexmap` into the dep tree —
    fn simple_object_dotted_keys_for_scalars() {
/// empty map) and is rooted at a JSON object/array; `None` for null/empty/
    }
        assert!(rendered("   ").is_none());
    signature: Signature,
    }
        StringBuilder::new(),
        assert_eq!(
        capacity,
            value: "value".to_string(),
        assert!(udf
    }
            ]
            // by returning Array. DataFusion broadcasts a 1-row Array vs.
        Self {
//! `JsonExtractAllFunctionImpl`). Objects flatten to dotted keys (`user.name`);
}
        Some(map) => {
                assert!(!sorted);
    fn null_and_empty_input_returns_none() {
            // Caller shouldn't reach this — containers are walked recursively
        }
                ("x".to_string(), "null".to_string()),
        // serde_json is all-or-nothing, so we return the empty map — the
//! / top-level number → NULL map. Malformed JSON → empty map (we silently keep
        }
    #[test]
            path.push(ARRAY_MARKER.to_string());
        }
    /// Two or more values at the same path. Renders as
    Single(Option<String>),
#[derive(Debug)]
use datafusion::logical_expr::{
    /// A single value. `None` here means a JSON null was inserted; it renders
            insert(out, key, value);
    }
/*
            .return_type(&[DataType::Utf8])
            };
            "entries",
    }
                    .collect();
}
        }
        assert_eq!(
};
use super::json_common::{check_arity, parse, StringArrayView};
use datafusion::error::Result;
                match field.data_type() {
        }
    MapBuilder::with_capacity(
            }
impl ScalarUDFImpl for JsonExtractAllUdf {
///    round-trip form (matches `Double.toString` for the common
 * compatible open source license.
const NAME: &str = "json_extract_all";
fn stringify_scalar(v: &Value) -> Option<String> {
    fn coerce_types_enforces_string_arity() {
        check_arity(NAME, args.args.len(), 1)?;
    }
}
    fn json_null_renders_as_literal_string_null() {
            vec![("tags{}".to_string(), "[a, b, c]".to_string())]
        Some(MapFieldNames {
    }
///    values that don't need exponent form: `3.14159`, `0.5`).
    }
        assert_eq!(
fn new_map_builder(capacity: usize) -> MapBuilder<StringBuilder, StringBuilder> {
            signature: Signature::user_defined(Volatility::Immutable),
    if let Some(f) = n.as_f64() {
            ]
}
                v.push(next);
                // those constants when unpacking entries.
/// JSON-number → Java-`String.valueOf` parity:
}
    use super::*;
            // Build a single-row Map array, then wrap as a Scalar(List(...))
                    None => b.values().append_null(),
        // cares that the result is the empty map (struct `{}`), which is the
    pub fn new() -> Self {
    fn duplicate_logical_keys_merge_into_bracketed_list() {
    List(Vec<Option<String>>),
            .coerce_types(&[DataType::Int64])
            vec![
            rendered(r#"{"user":{"name":"John"},"system":"linux"}"#).unwrap(),
            // identical rows. Build once, replay n times.
}
        )),
    fn malformed_json_returns_empty_map() {
                        assert_eq!(fields[1].name(), "value");
                    .map(|o| o.as_deref().unwrap_or("null"))
        // Legacy: `if (pathStack.isEmpty()) return null` on top-level scalar.
        }
                Field::new("key", DataType::Utf8, false),
            }
            Vec::<(String, String)>::new()
    fn coerce_types(&self, args: &[DataType]) -> Result<Vec<DataType>> {
/// `values` is `nullable=true` so JSON nulls can round-trip as Arrow nulls
/// Append one Map row: `None` → null map slot; `Some(entries)` → a map with
    match &parsed {
                        assert_eq!(fields[0].data_type(), &DataType::Utf8);
        );
    ctx.register_udf(ScalarUDF::from(JsonExtractAllUdf::new()));
                None => None,
            if !s.is_empty() && !s.ends_with(ARRAY_MARKER) {
                vec![variant.clone()],
            vec![("{}".to_string(), "[1, 2, 3]".to_string())]
            let result = match s {
    }
            for (key, child) in map.iter() {
        assert_eq!(
/// Order-preserving append-or-merge map keyed by stringified path. We use a
        }
 * SPDX-License-Identifier: Apache-2.0
            .contains("expected string"));
}
/// inside the map (they render to the literal string `"null"` here, but a
//! `json_extract_all(value)` — flatten a JSON object to a `Map<Utf8, Utf8>` with
            vec![("users{}.name".to_string(), "[John, Jane]".to_string())]
        // With serde_json we get all-or-nothing (no token-level partial
        assert!(rendered(r#""just a string""#).is_none());
            // passes a container by mistake doesn't silently lose data.
    }
    fn render(&self) -> Option<String> {
/// recurse element-by-element so every element shares the same parent path
            assert_eq!(
/// (see `JsonExtractAllFunctionImpl#getReturnTypeInference`); this is the
        assert_eq!(
}
        coerce_args(NAME, args, &[CoerceMode::Utf8])
    }
fn build_path(path: &[String]) -> String {
        } else {
        Ok(map_data_type())
fn map_data_type() -> DataType {
use datafusion::arrow::array::{ArrayRef, MapBuilder, MapFieldNames, StringBuilder};
                s.push('.');
        assert_eq!(
                        assert_eq!(fields[1].data_type(), &DataType::Utf8);
    fn return_type_is_map_utf8_utf8() {
/// land next to each other (`a{}{}` for arrays-of-arrays).
use datafusion::common::ScalarValue;
    DataType::Map(
//! dot-separated paths as keys (parity with legacy
    }
    #[test]
        );
            ])),
    }
    Some(out)
    }
            rendered(r#"{"user":{"name":"#).unwrap(),
/// nullable}). The legacy Calcite path returns `MAP<VARCHAR, VARCHAR NULLABLE>`
    fn extend(&mut self, next: Option<String>) {
            rendered(r#"[{"age":1},{"age":2}]"#).unwrap(),
    #[test]
        for i in 0..n {
    Ok(())
                Some(format!("[{}]", parts.join(", ")))
        Value::Null => None,
                        assert!(fields[1].is_nullable());
        );
            entries
}
        // `a.b` after the nested-object path produces the same key, so the
        Value::Number(n) => Some(stringify_number(n)),
}
    }
fn walk(v: &Value, path: &mut Vec<String>, out: &mut OrderedEntries) {
impl JsonExtractAllUdf {
        })
        assert!(rendered("true").is_none());
        None => b.append(false)?,
            rendered(r#"{"name":"John","age":30}"#).unwrap(),
        let m = rendered(r#"{"n":30,"b":true,"x":null}"#).unwrap();
/// future caller might want to distinguish; keeping the slot nullable costs
                let parts: Vec<&str> = items
/// scalar-or-list polymorphism — so duplicate-key insertion can promote to a
        None => return Some(Vec::new()),
    #[test]
 * this file be licensed under the Apache-2.0 license or a
                ("b".to_string(), "true".to_string()),
///    `9.223372036854776E18` pattern; minor lowercase-`e` divergence is the
            entry: "entries".to_string(),
    fn array_of_primitives_suffixes_with_curly_marker() {
            ]
            b.append(true)?;
        Value::Bool(b) => Some(b.to_string()),
/// nothing).
            let value = stringify_scalar(leaf);
        if let ColumnarValue::Scalar(sv) = &args.args[0] {
        assert_eq!(
    #[test]
        // cases (`testInvalidJsonReturnResults`) are not part of the IT
            rendered(r#"{"a":{"b":1},"a.b":2}"#).unwrap(),
/// arrays produce no entries; non-empty arrays append `{}` to the path and
                "CoerceMode::Utf8 should pass {variant:?} through unchanged"
        out.push((key, Slot::Single(value)));
        );
                .collect()
    if let Some(u) = n.as_u64() {
}
            m,
                udf.coerce_types(&[variant.clone()]).unwrap(),
        match self {
    #[test]
                }
        }
}
                *self = Slot::List(v);
            );
                // Field names match Arrow Java's `MapVector.KEY_NAME` /
                    }
                Field::new("value", DataType::Utf8, true),
    #[test]
///    round-trip representation (matches Java's `Double.toString` for finite
fn scalar_str(sv: &ScalarValue) -> Option<&str> {
        );
        assert!(rendered("").is_none());
/// list without rewriting the whole value.
            Slot::List(v) => v.push(next),
            s.push_str(segment);
    /// `List.toString()` shape.
}
    #[test]
        );
            }
    }
/// whitespace input and for a top-level non-container value (string, number,
            }
        // IT-level `testSpathAutoExtractMalformedJson` only asserts on `{}`.
    }
            vec![("{}.age".to_string(), "[1, 2]".to_string())]
    }
///    only known formatting difference, not exercised by spath ITs).
                    other => panic!("expected Struct inside Map, got {other:?}"),
        assert!(udf.coerce_types(&[]).is_err());
        match dt {
    }
fn insert(out: &mut OrderedEntries, key: String, value: Option<String>) {
        assert_eq!(
        assert!(rendered("null").is_none());
            key: "key".to_string(),
/// merge is dominated by the JSON-walk cost on every realistic input.
    )
    }
///  - Integers above i64 → promoted to f64 and rendered in Rust's shortest
                .map(|(k, v)| (k, v.render().unwrap_or_else(|| "null".to_string())))
    #[test]
//! `try { … } catch (IOException) { /* swallow */ }` flow at
#[cfg(test)]
                ("n".to_string(), "30".to_string()),
        Value::String(s) => Some(s.clone()),
            vec![
    }
        for variant in [DataType::Utf8, DataType::LargeUtf8, DataType::Utf8View] {
        if segment == ARRAY_MARKER {
            rendered(r#"{"tags":["a","b","c"]}"#).unwrap(),
use std::sync::Arc;
    #[test]
                walk(child, path, out);
                b.keys().append_value(k);
/// (which is what produces the duplicate-key merge behaviour).
                        assert_eq!(fields.len(), 2);
    fn top_level_array_of_primitives_uses_curly_marker_as_root() {
    fn invoke_with_args(&self, args: ScalarFunctionArgs) -> Result<ColumnarValue> {
        // duplicate logical keys, so the merge produces `[1, 2]`.
    #[test]
        return f.to_string();
        assert!(rendered("42").is_none());
            for element in arr.iter() {
    fn return_type(&self, _args: &[DataType]) -> Result<DataType> {
    }
#[derive(Debug, PartialEq, Eq, Hash)]
mod tests {
    fn signature(&self) -> &Signature {
    }
    #[test]
/// Arrow `Map<Utf8, Utf8>` (Map → Struct{keys: Utf8 non-null, values: Utf8
        ScalarValue::Utf8(s) | ScalarValue::LargeUtf8(s) | ScalarValue::Utf8View(s) => s.as_deref(),
                let mut v = Vec::with_capacity(2);
        // values merge into a list. With `preserve_order` enabled,
            rendered(r#"{"users":[{"name":"John"},{"name":"Jane"}]}"#).unwrap(),
fn append_row(
    walk(&parsed, &mut Vec::new(), &mut out);
        // serde_json's `Value::Object` preserves the input order across
    fn null_in_array_renders_inline_with_other_elements() {
impl Slot {
        assert_eq!(
    }
        );
}
    }
    }
    match entries {
            Slot::List(items) => {
            return Ok(ColumnarValue::Array(Arc::new(b.finish()) as ArrayRef));
                walk(element, path, out);
        existing.extend(value);
    fn top_level_scalar_returns_none() {
        Value::Object(_) | Value::Array(_) => {}
                    .iter()
    }
        }
        _ => return None, // top-level scalar — legacy returns NULL.
                .into_iter()
/// duplicate-key insertion is rare (only when a JSON document has a literal
        return i.to_string();
) -> Result<()> {
    }
        // observable behaviour we deliver here. Unit-test-level partial-parse
        }),
                s.push('.');
            vec![("a.b".to_string(), "[1, 2]".to_string())]
                    DataType::Struct(fields) => {
                    Some(rendered) => b.values().append_value(&rendered),
//! Java-`List.toString()` rendering (`[a, b, c]`); JSON nulls render as the
        // Legacy: catches Jackson IOException and returns whatever was parsed.
            };
        Value::Array(_) | Value::Object(_) => {
/// the (already-stringified) entries. Insertion order is preserved by
            Vec::<(String, String)>::new()
use super::{coerce_args, CoerceMode};
/// DFS walk that mirrors the Jackson stream-walk in the legacy impl.
        // surface.
