            "Error in 'rex' command: encountered an error while compiling the regex '{pat}': {e}"
                builder.append_null();
        let err = compile_pattern("(unclosed").unwrap_err();
    fn extract_returns_none_when_pattern_does_not_match() {
        // Materialize column-valued operands lazily; keep the ArrayRef alive
        // fall back to per-row compile (slow but correct).
    }
    }
fn utf8_scalar(cv: &ColumnarValue) -> Option<String> {
    }
        }
            .transpose()?;
            } else {
        }
                continue;
        let mut builder = StringBuilder::with_capacity(n, n * 16);
            "rex_extract",
    fn extract_takes_first_match_only() {
                    continue;
            .transpose()?;
    }
        return None;
                opt.clone()
//! signatures (`int groupIndex` and `String groupName`).
    caps.name(group).map(|m| m.as_str())
//! practice positions 1 and 2 always arrive as scalars.
    fn extract_returns_none_for_unknown_group_name() {
/// Compile a regex pattern, returning a planning error on syntax issues
                (None, Some(s)) => {
//! per-call here, not per-row, and a column-valued pattern would either
    #[test]
//!   * the pattern matches but the requested group didn't participate
    }
pub(crate) fn compile_pattern(pat: &str) -> Result<Regex> {
        if args.args.len() != 3 {
    fn default() -> Self {
    })
            }
            .as_ref()
            };
/// Look up a capture group in the first match of `regex` against `input`.
            let regex_owned;
}
/// `group` is treated as a 1-based numeric index if it parses as a positive
    }
    use super::*;
//!
            Some(p) => Some(compile_pattern(p)?),
        }
        // 1-based indexing — group 0 is the whole match (Java doesn't expose
pub struct RexExtractUdf {
//! treats every operand as if it were a column ref defensively, but in
                    _ => {
 * SPDX-License-Identifier: Apache-2.0
        // every input row. If pattern is column-valued (a degenerate case), we
use datafusion::error::{DataFusionError, Result};
            let Some(input_value) = input.cell(i) else {
//! falls back to numbered-group lookup — matches the Java UDF's two
    }
        None
            return plan_err!("rex_extract expects 3 arguments, got {}", arg_types.len());
        assert_eq!(extract_group(&r, "no digits here", "g"), None);
//! (named-group lookup). If `group` parses as a positive integer, this UDF
};
    signature: Signature,
        };
    ColumnarValue, ScalarFunctionArgs, ScalarUDF, ScalarUDFImpl, Signature, Volatility,
}
        // alongside the StringArrayView (the view borrows the underlying buffers).
