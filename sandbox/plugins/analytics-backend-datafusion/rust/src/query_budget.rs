        let row_bytes = 16;
        configured_target_partitions,
        let per_partition = 2 * batch_bytes + decode_overhead;
    total.max(8)
        None => estimate_avg_row_bytes(schema),
    pub phantom_bytes: usize,
/// the cluster setting changes.
            datafusion::execution::memory_pool::GreedyMemoryPool::new(limit),
        // Acquire with exhausted pool — should increment rejections
}
                    );
        );
    use std::num::NonZeroUsize;
//! - Parquet decode buffers (page decompression, dictionary decode)
        num_columns,
    total.max(8)
        let decode_overhead =
    configured_batch_size: usize,
    // capacity=target_partitions. Each partition has decode + in-flight.
    configured_target_partitions: usize,
}
        }
    fn min_target_partitions_setting_still_acts_as_reduction_floor() {
                        .with_can_spill(true);
                    native_bridge_common::log_info!(
        DataType::Utf8 | DataType::Binary => 64,
        let batch_size = 8192;
        DataType::Date64 | DataType::Time64(_) | DataType::Timestamp(_, _) => 8,
        let output_channel = batch_bytes;
        DataType::Boolean => 1,
//! memory allows, reduced parallelism under pressure, rejection only at
//!
        pool,
                .into_iter()
                    batch_size,
                        compute_untracked_bytes_with_columns(
pub struct QueryMemoryBudget {
            total += estimate_field_bytes(field.data_type());
        let partitions = 4;
        .unwrap_or_else(|| estimate_avg_row_bytes(schema));
#[derive(Debug)]
/// This is the preferred path when metadata is cached. Uses actual
                            target_partitions, batch_size
                // Fixed-width: type size is exact. Metadata may include encoding overhead
        assert!(stats.fallbacks.load(Ordering::Relaxed) > fallbacks_before);
        assert_eq!(budget.target_partitions, 4);
    )
        let stats = adaptive_budget();
/// Estimate row bytes considering only the projected columns.
    // Multi-partition: CoalescePartitionsExec adds a merge channel with
pub fn acquire_budget_with_projection(
        } else {
/// burst — each new query arriving when RSS is elevated starts at minimum
        DataType::Duration(_) => 8,
static MIN_TARGET_PARTITIONS_SETTING: AtomicUsize = AtomicUsize::new(1);
        // search.concurrent.max_slice_count). The setting is a floor for
                        prev, target_partitions, phantom_bytes, min_partitions
    #[test]
            schema.fields().len(),
                if resident >= spill_bytes {
    configured_batch_size: usize,
            }
            | DataType::Utf8View
 * SPDX-License-Identifier: Apache-2.0
    MIN_TARGET_PARTITIONS_SETTING.store(value.max(1), Ordering::Release);
/// (typically within 1.1-1.3× of actual RSS) instead of the 2.5-3×
                        reserved, resident, thresholds.admission_reject * 100.0, limit
    crate::memory_guard::should_override(
        let admission_bytes = (limit as f64 * thresholds.admission_throttle) as usize;
        crate::memory_guard::OverrideContext::Admission,
        schema: &SchemaRef,
}
//! parallelism. This gives a graceful degradation path: full parallelism when
        assert_eq!(budget.target_partitions, DEFAULT_MIN_TARGET_PARTITIONS);
        assert_eq!(budget.target_partitions, 2);
    fn try_grow_reduce_budget_rejects_when_pool_exhausted() {
) -> Result<QueryMemoryBudget, DataFusionError> {
        // override a lower configured target_partitions (derived from
        let small_pool = test_pool(2_000_000);
        // Simulate an operator trying to allocate from the same pool
fn compute_untracked_bytes_with_columns(
        DataType::Map(entry, _) => estimate_field_bytes(entry.data_type()) * 4,
/// Computed budget for a query. Carries the phantom reservation that must be
    }
 * compatible open source license.
//! sort buffers). The following are **untracked**:
        let pool = test_pool(1_000_000_000);
pub fn acquire_budget(
        let schema = schema_of(vec![("a", DataType::Int64), ("b", DataType::Int64)]);
            budget.target_partitions < 4,
    #[test]
fn pool_limit(pool: &Arc<dyn MemoryPool>) -> Option<usize> {
//! reduce `target_partitions` to lower the phantom size, retrying with less
    }
    }
        ))
    }
}
                    }
const PARTITION_BUFFER_MULTIPLIER: usize = 3;
        DataType::LargeUtf8 | DataType::LargeBinary => 128,
        let schema = schema_of(vec![("a", DataType::Int64), ("b", DataType::Int64)]);
