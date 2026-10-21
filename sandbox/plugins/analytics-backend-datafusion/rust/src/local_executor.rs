        Arc::new(Schema::new(vec![Field::new(
        assert_eq!(session.phantom_size(), 1000);
    /// phantom_size() first and only acquire a new reservation if the new
            // version; cast to Utf8 so the assertion is independent of the concrete string type.
    /// [`PartitionStreamSender`]s flow naturally into the DataFusion physical
            vec![
    /// every batch consumed or produced by this session counts against the
    /// [`cancel_query(context_id)`] cascade resolves the racing execute
/*
        let env = RuntimeEnvBuilder::new()
            .await
    /// [`Self::execute_prepared`].
            }
        let mut session = LocalSession::new(&env);
            reservation.try_grow(5000).unwrap();
    ) -> Result<(), DataFusionError> {
            // DataFusion's string functions may return Utf8/LargeUtf8/Utf8View depending on
        let (mut stream, _plan) = session
    /// untracked memory (intermediate buffers, hash table overhead) in the shared
        config.options_mut().execution.target_partitions =
    /// The runtime's memory pool, disk manager, and caches are inherited —
        assert!(
        Arc::clone(&self.ctx.runtime_env().memory_pool)
            "DataFusion logical plan:\n{}",
        let mut session = LocalSession::new(&env);
        }
        if new_partitions < current {
        let token = query_tracker::get_cancellation_token(ctx_id);
        assert_eq!(session.target_partitions(), 2);
            ))
        }
        let env = test_runtime_env();
        };
        // through the raw plan; then derive `target_schema` and wrap with RelabelExec from
//! The session has no knowledge of the FFM bridge; it is exposed to Java via a
    }
            vec![Arc::new(Int64Array::from(values.to_vec()))],
            let env2 = test_runtime_env();
        // Session dropped — phantom must be released
        let env = test_runtime_env();
        );
            Arc::clone(schema),
        let schema = i64_schema("x");
        let pool: Arc<dyn datafusion::execution::memory_pool::MemoryPool> =
        let physical_plan =
                .register_partition("input-0", Arc::clone(&schema))
            i64_batch(&schema, &[7, 8, 9]),
            .register_partition("input-0", Arc::clone(&schema))
        {
            &schema,
        Arc::new(Schema::new(vec![
            Field::new(a, DataType::Utf8, false),
        let current = state.config().options().execution.target_partitions;
            let plan = df.logical_plan().clone();
        let session = LocalSession::new(&env);
            "concat(substring, '|', substring) must yield one '|'-joined row per input"
        let (sender, receiver) = channel(Arc::clone(&schema));
        let sender = session
impl LocalSession {
        let physical_plan = dataframe.create_physical_plan().await?;
    /// `concat(substring(a, ...), '|', substring(b, ...))` over a WHERE filter —
            .register_memtable("input-0", Arc::clone(&schema), batches)
    /// Table references in the plan resolve through the session's registered
            .execute_substrait(&substrait_bytes)
            Arc::clone(schema),
    async fn register_partition_makes_table_resolvable() {
                .expect("sum parses");
    /// stream.
}
            let mut buf = Vec::new();
    async fn execute_substrait_concat_substring_literal_substring() {
            ctx,
        let logical_plan =
            .expect("execute");
//! raw `Box::into_raw` pointer managed in `api.rs`, matching the lifecycle
    }
            let env = test_runtime_env();
    use futures::StreamExt;
        use crate::cancellation;
    fn reduce_target_partitions_lowers_value() {
        let env = test_runtime_env();
    #[test]
        let plan = self
        let plan = Plan::decode(bytes).map_err(|e| {
            msg
        // Build Substrait bytes for SELECT SUM(s) FROM "input-0"
        let substrait_bytes = {
                    crate::partition_stream::SendOutcome::Sent
        );
    use datafusion::execution::runtime_env::RuntimeEnvBuilder;
            DataFusionError::Execution(format!(
        use datafusion::execution::memory_pool::{GreedyMemoryPool, MemoryConsumer};
                .ctx
        let mut state = state_ref.write();
                total += col.value(i);
                .expect("producer register");
            .copied_config()
        let table = StreamingTable::try_new(schema, vec![partition])?;
    /// Returns the configured batch_size for this session.
            Arc<dyn datafusion::physical_plan::ExecutionPlan>,
            let df = producer
                .as_any()
        let mut session = LocalSession::new(&env);
            crate::substrait_consumer::from_substrait_plan(&self.ctx.state(), &plan).await?;
//! A [`LocalSession`] holds a DataFusion [`SessionContext`] configured to share
        }
    /// registered in [`query_tracker::QUERY_REGISTRY`], and a
use datafusion::arrow::datatypes::SchemaRef;
/// Coordinator-reduce DataFusion session.
    }
    /// The receiver is wrapped in a [`SingleReceiverPartition`] and registered
        let mut total: i64 = 0;
    /// producer side of the channel.
            msg.contains(&ctx_id.to_string()) && msg.to_lowercase().contains("cancelled"),
                "http://|https://".to_string(),
        let ctx_id = 98_765;
    }
//! rest of the node. The session is the Rust-side counterpart of
            for i in 0..col.len() {
        let stripped = crate::relabel_exec::wrap_if_relabel_needed(stripped, target_schema)?;
            prepared_plan: None,
    /// [`Self::execute_substrait`] resolve table references named `name` to
        let substrait_bytes = {
                .as_any()
        session.set_phantom(reservation);
 */
            let env = test_runtime_env();
            .unwrap();
    ctx: SessionContext,
                .expect("i64 col");
        let table = MemTable::try_new(schema, vec![batches])?;
    > {
use datafusion::prelude::{SessionConfig, SessionContext};
            QueryTrackingContext::new(ctx_id, pool, query_tracker::QueryType::Coordinator);
        // matching session — the plan only references `input-0`, so it is
        crate::udaf::register_all(&ctx);
                    name, e
        let consumer = MemoryConsumer::new("test_phantom").with_can_spill(true);
            .prepared_plan
            .sql("SELECT x FROM \"input-0\"")
                .register_memtable("input-0", Arc::clone(&schema), vec![])
        let mut total: i64 = 0;
            i64_batch(&schema, &[4, 5, 6]),
            i64_batch(&schema, &[1, 2, 3]),
            .execute_substrait(&substrait_bytes)
                .await
        assert_eq!(session.target_partitions(), 2);
            substrait.encode(&mut buf).expect("encode");
    pub fn set_phantom(
    /// shard responses in Java and hands them across in one call.
        )]))
    #[tokio::test]
 *
        Ok((stream, physical_plan))
    /// Mirrors the `execute_query` cancel path for the coordinator entry so
}
    fn i64_batch(schema: &SchemaRef, values: &[i64]) -> RecordBatch {
        let mut session = LocalSession::new(&env);
    /// Decodes a Substrait plan against the session and returns the resulting
        let result = runner.await.expect("spawn");
    ///
    }
        crate::udf::register_all(&ctx);
    /// this streaming table. The caller pushes `RecordBatch`es into the
        assert_eq!(df.schema().fields().len(), 1);
                ));
        session.reduce_target_partitions(2);
            drop(sender); // EOF
            substrait.encode(&mut buf).expect("encode");
    }
            cancellation::cancellable(token.as_ref(), ctx_id, blocked).await
    /// `execute_local_plan(session, plan, context_id)` the context is
