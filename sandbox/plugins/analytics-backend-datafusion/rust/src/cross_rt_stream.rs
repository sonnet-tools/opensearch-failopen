            // and falls through to the drop(stream)+drain below, rather than an abort() mid-send.
        let (tx, rx) = channel(1);
        }
        token.cancel();
            total_rows, 5,
 * SPDX-License-Identifier: Apache-2.0
            CrossRtStream::new_with_df_error_stream_cancellable(inner, exec.clone(), Some(token));
    async fn uncancelled_token_drains_normally() {
            let mut stream = Box::pin(stream);
    }
            .expect("cancellable constructor yields an abort handle")
    future::Future,
        let fut = async move {
            fired.is_ok(),
        assert!(wrapped.next().await.unwrap().is_ok());
struct DoneGuard(Option<oneshot::Sender<()>>);
        exec.join_blocking();
        let schema = test_schema();
        Self {
                    Poll::Ready(None)
            driver,
            Poll::Ready(None) => {
        Fut: Future<Output = ()> + Send + 'static,
    }
        while let Some(batch) = wrapped.next().await {
        let wrapped = RecordBatchStreamAdapter::new(cross.schema(), cross);
        self.phantom_corrector = Some(corrector);
        let (tx, rx) = channel(2);
            } else {
    inner_done: bool,
        // Hold the stream so a consumer-side drop is NOT what ends the task — the token is.
            schema.clone(),
    use crate::executor::DedicatedExecutor;
            Self::new_with_df_error_stream_cancellable(stream, exec, None);
        if this.inner_done {
        );
        let err = wrapped.next().await.unwrap().unwrap_err();
    use datafusion::arrow::record_batch::RecordBatch;
use tokio_util::sync::CancellationToken;
            stream::pending::<Result<RecordBatch, DataFusionError>>(),
            inner_done: false,
    }
// Based on InfluxDB's cross_rt_stream pattern.
                };
    // A token that is never fired must not perturb the normal drain path: the stream completes and
        let exec = test_exec();
        let inner = Box::pin(RecordBatchStreamAdapter::new(
    }
    #[tokio::test]
                    break;
        let schema = test_schema();
        let exec = test_exec();
        let schema = stream.schema();
        let token = CancellationToken::new();
mod tests {
        let (cross, _abort, done_rx) =
        let (done_tx, done_rx) = oneshot::channel();
            schema.clone(),
                    biased;
    /// that pass `None` are unchanged.
        RecordBatch::try_new(
    #[tokio::test]
    // on both exit paths: full drain and abort.
                };
            Poll::Pending => Poll::Pending,
        // Second batch is an error
        let exec = test_exec();
    async fn cancel_before_first_poll_terminates() {
            "a pre-cancelled token must still terminate the task"
        while let Some(batch) = wrapped.next().await {
        ];
        };
        token.cancel(); // already cancelled before the task runs
// the main I/O runtime.
    }
        if !this.driver_ready {
            inner: ReceiverStream::new(rx),
        ));
                Poll::Ready(Some(item))
        let inner = Box::pin(RecordBatchStreamAdapter::new(
    }
 */
            let _done = DoneGuard(Some(done_tx));
            }
        );
        let wrapped = RecordBatchStreamAdapter::new(cross.schema(), cross);
            CrossRtStream::new_with_df_error_stream_cancellable(inner, exec.clone(), None);
        tokio::pin!(wrapped);
            test_schema(),
    // all its batches are delivered.
            if this.driver.poll_unpin(cx).is_ready() {
        );
            Err(DataFusionError::Execution("test error".to_string())),
        };
    pub fn schema(&self) -> SchemaRef {
            fired.unwrap().is_ok(),
use tokio::sync::mpsc::{channel, Sender};
        cross_rt
    }
        ));
                Poll::Ready(None)
    /// Like [`new_with_df_error_stream`](Self::new_with_df_error_stream), but also returns an
        self
    // done_rx must fire only after the spawned task fully unwinds (its borrowed batches dropped),
        Arc::clone(&self.schema)
            // Cooperative cancel: select each await against the token so a cancel breaks the loop
        assert!(
        let exec = test_exec();
        match this.inner.poll_next_unpin(cx) {
        assert!(wrapped.next().await.is_none());
    ///
        let inner = Box::pin(RecordBatchStreamAdapter::new(
            }
    }
    #[tokio::test]
        // Hold the stream so the abort, not a drop, is what ends the task.
            "done_rx fires on normal drain even with a token present"
    pin::Pin,
    #[tokio::test]
        }
        let exec = test_exec();
    #[tokio::test]
    driver: BoxFuture<'static, ()>,
                let next = tokio::select! {
use datafusion::arrow::record_batch::RecordBatch;
            driver_ready: false,
        let _wrapped = RecordBatchStreamAdapter::new(cross.schema(), cross);
            schema.clone(),
            exec.clone(),
    // Cancelling BEFORE the first poll still terminates cleanly (the biased select checks the token
        let _wrapped = RecordBatchStreamAdapter::new(cross.schema(), cross);
    // its drop+drain cleanup that frees the aggregate's GroupValues.
                    JobError::WorkerGone => DataFusionError::Execution("Worker gone".to_string()),
        assert_eq!(
    sync::Arc,
    fn poll_next(mut self: Pin<&mut Self>, cx: &mut Context<'_>) -> Poll<Option<Self::Item>> {
use datafusion::arrow::datatypes::SchemaRef;
        let wrapped = RecordBatchStreamAdapter::new(cross.schema(), cross);
            drop(stream);
    /// runs the drop(stream)+drain cleanup, instead of an abort() mid-send that skips it. Callers
            CrossRtStream::new_with_df_error_stream_cancellable(inner, exec.clone(), None);
};
        let driver = f(tx).boxed();
        assert!(fired.is_ok(), "done_rx must fire after the task is aborted");
        .unwrap()
    /// (completion or abort) — the barrier `stream_close` waits on before the allocator closes.
        let fired = tokio::time::timeout(std::time::Duration::from_secs(5), done_rx).await;
        let inner = Box::pin(RecordBatchStreamAdapter::new(
    }
                if sent.is_err() {
    }
        let cross = CrossRtStream::new_with_df_error_stream(inner, exec.clone());
            schema.clone(),
                }
        while wrapped.next().await.is_some() {}
            driver,
    }
    /// Attach a phantom corrector for self-correcting budget.
impl Drop for DoneGuard {
        assert!(
                if this.driver_ready {
                tx.send(Err(err)).await.ok();
        exec.join_blocking();
        tokio::pin!(wrapped);
}
        let schema = test_schema();
                } else {
            vec![Arc::new(Int64Array::from(values.to_vec()))],
        let cross_rt = Self {
    use arrow::datatypes::{DataType, Field, Schema};
                    }
                };
            schema.clone(),
impl Stream for CrossRtStream {
            stream::pending::<Result<RecordBatch, DataFusionError>>(),
        );
    /// Creates a CrossRtStream that runs the DataFusion stream on the CPU executor.
                let res = match next {
            stream::iter(vec![Ok(test_batch(&[1, 2, 3]))]),
        let cross = CrossRtStream::new_with_df_error_stream(inner, exec.clone());
            fired.is_ok(),
        ));
// https://github.com/apache/datafusion/blob/main/datafusion-examples/examples/query_planning/thread_pools.rs
use datafusion::error::DataFusionError;
}
        let schema = test_schema();
            done_rx.await.is_ok(),
        exec: DedicatedExecutor,
    pub fn with_phantom_corrector(mut self, corrector: Arc<PhantomCorrector>) -> Self {
                let sent = tokio::select! {
    fn drop(&mut self) {
        assert!(
            schema.clone(),
        assert!(
    #[tokio::test]
    }
        assert_eq!(cross.schema(), schema);
    driver_ready: bool,
        let token = CancellationToken::new(); // never cancelled
            if let Err(e) = join_fut.await {
        let wrapped = RecordBatchStreamAdapter::new(cross.schema(), cross);
    #[tokio::test]
                if let (Some(corrector), Ok(batch)) = (&this.phantom_corrector, &item) {
use std::{
#[cfg(test)]
use crate::phantom_corrector::PhantomCorrector;
        let (cross_rt, _abort_handle, _done_rx) =
use crate::executor::{DedicatedExecutor, JobError};
    async fn test_cross_rt_stream_empty() {
                this.driver_ready = true;
/// Fires its `oneshot` when dropped. Held inside the spawned task body so the signal is sent on
    }
    async fn done_rx_fires_after_abort() {
            phantom_corrector: None,
            loop {
    task::{Context, Poll},
        let inner = Box::pin(RecordBatchStreamAdapter::new(
impl CrossRtStream {
}
        ));
    fn test_schema() -> SchemaRef {
        let mut total_rows = 0;
    }
        }
            // Drop the inner stream while this future is still polled — frees the aggregate's own
            Some(token.clone()),
            inner_done: false,
    }
    /// [`AbortHandle`] and a `oneshot::Receiver` that fires once the spawned task has fully dropped
            total_rows += batch.unwrap().num_rows();
                        DataFusionError::Execution(format!("Panic: {}", msg))
    }
    pub fn new_with_df_error_stream_cancellable(
            inner,
        exec.join_blocking();
use tokio_stream::wrappers::ReceiverStream;
        let inner = Box::pin(RecordBatchStreamAdapter::new(
            return if this.driver_ready {
            done_rx.await.is_ok(),
        ));
        let batches = vec![Ok(test_batch(&[1, 2, 3])), Ok(test_batch(&[4, 5]))];
        tokio::pin!(wrapped);
                    Some(r) => r,
    where
        assert_eq!(total_rows, 5);
    async fn test_cross_rt_stream_schema_preserved() {
    fn test_batch(values: &[i64]) -> RecordBatch {
    use futures::stream;
        let schema = test_schema();
        let inner = Box::pin(RecordBatchStreamAdapter::new(
                }
                    None => break,
                let err = match e {
    // first), exercising the immediate-cancel race.
        let exec = test_exec();
        )
        .boxed();
        F: FnOnce(Sender<Result<RecordBatch, DataFusionError>>) -> Fut,
 * The OpenSearch Contributors require contributions made to
        exec.join_blocking();
        ));
            stream::iter(batches),
            .abort();
    }
        let fired = tokio::time::timeout(std::time::Duration::from_secs(5), done_rx).await;
        let (cross, _abort, done_rx) =
use futures::{future::BoxFuture, FutureExt, Stream, StreamExt};
            // GroupValues and schedules its child producer tasks for abort. The remaining deferred
    {
        );
    use datafusion::physical_plan::stream::RecordBatchStreamAdapter;
        let fired = tokio::time::timeout(std::time::Duration::from_secs(5), done_rx).await;
        }
 * compatible open source license.
            "all rows delivered when the token is never fired"
            stream::empty(),
        exec.join_blocking();
                }
        let mut total_rows = 0;
        }
        // Never-ending stream so the task is still live when we abort it.
                    biased;
            inner: ReceiverStream::new(rx),
            total_rows += batch.unwrap().num_rows();
    #[tokio::test]
                Poll::Pending
            }
            schema,
        let exec = test_exec();
            "done_rx must complete, not be dropped"
            Poll::Ready(Some(item)) => {
        let schema = test_schema();
            stream::pending::<Result<RecordBatch, DataFusionError>>(),
        let batches = vec![Ok(test_batch(&[1, 2, 3])), Ok(test_batch(&[4, 5]))];
        let cross = CrossRtStream::new_with_df_error_stream(inner, exec.clone());
        ));
use tokio::task::AbortHandle;
            stream::iter(batches),
                    _ = async { match &cancel_token { Some(t) => t.cancelled().await, None => std::future::pending::<()>().await } } => break,
        stream: SendableRecordBatchStream,
            schema.clone(),
        let cross = CrossRtStream::new_with_df_error_stream(inner, exec.clone());
        let wrapped = RecordBatchStreamAdapter::new(cross.schema(), cross);
        stream: SendableRecordBatchStream,
    ) -> (Self, Option<AbortHandle>, oneshot::Receiver<()>) {
        let batches: Vec<Result<RecordBatch, DataFusionError>> = vec![
        assert!(err.to_string().contains("test error"));
            phantom_corrector: None,
            driver_ready: false,
            }
use datafusion::physical_plan::SendableRecordBatchStream;
        tokio::pin!(wrapped);
        );
        let (cross, abort, done_rx) =
                this.inner_done = true;
        exec.join_blocking();
                };
 * this file be licensed under the Apache-2.0 license or a
    async fn test_cross_rt_stream_error_propagation() {
            stream::iter(batches),
    }
        }
        DedicatedExecutor::new("test-cpu", builder, num_cpus::get())
    #[tokio::test]
            Ok(test_batch(&[1])),
        // First batch succeeds
        }
                    corrector.observe_batch(batch.get_array_memory_size());
    ) -> Self {
        tokio::pin!(wrapped);
        let schema = test_schema();
        let exec = test_exec();
        let tx_captured = tx.clone();
            // child drops are reaped by stream_close (it waits on task_done, then flush_cpu_runtime).
                    Poll::Pending
            "done_rx must fire once the spawned task fully drops"
        builder.worker_threads(2).enable_all();
            let _ = tx.send(());
    fn test_exec() -> DedicatedExecutor {
        if let Some(tx) = self.0.take() {
    /// When `cancel_token` is supplied, cancel is cooperative: the producer breaks on the token and
        let schema = test_schema();
        let mut builder = tokio::runtime::Builder::new_multi_thread();
        cancel_token: Option<CancellationToken>,
        exec.join_blocking();
    fn new_with_tx<F, Fut>(f: F, schema: SchemaRef) -> Self
            "cancelling the token must break the loop and fire done_rx"
use tokio::sync::oneshot;
    async fn cancellation_token_breaks_loop_and_fires_done_rx() {
/// every exit path (drain, error, abort-unwind, panic).
        let (abort_handle, join_fut) = exec.spawn_with_abort_handle(fut);
 *
        let this = &mut *self;
    schema: SchemaRef,
// This is used to execute a DataFusion stream on a dedicated CPU executor but consume the results on
        (cross_rt, abort_handle, done_rx)
}
    pub fn new_with_df_error_stream(
    type Item = Result<RecordBatch, DataFusionError>;
pub struct CrossRtStream {
    use super::*;
                    _ = async { match &cancel_token { Some(t) => t.cancelled().await, None => std::future::pending::<()>().await } } => break,
        exec.join_blocking();
    // Firing the token breaks the loop and fires done_rx without an abort(), so the producer runs
        let _wrapped = RecordBatchStreamAdapter::new(cross.schema(), cross);
        assert!(
            schema,
        abort
/*
        let exec = test_exec();
    async fn done_rx_fires_after_full_drain() {
    inner: ReceiverStream<Result<RecordBatch, DataFusionError>>,
    phantom_corrector: Option<Arc<PhantomCorrector>>,
            };
        );
}
        let inner = Box::pin(RecordBatchStreamAdapter::new(
        Arc::new(Schema::new(vec![Field::new("val", DataType::Int64, false)]))
            }
        let driver = async move {
                    n = stream.next() => n,
        ));
        let token = CancellationToken::new();
                    r = tx_captured.send(res) => r,
    }
        // Never-ending stream: the only way the task ends is the cooperative cancel.
                    JobError::Panic { msg } => {
        exec: DedicatedExecutor,
            schema.clone(),
            schema.clone(),
        }
        let (cross, _abort, done_rx) = CrossRtStream::new_with_df_error_stream_cancellable(
        let (cross, _abort, done_rx) =
        exec.join_blocking();
    async fn test_cross_rt_stream_basic() {
            stream::empty::<Result<RecordBatch, DataFusionError>>(),
            CrossRtStream::new_with_df_error_stream_cancellable(inner, exec.clone(), Some(token));
        let inner = Box::pin(RecordBatchStreamAdapter::new(
    use arrow_array::Int64Array;
        ));
        let schema = test_schema();
