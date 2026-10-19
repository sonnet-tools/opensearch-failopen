    pub pattern_count: u64,
}
 * this file be licensed under the Apache-2.0 license or a
 */
            pattern: String::new(),
    pub tokens: TokensMap,
 *
        Self {
/// Field-level eval (`evalField`) populates `pattern` and `tokens` and leaves
#[derive(Debug, Clone, Default, PartialEq, Eq)]
//! Java's UDF layer hands around `Map<String, Object>` keyed by
///
/// …, "pattern_count", …, "sample_logs", …, "tokens", …)`.
pub struct PatternResult {
/*
    pub fn empty() -> Self {
///
    }
//!
            sample_logs: Vec::new(),
/// The struct is intentionally non-exhaustive in semantics: a caller producing
            tokens: HashMap::new(),
/// Aggregate-finalize populates all four fields.
///
use std::collections::HashMap;
//! UDF layer needs to materialize these into Arrow rows, so this module
//! defines a typed struct the UDF wrappers can build and then convert.
 * compatible open source license.
    pub pattern: String,
    /// Empty placeholder, matches Java's `EMPTY_RESULT = {pattern: "", tokens: {}}`.
 * SPDX-License-Identifier: Apache-2.0
    pub sample_logs: Vec<String>,
//! Typed view of the result map returned by `PATTERN_PARSER` / `INTERNAL_PATTERN`.
            pattern_count: 0,
/// `pattern_count` = 0 / `sample_logs` empty.
/// a SIMPLE-mode label result will simply leave the unused fields default.
        }
/// Per-row / per-group result. Aligns with Java's `ImmutableMap.of("pattern",
 * The OpenSearch Contributors require contributions made to
}
impl PatternResult {
//! `"pattern"`, `"pattern_count"`, `"sample_logs"`, `"tokens"`. The DataFusion
use crate::patterns::utils::TokensMap;
