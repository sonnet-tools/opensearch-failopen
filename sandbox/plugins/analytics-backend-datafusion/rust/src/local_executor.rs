        assert_eq!(session.target_partitions(), 4);
        let substrait_bytes = {
    }
    }
                .expect("sum parses");
        assert_eq!(session.target_partitions(), 2);
//! 2. [`LocalSession::execute_substrait`] decodes a Substrait plan against the
        let mut total: i64 = 0;
    }
    /// Phantom reservation held for the lifetime of this session. Accounts for
        let msg = result.err().unwrap();
    #[test]
}
        let (sender, receiver) = channel(Arc::clone(&schema));
                ));
    /// same limits as the shard-scan path.
                .await
        let mut total: i64 = 0;
            .expect("register succeeds");
        };
    }
            tokio::time::sleep(Duration::from_secs(60)).await;
        let stripped = crate::relabel_exec::wrap_if_relabel_needed(stripped, target_schema)?;
            let col = datafusion::arrow::compute::cast(batch.column(0), &DataType::Utf8)
            "QueryTrackingContext::new must register a cancellation token"
use datafusion::physical_plan::displayable;
    }
                .expect("producer register");
    _phantom_reservation: Option<datafusion::execution::memory_pool::MemoryReservation>,
            }
        let mut session = LocalSession::new(&env);
    }
    /// [`Self::execute_prepared`].
    #[tokio::test]
        // output type tag and fail when wrapping the stripped tree).
    ) {
            .with_runtime_env(runtime_env)
    /// Reduce target_partitions on this session. Only reduces, never increases.
/// accounting shares the node-wide pool. One session corresponds to one reduce
        producer.join().expect("producer thread");
        let table = MemTable::try_new(schema, vec![batches])?;
        let mut session = LocalSession::new(&env);
/// Owns a [`SessionContext`] that reuses the caller's [`RuntimeEnv`] so memory
        Ok(())
//!
                ))
    ) -> Result<(), DataFusionError> {
            .execute_substrait(&substrait_bytes)
            let mut buf = Vec::new();
}
            .with_memory_pool(Arc::clone(&pool))
            .unwrap();
            "concat(substring, '|', substring) must yield one '|'-joined row per input"
