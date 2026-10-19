    }
            "PacketResponder failed for blk_6996194389878584395".to_string(),
//!    The candidate is `(repFreq, sameFreqCount)`.
    fn calculate_group_token_freq(&mut self, preprocessed_logs: &[Vec<String>]) {
#[derive(Debug)]
            let log_id = i.to_string();
            if (w.word_freq as f64) > threshold {
        return None;
        self.calculate_group_token_freq(&preprocessed_logs);
        assert!(
    }
        for i in 0..token_capacity {
 * compatible open source license.
            .expect("preprocess_all_logs always appends the logId");
/// Collapse runs of consecutive `<*>` wildcards into a single `<*>`. Mirrors
            "BLOCK* NameSystem.allocateBlock: \
            while k + dlen <= bytes.len() && &bytes[k..k + dlen] == denoter.as_bytes() {
        if tokens.is_empty() {
        let preprocessed = self.preprocess_all_logs(log_messages);
            let tok_key = positioned_token_key(i, token);
    let denoter = super::VARIABLE_DENOTER;
            "Verification succeeded for blk_-1547954353065580372".to_string(),
                        }
impl PartialOrd for WordCombination {
        //   "Verification succeeded <*> blk_<*>"           (2)
        // by non-alphanumeric" rule too — so the exact wildcard count
    fn hdfs_log_fixtures() -> Vec<String> {
}
    /// (the log's positional index as a string).
        );
}
    (from..=haystack.len() - needle.len()).find(|&i| &haystack[i..i + needle.len()] == needle)
            "expected 4 distinct patterns, got {:?}",
    }
        let mut preprocessed_logs: Vec<Vec<String>> = Vec::with_capacity(log_messages.len());
    #[test]
        let expected =
    }
    /// Count token frequency per position. Mirrors `processTokenHistogram`.
    fn process_token_histogram(&mut self, tokens: &[String]) {
                            samples.push(sample_log.clone());
                .to_string(),
            let word_occurrences = self.get_word_occurrences(tokens);
    }
            delimiters: default_delimiters(),
