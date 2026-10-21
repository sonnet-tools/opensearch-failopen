// ─── tests ──────────────────────────────────────────────────────────────────
/// `%{NAME=definition}` reference matcher — ported from
//! `grok <field> '<grok-pattern>'` command, the grok-syntax sibling of `parse`.
}
                None
//!     values are quote-stripped via `clean_string`, matching `Match.cleanString`.
        // The Java adapter validates pattern + method are non-null string
        );
            return Err(DataFusionError::Plan(format!(
    /// Read row `i` of a MapArray into a (key,value) vec for assertions.
                    .regex
    let first = chars[0];
                    .map_err(|e| DataFusionError::Execution(format!("grok: match failed: {e}")))?
        return value.to_string();
                ColumnarValue::Scalar(ScalarValue::Utf8(Some("grok".to_string()))),
//!
            }),
                    "grok: no definition for key '{pattern_name}' found, aborting"
/// value, but only when the quote char does not also appear in the interior —
use datafusion::error::{DataFusionError, Result};
static GROK_DICTIONARY: &str = include_str!("grok_patterns.txt");
//!      uses `fancy-regex` instead, whose backtracking engine supports the full
        }
    ColumnarValue, ScalarFunctionArgs, ScalarUDF, ScalarUDFImpl, Signature, Volatility,
        let n = args.number_rows;
//! grok pattern into a `map<varchar, varchar>`. Lowering target for PPL's
 * The OpenSearch Contributors require contributions made to
        _ => None,
/// non-scalar, a non-string scalar, or a SQL NULL — the adapter is meant to have
        )
        regex,
        let line = "177.95.8.74 - upton5450 [28/Sep/2022:10:15:57 -0700] \"HEAD /e-business/mindshare HTTP/1.0\" 404 19927";
            "grok",
    fields
                        None => String::new(),
        if fields.iter().any(|(f, _)| f == field) {
            config_options: Arc::new(datafusion::config::ConfigOptions::new()),
        iterations_left -= 1;
    }
//!   2. **Regex features.** The resolved patterns use lookbehind `(?<!…)`,
        // literals and gates method == "grok" at plan time. Re-check defensively
        let trimmed = line.trim();
        }
        );
                    .captures(input.value(i))
        }
//!      java.util.regex feature set grok relies on.
}
            // Unanchored find (Java grok's Matcher.find). A null input row, a row
    Regex::new(
/// `%{NAME}`, `%{NAME:subname}`, `%{NAME:subname:type}`, and inline
    collection: HashMap<String, String>,
        if field == "UNWANTED" {
        if !group_order.contains(&g) {
        let token = format!("%{{{name}}}");
/// Ported from `GrokCompiler.compile(pattern, ...)`.
                ColumnarValue::Scalar(ScalarValue::Utf8(Some(pattern.to_string()))),
            .find(|(k, _)| k == key)
        if !interior.contains(&first) {
        Ok(arr.as_any().downcast_ref::<MapArray>().unwrap().clone())
                ))
        }
        Ok(map_return_type())
//!
    defs
    DataType::Map(entries_field, false)
use super::{coerce_args, CoerceMode};
            let name = trimmed[..idx].to_string();
    #[test]
    fn name(&self) -> &str {
    }
        }
            number_rows: n,
            .into_iter()
        fields.push((field.clone(), group.clone()));
/// in literally (no regex/`$` interpretation), matching the Java behaviour.
impl ScalarUDFImpl for GrokUdf {
        // so a misuse from an unknown caller produces an actionable plan error.
            opt.clone()
}
        if args.args.len() != 3 {
 *
    }
            out.push_str(&s[..pos]);
//! # Why grok needs its own UDF rather than reusing `parse`
                entry: "entries".to_string(),
use datafusion::common::{plan_err, ScalarValue};
        false,
    // semantics: insertion order, deduped) — mirrors GrokUtils.getNameGroups.