/// stage; it holds the streaming inputs registered by
            .execution
    /// Unlike [`Self::register_partition`], this method does not return a
        let partition: Arc<dyn PartitionStream> = Arc::new(SingleReceiverPartition::new(receiver));
        let pool: Arc<dyn datafusion::execution::memory_pool::MemoryPool> =
            crate::substrait_consumer::from_substrait_plan(&self.ctx.state(), &plan).await?;
    }
    use arrow_array::{Array, Int64Array, RecordBatch, StringArray};
                .expect("sum parses");
    }
        &mut self,
//! 2. [`LocalSession::execute_substrait`] decodes a Substrait plan against the
        let env = test_runtime_env();
            .await
        // that never receives batches.
            column,
    /// Returns the current target_partitions for this session.
                "prepare_final_plan: failed to decode Substrait: {}",
            .unwrap();
            .register_table(name, Arc::new(table))
    /// Called serially from register_partition_stream during session setup,
            buf
///
        let substrait_bytes = {
use datafusion::physical_plan::streaming::PartitionStream;
//!
    #[tokio::test]
        let sql = "SELECT concat(substring(url, 1, 7), '|', substring(referer, 1, 8)) AS r \
                ))
        log_debug!(
    }
    /// [`PartitionStreamSender::send_blocking`].
            .expect("register memtable");
 * The OpenSearch Contributors require contributions made to
                .sql("SELECT SUM(x) AS total FROM \"input-0\"")
            DataFusionError::Execution(format!("Failed to decode Substrait plan: {}", e))
use arrow_array::RecordBatch;
        &mut self,
//!    wraps the receiver in a [`SingleReceiverPartition`], and registers it as
    ///
        // A future that would block indefinitely — `cancel_query` is the
        RecordBatch::try_new(
            )
//!    session (its table references resolve to the streaming tables) and hands
        self.ctx
    #[tokio::test]
    /// Phantom reservation held for the lifetime of this session. Accounts for
    pub fn reduce_target_partitions(&self, new_partitions: usize) {
        .expect("batch builds")
                .sql("SELECT SUM(x) AS total FROM \"input-0\"")
    }
        let mut reservation = consumer.register(&pool);
            let mut reservation = consumer.register(&pool);
    ) -> Result<
    /// Returns the memory pool the session's `RuntimeEnv` was built with.
            datafusion::physical_plan::execute_stream(physical_plan.clone(), self.ctx.task_ctx())
        assert_eq!(
    }
                .register_memtable("input-0", Arc::clone(&schema), vec![])
        // Build the Substrait bytes from a SQL-built logical plan against a
            let batch = batch.expect("batch ok");
        // Each row joins the two substring results with the middle '|' literal.
            }
    }
            crate::relabel_exec::wrap_if_relabel_needed(physical_plan, target_schema)?;
        assert!(
    }
        let (mut stream, _plan) = session
                .expect("producer register");
            let batch = batch.expect("batch ok");
                .downcast_ref::<StringArray>()
    /// by the memtable variant of the coordinator-reduce sink, which buffers
    ///
        schema: SchemaRef,
        datafusion::physical_plan::execute_stream(Arc::clone(plan), self.ctx.task_ctx())
        session
        while let Some(batch) = stream.next().await {
/// [`Self::register_partition`] and is drained exactly once via
            buf
            &["https://gamma", "https://delta"],
use prost::Message;
            .options()
        // Two rows, both non-empty so they survive the WHERE filter.
        // Strip first so `force_aggregate_mode(Final)` can find the Final/Partial pair
    /// plan. The returned stream is hot — polling it drives both the reduce
        );
                crate::agg_mode::physical_optimizer_rules_without_combine(),
        );
    ) {
            let df = producer
                .ctx
        let env = RuntimeEnvBuilder::new()
            .await
        let df = session
    ///
        schema: SchemaRef,
            physical_plan,
        );
    _phantom_reservation: Option<datafusion::execution::memory_pool::MemoryReservation>,
        let target_schema = crate::schema_coerce::coerce_inferred_schema(stripped.schema());
                Arc::new(StringArray::from(col_a.to_vec())),
        self.prepared_plan = Some(stripped);
    /// future through the [`cancellation::cancellable`] branch.
                .await
        tokio::time::sleep(Duration::from_millis(20)).await;
        let ctx = SessionContext::new_with_state(state);
    pub fn new(runtime_env: &RuntimeEnv) -> Self {
            .expect("sql parses");
        self.ctx
            let mut producer = LocalSession::new(&env);
                .register_partition("input-0", Arc::clone(&schema))
        })?;
        bytes: &[u8],
            false,
    #[tokio::test]
    }
            let mut session = LocalSession::new(&env);
        reservation.try_grow(1000).unwrap();
        };
    }
        };
            logical_plan.display_indent()
        Ok(())
            let plan = df.logical_plan().clone();
