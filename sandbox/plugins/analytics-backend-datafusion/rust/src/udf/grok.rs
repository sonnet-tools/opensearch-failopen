            vec![Some("880 Holmes Lane")],
    ctx.register_udf(ScalarUDF::from(GrokUdf::new()));
//!     row that does not match, or a SQL NULL input — yields `""`, mirroring
#[cfg(test)]
        let n = input.len();
    for line in GROK_DICTIONARY.lines() {
                DataFusionError::Internal(format!(
        }
        // BASE10NUM uses lookbehind + atomic group (regex crate would reject).
        // The Java adapter validates pattern + method are non-null string
//!   * Require `method == "grok"`.
use datafusion::error::{DataFusionError, Result};
            .as_any()
    })?;
        "grok"
            .collect()
    }
                    "grok: no definition for key '{pattern_name}' found, aborting"
    match sv {
        let validated = coerce_args(
            Some("Holmes Lane")
    for caps in NAMED_GROUP.captures_iter(&named_regex) {
/// for output, mirroring `GrokUtils.getNameGroups`.
            value_for(&map, 0, "address").as_deref(),
        collection,
    /// The named groups in the order they appear in the resolved regex, deduped,
use datafusion::logical_expr::{
            DataFusionError::Plan("grok: method must be a non-null string literal".into())
            out.push_str(&s[pos + token.len()..]);
                let value = match &captures {
//!   * Verify `pattern` and `method` operands are non-null string literals.
            .map(|j| (keys.value(j).to_string(), values.value(j).to_string()))
        r"%\{(?<name>(?<pattern>[a-zA-Z0-9_]+)(?::(?<subname>[a-zA-Z0-9_:;,\-/\s.']+))?)(?:=(?<definition>(?:(?:[^{}]+|\.+)+)+))?\}",
            arg_fields: vec![],
                builder.values().append_value(value);
//!   1. **Dictionary resolution.** Grok references like `%{COMMONAPACHELOG}` must
        let count = named_regex.matches(&token).count();
        let subname = caps.name("subname").map(|m| m.as_str().to_string());
/// Default grok pattern dictionary — forked from logstash, identical to the
    }
        }
        for i in 0..n {
//!   * Resolve the grok pattern to a `fancy-regex` once per call (literal
        }
        let arr = out.into_array(n)?;
//!     groups are dropped). A field whose group did not participate — and any
/// pattern (drops `UNWANTED`) — mirrors `GrokExpression.getNamedGroupCandidates`
    if pattern.trim().is_empty() {
        (0..keys.len())
/// composed with `Match.capture`'s first-wins-per-key map.
            vec![Some("880 Holmes Lane")],
struct ResolvedGrok {
        Ok(ColumnarValue::Array(Arc::new(builder.finish()) as ArrayRef))
    #[test]
        let values = entries
    let value_field = Arc::new(Field::new("value", DataType::Utf8, true));
    regex: FancyRegex,
/// A grok pattern resolved to a concrete regex plus the synthetic-group → field
        Self::new()
        let input = input_arr
        // NUMBER has no subname → UNWANTED → must not appear as an output key.
            out
            return interior.iter().collect();
        );
    pub fn new() -> Self {
                builder.keys().append_value(field);
        }
            for (field, group) in &fields {
            }),
            .unwrap();
    ColumnarValue, ScalarFunctionArgs, ScalarUDF, ScalarUDFImpl, Signature, Volatility,
            // GrokExpression.parseValue returning ExprStringValue("").
            arg_types,
/// `regex` crate is used (avoids backtracking on the meta-pattern).
//! Plan-time work (Java `GrokAdapter`):
    if first == last && (first == '"' || first == '\'') {
        })?;
    if named_regex.is_empty() {
        // testGrokAddressOverriding: "%{NUMBER} %{GREEDYDATA:address}" — NUMBER →
        assert_eq!(value_for(&map, 0, "response").as_deref(), Some("404"));
        let n = args.number_rows;
});
        if let Some(def) = &definition {
    }
        let map = run_grok(
/// `%{NAME=definition}` reference matcher — ported from
    ));
    #[test]
 *
        let token = format!("%{{{name}}}");
/// non-scalar, a non-string scalar, or a SQL NULL — the adapter is meant to have
    }
 * The OpenSearch Contributors require contributions made to
    let mut defs = HashMap::new();
