    /// The last token is the synthetic logId — skip it.
        assert_eq!(v[0], WordCombination::new(3, 3));
}
        //   "PacketResponder failed <*> blk_<*>"           (2)
        for i in 0..tokens_len {
        }
            same_freq_count,
            "BLOCK* NameSystem.addStoredBlock: blockMap updated: <*IP*> is added to blk_<*> size <*>";
        // adjacent wildcards, group by pattern string.
//!    corpus.
        Some(self.cmp(other))
            *self.token_freq_map.entry(key).or_insert(0) += 1;
    fn brain_aggregates_hdfs_fixtures_into_four_groups() {
            let is_lower = token_freq < rep_freq;
    fn collapse_three_consecutive_wildcards() {
            let word_occurrences = self.get_word_occurrences(tokens);
            if is_higher {
                    out.push(super::VARIABLE_DENOTER.to_string());
    if needle.is_empty() || from > haystack.len() {
    let mut i = 0;
        &mut self,
            WordCombination::new(5, 1),
    /// then derive per-log group candidate strings. Returns the list of
    }
    }
        self.calculate_group_token_freq(&preprocessed_logs);
    }
                        if max_sample_count > 0 {
/// `same_freq_count` descending, then `word_freq` descending.
//!    The candidate is `(repFreq, sameFreqCount)`.
        let rep_freq: u64 = group_candidate_str
            .cmp(&self.same_freq_count)
        }
            // BLOCK* NameSystem.allocateBlock
/// reads out the per-pattern stats. The struct stores the internal maps
        assert_eq!(
//! consumes.
                return *w;
            .last()
        let logs = hdfs_log_fixtures();
 * compatible open source license.
             is added to blk_-7017553867379051457 size 67108864"
                .to_string(),
                .collect();
/// pattern string to its [`PatternEntry`].
            while k + dlen <= bytes.len() && &bytes[k..k + dlen] == denoter.as_bytes() {
    fn hdfs_log_fixtures() -> Vec<String> {
        if tokens.is_empty() {
        }
                .token_freq_map
            let token_freq = *self
            .expect("group candidate string is well-formed");
            stats.keys().collect::<Vec<_>>()
    /// Frequency-of-frequencies histogram for this log line: map of `tokenFreq
            "BLOCK* NameSystem.allocateBlock: \
                .group_token_set_map
        assert_eq!(
                .entry(pattern_key.clone())
    /// token-set maps. Mirrors `calculateGroupTokenFreq`.
                .map(|t| collapse_continuous_wildcards(&t))
impl WordCombination {
    /// token set keyed by `(tokens.len()-1, group_candidate_str, position)`.
/*
    /// already sorted by `(same_freq_count desc, word_freq desc)`. Walk the
                .entry(key)
}
            tokens.push(log_id);
        v.sort();
                .insert(tokens[i].clone());
            let group_key = group_token_set_key(token_capacity, group_candidate_str, i);
}
            .log_id_group_candidate_map
    /// sameFreqCount)` and update both the logId→candidate and per-position
            // WordCombination.compareTo). The candidate is the FIRST element
 * The OpenSearch Contributors require contributions made to
            .next()
    group_token_set_map: HashMap<String, HashSet<String>>,
            "PacketResponder failed for blk_6996194389878584395".to_string(),
        let expected =
/// `POSITIONED_TOKEN_KEY_FORMAT` in Java.
        // word_freq desc tiebreaker → 3, 2, 5
        }
            let key = positioned_token_key(i, tok);
            let mut tokens =
            "expected pattern not derived for BLOCK* lines.\n  got: {:?}",
        ];
use crate::patterns::preprocess::{default_delimiters, default_filter_patterns, FilterPattern};
                    }
                .unwrap_or_else(|| panic!("missing group token set for key {:?}", group_key));
            token_freq_map: HashMap::new(),
    fn new(word_freq: u64, same_freq_count: u64) -> Self {
        let mut out = Vec::with_capacity(token_capacity);
        }
impl PartialOrd for WordCombination {
                    pattern: pattern_key,
impl Default for BrainLogParser {
//!    word-combination key that identifies the "group" each log belongs to.
        let threshold = (max_freq as f64) * threshold_percentage;
        // Step 1+2: Preprocess all logs, fill histogram + group candidates.
            out.push_str(denoter);
                        }
            out.push(token.clone());
        for (key, entry) in stats.iter() {
            "expected pattern not in stats: {:?}",
//! The output is a [`BrainParseStats`] map — the same data structure Java's
/// (token-frequency histogram, group token sets, logId → candidate string)
//!
        )
        );
    threshold_percentage: f64,
            "Verification succeeded for blk_6996194389878584395".to_string(),
    }
        // varies). Test by stripping consecutive wildcards instead.
    /// list and pick the FIRST entry whose `word_freq > maxFreq * threshold%`.
        } else {
                        samples
            log_pattern_map
    #[test]
    // ── End-to-end parse_all_log_patterns ──────────────────────────────────
        }
                .to_string(),
 */
    use super::*;
    delimiters: &'static [&'static str],
            }
            "BLOCK* NameSystem.allocateBlock: \
 * SPDX-License-Identifier: Apache-2.0
        );
    filter_patterns: &'static [FilterPattern],
            .same_freq_count
 * this file be licensed under the Apache-2.0 license or a
        // CalcitePPLPatternsIT.testBrainAggregationMode_NotShowNumberedToken
    fn update_group_token_freq_map(&mut self, tokens: &[String], group_candidate_str: &str) {
    format!("{}-{}", position, token)
            self.process_token_histogram(&tokens);
        // to blk_<*> by the "letters+digits" filter rule (PR fixture uses
        let expected =
                });
            threshold_percentage,
/// `"<tokens_len>-<group_candidate>-<position>"`. Mirrors
struct WordCombination {
             blk_2096692261399680562"
    fn word_combination_orders_by_same_freq_count_desc() {
    /// (the log's positional index as a string).
}
    log_id_group_candidate_map: HashMap<String, String>,
        // by non-alphanumeric" rule too — so the exact wildcard count
        assert_eq!(entry.pattern_count, 2);
    /// If none qualify, return the first entry. Mirrors `findCandidate`.
    }
                    continue;
//! 2. **Build the token-frequency histogram** — for every preprocessed log,
    }
}
use std::collections::{HashMap, HashSet};
    #[test]
            WordCombination::new(2, 3),
    // ── collapse_continuous_wildcards ──────────────────────────────────────
            word_freq,