/// [`Self::execute_substrait`].
            .with_config(config)
        let state = SessionStateBuilder::new()
    /// Panics if no plan has been prepared via [`Self::prepare_final_plan`].
                let outcome = sender.send_blocking(Ok(i64_batch(&producer_schema, chunk)), &handle);
    ///
            "DataFusion coordinator reduce physical plan:\n{}",
            .expect("runtime env builds")
            let col = datafusion::arrow::compute::cast(batch.column(0), &DataType::Utf8)
        session.reduce_target_partitions(8);
            .expect("prepare_final_plan succeeds");
            .ctx
        // portable onto our real session.
            })?;
        let env = test_runtime_env();
        // only way out. Mirrors a coord reduce stalled on an input partition
pub struct LocalSession {
    }
        let _sender = session
    async fn cancel_query_fires_token_registered_from_reduce_path() {
        assert_eq!(session.target_partitions(), 4);
                .sql("SELECT SUM(s) FROM \"input-0\"")
            .expect("register succeeds");
                .map_err(|e| DataFusionError::Execution(format!("execute_substrait: {}", e)))?;
        Ok(sender)
use datafusion::execution::{SendableRecordBatchStream, SessionStateBuilder};
        );
    /// string literal. Round-trips through SQL → Substrait → `from_substrait_plan`
            ],
        // Register a streaming table so the plan can resolve table refs.
        session
        )?;
            Field::new(b, DataType::Utf8, false),
    /// a parent `AnalyticsQueryTask.cancel()` interrupts the reduce even
    #[test]
        let producer = std::thread::spawn(move || {
                .expect("producer register");
                .as_any()
    }
        // Brief yield so the runner parks on the sleep before we cancel.
        let mut results: Vec<String> = Vec::new();
            let consumer = MemoryConsumer::new("test_phantom").with_can_spill(true);
            tokio::time::sleep(Duration::from_secs(60)).await;
        while let Some(batch) = stream.next().await {
        self.ctx.copied_config().options().execution.batch_size
            .with_memory_pool(Arc::clone(&pool))
        use std::num::NonZeroUsize;
        self._phantom_reservation = Some(reservation);
        use datafusion::execution::memory_pool::{GreedyMemoryPool, MemoryConsumer};
        let logical_plan =
            .as_ref()
        let env = test_runtime_env();
        // the stripped output (otherwise the relabel target would carry the pre-strip Final
    /// Builds a session whose `SessionContext` reuses the given [`RuntimeEnv`].
                DataFusionError::Execution(format!(
        name: &str,
            let substrait = to_substrait_plan(&plan, &producer.ctx.state()).expect("to_substrait");
        )
            .map_err(|e| {
                .ctx
    ///
            let env = test_runtime_env();
    /// Prepares a final-aggregate physical plan on this session.
    pub async fn execute_substrait(
    /// Used by the bridge layer to seed a per-query tracking context so
                .await
            .await
            .register_memtable("input-0", Arc::clone(&schema), vec![batch])
            let substrait = to_substrait_plan(&plan, &producer.ctx.state()).expect("to_substrait");
                .expect("producer register");
        });
        producer.join().expect("producer thread");
        &self,
//! `DatafusionReduceSink` on the Java side:
            .build()
            .expect("register memtable");
    }
            Arc::new(GreedyMemoryPool::new(10_000_000));
        Self {
            "error must name the cancelled context: got [{}]",
    ///
    /// Coordinator-side task cancellation wiring: once Java calls
/// Owns a [`SessionContext`] that reuses the caller's [`RuntimeEnv`] so memory
    /// computation and the consumption of the streaming inputs.
        let schema = i64_schema("s");
    pub fn batch_size(&self) -> usize {
    }
use crate::partition_stream::{channel, PartitionStreamSender, SingleReceiverPartition};
    }
    use tokio::runtime::Handle;
        let blocked = async {
    }
            Arc::new(GreedyMemoryPool::new(10_000_000));
        let producer_schema = Arc::clone(&schema);
    async fn prepare_final_plan_stores_plan() {
            let col = col
        ];
        let reserved_before = pool.reserved();
                Arc::new(StringArray::from(col_b.to_vec())),
    /// same limits as the shard-scan path.
            buf
//! model used by `DataFusionRuntime` / `ShardView` / `QueryStreamHandle`.
        self.ctx
        use std::time::Duration;
    /// before the first batch is produced.
            let mut buf = Vec::new();
            .target_partitions
    /// stripping, and stores the result for later execution via
            Ok::<(), String>(())
        let target_schema = crate::schema_coerce::coerce_inferred_schema(physical_plan.schema());
            .expect("execute_prepared called without a prepared plan");
        assert!(result.is_err(), "cancel_query must surface as an error");
                assert!(matches!(
        results.sort();
            let _unused = producer
use datafusion::common::DataFusionError;
}
    pub fn phantom_size(&self) -> usize {
    /// `batches` in a single [`MemTable`] partition.
//!
        name: &str,
            let batch = batch.expect("batch ok");
            state.config_mut().options_mut().execution.target_partitions = new_partitions;
    pub(crate) prepared_plan: Option<Arc<dyn datafusion::physical_plan::ExecutionPlan>>,
            let mut buf = Vec::new();
        let msg = result.err().unwrap();
            .with_default_features()
use std::sync::Arc;
        };
        let batches = vec![
    use datafusion_substrait::logical_plan::producer::to_substrait_plan;
            let col = batch
                total += col.value(i);
            crate::api::get_reduce_target_partitions();
            let mut producer = LocalSession::new(&env2);
                .downcast_ref::<Int64Array>()
        DataFusionError,
        let (mut stream, _plan) = session
        Ok(())
        ),
            _phantom_reservation: None,
            .expect("execute");
    }
        let mut config = SessionConfig::new();
//!    a [`StreamingTable`] on the session under the input id.
        });
            .with_runtime_env(runtime_env)
                   FROM \"input-0\" WHERE url <> '' AND referer <> ''";
use datafusion::physical_plan::displayable;
        self._phantom_reservation.as_ref().map_or(0, |r| r.size())
            .register_table(name, Arc::new(table))
                .expect("sum parses");
            .build()
            substrait.encode(&mut buf).expect("encode");
        let plan = Plan::decode(substrait_bytes).map_err(|e| {
//!
        }
            let mut producer = LocalSession::new(&env);
        // matching session — the plan only references `input-0`, so it is
    pub fn register_partition(
    pub async fn prepare_final_plan(
        let schema = i64_schema("x");
    pub fn register_memtable(
        let stripped = crate::agg_mode::apply_aggregate_mode(
            let substrait = to_substrait_plan(&plan, &producer.ctx.state()).expect("to_substrait");
            let _unused = producer
    pub fn target_partitions(&self) -> usize {
        let mut session = LocalSession::new(&env);
        ]))
        })?;
    #[test]
    async fn execute_substrait_sums_memtable_input() {
        assert!(session.prepared_plan.is_none());
    #[tokio::test]
            token.is_some(),
    #[tokio::test]
    /// channel sender — the batches are fully materialized in the table. Used
    /// Pre-prepared physical plan (set by `prepare_final_plan`).
            producer
    /// streaming tables, so input batches pushed into
        let dataframe = self.ctx.execute_logical_plan(logical_plan).await?;
/// accounting shares the node-wide pool. One session corresponds to one reduce
            .expect("register succeeds");
    /// Decodes Substrait → LogicalPlan → PhysicalPlan, applies final-mode
        assert!(session.prepared_plan.is_some());
            for i in 0..col.len() {
        assert_eq!(total, 45);
        reservation: datafusion::execution::memory_pool::MemoryReservation,
        assert_eq!(pool.reserved(), reserved_before);
                .expect("i64 col");
use datafusion::execution::runtime_env::RuntimeEnv;
                    "Failed to register streaming table '{}': {}",
        assert_eq!(total, 45);
        RecordBatch::try_new(
                "http://|https://".to_string(),
            DataType::Int64,
        &mut self,
        let handle = Handle::current();
            })?;
    pub fn memory_pool(&self) -> Arc<dyn MemoryPool> {
    use super::*;
        use crate::query_tracker::{self, QueryTrackingContext};
        &mut self,
                results.push(col.value(i).to_string());
        while let Some(batch) = stream.next().await {
    /// before any query execution begins.
                .expect("cast concat output to Utf8");
 * compatible open source license.
        let substrait_bytes = {
        let physical_plan = dataframe.create_physical_plan().await?;
        RuntimeEnvBuilder::new()
        )
            ],
    /// Reduce target_partitions on this session. Only reduces, never increases.
            session.set_phantom(reservation);
        let schema = two_string_schema("url", "referer");
            .expect("register");
    /// Sets the phantom reservation for this session. Caller should check
        // Never increases
        // Build the Substrait bytes from a SQL-built logical plan against a
            let mut producer = LocalSession::new(&env);
            assert_eq!(pool.reserved(), reserved_before + 5000);
                .column(0)
            crate::agg_mode::Mode::Final,
    /// the outer operands are scalar-function calls and the middle operand is a
mod tests {
            results,
use native_bridge_common::log_debug;
            .await
//! Coordinator-reduce local execution.
    pub fn execute_prepared(&self) -> Result<SendableRecordBatchStream, DataFusionError> {
            .map_err(|e| {
        // A trivial `SELECT * FROM "input-0"` proves the table resolves.
        .expect("string batch builds")
    fn two_string_batch(schema: &SchemaRef, col_a: &[&str], col_b: &[&str]) -> RecordBatch {
    fn i64_schema(column: &str) -> SchemaRef {
use datafusion::catalog::streaming::StreamingTable;
            .register_partition("input-0", Arc::clone(&schema))
            .execute_substrait(&substrait_bytes)
    async fn execute_substrait_sums_streaming_input() {
    /// and asserts one concatenated row per input.
            let mut buf = Vec::new();
        substrait_bytes: &[u8],
            .build();
            &["http://alpha", "http://bravo"],
    }
            .build()
        (
        let stream =
        let runtime_env = Arc::new(runtime_env.clone());
            .expect("execute");
        // Push three batches totaling 45 = 1+2+3+4+5+6+7+8+9, then close.
    /// Returns the current phantom reservation size, or 0 if none.
    /// returned [`PartitionStreamSender`] via
                .column(0)
            let df = producer.ctx.sql(sql).await.expect("concat sql parses");
                    outcome,
                .expect("utf8 col");
                .downcast_ref::<Int64Array>()
        };
    /// estimate is larger than the current one.
            .with_memory_pool(Arc::clone(&pool))
use substrait::proto::Plan;
    ) -> Result<(), DataFusionError> {
            vec![
            for i in 0..col.len() {
        let schema = i64_schema("x");
    /// Registers an in-memory input on the session under `name`, holding all
    fn two_string_schema(a: &str, b: &str) -> SchemaRef {
        let runner = tokio::spawn(async move {
        batches: Vec<RecordBatch>,
//!    creates a [`PartitionStreamSender`] / [`PartitionStreamReceiver`] pair,
        assert_eq!(session.phantom_size(), 0);
            false,
        let state_ref = self.ctx.state_ref();
            buf
        use std::sync::Arc;
            for chunk in &[vec![1i64, 2, 3], vec![4, 5, 6], vec![7, 8, 9]] {
            let df = producer
        }
        }
        // portable onto our real session.
 * this file be licensed under the Apache-2.0 license or a
    /// reduce-stage allocations count against the same pool as the shard-scan
        query_tracker::cancel_query(ctx_id);
            producer
    ///
        let batch = two_string_batch(
    use datafusion::arrow::datatypes::{DataType, Field, Schema};
            Arc::new(GreedyMemoryPool::new(10_000));
 * SPDX-License-Identifier: Apache-2.0
            .prepare_final_plan(&substrait_bytes)
            let col = batch
    }
use datafusion::execution::memory_pool::MemoryPool;
    fn set_phantom_stores_reservation() {
    ) -> Result<PartitionStreamSender, DataFusionError> {
    /// Executes the previously prepared plan and returns the output stream.
            displayable(physical_plan.as_ref()).indent(true)
    /// Registers a streaming input on the session under `name` and returns the
        let dataframe = self.ctx.execute_logical_plan(logical_plan).await?;
        let mut session = LocalSession::new(&env);
use datafusion::datasource::MemTable;
        // output type tag and fail when wrapping the stripped tree).
                e
    }
            let plan = df.logical_plan().clone();
    /// pool so concurrent reduces trigger backpressure before OOM.
//!    back a [`SendableRecordBatchStream`] the bridge layer can drain.
            let plan = df.logical_plan().clone();
    fn phantom_released_on_session_drop() {
    fn test_runtime_env() -> RuntimeEnv {
//! the caller-supplied [`RuntimeEnv`] (and therefore its memory pool) with the
        let _tracking =
                DataFusionError::Execution(format!("Failed to register memtable '{}': {}", name, e))
    /// # Panics
        session
            .register_partition("input-0", Arc::clone(&schema))
            "QueryTrackingContext::new must register a cancellation token"
    /// path.
            }
        let pool: Arc<dyn datafusion::execution::memory_pool::MemoryPool> =
            substrait.encode(&mut buf).expect("encode");
        log_debug!(
            .with_physical_optimizer_rules(
#[cfg(test)]
            }
        let _sender = session
        use datafusion::execution::memory_pool::GreedyMemoryPool;
    }
    /// as a [`StreamingTable`]; Substrait plans executed through
//! 1. For each declared stage input, [`LocalSession::register_partition`]
            let substrait = to_substrait_plan(&plan, &producer.ctx.state()).expect("to_substrait");
            SendableRecordBatchStream,
