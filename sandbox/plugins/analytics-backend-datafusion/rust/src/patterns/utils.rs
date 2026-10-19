    original: &str,
        );
/// plain `HashMap` is sufficient.
    }
            is_token.push(false);
        );
            &mut tokens,
                let next_static = &parts[i + 1];
            &mut tokens,
        if start > last_end {
                // is UTF-16 based but yields the same offsets for ASCII test
                i += 1;
    }
        extract_variables(
        let start = m.start();
        } else {
/// Walk through `original` using the pattern's static parts as anchors and
    let mut pos = 0usize;
    #[test]
/// Regex matching wildcard placeholders of the form `<* …>`. Mirrors Java's
    /// `is_token`.
        extract_variables(
                        pos = absolute;
    pub fn to_token_order_string(&self, _prefix: &str) -> String {
pub struct ParseResult {
            parsed.parts,
    let token_order = &parse_result.token_order;
                // boundaries, but the IT fixtures are all ASCII.
        );
}
                        i += 1;
/// Map of token label → list of extracted variable values. Mirrors Java's
            } else {
        );
) {
use regex::Regex;
    _prefix: &str,
impl ParseResult {
        parts.push(pattern[last_end..].to_string());
        parts,
                "-1547954353065580372".to_string(),
            "Verification succeeded for blk_-1547954353065580372",
    let mut is_token: Vec<bool> = Vec::new();
    }
//! and by the BRAIN aggregate's `evalAgg` step.
//!
        let parsed = parse_pattern("Verification succeeded <*> blk_<*>", &WILDCARD_PATTERN);
            tokens.get("<token2>"),
                out.push_str(&self.token_order[token_index]);
        let mut out = String::new();
        let parsed = parse_pattern("<*>@<*>.<*>", &WILDCARD_PATTERN);
        is_token,
    /// Per-part flag: `true` means the corresponding `parts` entry is a token
    /// Mirrors `ParseResult.toTokenOrderString(prefix)` in Java. The `prefix`
    }
    Lazy::new(|| Regex::new(r"<\*[^>]*>").expect("WILDCARD_PATTERN regex is well-formed"));
pub static TOKEN_PATTERN: Lazy<Regex> =
    /// Rebuild the pattern using numbered-token labels instead of wildcards.
    (0..=haystack.len() - needle.len()).find(|&i| &haystack[i..i + needle.len()] == needle)
        for (i, part) in self.parts.iter().enumerate() {
        assert_eq!(parsed.is_token, vec![true, false, true, false, true]);
            ])
            WILDCARD_PREFIX,
#[derive(Debug, Clone, PartialEq, Eq)]
                return;
}
    if parse_result.parts.is_empty() {
        let parsed = parse_pattern("<*>@<*>.<*>", &WILDCARD_PATTERN);
/// `Map<String, List<String>>` semantics; assertions in `CalcitePPLPatternsIT`
            "<token1>@<token2>.<token3>"
        return Some(0);
pub type TokensMap = HashMap<String, Vec<String>>;
        );
/// The wildcard-style prefix used when generating numbered-token labels from
/// compare via `Map.equals` (content-only, key order doesn't matter), so a
                }
        let end = m.end();
            // Static part — must match the prefix of `original[pos..]`.
                add_to_result(result, token_key, value.to_string());
pub const WILDCARD_PREFIX: &str = "<*";
    let mut token_count = 1usize;
        parts.push(pattern[start..end].to_string());
            &parsed,
            if i == parts.len() - 1 {
/// Regex matching numbered token placeholders like `<token1>`, `<token12>`.
            tokens.get("<token1>"),
                    }
mod tests {
 * compatible open source license.
    }
    result.entry(key.to_string()).or_default().push(value);
            }
