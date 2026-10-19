pub const DEFAULT_FREQUENCY_THRESHOLD_PERCENTAGE: f64 = 0.3;
//! DataFusion or Arrow. Tests below pin behavior against fixture data drawn
/// Default threshold used by BRAIN to decide whether a low-frequency token
pub mod eval;
pub use utils::{extract_variables, parse_pattern, ParseResult};
//!
pub mod utils;
//! `opensearch-project/sql/common/src/main/java/org/opensearch/sql/common/patterns/`
//! * [`preprocess`] — regex-based pre-tokenization (IP / datetime / UUID / etc.
/// counts as a variable. Matches `BrainLogParser.DEFAULT_VARIABLE_COUNT_THRESHOLD`.
pub const DEFAULT_VARIABLE_COUNT_THRESHOLD: usize = 5;
pub use preprocess::{default_delimiters, default_filter_patterns, preprocess};
pub use tokens::PatternResult;
//! of the Drain/Brain log-parsing approach
//!   variable detection, delimiter normalization, whitespace splitting).
/// candidate selection. Matches `BrainLogParser.DEFAULT_FREQUENCY_THRESHOLD_PERCENTAGE`.
 * this file be licensed under the Apache-2.0 license or a
 *
/// Default representative-frequency threshold percentage used by BRAIN's group
//!   (matches Java's `PatternUtils.parsePattern` / `extractVariables` /
//!   `ParseResult`).
 * The OpenSearch Contributors require contributions made to
/// Canonical wildcard token. Matches `BrainLogParser.VARIABLE_DENOTER` in Java.
//! Rust port of PPL `patterns` command's algorithm layer.
//! * [`utils`] — pattern-string parsing and variable extraction
//!   used by aggregation mode.
//! * [`brain`] — the BRAIN method: token histogram, group token sets,
//!
pub const VARIABLE_DENOTER: &str = "<*>";
//! ## Module layout
pub mod tokens;
//! from `CalcitePPLPatternsIT`, so equivalence with the Java implementation
//! ([reference](https://ieeexplore.ieee.org/document/10109145)).
pub mod brain;
//! is enforced at unit-test time.
//!   `crate::udf::pattern_parser`.
pub mod preprocess;
 */
/*
//!   `sample_logs` / `tokens`) used by the DataFusion UDF layer in
//! * [`tokens`] — typed view of the result map (`pattern` / `pattern_count` /
//! Source of truth: the Java implementation under
//!
//!   per-line pattern derivation, and the full `parse_all_log_patterns` pipeline
pub use brain::{BrainLogParser, BrainParseStats, PatternEntry};
 * SPDX-License-Identifier: Apache-2.0
//! The UDF layer wraps these pure functions; nothing in this module depends on
//!
 * compatible open source license.
//! (`BrainLogParser.java`, `PatternUtils.java`). The algorithm itself is a port
pub use eval::{eval_agg, eval_field, eval_samples, AggCandidate};
