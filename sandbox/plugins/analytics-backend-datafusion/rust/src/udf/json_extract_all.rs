        Self::new()
/// streaming-parser order in the legacy impl.
    s
//! Java-`List.toString()` rendering (`[a, b, c]`); JSON nulls render as the
                path.push(key.clone());
    Some(out)
}
///    `9.223372036854776E18` pattern; minor lowercase-`e` divergence is the
    MapBuilder::with_capacity(
}
                        assert_eq!(fields[1].name(), "value");
    #[test]
        }
            // by returning Array. DataFusion broadcasts a 1-row Array vs.
        capacity,
            vec![
}
            b.append(true)?;
        Value::Bool(b) => Some(b.to_string()),
};
}
    ColumnarValue, ScalarFunctionArgs, ScalarUDF, ScalarUDFImpl, Signature, Volatility,
            entries
    }
    };
    /// A single value. `None` here means a JSON null was inserted; it renders
                path.pop();
        Some(map) => {
    #[test]
        existing.extend(value);
/// merge is dominated by the JSON-walk cost on every realistic input.
}
            rendered(r#"{"users":[{"name":"John"},{"name":"Jane"}]}"#).unwrap(),
    }
//! {@code JsonExtractAllFunctionImpl#parseJson}).
            }
        Value::Object(map) => {
    Ok(())
            .contains("expected string"));
    fn empty_object_returns_empty_map() {
        let mut b = new_map_builder(n);
        );
        // cares that the result is the empty map (struct `{}`), which is the
    }
            // Caller shouldn't reach this — containers are walked recursively
    }
                // Field names match Arrow Java's `MapVector.KEY_NAME` /
                // `VALUE_NAME` so the SQL-plugin response marshaller can use