/// label. Mirrors `PatternUtils.extractVariables(parseResult, original, result, prefix)`.
        // From CalcitePPLPatternsIT.testBrainAggregationMode_ShowNumberedToken
            token_index += 1;
    }
    parse_result: &ParseResult,
    }
    /// parameter is unused in Java (only validated downstream); we keep it on
 * this file be licensed under the Apache-2.0 license or a
 * SPDX-License-Identifier: Apache-2.0
        );
        assert_eq!(parsed.token_order, vec!["<token1>", "<token2>", "<token3>"]);
        let mut tokens = TokensMap::new();
        assert_eq!(
    fn parse_wildcard_pattern_splits_on_email_separators() {
            vec!["<token1>", "@", "<token2>", ".", "<token3>"]
    result: &mut TokensMap,
//! `PatternUtils.ParseResult` from the Java implementation. Used both by the
                let value = &original[pos..];
 */
    /// (placeholder), `false` means literal static text.
                i += 1;
                        let absolute = pos + rel_idx;
            WILDCARD_PREFIX,
        return None;
        token_order,
    use super::*;
/// wildcards. Matches Java's `PatternUtils.WILDCARD_PREFIX = "<*"`.
/*
            let token_key = &token_order[token_index];
        token_count += 1;
                    Some(rel_idx) => {
            &parsed,
//! Pattern-string parsing and variable extraction.
        let mut token_index = 0usize;
        extract_variables(
    fn token_pattern_matches_numbered_placeholders() {
        let parsed = parse_pattern("<*>@<*>", &WILDCARD_PATTERN);
            WILDCARD_PREFIX,
        assert_eq!(
                    None => return,
            &parsed,
                token_index += 1;
    /// appearance. Has length equal to the count of `true` entries in
    #[test]
    let mut last_end = 0usize;
            parsed.to_token_order_string(WILDCARD_PREFIX),
            &parsed,
/// Mirrors `PatternUtils.ParseResult` in Java: three parallel lists tracking
}
                let search_region = &original_bytes[pos..];
/// The `_prefix` parameter is unused in Java (only the label list iteration
    if needle.len() > haystack.len() {
        assert_eq!(
    }
            }
        assert_eq!(tokens.get("<token3>"), Some(&vec!["com".to_string()]));
            "amberduke.pyrami.com",
        assert_eq!(parsed.parts, vec!["<*>", "@", "<*>", ".", "<*>"]);
            } else {
    fn extract_variables_handles_multi_sample_aggregation() {
    let parts = &parse_result.parts;
        assert!(tokens.is_empty(), "expected no tokens, got {:?}", tokens);
fn add_to_result(result: &mut TokensMap, key: &str, value: String) {
            if original[pos..].starts_with(current_part) {
    pub is_token: Vec<bool>,
    }
            "amberduke@pyrami.com",
        token_order.push(format!("<token{}>", token_count));
        let parsed = parse_pattern("<*>@<*>.<*>", &WILDCARD_PATTERN);
        }
/// Mirrors Java's `PatternUtils.TOKEN_PATTERN = Pattern.compile("<token\\d+>")`.
///
                match find_subsequence(search_region, next_static_bytes) {
                // Last part — capture the remaining tail.
            if self.is_token[i] {
//! Mirrors `PatternUtils.parsePattern`, `PatternUtils.extractVariables`, and
    ParseResult {
            Some(&vec![
        return;
        let current_part = &parts[i];
    while i < parts.len() {
use std::collections::HashMap;
    let is_token = &parse_result.is_token;
    fn extract_variables_returns_empty_when_static_mismatch() {
    /// `<token1>`, `<token2>`, … numbered labels assigned in order of
/// matters); kept on the signature for parity.
        );
    }
/// Parse a pattern string by splitting on `compiled_pattern` matches and
        assert_eq!(tokens.get("<token2>"), Some(&vec!["pyrami".to_string()]));
    }
    Lazy::new(|| Regex::new(r"<token\d+>").expect("TOKEN_PATTERN regex is well-formed"));
            Some(&vec!["for".to_string(), "for".to_string()])
pub static WILDCARD_PATTERN: Lazy<Regex> =
    }
                pos += current_part.len();
/// Result of parsing a pattern string into alternating static / token parts.
    }
            WILDCARD_PREFIX,
                // Bytewise indexOf — equivalent to Java's String.indexOf which
}
        let mut tokens = TokensMap::new();
/// `PatternUtils.WILDCARD_PATTERN = Pattern.compile("<\\*[^>]*>")`. Examples
        extract_variables(
    #[test]
        // expected: token1 = ["for", "for"], token2 = ids
    for m in compiled_pattern.find_iter(pattern) {
                        let value = &original[pos..absolute];
/// it matches: `<*>`, `<*IP*>`, `<*UUID*>`, `<*DATETIME*>`.
pub fn parse_pattern(pattern: &str, compiled_pattern: &Regex) -> ParseResult {
        assert_eq!(
pub const TOKEN_PREFIX: &str = "<token";
use once_cell::sync::Lazy;
/// labeling each match in order (`<token1>`, `<token2>`, …). Mirrors
//! Calcite-side adapters (SIMPLE method `mode=label` show_numbered_token path)
        assert_eq!(parsed.is_token, vec![true, false, true, false, true]);
                // data. For non-ASCII input we'd need to advance by char
    /// the signature for parity but otherwise treat it as informational.
    /// Alternating static text and token-placeholder substrings.
}
        // No '@' in original — extraction must bail without inserting partial values.
    #[test]
        );
    fn to_token_order_string_rewrites_wildcards_to_numbered_tokens() {
/// each part's text, whether it's a token placeholder, and the order in which
    let mut parts: Vec<String> = Vec::new();
    #[test]
                out.push_str(part);
        out
/// token placeholders appear.
            &mut tokens,
    #[test]
    fn extract_variables_extracts_email_parts() {
                "6996194389878584395".to_string(),
}
 * The OpenSearch Contributors require contributions made to
    pub parts: Vec<String>,
                        add_to_result(result, token_key, value.to_string());
    }
    let original_bytes = original.as_bytes();
 *
        }
        assert_eq!(tokens.get("<token1>"), Some(&vec!["amberduke".to_string()]));
    if needle.is_empty() {
            } else {
            }
    if last_end < pattern.len() {
    pub token_order: Vec<String>,
pub fn extract_variables(
}
        is_token.push(false);
fn find_subsequence(haystack: &[u8], needle: &[u8]) -> Option<usize> {
    let mut token_index = 0usize;
/// The numbered-token prefix. Matches Java's `PatternUtils.TOKEN_PREFIX = "<token"`.
        let mut tokens = TokensMap::new();
            &mut tokens,
        is_token.push(true);
            "Verification succeeded for blk_6996194389878584395",
        if is_token[i] {
/// append each interpolated value to `result` under the corresponding token
    let mut token_order: Vec<String> = Vec::new();
        let parsed = parse_pattern("<token1>@<token2>.<token3>", &TOKEN_PATTERN);
            parts.push(pattern[last_end..start].to_string());
        last_end = end;
/// `PatternUtils.parsePattern(pattern, compiledPattern)` in Java.
        }
    let mut i = 0usize;
                let next_static_bytes = next_static.as_bytes();
#[cfg(test)]