fn resolve_grok(pattern: &str) -> Result<ResolvedGrok> {
                // error (e.g. backtrack-limit) surfaces as a DataFusion error
    /// matching `GrokUtils.getNameGroups` (a `LinkedHashSet`).
            Some(MapFieldNames {
    collection: HashMap<String, String>,
        if iterations_left <= 0 {
            // all collapse to "" for that field — mirroring
        )?;
    fn hostname_extraction_matches_legacy() {
    value.to_string()
use super::{coerce_args, CoerceMode};
fn clean_string(value: &str) -> String {
        .unwrap();
            // Unanchored find (Java grok's Matcher.find). A null input row, a row
        }
        let out = udf.invoke_with_args(args)?;
        .unwrap();
        let fields = output_fields(&resolved);
            .column(1)
        };
            .map(|(_, v)| v)
                        None => String::new(),
            }
//!     contrast to `parse`'s anchored `^…$`.
//!      SQL plugin's grok library (`org.opensearch.sql.common.grok`) is not on
        )
    }
        if !group_order.contains(&g) {
        Ok(map_return_type())
            })?;
    )
            signature: Signature::user_defined(Volatility::Immutable),
            continue;
                ColumnarValue::Scalar(ScalarValue::Utf8(Some(pattern.to_string()))),
        }
    };
    }
            value_for(&map, 0, "timestamp").as_deref(),
}
            let captures = if input.is_null(i) {
            continue; // first synthetic group for a field wins, like Match.capture
//!     values are quote-stripped via `clean_string`, matching `Match.cleanString`.
        }
    let mut fields: Vec<(String, String)> = Vec::new();
        let pattern = scalar_str(&args.args[1]).ok_or_else(|| {
    }
        if method != "grok" {
    fn return_type(&self, arg_types: &[DataType]) -> Result<DataType> {
    /// no subname was given), as produced by `GrokCompiler.compile`.
                };
            index += 1;
    let mut iterations_left = 1000;
});
#[derive(Debug, PartialEq, Eq, Hash)]
static NAMED_GROUP: LazyLock<Regex> = LazyLock::new(|| {
//! (`GrokCompiler` + `Grok` + `Match` + `GrokExpression`):
            )));
//!
    let chars: Vec<char> = value.chars().collect();
        assert_eq!(value_for(&map, 0, "host").as_deref(), Some("pyrami.com"));
use datafusion::arrow::array::{
            collection.insert(
            return plan_err!("grok expects 3 arguments, got {}", args.args.len());
//!     pattern), recording the synthetic-group → field-name map.
        let mut builder = MapBuilder::new(
            .ok_or_else(|| {
    use datafusion::arrow::array::MapArray;
        let resolved = resolve_grok(&pattern)?;
            None => continue,
//!
        // GrokCompiler.register's `^(\w+)\s+(.*)$` line parser.
    }
use regex::Regex;
        // Output keys in pattern (group) order; deduped; UNWANTED dropped.
            return String::new();
        let keys = entries
//!   * Match **unanchored** — grok uses `Matcher.find()` (substring match), in
                    .captures(input.value(i))
    }
            args: vec![
    }
/// values nullable. Identical to `parse`'s output shape so `ITEM` binds the same.
}
//!
/// `GrokCompiler.registerDefaultPatterns`).
        if field == "UNWANTED" {
                ))
        }
            Some(f) => f,
        let field = match resolved.collection.get(group) {
//!   * For every input row, populate a `map<utf8, utf8>` with one entry per
        if !interior.contains(&first) {
                None
}
        DataFusionError::Plan(format!("grok: invalid resolved regex for [{pattern}]: {e}"))
    }
    if value.is_empty() {
}
                    None => String::new(),
        let udf = GrokUdf::new();
/// Ordered, deduped list of user-facing output field names for a resolved grok
    let mut collection: HashMap<String, String> = HashMap::new();
            let definition_of_pattern = pattern_defs.get(&pattern_name).ok_or_else(|| {
 * this file be licensed under the Apache-2.0 license or a
//!      that the RE2-based `regex` crate backing `parse` cannot compile. Matching
}
fn replace_first(s: &str, token: &str, replacement: &str) -> String {
    DataType::Map(entries_field, false)
        };
        let input_arr = args.args[0].clone().into_array(n)?;
    }
            opt.clone()
    // Local copy so inline `%{NAME=definition}` defs don't leak across calls.
}
//!
            "%{NUMBER} %{GREEDYDATA:address}",
            .find(|(k, _)| k == key)