/// Append one Map row: `None` → null map slot; `Some(entries)` → a map with
        // With serde_json we get all-or-nothing (no token-level partial
        Value::Number(n) => Some(stringify_number(n)),
            rendered(r#"{"name":"John","age":30}"#).unwrap(),
    fn json_null_renders_as_literal_string_null() {
        // Legacy: `if (pathStack.isEmpty()) return null` on top-level scalar.
/// Public entry — returns `Some(map)` when the input parses (possibly to an
    }
            vec![
    match entries {
        check_arity(NAME, args.args.len(), 1)?;
        assert!(udf
                vec![variant.clone()],
fn map_data_type() -> DataType {
        extract_all(s).map(|entries| {
/// substrait-friendly Arrow shape that decodes to the same logical type.
        let udf = JsonExtractAllUdf::new();
}
enum Slot {
                s.push('.');
///  - Integers in i64 range → `123`, `9223372036854775807`
    n.to_string()
    if let Some(u) = n.as_u64() {
        match dt {
            .unwrap_err()
            rendered(r#"{"a":{"b":1},"a.b":2}"#).unwrap(),
            let s = scalar_str(sv);
        Self {
                        assert_eq!(fields.len(), 2);
    }
                .into_iter()
        Value::Array(_) | Value::Object(_) => {
        None => b.append(false)?,
fn append_row(
        );
    }
    List(Vec<Option<String>>),
/// `Vec<(String, Slot)>` rather than pulling `indexmap` into the dep tree —
        assert_eq!(
                    other => panic!("expected Struct inside Map, got {other:?}"),
        // Malformed → legacy swallows the error and returns the partial map.
//! arrays append a `{}` segment (`tags{}`); duplicate logical keys merge into a
                    None => b.values().append_null(),
        assert_eq!(
                v.push(next);
            // passes a container by mistake doesn't silently lose data.
        assert!(rendered("42").is_none());
/// the (already-stringified) entries. Insertion order is preserved by
#[derive(Debug, PartialEq, Eq, Hash)]
        );
                "CoerceMode::Utf8 should pass {variant:?} through unchanged"
    }
                b.keys().append_value(k);
/// One logical value at a path. Mirrors the legacy `Object` slot —
 * The OpenSearch Contributors require contributions made to
            ]
        }
                    .collect();
                .collect()
            // promoting to a real Scalar for Map; the cleanest fast-path here
}
        );
        // `{"a":{"b":1}, "a.b": 2}` — Jackson's parser emits the outer key
            DataType::Map(field, sorted) => {
    /// `List.toString()` shape.
        out.push((key, Slot::Single(value)));
            }
    }
            let result = match s {
            rendered(r#"[1,2,3]"#).unwrap(),
                match v.render() {
        );
    fn render(&self) -> Option<String> {
            };
use serde_json::Value;
 * this file be licensed under the Apache-2.0 license or a
        _ => return None, // top-level scalar — legacy returns NULL.
    fn name(&self) -> &str {
            .to_string()
//! `JsonExtractAllFunctionImpl`). Objects flatten to dotted keys (`user.name`);
                        assert!(fields[1].is_nullable());
                ("age".to_string(), "30".to_string()),
        } else {
    }
        // duplicate logical keys, so the merge produces `[1, 2]`.
    #[test]
                Some(s) => extract_all(s),
fn build_path(path: &[String]) -> String {
//! dot-separated paths as keys (parity with legacy
        }
        assert_eq!(
    fn return_type_is_map_utf8_utf8() {
/// boundary — see `Slot::render`).
            rendered(r#"[{"a":null},{"a":1}]"#).unwrap(),
                ("name".to_string(), "John".to_string()),
fn new_map_builder(capacity: usize) -> MapBuilder<StringBuilder, StringBuilder> {
    }
            path.pop();
 */
    }
///    values that don't need exponent form: `3.14159`, `0.5`).
        assert_eq!(
    /// as the literal string `"null"` to match Java's `String.valueOf(null)`.
                Some(format!("[{}]", parts.join(", ")))
    fn malformed_json_returns_empty_map() {
fn walk(v: &Value, path: &mut Vec<String>, out: &mut OrderedEntries) {
        }),
        })
            signature: Signature::user_defined(Volatility::Immutable),
                        assert_eq!(fields[0].data_type(), &DataType::Utf8);
    #[test]
        // `a.b` after the nested-object path produces the same key, so the
mod tests {
    }
impl ScalarUDFImpl for JsonExtractAllUdf {
        assert!(rendered("null").is_none());
    fn return_type(&self, _args: &[DataType]) -> Result<DataType> {
    /// `[v1, v2, ..., vn]` with `null` for null elements — Java's
#[cfg(test)]
                v.push(first.take());
            vec![("{}.a".to_string(), "[null, 1]".to_string())]
                ("n".to_string(), "30".to_string()),
use super::json_common::{check_arity, parse, StringArrayView};
        assert!(rendered("true").is_none());
        StringBuilder::new(),
        None => return Some(Vec::new()),
            entry: "entries".to_string(),
    #[test]
            s.push_str(ARRAY_MARKER);
    }
    fn empty_array_yields_no_entry() {
            assert_eq!(
        // string `"null"` (legacy `String.valueOf((Object) null) == "null"`).
}
            value: "value".to_string(),
    }
        Value::String(s) => Some(s.clone()),
        let dt = JsonExtractAllUdf::new()
        coerce_args(NAME, args, &[CoerceMode::Utf8])
fn stringify_number(n: &serde_json::Number) -> String {
                    }
        }
        // Legacy: catches Jackson IOException and returns whatever was parsed.
        return f.to_string();
}
    if let Some((_, existing)) = out.iter_mut().find(|(k, _)| *k == key) {
            }
                        assert!(!fields[0].is_nullable());
use std::sync::Arc;
                match field.data_type() {
    if let Some(i) = n.as_i64() {
            return Ok(ColumnarValue::Array(Arc::new(b.finish()) as ArrayRef));
    match &parsed {
        assert!(udf.coerce_types(&[]).is_err());
/*
    }
            } else if s.ends_with(ARRAY_MARKER) {
            };
pub struct JsonExtractAllUdf {
                .map(|(k, v)| (k, v.render().unwrap_or_else(|| "null".to_string())))
    #[test]
/// inside the map (they render to the literal string `"null"` here, but a
            false,
            // identical rows. Build once, replay n times.
                *self = Slot::List(v);
            rendered(r#"{"tags":["a","b","c"]}"#).unwrap(),
/// JSON-number → Java-`String.valueOf` parity:
            vec![("a.b".to_string(), "[1, 2]".to_string())]
        )),
 * SPDX-License-Identifier: Apache-2.0
}
        let arr = args.args[0].clone().into_array(n)?;
        ScalarValue::Utf8(s) | ScalarValue::LargeUtf8(s) | ScalarValue::Utf8View(s) => s.as_deref(),
            other => panic!("expected Map, got {other:?}"),
                ("system".to_string(), "linux".to_string()),
                None => None,
        // IT-level `testSpathAutoExtractMalformedJson` only asserts on `{}`.
                assert!(!sorted);
    )
/// does. Returns `None` for JSON null (rendered as `"null"` at the outer
fn extract_all(s: &str) -> Option<OrderedEntries> {
                }
        Some(v) => v,
    fn signature(&self) -> &Signature {
        assert_eq!(rendered(r#"{}"#).unwrap(), Vec::<(String, String)>::new());
        }
    walk(&parsed, &mut Vec::new(), &mut out);
    fn null_and_empty_input_returns_none() {
    fn extend(&mut self, next: Option<String>) {
    }
                append_row(&mut b, result.as_ref())?;
 *
    // form serde_json holds internally.
        assert!(rendered("   ").is_none());
/// Join `path` into a dotted/`{}`-terminated string. Array markers `{}` carry
    fn top_level_array_of_primitives_uses_curly_marker_as_root() {
    fn top_level_scalar_returns_none() {
        assert!(rendered("").is_none());
///  - Integers above i64 → promoted to f64 and rendered in Rust's shortest
    b: &mut MapBuilder<StringBuilder, StringBuilder>,
        Value::Array(arr) => {
/// DFS walk that mirrors the Jackson stream-walk in the legacy impl.
        // `{"x": null}` → key `x` present, value rendered as the literal
    match sv {
const NAME: &str = "json_extract_all";
                ("user.name".to_string(), "John".to_string()),
    }
                walk(child, path, out);
    #[test]
            vec![("tags{}".to_string(), "[a, b, c]".to_string())]
            rendered(r#"{"empty":[]}"#).unwrap(),
/// arrays produce no entries; non-empty arrays append `{}` to the path and
            vec![("{}.age".to_string(), "[1, 2]".to_string())]
        assert_eq!(
            s.push_str(segment);
            }
            for element in arr.iter() {
        assert_eq!(
    fn array_of_primitives_suffixes_with_curly_marker() {
    fn default() -> Self {
        }
    }
        return None;
use datafusion::error::Result;
        if segment == ARRAY_MARKER {
        }
    match v {
        );
        Value::Null => None,
        // observable behaviour we deliver here. Unit-test-level partial-parse
//! `try { … } catch (IOException) { /* swallow */ }` flow at
/// `IndexMap` so the wire-level JSON object key order matches Jackson's
    }
        }
/// `values` is `nullable=true` so JSON nulls can round-trip as Arrow nulls
                s.push('.');
            // by `walk`. Defensive: serialize as JSON so a future caller that
            Vec::<(String, String)>::new()
    } else {
) -> Result<()> {
        assert_eq!(
        return i.to_string();
                        assert_eq!(fields[1].data_type(), &DataType::Utf8);
impl Slot {
            vec![
/// bool, null). Matches the legacy contract exactly.
//! / top-level number → NULL map. Malformed JSON → empty map (we silently keep
    let mut out: OrderedEntries = Vec::new();
    #[test]
            append_row(&mut b, row_result.as_ref())?;
    }
        assert_eq!(
#[derive(Debug)]
        assert_eq!(
        );
            .return_type(&[DataType::Utf8])
    }
impl JsonExtractAllUdf {
            DataType::Struct(Fields::from(vec![
    let parsed = match parse(s) {
            .coerce_types(&[DataType::Int64])
    fn invoke_with_args(&self, args: ScalarFunctionArgs) -> Result<ColumnarValue> {
/// Arrow `Map<Utf8, Utf8>` (Map → Struct{keys: Utf8 non-null, values: Utf8
    if s.trim().is_empty() {
}
    pub fn new() -> Self {
use datafusion::execution::context::SessionContext;
            // is still to drop into the columnar builder for n rows and emit
}
    fn duplicate_logical_keys_merge_into_bracketed_list() {
    }
    // Should be unreachable for finite JSON; fall back to the raw textual
/// whitespace input and for a top-level non-container value (string, number,
        }
fn insert(out: &mut OrderedEntries, key: String, value: Option<String>) {
        );
                ("x".to_string(), "null".to_string()),
    fn null_in_array_renders_inline_with_other_elements() {
const ARRAY_MARKER: &str = "{}";
            for (k, v) in map.iter() {
    #[test]
//! whatever was parsed before the syntax error, matching the legacy
        false,
type OrderedEntries = Vec<(String, Slot)>;
}
    let mut s = String::with_capacity(path.iter().map(|p| p.len() + 1).sum::<usize>());
fn stringify_scalar(v: &Value) -> Option<String> {
            insert(out, key, value);
        for variant in [DataType::Utf8, DataType::LargeUtf8, DataType::Utf8View] {
                udf.coerce_types(&[variant.clone()]).unwrap(),
 * compatible open source license.
    }
    }
    fn top_level_array_of_objects_roots_at_curly_marker() {
            }
///    round-trip form (matches `Double.toString` for the common
    }
            Slot::Single(first) => {
                None => None,
            Slot::List(v) => v.push(next),
            "entries",
    fn rendered(s: &str) -> Option<Vec<(String, String)>> {
                Field::new("key", DataType::Utf8, false),
        }
        );
            if !s.is_empty() && !s.ends_with(ARRAY_MARKER) {
    }
    fn array_of_objects_propagates_marker_into_children() {
    use super::*;
/// scalar-or-list polymorphism — so duplicate-key insertion can promote to a
/// (which is what produces the duplicate-key merge behaviour).
    }
}
pub fn register_all(ctx: &SessionContext) {
    }
        let m = rendered(r#"{"n":30,"b":true,"x":null}"#).unwrap();
                    DataType::Struct(fields) => {
        match self {
/// recurse element-by-element so every element shares the same parent path
/// land next to each other (`a{}{}` for arrays-of-arrays).
            vec![("users{}.name".to_string(), "[John, Jane]".to_string())]
        Some(MapFieldNames {
//! `json_extract_all(value)` — flatten a JSON object to a `Map<Utf8, Utf8>` with
    }
    }
/// list without rewriting the whole value.
    }
use datafusion::arrow::array::{ArrayRef, MapBuilder, MapFieldNames, StringBuilder};
    fn coerce_types_enforces_string_arity() {
    #[test]
    entries: Option<&OrderedEntries>,
impl Default for JsonExtractAllUdf {
                ("b".to_string(), "true".to_string()),
    #[test]
                let mut v = Vec::with_capacity(2);
            ]
        let n = args.number_rows;
/// empty map) and is rooted at a JSON object/array; `None` for null/empty/
    fn nested_object_flattens_to_dotted_path() {
            Some(v.to_string())
            vec![("{}".to_string(), "[1, 2, 3]".to_string())]
    }
use datafusion::logical_expr::{
            let row_result = match strings.cell(i) {
/// `path` is the current path stack (field names + array markers). Empty
    #[test]
            ])),
        assert_eq!(
            for _ in 0..n {
                // those constants when unpacking entries.
/// future caller might want to distinguish; keeping the slot nullable costs
/// (see `JsonExtractAllFunctionImpl#getReturnTypeInference`); this is the
/// duplicate-key insertion is rare (only when a JSON document has a literal
            key: "key".to_string(),
///    only known formatting difference, not exercised by spath ITs).
            Slot::List(items) => {
        for i in 0..n {
    for segment in path {
        leaf => {
        // state), but the IT-side `testSpathAutoExtractMalformedJson` only
        );
        Value::Object(_) | Value::Array(_) => {}
            let value = stringify_scalar(leaf);
            Slot::Single(None) => Some("null".to_string()),
        Ok(ColumnarValue::Array(Arc::new(b.finish()) as ArrayRef))
    ctx.register_udf(ScalarUDF::from(JsonExtractAllUdf::new()));
        }
            let key = build_path(path);
            m,
                    .map(|o| o.as_deref().unwrap_or("null"))
        // Scalar fast-path — every row in the batch evaluates to the same map.
        assert!(rendered(r#""just a string""#).is_none());
}
        // serde_json's `Value::Object` preserves the input order across
        return u.to_string();
    fn simple_object_dotted_keys_for_scalars() {
            for (key, child) in map.iter() {
        NAME
    fn coerce_types(&self, args: &[DataType]) -> Result<Vec<DataType>> {
            ]
///    round-trip representation (matches Java's `Double.toString` for finite
/// through unchanged; field-name separators are `.`. Adjacent `{}` segments
    }
                    .iter()
        Arc::new(Field::new(
/// Order-preserving append-or-merge map keyed by stringified path. We use a
    }
            Slot::Single(Some(s)) => Some(s.clone()),
    }
                Field::new("value", DataType::Utf8, true),
        }
            }
        // cases (`testInvalidJsonReturnResults`) are not part of the IT
/// Stringify a JSON scalar exactly the way the legacy `String.valueOf` chain
    DataType::Map(
                let parts: Vec<&str> = items
    if let Some(f) = n.as_f64() {
                Some(text) => extract_all(text),
            }
    match v {
        );
            }
            );
            .unwrap();
}
use datafusion::common::ScalarValue;
    #[test]
            rendered(r#"{"user":{"name":"#).unwrap(),
use super::{coerce_args, CoerceMode};
            let mut b = new_map_builder(n);
/// dotted key that collides with a nested-object path), so O(n) lookup on
    signature: Signature,
            path.push(ARRAY_MARKER.to_string());
        StringBuilder::new(),
    }
        _ => None,
                    Some(rendered) => b.values().append_value(&rendered),
fn scalar_str(sv: &ScalarValue) -> Option<&str> {
            Vec::<(String, String)>::new()
///  - Non-integers → Rust's default `{}` formatter, which is the shortest
//! literal string `"null"`. Null input / empty / whitespace / top-level scalar
        let strings = StringArrayView::from_array(&arr)?;
        // surface.
        }
        &self.signature
/// nullable}). The legacy Calcite path returns `MAP<VARCHAR, VARCHAR NULLABLE>`
        // serde_json is all-or-nothing, so we return the empty map — the
        match self {
            rendered(r#"{"user":{"name":"John"},"system":"linux"}"#).unwrap(),
            // Build a single-row Map array, then wrap as a Scalar(List(...))
                }
    )
use datafusion::arrow::datatypes::{DataType, Field, Fields};
                        assert_eq!(fields[0].name(), "key");
    #[test]
/// nothing).
    #[test]
    Single(Option<String>),
            rendered(r#"[{"age":1},{"age":2}]"#).unwrap(),
        // values merge into a list. With `preserve_order` enabled,
        if let ColumnarValue::Scalar(sv) = &args.args[0] {
}
                walk(element, path, out);
        assert_eq!(
    /// Two or more values at the same path. Renders as
    #[test]
}
        Ok(map_data_type())
