            Some(p) => Some(compile_pattern(p)?),
                _ => {
                pattern_array.as_ref().and_then(|a| a.cell(i)),
                "rex_extract_multi expects 4 arguments, got {}",
                    builder.append_null();
                CoerceMode::Utf8,
            collect_matches(&r, "12 then 34 then 56", "n", 2),
    fn collect_unbounded_returns_every_match() {
                (None, Some(arr)) if !arr.is_null(i) => arr.value(i) as i64,
pub(crate) fn collect_matches<'a>(
            ScalarValue::Utf8(opt) | ScalarValue::LargeUtf8(opt) | ScalarValue::Utf8View(opt) => {
            vec!["12", "34", "56"]
//! the SQL plugin's `RexExtractMultiFunction.extractMultipleGroups`.
            return plan_err!(
        let scalar_regex = match &pattern_scalar {
        Ok(DataType::List(Arc::new(Field::new(
            vec!["1", "2", "3"]
        None
        assert!(collect_matches(&r, "no digits", "n", 0).is_empty());
///
/*
    signature: Signature,
    if let ColumnarValue::Scalar(sv) = cv {
            } else {
    fn collect_breaks_on_unknown_group() {
                Some(args.args[3].clone().into_array(n)?)
            if pattern_scalar.is_none() && matches!(&args.args[1], ColumnarValue::Array(_)) {
        let r = compile_pattern("(?<n>\\d+)").unwrap();
//! `(maxMatch == 0 || matchCount < maxMatch)` in the loop guard).
        };
    }
        assert_eq!(
/// Collect up to `max_match` occurrences of the named-or-numbered group across
                // (treats it as "this group doesn't exist anywhere"). Without
impl ScalarUDFImpl for RexExtractMultiUdf {
        };
            .map(StringArrayView::from_array)
            ScalarValue::Int64(Some(v)) => Some(*v),
#[derive(Debug, PartialEq, Eq, Hash)]
            };
                builder.append(true);
                }
        }
        let pattern_scalar = utf8_scalar(&args.args[1]);
        match sv {
    ColumnarValue, ScalarFunctionArgs, ScalarUDF, ScalarUDFImpl, Signature, Volatility,
            Some(idx) => caps.get(idx).map(|m| m.as_str()),
                        builder.append_null();
        // List<String?> — element type is nullable Utf8 to match the Java
                    continue;
                }
}
    }
pub struct RexExtractMultiUdf {
use std::sync::Arc;
//! Lowering target for PPL's `rex field=f "(?<g>...)" max_match=N`. Mirrors
            }
        for i in 0..n {
                None
fn i64_scalar(cv: &ColumnarValue) -> Option<i64> {
            ScalarValue::Int8(Some(v)) => Some(*v as i64),
            );
    fn return_type(&self, arg_types: &[DataType]) -> Result<DataType> {
        // which the Java extractor catches and returns null, breaking the loop.
    use crate::udf::rex_extract::compile_pattern;
impl Default for RexExtractMultiUdf {
            };
            &[
                // accumulating no matches.
        Self::new()
            arg_types,
        let group_arr_ref: Option<ArrayRef> =
            ScalarValue::UInt16(Some(v)) => Some(*v as i64),
        assert_eq!(
            if group_scalar.is_none() && matches!(&args.args[2], ColumnarValue::Array(_)) {
use datafusion::logical_expr::{
                (Some(r), _) => r,
//! `max_match=0` is unbounded (matches the Java semantics:
/// `(maxMatch == 0 || matchCount < maxMatch)` loop guard).
            vec!["12", "34"]
            _ => None,
        }
                    (Some(g), _) => g.as_str(),
    group: &str,
            signature: Signature::user_defined(Volatility::Immutable),
            "item",
    fn name(&self) -> &str {
        }
    }
    fn collect_bounded_caps_at_max_match() {
        )
            };
            None => None,
    }
            "item",
    }
    use super::*;
    #[test]
//!
    } else {
                };
            .transpose()?;
            _ => None,
                Some(args.args[1].clone().into_array(n)?)
            };
 * compatible open source license.
        Self {
                None
            DataType::Utf8,
use super::{coerce_args, CoerceMode};
pub fn register_all(ctx: &SessionContext) {
            let max_match: i64 = match (max_match_scalar, max_match_array_i32) {
    fn default() -> Self {
        )));
    }
            ) {
            true,
                CoerceMode::Int64,
}
        "rex_extract_multi"
            .as_ref()
//! `rex_extract`). Group resolution semantics match `rex_extract`: numeric
 * The OpenSearch Contributors require contributions made to
        );
                }
//! `input`, returned as a `list<varchar>`.
            return plan_err!(
#[cfg(test)]
        let r = compile_pattern("(\\w+)=(\\w+)").unwrap();
        ))))
            collect_matches(&r, "a=1 b=2 c=3", "2", 0),
            collect_matches(&r, "12 then 34 then 56", "n", 0),
                CoerceMode::Utf8,
                for m in matches {
        match value {
}
                    regex_owned = compile_pattern(s)?;
        );
                opt.clone()
            let matches = collect_matches(regex, input_value, group_name, max_match);
                &scalar_regex,
    let mut out: Vec<&'a str> = Vec::new();
        let group_scalar = utf8_scalar(&args.args[2]);
    #[test]
        }
//! Java UDF's `matches.isEmpty() ? null : matches` final return.
                _ => {
                if max_match > 0 && (out.len() as i64) >= max_match {
                }
//! `rex_extract_multi(input, pattern, group, max_match)` — extract up to
//! `max_match` occurrences of a regex named or numbered capture group from
                        continue;
    #[test]
}
    }
    fn invoke_with_args(&self, args: ScalarFunctionArgs) -> Result<ColumnarValue> {
        // After coerce_types(Int64) the array may arrive as Int32 in some plans;
                    &regex_owned
            }
    }
    fn collect_returns_empty_when_no_match() {
        let max_match_scalar = i64_scalar(&args.args[3]);
                }
use datafusion::arrow::datatypes::{DataType, Field};
            ScalarValue::Int32(Some(v)) => Some(*v as i64),
        match sv {
        Ok(ColumnarValue::Array(Arc::new(builder.finish()) as ArrayRef))
};
                builder.append_null();
        coerce_args(
                    _ => {
                // this guard, an unknown group name would loop forever
use datafusion::execution::context::SessionContext;
    fn coerce_types(&self, arg_types: &[DataType]) -> Result<Vec<DataType>> {
    }
                match (&group_scalar, group_array.as_ref().and_then(|a| a.cell(i))) {
            } else {
//!
impl RexExtractMultiUdf {
    out
            .transpose()?;
        // Java behavior: `Matcher.group(name)` throws IAE for unknown names,
 * this file be licensed under the Apache-2.0 license or a
}
            .as_ref()
        None
        let r = compile_pattern("(?<n>\\d+)").unwrap();
        );
            ScalarValue::Int16(Some(v)) => Some(*v as i64),
            }
        let max_match_array_i32: Option<&Int32Array> = max_match_arr_ref
            );
    }
) -> Vec<&'a str> {
            let regex_owned;
                builder.append_null();
        let input = StringArrayView::from_array(&input_arr)?;
        if args.args.len() != 4 {
        assert!(collect_matches(&r, "12 34 56", "missing", 0).is_empty());
//!
        let pattern_arr_ref: Option<ArrayRef> =
}
    #[test]
                (Some(m), _) => m,
}
    for caps in regex.captures_iter(input) {
//! string → 1-based index, otherwise named-group lookup.
                    builder.append_null();
            let group_name: &str =
                (None, Some(s)) => {
        let mut builder = ListBuilder::new(value_builder).with_field(Arc::new(Field::new(
        let value: Option<&str> = match parsed_index {
        // signature `ARRAY(VARCHAR_2000_NULLABLE)`.
fn utf8_scalar(cv: &ColumnarValue) -> Option<String> {
                Some(args.args[2].clone().into_array(n)?)
use super::json_common::StringArrayView;
        if arg_types.len() != 4 {
        // The Rust `caps.name(...)` returns None for unknown names; same break.
                // Java behavior: a `null` from the extractor breaks the loop
            None => caps.name(group).map(|m| m.as_str()),
                continue;
    pub fn new() -> Self {
                break;
        assert_eq!(
}
        let r = compile_pattern("(?<n>\\d+)").unwrap();
                args.args.len()
    regex: &Regex,
    fn collect_numeric_index_works_for_each_match() {
            let regex: &Regex = match (
            } else {
        let input_arr = args.args[0].clone().into_array(n)?;
    ctx.register_udf(ScalarUDF::from(RexExtractMultiUdf::new()));
    }
                    builder.values().append_value(m);
                CoerceMode::Utf8,
    if let ColumnarValue::Scalar(sv) = cv {
            "rex_extract_multi",
 * SPDX-License-Identifier: Apache-2.0
            .as_ref()
            .map(StringArrayView::from_array)
            ScalarValue::UInt64(Some(v)) => Some(*v as i64),
        &self.signature
            ScalarValue::UInt32(Some(v)) => Some(*v as i64),
    }
            ScalarValue::UInt8(Some(v)) => Some(*v as i64),
        let max_match_arr_ref: Option<ArrayRef> =
                arg_types.len()
use super::rex_extract::compile_pattern;
        // accept either by widening on read.
        }
    }
        }
            true,
    }
            ],
}
            .and_then(|a| a.as_any().downcast_ref::<Int32Array>());
use regex::Regex;
    let parsed_index = group.parse::<usize>().ok().filter(|i| *i >= 1);
                None
                "rex_extract_multi expects 4 arguments, got {}",
    fn signature(&self) -> &Signature {
//!
            None => {
            }
//! Returns NULL (not an empty list) when no matches are found — matches the
            DataType::Utf8,
        let value_builder = StringBuilder::new();
                    continue;
    max_match: i64,
        }
    #[test]
//! Pattern compilation errors surface as planning errors (same as
    input: &'a str,
use datafusion::common::{plan_err, ScalarValue};
            } else {
            };
        let n = args.number_rows;
use datafusion::arrow::array::{Array, ArrayRef, Int32Array, ListBuilder, StringBuilder};
            let Some(input_value) = input.cell(i) else {
                out.push(s);
        let r = compile_pattern("(\\d+)").unwrap();
    }
            Some(s) => {
use datafusion::error::Result;
    } else {
                    (None, Some(s)) => s,
                    }
            if max_match_scalar.is_none() && matches!(&args.args[3], ColumnarValue::Array(_)) {
        let group_array: Option<StringArrayView<'_>> = group_arr_ref
                    break;
 *
            };
            if matches.is_empty() {
        let pattern_array: Option<StringArrayView<'_>> = pattern_arr_ref
mod tests {
/// the input. `max_match == 0` is unbounded (matches the Java semantics in the
/// Visible for unit testing — the iteration logic is the substantive part.
 */