use std::sync::LazyLock;
        if trimmed.is_empty() || trimmed.starts_with('#') {
        let entries = map.value(i);
});
                // rather than a silent miss.
/// `%{NAME}`, `%{NAME:subname}`, `%{NAME:subname:type}`, and inline
        fields.push((field.clone(), group.clone()));
    #[test]
                    "grok: expected Utf8 input, got {:?}",
}
        Ok(validated.into_iter().map(|_| DataType::Utf8).collect())
/// caught these at plan time but we re-check at runtime.
            None => break,
        let map = run_grok(
/// Ported from `GrokCompiler.compile(pattern, ...)`.
    .expect("GROK_REFERENCE is a valid regex")
                format!("name{index}"),
            .downcast_ref::<StringArray>()
            .as_any()
//! `grok(input, grok_pattern_lit, method_lit)` — extract named groups from a
        // contract as parse's coerce_types.
                    input_arr.data_type(),
 * compatible open source license.
        assert_eq!(clean_string("\"a\"b\""), "\"a\"b\""); // interior quote → untouched
/// Strip a matching pair of surrounding single/double quotes from a captured
    defs
        let definition = caps.name("definition").map(|m| m.as_str().to_string());
    fn run_grok(input: Vec<Option<&str>>, pattern: &str) -> Result<MapArray> {
            DataFusionError::Plan("grok: pattern must be a non-null string literal".into())
fn map_return_type() -> DataType {
        assert_eq!(clean_string("plain"), "plain");
                    },
    }
            .into_iter()
            out.push_str(&s[..pos]);
        if chars.len() <= 2 {
        if fields.iter().any(|(f, _)| f == field) {
        _ => None,
}
            out.push_str(replacement);
// ─── tests ──────────────────────────────────────────────────────────────────
        // testGrokEmail: ".+@%{HOSTNAME:host}" against an email.
        );
        Some(pos) => {
    let mut index: usize = 0;
/// Literal single-occurrence string replacement — equivalent to
    let key_field = Arc::new(Field::new("key", DataType::Utf8, false));
    let entries_field = Arc::new(Field::new(
        assert_eq!(clean_string("\"\""), "");
    Ok(ResolvedGrok {
        "entries",
        };
use datafusion::common::{plan_err, ScalarValue};
/// SQL plugin's `common/src/main/resources/patterns/patterns` (loaded there via
        assert!(!keys.contains(&"UNWANTED".to_string()));
    // Recover the named-group order from the resolved regex (LinkedHashSet
}
                        Some(m) => clean_string(m.as_str()),
    }
pub struct GrokUdf {
            Some("28/Sep/2022:10:15:57 -0700")
    }
                value: "value".to_string(),
            return plan_err!("grok: deep recursion pattern compilation of [{pattern}]");
//! grok pattern into a `map<varchar, varchar>`. Lowering target for PPL's
}
    fn default() -> Self {
    })
/// Parsed dictionary: pattern name → definition. Built once.
        assert_eq!(clean_string("'bar'"), "bar");
            &[CoerceMode::Utf8, CoerceMode::Utf8, CoerceMode::Utf8],
    }
    // semantics: insertion order, deduped) — mirrors GrokUtils.getNameGroups.
                "grok: method '{method}' is not supported by this UDF; expected 'grok'"
//!      (`grok_patterns.txt`, forked from logstash, same file the SQL plugin
            named_regex = replace_first(&named_regex, &token, &replacement);
