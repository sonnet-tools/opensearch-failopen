    ///
        let blocked_schema = Arc::clone(&schema);
        for i in 0..CHANNEL_CAPACITY {
    /// bridge push without being async itself and without requiring the calling
            .receiver
                    None => Poll::Ready(None),
        failure_emitted: false,
    fn early_termination_after_receiver_drop_is_noop() {
use datafusion::physical_plan::streaming::PartitionStream;
    /// producer/drain died mid-stream. The receiver consults it on channel-close so a truncated
        }
        assert!(
            blocked.join().unwrap(),
        let schema = test_schema();
            receiver.lock().close();
    }
        schema,
        // when the bounded channel is FULL. fail() records out-of-band (no channel send), so it works
            .field("schema", &self.schema)
    ///
    let receiver = PartitionStreamReceiver {
        assert_eq!(second.num_rows(), 1);
use datafusion::arrow::datatypes::SchemaRef;
        // Upstream wrapped the receiver in a ChannelMutex (parking_lot) so the sender can hold a
        producer.await.unwrap();
    fn schema(&self) -> &SchemaRef {
impl PartitionStream for SingleReceiverPartition {
        sender.fail(DataFusionError::Execution("spill read failed".to_string()));
        let schema = test_schema();
        let partition = SingleReceiverPartition::new(receiver);
        }
            sender
    /// Delivery is via the flag, not the channel: the caller (`sender_fail`) drops the sender right
    fn schema(&self) -> SchemaRef {
const CHANNEL_CAPACITY: usize = 4;
        match polled {
                .tx
    }
        let schema = test_schema();
        &self,
    fn early_termination_unblocks_full_channel_sender() {
/// Implements [`Stream`] + [`RecordBatchStream`] so DataFusion can poll it
        assert!(
    }
    receiver: Mutex<Option<PartitionStreamReceiver>>,
        )
    rx: Arc<ChannelMutex<mpsc::Receiver<Result<RecordBatch, DataFusionError>>>>,
    }
            sender
        // make every close look like an error.
        sender.tx.try_send(Ok(test_batch(&schema, &[1]))).unwrap();
        let blocked_sender = Arc::clone(&sender);
 * The OpenSearch Contributors require contributions made to
    Sent,
                        Poll::Ready(Some(Err(DataFusionError::Execution(msg))))
    }
        let producer = tokio::spawn(async move {
//! # Backpressure
    }
/// Consumer side of a partition stream.
            }
    failure_emitted: bool,
    async fn clean_close_without_failure_is_eof_not_error() {
        producer.join().unwrap();
        producer.await.unwrap();
            sender
                        self.failure_emitted = true;
        let second = receiver.next().await.unwrap().unwrap();
    /// couldn't be enqueued in-band (then the sender drops → channel closes → would otherwise look
    /// Marks the stream as TERMINALLY FAILED. Used by the failure path (`sender_fail`) when the
        rx: shared_rx,
    /// producer/drain died mid-stream: the consumer must see an `Err` (so the query fails) rather than
    fn fmt(&self, f: &mut fmt::Formatter<'_>) -> fmt::Result {
            "stream ends after the terminal error"
        let schema = test_schema();
                    }
        sender.tx.try_send(Ok(test_batch(&schema, &[2]))).unwrap();
                .await
/// Wraps a [`PartitionStreamReceiver`] so it can be registered as a DataFusion
        let taken = self
/// a `SessionContext` as a `StreamingTable`.
    /// Closing the receiver rejects any blocked or future sends while preserving
                .send(Ok(test_batch(&producer_schema, &[3])))
}
            drop(sender);
/// than once across the life of a plan. The receiver can only be consumed once,
    use arrow_array::Int64Array;
        drop(receiver);
        schema: Arc::clone(&schema),
        // codex round-5 BLOCKER #1: a truncated partition must NEVER be consumed as a clean EOF, even
        assert_eq!(batch.num_rows(), 1);
        for _ in 0..CHANNEL_CAPACITY {
        }
        match handle.block_on(self.tx.send(batch)) {
                .await
            other => other,
//! contract expected by DataFusion's `StreamingTable` when a partition is
    schema: SchemaRef,
            .field("schema", &self.schema)
    (sender, receiver)
        let producer_schema = Arc::clone(&schema);
    /// partition surfaces as an `Err` even when the bounded data channel was full and the error
    failure: Arc<OnceLock<String>>,
    async fn receiver_yields_sent_batches_then_eof() {
        let rt = tokio::runtime::Runtime::new().expect("runtime builds");
impl SingleReceiverPartition {
    }
    };
    receiver: Weak<ChannelMutex<mpsc::Receiver<Result<RecordBatch, DataFusionError>>>>,
            receiver: Mutex::new(Some(receiver)),
                .tx
    }
/// Outcome of a blocking send. `ReceiverDropped` is the benign terminal case — the
pub struct PartitionStreamReceiver {
/// DataFusion's [`PartitionStream::execute`] contract may invoke `execute` more
/// receiver side.
    schema: SchemaRef,
        assert_eq!(batch.num_rows(), 1);
        sender.terminate_early();
    /// Out-of-band terminal-failure flag shared with the receiver. Set by [`try_fail`] when the
        let batch = receiver.next().await.unwrap().unwrap();
                .expect("prefill within capacity");
 *
    type Item = Result<RecordBatch, DataFusionError>;
/// Creates a paired sender/receiver over a bounded mpsc (capacity
        assert_eq!(RecordBatchStream::schema(&receiver), schema);
    /// Shared with the sender (see [`PartitionStreamSender::failure`]). On channel-close, if this is
            assert!(matches!(outcome, SendOutcome::Sent));
    /// This is safe to call while [`Self::send_blocking`] holds an immutable sender
                let recorded = self.failure.get().cloned();
    }
        let sender_schema = Arc::clone(&schema);
    /// instead of `None`. So a truncated partition can NEVER be consumed as complete, regardless of
    /// [`SendOutcome::ReceiverDropped`] only if the receiver has been dropped or
                .send(Ok(test_batch(&producer_schema, &[1])))
//!
    let sender = PartitionStreamSender {
    /// The provided `handle` is used to drive the async send — typically the
            vec![Arc::new(Int64Array::from(values.to_vec()))],
//! # Single-consumer contract
            assert!(item.is_ok(), "prefilled items are Ok batches");
        // released at the end of this statement, before the failure bookkeeping below.
                Box::pin(RecordBatchStreamAdapter::new(
        }
                    stream::empty(),
    }
            let outcome = sender.send_blocking(Ok(test_batch(&sender_schema, &[7, 8, 9])), &handle);
        // Control: a normal drop (no try_fail) must still be a clean EOF — the failure path must not
        let terminal = receiver.next().await.expect("a terminal item, not EOF");
//!
    /// this and then return `None` on the next poll.
    #[tokio::test]
        // Second execute() must not panic and must yield an empty stream.
            "error carries the failure reason: {err}"
        });
}
/// DataFusion consumer finished (e.g. a `LimitExec` satisfied its fetch), or an
        drop(sender); // close the channel
