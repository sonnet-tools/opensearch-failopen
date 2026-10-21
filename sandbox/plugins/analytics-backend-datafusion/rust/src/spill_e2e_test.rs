                .downcast_ref::<Int64Array>()
}
    // FIXME: known-flaky — intermittently fails with ResourcesExhausted ("Failed to reserve memory
        // Small batches + a couple of partitions keep per-operator memory low so
        let total_rows: usize = batches.iter().map(|b| b.num_rows()).sum();
    const POOL_LIMIT_BYTES: usize = 12 * 1024 * 1024;
            .children()
        // holds ~NUM_ROWS groups — far more than the 4 MiB pool can keep
        }
                count_sum += counts.value(i);
            }
    use datafusion::execution::disk_manager::{DiskManagerBuilder, DiskManagerMode};
            .with_default_features()
            let batch = RecordBatch::try_new(
        let mut config = SessionConfig::new();
    /// enough that the high-cardinality hash table can't stay resident (forcing
                ],
            let path = dir.join(format!("data_{}.parquet", file_idx));
            for i in 0..counts.len() {
            .sql("SELECT id, COUNT(*) AS c FROM t GROUP BY id")
            writer.close().unwrap();
            "t",
//! Determinism: `DynamicLimitPool` only consults process RSS / the jemalloc
        );
        let batches = collect(plan.clone(), ctx.task_ctx()).await.unwrap();
        .await
        for b in &batches {
    }
 * this file be licensed under the Apache-2.0 license or a
            Field::new("host", DataType::Utf8, true),
 * SPDX-License-Identifier: Apache-2.0
 *
            Field::new("id", DataType::Int64, false),
                assert_eq!(counts.value(i), 1, "each unique id appears exactly once");
        write_parquet_data(data_dir.path());
        );
    use parquet::arrow::ArrowWriter;
        // ── Spill actually happened ──
//! a high-cardinality `GROUP BY` over enough rows, run under a memory pool too
    #[tokio::test(flavor = "multi_thread", worker_threads = 2)]
//!
    fn write_parquet_data(dir: &Path) {
    /// each row carries a bit of payload.
    /// Recursively sums the `SpillCount` metric across every operator in the
        // the aggregator is pushed to spill rather than failing outright.
//! ([`crate::memory::DynamicLimitPool`]) and a real on-disk [`DiskManager`]:
            "expected the grouped aggregation to spill to disk under a {}MiB pool, \
            let mut writer = ArrowWriter::try_new(file, schema.clone(), None).unwrap();
    /// Writes `NUM_ROWS` rows across `NUM_FILES` parquet files. `id` is unique
    }
        let plan = df.create_physical_plan().await.unwrap();
            .build();
        )
                .column(1)
        let df = ctx
            writer.write(&batch).unwrap();
            "every unique id must yield exactly one group"
    use datafusion::prelude::{ParquetReadOptions, SessionConfig};
