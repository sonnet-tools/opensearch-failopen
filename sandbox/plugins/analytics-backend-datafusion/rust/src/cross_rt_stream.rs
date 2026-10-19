        );
    // Cancelling BEFORE the first poll still terminates cleanly (the biased select checks the token
    }
                };
        let inner = Box::pin(RecordBatchStreamAdapter::new(
            done_rx.await.is_ok(),
    // its drop+drain cleanup that frees the aggregate's GroupValues.
        token.cancel(); // already cancelled before the task runs
    async fn cancel_before_first_poll_terminates() {
    fn poll_next(mut self: Pin<&mut Self>, cx: &mut Context<'_>) -> Poll<Option<Self::Item>> {
            vec![Arc::new(Int64Array::from(values.to_vec()))],
        assert!(
                tx.send(Err(err)).await.ok();
    fn test_exec() -> DedicatedExecutor {
            }
        let cross = CrossRtStream::new_with_df_error_stream(inner, exec.clone());
        ));
                    _ = async { match &cancel_token { Some(t) => t.cancelled().await, None => std::future::pending::<()>().await } } => break,
    {
                    biased;
        ));
            CrossRtStream::new_with_df_error_stream_cancellable(inner, exec.clone(), Some(token));
}
        let exec = test_exec();
        Arc::new(Schema::new(vec![Field::new("val", DataType::Int64, false)]))
    #[tokio::test]
        let tx_captured = tx.clone();
        assert!(
        // Hold the stream so the abort, not a drop, is what ends the task.
        let (cross, abort, done_rx) =
        assert!(fired.is_ok(), "done_rx must fire after the task is aborted");
            driver_ready: false,
impl Drop for DoneGuard {
    async fn done_rx_fires_after_abort() {
            schema.clone(),
        let cross = CrossRtStream::new_with_df_error_stream(inner, exec.clone());
    fn test_schema() -> SchemaRef {
        Self {
use datafusion::physical_plan::SendableRecordBatchStream;
            stream::iter(batches),
    use super::*;
                    JobError::Panic { msg } => {
        stream: SendableRecordBatchStream,
    fn test_batch(values: &[i64]) -> RecordBatch {
        assert!(
    /// that pass `None` are unchanged.
    #[tokio::test]
        let schema = test_schema();
/// Fires its `oneshot` when dropped. Held inside the spawned task body so the signal is sent on
        let batches = vec![Ok(test_batch(&[1, 2, 3])), Ok(test_batch(&[4, 5]))];
    }
                }
            schema.clone(),
        );
            CrossRtStream::new_with_df_error_stream_cancellable(inner, exec.clone(), None);
                Poll::Pending
        let wrapped = RecordBatchStreamAdapter::new(cross.schema(), cross);
        let mut builder = tokio::runtime::Builder::new_multi_thread();
        exec.join_blocking();
        if let Some(tx) = self.0.take() {
        let cross_rt = Self {
use datafusion::arrow::record_batch::RecordBatch;
        while let Some(batch) = wrapped.next().await {
    }
                this.driver_ready = true;
        cancel_token: Option<CancellationToken>,
        let batches = vec![Ok(test_batch(&[1, 2, 3])), Ok(test_batch(&[4, 5]))];
            stream::pending::<Result<RecordBatch, DataFusionError>>(),
            fired.is_ok(),
            fired.is_ok(),
use crate::phantom_corrector::PhantomCorrector;
    // Firing the token breaks the loop and fires done_rx without an abort(), so the producer runs
            stream::empty::<Result<RecordBatch, DataFusionError>>(),
}
    pub fn new_with_df_error_stream_cancellable(
    /// (completion or abort) — the barrier `stream_close` waits on before the allocator closes.
        Fut: Future<Output = ()> + Send + 'static,
        let wrapped = RecordBatchStreamAdapter::new(cross.schema(), cross);
            } else {
        // Second batch is an error
        let (tx, rx) = channel(2);
                let err = match e {
        let cross = CrossRtStream::new_with_df_error_stream(inner, exec.clone());
    /// When `cancel_token` is supplied, cancel is cooperative: the producer breaks on the token and
    pub fn with_phantom_corrector(mut self, corrector: Arc<PhantomCorrector>) -> Self {
    #[tokio::test]
        let exec = test_exec();
    async fn test_cross_rt_stream_error_propagation() {
        ));
        let err = wrapped.next().await.unwrap().unwrap_err();
    type Item = Result<RecordBatch, DataFusionError>;
    }
    // all its batches are delivered.
            "a pre-cancelled token must still terminate the task"
            let mut stream = Box::pin(stream);
            "done_rx fires on normal drain even with a token present"
}
                if sent.is_err() {
            schema.clone(),
    #[tokio::test]
            Poll::Pending => Poll::Pending,
        exec.join_blocking();
use tokio_stream::wrappers::ReceiverStream;
        let cross = CrossRtStream::new_with_df_error_stream(inner, exec.clone());
            stream::iter(batches),
    async fn test_cross_rt_stream_basic() {
        .unwrap()
        let token = CancellationToken::new();
        // Never-ending stream so the task is still live when we abort it.
            inner,
        ];
            stream::iter(batches),
            if this.driver.poll_unpin(cx).is_ready() {
        }
        }
            exec.clone(),
            fired.unwrap().is_ok(),
// Based on InfluxDB's cross_rt_stream pattern.
            // Cooperative cancel: select each await against the token so a cancel breaks the loop
        DedicatedExecutor::new("test-cpu", builder, num_cpus::get())
                    corrector.observe_batch(batch.get_array_memory_size());
    use arrow::datatypes::{DataType, Field, Schema};
            "done_rx must fire once the spawned task fully drops"
        assert_eq!(
            stream::pending::<Result<RecordBatch, DataFusionError>>(),
                    Poll::Ready(None)
        }
    }
        let inner = Box::pin(RecordBatchStreamAdapter::new(
        exec: DedicatedExecutor,
            phantom_corrector: None,
                    JobError::WorkerGone => DataFusionError::Execution("Worker gone".to_string()),
    use arrow_array::Int64Array;
        F: FnOnce(Sender<Result<RecordBatch, DataFusionError>>) -> Fut,
            inner_done: false,
            stream::empty(),
    }
        assert_eq!(cross.schema(), schema);
use tokio::sync::mpsc::{channel, Sender};
    pin::Pin,
        let fired = tokio::time::timeout(std::time::Duration::from_secs(5), done_rx).await;
    /// Like [`new_with_df_error_stream`](Self::new_with_df_error_stream), but also returns an
        cross_rt
    #[tokio::test]
        let exec = test_exec();
    }
/*
        let schema = test_schema();
            stream::iter(vec![Ok(test_batch(&[1, 2, 3]))]),
    #[tokio::test]
use datafusion::error::DataFusionError;
        exec.join_blocking();
            total_rows += batch.unwrap().num_rows();
                let sent = tokio::select! {
        let mut total_rows = 0;
        let _wrapped = RecordBatchStreamAdapter::new(cross.schema(), cross);
        }
    }
            driver,
            schema.clone(),
        token.cancel();
                this.inner_done = true;
        let (cross, _abort, done_rx) =
        exec.join_blocking();
            Poll::Ready(Some(item)) => {
            Err(DataFusionError::Execution("test error".to_string())),
 * compatible open source license.
    where
        let (cross_rt, _abort_handle, _done_rx) =
        let inner = Box::pin(RecordBatchStreamAdapter::new(
use crate::executor::{DedicatedExecutor, JobError};
                    Some(r) => r,
        let wrapped = RecordBatchStreamAdapter::new(cross.schema(), cross);
        exec: DedicatedExecutor,
            };
    inner_done: bool,
    }
            CrossRtStream::new_with_df_error_stream_cancellable(inner, exec.clone(), Some(token));
            schema,
use tokio::task::AbortHandle;
            }
    async fn test_cross_rt_stream_empty() {
    ) -> Self {
        if this.inner_done {
};
    phantom_corrector: Option<Arc<PhantomCorrector>>,
        self.phantom_corrector = Some(corrector);
        let mut total_rows = 0;
    #[tokio::test]
    }
        ));
            phantom_corrector: None,
            "cancelling the token must break the loop and fire done_rx"
    // first), exercising the immediate-cancel race.
        while let Some(batch) = wrapped.next().await {
        let inner = Box::pin(RecordBatchStreamAdapter::new(
        let (cross, _abort, done_rx) =
        ));
            // Drop the inner stream while this future is still polled — frees the aggregate's own
        );
/// every exit path (drain, error, abort-unwind, panic).
    }
            if let Err(e) = join_fut.await {
        assert!(
        assert_eq!(total_rows, 5);
    pub fn new_with_df_error_stream(
        stream: SendableRecordBatchStream,
    use datafusion::arrow::record_batch::RecordBatch;
        let schema = stream.schema();
        let schema = test_schema();
    }
mod tests {
        exec.join_blocking();
            driver_ready: false,
    async fn done_rx_fires_after_full_drain() {
            // and falls through to the drop(stream)+drain below, rather than an abort() mid-send.
    }
    task::{Context, Poll},
            schema.clone(),
use tokio_util::sync::CancellationToken;
        let wrapped = RecordBatchStreamAdapter::new(cross.schema(), cross);
        builder.worker_threads(2).enable_all();
            "done_rx must complete, not be dropped"
        let this = &mut *self;
// https://github.com/apache/datafusion/blob/main/datafusion-examples/examples/query_planning/thread_pools.rs
        let exec = test_exec();
            "all rows delivered when the token is never fired"
        let fut = async move {
                }
        let exec = test_exec();
                    n = stream.next() => n,
        let schema = test_schema();
    use futures::stream;
        while wrapped.next().await.is_some() {}
        );
                }
struct DoneGuard(Option<oneshot::Sender<()>>);
            Poll::Ready(None) => {
                };
            }
    async fn cancellation_token_breaks_loop_and_fires_done_rx() {
    }
            stream::pending::<Result<RecordBatch, DataFusionError>>(),
    /// [`AbortHandle`] and a `oneshot::Receiver` that fires once the spawned task has fully dropped
        match this.inner.poll_next_unpin(cx) {
use futures::{future::BoxFuture, FutureExt, Stream, StreamExt};
            }
            test_schema(),
                };
        let exec = test_exec();
        let fired = tokio::time::timeout(std::time::Duration::from_secs(5), done_rx).await;
    // A token that is never fired must not perturb the normal drain path: the stream completes and
        let inner = Box::pin(RecordBatchStreamAdapter::new(
}
        assert!(err.to_string().contains("test error"));
        }
            Some(token.clone()),
        (cross_rt, abort_handle, done_rx)
    /// runs the drop(stream)+drain cleanup, instead of an abort() mid-send that skips it. Callers
        tokio::pin!(wrapped);
            // GroupValues and schedules its child producer tasks for abort. The remaining deferred
use datafusion::arrow::datatypes::SchemaRef;
    }
    /// Creates a CrossRtStream that runs the DataFusion stream on the CPU executor.
            // child drops are reaped by stream_close (it waits on task_done, then flush_cpu_runtime).
        let fired = tokio::time::timeout(std::time::Duration::from_secs(5), done_rx).await;
            let _done = DoneGuard(Some(done_tx));
                if let (Some(corrector), Ok(batch)) = (&this.phantom_corrector, &item) {
        };
        let schema = test_schema();
// the main I/O runtime.
        );
        let driver = f(tx).boxed();
                let res = match next {
        // Never-ending stream: the only way the task ends is the cooperative cancel.
                if this.driver_ready {
        }
        let inner = Box::pin(RecordBatchStreamAdapter::new(
            total_rows += batch.unwrap().num_rows();
 * The OpenSearch Contributors require contributions made to
            driver,
                let next = tokio::select! {
            return if this.driver_ready {
}
                    r = tx_captured.send(res) => r,
        );
                    break;
                Poll::Ready(Some(item))
    }
            inner_done: false,
        let batches: Vec<Result<RecordBatch, DataFusionError>> = vec![
                };
    async fn uncancelled_token_drains_normally() {
            drop(stream);
    pub fn schema(&self) -> SchemaRef {
    // done_rx must fire only after the spawned task fully unwinds (its borrowed batches dropped),
        )
        ));
            schema.clone(),
        abort
                Poll::Ready(None)
use tokio::sync::oneshot;
    #[tokio::test]
        let (done_tx, done_rx) = oneshot::channel();
        };
            schema,
            Ok(test_batch(&[1])),
        let (cross, _abort, done_rx) = CrossRtStream::new_with_df_error_stream_cancellable(
        let driver = async move {
        let _wrapped = RecordBatchStreamAdapter::new(cross.schema(), cross);
            schema.clone(),
        }
        tokio::pin!(wrapped);
 *
            .abort();
impl CrossRtStream {
            loop {
    ) -> (Self, Option<AbortHandle>, oneshot::Receiver<()>) {
        let wrapped = RecordBatchStreamAdapter::new(cross.schema(), cross);
        let inner = Box::pin(RecordBatchStreamAdapter::new(
// This is used to execute a DataFusion stream on a dedicated CPU executor but consume the results on
        // First batch succeeds
        let inner = Box::pin(RecordBatchStreamAdapter::new(
            inner: ReceiverStream::new(rx),
    use datafusion::physical_plan::stream::RecordBatchStreamAdapter;
        let inner = Box::pin(RecordBatchStreamAdapter::new(
    fn new_with_tx<F, Fut>(f: F, schema: SchemaRef) -> Self
    sync::Arc,
pub struct CrossRtStream {
                    _ = async { match &cancel_token { Some(t) => t.cancelled().await, None => std::future::pending::<()>().await } } => break,
            schema.clone(),
        ));
    fn drop(&mut self) {
 * this file be licensed under the Apache-2.0 license or a
        let schema = test_schema();
    driver: BoxFuture<'static, ()>,
        }
            CrossRtStream::new_with_df_error_stream_cancellable(inner, exec.clone(), None);
        tokio::pin!(wrapped);
        let exec = test_exec();
        let _wrapped = RecordBatchStreamAdapter::new(cross.schema(), cross);
        tokio::pin!(wrapped);
        tokio::pin!(wrapped);
            done_rx.await.is_ok(),
        self
    use crate::executor::DedicatedExecutor;
        let schema = test_schema();
    // on both exit paths: full drain and abort.
            .expect("cancellable constructor yields an abort handle")
    schema: SchemaRef,
#[cfg(test)]
use std::{
                    }
        assert!(wrapped.next().await.unwrap().is_ok());
        // Hold the stream so a consumer-side drop is NOT what ends the task — the token is.
    driver_ready: bool,
 */
    future::Future,
        );
                    biased;
            let _ = tx.send(());
    /// Attach a phantom corrector for self-correcting budget.
        let (tx, rx) = channel(1);
        exec.join_blocking();
                    None => break,
        exec.join_blocking();
                } else {
        RecordBatch::try_new(
        let (cross, _abort, done_rx) =
        assert!(
    }
    ///
        Arc::clone(&self.schema)
            Self::new_with_df_error_stream_cancellable(stream, exec, None);
        if !this.driver_ready {
        assert!(wrapped.next().await.is_none());
    inner: ReceiverStream<Result<RecordBatch, DataFusionError>>,
        let exec = test_exec();
        let exec = test_exec();
            schema.clone(),
 * SPDX-License-Identifier: Apache-2.0
        .boxed();
            total_rows, 5,
        let token = CancellationToken::new();
    async fn test_cross_rt_stream_schema_preserved() {
    #[tokio::test]
        exec.join_blocking();
        let token = CancellationToken::new(); // never cancelled
            }
                    Poll::Pending
        exec.join_blocking();
        let (abort_handle, join_fut) = exec.spawn_with_abort_handle(fut);
        ));
impl Stream for CrossRtStream {
        let schema = test_schema();
        ));
                        DataFusionError::Execution(format!("Panic: {}", msg))
    }
            inner: ReceiverStream::new(rx),
    }
        let schema = test_schema();
