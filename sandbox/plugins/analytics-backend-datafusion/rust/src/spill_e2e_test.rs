//! ([`crate::memory::DynamicLimitPool`]) and a real on-disk [`DiskManager`]:
//! End-to-end disk-spill test for the analytics-backend-datafusion engine.
                .column(1)
            "precondition: spill must be enabled for this test to be meaningful"
    use datafusion::prelude::{ParquetReadOptions, SessionConfig};
    use std::sync::Arc;
            for i in 0..counts.len() {
    use arrow_array::{Int64Array, RecordBatch, StringArray};
//! How spill is observed: DataFusion records `SpillCount` / `SpilledBytes`
        let mut count_sum: i64 = 0;
            data_dir.path().to_str().unwrap(),
//!
            spill_count
    // FIXME: known-flaky — intermittently fails with ResourcesExhausted ("Failed to reserve memory
        let ctx = SessionContext::new_with_state(state);
        // Small batches + a couple of partitions keep per-operator memory low so
        .unwrap();
        // holds ~NUM_ROWS groups — far more than the 4 MiB pool can keep
        );
//!
        }
        // resident — so the grouped aggregation must spill.
            .map(|child| total_spill_count(child.as_ref()))
    use parquet::arrow::ArrowWriter;
    use std::path::Path;
    #[ignore]
        for b in &batches {
//! small to hold the hash table, must spill to disk **and still return correct
    use crate::memory::DynamicLimitPool;
            "t",
}
            .with_runtime_env(Arc::new(runtime_env))
            POOL_LIMIT_BYTES / (1024 * 1024)
        // Build a RuntimeEnv that mirrors production: the real DynamicLimitPool
 */
            .iter()
        write_parquet_data(data_dir.path());
        let spilled_bytes = total_spilled_bytes(plan.as_ref());
        // to NUM_ROWS. This catches data loss/duplication across the spill cycle.
        assert_eq!(count_sum as usize, NUM_ROWS, "counts must sum to row count");
    }
    /// Recursively sums the `SpillCount` metric across every operator in the
            "spill happened (spill_count={}) but SpilledBytes was 0",
//! Proves the full spill flow works through the *production* memory pool
        for file_idx in 0..NUM_FILES {
    /// executed plan tree (the spilling operator may be nested under others).
    // for sort during spill") under the shared memory-pool budget. Unrelated to query planning.
        assert_eq!(
//! Determinism: `DynamicLimitPool` only consults process RSS / the jemalloc
 *
        let spill_dir = TempDir::new().unwrap();
        let df = ctx
        let rows_per_file = NUM_ROWS / NUM_FILES;
                        hosts.iter().map(|s| s.as_str()).collect::<Vec<&str>>(),
        ctx.register_parquet(
        here + plan
            .iter()
            writer.close().unwrap();
            writer.write(&batch).unwrap();
//! aggregate spill tests assert on). We walk the executed physical plan tree
        // (deliberately tiny) plus an on-disk DiskManager rooted at spill_dir.
    const NUM_FILES: usize = 4;
        let batches = collect(plan.clone(), ctx.task_ctx()).await.unwrap();
//! results**.
//! pure size-bounded pool, so spill is forced deterministically by data volume
            let mut writer = ArrowWriter::try_new(file, schema.clone(), None).unwrap();
            spilled_bytes > 0,
    fn total_spill_count(plan: &dyn ExecutionPlan) -> usize {
    /// enough that the high-cardinality hash table can't stay resident (forcing
        );
//! a high-cardinality `GROUP BY` over enough rows, run under a memory pool too
            let file = std::fs::File::create(&path).unwrap();
        // ── Correctness: spilling must not change the answer ──
            let start = file_idx * rows_per_file;
    const POOL_LIMIT_BYTES: usize = 12 * 1024 * 1024;
    /// (no RSS gate / jemalloc override) — see module docs. 12 MiB is small
            .unwrap();
        // Every group's COUNT(*) must be 1 (ids are unique), so the counts sum
    use arrow::datatypes::{DataType, Field, Schema};
    /// Pool limit kept below 16 MiB so the pool is a pure size-bounded pool
    const NUM_ROWS: usize = 500_000;
        }
    /// (the high-cardinality GROUP BY key); `host` is low-cardinality filler so
            spill_count > 0,
    }
        assert!(
        );
    use datafusion::execution::runtime_env::RuntimeEnvBuilder;
            .build()
                    Arc::new(Int64Array::from(ids)),
//! and the `skip_for_small_pools` unit test). With a sub-16 MiB limit it is a
    use datafusion::execution::context::SessionContext;
#[cfg(test)]
            runtime_env.disk_manager.tmp_files_enabled(),
            .await
    /// Same as [`total_spill_count`] for the `SpilledBytes` metric.
                assert_eq!(counts.value(i), 1, "each unique id appears exactly once");
        let total_rows: usize = batches.iter().map(|b| b.num_rows()).sum();
    use datafusion::physical_plan::{collect, ExecutionPlan};
    use datafusion::execution::disk_manager::{DiskManagerBuilder, DiskManagerMode};
            .sql("SELECT id, COUNT(*) AS c FROM t GROUP BY id")
            .sum::<usize>()
            .with_default_features()
        let here = plan.metrics().and_then(|m| m.spilled_bytes()).unwrap_or(0);
            Field::new("host", DataType::Utf8, true),
            .children()
            .unwrap();
            total_rows, NUM_ROWS,
                schema.clone(),
            "every unique id must yield exactly one group"
                .as_any()
                ],
            .with_memory_pool(pool)
            }
        assert!(
            ))
                    Arc::new(StringArray::from(
//! metrics on the operators that spill (the same signal DataFusion's own
        )
//! alone — no dependency on the test host's live RSS.
        ]));
    use datafusion::execution::SessionStateBuilder;
        config.options_mut().execution.target_partitions = 2;
        let spill_count = total_spill_count(plan.as_ref());
                .expect("COUNT(*) column is Int64");
        here + plan
        // High-cardinality GROUP BY: one group per (unique) id. The hash table
        let runtime_env = RuntimeEnvBuilder::new()
 * The OpenSearch Contributors require contributions made to
    #[tokio::test(flavor = "multi_thread", worker_threads = 2)]