use datafusion::execution::{RecordBatchStream, TaskContext};
    #[test]
        .unwrap();
 */
        &self.schema
/// so the first `execute` takes it and subsequent calls return an empty stream
            schema: Arc::clone(&receiver.schema),
        let handle = rt.handle().clone();
            sender
        let ctx = Arc::new(TaskContext::default());
            .finish()
}
    #[tokio::test]
            .take();
        let (sender, mut receiver) = channel(Arc::clone(&schema));
    }
pub(crate) struct SingleReceiverPartition {
        sender.terminate_early();
        let polled = self.rx.lock().poll_recv(cx);
        );
        assert_eq!(first.num_rows(), 2);
    /// thread to be a Tokio worker.
            Some(receiver) => Box::pin(receiver),
        let (sender, mut receiver) = channel(Arc::clone(&schema));
            .expect("partition mutex poisoned")
    }
    fn test_schema() -> SchemaRef {
            .field("schema", &self.schema)
impl RecordBatchStream for PartitionStreamReceiver {
        let (sender, receiver) = channel(Arc::clone(&schema));
        let (sender, _receiver) = channel(Arc::clone(&schema));
    ) -> SendOutcome {
        if self.failure_emitted {
        assert_eq!(receiver.next().await.unwrap().unwrap().num_rows(), 1);
        let (sender, receiver) = channel(Arc::clone(&schema));
        }
    }
    use futures::StreamExt;
        let schema = test_schema();
}
    }
