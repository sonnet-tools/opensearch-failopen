        assert_eq!(
                rest = &rest[end + 1..];
            DataType::Utf8View => Ok(Self::Utf8View(
        let mut doc = v(r#"{"xs":[{"k":1}]}"#);
                    out.push(']');
#[cfg(test)]
    let mut rest = input;
            parse_ppl_segments("a.b{0}.c{}").unwrap(),
    }
        Segment::Index(i) => {
    pub(crate) fn cell(&self, i: usize) -> Option<&str> {
            }
    Ok(out)
        );
                }
use datafusion::logical_expr::ColumnarValue;
            ("a.b", "$.a.b"),
        let mut doc = v(r#"{"xs":[{"k":1,"v":10},{"k":2,"v":20}]}"#);
/// for non-scalars, non-string scalars, and `NULL` scalars. Shared by every
                Segment::Field("a"),
        let segs = parse_ppl_segments("f2.nope").unwrap();
                if cut > 0 {
                let end = rest.find('}').ok_or_else(|| {
    pub(crate) fn from_array(arr: &'a ArrayRef) -> Result<Self> {
/// short-circuits that branch.
    fn parse_handles_malformed_and_valid() {
                    out.push(Segment::Wildcard);
pub(crate) fn check_arity(udf: &str, observed: usize, expected: usize) -> Result<()> {
 * this file be licensed under the Apache-2.0 license or a
            r#"{"f1":"abc","f2":{"f3":"a"}}"#
                }
    Ok(out)
/// Tokenise a PPL path into `Segment`s without allocating for field names.
                let end = rest.find('}').ok_or_else(|| {
        serde_json::from_str(s).unwrap()
        );
    }
            }
            }
                    walk_mut_inner(child, tail, apply);
            )),
    #[test]
/// "malformed → NULL" convention across all json_* UDFs (see
/// (`$.a.b[0].c[*]`). Empty input → `"$"` (document root), matching the
}
        }
}
                } else {
                let idx = rest[1..end].trim();
        }
    Index(usize),
    #[test]
                    ))
    }
    fn walk_mut_deletes_flat_key() {
        }
                    out.push('[');
                        ))
                    .expect("Utf8View downcast"),
                out.push('.');
                arr.as_any()
