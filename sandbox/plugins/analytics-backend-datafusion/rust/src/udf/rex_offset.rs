    }
mod tests {
        );
//! `rex_offset(input, pattern)` — compute start-end offsets of every named
        Self::new()
        // Java calls `matcher.find()` once, then walks named groups within
        // non-participating groups; the `if (start >= 0 && end >= 0)` guard
        }
        };
        if arg_types.len() != 2 {
pub(crate) fn calculate_offsets(regex: &Regex, input: &str) -> Option<String> {
            };
    }
    } else {
    ctx.register_udf(ScalarUDF::from(RexOffsetUdf::new()));
#[derive(Debug, PartialEq, Eq, Hash)]
    fn offsets_returns_none_when_pattern_has_no_named_groups() {
}
        assert_eq!(calculate_offsets(&r, "y"), Some("b=0-0".to_string()));
//! capture group from the first regex match, formatted as
        coerce_args(
    fn coerce_types(&self, arg_types: &[DataType]) -> Result<Vec<DataType>> {
        }
    fn offsets_returns_alphabetically_sorted_pairs() {
            arg_types,
        match sv {
//!   * `input` or `pattern` is NULL
use datafusion::arrow::datatypes::DataType;
        // that single match. Subsequent matches don't contribute.
        }
    }
                    builder.append_null();
        Self {
            let regex: &Regex = match (
                builder.append_null();
        }
        let pattern_arr_ref: Option<ArrayRef> =
use std::sync::Arc;
    }
                _ => {
        let n = args.number_rows;
            let regex_owned;
        }
    let caps = regex.captures(input)?;
use super::json_common::StringArrayView;
use regex::Regex;
                Some(args.args[1].clone().into_array(n)?)
    }
//! `"name1=start1-end1&name2=start2-end2"` with group names sorted
        // empty offsetPairs; we mirror that.
/// offsets throughout the regex stack.
//! alphabetically.
        Ok(ColumnarValue::Array(Arc::new(builder.finish()) as ArrayRef))
use super::{coerce_args, CoerceMode};
        None
}
    ColumnarValue, ScalarFunctionArgs, ScalarUDF, ScalarUDFImpl, Signature, Volatility,
            ) {
//!
    }
            Some("n=0-1".to_string())
//!     `offsetPairs.isEmpty() ? null : ...`)
            .transpose()?;
impl Default for RexOffsetUdf {
    #[test]
        // Pattern matches but no `(?<name>...)` groups — Java returns null for
}
    fn name(&self) -> &str {
            let Some(input_value) = input.cell(i) else {
    }
    use crate::udf::rex_extract::compile_pattern;
    if pairs.is_empty() {
                }
    }
};
//! to capture-group index 1, 2, 3, …. This UDF mirrors that walk: we use
                    pairs.push(format!("{name}={start}-{}", end - 1));
///
                }
    }
    fn signature(&self) -> &Signature {
        let mut builder = StringBuilder::with_capacity(n, n * 32);
            // Index 0 is the whole match; named groups start at 1. The
    }
        None
        let r = compile_pattern("(?<g>\\d+)").unwrap();
    #[test]