use tokio::runtime::Handle;
        assert!(matches!(
            sender
        let outcome = std::thread::spawn(move || {
    /// Guards the out-of-band error so it's emitted exactly once: after yielding the `Err` we set
        RecordBatch::try_new(
//! shard response pipeline.
            sender
///
/// early-termination request closed this partition's receiver. Surfaced as a distinct
/*
    /// like a clean EOF). (codex round-5 BLOCKER #1.)
//!
    }
//! [`SingleReceiverPartition::execute`] hands out the receiver exactly once. Any
        let mut second = partition.execute(ctx);
    #[tokio::test]
/// Producer side of a partition stream.
        let rt = tokio::runtime::Runtime::new().expect("runtime builds");
        for value in 0..CHANNEL_CAPACITY {
        let producer_schema = Arc::clone(&schema);
pub struct PartitionStreamSender {
        // and later sends must still report the dropped receiver.
}
    // Upstream: the receiver lives behind an Arc<ChannelMutex> so the sender can hold a Weak to it
use datafusion::common::DataFusionError;
        let (sender, mut receiver) = channel(Arc::clone(&schema));
//! Streaming input for coordinator-reduce execution.
    tx: mpsc::Sender<Result<RecordBatch, DataFusionError>>,
        Self {
use parking_lot::Mutex as ChannelMutex;
        batch: Result<RecordBatch, DataFusionError>,
        assert!(receiver.next().await.is_none());
            blocked_sender.send_blocking(Ok(test_batch(&blocked_schema, &[99])), &handle)
//! back-pressures when the DataFusion execute side falls behind. Under load the
            let item = receiver.next().await.expect("a prefilled batch");
        })
        // Then the stream yields the terminal Err exactly once (not None/clean-EOF).
impl fmt::Debug for PartitionStreamReceiver {
                // Second+ execute: hand back an already-closed empty stream so
                .await
/// Both halves share the provided [`SchemaRef`]. Dropping the sender closes the
        // Weak handle for early termination — hence the .lock() before poll_recv. The lock is
            }
    #[tokio::test]
        let blocked = std::thread::spawn(move || {
    /// Push a batch into the channel from a synchronous (non-async) context.
use datafusion::physical_plan::SendableRecordBatchStream;
//! A [`channel`] produces a paired [`PartitionStreamSender`] /
            "clean close is EOF, not Err"
    }
    ReceiverDropped,
    /// after this, which closes the channel; the receiver drains any already-queued `Ok` batches in
 * SPDX-License-Identifier: Apache-2.0
    failure: Arc<OnceLock<String>>,
    async fn early_termination_drains_buffered_batches_then_eof() {
            drop(sender);
    /// already buffered batches for the DataFusion consumer to drain before EOF.
            Ok(()) => SendOutcome::Sent,
        failure: Arc::clone(&failure),
        assert!(second.next().await.is_none());
        let sender = Arc::new(sender);
        tx,
///
        // The weak receiver-control handle no longer upgrades; this must not panic
/// directly. Typically handed to [`SingleReceiverPartition`] and registered on
        assert!(sender.tx.try_send(Ok(test_batch(&schema, &[3]))).is_err());
//! re-executed.
//!
    };
//! [`PartitionStreamReceiver`]. The sender is exposed through the FFM bridge so
        let mut first = partition.execute(Arc::clone(&ctx));
        .join()
impl fmt::Debug for SingleReceiverPartition {
use std::sync::{Arc, Mutex, OnceLock, Weak};
        let handle = rt.handle().clone();
    #[test]
                .unwrap();
        }
    async fn single_receiver_partition_executes_once_then_empty() {
        &self.schema
    fn fmt(&self, f: &mut fmt::Formatter<'_>) -> fmt::Result {
}
    /// set the receiver yields it as a terminal `Err` rather than a clean `None`/EOF.
}
            .finish()
        let (sender, receiver) = channel(Arc::clone(&schema));
mod tests {
}
                .try_send(Ok(test_batch(&schema, &[value as i64])))
#[cfg(test)]
                    Some(msg) => {
#[must_use]
//! can be registered on a `SessionContext` as a `StreamingTable`.
    use datafusion::arrow::datatypes::{DataType, Field, Schema};
            err.to_string().contains("spill read failed"),
//! The underlying mpsc is bounded (capacity 4) — chosen small so the sender
}
            None => {
    pub fn send_blocking(
    /// channel fullness. `OnceLock` — the first failure wins; later calls are no-ops. (codex round-5
        let _ = self.failure.set(err.to_string());
        let (sender, mut receiver) = channel(Arc::clone(&schema));
            SendOutcome::ReceiverDropped
    /// channel + non-polling consumer (the round-4 concern), and never double-emits the error.
        // terminal Err on channel-close.
                .send(Ok(test_batch(&producer_schema, &[42])))
        let first = receiver.next().await.unwrap().unwrap();
    fn send_blocking_reports_receiver_dropped() {
        failure,
            sender.send_blocking(Ok(test_batch(&schema, &[1])), &handle)
}
    let shared_rx = Arc::new(ChannelMutex::new(rx));
    /// Gracefully terminates this input partition without cancelling the query.
            // Channel closed (sender dropped). If the producer/drain recorded an out-of-band failure
impl Stream for PartitionStreamReceiver {
/// `StreamingTable` partition.
        });
        sender.terminate_early();
        let err = terminal.expect_err("truncated partition must surface as Err, never clean EOF");
        });
        let producer = tokio::spawn(async move {
        }
    }
    /// a clean EOF. Records the reason in the out-of-band `failure` flag (shared with the receiver) and
            .lock()
/// DataFusion execute side falls behind.
        handle: &Handle,
/// (zero batches, end-of-stream immediately) rather than panicking.
        let schema = test_schema();
        assert!(
    /// returns immediately — NO in-band channel send, so it can NEVER block/deadlock against a full
        });
    fn fmt(&self, f: &mut fmt::Formatter<'_>) -> fmt::Result {
                .tx
        assert!(sender.tx.try_send(Ok(test_batch(&schema, &[1]))).is_err());
//! empty stream rather than panicking — matches the "take once, then empty"
    async fn send_blocking_pushes_through_handle() {
    #[tokio::test]
/// variant so the FFM layer can signal it without the Java side substring-matching an
        // regardless of channel fullness; the receiver drains queued Oks in FIFO order, then yields the
    async fn fail_surfaces_error_even_when_channel_full_then_closed() {
            .finish()
    pub fn fail(&self, err: DataFusionError) {
//! Java feeder thread blocks on `send_blocking`, which naturally stalls the
    ///
    /// Blocks while the channel is full (natural backpressure). Returns
    async fn channel_preserves_schema() {
        assert_eq!(sender.schema(), &schema);
use tokio::sync::mpsc;
    pub(crate) fn new(receiver: PartitionStreamReceiver) -> Self {
        f.debug_struct("SingleReceiverPartition")
        // Saturate the channel (capacity 4) — fail() must not depend on a free slot.
            Err(_) => SendOutcome::ReceiverDropped,
impl fmt::Debug for PartitionStreamSender {
                .tx
 * compatible open source license.
/// [`CHANNEL_CAPACITY`]).
                    Arc::clone(&self.schema),
        drop(receiver);
    /// closed for early termination — the sole failure mode of `mpsc::Sender::send`.
/// `df_sender_close`) closes the channel, which signals EOF to the DataFusion
                .tx
    }
/// error message.
    /// FIFO order, then on close consults the flag and yields the recorded error as its terminal item
        assert_eq!(partition.schema(), &schema);
        let schema = test_schema();
            Poll::Ready(None) => {
        let producer = tokio::spawn(async move {
        match taken {
        assert_eq!(receiver.next().await.unwrap().unwrap().num_rows(), 1);
pub fn channel(schema: SchemaRef) -> (PartitionStreamSender, PartitionStreamReceiver) {
            // terminal Err so a TRUNCATED partition fails the query instead of looking like clean EOF.
        let schema = test_schema();
    // and close it for early termination without owning it.
}
}
        assert!(receiver.next().await.is_none());
//! Java can push Arrow `RecordBatch`es synchronously via
            return Poll::Ready(None);
        }
    #[tokio::test]
    use super::*;
            receiver.next().await.is_none(),
use futures::{stream, Stream};
    schema: SchemaRef,
impl PartitionStreamSender {
    #[test]
            Arc::clone(schema),
        // Queued Ok batches drain first (FIFO).
        assert!(receiver.next().await.is_none());
    fn execute(&self, _ctx: Arc<TaskContext>) -> SendableRecordBatchStream {
use std::pin::Pin;
        );
        let schema = test_schema();
                .unwrap();
        }
    }
            drop(sender);
                .send(Ok(test_batch(&producer_schema, &[1, 2])))
        let (sender, mut receiver) = channel(Arc::clone(&schema));
        );
            receiver.next().await.is_none(),
        // Emitted exactly once — the stream is done afterward.
    }
    /// `io_runtime` handle from the global `RuntimeManager`. This lets the FFM
//!
    }
        assert_eq!(batch.num_rows(), 3);
        receiver: Arc::downgrade(&shared_rx),
    /// Returns the schema this sender was created with.
use datafusion::arrow::record_batch::RecordBatch;
            drop(sender);
        assert!(first.next().await.is_none());
/// buffered batches are drained, which DataFusion interprets as end-of-input.
        if let Some(receiver) = self.receiver.upgrade() {
    fn poll_next(mut self: Pin<&mut Self>, cx: &mut Context<'_>) -> Poll<Option<Self::Item>> {
 * this file be licensed under the Apache-2.0 license or a
    pub fn terminate_early(&self) {
///
use std::task::{Context, Poll};
    /// borrow, unlike dropping the sender itself.
    }
/// Owned by the FFM bridge via `Box::into_raw`; dropping the sender (e.g. via
    }
}
//! subsequent `execute()` call on the same partition returns an already-closed
        assert!(matches!(outcome, SendOutcome::ReceiverDropped));
        let batch = first.next().await.unwrap().unwrap();
}
    let (tx, rx) = mpsc::channel(CHANNEL_CAPACITY);
        let batch = receiver.next().await.unwrap().unwrap();
//! [`PartitionStreamSender::send_blocking`]. The receiver implements DataFusion's
                .unwrap();
    }
        let schema = test_schema();
                // DataFusion sees the partition as drained.
                .unwrap();
        f.debug_struct("PartitionStreamReceiver")
        Arc::new(Schema::new(vec![Field::new("x", DataType::Int64, false)]))
///
    #[tokio::test]
        let handle = Handle::current();
    let failure: Arc<OnceLock<String>> = Arc::new(OnceLock::new());
    /// BLOCKER #1; supersedes the round-4 best-effort in-band approach.)
        Arc::clone(&self.schema)
            // Terminal: we already surfaced the out-of-band error. Stream is done.
use datafusion::physical_plan::stream::RecordBatchStreamAdapter;
                // Clone the message out before the mutable borrow of failure_emitted below.
                }
            // (try_fail) but couldn't enqueue it in-band (full channel + timeout), surface it here as a
use std::fmt;
        let (sender, receiver) = channel(Arc::clone(&schema));
    fn test_batch(schema: &SchemaRef, values: &[i64]) -> RecordBatch {
        ));
        producer.await.unwrap();
                .unwrap();
/// channel — the receiver's `poll_next` then yields `Ready(None)` once any
        f.debug_struct("PartitionStreamSender")
        });
                .await
pub enum SendOutcome {
//! [`RecordBatchStream`] and is wrapped in a [`SingleReceiverPartition`] so it
    pub fn schema(&self) -> &SchemaRef {
        let producer = std::thread::spawn(move || {
    ///
        let producer_schema = Arc::clone(&schema);
                match recorded {
                .try_send(Ok(test_batch(&schema, &[i as i64])))
                .tx
                ))
/// Bounded channel capacity. Small by design — producers back-pressure when the
        .unwrap()