//! 1. For each declared stage input, [`LocalSession::register_partition`]
        let runtime_env = Arc::new(runtime_env.clone());
            Ok::<(), String>(())
    /// the outer operands are scalar-function calls and the middle operand is a
 */
            DataFusionError::Execution(format!(
    /// [`PartitionStreamSender`]s flow naturally into the DataFusion physical
        assert_eq!(total, 45);
        schema: SchemaRef,
            }
            .map_err(|e| {
            let mut producer = LocalSession::new(&env);
        let env = test_runtime_env();
        RecordBatch::try_new(
            substrait.encode(&mut buf).expect("encode");
    /// Unlike [`Self::register_partition`], this method does not return a
        self._phantom_reservation = Some(reservation);
    }
    ///
        Ok(sender)
 * compatible open source license.
    /// shard responses in Java and hands them across in one call.
            .prepare_final_plan(&substrait_bytes)
        Arc::new(Schema::new(vec![
        let substrait_bytes = {
/// [`Self::execute_substrait`].
    /// phantom_size() first and only acquire a new reservation if the new
        // Each row joins the two substring results with the middle '|' literal.
        DataFusionError,
                .sql("SELECT SUM(x) AS total FROM \"input-0\"")
                .ctx
        let df = session
            crate::substrait_consumer::from_substrait_plan(&self.ctx.state(), &plan).await?;
        while let Some(batch) = stream.next().await {
        // portable onto our real session.
        let schema = two_string_schema("url", "referer");
            .ctx
            let mut producer = LocalSession::new(&env2);
        };
            .copied_config()
        self._phantom_reservation.as_ref().map_or(0, |r| r.size())
    pub(crate) prepared_plan: Option<Arc<dyn datafusion::physical_plan::ExecutionPlan>>,
    pub fn phantom_size(&self) -> usize {
            let substrait = to_substrait_plan(&plan, &producer.ctx.state()).expect("to_substrait");
        assert!(session.prepared_plan.is_some());
    /// Coordinator-side task cancellation wiring: once Java calls
        let result = runner.await.expect("spawn");
            .expect("execute");
    pub fn batch_size(&self) -> usize {
    ) -> Result<(), DataFusionError> {
        use std::num::NonZeroUsize;
            substrait.encode(&mut buf).expect("encode");
            let plan = df.logical_plan().clone();
//!    back a [`SendableRecordBatchStream`] the bridge layer can drain.
    }
    #[tokio::test]
                .await
            .register_table(name, Arc::new(table))
            let col = col
            Arc::new(GreedyMemoryPool::new(10_000_000));
    /// reduce-stage allocations count against the same pool as the shard-scan
    }
    /// as a [`StreamingTable`]; Substrait plans executed through
            ctx,
    fn two_string_batch(schema: &SchemaRef, col_a: &[&str], col_b: &[&str]) -> RecordBatch {
            substrait.encode(&mut buf).expect("encode");
        );
    /// channel sender — the batches are fully materialized in the table. Used
            token.is_some(),
        // matching session — the plan only references `input-0`, so it is
    /// path.
        }
        Ok((stream, physical_plan))
            prepared_plan: None,
        reservation.try_grow(1000).unwrap();
            crate::relabel_exec::wrap_if_relabel_needed(physical_plan, target_schema)?;
    async fn register_partition_makes_table_resolvable() {
        let schema = i64_schema("x");
        let physical_plan = dataframe.create_physical_plan().await?;
            "error must name the cancelled context: got [{}]",
                .sql("SELECT SUM(s) FROM \"input-0\"")
            .expect("execute");
    }
            let env2 = test_runtime_env();
        let reserved_before = pool.reserved();
                    crate::partition_stream::SendOutcome::Sent
                assert!(matches!(
            .options()
        .expect("string batch builds")
        // Push three batches totaling 45 = 1+2+3+4+5+6+7+8+9, then close.
            .await
    /// Sets the phantom reservation for this session. Caller should check
            .expect("register memtable");
        let state = SessionStateBuilder::new()
    }
        let physical_plan =
            column,
        if new_partitions < current {
/// Coordinator-reduce DataFusion session.
use datafusion::common::DataFusionError;
 * this file be licensed under the Apache-2.0 license or a
 *
        let stream =
                .downcast_ref::<Int64Array>()
    async fn execute_substrait_sums_memtable_input() {
        })?;
            vec![Arc::new(Int64Array::from(values.to_vec()))],
    pub fn register_memtable(
impl LocalSession {
    /// Called serially from register_partition_stream during session setup,
            Arc::new(GreedyMemoryPool::new(10_000));
        let (mut stream, _plan) = session
            .register_memtable("input-0", Arc::clone(&schema), vec![batch])
        let pool: Arc<dyn datafusion::execution::memory_pool::MemoryPool> =
                .expect("i64 col");
//! the caller-supplied [`RuntimeEnv`] (and therefore its memory pool) with the
        &mut self,
                .downcast_ref::<Int64Array>()
        let mut results: Vec<String> = Vec::new();
    ) -> Result<PartitionStreamSender, DataFusionError> {
//!
//! model used by `DataFusionRuntime` / `ShardView` / `QueryStreamHandle`.
        session.set_phantom(reservation);
        use datafusion::execution::memory_pool::{GreedyMemoryPool, MemoryConsumer};
    /// producer side of the channel.
        while let Some(batch) = stream.next().await {
            .register_table(name, Arc::new(table))
        name: &str,
    }
                "http://|https://".to_string(),
            .expect("register");
use datafusion::execution::memory_pool::MemoryPool;
            DataType::Int64,
    /// pool so concurrent reduces trigger backpressure before OOM.
            // DataFusion's string functions may return Utf8/LargeUtf8/Utf8View depending on
                DataFusionError::Execution(format!(
        results.sort();
    #[test]
        let sql = "SELECT concat(substring(url, 1, 7), '|', substring(referer, 1, 8)) AS r \
        log_debug!(
        let plan = Plan::decode(substrait_bytes).map_err(|e| {
        let mut config = SessionConfig::new();
                "http://|https://".to_string(),
            let mut buf = Vec::new();
            for i in 0..col.len() {
        );
            .unwrap();
use native_bridge_common::log_debug;
        let schema = i64_schema("x");
        bytes: &[u8],
        schema: SchemaRef,
                .register_partition("input-0", Arc::clone(&schema))
        // that never receives batches.
            reservation.try_grow(5000).unwrap();
            .execute_substrait(&substrait_bytes)
            state.config_mut().options_mut().execution.target_partitions = new_partitions;
    /// Returns the current phantom reservation size, or 0 if none.
    fn i64_schema(column: &str) -> SchemaRef {
    }
        Self {
                .map_err(|e| DataFusionError::Execution(format!("execute_substrait: {}", e)))?;
            let substrait = to_substrait_plan(&plan, &producer.ctx.state()).expect("to_substrait");
                results.push(col.value(i).to_string());
//!    session (its table references resolve to the streaming tables) and hands
 * The OpenSearch Contributors require contributions made to
                Arc::new(StringArray::from(col_b.to_vec())),
    fn test_runtime_env() -> RuntimeEnv {
            &["http://alpha", "http://bravo"],
        let current = state.config().options().execution.target_partitions;
    /// [`Self::execute_substrait`] resolve table references named `name` to
        let target_schema = crate::schema_coerce::coerce_inferred_schema(stripped.schema());
    /// Registers an in-memory input on the session under `name`, holding all
            i64_batch(&schema, &[7, 8, 9]),
    ) -> Result<
            .as_ref()
            .register_partition("input-0", Arc::clone(&schema))
    use futures::StreamExt;
            let batch = batch.expect("batch ok");
        name: &str,
        use datafusion::execution::memory_pool::{GreedyMemoryPool, MemoryConsumer};
    use tokio::runtime::Handle;
//!    creates a [`PartitionStreamSender`] / [`PartitionStreamReceiver`] pair,
            i64_batch(&schema, &[4, 5, 6]),
    }
    /// before any query execution begins.
        assert!(
            .expect("prepare_final_plan succeeds");
            Arc::new(GreedyMemoryPool::new(10_000_000));
use substrait::proto::Plan;
    ///
                .column(0)
            msg
            msg.contains(&ctx_id.to_string()) && msg.to_lowercase().contains("cancelled"),
            let env = test_runtime_env();
    }
        crate::udaf::register_all(&ctx);
            let col = batch
            .await
    ///
            displayable(physical_plan.as_ref()).indent(true)
        assert_eq!(session.target_partitions(), 2);
    async fn execute_substrait_sums_streaming_input() {
    }
        let table = StreamingTable::try_new(schema, vec![partition])?;
            .register_partition("input-0", Arc::clone(&schema))
    pub fn target_partitions(&self) -> usize {
        log_debug!(
        let _sender = session
            let mut buf = Vec::new();
            SendableRecordBatchStream,
            .await
    /// every batch consumed or produced by this session counts against the
    /// Used by the bridge layer to seed a per-query tracking context so
        let state_ref = self.ctx.state_ref();
use datafusion::physical_plan::streaming::PartitionStream;
        let env = test_runtime_env();
use datafusion::prelude::{SessionConfig, SessionContext};
        &mut self,
    async fn prepare_final_plan_stores_plan() {
    async fn execute_substrait_concat_substring_literal_substring() {
        // Two rows, both non-empty so they survive the WHERE filter.
    }
        let blocked = async {
    /// [`cancel_query(context_id)`] cascade resolves the racing execute
        session
    }
        let mut session = LocalSession::new(&env);
        let batch = two_string_batch(
        self.prepared_plan = Some(stripped);
            "DataFusion logical plan:\n{}",
    /// Decodes Substrait → LogicalPlan → PhysicalPlan, applies final-mode
        let runner = tokio::spawn(async move {
        Ok(())
//! raw `Box::into_raw` pointer managed in `api.rs`, matching the lifecycle
    /// # Panics
            let mut buf = Vec::new();
    /// Registers a streaming input on the session under `name` and returns the
            let _unused = producer
    }
    pub async fn prepare_final_plan(
        let consumer = MemoryConsumer::new("test_phantom").with_can_spill(true);
        let producer = std::thread::spawn(move || {
                .column(0)
        });
                    outcome,
            })?;
//!    wraps the receiver in a [`SingleReceiverPartition`], and registers it as
        session
    /// Prepares a final-aggregate physical plan on this session.
        ]))
        // Strip first so `force_aggregate_mode(Final)` can find the Final/Partial pair
        // through the raw plan; then derive `target_schema` and wrap with RelabelExec from
        );
//! `DatafusionReduceSink` on the Java side:
            let df = producer.ctx.sql(sql).await.expect("concat sql parses");
        let dataframe = self.ctx.execute_logical_plan(logical_plan).await?;
            vec![
                .as_any()
            Field::new(a, DataType::Utf8, false),
        assert_eq!(session.phantom_size(), 0);
        let plan = Plan::decode(bytes).map_err(|e| {
    #[tokio::test]
        use crate::query_tracker::{self, QueryTrackingContext};
    use datafusion::execution::runtime_env::RuntimeEnvBuilder;
        &mut self,
            false,
///
use datafusion::execution::runtime_env::RuntimeEnv;
        use std::sync::Arc;
            .build()
    fn reduce_target_partitions_lowers_value() {
    /// streaming tables, so input batches pushed into
        let producer_schema = Arc::clone(&schema);
    ///
        );
        config.options_mut().execution.target_partitions =
    /// Panics if no plan has been prepared via [`Self::prepare_final_plan`].
            .expect("runtime env builds")
//! The session has no knowledge of the FFM bridge; it is exposed to Java via a
        )
            &schema,
                crate::agg_mode::physical_optimizer_rules_without_combine(),
use crate::partition_stream::{channel, PartitionStreamSender, SingleReceiverPartition};
                   FROM \"input-0\" WHERE url <> '' AND referer <> ''";
            buf
        )]))
    ///
        // A future that would block indefinitely — `cancel_query` is the
        )?;
    /// and asserts one concatenated row per input.
            .expect("register succeeds");
    /// Builds a session whose `SessionContext` reuses the given [`RuntimeEnv`].
            producer
            let substrait = to_substrait_plan(&plan, &producer.ctx.state()).expect("to_substrait");
            .expect("register memtable");
                    name, e
            }
        let token = query_tracker::get_cancellation_token(ctx_id);
        session
                total += col.value(i);
            .build()
            false,
        ];
    pub async fn execute_substrait(
use datafusion::execution::{SendableRecordBatchStream, SessionStateBuilder};
        // Never increases
    /// stripping, and stores the result for later execution via
    /// `batches` in a single [`MemTable`] partition.
            assert_eq!(pool.reserved(), reserved_before + 5000);
            logical_plan.display_indent()
        // Register a streaming table so the plan can resolve table refs.
                .expect("i64 col");
        self.ctx
        substrait_bytes: &[u8],
    ///
use datafusion::datasource::MemTable;
            crate::agg_mode::Mode::Final,
    /// plan. The returned stream is hot — polling it drives both the reduce
    /// Table references in the plan resolve through the session's registered
            .target_partitions
            i64_batch(&schema, &[1, 2, 3]),
        let stripped = crate::agg_mode::apply_aggregate_mode(
                e
        let pool: Arc<dyn datafusion::execution::memory_pool::MemoryPool> =
    /// Returns the memory pool the session's `RuntimeEnv` was built with.
        let ctx_id = 98_765;
        let target_schema = crate::schema_coerce::coerce_inferred_schema(physical_plan.schema());
            )
        }
                .register_memtable("input-0", Arc::clone(&schema), vec![])
                .expect("producer register");
            producer
        let env = test_runtime_env();
                .expect("utf8 col");
                let outcome = sender.send_blocking(Ok(i64_batch(&producer_schema, chunk)), &handle);
        use std::time::Duration;
        .expect("batch builds")
/// [`Self::register_partition`] and is drained exactly once via
            crate::api::get_reduce_target_partitions();
        let env = test_runtime_env();
    /// `execute_local_plan(session, plan, context_id)` the context is
    }
use std::sync::Arc;
        let schema = i64_schema("s");
                "prepare_final_plan: failed to decode Substrait: {}",
    /// a parent `AnalyticsQueryTask.cancel()` interrupts the reduce even
            "DataFusion coordinator reduce physical plan:\n{}",
        let partition: Arc<dyn PartitionStream> = Arc::new(SingleReceiverPartition::new(receiver));
        {
                total += col.value(i);
        session.reduce_target_partitions(2);
        let mut session = LocalSession::new(&env);
                    "Failed to register streaming table '{}': {}",
            .expect("execute");
        // matching session — the plan only references `input-0`, so it is
        // Brief yield so the runner parks on the sleep before we cancel.
    use datafusion_substrait::logical_plan::producer::to_substrait_plan;
    /// estimate is larger than the current one.
            vec![
        let _tracking =
            let consumer = MemoryConsumer::new("test_phantom").with_can_spill(true);
    /// Executes the previously prepared plan and returns the output stream.
    /// future through the [`cancellation::cancellable`] branch.
            let _unused = producer
    /// returned [`PartitionStreamSender`] via
            buf
    #[tokio::test]
        let ctx = SessionContext::new_with_state(state);
    #[test]
            let df = producer
            ))
    /// Returns the current target_partitions for this session.
        assert!(result.is_err(), "cancel_query must surface as an error");
            .build()
        let mut session = LocalSession::new(&env);
    /// Mirrors the `execute_query` cancel path for the coordinator entry so
            let col = batch
//! rest of the node. The session is the Rust-side counterpart of
            Arc::clone(schema),
            let mut reservation = consumer.register(&pool);
use datafusion::catalog::streaming::StreamingTable;
    #[tokio::test]
        // only way out. Mirrors a coord reduce stalled on an input partition
        assert!(session.prepared_plan.is_none());
        let session = LocalSession::new(&env);
        let mut reservation = consumer.register(&pool);
            }
        )
    }
    }
    fn two_string_schema(a: &str, b: &str) -> SchemaRef {
        let (mut stream, _plan) = session
    use arrow_array::{Array, Int64Array, RecordBatch, StringArray};
            datafusion::physical_plan::execute_stream(physical_plan.clone(), self.ctx.task_ctx())
        let pool: Arc<dyn datafusion::execution::memory_pool::MemoryPool> =
                .expect("producer register");
mod tests {
    ///
        let env = RuntimeEnvBuilder::new()
        &self,
        // Build Substrait bytes for SELECT SUM(s) FROM "input-0"
            })?;
/*
    }
        // A trivial `SELECT * FROM "input-0"` proves the table resolves.
        let env = test_runtime_env();
            let df = producer
            buf
            .build();
        let mut state = state_ref.write();
        Arc::new(Schema::new(vec![Field::new(
        self.ctx
        };
/// stage; it holds the streaming inputs registered by
        // Build the Substrait bytes from a SQL-built logical plan against a
                .ctx
            let batch = batch.expect("batch ok");
        })?;
                Arc::new(StringArray::from(col_a.to_vec())),
        self.ctx
            for chunk in &[vec![1i64, 2, 3], vec![4, 5, 6], vec![7, 8, 9]] {
        let plan = self
    ///
            for i in 0..col.len() {
            results,
        let substrait_bytes = {
        let env = test_runtime_env();
    async fn cancel_query_fires_token_registered_from_reduce_path() {
        let handle = Handle::current();
    /// by the memtable variant of the coordinator-reduce sink, which buffers
            let mut session = LocalSession::new(&env);
                .await
                DataFusionError::Execution(format!("Failed to register memtable '{}': {}", name, e))
    /// string literal. Round-trips through SQL → Substrait → `from_substrait_plan`
    /// before the first batch is produced.
            .with_physical_optimizer_rules(
    use super::*;
            let env = test_runtime_env();
        };
        assert_eq!(session.phantom_size(), 1000);
            Arc::clone(schema),
            _phantom_reservation: None,
            DataFusionError::Execution(format!("Failed to decode Substrait plan: {}", e))
    /// The receiver is wrapped in a [`SingleReceiverPartition`] and registered
        assert_eq!(
        session.reduce_target_partitions(8);
            .prepared_plan
        ),
        RecordBatch::try_new(
    ctx: SessionContext,
    /// this streaming table. The caller pushes `RecordBatch`es into the
            let df = producer
        // portable onto our real session.
        let sender = session
                .register_memtable("input-0", Arc::clone(&schema), vec![])
    > {
            ],
        batches: Vec<RecordBatch>,
            physical_plan,
            .register_partition("input-0", Arc::clone(&schema))
            .expect("sql parses");
            &["https://gamma", "https://delta"],
        RuntimeEnvBuilder::new()
        };
            let plan = df.logical_plan().clone();
use datafusion::arrow::datatypes::SchemaRef;
            substrait.encode(&mut buf).expect("encode");
        // the stripped output (otherwise the relabel target would carry the pre-strip Final
            let mut producer = LocalSession::new(&env);
    #[tokio::test]
            .register_memtable("input-0", Arc::clone(&schema), batches)
            .await
                .as_any()
            let substrait = to_substrait_plan(&plan, &producer.ctx.state()).expect("to_substrait");
        assert_eq!(pool.reserved(), reserved_before);
        assert_eq!(total, 45);
    /// stream.
    pub fn execute_prepared(&self) -> Result<SendableRecordBatchStream, DataFusionError> {
    use datafusion::arrow::datatypes::{DataType, Field, Schema};
        use datafusion::execution::memory_pool::GreedyMemoryPool;
        let env = RuntimeEnvBuilder::new()
        let physical_plan = dataframe.create_physical_plan().await?;
    fn phantom_released_on_session_drop() {
            .with_config(config)
    }
        datafusion::physical_plan::execute_stream(Arc::clone(plan), self.ctx.task_ctx())
            for i in 0..col.len() {
        let schema = i64_schema("x");
    /// registered in [`query_tracker::QUERY_REGISTRY`], and a
            // version; cast to Utf8 so the assertion is independent of the concrete string type.
        let mut session = LocalSession::new(&env);
 * SPDX-License-Identifier: Apache-2.0
    /// The runtime's memory pool, disk manager, and caches are inherited —
        );
            QueryTrackingContext::new(ctx_id, pool, query_tracker::QueryType::Coordinator);
        // Session dropped — phantom must be released
//!    a [`StreamingTable`] on the session under the input id.
        use crate::cancellation;
    /// Decodes a Substrait plan against the session and returns the resulting
        let logical_plan =
        let substrait_bytes = {
    }
                .sql("SELECT SUM(x) AS total FROM \"input-0\"")
        // Build the Substrait bytes from a SQL-built logical plan against a
use prost::Message;
            .map_err(|e| {
                .expect("sum parses");
//!
            Arc<dyn datafusion::physical_plan::ExecutionPlan>,
        }
            buf
            cancellation::cancellable(token.as_ref(), ctx_id, blocked).await
                .downcast_ref::<StringArray>()
        self.ctx.copied_config().options().execution.batch_size
        query_tracker::cancel_query(ctx_id);
        while let Some(batch) = stream.next().await {
    fn set_phantom_stores_reservation() {
            .with_memory_pool(Arc::clone(&pool))
pub struct LocalSession {
        reservation: datafusion::execution::memory_pool::MemoryReservation,
            ],
        let (mut stream, _plan) = session
            .with_default_features()
    /// Returns the configured batch_size for this session.
            let plan = df.logical_plan().clone();
//! A [`LocalSession`] holds a DataFusion [`SessionContext`] configured to share
        tokio::time::sleep(Duration::from_millis(20)).await;
            .await
    pub fn register_partition(
    /// Pre-prepared physical plan (set by `prepare_final_plan`).
    pub fn reduce_target_partitions(&self, new_partitions: usize) {
            .expect("execute_prepared called without a prepared plan");
        let _sender = session
            session.set_phantom(reservation);
                .expect("sum parses");
            .execution
    }
    /// computation and the consumption of the streaming inputs.
                .as_any()
                .expect("producer register");
        Arc::clone(&self.ctx.runtime_env().memory_pool)
        }
        (
            crate::substrait_consumer::from_substrait_plan(&self.ctx.state(), &plan).await?;
    pub fn new(runtime_env: &RuntimeEnv) -> Self {
            let plan = df.logical_plan().clone();
    pub fn memory_pool(&self) -> Arc<dyn MemoryPool> {
    /// `concat(substring(a, ...), '|', substring(b, ...))` over a WHERE filter —
                .expect("cast concat output to Utf8");
        let logical_plan =
    fn i64_batch(schema: &SchemaRef, values: &[i64]) -> RecordBatch {
            let batch = batch.expect("batch ok");
        &mut self,
                .register_partition("input-0", Arc::clone(&schema))
        assert_eq!(df.schema().fields().len(), 1);
            drop(sender); // EOF
            let mut producer = LocalSession::new(&env);
        let dataframe = self.ctx.execute_logical_plan(logical_plan).await?;
        });
                .ctx
use arrow_array::RecordBatch;
    /// untracked memory (intermediate buffers, hash table overhead) in the shared
        );
#[cfg(test)]
        let batches = vec![
        crate::udf::register_all(&ctx);
        }
    /// [`PartitionStreamSender::send_blocking`].
        }
            .execute_substrait(&substrait_bytes)
            Field::new(b, DataType::Utf8, false),
            let env = test_runtime_env();
        assert!(
    pub fn set_phantom(
            .sql("SELECT x FROM \"input-0\"")
//! Coordinator-reduce local execution.
}
