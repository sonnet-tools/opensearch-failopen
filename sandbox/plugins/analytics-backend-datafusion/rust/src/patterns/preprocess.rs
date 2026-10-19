        // lookahead). Rust's `regex` doesn't support either — emulate by
                "<*IP*>",
            // Walk forward to find the end of `-?\+?\d+`. Java's grouping
        // single-pass replacement loop; the rebuild path is called explicitly.
            r"(?-u)(?:^^^^^^never^^^^^^)",
                j += 1;
                continue;
//!
            // `bytes[i-1]` (or `None` at start-of-string — Java's lookbehind
            replacement,
//! Pre-tokenization for the BRAIN algorithm.
        FilterPattern::new(r"(/|)([0-9]+\.){3}[0-9]+(:[0-9]+|)(:|)", "<*IP*>"),
    #[test]
        let is_digit = c.is_ascii_digit() || c == b'-' || c == b'+';
pub fn default_filter_patterns() -> &'static [FilterPattern] {
    for delim in delimiters {
        preprocess(msg, default_filter_patterns(), default_delimiters())
/// ISO datetime → UUID → hex/letter+digits/floats → generic number-surrounded-
        let tokens = pp(
            continue;
}
            while j < bytes.len() && bytes[j].is_ascii_digit() {
            ]
    s.split_whitespace().map(String::from).collect()
            // allows at most one sign character, so the leading `-` / `+` is
        let c = bytes[i];
            // the run is not a valid match (lookahead `(?=[^A-Za-z0-9])`).
            tokens,
    // the broad number rule.
            // first byte and advance.
fn is_separator(b: u8) -> bool {
 * this file be licensed under the Apache-2.0 license or a
        // see every number-segment between underscores substituted to `<*>`.
}
    }
            r"((0x|0X)[0-9a-fA-F]+)|[a-zA-Z]+\d+|([+-]?\d{4,}(\.\d*)?|\.\d+)",
            i += 1;
/// `LinkedHashMap<Pattern, String>` iteration order.
        // Generic number surrounded by non-alphanumeric. Java uses
    // Apply the generic-number lookaround rule explicitly. This must follow the
            if j >= bytes.len() || is_separator(bytes[j]) {
            i += 1;
            r"(\d{4}-\d{2}-\d{2})[T ]?(\d{2}:\d{2}:\d{2})(\.\d{3})?(Z|([+-]\d{2}:?\d{2}))?",
        );
}
pub fn preprocess(
        // IP — `(/|)([0-9]+\.){3}[0-9]+(:[0-9]+|)(:|)`. The optional leading
        }
    vec![
//! 1. Apply each filter regex in declaration order, replacing matches with the
        // testBrainParseWithUUID_NotShowNumberedToken expects:
        ),
                "is",
    &[",", "+"]
 */
        let tokens =
/// Default delimiters that are replaced with spaces during preprocessing.
});
/// Run the full preprocess pipeline on a single log message and return its
}
    // Skip the placeholder index 4 — we apply the lookbehind/lookahead rule
    }
/// `BrainLogParser.preprocess(logMessage, filterPatternVariableMap, delimiters)`.
        // ISO date+time. Java's regex is
        // alternation. Tests below confirm equivalence on the IT fixtures.
