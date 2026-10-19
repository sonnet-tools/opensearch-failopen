                let value = match &captures {
};
        // map's key order matches what users see in legacy PPL output.
        let n = args.number_rows;
    fn entries_of(map: &MapArray, row: usize) -> Vec<(String, String)> {
        Self::new()
            .filter_map(|name| name.map(String::from))
        assert!(msg.contains("'regex'"), "{msg}");
                    input_arr.data_type(),
            .unwrap_err();
use datafusion::execution::context::SessionContext;
        // Anchor pattern so we honour Java's `Matcher.matches()` semantics:
                ColumnarValue::Scalar(ScalarValue::Utf8(Some(method.to_string()))),
    #[test]
                value: "value".to_string(),
        }
        _ => None,
    }
        let values = entries
                    Some(c) => c.name(name).map(|m| m.as_str()).unwrap_or(""),
        let input = input_arr
 * SPDX-License-Identifier: Apache-2.0
        )?;
                regex.captures(input.value(i))
//!     pattern or method makes no sense for parse and is rejected up front.
        let n = input.len();
        if group_names.is_empty() {
            .downcast_ref::<StringArray>()
            .unwrap();
            return plan_err!("parse expects 3 arguments, got {}", args.args.len());
            )));
                "parse: method '{method}' is not supported by the analytics engine; \
        DataType::Struct(vec![key_field, value_field].into()),
        })?;
                ColumnarValue::Scalar(ScalarValue::Utf8(Some(pattern.to_string()))),
    }
        };
    let ColumnarValue::Scalar(sv) = cv else {
            r"ip=(?<ip>\S+) port=(?<port>\d+)",
        for i in 0..n {
        assert_eq!(
    #[test]
use datafusion::common::{plan_err, ScalarValue};
        let input_arr = StringArray::from(input);
    DataType::Map(entries_field, false)
            for name in &group_names {
                ColumnarValue::Array(Arc::new(input_arr)),
            StringBuilder::new(),
//!     where `extractNamedGroup` returns null and `ParseFunction` wraps that
            }
    fn return_type(&self, arg_types: &[DataType]) -> Result<DataType> {
    pub fn new() -> Self {
            // participate all collapse to "" for that group's value — this
            .as_any()
            .coerce_types(&[DataType::LargeUtf8, DataType::Utf8View, DataType::Utf8])
        // would always return NULL. Fail loudly at plan time.
                entry: "entries".to_string(),
fn map_return_type() -> DataType {
        if method != "regex" {
};
            vec![("name".to_string(), "alice".to_string())]
use super::{coerce_args, CoerceMode};
//!     to `ExprStringValue("")`.
}
            builder.append(true)?;
            entries_of(&map, 0),
        assert!(err.to_string().contains("expected string"));
    fn null_input_emits_empty_values_with_full_schema() {
        if arg_types.len() != 3 {
            .ok_or_else(|| {
//!     Java's `Matcher.matches()` semantic that PPL's `RegexExpression` relies on.
            )));
        assert!(udf.return_type(&[DataType::Utf8, DataType::Utf8]).is_err());
    fn coerce_types_rejects_non_string_input() {
use datafusion::arrow::datatypes::{DataType, Field};
        }
                DataType::Utf8,
    #[test]
 * compatible open source license.
    }
            .downcast_ref::<StringArray>()
//!     group's value — same behaviour as the legacy `RegexExpression`
/// is non-scalar, a non-string scalar, or a SQL NULL — the adapter is meant to
/// values nullable. Constructed once per call rather than per row.
            // mirrors `extractNamedGroup` returning null and ParseFunction
        let pattern = scalar_str(&args.args[1]).ok_or_else(|| {
fn scalar_str(cv: &ColumnarValue) -> Option<String> {
        // the match must consume the entire input. Wrapping in a non-capturing
        // unknown caller produces an actionable plan error instead of a panic.
        // coerce_args validates each slot is a string variant (LargeUtf8 / Utf8View / Utf8) but
            vec![Some("ip=10.0.0.1 port=443 trailing-junk")],
        assert!(!map.is_null(0)); // row 0 cell is present
            _ => panic!("expected array"),
        );
        .unwrap();
        let err = run_parse(vec![Some("x")], r"(?<x>[unbalanced", "regex").unwrap_err();
    use datafusion::arrow::datatypes::TimeUnit;
        let anchored = format!("^(?:{pattern})$");
            "parse",
        let udf = ParseUdf::new();
use datafusion::arrow::array::{
        .unwrap();
    fn pattern_without_named_groups_is_rejected() {
    }
        // Same pattern — the trailing junk means the row should NOT match,
        assert_eq!(dt, map_return_type());
        let err = udf
                builder.keys().append_value(name);
        if args.args.len() != 3 {
impl ParseUdf {
            signature: Signature::user_defined(Volatility::Immutable),
        (0..entries.len())
        let map = run_parse(
                ("port".to_string(), "443".to_string()),
mod tests {
            number_rows: n,
    }
}
    }
    fn return_type_is_map_utf8_utf8() {
            .map_err(|e| DataFusionError::Plan(format!("parse: invalid regex [{pattern}]: {e}")))?;
        Ok(validated.into_iter().map(|_| DataType::Utf8).collect())
//!   * Verify `pattern` and `method` operands are string literals — column-valued
    #[test]
    }
    #[test]
    }
            vec![Some("ip=10.0.0.1 port=443")],
    fn invalid_regex_surfaces_as_plan_error() {
    fn invoke_with_args(&self, args: ScalarFunctionArgs) -> Result<ColumnarValue> {
        // caller relies on.
    }
            Some(MapFieldNames {
                builder.values().append_value(value);
        );
    #[test]
            &[CoerceMode::Utf8, CoerceMode::Utf8, CoerceMode::Utf8],
            ColumnarValue::Array(a) => a,
    fn name(&self) -> &str {
        let out = udf
//!     it with `^…$` so the match consumes the entire input — equivalent to
    #[test]
#[cfg(test)]
    match sv {
        Ok(ColumnarValue::Array(Arc::new(builder.finish()) as ArrayRef))
            opt.clone()
    };
//!   * For every input row, populate a `map<utf8, utf8>` with one entry per
        }
        let entries = map.value(row);
            r"name=(?<name>\w+)",
    fn whole_string_anchoring_is_enforced() {
        let input_arr = args.args[0].clone().into_array(n)?;
            };
        // Mirrors ParseFunction.parse(null, …) in core PPL — the map cell is
    }
use regex::Regex;
use datafusion::error::{DataFusionError, Result};
        let method = scalar_str(&args.args[2]).ok_or_else(|| {
    signature: Signature,
        // so all named groups are emitted with "".
            return Err(DataFusionError::Plan(format!(
}
        let args = ScalarFunctionArgs {
/// have caught these at plan time but we re-check at runtime.
    fn return_type_rejects_wrong_arity() {
    fn extracts_named_groups_in_pattern_order() {
    use datafusion::arrow::array::MapArray;
            StringBuilder::new(),
        let group_names: Vec<String> = regex
    }
    }
    let value_field = Arc::new(Field::new("value", DataType::Utf8, true));
            .column(1)
            entries_of(&map, 1),
    fn signature(&self) -> &Signature {
}
                DataType::Utf8,
        }
                 only 'regex' is currently supported (use 'grok' / 'patterns' on the legacy engine)",
        let validated = coerce_args(
            .as_any()
            .column(0)
                    None => "",
        // PPL parse without named groups is a user error: the result map would
    ColumnarValue, ScalarFunctionArgs, ScalarUDF, ScalarUDFImpl, Signature, Volatility,
        let udf = ParseUdf::new();
            .as_any()
//!     named group in pattern definition order. A row that fails to match (or
                ("port".to_string(), "".to_string()),
//! Runtime work (this file):
    ctx.register_udf(ScalarUDF::from(ParseUdf::new()));
        assert!(err.to_string().contains("no named capture groups"));
            .downcast_ref::<StringArray>()
    fn coerce_types_normalises_string_variants() {
                DataType::Timestamp(TimeUnit::Millisecond, None),
            args: vec![
}
}
            DataFusionError::Plan("parse: method must be a non-null string literal".into())
 */
        let map = run_parse(
//!   * Compile the regex once per call (literal pattern from the adapter), anchor
        Self {
            .collect()
        let mut builder = MapBuilder::new(
    }
#[derive(Debug, PartialEq, Eq, Hash)]
        );
        assert!(err.to_string().contains("invalid regex"));
    fn default() -> Self {
                "parse: regex [{pattern}] has no named capture groups",
        ScalarValue::Utf8(opt) | ScalarValue::LargeUtf8(opt) | ScalarValue::Utf8View(opt) => {
            .unwrap();
    }
use std::sync::Arc;
            .unwrap();
        };
        .unwrap();
        let err = run_parse(vec![Some("x")], r"\w+", "regex").unwrap_err();
    Array, ArrayRef, MapBuilder, MapFieldNames, StringArray, StringBuilder,
            return_field: Arc::new(Field::new("out", map_return_type(), true)),
        )
        let err = run_parse(vec![Some("x")], r"(?<x>.)", "grok").unwrap_err();
        // be empty and the downstream INTERNAL_ITEM(parse(...), name) lookup
            arg_types,
    fn coerce_types(&self, arg_types: &[DataType]) -> Result<Vec<DataType>> {
        let arr = match out {
//! command.
            arg_fields: vec![],
            .return_type(&[DataType::Utf8, DataType::Utf8, DataType::Utf8])
        Ok(map_return_type())
        let msg = err.to_string();
// ─── tests ──────────────────────────────────────────────────────────────────
//!     a group that didn't participate in the match) yields `""` for that
    }
            entries_of(&map, 0),
        let udf = ParseUdf::new();
//! `parse(input, pattern_lit, method_lit)` — extract named regex groups into a
        // The Java adapter validates that pattern + method are non-null string
        )
 * this file be licensed under the Apache-2.0 license or a
            // a non-matching row, and a row where the group did not
        assert_eq!(
            return Err(DataFusionError::Plan(format!(
    let key_field = Arc::new(Field::new("key", DataType::Utf8, false));
    fn non_regex_method_is_rejected_with_actionable_message() {
            let captures = if input.is_null(i) {
    ));
        }
            entries_of(&map, 0),
        let dt = udf
    use super::*;
            })?;
    #[test]
        "parse"
}
        // literals at plan time. Re-check defensively so a misuse from an
//!
        let udf = ParseUdf::new();
        false,
            DataFusionError::Plan("parse: pattern must be a non-null string literal".into())
    fn run_parse(input: Vec<Option<&str>>, pattern: &str, method: &str) -> Result<MapArray> {
            ]
    }
        // Collect named groups in pattern definition order so the resulting
/// Arrow `Map<Utf8, Utf8>` field shape returned by this UDF — keys non-null,
        }
        // each input column to StringArray, which only matches the Utf8 representation.
            "regex",
        &self.signature
        // since the shared helper changed to pass-through (preserving the observed variant),
            return plan_err!("parse expects 3 arguments, got {}", arg_types.len());
        let map = run_parse(
pub struct ParseUdf {
                ))
            vec![
//!
        assert_eq!(
            .capture_names()
                ("ip".to_string(), "10.0.0.1".to_string()),
    }
        let regex = Regex::new(&anchored)
    #[test]
            r"ip=(?<ip>\S+) port=(?<port>\d+)",
            .coerce_types(&[
                    "parse: expected Utf8 input, got {:?}",
//!
        assert!(msg.contains("'grok'"), "{msg}");
        let keys = entries
            // itself is never null — see the comment above for why.
            "regex",
        "entries",
            // For each row emit one entry per group_name. A null input row,
                DataFusionError::Internal(format!(
                };
//!     `ParseFunction.parse(null, …)` in core PPL.
        assert_eq!(out, vec![DataType::Utf8, DataType::Utf8, DataType::Utf8]);
}
/*
//! # Division of labor with the Java adapter
            .unwrap();
        // present (never null) and every named group key is there with "".
use datafusion::logical_expr::{
    }
            ])
//!     `grok` / `patterns` aren't on the analytics path yet.
            .map(|i| (keys.value(i).to_string(), values.value(i).to_string()))
impl Default for ParseUdf {
 *
            }),
            ],
    #[test]
            vec![("name".to_string(), "".to_string())]
            vec![
//! `map<varchar, varchar>`. Lowering target for PPL's `parse <field> '<regex>'`
        Ok(arr.as_any().downcast_ref::<MapArray>().unwrap().clone())
        // group is safe — it does not perturb the named-group indexing the
        }
            // wrapping it to ExprStringValue("").
    let entries_field = Arc::new(Field::new(
    }
            } else {
        })?;
impl ScalarUDFImpl for ParseUdf {
        let udf = ParseUdf::new();
            config_options: Arc::new(datafusion::config::ConfigOptions::new()),
            ]
        return None;
                ("ip".to_string(), "".to_string()),
        );
//!   * A SQL NULL input row is treated like a row that didn't match: every
        // we map every accepted string variant down to Utf8 here — invoke_with_args downcasts
            // append(true) closes the map entry for this row. The map cell
                key: "key".to_string(),
//! Plan-time work (Java `ParseAdapter`):
        )
 * The OpenSearch Contributors require contributions made to
//!   * Reject methods other than `regex` with a clear error mentioning
        let out = udf.invoke_with_args(args)?;
/// Pull the string value out of a literal column. Returns None if the column
        assert_eq!(
                None
        );
    }
//!     named group still appears in the map with `""` as its value. Mirrors
            vec![None, Some("name=alice")],
            .collect();
            "regex",
pub fn register_all(ctx: &SessionContext) {