//!      java.util.regex feature set grok relies on.
            } else {
                ))
    fn signature(&self) -> &Signature {
        let trimmed = line.trim();
        assert_eq!(
            .as_any()
        }
static GROK_DICTIONARY: &str = include_str!("grok_patterns.txt");
        // testGrokApacheLog: COMMONAPACHELOG → timestamp + response extraction.
};
//!      `GrokCompiler.compile`.
                    Some(c) => match c.name(group) {
use datafusion::arrow::datatypes::{DataType, Field};
        assert_eq!(value_for(&map, 0, "host").as_deref(), Some(""));
        assert_eq!(
//! `grok <field> '<grok-pattern>'` command, the grok-syntax sibling of `parse`.
    }
use fancy_regex::Regex as FancyRegex;
//!      uses `fancy-regex` instead, whose backtracking engine supports the full
fn output_fields(resolved: &ResolvedGrok) -> Vec<(String, String)> {
            pattern_defs.insert(pattern_name.clone(), def.clone());
            StringBuilder::new(),
        let pattern_name = caps.name("pattern").unwrap().as_str().to_string();
 * SPDX-License-Identifier: Apache-2.0
/// `GrokUtils.GROK_PATTERN`. No lookaround/atomic features, so the linear
        );
    }
        let keys: Vec<String> = row_entries(&map, 0).into_iter().map(|(k, _)| k).collect();
            return_field: Arc::new(Field::new("out", map_return_type(), true)),
                resolved