//!    count how often each token appears at each position across the entire
        log_pattern_map
    fn collapse_wildcards_in_mixed_string() {
    }
        let token_capacity = tokens.len() - 1;
        return None;
    fn brain_groups_verification_succeeded_lines() {
            // PacketResponder failed
    /// → number of positions whose token has that freq`. Mirrors
                    if entry.sample_logs.len() < max_sample_count {
    /// Per-row pattern derivation. For each position in `tokens`, decide
        let logs = vec![
            !sorted.is_empty(),
            let mut sorted_word_combinations: Vec<WordCombination> = word_occurrences
                .insert(log_id.clone(), group_candidate_str.clone());
        let group_candidate_str = self
        ];
}
    }
            preprocessed_logs.push(tokens);
            "BLOCK* NameSystem.addStoredBlock: blockMap updated: 10.251.31.85:50010 \
            "BLOCK* NameSystem.addStoredBlock: blockMap updated: <*IP*> is added to blk_<*> size <*>";
/// `GROUP_TOKEN_SET_KEY_FORMAT` in Java.
            self.log_id_group_candidate_map
        let stats = parser.parse_all_log_patterns(&logs, 5);
            let token = &tokens[i];
        }
                .and_modify(|entry| {
            WordCombination::new(3, 3),
    /// Count token frequency per position. Mirrors `processTokenHistogram`.
//! The algorithm groups log lines by their structural pattern:
        }
            stats.keys().collect::<Vec<_>>()
            out.push_str(&part[i..j]);
//! 4. **Build the per-group token set per position** — within each group,
    }
        let preprocessed = self.preprocess_all_logs(log_messages);
}
    /// preprocessed token lists, each terminated by a synthetic logId token
            super::DEFAULT_FREQUENCY_THRESHOLD_PERCENTAGE,