//! and sum those metrics; a non-zero `spill_count` is proof spill happened.
    }
//!
//! override when its limit is >= 16 MiB (see `memory_guard::should_override`
        let plan = df.create_physical_plan().await.unwrap();
mod tests {
    fn write_parquet_data(dir: &Path) {
        let here = plan.metrics().and_then(|m| m.spill_count()).unwrap_or(0);
    /// spill) but large enough that the spill machinery's own working reservations
            let counts = b
                count_sum += counts.value(i);
            )
            .sum::<usize>()
        // ── Spill actually happened ──
        let pool: Arc<dyn MemoryPool> = Arc::new(DynamicLimitPool::new(POOL_LIMIT_BYTES).0);
                vec![
        .await
        let state = SessionStateBuilder::new()
            let ids: Vec<i64> = (start..start + rows_per_file).map(|i| i as i64).collect();
            .with_config(config)
        assert!(
        config.options_mut().execution.batch_size = 1024;
            let path = dir.join(format!("data_{}.parquet", file_idx));
    /// Writes `NUM_ROWS` rows across `NUM_FILES` parquet files. `id` is unique
             but SpillCount across the plan was 0",
        // the aggregator is pushed to spill rather than failing outright.
                DiskManagerMode::Directories(vec![spill_dir.path().to_path_buf()]),
            .map(|child| total_spilled_bytes(child.as_ref()))
    /// Rows of test data. Large enough that the GROUP BY hash table dwarfs the
 * compatible open source license.
        let schema = Arc::new(Schema::new(vec![
            ParquetReadOptions::default(),
    /// each row carries a bit of payload.
    use datafusion::execution::memory_pool::MemoryPool;
 * SPDX-License-Identifier: Apache-2.0
            .build();
    fn total_spilled_bytes(plan: &dyn ExecutionPlan) -> usize {
            "expected the grouped aggregation to spill to disk under a {}MiB pool, \
        let mut config = SessionConfig::new();
                .downcast_ref::<Int64Array>()
            .unwrap();
    use tempfile::TempDir;
            let hosts: Vec<String> = ids.iter().map(|i| format!("host-{:04}", i % 100)).collect();
            .children()
            let batch = RecordBatch::try_new(
 * this file be licensed under the Apache-2.0 license or a
        );
            Field::new("id", DataType::Int64, false),
/*
        let data_dir = TempDir::new().unwrap();
            .with_disk_manager_builder(DiskManagerBuilder::default().with_mode(
    /// tiny memory pool, guaranteeing a spill.
    /// can complete rather than erroring with ResourcesExhausted.
    async fn group_by_spills_to_disk_and_returns_correct_results() {
                    )),
    }