/// legacy contract. Returns a planning error for an unmatched `{`.
pub(crate) enum Segment<'a> {
    if tail.is_empty() {
                    let parsed = idx.parse::<usize>().map_err(|_| {
            ("", "$"),
 * The OpenSearch Contributors require contributions made to
        assert!(convert_ppl_path("a{0")
}
    fn v(s: &str) -> Value {
                    out.push_str(idx);
            )),
        let segs = parse_ppl_segments("xs{}.v").unwrap();
    /// Returns `Some(value)` for non-null rows, `None` for nulls.
    Utf8(&'a StringArray),
            r#"{"xs":[{"k":1},{"k":2}]}"#
    out.push_str("$.");
/// Drive `apply` against every terminal `(parent, final_segment)` reached by
        return Ok("$".into());
            }
        walk_mut(&mut doc, &segs, |parent, seg| {
    }
        }
pub(crate) enum StringArrayView<'a> {
            }
}
/*
    while !rest.is_empty() {
            serde_json::to_string(&doc).unwrap(),
        });
                    out.push_str("[*]");
        // Parent is `node`; the final segment names the slot to mutate.
/// `segments` inside `root`. Missing intermediate keys / out-of-range indices
            ("a{}", "$.a[*]"),
        Segment::Wildcard => {
}
            ScalarValue::Utf8(s) | ScalarValue::LargeUtf8(s) | ScalarValue::Utf8View(s),
            }
        assert!(parse("{not json").is_none());
 * SPDX-License-Identifier: Apache-2.0
            b'{' => {
            Self::Utf8(a) => (!a.is_null(i)).then(|| a.value(i)),
        match self {
            assert_eq!(convert_ppl_path(input).unwrap(), want, "input={input}");
                if let Some(child) = map.get_mut(*name) {
where
/// One tokenised step of a PPL path. Mirrors the three cases `convert_ppl_path`
                map.shift_remove(*name);
        assert_eq!(
            b'{' => {
            }
/// `json_udf_legacy_semantics.md`).
                })?;
            DataType::Utf8 => Ok(Self::Utf8(
                    .downcast_ref::<StringArray>()
    }
/// handles: bare identifier (field), `{n}` (array index), `{}` (array wildcard).
pub(crate) fn parse_ppl_segments(input: &str) -> Result<Vec<Segment<'_>>> {
                let cut = rest.find(['.', '{']).unwrap_or(rest.len());
            if let (Value::Object(map), Segment::Field(name)) = (parent, seg) {
                }
                    walk_mut_inner(child, tail, apply);
            DataType::LargeUtf8 => Ok(Self::LargeUtf8(
                    .expect("LargeUtf8 downcast"),
        assert!(parse_ppl_segments("a{0").is_err());
        assert_eq!(serde_json::to_string(&doc).unwrap(), r#"{"a":1,"c":3}"#);
    }
/// Standard arity guard.
    Wildcard,
            Self::Utf8View(a) => (!a.is_null(i)).then(|| a.value(i)),
        DataFusionError::Plan(format!(
    fn ppl_path_mirrors_legacy_convert_to_jsonpath() {
        ] {
            _ => {
        walk_mut(&mut doc, &segs, |parent, seg| {
                out.push_str(&rest[..cut]);
        match rest.as_bytes()[0] {
//! strings and typed segment vectors), a segment-based mutation walker used by
/// Returns a planning error for unmatched `{` or a non-numeric index — the
//! the write UDFs, and a malformed-to-`None` JSON parser.
        return;
                    out.push(Segment::Index(parsed));
                            "Non-numeric array index '{idx}' in JSON path: {input}"
{
}
                }
                Segment::Field("c"),
            )),
use datafusion::common::ScalarValue;
    }
    }
            if let (Value::Object(map), Segment::Field(name)) = (parent, seg) {
    #[test]
                let idx = rest[1..end].trim();
/// `Utf8View`). Dispatch happens once in [`Self::from_array`]; per-row access
            if let Value::Array(arr) = node {
use serde_json::Value;
    fn parse_ppl_segments_tokenises_field_index_and_wildcard() {
/// Extract `&str` from a string-typed `ColumnarValue::Scalar`. Returns `None`
                rest = &rest[cut..];
            serde_json::to_string(&doc).unwrap(),
                    .downcast_ref::<LargeStringArray>()
    }
            }
        _ => None,
            }
        assert_eq!(parse_ppl_segments("").unwrap(), Vec::<Segment>::new());
    fn arity_guards() {
        assert!(parse_ppl_segments("a{x}").is_err());
                    .expect("Utf8 downcast"),
use datafusion::arrow::array::{Array, ArrayRef, LargeStringArray, StringArray, StringViewArray};
//! Shared helpers for the PPL `json_*` UDFs: PPL-path parsing (to both JSONPath
    F: FnMut(&mut Value, &Segment<'_>),
            other => Err(DataFusionError::Internal(format!(
/// json-family UDF's all-scalar fast path.
        assert_eq!(parse_ppl_segments("a").unwrap(), vec![Segment::Field("a")]);
                for child in arr.iter_mut() {
        walk_mut(&mut doc, &segs, |parent, seg| {
/// are silently skipped (matching Jayway's `SUPPRESS_EXCEPTIONS` behaviour
            ("a{0}", "$.a[0]"),
            Self::LargeUtf8(a) => (!a.is_null(i)).then(|| a.value(i)),
        let mut doc = v(r#"{"a":1,"b":2,"c":3}"#);
                })?;
                if idx.is_empty() {
    }
        });
        assert_eq!(
    if input.is_empty() {
    }
    match head {
            ]
    }
pub(crate) fn convert_ppl_path(input: &str) -> Result<String> {
                arr.as_any()
    #[test]
        assert!(parse("[1,2,3]").is_some());
    LargeUtf8(&'a LargeStringArray),
                }
    #[test]
pub(crate) fn walk_mut<F>(root: &mut Value, segments: &[Segment<'_>], mut apply: F)
            }
    }
}
            b'.' => {
                map.shift_remove(*name);
    })
    use super::*;
            }
/// View over an Arrow string array of any logical width (`Utf8`, `LargeUtf8`,
    }
        assert!(check_arity("f", 2, 1).is_err());
}
                if let Some(child) = arr.get_mut(*i) {
        Segment::Field(name) => {
/// same inputs `convert_ppl_path` rejects.
            _ => {
///
        walk_mut(&mut doc, &segs, |parent, seg| {
                Segment::Wildcard,
                Segment::Field("b"),
        return;
    let mut rest = input;
        ) => s.as_deref(),
        );
        let segs = parse_ppl_segments("b").unwrap();
        let mut doc = v(r#"{"f1":"abc","f2":{"f3":"a"}}"#);
    let mut out = Vec::new();
    let mut out = String::with_capacity(input.len() + 2);
        assert!(check_arity("f", 1, 1).is_ok());
            if let Value::Array(arr) = node {
                rest = &rest[cut..];
                    DataFusionError::Plan(format!("Unmatched '{{' in JSON path: {input}"))
                    walk_mut_inner(child, tail, apply);
    match v {
        }
            ("a", "$.a"),
    fn walk_mut_handles_missing_path_as_noop() {
        match rest.as_bytes()[0] {
use datafusion::error::{DataFusionError, Result};
    fn walk_mut_wildcard_fans_out_across_array() {
    Utf8View(&'a StringViewArray),
 * compatible open source license.
{
where
    }
use datafusion::arrow::datatypes::DataType;
                let cut = rest.find(['.', '{']).unwrap_or(rest.len());
                rest = &rest[1..];
                "expected string array (Utf8/LargeUtf8/Utf8View), got {other:?}"
        }
/// that legacy mutation UDFs rely on). Wildcard segments fan out across every
                        "Unmatched '{{' in JSON path: {input}"
                    out.push(Segment::Field(&rest[..cut]));
        }
            if let Value::Object(map) = node {
                        DataFusionError::Plan(format!(
        }
                if idx.is_empty() {
    serde_json::from_str(s).ok()
            vec![
/// Empty `segments` is a no-op: PPL mutation UDFs reject a root-only path at
        for (input, want) in [
    if segments.is_empty() {
                rest = &rest[end + 1..];
pub(crate) fn parse(s: &str) -> Option<Value> {
            .contains("Unmatched"));
            ("a{0}.b{}.c", "$.a[0].b[*].c"),
            if let (Value::Object(map), Segment::Field(name)) = (parent, seg) {
    F: FnMut(&mut Value, &Segment<'_>),
                    })?;
    (observed == expected).then_some(()).ok_or_else(|| {
mod tests {
impl<'a> StringArrayView<'a> {
            ("a{  2  }", "$.a[2]"),
        ColumnarValue::Scalar(
                    .downcast_ref::<StringViewArray>()
/// via [`Self::cell`] is a small enum match.
}
    #[inline]
pub(crate) fn scalar_utf8(v: &ColumnarValue) -> Option<&str> {
/// Convert a PPL-style path (`a.b{0}.c{}`) to a JSONPath expression
        apply(node, head);
#[derive(Debug, Clone, PartialEq, Eq)]
    #[test]
    while !rest.is_empty() {
    }
fn walk_mut_inner<F>(node: &mut Value, segments: &[Segment<'_>], apply: &mut F)
            ))),
    walk_mut_inner(root, segments, &mut apply);
                    datafusion::error::DataFusionError::Plan(format!(
        });
    let (head, tail) = segments.split_first().expect("non-empty checked by caller");
            "{udf} expects {expected} arguments, got {observed}"
    }
}
        ))
                Segment::Index(0),
            b'.' => rest = &rest[1..],
}
            .unwrap_err()
/// Parse a JSON string; returns `None` on malformed input. Matches the
 *
                }
        assert_eq!(serde_json::to_string(&doc).unwrap(), r#"{"xs":[{"k":1}]}"#);
/// element of the current array; descending through a non-container
        match arr.data_type() {
            .to_string()
/// the call site before reaching the walker.
                arr.as_any()
                } else {
    #[test]
            if let (Value::Object(map), Segment::Field(name)) = (parent, seg) {
    }
            }
    Field(&'a str),
        let segs = parse_ppl_segments("xs{5}.k").unwrap();
                map.shift_remove(*name);
                map.shift_remove(*name);
    #[test]
        });
    fn walk_mut_index_out_of_range_is_noop() {
 */