//! candidates from the pattern up front and emits one call per group with
//! `RexExtractAdapter` on the Java side — column-valued patterns/groups are
    }
            _ => None,
    fn return_type(&self, arg_types: &[DataType]) -> Result<DataType> {
                    builder.append_null();
    fn coerce_types(&self, arg_types: &[DataType]) -> Result<Vec<DataType>> {
        let pattern_array: Option<StringArrayView<'_>> = pattern_arr_ref
                Some(args.args[2].clone().into_array(n)?)
        assert_eq!(extract_group(&r, "user@example.com", "host"), Some("user"));
                (Some(r), _) => r,
        Ok(DataType::Utf8)
                Some(args.args[1].clone().into_array(n)?)
            return plan_err!("rex_extract expects 3 arguments, got {}", args.args.len());
//!
            if pattern_scalar.is_none() && matches!(&args.args[1], ColumnarValue::Array(_)) {
/// (matches the Java UDF's `IllegalArgumentException` for `PatternSyntaxException`).
            arg_types,
use super::{coerce_args, CoerceMode};
        DataFusionError::Plan(format!(
        let group_arr_ref: Option<ArrayRef> =
        }
/*
        "rex_extract"
        // `extract_group` uses `captures(...)` which returns the first match.
impl Default for RexExtractUdf {
}
            Some("example.com")
use super::json_common::StringArrayView;
    #[test]
    let caps = regex.captures(input)?;
        Self {
                match (&group_scalar, group_array.as_ref().and_then(|a| a.cell(i))) {
    if let ColumnarValue::Scalar(sv) = cv {
    }
}
    fn signature(&self) -> &Signature {
//! regex named or numbered capture group from `input`.
                    regex_owned = compile_pattern(s)?;
    }
        Self::new()
        match sv {
            let group_name: &str =
    fn invoke_with_args(&self, args: ScalarFunctionArgs) -> Result<ColumnarValue> {
                        continue;
        Ok(ColumnarValue::Array(Arc::new(builder.finish()) as ArrayRef))
use std::sync::Arc;
//! `rex_extract(input, pattern, group)` — extract the first occurrence of a
 * The OpenSearch Contributors require contributions made to
}
//! # Group resolution
        assert_eq!(
        let n = args.number_rows;
//! (single-match form). Mirrors the SQL plugin's
//! The Calcite visitor (CalciteRelNodeVisitor.visitRex) parses named-group
impl ScalarUDFImpl for RexExtractUdf {
        let r = compile_pattern("(?<n>\\d+)").unwrap();
 *
                }
use datafusion::arrow::datatypes::DataType;
            &[CoerceMode::Utf8, CoerceMode::Utf8, CoerceMode::Utf8],
                pattern_array.as_ref().and_then(|a| a.cell(i)),
                    (Some(g), _) => g.as_str(),
    } else {
    if let Ok(idx) = group.parse::<usize>() {
        // We accept idx >= 1 to match Java's `if (groupIndex > 0)` guard.
}
        )
                    (None, Some(s)) => s,
            // Resolve the regex — scalar fast-path or per-row column lookup.
}
    pub fn new() -> Self {
    fn extract_supports_numeric_group_index() {
                }
        ))
    #[test]
                    }
                _ => {
    }
            };
        // Subsequent matches are the job of `rex_extract_multi`.
            if group_scalar.is_none() && matches!(&args.args[2], ColumnarValue::Array(_)) {
            // Resolve the group name (or numeric index, if it parses as one).
/// Returns `None` for NULL scalars, non-scalar values, or non-string types.
//!
//! recompile at every row (catastrophic) or silently degrade. The Rust UDF
//!   * the pattern doesn't match `input`
use datafusion::execution::context::SessionContext;
//!
impl RexExtractUdf {
            .as_ref()
    fn compile_pattern_returns_plan_error_on_invalid_syntax() {
                };
        // Pattern and group are typically scalars at this point — Java adapter
}
#[derive(Debug, PartialEq, Eq, Hash)]
        let group_scalar = utf8_scalar(&args.args[2]);
        assert_eq!(extract_group(&r, "hello world", "3"), None);
/// integer; otherwise as a named group. Returns `None` if no match, the group
#[cfg(test)]
        if arg_types.len() != 3 {
                        builder.append_null();
                    &regex_owned
    ctx.register_udf(ScalarUDF::from(RexExtractUdf::new()));
pub(crate) fn extract_group<'a>(regex: &Regex, input: &'a str, group: &str) -> Option<&'a str> {
                None
use datafusion::logical_expr::{
        let pattern_arr_ref: Option<ArrayRef> =
//! `pattern` and `group` are validated as string literals at plan time by
        // enforced literal-only at plan time. Compile the regex once; reuse for
        // it via this UDF; idx >= 1 only).
    }
        &self.signature
        );
            } else {
        }
//! Lowering target for PPL's `rex field=f "(?<g>...)"` extract command
//!
                None
    }
            ) {
        for i in 0..n {
    }
        let r = compile_pattern("(?<g>\\w+)").unwrap();
    #[test]
        let scalar_regex = match &pattern_scalar {
//! Returns NULL when:
//! rejected before substrait serialization because the regex is compiled
//!   * `input` or `pattern` is NULL
        let r = compile_pattern("(\\w+) (\\w+)").unwrap();
        let r = compile_pattern("(?<g>\\d+)").unwrap();
        if idx >= 1 {
 * compatible open source license.
        assert_eq!(extract_group(&r, "12 then 34 then 56", "n"), Some("12"));
    Regex::new(pat).map_err(|e| {
    #[test]
        let r = compile_pattern("(?<host>[^@]+)@(?<domain>.+)").unwrap();
            signature: Signature::user_defined(Volatility::Immutable),
mod tests {
            }
            };
        let group_array: Option<StringArrayView<'_>> = group_arr_ref
        let input_arr = args.args[0].clone().into_array(n)?;
    }
            .map(StringArrayView::from_array)
        assert!(err.to_string().contains("Error in 'rex' command"));
            return caps.get(idx).map(|m| m.as_str());
        // Java's `Matcher.group(int)` is 1-based; idx 0 is the full match.
 */
use regex::Regex;
            let regex: &Regex = match (
            };
/// doesn't exist, or the group didn't participate in the match.
//!   * the requested group doesn't exist in the pattern
                None => builder.append_null(),
        }
            match extract_group(regex, input_value, group_name) {
}
        assert_eq!(extract_group(&r, "hello world", "1"), Some("hello"));
//! `group` as the literal group name. So `group` is always a string here
                Some(s) => builder.append_value(s),
            None => None,
 * this file be licensed under the Apache-2.0 license or a
//!
//! # Division of labor with the Java adapter
        coerce_args(
    fn extract_named_group_first_match() {
    #[test]
        let pattern_scalar = utf8_scalar(&args.args[1]);
use datafusion::common::{plan_err, ScalarValue};
        let input = StringArrayView::from_array(&input_arr)?;
            .map(StringArrayView::from_array)
//! `org.opensearch.sql.expression.function.udf.RexExtractFunction.extractGroup`.
pub fn register_all(ctx: &SessionContext) {
                &scalar_regex,
            ScalarValue::Utf8(opt) | ScalarValue::LargeUtf8(opt) | ScalarValue::Utf8View(opt) => {
            extract_group(&r, "user@example.com", "domain"),
    fn name(&self) -> &str {
        assert_eq!(extract_group(&r, "hello world", "2"), Some("world"));
/// If `cv` is a Utf8/LargeUtf8/Utf8View string scalar, return the String.
use datafusion::arrow::array::{ArrayRef, StringBuilder};
        assert_eq!(extract_group(&r, "hello", "missing"), None);