//! DataFusion's `MemoryPool` only tracks operator-internal state (hash tables,
    };
    let num_columns = schema.fields().len();
    }
        let budget = acquire_budget(&pool, &schema, 4, 8192).unwrap();
        // 8 + 64 = 72, plus 2 nullable → ceil(2/8) = 1 byte bitmap
    }
        }
        ))
//! 1. **Estimate** the untracked memory for the chosen `target_partitions` and
    for (idx, field) in schema.fields().iter().enumerate() {
    let batch_bytes = batch_size * avg_row_bytes;
        // When the configured target is above the floor and memory pressure
        assert!(budget.target_partitions >= 2);
            ("a", DataType::Int64),
                total += estimate_field_bytes(field.data_type());
/// Per-column overhead within a partition (column reader, decompression buffer,
    #[test]
        acquire_budget(pool, schema, target_partitions, batch_size)
        DataType::Int64 | DataType::UInt64 | DataType::Float64 => 8,
    let avg_row_bytes = estimate_row_bytes_from_metadata(schema, metadata)
use std::sync::atomic::{AtomicU64, AtomicUsize, Ordering};
//! # Adaptive fallback
                    ));
    }
    }
//!
    #[test]
///   (metadata is ground truth) and MIN for fixed-width (both are exact).
    pub phantom_reservation: MemoryReservation,
        let after_phantom = pool.reserved();
    let output_channel = batch_bytes;
    use std::sync::Mutex;
    /// Helper for tests with artificially small pools.
    configured_target_partitions: usize,
/// How many batch-sized buffers exist per partition in the pipeline.
                    ADAPTIVE_BUDGET.rejections.fetch_add(1, Ordering::Relaxed);
    /// The phantom reservation occupying pool capacity for untracked memory.
/// over-estimation from static estimates.
pub fn adaptive_budget() -> &'static AdaptiveBudgetStats {
        assert!(reserved_with_budget > 0);
/// - Static type-based estimate (conservative for short strings)
            | DataType::List(_)
}
//!
                // (e.g., RLE/dictionary pages) that inflates the number.
/// rejects it, iteratively halves target_partitions until it fits.
///
/// Compute and reserve a memory budget for a query.
        let reserved = pool.reserved();
                    phantom_reservation: reservation,
        set_min_target_partitions(2);
    target_partitions: usize,
