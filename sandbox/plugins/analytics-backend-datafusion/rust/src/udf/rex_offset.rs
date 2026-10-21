            &[CoerceMode::Utf8, CoerceMode::Utf8],
            None => None,
        // Pattern matches but no `(?<name>...)` groups — Java returns null for
            if pattern_scalar.is_none() && matches!(&args.args[1], ColumnarValue::Array(_)) {
use datafusion::arrow::array::{ArrayRef, StringBuilder};
    fn offsets_returns_none_when_pattern_has_no_named_groups() {
                Some(s) => builder.append_value(s),
    }
            let Some(input_value) = input.cell(i) else {
impl ScalarUDFImpl for RexOffsetUdf {
        let r = compile_pattern("(?<n>\\d+)").unwrap();
    #[test]
/// matches Java's UTF-16 code-unit indices for ASCII-only inputs. For
        let pattern_scalar = utf8_scalar(&args.args[1]);
//!
                continue;
    fn return_type(&self, arg_types: &[DataType]) -> Result<DataType> {
            let regex: &Regex = match (
        let r = compile_pattern("(?<host>[^@]+)@(?<domain>.+)").unwrap();
    ctx.register_udf(ScalarUDF::from(RexOffsetUdf::new()));
                builder.append_null();
use std::sync::Arc;
        let result = calculate_offsets(&r, "user@example.com").unwrap();
        // skips them. Rust's `caps.get(idx)` returns None — same skip.
    }
            }
//!
            return plan_err!("rex_offset expects 2 arguments, got {}", arg_types.len());
//! Lowering target for PPL's `rex field=f "(?<g>...)" offset_field=name`.
        }
//! Mirrors the SQL plugin's `RexOffsetFunction.calculateOffsets`.
    }
        Self::new()
        &self.signature
            Some(p) => Some(compile_pattern(p)?),
use super::rex_extract::compile_pattern;
    let mut pairs: Vec<String> = Vec::new();
    signature: Signature,
        // 'b' matched at 0-0. Java's `matcher.start(idx)` returns -1 for
/// offsets throughout the regex stack.
        if let Some(name) = name_opt {
//! capture group from the first regex match, formatted as
                }
            arg_types,
//!
//! The Java implementation parses named-group names from the pattern itself
    } else {
        "rex_offset"
            match calculate_offsets(regex, input_value) {
 * this file be licensed under the Apache-2.0 license or a
        coerce_args(
    }
 */
pub(crate) fn calculate_offsets(regex: &Regex, input: &str) -> Option<String> {
            ScalarValue::Utf8(opt) | ScalarValue::LargeUtf8(opt) | ScalarValue::Utf8View(opt) => {
            calculate_offsets(&r, "12 then 34"),
        let pattern_arr_ref: Option<ArrayRef> =
            // `capture_names` iterator yields a `None` at index 0, so the
        let input_arr = args.args[0].clone().into_array(n)?;
//!   * the pattern doesn't match `input`
impl RexOffsetUdf {
        if arg_types.len() != 2 {
        assert_eq!(calculate_offsets(&r, "no digits"), None);
                (None, Some(s)) => {
}
    }
        assert_eq!(result, "domain=5-15&host=0-3");
            let regex_owned;
                Some(args.args[1].clone().into_array(n)?)
            // groups — the `idx` here aligns with `caps.get(idx)`.
    #[test]
        }
    }
                    &regex_owned
        );
    if pairs.is_empty() {
        // Java sorts alphabetically: domain first, then host.
    fn signature(&self) -> &Signature {
            // Index 0 is the whole match; named groups start at 1. The
    }
//! (regex `\(\?<([^>]+)>`) and walks them in declaration order, mapping each
use datafusion::common::{plan_err, ScalarValue};
 * compatible open source license.
    pub fn new() -> Self {
#[derive(Debug, PartialEq, Eq, Hash)]
        };
        match sv {
    }
 *
/// Build the `"name1=s1-e1&name2=s2-e2"` offset string from the first regex
        let r = compile_pattern("(?<g>\\d+)").unwrap();
            .as_ref()
            .transpose()?;
                opt.clone()
pub struct RexOffsetUdf {
        // empty offsetPairs; we mirror that.
/// match. Names are sorted alphabetically in the output. Returns None if no
use super::{coerce_args, CoerceMode};
                if end >= 1 {
    }
use super::json_common::StringArrayView;
            if let Some(m) = caps.get(idx) {
}
    #[test]
/// non-ASCII input this may diverge from the Java behavior — kept consistent
    fn offsets_returns_none_when_pattern_does_not_match() {
        None
                    continue;
        }
        assert_eq!(calculate_offsets(&r, "hello"), None);
                None
//!     `offsetPairs.isEmpty() ? null : ...`)
/// The end position is the index of the last matched character (inclusive),
        // (?<a>x)?(?<b>y) on input "y": group 'a' didn't match (None), group
        let n = args.number_rows;
    }
 * The OpenSearch Contributors require contributions made to
        let r = compile_pattern("(?<a>x)?(?<b>y)").unwrap();
                }
}
    fn offsets_returns_alphabetically_sorted_pairs() {
///
impl Default for RexOffsetUdf {
        let scalar_regex = match &pattern_scalar {
        assert_eq!(calculate_offsets(&r, "y"), Some("b=0-0".to_string()));
            "rex_offset",
                pattern_array.as_ref().and_then(|a| a.cell(i)),
/// match or no named groups participated.
use datafusion::error::Result;
    }
    #[test]
use datafusion::logical_expr::{
            }
    #[test]
                    regex_owned = compile_pattern(s)?;
}
            .map(StringArrayView::from_array)
        // Java calls `matcher.find()` once, then walks named groups within
                _ => {
    fn invoke_with_args(&self, args: ScalarFunctionArgs) -> Result<ColumnarValue> {
            };
            // `name_opt.is_some()` branch only fires for actual capture
    for (idx, name_opt) in regex.capture_names().enumerate() {
    fn coerce_types(&self, arg_types: &[DataType]) -> Result<Vec<DataType>> {
                let start = m.start();
            } else {
//! alphabetically (matching `Collections.sort(offsetPairs)` in the Java code).
        None
        if args.args.len() != 2 {
                    pairs.push(format!("{name}={start}-{}", end - 1));
}
use regex::Regex;
    if let ColumnarValue::Scalar(sv) = cv {
/// Note: positions are byte offsets (Rust `regex` returns byte indices), which
pub fn register_all(ctx: &SessionContext) {
        Ok(ColumnarValue::Array(Arc::new(builder.finish()) as ArrayRef))
    fn offsets_handles_optional_groups_that_did_not_participate() {
            ) {
        let mut builder = StringBuilder::with_capacity(n, n * 32);
    fn default() -> Self {
        // non-participating groups; the `if (start >= 0 && end >= 0)` guard
use datafusion::arrow::datatypes::DataType;
        let pattern_array: Option<StringArrayView<'_>> = pattern_arr_ref
                &scalar_regex,
            };
    let caps = regex.captures(input)?;
//! alphabetically.
//! to capture-group index 1, 2, 3, …. This UDF mirrors that walk: we use
    use super::*;
//! Rust's `regex::Regex::capture_names` which returns names in the same
        }
        for i in 0..n {
            _ => None,
mod tests {
//! End position is **inclusive** (matches the Java implementation:
        }
    fn offsets_uses_first_match_only() {
//! `rex_offset(input, pattern)` — compute start-end offsets of every named
                let end = m.end();
                    builder.append_null();
//! declaration order. After computing positions, we sort the result
            signature: Signature::user_defined(Volatility::Immutable),
}
#[cfg(test)]
        Ok(DataType::Utf8)
//! `"name1=start1-end1&name2=start2-end2"` with group names sorted
        Some(pairs.join("&"))
///
        )
//!
    }
            }
                }
 * SPDX-License-Identifier: Apache-2.0
        assert_eq!(
                (Some(r), _) => r,
/// with the rest of the analytics-engine route, which already uses byte
}
    }
/// `groupName + "=" + start + "-" + (end - 1)`.
//! Returns NULL when:
            return plan_err!("rex_offset expects 2 arguments, got {}", args.args.len());
        // that single match. Subsequent matches don't contribute.
/// matching `RexOffsetFunction.calculateOffsets` in the SQL plugin:
    ColumnarValue, ScalarFunctionArgs, ScalarUDF, ScalarUDFImpl, Signature, Volatility,
                None => builder.append_null(),
}
        pairs.sort();
    use crate::udf::rex_extract::compile_pattern;
};
        Self {
/*
//!   * `input` or `pattern` is NULL
        }
//! `start + "-" + (end - 1)`).
        let input = StringArrayView::from_array(&input_arr)?;
            Some("n=0-1".to_string())
use datafusion::execution::context::SessionContext;
        // Named groups are 'host' (start=0,end=4 → 0-3) and 'domain' (start=5,end=16 → 5-15).
//!   * the pattern matches but has zero named groups (the Java code guards
    }
    fn name(&self) -> &str {
    } else {
            };
    }
        let r = compile_pattern("\\w+").unwrap();
fn utf8_scalar(cv: &ColumnarValue) -> Option<String> {
