    let mut s = String::from(log_message);
    #[test]
    for delim in delimiters {
            // unwrap() at construction is appropriate — these are hardcoded
            let digits_start = j;
//!    associated variable denoter (e.g. `<*IP*>`, `<*UUID*>`).
            replacement,
        );
                out.push(c as char);
            out.push(c as char);
        // task_id like `_task_200811092030_0002_r_000296_0/part-00296.` should
                // No digits after sign — not a number run.
             /user/root/sortrand/_temporary/_task_200811092030_0002_r_000296_0/part-00296. \
/*
        if i == 4 {
        }
static DEFAULT_FILTER_PATTERNS: Lazy<Vec<FilterPattern>> = Lazy::new(|| {
                j += 1;
        );
            // Walk forward to find the end of `-?\+?\d+`. Java's grouping
            "<*UUID*>",
        let tokens =
    pub regex: Regex,
        );
                j += 1;
});
                i += 1;
        );
    let mut i = 0;
/// token list. Mirrors Java's
/// Apply the "generic number surrounded by non-alphanumeric" rule. Java uses
}
        // alternation. Tests below confirm equivalence on the IT fixtures.
//! Mirrors `BrainLogParser.preprocess(logMessage, filterPatternVariableMap, delimiters)`
                i += 1;
    fn new(pattern: &str, replacement: &'static str) -> Self {
    // the broad number rule.
            }
/// the same.
            joined
        // slash and trailing `:port` / `:` are kept consistent with Java.
//! 3. Trim leading/trailing whitespace.
                "updated:",
        );
                "NameSystem.addStoredBlock:",
        // per Java's `[^A-Za-z0-9 ]`).
    log_message: &str,
    fn preprocess_substitutes_ip_then_blk_number() {
    }
            // allows at most one sign character, so the leading `-` / `+` is
                continue;
    out
        // UUID — `\b[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{12}\b`.
                continue;
            i += 1;
        let is_digit = c.is_ascii_digit() || c == b'-' || c == b'+';
                continue;
}
        let c = bytes[i];
        // capturing the surrounding characters and rebuilding the string in
        assert_eq!(
        Self {
            vec!["[PlaceOrder]", "user_id=<*UUID*>", "user_currency=USD"]
            // Followed by alphanumeric — don't substitute, just copy the
            // Decide if this starts a candidate number. Java's regex is anchored
/// `DEFAULT_FILTER_PATTERN_VARIABLE_MAP` LinkedHashMap iteration: IP →
                "to",
                "is",
                "<*IP*>",
            // consumed here only if followed by digits.
            if i == 0 {
        }
    // earlier patterns so IP / datetime / UUID / hex matches aren't broken by
    // Skip the placeholder index 4 — we apply the lookbehind/lookahead rule
 * compatible open source license.
    !b.is_ascii_alphanumeric() && b != b' '
fn apply_generic_number_filter(input: &str) -> String {
            ]
        // integer digits. The `(?!\d{3}$)` negative lookahead in Java prevents
}
        assert!(
pub fn preprocess(
//!
#[cfg(test)]
 * The OpenSearch Contributors require contributions made to
                "blk_<*>",
    #[test]
    }
    // Apply the generic-number lookaround rule explicitly. This must follow the
        let joined = tokens.join(" ");
        // lookahead). Rust's `regex` doesn't support either — emulate by
/// `LinkedHashMap<Pattern, String>` iteration order.
    }
//! the synthetic `logId` token that BRAIN uses as a row identifier.
fn is_separator(b: u8) -> bool {
    }
    // via `apply_generic_number_filter` after the regex pass to match Java's
//! Returns the resulting token list. The caller is responsible for appending
            // placeholder so the iteration count matches Java (5 entries)
    ]
/// string and rebuilds it with each qualifying number run replaced by `<*>`.
        FilterPattern::new(r"(/|)([0-9]+\.){3}[0-9]+(:[0-9]+|)(:|)", "<*IP*>"),
}
            pp("Verification succeeded for blk_-1547954353065580372"),
/// by-non-alphanumeric. Java relies on insertion order, so the Rust list does
            // patterns identical to Java's static initializer block.
    fn preprocess_simple_log_line_splits_on_whitespace() {
    while i < bytes.len() {
        // "BLOCK* NameSystem.addStoredBlock: blockMap updated: <*IP*> is added to blk_<*> size <*>"
            // by lookbehind on the byte BEFORE the match; here, that's
use once_cell::sync::Lazy;
    for (i, fp) in filter_patterns.iter().enumerate() {
        FilterPattern::new(
 * this file be licensed under the Apache-2.0 license or a
/// `BrainLogParser.preprocess(logMessage, filterPatternVariableMap, delimiters)`.
/// ISO datetime → UUID → hex/letter+digits/floats → generic number-surrounded-
//! 1. Apply each filter regex in declaration order, replacing matches with the
            r"((0x|0X)[0-9a-fA-F]+)|[a-zA-Z]+\d+|([+-]?\d{4,}(\.\d*)?|\.\d+)",
        FilterPattern::new(
/// Default filter patterns. Order must match Java's
/// Default delimiters that are replaced with spaces during preprocessing.
}
    filter_patterns: &[FilterPattern],
            r"(\d{4}-\d{2}-\d{2})[T ]?(\d{2}:\d{2}:\d{2})(\.\d{3})?(Z|([+-]\d{2}:?\d{2}))?",
#[inline]
 *
        ),
        // Hex (0x / 0X prefix), letters followed by digits, or floats with 4+
            tokens,
        preprocess(msg, default_filter_patterns(), default_delimiters())
    s.split_whitespace().map(String::from).collect()
        // [`apply_generic_number_filter`]. This pattern is unused in the
            i += 1;
            // first byte and advance.
            if !is_separator_no_space(prev) {
            }
            pp("[PlaceOrder] user_id=d664d7be-77d8-11f0-8880-0242f00b101d user_currency=USD");
            }
        s = fp.regex.replace_all(&s, fp.replacement).into_owned();
}
            "<*>",
                i += 1;
    }
use regex::Regex;
fn is_separator_no_space(b: u8) -> bool {
            vec![
            continue;
    fn pp(msg: &str) -> Vec<String> {
/// The caller is responsible for appending the synthetic logId token that BRAIN
            out.push(c as char);
/// One (regex, replacement) pair. Ordered application matches the Java
            // requires a preceding char, so don't match at the start).
    !b.is_ascii_alphanumeric()
                "BLOCK*",
        let tokens = pp(
                "size",
        // characters are non-alphanumeric (and the preceding is also non-space
            "expected wildcards in tokenized output: {}",
                continue;
                out.push_str("<*>");
        // testBrainParseWithUUID_NotShowNumberedToken expects:
            vec!["Verification", "succeeded", "for", "blk_<*>"]
    let mut out = String::with_capacity(input.len());
        // From testBrainLabelMode_NotShowNumberedToken second row, the
        // see every number-segment between underscores substituted to `<*>`.
    fn preprocess_collapses_consecutive_wildcards_via_number_runs() {
                out.push(c as char);
            }
        FilterPattern::new(
/// Matches Java's `DEFAULT_DELIMITERS = List.of(",", "+")`.
        // ISO date+time. Java's regex is
            while j < bytes.len() && bytes[j].is_ascii_digit() {
        }
}
/// Run the full preprocess pipeline on a single log message and return its
            r"\b[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{12}\b",
                i = j;
//! 2. Replace every delimiter character with a single space.
        // From the CalcitePPLPatternsIT testBrainLabelMode_NotShowNumberedToken expected pattern:
        assert_eq!(
            if j >= bytes.len() || is_separator(bytes[j]) {
        ),
    s = apply_generic_number_filter(&s);
            "<*>",
        // matching 3-digit numbers — Rust's `regex` crate doesn't support
 */
    pub replacement: &'static str,
        // lookaround, so emulate by requiring 4+ digits explicitly in the