/// Collapse runs of consecutive `<*>` wildcards into a single `<*>`. Mirrors
    fn get_word_occurrences(&self, tokens: &[String]) -> HashMap<u64, u64> {
    pub fn with_thresholds(variable_count_threshold: usize, threshold_percentage: f64) -> Self {
    /// maxSampleCount)` in Java.
impl Ord for WordCombination {
                    entry.pattern_count += 1;
        let mut v = vec![
                .collect();
            return Vec::new();
//! 6. **Collapse adjacent wildcards** and group by pattern string, counting
    #[test]
fn group_token_set_key(tokens_len: usize, group_candidate: &str, position: usize) -> String {
fn positioned_token_key(position: usize, token: &str) -> String {
        log_messages: &[String],
    /// From CalcitePPLPatternsIT.testBrainAggregationMode_NotShowNumberedToken
            let mut k = j + dlen;
    }
            // BLOCK* NameSystem.addStoredBlock
            let group_candidate_str =
pub struct PatternEntry {
                    continue;
        max_sample_count: usize,
            let log_id = tokens
    }
            "threshold_percentage must be in [0.0, 1.0]"
            );
        occurrences
                .last()
                crate::patterns::preprocess::preprocess(msg, self.filter_patterns, self.delimiters);
#[derive(Debug)]
            (0.0..=1.0).contains(&threshold_percentage),
        for i in 0..token_capacity {
    }
    #[test]
}
                .iter()
    }
    fn calculate_group_token_freq(&mut self, preprocessed_logs: &[Vec<String>]) {
        for (i, tok) in tokens.iter().enumerate().take(tokens.len() - 1) {
    fn parse_log_pattern(&self, tokens: &[String]) -> Vec<String> {
//!    number runs), normalize delimiters to spaces, split on whitespace.
                }
        // expects exactly 4 patterns, each containing 2 sample logs:
            let key = positioned_token_key(i, tok);
                .token_freq_map
            stats.len(),
        let mut log_pattern_map: BrainParseStats = HashMap::new();
                k += dlen;
        let tokens_len = tokens.len() - 1;
            stats.contains_key(expected),
    word_freq: u64,
            .expect("preprocess_all_logs always appends the logId");
            variable_count_threshold,
            "expected 4 distinct patterns, got {:?}",
        }
             /user/root/sortrand/_temporary/_task_200811092030_0002_r_000296_0/part-00296. \
                .get(&group_key)
        // Both lines belong to the same pattern. The blk_ field is preprocessed
pub fn collapse_continuous_wildcards(part: &str) -> String {
        assert_eq!(collapse_continuous_wildcards("<*>"), "<*>");
            "expected a single pattern, got {:?}",
//! 5. **Per-row pattern derivation** — for each log, replace every token that
//! 3. **Pick a group candidate per log** — look at the histogram and find a
    /// Run the full BRAIN pipeline over a slice of log messages and return the
    #[test]
}
    ) -> BrainParseStats {
        // Spot-check one of the patterns matches what the IT expects.
                let is_unique = group_set.len() == 1;
        );
        assert_eq!(collapse_continuous_wildcards("hello world"), "hello world");
        let log_id = tokens
/// Top-level result of running BRAIN over a set of log messages — a map of
                .unwrap_or_else(|| panic!("missing token freq for {:?} at position {}", token, i));
        other
    // ── WordCombination ordering ───────────────────────────────────────────
    fn collapse_passes_through_short_strings() {
        //   "Verification succeeded <*> blk_<*>"           (2)
//!    but not unique; frequency below but group has many variants) with
            break;
            } else if is_lower {
            return;
 *
        assert_eq!(v[1], WordCombination::new(2, 3));
mod tests {
    }
            let group_set = self
             is added to blk_-3249711809227781266 size 67108864"
    pub fn parse_all_log_patterns(
//! `parseAllLogPatterns` returns and which `LogPatternAggFunction.value()`
    }
        }
            "Verification succeeded for blk_-1547954353065580372".to_string(),
    }
        let stats = parser.parse_all_log_patterns(&logs, 5);
                entry.pattern_count, key
    while i < bytes.len() {
            stats.keys().collect::<Vec<_>>()
//!    `<*>`.
    }
            out.push_str(&part[i..]);
//!    isn't characteristic of its group (frequency above the representative
        if tokens.is_empty() {
    }
    }
             blk_-6620182933895093708"
                format!("{},{}", candidate.word_freq, candidate.same_freq_count);
            "Verification succeeded for blk_6996194389878584395".to_string(),
            return occurrences;
    variable_count_threshold: usize,
            let is_higher = token_freq > rep_freq;
        Self {
        );
        for w in sorted {
            .expect("every preprocessed log has a group candidate");
    fn partial_cmp(&self, other: &Self) -> Option<std::cmp::Ordering> {
            let raw_pattern_tokens = self.parse_log_pattern(tokens);
                    sample_logs: {
fn find_at(haystack: &[u8], needle: &[u8], from: usize) -> Option<usize> {
            stats.len(),
    }
                if group_set.len() >= self.variable_count_threshold {
/// BRAIN log parser. Stateful per-invocation — the caller feeds log lines and
    fn preprocess_all_logs(&mut self, log_messages: &[String]) -> Vec<Vec<String>> {
        return None;
pub type BrainParseStats = HashMap<String, PatternEntry>;
    out
    }
    let mut out = String::with_capacity(part.len());
//! BRAIN algorithm core. Mirrors `BrainLogParser.java` from the SQL plugin
/// Represents `(word_freq, same_freq_count)` — a token-frequency observation
/// for a log line. Ordering matches Java's `WordCombination.compareTo`:
    fn collapse_passes_through_when_no_wildcards() {
            let pattern_key = collapsed.join(" ");
            .and_then(|s| s.parse().ok())
        return part.to_string();
                }
#[cfg(test)]
}
        vec![
                .expect("preprocess_all_logs always appends the logId");
    pub pattern_count: u64,
        // negative numbers — those get hit by the "generic number surrounded
    fn default() -> Self {
            // none, the first element.
            .split(',')
            i = k;
        let logs = hdfs_log_fixtures();
            super::DEFAULT_VARIABLE_COUNT_THRESHOLD,
            let log_id = i.to_string();
        if tokens.is_empty() {
            log_id_group_candidate_map: HashMap::new(),
    /// For each position in `tokens`, insert the token into the per-group
        }
                            samples.push(sample_log.clone());
//!
        let entry = stats.values().next().unwrap();
//!
    }
#[derive(Debug, Clone, PartialEq, Eq)]
        Self {
        assert_eq!(entry.sample_logs.len(), 2);
        let max_freq = sorted.iter().map(|w| w.word_freq).max().unwrap_or(0);
        // the first BLOCK* row's expected pattern is verified directly.
            .get(log_id)
    /// Pre-tokenize every log message, update the token-frequency histogram,
            stats.keys().collect::<Vec<_>>()
/// Composite key for `tokenFreqMap` entries: `"<position>-<token>"`. Mirrors
    }
/// for inspection but the public API exposes only [`parse_all_log_patterns`].
        preprocessed_logs
                .expect("token must be in histogram after preprocess_all_logs");
        let mut preprocessed_logs: Vec<Vec<String>> = Vec::with_capacity(log_messages.len());
            4,
        //   "BLOCK* NameSystem.addStoredBlock: blockMap updated: <*IP*> is added to blk_<*> size <*>"  (2)
        ]
impl BrainLogParser {
        // same_freq_count desc → 3, 3, 1
                })
        }
                .or_insert_with(|| PatternEntry {
            // whose wordFreq exceeds the threshold (maxFreq * threshold%); if
    token_freq_map: HashMap<String, u64>,
        assert_eq!(collapse_continuous_wildcards(""), "");
                    out.push(super::VARIABLE_DENOTER.to_string());
        let mut occurrences: HashMap<u64, u64> = HashMap::new();
/// Composite key for `groupTokenSetMap` entries:
    /// New parser with explicit thresholds; uses the default filter patterns
pub struct BrainLogParser {
}
            let freq = *self
/// value type from Java's `parseAllLogPatterns` return: `{pattern, pattern_count,
        assert_eq!(v[2], WordCombination::new(5, 1));
            "Sorted word combinations must be non-empty"
            let tok_key = positioned_token_key(i, token);
    #[test]
    let bytes = part.as_bytes();
                entry.pattern_count, 2,
    let dlen = denoter.len();
            "blk_<*> size <*>"
        }
            // Sort by sameFreqCount desc, then wordFreq desc (matches Java's
}
            // Verification succeeded
            "PacketResponder failed for blk_-1547954353065580372".to_string(),
                .to_string(),
            self.update_group_token_freq_map(tokens, &group_candidate_str);
                .get(&tok_key)
                .into_iter()
            let sample_log = &log_messages[i];
        let stats = parser.parse_all_log_patterns(&logs, 5);
    /// on the histogram and the group token set. Mirrors `parseLogPattern`.
        let mut parser = BrainLogParser::with_thresholds(5, 0.3);
        // From CalcitePPLPatternsIT.testBrainLabelMode_NotShowNumberedToken,
        assert!(
    #[test]
            }
    fn cmp(&self, other: &Self) -> std::cmp::Ordering {
    /// per-pattern aggregated stats. Mirrors `parseAllLogPatterns(logMessages,
                .get(&key)
//! 1. **Preprocess** every line — apply regex filters (IP, datetime, UUID,
        out
            "Verification succeeded for blk_-1547954353065580372".to_string(),
    // The three internal maps from Java's BrainLogParser.
                .or_default()
    /// Mirrors `updateGroupTokenFreqMap`.
        Self::with_thresholds(
        if tokens.is_empty() {
            if (w.word_freq as f64) > threshold {
        }
            "BLOCK* NameSystem.addStoredBlock: blockMap updated: 10.251.107.19:50010 \
        );
        assert!(
        for tokens in preprocessed_logs {
    let denoter = super::VARIABLE_DENOTER;
/// patterns like `<*><*><*>` that result from multiple adjacent number runs.
            stats.contains_key(expected),
        let mut parser = BrainLogParser::default();
#[derive(Debug, Clone, Copy, PartialEq, Eq)]
            }
        if let Some(j) = find_at(bytes, denoter.as_bytes(), i) {
            let collapsed: Vec<String> = raw_pattern_tokens
        }
             /user/root/sortrand/_temporary/_task_200811092030_0002_r_000318_0/part-00318. \
            delimiters: default_delimiters(),
            // tokens.last() is the synthetic logId.
}
        let mut parser = BrainLogParser::with_thresholds(5, 0.2);
    /// For each log line: derive its group candidate string `(repFreq,
            *occurrences.entry(freq).or_insert(0) += 1;
        assert_eq!(collapse_continuous_wildcards("<*><*><*>"), "<*>");
        for (i, msg) in log_messages.iter().enumerate() {
            let candidate =
                if !is_unique {
//! (`common/src/main/java/org/opensearch/sql/common/patterns/BrainLogParser.java`).
            group_token_set_map: HashMap::new(),
        // Step 5+6: For each log, derive the per-row pattern, collapse
    }
//!    occurrences and collecting sample logs.
                "every group should have count == 2 for these fixtures, got {} for {:?}",
        //   "<*> NameSystem.allocateBlock: /user/root/sortrand/_temporary/_task_<*>_<*>_r_<*>_<*>/part<*> blk_<*>"  (2)
        assert_eq!(
                    },
/// `BrainLogParser.collapseContinuousWildcards`. Used post-parsing to clean up
        );
    }
    same_freq_count: u64,
/// Aggregated stats per discovered pattern. Mirrors the `Map<String, Object>`
            .then_with(|| other.word_freq.cmp(&self.word_freq))
        for (i, tok) in tokens.iter().enumerate().take(tokens.len() - 1) {
    pub sample_logs: Vec<String>,
/// sample_logs}` keyed by pattern string.
        );
    /// — the four HDFS log patterns plus their expected aggregated outputs.
    fn find_candidate(sorted: &[WordCombination], threshold_percentage: f64) -> WordCombination {
    (from..=haystack.len() - needle.len()).find(|&i| &haystack[i..i + needle.len()] == needle)
                Self::find_candidate(&sorted_word_combinations, self.threshold_percentage);
    #[test]
            assert_eq!(
            return;
            self.group_token_set_map
//!    collect the distinct tokens seen at each position.
    /// Find the representative WordCombination for a log line. The list is
    fn process_token_histogram(&mut self, tokens: &[String]) {
    /// and delimiters.
        for (i, tokens) in preprocessed.iter().enumerate() {
        assert!(
                        let mut samples = Vec::with_capacity(max_sample_count.min(8));
    format!("{}-{}-{}", tokens_len, group_candidate, position)
            let key = group_token_set_key(tokens_len, group_candidate_str, i);
        sorted[0]
    pub pattern: String,
                .map(|(freq, same_freq_count)| WordCombination::new(*freq, *same_freq_count))
    if needle.len() > haystack.len() - from {
            filter_patterns: default_filter_patterns(),
                        entry.sample_logs.push(sample_log.clone());
    fn brain_aggregates_brain_label_mode_blockstar_into_expected_pattern() {
    /// `getWordOccurrences`.
                    pattern_count: 1,
                .to_string(),
            collapse_continuous_wildcards("blk_<*><*> size <*>"),
    /// whether the token at that position is a constant or a variable, based
            sorted_word_combinations.sort();
        }
    }
            1,
        assert!(
    if part.len() < dlen * 2 {
