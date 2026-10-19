#[allow(unused_imports)]
mod harness;
#[allow(unused_imports)]
//! - the **production pipeline**: `IndexedStream` with
#[allow(unused_imports)]
    execute_tree, load_segment, run_iteration, run_iteration_twice, LoadedSegment,
pub(super) use corpus::{build_corpus, CellValue, Corpus};
 * The OpenSearch Contributors require contributions made to
//!   `BitmapTreeEvaluator`, `PagePruner`, `RowSelection`, etc.
mod oracle;
mod seed;
//! Collector-matching doc-id sets; the same tree is evaluated by
pub(super) use harness::{
 *
mod tree_gen;
#[allow(unused_imports)]
};
//! failures deterministically reproduce via
//!
/*
//!
//! The result sets must match. Any mismatch prints the outer seed, the
//! `INDEXED_E2E_SEED=<hex> cargo test <test_name>`.
mod corpus;
pub(super) use config::{ColumnKind, FixtureConfig};
pub(super) use tree_gen::{collect_collector_tags, generate_tree, GeneratedTree};
 */
//! - a row-by-row **oracle** against the raw `Vec<CorpusRow>` we kept
 * SPDX-License-Identifier: Apache-2.0
mod delegation;
//!   in memory during corpus generation, and
//! random `BoolNode` tree over the fixture's schema + a set of random
pub(super) use oracle::oracle_evaluate;
pub(super) use seed::{derive_seed, master_seed};
mod config;
#[allow(unused_imports)]
//! Seedable randomized E2E tests for the indexed parquet query path.
//!
 * compatible open source license.
 * this file be licensed under the Apache-2.0 license or a
//! columns, RGs, and pages. Each iteration within a test generates a
#[allow(unused_imports)]
#![cfg(test)]
mod tests;
//! per-iteration seed, the fixture config, and the generated tree so
//! One fixture is built once per test at 10k–50k rows across multiple