pub fn default_delimiters() -> &'static [&'static str] {
        // capturing the surrounding characters and rebuilding the string in
            }
        FilterPattern::new(
            // unwrap() at construction is appropriate — these are hardcoded
            joined.contains("<*>"),
        // UUID — `\b[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{12}\b`.
    !b.is_ascii_alphanumeric()
        // `(\d{4}-\d{2}-\d{2})[T ]?(\d{2}:\d{2}:\d{2})(\.\d{3})?(Z|([+-]\d{2}:?\d{2}))?`.
        assert!(
        // `(?<=[^A-Za-z0-9 ])(-?\+?\d+)(?=[^A-Za-z0-9])` (lookbehind +
//!
    fn new(pattern: &str, replacement: &'static str) -> Self {
            if !is_separator_no_space(prev) {
    pub regex: Regex,
            regex: Regex::new(pattern).expect("static BRAIN filter regex is well-formed"),
            "<*>",
/// string and rebuilds it with each qualifying number run replaced by `<*>`.
        // characters are non-alphanumeric (and the preceding is also non-space
        let tokens = pp("BLOCK* NameSystem.allocateBlock: \
}
//! 2. Replace every delimiter character with a single space.
        }
    }
fn is_separator_no_space(b: u8) -> bool {
/*
        ),
    &DEFAULT_FILTER_PATTERNS
/// Matches Java's `DEFAULT_DELIMITERS = List.of(",", "+")`.
    // via `apply_generic_number_filter` after the regex pass to match Java's
            "expected wildcards in tokenized output: {}",
            // placeholder so the iteration count matches Java (5 entries)
        // matching 3-digit numbers — Rust's `regex` crate doesn't support
            let digits_start = j;
    #[test]
        } else {
        // per Java's `[^A-Za-z0-9 ]`).
/// `DEFAULT_FILTER_PATTERN_VARIABLE_MAP` LinkedHashMap iteration: IP →
    !b.is_ascii_alphanumeric() && b != b' '
        ),
        // From testBrainLabelMode_NotShowNumberedToken second row, the
use once_cell::sync::Lazy;
        FilterPattern::new(
            // Decide if this starts a candidate number. Java's regex is anchored
        let joined = tokens.join(" ");
use regex::Regex;
//! Returns the resulting token list. The caller is responsible for appending
    s = apply_generic_number_filter(&s);
        // Just sanity-check that the multi-digit numbers got substituted somewhere.
        FilterPattern::new(
        // A digit run qualifies only when both the preceding and following
            joined
/// Apply the "generic number surrounded by non-alphanumeric" rule. Java uses
            // patterns identical to Java's static initializer block.
    delimiters: &[&str],
            // requires a preceding char, so don't match at the start).
 *
/// token list. Mirrors Java's
pub struct FilterPattern {
    use super::*;
    let mut i = 0;
        // integer digits. The `(?!\d{3}$)` negative lookahead in Java prevents
            }
            let mut j = i;
            "BLOCK* NameSystem.addStoredBlock: blockMap updated: 10.251.31.85:50010 is added to \
             /user/root/sortrand/_temporary/_task_200811092030_0002_r_000296_0/part-00296. \
//! in Java:
                "added",
//!
            pp("Verification succeeded for blk_-1547954353065580372"),
                "<*>",
///
            }
    fn preprocess_substitutes_uuid() {
            tokens,
/// by-non-alphanumeric. Java relies on insertion order, so the Rust list does
    }
                "to",
//!    associated variable denoter (e.g. `<*IP*>`, `<*UUID*>`).
            // Followed by alphanumeric — don't substitute, just copy the
static DEFAULT_FILTER_PATTERNS: Lazy<Vec<FilterPattern>> = Lazy::new(|| {
        s = fp.regex.replace_all(&s, fp.replacement).into_owned();
) -> Vec<String> {
        // lookaround, so emulate by requiring 4+ digits explicitly in the
        FilterPattern::new(
        // Hex (0x / 0X prefix), letters followed by digits, or floats with 4+
        if i == 4 {
        assert_eq!(
            // The character after the digits must be a non-alphanumeric, or
        s = s.replace(delim, " ");
/// One (regex, replacement) pair. Ordered application matches the Java
        Self {
/// uses to key per-row state.
            // consumed here only if followed by digits.
        );
            }
    }
 * The OpenSearch Contributors require contributions made to
mod tests {
                i += 1;
            }
    let bytes = input.as_bytes();
        // task_id like `_task_200811092030_0002_r_000296_0/part-00296.` should
    // behavior exactly.
        // "[PlaceOrder] user_id=<*UUID*> user_currency=USD"
                out.push(c as char);
    }
            vec![
    let mut s = String::from(log_message);
#[inline]
            "<*UUID*>",
                continue;
                out.push_str("<*>");
            let prev = bytes[i - 1];
}
                "blk_<*>",
            // by lookbehind on the byte BEFORE the match; here, that's
    }
    fn preprocess_simple_log_line_splits_on_whitespace() {
            }
 * compatible open source license.
}
                "BLOCK*",
        // slash and trailing `:port` / `:` are kept consistent with Java.
                "size",
            "<*>",
            pp("[PlaceOrder] user_id=d664d7be-77d8-11f0-8880-0242f00b101d user_currency=USD");
/// Default filter patterns. Order must match Java's
    fn pp(msg: &str) -> Vec<String> {
#[inline]
 * SPDX-License-Identifier: Apache-2.0
//! 3. Trim leading/trailing whitespace.
                i = j;
    filter_patterns: &[FilterPattern],
            vec!["[PlaceOrder]", "user_id=<*UUID*>", "user_currency=USD"]
    #[test]
        if is_digit {
    out
            r"\b[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{12}\b",
                out.push(c as char);
        ),
        // "BLOCK* NameSystem.addStoredBlock: blockMap updated: <*IP*> is added to blk_<*> size <*>"
            out.push(c as char);
    fn preprocess_collapses_consecutive_wildcards_via_number_runs() {
    log_message: &str,
                i += 1;
            if j == digits_start {
    let mut out = String::with_capacity(input.len());
        assert_eq!(
                j += 1;
        // From the CalcitePPLPatternsIT testBrainLabelMode_NotShowNumberedToken expected pattern:
        }
             blk_-7017553867379051457 size 67108864",
/// which Rust's default `regex` crate doesn't support. This function walks the
}
            "<*DATETIME*>",
//! 4. Split on runs of whitespace (`\s+`).
            if bytes[j] == b'-' || bytes[j] == b'+' {
impl FilterPattern {
    }
    // earlier patterns so IP / datetime / UUID / hex matches aren't broken by
fn apply_generic_number_filter(input: &str) -> String {
    }
//! Mirrors `BrainLogParser.preprocess(logMessage, filterPatternVariableMap, delimiters)`
        assert_eq!(
                "NameSystem.addStoredBlock:",
                // No digits after sign — not a number run.
                "updated:",
            out.push(c as char);
/// lookbehind + lookahead (`(?<=[^A-Za-z0-9 ])(-?\+?\d+)(?=[^A-Za-z0-9])`),
        );
        );
            vec!["Verification", "succeeded", "for", "blk_<*>"]
    ]
}
                continue;
                out.push(c as char);
    while i < bytes.len() {
//! the synthetic `logId` token that BRAIN uses as a row identifier.
    #[test]
#[cfg(test)]
                i += 1;
    for (i, fp) in filter_patterns.iter().enumerate() {
    pub replacement: &'static str,
#[derive(Debug, Clone)]
            if i == 0 {
        // [`apply_generic_number_filter`]. This pattern is unused in the
                continue;
/// The caller is responsible for appending the synthetic logId token that BRAIN
                "blockMap",
/// the same.
        );
             blk_-6620182933895093708");
    fn preprocess_substitutes_ip_then_blk_number() {
