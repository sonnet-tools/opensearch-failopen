    fn schema(&self) -> &SchemaRef {
    pub fn fail(&self, err: DataFusionError) {
            sender
            .finish()
/// error message.
    let shared_rx = Arc::new(ChannelMutex::new(rx));
    };
    #[tokio::test]
        // Control: a normal drop (no try_fail) must still be a clean EOF — the failure path must not
        let taken = self
        let rt = tokio::runtime::Runtime::new().expect("runtime builds");
    use super::*;
                    None => Poll::Ready(None),
        for _ in 0..CHANNEL_CAPACITY {
    #[test]
                    }
    }
//!
//! [`PartitionStreamSender::send_blocking`]. The receiver implements DataFusion's
    /// set the receiver yields it as a terminal `Err` rather than a clean `None`/EOF.
 * compatible open source license.
    async fn channel_preserves_schema() {
    pub fn send_blocking(
        drop(receiver);
            Ok(()) => SendOutcome::Sent,
        sender.tx.try_send(Ok(test_batch(&schema, &[1]))).unwrap();
/// receiver side.
        let schema = test_schema();
        producer.await.unwrap();
    /// Out-of-band terminal-failure flag shared with the receiver. Set by [`try_fail`] when the
        &self.schema
        let producer = std::thread::spawn(move || {
        let blocked_schema = Arc::clone(&schema);
        sender.terminate_early();
    failure_emitted: bool,
        )
        }
            sender
        &self.schema
            err.to_string().contains("spill read failed"),
    fn execute(&self, _ctx: Arc<TaskContext>) -> SendableRecordBatchStream {
            sender
impl RecordBatchStream for PartitionStreamReceiver {
                        Poll::Ready(Some(Err(DataFusionError::Execution(msg))))
    schema: SchemaRef,
    /// producer/drain died mid-stream. The receiver consults it on channel-close so a truncated
//!
        );
    #[tokio::test]
/// early-termination request closed this partition's receiver. Surfaced as a distinct
    #[tokio::test]
    /// Marks the stream as TERMINALLY FAILED. Used by the failure path (`sender_fail`) when the
/// buffered batches are drained, which DataFusion interprets as end-of-input.
        let ctx = Arc::new(TaskContext::default());
/// DataFusion execute side falls behind.
        // and later sends must still report the dropped receiver.
        let schema = test_schema();
            blocked_sender.send_blocking(Ok(test_batch(&blocked_schema, &[99])), &handle)
        assert!(sender.tx.try_send(Ok(test_batch(&schema, &[1]))).is_err());
    }
use std::fmt;
        let (sender, receiver) = channel(Arc::clone(&schema));
        }
    pub fn terminate_early(&self) {
                // DataFusion sees the partition as drained.
        for i in 0..CHANNEL_CAPACITY {
    /// bridge push without being async itself and without requiring the calling
        drop(sender); // close the channel
        assert!(
impl SingleReceiverPartition {
        .unwrap()
            sender
/*
        assert!(
    async fn fail_surfaces_error_even_when_channel_full_then_closed() {
        let schema = test_schema();
        let producer = tokio::spawn(async move {
    #[test]
/// Consumer side of a partition stream.
/// Wraps a [`PartitionStreamReceiver`] so it can be registered as a DataFusion
//! can be registered on a `SessionContext` as a `StreamingTable`.
    ///
impl PartitionStreamSender {
        }
    }
    pub fn schema(&self) -> &SchemaRef {
        let rt = tokio::runtime::Runtime::new().expect("runtime builds");
            .expect("partition mutex poisoned")
        match polled {
pub fn channel(schema: SchemaRef) -> (PartitionStreamSender, PartitionStreamReceiver) {
            sender.send_blocking(Ok(test_batch(&schema, &[1])), &handle)
        assert_eq!(batch.num_rows(), 3);
//! empty stream rather than panicking — matches the "take once, then empty"
    fn poll_next(mut self: Pin<&mut Self>, cx: &mut Context<'_>) -> Poll<Option<Self::Item>> {
        );
            None => {
    /// thread to be a Tokio worker.
    receiver: Mutex<Option<PartitionStreamReceiver>>,
        let second = receiver.next().await.unwrap().unwrap();
pub(crate) struct SingleReceiverPartition {
    schema: SchemaRef,
    fn fmt(&self, f: &mut fmt::Formatter<'_>) -> fmt::Result {
        }
        })
            assert!(matches!(outcome, SendOutcome::Sent));
    }
    /// Push a batch into the channel from a synchronous (non-async) context.
    #[tokio::test]
    type Item = Result<RecordBatch, DataFusionError>;
        let (sender, _receiver) = channel(Arc::clone(&schema));
    }
/// DataFusion's [`PartitionStream::execute`] contract may invoke `execute` more
                    Arc::clone(&self.schema),
    async fn early_termination_drains_buffered_batches_then_eof() {
                .tx
        let (sender, receiver) = channel(Arc::clone(&schema));
    /// borrow, unlike dropping the sender itself.
/// directly. Typically handed to [`SingleReceiverPartition`] and registered on
    /// already buffered batches for the DataFusion consumer to drain before EOF.
    }
}
}
        assert!(first.next().await.is_none());
        schema,
}
/// DataFusion consumer finished (e.g. a `LimitExec` satisfied its fetch), or an
            let outcome = sender.send_blocking(Ok(test_batch(&sender_schema, &[7, 8, 9])), &handle);
use std::pin::Pin;
impl fmt::Debug for PartitionStreamReceiver {
                .expect("prefill within capacity");
    receiver: Weak<ChannelMutex<mpsc::Receiver<Result<RecordBatch, DataFusionError>>>>,
        let mut first = partition.execute(Arc::clone(&ctx));
    #[tokio::test]
use datafusion::execution::{RecordBatchStream, TaskContext};
use datafusion::physical_plan::stream::RecordBatchStreamAdapter;
    }
/// Outcome of a blocking send. `ReceiverDropped` is the benign terminal case — the
        let (sender, mut receiver) = channel(Arc::clone(&schema));
        rx: shared_rx,
    // Upstream: the receiver lives behind an Arc<ChannelMutex> so the sender can hold a Weak to it
    /// Gracefully terminates this input partition without cancelling the query.
        let producer = tokio::spawn(async move {
    }
}
use std::sync::{Arc, Mutex, OnceLock, Weak};
        // The weak receiver-control handle no longer upgrades; this must not panic
        handle: &Handle,
    ///
        failure_emitted: false,
            other => other,
            Poll::Ready(None) => {
            .lock()
use datafusion::arrow::datatypes::SchemaRef;
            receiver.next().await.is_none(),
        let batch = receiver.next().await.unwrap().unwrap();
        }
        assert!(sender.tx.try_send(Ok(test_batch(&schema, &[3]))).is_err());
impl fmt::Debug for SingleReceiverPartition {
}
    fn early_termination_after_receiver_drop_is_noop() {
    }
            .field("schema", &self.schema)
        let blocked = std::thread::spawn(move || {
    /// like a clean EOF). (codex round-5 BLOCKER #1.)
    let (tx, rx) = mpsc::channel(CHANNEL_CAPACITY);
/// `df_sender_close`) closes the channel, which signals EOF to the DataFusion
                .unwrap();
    failure: Arc<OnceLock<String>>,
        assert!(second.next().await.is_none());
        Self {
    };
/// `StreamingTable` partition.
        assert_eq!(partition.schema(), &schema);
//! The underlying mpsc is bounded (capacity 4) — chosen small so the sender
        let schema = test_schema();
        assert_eq!(RecordBatchStream::schema(&receiver), schema);
    }
    fn test_schema() -> SchemaRef {
        // when the bounded channel is FULL. fail() records out-of-band (no channel send), so it works
        assert_eq!(receiver.next().await.unwrap().unwrap().num_rows(), 1);
    use datafusion::arrow::datatypes::{DataType, Field, Schema};
impl Stream for PartitionStreamReceiver {
}
        }
/// Owned by the FFM bridge via `Box::into_raw`; dropping the sender (e.g. via
            drop(sender);
                match recorded {
            .finish()
                .unwrap();
/// so the first `execute` takes it and subsequent calls return an empty stream
        assert_eq!(batch.num_rows(), 1);
            .receiver
        failure: Arc::clone(&failure),
    /// channel fullness. `OnceLock` — the first failure wins; later calls are no-ops. (codex round-5
                .await
        producer.await.unwrap();
        let blocked_sender = Arc::clone(&sender);
    async fn send_blocking_pushes_through_handle() {
        }
        });
            schema: Arc::clone(&receiver.schema),
        assert!(
//!
        for value in 0..CHANNEL_CAPACITY {
        });
            .field("schema", &self.schema)
}
        // terminal Err on channel-close.
        failure,
        // Emitted exactly once — the stream is done afterward.
        tx,
    /// couldn't be enqueued in-band (then the sender drops → channel closes → would otherwise look
                .try_send(Ok(test_batch(&schema, &[value as i64])))
                .tx
    /// Returns the schema this sender was created with.
        let handle = rt.handle().clone();
        .unwrap();
}
    tx: mpsc::Sender<Result<RecordBatch, DataFusionError>>,
                    Some(msg) => {
        let terminal = receiver.next().await.expect("a terminal item, not EOF");
        let producer_schema = Arc::clone(&schema);
    failure: Arc<OnceLock<String>>,
        );
        &self,
            Arc::clone(schema),
    async fn receiver_yields_sent_batches_then_eof() {
use tokio::sync::mpsc;
//! A [`channel`] produces a paired [`PartitionStreamSender`] /
        });
/// variant so the FFM layer can signal it without the Java side substring-matching an
    /// producer/drain died mid-stream: the consumer must see an `Err` (so the query fails) rather than
        assert_eq!(receiver.next().await.unwrap().unwrap().num_rows(), 1);
use datafusion::physical_plan::SendableRecordBatchStream;
        let schema = test_schema();
    use futures::StreamExt;
                .try_send(Ok(test_batch(&schema, &[i as i64])))
    /// after this, which closes the channel; the receiver drains any already-queued `Ok` batches in
    /// Closing the receiver rejects any blocked or future sends while preserving
            .finish()
    /// FIFO order, then on close consults the flag and yields the recorded error as its terminal item
    fn early_termination_unblocks_full_channel_sender() {
            Some(receiver) => Box::pin(receiver),
        assert_eq!(first.num_rows(), 2);
    }
            "stream ends after the terminal error"
        if let Some(receiver) = self.receiver.upgrade() {
    async fn single_receiver_partition_executes_once_then_empty() {
        if self.failure_emitted {
    async fn clean_close_without_failure_is_eof_not_error() {
use futures::{stream, Stream};
/// Implements [`Stream`] + [`RecordBatchStream`] so DataFusion can poll it
 * this file be licensed under the Apache-2.0 license or a
#[cfg(test)]
        // codex round-5 BLOCKER #1: a truncated partition must NEVER be consumed as a clean EOF, even
                .tx
        let (sender, mut receiver) = channel(Arc::clone(&schema));
use datafusion::physical_plan::streaming::PartitionStream;
}
            "clean close is EOF, not Err"
//! [`RecordBatchStream`] and is wrapped in a [`SingleReceiverPartition`] so it
        assert_eq!(sender.schema(), &schema);
            }
    fn test_batch(schema: &SchemaRef, values: &[i64]) -> RecordBatch {
//! [`SingleReceiverPartition::execute`] hands out the receiver exactly once. Any
const CHANNEL_CAPACITY: usize = 4;
        let _ = self.failure.set(err.to_string());
/// than once across the life of a plan. The receiver can only be consumed once,
}
    fn schema(&self) -> SchemaRef {
impl fmt::Debug for PartitionStreamSender {
        batch: Result<RecordBatch, DataFusionError>,
        let (sender, mut receiver) = channel(Arc::clone(&schema));
#[must_use]
        });
        let producer_schema = Arc::clone(&schema);
//! back-pressures when the DataFusion execute side falls behind. Under load the
use parking_lot::Mutex as ChannelMutex;
/// channel — the receiver's `poll_next` then yields `Ready(None)` once any
                ))
        match taken {
        // Queued Ok batches drain first (FIFO).
    /// a clean EOF. Records the reason in the out-of-band `failure` flag (shared with the receiver) and
    let failure: Arc<OnceLock<String>> = Arc::new(OnceLock::new());
    /// this and then return `None` on the next poll.
        let first = receiver.next().await.unwrap().unwrap();
}
    #[test]
    /// `io_runtime` handle from the global `RuntimeManager`. This lets the FFM
        let mut second = partition.execute(ctx);
        let (sender, receiver) = channel(Arc::clone(&schema));
            let item = receiver.next().await.expect("a prefilled batch");
        f.debug_struct("SingleReceiverPartition")
/// Producer side of a partition stream.
///
                .send(Ok(test_batch(&producer_schema, &[3])))
        assert!(matches!(
            // terminal Err so a TRUNCATED partition fails the query instead of looking like clean EOF.
//! [`PartitionStreamReceiver`]. The sender is exposed through the FFM bridge so
        let schema = test_schema();
//! shard response pipeline.
    /// returns immediately — NO in-band channel send, so it can NEVER block/deadlock against a full
            drop(sender);
        let (sender, mut receiver) = channel(Arc::clone(&schema));
pub struct PartitionStreamReceiver {
    ///
/// a `SessionContext` as a `StreamingTable`.
                .await
    /// channel + non-polling consumer (the round-4 concern), and never double-emits the error.
    #[tokio::test]
        // Saturate the channel (capacity 4) — fail() must not depend on a free slot.
//! # Single-consumer contract
    #[tokio::test]
        let handle = rt.handle().clone();
    }
        assert!(matches!(outcome, SendOutcome::ReceiverDropped));
            assert!(item.is_ok(), "prefilled items are Ok batches");
            receiver.next().await.is_none(),
    }
            .field("schema", &self.schema)
 * The OpenSearch Contributors require contributions made to
    /// Delivery is via the flag, not the channel: the caller (`sender_fail`) drops the sender right
        f.debug_struct("PartitionStreamReceiver")
        let schema = test_schema();
        // Then the stream yields the terminal Err exactly once (not None/clean-EOF).
mod tests {
    }
        });
        .join()
    }
            // (try_fail) but couldn't enqueue it in-band (full channel + timeout), surface it here as a
        }
            Err(_) => SendOutcome::ReceiverDropped,
}
                    stream::empty(),
        Arc::new(Schema::new(vec![Field::new("x", DataType::Int64, false)]))
                .tx
    /// instead of `None`. So a truncated partition can NEVER be consumed as complete, regardless of
    }
    fn fmt(&self, f: &mut fmt::Formatter<'_>) -> fmt::Result {
///
        producer.join().unwrap();
//! Java feeder thread blocks on `send_blocking`, which naturally stalls the
 *
                .send(Ok(test_batch(&producer_schema, &[1])))
        let producer_schema = Arc::clone(&schema);
use datafusion::common::DataFusionError;
//! # Backpressure
        assert!(receiver.next().await.is_none());
            // Channel closed (sender dropped). If the producer/drain recorded an out-of-band failure
        schema: Arc::clone(&schema),
    schema: SchemaRef,
        sender.fail(DataFusionError::Execution("spill read failed".to_string()));
}
        let batch = receiver.next().await.unwrap().unwrap();
        let polled = self.rx.lock().poll_recv(cx);
                .tx
    /// Guards the out-of-band error so it's emitted exactly once: after yielding the `Err` we set
        assert!(receiver.next().await.is_none());
        assert_eq!(second.num_rows(), 1);
    ReceiverDropped,
    ///
            sender
            "error carries the failure reason: {err}"
                .send(Ok(test_batch(&producer_schema, &[42])))
            SendOutcome::ReceiverDropped
        let batch = first.next().await.unwrap().unwrap();
pub struct PartitionStreamSender {
        // Weak handle for early termination — hence the .lock() before poll_recv. The lock is
/// [`CHANNEL_CAPACITY`]).
    }
        let sender = Arc::new(sender);
use std::task::{Context, Poll};
                .await
/// Bounded channel capacity. Small by design — producers back-pressure when the
        let partition = SingleReceiverPartition::new(receiver);
    /// This is safe to call while [`Self::send_blocking`] holds an immutable sender
 * SPDX-License-Identifier: Apache-2.0
        }
///
                .send(Ok(test_batch(&producer_schema, &[1, 2])))
    /// closed for early termination — the sole failure mode of `mpsc::Sender::send`.
        let schema = test_schema();
        drop(receiver);
            receiver: Mutex::new(Some(receiver)),
                .unwrap();
//! contract expected by DataFusion's `StreamingTable` when a partition is
        let producer = tokio::spawn(async move {
                let recorded = self.failure.get().cloned();
                .tx
            return Poll::Ready(None);
    fn send_blocking_reports_receiver_dropped() {
    }
                // Second+ execute: hand back an already-closed empty stream so
    }
            .take();
        sender.terminate_early();
        producer.await.unwrap();
/// Both halves share the provided [`SchemaRef`]. Dropping the sender closes the
//! re-executed.
        let schema = test_schema();
    ) -> SendOutcome {
    (sender, receiver)
//! Streaming input for coordinator-reduce execution.
        f.debug_struct("PartitionStreamSender")
    /// [`SendOutcome::ReceiverDropped`] only if the receiver has been dropped or
        // released at the end of this statement, before the failure bookkeeping below.
}
    Sent,
    /// Shared with the sender (see [`PartitionStreamSender::failure`]). On channel-close, if this is
            }
    }
                }
    use arrow_array::Int64Array;
                // Clone the message out before the mutable borrow of failure_emitted below.
    /// partition surfaces as an `Err` even when the bounded data channel was full and the error
        match handle.block_on(self.tx.send(batch)) {
            receiver.lock().close();
        // Second execute() must not panic and must yield an empty stream.
//! Java can push Arrow `RecordBatch`es synchronously via
pub enum SendOutcome {
impl PartitionStream for SingleReceiverPartition {
        assert!(receiver.next().await.is_none());
    /// The provided `handle` is used to drive the async send — typically the
    /// BLOCKER #1; supersedes the round-4 best-effort in-band approach.)
        let (sender, receiver) = channel(Arc::clone(&schema));
    /// Blocks while the channel is full (natural backpressure). Returns
        let (sender, mut receiver) = channel(Arc::clone(&schema));
use datafusion::arrow::record_batch::RecordBatch;
                        self.failure_emitted = true;
        // make every close look like an error.
//!
/// (zero batches, end-of-stream immediately) rather than panicking.
    let sender = PartitionStreamSender {
            sender
    rx: Arc<ChannelMutex<mpsc::Receiver<Result<RecordBatch, DataFusionError>>>>,
                Box::pin(RecordBatchStreamAdapter::new(
    let receiver = PartitionStreamReceiver {
        assert_eq!(batch.num_rows(), 1);
    }
 */
        let schema = test_schema();
        let handle = Handle::current();
        ));
            // Terminal: we already surfaced the out-of-band error. Stream is done.
    }
    pub(crate) fn new(receiver: PartitionStreamReceiver) -> Self {
        RecordBatch::try_new(
            drop(sender);
//!
///
/// Creates a paired sender/receiver over a bounded mpsc (capacity
            blocked.join().unwrap(),
    }
    fn fmt(&self, f: &mut fmt::Formatter<'_>) -> fmt::Result {
                .await
                .unwrap();
    }
        // regardless of channel fullness; the receiver drains queued Oks in FIFO order, then yields the
use tokio::runtime::Handle;
            drop(sender);
            vec![Arc::new(Int64Array::from(values.to_vec()))],
        sender.terminate_early();
        let err = terminal.expect_err("truncated partition must surface as Err, never clean EOF");
        sender.tx.try_send(Ok(test_batch(&schema, &[2]))).unwrap();
        let outcome = std::thread::spawn(move || {
                .unwrap();
        receiver: Arc::downgrade(&shared_rx),
        // Upstream wrapped the receiver in a ChannelMutex (parking_lot) so the sender can hold a
//! subsequent `execute()` call on the same partition returns an already-closed
        let sender_schema = Arc::clone(&schema);
    // and close it for early termination without owning it.
        Arc::clone(&self.schema)