fn map_return_type() -> DataType {
    let mut collection: HashMap<String, String> = HashMap::new();
            .collect()
            };
    fn clean_string_strips_balanced_quotes() {
//! `parse` takes a raw regex; grok takes grok syntax (`%{HOSTNAME:host}`). Two
use regex::Regex;
            vec![Some("880 Holmes Lane")],
            DataFusionError::Plan("grok: method must be a non-null string literal".into())
    /// matching `GrokUtils.getNameGroups` (a `LinkedHashSet`).
//! Plan-time work (Java `GrokAdapter`):
        let map = run_grok(vec![Some(line)], "%{COMMONAPACHELOG}").unwrap();
    let key_field = Arc::new(Field::new("key", DataType::Utf8, false));
                    None => String::new(),
        if arg_types.len() != 3 {
}
                    input_arr.data_type(),
        group_order,
    }
fn clean_string(value: &str) -> String {
    }
            name = format!("{name}={def}");
impl GrokUdf {
//!     contrast to `parse`'s anchored `^…$`.
    match sv {
    ));
            arg_fields: vec![],
        None => s.to_string(),
    }
    Ok(ResolvedGrok {
/// A grok pattern resolved to a concrete regex plus the synthetic-group → field
/// Literal single-occurrence string replacement — equivalent to
        )
        let entries = map.value(i);
        // contract as parse's coerce_types.
            collection.insert(
            .as_any()
        }
            out.push_str(&s[pos + token.len()..]);
                "grok: method '{method}' is not supported by this UDF; expected 'grok'"
    for group in &resolved.group_order {
//! (`GrokCompiler` + `Grok` + `Match` + `GrokExpression`):
                // error (e.g. backtrack-limit) surfaces as a DataFusion error
        assert_eq!(value_for(&map, 0, "host").as_deref(), Some("pyrami.com"));
    let value_field = Arc::new(Field::new("value", DataType::Utf8, true));
    use super::*;
/// Resolve a grok pattern to a `fancy-regex` plus its group→field mapping.
        &self.signature
            Some(f) => f,
    let entries_field = Arc::new(Field::new(
        // Validate each slot is a string variant, then map down to Utf8:
        assert_eq!(
/// `GrokCompiler.registerDefaultPatterns`).
        let validated = coerce_args(
    // Local copy so inline `%{NAME=definition}` defs don't leak across calls.
        for i in 0..n {
        let g = caps.get(1).unwrap().as_str().to_string();
    #[test]
        let map = run_grok(vec![Some("amberduke@pyrami.com")], ".+@%{HOSTNAME:host}").unwrap();
        let map = run_grok(
            defs.insert(name, definition);
        // GrokCompiler.register's `^(\w+)\s+(.*)$` line parser.
//!     distinct user-facing field name (the `%{NAME:field}` subname; `UNWANTED`
            None => break,
//!
        let pattern = scalar_str(&args.args[1]).ok_or_else(|| {
/// Strip a matching pair of surrounding single/double quotes from a captured
    fn unwanted_groups_are_dropped() {
    })?;
        let definition = caps.name("definition").map(|m| m.as_str().to_string());
                    },
    let last = chars[chars.len() - 1];
            let definition_of_pattern = pattern_defs.get(&pattern_name).ok_or_else(|| {
    #[test]
    fn number_greedydata_with_lookbehind_and_atomic_group() {
            .column(0)
        }
        )?;
    }
        };
            return plan_err!("grok: deep recursion pattern compilation of [{pattern}]");
});
fn scalar_str(cv: &ColumnarValue) -> Option<String> {
 * this file be licensed under the Apache-2.0 license or a
//!   * For every input row, populate a `map<utf8, utf8>` with one entry per
                // fancy-regex returns Result<Option<Captures>>; a runtime regex
        let field = match resolved.collection.get(group) {
        if trimmed.is_empty() || trimmed.starts_with('#') {
use std::sync::Arc;
        assert_eq!(value_for(&map, 0, "response").as_deref(), Some("404"));
//!     row that does not match, or a SQL NULL input — yields `""`, mirroring
    let mut index: usize = 0;
    for caps in NAMED_GROUP.captures_iter(&named_regex) {
            for (field, group) in &fields {
/// Arrow `Map<Utf8, Utf8>` field shape returned by this UDF — keys non-null,
    use datafusion::arrow::array::MapArray;
        assert_eq!(clean_string("\"\""), "");
}
            ],
            .map(|j| (keys.value(j).to_string(), values.value(j).to_string()))
    loop {
        }
        }
            );
        }
        let udf = GrokUdf::new();
            arg_types,
fn output_fields(resolved: &ResolvedGrok) -> Vec<(String, String)> {
            &[CoerceMode::Utf8, CoerceMode::Utf8, CoerceMode::Utf8],
    fn return_type(&self, arg_types: &[DataType]) -> Result<DataType> {
    #[test]
        let keys: Vec<String> = row_entries(&map, 0).into_iter().map(|(k, _)| k).collect();
            vec![Some("880 Holmes Lane")],
        DataFusionError::Plan(format!("grok: invalid resolved regex for [{pattern}]: {e}"))
    }
        .unwrap();
    fn hostname_extraction_matches_legacy() {
    if named_regex.is_empty() {
pub fn register_all(ctx: &SessionContext) {
    fn commonapachelog_named_fields() {
    }
            Some(c) => c,
    let mut fields: Vec<(String, String)> = Vec::new();
    let chars: Vec<char> = value.chars().collect();
            continue;
        assert_eq!(value_for(&map, 0, "host").as_deref(), Some(""));
//!     `GrokExpression.parseValue` returning `ExprStringValue("")`. Captured
/// SQL plugin's `common/src/main/resources/patterns/patterns` (loaded there via
    if value.is_empty() {
static DICTIONARY: LazyLock<HashMap<String, String>> = LazyLock::new(|| {
    regex: FancyRegex,
        assert_eq!(
        DataType::Struct(vec![key_field, value_field].into()),
            .downcast_ref::<StringArray>()
//!   * Match **unanchored** — grok uses `Matcher.find()` (substring match), in
        let fields = output_fields(&resolved);
        Some(pos) => {
        collection,
use std::collections::HashMap;
        }
});
    fn signature(&self) -> &Signature {
/// Default grok pattern dictionary — forked from logstash, identical to the
        }
    .expect("GROK_REFERENCE is a valid regex")
}
            continue; // first synthetic group for a field wins, like Match.capture
        // GROK_REFERENCE never uses fancy features, so this find is infallible.
    let regex = FancyRegex::new(&named_regex).map_err(|e| {
            let captures = if input.is_null(i) {
    fn run_grok(input: Vec<Option<&str>>, pattern: &str) -> Result<MapArray> {
            .ok_or_else(|| {
    }
            pattern_defs.insert(pattern_name.clone(), def.clone());
                ColumnarValue::Array(Arc::new(input_arr)),
                    "grok: expected Utf8 input, got {:?}",
/// Ordered, deduped list of user-facing output field names for a resolved grok
        Ok(validated.into_iter().map(|_| DataType::Utf8).collect())
    pub fn new() -> Self {
        Self {
            .downcast_ref::<StringArray>()
            .unwrap();
        })?;
            // GrokExpression.parseValue returning ExprStringValue("").
#[cfg(test)]
/// caught these at plan time but we re-check at runtime.
        // `NAME definition` — split on the first run of whitespace, exactly like
//!      be recursively expanded against a pattern dictionary before matching. The
        "entries",
        let args = ScalarFunctionArgs {
    value.to_string()
            group_order.push(g);
        let arr = out.into_array(n)?;
//!      `GrokCompiler.compile`.
            args: vec![
use fancy_regex::Regex as FancyRegex;
            }
mod tests {
    }
    /// The named groups in the order they appear in the resolved regex, deduped,
        let input = input_arr
            .unwrap();
        let input_arr = args.args[0].clone().into_array(n)?;
/*
        for _ in 0..count {
//!   * Verify `pattern` and `method` operands are non-null string literals.
//!
        let map = run_grok(vec![None, Some("no-at-sign-here")], ".+@%{HOSTNAME:host}").unwrap();
        // testGrokEmail: ".+@%{HOSTNAME:host}" against an email.
            builder.append(true)?;
    }
    let mut pattern_defs = DICTIONARY.clone();
            "%{NUMBER} %{GREEDYDATA:address}",
            "%{NUMBER} %{GREEDYDATA:address}",
}
/// `GrokUtils.GROK_PATTERN`. No lookaround/atomic features, so the linear
        return None;
    }
            .downcast_ref::<StringArray>()
    let ColumnarValue::Scalar(sv) = cv else {
        // Output keys in pattern (group) order; deduped; UNWANTED dropped.
            Some(MapFieldNames {
        let n = input.len();
//!     groups are dropped). A field whose group did not participate — and any
//!   * Require `method == "grok"`.
//!     pattern), recording the synthetic-group → field-name map.
/// values nullable. Identical to `parse`'s output shape so `ITEM` binds the same.
        };
        let resolved = resolve_grok(&pattern)?;
});
                key: "key".to_string(),
    Regex::new(r"\(\?<([a-zA-Z][a-zA-Z0-9]*)>").expect("NAMED_GROUP is a valid regex")
//! consequences force a separate implementation:
    let mut group_order: Vec<String> = Vec::new();
        };
            return_field: Arc::new(Field::new("out", map_return_type(), true)),
    }
        let mut builder = MapBuilder::new(
        }
            None => continue,
    }
        Self::new()
}
        if chars.len() <= 2 {
    fn non_matching_and_null_rows_yield_empty_strings() {
/// Matches the synthetic `(?<nameN>` capture-group openers in a resolved grok
/// Parsed dictionary: pattern name → definition. Built once.
    let mut defs = HashMap::new();
struct ResolvedGrok {
        let input_arr = StringArray::from(input);
            // all collapse to "" for that field — mirroring
 * SPDX-License-Identifier: Apache-2.0
            let replacement = format!("(?<name{index}>{definition_of_pattern})");
            .column(1)
    let mut named_regex = pattern.to_string();
use datafusion::logical_expr::{
        "grok"
                value: "value".to_string(),
        }
    fn row_entries(map: &MapArray, i: usize) -> Vec<(String, String)> {
            let definition = trimmed[idx..].trim_start().to_string();
        }
};
            // that does not match anywhere, and a group that did not participate
        (0..keys.len())
        // BASE10NUM uses lookbehind + atomic group (regex crate would reject).
    /// `name0` → user field name (`host`, `UNWANTED`, or the pattern name when
        assert!(!keys.contains(&"UNWANTED".to_string()));
                    Some(c) => match c.name(group) {
use datafusion::execution::context::SessionContext;
};
        let map = run_grok(
//!      ships) and the resolution algorithm are ported here verbatim from
    })
//! # Division of labor with the Java adapter
/// mapping needed to key the output map.
            index += 1;
            Some("Holmes Lane")
                resolved
            .map(|(_, v)| v)
        // invoke_with_args downcasts the input column to StringArray. Same
fn resolve_grok(pattern: &str) -> Result<ResolvedGrok> {
static GROK_REFERENCE: LazyLock<Regex> = LazyLock::new(|| {
 */
                let value = match &captures {
        let values = entries
//!   * Resolve the grok pattern to a `fancy-regex` once per call (literal
            signature: Signature::user_defined(Volatility::Immutable),
                // rather than a silent miss.
        let method = scalar_str(&args.args[2]).ok_or_else(|| {
 * compatible open source license.
    };
    }
        }
    if first == last && (first == '"' || first == '\'') {
    #[test]
        ScalarValue::Utf8(opt) | ScalarValue::LargeUtf8(opt) | ScalarValue::Utf8View(opt) => {
            let mut out = String::with_capacity(s.len() - token.len() + replacement.len());
        assert_eq!(clean_string("'bar'"), "bar");
    }
        // testGrokApacheLog: COMMONAPACHELOG → timestamp + response extraction.
//!
impl Default for GrokUdf {
/// `regex` crate is used (avoids backtracking on the meta-pattern).
//!      OpenSearch core's classpath, so the 108-line default dictionary
    if pattern.trim().is_empty() {
            value_for(&map, 0, "timestamp").as_deref(),
            out
use datafusion::arrow::datatypes::{DataType, Field};
}
            value_for(&map, 0, "address").as_deref(),
/// `StringUtils.replace(s, token, replacement, 1)`. The replacement is spliced
        return plan_err!("grok: pattern not found in [{pattern}]");
    /// no subname was given), as produced by `GrokCompiler.compile`.
    match s.find(token) {
            return plan_err!("grok expects 3 arguments, got {}", arg_types.len());
                DataFusionError::Internal(format!(
                builder.keys().append_value(field);
    }
            continue;
            StringBuilder::new(),
    }
        if method != "grok" {
    #[test]
static NAMED_GROUP: LazyLock<Regex> = LazyLock::new(|| {
    }
            named_regex = replace_first(&named_regex, &token, &replacement);
use datafusion::arrow::array::{
    for line in GROK_DICTIONARY.lines() {
//!   1. **Dictionary resolution.** Grok references like `%{COMMONAPACHELOG}` must
/// composed with `Match.capture`'s first-wins-per-key map.
/// pattern (drops `UNWANTED`) — mirrors `GrokExpression.getNamedGroupCandidates`
        let pattern_name = caps.name("pattern").unwrap().as_str().to_string();
}
    }
        // NUMBER has no subname → UNWANTED → must not appear as an output key.
        r"%\{(?<name>(?<pattern>[a-zA-Z0-9_]+)(?::(?<subname>[a-zA-Z0-9_:;,\-/\s.']+))?)(?:=(?<definition>(?:(?:[^{}]+|\.+)+)+))?\}",
        );
    }
/// Pull the string value out of a literal column. Returns None if the column is
/// for output, mirroring `GrokUtils.getNameGroups`.
        // testGrokAddressOverriding: "%{NUMBER} %{GREEDYDATA:address}" — NUMBER →
            Some("28/Sep/2022:10:15:57 -0700")
}
    }
        Ok(ColumnarValue::Array(Arc::new(builder.finish()) as ArrayRef))
        assert!(keys.contains(&"address".to_string()));
    signature: Signature,
        let interior = &chars[1..chars.len() - 1];
    }
}
//!      (`grok_patterns.txt`, forked from logstash, same file the SQL plugin
                format!("name{index}"),
fn replace_first(s: &str, token: &str, replacement: &str) -> String {
    }
        .unwrap();
            .as_any()
            DataFusionError::Plan("grok: pattern must be a non-null string literal".into())
    fn coerce_types(&self, arg_types: &[DataType]) -> Result<Vec<DataType>> {
/// regex — ported from `GrokUtils.NAMED_REGEX`. Used to recover the group order
//! `grok(input, grok_pattern_lit, method_lit)` — extract named groups from a
    fn invoke_with_args(&self, args: ScalarFunctionArgs) -> Result<ColumnarValue> {
            })?;
    Array, ArrayRef, MapBuilder, MapFieldNames, StringArray, StringBuilder,
        }
        if let Some(idx) = trimmed.find(char::is_whitespace) {
        let out = udf.invoke_with_args(args)?;
        })?;
        if let Some(def) = &definition {
    }
                ))
    )
    fn default() -> Self {
//!      that the RE2-based `regex` crate backing `parse` cannot compile. Matching
                DataFusionError::Plan(format!(
        let count = named_regex.matches(&token).count();
//!      lookahead `(?!…)` and atomic groups `(?>…)` (e.g. `BASE10NUM`, `IPV4`)
        let keys = entries
                };
/// ported from `Match.cleanString`.
            out.push_str(replacement);
        assert_eq!(value_for(&map, 1, "host").as_deref(), Some(""));
            .as_any()
                builder.values().append_value(value);
                subname.clone().unwrap_or_else(|| pattern_name.clone()),
        assert_eq!(clean_string("plain"), "plain");
            return plan_err!("grok expects 3 arguments, got {}", args.args.len());
#[derive(Debug, PartialEq, Eq, Hash)]
//!
        return plan_err!("grok: pattern should not be empty or null");
            })?;
        if iterations_left <= 0 {
                        Some(m) => clean_string(m.as_str()),
//!      SQL plugin's grok library (`org.opensearch.sql.common.grok`) is not on
pub struct GrokUdf {
            return String::new();
    let mut iterations_left = 1000;
        let caps = match GROK_REFERENCE.captures(&named_regex) {
    // Recover the named-group order from the resolved regex (LinkedHashSet
        assert_eq!(clean_string("\"a\"b\""), "\"a\"b\""); // interior quote → untouched
            StringBuilder::new(),
        let mut name = caps.name("name").unwrap().as_str().to_string();
}
            return interior.iter().collect();
    group_order: Vec<String>,
//! Runtime work (this file), mirroring the SQL plugin's grok semantics
            } else {
    fn value_for(map: &MapArray, i: usize, key: &str) -> Option<String> {
use std::sync::LazyLock;
            )));
        let subname = caps.name("subname").map(|m| m.as_str().to_string());
        row_entries(map, i)
    ctx.register_udf(ScalarUDF::from(GrokUdf::new()));
        assert_eq!(clean_string("\"foo\""), "foo");