//! extreme saturation.
                return Ok(QueryMemoryBudget {
            if resident > 0 {
        let reserved_with_budget = pool.reserved();
        let single = compute_untracked_bytes_with_columns(1, batch_size, row_bytes, 2);
use parquet::file::metadata::ParquetMetaData;
                            phantom_bytes,
                    let prev = batch_size;
                        min_partitions,
//!
            let resident = crate::memory_guard::cached_resident_bytes();
        // Caller asks for 2 partitions; setting is 8. Result must stay at 2.
/// parallelism, limiting its hash table growth and total memory footprint.
    fn estimate_empty_schema_returns_minimum() {
        assert!(single < multi);
        // Reproduces the bug where `datafusion.min_target_partitions=8` would
        assert!(stats.rejections.load(Ordering::Relaxed) > rejections_before);
    let per_partition = PARTITION_BUFFER_MULTIPLIER * batch_bytes + decode_overhead;
        DataType::Decimal128(_, _) => 16,
        avg_row_bytes,
    configured_batch_size: usize,
            ("b", DataType::Int64),
///   an under-estimate from static. So we actually want MAX for variable-length columns
    let decode_overhead =
                    native_bridge_common::log_info!(
use datafusion::arrow::datatypes::{DataType, SchemaRef};
                            avg_row_bytes,
        // Now try to exceed — this should fail, triggering spill in a real operator
        let pool = test_pool(1_000_000_000);
    /// Drop this when the query completes to release the capacity.
        batch_size,
    // This avoids the ~5µs jemalloc epoch.advance cost on the happy path.
        );
    }
                        MIN_BATCH_SIZE,
    num_columns: usize,
    let mut total: usize = 0;
static ADAPTIVE_BUDGET: Lazy<AdaptiveBudgetStats> = Lazy::new(|| AdaptiveBudgetStats {
    let min_partitions = get_min_target_partitions().min(configured_target_partitions.max(1));
                        pool.grow(&reservation, phantom_bytes);
        let result = try_grow_reduce_budget(&pool, &schema, 8192, 4, 0);
        }
    /// Serializes tests that mutate the process-global MIN_TARGET_PARTITIONS_SETTING.
        DataType::Time32(_) => 4,
        configured_batch_size,
    match dt {
            .contains("Cannot reserve untracked memory budget"));
//!
        let per_part = 3 * batch_bytes + decode_overhead;
//! 3. Let the query run at full configured parallelism.
        let pool = test_pool(1_000_000); // 1MB — forces batch reduction
    }
            } else {
        }
        let schema = schema_of(vec![("a", DataType::Int64)]);
        configured_batch_size,
        let result = try_grow_reduce_budget(&pool, &schema, 8192, 4, needed + 1).unwrap();
        assert_eq!(estimate_avg_row_bytes(&schema), 8);
    // Proactive admission guard: only consult jemalloc RSS when the pool's own
//!    `batch_size` from the schema.
        let thresholds = crate::memory_guard::get_thresholds();
/// `uncompressed_size / num_rows` per column from the first row group
            .sum(),
//!
    acquire_budget_inner(
        let pool = test_pool(1_000_000_000);
                // pool's rejection is a false positive (stale phantoms from
    // value below the setting is left untouched.
}
    let mut batch_size = configured_batch_size.max(MIN_BATCH_SIZE);
        let needed = compute_untracked_bytes_with_columns(
        let batch_size = 8192;
                if resident >= admission_threshold_bytes {
//! - OpenSearch field mappings with known cardinality (keyword fields)
        return Ok(None);
        let schema = schema_of(vec![("a", DataType::LargeBinary)]); // 128 bytes/row
            .unwrap_err()
    }
        let _guard = MIN_PARTITIONS_TEST_LOCK.lock().unwrap();
        let pool = test_pool(1024);
/// Estimate average row size in bytes from a schema.
        Arc::new(datafusion::execution::memory_pool::TrackConsumersPool::new(
    pub target_partitions: usize,
                    (limit as f64 * thresholds.admission_throttle) as i64;
            .iter()
/// (e.g. derived from `search.concurrent.max_slice_count`).
//! - Query-level hint via `DatafusionQueryConfig`
    #[test]
    fn acquire_budget_test(
fn estimate_field_bytes(dt: &DataType) -> usize {
) -> Result<QueryMemoryBudget, DataFusionError> {
pub fn set_min_target_partitions(value: usize) {
        num_columns,
                    // RSS at spill threshold (85%) — reject immediately.
            let measured = col_chunk.uncompressed_size() as usize / num_rows;
    #[test]
                    batch_size = (batch_size / 2).max(MIN_BATCH_SIZE);
            }
        let expected = 4 * per_part + batch_bytes;
        // Pool is 10MB. Phantom takes ~5MB. Operator only gets ~5MB before spill.
            Ok(()) => {
        DataType::Decimal256(_, _) => 32,
        if let Some(field) = schema.fields().get(idx) {
        assert_eq!(pool.reserved(), 0);
}
                            phantom_reservation: reservation,
}
///
                    ADAPTIVE_BUDGET.rejections.fetch_add(1, Ordering::Relaxed);
    }
        let budget = acquire_budget(&pool, &schema, 4, 8192).unwrap();
/// Acquire budget using measured row bytes from parquet metadata.
        let row_bytes = 16;
        MemoryLimit::Finite(limit) => Some(limit),
    /// Bytes reserved by the phantom (informational).
        ]); // 32 bytes/row
/// covers the estimate. Returns Err if the pool cannot fit the phantom even at
                    target_partitions,
//! # Solution: Phantom Reservation + Spill Pressure
}
    )
        DataType::Date32 => 4,
) -> Option<usize> {
    #[test]
            }
    num_columns: usize,
        let pool = test_pool(500_000);
    #[test]
        let schema = schema_of(vec![
//! (tracked + untracked), and operators automatically spill to stay within it.
    use super::*;
    MIN_TARGET_PARTITIONS_SETTING.load(Ordering::Acquire)
        let num_columns = 3;
    let avg_row_bytes = estimate_avg_row_bytes(schema);
            ("b", DataType::Int64),
            ("d", DataType::Int64),
        // adaptive reduction, so it must be a no-op when configured ≤ floor.
    // Null bitmaps: 1 bit per nullable column per row, rounded up to bytes
            .map(|f| estimate_field_bytes(f.data_type()))
        assert!(result.is_some());
        let schema = schema_of(vec![("a", DataType::Int64), ("b", DataType::Int64)]);
/// Updated from Java when the cluster setting `datafusion.min_target_partitions`
        avg_row_bytes,
        return per_partition + output_channel;
            8192,
        pool,
        DataType::FixedSizeBinary(n) => *n as usize,
            "query_untracked(partitions={},batch={})",
    configured_target_partitions: usize,
//! 2. **Reserve** that estimate from the pool as a phantom "untracked overhead"
    fn compute_untracked_bytes_formula() {
            budget.target_partitions
        if reserved >= admission_bytes {
    acquire_budget_inner(
            avg_row_bytes,
                        "Memory pressure: reducing batch_size {} -> {} at target_partitions={} (phantom {} bytes failed)",
//! memory, the pool's limit underestimates true memory usage, and operators
                        ),
        assert!(result.is_err(), "expected Err when pool is exhausted");
        let mut reservation = consumer.register(pool);
        let result = try_grow_reduce_budget(&pool, &schema, 8192, 4, 0).unwrap();
                        return Ok(QueryMemoryBudget {
    if num_rows == 0 {
    #[test]
});
/// For fixed-width types: exact byte width.
/// so it cannot raise the starting value above what the caller requested
        // Existing reservation is larger — should return Ok(None)
        assert!(budget.phantom_bytes > 0);
/// existing reservation already covers the new estimate (e.g. a prior child
            nullable_count += 1;
        Some(indices) => indices.len(),
    matches!(
        pool: &Arc<dyn MemoryPool>,
mod tests {
    let mut total: usize = 0;
        let pool = test_pool(2_000_000);
    fn phantom_freed_on_drop() {
use std::sync::Arc;
        assert!(
    total += (nullable_count + 7) / 8;
        let pool = test_pool(1_000_000_000); // 1GB
/// Revised strategy: for variable-length types, use metadata (ground truth).
                            "query_untracked(partitions={},batch={},jemalloc_override)",
                } else if batch_size > MIN_BATCH_SIZE {
        // Single partition should use less than half of 2-partition (no merge channel multiplier)
        assert_eq!(budget.target_partitions, 4);
        let budget = result.unwrap();
/// Attempts to reserve a phantom allocation representing the untracked memory
/// Set the minimum target partitions floor at runtime. Called from Java when
    };
}
/// `target_partitions` until the reservation succeeds or we hit the minimum.
        let prev = get_min_target_partitions();
//!
//! # When even spilling isn't enough
        let wide_schema = schema_of(vec![("a", DataType::Int64), ("b", DataType::Int64)]);
        assert_eq!(budget.batch_size, 8192);
    }
}
            | DataType::LargeList(_)
    fn schema_of(fields: Vec<(&str, DataType)>) -> SchemaRef {
        avg_row_bytes,
) -> usize {
//! When parquet column statistics include `distinct_count` (NDV), the budget
    }
//! - Channel buffers (`CoalescePartitionsExec` mpsc, `CrossRtStream` mpsc)
                        prev, batch_size, target_partitions, phantom_bytes
/// Read the current minimum target partitions floor.
/// - Short strings (10 bytes): static=64 wins, metadata≈14 (includes offset overhead) → uses 14
        let tiny_pool = test_pool(1000);
    .map(Some)
    }
/// Configurable minimum target_partitions floor for adaptive reduction.
        // No CoalescePartitionsExec, no merge channel. Pipeline is:
        assert_eq!(estimate_avg_row_bytes(&schema), 21);
                        let reservation = consumer.register(pool);
                    target_partitions = (target_partitions / 2).max(min_partitions);
                        "Memory pressure: reducing target_partitions {} -> {} (phantom {} bytes failed, floor={})",
                }
        let _ = acquire_budget(&small_pool, &wide_schema, 8, 8192).unwrap();
/// Minimum batch_size floor.
        let budget = result.unwrap();
//!
    if target_partitions == 1 {
        let schema = schema_of(vec![("id", DataType::Int64), ("name", DataType::Utf8)]);
        match reservation.try_grow(phantom_bytes) {
    #[test]
            }
    let mut nullable_count: usize = 0;
/// - 1 batch: in-flight between FileStream and CoalescePartitionsExec
}
    compute_untracked_bytes_with_columns(target_partitions, batch_size, avg_row_bytes, 0)
}
/// instead of static type-based estimates. Produces tight phantoms
/// from a prior child registration (if any). Skips acquisition when the
                        let consumer = MemoryConsumer::new(format!(
const DEFAULT_MIN_TARGET_PARTITIONS: usize = 1;
        assert!(budget.batch_size >= MIN_BATCH_SIZE);
pub fn get_min_target_partitions() -> usize {
/// Includes 1 bit per nullable column for the validity bitmap.
            "expected partitions < 4, got {}",
}
    #[test]
/// For fixed-width types, use the type size (exact).
    #[test]
    batch_size: usize,
    #[test]
                    return Err(crate::native_error::admission_rejected_error(
    configured_target_partitions: usize,
            | DataType::Binary
//! Per-query budgeting with spill-on-exceed semantics.
        batch_size: usize,
            target_partitions,
                    );
    );
    }
//! could leave proportional headroom for hash aggregation / distinct operators:
///
    )
 * this file be licensed under the Apache-2.0 license or a
    use datafusion::arrow::datatypes::{Field, Schema};
            Err(_) => {
/// Returns `Err` only if even `target_partitions=1` with `batch_size=MIN`
//!
}
/// Returns a reference to the global budget stats counters.
        DataType::Struct(fields) => fields
        assert_eq!(pool.reserved(), budget.phantom_bytes);
        PAGE_DECODE_BASE_OVERHEAD_BYTES + num_columns * PER_COLUMN_DECODE_OVERHEAD_BYTES;
) -> Result<QueryMemoryBudget, DataFusionError> {
/*
        configured_target_partitions,
            fields
        None => schema.fields().len(),
        let result = acquire_budget_test(&pool, &schema, 4, 8192);
        _ => None,
    )
//! - Parquet column chunk statistics (`Statistics::distinct_count()`)
                            batch_size,
/// Extract pool limit if finite.
fn is_variable_length(dt: &DataType) -> bool {
        // Untracked: 1 decode buffer + 1 in-flight + 1 CrossRtStream slot
    fn min_target_partitions_setting_does_not_raise_configured_value() {
}
        drop(reservation);
                    ADAPTIVE_BUDGET.fallbacks.fetch_add(1, Ordering::Relaxed);
/// Base per-partition overhead for parquet decode structures (metadata parsing,
/// - ~1 batch: parquet decode working buffer (decompressed page → arrow arrays)
//! # Problem
        let multi = compute_untracked_bytes_with_columns(2, batch_size, row_bytes, 2);
                    ));
        pool,
                    // Better to reject with clear backpressure than admit and fail slowly.
//! (`try_grow` returns `ResourcesExhausted`), the query is rejected at
            NonZeroUsize::new(5).unwrap(),
                            MIN_BATCH_SIZE,
    schema: &SchemaRef,
        let result = try_grow_reduce_budget(&pool, &schema, 8192, 4, 0).unwrap();
        );
    fn single_partition_avoids_coalesce_overhead() {
    )
        let schema = schema_of(vec![("a", DataType::Int64)]);
        avg_row_bytes,
//! - They trigger spill-to-disk, freeing tracked memory.
        assert!(budget.target_partitions < 8);
    }
        // forces reduction, target_partitions must not drop below the floor.
    }
    avg_row_bytes: usize,
        let prev = get_min_target_partitions();
    schema: &SchemaRef,
        _ => 32,
    target_partitions: usize,
                // Variable-length: metadata is ground truth (includes offset array overhead
) -> Result<QueryMemoryBudget, DataFusionError> {
    fn adaptive_budget_counters_increment() {
    }
//! # TODO: Cardinality-aware operator headroom
    loop {
        assert_eq!(result, expected);
fn acquire_budget_inner(
                    native_bridge_common::log_info!(
                });
        // Pool with only 2MB — not enough for 8 partitions
        let pool = test_pool(10_000_000);
}
/// Returns `None` if metadata doesn't have useful stats (empty file, etc.).
                        reserved, resident, thresholds.admission_throttle * 100.0, min_partitions
        return None;
    let first_rg = metadata.row_groups().first()?;
const MIN_BATCH_SIZE: usize = 1024;
        None,
    #[test]
}
        Some(indices) => estimate_projected_row_bytes(schema, indices),
    // derived from `search.concurrent.max_slice_count`). Clamp so a configured
    fn phantom_creates_spill_pressure_for_operators() {
            4 * estimate_field_bytes(inner.data_type())
const PER_COLUMN_DECODE_OVERHEAD_BYTES: usize = 4 * 1024;
                        });
    #[test]
        assert!(budget.target_partitions < 8);
        set_min_target_partitions(8);
        if idx < first_rg.columns().len() {
        DataType::Utf8View | DataType::BinaryView => 64,
            target_partitions, batch_size
                            target_partitions,
///
        ]);
/// For each column, takes the **minimum** of:
        batch_size,
    fn test_pool(limit: usize) -> Arc<dyn MemoryPool> {
//! This phantom reservation **occupies** pool capacity that would otherwise be
    // Then CrossRtStream adds 1 more output slot.
        ))
    acquire_budget_with_projection(
    acquire_budget_inner(
    batch_size: usize,
use datafusion::execution::memory_pool::{
/// Same as [`acquire_budget`] but accepts an optional projection.
        configured_target_partitions,
    metadata: &ParquetMetaData,
        let consumer = MemoryConsumer::new("hash_agg");
        let rejections_before = stats.rejections.load(Ordering::Relaxed);
        ]);
/// threshold (default 70% of pool limit), immediately reduces partitions to
/// row group state, page index). Independent of column count.
    schema: &SchemaRef,
    #[test]
    pub rejections: AtomicU64,
pub struct AdaptiveBudgetStats {
/// Delegates to the common memory guard for admission-level override check.
pub fn estimate_row_bytes_from_metadata(
    fallbacks: AtomicU64::new(0),
        let _ = acquire_budget(&pool, &schema, 4, 8192).unwrap();
    pub batch_size: usize,
    let num_columns = schema.fields().len();
    // raise target_partitions above what the caller already configured (e.g.
        assert!(budget.phantom_bytes <= 2_000_000);
        .with_can_spill(true);
#[cfg(test)]
            compute_untracked_bytes_with_columns(partitions, batch_size, row_bytes, num_columns);
        let budget = acquire_budget(&pool, &schema, 2, 8192).unwrap();
//! headroom.
        let budget = acquire_budget_test(&pool, &schema, 8, 8192).unwrap();
        let pool = test_pool(1000); // Tiny pool — even minimum won't fit
    }
                    if jemalloc_says_headroom_available(limit) {
        pool,
    configured_batch_size: usize,
                drop(reservation);
                // queries whose Drop hasn't propagated, accounting drift).
        }
    #[test]
    rejections: AtomicU64::new(0),
        assert!(result
                .map(|(name, dt)| Field::new(name, dt, true))
        // Tiny pool that can't fit anything
        if field.is_nullable() {
        // FileStream → CrossRtStream(1 slot) → Java
    let avg_row_bytes = match projected_columns {
        DataType::Int32 | DataType::UInt32 | DataType::Float32 => 4,
    static MIN_PARTITIONS_TEST_LOCK: Mutex<()> = Mutex::new(());
///
    pool: &Arc<dyn MemoryPool>,
            ("a", DataType::Int64),
/// If `projected_columns` is provided, only those columns contribute to the
            4,
}
    MemoryConsumer, MemoryLimit, MemoryPool, MemoryReservation,
fn compute_untracked_bytes(
//!
        assert!(reservation.try_grow(remaining).is_ok());
            estimate_avg_row_bytes(&schema),
//! The net effect: the pool limit now represents the **actual** RSS bound
 *
    // reservation accounting already shows pressure (>= admission threshold).
/// dictionary decode state). ~4KB per active column reader.
//! - Their `try_grow` calls fail earlier.
        DataType::Int8 | DataType::UInt8 => 1,
        assert!(budget.phantom_bytes > 0);
/// cannot fit — the query should be rejected.
            | DataType::LargeBinary
        drop(budget);
    let mut target_partitions = configured_target_partitions.max(1);
                    phantom_bytes,
/// Derived from the execution pipeline:
                // RSS between admission (70%) and operator (85%) — reduce partitions
                // Both pool and jemalloc confirm pressure — reduce parallelism
    pool: &Arc<dyn MemoryPool>,
        set_min_target_partitions(prev);
                            num_columns,
        assert!(result.is_err());
                        avg_row_bytes,
/// held for the query's lifetime.
/// Tries to reserve a phantom at the configured parallelism. If the pool
        let fallbacks_before = stats.fallbacks.load(Ordering::Relaxed);
pub fn estimate_avg_row_bytes(schema: &SchemaRef) -> usize {
        configured_target_partitions,
            PAGE_DECODE_BASE_OVERHEAD_BYTES + num_columns * PER_COLUMN_DECODE_OVERHEAD_BYTES;
        drop(budget);
    fn try_grow_reduce_budget_skips_when_existing_covers() {
                .collect::<Vec<_>>(),
    avg_row_bytes: usize,
        num_columns,
fn estimate_projected_row_bytes(schema: &SchemaRef, indices: &[usize]) -> usize {
fn jemalloc_says_headroom_available(pool_limit_bytes: usize) -> bool {
/// target_partitions=1 — the reduce should be rejected.
    ) -> Result<QueryMemoryBudget, DataFusionError> {
        configured_batch_size,
    let num_rows = first_rg.num_rows() as usize;
            ("id", DataType::Int64),
        schema,
    }
    // The setting acts purely as a floor for adaptive reduction. It must never
                if let Some(limit) = pool_limit(pool) {
/// This produces the tightest correct estimate regardless of string length:
        // Try to allocate what's left
    pool: &Arc<dyn MemoryPool>,
            ("c", DataType::Int64),
        assert!(budget.target_partitions >= DEFAULT_MIN_TARGET_PARTITIONS);
};
    fn acquire_budget_rejects_when_fully_exhausted() {
                        "Admission REJECTED: pool reserved={}B, RSS={}B >= spill threshold ({:.0}% of {}B). Node under memory pressure.",
            ("c", DataType::Utf8),
        let schema = Arc::new(Schema::empty());
                        MIN_BATCH_SIZE,
}
                    );
                total += measured;
    for field in schema.fields() {
        // Successful acquire — should not increment fallbacks/rejections
    #[test]
    }
//! - In-flight `RecordBatch`es between operators
    for &idx in indices {
        let result =
    pub fallbacks: AtomicU64,
                if target_partitions > min_partitions {
    projected_columns: Option<&[usize]>,
        let batch_bytes = batch_size * row_bytes; // 131072
            | DataType::Map(_, _)
//! This would prevent the phantom from starving high-cardinality GROUP BY
///
    /// Effective batch_size to use.
        let pool = test_pool(2_000_000);
    let num_columns = match projected_columns {
        let phantom_bytes = compute_untracked_bytes_with_columns(
        // No existing reservation — should acquire
    pool: &Arc<dyn MemoryPool>,
        DataType::FixedSizeList(inner, n) => *n as usize * estimate_field_bytes(inner.data_type()),
            total += estimate_field_bytes(field.data_type());
    target_partitions * per_partition + output_channel
                        avg_row_bytes,
                }
        let consumer = MemoryConsumer::new(format!(
            ("count", DataType::Int32),
        let budget = acquire_budget(&pool, &schema, 8, 8192).unwrap();
/// row-width estimate (much tighter for narrow projections on wide tables).
    pool: &Arc<dyn MemoryPool>,
/// reservation based on a child input's schema. Compares the estimated
                    return Err(crate::native_error::admission_rejected_error(
        }
        target_partitions: usize,
    avg_row_bytes: usize,
    fn estimate_variable_width_schema() {
    fn acquire_budget_succeeds_with_plenty_of_memory() {
        pool_limit_bytes,
    &ADAPTIVE_BUDGET
pub fn acquire_budget_from_metadata(
    )
///
/// Compute the untracked byte envelope for given parameters.
//! - The system stays within the pool limit (tracked + phantom ≤ pool_limit).
                        ))
        // Acquire with tiny pool that forces fallback
        let budget = acquire_budget_test(&pool, &schema, 4, 8192).unwrap();
        let _guard = MIN_PARTITIONS_TEST_LOCK.lock().unwrap();
            .to_string()
        let schema = schema_of(vec![("a", DataType::Int64), ("b", DataType::Int64)]);
        DataType::Interval(_) => 16,
/// had a wider schema). Returns Ok(None) when the existing reservation already
        Arc::new(Schema::new(
                    );
        DataType::Utf8
    }
//! admission time with a clear error — before any work begins.
        dt,
    }
            num_columns,
//! queries that need large hash tables. Without NDV, operators rely on
/// **Proactive RSS check**: before attempting pool reservation, consults
    }
//!
    fn acquire_budget_reduces_partitions_under_pressure() {
        assert!(result.is_none());
        let pool = test_pool(100_000_000);
///
            | DataType::BinaryView
///
/// - 1 batch: buffered in the CoalescePartitionsExec mpsc channel slot
/// Attempt to acquire or grow the coordinator-reduce session's phantom
        // 8 + 8 + 4 = 20, plus 3 nullable columns → ceil(3/8) = 1 byte bitmap
        let schema = schema_of(vec![("a", DataType::Int64), ("b", DataType::Int64)]);
        num_columns,
//! If the pool is so exhausted that even the phantom reservation itself fails
                    let prev = target_partitions;
    if needed <= prior_partition_reservation_bytes {
    if let Some(limit) = pool_limit(pool) {
) -> Result<Option<QueryMemoryBudget>, DataFusionError> {
        DataType::Int16 | DataType::UInt16 | DataType::Float16 => 2,
/// Cumulative counters for budget fallbacks and rejections.
/// Core budget acquisition logic. All public entry points delegate here.
//! - Spillable operators (HashAgg, Sort) see less available capacity.
    schema: &SchemaRef,
//!
    /// Effective target_partitions to use.
                        compute_untracked_bytes(min_partitions, MIN_BATCH_SIZE, avg_row_bytes),
        let budget = acquire_budget(&pool, &schema, 4, 8192).unwrap();
/// - `uncompressed_size / num_rows` from parquet (accurate for long strings)
        let mut reservation = consumer.register(&pool);
    fn estimate_fixed_width_schema() {
/// jemalloc's resident bytes. If physical memory already exceeds the admission
            if is_variable_length(field.data_type()) {
        assert!(budget.batch_size < 8192);
//! DataFusion's spill mechanism (safe but slower). Sources for NDV:
        configured_target_partitions,
        DataType::List(inner) | DataType::LargeList(inner) => {
//! that *could* spill don't trigger spill because the pool appears to have
        let schema = schema_of(vec![("a", DataType::Int64), ("b", DataType::Utf8)]);
    }
                    native_bridge_common::log_info!(
                // If actual process memory is well below the pool limit, the
    match pool.memory_limit() {
        assert_eq!(estimate_avg_row_bytes(&schema), 73);
                }
/// changes. The floor is clamped per-call to the configured target_partitions,
///
    prior_partition_reservation_bytes: usize,
//!    `MemoryConsumer` (marked `can_spill = true`).
pub fn try_grow_reduce_budget(
        let schema = schema_of(vec![
        assert!(result.is_err());
    batch_size: usize,
    configured_target_partitions: usize,
            | DataType::LargeUtf8
    schema: &SchemaRef,
    fn try_grow_reduce_budget_acquires_when_needed_exceeds_existing() {
//! When the phantom reservation fails, the budget calculator can optionally
        let schema = schema_of(vec![("a", DataType::Int64), ("b", DataType::Int64)]);
        let schema = schema_of(vec![
                    target_partitions = min_partitions;
        let result = acquire_budget(&tiny_pool, &schema, 4, 8192);
                let admission_threshold_bytes =
    }
/// For variable-width types: conservative static estimate.
/// the minimum. This prevents the "20 queries all pass admission simultaneously"
                    ADAPTIVE_BUDGET.fallbacks.fetch_add(1, Ordering::Relaxed);
/// Returns at least 8 bytes (minimum for one Int64 column).
                // Before reducing: consult jemalloc as second source of truth.
/// Refine row-width estimate using actual column sizes from parquet metadata.
                        min_partitions,
 */
use datafusion::common::DataFusionError;
///
                let spill_bytes = (limit as f64 * thresholds.admission_reject) as i64;
///
    metadata: &ParquetMetaData,
                // Proceed at current parallelism via infallible grow.
    }
        let remaining = 10_000_000 - after_phantom;
/// Compute untracked bytes with column-count-aware decode overhead.
    Some(total.max(8))
        assert!(result.is_some());
    fn acquire_budget_reduces_batch_size_at_min_partitions() {
    }
/// Default minimum target_partitions floor (used if the dynamic setting hasn't been set).
                }
    }
                        "Admission: pool reserved={}B, RSS={}B >= admission threshold ({:.0}%) — reducing to min partitions={}",
                    // Even at min partitions this query will hit spill on first batch.
