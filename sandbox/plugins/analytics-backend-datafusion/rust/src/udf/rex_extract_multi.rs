            };
    regex: &Regex,
    fn collect_returns_empty_when_no_match() {
                Some(args.args[2].clone().into_array(n)?)
                &scalar_regex,
        Ok(ColumnarValue::Array(Arc::new(builder.finish()) as ArrayRef))
            ScalarValue::Int64(Some(v)) => Some(*v),
                builder.append(true);
            };
        &self.signature
    }
                    break;
//! Returns NULL (not an empty list) when no matches are found — matches the
            vec!["12", "34", "56"]
        coerce_args(
    fn return_type(&self, arg_types: &[DataType]) -> Result<DataType> {
    signature: Signature,
                arg_types.len()
            .as_ref()
 * The OpenSearch Contributors require contributions made to
/// `(maxMatch == 0 || matchCount < maxMatch)` loop guard).
            collect_matches(&r, "a=1 b=2 c=3", "2", 0),
    ctx.register_udf(ScalarUDF::from(RexExtractMultiUdf::new()));
impl RexExtractMultiUdf {
        None
        Ok(DataType::List(Arc::new(Field::new(
    fn default() -> Self {
        };
}
}
//! `(maxMatch == 0 || matchCount < maxMatch)` in the loop guard).
impl Default for RexExtractMultiUdf {
    }
        if args.args.len() != 4 {
            "item",
                }
        let max_match_arr_ref: Option<ArrayRef> =
                continue;
    input: &'a str,
//! `rex_extract_multi(input, pattern, group, max_match)` — extract up to
    }
 */
            };
            vec!["1", "2", "3"]
            } else {
        if arg_types.len() != 4 {
    }
        );
            return plan_err!(
            collect_matches(&r, "12 then 34 then 56", "n", 2),
                    builder.append_null();
        let value: Option<&str> = match parsed_index {
        let scalar_regex = match &pattern_scalar {
            DataType::Utf8,
    }
        assert!(collect_matches(&r, "no digits", "n", 0).is_empty());
        Self {
//! Lowering target for PPL's `rex field=f "(?<g>...)" max_match=N`. Mirrors
                }
        let group_scalar = utf8_scalar(&args.args[2]);
            ScalarValue::UInt16(Some(v)) => Some(*v as i64),
                (Some(m), _) => m,
//!
        let r = compile_pattern("(?<n>\\d+)").unwrap();
};
//!
        // Java behavior: `Matcher.group(name)` throws IAE for unknown names,
use super::rex_extract::compile_pattern;
    fn coerce_types(&self, arg_types: &[DataType]) -> Result<Vec<DataType>> {
            None => caps.name(group).map(|m| m.as_str()),
                        builder.append_null();
//! string → 1-based index, otherwise named-group lookup.
    #[test]
}
        let group_array: Option<StringArrayView<'_>> = group_arr_ref
fn utf8_scalar(cv: &ColumnarValue) -> Option<String> {
}
            signature: Signature::user_defined(Volatility::Immutable),
        let pattern_arr_ref: Option<ArrayRef> =
        let n = args.number_rows;
/// Collect up to `max_match` occurrences of the named-or-numbered group across
            ScalarValue::Utf8(opt) | ScalarValue::LargeUtf8(opt) | ScalarValue::Utf8View(opt) => {
            true,
        let value_builder = StringBuilder::new();
    #[test]
            ScalarValue::UInt32(Some(v)) => Some(*v as i64),
use super::json_common::StringArrayView;
fn i64_scalar(cv: &ColumnarValue) -> Option<i64> {
        // which the Java extractor catches and returns null, breaking the loop.
    let parsed_index = group.parse::<usize>().ok().filter(|i| *i >= 1);
            .and_then(|a| a.as_any().downcast_ref::<Int32Array>());
impl ScalarUDFImpl for RexExtractMultiUdf {
                Some(args.args[3].clone().into_array(n)?)
}
    } else {
//! `input`, returned as a `list<varchar>`.
#[derive(Debug, PartialEq, Eq, Hash)]
 *
            ScalarValue::UInt64(Some(v)) => Some(*v as i64),
            let Some(input_value) = input.cell(i) else {
                    }
            }
                // (treats it as "this group doesn't exist anywhere"). Without
    fn invoke_with_args(&self, args: ScalarFunctionArgs) -> Result<ColumnarValue> {
                None
use datafusion::common::{plan_err, ScalarValue};
            if pattern_scalar.is_none() && matches!(&args.args[1], ColumnarValue::Array(_)) {
            .map(StringArrayView::from_array)
use datafusion::arrow::datatypes::{DataType, Field};
        );
        "rex_extract_multi"
pub struct RexExtractMultiUdf {
#[cfg(test)]
        match sv {
                "rex_extract_multi expects 4 arguments, got {}",
                match (&group_scalar, group_array.as_ref().and_then(|a| a.cell(i))) {
            let max_match: i64 = match (max_match_scalar, max_match_array_i32) {
                    builder.append_null();
            Some(p) => Some(compile_pattern(p)?),
                "rex_extract_multi expects 4 arguments, got {}",
                None
                }
            );
            "item",
        // accept either by widening on read.
            ScalarValue::Int16(Some(v)) => Some(*v as i64),
                CoerceMode::Utf8,
        let r = compile_pattern("(\\w+)=(\\w+)").unwrap();
    if let ColumnarValue::Scalar(sv) = cv {
            .as_ref()
use datafusion::execution::context::SessionContext;
//!
//!
            } else {
        let r = compile_pattern("(?<n>\\d+)").unwrap();
            let group_name: &str =
    #[test]
                builder.append_null();
            .transpose()?;
                builder.append_null();
            return plan_err!(
            ],
        }
    use super::*;
        let r = compile_pattern("(?<n>\\d+)").unwrap();
    fn name(&self) -> &str {
//! `max_match` occurrences of a regex named or numbered capture group from
    #[test]
    max_match: i64,
    group: &str,
        let max_match_scalar = i64_scalar(&args.args[3]);
///
        match sv {
            };
            vec!["12", "34"]
        )));
            _ => None,
            Some(idx) => caps.get(idx).map(|m| m.as_str()),
            }
    for caps in regex.captures_iter(input) {
    }
            let regex: &Regex = match (
            arg_types,
}
                if max_match > 0 && (out.len() as i64) >= max_match {
        let r = compile_pattern("(\\d+)").unwrap();
            Some(s) => {
}
                // accumulating no matches.
                CoerceMode::Utf8,
        }
    ColumnarValue, ScalarFunctionArgs, ScalarUDF, ScalarUDFImpl, Signature, Volatility,
    if let ColumnarValue::Scalar(sv) = cv {
                args.args.len()
                // this guard, an unknown group name would loop forever
}
use datafusion::arrow::array::{Array, ArrayRef, Int32Array, ListBuilder, StringBuilder};
        match value {
                _ => {
                CoerceMode::Utf8,
/// the input. `max_match == 0` is unbounded (matches the Java semantics in the
/*
            None => {
            if matches.is_empty() {
        Self::new()
    fn collect_bounded_caps_at_max_match() {
        // The Rust `caps.name(...)` returns None for unknown names; same break.
        assert_eq!(
    pub fn new() -> Self {
        let mut builder = ListBuilder::new(value_builder).with_field(Arc::new(Field::new(
    }
    }
            if group_scalar.is_none() && matches!(&args.args[2], ColumnarValue::Array(_)) {
                Some(args.args[1].clone().into_array(n)?)
            &[
            "rex_extract_multi",
pub(crate) fn collect_matches<'a>(
                break;
        };
//! `max_match=0` is unbounded (matches the Java semantics:
use datafusion::logical_expr::{
                _ => {
        let pattern_array: Option<StringArrayView<'_>> = pattern_arr_ref
    #[test]
    let mut out: Vec<&'a str> = Vec::new();
            true,
        }
        }
                    (Some(g), _) => g.as_str(),
    out
            }
                out.push(s);
        assert_eq!(
 * compatible open source license.
                opt.clone()
            };
            ScalarValue::Int8(Some(v)) => Some(*v as i64),
            } else {
        let pattern_scalar = utf8_scalar(&args.args[1]);
            } else {
            if max_match_scalar.is_none() && matches!(&args.args[3], ColumnarValue::Array(_)) {
                    regex_owned = compile_pattern(s)?;
//! `rex_extract`). Group resolution semantics match `rex_extract`: numeric
            ) {
            _ => None,
            let matches = collect_matches(regex, input_value, group_name, max_match);
        let max_match_array_i32: Option<&Int32Array> = max_match_arr_ref
        }
                    (None, Some(s)) => s,
            }
        assert_eq!(
) -> Vec<&'a str> {
                pattern_array.as_ref().and_then(|a| a.cell(i)),
use super::{coerce_args, CoerceMode};
                    _ => {
            collect_matches(&r, "12 then 34 then 56", "n", 0),
pub fn register_all(ctx: &SessionContext) {
use std::sync::Arc;
        let input = StringArrayView::from_array(&input_arr)?;
mod tests {
                (None, Some(s)) => {
    }
 * this file be licensed under the Apache-2.0 license or a
        None
    }
            .as_ref()
            .map(StringArrayView::from_array)
        );
    }
                (Some(r), _) => r,
            };
        // List<String?> — element type is nullable Utf8 to match the Java
use datafusion::error::Result;
                (None, Some(arr)) if !arr.is_null(i) => arr.value(i) as i64,
        // After coerce_types(Int64) the array may arrive as Int32 in some plans;
                CoerceMode::Int64,
                    continue;
                }
    }
}
        }
    use crate::udf::rex_extract::compile_pattern;
                }
        for i in 0..n {
/// Visible for unit testing — the iteration logic is the substantive part.
                    continue;
        // signature `ARRAY(VARCHAR_2000_NULLABLE)`.
                        continue;
        let group_arr_ref: Option<ArrayRef> =
    fn collect_unbounded_returns_every_match() {
                None
            ScalarValue::UInt8(Some(v)) => Some(*v as i64),
            None => None,
    }
//! Pattern compilation errors surface as planning errors (same as
        }
            let regex_owned;
                // Java behavior: a `null` from the extractor breaks the loop
    fn collect_numeric_index_works_for_each_match() {
    fn collect_breaks_on_unknown_group() {
            DataType::Utf8,
//! Java UDF's `matches.isEmpty() ? null : matches` final return.
                for m in matches {
            ScalarValue::Int32(Some(v)) => Some(*v as i64),
        ))))
        )
    }
//! the SQL plugin's `RexExtractMultiFunction.extractMultipleGroups`.
 * SPDX-License-Identifier: Apache-2.0
    fn signature(&self) -> &Signature {
                    &regex_owned
    }
use regex::Regex;
                    builder.values().append_value(m);
                };
            );
            .transpose()?;
        let input_arr = args.args[0].clone().into_array(n)?;
    } else {
        assert!(collect_matches(&r, "12 34 56", "missing", 0).is_empty());