//! aggregate spill tests assert on). We walk the executed physical plan tree
    use datafusion::execution::SessionStateBuilder;
            .sum::<usize>()
        // ── Correctness: spilling must not change the answer ──
    use std::path::Path;
    fn total_spill_count(plan: &dyn ExecutionPlan) -> usize {
            .with_config(config)
    #[ignore]
                vec![
 */
 * compatible open source license.
            .build()
    /// tiny memory pool, guaranteeing a spill.
            let start = file_idx * rows_per_file;
    use datafusion::execution::memory_pool::MemoryPool;
            .children()
    }
    use arrow_array::{Int64Array, RecordBatch, StringArray};
        for file_idx in 0..NUM_FILES {
//! metrics on the operators that spill (the same signal DataFusion's own
        // Build a RuntimeEnv that mirrors production: the real DynamicLimitPool
        let pool: Arc<dyn MemoryPool> = Arc::new(DynamicLimitPool::new(POOL_LIMIT_BYTES).0);
        assert!(
            POOL_LIMIT_BYTES / (1024 * 1024)
    /// Same as [`total_spill_count`] for the `SpilledBytes` metric.
        let schema = Arc::new(Schema::new(vec![
#[cfg(test)]
    }
        let spill_count = total_spill_count(plan.as_ref());
//! small to hold the hash table, must spill to disk **and still return correct
    use std::sync::Arc;
//! and sum those metrics; a non-zero `spill_count` is proof spill happened.
                    Arc::new(Int64Array::from(ids)),
        config.options_mut().execution.batch_size = 1024;
        let here = plan.metrics().and_then(|m| m.spill_count()).unwrap_or(0);
    use tempfile::TempDir;
        );
        ]));
            .with_memory_pool(pool)
                .as_any()
    /// executed plan tree (the spilling operator may be nested under others).
    async fn group_by_spills_to_disk_and_returns_correct_results() {
        let data_dir = TempDir::new().unwrap();
    /// Pool limit kept below 16 MiB so the pool is a pure size-bounded pool
            "spill happened (spill_count={}) but SpilledBytes was 0",
        assert_eq!(
                schema.clone(),
    use datafusion::physical_plan::{collect, ExecutionPlan};
//! override when its limit is >= 16 MiB (see `memory_guard::should_override`
                        hosts.iter().map(|s| s.as_str()).collect::<Vec<&str>>(),
        // to NUM_ROWS. This catches data loss/duplication across the spill cycle.
                    Arc::new(StringArray::from(
    /// (no RSS gate / jemalloc override) — see module docs. 12 MiB is small
            .unwrap();
        // (deliberately tiny) plus an on-disk DiskManager rooted at spill_dir.
            let counts = b
            spill_count > 0,
//!
        // High-cardinality GROUP BY: one group per (unique) id. The hash table
/*
                DiskManagerMode::Directories(vec![spill_dir.path().to_path_buf()]),
    /// Rows of test data. Large enough that the GROUP BY hash table dwarfs the
            ParquetReadOptions::default(),
//! and the `skip_for_small_pools` unit test). With a sub-16 MiB limit it is a
    /// (the high-cardinality GROUP BY key); `host` is low-cardinality filler so
            "precondition: spill must be enabled for this test to be meaningful"
        // Every group's COUNT(*) must be 1 (ids are unique), so the counts sum
        }
        assert!(
    // for sort during spill") under the shared memory-pool budget. Unrelated to query planning.
        let runtime_env = RuntimeEnvBuilder::new()
            let ids: Vec<i64> = (start..start + rows_per_file).map(|i| i as i64).collect();
        let spilled_bytes = total_spilled_bytes(plan.as_ref());
            let file = std::fs::File::create(&path).unwrap();
            .map(|child| total_spilled_bytes(child.as_ref()))
        );
    const NUM_FILES: usize = 4;
            .with_runtime_env(Arc::new(runtime_env))
            let hosts: Vec<String> = ids.iter().map(|i| format!("host-{:04}", i % 100)).collect();
            ))
    fn total_spilled_bytes(plan: &dyn ExecutionPlan) -> usize {
    use datafusion::execution::context::SessionContext;
//! Proves the full spill flow works through the *production* memory pool
        assert!(
        let mut count_sum: i64 = 0;
            .iter()
            )
            .unwrap();
//!
            .with_disk_manager_builder(DiskManagerBuilder::default().with_mode(
            spill_count
            spilled_bytes > 0,
                    )),
    const NUM_ROWS: usize = 500_000;
        let here = plan.metrics().and_then(|m| m.spilled_bytes()).unwrap_or(0);
            .await
        assert_eq!(count_sum as usize, NUM_ROWS, "counts must sum to row count");
        config.options_mut().execution.target_partitions = 2;
    /// spill) but large enough that the spill machinery's own working reservations
//! End-to-end disk-spill test for the analytics-backend-datafusion engine.
//! results**.
        ctx.register_parquet(
//! pure size-bounded pool, so spill is forced deterministically by data volume
//! How spill is observed: DataFusion records `SpillCount` / `SpilledBytes`
            data_dir.path().to_str().unwrap(),
            .sum::<usize>()
        let rows_per_file = NUM_ROWS / NUM_FILES;
        here + plan
    use crate::memory::DynamicLimitPool;
//! alone — no dependency on the test host's live RSS.
        // resident — so the grouped aggregation must spill.
                .expect("COUNT(*) column is Int64");
        .unwrap();
    use arrow::datatypes::{DataType, Field, Schema};
        let spill_dir = TempDir::new().unwrap();
            runtime_env.disk_manager.tmp_files_enabled(),
        let ctx = SessionContext::new_with_state(state);
mod tests {
    /// can complete rather than erroring with ResourcesExhausted.
    use datafusion::execution::runtime_env::RuntimeEnvBuilder;
 * The OpenSearch Contributors require contributions made to
            .map(|child| total_spill_count(child.as_ref()))
            .iter()
             but SpillCount across the plan was 0",
        here + plan
        let state = SessionStateBuilder::new()
            .unwrap();
            total_rows, NUM_ROWS,