///
//! Returns NULL when:
impl ScalarUDFImpl for RexOffsetUdf {
            return plan_err!("rex_offset expects 2 arguments, got {}", args.args.len());
//!
#[cfg(test)]
        let result = calculate_offsets(&r, "user@example.com").unwrap();
}
}
//! End position is **inclusive** (matches the Java implementation:
    if let ColumnarValue::Scalar(sv) = cv {
fn utf8_scalar(cv: &ColumnarValue) -> Option<String> {
            } else {
//! Mirrors the SQL plugin's `RexOffsetFunction.calculateOffsets`.
            &[CoerceMode::Utf8, CoerceMode::Utf8],
}
                    &regex_owned
    use super::*;
                (None, Some(s)) => {
            };
                    continue;
            // groups — the `idx` here aligns with `caps.get(idx)`.
                let start = m.start();
        if args.args.len() != 2 {
//! Rust's `regex::Regex::capture_names` which returns names in the same
    }
}
pub fn register_all(ctx: &SessionContext) {
            calculate_offsets(&r, "12 then 34"),
        Some(pairs.join("&"))
        // Java sorts alphabetically: domain first, then host.
use datafusion::logical_expr::{
        // skips them. Rust's `caps.get(idx)` returns None — same skip.
                if end >= 1 {
/// The end position is the index of the last matched character (inclusive),
/// Build the `"name1=s1-e1&name2=s2-e2"` offset string from the first regex
                opt.clone()
//! The Java implementation parses named-group names from the pattern itself
                    regex_owned = compile_pattern(s)?;
 * The OpenSearch Contributors require contributions made to
        Ok(DataType::Utf8)
    fn invoke_with_args(&self, args: ScalarFunctionArgs) -> Result<ColumnarValue> {
impl RexOffsetUdf {
        let scalar_regex = match &pattern_scalar {
/*
//! declaration order. After computing positions, we sort the result
            Some(p) => Some(compile_pattern(p)?),
 * this file be licensed under the Apache-2.0 license or a
            }
        for i in 0..n {
                None => builder.append_null(),
 *
    }
        assert_eq!(
/// `groupName + "=" + start + "-" + (end - 1)`.
    } else {
//!
/// with the rest of the analytics-engine route, which already uses byte
use datafusion::arrow::array::{ArrayRef, StringBuilder};
        assert_eq!(result, "domain=5-15&host=0-3");
                let end = m.end();
                None
            match calculate_offsets(regex, input_value) {
    #[test]
        let pattern_array: Option<StringArrayView<'_>> = pattern_arr_ref
    fn offsets_handles_optional_groups_that_did_not_participate() {
            };
            .as_ref()
/// match or no named groups participated.
            .map(StringArrayView::from_array)
        let r = compile_pattern("(?<host>[^@]+)@(?<domain>.+)").unwrap();
                Some(s) => builder.append_value(s),
//!   * the pattern doesn't match `input`
        let pattern_scalar = utf8_scalar(&args.args[1]);
        &self.signature
/// matching `RexOffsetFunction.calculateOffsets` in the SQL plugin:
pub struct RexOffsetUdf {
            }
        assert_eq!(calculate_offsets(&r, "no digits"), None);
//! alphabetically (matching `Collections.sort(offsetPairs)` in the Java code).
            _ => None,
        }
    fn default() -> Self {
 * SPDX-License-Identifier: Apache-2.0
    fn offsets_returns_none_when_pattern_does_not_match() {
 */
        let input = StringArrayView::from_array(&input_arr)?;
                &scalar_regex,
        )
/// Note: positions are byte offsets (Rust `regex` returns byte indices), which
                pattern_array.as_ref().and_then(|a| a.cell(i)),
    }
//! `start + "-" + (end - 1)`).
    let mut pairs: Vec<String> = Vec::new();
            None => None,
    pub fn new() -> Self {
//!   * the pattern matches but has zero named groups (the Java code guards
/// non-ASCII input this may diverge from the Java behavior — kept consistent
 * compatible open source license.
        if let Some(name) = name_opt {
    #[test]
        assert_eq!(calculate_offsets(&r, "hello"), None);
    #[test]
    fn offsets_uses_first_match_only() {
use datafusion::common::{plan_err, ScalarValue};
use super::rex_extract::compile_pattern;
            // `name_opt.is_some()` branch only fires for actual capture
            }
//! (regex `\(\?<([^>]+)>`) and walks them in declaration order, mapping each
        // 'b' matched at 0-0. Java's `matcher.start(idx)` returns -1 for
        let r = compile_pattern("\\w+").unwrap();
        let input_arr = args.args[0].clone().into_array(n)?;
            // `capture_names` iterator yields a `None` at index 0, so the
/// matches Java's UTF-16 code-unit indices for ASCII-only inputs. For
    for (idx, name_opt) in regex.capture_names().enumerate() {
use datafusion::error::Result;
/// match. Names are sorted alphabetically in the output. Returns None if no
        // (?<a>x)?(?<b>y) on input "y": group 'a' didn't match (None), group
            signature: Signature::user_defined(Volatility::Immutable),
            if let Some(m) = caps.get(idx) {
        let r = compile_pattern("(?<n>\\d+)").unwrap();
            return plan_err!("rex_offset expects 2 arguments, got {}", arg_types.len());
//!
            "rex_offset",
        let r = compile_pattern("(?<a>x)?(?<b>y)").unwrap();
                }
        // Named groups are 'host' (start=0,end=4 → 0-3) and 'domain' (start=5,end=16 → 5-15).
        "rex_offset"
                continue;
            ScalarValue::Utf8(opt) | ScalarValue::LargeUtf8(opt) | ScalarValue::Utf8View(opt) => {
use datafusion::execution::context::SessionContext;
//! Lowering target for PPL's `rex field=f "(?<g>...)" offset_field=name`.
        pairs.sort();
                (Some(r), _) => r,
            if pattern_scalar.is_none() && matches!(&args.args[1], ColumnarValue::Array(_)) {
    }
}
    fn return_type(&self, arg_types: &[DataType]) -> Result<DataType> {
    signature: Signature,
    }