//!     distinct user-facing field name (the `%{NAME:field}` subname; `UNWANTED`
impl Default for GrokUdf {
        return value.to_string();
        None => s.to_string(),
        if arg_types.len() != 3 {
        if let Some(idx) = trimmed.find(char::is_whitespace) {
        })?;
impl ScalarUDFImpl for GrokUdf {
static DICTIONARY: LazyLock<HashMap<String, String>> = LazyLock::new(|| {
            Some(c) => c,
fn scalar_str(cv: &ColumnarValue) -> Option<String> {
                // fancy-regex returns Result<Option<Captures>>; a runtime regex
        return plan_err!("grok: pattern not found in [{pattern}]");
        group_order,
        DataType::Struct(vec![key_field, value_field].into()),
        iterations_left -= 1;
/// Arrow `Map<Utf8, Utf8>` field shape returned by this UDF — keys non-null,
        // Validate each slot is a string variant, then map down to Utf8:
}
            let name = trimmed[..idx].to_string();
        let interior = &chars[1..chars.len() - 1];
        }
//!      OpenSearch core's classpath, so the 108-line default dictionary
        let line = "177.95.8.74 - upton5450 [28/Sep/2022:10:15:57 -0700] \"HEAD /e-business/mindshare HTTP/1.0\" 404 19927";
        assert_eq!(clean_string("\"foo\""), "foo");
    use super::*;
            let replacement = format!("(?<name{index}>{definition_of_pattern})");
 */
            number_rows: n,
        // `NAME definition` — split on the first run of whitespace, exactly like
    }
/// mapping needed to key the output map.
    fn number_greedydata_with_lookbehind_and_atomic_group() {
    fn non_matching_and_null_rows_yield_empty_strings() {
//!     `GrokExpression.parseValue` returning `ExprStringValue("")`. Captured
        assert_eq!(value_for(&map, 1, "host").as_deref(), Some(""));
            })?;
    let mut named_regex = pattern.to_string();
    Array, ArrayRef, MapBuilder, MapFieldNames, StringArray, StringBuilder,
            };
        assert!(keys.contains(&"address".to_string()));
    fn unwanted_groups_are_dropped() {
        let method = scalar_str(&args.args[2]).ok_or_else(|| {
    let regex = FancyRegex::new(&named_regex).map_err(|e| {
            builder.append(true)?;
            // that does not match anywhere, and a group that did not participate
        let g = caps.get(1).unwrap().as_str().to_string();
        let mut name = caps.name("name").unwrap().as_str().to_string();
        Ok(arr.as_any().downcast_ref::<MapArray>().unwrap().clone())
            let definition = trimmed[idx..].trim_start().to_string();
            return plan_err!("grok expects 3 arguments, got {}", arg_types.len());
    let mut group_order: Vec<String> = Vec::new();
    }
        regex,
        // literals and gates method == "grok" at plan time. Re-check defensively
    fn name(&self) -> &str {
//! consequences force a separate implementation:
    /// Read row `i` of a MapArray into a (key,value) vec for assertions.
        )
        // GROK_REFERENCE never uses fancy features, so this find is infallible.
        }
/// in literally (no regex/`$` interpretation), matching the Java behaviour.
impl GrokUdf {
use std::sync::Arc;
    /// `name0` → user field name (`host`, `UNWANTED`, or the pattern name when
            let mut out = String::with_capacity(s.len() - token.len() + replacement.len());
    }
        Self {
                DataFusionError::Plan(format!(
static GROK_REFERENCE: LazyLock<Regex> = LazyLock::new(|| {
        }
    loop {
//!      be recursively expanded against a pattern dictionary before matching. The
mod tests {
            name = format!("{name}={def}");
    }
    let mut pattern_defs = DICTIONARY.clone();
    #[test]
    Regex::new(r"\(\?<([a-zA-Z][a-zA-Z0-9]*)>").expect("NAMED_GROUP is a valid regex")
    }
    signature: Signature,
    }
};
//! Runtime work (this file), mirroring the SQL plugin's grok semantics
    let ColumnarValue::Scalar(sv) = cv else {
    fn value_for(map: &MapArray, i: usize, key: &str) -> Option<String> {
/// Resolve a grok pattern to a `fancy-regex` plus its group→field mapping.
//!   2. **Regex features.** The resolved patterns use lookbehind `(?<!…)`,
            "%{NUMBER} %{GREEDYDATA:address}",
    for group in &resolved.group_order {
    group_order: Vec<String>,
    #[test]
    }
            continue;
            .downcast_ref::<StringArray>()
                ColumnarValue::Scalar(ScalarValue::Utf8(Some("grok".to_string()))),
    fn coerce_types(&self, arg_types: &[DataType]) -> Result<Vec<DataType>> {
    Regex::new(
        row_entries(map, i)
        // invoke_with_args downcasts the input column to StringArray. Same
            return Err(DataFusionError::Plan(format!(
/*
        }
            "grok",
        return plan_err!("grok: pattern should not be empty or null");
                    .map_err(|e| DataFusionError::Execution(format!("grok: match failed: {e}")))?
pub fn register_all(ctx: &SessionContext) {
    fields
            .unwrap();
            defs.insert(name, definition);
}
        let map = run_grok(vec![Some(line)], "%{COMMONAPACHELOG}").unwrap();
}
    }
        }
            .column(0)
/// Pull the string value out of a literal column. Returns None if the column is
        let map = run_grok(vec![None, Some("no-at-sign-here")], ".+@%{HOSTNAME:host}").unwrap();
                key: "key".to_string(),
//!
        let caps = match GROK_REFERENCE.captures(&named_regex) {
//! # Why grok needs its own UDF rather than reusing `parse`
        }
            .downcast_ref::<StringArray>()
        ScalarValue::Utf8(opt) | ScalarValue::LargeUtf8(opt) | ScalarValue::Utf8View(opt) => {
                entry: "entries".to_string(),
                subname.clone().unwrap_or_else(|| pattern_name.clone()),
        if args.args.len() != 3 {
        return None;
        let input_arr = StringArray::from(input);
        let map = run_grok(vec![Some("amberduke@pyrami.com")], ".+@%{HOSTNAME:host}").unwrap();
        let args = ScalarFunctionArgs {
        &self.signature
                    .regex
//!      ships) and the resolution algorithm are ported here verbatim from
    fn clean_string_strips_balanced_quotes() {
/// regex — ported from `GrokUtils.NAMED_REGEX`. Used to recover the group order
    match s.find(token) {
    fn commonapachelog_named_fields() {
    let last = chars[chars.len() - 1];
//!
        }
    #[test]
        false,
            config_options: Arc::new(datafusion::config::ConfigOptions::new()),
            ],
    fn invoke_with_args(&self, args: ScalarFunctionArgs) -> Result<ColumnarValue> {
        }
    fn row_entries(map: &MapArray, i: usize) -> Vec<(String, String)> {
//!      lookahead `(?!…)` and atomic groups `(?>…)` (e.g. `BASE10NUM`, `IPV4`)
        for _ in 0..count {
//! `parse` takes a raw regex; grok takes grok syntax (`%{HOSTNAME:host}`). Two
use datafusion::execution::context::SessionContext;
use std::collections::HashMap;
                ColumnarValue::Array(Arc::new(input_arr)),
            StringBuilder::new(),
/// ported from `Match.cleanString`.
            );
/// value, but only when the quote char does not also appear in the interior —
        // so a misuse from an unknown caller produces an actionable plan error.
    let first = chars[0];
/// Matches the synthetic `(?<nameN>` capture-group openers in a resolved grok
            group_order.push(g);
//! # Division of labor with the Java adapter
/// `StringUtils.replace(s, token, replacement, 1)`. The replacement is spliced
