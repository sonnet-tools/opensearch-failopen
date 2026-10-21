impl Default for ParseUdf {
            vec![("name".to_string(), "".to_string())]
//!   * Reject methods other than `regex` with a clear error mentioning
/// have caught these at plan time but we re-check at runtime.
                };
                None
        assert_eq!(
    fn coerce_types_rejects_non_string_input() {
        let udf = ParseUdf::new();
            // mirrors `extractNamedGroup` returning null and ParseFunction
        }
                key: "key".to_string(),
                ColumnarValue::Scalar(ScalarValue::Utf8(Some(pattern.to_string()))),
        let out = udf
                    "parse: expected Utf8 input, got {:?}",
 * this file be licensed under the Apache-2.0 license or a
 * The OpenSearch Contributors require contributions made to
        let msg = err.to_string();
            };
                builder.values().append_value(value);
    ctx.register_udf(ScalarUDF::from(ParseUdf::new()));
        // present (never null) and every named group key is there with "".
        Ok(validated.into_iter().map(|_| DataType::Utf8).collect())
#[cfg(test)]
            number_rows: n,
                let value = match &captures {
    fn return_type(&self, arg_types: &[DataType]) -> Result<DataType> {
            .column(0)
            vec![None, Some("name=alice")],
            "regex",
    fn return_type_is_map_utf8_utf8() {
    fn coerce_types_normalises_string_variants() {
            let captures = if input.is_null(i) {
            .map(|i| (keys.value(i).to_string(), values.value(i).to_string()))
        if group_names.is_empty() {
pub fn register_all(ctx: &SessionContext) {
        let n = args.number_rows;
    };
    fn return_type_rejects_wrong_arity() {
            return Err(DataFusionError::Plan(format!(
        // Same pattern — the trailing junk means the row should NOT match,
    }
//!     `grok` / `patterns` aren't on the analytics path yet.
        // Collect named groups in pattern definition order so the resulting
//!     named group still appears in the map with `""` as its value. Mirrors
        }
            arg_fields: vec![],
            "parse",
        // coerce_args validates each slot is a string variant (LargeUtf8 / Utf8View / Utf8) but
use std::sync::Arc;
}
pub struct ParseUdf {
//!   * Compile the regex once per call (literal pattern from the adapter), anchor
        assert!(udf.return_type(&[DataType::Utf8, DataType::Utf8]).is_err());
impl ScalarUDFImpl for ParseUdf {
        }
        let pattern = scalar_str(&args.args[1]).ok_or_else(|| {
        let err = run_parse(vec![Some("x")], r"(?<x>.)", "grok").unwrap_err();
        let mut builder = MapBuilder::new(
            vec![
        let input = input_arr
    fn invalid_regex_surfaces_as_plan_error() {
        })?;
    use super::*;
    }
//!     Java's `Matcher.matches()` semantic that PPL's `RegexExpression` relies on.
//!     where `extractNamedGroup` returns null and `ParseFunction` wraps that
    DataType::Map(entries_field, false)
            // wrapping it to ExprStringValue("").
                ("ip".to_string(), "".to_string()),
    fn extracts_named_groups_in_pattern_order() {
//!     `ParseFunction.parse(null, …)` in core PPL.
    }
    }
fn map_return_type() -> DataType {
    fn null_input_emits_empty_values_with_full_schema() {
        }
    }
    Array, ArrayRef, MapBuilder, MapFieldNames, StringArray, StringBuilder,
    use datafusion::arrow::datatypes::TimeUnit;
        (0..entries.len())
        DataType::Struct(vec![key_field, value_field].into()),
        let dt = udf
        assert!(msg.contains("'grok'"), "{msg}");
        let validated = coerce_args(
    }
        // so all named groups are emitted with "".
            config_options: Arc::new(datafusion::config::ConfigOptions::new()),
use datafusion::execution::context::SessionContext;
        let map = run_parse(
            .unwrap();
        let method = scalar_str(&args.args[2]).ok_or_else(|| {
            // a non-matching row, and a row where the group did not
            .unwrap();
/*
        };
            .unwrap_err();
        let input_arr = args.args[0].clone().into_array(n)?;
//!
        _ => None,
            entries_of(&map, 0),
use datafusion::common::{plan_err, ScalarValue};
        );
        }
            // For each row emit one entry per group_name. A null input row,
        .unwrap();
    #[test]
            .downcast_ref::<StringArray>()
 */
        for i in 0..n {
use datafusion::logical_expr::{
            .coerce_types(&[DataType::LargeUtf8, DataType::Utf8View, DataType::Utf8])
            r"name=(?<name>\w+)",
        // be empty and the downstream INTERNAL_ITEM(parse(...), name) lookup
        let input_arr = StringArray::from(input);
        // Anchor pattern so we honour Java's `Matcher.matches()` semantics:
    }
//!     a group that didn't participate in the match) yields `""` for that
            .unwrap();
        false,
                regex.captures(input.value(i))
            arg_types,
        )
 * SPDX-License-Identifier: Apache-2.0
//! `map<varchar, varchar>`. Lowering target for PPL's `parse <field> '<regex>'`
                DataType::Timestamp(TimeUnit::Millisecond, None),
// ─── tests ──────────────────────────────────────────────────────────────────
            )));
            return plan_err!("parse expects 3 arguments, got {}", arg_types.len());
            r"ip=(?<ip>\S+) port=(?<port>\d+)",
//!   * A SQL NULL input row is treated like a row that didn't match: every
            Some(MapFieldNames {
            .downcast_ref::<StringArray>()
    #[test]
            // participate all collapse to "" for that group's value — this
        let group_names: Vec<String> = regex
            .map_err(|e| DataFusionError::Plan(format!("parse: invalid regex [{pattern}]: {e}")))?;
                ))
    #[test]
    }
        Ok(map_return_type())
            vec![
        assert_eq!(out, vec![DataType::Utf8, DataType::Utf8, DataType::Utf8]);
            ]
    }
                ColumnarValue::Array(Arc::new(input_arr)),
        // unknown caller produces an actionable plan error instead of a panic.
        )
        )?;
        .unwrap();
            DataFusionError::Plan("parse: method must be a non-null string literal".into())
        let keys = entries
            return_field: Arc::new(Field::new("out", map_return_type(), true)),
        };
    signature: Signature,
        &self.signature
        );
                ("ip".to_string(), "10.0.0.1".to_string()),
    pub fn new() -> Self {
    #[test]
            entries_of(&map, 0),
/// is non-scalar, a non-string scalar, or a SQL NULL — the adapter is meant to
                DataType::Utf8,
        // since the shared helper changed to pass-through (preserving the observed variant),
//!     to `ExprStringValue("")`.
}
//! Plan-time work (Java `ParseAdapter`):
            for name in &group_names {
        assert_eq!(dt, map_return_type());
    #[test]
                "parse: regex [{pattern}] has no named capture groups",
            signature: Signature::user_defined(Volatility::Immutable),
            .collect();
            "regex",
}
            .capture_names()
                    input_arr.data_type(),
        "entries",
            .as_any()
                builder.keys().append_value(name);
        if args.args.len() != 3 {
}
        // group is safe — it does not perturb the named-group indexing the
        let map = run_parse(
//! # Division of labor with the Java adapter
fn scalar_str(cv: &ColumnarValue) -> Option<String> {
        return None;
        })?;
use datafusion::arrow::array::{
        let udf = ParseUdf::new();
}
    use datafusion::arrow::array::MapArray;
        Ok(arr.as_any().downcast_ref::<MapArray>().unwrap().clone())
        let arr = match out {
    }
            &[CoerceMode::Utf8, CoerceMode::Utf8, CoerceMode::Utf8],
 * compatible open source license.
        let udf = ParseUdf::new();
        let anchored = format!("^(?:{pattern})$");
//!     group's value — same behaviour as the legacy `RegexExpression`
        let udf = ParseUdf::new();
                ("port".to_string(), "443".to_string()),
        // each input column to StringArray, which only matches the Utf8 representation.
//!     named group in pattern definition order. A row that fails to match (or
    let key_field = Arc::new(Field::new("key", DataType::Utf8, false));
            return Err(DataFusionError::Plan(format!(
    #[test]
        ScalarValue::Utf8(opt) | ScalarValue::LargeUtf8(opt) | ScalarValue::Utf8View(opt) => {
        let err = run_parse(vec![Some("x")], r"\w+", "regex").unwrap_err();
        assert_eq!(
        )
    }
    fn invoke_with_args(&self, args: ScalarFunctionArgs) -> Result<ColumnarValue> {
        assert!(err.to_string().contains("invalid regex"));
            args: vec![
            StringBuilder::new(),
            entries_of(&map, 0),
    let entries_field = Arc::new(Field::new(
        "parse"
//! Runtime work (this file):
}
            return plan_err!("parse expects 3 arguments, got {}", args.args.len());
//!     it with `^…$` so the match consumes the entire input — equivalent to
            vec![("name".to_string(), "alice".to_string())]
            DataFusionError::Plan("parse: pattern must be a non-null string literal".into())
            vec![Some("ip=10.0.0.1 port=443")],
    ));
            .collect()
            .return_type(&[DataType::Utf8, DataType::Utf8, DataType::Utf8])
/// Arrow `Map<Utf8, Utf8>` field shape returned by this UDF — keys non-null,
        assert!(!map.is_null(0)); // row 0 cell is present
    fn pattern_without_named_groups_is_rejected() {
    }
}
        assert_eq!(
            .ok_or_else(|| {
            StringBuilder::new(),
            ])
//! command.
            }
        // The Java adapter validates that pattern + method are non-null string
            builder.append(true)?;
            )));
                entry: "entries".to_string(),
}
    fn whole_string_anchoring_is_enforced() {
        let n = input.len();
            "regex",
        let values = entries
                    Some(c) => c.name(name).map(|m| m.as_str()).unwrap_or(""),
    }
        .unwrap();
use datafusion::error::{DataFusionError, Result};
    #[test]
        if method != "regex" {
        // PPL parse without named groups is a user error: the result map would
        let err = run_parse(vec![Some("x")], r"(?<x>[unbalanced", "regex").unwrap_err();
    let ColumnarValue::Scalar(sv) = cv else {
            })?;
        Ok(ColumnarValue::Array(Arc::new(builder.finish()) as ArrayRef))
};
        let entries = map.value(row);
    #[test]
    #[test]
            }),
                DataFusionError::Internal(format!(
        // Mirrors ParseFunction.parse(null, …) in core PPL — the map cell is
                DataType::Utf8,
//!
        }
    fn non_regex_method_is_rejected_with_actionable_message() {
        );
        let out = udf.invoke_with_args(args)?;
        assert!(err.to_string().contains("no named capture groups"));
            _ => panic!("expected array"),
            .column(1)
        // literals at plan time. Re-check defensively so a misuse from an
            .as_any()
    let value_field = Arc::new(Field::new("value", DataType::Utf8, true));
                 only 'regex' is currently supported (use 'grok' / 'patterns' on the legacy engine)",
    fn entries_of(map: &MapArray, row: usize) -> Vec<(String, String)> {
            ]
//!   * For every input row, populate a `map<utf8, utf8>` with one entry per
        // we map every accepted string variant down to Utf8 here — invoke_with_args downcasts
    #[test]
    }
        assert_eq!(
        // map's key order matches what users see in legacy PPL output.
        Self::new()
            ColumnarValue::Array(a) => a,
        // the match must consume the entire input. Wrapping in a non-capturing
//!
            // itself is never null — see the comment above for why.
/// Pull the string value out of a literal column. Returns None if the column
impl ParseUdf {
        // caller relies on.
        Self {
        );
                ColumnarValue::Scalar(ScalarValue::Utf8(Some(method.to_string()))),
                    None => "",
            } else {
mod tests {
#[derive(Debug, PartialEq, Eq, Hash)]
        );
            vec![Some("ip=10.0.0.1 port=443 trailing-junk")],
    }
        }
                ("port".to_string(), "".to_string()),
};
    ColumnarValue, ScalarFunctionArgs, ScalarUDF, ScalarUDFImpl, Signature, Volatility,
            .coerce_types(&[
    fn signature(&self) -> &Signature {
            r"ip=(?<ip>\S+) port=(?<port>\d+)",
        let err = udf
    match sv {
        if arg_types.len() != 3 {
        assert!(msg.contains("'regex'"), "{msg}");
        // would always return NULL. Fail loudly at plan time.
        let args = ScalarFunctionArgs {
            opt.clone()
    fn run_parse(input: Vec<Option<&str>>, pattern: &str, method: &str) -> Result<MapArray> {
            .downcast_ref::<StringArray>()
    }
        let map = run_parse(
            .unwrap();
    fn coerce_types(&self, arg_types: &[DataType]) -> Result<Vec<DataType>> {
    }
 *
    fn default() -> Self {
    }
        assert!(err.to_string().contains("expected string"));
/// values nullable. Constructed once per call rather than per row.
            // append(true) closes the map entry for this row. The map cell
            entries_of(&map, 1),
//! `parse(input, pattern_lit, method_lit)` — extract named regex groups into a
    }
use super::{coerce_args, CoerceMode};
//!     pattern or method makes no sense for parse and is rejected up front.
    fn name(&self) -> &str {
//!   * Verify `pattern` and `method` operands are string literals — column-valued
        let regex = Regex::new(&anchored)
        let udf = ParseUdf::new();
    }
            .as_any()
use regex::Regex;
            .filter_map(|name| name.map(String::from))
                "parse: method '{method}' is not supported by the analytics engine; \
use datafusion::arrow::datatypes::{DataType, Field};
            ],
                value: "value".to_string(),