/// reads out the per-pattern stats. The struct stores the internal maps
                .or_default()
    /// maxSampleCount)` in Java.
    fn brain_aggregates_hdfs_fixtures_into_four_groups() {
    fn partial_cmp(&self, other: &Self) -> Option<std::cmp::Ordering> {
    fn collapse_wildcards_in_mixed_string() {
            tokens.push(log_id);
//! 2. **Build the token-frequency histogram** — for every preprocessed log,
    #[test]
            self.log_id_group_candidate_map
    fn parse_log_pattern(&self, tokens: &[String]) -> Vec<String> {
        assert!(
            WordCombination::new(2, 3),
            variable_count_threshold,
    threshold_percentage: f64,
            token_freq_map: HashMap::new(),
impl Ord for WordCombination {
            4,
    /// From CalcitePPLPatternsIT.testBrainAggregationMode_NotShowNumberedToken
                .iter()
/// `same_freq_count` descending, then `word_freq` descending.
            // whose wordFreq exceeds the threshold (maxFreq * threshold%); if
            filter_patterns: default_filter_patterns(),
            WordCombination::new(3, 3),
fn positioned_token_key(position: usize, token: &str) -> String {
                    out.push(super::VARIABLE_DENOTER.to_string());
        //   "PacketResponder failed <*> blk_<*>"           (2)
                Self::find_candidate(&sorted_word_combinations, self.threshold_percentage);
        // Spot-check one of the patterns matches what the IT expects.
        }
 */
    /// already sorted by `(same_freq_count desc, word_freq desc)`. Walk the
    filter_patterns: &'static [FilterPattern],
             is added to blk_-7017553867379051457 size 67108864"
    }
        assert_eq!(collapse_continuous_wildcards(""), "");
        // Step 5+6: For each log, derive the per-row pattern, collapse
    if needle.is_empty() || from > haystack.len() {
            let key = positioned_token_key(i, tok);
            stats.len(),
    variable_count_threshold: usize,
//!
        );
    }
        for (i, tokens) in preprocessed.iter().enumerate() {
    format!("{}-{}-{}", tokens_len, group_candidate, position)
        }
                .to_string(),
        }
            collapse_continuous_wildcards("blk_<*><*> size <*>"),
            self.group_token_set_map
        out
            "BLOCK* NameSystem.allocateBlock: \
 *
    let mut out = String::with_capacity(part.len());
                    },
            i = k;
use crate::patterns::preprocess::{default_delimiters, default_filter_patterns, FilterPattern};
//! BRAIN algorithm core. Mirrors `BrainLogParser.java` from the SQL plugin
        }
            out.push_str(&part[i..j]);
    fn brain_aggregates_brain_label_mode_blockstar_into_expected_pattern() {
        for (i, tok) in tokens.iter().enumerate().take(tokens.len() - 1) {
        // adjacent wildcards, group by pattern string.
/// sample_logs}` keyed by pattern string.
                .group_token_set_map
        for i in 0..tokens_len {
        for (i, msg) in log_messages.iter().enumerate() {
        assert_eq!(entry.sample_logs.len(), 2);
            "expected pattern not in stats: {:?}",
            "Verification succeeded for blk_-1547954353065580372".to_string(),
        // to blk_<*> by the "letters+digits" filter rule (PR fixture uses
        }
                .insert(log_id.clone(), group_candidate_str.clone());
                entry.pattern_count, 2,
    fn new(word_freq: u64, same_freq_count: u64) -> Self {
            let group_candidate_str =
        if tokens.is_empty() {
        }
//!
    // ── collapse_continuous_wildcards ──────────────────────────────────────
            out.push(token.clone());
    /// The last token is the synthetic logId — skip it.
            let key = positioned_token_key(i, tok);
    }
        // negative numbers — those get hit by the "generic number surrounded
    delimiters: &'static [&'static str],
                    if entry.sample_logs.len() < max_sample_count {
            return;
    }
/// `BrainLogParser.collapseContinuousWildcards`. Used post-parsing to clean up
        }
        }
            // Sort by sameFreqCount desc, then wordFreq desc (matches Java's
                .or_insert_with(|| PatternEntry {
    }
    /// and delimiters.
                crate::patterns::preprocess::preprocess(msg, self.filter_patterns, self.delimiters);
        sorted[0]
    /// If none qualify, return the first entry. Mirrors `findCandidate`.
//!    number runs), normalize delimiters to spaces, split on whitespace.
        let mut parser = BrainLogParser::default();
    /// Per-row pattern derivation. For each position in `tokens`, decide
//! `parseAllLogPatterns` returns and which `LogPatternAggFunction.value()`
            !sorted.is_empty(),
    /// — the four HDFS log patterns plus their expected aggregated outputs.
                format!("{},{}", candidate.word_freq, candidate.same_freq_count);
            let mut k = j + dlen;
        let group_candidate_str = self
    if part.len() < dlen * 2 {
        vec![
/// BRAIN log parser. Stateful per-invocation — the caller feeds log lines and
        }
        for (i, tok) in tokens.iter().enumerate().take(tokens.len() - 1) {
                let is_unique = group_set.len() == 1;
        let mut parser = BrainLogParser::with_thresholds(5, 0.3);
        let threshold = (max_freq as f64) * threshold_percentage;
            stats.contains_key(expected),
                .to_string(),
    }
            }
                if group_set.len() >= self.variable_count_threshold {
        );
    /// per-pattern aggregated stats. Mirrors `parseAllLogPatterns(logMessages,
            WordCombination::new(5, 1),
            let token = &tokens[i];
        log_messages: &[String],
    fn default() -> Self {
        Self::with_thresholds(
        // same_freq_count desc → 3, 3, 1
            let token_freq = *self
        v.sort();
    #[test]
                .collect();
            "BLOCK* NameSystem.addStoredBlock: blockMap updated: 10.251.107.19:50010 \
//! 4. **Build the per-group token set per position** — within each group,
            // Verification succeeded
/// value type from Java's `parseAllLogPatterns` return: `{pattern, pattern_count,
    /// sameFreqCount)` and update both the logId→candidate and per-position
        assert!(
    pub pattern: String,
                })
    let mut i = 0;
pub struct BrainLogParser {
                .unwrap_or_else(|| panic!("missing group token set for key {:?}", group_key));
            // BLOCK* NameSystem.allocateBlock
    let dlen = denoter.len();
                .expect("preprocess_all_logs always appends the logId");
 * The OpenSearch Contributors require contributions made to
                .map(|(freq, same_freq_count)| WordCombination::new(*freq, *same_freq_count))
        assert_eq!(collapse_continuous_wildcards("<*><*><*>"), "<*>");
    }
            *self.token_freq_map.entry(key).or_insert(0) += 1;
        preprocessed_logs
    #[test]
    #[test]
}
            let is_lower = token_freq < rep_freq;
        for w in sorted {
    word_freq: u64,
        );
        assert!(
        &mut self,
            log_id_group_candidate_map: HashMap::new(),
        //   "<*> NameSystem.allocateBlock: /user/root/sortrand/_temporary/_task_<*>_<*>_r_<*>_<*>/part<*> blk_<*>"  (2)
        }
        assert_eq!(
            super::DEFAULT_FREQUENCY_THRESHOLD_PERCENTAGE,
    }
/// Represents `(word_freq, same_freq_count)` — a token-frequency observation
            stats.len(),
    }
        let mut parser = BrainLogParser::with_thresholds(5, 0.2);
/*
    /// Frequency-of-frequencies histogram for this log line: map of `tokenFreq
        let stats = parser.parse_all_log_patterns(&logs, 5);
        return part.to_string();
//!    count how often each token appears at each position across the entire
            let mut tokens =
/// `"<tokens_len>-<group_candidate>-<position>"`. Mirrors
        let mut out = Vec::with_capacity(token_capacity);
    /// on the histogram and the group token set. Mirrors `parseLogPattern`.
    /// Pre-tokenize every log message, update the token-frequency histogram,
/// for a log line. Ordering matches Java's `WordCombination.compareTo`:
        let rep_freq: u64 = group_candidate_str
                    out.push(super::VARIABLE_DENOTER.to_string());
        // the first BLOCK* row's expected pattern is verified directly.
                "every group should have count == 2 for these fixtures, got {} for {:?}",
//!    occurrences and collecting sample logs.
             blk_-6620182933895093708"
/// Aggregated stats per discovered pattern. Mirrors the `Map<String, Object>`
            "threshold_percentage must be in [0.0, 1.0]"
        let stats = parser.parse_all_log_patterns(&logs, 5);
    }
    // ── End-to-end parse_all_log_patterns ──────────────────────────────────
            self.process_token_histogram(&tokens);
        Self {
                .insert(tokens[i].clone());
//! 6. **Collapse adjacent wildcards** and group by pattern string, counting
            .last()
            sorted_word_combinations.sort();
            break;
#[cfg(test)]
        assert_eq!(v[0], WordCombination::new(3, 3));
             /user/root/sortrand/_temporary/_task_200811092030_0002_r_000296_0/part-00296. \
    fn cmp(&self, other: &Self) -> std::cmp::Ordering {
            "BLOCK* NameSystem.addStoredBlock: blockMap updated: 10.251.31.85:50010 \
             is added to blk_-3249711809227781266 size 67108864"
        for (key, entry) in stats.iter() {
                    continue;
            log_pattern_map
//!
    /// token set keyed by `(tokens.len()-1, group_candidate_str, position)`.
            out.push_str(denoter);
mod tests {
        );
        let logs = hdfs_log_fixtures();
        }
}
        let tokens_len = tokens.len() - 1;
            let group_set = self
                    sample_logs: {
                    pattern: pattern_key,
                k += dlen;
                .get(&tok_key)
            *occurrences.entry(freq).or_insert(0) += 1;
        assert_eq!(
    #[test]
        let stats = parser.parse_all_log_patterns(&logs, 5);
                .into_iter()
}
 * this file be licensed under the Apache-2.0 license or a
    }
                        let mut samples = Vec::with_capacity(max_sample_count.min(8));
                .to_string(),
                .entry(key)
    fn preprocess_all_logs(&mut self, log_messages: &[String]) -> Vec<Vec<String>> {
        Some(self.cmp(other))
//! 1. **Preprocess** every line — apply regex filters (IP, datetime, UUID,
    }
        assert_eq!(
            .split(',')
            // WordCombination.compareTo). The candidate is the FIRST element
            super::DEFAULT_VARIABLE_COUNT_THRESHOLD,
    /// New parser with explicit thresholds; uses the default filter patterns
    /// `getWordOccurrences`.
                .expect("token must be in histogram after preprocess_all_logs");
    pub fn with_thresholds(variable_count_threshold: usize, threshold_percentage: f64) -> Self {
            1,
        other
    }
            "BLOCK* NameSystem.addStoredBlock: blockMap updated: <*IP*> is added to blk_<*> size <*>";
        assert_eq!(v[2], WordCombination::new(5, 1));
        let expected =
    /// Mirrors `updateGroupTokenFreqMap`.
            stats.keys().collect::<Vec<_>>()
//! 5. **Per-row pattern derivation** — for each log, replace every token that
            let is_higher = token_freq > rep_freq;
        } else {
    fn collapse_passes_through_when_no_wildcards() {
            let candidate =
    /// whether the token at that position is a constant or a variable, based
/// `POSITIONED_TOKEN_KEY_FORMAT` in Java.
        let mut log_pattern_map: BrainParseStats = HashMap::new();
#[derive(Debug, Clone, Copy, PartialEq, Eq)]
            "blk_<*> size <*>"
    /// For each position in `tokens`, insert the token into the per-group
        let max_freq = sorted.iter().map(|w| w.word_freq).max().unwrap_or(0);
            let pattern_key = collapsed.join(" ");
            .get(log_id)
    /// token-set maps. Mirrors `calculateGroupTokenFreq`.
            }
                return *w;
}
}
            let raw_pattern_tokens = self.parse_log_pattern(tokens);
                    pattern_count: 1,
    fn get_word_occurrences(&self, tokens: &[String]) -> HashMap<u64, u64> {
    /// Run the full BRAIN pipeline over a slice of log messages and return the
fn find_at(haystack: &[u8], needle: &[u8], from: usize) -> Option<usize> {
        // CalcitePPLPatternsIT.testBrainAggregationMode_NotShowNumberedToken
        );
//! The algorithm groups log lines by their structural pattern:
            .next()
}
    log_id_group_candidate_map: HashMap<String, String>,
        )
}
    /// Find the representative WordCombination for a log line. The list is
        return None;
    }
        let token_capacity = tokens.len() - 1;
        assert_eq!(entry.pattern_count, 2);
        if tokens.is_empty() {
            stats.keys().collect::<Vec<_>>()
                .unwrap_or_else(|| panic!("missing token freq for {:?} at position {}", token, i));
//!    `<*>`.
fn group_token_set_key(tokens_len: usize, group_candidate: &str, position: usize) -> String {
            let key = group_token_set_key(tokens_len, group_candidate_str, i);
            .log_id_group_candidate_map
    }
    pub pattern_count: u64,
    fn word_combination_orders_by_same_freq_count_desc() {
                        samples
    /// then derive per-log group candidate strings. Returns the list of
        }
//! (`common/src/main/java/org/opensearch/sql/common/patterns/BrainLogParser.java`).
    /// → number of positions whose token has that freq`. Mirrors
        let logs = hdfs_log_fixtures();
                }
    same_freq_count: u64,
    out
                .and_modify(|entry| {
        Self {
    /// preprocessed token lists, each terminated by a synthetic logId token
        // From CalcitePPLPatternsIT.testBrainLabelMode_NotShowNumberedToken,
    // ── WordCombination ordering ───────────────────────────────────────────
            // BLOCK* NameSystem.addStoredBlock
             blk_2096692261399680562"
            }
        let entry = stats.values().next().unwrap();
 * SPDX-License-Identifier: Apache-2.0
        }
/// for inspection but the public API exposes only [`parse_all_log_patterns`].
impl Default for BrainLogParser {
            word_freq,
        assert_eq!(collapse_continuous_wildcards("<*>"), "<*>");
                });
                        entry.sample_logs.push(sample_log.clone());
    fn collapse_three_consecutive_wildcards() {
        for tokens in preprocessed_logs {
        ];
            let log_id = tokens
    }
            );
    use super::*;
    #[test]
/// `GROUP_TOKEN_SET_KEY_FORMAT` in Java.
                    entry.pattern_count += 1;
struct WordCombination {
        assert_eq!(collapse_continuous_wildcards("hello world"), "hello world");
    ) -> BrainParseStats {
            .and_then(|s| s.parse().ok())
             /user/root/sortrand/_temporary/_task_200811092030_0002_r_000318_0/part-00318. \
            stats.keys().collect::<Vec<_>>()
            let sample_log = &log_messages[i];
}
    }
#[derive(Debug, Clone, PartialEq, Eq)]
//!    collect the distinct tokens seen at each position.
            "Verification succeeded for blk_6996194389878584395".to_string(),
                .entry(pattern_key.clone())
    }
                .last()
/// Composite key for `groupTokenSetMap` entries:
use std::collections::{HashMap, HashSet};
    }
        occurrences
        max_sample_count: usize,
}
            // none, the first element.
//! consumes.
impl BrainLogParser {
}
//!    word-combination key that identifies the "group" each log belongs to.
//! The output is a [`BrainParseStats`] map — the same data structure Java's
            .expect("group candidate string is well-formed");
/// pattern string to its [`PatternEntry`].
            group_token_set_map: HashMap::new(),
            stats.contains_key(expected),
            // PacketResponder failed
}
        }
                .collect();
//!    but not unique; frequency below but group has many variants) with
            "BLOCK* NameSystem.addStoredBlock: blockMap updated: <*IP*> is added to blk_<*> size <*>";
    fn find_candidate(sorted: &[WordCombination], threshold_percentage: f64) -> WordCombination {
        if let Some(j) = find_at(bytes, denoter.as_bytes(), i) {
            if is_higher {
        let mut occurrences: HashMap<u64, u64> = HashMap::new();
//!    corpus.
        //   "BLOCK* NameSystem.addStoredBlock: blockMap updated: <*IP*> is added to blk_<*> size <*>"  (2)
        // word_freq desc tiebreaker → 3, 2, 5
            let collapsed: Vec<String> = raw_pattern_tokens
    #[test]
    if needle.len() > haystack.len() - from {
        let log_id = tokens
    pub sample_logs: Vec<String>,
    format!("{}-{}", position, token)
    group_token_set_map: HashMap<String, HashSet<String>>,
        ];
        }
                .get(&group_key)
/// (token-frequency histogram, group token sets, logId → candidate string)
        // expects exactly 4 patterns, each containing 2 sample logs:
                .get(&key)
            return occurrences;
            .same_freq_count
                }
impl WordCombination {
    token_freq_map: HashMap<String, u64>,
            assert_eq!(
        if tokens.is_empty() {
//! 3. **Pick a group candidate per log** — look at the histogram and find a
//!    isn't characteristic of its group (frequency above the representative
pub struct PatternEntry {
pub fn collapse_continuous_wildcards(part: &str) -> String {
            // tokens.last() is the synthetic logId.
            (0.0..=1.0).contains(&threshold_percentage),
            "expected pattern not derived for BLOCK* lines.\n  got: {:?}",
            out.push_str(&part[i..]);
            .expect("every preprocessed log has a group candidate");
    pub fn parse_all_log_patterns(
        ]
            "Sorted word combinations must be non-empty"
    /// list and pick the FIRST entry whose `word_freq > maxFreq * threshold%`.
        }
            "Verification succeeded for blk_6996194389878584395".to_string(),
            let freq = *self
/// patterns like `<*><*><*>` that result from multiple adjacent number runs.
            } else if is_lower {
            threshold_percentage,
    fn collapse_passes_through_short_strings() {
    /// For each log line: derive its group candidate string `(repFreq,
            .cmp(&self.same_freq_count)
        // Both lines belong to the same pattern. The blk_ field is preprocessed
                    }
            same_freq_count,
                entry.pattern_count, key
/// Top-level result of running BRAIN over a set of log messages — a map of
        log_pattern_map
            self.update_group_token_freq_map(tokens, &group_candidate_str);
        // varies). Test by stripping consecutive wildcards instead.
    fn brain_groups_verification_succeeded_lines() {
            let group_key = group_token_set_key(token_capacity, group_candidate_str, i);
        // Step 1+2: Preprocess all logs, fill histogram + group candidates.
    while i < bytes.len() {
    let bytes = part.as_bytes();
            "expected a single pattern, got {:?}",
        assert_eq!(v[1], WordCombination::new(2, 3));
                .token_freq_map
        let mut v = vec![
    }
        );
    }
/// Composite key for `tokenFreqMap` entries: `"<position>-<token>"`. Mirrors
            preprocessed_logs.push(tokens);
            "PacketResponder failed for blk_-1547954353065580372".to_string(),
            return Vec::new();
        let logs = vec![
                    continue;
            stats.keys().collect::<Vec<_>>()
            let mut sorted_word_combinations: Vec<WordCombination> = word_occurrences
            return;
                .map(|t| collapse_continuous_wildcards(&t))
            .then_with(|| other.word_freq.cmp(&self.word_freq))
    fn update_group_token_freq_map(&mut self, tokens: &[String], group_candidate_str: &str) {
                        if max_sample_count > 0 {
pub type BrainParseStats = HashMap<String, PatternEntry>;
                if !is_unique {
    // The three internal maps from Java's BrainLogParser.
                .token_freq_map