/// at full configured parallelism. If that fails, iteratively halves
        let schema = schema_of(vec![("a", DataType::Int64)]);
            batch_size,
/// - Long strings (500 bytes): static=64 loses, metadata≈504 → uses 504... wait, that's
) -> usize {
    fn try_grow_reduce_budget_adapts_partitions_under_pressure() {
use once_cell::sync::Lazy;
            let col_chunk = &first_rg.columns()[idx];
//!
    let needed = compute_untracked_bytes_with_columns(
        let pool = test_pool(1_000_000_000);
//!   headroom = NDV × (key_bytes + accumulator_bytes_per_group)
                            min_partitions,
 * The OpenSearch Contributors require contributions made to
/// untracked memory for this schema against the reservation already held
            ("price", DataType::Float64),
        assert!(reservation.try_grow(1).is_err());
                // which Arrow also has). Use it directly — it's the actual decoded size.
        total += estimate_field_bytes(field.data_type());
        // Small pool forces partition reduction
//!
//! Instead of clamping `target_partitions` (which reduces throughput), we:
//! More partitions multiply all of the above. Without accounting for untracked
const PAGE_DECODE_BASE_OVERHEAD_BYTES: usize = 64 * 1024;
    let mut total: usize = 0;
        set_min_target_partitions(prev);
    }
//! available to operators. When the pool is under pressure:
                } else {