pub fn default_delimiters() -> &'static [&'static str] {
//!
            "<*DATETIME*>",
                out.push(c as char);
            }
        if is_digit {
    #[test]
        // `(?<=[^A-Za-z0-9 ])(-?\+?\d+)(?=[^A-Za-z0-9])` (lookbehind +
            // The character after the digits must be a non-alphanumeric, or
/// which Rust's default `regex` crate doesn't support. This function walks the
            "BLOCK* NameSystem.addStoredBlock: blockMap updated: 10.251.31.85:50010 is added to \
        let tokens = pp("BLOCK* NameSystem.allocateBlock: \
    &[",", "+"]
    #[test]
            tokens,
            r"(?-u)(?:^^^^^^never^^^^^^)",
    use super::*;
        // Just sanity-check that the multi-digit numbers got substituted somewhere.
    fn preprocess_substitutes_uuid() {
 * SPDX-License-Identifier: Apache-2.0
        FilterPattern::new(
    let bytes = input.as_bytes();
                "<*>",
        // IP — `(/|)([0-9]+\.){3}[0-9]+(:[0-9]+|)(:|)`. The optional leading
    }
impl FilterPattern {
            let prev = bytes[i - 1];
        assert_eq!(
/// lookbehind + lookahead (`(?<=[^A-Za-z0-9 ])(-?\+?\d+)(?=[^A-Za-z0-9])`),
        ),
            let mut j = i;
/// uses to key per-row state.
    }
    delimiters: &[&str],
            // the run is not a valid match (lookahead `(?=[^A-Za-z0-9])`).
pub struct FilterPattern {
///
#[inline]
) -> Vec<String> {
            regex: Regex::new(pattern).expect("static BRAIN filter regex is well-formed"),
        // Generic number surrounded by non-alphanumeric. Java uses
        // A digit run qualifies only when both the preceding and following
             blk_-7017553867379051457 size 67108864",
        } else {
            if j == digits_start {
//! 4. Split on runs of whitespace (`\s+`).
//!
        s = s.replace(delim, " ");
    vec![
}
mod tests {
        // single-pass replacement loop; the rebuild path is called explicitly.
        // "[PlaceOrder] user_id=<*UUID*> user_currency=USD"
    }
    // behavior exactly.
                "blockMap",
            if bytes[j] == b'-' || bytes[j] == b'+' {
                "added",
//! in Java:
    &DEFAULT_FILTER_PATTERNS
pub fn default_filter_patterns() -> &'static [FilterPattern] {
             blk_-6620182933895093708");
#[derive(Debug, Clone)]
            }
        ),
//! Pre-tokenization for the BRAIN algorithm.
        // `(\d{4}-\d{2}-\d{2})[T ]?(\d{2}:\d{2}:\d{2})(\.\d{3})?(Z|([+-]\d{2}:?\d{2}))?`.
            // `bytes[i-1]` (or `None` at start-of-string — Java's lookbehind
}
    }
            joined.contains("<*>"),
