/// Key phrase: "Failed to allocate"
/// Produced when `DynamicLimitPool.try_grow` fails and jemalloc confirms pressure.
/// Java conversion: `CircuitBreakingException` → HTTP 429
//!
/// Query cancelled due to critical RSS pressure during execution.
//!
pub fn admission_rejected_error(
 * this file be licensed under the Apache-2.0 license or a
    consumer_name: &str,
    ))
//! Any changes to prefixes, field ordering, or key phrases MUST be coordinated
///
 * SPDX-License-Identifier: Apache-2.0
/// Admission rejection: not enough pool capacity to start a new query.
/// Java conversion: `OpenSearchStatusException(TOO_MANY_REQUESTS)` → HTTP 429
    limit: usize,
///
    bytes_requested: usize,
 *
///
 * compatible open source license.
         — {} available out of {} limit",
//! Standardized error constructors for errors that cross the Rust→Java FFM boundary.
) -> DataFusionError {
    bytes_required: usize,
/// Uses the same key phrase as `pool_limit_error` so the Java converter produces
    limit: usize,
use datafusion::common::DataFusionError;
    batch_size: usize,
//! The message formats below are a **stable contract** between Rust and Java.
pub fn critical_pressure_error(
//! # Adding new error types
//! 2. Add a matching branch in `NativeErrorConverter.findAndConvert()`.
        "Cannot reserve untracked memory budget: {} bytes required at \
//! 1. Add a factory function here with a distinctive, stable prefix/phrase.
/// parallelism. The query is rejected before any execution begins.
//!
/// Key phrase: "Failed to allocate"
    ))
) -> DataFusionError {
/// and RSS exceeds the critical threshold (95% by default). At this level, even
}
    bytes_requested: usize,
 */
//!
    DataFusionError::ResourcesExhausted(format!(
pub fn pool_limit_error(
        bytes_required, partitions, batch_size, avg_row_bytes,
        bytes_requested, consumer_name, consumer_reserved, available, limit,
    DataFusionError::ResourcesExhausted(format!(
    avg_row_bytes: usize,
) -> DataFusionError {
//!
/// Triggers operator spill; if spill also fails, the query is terminated.
//! Errors produced by these functions are returned as `Err(String)` through `#[ffm_safe]`
/// Java conversion: `CircuitBreakingException` → HTTP 429
    consumer_reserved: usize,
/// a `CircuitBreakingException` with proper bytes_wanted / limit semantics.
/// Produced when `DynamicLimitPool.try_grow` fails, jemalloc confirms pressure,
    critical_pct: u32,
        "Failed to allocate {} bytes for {} ({} already reserved) \
//! them into appropriate OpenSearch exception types.
         minimum parallelism (partitions={}, batch_size={}, avg_row_bytes={}). \
//! with `NativeErrorConverter.java`. The Java parser uses substring matching on
/// Produced when `acquire_budget` cannot reserve the phantom even at minimum
/// Pool limit exceeded during operator execution.
    ))
    partitions: usize,
//! these messages to classify errors.
         — 0 available out of {} limit. \
//! `NativeErrorConverter` (in analytics-engine plugin) parses these messages to convert
///
}
    consumer_reserved: usize,
}
///
 * The OpenSearch Contributors require contributions made to
         Query cancelled: native memory RSS exceeds critical threshold ({}% of pool limit).",
    DataFusionError::ResourcesExhausted(format!(
//! FFM exports, arriving in Java as `RuntimeException(message)`. The Java-side
         Pool capacity exhausted.",
/// spilling cannot recover fast enough — the query is cancelled to protect the node.
    consumer_name: &str,
/*
//! 3. Document the Java exception type and HTTP status in the doc comment.
//! # Contract
        bytes_requested, consumer_name, consumer_reserved, limit, critical_pct,
    available: usize,
/// Key phrase: "Cannot reserve untracked memory budget"
///
///
        "Failed to allocate {} bytes for {} ({} already reserved) \
