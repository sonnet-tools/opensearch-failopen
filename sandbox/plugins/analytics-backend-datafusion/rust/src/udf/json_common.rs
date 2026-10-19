            r#"{"f1":"abc","f2":{"f3":"a"}}"#
                if idx.is_empty() {
    F: FnMut(&mut Value, &Segment<'_>),
    let (head, tail) = segments.split_first().expect("non-empty checked by caller");
    Ok(out)
/// the call site before reaching the walker.
            ("a{}", "$.a[*]"),
        );
                    walk_mut_inner(child, tail, apply);
            ))),
 */
            if let (Value::Object(map), Segment::Field(name)) = (parent, seg) {
impl<'a> StringArrayView<'a> {
            )),
        );
        let mut doc = v(r#"{"f1":"abc","f2":{"f3":"a"}}"#);
            DataType::Utf8 => Ok(Self::Utf8(
    }
use serde_json::Value;
use datafusion::arrow::array::{Array, ArrayRef, LargeStringArray, StringArray, StringViewArray};
                    walk_mut_inner(child, tail, apply);
            ("a{0}", "$.a[0]"),
                    datafusion::error::DataFusionError::Plan(format!(
            .unwrap_err()
                    .expect("LargeUtf8 downcast"),
                        "Unmatched '{{' in JSON path: {input}"
    }
        Segment::Wildcard => {
        assert_eq!(parse_ppl_segments("").unwrap(), Vec::<Segment>::new());
    use super::*;
    if tail.is_empty() {
                "expected string array (Utf8/LargeUtf8/Utf8View), got {other:?}"
                    DataFusionError::Plan(format!("Unmatched '{{' in JSON path: {input}"))
            ("a.b", "$.a.b"),
        });
        }
    let mut rest = input;
                map.shift_remove(*name);
            }
                let idx = rest[1..end].trim();
        assert!(check_arity("f", 1, 1).is_ok());
            Self::Utf8View(a) => (!a.is_null(i)).then(|| a.value(i)),
pub(crate) fn convert_ppl_path(input: &str) -> Result<String> {
/// Tokenise a PPL path into `Segment`s without allocating for field names.
/// Convert a PPL-style path (`a.b{0}.c{}`) to a JSONPath expression
                map.shift_remove(*name);
            b'.' => {
    fn ppl_path_mirrors_legacy_convert_to_jsonpath() {
/// json-family UDF's all-scalar fast path.
            }
 * this file be licensed under the Apache-2.0 license or a
    if input.is_empty() {
/// for non-scalars, non-string scalars, and `NULL` scalars. Shared by every
        }
    #[test]
                }
    }
    #[test]
            }
                if idx.is_empty() {
                } else {
        let segs = parse_ppl_segments("f2.nope").unwrap();
        let segs = parse_ppl_segments("xs{5}.k").unwrap();
    match v {
use datafusion::error::{DataFusionError, Result};
        ) => s.as_deref(),
    #[inline]
/// Extract `&str` from a string-typed `ColumnarValue::Scalar`. Returns `None`
            Self::Utf8(a) => (!a.is_null(i)).then(|| a.value(i)),
}
}
                    out.push(Segment::Wildcard);
        walk_mut(&mut doc, &segs, |parent, seg| {
        ColumnarValue::Scalar(
//! the write UDFs, and a malformed-to-`None` JSON parser.
        return;
                        DataFusionError::Plan(format!(
            other => Err(DataFusionError::Internal(format!(
    /// Returns `Some(value)` for non-null rows, `None` for nulls.
                let end = rest.find('}').ok_or_else(|| {
                let end = rest.find('}').ok_or_else(|| {
    let mut out = Vec::new();
            if let Value::Array(arr) = node {
                rest = &rest[end + 1..];
        walk_mut(&mut doc, &segs, |parent, seg| {
            b'{' => {
                    out.push(Segment::Field(&rest[..cut]));
/// Standard arity guard.
            }
        return Ok("$".into());
                    out.push_str(idx);
    }
                        ))
    Utf8(&'a StringArray),
        }
            )),
            .to_string()
}
/// Returns a planning error for unmatched `{` or a non-numeric index — the
                }
                }
    match head {
            ("a{  2  }", "$.a[2]"),
        let mut doc = v(r#"{"xs":[{"k":1,"v":10},{"k":2,"v":20}]}"#);
                Segment::Field("c"),
}
#[cfg(test)]
        // Parent is `node`; the final segment names the slot to mutate.
 * compatible open source license.
/// element of the current array; descending through a non-container
        let segs = parse_ppl_segments("xs{}.v").unwrap();
            DataType::Utf8View => Ok(Self::Utf8View(
            serde_json::to_string(&doc).unwrap(),
        }
        walk_mut(&mut doc, &segs, |parent, seg| {
use datafusion::logical_expr::ColumnarValue;
                if let Some(child) = arr.get_mut(*i) {
                rest = &rest[end + 1..];
            )),
mod tests {
 *
        assert_eq!(
                    let parsed = idx.parse::<usize>().map_err(|_| {
use datafusion::common::ScalarValue;
/// same inputs `convert_ppl_path` rejects.
                    out.push(']');
    #[test]
/// One tokenised step of a PPL path. Mirrors the three cases `convert_ppl_path`
/// Parse a JSON string; returns `None` on malformed input. Matches the
                let idx = rest[1..end].trim();
where
        let mut doc = v(r#"{"xs":[{"k":1}]}"#);
                    out.push('[');
            if let Value::Array(arr) = node {
                let cut = rest.find(['.', '{']).unwrap_or(rest.len());
//! strings and typed segment vectors), a segment-based mutation walker used by
        Segment::Field(name) => {
    }
    Ok(out)
                Segment::Wildcard,
                rest = &rest[1..];
                arr.as_any()
            assert_eq!(convert_ppl_path(input).unwrap(), want, "input={input}");
        );
    })
}
/// short-circuits that branch.
                Segment::Field("a"),
        assert_eq!(
        walk_mut(&mut doc, &segs, |parent, seg| {
#[derive(Debug, Clone, PartialEq, Eq)]
            if let Value::Object(map) = node {
/// handles: bare identifier (field), `{n}` (array index), `{}` (array wildcard).
        assert_eq!(
                map.shift_remove(*name);
            ("a", "$.a"),
pub(crate) enum StringArrayView<'a> {
pub(crate) fn parse_ppl_segments(input: &str) -> Result<Vec<Segment<'_>>> {
            b'{' => {
/// (`$.a.b[0].c[*]`). Empty input → `"$"` (document root), matching the
pub(crate) fn walk_mut<F>(root: &mut Value, segments: &[Segment<'_>], mut apply: F)
        DataFusionError::Plan(format!(
        Segment::Index(i) => {
    }
                })?;
        return;
}
    }
        _ => None,
            ("", "$"),
    }
            .contains("Unmatched"));
                } else {
/// `json_udf_legacy_semantics.md`).
            b'.' => rest = &rest[1..],
    fn arity_guards() {
                out.push('.');
    #[test]
                let cut = rest.find(['.', '{']).unwrap_or(rest.len());
    Index(usize),
    }
pub(crate) fn scalar_utf8(v: &ColumnarValue) -> Option<&str> {
    F: FnMut(&mut Value, &Segment<'_>),
            _ => {
 * SPDX-License-Identifier: Apache-2.0
        assert!(parse("[1,2,3]").is_some());
        assert!(convert_ppl_path("a{0")
        assert!(parse_ppl_segments("a{x}").is_err());
                out.push_str(&rest[..cut]);
                    out.push_str("[*]");
        }
/// View over an Arrow string array of any logical width (`Utf8`, `LargeUtf8`,
            DataType::LargeUtf8 => Ok(Self::LargeUtf8(
            ]
                arr.as_any()
use datafusion::arrow::datatypes::DataType;
    (observed == expected).then_some(()).ok_or_else(|| {
        serde_json::from_str(s).unwrap()
                }
        apply(node, head);
    while !rest.is_empty() {
        ] {
        let mut doc = v(r#"{"a":1,"b":2,"c":3}"#);
        });
            parse_ppl_segments("a.b{0}.c{}").unwrap(),
    }
            }
                rest = &rest[cut..];
        assert!(parse("{not json").is_none());
            r#"{"xs":[{"k":1},{"k":2}]}"#
        });
                Segment::Index(0),
                    walk_mut_inner(child, tail, apply);
        });
}
    }
/// legacy contract. Returns a planning error for an unmatched `{`.
    LargeUtf8(&'a LargeStringArray),
    out.push_str("$.");
    pub(crate) fn from_array(arr: &'a ArrayRef) -> Result<Self> {
    fn parse_handles_malformed_and_valid() {
    walk_mut_inner(root, segments, &mut apply);
        }
        for (input, want) in [
                if let Some(child) = map.get_mut(*name) {
fn walk_mut_inner<F>(node: &mut Value, segments: &[Segment<'_>], apply: &mut F)
    fn walk_mut_index_out_of_range_is_noop() {
    }
                    ))
    let mut rest = input;
pub(crate) enum Segment<'a> {
            }
 * The OpenSearch Contributors require contributions made to
                if cut > 0 {
            "{udf} expects {expected} arguments, got {observed}"
    let mut out = String::with_capacity(input.len() + 2);
where
pub(crate) fn check_arity(udf: &str, observed: usize, expected: usize) -> Result<()> {
        ))
            if let (Value::Object(map), Segment::Field(name)) = (parent, seg) {
    }
            }
        assert_eq!(serde_json::to_string(&doc).unwrap(), r#"{"a":1,"c":3}"#);
/// via [`Self::cell`] is a small enum match.
/// Drive `apply` against every terminal `(parent, final_segment)` reached by
        assert!(parse_ppl_segments("a{0").is_err());
    if segments.is_empty() {
    fn walk_mut_deletes_flat_key() {
    fn walk_mut_wildcard_fans_out_across_array() {
            ScalarValue::Utf8(s) | ScalarValue::LargeUtf8(s) | ScalarValue::Utf8View(s),
                }
                    .downcast_ref::<StringArray>()
            }
                    .expect("Utf8 downcast"),
            Self::LargeUtf8(a) => (!a.is_null(i)).then(|| a.value(i)),
}
{
                })?;
            }
                    .downcast_ref::<LargeStringArray>()
    Utf8View(&'a StringViewArray),
pub(crate) fn parse(s: &str) -> Option<Value> {
                arr.as_any()
            _ => {
                map.shift_remove(*name);
                rest = &rest[cut..];
    #[test]
{
            if let (Value::Object(map), Segment::Field(name)) = (parent, seg) {
                }
    while !rest.is_empty() {
/// that legacy mutation UDFs rely on). Wildcard segments fan out across every
/// are silently skipped (matching Jayway's `SUPPRESS_EXCEPTIONS` behaviour
}
    }
}
            serde_json::to_string(&doc).unwrap(),
/// `Utf8View`). Dispatch happens once in [`Self::from_array`]; per-row access
    fn parse_ppl_segments_tokenises_field_index_and_wildcard() {
    }
    #[test]
        }
///
                Segment::Field("b"),
        match rest.as_bytes()[0] {
    fn v(s: &str) -> Value {
//! Shared helpers for the PPL `json_*` UDFs: PPL-path parsing (to both JSONPath
        match self {
            }
    }
                            "Non-numeric array index '{idx}' in JSON path: {input}"
            vec![
    fn walk_mut_handles_missing_path_as_noop() {
                for child in arr.iter_mut() {
        assert!(check_arity("f", 2, 1).is_err());
                    .expect("Utf8View downcast"),
/// "malformed → NULL" convention across all json_* UDFs (see
        match rest.as_bytes()[0] {
    pub(crate) fn cell(&self, i: usize) -> Option<&str> {
    Wildcard,
        assert_eq!(serde_json::to_string(&doc).unwrap(), r#"{"xs":[{"k":1}]}"#);
/// Empty `segments` is a no-op: PPL mutation UDFs reject a root-only path at
            }
    serde_json::from_str(s).ok()
    #[test]
}
    }
                    .downcast_ref::<StringViewArray>()
    #[test]
/// `segments` inside `root`. Missing intermediate keys / out-of-range indices
            ("a{0}.b{}.c", "$.a[0].b[*].c"),
        let segs = parse_ppl_segments("b").unwrap();
        assert_eq!(parse_ppl_segments("a").unwrap(), vec![Segment::Field("a")]);
/*
        match arr.data_type() {
    }
            }
    Field(&'a str),
            if let (Value::Object(map), Segment::Field(name)) = (parent, seg) {
                    })?;
                    out.push(Segment::Index(parsed));
        }
