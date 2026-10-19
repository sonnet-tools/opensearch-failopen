    }
            .map(|f| estimate_field_bytes(f.data_type()))
//! 3. Let the query run at full configured parallelism.
//! This phantom reservation **occupies** pool capacity that would otherwise be
    let first_rg = metadata.row_groups().first()?;
///
    // Null bitmaps: 1 bit per nullable column per row, rounded up to bytes
                            target_partitions, batch_size
    }
        let small_pool = test_pool(2_000_000);
        assert!(budget.phantom_bytes > 0);
}
                        let consumer = MemoryConsumer::new(format!(
        let schema = schema_of(vec![("a", DataType::Int64), ("b", DataType::Int64)]);
    let num_columns = schema.fields().len();
                total += estimate_field_bytes(field.data_type());
            }
/// instead of static type-based estimates. Produces tight phantoms
                    native_bridge_common::log_info!(
    fn single_partition_avoids_coalesce_overhead() {
        assert_eq!(budget.target_partitions, 4);
        drop(reservation);
        Arc::new(Schema::new(
}
        schema: &SchemaRef,
        let pool = test_pool(1_000_000_000);
//! - They trigger spill-to-disk, freeing tracked memory.
    }
    let num_columns = match projected_columns {
            ("c", DataType::Utf8),
        avg_row_bytes,
                        ))
            target_partitions, batch_size
/// Same as [`acquire_budget`] but accepts an optional projection.
                if target_partitions > min_partitions {
    }
                        reserved, resident, thresholds.admission_throttle * 100.0, min_partitions
pub fn acquire_budget(
            let col_chunk = &first_rg.columns()[idx];
//! # Problem
        configured_target_partitions,
    #[test]
        let result = try_grow_reduce_budget(&pool, &schema, 8192, 4, 0).unwrap();
    pub phantom_bytes: usize,
                        reserved, resident, thresholds.admission_reject * 100.0, limit
//!
        avg_row_bytes,
                            phantom_reservation: reservation,
                if resident >= spill_bytes {
                .collect::<Vec<_>>(),
/// Default minimum target_partitions floor (used if the dynamic setting hasn't been set).
/// covers the estimate. Returns Err if the pool cannot fit the phantom even at
        // Acquire with exhausted pool — should increment rejections
/// Attempts to reserve a phantom allocation representing the untracked memory
/// target_partitions=1 — the reduce should be rejected.
    configured_target_partitions: usize,
        let schema = schema_of(vec![("a", DataType::Int64)]);
    // Then CrossRtStream adds 1 more output slot.
            compute_untracked_bytes_with_columns(partitions, batch_size, row_bytes, num_columns);
//! extreme saturation.
//! - Spillable operators (HashAgg, Sort) see less available capacity.
    schema: &SchemaRef,
    let per_partition = PARTITION_BUFFER_MULTIPLIER * batch_bytes + decode_overhead;
    let min_partitions = get_min_target_partitions().min(configured_target_partitions.max(1));
 * this file be licensed under the Apache-2.0 license or a
/// Returns a reference to the global budget stats counters.
        drop(budget);
pub struct AdaptiveBudgetStats {
        ))
        let single = compute_untracked_bytes_with_columns(1, batch_size, row_bytes, 2);
/// Acquire budget using measured row bytes from parquet metadata.
//! - In-flight `RecordBatch`es between operators
        let _guard = MIN_PARTITIONS_TEST_LOCK.lock().unwrap();
    num_columns: usize,
                // Both pool and jemalloc confirm pressure — reduce parallelism
                        .with_can_spill(true);
    acquire_budget_inner(
    #[test]
    /// Effective batch_size to use.
        batch_size: usize,
static MIN_TARGET_PARTITIONS_SETTING: AtomicUsize = AtomicUsize::new(1);
                        "Memory pressure: reducing batch_size {} -> {} at target_partitions={} (phantom {} bytes failed)",
        let wide_schema = schema_of(vec![("a", DataType::Int64), ("b", DataType::Int64)]);
            .to_string()
///
    #[test]
/// `target_partitions` until the reservation succeeds or we hit the minimum.
        if reserved >= admission_bytes {
        // Successful acquire — should not increment fallbacks/rejections
    )
                        min_partitions,
        configured_target_partitions,
pub struct QueryMemoryBudget {
                    ADAPTIVE_BUDGET.rejections.fetch_add(1, Ordering::Relaxed);
                total += measured;
//!
            .unwrap_err()
                    // Even at min partitions this query will hit spill on first batch.
        DataType::Interval(_) => 16,
            .sum(),
                }
                        return Ok(QueryMemoryBudget {
    }
/// changes. The floor is clamped per-call to the configured target_partitions,
                // Before reducing: consult jemalloc as second source of truth.
/// For fixed-width types: exact byte width.
        if let Some(field) = schema.fields().get(idx) {
use parquet::file::metadata::ParquetMetaData;
/// Tries to reserve a phantom at the configured parallelism. If the pool
                }
    MemoryConsumer, MemoryLimit, MemoryPool, MemoryReservation,
            | DataType::List(_)
/*
//!
    use datafusion::arrow::datatypes::{Field, Schema};
        ))
        let budget = result.unwrap();
            num_columns,
pub fn try_grow_reduce_budget(
/// Estimate row bytes considering only the projected columns.
    }
    }
                }
            ("a", DataType::Int64),
        // Untracked: 1 decode buffer + 1 in-flight + 1 CrossRtStream slot
                    // Better to reject with clear backpressure than admit and fail slowly.
fn estimate_projected_row_bytes(schema: &SchemaRef, indices: &[usize]) -> usize {
        PAGE_DECODE_BASE_OVERHEAD_BYTES + num_columns * PER_COLUMN_DECODE_OVERHEAD_BYTES;
        _ => 32,
            }
        assert_eq!(estimate_avg_row_bytes(&schema), 21);
        assert!(reservation.try_grow(remaining).is_ok());
        assert!(stats.fallbacks.load(Ordering::Relaxed) > fallbacks_before);
///
    pool: &Arc<dyn MemoryPool>,
        assert_eq!(budget.target_partitions, 4);
        ))
        assert!(reserved_with_budget > 0);
        assert!(result.is_none());
                    native_bridge_common::log_info!(
use datafusion::execution::memory_pool::{
/// - Static type-based estimate (conservative for short strings)
        batch_size,
        let pool = test_pool(1_000_000); // 1MB — forces batch reduction
    avg_row_bytes: usize,
//! When parquet column statistics include `distinct_count` (NDV), the budget
    compute_untracked_bytes_with_columns(target_partitions, batch_size, avg_row_bytes, 0)
        assert!(reservation.try_grow(1).is_err());
//!
/// - `uncompressed_size / num_rows` from parquet (accurate for long strings)
        assert_eq!(budget.batch_size, 8192);
//! could leave proportional headroom for hash aggregation / distinct operators:
//!
static ADAPTIVE_BUDGET: Lazy<AdaptiveBudgetStats> = Lazy::new(|| AdaptiveBudgetStats {
        // Acquire with tiny pool that forces fallback
                // pool's rejection is a false positive (stale phantoms from
                        MIN_BATCH_SIZE,
        // override a lower configured target_partitions (derived from
            ("d", DataType::Int64),
    if target_partitions == 1 {
    acquire_budget_inner(
    // Proactive admission guard: only consult jemalloc RSS when the pool's own
fn compute_untracked_bytes(
        let pool = test_pool(1_000_000_000);
            PAGE_DECODE_BASE_OVERHEAD_BYTES + num_columns * PER_COLUMN_DECODE_OVERHEAD_BYTES;
            ("id", DataType::Int64),
                    );
}
            } else {
}
    acquire_budget_inner(
//! When the phantom reservation fails, the budget calculator can optionally
        DataType::LargeUtf8 | DataType::LargeBinary => 128,
pub fn acquire_budget_from_metadata(
});
    }
                // Fixed-width: type size is exact. Metadata may include encoding overhead
            NonZeroUsize::new(5).unwrap(),
    fn estimate_empty_schema_returns_minimum() {
/// the cluster setting changes.
        configured_batch_size,
fn acquire_budget_inner(
    schema: &SchemaRef,
                    ));
    batch_size: usize,
        }
        DataType::Map(entry, _) => estimate_field_bytes(entry.data_type()) * 4,
use once_cell::sync::Lazy;
    }
/// the minimum. This prevents the "20 queries all pass admission simultaneously"
    #[test]
        ]);
/// Includes 1 bit per nullable column for the validity bitmap.
        let schema = Arc::new(Schema::empty());
    pub target_partitions: usize,
//! # Solution: Phantom Reservation + Spill Pressure
    }
    }
        num_columns,
        DataType::Time32(_) => 4,
};
            total += estimate_field_bytes(field.data_type());
        assert_eq!(estimate_avg_row_bytes(&schema), 73);
        num_columns,
        _ => None,
        let pool = test_pool(1_000_000_000);
            .contains("Cannot reserve untracked memory budget"));
/// dictionary decode state). ~4KB per active column reader.
                        compute_untracked_bytes_with_columns(
/// reservation based on a child input's schema. Compares the estimated
use datafusion::common::DataFusionError;
) -> usize {
}
                        MIN_BATCH_SIZE,
        let needed = compute_untracked_bytes_with_columns(
        // No CoalescePartitionsExec, no merge channel. Pipeline is:
/// (typically within 1.1-1.3× of actual RSS) instead of the 2.5-3×
        let prev = get_min_target_partitions();
            | DataType::BinaryView
            | DataType::LargeUtf8
}
        let fallbacks_before = stats.fallbacks.load(Ordering::Relaxed);
                return Ok(QueryMemoryBudget {
            4 * estimate_field_bytes(inner.data_type())
    // The setting acts purely as a floor for adaptive reduction. It must never
        let pool = test_pool(2_000_000);
        let _ = acquire_budget(&small_pool, &wide_schema, 8, 8192).unwrap();
                } else {
        let rejections_before = stats.rejections.load(Ordering::Relaxed);
/// - 1 batch: in-flight between FileStream and CoalescePartitionsExec
        let row_bytes = 16;
pub fn estimate_row_bytes_from_metadata(
///
/// Compute the untracked byte envelope for given parameters.
            target_partitions,
        DataType::List(inner) | DataType::LargeList(inner) => {
    let mut total: usize = 0;
/// **Proactive RSS check**: before attempting pool reservation, consults
    }
    pub phantom_reservation: MemoryReservation,
        let thresholds = crate::memory_guard::get_thresholds();
        // Existing reservation is larger — should return Ok(None)
    static MIN_PARTITIONS_TEST_LOCK: Mutex<()> = Mutex::new(());
        assert!(budget.batch_size >= MIN_BATCH_SIZE);
    #[test]
//!
    }
                            num_columns,
    // raise target_partitions above what the caller already configured (e.g.
    metadata: &ParquetMetaData,
        assert_eq!(estimate_avg_row_bytes(&schema), 8);
        // Pool with only 2MB — not enough for 8 partitions
                        avg_row_bytes,
//! This would prevent the phantom from starving high-cardinality GROUP BY
        None => schema.fields().len(),
/// Read the current minimum target partitions floor.
}
        if field.is_nullable() {
    /// Bytes reserved by the phantom (informational).
//! # TODO: Cardinality-aware operator headroom
        // 8 + 64 = 72, plus 2 nullable → ceil(2/8) = 1 byte bitmap
        if idx < first_rg.columns().len() {
        let mut reservation = consumer.register(&pool);
    let num_rows = first_rg.num_rows() as usize;
//! memory, the pool's limit underestimates true memory usage, and operators
            4,
        let result =
//!
        acquire_budget(pool, schema, target_partitions, batch_size)
                        ),
    pool: &Arc<dyn MemoryPool>,
    }
    MIN_TARGET_PARTITIONS_SETTING.load(Ordering::Acquire)
        drop(budget);
/// Core budget acquisition logic. All public entry points delegate here.
//! - Their `try_grow` calls fail earlier.
        let reserved_with_budget = pool.reserved();
/// - Short strings (10 bytes): static=64 wins, metadata≈14 (includes offset overhead) → uses 14
    }
const MIN_BATCH_SIZE: usize = 1024;
//! More partitions multiply all of the above. Without accounting for untracked
                    );
//!
                });
    use super::*;
    num_columns: usize,
        let pool = test_pool(1024);
        }
        let schema = schema_of(vec![
) -> usize {
        // No existing reservation — should acquire
//! 2. **Reserve** that estimate from the pool as a phantom "untracked overhead"
    configured_batch_size: usize,
            }
//! - OpenSearch field mappings with known cardinality (keyword fields)
        // Tiny pool that can't fit anything
        let budget = result.unwrap();
        None,
        DataType::Date64 | DataType::Time64(_) | DataType::Timestamp(_, _) => 8,
            budget.target_partitions
    let mut target_partitions = configured_target_partitions.max(1);
        pool_limit_bytes,
) -> Result<Option<QueryMemoryBudget>, DataFusionError> {
        let schema = schema_of(vec![("a", DataType::Int64), ("b", DataType::Int64)]);
        assert!(budget.batch_size < 8192);
#[cfg(test)]
//! - The system stays within the pool limit (tracked + phantom ≤ pool_limit).
/// over-estimation from static estimates.
        // Pool is 10MB. Phantom takes ~5MB. Operator only gets ~5MB before spill.
    avg_row_bytes: usize,
                    let prev = target_partitions;
        let schema = schema_of(vec![("id", DataType::Int64), ("name", DataType::Utf8)]);
        let budget = acquire_budget_test(&pool, &schema, 4, 8192).unwrap();
/// Set the minimum target partitions floor at runtime. Called from Java when
        // Try to allocate what's left
        let stats = adaptive_budget();
        match reservation.try_grow(phantom_bytes) {
/// Revised strategy: for variable-length types, use metadata (ground truth).
//! parallelism. This gives a graceful degradation path: full parallelism when
        );
}
            avg_row_bytes,
    fn try_grow_reduce_budget_adapts_partitions_under_pressure() {
        DataType::Date32 => 4,
                // queries whose Drop hasn't propagated, accounting drift).
        // Single partition should use less than half of 2-partition (no merge channel multiplier)
/// If `projected_columns` is provided, only those columns contribute to the
        let row_bytes = 16;
            }
                    target_partitions = min_partitions;
/// Minimum batch_size floor.
        assert!(budget.target_partitions >= 2);
    #[test]
    let mut batch_size = configured_batch_size.max(MIN_BATCH_SIZE);
//! reduce `target_partitions` to lower the phantom size, retrying with less
            ("price", DataType::Float64),
const PARTITION_BUFFER_MULTIPLIER: usize = 3;
        let mut reservation = consumer.register(pool);
                    let prev = batch_size;
        configured_batch_size,
        // Reproduces the bug where `datafusion.min_target_partitions=8` would
    pub rejections: AtomicU64,
                if resident >= admission_threshold_bytes {
    configured_target_partitions: usize,
    if num_rows == 0 {
                        min_partitions,
    target_partitions: usize,
        total += estimate_field_bytes(field.data_type());
    /// Serializes tests that mutate the process-global MIN_TARGET_PARTITIONS_SETTING.
    batch_size: usize,
    }
        DataType::Utf8View | DataType::BinaryView => 64,
        let budget = acquire_budget(&pool, &schema, 4, 8192).unwrap();
//! # Adaptive fallback
    }
    &ADAPTIVE_BUDGET
///
        }
/// Estimate average row size in bytes from a schema.
/// Configurable minimum target_partitions floor for adaptive reduction.
/// so it cannot raise the starting value above what the caller requested
//!
        pool,
const PER_COLUMN_DECODE_OVERHEAD_BYTES: usize = 4 * 1024;
    // reservation accounting already shows pressure (>= admission threshold).
        DataType::Boolean => 1,
/// Updated from Java when the cluster setting `datafusion.min_target_partitions`
    #[test]
//! If the pool is so exhausted that even the phantom reservation itself fails
        set_min_target_partitions(prev);
                    native_bridge_common::log_info!(
//! 1. **Estimate** the untracked memory for the chosen `target_partitions` and
        pool: &Arc<dyn MemoryPool>,
/// cannot fit — the query should be rejected.
                    phantom_reservation: reservation,
///   an under-estimate from static. So we actually want MAX for variable-length columns
        pool,
        DataType::FixedSizeList(inner, n) => *n as usize * estimate_field_bytes(inner.data_type()),
        assert_eq!(budget.target_partitions, 2);
            .iter()
        let batch_bytes = batch_size * row_bytes; // 131072
}
            nullable_count += 1;
                // If actual process memory is well below the pool limit, the
                    target_partitions,
pub fn adaptive_budget() -> &'static AdaptiveBudgetStats {
) -> Result<QueryMemoryBudget, DataFusionError> {
//!
    fallbacks: AtomicU64::new(0),
        DataType::Int8 | DataType::UInt8 => 1,
    }
/// Compute untracked bytes with column-count-aware decode overhead.
/// Compute and reserve a memory budget for a query.
    #[test]
        let schema = schema_of(vec![("a", DataType::Int64), ("b", DataType::Int64)]);
    acquire_budget_with_projection(
    )
    #[test]
        let result = try_grow_reduce_budget(&pool, &schema, 8192, 4, 0).unwrap();
    let avg_row_bytes = estimate_avg_row_bytes(schema);
//! headroom.
            "query_untracked(partitions={},batch={})",
    let output_channel = batch_bytes;
        let multi = compute_untracked_bytes_with_columns(2, batch_size, row_bytes, 2);
        let budget = acquire_budget(&pool, &schema, 4, 8192).unwrap();
        num_columns,
    // This avoids the ~5µs jemalloc epoch.advance cost on the happy path.
        DataType::Int64 | DataType::UInt64 | DataType::Float64 => 8,
/// at full configured parallelism. If that fails, iteratively halves
        );
        let per_part = 3 * batch_bytes + decode_overhead;
        Some(indices) => estimate_projected_row_bytes(schema, indices),
    pool: &Arc<dyn MemoryPool>,
//!    `MemoryConsumer` (marked `can_spill = true`).
        let after_phantom = pool.reserved();
use datafusion::arrow::datatypes::{DataType, SchemaRef};
    #[test]
                            target_partitions,
                    ));
    };
use std::sync::Arc;
    }
        let schema = schema_of(vec![
    fn acquire_budget_succeeds_with_plenty_of_memory() {
    fn try_grow_reduce_budget_skips_when_existing_covers() {
    let avg_row_bytes = estimate_row_bytes_from_metadata(schema, metadata)
    fn acquire_budget_reduces_batch_size_at_min_partitions() {
        ]);
                        "Admission: pool reserved={}B, RSS={}B >= admission threshold ({:.0}%) — reducing to min partitions={}",
const DEFAULT_MIN_TARGET_PARTITIONS: usize = 1;
/// row group state, page index). Independent of column count.
    ) -> Result<QueryMemoryBudget, DataFusionError> {
 * The OpenSearch Contributors require contributions made to
    configured_target_partitions: usize,
        assert!(result.is_err(), "expected Err when pool is exhausted");
    }
    prior_partition_reservation_bytes: usize,
    fn try_grow_reduce_budget_rejects_when_pool_exhausted() {
        );
//! - Channel buffers (`CoalescePartitionsExec` mpsc, `CrossRtStream` mpsc)
    #[test]
                        "Memory pressure: reducing target_partitions {} -> {} (phantom {} bytes failed, floor={})",
                let admission_threshold_bytes =
        let result = acquire_budget_test(&pool, &schema, 4, 8192);
/// (e.g. derived from `search.concurrent.max_slice_count`).
    configured_batch_size: usize,
use std::sync::atomic::{AtomicU64, AtomicUsize, Ordering};
mod tests {
 *
pub fn acquire_budget_with_projection(
                        prev, batch_size, target_partitions, phantom_bytes
    schema: &SchemaRef,
 */
//! (`try_grow` returns `ResourcesExhausted`), the query is rejected at
///
        assert!(
        assert!(result.is_err());
///
    fn schema_of(fields: Vec<(&str, DataType)>) -> SchemaRef {
        DataType::Decimal128(_, _) => 16,
                            MIN_BATCH_SIZE,
                    ADAPTIVE_BUDGET.fallbacks.fetch_add(1, Ordering::Relaxed);
 * SPDX-License-Identifier: Apache-2.0
        set_min_target_partitions(8);
        configured_target_partitions,
        let phantom_bytes = compute_untracked_bytes_with_columns(
    }
        DataType::Decimal256(_, _) => 32,
        let schema = schema_of(vec![
            | DataType::Binary
        let tiny_pool = test_pool(1000);
        assert!(budget.phantom_bytes > 0);
            budget.target_partitions < 4,
            | DataType::LargeBinary
    fn test_pool(limit: usize) -> Arc<dyn MemoryPool> {
                    // RSS at spill threshold (85%) — reject immediately.
                // (e.g., RLE/dictionary pages) that inflates the number.
        let pool = test_pool(100_000_000);
        DataType::Utf8 | DataType::Binary => 64,
        let pool = test_pool(1000); // Tiny pool — even minimum won't fit
}
///   (metadata is ground truth) and MIN for fixed-width (both are exact).
/// Extract pool limit if finite.
                .map(|(name, dt)| Field::new(name, dt, true))
/// Base per-partition overhead for parquet decode structures (metadata parsing,
    match pool.memory_limit() {
        // When the configured target is above the floor and memory pressure
    let mut total: usize = 0;
//!   headroom = NDV × (key_bytes + accumulator_bytes_per_group)
    /// Helper for tests with artificially small pools.
        assert!(stats.rejections.load(Ordering::Relaxed) > rejections_before);
/// - 1 batch: buffered in the CoalescePartitionsExec mpsc channel slot
/// burst — each new query arriving when RSS is elevated starts at minimum
/// rejects it, iteratively halves target_partitions until it fits.
/// Delegates to the common memory guard for admission-level override check.
        DataType::Int32 | DataType::UInt32 | DataType::Float32 => 4,
        // Now try to exceed — this should fail, triggering spill in a real operator
    #[test]
            Ok(()) => {
///
        return Ok(None);
//! - Query-level hint via `DatafusionQueryConfig`
    }
}
        let schema = schema_of(vec![("a", DataType::Int64)]);
                            batch_size,
    if let Some(limit) = pool_limit(pool) {
/// Attempt to acquire or grow the coordinator-reduce session's phantom
    metadata: &ParquetMetaData,
/// had a wider schema). Returns Ok(None) when the existing reservation already
            | DataType::Utf8View
        Some(indices) => indices.len(),
//!    `batch_size` from the schema.
        let per_partition = 2 * batch_bytes + decode_overhead;
        let output_channel = batch_bytes;
    /// The phantom reservation occupying pool capacity for untracked memory.
    let mut total: usize = 0;
                        prev, target_partitions, phantom_bytes, min_partitions
//! that *could* spill don't trigger spill because the pool appears to have
/// from a prior child registration (if any). Skips acquisition when the
                    native_bridge_common::log_info!(
        DataType::Int16 | DataType::UInt16 | DataType::Float16 => 2,
            let resident = crate::memory_guard::cached_resident_bytes();
/// Derived from the execution pipeline:
                            "query_untracked(partitions={},batch={},jemalloc_override)",
                    return Err(crate::native_error::admission_rejected_error(
    schema: &SchemaRef,
//! sort buffers). The following are **untracked**:
    }
    fn estimate_variable_width_schema() {
                        let reservation = consumer.register(pool);
        ]); // 32 bytes/row
 * compatible open source license.
//!
/// existing reservation already covers the new estimate (e.g. a prior child
        assert!(budget.phantom_bytes <= 2_000_000);
    .map(Some)
//! memory allows, reduced parallelism under pressure, rejection only at
/// `uncompressed_size / num_rows` per column from the first row group
    fn estimate_fixed_width_schema() {
    schema: &SchemaRef,
pub fn estimate_avg_row_bytes(schema: &SchemaRef) -> usize {
        assert_eq!(budget.target_partitions, DEFAULT_MIN_TARGET_PARTITIONS);
        assert_eq!(result, expected);
            | DataType::Map(_, _)
///
            if resident > 0 {
                    return Err(crate::native_error::admission_rejected_error(
                    batch_size = (batch_size / 2).max(MIN_BATCH_SIZE);
            ("b", DataType::Int64),
        let schema = schema_of(vec![("a", DataType::LargeBinary)]); // 128 bytes/row
    }
                    ADAPTIVE_BUDGET.fallbacks.fetch_add(1, Ordering::Relaxed);
                            phantom_bytes,
    )
        // search.concurrent.max_slice_count). The setting is a floor for
    match dt {
    // capacity=target_partitions. Each partition has decode + in-flight.
}
}
        DataType::Duration(_) => 8,
/// held for the query's lifetime.
    #[test]
                    if jemalloc_says_headroom_available(limit) {
    configured_batch_size: usize,
    }
        let pool = test_pool(1_000_000_000); // 1GB
/// Returns at least 8 bytes (minimum for one Int64 column).
        dt,
    }
        let schema = schema_of(vec![("a", DataType::Int64), ("b", DataType::Int64)]);
            batch_size,
        let budget = acquire_budget(&pool, &schema, 8, 8192).unwrap();
    }
                // Variable-length: metadata is ground truth (includes offset array overhead
    if needed <= prior_partition_reservation_bytes {
    let decode_overhead =
        DataType::Utf8
            Err(_) => {
        let pool = test_pool(500_000);
    for &idx in indices {
            estimate_avg_row_bytes(&schema),
        set_min_target_partitions(2);
        let _ = acquire_budget(&pool, &schema, 4, 8192).unwrap();
                if let Some(limit) = pool_limit(pool) {
                        "Admission REJECTED: pool reserved={}B, RSS={}B >= spill threshold ({:.0}% of {}B). Node under memory pressure.",
    target_partitions: usize,
//! - Parquet decode buffers (page decompression, dictionary decode)
    total += (nullable_count + 7) / 8;
fn jemalloc_says_headroom_available(pool_limit_bytes: usize) -> bool {
            "expected partitions < 4, got {}",
        let partitions = 4;
        assert!(result
//! queries that need large hash tables. Without NDV, operators rely on
                    (limit as f64 * thresholds.admission_throttle) as i64;
        let budget = acquire_budget(&pool, &schema, 4, 8192).unwrap();
    batch_size: usize,
/// Returns `Err` only if even `target_partitions=1` with `batch_size=MIN`
        // adaptive reduction, so it must be a no-op when configured ≤ floor.
//! - Parquet column chunk statistics (`Statistics::distinct_count()`)
    pool: &Arc<dyn MemoryPool>,
        return None;
/// How many batch-sized buffers exist per partition in the pipeline.
        // Small pool forces partition reduction
        DataType::Struct(fields) => fields
    pub batch_size: usize,
        assert_eq!(pool.reserved(), 0);
            8192,
/// - ~1 batch: parquet decode working buffer (decompressed page → arrow arrays)
                        pool.grow(&reservation, phantom_bytes);
    #[test]
//! DataFusion's `MemoryPool` only tracks operator-internal state (hash tables,
    fn adaptive_budget_counters_increment() {
        let num_columns = 3;
    fn min_target_partitions_setting_still_acts_as_reduction_floor() {
        Arc::new(datafusion::execution::memory_pool::TrackConsumersPool::new(
    MIN_TARGET_PARTITIONS_SETTING.store(value.max(1), Ordering::Release);
        let result = acquire_budget(&tiny_pool, &schema, 4, 8192);
                        compute_untracked_bytes(min_partitions, MIN_BATCH_SIZE, avg_row_bytes),
}
    fn try_grow_reduce_budget_acquires_when_needed_exceeds_existing() {
    );
                        });
    // value below the setting is left untouched.
        let pool = test_pool(2_000_000);
    projected_columns: Option<&[usize]>,
    // derived from `search.concurrent.max_slice_count`). Clamp so a configured
        let schema = schema_of(vec![("a", DataType::Int64), ("b", DataType::Int64)]);
        let expected = 4 * per_part + batch_bytes;
        let budget = acquire_budget_test(&pool, &schema, 8, 8192).unwrap();
        let _guard = MIN_PARTITIONS_TEST_LOCK.lock().unwrap();
        num_columns,
    }
    // Multi-partition: CoalescePartitionsExec adds a merge channel with
    avg_row_bytes: usize,
                } else if batch_size > MIN_BATCH_SIZE {
            ("b", DataType::Int64),
pub fn set_min_target_partitions(value: usize) {
    use std::sync::Mutex;
/// Per-column overhead within a partition (column reader, decompression buffer,
        assert!(result.is_some());
/// Cumulative counters for budget fallbacks and rejections.
                            avg_row_bytes,
) -> Option<usize> {
        let prev = get_min_target_partitions();
/// This produces the tightest correct estimate regardless of string length:
        assert!(single < multi);
}
    )
            if is_variable_length(field.data_type()) {
    crate::memory_guard::should_override(
//!
        }
fn compute_untracked_bytes_with_columns(
            total += estimate_field_bytes(field.data_type());
        return per_partition + output_channel;
                    );
        .with_can_spill(true);
        DataType::FixedSizeBinary(n) => *n as usize,
/// jemalloc's resident bytes. If physical memory already exceeds the admission
                    }
                    target_partitions = (target_partitions / 2).max(min_partitions);
        let admission_bytes = (limit as f64 * thresholds.admission_throttle) as usize;
        let batch_size = 8192;
    configured_target_partitions: usize,
    fn acquire_budget_rejects_when_fully_exhausted() {
    configured_target_partitions: usize,
    use std::num::NonZeroUsize;
//!
            let measured = col_chunk.uncompressed_size() as usize / num_rows;
                drop(reservation);
                let spill_bytes = (limit as f64 * thresholds.admission_reject) as i64;
/// For each column, takes the **minimum** of:
fn pool_limit(pool: &Arc<dyn MemoryPool>) -> Option<usize> {
        batch_size,
const PAGE_DECODE_BASE_OVERHEAD_BYTES: usize = 64 * 1024;
    #[test]
        let pool = test_pool(1_000_000_000);
        // 8 + 8 + 4 = 20, plus 3 nullable columns → ceil(3/8) = 1 byte bitmap
/// For fixed-width types, use the type size (exact).
    fn phantom_freed_on_drop() {
    )
                // which Arrow also has). Use it directly — it's the actual decoded size.
    loop {
    for field in schema.fields() {
    fn acquire_budget_test(
    pool: &Arc<dyn MemoryPool>,
        assert!(budget.target_partitions < 8);
        // forces reduction, target_partitions must not drop below the floor.
        MemoryLimit::Finite(limit) => Some(limit),
        } else {
//! (tracked + untracked), and operators automatically spill to stay within it.
    /// Drop this when the query completes to release the capacity.
    }
            ("count", DataType::Int32),
#[derive(Debug)]
}
        .unwrap_or_else(|| estimate_avg_row_bytes(schema));
    fn compute_untracked_bytes_formula() {
        let schema = schema_of(vec![("a", DataType::Int64), ("b", DataType::Int64)]);
        schema,
//! available to operators. When the pool is under pressure:
        assert!(result.is_err());
    for (idx, field) in schema.fields().iter().enumerate() {
//!
                }
                    phantom_bytes,
/// threshold (default 70% of pool limit), immediately reduces partitions to
        let reserved = pool.reserved();
}
        let consumer = MemoryConsumer::new(format!(
        crate::memory_guard::OverrideContext::Admission,
    let num_columns = schema.fields().len();
/// Computed budget for a query. Carries the phantom reservation that must be
/// untracked memory for this schema against the reservation already held
    }
/// Returns `None` if metadata doesn't have useful stats (empty file, etc.).
/// parallelism, limiting its hash table growth and total memory footprint.
    fn acquire_budget_reduces_partitions_under_pressure() {
            ("a", DataType::Int64),
        configured_batch_size,
    #[test]
        let result = try_grow_reduce_budget(&pool, &schema, 8192, 4, 0);
        let schema = schema_of(vec![("a", DataType::Int64), ("b", DataType::Utf8)]);
    configured_batch_size: usize,
    )
    #[test]
        assert_eq!(pool.reserved(), budget.phantom_bytes);
pub fn get_min_target_partitions() -> usize {
        let result = try_grow_reduce_budget(&pool, &schema, 8192, 4, needed + 1).unwrap();
    Some(total.max(8))
}
        set_min_target_partitions(prev);
    total.max(8)
        assert!(budget.target_partitions < 8);
    fn min_target_partitions_setting_does_not_raise_configured_value() {
///
    let batch_bytes = batch_size * avg_row_bytes;
///
    pub fallbacks: AtomicU64,
    let mut nullable_count: usize = 0;
            schema.fields().len(),
//! The net effect: the pool limit now represents the **actual** RSS bound
    };
}
                            min_partitions,
) -> Result<QueryMemoryBudget, DataFusionError> {
        let budget = acquire_budget(&pool, &schema, 2, 8192).unwrap();
        let consumer = MemoryConsumer::new("hash_agg");
        // FileStream → CrossRtStream(1 slot) → Java
fn estimate_field_bytes(dt: &DataType) -> usize {
//! admission time with a clear error — before any work begins.
        let decode_overhead =
        pool,
    /// Effective target_partitions to use.
            | DataType::LargeList(_)
        let schema = schema_of(vec![("a", DataType::Int64)]);
        }
fn is_variable_length(dt: &DataType) -> bool {
//! Per-query budgeting with spill-on-exceed semantics.
//! Instead of clamping `target_partitions` (which reduces throughput), we:
//! # When even spilling isn't enough
        // Caller asks for 2 partitions; setting is 8. Result must stay at 2.
    #[test]
    rejections: AtomicU64::new(0),
    target_partitions * per_partition + output_channel
                // RSS between admission (70%) and operator (85%) — reduce partitions
        assert!(budget.target_partitions >= DEFAULT_MIN_TARGET_PARTITIONS);
        avg_row_bytes,
) -> Result<QueryMemoryBudget, DataFusionError> {
/// Refine row-width estimate using actual column sizes from parquet metadata.
        configured_target_partitions,
                    ADAPTIVE_BUDGET.rejections.fetch_add(1, Ordering::Relaxed);
) -> Result<QueryMemoryBudget, DataFusionError> {
    matches!(
                // Proceed at current parallelism via infallible grow.
        let batch_size = 8192;
        assert!(result.is_some());
/// - Long strings (500 bytes): static=64 loses, metadata≈504 → uses 504... wait, that's
            datafusion::execution::memory_pool::GreedyMemoryPool::new(limit),
        target_partitions: usize,
//! DataFusion's spill mechanism (safe but slower). Sources for NDV:
    let avg_row_bytes = match projected_columns {
                .into_iter()
    }
/// row-width estimate (much tighter for narrow projections on wide tables).
            fields
        }
    fn phantom_creates_spill_pressure_for_operators() {
        // Simulate an operator trying to allocate from the same pool
        configured_target_partitions,
            ("c", DataType::Int64),
        let remaining = 10_000_000 - after_phantom;
///
}
        pool,
        avg_row_bytes,
    total.max(8)
/// For variable-width types: conservative static estimate.
        None => estimate_avg_row_bytes(schema),
                    );
/// This is the preferred path when metadata is cached. Uses actual
    let needed = compute_untracked_bytes_with_columns(
                        avg_row_bytes,
                    batch_size,
        let pool = test_pool(10_000_000);
